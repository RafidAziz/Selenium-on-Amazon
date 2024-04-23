package amazonSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {

	private WebDriver driver;
	
	private By customerNameTxt = By.name("customerName");
	private By emailTxt = By.cssSelector("input[class='a-input-text a-span12 a-spacing-micro auth-required-field auth-require-claim-validation']");
	private By passwordTxt = By.id("ap_password");
	private By confirmPasswordTxt = By.id("ap_password_check");
	private By continueBtn = By.id("continue");

	public CreateAccountPage (WebDriver driver) {
		this.driver = driver;
	}
	
	// enter customer name
	public void enterCustomerName (String customerName) {
		driver.findElement(customerNameTxt).sendKeys(customerName);
	}
	
	// enter email / mobile
	public void enterEmailMobile (String emailMobile) {
		driver.findElement(emailTxt).sendKeys(emailMobile);
	}
	
	// enter password
	public void enterPassword (String password) {
		driver.findElement(passwordTxt).sendKeys(password);
	}
	
	// enter confirm password
	public void enterConfirmPassword (String confirmPassword) {
		driver.findElement(confirmPasswordTxt).sendKeys(confirmPassword);
	}
	
	// click continue btn
	public void clickContinueBtn () {
		driver.findElement(continueBtn).click();
	}
	
	// check all fields entered 
	public boolean checkAllFieldsEntered() {
		if (driver.findElement(customerNameTxt).getText() != "" &&
				driver.findElement(emailTxt).getText() != "" &&
				driver.findElement(passwordTxt).getText() != "" &&
				driver.findElement(confirmPasswordTxt).getText() != "") {
			return true;
		}
		return false;
	}
}
