package co.hcmus.services;

import java.util.List;

import co.hcmus.models.Tag;

public interface ITagService {
	public void addTag(Tag tag);

	public void updateTag(Tag tag);

	public Tag getTagById(String id);

	public void deleteTag(String id);

	public List<Tag> getTags();
}
