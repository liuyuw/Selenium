package com.arrow.swb.selenium.order.cmpqaeu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.arrow.swb.selenium.common.SWBTest;

public class SWBOrderTest extends SWBTest {

	public SWBOrderTest(String instance) {
		super(instance);
		// TODO Auto-generated constructor stub
	}

	public SWBOrderTest(String instance, String browser) {
		super(instance, browser);
		// TODO Auto-generated constructor stub
	}

	public void createOrderHeader(){
		//Click New Order button
		this.getDriver().findElement(By.id("ext-gen39")).click();
		//switch to the New Order Frame
		WebElement iframe = this.getDriver().findElement(By.xpath("//iframe[contains(@src, 'order')]"));
		this.getDriver().switchTo().frame(iframe);
		//Type Customer Name
		this.getDriver().findElement(By.id("custNameSearch")).sendKeys("BMW");
		
		//Select the first one from the list
		this.getDriver().findElement(By.xpath("//div[@class='x-combo-list-inner']/table/tbody/tr/td[1]")).click();
		//Wait for 2s so that Save button can be clicked
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Click Save
		this.getDriver().findElement(By.xpath("//button[@id='ext-gen40']"));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SWBOrderTest orderTest = new SWBOrderTest("CMPQA-EU", "FF");
		//Create Order
		orderTest.createOrderHeader();
	}

}
