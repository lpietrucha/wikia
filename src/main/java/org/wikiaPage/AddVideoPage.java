package org.wikiaPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddVideoPage {
    private WebDriver driver;

    public AddVideoPage(WebDriver driver) {
    	this.driver = driver;
    }
    
    public String getPageUrl() {
    	return driver.getCurrentUrl();
    }
    
    public void enterVideoURL(String videoURL){
    	WebElement urlField = driver.findElement(By.xpath("//input[@name='wpWikiaVideoAddUrl']"));
    	urlField.click();
    	urlField.sendKeys(videoURL);
    }
    
    public VideosPage clickAdd(){
    	WebElement addButton = driver.findElement(By.xpath("//input[@value='Add']"));
    	addButton.submit();
        return PageFactory.initElements(driver, VideosPage.class);
    }
    
    public void logOut() {
    	
    }
}
