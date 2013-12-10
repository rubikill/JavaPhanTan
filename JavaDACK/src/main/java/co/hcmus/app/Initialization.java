package co.hcmus.app;

import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import co.hcmus.models.Account;
import co.hcmus.models.AccountType;
import co.hcmus.models.Comment;
import co.hcmus.models.History;
import co.hcmus.models.HistoryDetail;
import co.hcmus.models.Manufacturer;
import co.hcmus.models.PaymentType;
import co.hcmus.models.Permission;
import co.hcmus.models.PermissionDetail;
import co.hcmus.models.PointLevel;
import co.hcmus.models.Product;
import co.hcmus.models.ProductDetail;
import co.hcmus.models.ProductType;
import co.hcmus.models.Promotion;
import co.hcmus.models.PromotionDetail;
import co.hcmus.models.Rating;
import co.hcmus.models.Tag;
import co.hcmus.services.IAccountService;
import co.hcmus.services.IAccountTypeService;
import co.hcmus.services.IProductTypeService;
import co.hcmus.services.IManufacturerService;
import co.hcmus.services.IProductService;
import co.hcmus.util.STATUS;


public class Initialization implements InitializingBean {

	@Autowired
	private IAccountService accountService;

	@Autowired
	private IAccountTypeService accountTypeService;

	@Autowired
	private IProductTypeService productTypeService;

	@Autowired
	private IManufacturerService manufacturerService;

	@Autowired
	private IProductService productService;

	@Autowired
	private MongoTemplate mongoTemplate;

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out
				.println("----------------------------------------------");
		System.out
				.println("----------------INITIALIZATION----------------");
		System.out
				.println("----------------------------------------------");

		// create collection Account if not exits
		if (!mongoTemplate.collectionExists(Account.class)) {
			mongoTemplate.createCollection(Account.class);
		}
	
		// create collection AccountType if not exits
		if (!mongoTemplate.collectionExists(AccountType.class)) {
			mongoTemplate.createCollection(AccountType.class);
		}
		// create collection Comment if not exits
		if (!mongoTemplate.collectionExists(Comment.class)) {
			mongoTemplate.createCollection(Comment.class);
		}
		// create collection History if not exits
		if (!mongoTemplate.collectionExists(History.class)) {
			mongoTemplate.createCollection(History.class);
		}
		// create collection HistoryDetail if not exits
		if (!mongoTemplate.collectionExists(HistoryDetail.class)) {
			mongoTemplate.createCollection(HistoryDetail.class);
		}
		// create collection Manufacturer if not exits
		if (!mongoTemplate.collectionExists(Manufacturer.class)) {
			mongoTemplate.createCollection(Manufacturer.class);
		}
		// create collection PaymentType if not exits
		if (!mongoTemplate.collectionExists(PaymentType.class)) {
			mongoTemplate.createCollection(PaymentType.class);
		}
		// create collection Permission if not exits
		if (!mongoTemplate.collectionExists(Permission.class)) {
			mongoTemplate.createCollection(Permission.class);
		}
		// create collection PermissionDetail if not exits
		if (!mongoTemplate.collectionExists(PermissionDetail.class)) {
			mongoTemplate.createCollection(PermissionDetail.class);
		}
		// create collection PointLevel if not exits
		if (!mongoTemplate.collectionExists(PointLevel.class)) {
			mongoTemplate.createCollection(PointLevel.class);
		}
		// create collection Product if not exits
		if (!mongoTemplate.collectionExists(Product.class)) {
			mongoTemplate.createCollection(Product.class);
		}
		// create collection ProductDetail if not exits
		if (!mongoTemplate.collectionExists(ProductDetail.class)) {
			mongoTemplate.createCollection(ProductDetail.class);
		}
		// create collection ProductType if not exits
		if (!mongoTemplate.collectionExists(ProductType.class)) {
			mongoTemplate.createCollection(ProductType.class);
		}
		// create collection Promotion if not exits
		if (!mongoTemplate.collectionExists(Promotion.class)) {
			mongoTemplate.createCollection(Promotion.class);
		}
		// create collection PromotionDetail if not exits
		if (!mongoTemplate.collectionExists(PromotionDetail.class)) {
			mongoTemplate.createCollection(PromotionDetail.class);
		}
		// create collection Rating if not exits
		if (!mongoTemplate.collectionExists(Rating.class)) {
			mongoTemplate.createCollection(Rating.class);
		}
		// create collection Tag if not exits
		if (!mongoTemplate.collectionExists(Tag.class)) {
			mongoTemplate.createCollection(Tag.class);
		}

