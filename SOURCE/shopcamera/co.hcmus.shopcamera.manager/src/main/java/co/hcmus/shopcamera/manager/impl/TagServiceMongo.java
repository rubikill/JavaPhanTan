package co.hcmus.shopcamera.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.shopcamera.data.dao.ITagDAO;
import co.hcmus.shopcamera.data.model.Tag;
import co.hcmus.shopcamera.manager.ITagService;

@Service("tagService")
@Transactional
public class TagServiceMongo implements ITagService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(TagServiceMongo.class);
	
	@Autowired
	private ITagDAO tagDAO;

	@Override
	public void addTag(Tag tag) {
		// TODO Auto-generated method stub
		logger.info("tagServiceMongo add tag with Name : " + tag.getName());
		tagDAO.addTag(tag);
	}

	@Override
	public void updateTag(Tag tag) {
		// TODO Auto-generated method stub
		logger.info("tagServiceMongo update tag with Id : " + tag.getId());
		tagDAO.updateTag(tag);
	}

	@Override
	public Tag getTagById(String id) {
		// TODO Auto-generated method stub
		logger.info("tagServiceMongo get tag with Id : " + id);
		return tagDAO.getTagById(id);
	}

	@Override
	public void deleteTag(String id) {
		logger.info("tagServiceMongo delete tag with Id : " + id);
		tagDAO.deleteTag(id);

	}

	@Override
	public List<Tag> getTags() {
		// TODO Auto-generated method stub
		logger.info("tagServiceMongo get all Tag");
		return tagDAO.getTags();
	}

}
