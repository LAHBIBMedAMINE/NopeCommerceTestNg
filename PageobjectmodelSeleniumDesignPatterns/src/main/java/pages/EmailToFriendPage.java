package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailToFriendPage extends PageBase{

	public EmailToFriendPage(WebDriver driver) {
		super(driver);
		}
	
	@FindBy(id="FriendEmail")
	WebElement friendmailTxBx;
	
	@FindBy(id="YourEmailAddress")
	WebElement myemailTxBx;
	
	@FindBy(id="PersonalMessage")
	WebElement personelmessageTxBx;
	
	@FindBy(css= "button.button-1.send-email-a-friend-button")
	WebElement sendmailBtn;
	
	@FindBy(css="div.result")
	public WebElement resultmessage;
	
	@FindBy(css ="div.message-error.validation-summary-errors")
	public WebElement errorMessage;
	
	public void emailtofirend(String friendmail,String mymail,String personelmessage) {
		friendmailTxBx.sendKeys(friendmail);
		myemailTxBx.clear();
		myemailTxBx.sendKeys(mymail);
		personelmessageTxBx.sendKeys(personelmessage);
		sendmailBtn.click();
	}

}
