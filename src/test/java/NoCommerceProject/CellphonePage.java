package NoCommerceProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CellphonePage extends BaseClass {
	
	@FindBy(xpath="//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]")
	private WebElement addtocart;
	
	@FindBy(xpath="//span[@class='cart-label']")
	private WebElement shoppingcart;
	
	public CellphonePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void AddCellToCart() throws InterruptedException {
		addtocart.click();
		Thread.sleep(5000);
	}
	
	public ShoppingCartPage GoToCart() throws InterruptedException {
		shoppingcart.click();
		Thread.sleep(5000);
		return new ShoppingCartPage();
	}

}
