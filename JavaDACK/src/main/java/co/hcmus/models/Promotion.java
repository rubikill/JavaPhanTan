package co.hcmus.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Promotion {

	@Id
	private String id;  					// promotion id
	private String productId;				// productid
	
	public Promotion()
	{
		
	}
	public String getId() {	
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}
