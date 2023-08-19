package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import pages.DashboardPage;
import pages.Navigations;
import pages.hradministration.organization.GeneralInformationPage;

@Epic("General Information Page Test")
public class TC_7_GeneralInformationTest extends TestBase{

	@Test
	@Story("Verify Organization name is updated")
	public void verifyOrgNameIsUpdated() {
		System.out.println("STEP - Navigate to General Information Page");
		
		DashboardPage dashboardPage = new DashboardPage();
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
