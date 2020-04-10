package sample.sample.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*css Selectors:

1) tag and ID   tag#Id

2) tag and class              tag.class 

3) tag, class and attribute   tag.class[attribute= attribute value]

4) starts with                tag#Id[attribute^='attribute starting value']

5) Ends with                  tag#Id[attribute$='attribute ending value']



Differences between CSS selectors and Xpath 

1) CSS selectors are faster than Xpath

2) Its easy to  identify WebElements using CSS selectors than Xpath

3) Xpath Syntax: findelement(By.Xpath) ,  CSS Selectors: findelement(By.cssSelector)

4) Using CSS Selectors we cannot identify elements using parent tag(axis path) 

*/



public class CssSelector {

	public WebDriver driver;

	@BeforeTest
	public void start() {

		// launching the Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\TestAutomation\\Grid\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("https://login.yahoo.com");
		// Maximize the window
		driver.manage().window().maximize();

	}

	@Test
	void locateByCSS() throws InterruptedException {

		// The CSS 'Tag and Id' Selector to locate a Web Element
		//// Here Tag = input and Id = identifierId
		WebElement ele1 = driver.findElement(By.cssSelector("input#login-username"));

		ele1.sendKeys("vijsyn@gmail.com");
		System.out.println(ele1.getTagName());

		Thread.sleep(2000);

		// The CSS 'Tag and Class' Selector to locate a Web Element
		// Note: If multiple elements have the same HTML tag and class, then the
		// first one will be recognized.

		driver.findElement(By.cssSelector("a#createacc")).click();

		Thread.sleep(2000);

		WebElement ele2 = driver.findElement(By.cssSelector("input.ureg-fname"));

		System.out.println(ele2.getText());

		Thread.sleep(2000);

		// The CSS 'Tag and Attribute' Selector to locate a Web Element
		// Note: If multiple elements have the same HTML tag and attribute, then
		// the first one will be recognized.
		WebElement ele3 = driver.findElement(By.cssSelector("input[name=firstName]"));

		System.out.println(ele3.getAttribute("name"));

		Thread.sleep(2000);

		// The CSS 'Tage, Class and Attribute Selector to locate a Web Element

		WebElement ele4 = driver.findElement(By.cssSelector("input.ureg-fname[name=firstName]"));

		System.out.println(ele4.getAttribute("name"));

		Thread.sleep(2000);

		WebElement ele5 = driver.findElement(By.cssSelector("input.ureg-fname[name=firstName]"));

		System.out.println(ele4.getAttribute("name"));

		Thread.sleep(2000);

		WebElement ele6 = driver.findElement(By.cssSelector("input#login-signin[name^='sig']"));

		Thread.sleep(2000);

		WebElement ele7 = driver.findElement(By.cssSelector("input#login-signin[name$='nin']"));

		Thread.sleep(2000);
	}

	@AfterTest
	public void testB() {

		driver.quit();

	}
}
