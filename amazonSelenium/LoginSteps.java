package amazonSelenium;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class LoginSteps extends BaseTest {
	private String baseUrl = "https://www.amazon.com";
	
//	@Before
//	public void setUp() {		
//        initializeDriverAndPages();
//	}
	
	@Given ("User is on the login page")
	public void userIsOnLoginPage() {
    	initializeDriverAndPages();
		navigateToHomePage(baseUrl);
		homePage.clickSignInBtn();
	}
	
    @When ("User enters {string}")
    public void userEnterEmailOrMobile(String emailOrMobile) {
    	signInPage.enterEmailOrMobile(emailOrMobile);
    	System.out.println(emailOrMobile);
    }
    
    @When ("User clicks on continue button")
    public void userClickContinueBtn() {
    	signInPage.clickContinueBtn();
    	System.out.println("after click continue btn");
    }
    
    @When ("User enters password {string}")
    public void userEnterPassword(String password) {
    	System.out.println("before enter password");
    	signInPage.enterPassword(password);
    	System.out.println("after enter password");
    }
    
    @When ("User clicks on sign in button")
    public void userClickSignInBtn() {
    	signInPage.clickSignInBtn();
    }
    
    @Then ("User should be logged in successfully")
    public void userSignedInSuccessfully() {
		Assert.assertTrue(homePage.checkHelloAccName(), "Error: Login was not successful");
    }
    
    @Then ("User should not be logged in successfully")
    public void userNotSignedInSuccessfully() {
		Assert.assertFalse(homePage.checkHelloAccName(), "Error: Login was not successful");
    }
    
    // Log out test case
	@And ("User clicks on sign out button")
	public void userSignOut() {
		homePage.clickSignOutBtn();
	}
	
	@Then ("User should be logged out successfully")
	public void userSignedOutSuccessfully() {
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.amazon.com/ap/signin"), 
				"Error: Log out was not successful");
	}
	
	@After
	public void tearDown() {
		if (driver!= null) {
			driver.quit();
		}
	}

}
