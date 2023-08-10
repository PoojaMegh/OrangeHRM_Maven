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

package pages.training;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class CoursesPage extends ControlActions{

	//Page factory
	@FindBy (css = "i.large.material-icons")
	private WebElement addIconElement;
	
	
	public CoursesPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Methods
	public CoursesPage clickOnAddIcon() {
		clickOnElement(addIconElement, true);
		return this;
	}
	
	/*
	 * public CoursesPage enterTitle(String title) {
	 * 
	 * }
	 */
}
