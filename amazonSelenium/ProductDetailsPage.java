package amazonSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class ProductDetailsPage extends BaseTest {

	private WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	private String checkoutPageUrl = "https://www.amazon.com/gp/buy/addressselect/handlers/display.html?_from=cheetah";
	private String expectedSeller;
	private String actualSeller;
	private String returnsPolicyUrl = "https://www.amazon.com/gp/help/customer/display.html?nodeId=GKM69DUUYKQWKWX7&ref_=dp_ret_policy";
	private String privacyNoticeUrl = "https://www.amazon.com/gp/help/customer/display.html?nodeId=201909010";
	private String prodPrice;
	private String prodQty;
	private String initialPrice;
	private String updatedPrice;
	private String initialImgSrc;
	private String updatedImgSrc;
	
	private By addToCartBtn = By.id("add-to-cart-button");
	private By addedtoCartMsg = By.cssSelector("h1[class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']");
	private By quantityDropDown = By.cssSelector(".a-dropdown-label");
	private By quantityDropDownNum = By.cssSelector("span[id='a-autoid-2-announce'] span[class='a-dropdown-prompt']");
	private By quantity2DropDown = By.id("quantity_1");
	private By buyNowBtn = By.id("buy-now-button");
	private By regularPriceRadioBtn = By.cssSelector("div[id='newAccordionRow_1'] i[class='a-icon a-accordion-radio a-icon-radio-inactive']");
	private By soldByLink = By.id("sellerProfileTriggerId");
	private By sellerNameLabel = By.id("seller-name");
	
	private By returnsLink = By.cssSelector("a[data-csa-c-content-id='odf-desktop-return-info'] span[class='a-size-small offer-display-feature-text-message']");
	private By returnHeading = By.cssSelector("div[data-csa-c-content-id='desktop-return-info'] span[class='a-text-bold']");
	private By returnDesc = By.cssSelector("div[id='a-popover-4'] div[class='a-section a-padding-base'] div:nth-child(1)");
	private By fullReturnPolicyLink = By.xpath("//div[@class='a-section a-padding-base']//a[@id='desktop-return-info-link-text']");
	
	private By paymentLink = By.xpath("//span[@class='a-size-small offer-display-feature-text-message'][normalize-space()='Secure transaction']");
	private By paymentHeading = By.xpath("//span[normalize-space()='Your transaction is secure']");
	private By paymentLearnMoreLink = By.xpath("//div[contains(text(),'We work hard to protect your security and privacy.')]//span[contains(text(),'Learn more')]");
	
	private By reportIssueLink = By.cssSelector("._tell-amazon-desktop_style_tell_amazon_link__1KW5z");
	private By reportAnIssueHeading = By.xpath("//h4[normalize-space()='Report an issue']");
	private By chooseDropDown = By.cssSelector("span[class='a-button a-button-dropdown a-spacing-base a-button-span12'] span[class='a-button-text a-declarative']");
	private By problemWithOrderOption = By.id("tellAmazon_firstLevelDropdown_0");
	private String problemWithOrderText = "There’s a problem with my order";
	private By prodInfoMissingOption = By.id("tellAmazon_firstLevelDropdown_1");
	private String prodInfoMissingText = "Some product information is missing, inaccurate or could be improved";
	private By partsMismatchOption = By.id("tellAmazon_firstLevelDropdown_2");
	private String partsMismatchText = "Parts of this page don't match";
	private By issueWithPriceOption = By.id("tellAmazon_firstLevelDropdown_3");
	private String issueWithPriceText = "I have an issue with the price";
	private By prodOffensiveOption = By.id("tellAmazon_firstLevelDropdown_4");
	private String prodOffensiveText = "This product or content is offensive";
	private By prodIllegalOption = By.id("tellAmazon_firstLevelDropdown_5");
	private String prodIllegalText = "This product or content is illegal, unsafe or suspicious";
	private By issueWithSellerOption = By.id("tellAmazon_firstLevelDropdown_6");
	private String issueWithSellerText = "I have an issue with a Seller";
	private By otherOption = By.id("tellAmazon_firstLevelDropdown_7");
	private String otherText = "Other";
	
	// Sections locators
	private By customersAlsoBoughtSectionHeading = By.cssSelector("div#customers_also_bought");
	private By shopDealsOnRelatedItemsHeading = By.cssSelector("div[id='CardInstanceBJ5AuiQJ9nOeypc5ZAAfiw'] div[class='a-section a-spacing-large bucket'] div h2[class='a-carousel-heading a-inline-block']");
	private By frequentlyPurchasedItemsSectionHeading = By.cssSelector("div[id='CardInstancew_KP2n-bVleZyWv5h8nUUg'] div[class='a-section a-spacing-large bucket'] div h2[class='a-carousel-heading a-inline-block']");
	private By fromTheBrandSectionHeading = By.cssSelector("div[id='aplusBrandStory_feature_div'] h2");
	private By productDescriptionSectionHeading = By.cssSelector("div[id='aplus_feature_div'] h2");
	private By lookingForSpecificInfoSectionHeading = By.cssSelector("h3[class='a-color-base']");
	private By productInformationSectionHeading = By.cssSelector("body div[id='a-page'] div[id='dp'] div[id='dp-container'] div[id='Desktop-Detailed-Evaluation-Zone'] div[id='productDetails_feature_div'] div div[id='prodDetails'] h2:nth-child(1)");
	private By videosSectionHeading = By.xpath("//h2[normalize-space()='Videos']");
	private By productGuidesAndDocumentsSectionHeading = By.xpath("//h2[normalize-space()='Product guides and documents']");
	private By compareWithSimilarItemsSectionHeading = By.xpath("//h2[normalize-space()='Compare with similar items']");
	private By inspirationFromThisBrandSectionHeading = By.xpath("//h2[normalize-space()='Inspiration from this brand']");
	private By importantInformationSectionHeading = By.xpath("//h2[normalize-space()='Important information']");
	private By productsRelatedToThisItemSectionHeading = By.xpath("//h2[normalize-space()='Products related to this item']");
	private By similarBrandsOnAmazonSectionHeading = By.xpath("//h2[normalize-space()='Similar brands on Amazon']");
	private By customerReviewsSectionHeading = By.xpath("//h2[normalize-space()='Customer reviews']");
	private By customersWhoBoughtThisItemAlsoBoughtSectionHeading = By.xpath("//h2[normalize-space()='Customers who bought this item also bought']");
	private By bestSellersInKitchenAndDiningSectionHeading = By.xpath("//h2[normalize-space()='Best Sellers in Kitchen & Dining']");
	private By customersWhoViewedItemsInYourBrowsingHistoryAlsoViewedSectionHeading = By.xpath("//h2[contains(text(),'Customers who viewed items in your browsing histor')]");
	private By yourBrowsingHistorySectionHeading = By.xpath("//h2[normalize-space()='Your Browsing History']");

	// Top navigation header locators (appears when user scrolls down page)
	private By navigationHeader = By.id("btf-sub-nav-desktop-tabs");
	private By topLink = By.xpath("//div[@class='top-tab-content']//div[1]");
	private By aboutThisItemLink = By.xpath("//span[normalize-space()='About this item']");
	private By similarLink = By.xpath("//span[normalize-space()='Similar']");
	private By questionsLink = By.xpath("//span[normalize-space()='Questions']");
	private By productInfoLink = By.xpath("//span[normalize-space()='Product information']");
	private By reviewsLink = By.xpath("//span[normalize-space()='Reviews']");
	
	// Footer navigation headings and links
		// Get To Know Us section
	private By getToKnowUsHeading = By.xpath("//div[normalize-space()='Get to Know Us']");
	private By careersLink = By.xpath("//div[@id='navFooter']//a[normalize-space()='Careers']");
	private By blogLink = By.xpath("//div[@id='navFooter']//a[normalize-space()='Blog']");
	private By aboutAmazonLink = By.xpath("//div[@id='navFooter']//a[normalize-space()='About Amazon']");
	private By investorRelationsLink = By.xpath("//div[@id='navFooter']//a[normalize-space()='Investor Relations']");
	private By amazonDevicesLink = By.xpath("//div[@id='navFooter']//a[normalize-space()='Amazon Devices']");
	private By amazonScienceLink = By.xpath("//div[@id='navFooter']//a[normalize-space()='Amazon Science']");

		// Make Money with Us section
	private By makeMoneyWithUsHeading = By.xpath("//div[normalize-space()='Make Money with Us']");
	private By sellProductsLink = By.xpath("//div[@role='heading' and text()='Make Money with Us']/following-sibling::ul/li/a[normalize-space()='Sell products on Amazon']");
	private By sellOnBusinessLink = By.xpath("//div[@role='heading' and text()='Make Money with Us']/following-sibling::ul/li/a[normalize-space()='Sell on Amazon Business']");
	private By sellAppsLink = By.xpath("//div[@role='heading' and text()='Make Money with Us']/following-sibling::ul/li/a[normalize-space()='Sell apps on Amazon']");
	private By becomeAffiliateLink = By.xpath("//div[@role='heading' and text()='Make Money with Us']/following-sibling::ul/li/a[normalize-space()='Become an Affiliate']");
	private By advertiseProductsLink = By.xpath("//div[@role='heading' and text()='Make Money with Us']/following-sibling::ul/li/a[normalize-space()='Advertise Your Products']");
	private By selfPublishLink = By.xpath("//div[@role='heading' and text()='Make Money with Us']/following-sibling::ul/li/a[normalize-space()='Self-Publish with Us']");
	private By hostHubLink = By.xpath("//div[@role='heading' and text()='Make Money with Us']/following-sibling::ul/li/a[normalize-space()='Host an Amazon Hub']");
	private By seeMoreLink = By.xpath("//div[@role='heading' and text()='Make Money with Us']/following-sibling::ul/li/a[contains(text(), 'See More Make Money with Us')]");
	
		// Amazon Payment Products section
	private By amazonPaymentProductsHeading = By.xpath("//div[normalize-space()='Amazon Payment Products']");
	private By amazonBusinessCardLink = By.xpath("//div[@id='navFooter']//a[normalize-space()='Amazon Business Card']");
	private By shopWithPointsLink = By.xpath("//div[@id='navFooter']//a[normalize-space()='Shop with Points']");
	private By reloadYourBalanceLink = By.xpath("//div[@id='navFooter']//a[normalize-space()='Reload Your Balance']");
	private By amazonCurrencyConverterLink = By.xpath("//div[@id='navFooter']//a[normalize-space()='Amazon Currency Converter']");

		// Let Us Help You section
	private By letUsHelpYouHeading = By.xpath("//div[normalize-space()='Let Us Help You']");
	private By amazonCovidLink = By.xpath("//div[@id='navFooter']//a[normalize-space()='Amazon and COVID-19']");
	private By yourAccountLink = By.xpath("//div[@id='navFooter']//a[normalize-space()='Your Account']");
	private By yourOrdersLink = By.xpath("//div[@id='navFooter']//a[normalize-space()='Your Orders']");
	private By shippingRatesPoliciesLink = By.xpath("//div[@id='navFooter']//a[normalize-space()='Shipping Rates & Policies']");
	private By returnsReplacementsLink = By.xpath("//div[@id='navFooter']//a[normalize-space()='Returns & Replacements']");
	private By manageContentDevicesLink = By.xpath("//div[@id='navFooter']//a[normalize-space()='Manage Your Content and Devices']");
	private By helpLink = By.xpath("//div[@id='navFooter']//a[normalize-space()='Help']");

	// Locators for product variations
	private By twoBladeButton = By.xpath("//p[normalize-space()='2 Blade']");
	private By eightBladeButton = By.xpath("//p[normalize-space()='8 Blade']");
	private By twelveBladeButton = By.xpath("//p[normalize-space()='12 Blade']");
	private By priceWholeMiddle = By.xpath("//div[@id='apex_desktop_newAccordionRow']//span[@class='a-price-whole']");
	private By priceFractionMiddle = By.xpath("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@class='a-price-fraction'][normalize-space()='97']");
	private By priceWholeBuyNew = By.xpath("//div[@data-csa-c-buying-option-type='NEW']//span[@class='a-price-whole']");
	private By mainProductImg = By.xpath("//body[1]/div[1]/div[1]/div[9]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/ul[1]/li[5]/span[1]/span[1]/span[1]/span[1]/img[1]");
	private By size2BladeText = By.xpath("//span[@class='selection'][normalize-space()='2 Blade']");
	private By size8BladeText = By.xpath("//span[@class='selection'][normalize-space()='8 Blade']");
	private By size12BladeText = By.xpath("//span[@class='selection'][normalize-space()='12 Blade']");
	
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
	}  
	
	public String getProdPrice() {
		return prodPrice;
	}
	
	public String getProdQty() {
		return prodQty;
	}
	
	public void setProdPrice() {
		waitTwoSeconds();
		prodPrice = "$" + driver.findElement(priceWholeMiddle).getText() + "." + driver.findElement(priceFractionMiddle).getText();
	}
	
	public void setInitialPrice() {
		waitTwoSeconds();
		initialPrice = driver.findElement(priceWholeMiddle).getText();
	}
	
	public void setUpdatedPrice() {
		waitTwoSeconds();
		updatedPrice = driver.findElement(priceWholeMiddle).getText();
	}
	
	public void setInitialImgSrc() {
		waitTwoSeconds();
		waitTwoSeconds();
		initialImgSrc = driver.findElement(mainProductImg).getAttribute("src");
	}
	
	public void setUpdatedImgSrc() {
		waitTwoSeconds();
		waitTwoSeconds();
		updatedImgSrc = driver.findElement(mainProductImg).getAttribute("src");
	}
	
	public void setProdQty() {
		waitTwoSeconds();
		waitTwoSeconds();
		prodQty = driver.findElement(quantityDropDownNum).getText();
	}
	
	// click add to cart button
	public void clickAddToCartBtn() {
		driver.findElement(addToCartBtn).click();
	}
	
	public void clickBuyNowBtn() {
		driver.findElement(buyNowBtn).click();
	}
	
	public void clickRegularPriceRadioBtn() {
		if (driver.findElement(regularPriceRadioBtn).isDisplayed()) {
			driver.findElement(regularPriceRadioBtn).click();
		}
	}
	
	public void clickSoldByLink() {
		expectedSeller = driver.findElement(soldByLink).getText();
		driver.findElement(soldByLink).click();
		
	}
	
	public void clickReturnsLink() {
		driver.findElement(returnsLink).click();
	}
	
	public void clickFullReturnPolicyLink() {
		driver.findElement(fullReturnPolicyLink).click();
	}
	
	public void clickPaymentLink() {
		driver.findElement(paymentLink).click();
	}
	
	public void clickPaymentLearnMoreLink() {
		driver.findElement(paymentLearnMoreLink).click();
	}
	
	public void clickReportAnIssueLink() {
		driver.findElement(reportIssueLink).click();
	}
	
	public void clickReportAnIssueDropDown() {
		driver.findElement(chooseDropDown).click();
	}
	
	public void click2BladeButton() {
		driver.findElement(twoBladeButton).click();
	}
	
	public void click8BladeButton() {
		driver.findElement(eightBladeButton).click();
	}
	
	public void click12BladeButton() {
		driver.findElement(twelveBladeButton).click();
	}
	
	// get 'added to cart' text
	public String getAddedToCartText() {
//		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.findElement(addedtoCartMsg).getText());
		return driver.findElement(addedtoCartMsg).getText();
	}
	
	public void changeDropDownQuantityToTwo() {
		// stopped debugging here
		retryLocatingDynamicElement(driver, quantityDropDown);
		driver.findElement(quantity2DropDown).click();
	}
	
	public void assertDropDownQuantityIsTwo() {
		Assert.assertTrue(driver.findElement(quantityDropDown).getText().contains("2"), "Quantity is not changed to 2.");
	}
	
	public void assertBuyNow() {
		Assert.assertTrue(driver.getCurrentUrl().equals(checkoutPageUrl), "User is not in checkout page. Actual page: " + driver.getCurrentUrl());
	}
	
	public void assertSellerName() {
		actualSeller = driver.findElement(sellerNameLabel).getText();
		Assert.assertTrue(actualSeller.contains(expectedSeller), "Seller name does not match.");
	}
	
	public void assertReturnsPolicy() {
		waitTwoSeconds();
		Assert.assertTrue(driver.findElement(returnDesc).isDisplayed(), "Returns description is not displayed.");
		retryClickingReturnPolicyLink();
		switchToNewTab(driver);
		waitTwoSeconds();
		Assert.assertTrue(driver.getCurrentUrl().contains(returnsPolicyUrl), "Returns policy URL is not correct: " + driver.getCurrentUrl());
	}
	
	public void assertPaymentLearnMoreLink() {
		waitTwoSeconds();
		Assert.assertTrue(driver.findElement(paymentHeading).isDisplayed(), "Payment heading is not displayed.");
		retryClickingPaymentLearnMoreLink();
		switchToNewTab(driver);
		waitTwoSeconds();
		Assert.assertTrue(driver.getCurrentUrl().contains(privacyNoticeUrl), "Privacy notice URL is not correct: " + driver.getCurrentUrl());
	}
	
	public void assertReportAnIssueDropDownOptions() {
		Assert.assertEquals(driver.findElement(problemWithOrderOption).getText(), problemWithOrderText, "Option 1 mismatch.");
		Assert.assertEquals(driver.findElement(prodInfoMissingOption).getText(), prodInfoMissingText, "Option 2 mismatch.");
		Assert.assertEquals(driver.findElement(partsMismatchOption).getText(), partsMismatchText, "Option 3 mismatch.");
		Assert.assertEquals(driver.findElement(issueWithPriceOption).getText(), issueWithPriceText, "Option 4 mismatch.");
		Assert.assertEquals(driver.findElement(prodOffensiveOption).getText(), prodOffensiveText, "Option 5 mismatch.");
		Assert.assertEquals(driver.findElement(prodIllegalOption).getText(), prodIllegalText, "Option 6 mismatch.");
		Assert.assertEquals(driver.findElement(issueWithSellerOption).getText(), issueWithSellerText, "Option 7 mismatch.");
		Assert.assertEquals(driver.findElement(otherOption).getText(), otherText, "Option 8 mismatch.");
	}
	
	public void assertReportAnIssue() {
		waitTwoSeconds();
		Assert.assertTrue(driver.findElement(reportAnIssueHeading).isDisplayed(), "Report an issue heading is not displayed.");
		Assert.assertTrue(driver.findElement(chooseDropDown).isDisplayed(), "Report an issue drop down is not displayed.");
		clickReportAnIssueDropDown();
		assertReportAnIssueDropDownOptions();
	}
	
	public void retryClickingReturnPolicyLink() {
		while (true) {
			try {
				driver.navigate().refresh();
				clickReturnsLink();
				clickFullReturnPolicyLink();
				break;
			} catch (ElementNotInteractableException e) {
	            System.out.println("Element not interactable, retrying...");
	            waitTwoSeconds();
			}
		}
	}
	
	public void retryClickingPaymentLearnMoreLink() {
		while (true) {
			try {
				driver.navigate().refresh();
				clickPaymentLink();
				clickPaymentLearnMoreLink();
				break;
			} catch (ElementNotInteractableException e) {
	            System.out.println("Element not interactable, retrying...");
	            waitTwoSeconds();
			}
		}
	}
	
	public void assertShopDealsOnRelatedItemsHeading() {
	    try {
	        WebElement element = driver.findElement(shopDealsOnRelatedItemsHeading);
	        softAssert.assertTrue(element.isDisplayed(), "Shop Deals on Related Items heading is not displayed");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        softAssert.fail("Shop Deals on Related Items heading assertion failed");
	    }
	}

	public void assertFrequentlyPurchasedItemsSectionHeading() {
	    try {
	        WebElement element = driver.findElement(frequentlyPurchasedItemsSectionHeading);
	        softAssert.assertTrue(element.isDisplayed(), "Frequently Purchased Items section heading is not displayed");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        softAssert.fail("Frequently Purchased Items section heading assertion failed");
	    }
	}

	public void assertFromTheBrandSectionHeading() {
	    try {
	        WebElement element = driver.findElement(fromTheBrandSectionHeading);
	        softAssert.assertTrue(element.isDisplayed(), "From the Brand section heading is not displayed");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        softAssert.fail("From the Brand section heading assertion failed");
	    }
	}

	public void assertProductDescriptionSectionHeading() {
	    try {
	        WebElement element = driver.findElement(productDescriptionSectionHeading);
	        softAssert.assertTrue(element.isDisplayed(), "Product Description section heading is not displayed");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        softAssert.fail("Product Description section heading assertion failed");
	    }
	}

	public void assertLookingForSpecificInfoSectionHeading() {
	    try {
	        WebElement element = driver.findElement(lookingForSpecificInfoSectionHeading);
	        softAssert.assertTrue(element.isDisplayed(), "Looking for Specific Info section heading is not displayed");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        softAssert.fail("Looking for Specific Info section heading assertion failed");
	    }
	}

	public void assertProductInformationSectionHeading() {
	    try {
	        WebElement element = driver.findElement(productInformationSectionHeading);
	        softAssert.assertTrue(element.isDisplayed(), "Product Information section heading is not displayed");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        softAssert.fail("Product Information section heading assertion failed");
	    }
	}

	public void assertVideosSectionHeading() {
	    try {
	        WebElement element = driver.findElement(videosSectionHeading);
	        softAssert.assertTrue(element.isDisplayed(), "Videos section heading is not displayed");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        softAssert.fail("Videos section heading assertion failed");
	    }
	}

	public void assertProductGuidesAndDocumentsSectionHeading() {
	    try {
	        WebElement element = driver.findElement(productGuidesAndDocumentsSectionHeading);
	        softAssert.assertTrue(element.isDisplayed(), "Product Guides and Documents section heading is not displayed");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        softAssert.fail("Product Guides and Documents section heading assertion failed");
	    }
	}

	public void assertCompareWithSimilarItemsSectionHeading() {
	    try {
	        WebElement element = driver.findElement(compareWithSimilarItemsSectionHeading);
	        softAssert.assertTrue(element.isDisplayed(), "Compare with Similar Items section heading is not displayed");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        softAssert.fail("Compare with Similar Items section heading assertion failed");
	    }
	}

	public void assertInspirationFromThisBrandSectionHeading() {
	    try {
	        WebElement element = driver.findElement(inspirationFromThisBrandSectionHeading);
	        softAssert.assertTrue(element.isDisplayed(), "Inspiration from this Brand section heading is not displayed");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        softAssert.fail("Inspiration from this Brand section heading assertion failed");
	    }
	}

	public void assertImportantInformationSectionHeading() {
	    try {
	        WebElement element = driver.findElement(importantInformationSectionHeading);
	        softAssert.assertTrue(element.isDisplayed(), "Important Information section heading is not displayed");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        softAssert.fail("Important Information section heading assertion failed");
	    }
	}
	
	public void assertProductsRelatedToThisItemSectionHeading() {
	    try {
	        WebElement element = driver.findElement(productsRelatedToThisItemSectionHeading);
	        softAssert.assertTrue(element.isDisplayed(), "Products Related to this Item section heading is not displayed");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        softAssert.fail("Products Related to this Item section heading assertion failed");
	    }
	}

	public void assertSimilarBrandsOnAmazonSectionHeading() {
	    try {
	        WebElement element = driver.findElement(similarBrandsOnAmazonSectionHeading);
	        softAssert.assertTrue(element.isDisplayed(), "Similar Brands on Amazon section heading is not displayed");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        softAssert.fail("Similar Brands on Amazon section heading assertion failed");
	    }
	}

	public void assertCustomerReviewsSectionHeading() {
	    try {
	        WebElement element = driver.findElement(customerReviewsSectionHeading);
	        softAssert.assertTrue(element.isDisplayed(), "Customer Reviews section heading is not displayed");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        softAssert.fail("Customer Reviews section heading assertion failed");
	    }
	}

	public void assertCustomersWhoBoughtThisItemAlsoBoughtSectionHeading() {
	    try {
	        WebElement element = driver.findElement(customersWhoBoughtThisItemAlsoBoughtSectionHeading);
	        softAssert.assertTrue(element.isDisplayed(), "Customers who bought this item also bought section heading is not displayed");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        softAssert.fail("Customers who bought this item also bought section heading assertion failed");
	    }
	}

	public void assertBestSellersInKitchenAndDiningSectionHeading() {
	    try {
	        WebElement element = driver.findElement(bestSellersInKitchenAndDiningSectionHeading);
	        softAssert.assertTrue(element.isDisplayed(), "Best Sellers in Kitchen and Dining section heading is not displayed");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        softAssert.fail("Best Sellers in Kitchen and Dining section heading assertion failed");
	    }
	}

	public void assertCustomersWhoViewedItemsInYourBrowsingHistoryAlsoViewedSectionHeading() {
	    try {
	        WebElement element = driver.findElement(customersWhoViewedItemsInYourBrowsingHistoryAlsoViewedSectionHeading);
	        softAssert.assertTrue(element.isDisplayed(), "Customers who viewed items in your browsing history also viewed section heading is not displayed");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        softAssert.fail("Customers who viewed items in your browsing history also viewed section heading assertion failed");
	    }
	}

	public void assertYourBrowsingHistorySectionHeading() {
	    try {
	        WebElement element = driver.findElement(yourBrowsingHistorySectionHeading);
	        softAssert.assertTrue(element.isDisplayed(), "Your Browsing History section heading is not displayed");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        softAssert.fail("Your Browsing History section heading assertion failed");
	    } finally {
	    	softAssert.assertAll("Important note: This test case is expected to fail as sections are dynamic."); // This ensures that any soft assertion failures are reported in Cucumber	
	    }
	}
	
	// Assertions for Top navigation header locators (appears when user scrolls down page)
	// Assertion for navigation header
	public void assertNavigationHeaderDisplayed() {
	    WebElement element = driver.findElement(navigationHeader);
	    Assert.assertTrue(element.isDisplayed(), "Navigation header is not displayed");
	}

	// Assertion for top link
	public void assertTopLinkDisplayed() {
	    WebElement element = driver.findElement(topLink);
	    Assert.assertTrue(element.isDisplayed(), "Top link is not displayed");
	}

	// Assertion for 'About this item' link
	public void assertAboutThisItemLinkDisplayed() {
	    WebElement element = driver.findElement(aboutThisItemLink);
	    Assert.assertTrue(element.isDisplayed(), "'About this item' link is not displayed");
	}

	// Assertion for 'Similar' link
	public void assertSimilarLinkDisplayed() {
	    WebElement element = driver.findElement(similarLink);
	    Assert.assertTrue(element.isDisplayed(), "'Similar' link is not displayed");
	}

	// Assertion for 'Questions' link
	public void assertQuestionsLinkDisplayed() {
	    WebElement element = driver.findElement(questionsLink);
	    Assert.assertTrue(element.isDisplayed(), "'Questions' link is not displayed");
	}

	// Assertion for 'Product information' link
	public void assertProductInfoLinkDisplayed() {
	    WebElement element = driver.findElement(productInfoLink);
	    Assert.assertTrue(element.isDisplayed(), "'Product information' link is not displayed");
	}

	// Assertion for 'Reviews' link
	public void assertReviewsLinkDisplayed() {
	    WebElement element = driver.findElement(reviewsLink);
	    Assert.assertTrue(element.isDisplayed(), "'Reviews' link is not displayed");
	}
	
	// Assertions for footer navigation sections
	public void assertGetToKnowUsHeadingIsDisplayed() {
	    Assert.assertTrue(driver.findElement(getToKnowUsHeading).isDisplayed(), "Get To Know Us heading is not displayed.");
	}

	public void assertCareersLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(careersLink).isDisplayed(), "Careers link is not displayed.");
	}

	public void assertBlogLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(blogLink).isDisplayed(), "Blog link is not displayed.");
	}

	public void assertAboutAmazonLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(aboutAmazonLink).isDisplayed(), "About Amazon link is not displayed.");
	}

	public void assertInvestorRelationsLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(investorRelationsLink).isDisplayed(), "Investor Relations link is not displayed.");
	}

	public void assertAmazonDevicesLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(amazonDevicesLink).isDisplayed(), "Amazon Devices link is not displayed.");
	}

	public void assertAmazonScienceLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(amazonScienceLink).isDisplayed(), "Amazon Science link is not displayed.");
	}

	public void assertMakeMoneyWithUsHeadingIsDisplayed() {
	    Assert.assertTrue(driver.findElement(makeMoneyWithUsHeading).isDisplayed(), "Make Money with Us heading is not displayed.");
	}

	public void assertSellProductsLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(sellProductsLink).isDisplayed(), "Sell Products on Amazon link is not displayed.");
	}

	public void assertSellOnBusinessLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(sellOnBusinessLink).isDisplayed(), "Sell on Amazon Business link is not displayed.");
	}

	public void assertSellAppsLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(sellAppsLink).isDisplayed(), "Sell Apps on Amazon link is not displayed.");
	}

	public void assertBecomeAffiliateLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(becomeAffiliateLink).isDisplayed(), "Become an Affiliate link is not displayed.");
	}

	public void assertAdvertiseProductsLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(advertiseProductsLink).isDisplayed(), "Advertise Your Products link is not displayed.");
	}

	public void assertSelfPublishLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(selfPublishLink).isDisplayed(), "Self-Publish with Us link is not displayed.");
	}

	public void assertHostHubLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(hostHubLink).isDisplayed(), "Host an Amazon Hub link is not displayed.");
	}

	public void assertSeeMoreLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(seeMoreLink).isDisplayed(), "See More Make Money with Us link is not displayed.");
	}

	public void assertAmazonPaymentProductsHeadingIsDisplayed() {
	    Assert.assertTrue(driver.findElement(amazonPaymentProductsHeading).isDisplayed(), "Amazon Payment Products heading is not displayed.");
	}

	public void assertAmazonBusinessCardLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(amazonBusinessCardLink).isDisplayed(), "Amazon Business Card link is not displayed.");
	}

	public void assertShopWithPointsLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(shopWithPointsLink).isDisplayed(), "Shop with Points link is not displayed.");
	}

	public void assertReloadYourBalanceLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(reloadYourBalanceLink).isDisplayed(), "Reload Your Balance link is not displayed.");
	}

	public void assertAmazonCurrencyConverterLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(amazonCurrencyConverterLink).isDisplayed(), "Amazon Currency Converter link is not displayed.");
	}

	public void assertLetUsHelpYouHeadingIsDisplayed() {
	    Assert.assertTrue(driver.findElement(letUsHelpYouHeading).isDisplayed(), "Let Us Help You heading is not displayed.");
	}

	public void assertAmazonCovidLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(amazonCovidLink).isDisplayed(), "Amazon and COVID-19 link is not displayed.");
	}

	public void assertYourAccountLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(yourAccountLink).isDisplayed(), "Your Account link is not displayed.");
	}

	public void assertYourOrdersLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(yourOrdersLink).isDisplayed(), "Your Orders link is not displayed.");
	}

	public void assertShippingRatesPoliciesLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(shippingRatesPoliciesLink).isDisplayed(), "Shipping Rates & Policies link is not displayed.");
	}

	public void assertReturnsReplacementsLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(returnsReplacementsLink).isDisplayed(), "Returns & Replacements link is not displayed.");
	}

	public void assertManageContentDevicesLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(manageContentDevicesLink).isDisplayed(), "Manage Your Content and Devices link is not displayed.");
	}

	public void assertHelpLinkIsDisplayed() {
	    Assert.assertTrue(driver.findElement(helpLink).isDisplayed(), "Help link is not displayed.");
	}
	
	// Assertions for Scenario: Verify product variations in product details page
	public void assert2BladeButtonIsDisplayed() {
		Assert.assertTrue(driver.findElement(twoBladeButton).isDisplayed(), "2 Blade button is not displayed.");
	}
	
	public void assert8BladeButtonIsDisplayed() {
		Assert.assertTrue(driver.findElement(eightBladeButton).isDisplayed(), "8 Blade button is not displayed.");
	}
	
	public void assert12BladeButtonIsDisplayed() {
		Assert.assertTrue(driver.findElement(twelveBladeButton).isDisplayed(), "12 Blade button is not displayed.");
	}
	
	public void assert2BladeButtonIsEnabled() {
		Assert.assertTrue(driver.findElement(twoBladeButton).isEnabled(), "2 Blade button is not clickable.");
	}
	
	public void assert8BladeButtonIsEnabled() {
		Assert.assertTrue(driver.findElement(eightBladeButton).isEnabled(), "8 Blade button is not clickable.");
	}
	
	public void assert12BladeButtonIsEnabled() {
		Assert.assertTrue(driver.findElement(twelveBladeButton).isEnabled(), "12 Blade button is not clickable.");
	}
	
	public void assertSize2BladeTextIsDisplayed() {
		waitTwoSeconds();
		Assert.assertTrue(driver.findElement(size2BladeText).isDisplayed(), "2 Blade text is not displayed.");
	}
	
	public void assertSize8BladeTextIsDisplayed() {
		waitTwoSeconds();
		Assert.assertTrue(driver.findElement(size8BladeText).isDisplayed(), "8 Blade text is not displayed.");
	}
	
	public void assertSize12BladeTextIsDisplayed() {
		waitTwoSeconds();
		Assert.assertTrue(driver.findElement(size12BladeText).isDisplayed(), "12 Blade text is not displayed.");
	}
	
	public void assertPriceDiffThanInitialPrice() {
		System.out.println("updated price: " + updatedPrice);
		System.out.println("initial price: " + initialPrice);
		Assert.assertNotEquals(updatedPrice, initialPrice, "Price is not updated.");
	}
	
	public void assertImgSrcDiffThanInitial() {
		System.out.println("updated src: " + updatedImgSrc);
		System.out.println("initial src: " + initialImgSrc);
		Assert.assertNotEquals(updatedImgSrc, initialImgSrc, "Product image is not updated.");	
	}
}
