package co.hcmus.services;

import java.util.List;

import co.hcmus.models.HistoryDetail;

/**
 * 
 * @author Thanh Toan
 * 
 */
public interface IHistoryDetailService {
	/**
	 * 
	 * @param historyDetail
	 */
	public void addHistoryDetail(HistoryDetail historyDetail);

	/**
	 * 
	 * @param historyDetail
	 */
	public void updateHistoryDetail(HistoryDetail historyDetail);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public HistoryDetail getHistoryDetailById(String id);

	/**
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
	 * 
	 * @param historyId
	 * @param status
	 * @return
	 */
	public List<HistoryDetail> getHistoryDetailByHistoryId(String historyId,
			String status);

	/**
	 * 
	 * @param productId
	 * @param status
	 * @return
	 */
	public List<HistoryDetail> getHistoryDetailByProductId(String productId,
			String status);
}
