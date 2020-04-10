package sample.sample.com;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//2) Example: Capture Scrape Data and Navigate to different pages using JavaScriptExecutor.
//=============================================================================================

//Execute the below selenium script. In this example,

//  --->Launch the site
//  --->Fetch the details of the site like URL of the site, title name and domain name of the site.
//  --->Then navigate to a different page.

public class JavaScriptExecutor2 {

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
		driver.get("http://demo.guru99.com/V4/");

		// Fetching the Domain Name of the site. Tostring() change object to
		// name.
		String DomainName = js.executeScript("return document.domain;").toString();
		System.out.println("Domain name of the site = " + DomainName);

		// Fetching the URL of the site. Tostring() change object to name
		String url = js.executeScript("return document.URL;").toString();
		System.out.println("URL of the site = " + url);
		
		Thread.sleep(2000);

		// Method document.title fetch the Title name of the site. Tostring()
		// change object to name
		String TitleName = js.executeScript("return document.title;").toString();
		System.out.println("Title of the page = " + TitleName);
		
		Thread.sleep(2000);

		// Navigate to new Page i.e to generate access page. (launch new url)
		js.executeScript("window.location = 'http://demo.guru99.com/'");
		
		Thread.sleep(10000);
	}

	@AfterTest
	public void closeBrowser() {

		// Close the main window
		driver.close();

	}

}
