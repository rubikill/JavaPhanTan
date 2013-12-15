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
import co.hcmus.models.PromotionDetail;
import co.hcmus.services.IPromotionDetailService;
import co.hcmus.util.Tools;

@Controller
public class PromotionDetailController {

	@Autowired
	private IPromotionDetailService promotionDetailService;

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
			PromotionDetail promotionDetail = (PromotionDetail)Tools.fromJsonTo(json, PromotionDetail.class);
			promotionDetailService.addPromotionDetail(promotionDetail);
			return new ResponseEntity<String>(headers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}

	}
}
