package co.hcmus.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Tag {

	@Id
	private String id; // id tag
	private String name; // name tag
	private String status; // status

	public Tag(String id, String name, String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public Tag() {

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
