package sample.sample.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Example of executeScript: 
//For executeScript, we will see three different example one by one.

//1) Example: Click a button to login and generate Alert window using JavaScriptExecutor. 

//     --->In this scenario, we will use "Guru99" demo site to illustrate JavaScriptExecutor. In this example,

//     --->Launch the web browser
//     --->open the site "http://demo.guru99.com/V4/ "and
//     --->login with credentials
//     --->Display alert window on successful login.

public class JavaScriptExecutor1 {

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

		driver.get("http://demo.guru99.com/V4/");
		// This line maximizes the browser window
		driver.manage().window().maximize();

		// Adding wait
		Thread.sleep(2000);

		// Launching the Site.
		driver.get("http://demo.guru99.com/V4/");

		WebElement button = driver.findElement(By.name("btnLogin"));

		// Login to Guru99
		driver.findElement(By.name("uid")).sendKeys("mngr254825");
		driver.findElement(By.name("password")).sendKeys("ydErUgU");

		// Perform Click on LOGIN button using JavascriptExecutor
		js.executeScript("arguments[0].click();", button);

		// To generate Alert window using JavascriptExecutor. Display the alert
		// message
		js.executeScript("alert('Welcome to Guru99');");
		
		Thread.sleep(5000);

	}

	@AfterTest
	public void closeBrowser() {

		// Close the main window
		driver.quit();

	}

}
