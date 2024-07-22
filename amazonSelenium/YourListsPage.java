package amazonSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class YourListsPage extends BaseTest {
	
	private WebDriver driver;
	
	private By moreLink = By.cssSelector("a[id='overflow-menu-popover-trigger'] div[class='aok-inline-block aok-align-center']");
	private By manageListLink = By.id("editYourList");
	private By deleteListBtn = By.cssSelector("span[class='a-button a-spacing-base a-button-base full-width-element'] input[type='submit']");
	private By deleteListConfirmBtn = By.name("submit.save");
	
	public YourListsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// click 'manage list' link
	public void clickManageListLink() {
		Actions action = new Actions(driver);
		WebElement WEmoreLink = driver.findElement(moreLink);
        System.out.println("More link Located: " + WEmoreLink.isDisplayed());

		action.moveToElement(WEmoreLink).click().perform();
		action.moveToElement(driver.findElement(manageListLink)).click().perform();
	}
	
	// click 'delete list' button
	public void clickDeleteListBtn() {
		// wait for 2 seconds
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(deleteListBtn).click();
	}
	
	// click confirmation button for delete list
	public void clickDeleteListConfirmBtn() {
		// wait for 2 seconds
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		driver.findElement(deleteListConfirmBtn).click();
	}
}
