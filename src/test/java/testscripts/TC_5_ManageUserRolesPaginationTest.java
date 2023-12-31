package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import pages.Navigations;
import pages.hradministration.ManageUserRolesPage;

@Epic("Manage User Roles Page Tests")
public class TC_5_ManageUserRolesPaginationTest extends TestBase{
	
	@Test
	@Story("Verify record counts deisplayed")
	public void verifyCorrectRecordCountDisplayed() {
		System.out.println("STEP - Navigate to Manage User Roles Page");
		
		new Navigations()
			.clickOnDashboardLeftMenu("HR Administration")
			.navigate_to("Manage User Roles");
		
		ManageUserRolesPage manageUserRolesPage = new ManageUserRolesPage();
		
		System.out.println("VERIFY - By default 50 records should be displayed in table");
		String actualDefaultValue = manageUserRolesPage.getPaginationDefaultValue();
		Assert.assertSame(actualDefaultValue, "50");
			
		System.out.println("VERIFY - Correct record summary is displayed at right corner of page");
		int expectedRowCount = manageUserRolesPage.getTotalTableRows();
		int actualRowCount = manageUserRolesPage.getTotalRowsFromSummary();
		Assert.assertTrue(expectedRowCount==actualRowCount);
	}
}
