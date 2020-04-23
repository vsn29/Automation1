package sample.sample.com;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//

public class Alert_Demo {

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
	public void alerts() throws InterruptedException {

		// Initialize Gecko Driver using Desired Capabilities Class
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("marionette", true);

		// Launch Website
		driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");
		// This line maximizes the browser window
		driver.manage().window().maximize();

		Thread.sleep(2000);

		// Handling alert boxes
		// Click on generate alert button
	/*	driver.findElement(By.xpath("/html/body/div/div[11]/div/p/button")).click();*/

		driver.findElement(By.partialLinkText("Generate Alert Box")).click();

		Thread.sleep(2000);

		// Using Alert class to first switch to or focus to the alert box
		Alert alert = (Alert) driver.switchTo().alert();
		Thread.sleep(2000);

		// Using accept() method to accept the alert box
		alert.accept();

		Thread.sleep(2000);
		// Handling confirm box
		// Click on Generate Confirm Box
		/*driver.findElement(By.xpath("/html/body/div/div[12]/div/p[1]/button")).click();*/
		
		driver.findElement(By.linkText("Generate Confirm Box")).click();
		Thread.sleep(2000);

		Alert confirmBox = (Alert) driver.switchTo().alert();

		// Using dismiss() command to dismiss the confirm box
		// Similarly accept can be used to accept the confirm box
		((Alert) confirmBox).dismiss();
		Thread.sleep(2000);

	}

	@AfterTest
	public void closeBrowser() {

		// Close the main window
		driver.close();

	}

}
