package co.hcmus.shopcamera.data.dao;

import java.util.List;

import co.hcmus.shopcamera.data.model.History;

/**
 * Iterface for history DAO
 * 
 * @author Thanh Toan
 * 
 */
public interface IHistoryDAO {
	/**
	 * Create
	 * 
	 * @param history
	 */
	public void addHistory(History history);

	/**
	 * Update
	 * 
	 * @param history
	 */
	public void updateHistory(History history);

	/**
	 * Get
	 * 
	 * @param id
	 * @return
	 */
	public History getHistory(String id);

	/**
	 * Delete
	 * 
	 * @param id
	 */
	public void deleteHistory(String id);

	/**
	 * Get all
	 * 
	 * @return
	 */
	public List<History> getHistorys();

	/**
	 * Get by email
	 * 
	 * @param email
	 * @return
	 */
	public List<History> getHistorysByEmail(String email);
}
