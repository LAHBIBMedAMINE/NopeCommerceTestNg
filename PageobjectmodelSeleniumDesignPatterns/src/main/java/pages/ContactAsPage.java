package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactAsPage extends PageBase{

	public ContactAsPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	@FindBy(id="FullName")
	WebElement FullNameTxBx;
	
	@FindBy(id="Email")
	WebElement EmailTxBx;
	
	@FindBy(id="Enquiry")
	WebElement EnquiryTxBx;
	
	@FindBy(css="button.button-1.contact-us-button")
	WebElement submitBtn;
	
	@FindBy(css="div.result")
	public WebElement resultRx;
	
	
	
	public void FillFromContactUs(String name, String email, String EnquiryTxt) {
		FullNameTxBx.sendKeys(name);
		EmailTxBx.sendKeys(email);
		EnquiryTxBx.sendKeys(EnquiryTxt);

	}
	
	public void submitemailContactUs() {
		submitBtn.click();
	}
		

}
