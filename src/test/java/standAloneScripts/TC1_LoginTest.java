package standAloneScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TC1_LoginTest {
	
	static WebDriverWait wait;
	static WebDriver driver;

	public static void main(String[] args) {
		System.out.println("PREREQUISITE - Launch oranage HRM URL");
		startBrowser();
		
		doLogin("Admin", "wU7P2xU@yS");
		
		tearDown();
		
	}
	
	static void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	static void doLogin(String uName, String password) {
		driver.get("https://poojamegh08-trials711.orangehrmlive.com");
		
		wait = new WebDriverWait(driver, 30);
		
		System.out.println("PREREQUISITE - User Login with valid credential");
		
		WebElement logoElement = driver.findElement(By.xpath("//div[@class='orangehrm-logo']"));
		Assert.assertTrue(isElementDisplayed(logoElement, false), "Login Page Not Displayed!");
		
		System.out.println("STEP - Login with given credentials");
		System.out.println("STEP - Enter Username ----- '" + uName + "'");
		WebElement userNameElement = driver.findElement(By.id("txtUsername"));
		userNameElement.sendKeys(uName);
		
		System.out.println("STEP - Enter Password ----- '" + password + "'");
		WebElement passwordElement = driver.findElement(By.cssSelector("#txtPassword"));
		passwordElement.sendKeys(password);
		
		System.out.println("STEP - Click on Login button");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		WebElement elployeeManagementHeaderElement = driver.findElement(By.xpath("//div[text()='Employee Management']"));
		Assert.assertTrue(isElementDisplayed(elployeeManagementHeaderElement, true));
		
	}
	
	static boolean isElementDisplayed(WebElement element, boolean isWaitRequired) {
		waitIfRequired(element, isWaitRequired);
		return element.isDisplayed();
	}
	
	static void waitIfRequired(WebElement element, boolean isWaitRequired) {
		if(isWaitRequired) {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
	}
	
	public static void tearDown() {
		System.out.println("Close the Browser!");
		driver.close();
	}
}
