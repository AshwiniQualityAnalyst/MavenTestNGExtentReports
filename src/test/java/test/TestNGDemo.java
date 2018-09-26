package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.GoogleSearchPageObjects;

public class TestNGDemo {
	WebDriver driver =null;
	
	@BeforeTest
	public void setUpTest() {
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath+"/BrowserDrivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void TestCase1() {
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		driver.get("https://www.google.com/");
		searchPageObj.setTextInSearchBox("Automation step by step");
		searchPageObj.clickSearchButton();
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		System.out.println("Cool passed");
	}
}
