package NoCommerceProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BaseClass {
	
	@FindBy(xpath = "//input[@id='termsofservice']")
	private WebElement clickcheckbox;
	
	@FindBy(xpath = "//button[@id='checkout']")
	private WebElement checkoutBtn;
	
	@FindBy(xpath="//tr[@class='order-total']//td[@class='cart-total-right']")
	private WebElement totalPrice;
	
	public ShoppingCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getamount() {
		String amount = totalPrice.getText();
		return amount;
	}
	
	public CheckoutSignInPage checkout() throws InterruptedException {
		clickcheckbox.click();
		checkoutBtn.click();
		Thread.sleep(5000);
		return new CheckoutSignInPage();
	}

}
