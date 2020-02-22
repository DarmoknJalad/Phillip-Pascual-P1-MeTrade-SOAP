package com.phillippascual.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.phillippascual.api.APIClient;

@WebService
public class StockPriceWS {
	@WebMethod
	public double getStockPrice(String ticker) {
		return APIClient.retrieveStockPrice(ticker);
	}
	
}
