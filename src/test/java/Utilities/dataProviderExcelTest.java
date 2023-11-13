package Utilities;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
	/*
	@BeforeClass
	public void setUpTest() throws InterruptedException {
		baseSetup("firefox");
		driver = getDriver();
		getDriver().get("https://demo.nopcommerce.com/");
		hp = new HomePage();
		
	}*/
	
	@DataProvider
	public Object[][] readExcelData() throws InvalidFormatException {
		Object[][] inputdata = excelDataRead.getTestData("Sheet1");
		
		return inputdata;
	}
	
	@Test(dataProvider = "readExcelData")
	public void setupTest(String browser, String url) throws InterruptedException {
		baseSetup(browser);
		driver = getDriver();
		getDriver().get(url);
		hp = new HomePage();
		Thread.sleep(5000);
		Assert.assertNotNull(hp, "ERROR !! nopCommerce home page not launched");
		getDriver().quit();
	}
	
	@AfterClass
	public void tearDown() {
		//tearDown();
	}

}
