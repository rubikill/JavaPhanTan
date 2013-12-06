package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.IPermissionDetailDAO;
import co.hcmus.models.Account;
import co.hcmus.models.PermissionDetail;

@Repository("permissionDetailDAO")
public class PermissionDetailDAOMongo implements IPermissionDetailDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	public static final String COLLECTION_NAME = "permission_detail";

	@Override
	public void addPermissionDetail(PermissionDetail permissionDetail) {
		if (!mongoTemplate.collectionExists(Account.class)) {
			mongoTemplate.createCollection(Account.class);
		}
		mongoTemplate.insert(permissionDetail, COLLECTION_NAME);

	}

	@Override
	public void updatePermissionDetail(PermissionDetail permissionDetail) {
		mongoTemplate.insert(permissionDetail, COLLECTION_NAME);

	}

	@Override
	public PermissionDetail getPermissionDetail(String id) {
		Query searchPermissionDetailQuery = new Query(Criteria.where("id").is(id));
		return mongoTemplate.findOne(searchPermissionDetailQuery, PermissionDetail.class,
				COLLECTION_NAME);
	}

	@Override
	public void deletePermissionDetail(String id) {
		PermissionDetail PermissionDetail = getPermissionDetail(id);
		mongoTemplate.remove(PermissionDetail, COLLECTION_NAME);

	}

	@Override
	public List<PermissionDetail> getPermissionDetails() {
		return mongoTemplate.findAll(PermissionDetail.class, COLLECTION_NAME);
	}
	
}
