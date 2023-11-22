package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);

	}

	@FindBy (partialLinkText = "Register")
	WebElement registerlink;

	@FindBy (partialLinkText = "Log in")
	WebElement Loginlink;
	
	@FindBy(linkText = "My account")
	WebElement myaccountlink;
	
	@FindBy(partialLinkText = "Contact us")
	WebElement contactUsLink;
	
	@FindBy(id ="customerCurrency")
	WebElement currencydroplist;
	
	@FindBy(linkText = "Computers")
	public WebElement computerSection;
	
	@FindBy(linkText = "Notebooks")
	public WebElement NotebooksSection;
	
	@FindBy(linkText = "Desktops")
	public WebElement DesktopsSection;
	
	
	
	@FindBy(linkText ="Wishlist")
	WebElement wichlistLink;
	
	

	public void openRegistrationLink() {
		registerlink.click();
	}

	public void openLoginLink() {
		Loginlink.click();
	}
	
	public void openMyAccountLink() {
		myaccountlink.click();
		
	}
	
	public void openContactusLink() {
		contactUsLink.click();
			
	}
	public void changeCurrency(String Currency) {
		select = new Select(currencydroplist);
		select.selectByVisibleText(Currency);
	}
	
	public void hoveroverMenu(WebElement element, boolean rx) {
		action.moveToElement(element).build().perform();
		if (rx) {element.click();}
	}
	
	public void openWishListLink() {
		wichlistLink.click();
	}
	


	
		

}
