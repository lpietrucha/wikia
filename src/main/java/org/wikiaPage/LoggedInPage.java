package org.wikiaPage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedInPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoggedInPage(WebDriver driver) {
    	this.driver = driver;
    	this.wait = new WebDriverWait(driver, 10);
    }
    
    public boolean isUserNameDisplayed(String expectedValue) {
    	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ajaxRegister")));
    	try {
        	WebElement accountNavigation = driver.findElement(By.id("AccountNavigation"));
        	WebElement userNameLink = accountNavigation.findElement(By.partialLinkText(expectedValue));
        	return true;
    	} catch (NoSuchElementException e) {
            return false;
        }
    }
    
    public void clickContribute() {
    	WebElement contributeButton = driver.findElement(By.xpath("//nav[@class='wikia-menu-button contribute secondary combined']"));
    	contributeButton.click();
    }
    
    public boolean isContributeDropDownVisible() {
    	WebElement contributeDropDown =  driver.findElement(By.xpath("//ul[@class='WikiaMenuElement']"));
    	return contributeDropDown.isDisplayed();
    }
    
    public AddVideoPage clickAddVideo() {
    	WebElement addVideoButton = driver.findElement(By.xpath("//a[@data-id='wikiavideoadd']"));
    	addVideoButton.click();
        return PageFactory.initElements(driver, AddVideoPage.class);
    }
}
