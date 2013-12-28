package co.hcmus.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import co.hcmus.models.ExchangeRate;
/**
 * Tools for fetching data from other page (e.g exchange rate)
 * @author WindyZBoy
 *
 */
public class FetchDataFromOtherPage {
	
	/**
	 * Get exchange rate from VietcomBank web site 
	 * @return
	 */
	public static List<ExchangeRate> getExchangeRate() {
		List<ExchangeRate> news = new ArrayList<ExchangeRate>();
		Document doc;
		try {
			
			//Connect to VietcomBank web site
			doc = Jsoup.connect(
					"http://www.vietcombank.com.vn/ExchangeRates/?lang=en")
					.get();
			//Filter element
			Elements erElements = doc.select("#ctl00_Content_ExrateView")
					.select("td");

			for (int i = 0; i < erElements.size(); i+=5) {
				Element element = erElements.get(i);
				ExchangeRate exrItem = new ExchangeRate();
				exrItem.setCurencyCode(element.text());
				element = erElements.get(i+1);
				exrItem.setCurencyName(element.text());
				element = erElements.get(i+2);
				exrItem.setBuy(element.text());
				element = erElements.get(i+3);
				exrItem.setTransfer(element.text());
				element = erElements.get(i+4);
				exrItem.setSell(element.text());
				news.add(exrItem);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return news;
	}
}
