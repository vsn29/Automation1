package sample.sample.com;

//Mouse Hover function:
//----------------------------------

// 1) Mouse hover action is basically an action where a user places a mouse over a designated area like a hyperlink. 

// 2)It can cause some event to get triggered.

// 3)For Example, moving the mouse over an element on web page displays some pop-up windows or maybe description boxes.

// 4)Actions class provides a rich set of APIs for mouse events and keyboard events. 
//   So, to perform mouse event also, Actions class provides moveToElement() methods.
   
// 5)So, here are the methods Actions class has provided for Mouse Hover action:
//------------------------------------------------------------------------------------

//     a)moveToElement(WebElement target)

//     b)moveToElement(WebElement target, int xOffset, int yOffset)

//1. How to move the mouse cursor to the middle of the web element?
//====================================================================================

// -->moveToElement(WebElement target): Moves the mouse to the middle of the element.

//Let’s see what happens internally when invoke the perform() method below:
//----------------------------------------------------------------------------

//  a)Move Mouse Action: Mouse gets moved to the middle of the element.
//    Here, the element is scrolled into view and its location gets calculated using getBoundingClientRect.

//  b)Build: build() method is used to generate a composite action containing all actions.
//           In this case, it’s just a single move mouse action. If you observe, we have not invoked it in our above command. 
//           This is because the build is executed in the perform method internally.

//  c) Perform: perform() method performs the actions we have specified. But before that, 
//              it internally invokes build() method first. After the build, the action is performed.
 
//Example: Consider the following example : 
//---------------------------------------------

//In the above image, consider a case when it is required to select an option from the menu. 
//For this, it’s required to first mouse hover ‘Music’ which displays menu list with options 
//like ‘Rock’, ‘Jazz’, ‘Pop’. After that mouse-hover at ‘Rock’ which finally displays menu list 
//with options ‘Alternative’ and ‘Classic’. Then at last select ‘Alternative’ option.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseHover {

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
		driver.get("http://demoqa.com/menu/");
		System.out.println("demoqa webpage Displayed");

		// This line maximizes the browser window
		driver.manage().window().maximize();

		// Adding wait
		Thread.sleep(2000);

		// Instantiate Action Class
		Actions actions = new Actions(driver);
		// Retrieve WebElement 'Music' to perform mouse hover
		WebElement menuOption = driver.findElement(By.xpath(".//div[contains(text(),'Music')]"));
		// Mouse hover menuOption 'Music'
		actions.moveToElement(menuOption).perform();
		System.out.println("Done Mouse hover on 'Music' from Menu");

		// Adding wait
		Thread.sleep(2000);

		// Now Select 'Rock' from sub menu which has got displayed on mouse
		// hover of 'Music'
		WebElement subMenuOption = driver.findElement(By.xpath("//div[@id='ui-id-10']"));
		// Mouse hover menuOption 'Rock'
		actions.moveToElement(subMenuOption).perform();
/*		actions.moveToElement(subMenuOption).click().perform();*/
		System.out.println("Done Mouse hover on 'Rock' from Menu");

		// Adding wait
		Thread.sleep(2000);

		// Now , finally, it displays the desired menu list from which required
		// option needs to be selected
		// Now Select 'Alternative' from sub menu which has got displayed on
		// mouse hover of 'Rock'
		WebElement selectMenuOption = driver.findElement(By.xpath(".//div[contains(text(),'Alternative')]"));
		selectMenuOption.click();
		System.out.println("Selected 'Alternative' from Menu");

		// Adding wait
		Thread.sleep(2000);

	}

	@AfterTest
	public void closeBrowser() {

		// Close the main window
		driver.close();

	}
}
