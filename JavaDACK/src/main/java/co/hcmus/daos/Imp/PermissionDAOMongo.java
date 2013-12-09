package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.IPermissionDAO;
import co.hcmus.models.Account;
import co.hcmus.models.Permission;

@Repository("PermissionDAO")
public class PermissionDAOMongo implements IPermissionDAO {

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
		mongoTemplate.insert(permission, COLLECTION_NAME);

	}

	// Update Permission
	@Override
	public void updatePermission(Permission permission) {
		mongoTemplate.save(permission, COLLECTION_NAME);

	}

	// Get a specific Permission
	@Override
	public Permission getPermission(String id) {
		Query searchPermissionQuery = new Query(Criteria.where("id").is(id));
		return mongoTemplate.findOne(searchPermissionQuery, Permission.class,
				COLLECTION_NAME);
	}

	// Delete a Permission
	@Override
	public void deletePermission(String id) {
		Permission permission = getPermission(id);
		mongoTemplate.remove(permission, COLLECTION_NAME);

	}

	// Get all Permissions
	@Override
	public List<Permission> getPermissions() {
		return mongoTemplate.findAll(Permission.class, COLLECTION_NAME);
	}

}
