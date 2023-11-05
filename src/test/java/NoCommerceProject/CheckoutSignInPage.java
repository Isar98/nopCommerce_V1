package NoCommerceProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutSignInPage extends BaseClass{
	
	@FindBy(xpath="//button[normalize-space()='Checkout as Guest']")
	private WebElement guestTab;
	
	public CheckoutSignInPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public CheckoutBillingPage checkoutAsGuest() {
		guestTab.click();
		return new CheckoutBillingPage();
	}

}
