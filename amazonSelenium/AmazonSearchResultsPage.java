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

    public AmazonSearchResultsPage(WebDriver driver) {
        // Initialize the driver and elements using PageFactory
        this.driver = driver;
//        System.out.println("before initialize elements");
//        System.out.println(driver);
//        System.out.println(this);
//        PageFactory.initElements(driver, this);
//        System.out.println("after initialize elements");
    }

    public boolean isSearchResultsDisplayed() {
        // Check if the resultsForLabel element is displayed
//        WebElement resultsFor = driver.findElement(resultsForLabel);

//    	if (resultsForLabel != null) {
//    		System.out.println(resultsForLabel);
//    		return true;
//    	}
//    	
//    	return false;
//		System.out.println(resultsFor);
		System.out.println(driver.findElement(resultsForLabel).isDisplayed());

    	
        return driver.findElement(resultsForLabel).isDisplayed();
    }
}
