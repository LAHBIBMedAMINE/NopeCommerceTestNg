package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.ContactAsPage;
import pages.HomePage;

public class ContactusTEST extends TestBase{
	
	ContactAsPage contactuspageOb;
	HomePage homepageOb;
	
	// use faker to generate fake data
	Faker fakeData = new Faker();
	String FirstName = fakeData.name().firstName();
	String mail = fakeData.internet().emailAddress();
	String txt="you are the best";
	
	@Test
	public void contactUsTTS() {
		contactuspageOb = new ContactAsPage(driver);
		homepageOb = new HomePage(driver);
		homepageOb.openContactusLink();
		contactuspageOb.FillFromContactUs(FirstName, mail, txt);
		assertTrue(contactuspageOb.resultRx.getText().contains("Your enquiry has been successfully sent to the store owner."));
		
		
	}

}
