package NoCommerceProject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class BaseClass {
	private static WebDriver driver;
	
	protected static ThreadLocal<WebDriver> tsdriver = new ThreadLocal<>();
	
	String ffPath = System.getProperty ("user.dir") + "\\Browsers\\geckodriver.exe";
	String chrPath = System.getProperty ("user.dir") + "\\Browsers\\chromedriver.exe";
		
	public  void baseSetup(String browser) throws InterruptedException {
		
		switch(browser) {
			
		  case "firefox":
		    driver = new FirefoxDriver();
		    break;
		    
		  case "chrome":
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Browsers/chromedriver.exe");
			driver = new ChromeDriver(ops);
		    break;
		   
		  case "edge":
			  driver = new EdgeDriver();
			    break;
	    
	  default:
	}
		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().get(getUrl());  
		getDriver().manage().window().maximize();
		//Thread.sleep(3000);
		
	}
	
	public String getUrl() {
		return getDriver().getCurrentUrl();
	}
	protected WebDriver getDriver() {
		return driver;
	}

	public String getTitle() {
		return getDriver().getTitle();
	}
	
	protected String getText() {
		return getText();
	}
	
	public void takeScreenShot() throws IOException  {
		File srce = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String datetime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		File targetfile = new File(System.getProperty("user.dir")+"/Screenshots/"+"ErrorStatus_"+datetime+".png");
		FileUtils.copyFile(srce, targetfile);
		
	}

	public static String takeSnapShot(String methodName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static Properties propFileReader() throws IOException {
		Properties props = new Properties();
		String propfile = "./src/test/resources/config.properties";
		FileReader reader=new FileReader(propfile);
		props.load(reader);
		return props;
		}
	
	public void tearDown() {
		//tearDown();
	}

	
}
