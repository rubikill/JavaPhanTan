package co.hcmus.services;

import java.util.List;

import co.hcmus.models.ProductState;

public interface IProductStateService {
	public void addProductState(ProductState productState);

	public void updateProductState(ProductState productState);

	public ProductState getProductStateById(String id, String status);
	
	public ProductState getProductStateByName(String name, String status);

	public void deleteProductState(String id);

	public List<ProductState> getProductStates();
}
