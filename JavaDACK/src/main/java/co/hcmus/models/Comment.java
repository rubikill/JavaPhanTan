package co.hcmus.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comment {

	@Id
	private String id;
	private String email;
	private String productId;
	private String idCommentRoot;
	private String content;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductID(String productId) {
		this.productId = productId;
	}
	
	public String getIdCommentRoot() {
		return idCommentRoot;
	}
	public void setIdCommentRoot(String idCommentRoot) {
		this.idCommentRoot = idCommentRoot;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
