package TestPages;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import NoCommerceProject.BaseClass;
import NoCommerceProject.CellphonePage;
import NoCommerceProject.CheckoutBillingPage;
import NoCommerceProject.CheckoutSignInPage;
import NoCommerceProject.CompletedPage;
import NoCommerceProject.ConfirmationPage;
import NoCommerceProject.HomePage;
import NoCommerceProject.PaymentInfoPage;
import NoCommerceProject.PaymentMethodPage;
import NoCommerceProject.ShippingMethodPage;
import NoCommerceProject.ShoppingCartPage;

public class NoCommTestPage extends BaseClass {
	WebDriver driver;
	private String url = "https://demo.nopcommerce.com/";
	private HomePage hp;
	private CellphonePage cp;
	private ShoppingCartPage scp;
	private CheckoutSignInPage csip;
	private CheckoutBillingPage cop;
	private ShippingMethodPage smp;
	private PaymentMethodPage pmp;
	private PaymentInfoPage pip;
	private ConfirmationPage cfp;
	private CompletedPage comp;
	private Properties prop;
	public static Logger Log;
	
	
	@BeforeClass
	public void setUpTest() throws InterruptedException {
		Log = Logger.getLogger(NoCommTestPage.class.getName());
		Log.info("setting up the browser for the test");
		
		try {
			prop = propFileReader();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		baseSetup(prop.getProperty("browser"),
				prop.getProperty("base_url"));
		
		//baseSetup("firefox", url);
		Thread.sleep(5000);
		hp = new HomePage();
	}
	
	@Test(priority=2,enabled=true)
	public void testCellphoneTab() throws InterruptedException {
		Log.info("Navigating to electronic then cellphone page");
		cp = hp.cellphoneTab();
		
		System.out.println(getDriver().getTitle());
		System.out.println(getDriver().getCurrentUrl());
		
		if(getDriver().getTitle().equalsIgnoreCase("nopCommerce demo store. Cell phones")) {
			Assert.assertNotNull(cp,"Error! NopCommerce cellphone page did not launch");
			Log.info("NopCommerce cellphone Page launched successfully");
		}else {
			Log.info("NopCommerce page tittle is not the cellphone page");
		}
		
	}
	
	@Test(priority=3,enabled=true)
	public void addPhoneAndCheckout() throws InterruptedException {
		Log.info("Add item to cart then naviagte to cart>checkout.checkout as guest");
		cp.AddCellToCart();
		scp = cp.GoToCart();
		scp.getamount();
		System.out.println(scp.getamount());
		csip = scp.checkout();
		cop = csip.checkoutAsGuest();
		
		System.out.println(getDriver().getTitle());
		System.out.println(getDriver().getCurrentUrl());
		
		if(getDriver().getCurrentUrl().equalsIgnoreCase("https://demo.nopcommerce.com/onepagecheckout#opc-billing")) {
			Assert.assertNotNull(cop,"Error! NopCommerce billing page did not launch");
			Log.info("NopCommerce Billing page launched succesfully");
		}else {
			Log.info("NopCommerce page url is not the billing url");
		}
	}
	
	@Test(priority=4,enabled=true)
	public void checkoutBillingInfo() throws InterruptedException {
		Log.info("Enter Billing info and launch shipping page");
		smp = cop.BillingInfo("isar", "x", "isar@hotmail.com", "montreal", "123 montreal", "a1b2c3", "0123456789");
		
		System.out.println(getDriver().getTitle());
		System.out.println(getDriver().getCurrentUrl());
		
		if(getDriver().getCurrentUrl().equalsIgnoreCase("https://demo.nopcommerce.com/onepagecheckout#opc-shipping_method")) {
			Assert.assertNotNull(smp,"Error! Shipping page did not launch");
			Log.info("NopCommerce Shipping page launched succesfully");
		}else {
			Log.info("NopCommerce page url is not the Shipping page url");
		}
	}
	
	@Test(priority=5,enabled=true)
	public void checkoutShipAndPayment() throws InterruptedException {
		Log.info("Enter credit card info and launch confirmation page");
		pmp = smp.shippingselect();
		pip = pmp.paymentoption();
		cfp = pip.creditCardInfo("isar", "4012 8888 8888 1881", "123");
		
		System.out.println(getDriver().getTitle());
		System.out.println(getDriver().getCurrentUrl());
		
		if(getDriver().getCurrentUrl().equalsIgnoreCase("https://demo.nopcommerce.com/onepagecheckout#opc-confirm_order")) {
			Assert.assertNotNull(cfp,"Error! confirmation page did not launch");
			Log.info("NopCommerce confirmation page launched succesfully");
		}else {
			Log.info("NopCommerce page url is not the confirmation page url");
		}
	}
	
	@Test(priority=6,enabled=true)
	public void completeOrder() throws InterruptedException {
		Log.info("return and launch Home page");
		
		comp = cfp.completeOrder();
		hp = comp.finishOrder();
		
		System.out.println(getDriver().getTitle());
		System.out.println(getDriver().getCurrentUrl());
		
		if(getDriver().getCurrentUrl().equalsIgnoreCase("https://demo.nopcommerce.com/")) {
			Assert.assertNotNull(hp,"Error!  Home page did not launch");
			Log.info("NopCommerce  Home page launched succesfully");
		}else {
			Log.info("NopCommerce page url is not the  Home page url");
		}
		
	}

}