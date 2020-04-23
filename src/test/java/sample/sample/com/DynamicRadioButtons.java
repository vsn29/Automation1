package sample.sample.com;

//By handling the dynamic radio buttons
//=====================================================================================

//We will first calculate the number of radio buttons.The following is the line of code which calculates the number of radio buttons.

//int a=driver.findElements(By.xpath("//input [@name='group1']")).size();

//The above line of code calculates the number of radio buttons whose name is group1.Now,we will handle the radio buttons by using the index of a particular radio button.

//driver.findElements(By.xpath("//input[@name='group1']")).get(2).click();

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicRadioButtons {

	public WebDriver driver;

	@BeforeTest
	public void start() throws InterruptedException {

		// Set system properties for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\TestAutomation\\Grid\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		// Adding wait
		Thread.sleep(2000);

	}

	@Test
	public void dynamicRadioButton() throws InterruptedException {

		driver.get("C:/Users/admin/radio.html");
		// This line maximizes the browser window
		driver.manage().window().maximize();

		// Adding wait
		Thread.sleep(2000);

		// he following is the line of code which calculates the number of radio
		// buttons.
		int a = driver.findElements(By.xpath("//input [@name='group1']")).size();

		System.out.println(a);

		// Now, we will handle the radio buttons by using the index of a
		// particular radio button.

		driver.findElements(By.xpath("//input[@name='group1']")).get(1).click();

		/*
		 * System.out.println(driver.findElements(By.xpath(
		 * "//input[@type=’radio’]")).size());
		 */

		Thread.sleep(2000);

	}

	@AfterTest
	public void closeBrowser() {

		// Close the main window
		driver.close();

	}

}
