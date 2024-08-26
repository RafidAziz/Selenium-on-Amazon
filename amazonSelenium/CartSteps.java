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

	private String baseUrl = "https://www.amazon.com";
	private String prodDetailsUrl = "https://www.amazon.com/Mueller-Austria-Chopper-Vegetable-Container/dp/B08N9Q24M9/ref=pd_cart_vw_crc_d_sccl_1_1/134-8582275-1630743?pd_rd_w=f1ILy&content-id=amzn1.sym.1c2f7c10-4d4d-4813-8c51-1798e23c9a80&pf_rd_p=1c2f7c10-4d4d-4813-8c51-1798e23c9a80&pf_rd_r=FG0R4R2WK063355XWJZ1&pd_rd_wg=RE3fK&pd_rd_r=0143a164-d2d8-4a85-b0ed-9924ec76da4f&pd_rd_i=B08N9Q24M9&th=1";
	
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
    			, "Added to Cart"
    			, "Item was not added to cart");    	
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
