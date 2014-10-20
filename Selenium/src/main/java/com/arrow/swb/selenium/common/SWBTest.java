package com.arrow.swb.selenium.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SWBTest {
	WebDriver driver = null;
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public SWBTest(String instance){
		//Default for IE
		SWBUtil.loadWebDriver();
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SWBUtil.login(driver, instance);
	}
	
}
