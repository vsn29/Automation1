package sample.sample.com;

//Handling Static Dropdwons in Selenium :

//Before we can control drop-down boxes, we must do following two things:

//   1)Import the package org.openqa.selenium.support.ui.Select

//   2)Instantiate the drop-down box as a "Select" object in WebDriver

// Following Example depicts the Static Dropdown

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDown {

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

		driver.get("https://www.spicejet.com/");
		// This line maximizes the browser window
		driver.manage().window().maximize();

		// Adding wait
		Thread.sleep(2000);

		/*
		  Select s = new Select(driver.findElement(By.id("//div[@id='divpaxinfo']")).click();
		 */

		WebElement dropdown = driver.findElement(By.id("divpaxinfo"));

		dropdown.click();
		
		// Adding wait
				Thread.sleep(2000);

		//Dropdwon Element
		WebElement submenu = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));

		submenu.click();
		
		// Adding wait
				Thread.sleep(2000);

		//Declare the drop-down element as an instance of the Select class.
		Select s = new Select(submenu);

		s.selectByIndex(2);

	}

	@AfterTest
	public void closeBrowser() {

		// Close the main window
		driver.close();

	}

}
