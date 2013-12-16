package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IManufacturerDAO;
import co.hcmus.models.Manufacturer;
import co.hcmus.util.STATUS;

@Repository("manufacturerDAO")
@Transactional
public class ManufacturerDAOMongo implements IManufacturerDAO {

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
		mongoTemplate.insert(manufacturer, COLLECTION_NAME);

	}

	@Override
	public void updateManufacturer(Manufacturer manufacturer) {
		// update a document
		mongoTemplate.save(manufacturer, COLLECTION_NAME);

	}

	@Override
	public Manufacturer getManufacturerById(String id) {
		Query searchManufaturerQuery = new Query(Criteria.where("_id").is(id));
		return mongoTemplate.findOne(searchManufaturerQuery,
				Manufacturer.class, COLLECTION_NAME);
	}

	@Override
	public void deleteManufacturer(String id) {
		// TODO Auto-generated method stub
		Manufacturer manufacturer = getManufacturerById(id);
		manufacturer.setStatus(STATUS.INACTIVE.getStatusCode());
		mongoTemplate.save(manufacturer, COLLECTION_NAME);
	}

	@Override
	public List<Manufacturer> getManufacturers() {
		// get all docuemnt
		return mongoTemplate.findAll(Manufacturer.class, COLLECTION_NAME);
	}

}
