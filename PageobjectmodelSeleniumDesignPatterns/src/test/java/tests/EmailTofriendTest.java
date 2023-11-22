package tests;



import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.EmailToFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ProdChoosenPage;
import pages.ReslultProductPage;
import pages.SearchPage;
import pages.RegistrationPage;

public class EmailTofriendTest extends TestBase{
	
	HomePage homePageOB;
	RegistrationPage UserRegistrationOb;
	LoginPage LoginOb;
	SearchPage SearchPageOb;
	ReslultProductPage ReslultProductPageOb;
	ProdChoosenPage ProdChoosenPageOb;
	EmailToFriendPage EmailToFriendPgeOb;
	LogoutPage logoutOb;
	
	// use faker to generate fake data
    Faker fakeData = new Faker();
    String FirstName = fakeData.name().firstName();
    String LastName = fakeData.name().lastName();
    String DayofBirth ="25";
    String MonthofBirth ="June";
    String YearofBirth ="1989";
    String mail = fakeData.internet().emailAddress();
    String friendemail = fakeData.internet().emailAddress();
    String password = fakeData.internet().password(6, 10);
    String newpassword = fakeData.internet().password(6, 10);
    String company =fakeData.company().name();
    String Mailtext ="testing is great";
	
	

    String ProductName = "Apple MacBook Pro 13-inch";

    
	
	
	
	@Test(priority = 0)
	public void RegisterANDLogin () {
		homePageOB = new HomePage(driver);
		UserRegistrationOb = new RegistrationPage(driver);
		LoginOb = new LoginPage(driver);
		
		//registration Phase
		homePageOB.openRegistrationLink();
		UserRegistrationOb.userRegistration("FirstName","LastName",DayofBirth,MonthofBirth,YearofBirth,mail,password,company);
		
		//login Phase
		homePageOB.openLoginLink();
		LoginOb.userLogin(mail, password);
		assertTrue(LoginOb.logoutlink.isDisplayed());
	}
	
	@Test(priority = 1, dependsOnMethods = "RegisterANDLogin")
	public void SearchProduct() {
		SearchPageOb =new SearchPage(driver) ;
		ReslultProductPageOb = new ReslultProductPage(driver);
		SearchPageOb.SearchForProduct(ProductName);
		assertTrue(ReslultProductPageOb.resultProductSelector.isDisplayed());
	}
	
	@Test(priority = 2, dependsOnMethods = "RegisterANDLogin")
	public void emailtofriendxxRegistred() {
		ProdChoosenPageOb = new ProdChoosenPage(driver);
		EmailToFriendPgeOb = new EmailToFriendPage(driver);
		ReslultProductPageOb.openproductlink();
		ProdChoosenPageOb.EmailtoFirendOpnLink();
		EmailToFriendPgeOb.emailtofirend(friendemail,mail , Mailtext);	
		assertTrue(EmailToFriendPgeOb.resultmessage.getText().contains("Your message has been sent"));
	}
	
	//we will logout to test non registered user fail to send
	
	@Test(priority = 3, dependsOnMethods = "RegisterANDLogin")
	public void logout() {
		logoutOb = new LogoutPage(driver);
		logoutOb.Userlogout();
		assertTrue(LoginOb.Loginbtn.isDisplayed());
		
	}
	
	@Test(priority = 4, dependsOnMethods = "logout")
	public void SearchProduct2() {
		SearchPageOb =new SearchPage(driver) ;
		ReslultProductPageOb = new ReslultProductPage(driver);
		SearchPageOb.SearchForProduct(ProductName);
		assertTrue(ReslultProductPageOb.resultProductSelector.isDisplayed());
	}
	
	
	@Test(priority = 5, dependsOnMethods = "logout")
	public void emailtofriendxxNonRegistred() {
		ProdChoosenPageOb = new ProdChoosenPage(driver);
		EmailToFriendPgeOb = new EmailToFriendPage(driver);
		ReslultProductPageOb.openproductlink();
		ProdChoosenPageOb.EmailtoFirendOpnLink();
		EmailToFriendPgeOb.emailtofirend(friendemail, mail, Mailtext);	
		assertTrue(EmailToFriendPgeOb.errorMessage.getText().contains("Only registered customers can use email a friend feature"));
	}
	
	
	
	

}
