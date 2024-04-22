package amazonSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;
	
	private By searchTextbox = By.id("twotabsearchtextbox");
	private By searchBtn = By.id("nav-search-submit-button");
	private By signInBtn = By.id("nav-link-accountList");
	
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
}
