package co.hcmus.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.models.Promotion;
import co.hcmus.models.PromotionDetail;
import co.hcmus.services.IPromotionDetailService;
import co.hcmus.services.IPromotionService;
import co.hcmus.util.STATUS;
import co.hcmus.util.Tools;

@Controller
public class PromotionDetailController {
	private static final Logger logger = LoggerFactory
			.getLogger(PromotionDetailController.class);
	@Autowired
	private IPromotionDetailService promotionDetailService;

	@Autowired
	private IPromotionService promotionService;

	
	/**
	 * ADMIN PAGE - get total page of listPromotionDetails
	 * @param listPromotionDetails
	 * @return
	 */
	private int getTotalPage(List<PromotionDetail> listPromotionDetails) {
		if (listPromotionDetails.size() == 0)
			return 1;
		if (listPromotionDetails.size() <= 10)
			return 1;
		int totalPage = listPromotionDetails.size() / 10;
		if (listPromotionDetails.size() % 10 == 0)
			return totalPage;
		return totalPage + 1;

	}
	
	/**
	 * ADMIN PAGE - Show all product of a Promotion by Promotion's ID
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/promotions/{id}", method = RequestMethod.GET)
	public String showPromotionDetail(HttpServletRequest request,
			@PathVariable String id, @RequestParam("Page") int currentPage) {
		PromotionDetail promotionDetail = new PromotionDetail();
		Promotion promotion = promotionService.getPromotionById(id);
		List<PromotionDetail> listPromotionDetail = promotionDetailService
				.getPromotionDetailsByPromotionIdWithoutStatus(id);
		List<PromotionDetail> listResult;
		if (listPromotionDetail.size() < 10 * currentPage) {
			listResult = listPromotionDetail.subList(10 * (currentPage - 1),
					listPromotionDetail.size());
		} else {
			listResult = listPromotionDetail.subList(10 * (currentPage - 1),
					(10 * currentPage));
		}
		int totalPage = getTotalPage(listPromotionDetail);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("promotion", promotion);
		request.setAttribute("promotionDetail", promotionDetail);
		request.setAttribute("listPromotionDetails", listResult);
		logger.info("Admin get promotionDetails");
		return "promotiondetail";
	}

	/**
	 * ADMIN PAGE - Add new Promotion detail
	 * 
	 * @param promotionDetail
	 * @param id
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/promotions/{id}/add", method = RequestMethod.POST)
	public String addPromotionDetail(PromotionDetail promotionDetail,
			@PathVariable String id) {
		promotionDetail.setPromotionId(id);
		promotionDetail.setId(null);
		promotionDetailService.addPromotionDetail(promotionDetail);
		logger.info("Admin add promotionDetails");
		return "redirect:/admin/promotions/" + id+ "?Page=1";
	}

	/**
	 * ADMIN PAGE - Deactive a product from promotion
	 * 
	 * @param promotionDetail
	 * @param id
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/promotions/{id}/block/{pageNumber}", method = RequestMethod.POST)
	public String blockPromotionDetail(@PathVariable String id, PromotionDetail promotionDetail, @PathVariable int pageNumber) {
		//NOTE: There is an error. PromotionDetail Id is replaced by promotion Id, then ProductId is used instead (productID is promotionDetails ID not product ID)
		PromotionDetail pd = promotionDetailService.getPromotionDetailByPromotionDetailId(promotionDetail.getProductId());
		pd.setStatus(STATUS.INACTIVE.getStatusCode());
		promotionDetailService.updatePromotionDetail(pd);
		logger.info("Admin active promotionDetails with id : "
				+ pd.getId());
		return "redirect:/admin/promotions/" + id + "?Page=" + pageNumber;
	}

	/**
	 * ADMIN PAGE - Active a product from promotion
	 * 
	 * @param promotionDetail
	 * @param id
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/promotions/{id}/active/{pageNumber}", method = RequestMethod.POST)
	public String activePromotionDetail(PromotionDetail promotionDetail,@PathVariable String id, @PathVariable int pageNumber) {
		//NOTE: There is an error. PromotionDetail Id is replaced by promotion Id, then ProductId is used instead (productID is promotionDetails ID not product ID)
		PromotionDetail pd = promotionDetailService.getPromotionDetailByPromotionDetailId(promotionDetail.getProductId());
		pd.setStatus(STATUS.ACTIVE.getStatusCode());
		promotionDetailService.updatePromotionDetail(pd);
		logger.info("Admin active promotionDetails with id : "
				+ pd.getId());
		return "redirect:/admin/promotions/" + id+ "?Page=" + pageNumber;
	}

	/**
	 * ADMIN PAGE - Edit a promotion detail
	 * 
	 * @param promotionDetail
	 * @param id
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/promotions/{promotion_id}/edit/{pageNumber}", method = RequestMethod.POST)
	public String editPromotionDetail(PromotionDetail promotionDetail,
			@PathVariable String promotion_id, @PathVariable int pageNumber) {
		System.out.println(promotionDetail.getProductId());
		promotionDetail.setPromotionId(promotion_id);
		promotionDetailService.updatePromotionDetail(promotionDetail);
		logger.info("Admin edit promotionDetails with id : "
				+ promotionDetail.getId());
		return "redirect:/admin/promotions/" + promotion_id+ "?Page=" + pageNumber;
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
			logger.info("Rest get all promotionDetails");
			return new ResponseEntity<String>(
					Tools.toJsonArray(listPromotionDetail), headers,
					HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error get all promotionDetails");
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
			logger.info("Rest create promotionDetails");
			return new ResponseEntity<String>(headers, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error create promotionDetails");
			return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}

	}
}
