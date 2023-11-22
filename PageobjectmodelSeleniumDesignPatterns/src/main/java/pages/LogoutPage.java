package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends PageBase {

	public LogoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(partialLinkText = "Log out")
	public WebElement logoutlink;
	
	public void Userlogout(){

    	logoutlink.click();

    }

}
