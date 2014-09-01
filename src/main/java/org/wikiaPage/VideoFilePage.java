package org.wikiaPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VideoFilePage {
    private WebDriver driver;

    public VideoFilePage(WebDriver driver) {
    	this.driver = driver;
    }
    
    public String getPageUrl() {
    	return driver.getCurrentUrl();
    }
    
    public String getVideoName() {
    	WebElement pageHeader = driver.findElement(By.id("WikiaPageHeader")).findElement(By.tagName("h1"));
    	return pageHeader.getText();
    }
}
