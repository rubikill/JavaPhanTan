package co.hcmus.services;

import java.util.List;

import co.hcmus.models.History;

public interface HistoryService {
	public void addHistory(History history);

	public void updateHistory(History history);

	public History getHistory(int id);

	public void deleteHistory(int id);

	public List<History> getHistorys();

}
