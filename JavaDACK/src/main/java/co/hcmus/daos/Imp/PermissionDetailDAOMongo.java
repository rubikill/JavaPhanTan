package co.hcmus.daos.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IPermissionDetailDAO;
import co.hcmus.models.Account;
import co.hcmus.models.PermissionDetail;
import co.hcmus.util.STATUS;

@Repository("permissionDetailDAO")
@Transactional
public class PermissionDetailDAOMongo implements IPermissionDetailDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	// Collection name save in MongoDB
	public static final String COLLECTION_NAME = "permissionDetail";

	// Add PermissionDetail
	@Override
	public void addPermissionDetail(PermissionDetail permissionDetail) {
		if (!mongoTemplate.collectionExists(Account.class)) {
			mongoTemplate.createCollection(Account.class);
		}
		mongoTemplate.insert(permissionDetail, COLLECTION_NAME);

	}

	// update PermissionDetail
	@Override
	public void updatePermissionDetail(PermissionDetail permissionDetail) {
		mongoTemplate.save(permissionDetail, COLLECTION_NAME);

	}

	// Get PermissionDetail
	@Override
	public PermissionDetail getPermissionDetail(String id) {
		Query searchPermissionDetailQuery = new Query(Criteria.where("_id").is(
				id));
		return mongoTemplate.findOne(searchPermissionDetailQuery,
				PermissionDetail.class, COLLECTION_NAME);
	}

	// Delete PermissionDetail
	@Override
	public void deletePermissionDetail(String id) {
		PermissionDetail permissionDetail = getPermissionDetail(id);
		permissionDetail.setStatus(STATUS.INACTIVE.getStatusCode());
		mongoTemplate.save(permissionDetail, COLLECTION_NAME);

	}

	// Get all permissionDetail
	@Override
	public List<PermissionDetail> getPermissionDetails() {
		return mongoTemplate.findAll(PermissionDetail.class, COLLECTION_NAME);
	}

	@Override
	public List<PermissionDetail> getPermissionDetailByPermissionId(String id,
			String status) {
		Query searchPermissionDetailByPermissionIdQuery = new Query(Criteria
				.where("permissionId").is(id).and("status").is(status));
		return mongoTemplate.find(searchPermissionDetailByPermissionIdQuery,
				PermissionDetail.class, COLLECTION_NAME);
	}

	@Override
	public List<PermissionDetail> getPermissionDetailByAccountTypeId(String id,
			String status) {
		// TODO Auto-generated method stub
		Query searchPermissionDetailByAccountTypeIdQuery = new Query(Criteria
				.where("accountTypeId").is(id).and("status").is(status));
		return mongoTemplate.find(searchPermissionDetailByAccountTypeIdQuery,
				PermissionDetail.class, COLLECTION_NAME);
	}

}
