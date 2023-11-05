package NoCommerceProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutBillingPage extends BaseClass{
	WebDriver driver;

	@FindBy(xpath="//input[@id='BillingNewAddress_FirstName']")
	private WebElement firstname;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_LastName']")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_Email']")
	private WebElement emailaddress;
	
	@FindBy(xpath="//select[@id='BillingNewAddress_CountryId']")
	private WebElement country;
	
	@FindBy(xpath="//select[@id='BillingNewAddress_StateProvinceId']")
	private WebElement province;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_City']")
	private WebElement cities;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_Address1']")
	private WebElement address;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_ZipPostalCode']")
	private WebElement postalcode;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_PhoneNumber']")
	private WebElement phonenumber;
	
	@FindBy(xpath="//button[@onclick='Billing.save()']")
	private WebElement continuebtn;
	
	public CheckoutBillingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingMethodPage BillingInfo(String fn, String ln, String email, String city, String add, String postal, CharSequence num) throws InterruptedException {
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		emailaddress.sendKeys(email);
		
		Select dropdown=new Select(country);
		dropdown.selectByVisibleText("Canada");
		Thread.sleep(5000);
		
		Select dropdown1=new Select(province);
		dropdown1.selectByVisibleText("Quebec");
		Thread.sleep(5000);
		
		cities.sendKeys(city);
		address.sendKeys(add);
		postalcode.sendKeys(postal);
		phonenumber.sendKeys(num);
		Thread.sleep(5000);
		continuebtn.click();
		
		return new ShippingMethodPage();
		
	}

}

