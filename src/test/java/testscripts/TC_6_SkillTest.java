package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import pages.Navigations;
import pages.employeemanagement.more.qualifications.SkillPage;

@Epic("Skills Page Test")
public class TC_6_SkillTest extends TestBase{

	@Test
	@Story("Verify added skill is displayed")
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
