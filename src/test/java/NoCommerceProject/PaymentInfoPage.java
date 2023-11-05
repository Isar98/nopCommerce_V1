package NoCommerceProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentInfoPage extends BaseClass {
	
	@FindBy(xpath="//select[@id='CreditCardType']")
	private WebElement creditcardType;
	
	@FindBy(xpath="//input[@id='CardholderName']")
	private WebElement cardName;
	
	@FindBy(xpath="//input[@id='CardNumber']")
	private WebElement cardNumber;
	
	@FindBy(xpath="//select[@id='ExpireMonth']")
	private WebElement cardExpireMonth;
	
	@FindBy(xpath="//select[@id='ExpireYear']")
	private WebElement cardExpireYear;
	
	@FindBy(xpath="//input[@id='CardCode']")
	private WebElement cardCode;
	
	@FindBy(xpath="//button[@class='button-1 payment-info-next-step-button']")
	private WebElement continuebtn;
	
	public PaymentInfoPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ConfirmationPage creditCardInfo(String name, CharSequence num, CharSequence code) throws InterruptedException {
		Select cardType = new Select(creditcardType);
		cardType.selectByVisibleText("Visa");
		Thread.sleep(3000);
		
		cardName.sendKeys(name);
		cardNumber.sendKeys(num);
		
		Select expireMonth = new Select(cardExpireMonth);
		expireMonth.selectByValue("2");
		
		Select expireYear = new Select(cardExpireYear);
		expireYear.selectByValue("2025");
		
		cardCode.sendKeys(code);
		Thread.sleep(5000);
		
		continuebtn.click();
		
		return new ConfirmationPage();
	}

}
