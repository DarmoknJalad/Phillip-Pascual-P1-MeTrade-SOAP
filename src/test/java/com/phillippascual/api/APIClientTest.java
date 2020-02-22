package com.phillippascual.api;

import org.junit.Test;

public class APIClientTest {

	@Test
	public void retrieveStockPriceTest_returnsFalse() {
		String testTicker = "MSFT";
		double response = APIClient.retrieveStockPrice(testTicker);
		System.out.println(response);
		assert(response > 0);
	}

}
