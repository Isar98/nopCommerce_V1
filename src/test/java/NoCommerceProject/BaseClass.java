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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class BaseClass {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public WebDriver getDriver() {
		return driver.get();
	}
		
	public  void baseSetup(String browser, String url) throws InterruptedException {
		
		String 	ffpath = System.getProperty ("user.dir") + "\\src\\test\\resources\\Browsers\\geckodriver.exe";
		String 	chrpath = System.getProperty ("user.dir") + "\\src\\test\\resources\\Browsers\\chromedriver";
		
		switch(browser) {
			
		  case "firefox":

		    FirefoxOptions ffoptions = new FirefoxOptions();
		    ffoptions.setProfile(new FirefoxProfile());
		    ffoptions.addPreference("dom.webnotifications.enabled", false);
		    ffoptions.setBinary("C://Program Files//Mozilla Firefox/firefox.exe");
		    System.setProperty("webdriver.gecko.driver", ffpath); 
		    driver.set(new FirefoxDriver(ffoptions));
		    break;
		    
		  case "chrome":
			System.out.println(chrpath);
			ChromeOptions chroptions = new ChromeOptions();
			chroptions.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", chrpath);	 
			driver.set(new ChromeDriver(chroptions));
		    break;
		   
		  case "edge":
			    break;
	    
	  default:
		  throw new IllegalStateException("Unexpected value: " + browser);
	}
		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().get(url);  
		getDriver().manage().window().maximize();
		//Thread.sleep(3000);
		
	}
	
	public String getUrl() {
		return getDriver().getCurrentUrl();
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

	
}
