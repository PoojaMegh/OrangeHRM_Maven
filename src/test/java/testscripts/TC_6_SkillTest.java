package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Navigations;
import pages.employeemanagement.more.qualifications.SkillPage;

public class TC_6_SkillTest extends TestBase{

	@Test
	public void verifyAddedSkillDisplayed() {
		System.out.println("STEP - Navigate to Skills Page");
		
		new Navigations()
			.clickOnDashboardLeftMenu("Employee Management")
			.navigate_to("More-> Qualifications-> Skills");
		
		System.out.println("STEP - Add New Skill");
		boolean skillFlag = new SkillPage()
								.clickOnAddIcon()
								.enterName("Java-Selenium")
								.enterDescription("Java-Selenium APR'23 Batch")
								.clickOnSaveButton()
								.isSkillDisplayedByText("Java-Selenium");
		
		System.out.println("VERIFY - New Skill is added");
		Assert.assertTrue(skillFlag);
	}
}
