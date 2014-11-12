package com.arrow.swb.selenium.common;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SWBUtil {
	/**
	 * For IE/Chrome, we need load webdriver, for Firefox, we can ignore this
	 */
	public static void loadWebDriver(String browser) {
		File file = null;
		if("IE".equals(browser)){
			file = new File("C:/Selenium/IEDriverServer_32.exe");
		}else if ("CH".equals(browser)){
			file = new File("D:/Selenium/chromedriver.exe");
		}
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	}

	/**
	 * Login the SWB for specific instances This method is without username and
	 * pwd, give these value hardcoded
	 * 
	 * @param driver
	 * @param instance
	 */
	public static void login(WebDriver driver, String instance) {
		String link = "";
		String username = "";
		String password = "";
		if (instance.equals("CMPQA-EU")) {
			link = "http://qaswb.arrow.com";
			username = "z02668";
			password = "arrow123";
		}

		driver.navigate().to(link);

		// Find the username and password field
		WebElement usernameText = driver.findElement(By.name("ssousername"));
		WebElement passwordText = driver.findElement(By.name("password"));

		// Give the username and password
		usernameText.sendKeys(username);
		passwordText.sendKeys(password);

		// Submit and login
		passwordText.submit();

		// Choose responsibility
		Select resp = new Select(
				driver.findElement(By.name("responsibilityId")));
		resp.selectByVisibleText("ARW IT Sales Work Bench PM User");
		// Choose OU
		Select ou = new Select(driver.findElement(By.name("organizationId")));
		ou.selectByVisibleText("ARROW GERMANY");
		// Submit and go to SWB
		WebElement pickForm = driver.findElement(By.name("pickForm"));
		pickForm.submit();

	}

	/**
	 * Login the SWB for specific instances This method is without username and
	 * pwd, give these value hardcoded
	 * 
	 * @param driver
	 * @param instance
	 */
	public static void login(WebDriver driver, String instance,
			String username, String password) {
		String link = "";
		if (username == null || password == null) {
			System.out.println("Need username and password");
			return;
		} else {

			if (instance.equals("CMPQA-EU")) {
				link = "http://qaswb.arrow.com";
			}

			driver.navigate().to(link);

			// Find the username and password field
			WebElement usernameText = driver
					.findElement(By.name("ssousername"));
			WebElement passwordText = driver.findElement(By.name("password"));

			// Give the username and password
			usernameText.sendKeys(username);
			passwordText.sendKeys(password);

			// Submit and login
			passwordText.submit();

			// Choose responsibility
			Select resp = new Select(driver.findElement(By
					.name("responsibilityId")));
			resp.selectByVisibleText("ARW IT Sales Work Bench PM User");
			// Choose OU
			Select ou = new Select(
					driver.findElement(By.name("organizationId")));
			ou.selectByVisibleText("ARROW GERMANY");
			// Submit and go to SWB
			WebElement pickForm = driver.findElement(By.name("pickForm"));
			pickForm.submit();
		}

	}

}
