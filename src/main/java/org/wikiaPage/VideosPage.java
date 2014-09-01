package org.wikiaPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class VideosPage {
    private WebDriver driver;

    public VideosPage(WebDriver driver) {
    	this.driver = driver;
    }
    
    public String getFlashMessageText() {
    	WebElement flashMessageBox = driver.findElement(By.className("msg"));
    	return flashMessageBox.getText();
    }
    
    public String getFileNameFromFlashMessage(){
    	WebElement flashMessageLink = driver.findElement(By.partialLinkText("File:"));
    	return flashMessageLink.getAttribute("title").replace("File:", "");
    }
    
    public VideoFilePage clickFlashMessageLink() {
    	WebElement flashMessageLink = driver.findElement(By.partialLinkText("File:"));
    	flashMessageLink.click();
        return PageFactory.initElements(driver, VideoFilePage.class);
    }
}
