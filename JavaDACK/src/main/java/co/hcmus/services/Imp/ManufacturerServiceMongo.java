package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IManufacturerDAO;
import co.hcmus.models.Manufacturer;
import co.hcmus.services.IManufacturerService;

@Service("manufacturerService")
@Transactional
public class ManufacturerServiceMongo implements IManufacturerService {

	private IManufacturerDAO manufacturerDAO;

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

	}

	@Override
	public List<Manufacturer> getManufacturers() {
		// TODO Auto-generated method stub
		return manufacturerDAO.getManufacturers();
	}

}
