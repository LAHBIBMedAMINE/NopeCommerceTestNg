package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.CheckOutPage;
import pages.DesktopPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderInformationPage;
import pages.Shopping_cartPage;
import pages.RegistrationPage;

/* The TEST FLOWs
 * first   0:Test  register a user and login (even the registration fails due existing mail the test continue to login)
 * second  1:Test  move to desktop page
 * third   2:Test  chose 2 desktop to add to cart (the second and third desktop)
 * forth   3:Test  check the shopping page content
 * Fifth   4:Test  proceed to checkout (check the agreeButon)
 * sixth   5:Test  Fill all from  till the success of order (option available (payment method,shipment method)
 * seventh 7:Test  download the PDF Of the order
*/
public class CheckOutTest extends TestBase{
	
	HomePage homepgOb;
	RegistrationPage UserRegistrationOb;
	LoginPage LoginOb;
	DesktopPage DesktopPgOb;
	Shopping_cartPage Shopping_cartPgOb;
	CheckOutPage CheckOutPgOb;
	OrderInformationPage OrderInformationPgOp;
	
	// use faker to generate fake data
    Faker fakeData = new Faker();
	
	//registration

    String FirstName = fakeData.name().firstName();
    String LastName = fakeData.name().lastName();
    String DayofBirth ="25";
    String MonthofBirth ="June";
    String YearofBirth ="1989";
    String mail = fakeData.internet().emailAddress();
    String password = fakeData.internet().password(6, 10);
    String newpassword = fakeData.internet().password(6, 10);
    String company =fakeData.company().name();

    //filling form
    String country ="United States";
    String state ="California";
    String city =fakeData.address().city();
    String adress1 =fakeData.address().streetAddress();
    String adress2 =fakeData.address().streetAddress();
    String zipcode =fakeData.address().zipCode();
    String phone = fakeData.phoneNumber().cellPhone();
    String fax = fakeData.phoneNumber().phoneNumber();
    String cardNumber =fakeData.finance().creditCard();
    
    //select option
    String PaymethOP1 = "Paybycreditordebitcard";
    String PaymethOP2 ="Paybycheque";
    // card info
    List<String> cardInfo = List.of("Visa",FirstName,cardNumber,"06","2027","396");
    String shipmeth = "shippingoption_0";
	
	@Test(priority = 0)
	public void RegisterANDLogin () {
		homepgOb = new HomePage(driver);
		UserRegistrationOb = new RegistrationPage(driver);
		LoginOb = new LoginPage(driver);
		
		//registration Phase ** Even the registration failed due to existing mail the test will continue to login
		homepgOb.openRegistrationLink();
		UserRegistrationOb.userRegistration(FirstName,LastName,DayofBirth,MonthofBirth,YearofBirth,mail,password,company);
		
		//login Phase
		homepgOb.openLoginLink();
		LoginOb.userLogin(mail, password);
		assertTrue(LoginOb.logoutlink.isDisplayed());
	}
	
	
	
	// navigate to desktop page
	@Test(priority = 1)
	public void HoverOverMenu() {
		homepgOb.hoveroverMenu(homepgOb.computerSection, false);
		homepgOb.hoveroverMenu(homepgOb.DesktopsSection, true);
		assertTrue(driver.getCurrentUrl().contains("desktops"));
	}
	
	//add elements to shopping cart
	@Test(priority =2 )
	private void AddToshopCart() {
		DesktopPgOb = new DesktopPage(driver);
		
		DesktopPgOb.addTocard(1);
		DesktopPgOb.addTocard(2);
	}
	
	//navigate to shopping cart Page
	@Test(priority =3)
	public void checkShoppingcart() {
		Shopping_cartPgOb = new Shopping_cartPage(driver);
		// open shoppingCart
		Shopping_cartPgOb.openshoppingcart();
		//check shopping table is displayed
		assertTrue(Shopping_cartPgOb.shoppingTable.isDisplayed());
		//check number of product displayed
		assertEquals(Shopping_cartPgOb.productList.size(),2);
	}
	
	@Test(priority =4)
	public void proceedTocheckOut() {
		Shopping_cartPgOb.EnsureAndCheckAgreeTermsButton();
		// Agree Terms Check
		assertTrue(Shopping_cartPgOb.agreeTermscheck.isSelected());
		// proceed to checkout
		Shopping_cartPgOb.proceedTocheckout();
	}
	
	@Test(priority = 5)
	public void fillinfoAndOptionSelecton() {
		CheckOutPgOb = new CheckOutPage(driver);
		
		CheckOutPgOb.EnsureAndCheckShipToSameAdress();
		CheckOutPgOb.FilladressForm(country, state, city, adress1, adress2, zipcode, phone, fax);
		CheckOutPgOb.SelectshippingoptionAndContinue(shipmeth);
		CheckOutPgOb.SelectPaymentoptionAndContinue(PaymethOP1,cardInfo);
		CheckOutPgOb.paymentcheckInofProceed();
		CheckOutPgOb.confirmtheorder();
		assertTrue(CheckOutPgOb.orderSuccessMsg.getText().contains("Your order has been successfully processed!"));
	}
	
	@Test(priority =6)
	public void downloadPdfTest() throws InterruptedException {
		CheckOutPgOb.openOrderDetailLink();
		OrderInformationPgOp = new OrderInformationPage(driver);
		OrderInformationPgOp.pdfDownload();
		Thread.sleep(15000);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
