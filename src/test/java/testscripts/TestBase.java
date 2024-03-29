package testscripts;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.ControlActions;
import io.qameta.allure.Step;
import pages.LoginPage;
import utlity.DateTimeUtility;

public class TestBase {

	@BeforeMethod
	@Step("Setting up environment")
	public void setup() {
		System.out.println("PREREQUISITE - Launch oranage HRM URL");
		ControlActions.start();
		System.out.println("PREREQUISITE - User Login with valid credential");
		LoginPage loginPage = new LoginPage();
		loginPage.doLogin("Admin", "wU7P2xU@yS");
	}
	
	@AfterMethod
	@Step("Teardown environment")
	public void tearDown(ITestResult itestResult) {
		if(itestResult.getStatus() == ITestResult.FAILURE)
			ControlActions.takeScreenshots(itestResult.getTestClass().getName() +"_"+ itestResult.getName() + "_" + DateTimeUtility.getTimeStamp());
		ControlActions.closeBrowser();
	}
}
