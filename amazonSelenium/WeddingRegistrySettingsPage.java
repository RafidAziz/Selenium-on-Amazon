package amazonSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WeddingRegistrySettingsPage {
	
	private WebDriver driver;
	
	private String weddingRegistryHomeUrl = "https://www.amazon.com/wedding/home";
	private By deleteRegistryBtn = By.cssSelector("span[id='a-autoid-15'] input[type='submit']");
	private By confirmDeleteBtn = By.cssSelector("span[id='a-autoid-16'] input[type='submit']");
	
	public WeddingRegistrySettingsPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickDeleteRegistryButton() {
		driver.findElement(deleteRegistryBtn).click();
	}
	
	public void clickConfirmDeleteButton() {
		driver.findElement(confirmDeleteBtn).click();
	}
	
	public void assertDeletedWeddingRegistry() {
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().equals(weddingRegistryHomeUrl));
	}
}
