package co.hcmus.daos;

import java.util.List;


import co.hcmus.models.HistoryDetail;
public interface IHistoryDetailDAO {
	public void addHistoryDetail(HistoryDetail historyDetail);
	public void updateHistoryDetail(HistoryDetail historyDetail);
	public HistoryDetail getHistoryDetailById(String id);
	public void deleteHistoryDetail(String id);
	public List<HistoryDetail> getHistoryDetails();
}
