package co.hcmus.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Manufacturer {

	@Id
	private String id; // id of manufacturer
	private String name; // name of manufacturer
	private String status; // status

	public Manufacturer(String name, String status) {
		super();
		this.name = name;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
