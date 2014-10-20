package com.arrow.swb.selenium.common;

import java.io.File;

import org.openqa.selenium.WebDriver;

public class SWBUtil {
	public static void loadWebDriver(){
    	File file = new File("C:/Selenium/IEDriverServer_32.exe");
    	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	}
	public static void login(WebDriver driver, String instance){
		String link = "";
		if(instance.equals("CMPQA-EU")){
			link = "http://qaswb.arrow.com";
			
		}
	}
	
	
}
