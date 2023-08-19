package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;
import io.qameta.allure.Step;

public class DashboardPage extends ControlActions{
	
	private static DashboardPage dashboardPage;
	
	By byWidgets = By.xpath("//div[@id='widget.id'  and not(contains(@class,'ng-hide'))]");
	
	@FindBy(xpath = "//div[text()='Employee Management']")
	WebElement employeeManagentHeaderElement;
	
	@FindBy(xpath = "//div[@id='widget.id'  and not(contains(@class,'ng-hide'))]")
	List<WebElement> listOfWidgets;
	
	@FindBy(xpath = "//div[@id='widget.id' and not(contains(@class,'ng-hide'))]//div[@class='widget-header']/span[2]")
	List<WebElement> listOfWidgetsTextElement;
	
	@FindBy(css = "div#sidebar-profile-picture")
	WebElement profilePictureElement;
	
	@FindBy(css = "div.image-container>a>i")
	WebElement settingBtn;
	
	@FindBy(css = "div.opened>div>div")
	List<WebElement> userMenuList;
	
	/*
	 * @FindBy(css = "div#displayAboutLoadMask") WebElement loaderElement;
	 */
	
	@FindBy(css = "div#companyInfo>div>div:nth-child(3)>p")
	WebElement employeeCountElement;
	
	//New Added
	@FindBy(css = "div#companyInfo>div>div:first-child>p")
	WebElement organizationNameElement;
	
	@FindBy(css = "a#aboutDisplayLink")
	WebElement aboutLinkElement;
	
	@FindBy(css = "div.modal-footer>a#heartbeatSubmitBtn")
	WebElement submitBtn;
	
	@FindBy(css = "a[class='name']")
	WebElement profileNameElement;
	
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Get widgets count")
	public int getTotalVisibleWidgets() {
		return listOfWidgets.size();
	}
	
	public DashboardPage waitUntilDashboardPageIsLoaded() {
		waitForElementToBeVisible(employeeManagentHeaderElement);
		return this;
	}
	
	public void waitUntilWidgetsAreLoaded() {
		waitUntilElementsToBeMoreThan(byWidgets,1);
	}
	
	@Step("Getting list of all widgets")
	public List<String> getAllWidgetsName(){
		return getListOfElementText(listOfWidgetsTextElement); 
	}
	
	public boolean isEmployeeManagementHeaderDisplayed() {
		return isElementDisplayed(employeeManagentHeaderElement, true);
	}
	
	public boolean isUserProfileDisplayed() {
		return isElementDisplayed(profilePictureElement, true);
	}
	
	@Step("Move Hover on user profile")
	public DashboardPage mouseHoverOnUserProfile() {
		mouseHover(profilePictureElement,false);
		return this;
	}
	
	public DashboardPage clickOnSettingButton() {
		clickOnElement(settingBtn,true);
		return this;
	}
	
	public int getUserMenuListSize(){
		return userMenuList.size();
	}
	
	/*
	 * public void waitForInvisibilityOfLoader() {
	 * waitForInvisibilyOfElement(loaderElement); }
	 */
	
	@Step("Get employee count")
	public int getEmployeeCount() {
		waitUntilTextToBePresent(employeeCountElement, "Employees:");
		String empCountInfo = getElementText(employeeCountElement, false);
		String[] empCountInfoArr = empCountInfo.split(" ");
		int actualEmpCount = Integer.parseInt(empCountInfoArr[1]);
		return actualEmpCount;
	}
	
	//New Added
	@Step("Getting user's org name")
	public String getOrganizationName() {
		waitForElementToBeVisible(organizationNameElement);
		String orgName = getElementText(organizationNameElement, true);
		String[] orgNameArr = orgName.split("Company Name: ");
		String actualOrgName = orgNameArr[1];
		return actualOrgName;
	}
	
	public DashboardPage clickOnUserMenuAboutLink() {
		clickOnElement(aboutLinkElement, false);
		return this;
	}
	
	public void clickOnOkButton() {
		clickOnElement(submitBtn, false);
	}
	
	public String getProfileName() {
		return getElementText(profileNameElement, false);
	}
	
	@Step("Navigating on Dashboard page left menu")
	public DashboardPage clickOnDashboardLeftMenu(String menuText) {
		getElement("XPATH", "(//span[contains(text(),'"+menuText+"')]/parent::a)[1]", true).click();
		return this;
	}
	
}
