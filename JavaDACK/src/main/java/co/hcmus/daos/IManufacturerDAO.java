package co.hcmus.daos;

import java.util.List;
import co.hcmus.models.Manufacturer;

/**
 * Interface of Manufacture
 * 
 * @author Thanh Toan
 * 
 */
public interface IManufacturerDAO {

	/**
	 * 
	 * @param manufacturer
	 */
	public void addManufacturer(Manufacturer manufacturer);

	/**
	 * 
	 * @param manufacturer
	 */
	public void updateManufacturer(Manufacturer manufacturer);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Manufacturer getManufacturerById(String id);

	/**
	 * 
	 * @param id
	 */
	public void deleteManufacturer(String id);

	/**
	 * 
	 * @return
	 */
	public List<Manufacturer> getManufacturers();
}
