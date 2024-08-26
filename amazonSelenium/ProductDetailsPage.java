package amazonSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class ProductDetailsPage extends BaseTest {

	private WebDriver driver;
	
	private By addToCartBtn = By.id("add-to-cart-button");
	private By addedtoCartMsg = By.cssSelector("h1[class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']");
	private By quantityDropDown = By.id("a-autoid-0-announce");
	private By quantity2DropDown = By.id("quantity_1");
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
	}  
	
	// click add to cart button
	public void clickAddToCartBtn() {
		driver.findElement(addToCartBtn).click();
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
}
