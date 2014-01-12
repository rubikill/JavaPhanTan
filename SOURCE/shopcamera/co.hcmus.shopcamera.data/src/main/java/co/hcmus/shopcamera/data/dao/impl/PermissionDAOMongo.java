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

import co.hcmus.shopcamera.data.dao.IPermissionDAO;
import co.hcmus.shopcamera.data.model.Account;
import co.hcmus.shopcamera.data.model.Permission;
import co.hcmus.shopcamera.utility.STATUS;

@Repository("PermissionDAO")
@Transactional
public class PermissionDAOMongo implements IPermissionDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(PermissionDAOMongo.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "permission";

	// Add new Permission
	@Override
	public void addPermission(Permission permission) {
		if (!mongoTemplate.collectionExists(Account.class)) {
			mongoTemplate.createCollection(Account.class);
		}
		logger.info("PermissionDAOMongo add Permission with Name : " + permission.getName());
		mongoTemplate.insert(permission, COLLECTION_NAME);

	}

	// Update Permission
	@Override
	public void updatePermission(Permission permission) {
		logger.info("PermissionDAOMongo update Permission with Id : " + permission.getId());
		mongoTemplate.save(permission, COLLECTION_NAME);

	}

	// Get a specific Permission
	@Override
	public Permission getPermission(String id) {
		Query searchPermissionQuery = new Query(Criteria.where("_id").is(id));
		logger.info("PermissionDAOMongo get Permission with Id : " + id);
		return mongoTemplate.findOne(searchPermissionQuery, Permission.class,
				COLLECTION_NAME);
	}

	// Delete a Permission
	@Override
	public void deletePermission(String id) {
		Permission permission = getPermission(id);
		permission.setStatus(STATUS.INACTIVE.getStatusCode());
		logger.info("PermissionDAOMongo delete Permission with Id : " + id);
		mongoTemplate.save(permission, COLLECTION_NAME);

	}

	// Get all Permissions
	@Override
	public List<Permission> getPermissions() {
		logger.info("PermissionDAOMongo get all Permission");
		return mongoTemplate.findAll(Permission.class, COLLECTION_NAME);
	}

}
