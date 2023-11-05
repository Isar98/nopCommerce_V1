package NoCommerceProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingMethodPage extends BaseClass {
	
	@FindBy(xpath="//input[@id='shippingoption_0']")
	private WebElement groundshipping;
	
	@FindBy(xpath="//button[@class='button-1 shipping-method-next-step-button']")
	private WebElement continuebtn;
	
	public ShippingMethodPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public PaymentMethodPage shippingselect() throws InterruptedException {
		groundshipping.click();
		continuebtn.click();
		Thread.sleep(5000);
		return new PaymentMethodPage();
	}

}
