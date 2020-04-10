package sample.sample.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Test Scenario : Searches a keyword from yahoo search engine

public class TestA {

	public WebDriver driver;

	@BeforeTest
	public void start() {

		System.setProperty("webdriver.chrome.driver", "C:\\TestAutomation\\Grid\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://yahoo.com");

	}

	@Test
	public void search() {

		WebElement ele = driver.findElement(By.xpath("//input[@id='uh-search-box']"));

		ele.sendKeys("Hello");

		WebElement ele1 = driver.findElement(By.xpath("//button[@id='uh-search-button']"));

		ele1.click();

	}

	@AfterTest
	public void testB() {

		driver.close();

	}
}
