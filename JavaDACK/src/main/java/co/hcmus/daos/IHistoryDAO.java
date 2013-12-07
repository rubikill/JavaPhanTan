package co.hcmus.daos;

import java.util.List;

import co.hcmus.models.History;

public interface IHistoryDAO {
	public void addHistory(History history);
	public void updateHistory(History history);
	public History getHistory(String id);
	public void deleteHistory(String id);
	public List<History> getHistorys();
	
}
