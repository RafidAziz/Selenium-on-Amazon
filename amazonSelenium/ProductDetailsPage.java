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
}
