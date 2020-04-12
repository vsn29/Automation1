package sample.sample.com;

///*Syntax:

// JavascriptExecutor js = (JavascriptExecutor) driver;  
// js.executeScript(Script,Arguments);
// script - The JavaScript to execute
// Arguments - The arguments to the script.(Optional)*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagementTest {

	public WebDriver driver;

	@Test
	public void WebDriverManagerTest() throws InterruptedException {
		// setup the chromedriver using WebDriverManager
		WebDriverManager.chromedriver().setup();

		// Create driver object for Chrome
		WebDriver driver = new ChromeDriver();

		// Navigate to a URL
		driver.get("https://www.google.com");

		Thread.sleep(2000);

		// quit the browser
		driver.quit();
	}

}
