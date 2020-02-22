package com.phillippascual.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class APIClient {
	public static double retrieveStockPrice(String ticker) {
		System.setProperty("http.agent", "Chrome");
		try {
			URL url = new URL("http://localhost:8082/stockpriceservice?ticker=" + ticker);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Content-Type", "text/xml");
			InputStream input = conn.getInputStream();
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(input);
			String output = "";
			while (scan.hasNext()) {
				output += scan.nextLine();
			}
			
			JSONObject fullJson = new JSONObject(output);
			JSONObject timeSeries = fullJson.getJSONObject("Time Series (5min)");
			JSONObject metaData = fullJson.getJSONObject("Meta Data");
			
			String lastUpdate = metaData.getString("3. Last Refreshed");
			Iterator<String> iterator = timeSeries.keys();
			
			while (iterator.hasNext()) {
				String timeAndDate = iterator.next().toString();
				if (timeAndDate.equals(lastUpdate)) {
					JSONObject latest = timeSeries.getJSONObject(timeAndDate);
					return latest.getDouble("4. close");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
