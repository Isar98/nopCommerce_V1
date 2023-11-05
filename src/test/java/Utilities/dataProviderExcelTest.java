package Utilities;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import NoCommerceProject.BaseClass;
import NoCommerceProject.HomePage;
import NoCommerceProject.LoginPage;
import Utilities.excelDataRead;

public class dataProviderExcelTest extends BaseClass{
	private WebDriver driver;
	private HomePage hp;
	
	@BeforeClass
	public void setUpTest() throws InterruptedException {
		baseSetup("chrome", "url");
		driver = getDriver();
		getDriver().get("https://demo.nopcommerce.com/");
		hp = new HomePage();
	}
	
	@DataProvider
	public Object[][] readExcelData() throws InvalidFormatException {
		Object[][] logindata = excelDataRead.getTestData("Sheet1");
		
		/*String un = (String) logindata[0][0];
		String pwd = (String) logindata[0][1];
		System.out.println("username is :" + un);
		System.out.println("password is :" + pwd);
		String un2 = (String) logindata[1][0];
		String pwd2 = (String) logindata[1][1];
		System.out.println("2nd username is :" + un2);
		System.out.println("2nd password is :" + pwd2);*/
		return logindata;
	}
	
	@Test(dataProvider = "readExcelData")
	public void loginTest(String un, String pwd) {
		hp.loginLinkClick();
		LoginPage lp = new LoginPage(getDriver());
		lp.doLogin(un, pwd);
		lp.doLogout();
	}
	
	@AfterClass
	public void tearDown() {
		//tearDown();
	}

}
