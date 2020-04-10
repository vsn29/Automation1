package sample.sample.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// Scenario: Verify that, notification icon is displayed on yahoo home page
public class TestB {

	public WebDriver driver;

	@BeforeTest
	public void start() {

		System.setProperty("webdriver.chrome.driver", "C:\\TestAutomation\\Grid\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://yahoo.com");

	}

	 
	@Test
	public void search() throws InterruptedException {

		WebElement ele = driver.findElement(By.xpath("//button[@title = 'Notifications']"));
		Thread.sleep(10000);

		/*if (ele.isDisplayed()) {

			System.out.println(" Notification icon is displayed");
		} else {
			System.out.println("Notification icon is not displayed");
		}
		*/
		
		 Assert.assertTrue(ele.isDisplayed());

	}

	@AfterTest
	public void testB() {

		driver.quit();

	}
}
