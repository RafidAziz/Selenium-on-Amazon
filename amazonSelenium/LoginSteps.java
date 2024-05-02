package amazonSelenium;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class LoginSteps extends BaseTest {
	private String baseUrl = "https://www.amazon.com";
	
	@Before
	public void setUp() {		
        initializeDriverAndPages();
	}
	
	@Given ("User is on the login page")
	public void userIsOnLoginPage() {
		navigateToURL(baseUrl);
		homePage.clickSignInBtn();
	}
	
    @When ("User enters {string}")
    public void userEnterEmailOrMobile(String emailOrMobile) {
    	signInPage.enterEmailOrMobile(emailOrMobile);
    }
    
    @When ("User clicks on continue button")
    public void userClickContinueBtn() {
    	signInPage.clickContinueBtn();
    }
    
    @When ("User enters {string}")
    public void userEnterPassword(String password) {
    	signInPage.enterPassword(password);
    }
    
    @When ("User clicks on sign in button")
    public void userClickSignInBtn() {
    	signInPage.clickSignInBtn();
    }
    
    @Then ("User should be logged in successfully")
    public void userSignedInSuccessfully() {
		Assert.assertTrue(homePage.checkHelloAccName(), "Error: Login was not successful");
    }
	
	@After
	public void tearDown() {
		if (driver!= null) {
			driver.quit();
		}
	}

}
