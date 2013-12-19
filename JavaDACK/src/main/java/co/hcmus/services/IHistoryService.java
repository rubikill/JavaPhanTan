package co.hcmus.services;

import java.util.List;

import co.hcmus.models.History;

/**
 * 
 * @author Thanh Toan
 * 
 */
public interface IHistoryService {
	/**
	 * 
	 * @param history
	 */
	public void addHistory(History history);

	/**
	 * 
	 * @param history
	 */
	public void updateHistory(History history);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public History getHistory(String id);

	/**
	 * 
	 * @param id
	 */
	public void deleteHistory(String id);

	/**
	 * 
	 * @return
	 */
	public List<History> getHistorys();

	/**
	 * 
	 * @param email
	 * @return
	 */
	public List<History> getHistorysByEmail(String email);

}
