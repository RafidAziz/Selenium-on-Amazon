package amazonSelenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class SearchSteps extends BaseTest{

	private String baseUrl = "https://www.amazon.com";
	private String searchResultsUrl = "https://www.amazon.com/s?k=ipad+mini+6&crid=19E0CL05GIZDJ&sprefix=ipad+mini+6%2Caps%2C336&ref=nb_sb_noss_2";
	private String prodDetailsUrl = "https://www.amazon.com/Mueller-Austria-Chopper-Vegetable-Container/dp/B08N9Q24M9/ref=pd_cart_vw_crc_d_sccl_1_1/134-8582275-1630743?pd_rd_w=f1ILy&content-id=amzn1.sym.1c2f7c10-4d4d-4813-8c51-1798e23c9a80&pf_rd_p=1c2f7c10-4d4d-4813-8c51-1798e23c9a80&pf_rd_r=FG0R4R2WK063355XWJZ1&pd_rd_wg=RE3fK&pd_rd_r=0143a164-d2d8-4a85-b0ed-9924ec76da4f&pd_rd_i=B08N9Q24M9&th=1";
	
//	@Before
//	public void setUp() {		
//        initializeDriverAndPages();
//	}
	
	// Search Product Steps
	@Given("User is on the home page")
	public void userIsOnHomePage() {
    	initializeDriverAndPages();
		navigateToHomePage(baseUrl);
	}
	
    @When ("User searches {string}")
    public void userSearchProduct (String productName) {
    	homePage.enterSearchTextbox(productName);
    }
    
    @When ("User clicks on the search button")
    public void userClickSearchBtn() {
    	homePage.clickSearchBtn();
    }
    
    @Then ("User should be redirected to the results page")
    public void userViewProducts() {
    	Assert.assertTrue(searchResultsPage.isSearchResultsDisplayed(), 
    			"Error: Search results not displayed");
    }
    
    
    // View Product Steps
    @Given ("User is on the amazon search results page")
	public void userIsOnSearchResultsPage() {
		navigateToURL(searchResultsUrl);
	}
    
    @When ("User clicks on a product")
    public void userClickProduct() {
    	searchResultsPage.clickProductDesc();
    }
	
	@Then ("User should be redirected to the product details page")
	public void userViewProductDetails() {
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.amazon.com/2021-Apple-iPad-Mini"), 
				"User is not directed to product details page");
	}
    
	// Scenario: Change product quantity
	@When ("User is on the product details page")
	public void userGoToprodDetailsPage() {
		waitTwoSeconds();
		navigateToURL(prodDetailsUrl);
	}
	
	@And ("User changes product quantity")
	public void userChangeProductQuantity() {
		prodDetailsPage.changeDropDownQuantityToTwo();
	}
	
	@Then ("User should see quantity is changed")
	public void userSeeQuantityChanged() {
		prodDetailsPage.assertDropDownQuantityIsTwo();
	}
	
	// Scenario: Verify Buy Now button
	@When ("User logs in with {string} and {string}")
    public void loginUser(String emailOrMobile, String password) {
        navigateToHomePage(baseUrl);
        homePage.clickSignInBtn();
        signInPage.enterEmailOrMobile(emailOrMobile);
        signInPage.clickContinueBtn();
        signInPage.enterPassword(password);
        signInPage.clickSignInBtn();
    }
	
	@And ("User clicks on Buy Now button")
	public void userClickBuyNowButton() {
		waitTwoSeconds();
		prodDetailsPage.clickBuyNowBtn();
	}

	@Then ("User should see the checkout page")
	public void userSeeCheckoutPage() {
		prodDetailsPage.assertBuyNow();
	}
	
	// Scenario: Verify seller name
	@And ("User clicks on Sold By link")
	public void userClickSoldByLink() {
		prodDetailsPage.clickSoldByLink();
	}
	
	@Then ("User should see the seller name")
	public void userSeeSellerName() {
		prodDetailsPage.assertSellerName();
	}
	
	// Scenario: Verify returns popup
	@And ("User clicks returns link")
	public void userClickReturnsLink() {
//		prodDetailsPage.clickRegularPriceRadioBtn();
		prodDetailsPage.clickReturnsLink();
	}
	
	@Then ("User should see popup of return policy")
	public void userSeePopupReturnPolicy() {
		prodDetailsPage.assertReturnsPolicy();
	}
	
	// Scenario: Verify payment popup
	@And ("User clicks payment link")
	public void userClickPaymentLink() {
		prodDetailsPage.clickPaymentLink();
	}
	
	@Then ("User should see popup of payment policy")
	public void userSeePopupPaymentPolicy() {
		prodDetailsPage.assertPaymentLearnMoreLink();
	}
	
	// Scenario: Verify report an issue function
	@And ("User clicks report an issue link")
	public void userClickReportAnIssueLink() {
		prodDetailsPage.clickReportAnIssueLink();
	}
	
	@Then ("User should see popup for reporting issues")
	public void userSeePopupForReportingIssues() {
		prodDetailsPage.assertReportAnIssue();
	}
	
	// Scenario: Verify page sections in product details page
