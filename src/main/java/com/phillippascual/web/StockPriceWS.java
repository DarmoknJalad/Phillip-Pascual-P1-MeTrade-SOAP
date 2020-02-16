package com.phillippascual.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class StockPriceWS {
	@WebMethod
	public static String retrieveStockPrice(String ticker) {
		System.setProperty("http.agent", "Chrome");
		try {
			URL url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=" + ticker +
					"&interval=5min&outputsize=compact&apikey=CTT7YELSGMWZLGAK");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Content-Type", "application/json");
			InputStream input = conn.getInputStream();
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(input);
			return scan.nextLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
