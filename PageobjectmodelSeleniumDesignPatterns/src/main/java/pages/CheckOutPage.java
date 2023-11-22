package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage extends PageBase{

	public CheckOutPage(WebDriver driver) {
		super(driver);
		
		// TODO Auto-generated constructor stub
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
	
	// Address Form identifiers
	@FindBy(id="ShipToSameAddress")
	public WebElement ShipToSameAddressBtn;
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement Address_CountryId;
	@FindBy(id="BillingNewAddress_StateProvinceId")
	WebElement AddressStateProvinceId;
	@FindBy(id="BillingNewAddress_City")
	WebElement Address_City;
	@FindBy(id="BillingNewAddress_Address1")
	WebElement Address_Address1;
	@FindBy(id="BillingNewAddress_Address2")
	WebElement Address_Address2;
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement ZipPostalCode;
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement Address_PhoneNumber;
	@FindBy(id="BillingNewAddress_FaxNumber")
	WebElement FaxNumber;
	@FindBy(css="button.button-1.new-address-next-step-button")
	WebElement ContinueBtn;
	
	
	
	@FindBy(id="shippingoption_1")
	WebElement shippingoption_0;
	@FindBy(id="shippingoption_1")
	WebElement shippingoption_1;
	@FindBy(id="shippingoption_1")
	WebElement shippingoption_2;
	
	@FindBy(css="button.button-1.shipping-method-next-step-button")
	WebElement shippingMethodContinueBtn;
	
	
	
	@FindBy(id="paymentmethod_0")
	WebElement paymentmethod_0;
	@FindBy(id="paymentmethod_1")
	WebElement paymentmethod_1;
	@FindBy(css="button.button-1.payment-method-next-step-button")
	WebElement paymentMethodContinueBtn;
	
	@FindBy(css="button.button-1.payment-info-next-step-button")
	WebElement paymentInfoContinueBtn;
	
	
	@FindBy(id="CreditCardType")
	WebElement CreditCardType;
	@FindBy(id="CardholderName")
	WebElement CardholderName;
	@FindBy(id="CardNumber")
	WebElement CardNumber;
	@FindBy(id="ExpireMonth")
	WebElement ExpireMonth;
	@FindBy(id="ExpireYear")
	WebElement ExpireYear;
	@FindBy(id="CardCode")
	WebElement CardCode;
	
	
	@FindBy(css="button.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;
	
	@FindBys({@FindBy(css="div.page.checkout-page.order-completed-page"),
		@FindBy(tagName = "strong")})
	public WebElement orderSuccessMsg;
	
	@FindBy(linkText = "Click here for order details.")
	WebElement detailorderLink;
	
	public void FilladressForm(String country, String state,String city, String adress1,String adress2,
			String zipcode,String phone,String fax) {
		
		select = new Select(Address_CountryId);
    	select.selectByVisibleText(country);
    	
    	select = new Select(AddressStateProvinceId);
    	select.selectByVisibleText(state);
    	
    	Address_City.sendKeys(city);
    	Address_Address1.sendKeys(adress1);
    	Address_Address2.sendKeys(adress2);
    	ZipPostalCode.sendKeys(zipcode);
    	Address_PhoneNumber.sendKeys(phone);
    	FaxNumber.sendKeys(fax);
    	ContinueBtn.click();
	}
	
	public void EnsureAndCheckShipToSameAdress() {
			
			if (ShipToSameAddressBtn.isSelected()) {
				// do nothing
			}else {ShipToSameAddressBtn.click(); }
		}
	
	
	public void SelectshippingoptionAndContinue(String optionsIdx) {
		// the method is able to select one option available
		WebElement option;
		switch (optionsIdx) {
	    case "shippingoption_0":
	        option = shippingoption_0;
	        break;
	    case "shippingoption_1":
	    	option = shippingoption_1;;
	        break;
	    case "shippingoption_2":
	    	option = shippingoption_2;;
	        break;
	    default:
	    	option = shippingoption_0;
	}
		
		if (option.isSelected()) {
			// do nothing
		}else {option.click(); }
		
		// continue
		shippingMethodContinueBtn.click();
	}
	
	public void SelectPaymentoptionAndContinue(String optionsIdx,List<String> cardinfo) {
		// the method is able to select one option available
		WebElement option;
		switch (optionsIdx) {
	    case "Paybycheque":
	        option = paymentmethod_0;
	        // check for option selected
	        if (option.isSelected()) {
				// do nothing
			}else {option.click(); }
	    // continue
	        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodContinueBtn));
	        paymentMethodContinueBtn.click();    
	        break;
	    case "Paybycreditordebitcard":
	    	option = paymentmethod_1;
	    	// check for option selected
	        if (option.isSelected()) {
				// do nothing
			}else {option.click(); }
	        
	     // continue
	        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodContinueBtn));
	        paymentMethodContinueBtn.click();
	        
	        //fill the credit card form
	        select = new Select(CreditCardType);
	    	select.selectByVisibleText(cardinfo.get(0));
	    	
	    	CardholderName.sendKeys(cardinfo.get(1));
	    	CardNumber.sendKeys(cardinfo.get(2));
	    	
	    	select = new Select(ExpireMonth);
	    	select.selectByVisibleText(cardinfo.get(3));
	    	
	    	select = new Select(ExpireYear);
	    	select.selectByVisibleText(cardinfo.get(4));
	    	
	    	CardCode.sendKeys(cardinfo.get(5));
	    	
	    	// continue
	    	wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
	    	confirmBtn.click(); 
	    	
	        break;
	    default:
	    	option = paymentmethod_0;
	        // check for option selected
	        if (option.isSelected()) {
				// do nothing
			}else {option.click(); }
	    // continue
	        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodContinueBtn));
	        paymentMethodContinueBtn.click();    
	        break;
	}
		
		
	}
	
	public void paymentcheckInofProceed() {
		wait.until(ExpectedConditions.elementToBeClickable(paymentInfoContinueBtn));
		paymentInfoContinueBtn.click();
		
	}
	public void confirmtheorder() {
		wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
		confirmBtn.click();
		
	}
	
	public void openOrderDetailLink() {
		wait.until(ExpectedConditions.elementToBeClickable(detailorderLink));
		detailorderLink.click();
		
	}
	

	
	
	

}
