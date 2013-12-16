package co.hcmus.services.Imp;

import java.util.List;


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
	@Autowired
	private IManufacturerDAO manufacturerDAO;
	@Autowired
	private IProductService productService;

	@Override
	public void addManufacturer(Manufacturer manufacturer) {
		// TODO Auto-generated method stub
		manufacturerDAO.addManufacturer(manufacturer);
	}

	@Override
	public void updateManufacturer(Manufacturer manufacturer) {
		// TODO Auto-generated method stub
		manufacturerDAO.updateManufacturer(manufacturer);
	}

	@Override
	public Manufacturer getManufacturerById(String id) {
		// TODO Auto-generated method stub
		return manufacturerDAO.getManufacturerById(id);
	}

	@Override
	public void deleteManufacturer(String id) {
		// TODO Auto-generated method stub
		List<Product> listProduct = productService.getProductsByManufacturerId(id,
				STATUS.ACTIVE.getStatusCode());
		for(Product product : listProduct)
			productService.deleteProduct(product.getId());
		manufacturerDAO.deleteManufacturer(id);
	}

	@Override
	public List<Manufacturer> getManufacturers() {
		// TODO Auto-generated method stub
		return manufacturerDAO.getManufacturers();
	}

}
