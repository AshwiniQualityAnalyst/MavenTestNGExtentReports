package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pages.GoogleSearchPageObjects;

public class ExtentReportsWithTestNG {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver =null;

	@BeforeSuite
	public void setUp() {
		// start reporters
		htmlReporter = new ExtentHtmlReporter("extent.html");
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeTest
	public void setUpTest() {
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath+"/BrowserDrivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void TestingReports1() throws IOException {
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		driver.get("https://www.google.com/");
		test.pass("Navigated to Ashwini Page");
		//Remaining Steps of scripts
		searchPageObj.setTextInSearchBox("Automation step by step");
		test.pass("Entered text into google textbox");
		searchPageObj.clickSearchButton();
		test.pass("Clicked on entered button");
		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		// info(details)
		test.info("This step shows usage of info(details)");
		// log with snapshot
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");
	}

	@Test
	public void TestingReports2() throws IOException {
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("MySecondTest", "Sample description");
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		driver.get("https://www.google.com/");
		test.pass("Navigated to Home Page");
		//Remaining Steps of scripts
		searchPageObj.setTextInSearchBox("Automation step by step");
		test.pass("Entered sex text into google textbox");
		searchPageObj.clickSearchButton();
		test.pass("Clicked on FUCKING button");
		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		// info(details)
		test.info("This step shows usage of info(details)");
		// log with snapshot
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("Cool passed");
	}

	@AfterSuite
	public void tearDownTest() {
		// calling flush writes everything to the log file
		extent.flush();
	}
}

