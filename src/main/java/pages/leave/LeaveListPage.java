package pages.leave;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class LeaveListPage extends ControlActions {

	private static LeaveListPage leaveListPage;
	
	@FindBy (xpath = "(//i[text()='date_range'])[1]")
	private WebElement fromCalanderIcon;
	
	@FindBy (xpath = "(//i[text()='date_range'])[2]")
	private WebElement toCalanderIcon;
	
	@FindBy (xpath = "//div[contains(@class,'--focused')]//div[contains(@class,'--month')]/input[1]")
	private WebElement monthElement;
	
	@FindBy (css = "div#viewLeaveEntitlement table>tbody>tr")
	private List<WebElement> listOfRows;
	
	/*
	 * @FindBy (xpath = "(//div[contains(@class,'--month')]/input[1]") private
	 * WebElement toMonthElement;
	 * 
	 * @FindBy (xpath = "(//div[contains(@class,'--month')]/input[1]") private
	 * WebElement fromMonthElement;
	 */
	
	@FindBy (xpath = "//div[contains(@class,'--focused')]//div[contains(@class,'--year')]/input[1]")
	private WebElement yearElement;
		
	private LeaveListPage() {
		PageFactory.initElements(driver, this);
	}
	
	public static LeaveListPage getObject() {
		if (leaveListPage == null)
			leaveListPage = new LeaveListPage();
		return leaveListPage;
	}
	
	private void setMonth(String month) {
		String currentSelectedMonth = getInputElementText(monthElement);
		if(!month.equalsIgnoreCase(currentSelectedMonth)) {
			clickOnElement(monthElement, false);
			clickOnElement("XPATH", "//ul[contains(@class,'active')]/li/span[text()='"+month+"']", true);
		}
	}
	
	private void setYear(String year) throws InterruptedException {
		Thread.sleep(1000);
		String currentSelectedYear = getInputElementText(yearElement);
		if(!year.equalsIgnoreCase(currentSelectedYear)) {
			clickOnElement(yearElement, true);
			clickOnElement("XPATH", "//ul[contains(@class,'active')]/li/span[text()='"+year+"']", true);
		}
	}
	
	private void setDate(String date) {
		String locator = "//div[@class='picker picker--focused picker--opened']//table//div[text()='"+date+"'][contains(@class,'picker__day picker__day--infocus')]";
		clickOnElement("XPATH", locator, true);
	}
	
	public enum DateType{
		FROM,TO;
	}
	
	public enum LeaveBtnOptions{
		RESET("Reset"),
		EXPORTSUMMARY("Export Summary"),
		EXPORTDETAIL("Export Detail"),
		SEARCH("Search"),
		SAVE("Save");
		
		public final String value;
		private LeaveBtnOptions(String option) {
			value = option;
		}
	}
	
	public enum Month{ 
		JANUARY("January"), 
		FEBRUARY("February"),
		MARCH("March");
		
		public final String value;
		private Month(String temp) {
			value = temp;
		}
	 }
	 
	public void clickOnBtn(LeaveBtnOptions btnType) {
		String locator = "//button[text()='"+btnType+"'] | //a[text()='"+btnType+"']";
		clickOnElement("XPATH", locator, false);
	}
	
	public LeaveListPage setDate (Month month, String year, String date, DateType dateElement) throws InterruptedException {
		if(dateElement == DateType.TO)
			clickOnElement(toCalanderIcon, true);
		else if (dateElement == DateType.FROM)
			clickOnElement(fromCalanderIcon, true);
		
		setYear(year);
		setMonth(month.value);
		setDate(date);
		return this;
	}
	
	public int getRowCountInSearchResultTable() {
		return getListOfElementCount(listOfRows);
	}
	
}
