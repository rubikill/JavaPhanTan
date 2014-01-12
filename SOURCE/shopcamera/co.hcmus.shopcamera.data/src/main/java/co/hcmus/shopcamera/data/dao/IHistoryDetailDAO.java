package co.hcmus.shopcamera.data.dao;

import java.util.List;

import co.hcmus.shopcamera.data.model.HistoryDetail;

/**
 * Interface of history details DAO
 * 
 * @author Thanh Toan
 * 
 */
public interface IHistoryDetailDAO {
	/**
	 * create
	 * 
	 * @param historyDetail
	 */
	public void addHistoryDetail(HistoryDetail historyDetail);

	/**
	 * update
	 * 
	 * @param historyDetail
	 */
	public void updateHistoryDetail(HistoryDetail historyDetail);

	/**
	 * get by id
	 * 
	 * @param id
	 * @return
	 */
	public HistoryDetail getHistoryDetailById(String id);

	/**
	 * get by history details
	 * 
	 * @param id
	 */
	public void deleteHistoryDetail(String id);

	/**
	 * 
	 * @return
	 */
	public List<HistoryDetail> getHistoryDetails();

	/**
	 * get by history id
	 * 
	 * @param historyId
	 * @param status
	 * @return
	 */
	public List<HistoryDetail> getHistoryDetailByHistoryId(String historyId,
			String status);

	/**
	 * get by product id
	 * 
	 * @param productId
	 * @param status
	 * @return
	 */
	public List<HistoryDetail> getHistoryDetailByProductId(String productId,
			String status);
}
