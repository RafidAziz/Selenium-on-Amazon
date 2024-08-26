package amazonSelenium;

import org.openqa.selenium.*;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class CartPage extends BaseTest {

	private WebDriver driver;
	
	private By deleteLink = By.cssSelector("input[value='Delete']");
	private By removedFromCartMsg = By.cssSelector("div[data-action='delete']");
	private By quantityDropDown = By.cssSelector("#a-autoid-1-announce");
	private By quantity5DropDown = By.id("quantity_5");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// click delete link
	public void clickDeleteLink() {
		driver.findElement(deleteLink).click();
	}
	
	// get 'removed from cart msg'
	public String getRemovedFromCartMsg() {
		System.out.println(driver.findElement(removedFromCartMsg).getText());
		return driver.findElement(removedFromCartMsg).getText();
	}
	
	public void changeDropDownQuantityToFive() {
		driver.findElement(quantityDropDown).click();
		driver.findElement(quantity5DropDown).click();
	}
	
	public void assertDropDownQuantityIsFive() {
		Assert.assertTrue(driver.findElement(quantityDropDown).getText().contains("5"), "Quantity is not changed to 5.");
	}
}
