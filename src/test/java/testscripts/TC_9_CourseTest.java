/*
1. Launch your oranage HRM URL
2. User Login with valid credential
3. User click on training tab
4. User click on + icon on top right corner
5. User enters valid details (DO NOT ADD COMPANY NAME AS TECHNOCREDITS)
6. click on save button
7. User click on back arrow
8. User validates that new corces is added to learning courses table
*/

package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import pages.DashboardPage;
import pages.Navigations;
import pages.training.CoursesPage;

@Epic("Course Page Test")
public class TC_9_CourseTest extends TestBase{

	@Test
	@Story("Verify Added Course is displayed")
	public void verifyAddedCourseDisplayed() {
		System.out.println("STEP - Navigate to Courses Page");
		
		new Navigations()
			.clickOnDashboardLeftMenu("Training");
		
		System.out.println("STEP - Add New Course");
		new CoursesPage()
			.clickOnAddIcon();
		/*//	.updateOrganizationName("VOIS")
			.checkNumOfEmpField()
			.clickOnSaveButton();*/
		
		System.out.println("VERIFY - Organization name is updated and displayed on user profile");
		boolean orgNameUpdatedFlag = new DashboardPage()
										.mouseHoverOnUserProfile()
										.clickOnSettingButton()
										.clickOnUserMenuAboutLink()
										.getOrganizationName()
										.equals("VOIS");
		
		Assert.assertTrue(orgNameUpdatedFlag);
	}
}
