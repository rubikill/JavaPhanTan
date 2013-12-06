package co.hcmus.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class PromotionDetail {

	@Id
	private String id;				// promotion detail id
	private String promotionId;		// promotion id
	private String name;			// name of promotion
	private Date date_start;		// day start of promotion
	private Date date_end;			// day end of promotion
	private String content;			// content
	private String note;			// note
	private String tagId;			// to tag id
	private int discount;			// discount
	
	public PromotionDetail()
	{
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate_start() {
		return date_start;
	}
	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}
	public Date getDate_end() {
		return date_end;
	}
	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getTagId() {
		return tagId;
	}
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
}
