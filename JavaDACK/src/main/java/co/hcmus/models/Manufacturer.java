package co.hcmus.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Manufacturer {

	@Id
	private String id; // id of manufacturer
	private String name; // name of manufacturer
	
	public Manufacturer(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Manufacturer() {

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

}
