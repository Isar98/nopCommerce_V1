package NoCommerceProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	
	@FindBy(xpath="//input[@id='Email']")
	private WebElement emailAddress;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	private WebElement loginbtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage LogingIn(String email, String pass) throws InterruptedException {
		emailAddress.sendKeys(email);
		password.sendKeys(pass);
		loginbtn.click();
		return new HomePage();
	}

}
