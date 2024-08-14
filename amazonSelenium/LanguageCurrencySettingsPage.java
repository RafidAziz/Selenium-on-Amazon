package amazonSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LanguageCurrencySettingsPage {

	private WebDriver driver;
	
	private String spanishWordCheck = "Traducción";
	
	private By translationHeading = By.cssSelector("#icp-language-translation-heading");
	private By englishLangCheckbox = By.cssSelector("body > div:nth-child(1) > div:nth-child(29) > div:nth-child(1) > form:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > label:nth-child(1) > i:nth-child(2)");
	private By spanishLangCheckbox = By.cssSelector("body > div:nth-child(1) > div:nth-child(29) > div:nth-child(1) > form:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > label:nth-child(1) > i:nth-child(2)");
	private By saveChangesBtn = By.cssSelector(".a-button-input");
	
	public LanguageCurrencySettingsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectSpanishLanguage() {
		driver.findElement(spanishLangCheckbox).click();
	}
	
	public void selectEnglishLanguage() {
		driver.findElement(englishLangCheckbox).click();
	}
	
	public void clickSaveChangesButton() {
		driver.findElement(saveChangesBtn).click();
	}
	
	public void assertLanguageChangedToSpanish() {
		Assert.assertTrue(spanishWordCheck.equals(driver.findElement(translationHeading).getText()), "Language was not changed to Spanish.");
	}
}
