package com.phillippascual.publisher;

import javax.xml.ws.Endpoint;

import com.phillippascual.service.StockPriceWS;

public class Publisher {
	
	/**
	 * The main() method publishes the WSDL to the appropriate address and instantiates an instance of the
	 * WebService Class that the WSDL governs.
	 */
	public static void main(String[] args) {
		System.out.println("SOAP Server started!");
		Endpoint.publish("http://localhost:8090/stockpriceservice", new StockPriceWS());
	}
}
