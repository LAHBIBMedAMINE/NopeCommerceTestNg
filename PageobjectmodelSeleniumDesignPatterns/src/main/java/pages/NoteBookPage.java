package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NoteBookPage extends PageBase{

	public NoteBookPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css ="button.button-2.add-to-compare-list-button")
	List<WebElement> addCompareproduct1Btn;
	
	@FindBy(css ="p.content")
	public WebElement notificationProdComp;
	
	@FindBy(css ="span.close")
	public WebElement ClosenotificationProdComp;
	
	public void addToCompare(int itemIndex) {
		addCompareproduct1Btn.get(itemIndex).click();
		
	}

}
