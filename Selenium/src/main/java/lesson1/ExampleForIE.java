package lesson1;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
 
public class ExampleForIE {
	private boolean result = Boolean.FALSE;
	public void loginTest(){
    	File file = new File("C:/Selenium/IEDriverServer_32.exe");
    	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
        // 如果你的 FireFox 没有安装在默认目录，那么必须在程序中设置
        // System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        // 创建一个 FireFox 的浏览器实例
        WebDriver driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        // 让浏览器访问 Baidu
        //driver.get("http://www.google.com");
        driver.get("http://qaswb.arrow.com");
        // 用下面代码也可以实现
        // driver.navigate().to("http://www.baidu.com");
        
        // 获取 网页的 title
        System.out.println("1 Page title is: " + driver.getTitle());
        
        // 通过 id 找到 input 的 DOM
        WebElement username = driver.findElement(By.name("ssousername"));//driver.findElement(By.id("gbqfq"));
        WebElement password = driver.findElement(By.name("password"));
        
        // 输入关键字
        username.sendKeys("z02668");
        password.sendKeys("arrow123");
        
 
        // 提交 input 所在的 form
        password.submit();
        //WebElement resp = driver.findElement(By.name("responsibilityId"));
        Select resp = new Select(driver.findElement(By.name("responsibilityId")));
        //WebElement ou = driver.findElement(By.name("organizationId"));
        resp.selectByVisibleText("ARW IT Sales Work Bench PM User");
        Select ou = new Select(driver.findElement(By.name("organizationId")));
        ou.selectByVisibleText("ARROW GERMANY");

//        WebElement pickForm = driver.findElement(By.name("pickForm"));
//        pickForm.submit();
        
       // driver.findElement(By.name("submit")).findElement(By.xpath("..")).click();
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        
        WebElement eAction = driver.findElement(By.xpath("//input[@name='submit']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", eAction);
        System.out.println("2 Page title is: " + driver.getTitle());
        result = Boolean.TRUE;
	}
    public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public static void main(String[] args) {
    	

 
        // 关闭浏览器
        //driver.quit();
    }
}