package co.hcmus.models;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class ProductState {

	@Id
	private String id;		//id of productState
	private String name;	// name of productstate
	private String status;	// status
	
	public ProductState(String name, String status )
	{
		this.name = name;
		this.status = status;
	}
	
	public ProductState()
	{
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
