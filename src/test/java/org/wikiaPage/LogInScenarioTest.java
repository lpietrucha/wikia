package org.wikiaPage;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.wikiaPage.BrowserControl;
import org.wikiaPage.WikiaHomePage;

public class LogInScenarioTest {
  private BrowserControl browserControl;
  private WikiaHomePage wikiaHomePage;	
  private LoggedInPage loggedInPage;
  private final String userName = "TestUser_lpj";
  private final String password = "secret";
	
  @Test
  public void test001_redirection() {
	  String expectedURL = "http://testhomework.wikia.com/wiki/Test-homework_Wiki";
	  String actualURL = wikiaHomePage.getPageUrl();
	  Assert.assertEquals(actualURL, expectedURL);
  }
  
  @Test
  public void test002_loginTableAppears() {
	  wikiaHomePage.hoverOverLogin();
	  Assert.assertTrue(wikiaHomePage.isLoginTableVisible());
  }
  
  @Test
  public void test003_loginAndVerify() {
	  wikiaHomePage.hoverOverLogin();
	  wikiaHomePage.enterUsername(userName);
	  wikiaHomePage.enterPassword(password);
	  loggedInPage = wikiaHomePage.logIn();
	  Assert.assertTrue(loggedInPage.isUserNameDisplayed("TestUser lpj"));
  }
  
  @BeforeSuite
  public void beforeLoginScenario() {
	  browserControl = new BrowserControl();
	  browserControl.startFirefoxBrowser();
	  browserControl.maximizeBrowser();
	  wikiaHomePage = browserControl.openURL("http://testhomework.wikia.com");
  }

  @AfterSuite
  public void cleanup() {
	  browserControl.closeBrowser();
  }

}
