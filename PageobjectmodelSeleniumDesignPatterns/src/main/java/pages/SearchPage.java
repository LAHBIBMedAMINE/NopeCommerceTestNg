package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "small-searchterms")
	WebElement searchTxBx;
	
	@FindBy(css ="#small-search-box-form > button")
	WebElement searchBtn;
	
	@FindBy(id="ui-id-1")
	public List<WebElement> productsuggesstions;
	
	@FindBy(css="strong.current-item")
	public WebElement itemrequested;
	
	@FindBy(css ="span.price.actual-price")
	public WebElement priceTag;
	
	
	
	public void SearchForProduct(String Product) {
		searchTxBx.sendKeys(Product);
		searchBtn.click();
		
		
	}
	
	public void searchprodusinglist(String Product)  {
		searchTxBx.sendKeys(Product);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(productsuggesstions));
		productsuggesstions.get(0).click();
		
	}
	

}
