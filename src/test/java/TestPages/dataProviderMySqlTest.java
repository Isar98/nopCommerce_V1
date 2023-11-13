package TestPages;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import NoCommerceProject.BaseClass;
import NoCommerceProject.HomePage;
import Utilities.mySqlConnect;

public class dataProviderMySqlTest extends BaseClass{
	
	private WebDriver driver;
	private HomePage hp;
	
	@DataProvider
	public Object[][] mySqlReadData() throws ClassNotFoundException, SQLException {
	    Object[][] dataFromDatabase = mySqlConnect.getMySqlData();
	    Object[][] testData = new Object[dataFromDatabase.length][2];

	    for (int i = 0; i < dataFromDatabase.length; i++) {
	        testData[i][0] = dataFromDatabase[i][0].toString();
	        testData[i][1] = dataFromDatabase[i][1].toString();
	    }

	    return testData;
	}
	
	@Test(dataProvider = "mySqlReadData")
	public void setUpTest(String browser, String url) throws InterruptedException {
		System.out.println("browser is :" + browser + "url is :" + url);
		baseSetup(browser);
		driver = getDriver();
		getDriver().get(url);
		hp = new HomePage();
		Thread.sleep(5000);
		Assert.assertNotNull(hp,"ERROR: nopCommerce homepage is not launched!");
		tearDown();
	}

}