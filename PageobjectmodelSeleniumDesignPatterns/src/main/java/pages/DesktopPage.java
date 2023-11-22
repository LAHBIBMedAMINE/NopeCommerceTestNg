package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DesktopPage extends PageBase{
	
	WebDriverWait wait;

	public DesktopPage(WebDriver driver) {
		super(driver);
		action = new Actions(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBys({@FindBy(css="div.item-grid"),
		@FindBy(css="button.button-2.product-box-add-to-cart-button")})
	List<WebElement> addTocartBtn;
	
	@FindBy(css="span.close")
	WebElement closeNotificationBtn;
	
	@FindBy(id="flyout-cart")
	public WebElement flyoutcart;
	
	@FindBy(css="span.cart-label")
	public WebElement shoppingcartLink;
	
	@FindBys({@FindBy(id="flyout-cart"),
		@FindBy(css="div.product")})
	public List<WebElement> productList;
	
	
	public void addTocard(int ItemIndex) {
		addTocartBtn.get(ItemIndex).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(closeNotificationBtn));
		closeNotificationBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(closeNotificationBtn));
		
	}
	
	public void hoveroverMenu(WebElement element, boolean rx) {
		action.moveToElement(element).build().perform();
		if (rx) {element.click();}
	}
	

}
