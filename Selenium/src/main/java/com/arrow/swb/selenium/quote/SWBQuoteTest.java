package com.arrow.swb.selenium.quote;

import java.util.List;

import org.cyberneko.html.HTMLElements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.arrow.swb.selenium.common.SWBTest;

public class SWBQuoteTest extends SWBTest {
	public SWBQuoteTest(String instance) {
		super(instance);
		// TODO Auto-generated constructor stub
	}

	public SWBQuoteTest(String instance, String browser) {
		super(instance, browser);
		// TODO Auto-generated constructor stub
	}

	public void createQuoteHeader() {
		// Click New Quote button
		this.getDriver().findElement(By.id("ext-gen31")).click();
		// switch to the New Quote Frame
		WebElement iframe = this.getDriver().findElement(
				By.xpath("//iframe[contains(@src, 'quote')]"));
		this.getDriver().switchTo().frame(iframe);
		// choose quote type
		List<WebElement> types = this.getDriver()
				.findElements(By.tagName("li"));
		for (int i = 0; i < types.size(); i++) {
			if (types.get(i).getText().contains("Costing")) {
				types.get(i).click();
			}
		}

		// Type Customer Name
		this.getDriver().findElement(By.name("customerName")).sendKeys("BMW");
		// Select the first one from the list
		this.getDriver()
				.findElement(
						By.xpath("//div[@class='x-boundlist-list-ct x-unselectable']/table/tbody/tr/td[1]"))
				.click();
		// Save
		try {
			this.getDriver()
					.findElement(
							By.xpath("//span[@id='button-1019-btnInnerEl']"))
					.click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createQuoteLine() {
		// Click Add New button to add new line
		this.getDriver()
				.findElement(
						By.xpath("//div[@id='quote-summary-toolbar-targetEl']/a/span/span/span"))
				.click();
		// Put Quantity
		this.getDriver()
				.findElement(
						By.xpath("//div[@id='quote-line-summary-grid-body']/div/div[1]/table/tbody/tr/td[2]/table/tbody/tr/td/input"))
				.sendKeys("3000");
		this.getDriver()
				.findElement(
						By.xpath("//div[@id='quote-line-summary-grid-body']/div/div[1]/table/tbody/tr/td[2]/table/tbody/tr/td/input"))
				.sendKeys(Keys.TAB);

		// Put item
		this.getDriver()
				.findElement(
						By.xpath("//div[@id='quote-line-summary-grid-body']/div/div[2]/table/tbody/tr/td[2]/input"))
				.sendKeys("BAV99;215");
		this.getDriver()
				.findElement(
						By.xpath("//div[@id='quote-line-summary-grid-body']/div/div[2]/table/tbody/tr/td[2]/input"))
				.sendKeys(Keys.TAB);

		// Switch to part search iframe
		WebElement psiFrame = this.getDriver().findElement(
				By.id("partSearchId"));
		this.getDriver().switchTo().frame(psiFrame);
		// Select the first one part
		this.getDriver().findElement(By.id("partSelectionIcon-0"))
				.findElement(By.xpath("img")).click();

		this.getDriver().switchTo().defaultContent();

	}

	public void copyQuote() {
		// switch to the base iframe
		WebElement iframe = this.getDriver().findElement(
				By.xpath("//iframe[contains(@src, 'quote')]"));
		this.getDriver().switchTo().frame(iframe);
		// sleep for 10s
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Click Copy
		this.getDriver()
				.findElement(
						By.xpath("//div[@id='quote-summary-toolbar-targetEl']/a[4]/span/span/span"))
				.click();
		// Click New Quote
		this.getDriver().findElement(By.id("newQuote-inputEl")).click();
		// Click Ok
		this.getDriver()
				.findElement(
						By.xpath("//div[@id='popup-copy-to-new-quote-bottom-innerCt']/div/div[2]/div/div/a/span/span/span"))
				.click();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SWBQuoteTest quoteTest = new SWBQuoteTest("CMPQA-EU", "FF");
		quoteTest.createQuoteHeader();
		quoteTest.createQuoteLine();
		quoteTest.copyQuote();
	}

}
