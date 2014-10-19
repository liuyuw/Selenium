package lesson1;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class ExampleForIE {
    public static void main(String[] args) {
    	
//    	DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
//    	caps.setCapability("ignoreZoomSetting", true);
    	//File file = new File("C:/Selenium/IEDriverServer.exe");
    	File file = new File("C:/Selenium/IEDriverServer_32.exe");
    	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
        // 如果你的 FireFox 没有安装在默认目录，那么必须在程序中设置
        // System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        // 创建一个 FireFox 的浏览器实例
        WebDriver driver = new InternetExplorerDriver();
 
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
        //WebElement okButton = driver.findElement(By.id("OK"));
        
        // 输入关键字
        username.sendKeys("z02668");
        password.sendKeys("arrow123");
        
 
        // 提交 input 所在的 form
        password.submit();
 
        // 通过判断 title 内容等待搜索页面加载完毕，Timeout 设置10秒
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().equals("Welcome to Sales Workbench");
            }
        });
        WebElement resp = driver.findElement(By.name("responsibilityId"));
        WebElement ou = driver.findElement(By.name("organizationId"));
        resp.click();
        WebElement swbPM = resp.findElement(By.xpath("//option[@value='51099']"));
        swbPM.click();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath("//option[@value='261']")).isDisplayed();
            }
        });
        WebElement germanyOU = ou.findElement(By.xpath("//option[@value='261']"));
        germanyOU.click();
        driver.findElement(By.name("submit")).submit();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("ext-gen39")).isDisplayed();
            }
        });
        
        
        
// 
//        // 显示搜索结果页面的 title
        System.out.println("2 Page title is: " + driver.getTitle());
 
        // 关闭浏览器
        //driver.quit();
    }
}