package amazonSelenium;

import org.openqa.selenium.*;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class CartPage extends BaseTest {

	private WebDriver driver;
	private String cartItemPrice;
	private String cartItemQty;
	
	private By cartItemPriceText = By.cssSelector("span[id='sc-subtotal-amount-activecart'] span[class='a-size-medium a-color-base sc-price sc-white-space-nowrap']");
	private By deleteLink = By.cssSelector("input[value='Delete']");
	private By removedFromCartMsg = By.cssSelector("div[data-action='delete']");
	private By quantityBox = By.xpath("//input[@name='quantityBox']");
	private By quantityAdd = By.cssSelector(".a-icon.a-icon-small-add");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setCartItemPrice() {
		waitTwoSeconds();
		cartItemPrice = driver.findElement(cartItemPriceText).getText();
	}
	
	public void setCartItemQty() {
		waitTwoSeconds();
		waitTwoSeconds();
		cartItemQty = driver.findElement(quantityBox).getAttribute("value");
	}
	
	// click delete link
	public void clickDeleteLink() {
		driver.findElement(deleteLink).click();
		waitTwoSeconds();
	}
	
	// get 'removed from cart msg'
	public String getRemovedFromCartMsg() {
		System.out.println(driver.findElement(removedFromCartMsg).getText());
		return driver.findElement(removedFromCartMsg).getText();
	}
	
	public void changeDropDownQuantityToFive() {
		driver.findElement(quantityAdd).click();
		waitTwoSeconds();
		driver.findElement(quantityAdd).click();
		waitTwoSeconds();
		driver.findElement(quantityAdd).click();
		waitTwoSeconds();
	}
	
	public void assertDropDownQuantityIsFive() {
		System.out.println("actual quantity: " + driver.findElement(quantityBox).getAttribute("value"));
		Assert.assertTrue(driver.findElement(quantityBox).getAttribute("value").contains("5"), "Quantity is not changed to 5.");
	}
	
	public void assertPriceInCartEqualsPriceInProdPage(String prodPrice) {
		setCartItemPrice();
		System.out.println("product detail price: " + prodPrice);
		System.out.println("cart price: " + cartItemPrice);
		Assert.assertEquals(cartItemPrice, prodPrice, "Prices in cart is different from price in product details page.");
	}
	
	public void assertQtyinCartEqualsQtyinProdPage(String prodQty) {
		// stopped here at regression testing cart feature file
		setCartItemQty();
		System.out.println("product detail quantity: " + prodQty);
		System.out.println("cart quantity: " + cartItemQty);
		Assert.assertEquals(cartItemQty, prodQty, "Quantity in cart is different from quantity in product details page.");
	}
}
