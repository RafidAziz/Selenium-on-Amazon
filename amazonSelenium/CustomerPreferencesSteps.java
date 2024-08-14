package amazonSelenium;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class CustomerPreferencesSteps extends BaseTest {
	
	private String baseUrl = "https://www.amazon.com";
	private String languageCurrencySettingsUrl = "https://www.amazon.com/customer-preferences/edit/?preferencesReturnUrl=%2F&ref_=nav_em_mozart_0_1_1_36";
	
	@Given ("User is logged in with {string} and {string} for Customer Preferences Module")
	public void customerPreferencesLoginUser(String emailOrMobile, String password) {
		// sign in user
		initializeDriverAndPages();
        navigateToHomePage(baseUrl);
        homePage.clickSignInBtn();
        signInPage.enterEmailOrMobile(emailOrMobile);
        signInPage.clickContinueBtn();
        signInPage.enterPassword(password);
        signInPage.clickSignInBtn();
	}

	// Scenario: Change language settings
	@When ("User goes to the language settings page")
	public void userGoToLanguageSettingsPage() {
		navigateToURL(languageCurrencySettingsUrl);
	}
	
	@And ("User selects another language")
	public void userSelectAnotherLanguage() {
		waitTwoSeconds();
		languageCurrencySettingsPage.selectSpanishLanguage();
	}
	
	@And ("User clicks save changes button")
	public void userClickSaveChangesButton() {
		languageCurrencySettingsPage.clickSaveChangesButton();
	}
	
	@And ("User sees language is changed correctly")
	public void userSeeLanguageIsChanged() {
		waitTwoSeconds();
		navigateToURL(languageCurrencySettingsUrl);
		waitTwoSeconds();
		languageCurrencySettingsPage.assertLanguageChangedToSpanish();
	}
	
	@Then ("User changes language back to english")
	public void userChangeLangugeToEnglish() {
		languageCurrencySettingsPage.selectEnglishLanguage();
		languageCurrencySettingsPage.clickSaveChangesButton();
	}
	
	@After
	public void tearDown() {
		if (driver!= null) {
			driver.quit();
		}
	}
}
