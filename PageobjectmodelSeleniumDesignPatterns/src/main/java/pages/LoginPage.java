package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy (id ="Email" )
	WebElement emailTxBx;

	@FindBy (id ="Password" )
	WebElement PasswordlTxBx;

	@FindBy (partialLinkText ="Log in" )
	public WebElement Loginbtn;

	@FindBy(css ="button.button-1.login-button")
    WebElement Loginbtn2;
	
	@FindBy(linkText = "Log out")
	public WebElement logoutlink;

	public void userLogin(String Email,String Password)
	{
		emailTxBx.sendKeys(Email);
		PasswordlTxBx.sendKeys(Password);
		Loginbtn2.click();

}
	
	



}
