package amazonSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

	private WebDriver driver;
	
	private By emailOrMobileTxt = By.id("ap_email");
	private By passwordTxt = By.id("ap_password");
	private By continueBtn = By.id("continue");
	private By createAccBtn = By.id("createAccountSubmit");
	private By signInSubmitBtn = By.id("signInSubmit");
	
	
	public SignInPage (WebDriver driver) {
		this.driver = driver;
	}

	// enter email or mobile
	public void enterEmailOrMobile(String emailOrMobile) {
		driver.findElement(emailOrMobileTxt).sendKeys(emailOrMobile);
	}
	
	// enter password
	public void enterPassword(String password) {

		driver.findElement(passwordTxt).sendKeys(password);
	}
	
	// click 'create account' button
	public void clickCreateAccBtn() {
		driver.findElement(createAccBtn).click();
	}
	
	// click continue button
	public void clickContinueBtn() {
		driver.findElement(continueBtn).click();
	}
	
	// click sign in button 
	public void clickSignInBtn() {
		driver.findElement(signInSubmitBtn).click();
	}
}
