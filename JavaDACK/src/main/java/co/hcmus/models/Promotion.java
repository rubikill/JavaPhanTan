package co.hcmus.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Promotion
 * 
 * @author Thanh Toan
 * 
 */
@Document
public class Promotion {

	@Id
	private String id; // promotion id
	private String name; // name of promotion
	private Date date_start; // day start of promotion
	private Date date_end; // day end of promotion
	private String content; // content
	private String note; // note
	private String tagId; // to tag id
	private String status; // status

	/**
	 * 
	 */
	public Promotion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param date_start
	 * @param date_end
	 * @param content
	 * @param note
	 * @param tagId
	 * @param status
	 */
	public Promotion(String name, Date date_start, Date date_end,
			String content, String note, String tagId, String status) {
		super();
		this.name = name;
		this.date_start = date_start;
		this.date_end = date_end;
		this.content = content;
		this.note = note;
		this.tagId = tagId;
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the date_start
	 */
	public Date getDate_start() {
		return date_start;
	}

	/**
	 * @param date_start
	 *            the date_start to set
	 */
	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}

	/**
	 * @return the date_end
	 */
	public Date getDate_end() {
		return date_end;
	}

	/**
	 * @param date_end
	 *            the date_end to set
	 */
	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the tagId
	 */
	public String getTagId() {
		return tagId;
	}

	/**
	 * @param tagId
	 *            the tagId to set
	 */
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
