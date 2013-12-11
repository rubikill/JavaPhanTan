package co.hcmus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.models.Rating;
import co.hcmus.services.IRatingService;

@Controller
public class RatingController {

	@Autowired
	private IRatingService ratingService;

	/**
	 * web service to check email is rating with productId
	 * 
	 * @param productId
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "rating/{productId}/{email}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> checkRatingByProductIdByEmail(
			@PathVariable("productId") String productId,
			@PathVariable("email") String email) {
		// get product byID
		Rating result = ratingService.checkRaingByProductIdByEmail(productId,
				email);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		if (result == null) {
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		}
		String json = "{ sum : " + result.getStar() + "," + "israting : true}";
		return new ResponseEntity<String>(json, headers, HttpStatus.OK);
	}
}
