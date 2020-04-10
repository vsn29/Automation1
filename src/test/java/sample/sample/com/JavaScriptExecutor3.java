package sample.sample.com;

//3) Example: Scroll Downusing JavaScriptExecutor.
//====================================================

//   -->Execute the below selenium script. In this example,

//   -->Launch the site

//   -->Scroll down by 600 pixel

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptExecutor3 {

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
	public void Logind() throws InterruptedException {

		// Creating the JavascriptExecutor interface object by Type casting
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Launching the Site.
		driver.get("http://moneyboats.com/");

		// Maximize window
		driver.manage().window().maximize();

		Thread.sleep(5000);
		// Vertical scroll down by 600 pixels
		js.executeScript("window.scrollBy(0,600)");
		
		Thread.sleep(2000);
	}

	@AfterTest
	public void closeBrowser() {

		// Close the main window
		driver.close();

	}

}
