package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderInformationPage extends PageBase{

	public OrderInformationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(linkText = "PDF Invoice")
	WebElement pdfDownloadBtn;
	
	public void pdfDownload() {
		pdfDownloadBtn.click();
	}

}
