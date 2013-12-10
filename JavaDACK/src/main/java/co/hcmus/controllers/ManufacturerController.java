package co.hcmus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.models.Manufacturer;
import co.hcmus.services.IManufacturerService;
import co.hcmus.util.Tools;


@Controller
public class ManufacturerController {

	@Autowired
	private IManufacturerService manufacturerService;

	/**
	 * webservice to get manufacturers
	 * @return
	 */
	@RequestMapping(value = "/manufacturer", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getManufacturers() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		// get all product
	List<Manufacturer> listManufacturer = manufacturerService.getManufacturers();
		return new ResponseEntity<String>(Tools.toJsonArray(listManufacturer), headers,
				HttpStatus.OK);
	}
}
