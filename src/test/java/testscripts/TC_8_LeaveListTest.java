package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import pages.DashboardPage;
import pages.leave.LeaveListPage;
import pages.leave.LeaveListPage.DateType;
import pages.leave.LeaveListPage.LeaveBtnOptions;
import pages.leave.LeaveListPage.Month;

@Epic("Leave List Page Test")
public class TC_8_LeaveListTest extends TestBase{

	@Test
	@Story("Verify leave list for selected criteria")
	public void verifyLeaveList() throws InterruptedException {
		DashboardPage dashboardPage = new DashboardPage();
		
		System.out.println("STEP - Navigate to Leave Page");
		dashboardPage
			.waitUntilDashboardPageIsLoaded()
			.clickOnDashboardLeftMenu("Leave");
		
		System.out.println("STEP - Select TO, From Date and Click on Search");
		LeaveListPage leaveListPage = LeaveListPage.getObject();
		leaveListPage
				.setDate(Month.JANUARY, "2022", "1", DateType.FROM)
				.setDate(Month.MARCH, "2023", "31", DateType.TO)
				.clickOnBtn(LeaveBtnOptions.SEARCH);
		
		System.out.println("VERIFY - Row count");
		int actualRowCount = leaveListPage.getRowCountInSearchResultTable();
		Assert.assertEquals(actualRowCount, 3);
	}
}
