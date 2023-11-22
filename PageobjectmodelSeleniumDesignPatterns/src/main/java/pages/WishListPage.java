package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class WishListPage extends PageBase{
	
	public WishListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css= "div.no-data")
	public WebElement noDataMessage;
	
	@FindBy(css= "div.table-wrapper")
	public WebElement tablewishList;
	
	@FindBys({@FindBy(css="table.cart"),
		@FindBy(css="a.product-name")})
	public List<WebElement> wishListContent;
	
	@FindBy(css="button.remove-btn")
	public WebElement removeElement;
	
	public void removeItem() {
		removeElement.click();
		
	}
	
	

}
