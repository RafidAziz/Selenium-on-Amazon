package amazonSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

	private WebDriver driver;
	
	private By createAccBtn = By.id("createAccountSubmit");
	
	public SignInPage (WebDriver driver) {
		this.driver = driver;
	}

	// click 'create account' button
	public void clickCreateAccBtn() {
		driver.findElement(createAccBtn).click();
	}
}
