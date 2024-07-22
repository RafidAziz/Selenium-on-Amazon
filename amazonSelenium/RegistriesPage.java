package amazonSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistriesPage {

	private WebDriver driver;
	
//	private By addToCartBtn = By.id("add-to-cart-button");
//	private By addedtoCartMsg = By.cssSelector("h1[class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']");
	
	private By marriageImgLink = By.cssSelector("img[alt='A pair of champagne flutes on top of plates with ribbon']");
	private By babyImgLink = By.cssSelector("img[alt='Baby nursery with crib and teddy bear']");
	private By birthdayImgLink = By.cssSelector("img[alt='A child opening a birthday present']");
	private By occasionImgLink = By.cssSelector("img[alt='A hand holding a stack of wraped gifts']");
	private By graduationImgLink = By.cssSelector("img[src='https://m.media-amazon.com/images/G/01/img18/home/GL/graduation-4.jpg']");
	private By petImgLink = By.cssSelector("img[alt='Pet parent with dog and dessert']");
	
	private String actualMarriageRegistryUrl;
	private String expectedMarriageRegistryUrl = "https://www.amazon.com/wedding?ref_=gr-landing-wedding";
	
	private String actualBabyRegistryUrl;
	private String expectedBabyRegistryUrl = "https://www.amazon.com/baby-reg?ref_=gr-landing-baby";
	
	private String actualBirthdayRegistryUrl;
	private String expectedBirthdayRegistryUrl = "https://www.amazon.com/registries/birthday?ref_=gr-landing-birthday";
	
	private String actualOccasionRegistryUrl;
	private String expectedOccasionRegistryUrl = "https://www.amazon.com/registries/custom?ref_=gr-landing-custom";
	
	private String actualGraduationRegistryUrl;
	private String expectedGraduationRegistryUrl = "https://www.amazon.com/registries/graduation?ref_=gr-landing-graduation";
	
	private String actualPetRegistryUrl;
	private String expectedPetRegistryUrl = "https://www.amazon.com/registries/pet?ref_=gr-landing-pet";
	
	public RegistriesPage(WebDriver driver) {
		this.driver = driver;
	} 
	
	public void clickMarriageImgLink() {
		driver.findElement(marriageImgLink).click();
		actualMarriageRegistryUrl = driver.getCurrentUrl();
		driver.navigate().back();
	}
	
	public void clickBabyImgLink() {
		driver.findElement(babyImgLink).click();
		actualBabyRegistryUrl = driver.getCurrentUrl();
		driver.navigate().back();
	}
	
	public void clickBirthdayImgLink() {
		driver.findElement(birthdayImgLink).click();
		actualBirthdayRegistryUrl = driver.getCurrentUrl();
		driver.navigate().back();
	}
	
	public void clickOccasionImgLink() {
		driver.findElement(occasionImgLink).click();
		actualOccasionRegistryUrl = driver.getCurrentUrl();
		driver.navigate().back();
	}
	
	public void clickGraduationImgLink() {
		driver.findElement(graduationImgLink).click();
		actualGraduationRegistryUrl = driver.getCurrentUrl();
		driver.navigate().back();
	}
	
	public void clickPetImgLink() {
		driver.findElement(petImgLink).click();
		actualPetRegistryUrl = driver.getCurrentUrl();
		driver.navigate().back();
	}
	
	public void assertCategoriesPages() {
		Assert.assertTrue(actualMarriageRegistryUrl.equals(expectedMarriageRegistryUrl) &&
							actualBabyRegistryUrl.equals(expectedBabyRegistryUrl) &&
							actualBirthdayRegistryUrl.equals(expectedBirthdayRegistryUrl) &&
							actualOccasionRegistryUrl.equals(expectedOccasionRegistryUrl) &&
							actualGraduationRegistryUrl.equals(expectedGraduationRegistryUrl) &&
							actualPetRegistryUrl.equals(expectedPetRegistryUrl));
	}
}
