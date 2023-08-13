package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.Navigations;
import pages.hradministration.organization.GeneralInformationPage;

public class TC_7_GeneralInformationTest extends TestBase{

	@Test
	public void verifyOrgNameIsUpdated() {
		System.out.println("STEP - Navigate to General Information Page");
		
		DashboardPage dashboardPage = DashboardPage.getObject();
		new Navigations()
			.clickOnDashboardLeftMenu("HR Administration")
			.navigate_to("Organization->General Information");
		
		System.out.println("STEP - Update Organization name");
		new GeneralInformationPage()
			.updateOrganizationName("VOIS")
			.checkNumOfEmpField()
			.clickOnSaveButton();
		
		System.out.println("VERIFY - Organization name is updated and displayed on user profile");
		boolean orgNameUpdatedFlag = dashboardPage
										.mouseHoverOnUserProfile()
										.clickOnSettingButton()
										.clickOnUserMenuAboutLink()
										.getOrganizationName()
										.equals("VOIS");
		
		Assert.assertTrue(orgNameUpdatedFlag);
	}
}
