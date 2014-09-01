package org.wikiaPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AddVideoScenarioTest {
  private BrowserControl browserControl;
  private WikiaHomePage wikiaHomePage;	
  private LoggedInPage loggedInPage;
  private AddVideoPage addVideoPage;
  private VideosPage videosPage;
  private VideoFilePage videoFilePage;
  private final String userName = "TestUser_lpj";
  private final String password = "secret";
	
  @Test
  public void test001_redirection() {
	  wikiaHomePage = browserControl.openURL("http://testhomework.wikia.com");
	  String expectedURL = "http://testhomework.wikia.com/wiki/Test-homework_Wiki";
	  String actualURL = wikiaHomePage.getPageUrl();
	  Assert.assertEquals(actualURL, expectedURL);
  }
  
  @Test
  public void test002_clickContribute_verifyDropdownShown() {
	  loggedInPage.clickContribute();
	  Assert.assertTrue(loggedInPage.isContributeDropDownVisible());
  }
  
  @Test
  public void test003_clickAddVideo_verifyRedirection() {
	  addVideoPage = loggedInPage.clickAddVideo();
	  String expectedURL = "http://testhomework.wikia.com/wiki/Special:WikiaVideoAdd";
	  String actualURL = addVideoPage.getPageUrl();
	  Assert.assertEquals(actualURL, expectedURL);
  }
  
  @Test
  public void test004_addVideo_verifyFlashMessage() {
	  addVideoPage.enterVideoURL("http://www.youtube.com/watch?v=h9tRIZyTXTI");
	  videosPage = addVideoPage.clickAdd();
	  String flashMessageText = videosPage.getFlashMessageText();
	  Assert.assertTrue(flashMessageText.contains("Video page"));
	  Assert.assertTrue(flashMessageText.contains("successfully added"));
  }
  
  @Test
  public void test005_clickFlashMessageLink_verifyRedirectionAndFileName() {
	  String fileNameWithSpaces = videosPage.getFileNameFromFlashMessage();
	  String fileNameWithUnderscores = fileNameWithSpaces.replaceAll(" ", "_");
	  videoFilePage = videosPage.clickFlashMessageLink();
	  String fileNameOnVideoFilePage = videoFilePage.getVideoName();
	  Assert.assertTrue(videoFilePage.getPageUrl().contains(fileNameWithUnderscores));
	  Assert.assertEquals(fileNameOnVideoFilePage, fileNameWithSpaces);
  }
  
  @BeforeSuite
  public void beforeSuite() {
	  browserControl = new BrowserControl();
	  browserControl.startFirefoxBrowser();
	  browserControl.maximizeBrowser();
	  wikiaHomePage = browserControl.openURL("http://testhomework.wikia.com");
	  wikiaHomePage.hoverOverLogin();
	  wikiaHomePage.enterUsername(userName);
	  wikiaHomePage.enterPassword(password);
	  loggedInPage = wikiaHomePage.logIn();
  }

  @AfterSuite
  public void afterSuite() {
	  browserControl.closeBrowser();
  }

}
