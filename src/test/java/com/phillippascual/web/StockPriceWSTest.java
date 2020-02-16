package com.phillippascual.web;

import static org.junit.Assert.*;

import org.junit.Test;

public class StockPriceWSTest {

	@Test
	public void retrieveStockPriceTest_returnsFalse() {
		String testTicker = "MSFT";
		assertEquals(StockPriceWS.retrieveStockPrice(testTicker).isEmpty(), false);
	}

}
