package amazonSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class ProductDetailsPage extends BaseTest {

	private WebDriver driver;
	private String checkoutPageUrl = "https://www.amazon.com/gp/buy/addressselect/handlers/display.html?_from=cheetah";
	private String expectedSeller;
	private String actualSeller;
	
	private By addToCartBtn = By.id("add-to-cart-button");
	private By addedtoCartMsg = By.cssSelector("h1[class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']");
	private By quantityDropDown = By.id("a-autoid-0-announce");
	private By quantity2DropDown = By.id("quantity_1");
	private By buyNowBtn = By.id("buy-now-button");
	private By soldByLink = By.id("sellerProfileTriggerId");
	private By sellerNameLabel = By.id("seller-name");
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
	}  
	
	// click add to cart button
	public void clickAddToCartBtn() {
		driver.findElement(addToCartBtn).click();
	}
	
	public void clickBuyNowBtn() {
		driver.findElement(buyNowBtn).click();
	}
	
	public void clickSoldByLink() {
		expectedSeller = driver.findElement(soldByLink).getText();
		driver.findElement(soldByLink).click();
		
	}
	
	// get 'added to cart' text
	public String getAddedToCartText() {
//		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.findElement(addedtoCartMsg).getText());
		return driver.findElement(addedtoCartMsg).getText();
	}
	
	public void changeDropDownQuantityToTwo() {
		driver.findElement(quantityDropDown).click();
		driver.findElement(quantity2DropDown).click();
	}
	
	public void assertDropDownQuantityIsTwo() {
		Assert.assertTrue(driver.findElement(quantityDropDown).getText().contains("2"), "Quantity is not changed to 2.");
	}
	
	public void assertBuyNow() {
		Assert.assertTrue(driver.getCurrentUrl().equals(checkoutPageUrl), "User is not in checkout page. Actual page: " + driver.getCurrentUrl());
	}
	
	public void assertSellerName() {
		actualSeller = driver.findElement(sellerNameLabel).getText();
		Assert.assertTrue(actualSeller.contains(expectedSeller), "Seller name does not match.");
	}
}
