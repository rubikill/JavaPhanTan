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
	public static final String COLLECTION_NAME = "Permission";

	@Override
	public void addPermission(Permission Permission) {
		if (!mongoTemplate.collectionExists(Account.class)) {
			mongoTemplate.createCollection(Account.class);
		}
		mongoTemplate.insert(Permission, COLLECTION_NAME);

	}

	@Override
	public void updatePermission(Permission Permission) {
		mongoTemplate.insert(Permission, COLLECTION_NAME);

	}

	@Override
	public Permission getPermission(String id) {
		Query searchPermissionQuery = new Query(Criteria.where("id").is(id));
		return mongoTemplate.findOne(searchPermissionQuery, Permission.class,
				COLLECTION_NAME);
	}

	@Override
	public void deletePermission(String id) {
		Permission Permission = getPermission(id);
		mongoTemplate.remove(Permission, COLLECTION_NAME);

	}

	@Override
	public List<Permission> getPermissions() {
		return mongoTemplate.findAll(Permission.class, COLLECTION_NAME);
	}

}
