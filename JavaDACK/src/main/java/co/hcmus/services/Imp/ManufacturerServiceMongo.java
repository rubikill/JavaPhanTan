package co.hcmus.services.Imp;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IManufacturerDAO;
import co.hcmus.models.Manufacturer;
import co.hcmus.models.Product;
import co.hcmus.services.IManufacturerService;
import co.hcmus.services.IProductService;
import co.hcmus.util.STATUS;

@Service("manufacturerService")
@Transactional
public class ManufacturerServiceMongo implements IManufacturerService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ManufacturerServiceMongo.class);
	
	@Autowired
	private IManufacturerDAO manufacturerDAO;
	@Autowired
	private IProductService productService;

	@Override
	public void addManufacturer(Manufacturer manufacturer) {
		// TODO Auto-generated method stub
		logger.info("ManufacturerServiceMongo add manufacturer with name : " + manufacturer.getName());
		manufacturerDAO.addManufacturer(manufacturer);
	}

	@Override
	public void updateManufacturer(Manufacturer manufacturer) {
		// TODO Auto-generated method stub
		logger.info("ManufacturerServiceMongo update manufacturer with id : " + manufacturer.getId());
		manufacturerDAO.updateManufacturer(manufacturer);
	}

	@Override
	public Manufacturer getManufacturerById(String id) {
		// TODO Auto-generated method stub
		logger.info("ManufacturerServiceMongo get manufacturer with id : " + id);
		return manufacturerDAO.getManufacturerById(id);
	}

	@Override
	public void deleteManufacturer(String id) {
		// TODO Auto-generated method stub
		List<Product> listProduct = productService.getProductsByManufacturerId(id,
				STATUS.ACTIVE.getStatusCode());
		for(Product product : listProduct)
			productService.deleteProduct(product.getId());
		logger.info("ManufacturerServiceMongo delete manufacturer with Id : " + id);
		manufacturerDAO.deleteManufacturer(id);
	}

	@Override
	public List<Manufacturer> getManufacturers() {
		// TODO Auto-generated method stub
		logger.info("ManufacturerServiceMongo get all Manufacturers");
		return manufacturerDAO.getManufacturers();
	}

}
