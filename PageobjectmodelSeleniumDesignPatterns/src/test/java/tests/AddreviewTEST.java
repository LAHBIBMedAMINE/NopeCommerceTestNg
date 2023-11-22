package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.ProdChoosenPage;
import pages.ReslultProductPage;
import pages.ReviewPage;
import pages.SearchPage;
import pages.RegistrationPage;

public class AddreviewTEST extends TestBase{
	
	
	HomePage homepageOb;
	SearchPage SearchPageOb;
	ReslultProductPage ReslultProductPageOb;
	ProdChoosenPage ProdChoosenPageOb;
	RegistrationPage UserRegistrationOb;
	LoginPage LoginOb;
	ReviewPage reviewPgOb;
	
	String ProductName = "Apple MacBook Pro 13-inch";
	
	// use faker to generate fake data
    Faker fakeData = new Faker();
    String FirstName = fakeData.name().firstName();
    String LastName = fakeData.name().lastName();
    String DayofBirth ="25";
    String MonthofBirth ="June";
    String YearofBirth ="1989";
    String mail = fakeData.internet().emailAddress();
    String password = fakeData.internet().password(6, 10);
    String newpassword = fakeData.internet().password(6, 10);
    String company =fakeData.company().name();
    String reviewText= "have a nice day";
    String reviewTitleText= "I love apple";

	
	
	
	@Test(priority = 0)
	public void RegisterANDLogin () {
		homepageOb = new HomePage(driver);
		UserRegistrationOb = new RegistrationPage(driver);
		LoginOb = new LoginPage(driver);
		
		//registration Phase ** Even the registration failed due to existing mail the test will continue to login
		homepageOb.openRegistrationLink();
		UserRegistrationOb.userRegistration(FirstName,LastName,DayofBirth,MonthofBirth,YearofBirth,mail,password,company);
		
		//login Phase
		homepageOb.openLoginLink();
		LoginOb.userLogin(mail, password);
		assertTrue(LoginOb.logoutlink.isDisplayed());
	}
	
	@Test(priority = 1,dependsOnMethods = "RegisterANDLogin")
	public void SearchProduct() {
		SearchPageOb =new SearchPage(driver) ;
		ReslultProductPageOb = new ReslultProductPage(driver);
		ProdChoosenPageOb = new ProdChoosenPage(driver);
		
		// search and display the chosen product
		SearchPageOb.SearchForProduct(ProductName);
		assertTrue(ReslultProductPageOb.resultProductSelector.isDisplayed());
		ReslultProductPageOb.openproductlink();	
		ProdChoosenPageOb.addReviewOpnLink();
	}
	
	@Test(priority = 2,dependsOnMethods = "RegisterANDLogin")
	public void addReview() {
		reviewPgOb = new ReviewPage(driver);
	
		
		for (int i=1; i<6; i++) 
		{
		reviewPgOb.AddaReview(reviewTitleText+i, reviewText+i, i);
		assertTrue(reviewPgOb.messageresult.getText().contains("Product review is successfully added"));
		reviewPgOb.productlink.click();
		ProdChoosenPageOb.addReviewOpnLink();
		}
		
		
	}
	
	
	

}
