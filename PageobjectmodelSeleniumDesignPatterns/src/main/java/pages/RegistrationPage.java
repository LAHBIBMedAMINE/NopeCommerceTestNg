package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends PageBase {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "gender-male")
    WebElement genderRdoBtn;

    @FindBy(id = "FirstName")
    WebElement firstnametxbx;

    @FindBy(id = "LastName")
    WebElement lastnametxbx;

    @FindBy(id = "Email")
    WebElement EmailTxBx;

    @FindBy(css="div.inputs.date-of-birth > div > select:nth-child(1)")
    WebElement DateOfBirthDay;

    @FindBy(css ="div.inputs.date-of-birth > div > select:nth-child(2)")
    WebElement DateOfBirthMonth;

    @FindBy(css ="div.inputs.date-of-birth > div > select:nth-child(3)")
    WebElement DateOfBirthYear;

    @FindBy(id = "Password")
    WebElement PasswordTxBx;

    @FindBy(id = "ConfirmPassword")
    WebElement ConfirmPasswordTxBx;

    @FindBy(id = "register-button")
    WebElement registerbtn;

    @FindBy(css ="div.result")
    public WebElement ResultMessage;

    @FindBy(css ="div.message-error.validation-summary-errors > ul > li")
    public WebElement ResultERRORMessage;

    @FindBy(id = "Company")
    WebElement companyname;
    
    @FindBy(tagName = "h1")
    public WebElement registrationTitle;
    
    @FindBy(partialLinkText = "Log out")
	public WebElement logoutlink;
    
    @FindBy(css = "a.button-1.register-continue-button")
    WebElement ContinueBtn;
    
	

    public void userRegistration(String firstName,String lastname,String day,String month,
    		String year,String Email,String Password,String compagny){
    	
    	select = new Select(DateOfBirthDay);
    	select.selectByVisibleText(day);
    	
    	select = new Select(DateOfBirthMonth);
    	select.selectByVisibleText(month);
    	
    	select = new Select(DateOfBirthYear);
    	select.selectByVisibleText(year);
    	
    	clickButton(genderRdoBtn);
        SetText(firstnametxbx, firstName);
        lastnametxbx.sendKeys(lastname);
        EmailTxBx.sendKeys(Email);
        PasswordTxBx.sendKeys(Password);
        ConfirmPasswordTxBx.sendKeys(Password);
        companyname.sendKeys(compagny);
        registerbtn.click();

    }
    
    public void Userlogout(){

    	logoutlink.click();
    }
    
    public void ContinueAfterRegistration(){

    	ContinueBtn.click();
    }

    public void RegisterButtonClick(){

    	registerbtn.click();
    }







}
