package co.hcmus.services;

import java.util.List;

import co.hcmus.models.History;

public interface IHistoryService {
	public void addHistory(History history);

	public void updateHistory(History history);

	public History getHistory(String id);

	public void deleteHistory(String id);

	public List<History> getHistorys();
	public List<History> getHistorysByEmail(String email);

}
