package com.phillippascual.api;

import static org.junit.Assert.*;

import org.junit.Test;

public class APIClientTest {

	@Test
	public void retrieveStockPriceTest_returnsFalse() {
		String testTicker = "MSFT";
		String response = APIClient.retrieveStockPrice(testTicker);
		System.out.println(response);
		assertEquals(response.isEmpty(), false);
	}

}
