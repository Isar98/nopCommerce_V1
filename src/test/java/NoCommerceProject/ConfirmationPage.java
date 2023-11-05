package NoCommerceProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends BaseClass {
	
	@FindBy(xpath="//tr[@class='order-total']//td[@class='cart-total-right']")
	private WebElement totalPrice;
	
	@FindBy(xpath="//button[normalize-space()='Confirm']")
	private WebElement confirmBtn;
	
	public ConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getamount() {
		String amount = totalPrice.getText();
		return amount;
	}
	
	public CompletedPage completeOrder() throws InterruptedException {
		confirmBtn.click();
		Thread.sleep(5000);
		return new CompletedPage();
	}
	

}
