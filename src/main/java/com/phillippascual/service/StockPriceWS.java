package com.phillippascual.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.phillippascual.api.APIClient;

@WebService
public class StockPriceWS {
	
	/**
	 * The getStockPrice() method takes in a String, and then passes that String parameter to the APIClient Class's
	 * retrieveStockPrice() method.  That method returns a double, which the getStockPrice() method ultimately returns
	 * to the calling application.
	 */
	@WebMethod
	public double getStockPrice(String ticker) {
		return APIClient.retrieveStockPrice(ticker);
	}
	
}