		//Add account
		Account account = new Account("admin@admin.com","Admin","092388332","A2, Phidel town",new Date(),"1","abcdef","active","1234567",100);
		accountService.addAccount(account);
		
		//Add accountType
		AccountType accountType = new AccountType("1", "Normal");
		accountTypeService.addAccountType(accountType);
		accountType = new AccountType("2", "VIP");
		accountTypeService.addAccountType(accountType);
		accountType = new AccountType("3", "Admin");
		accountTypeService.addAccountType(accountType);
		
		//Add new ProductType
		ProductType productType = new ProductType("CAMCODER");
		productTypeService.addProductType(productType);
		productType = new ProductType("DIGITAL SLR CAMERA");
		productTypeService.addProductType(productType);
		productType = new ProductType("POINT & SHOOT CAMERAS");
		productTypeService.addProductType(productType);
		productType = new ProductType("FLASHS");
		productTypeService.addProductType(productType);
		productType = new ProductType("LENS");
		productTypeService.addProductType(productType);
	
		//Add manufacturer
		Manufacturer mf = new Manufacturer("Panasonic");
		manufacturerService.addManufacturer(mf);
		mf = new Manufacturer("Samsung");
		manufacturerService.addManufacturer(mf);
		mf = new Manufacturer("Nikon");
		manufacturerService.addManufacturer(mf);

		mf = new Manufacturer("Canon");
		manufacturerService.addManufacturer(mf);
		mf = new Manufacturer("Sony");
		manufacturerService.addManufacturer(mf);
		mf = new Manufacturer("JVC");
		manufacturerService.addManufacturer(mf);
		mf = new Manufacturer("PENTAX");
		manufacturerService.addManufacturer(mf);
		mf = new Manufacturer("Samsung");
		manufacturerService.addManufacturer(mf);
		
		//Add new Product
		
