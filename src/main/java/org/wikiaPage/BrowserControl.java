package org.wikiaPage;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;

public class BrowserControl {
    private WebDriver driver;

    public BrowserControl() {
    }

    public void startFirefoxBrowser() {
    	FirefoxBinary binary = new FirefoxBinary(new File("C:\\FF27\\firefox.exe"));
    	FirefoxProfile profile = new FirefoxProfile();
        driver = new FirefoxDriver(binary, profile);
    }
    
    public void startChromeBrowser() {
    	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    
    public void maximizeBrowser() {
    	driver.manage().window().maximize();
    }
    
    public void closeBrowser() {
        driver.quit();
    }
    
    public WikiaHomePage openURL(String webURL) {
        driver.get(webURL);
        return PageFactory.initElements(driver, WikiaHomePage.class);
    }
}
