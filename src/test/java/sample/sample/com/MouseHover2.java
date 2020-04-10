package sample.sample.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Mouse Hover Functions:
//------------------------------------------------------------

//2.How to move the mouse cursor to an element offset?
//=============================================================

//moveToElement(WebElement target, int xOffset, int yOffset):
//Moves the mouse to an offset from the top-right corner of the element.

//Example: 
//----------------------------------------------------------------------

//Let’s consider Slider which is used to select some range. 
//This can be selected by moving the slider thumb or clicking on a specific point on the slider element. 
//To perform this action through automation script, we can take help of this particular method 
//i.e. moveToElement(WebElement target, int xOffset, int yOffset) where we specify the exact location to move the mouse on the element.

public class MouseHover2 {

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
	public void openBrowser() throws InterruptedException {

		// Launch the URL
		driver.get("http://demoqa.com/slider/");
		System.out.println("demoqa webpage Displayed");

		// This line maximizes the browser window
		driver.manage().window().maximize();

		// Adding wait
		Thread.sleep(2000);

		// to perform scroll on an application using Selenium

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		Thread.sleep(5000);

	}

	@AfterTest
	public void closeBrowser() {

		// Close the main window
		driver.close();

	}

}
