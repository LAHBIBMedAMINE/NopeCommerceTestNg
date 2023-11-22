package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ReslultProductPage extends PageBase{

	public ReslultProductPage(WebDriver driver) {
		super(driver);
		action = new Actions(driver);
	}
	
	@FindBy(css ="div.product-selectors")
	public WebElement resultProductSelector;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement appleLink;
	
	@FindBy(linkText = "Lenovo IdeaCentre 600 All-in-One PC")
	WebElement LenovoLink;
	
	@FindBy(css = "button.button-2.product-box-add-to-cart-button")
	WebElement AddTocartBtn;
	
	@FindBys({@FindBy(css="div.product-grid"),@FindBy(css = "h2.product-title")})
	public WebElement itemName;
	
	@FindBy(id="topcartlink")
	public WebElement shoppingCartFlyout;
	
	
	
	public void openproductlink() {
		appleLink.click();
	}
	public void openproductlink2() {
		LenovoLink.click();
	}
	public void addTocart() {
		AddTocartBtn.click();
	}
	
	public void hoveroverMenu(WebElement element, boolean rx) {
		action.moveToElement(element).build().perform();
		if (rx) {element.click();}
	}
	

}
