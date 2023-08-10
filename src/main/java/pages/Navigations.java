package pages;

import base.ControlActions;

public class Navigations extends ControlActions {

	// more -> Organization Chart -> xyz -> pqr -> Config

	/*
	 * public Navigations navigate_to(String path) { String[] pathArr =
	 * path.split("->"); for(int index=0;index<pathArr.length;index++) {
	 * if(index==0) {
	 * getElement("XPATH","//a[contains(text(),'"+pathArr[index]+"')]",
	 * true).click(); }else if (index==pathArr.length-1){ mouseHover(
	 * "XPATH","//a[@class='sub-menu-item-link truncate' and contains(text(),' "
	 * +pathArr[index]+"')]"); getElement(
	 * "XPATH","//a[@class='sub-menu-item-link truncate' and contains(text(),' "
	 * +pathArr[index]+"')]", true).click(); }else { System.out.println("------");
	 * System.out.println("Hovering Over " + pathArr[index]); mouseHover("XPATH",
	 * "//a[contains(text(),'"+pathArr[index]+"')]"); } } return this; }
	 */
	
	
	public Navigations navigate_to(String path) { 
		String[] pathArr = path.split("->"); 
		for(int index=0;index<pathArr.length;index++) { 
			if(index==0 || index==pathArr.length-1) {
				getElement("XPATH","//a[contains(text(),'"+pathArr[index]+"')]",true).click(); 
			}else { 
				mouseHover("XPATH","//a[contains(text(),'"+pathArr[index]+"')]"); 
				} 
			} 
		return this; 
	}
	 
	
	public Navigations clickOnDashboardLeftMenu(String menuText) {
		getElement("XPATH", "(//span[contains(text(),'"+menuText+"')]/parent::a)[1]", true).click();
		return this;
	}
}
