package NoCommerceProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletedPage extends BaseClass {
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//div[@class='order-number']")
	private WebElement orderNumber;
	
	public CompletedPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getOrderNumber() {
		String orderNum = orderNumber.getText();
		return orderNum;
	}
	
	public HomePage finishOrder() throws InterruptedException {
		continueBtn.click();
		Thread.sleep(5000);
		return new HomePage();
	}

}
