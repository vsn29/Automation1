package sample.sample.com;

//Handling Dynamic Dropdowns

// Following example depicts the How to handle dynamic dropdown in selenium

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynaimcDropDown {

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
	public void dropdownmenu() throws InterruptedException {
		driver.get("http://spicejet.com/");
		// This line maximizes the browser window
		driver.manage().window().maximize();

		// Adding wait
		Thread.sleep(2000);
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		Thread.sleep(2000);

	}

	@AfterTest
	public void closeBrowser() {

		// Close the main window
		driver.close();

	}

}
