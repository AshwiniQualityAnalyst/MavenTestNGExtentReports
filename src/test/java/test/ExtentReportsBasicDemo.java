package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import pages.GoogleSearchPageObjects;

public class ExtentReportsBasicDemo {
	private static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentreports.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("GoogleSearchTest", "Validate functionallity");

		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath+"/BrowserDrivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		driver.get("https://www.google.com/");
		test.pass("Navigated to google.com");

		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		searchPageObj.setTextInSearchBox("Automation step by step");
		test.pass("Entered text in search ");

		searchPageObj.clickSearchButton();
		test.pass("Press enter key");

		driver.close();
		test.pass("Closed the browser");

		test.info("Test completed");

		// calling flush writes everything to the log file
		extent.flush();
	}

}
