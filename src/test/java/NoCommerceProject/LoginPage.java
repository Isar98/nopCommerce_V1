package NoCommerceProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{
	
	@FindBy(xpath="//input[@id='Email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[@class='ico-logout']")
	private WebElement logout;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(),this);
	}

	public HomePage doLogin(String un, String pwd) throws InterruptedException {
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		Thread.sleep(5000);
		return new HomePage();
		
	}

	public LoginPage doLogout() throws InterruptedException {
		logout.click();
		Thread.sleep(5000);
		return new LoginPage();
		
	}

}
