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
	 * Controller for Admin page - MANAGE PROMOTION
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

	@RequestMapping(value = "/admin/promotions/add", method = RequestMethod.POST)
	public String addPromotion(Locale locale, Model model,
			HttpServletRequest request, Promotion promotion) {

		promotionService.addPromotion(promotion);
		prepairData(request);
		return "promotion";
	}

	@RequestMapping(value = "/admin/promotions/block/{id}", method = RequestMethod.POST)
	public String blockPromotion(Locale locale, Model model,
			HttpServletRequest request, @PathVariable String id) {
		Promotion promotion = promotionService.getPromotionById(id);
		promotion.setStatus(STATUS.BLOCK.getStatusCode());
		prepairData(request);
		return "promotion";
	}

	@RequestMapping(value = "/admin/promotions/edit", method = RequestMethod.POST)
	public String editPromotion(Locale locale, Model model,
			HttpServletRequest request, Promotion promotion) {
		System.out.println("ID:" + promotion.getId());
		System.out.println("Name:" + promotion.getName());
		System.out.println("Note:" + promotion.getNote());
		System.out.println("Status:" + promotion.getStatus());
		System.out.println("TagID:" + promotion.getTagId());
		System.out.println("Date start:" + promotion.getDate_end().toString());
		System.out.println("Date end:" + promotion.getDate_start().toString());

		promotionService.updatePromotion(promotion);
		prepairData(request);
		return "promotion";
	}

	private void prepairData(HttpServletRequest request) {
		Promotion promotion = new Promotion();
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
