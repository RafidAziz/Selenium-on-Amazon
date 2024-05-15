package amazonSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;
	
	private By searchTextbox = By.id("twotabsearchtextbox");
	private By searchBtn = By.id("nav-search-submit-button");
	private By signInBtn = By.id("nav-link-accountList");
//	private By cartBtn = By.cssSelector("span[class='nav-cart-icon nav-sprite']");
	private By cartBtn = By.id("nav-cart-count");
	private By helloAccName = By.cssSelector("span[id=\"nav-link-accountList-nav-line-1\"]");
	
	public HomePage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchProduct(String productName) {
		System.out.println("in search product method");

		enterSearchTextbox(productName);
		clickSearchBtn();
	}
	
	// enter in search box method
	public void enterSearchTextbox (String searchInput) {
		System.out.println("search input");

		driver.findElement(searchTextbox).sendKeys(searchInput);
	}
	
	// click search button method
	public void clickSearchBtn() {
		driver.findElement(searchBtn).click();
	}
	
	// click 'sign in' button
	public void clickSignInBtn() {
		driver.findElement(signInBtn).click();
	}
	
	// click shopping cart button
	public void clickCartBtn() {
		driver.findElement(cartBtn).click();
	}
	
	// check user is signed in
	public boolean checkHelloAccName() {		
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("https://www.amazon.com/?ref_=nav")) {
			return true;
		}
		
		return false;
	}
}
