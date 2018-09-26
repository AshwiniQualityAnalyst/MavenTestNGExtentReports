package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

	private static  WebElement element = null;
	public static WebElement textbox_search(WebDriver driver) {
		WebElement element = driver.findElement(By.name("q"));
		return element;
	}

	public static WebElement button_search(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]"));
		return element;
	}
}
