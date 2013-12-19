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
import co.hcmus.models.PromotionDetail;
import co.hcmus.services.IPromotionDetailService;
import co.hcmus.services.IPromotionService;
import co.hcmus.util.STATUS;
import co.hcmus.util.Tools;

@Controller
public class PromotionDetailController {

	@Autowired
	private IPromotionDetailService promotionDetailService;

	@Autowired
	private IPromotionService promotionService;

	/**
	 * ADMIN PAGE - Show all product of a Promotion by Promotion's ID
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/promotions/{id}", method = RequestMethod.GET)
	public String showPromotionDetail(Locale locale, Model model,
			HttpServletRequest request, @PathVariable String id) {
		PromotionDetail promotionDetail = new PromotionDetail();
		System.out.println("id detail: " + promotionDetail.getId());
		Promotion promotion = promotionService.getPromotionById(id);
		List<PromotionDetail> listPromotionDetail = promotionDetailService
				.getPromotionDetailsByPromotionIdWithoutStatus(id);
		System.out.println("Size:"  + listPromotionDetail.size());
		request.setAttribute("promotion", promotion);
		request.setAttribute("promotionDetail", promotionDetail);
		request.setAttribute("listPromotionDetails", listPromotionDetail);
		return "promotiondetail";
	}

	/**
	 * ADMIN PAGE - Add new Promotion detail
	 * @param locale
	 * @param model
	 * @param request
	 * @param promotionDetail	
	 * @param id	//Promotion's id
	 * @return
	 */
	@RequestMapping(value = "/admin/promotions/{id}/add", method = RequestMethod.POST)
	public String addPromotionDetail(Locale locale, Model model,
			HttpServletRequest request, PromotionDetail promotionDetail,
			@PathVariable String id) {
		
		promotionDetail.setPromotionId(id);
		promotionDetail.setId(null);
		
		System.out.println("promotion id:"  +promotionDetail.getId());
		System.out.println("promotion Product id:"  +promotionDetail.getProductId());
		System.out.println("promotion Promotion id:"  +promotionDetail.getPromotionId());
		System.out.println("promotion Status:"  +promotionDetail.getStatus());
		System.out.println("promotion discount:"  +promotionDetail.getDiscount());

		
		promotionDetailService.addPromotionDetail(promotionDetail);
		
		Promotion promotion = promotionService.getPromotionById(id);
		List<PromotionDetail> listPromotionDetail = promotionDetailService
				.getPromotionDetailsByPromotionIdWithoutStatus(id);

		request.setAttribute("promotionDetail", promotionDetail);
		request.setAttribute("promotion", promotion);
		request.setAttribute("listPromotionDetails", listPromotionDetail);
		return "redirect:/admin/promotions/" +id;
	}

	/**
	 * ADMIN PAGE - Block a product from promotion
	 * @param locale
	 * @param model
	 * @param request
	 * @param promotionDetail
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/promotions/{id}/block", method = RequestMethod.POST)
	public String blockPromotionDetail(Locale locale, Model model,
			HttpServletRequest request, PromotionDetail promotionDetail,
			@PathVariable String id) {
		promotionDetail.setPromotionId(id);
		promotionDetail.setStatus(STATUS.INACTIVE.getStatusCode());
		promotionDetailService.updatePromotionDetail(promotionDetail);
		
		Promotion promotion = promotionService.getPromotionById(id);
		List<PromotionDetail> listPromotionDetail = promotionDetailService
				.getPromotionDetailsByPromotionIdWithoutStatus(id);

		request.setAttribute("promotionDetail", promotionDetail);
		request.setAttribute("promotion", promotion);
		request.setAttribute("listPromotionDetails", listPromotionDetail);
		return "promotiondetail";
	}
	
	/**
	 * ADMIN PAGE - Active a product from promotion
	 * @param locale
	 * @param model
	 * @param request
	 * @param promotionDetail
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/promotions/{id}/active", method = RequestMethod.POST)
	public String activePromotionDetail(Locale locale, Model model,
			HttpServletRequest request, PromotionDetail promotionDetail,
			@PathVariable String id) {
		promotionDetail.setPromotionId(id);
		promotionDetail.setStatus(STATUS.ACTIVE.getStatusCode());
		promotionDetailService.updatePromotionDetail(promotionDetail);
		
		Promotion promotion = promotionService.getPromotionById(id);
		List<PromotionDetail> listPromotionDetail = promotionDetailService
				.getPromotionDetailsByPromotionIdWithoutStatus(id);

		request.setAttribute("promotionDetail", promotionDetail);
		request.setAttribute("promotion", promotion);
		request.setAttribute("listPromotionDetails", listPromotionDetail);
		return "promotiondetail";
	}

	/**
	 * ADMIN PAGE - Edit a promotion detail
	 * @param locale
	 * @param model
	 * @param request
	 * @param promotionDetail
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/promotions/{id}/edit", method = RequestMethod.POST)
	public String editPromotionDetail(Locale locale, Model model,
			HttpServletRequest request, PromotionDetail promotionDetail,
			@PathVariable String id) {
		promotionDetail.setPromotionId(id);
		promotionDetailService.updatePromotionDetail(promotionDetail);
		
		Promotion promotion = promotionService.getPromotionById(id);
		List<PromotionDetail> listPromotionDetail = promotionDetailService
				.getPromotionDetailsByPromotionIdWithoutStatus(id);
		System.out.println("Size:"  + listPromotionDetail.size());

		request.setAttribute("promotionDetail", promotionDetail);
		request.setAttribute("promotion", promotion);
		request.setAttribute("listPromotionDetails", listPromotionDetail);
		request.setAttribute("nav", "promotions");
		return "promotiondetail";
	}
	
	/**
	 * rest to get all PromotionDetails
	 * 
	 * @return
	 */
	@RequestMapping(value = "/promotiondetail", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getPromotionDetails() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		// get all product
		try {
			List<PromotionDetail> listPromotionDetail = promotionDetailService
					.getPromotionDetails();
			return new ResponseEntity<String>(
					Tools.toJsonArray(listPromotionDetail), headers,
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/promotiondetail/create", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> createPromotionDetail(@RequestBody String json) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		// get all product
		try {
			PromotionDetail promotionDetail = (PromotionDetail) Tools
					.fromJsonTo(json, PromotionDetail.class);
			promotionDetailService.addPromotionDetail(promotionDetail);
			return new ResponseEntity<String>(headers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}

	}
}
