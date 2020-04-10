package sample.sample.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LocateById {

	public WebDriver driver;

	@BeforeTest
	public void start() {

		// launching the Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\TestAutomation\\Grid\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://yahoo.com");
		// Maximize the window
		driver.manage().window().maximize();

	}

	@Test
	public void LocateByXPath() throws InterruptedException {

		// Absolute xpath for news tab in the yahoo home page
		WebElement ele1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div[2]/ul/li[3]/a"));

		ele1.click();

		Thread.sleep(5000);
		// Relative xpath for sign-in button in the yahoo home page

		WebElement ele2 = driver.findElement(By.xpath("//a[@title='National']"));

		ele2.click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//b[@data-reactid='10']")).click();

		Thread.sleep(2000);
		// The contains method for tag value using Text() method
		WebElement ele3 = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));

		ele3.getTagName();
		Thread.sleep(2000);

		// The contains method for locating element using attribute value
		WebElement ele4 = driver.findElement(By.xpath("//a[contains(@tabindex,'4')]"));

		ele4.getTagName();
		/* ele4.click(); */
		Thread.sleep(2000);

		// The sibling function for locating an element : following-sibling method

		WebElement ele5 = driver.findElement(By.xpath("//ul[@role='menubar']//following-sibling::a[@id='uh-signin']"));

		System.out.println(ele5.getTagName());
		Thread.sleep(2000);
	
		//The sibling function with preceding
		WebElement ele6 = driver.findElement(By.xpath("//ul[@role='menubar']//preceding-sibling::a[@id='uh-signin']"));

		System.out.println(ele6.getTagName());
		Thread.sleep(2000);
		
		//The Ancestor function
		WebElement ele7 = driver.findElement(By.xpath("//a[@id='uh-signin']//ancestor::div[@class='App-Bd']"));

		System.out.println(ele7.getTagName());
		
		Thread.sleep(2000);
		//AND and OR functions
		//Redirects to the signin page
		driver.findElement(By.xpath("//a[@id='uh-signin']")).click();
		
		//Redirects to the Create account page/Sign-up page
		driver.findElement(By.xpath("//a[@id='createacc']")).click();
		
		// Locating Element using AND function 
		WebElement ele8 = driver.findElement(By.xpath("//button[@type='submit' and @id='reg-submit-button']"));

		System.out.println(ele8.getTagName());
		
		//Locating Element usign OR function
		WebElement ele9 = driver.findElement(By.xpath("//input[@name='firstName' or @name='frstname']"));

		System.out.println(ele9.getTagName());
		
		Thread.sleep(2000);
		
		//Locating Element using Parent function
		WebElement ele10 = driver.findElement(By.xpath("//input[@name='yid']//parent::div[@id='yid-field-suggestion']"));

		System.out.println(ele10.getTagName());
		
		Thread.sleep(2000);
		
		//Locating Element using Starts-with function
		WebElement ele11 = driver.findElement(By.xpath("//input[starts-with(@name, 'first')]"));

		System.out.println(ele11.getTagName());
		
		
		
		
		
		
		
	}

	@AfterTest
	public void testB() {

		driver.quit();

	}
}
