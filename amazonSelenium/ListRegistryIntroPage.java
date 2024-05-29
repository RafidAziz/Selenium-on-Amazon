package amazonSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class ListRegistryIntroPage extends BaseTest {

	private WebDriver driver;
	
	private By createListBtn = By.cssSelector(".a-button-input");
	private By listTxt = By.cssSelector("#list-name");
	private By confirmListBtn = By.xpath("//span[@class='a-button a-button-primary']//input[@type='submit']");
	
	public ListRegistryIntroPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// click create list button
	public void clickCreateListBtn() {
		driver.findElement(createListBtn).click();
	}
	
	// enter list name
	public void enterListTxt(String listName) {
		driver.findElement(listTxt).sendKeys(listName);
	}
	
	// click confirm list button to create list
	public void clickConfirmListBtn() {
		driver.findElement(confirmListBtn).click();
	}
	
	// assert list is created successfully
	public void assertListCreatedSuccessfully() {
		Assert.assertTrue(driver.getCurrentUrl()
				.contains("https://www.amazon.com/hz/wishlist"), 
				"Error: List was not created successfully");
	}
}