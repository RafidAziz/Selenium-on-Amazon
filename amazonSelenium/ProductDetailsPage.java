package amazonSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class ProductDetailsPage extends BaseTest {

	private WebDriver driver;
	private String checkoutPageUrl = "https://www.amazon.com/gp/buy/addressselect/handlers/display.html?_from=cheetah";
	private String expectedSeller;
	private String actualSeller;
	private String returnsPolicyUrl = "https://www.amazon.com/gp/help/customer/display.html?nodeId=GKM69DUUYKQWKWX7&ref_=dp_ret_policy";
	private String privacyNoticeUrl = "https://www.amazon.com/gp/help/customer/display.html?nodeId=201909010";
	
	private By addToCartBtn = By.id("add-to-cart-button");
	private By addedtoCartMsg = By.cssSelector("h1[class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']");
	private By quantityDropDown = By.id("a-autoid-0-announce");
	private By quantity2DropDown = By.id("quantity_1");
	private By buyNowBtn = By.id("buy-now-button");
	private By regularPriceRadioBtn = By.cssSelector("div[id='newAccordionRow_1'] i[class='a-icon a-accordion-radio a-icon-radio-inactive']");
	private By soldByLink = By.id("sellerProfileTriggerId");
	private By sellerNameLabel = By.id("seller-name");
	private By returnsLink = By.cssSelector("a[data-csa-c-content-id='odf-desktop-return-info'] span[class='a-size-small offer-display-feature-text-message']");
	private By returnHeading = By.cssSelector("div[data-csa-c-content-id='desktop-return-info'] span[class='a-text-bold']");
	private By returnDesc = By.cssSelector("div[id='a-popover-4'] div[class='a-section a-padding-base'] div:nth-child(1)");
	private By fullReturnPolicyLink = By.xpath("//div[@class='a-section a-padding-base']//a[@id='desktop-return-info-link-text']");
	private By paymentLink = By.xpath("//span[@class='a-size-small offer-display-feature-text-message'][normalize-space()='Secure transaction']");
	private By paymentHeading = By.xpath("//span[normalize-space()='Your transaction is secure']");
	private By paymentLearnMoreLink = By.xpath("//div[contains(text(),'We work hard to protect your security and privacy.')]//span[contains(text(),'Learn more')]");
	
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
	
	public void clickRegularPriceRadioBtn() {
		if (driver.findElement(regularPriceRadioBtn).isDisplayed()) {
			driver.findElement(regularPriceRadioBtn).click();
		}
	}
	
	public void clickSoldByLink() {
		expectedSeller = driver.findElement(soldByLink).getText();
		driver.findElement(soldByLink).click();
		
	}
	
	public void clickReturnsLink() {
		driver.findElement(returnsLink).click();
	}
	
	public void clickFullReturnPolicyLink() {
		driver.findElement(fullReturnPolicyLink).click();
	}
	
	public void clickPaymentLink() {
		driver.findElement(paymentLink).click();
	}
	
	public void clickPaymentLearnMoreLink() {
		driver.findElement(paymentLearnMoreLink).click();
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
	
	public void assertReturnsPolicy() {
		waitTwoSeconds();
		Assert.assertTrue(driver.findElement(returnDesc).isDisplayed(), "Returns description is not displayed.");
		retryClickingReturnPolicyLink();
		switchToNewTab(driver);
		waitTwoSeconds();
		Assert.assertTrue(driver.getCurrentUrl().contains(returnsPolicyUrl), "Returns policy URL is not correct: " + driver.getCurrentUrl());
	}
	
	public void assertPaymentLearnMoreLink() {
		waitTwoSeconds();
		Assert.assertTrue(driver.findElement(paymentHeading).isDisplayed(), "Payment heading is not displayed.");
		retryClickingPaymentLearnMoreLink();
		switchToNewTab(driver);
		waitTwoSeconds();
		Assert.assertTrue(driver.getCurrentUrl().contains(privacyNoticeUrl), "Privacy notice URL is not correct: " + driver.getCurrentUrl());
	}
	
	public void retryClickingReturnPolicyLink() {
		while (true) {
			try {
				driver.navigate().refresh();
				clickReturnsLink();
				clickFullReturnPolicyLink();
				break;
			} catch (ElementNotInteractableException e) {
	            System.out.println("Element not interactable, retrying...");
	            waitTwoSeconds();
			}
		}
	}
	
	public void retryClickingPaymentLearnMoreLink() {
		while (true) {
			try {
				driver.navigate().refresh();
				clickPaymentLink();
				clickPaymentLearnMoreLink();
				break;
			} catch (ElementNotInteractableException e) {
	            System.out.println("Element not interactable, retrying...");
	            waitTwoSeconds();
			}
		}
	}
}
