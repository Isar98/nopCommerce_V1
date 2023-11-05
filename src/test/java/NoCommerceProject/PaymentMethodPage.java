package NoCommerceProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethodPage extends BaseClass {
	
	@FindBy(xpath="//input[@id='paymentmethod_1']")
	private WebElement creditcard;
	
	@FindBy(xpath="//button[@class='button-1 payment-method-next-step-button']")
	private WebElement continuebtn;
	
	public PaymentMethodPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public PaymentInfoPage paymentoption() throws InterruptedException {
		creditcard.click();
		continuebtn.click();
		Thread.sleep(5000);
		return new PaymentInfoPage();
	}

}
