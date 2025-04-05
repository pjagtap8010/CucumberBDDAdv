package stepDefinition;



import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageLayer.DashPage;
import pageLayer.LoginPage;

public class LoginStepDefinition {
	
	public static WebDriver driver = new ChromeDriver(); ;
	public static LoginPage login ;
	public static DashPage dash;
	
	@Before
	public void setup() {
		
		   
		  driver.manage().window().maximize();
		  
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   
		   login = new LoginPage(driver);
		   dash = new DashPage(driver);
		   
	}
	
	@After
	public void tearDown() {
		
		 driver.quit();
		 driver = new ChromeDriver();

        }

	
	
	@Given("user has valid data")
	public void user_has_valid_data() {
	   
	}

	@When("user enter the url {string}")
	public void user_enter_the_url(String url) {	 
		 driver.get(url);
	}

	@And("user enter the email_id {string} and password {string}")
	public void user_enter_the_email_id_and_password(String emailf, String passf) {
	    login.enterEmailId(emailf);
	    login.enterPassword(passf);
		
	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
	   login.clickOnLoginButton();
	}

	@Then("verify that user is able enter in dashboard page")
	public void verify_that_user_is_able_enter_in_dashboard_page( ) {
	    
		
       String act = login.clickOnDashBoardLogo();
		System.out.print(act);
		String expectedTitle = "Dashboard";
		
		Assert.assertEquals(act, expectedTitle, "Title mismatch");
		// driver.close();
		
	  
	}
	@When("user scroll down to the page")
	public void user_scroll_down_to_the_page() throws InterruptedException {
	    
		JavascriptExecutor scrlDash = ((JavascriptExecutor)driver);
		scrlDash.executeScript("scrollBy(0,200)");
		Thread.sleep(5000);
	}
	@And("user click on HoaA person")
	public void user_click_on_hoa_a_person() {
	    
		dash.clickOnPerson();
	}
	
	@Then("user should reflect to new page")
	public void user_should_reflect_to_new_page() {
		
	}
	
	@And("user enter the {string}")
	public void user_enter_the(String value) {

	     Set<String> windows = driver.getWindowHandles();
	     for(String w : windows) {
	    	 try {
	    		 driver.switchTo().window(w);
	    		 dash.enterValueInNewText(value);
	    	 }
	    	 catch(Exception e) {
	    		 e.printStackTrace();
	    	 }
	     }
	}
	@And("navigate back to home page")
	public void navigate_back_to_home_page() {
	  driver.navigate().back();
	}

}
