package co.hcmus.daos.Imp;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

import co.hcmus.daos.IProductDAO;
import co.hcmus.models.Product;
import co.hcmus.util.STATUS;

@Repository("productDAO")
@Transactional
public class ProductDAOMongo implements IProductDAO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ProductDAOMongo.class);
	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "product";

	@Override
	public void addProduct(Product product) {
		if (!mongoTemplate.collectionExists(Product.class)) {
			mongoTemplate.createCollection(Product.class);
		}
		logger.info("ProductDAOMongo add product with Name : " + product.getName());
		mongoTemplate.insert(product, COLLECTION_NAME);

	}

	@Override
	public void updateProduct(Product product) {
		// update a document
		logger.info("ProductDAOMongo update product with id : " + product.getId());
		mongoTemplate.save(product, COLLECTION_NAME);

	}

	@Override
	public Product getProductById(String id) {
		Query searchProductQuery = new Query(Criteria.where("_id").is(id));
		logger.info("ProductDAOMongo get product with id : " + id);
		return mongoTemplate.findOne(searchProductQuery, Product.class,
				COLLECTION_NAME);
	}

	@Override
	public void deleteProduct(String id) {
		// TODO Auto-generated method stub
		Product product = getProductById(id);
		product.setStatus(STATUS.INACTIVE.getStatusCode());
		logger.info("ProductDAOMongo delete product with id : " + id);
		mongoTemplate.save(product, COLLECTION_NAME);
	}

	@Override
	public List<Product> getProducts() {
		// get all docuemnt
		logger.info("ProductDAOMongo get all product");
		return mongoTemplate.findAll(Product.class, COLLECTION_NAME);
	}

	@Override
	public List<Product> getProductsByTypeId(String id, String status) {
		// TODO Auto-generated method stub
		Query searchProductQueryByType = new Query(Criteria
				.where("productTypeId").is(id).and("status").is(status));
		logger.info("ProductDAOMongo get  product by ProductTypeId : "  + id);
		return mongoTemplate.find(searchProductQueryByType, Product.class,
				COLLECTION_NAME);
	}

	@Override
	public List<Product> getProductsByManufacturerId(String id, String status) {
		// TODO Auto-generated method stub
		Query searchProductQueryByManufacturer = new Query(Criteria
				.where("manufacturerId").is(id).and("status").is(status));
		logger.info("ProductDAOMongo get  product by ManufacturerId : "  + id);
		return mongoTemplate.find(searchProductQueryByManufacturer,
				Product.class, COLLECTION_NAME);
	}

	/**
	 * Save image into MongoDB
	 * 
	 * @param name
	 *            Image's name = product's Id
	 * @param path
	 *            Image's location (Ex: c:\\myImage.jpg")
	 */
	@Override
	public void saveImage(String name, String path) {
		String newFileName = name;
		File imageFile = new File(path);
		GridFS gfsPhoto = new GridFS(mongoTemplate.getDb(), "image");
		GridFSInputFile gfsFile;
		try {
			gfsFile = gfsPhoto.createFile(imageFile);
			gfsFile.setFilename(newFileName);
			gfsFile.save();
			logger.info("ProductDAOMongo save  Image with Name : "  + name);
		} catch (IOException e) {
			logger.error("Error ProductDAOMongo save images");
			e.printStackTrace();
		}
	}

	/**
	 * Get an image by its id
	 * 
	 * @param name
	 *            File name in db = product's id
	 * @return Type: GridFSDBFile
	 */
	@Override
	public GridFSDBFile getImageByName(String name) {
		String newFileName = name;
		GridFS gfsPhoto = new GridFS(mongoTemplate.getDb(), "image");
		// Note: we can get all image from db
		// DBCursor cursor = gfsPhoto.getFileList();
		// while (cursor.hasNext()) {
		// System.out.println(cursor.next());
		// }
		logger.info("ProductDAOMongo get  Image by Name : "  + name);
		GridFSDBFile imageForOutput = gfsPhoto.findOne(newFileName);
		return imageForOutput;
	}

	/**
	 * Get an image by its name and write to a new file
	 * 
	 * @param name
	 *            Image name in db = product's Id
	 * @param path
	 *            Path where to write file
	 */
	@Override
	public void writeImage(String name, String path) {
		String newFileName = name;
		GridFS gfsPhoto = new GridFS(mongoTemplate.getDb(), "image");
		// output to new file
		GridFSDBFile imageForOutput = gfsPhoto.findOne(newFileName);
		try {
			imageForOutput.writeTo(path);
			logger.info("ProductDAOMongo write  image with name : "  + name);
		} catch (IOException e) {
			logger.error("Error ProductDAOMongo write Iamge");
			e.printStackTrace();
		}

	}

	/**
	 * Delete an image by its name Using this when update image.
	 * 
	 * @param name
	 *            Image name in db = product's id
	 */
	@Override
	public void deleteImageByName(String name) {
		String fileName = name;
		GridFS gfsPhoto = new GridFS(mongoTemplate.getDb(), "image");
		logger.info("ProductDAOMongo delete  Image by Name  : "  + name);
		gfsPhoto.remove(gfsPhoto.findOne(fileName));

	}

	@Override
	public List<Product> getProductByProductStateId(String id, String status) {
		// TODO Auto-generated method stub
		Query searchProductQueryByProductState = new Query(Criteria
				.where("productStateId").is(id).and("status").is(status));
		logger.info("ProductDAOMongo get  product by ProductStateId : "  + id);
		return mongoTemplate.find(searchProductQueryByProductState,
				Product.class, COLLECTION_NAME);
	}

	@Override
	public List<Product> searchProductByName(String name, String status) {
		// TODO Auto-generated method stub
		Query searchProductQueryByProductState = new Query(Criteria
				.where("name").regex(".*" + name + "*.", "i").and("status")
				.is(status));
		logger.info("ProductDAOMongo search  product by name : "  + name);
		return mongoTemplate.find(searchProductQueryByProductState,
				Product.class, COLLECTION_NAME);
	}

	@Override
	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
		Query searchProductQueryByName = new Query(Criteria.where("name").is(
				name));
		logger.info("ProductDAOMongo get  product by name : "  + name);
		return mongoTemplate.findOne(searchProductQueryByName, Product.class,
				COLLECTION_NAME);
	}

	@Override
	public void activeProduct(String id) {
		Product product = getProductById(id);
		product.setStatus(STATUS.ACTIVE.getStatusCode());
		logger.info("ProductDAOMongo active  product by Id : "  + id);
		mongoTemplate.save(product, COLLECTION_NAME);

	}
}
