package amazonSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchResultsPage {

    private WebDriver driver;
	
    // Using @FindBy annotation to locate the element
    //@FindBy(xpath = "//span[contains(text(),'results for')]")
    private By resultsForLabel = By.xpath("//span[contains(text(),'results for')]");
    private By productDesc = By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']");

    public AmazonSearchResultsPage(WebDriver driver) {
        // Initialize the driver and elements using PageFactory
        this.driver = driver;
    }

    public void clickProductDesc() {
    	driver.findElement(productDesc).click();
    }
    
    public boolean isSearchResultsDisplayed() {    	
        return driver.findElement(resultsForLabel).isDisplayed();
    }
}
