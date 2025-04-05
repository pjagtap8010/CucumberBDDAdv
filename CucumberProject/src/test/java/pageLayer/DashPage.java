package pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashPage {
	
	public WebDriver ldriver;
	public DashPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath= "//span [text()='Admin']")
	private WebElement person1;
	
	public void clickOnPerson() {
		person1.click();
	}
	
	@FindBy(xpath="//div[@class='oxd-table-filter']//input [@class='oxd-input oxd-input--active']")
	private WebElement new_textBox;
	
	public void enterValueInNewText(String text) {
		new_textBox.sendKeys(text);
	}

}
