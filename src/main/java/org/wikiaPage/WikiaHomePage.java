package org.wikiaPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikiaHomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String loginDropDownClassName = "ajaxLogin";
    private final String loginTableName = "UserLoginDropdown";
    private final String usernameInputFieldXpath = "//input[@name='username']";
    private final String passwordInputFieldXpath = "//input[@name='password']";
    private final String loginButtonXpath = "//input[@class='login-button']";

    public WikiaHomePage(WebDriver driver) {
    	this.driver = driver;
    	this.wait = new WebDriverWait(driver, 10);
    }
    
    public String getPageUrl() {
    	return driver.getCurrentUrl();
    }
    
    public String getTitle() {
    	return driver.getTitle();
    }
    
    public void hoverOverLogin() {
    	Actions mouseAction = new Actions(driver);
    	WebElement logInField = driver.findElement(By.className(loginDropDownClassName));
    	mouseAction.moveToElement(logInField).build().perform();
    }
    
    public WebElement getLoginTable() {
    	return driver.findElement(By.id(loginTableName));
    }
    
    public boolean isLoginTableVisible() {
    	return  getLoginTable().isDisplayed();
    }
    
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(usernameInputFieldXpath)));
    	WebElement usernameField = getLoginTable().findElement(By.xpath(usernameInputFieldXpath));
    	usernameField.click();
    	usernameField.sendKeys(username);
    }
    
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(passwordInputFieldXpath)));
    	WebElement passwordField = getLoginTable().findElement(By.xpath(passwordInputFieldXpath));
    	passwordField.click();
    	passwordField.sendKeys(password);
    }
    
    public LoggedInPage logIn() {
    	WebElement loginButton = getLoginTable().findElement(By.xpath(loginButtonXpath));
    	loginButton.submit();
        return PageFactory.initElements(driver, LoggedInPage.class);
    }
}
