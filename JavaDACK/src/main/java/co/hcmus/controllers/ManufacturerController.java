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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.models.Manufacturer;
import co.hcmus.services.IManufacturerService;
import co.hcmus.util.STATUS;
import co.hcmus.util.Tools;

@Controller
public class ManufacturerController {

	@Autowired
	private IManufacturerService manufacturerService;

	@RequestMapping(value = "/admin/manufacturer", method = RequestMethod.GET)
	public String getManufacturer(Locale locale, Model model,
			HttpServletRequest request) {
		prepairData(request);
		return "manufacturer";
	}

	@RequestMapping(value = "/admin/manufacturer/add", method = RequestMethod.POST)
	public String addManufacturer(Locale locale, Model model,
			HttpServletRequest request, Manufacturer manufacturer) {
		manufacturerService.addManufacturer(manufacturer);
		return "redirect:/admin/manufacturer";
	}

	@RequestMapping(value = "/admin/manufacturer/active/{id}", method = RequestMethod.GET)
	public String activeManufacturer(Locale locale, Model model,
			HttpServletRequest request, @PathVariable String id) {
		Manufacturer Manufacturer = manufacturerService.getManufacturerById(id);
		Manufacturer.setStatus(STATUS.ACTIVE.getStatusCode());
		manufacturerService.updateManufacturer(Manufacturer);
		return "redirect:/admin/manufacturer";
	}

	@RequestMapping(value = "/admin/manufacturer/deactive/{id}", method = RequestMethod.GET)
	public String deactiveManufacturer(Locale locale, Model model,
			HttpServletRequest request, @PathVariable String id) {
		Manufacturer Manufacturer = manufacturerService.getManufacturerById(id);
		Manufacturer.setStatus(STATUS.INACTIVE.getStatusCode());
		manufacturerService.updateManufacturer(Manufacturer);
		return "redirect:/admin/manufacturer";
	}

	@RequestMapping(value = "/admin/manufacturer/edit", method = RequestMethod.POST)
	public String editManufacturer(Model model, HttpServletRequest request,
			Manufacturer manufacturer) {
		manufacturerService.updateManufacturer(manufacturer);
		return "redirect:/admin/manufacturer";
	}

	private void prepairData(HttpServletRequest request) {
		List<Manufacturer> listManufacturer = manufacturerService
				.getManufacturers();

		request.setAttribute("listManufacturer", listManufacturer);
		request.setAttribute("manufacturer", new Manufacturer());
		request.setAttribute("nav", "manufacturer");
	}

	/**
	 * webservice to get manufacturers
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manufacturer", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getManufacturers() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		// get all product
		List<Manufacturer> listManufacturer = manufacturerService
				.getManufacturers();
		return new ResponseEntity<String>(Tools.toJsonArray(listManufacturer),
				headers, HttpStatus.OK);
	}
}
