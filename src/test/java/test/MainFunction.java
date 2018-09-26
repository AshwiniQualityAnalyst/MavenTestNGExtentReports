package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;
import pages.GoogleSearchPageObjects;

public class MainFunction {
	private static WebDriver driver = null;

	public static void main(String[] args) {
		googlesearch();

	}
	public static void googlesearch() {
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath+"/BrowserDrivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("https://www.google.com/");
		/*
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation Step by Step");
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		driver.close();
		 */
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		driver.get("https://www.google.com/");
		searchPageObj.setTextInSearchBox("Automation step by step");
		searchPageObj.clickSearchButton();
		driver.close();
		
	}
}
