package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import pages.DashboardPage;
import pages.Navigations;
import pages.employeemanagement.myinfo.PersonalDetailsPage;
import pages.employeemanagement.myinfo.SalaryPage;

@Epic("Employee Salary test")
public class TC_4_SalaryTest extends TestBase {

	@Test
	@Story("Verify CTC of employee is non-zero")
	public void verifyCTCIsNonZero() {
		System.out.println("STEP - User click on Employee Management tab");
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.waitUntilDashboardPageIsLoaded();
		new Navigations().clickOnDashboardLeftMenu("Employee Management");
		
		System.out.println("STEP - Navigate to My Info -> Personal Details tab ");
		Navigations navigations = new Navigations();
		
		navigations
			.navigate_to("My Info")
			.navigate_to("Personal Details");
		
		System.out.println("STEP - Get firstname and lastname from Personal Details");
		PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
		String firstName = personalDetailsPage.getFirstName();
		String lastName = personalDetailsPage.getLastName();
		String actualProfileName = firstName + " " + lastName;
		
		System.out.println("VERIFY - Profile name is as expected");
		Assert.assertEquals(actualProfileName, dashboardPage.getProfileName());
		
		System.out.println("VERIFY - user Personal Details Label displayed");
		boolean flag = personalDetailsPage.isPersonalDetailsHeaderDisplayed();
		Assert.assertTrue(flag);
		
		System.out.println("STEP - Click on Salary");
		navigations.navigate_to("Salary");
		SalaryPage salaryPage = new SalaryPage();
		
		System.out.println("VERIFY - the payable (CTC) amount is non-zero");
		double ctcValue = salaryPage.getCTCValue();
		Assert.assertTrue(ctcValue > 0);
	}
}
