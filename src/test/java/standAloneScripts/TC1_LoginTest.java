package standAloneScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC1_LoginTest {

	public static void main(String[] args) {
		System.out.println("PREREQUISITE - Launch oranage HRM URL");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://poojamegh08-trials711.orangehrmlive.com");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		System.out.println("PREREQUISITE - User Login with valid credential");
		
		
		
	}
}
