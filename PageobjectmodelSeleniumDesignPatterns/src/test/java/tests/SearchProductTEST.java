package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ReslultProductPage;
import pages.SearchPage;

public class SearchProductTEST extends TestBase{
	
	HomePage homepageObject;
	SearchPage SearchPgOb;
	ReslultProductPage ReslultProductPgOb;
	
	String ProductName = "Apple MacBook Pro 13-inch";
	
	@Test
	public void SearchProduct() {
		homepageObject = new HomePage(driver);
		SearchPgOb =new SearchPage(driver) ;
		ReslultProductPgOb = new ReslultProductPage(driver);
		SearchPgOb.SearchForProduct(ProductName);
		assertTrue(ReslultProductPgOb.resultProductSelector.isDisplayed());
		System.out.println(ReslultProductPgOb.itemName.getText());
			
	}
	
	

}
