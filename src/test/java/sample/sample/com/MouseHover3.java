package sample.sample.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseHover3 {

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

		// Instantiate Action Class
		Actions actions = new Actions(driver);
		// Retrieve WebElemnt 'slider' to perform mouse hover
		WebElement slider = driver.findElement(By.id("slider"));
		// Move mouse to x offset 50 i.e. in horizontal direction
		/* actions.moveToElement(slider, 50, 0).perform() */;
		actions.moveToElement(slider).click().moveByOffset(250, 0).build().perform();
		System.out.println("Moved slider in vertical directions");
		// Adding wait
		Thread.sleep(5000);

	}

	@AfterTest
	public void closeBrowser() {

		// Close the main window
		driver.close();

	}

}
