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
		waitTwoSeconds();
	}
	
	// Scenario: Change currency settings
	@When ("User goes to the currency settings page")
	public void userGoToCurrencySettingsPage() {
		waitTwoSeconds();
		navigateToURL(languageCurrencySettingsUrl);
	}
	
	@And ("User selects another currency")
	public void userSelectAnotherCurrency() {
		waitTwoSeconds();
		languageCurrencySettingsPage.clickCurrencyDropDown();
		languageCurrencySettingsPage.clickCurrencyDropDownSgd();
	}
	
	@And ("User sees currency is changed correctly")
	public void userSeeCurrencyIsChanged() {
		waitTwoSeconds();
		navigateToURL(languageCurrencySettingsUrl);
		waitTwoSeconds();
		languageCurrencySettingsPage.assertCurrencyChangedToSgd();
	}
	
	@Then ("User changes currency back to USD")
	public void userChangeCurrencyToUsd() {
		waitTwoSeconds();
		languageCurrencySettingsPage.clickCurrencyDropDown();
		languageCurrencySettingsPage.clickCurrencyDropDownUsd();
		languageCurrencySettingsPage.clickSaveChangesButton();
		waitTwoSeconds();
	}
	
	// Scenario: Cancel language changes
    @And ("User clicks cancel button")
    public void userClickCancelButton() {
    	languageCurrencySettingsPage.clickCancelButton();
    }
    
    @Then ("User should see english language selected")
    public void userSeesEnglishLanguageSelected() {
		waitTwoSeconds();
		navigateToURL(languageCurrencySettingsUrl);
		waitTwoSeconds();
    	languageCurrencySettingsPage.assertRevertLanguageToEnglish();
    }
    
 	// Scenario: Cancel currency changes
    @Then ("User should see USD currency selected")
    public void userSeesUsdCurrencySelected() {
		waitTwoSeconds();
		navigateToURL(languageCurrencySettingsUrl);
		waitTwoSeconds();
    	languageCurrencySettingsPage.assertRevertCurrencyToUsd();
    }
	
	@After
	public void tearDown() {
		if (driver!= null) {
			driver.quit();
		}
	}
}
