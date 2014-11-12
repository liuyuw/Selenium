package com.arrow.swb.selenium.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SWBTest {
	private WebDriver driver = null;
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public SWBTest(String instance){
		//Default for IE
		SWBUtil.loadWebDriver("IE");
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		SWBUtil.login(driver, instance);
	}
	/**
	 * Now only support IE and Firefox
	 * @param instance
	 * @param browser: IE, FF
	 */
	public SWBTest(String instance, String browser){
		//Default for IE
		if("IE".equals(browser)){
			SWBUtil.loadWebDriver("IE");
			driver = new InternetExplorerDriver();
		}else if("FF".equals(browser)){
			driver = new FirefoxDriver();

		}else if("CH".equals(browser)){
			SWBUtil.loadWebDriver("CH");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		SWBUtil.login(driver, instance);
	}
	
}
