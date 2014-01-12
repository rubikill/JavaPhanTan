package co.hcmus.shopcamera.data.dao;

import java.util.List;

import co.hcmus.shopcamera.data.model.Tag;

/**
 * 
 * @author Thanh Toan
 * 
 */
public interface ITagDAO {
	/**
	 * 
	 * @param tag
	 */
	public void addTag(Tag tag);

	/**
	 * 
	 * @param tag
	 */
	public void updateTag(Tag tag);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Tag getTagById(String id);

	/**
	 * 
	 * @param id
	 */
	public void deleteTag(String id);

	/**
	 * 
	 * @return
	 */
	public List<Tag> getTags();
}
