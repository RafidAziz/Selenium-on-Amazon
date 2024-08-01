package amazonSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreateWeddingRegistryPage {
	
	private WebDriver driver;
	
	// First page
	private By partnerFirstNameTxt = By.id("wr-create-flow-partner-firstname");
	private By partnerLastNameTxt = By.id("wr-create-flow-partner-lastname");
	private By firstContinueBtn = By.cssSelector("input[aria-labelledby='wr-create-flow-continue-announce']");
	
	// Second page
	private By weddingDateTxt = By.id("wr-create-flow-event-date");
	private By guestCountTxt = By.id("wr-create-flow-guest-count");
	private By secondContinueBtn = By.cssSelector("input[aria-labelledby='wr-create-flow-continue-announce']");
	
	// Third page
	private By allowGiftsToBeCheckBox = By.cssSelector("label[for='wr-create-flow-3p-address-sharing'] i[class='a-icon a-icon-checkbox']");
	private By letGiftGiversCheckBox = By.cssSelector("label[for='wr-create-flow-allow-additionalItems'] i[class='a-icon a-icon-checkbox']");
	private By thirdContinueBtn = By.cssSelector("input[aria-labelledby='wr-create-flow-continue-announce']");
	
	// Fourth page
	private By privateCheckBox = By.cssSelector("body > div:nth-child(1) > div:nth-child(31) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(7) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > fieldset:nth-child(2) > div:nth-child(1) > label:nth-child(1) > i:nth-child(2)");
	private By createBtn = By.cssSelector("input[aria-labelledby='wr-create-flow-submit-announce']");
	
	// Done page
	private By viewRegistryBtn = By.id("a-autoid-0-announce");
	
	// For asserting that registry is created
	private String expectedWeddingRegistryTitle = "rafid test";
	private By weddingRegistryTitle = By.cssSelector(".wedding-details-stripe__greeting-header-partner-first");
	public CreateWeddingRegistryPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterPartnerFirstName(String firstName) {
		driver.findElement(partnerFirstNameTxt).sendKeys(firstName);
	}
	
	public void enterPartnerLastName(String lastName) {
		driver.findElement(partnerLastNameTxt).sendKeys(lastName);
	}
	
	public void clickFirstContinueButton() {
		driver.findElement(firstContinueBtn).click();
	}
	
	public void enterWeddingDate(String weddingDate) {
		driver.findElement(weddingDateTxt).sendKeys(weddingDate);
	}
	
	public void enterGuestCount(String guestCount) {
		driver.findElement(guestCountTxt).sendKeys(guestCount);
	}
	
	public void clickSecondContinueButton() {
		driver.findElement(secondContinueBtn).click();
	}
	
	public void clickAllowGiftsToBeCheckBox() {
		driver.findElement(allowGiftsToBeCheckBox).click();
	}
	
	public void clickLetGiftGiversCheckBox() {
		driver.findElement(letGiftGiversCheckBox).click();
	}
	
	public void clickThirdContinueButton() {
		driver.findElement(thirdContinueBtn).click();
	}
	
	public void clickPrivateCheckBox() {
		driver.findElement(privateCheckBox).click();
	}
	
	public void clickCreateButton() {
		driver.findElement(createBtn).click();
	}
	
	public void assertCreatedWeddingRegistry() {
		String actualWeddingRegistryTitle = driver.findElement(weddingRegistryTitle).getText();
		Assert.assertTrue(expectedWeddingRegistryTitle.equals(actualWeddingRegistryTitle), "Error: Registry is not created.");
	}
}
