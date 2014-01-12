package co.hcmus.shopcamera.manager;

import java.util.List;

import co.hcmus.shopcamera.data.model.Manufacturer;

/**
 * 
 * @author Thanh Toan
 * 
 */
public interface IManufacturerService {
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
