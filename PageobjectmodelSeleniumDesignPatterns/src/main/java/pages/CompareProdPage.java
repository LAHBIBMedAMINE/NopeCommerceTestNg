package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class CompareProdPage extends PageBase{

	public CompareProdPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="div.no-data")
	public WebElement noItemtoCompareMsg;
	
	@FindBy(css = "a.clear-list")
	WebElement clearListBtn;
	
	@FindBys({@FindBy (css="tr.product-name"),
		@FindBy (tagName = "a")})
 	public List<WebElement> productstocompare;
	
	@FindBys({@FindBy (css="tr.remove-product"),
		@FindBy (css = "button.button-2.remove-button")})
 	public List<WebElement> removeItemBtns;
	
	
	public void clearlist() {
		clearListBtn.click();
	}
	
	public void removeItem(int removetiemIndex) {
		
		removeItemBtns.get(removetiemIndex).click();
	}

}