		//DSLR
		Product product = 
				new Product("D3200 Digital SLR Camera with 18-55mm VR Lens", 
						"52a5ff01dcace71c50fdc59d", 10 , 3, 5, "52a60375dcac65bfed509857", 496.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("D5200 DSLR Camera with 18-55mm VR Lens", 
						"52a5ff01dcace71c50fdc59d", 20 , 6, 4, "52a60375dcac65bfed509857", 749.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("EOS 6D Digital SLR Camera with 24-105mm f/4L IS Lens", 
						"52a5ff01dcace71c50fdc59d", 22 , 16, 14, "52a60375dcac65bfed509858", 2399,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("K-30 Digital SLR Camera with 18-55mm Lens", 
						"52a5ff01dcace71c50fdc59d", 13 , 4, 1, "52a60375dcac65bfed50985b", 727.98,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("EOS 5D Mark III Digital SLR Camera with 24-70mm f/4L IS Lens", 
						"52a5ff01dcace71c50fdc59d", 22 , 16, 14, "52a60375dcac65bfed509858", 4199.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("Alpha a77 Digital SLR Camera with 16-50mm Lens", 
						"52a5ff01dcace71c50fdc59d", 22 , 16, 14, "52a60375dcac65bfed509859", 1399.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		
		//CAMCODERS
		product = 
				new Product("VIXIA HF R40 8GB HD Flash Memory Camcorders", 
						"52a5ff01dcace71c50fdc59c", 82 , 19, 9, "52a60375dcac65bfed509858", 249,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("V201 HD Camcorder", 
						"52a5ff01dcace71c50fdc59c", 222 , 121, 1, "52a6066adcac6c00c81ce2b8", 179.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("Action Cam HDRAS15/B HD Flash Memory Camcorder", 
						"52a5ff01dcace71c50fdc59c", 45 , 16, 14, "52a60375dcac65bfed509859", 169.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("ADIXXION HD Flash Memory Camcorder", 
						"52a5ff01dcace71c50fdc59c", 9 , 3, 3, "52a60375dcac65bfed50985a", 299.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("HDR-PJ380 16GB HD Flash Memory Camcorder", 
						"52a5ff01dcace71c50fdc59c", 7 , 2, 1, "52a60375dcac65bfed509859", 599.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("HDR-CX380 16GB HD Flash Memory Camcorder", 
						"52a5ff01dcace71c50fdc59c", 13 , 5, 4, "52a60375dcac65bfed509859", 349.99,STATUS.ACTIVE.getStatusCode());
		
		//POINT & SHOOT CAMERAS
		productService.addProduct(product);
		product = 
				new Product("PowerShot 12.1-Megapixel SX280HS Digital Camera", 
						"52a5ff01dcace71c50fdc59e", 23 , 12, 4, "52a60375dcac65bfed509858", 279.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("PowerShot SX510 HS 12.1-Megapixel Digital Camera", 
						"52a5ff01dcace71c50fdc59e", 32 , 6,9, "52a60375dcac65bfed509858", 249.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("Coolpix S800c 16.0-Megapixel Digital Camera", 
						"52a5ff01dcace71c50fdc59e", 41 , 16, 14, "52a60375dcac65bfed509857", 129.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("WB250F 14.2-Megapixel Digital Camera", 
						"52a5ff01dcace71c50fdc59e", 34 , 16, 14, "52a6098ddcac79051d286a1e", 149.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("Coolpix P520 18.1-Megapixel Digital Camera", 
						"52a5ff01dcace71c50fdc59e", 12 , 16, 14, "52a60375dcac65bfed509857", 349.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("Galaxy 16.3-Megapixel Digital Camera", 
						"52a5ff01dcace71c50fdc59e", 23 , 16, 14, "52a6098ddcac79051d286a1e", 385.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("PowerShot A2500 16.0-Megapixel Digital Camera", 
						"52a5ff01dcace71c50fdc59e", 22 , 16, 14, "52a60375dcac65bfed509858", 109.99,STATUS.ACTIVE.getStatusCode());
		
		//FLASHS
		productService.addProduct(product);
		product = 
				new Product("SB-700 AF Speedlight External Flash", 
						"52a5ff01dcace71c50fdc59f", 18 , 16, 14, "52a60375dcac65bfed509857", 329.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("Speedlite 600EX-RT External Flash", 
						"52a5ff01dcace71c50fdc59f", 19 , 16, 14, "52a60375dcac65bfed509858", 499.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("HVL-F20S External Flash", 
						"52a5ff01dcace71c50fdc59f", 33 , 16, 14, "52a60375dcac65bfed50985a", 129.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("Speedlite 320EX External Flash", 
						"52a5ff01dcace71c50fdc59f", 44 , 16, 14, "52a60375dcac65bfed509858", 249.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("Ring Light", 
						"52a5ff01dcace71c50fdc59f", 35 , 16, 14, "52a60375dcac65bfed50985a", 249.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		
		//LENS
		product = 
				new Product("AF-S DX VR Zoom-Nikkor 55-200mm f/4-5.6G IF-ED Telephoto Zoom Lens", 
						"52a5ff01dcace71c50fdc5a0", 14 , 16, 14, "52a60375dcac65bfed509857", 249.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("AF-S NIKKOR 50mm f/1.8G Standard Lens", 
						"52a5ff01dcace71c50fdc5a0", 23 , 16, 14, "52a60375dcac65bfed509857", 219.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("AF-S DX NIKKOR 18-140mm f/3.5-5.6G ED VR Zoom Lens", 
						"52a5ff01dcace71c50fdc5a0", 31 , 16, 14, "52a60375dcac65bfed509857", 599.99,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("EF 40mm f/2.8 STM Standard Lens", 
						"52a5ff01dcace71c50fdc5a0", 44 , 16, 14, "52a60375dcac65bfed509858", 149,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("EF-S 10-22mm f/3.5-4.5 USM Ultra-Wide Zoom Lens", 
						"52a5ff01dcace71c50fdc5a0", 54 , 16, 14, "52a60375dcac65bfed509858", 599,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
		product = 
				new Product("EF 85mm f/1.8 USM Medium Telephoto Lens", 
						"52a5ff01dcace71c50fdc5a0", 12 , 16, 14, "52a60375dcac65bfed509858", 359,STATUS.ACTIVE.getStatusCode());
		productService.addProduct(product);
	}
}
