package sample.sample.com;

//Handling Radio buttons:
//==============================================================================

// Following example depicts How to handle Radio Buttons in Selenium 

// Step 1 :Invoke the Google Chrome browser.

// Step 2 : Navigate to the website in which we need to handle the radio buttons.

// Step 3 : Select the option Round Trip. We will locate the 'Round Trip' radio button by inspecting its HTML codes.

// There are two ways of handling the radio buttons:
//=================================================================================

//     a)By using the customized path:

//     b)By handling the radio buttons dynamically.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioButtons {

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
	public void testRadioButton() throws InterruptedException {

		driver.get("http://spicejet.com/");
		// This line maximizes the browser window
		driver.manage().window().maximize();

		// Adding wait
		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[contains(text(),'Round Trip')]")).click();
		
		Thread.sleep(2000);

	}

	@AfterTest
	public void closeBrowser() {

		// Close the main window
		driver.close();

	}

}
