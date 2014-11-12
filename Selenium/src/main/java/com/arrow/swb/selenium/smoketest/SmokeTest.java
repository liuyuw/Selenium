package com.arrow.swb.selenium.smoketest;

import com.arrow.swb.selenium.order.SWBOrderTest;
import com.arrow.swb.selenium.quote.SWBQuoteTest;

public class SmokeTest {

	public SmokeTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SWBOrderTest orderTest = new SWBOrderTest("CMPQA-EU", "FF");
		//Create Order
		orderTest.createOrderHeader();
		orderTest.createOrderLine();
		orderTest.copyOrder();
		
		SWBQuoteTest quoteTest = new SWBQuoteTest("CMPQA-EU", "FF");
		quoteTest.createQuoteHeader();
		quoteTest.createQuoteLine();
		quoteTest.copyQuote();
	}

}
