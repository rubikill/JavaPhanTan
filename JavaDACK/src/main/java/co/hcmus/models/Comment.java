package co.hcmus.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comment {

	@Id
	private String id;				// Id
	private String email;			// Commenter's email
	private String productId;		// Id of product which is commented
	private String idCommentRoot;	// If of root (parent) comment, if this comment reply a comment , if it = -1 , it root comment 
	private String content;			// Comment's content
	private String status;

	public Comment(String id, String email, String productId,
			String idCommentRoot, String content, String status) {
		super();
		this.id = id;
		this.email = email;
		this.productId = productId;
		this.idCommentRoot = idCommentRoot;
		this.content = content;
		this.status = status;
	}
	
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}
