package co.hcmus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import co.hcmus.models.Promotion;
import co.hcmus.services.IPromotionService;
import co.hcmus.util.Tools;

@Controller
public class PromotionController {

	@Autowired
	private IPromotionService promotionService;

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
