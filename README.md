Preconditions:
1) You need to have the following binaries installed:
	a) C:\FF27\firefox.exe (Firefox v27.0, as the latest supported by Selenium WebDriver)
	b) c:\chromedriver.exe (Chromedriver 2.9 as the latest supported by Selenium WebDriver)

RUNNING from command line interface:
1) After downloading sources navigate to project root directory
2) Type mvn test
3) Wait until tests are finished for results

Note:
For running with different browser you need to modify particular scenario @BeforeSuite section (comment will lead you)