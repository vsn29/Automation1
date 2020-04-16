package sample.sample.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagementTest {

	@Test
	public void WebDriverManagerTest() throws InterruptedException {
		// setup the chromedriver using WebDriverManager
		WebDriverManager.chromedriver().setup();

		// Create driver object for Chrome
		WebDriver driver = new ChromeDriver();

		// Navigate to a URL
		driver.get("https://www.google.com");

		Thread.sleep(2000);
		
		System.out.println("Browser Launch: Success");

		// quit the browser
		driver.quit();
	}

}
