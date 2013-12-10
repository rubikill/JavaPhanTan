package co.hcmus.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.hcmus.models.ProductDetail;
import co.hcmus.services.Imp.AccountServiceMongo;
import co.hcmus.services.Imp.AccountTypeServiceMongo;
import co.hcmus.services.Imp.CommentServiceMongo;
import co.hcmus.services.Imp.HistoryServiceMongo;
import co.hcmus.services.Imp.ManufacturerServiceMongo;
import co.hcmus.services.Imp.PermissionServiceMongo;
import co.hcmus.services.Imp.ProductDetailServiceMongo;
import co.hcmus.services.Imp.ProductServiceMongo;
import co.hcmus.services.Imp.ProductTypeServiceMongo;
import co.hcmus.util.STATUS;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private AccountServiceMongo accountService;
	@Autowired
	private AccountTypeServiceMongo accountTypeService;
	@Autowired
	private CommentServiceMongo commentService;
	@Autowired
	private HistoryServiceMongo historyService;
	@Autowired
	private PermissionServiceMongo permissionService;
	@Autowired
	private ProductTypeServiceMongo productTypeService;
	@Autowired
	private ProductServiceMongo productService;
	@Autowired
	private ManufacturerServiceMongo manufacturerService;
	@Autowired
	private ProductDetailServiceMongo productDetailService;

	// private Manufacturer
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// Add account
		// Account account = new
		// Account("abcd@acd.com","Thomas","092388332","A2, Phidel town",new
		// Date(),"1","abcdef","active","1234567",100);
		// accountService.addAccount(account);
		//
		// //Add accountType
		// AccountType accountType = new AccountType("1", "Normal");
		// accountTypeService.addAccountType(accountType);
		// accountType = new AccountType("2", "VIP");
		// accountTypeService.addAccountType(accountType);
		// accountType = new AccountType("3", "Admin");
		// accountTypeService.addAccountType(accountType);

		// Add new ProductType
		// ProductType productType = new ProductType("CAMCODER");
		// productTypeService.addProductType(productType);
		// productType = new ProductType("DIGITAL SLR CAMERA");
		// productTypeService.addProductType(productType);
		// productType = new ProductType("POINT & SHOOT CAMERAS");
		// productTypeService.addProductType(productType);
		// productType = new ProductType("FLASHS");
		// productTypeService.addProductType(productType);
		// productType = new ProductType("LENS");
		// productTypeService.addProductType(productType);

		// Add manufacturer
		// Manufacturer mf = new Manufacturer("Panasonic");
		// manufacturerService.addManufacturer(mf);
		// mf = new Manufacturer("Samsung");
		// manufacturerService.addManufacturer(mf);
		// mf = new Manufacturer("Nikon");
		// manufacturerService.addManufacturer(mf);

		// mf = new Manufacturer("Canon");
		// manufacturerService.addManufacturer(mf);
		// mf = new Manufacturer("Sony");
		// manufacturerService.addManufacturer(mf);
		// mf = new Manufacturer("JVC");
		// manufacturerService.addManufacturer(mf);
		// mf = new Manufacturer("PENTAX");
		// manufacturerService.addManufacturer(mf);
		// mf = new Manufacturer("Samsung");
		// manufacturerService.addManufacturer(mf);

		// ==============================================================
		// Add new Product - Without point column
		// ==============================================================
		// ==== DSLR ====
		// Product product =
		// new Product("D3200 Digital SLR Camera with 18-55mm VR Lens",
		// "52a5ff01dcace71c50fdc59d", 10 , 3, 5, "52a60375dcac65bfed509857",
		// 496.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);

		// Product product = new Product("TEST", "52a5ff01dcace71c50fdc59d", 10,
		// 3, 5, "52a60375dcac65bfed509857", 496.99, 49,
		// STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);

		// product =
		// new Product("D5200 DSLR Camera with 18-55mm VR Lens",
		// "52a5ff01dcace71c50fdc59d", 20 , 6, 4, "52a60375dcac65bfed509857",
		// 749.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("EOS 6D Digital SLR Camera with 24-105mm f/4L IS Lens",
		// "52a5ff01dcace71c50fdc59d", 22 , 16, 14, "52a60375dcac65bfed509858",
		// 2399,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("K-30 Digital SLR Camera with 18-55mm Lens",
		// "52a5ff01dcace71c50fdc59d", 13 , 4, 1, "52a60375dcac65bfed50985b",
		// 727.98,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new
		// Product("EOS 5D Mark III Digital SLR Camera with 24-70mm f/4L IS Lens",
		// "52a5ff01dcace71c50fdc59d", 22 , 16, 14, "52a60375dcac65bfed509858",
		// 4199.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("Alpha a77 Digital SLR Camera with 16-50mm Lens",
		// "52a5ff01dcace71c50fdc59d", 22 , 16, 14, "52a60375dcac65bfed509859",
		// 1399.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		//
		// // ==== CAMCODERS ====
		// product =
		// new Product("VIXIA HF R40 8GB HD Flash Memory Camcorders",
		// "52a5ff01dcace71c50fdc59c", 82 , 19, 9, "52a60375dcac65bfed509858",
		// 249,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("V201 HD Camcorder",
		// "52a5ff01dcace71c50fdc59c", 222 , 121, 1, "52a6066adcac6c00c81ce2b8",
		// 179.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("Action Cam HDRAS15/B HD Flash Memory Camcorder",
		// "52a5ff01dcace71c50fdc59c", 45 , 16, 14, "52a60375dcac65bfed509859",
		// 169.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("ADIXXION HD Flash Memory Camcorder",
		// "52a5ff01dcace71c50fdc59c", 9 , 3, 3, "52a60375dcac65bfed50985a",
		// 299.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("HDR-PJ380 16GB HD Flash Memory Camcorder",
		// "52a5ff01dcace71c50fdc59c", 7 , 2, 1, "52a60375dcac65bfed509859",
		// 599.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("HDR-CX380 16GB HD Flash Memory Camcorder",
		// "52a5ff01dcace71c50fdc59c", 13 , 5, 4, "52a60375dcac65bfed509859",
		// 349.99,STATUS.ACTIVE.getStatusCode());
		//
		// //==== POINT & SHOOT CAMERAS ====
		// productService.addProduct(product);
		// product =
		// new Product("PowerShot 12.1-Megapixel SX280HS Digital Camera",
		// "52a5ff01dcace71c50fdc59e", 23 , 12, 4, "52a60375dcac65bfed509858",
		// 279.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("PowerShot SX510 HS 12.1-Megapixel Digital Camera",
		// "52a5ff01dcace71c50fdc59e", 32 , 6,9, "52a60375dcac65bfed509858",
		// 249.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("Coolpix S800c 16.0-Megapixel Digital Camera",
		// "52a5ff01dcace71c50fdc59e", 41 , 16, 14, "52a60375dcac65bfed509857",
		// 129.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("WB250F 14.2-Megapixel Digital Camera",
		// "52a5ff01dcace71c50fdc59e", 34 , 16, 14, "52a6098ddcac79051d286a1e",
		// 149.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("Coolpix P520 18.1-Megapixel Digital Camera",
		// "52a5ff01dcace71c50fdc59e", 12 , 16, 14, "52a60375dcac65bfed509857",
		// 349.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("Galaxy 16.3-Megapixel Digital Camera",
		// "52a5ff01dcace71c50fdc59e", 23 , 16, 14, "52a6098ddcac79051d286a1e",
		// 385.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("PowerShot A2500 16.0-Megapixel Digital Camera",
		// "52a5ff01dcace71c50fdc59e", 22 , 16, 14, "52a60375dcac65bfed509858",
		// 109.99,STATUS.ACTIVE.getStatusCode());
		//
		// //==== FLASHS ====
		// productService.addProduct(product);
		// product =
		// new Product("SB-700 AF Speedlight External Flash",
		// "52a5ff01dcace71c50fdc59f", 18 , 16, 14, "52a60375dcac65bfed509857",
		// 329.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("Speedlite 600EX-RT External Flash",
		// "52a5ff01dcace71c50fdc59f", 19 , 16, 14, "52a60375dcac65bfed509858",
		// 499.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("HVL-F20S External Flash",
		// "52a5ff01dcace71c50fdc59f", 33 , 16, 14, "52a60375dcac65bfed50985a",
		// 129.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("Speedlite 320EX External Flash",
		// "52a5ff01dcace71c50fdc59f", 44 , 16, 14, "52a60375dcac65bfed509858",
		// 249.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("Ring Light",
		// "52a5ff01dcace71c50fdc59f", 35 , 16, 14, "52a60375dcac65bfed50985a",
		// 249.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		//
		// //==== LENS ====
		// product =
		// new
		// Product("AF-S DX VR Zoom-Nikkor 55-200mm f/4-5.6G IF-ED Telephoto Zoom Lens",
		// "52a5ff01dcace71c50fdc5a0", 14 , 16, 14, "52a60375dcac65bfed509857",
		// 249.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("AF-S NIKKOR 50mm f/1.8G Standard Lens",
		// "52a5ff01dcace71c50fdc5a0", 23 , 16, 14, "52a60375dcac65bfed509857",
		// 219.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("AF-S DX NIKKOR 18-140mm f/3.5-5.6G ED VR Zoom Lens",
		// "52a5ff01dcace71c50fdc5a0", 31 , 16, 14, "52a60375dcac65bfed509857",
		// 599.99,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("EF 40mm f/2.8 STM Standard Lens",
		// "52a5ff01dcace71c50fdc5a0", 44 , 16, 14, "52a60375dcac65bfed509858",
		// 149,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("EF-S 10-22mm f/3.5-4.5 USM Ultra-Wide Zoom Lens",
		// "52a5ff01dcace71c50fdc5a0", 54 , 16, 14, "52a60375dcac65bfed509858",
		// 599,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);
		// product =
		// new Product("EF 85mm f/1.8 USM Medium Telephoto Lens",
		// "52a5ff01dcace71c50fdc5a0", 12 , 16, 14, "52a60375dcac65bfed509858",
		// 359,STATUS.ACTIVE.getStatusCode());
		// productService.addProduct(product);

		// =============================================================
		// ADD product detail
		// =============================================================

		// ProductDetail pd = new ProductDetail("52a60af5dcac3f217a062f8d", 1,
		// 3.8, 17.8, STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062f8e", 1, 3.9, 17.2,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062f8f", 1, 4.4, 24,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062f90", 1, 3.8, 17.3,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062f91", 1, 4.6, 17.9,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062f92", 1, 4.1, 17.4,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062f93", 2, 2.2, 10.1,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062f94", 1, 2.4, 6.5,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062f95", 2, 0.9, 2,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062f96", 1, 2.1, 4.4,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062f97", 1, 2.3, 9.3,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062f98", 2, 2.1, 6.5,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062f99", 1, 2.3, 8.2,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062f9a", 1, 2.5, 12.3,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062f9b", 1, 2.7, 6.5,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062f9c", 1, 2.4, 6.5,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062f9d", 2, 3.4, 17.2,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062f9e", 1, 2.8, 9.9,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062f9f", 1, 2.2, 4.4,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062fa0", 1, 5, 12.7,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062fa1", 1, 5.6, 15,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062fa2", 1, 2.9, 2.3,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062fa3", 2, 4.5, 12.8,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062fa4", 1, 5.6, 6.9,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062fa5", 1, 3.9, 11.8,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062fa6", 1, 2.8, 6.6,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062fa7", 1, 3, 1.1,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062fa8", 1, 2.7, 4.6,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062fa9", 1, 3.3, 13.6,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);
		// pd = new ProductDetail("52a60af5dcac3f217a062faa", 1, 3, 15,
		// STATUS.ACTIVE.getStatusCode());
		// productDetailService.addProductDetail(pd);

		return "home";
	}

	@RequestMapping(value = "/compair", method = RequestMethod.GET)
	public String compair(Locale locale, Model model) {
		return "compair";
	}

	@RequestMapping(value = "/special_offer", method = RequestMethod.GET)
	public String special_offer(Locale locale, Model model) {
		return "special_offer";
	}

	@RequestMapping(value = "/tac", method = RequestMethod.GET)
	public String tac(Locale locale, Model model) {
		return "tac";
	}

}
