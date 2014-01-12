package co.hcmus.shopcamera.data.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.shopcamera.data.dao.IManufacturerDAO;
import co.hcmus.shopcamera.data.model.Manufacturer;
import co.hcmus.shopcamera.utility.STATUS;

@Repository("manufacturerDAO")
@Transactional
public class ManufacturerDAOMongo implements IManufacturerDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(ManufacturerDAOMongo.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "manufacturer";

	@Override
	public void addManufacturer(Manufacturer manufacturer) {
		if (!mongoTemplate.collectionExists(Manufacturer.class)) {
			mongoTemplate.createCollection(Manufacturer.class);
		}
		// insert a document
		logger.info("ManufacturerDAOMongo add Manufacturer");
		mongoTemplate.insert(manufacturer, COLLECTION_NAME);

	}

	@Override
	public void updateManufacturer(Manufacturer manufacturer) {
		// update a document
		logger.info("ManufacturerDAOMongo update Manufacturer with Id : " + manufacturer.getId());
		mongoTemplate.save(manufacturer, COLLECTION_NAME);

	}

	@Override
	public Manufacturer getManufacturerById(String id) {
		Query searchManufaturerQuery = new Query(Criteria.where("_id").is(id));
		logger.info("ManufacturerDAOMongo get Manufacturer with Id : " + id);
		return mongoTemplate.findOne(searchManufaturerQuery,
				Manufacturer.class, COLLECTION_NAME);
	}

	@Override
	public void deleteManufacturer(String id) {
		// TODO Auto-generated method stub
		Manufacturer manufacturer = getManufacturerById(id);
		manufacturer.setStatus(STATUS.INACTIVE.getStatusCode());
		logger.info("ManufacturerDAOMongo delete Manufacturer with Id : " + id);
		mongoTemplate.save(manufacturer, COLLECTION_NAME);
	}

	@Override
	public List<Manufacturer> getManufacturers() {
		// get all docuemnt
		logger.info("ManufacturerDAOMongo get all Manufacturer");
		return mongoTemplate.findAll(Manufacturer.class, COLLECTION_NAME);
	}

}
