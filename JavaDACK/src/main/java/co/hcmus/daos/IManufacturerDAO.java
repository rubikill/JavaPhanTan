package co.hcmus.daos;

import java.util.List;
import co.hcmus.models.Manufacturer;

public interface IManufacturerDAO {
	public void addManufacturer(Manufacturer manufacturer);
	public void updateManufacturer(Manufacturer manufacturer);
	public Manufacturer getManufacturerById(String id);
	public void deleteManufacturer(String id);
	public List<Manufacturer> getManufacturers();
}
