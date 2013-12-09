package co.hcmus.services;

import java.util.List;

import co.hcmus.models.HistoryDetail;

public interface IHistoryDetailService {
	public void addHistoryDetail(HistoryDetail historyDetail);

	public void updateHistoryDetail(HistoryDetail historyDetail);

	public HistoryDetail getHistoryDetailById(String id);

	public void deleteHistoryDetail(String id);

	public List<HistoryDetail> getHistoryDetails();
}
