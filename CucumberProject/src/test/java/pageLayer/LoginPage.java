package pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	public WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	
	@FindBy(name= "username")
	private WebElement email_textBox;
	
	public void enterEmailId(String email) {
		email_textBox.clear();
		 email_textBox.sendKeys(email);
	}
	
	@FindBy (name= "password")
	private WebElement password_textBox;
	
	public void enterPassword(String pass) {
		 password_textBox.clear();
		 password_textBox.sendKeys(pass);
	}
	
	@FindBy (xpath= "//button [text()=' Login ']")
	private WebElement login_button;
	
	public void clickOnLoginButton() {
		 login_button.click();
	}

	@FindBy (xpath= "//h6 [text() ='Dashboard']")
	private WebElement dash_board_logo;
	
	public String clickOnDashBoardLogo() {
		 
		String ActualTitle= dash_board_logo.getText();
		
		return ActualTitle;
	}
	
	
}
