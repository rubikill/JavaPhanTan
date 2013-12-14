package co.hcmus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.models.Rating;
import co.hcmus.models.ProductRate;
import co.hcmus.services.IRatingService;
import co.hcmus.util.STATUS;
import co.hcmus.util.Tools;

@Controller
public class RatingController {

	@Autowired
	private IRatingService ratingService;

	/**
	 * web service to check email is rating with productId and json to get email
	 * 
	 * @param productId
	 * @return
	 */
	@RequestMapping(value = "rating/{productId}", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> checkRatingByProductIdByEmail(
		@PathVariable("productId") String productId,
		@RequestBody String json) {

		// catch rating from json to get email
		Rating ratingTempFromJson = (Rating) Tools.fromJsonTo(json,
			Rating.class);

		// get email
		String email = ratingTempFromJson.getEmail();

		//System.out.println("-------:" + email);
		// get product byID
		double  resultAverage = ratingService.checkRaingByProductIdByEmail(productId,
			email, STATUS.ACTIVE.getStatusCode());
		// create header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");

		if (resultAverage ==  -1) {
			ProductRate productRate = new ProductRate();
			productRate.rateAverage = resultAverage;
			productRate.isRate = false;
			productRate.rateEmail = null;

			return new ResponseEntity<String>(Tools.toJson(productRate) , headers,
				HttpStatus.BAD_REQUEST);
		} else {
			// get rating by email
			Rating ratingByEmail = ratingService.getRatingByEmail(email,
				STATUS.ACTIVE.getStatusCode());

			ProductRate productRate = new ProductRate();
			productRate.rateAverage = resultAverage;
			productRate.isRate = true;
			productRate.rateEmail = ratingByEmail.getStar();

			return new ResponseEntity<String>(Tools.toJson(productRate), headers,
				HttpStatus.OK);
		}
	}

	/**
	 * web service to save or update rating of email with product id
	 * @param productId
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "rating/{productId}", method = RequestMethod.PUT, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> ratingSaveOrUpdate(
		@PathVariable("productId") String productId,
		@RequestBody String json) {

		// catch rating from json to get email
		Rating ratingTempFromJson = (Rating) Tools.fromJsonTo(json,
			Rating.class);

		// get email
		String email = ratingTempFromJson.getEmail();
		// get rate
		int rate = ratingTempFromJson.getStar();
		// get rating byID and email
		Double result = ratingService.checkRaingByProductIdByEmail(productId,
			email, STATUS.ACTIVE.getStatusCode());
		// create header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		if (result == -1) // add rate
		{
			try {
				Rating ratingInsert = new Rating();
				ratingInsert.setProductId(productId);
				ratingInsert.setEmail(email);
				ratingInsert.setStar(rate);
				ratingInsert.setStatus(STATUS.ACTIVE.getStatusCode());
				ratingService.addRating(ratingInsert);
			} catch (Exception e) {
				return new ResponseEntity<String>(headers,
					HttpStatus.BAD_REQUEST);
			}
		} else // update
		{
			try {
				
				//get rating with email
				Rating ratingByEmail = ratingService.getRatingByEmail(email,
					STATUS.ACTIVE.getStatusCode());
				
				Rating ratingUpdate = new Rating();
				ratingUpdate.setId(ratingByEmail.getId());
				ratingUpdate.setProductId(productId);
				ratingUpdate.setEmail(email);
				ratingUpdate.setStar(rate);
				ratingUpdate.setStatus(STATUS.ACTIVE.getStatusCode());
				ratingService.updateRating(ratingUpdate);
			} catch (Exception e) {
				return new ResponseEntity<String>(headers,
					HttpStatus.BAD_REQUEST);
			}
		}

		return new ResponseEntity<String>(headers, HttpStatus.OK);
	}
}