//	@Then ("User should see customers also bought section")
//	public void userSeeCustomersAlsoBoughtSection() {
//		prodDetailsPage.assertCustomersAlsoBoughtSection();
//	}
	
	@Then ("User should see shop deals on related items")
	public void userSeeShopDealsOnRelatedItemstSection() {
	    prodDetailsPage.assertShopDealsOnRelatedItemsHeading();
	}

	@Then ("User should see frequently purchased items with fast delivery section")
	public void userSeeFrequentlyPurchasedItemsSection() {
	    prodDetailsPage.assertFrequentlyPurchasedItemsSectionHeading();
	}

	@Then ("User should see from the brand section")
	public void userSeeFromTheBrandSection() {
	    prodDetailsPage.assertFromTheBrandSectionHeading();
	}

	@Then ("User should see product description section")
	public void userSeeProductDescriptionSection() {
	    prodDetailsPage.assertProductDescriptionSectionHeading();
	}

	@Then ("User should see looking for specific info section")
	public void userSeeLookingForSpecificInfoSection() {
	    prodDetailsPage.assertLookingForSpecificInfoSectionHeading();
	}

	@Then ("User should see product information section")
	public void userSeeProductInfoSection() {
	    prodDetailsPage.assertProductInformationSectionHeading();
	}

	@Then ("User should see videos section")
	public void userSeeVideosSection() {
	    prodDetailsPage.assertVideosSectionHeading();
	}

	@Then ("User should see product guides and documents section")
	public void userSeeProductGuidesAndDocsSection() {
	    prodDetailsPage.assertProductGuidesAndDocumentsSectionHeading();
	}

	@Then ("User should see compare with similar items section")
	public void userShouldSeeCompareWithSimilarItemsSection() {
	    prodDetailsPage.assertCompareWithSimilarItemsSectionHeading();
	}

	@Then ("User should see inspiration from this brand section")
	public void userShouldSeeInspirationFromThisBrandSection() {
	    prodDetailsPage.assertInspirationFromThisBrandSectionHeading();
	}

	@Then ("User should see important information section")
	public void userShouldSeeImportantInformationSection() {
	    prodDetailsPage.assertImportantInformationSectionHeading();
	}

	@Then ("User should see products related to this item section")
	public void userShouldSeeProductsRelatedToThisItemSection() {
	    prodDetailsPage.assertProductsRelatedToThisItemSectionHeading();
	}

	@Then ("User should see similar brands on amazon section")
	public void userShouldSeeSimilarBrandsOnAmazonSection() {
	    prodDetailsPage.assertSimilarBrandsOnAmazonSectionHeading();
	}

	@Then ("User should see customer reviews section")
	public void userShouldSeeCustomerReviewsSection() {
	    prodDetailsPage.assertCustomerReviewsSectionHeading();
	}

	@Then ("User should see customers who bought this item also bought section")
	public void userShouldSeeCustomersWhoBoughtThisItemAlsoBoughtSection() {
	    prodDetailsPage.assertCustomersWhoBoughtThisItemAlsoBoughtSectionHeading();
	}

	@Then ("User should see best sellers in kitchen and dining section")
	public void userShouldSeeBestSellersInKitchenAndDiningSection() {
	    prodDetailsPage.assertBestSellersInKitchenAndDiningSectionHeading();
	}

	@Then ("User should see customers who viewed items in your browsing history also viewed section")
	public void userShouldSeeCustomersWhoViewedItemsInYourBrowsingHistoryAlsoViewedSection() {
	    prodDetailsPage.assertCustomersWhoViewedItemsInYourBrowsingHistoryAlsoViewedSectionHeading();
	}
	
	@Then ("User should see your browsing history section")
	public void userShouldSeeYourBrowsingHistorySection() {
		scrollToBottomOfPage();
		prodDetailsPage.assertYourBrowsingHistorySectionHeading();
	}

	// 	Scenario: Verify navigation header in product details page
	// Step definition for scrolling down the page
	@When("User scrolls down")
	public void userScrollsDown() {
	    scrollToBottomOfPage();
	}

	// Step definition for verifying navigation header visibility
	@Then("User should see navigation header appear on the top")
	public void userShouldSeeNavigationHeader() {
	    prodDetailsPage.assertNavigationHeaderDisplayed();
	}

	// Step definition for verifying top link visibility
	@Then("User should see top link")
	public void userShouldSeeTopLink() {
	    prodDetailsPage.assertTopLinkDisplayed();
	}

	// Step definition for verifying 'About this item' link visibility
	@Then("User should see about this item link")
	public void userShouldSeeAboutThisItemLink() {
	    prodDetailsPage.assertAboutThisItemLinkDisplayed();
	}

	// Step definition for verifying 'Similar' link visibility
	@Then("User should see similar link")
	public void userShouldSeeSimilarLink() {
	    prodDetailsPage.assertSimilarLinkDisplayed();
	}

	// Step definition for verifying 'Questions' link visibility
	@Then("User should see questions link")
	public void userShouldSeeQuestionsLink() {
	    prodDetailsPage.assertQuestionsLinkDisplayed();
	}

	// Step definition for verifying 'Product information' link visibility
	@Then("User should see product information link")
	public void userShouldSeeProductInfoLink() {
	    prodDetailsPage.assertProductInfoLinkDisplayed();
	}

	// Step definition for verifying 'Reviews' link visibility
	@Then("User should see reviews link")
	public void userShouldSeeReviewsLink() {
	    prodDetailsPage.assertReviewsLinkDisplayed();
	}
	
	// 	Scenario: Verify navigation footer headings and links in product details page
	@Then ("User should see get to know us heading and links")
	public void userShouldSeeGetToKnowUsHeadingAndLinks() {		
		prodDetailsPage.assertGetToKnowUsHeadingIsDisplayed();
		prodDetailsPage.assertCareersLinkIsDisplayed();
		prodDetailsPage.assertBlogLinkIsDisplayed();
		prodDetailsPage.assertAboutAmazonLinkIsDisplayed();
		prodDetailsPage.assertInvestorRelationsLinkIsDisplayed();
		prodDetailsPage.assertAmazonDevicesLinkIsDisplayed();
		prodDetailsPage.assertAmazonScienceLinkIsDisplayed();
	}
	
	@Then ("User should see make money with us heading and links")
	public void userShouldSeeMakeMoneyWithUsHeadingAndLinks() {
	    prodDetailsPage.assertMakeMoneyWithUsHeadingIsDisplayed();
	    prodDetailsPage.assertSellProductsLinkIsDisplayed();
	    prodDetailsPage.assertSellOnBusinessLinkIsDisplayed();
	    prodDetailsPage.assertSellAppsLinkIsDisplayed();
	    prodDetailsPage.assertBecomeAffiliateLinkIsDisplayed();
	    prodDetailsPage.assertAdvertiseProductsLinkIsDisplayed();
	    prodDetailsPage.assertSelfPublishLinkIsDisplayed();
	    prodDetailsPage.assertHostHubLinkIsDisplayed();
	    prodDetailsPage.assertSeeMoreLinkIsDisplayed();
	}
	
	
	@Then ("User should see amazon payment products heading and links")
	public void userShouldSeeAmazonPaymentProductsHeadingAndLinks() {
	    prodDetailsPage.assertAmazonPaymentProductsHeadingIsDisplayed();
	    prodDetailsPage.assertAmazonBusinessCardLinkIsDisplayed();
	    prodDetailsPage.assertShopWithPointsLinkIsDisplayed();
	    prodDetailsPage.assertReloadYourBalanceLinkIsDisplayed();
	    prodDetailsPage.assertAmazonCurrencyConverterLinkIsDisplayed();
	}
	
	@Then("User should see let us help you heading and links")
	public void userShouldSeeLetUsHelpYouHeadingAndLinks() {
	    prodDetailsPage.assertLetUsHelpYouHeadingIsDisplayed();
	    prodDetailsPage.assertAmazonCovidLinkIsDisplayed();
	    prodDetailsPage.assertYourAccountLinkIsDisplayed();
	    prodDetailsPage.assertYourOrdersLinkIsDisplayed();
	    prodDetailsPage.assertShippingRatesPoliciesLinkIsDisplayed();
	    prodDetailsPage.assertReturnsReplacementsLinkIsDisplayed();
	    prodDetailsPage.assertManageContentDevicesLinkIsDisplayed();
	    prodDetailsPage.assertHelpLinkIsDisplayed();
	}
	
	// Scenario: Verify product variations in product details page
	@Then ("User should see the available product variation options")
	public void userShouldSeeTheAvailableProductVariationOptions() {
		prodDetailsPage.assert2BladeButtonIsDisplayed();
		prodDetailsPage.assert8BladeButtonIsDisplayed();
		prodDetailsPage.assert12BladeButtonIsDisplayed();
	}

	@And ("Each option should be clickable")
	public void eachOptionShouldBeClickable() {
		prodDetailsPage.assert2BladeButtonIsEnabled();
		prodDetailsPage.assert8BladeButtonIsEnabled();
		prodDetailsPage.assert12BladeButtonIsEnabled();
	}

	@When ("User selects product variations")
	public void userSelectsProductVariations() {
		prodDetailsPage.click2BladeButton();
		prodDetailsPage.click8BladeButton();
		prodDetailsPage.click12BladeButton();
	}

	@Then ("The selected variation should be highlighted")
	public void theSelectedVariationShouldBeHighlighted() {
		prodDetailsPage.click2BladeButton();
		prodDetailsPage.assertSize2BladeTextIsDisplayed();
		
		prodDetailsPage.click8BladeButton();
		prodDetailsPage.assertSize8BladeTextIsDisplayed();

		prodDetailsPage.click12BladeButton();
		prodDetailsPage.assertSize12BladeTextIsDisplayed();
		
		prodDetailsPage.click2BladeButton();
	}

	@Then ("The price should update according to the selected variation")
	public void thePriceShouldUpdateAccordingToTheSelectedVariation() {
		//stopped here
		prodDetailsPage.setInitialPrice();
		
		prodDetailsPage.click8BladeButton();
		prodDetailsPage.setUpdatedPrice();
		prodDetailsPage.assertPriceDiffThanInitialPrice();
		
		prodDetailsPage.click12BladeButton();
		prodDetailsPage.setUpdatedPrice();
		prodDetailsPage.assertPriceDiffThanInitialPrice();
		
		prodDetailsPage.click2BladeButton();
	}

	@Then ("The main product image should update to reflect the selected variation")
	public void theMainProductImageShouldUpdateToReflectTheSelectedVariation() {
		prodDetailsPage.setInitialImgSrc(); 
		
		prodDetailsPage.click8BladeButton();
		prodDetailsPage.setUpdatedImgSrc();
		prodDetailsPage.assertImgSrcDiffThanInitial(); // fail here
		
		prodDetailsPage.click12BladeButton();
		prodDetailsPage.setUpdatedImgSrc();
		prodDetailsPage.assertImgSrcDiffThanInitial();
	}
	
	@After
	public void tearDown() {
		if (driver!= null) {
			driver.quit();
		}
	}
}
