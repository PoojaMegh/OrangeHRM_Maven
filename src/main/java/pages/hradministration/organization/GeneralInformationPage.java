package pages.hradministration.organization;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class GeneralInformationPage extends ControlActions{

	@FindBy (css = "input#name")
	WebElement organizationInputElement;
	
	@FindBy (css = "input#numemp")
	WebElement numberOfEmpElement;
	
	@FindBy (css = "button.btn")
	WebElement saveButton;
	
	public GeneralInformationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public GeneralInformationPage updateOrganizationName(String updatedOrgName) {
		replaceText(updatedOrgName, organizationInputElement);
		return this;
	}
	
	public GeneralInformationPage checkNumOfEmpField() {
		numberOfEmpElement.isDisplayed();
		return this;
	}
	
	public GeneralInformationPage clickOnSaveButton() {
		clickOnElement(saveButton, false);
		return this;
	}
}
