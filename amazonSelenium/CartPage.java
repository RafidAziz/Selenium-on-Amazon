package amazonSelenium;

import org.openqa.selenium.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class CartPage extends BaseTest {

	private WebDriver driver;
	
	private By deleteLink = By.cssSelector("input[value='Delete']");
	private By removedFromCartMsg = By.cssSelector("div[data-action='delete']");
	
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
	
}
