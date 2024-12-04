package amazonSelenium;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps extends BaseTest{

	private String baseUrl = "https://www.amazon.com/?mr_donotredirect";
	private String prodDetailsUrl = "https://www.amazon.com/Mueller-Austria-Chopper-Vegetable-Container/dp/B08N9Q24M9?mr_donotredirect%2Fref=pd_cart_vw_crc_d_sccl_1_1%2F134-8582275-1630743&th=1";
	private String cartUrl = "https://www.amazon.com/gp/cart/view.html?ref_=nav_cart";
	
//	@Before
//	public void setUp() {		
//        initializeDriverAndPages();
//	}
	
    @Given ("User is logged in with {string} and {string}")
    public void loginUser(String emailOrMobile, String password) {
    	initializeDriverAndPages();
        navigateToHomePage(baseUrl);
        homePage.clickSignInBtn();
        signInPage.enterEmailOrMobile(emailOrMobile);
        signInPage.clickContinueBtn();
        signInPage.enterPassword(password);
        signInPage.clickSignInBtn();
    }
	
	// Add product test case
	@When ("User is in the product details page")
	public void userIsOnProdDetailsPage() {
    	navigateToURL(prodDetailsUrl);
    }
    
    @And ("User clicks on add to cart button")
	public void clickAddToCartBtn() {
    	prodDetailsPage.clickAddToCartBtn();
	}
    
    @Then ("User is redirected to 'added to cart' page")
    public void prodAddedToCartSuccessfully() {
    	System.out.println(prodDetailsPage.getAddedToCartText());
    	Assert.assertEquals(prodDetailsPage.getAddedToCartText()
    			, "Added to cart"
    			, "Item was not added to cart");    	
    }
    
    
//    Scenario Outline: Verify product price on the product detail page matches the price in the cart
    @And ("User notes the product price")
    public void userNotesProductPrice() {
    	prodDetailsPage.setProdPrice();
    }

    @Then ("User should see the same product price in the cart as on the product detail page")
    public void userSeesSameProductPriceInCart() {
    	String prodPrice = prodDetailsPage.getProdPrice();
    	cartPage.assertPriceInCartEqualsPriceInProdPage(prodPrice);
    }
    
//    Scenario Outline: Verify quantity added from product detail page matches quantity in the cart
  	@And ("User changes quantity of product")
  	public void userChangeQuantity() {
  		prodDetailsPage.changeDropDownQuantityToTwo();
  	}
  	
  	@And ("User notes the product quantity")
  	public void userNoteQuantity() {
  		prodDetailsPage.setProdQty();
  	}
  	
  	@Then ("User should see the same product quantity in the cart as on the product detail page")
  	public void userSeesSameProductQuantityInCart() {
  		String prodQty = prodDetailsPage.getProdQty();
  		cartPage.assertQtyinCartEqualsQtyinProdPage(prodQty);
  	}
    
    // Remove product test case
    @When ("User is in the shopping cart page")
    public void userIsInCartPage() {
    	System.out.println(driver.getCurrentUrl());
    	homePage.clickCartBtn();
    }
    
    @And ("User clicks on delete link")
    public void userClickDelLink() {
    	cartPage.clickDeleteLink();
    }
    
    @Then ("User sees a message that the item is removed from cart")
    public void prodRemoved() {
    	Assert.assertTrue(cartPage.getRemovedFromCartMsg()
    			.contains("removed from Shopping Cart"));
    }
    
    // Scenario: Change product quantity in cart
	@And ("User changes product quantity in cart")
	public void userChangeProductQuantity() {
		cartPage.changeDropDownQuantityToFive();
	}
	
	@Then ("User should see quantity is changed in cart")
	public void useSeeChangedQuantity() {
		cartPage.assertDropDownQuantityIsFive();
	}
	
	@After
	public void tearDown() {
		if (driver!= null) {
			driver.quit();
		}
	}
}
