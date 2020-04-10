package sample.sample.com;

//Javascript Executor :
//=======================================================================================================

// 1)JavaScriptExecutor is an Interface that helps to execute JavaScript through Selenium Webdriver.

// 2)JavaScriptExecutor provides two methods "executescript" & "executeAsyncScript" to run javascript
//   on the selected window or current page.

// JavaScriptExecutor Methods:
//=======================================================================================================

// 1)executeAsyncScript:
//----------------------------
// a)With Asynchronous script, your page renders more quickly.

// b)Instead of forcing users to wait for a script to download before the page renders.This function will execute
//   an asynchronous piece of JavaScript in the context of the currently selected frame or window in Selenium. 

// c)The JS so executed is single-threaded with a various callback function which runs synchronously.

// 2)executeScript:
//---------------------------

// a)This method executes JavaScript in the context of the currently selected frame or window in Selenium. 

// b)The script used in this method runs in the body of an anonymous function (a function without a name). 
//   We can also pass complicated arguments to it.

// c)The script can return values. Data types returned are

//   --->Boolean
//   --->Long
//   --->String
//   --->List
//   --->WebElement

//Example of executeAsyncScript: Performing a sleep in the browser under test.
//=============================================================================

// 1)Using the executeAsyncScript, helps to improve the performance of your test.
//   It allows writing test more like a normal coding.

// 2)The execSync blocks further actions being performed by the Selenium browser but execAsync does not block action.

// 3) It will send a callback to the server-side Testing suite once the script is done. 
//   It means everything inside the script will be executed by the browser and not the server.

// Example 1 : Performing a sleep in the browser under test:
//=================================================================================5
//In this scenario, we will use "Guru99" demo site to illustrate executeAsyncScript. In this example, you will

//     ---->Launch the browser.
//     ---->Open site "http://demo.guru99.com/V4/ ".
//     ---->Application waits for 5 sec to perform a further action.


//Function 1: Example 1: Function Flow:

//Step 1) Capture the start time before waiting for 5 seconds ( 5000 milliseconds) by using executeAsyncScript() method.

//Step 2) Then, use executeAsyncScript() to wait 5 seconds.

//Step 3) Then, get the current time.

//Step 4) Subtract (current time – start time) = passed time.

//Step 5) Verify the output it should display more than 5000 milliseconds
	
	

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptExecutor {

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
	public void javaScriptExeMethod() throws InterruptedException {

		// Creating the JavascriptExecutor interface object by Type casting
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("http://demo.guru99.com/V4/");
		// This line maximizes the browser window
		driver.manage().window().maximize();

		// Adding wait
		Thread.sleep(2000);

		// Declare and set the start time
		long start_time = System.currentTimeMillis();

		// Call executeAsyncScript() method to wait for 5 seconds
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");

		// Get the difference (currentTime - startTime) of times.
		System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));

		
		
	}

	@AfterTest
	public void closeBrowser() {

		// Close the main window
		driver.close();

	}

}
