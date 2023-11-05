package NoCommerceProject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
	
	@FindBy(xpath="//a[@class='ico-login']")
	private WebElement LoginTab;
	
	@FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")
	private WebElement electronicstab;
	
	@FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']")
	private WebElement cellphonetab;
	
	public HomePage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	public LoginPage login() throws InterruptedException {
		LoginTab.click();
		Thread.sleep(5000);
		return new LoginPage();
	}
	
	public CellphonePage cellphoneTab() throws InterruptedException {
		Actions actions = new Actions(getDriver());
		  actions.moveToElement(electronicstab)
		  	.pause(Duration.ofSeconds(2))
		  	.moveToElement(cellphonetab)
		  	.click()
		  	.perform();
		  Thread.sleep(5000);
		return new CellphonePage();
	}

}
