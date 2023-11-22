package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Shopping_cartPage extends PageBase{

	public Shopping_cartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="span.cart-label")
	WebElement shoppingcartLink;
	
	@FindBy(css="div.table-wrapper")
	public WebElement shoppingTable;
	
	@FindBys({@FindBy(css="div.table-wrapper"),
		@FindBy(css="td.product")})
	public List<WebElement> productList;
	
	@FindBy(id="termsofservice")
	public WebElement agreeTermscheck;
	
	@FindBy(id="checkout")
	WebElement checkoutBtn;
		
	
	
	
	public void openshoppingcart() {
		shoppingcartLink.click();
		
	}
	
	public void EnsureAndCheckAgreeTermsButton() {
		
		if (agreeTermscheck.isSelected()) {
			// do nothing
		}else {agreeTermscheck.click(); }
	}
	
	public void proceedTocheckout() {
		checkoutBtn.click();
		
	}
	

}
