package co.hcmus.shopcamera.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.shopcamera.data.model.Promotion;
import co.hcmus.shopcamera.data.model.PromotionDetail;
import co.hcmus.shopcamera.manager.IPromotionDetailService;
import co.hcmus.shopcamera.manager.IPromotionService;
import co.hcmus.shopcamera.utility.STATUS;
import co.hcmus.shopcamera.utility.Tools;

@Controller
public class PromotionController {
	private static final Logger logger = LoggerFactory
			.getLogger(PromotionController.class);
	@Autowired
	private IPromotionService promotionService;
	@Autowired
	private IPromotionDetailService promotionDetailService;

	/**
	 * ADMIN PAGE - Manage promotion (load)
	 * 
	 * @param request
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/promotions", method = RequestMethod.GET)
	public String getPromotions(HttpServletRequest request) {
		prepairData(request);
		logger.info("Admin get all promotions");
		return "promotion";
	}

	/**
	 * ADMIN PAGE - ADD new Promotion
	 * 
	 * @param promotion
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/promotions/add", method = RequestMethod.POST)
	public String addPromotion(Promotion promotion) {
		System.out.println("\n \n \n startDate:"
				+ promotion.getDate_start().toString());
		System.out.println("endDate:" + promotion.getDate_end().toString()
				+ "\n \n \n ");

		promotionService.addPromotion(promotion);
		logger.info("Admin create a promotion");
		return "redirect:/admin/promotions";
	}

	/**
	 * ADMIN PAGE - Deactive a promotion
	 * 
	 * @param id
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/promotions/block/{id}", method = RequestMethod.GET)
	public String blockPromotion(@PathVariable String id) {
		Promotion promotion = promotionService.getPromotionById(id);
		promotion.setStatus(STATUS.INACTIVE.getStatusCode());
		promotionService.updatePromotion(promotion);
		logger.info("Admin inactive Promotion with Id : " + id);
		return "redirect:/admin/promotions";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	/**
	 * ADMIN PAGE - Active a promotion
	 * 
	 * @param id
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/promotions/active/{id}", method = RequestMethod.GET)
	public String activePromotion(@PathVariable String id) {
		Promotion promotion = promotionService.getPromotionById(id);
		promotion.setStatus(STATUS.ACTIVE.getStatusCode());
		promotionService.updatePromotion(promotion);
		logger.info("Admin active Promotion with Id : " + id);
		return "redirect:/admin/promotions";
	}

	/**
	 * ADMIN PAGE - Edit a promotion
	 * 
	 * @param promotion
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/promotions/edit", method = RequestMethod.POST)
	public String editPromotion(Promotion promotion) {
		promotionService.updatePromotion(promotion);
		System.out.println("\n \n \n startDate:"
				+ promotion.getDate_start().toString());
		System.out.println("endDate:" + promotion.getDate_end().toString()
				+ "\n \n \n ");

		logger.info("Admin edit Promotion with Id : " + promotion.getId());
		return "redirect:/admin/promotions";
	}

	/**
	 * ADMIN PAGE - Prepair data for loading UI
	 * 
	 * @param request
	 */
	@Secured("ROLE_ADMIN")
	private void prepairData(HttpServletRequest request) {
		Promotion promotion = new Promotion();
		System.out.println("id: " + promotion.getId());
		List<Promotion> listPromotions = promotionService.getPromotions();
		request.setAttribute("listPromotions", listPromotions);
		request.setAttribute("promotion", promotion);
		request.setAttribute("nav", "promotions");
	}

	/**
	 * Web service to get Promotions
	 * 
	 * @return
	 */
	@RequestMapping(value = "/promotion", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getPromotions() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		// get all product
		try {
			List<Promotion> listPromotion = promotionService.getPromotions();

			HashMap<String, PromotionDetail> dict = new HashMap<String, PromotionDetail>();
			for (int i = 0; i < listPromotion.size(); i++) {
				Promotion pr = listPromotion.get(i);
				if (pr.getDate_start().compareTo(new Date()) < 0
						&& (pr.getDate_end().compareTo(new Date()) > 0)) {
					List<PromotionDetail> lpd = promotionDetailService
							.getPromotionDetailsByPromotionId(pr.getId(),
									STATUS.ACTIVE.getStatusCode());
					for (int j = 0; j < lpd.size(); j++) {
						PromotionDetail pd = lpd.get(j);
						if (!dict.containsKey(pd.getProductId())) {
							dict.put(pd.getProductId(), pd);
						} else {
							if (pd.getDiscount() > dict.get(pd.getProductId())
									.getDiscount()) {
								dict.put(pd.getProductId(), pd);
							}
						}
					}
				}
			}

			List<PromotionDetail> listPromotionDetail = new ArrayList<PromotionDetail>(
					dict.values());
			logger.info("Rest get all promotions");
			return new ResponseEntity<String>(
					Tools.toJsonArray(listPromotionDetail), headers,
					HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error get all promotions" + e.toString());
			return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * rest to create promotion
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/promotion/create", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> createPromotion(@RequestBody String json) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		try {
			Promotion promotion = (Promotion) Tools.fromJsonTo(json,
					Promotion.class);
			promotionService.addPromotion(promotion);
			logger.info("Rest create a promotion with name : "
					+ promotion.getName());
			return new ResponseEntity<String>(headers, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error create a promotion");
			return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * rest to update a promotion
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/promotion/update", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<String> updatePromotion(@RequestBody String json) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		try {
			Promotion promotion = (Promotion) Tools.fromJsonTo(json,
					Promotion.class);
			promotionService.updatePromotion(promotion);
			logger.info("Rest update a promotion with Id : "
					+ promotion.getId());
			return new ResponseEntity<String>(headers, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error update a promotion");
			return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}
	}
}
