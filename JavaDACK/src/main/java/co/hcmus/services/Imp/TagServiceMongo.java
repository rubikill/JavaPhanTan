package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.ITagDAO;
import co.hcmus.models.Tag;
import co.hcmus.services.ITagService;

@Service("tagService")
@Transactional
public class TagServiceMongo implements ITagService {
	@Autowired
	private ITagDAO tagDAO;

	@Override
	public void addTag(Tag tag) {
		// TODO Auto-generated method stub
		tagDAO.addTag(tag);
	}

	@Override
	public void updateTag(Tag tag) {
		// TODO Auto-generated method stub
		tagDAO.updateTag(tag);
	}

	@Override
	public Tag getTagById(String id) {
		// TODO Auto-generated method stub
		return tagDAO.getTagById(id);
	}

	@Override
	public void deleteTag(String id) {
		tagDAO.deleteTag(id);

	}

	@Override
	public List<Tag> getTags() {
		// TODO Auto-generated method stub
		return tagDAO.getTags();
	}

}
