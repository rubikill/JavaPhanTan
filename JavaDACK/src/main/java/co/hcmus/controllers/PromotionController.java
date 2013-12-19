package co.hcmus.controllers;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import co.hcmus.models.Promotion;
import co.hcmus.services.IPromotionService;
import co.hcmus.util.STATUS;
import co.hcmus.util.Tools;

@Controller
public class PromotionController {

	@Autowired
	private IPromotionService promotionService;

	/**
	 * ADMIN PAGE - Manage promotion (load)
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/promotions", method = RequestMethod.GET)
	public String getPromotions(Locale locale, Model model,
			HttpServletRequest request) {
		prepairData(request);
		return "promotion";
	}

	/**
	 * ADMIN PAGE - ADD new Promotion
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param promotion
	 * @return
	 */
	@RequestMapping(value = "/admin/promotions/add", method = RequestMethod.POST)
	public String addPromotion(Locale locale, Model model,
			HttpServletRequest request, Promotion promotion) {
		promotionService.addPromotion(promotion);
		return "redirect:/admin/promotions";
	}

	/**
	 * ADMIN PAGE - Block a promotion
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/promotions/block/{id}", method = RequestMethod.GET)
	public String blockPromotion(Locale locale, Model model,
			HttpServletRequest request, @PathVariable String id) {
		Promotion promotion = promotionService.getPromotionById(id);
		promotion.setStatus(STATUS.INACTIVE.getStatusCode());
		promotionService.updatePromotion(promotion);
		return "redirect:/admin/promotions";
	}

	/**
	 * ADMIN PAGE - Active a promotion
	 * @param locale
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/promotions/active/{id}", method = RequestMethod.GET)
	public String activePromotion(Locale locale, Model model,
			HttpServletRequest request, @PathVariable String id) {
		Promotion promotion = promotionService.getPromotionById(id);
		promotion.setStatus(STATUS.ACTIVE.getStatusCode());
		promotionService.updatePromotion(promotion);
		return "redirect:/admin/promotions";
	}

	
	/**
	 * ADMIN PAGE - Edit a promotion
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param promotion
	 * @return
	 */
	@RequestMapping(value = "/admin/promotions/edit", method = RequestMethod.POST)
	public String editPromotion(Locale locale, Model model,
			HttpServletRequest request, Promotion promotion) {
		promotionService.updatePromotion(promotion);
		return "redirect:/admin/promotions";
	}

	/**
	 * ADMIN PAGE - Prepair data for loading UI
	 * 
	 * @param request
	 */
	private void prepairData(HttpServletRequest request) {
		Promotion promotion = new Promotion();
		System.out.println("id: " + promotion.getId());
		List<Promotion> listPromotions = promotionService.getPromotions();
		request.setAttribute("listPromotions", listPromotions);
		request.setAttribute("promotion", promotion);
		request.setAttribute("nav", "promotions");
	}

	/**
	 * webservice to get Promotions
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
			return new ResponseEntity<String>(Tools.toJsonArray(listPromotion),
					headers, HttpStatus.OK);
		} catch (Exception e) {
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
			return new ResponseEntity<String>(headers, HttpStatus.OK);
		} catch (Exception e) {
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
			return new ResponseEntity<String>(headers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}
	}
}
