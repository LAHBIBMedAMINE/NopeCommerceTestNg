package tests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProdChoosenPage;
import pages.ReslultProductPage;
import pages.SearchPage;

public class ChangeCureencyTest extends TestBase{
	
	HomePage homepgOb;
	
	
	HomePage homepageObject;
	SearchPage SearchPageObjeect;
	ReslultProductPage ReslultProductPageOb;
	ProdChoosenPage ProdChoosenPageOb;
	
	String ProductName = "Apple MacBook Pro 13-inch";
	List<String> euroCurrency = List.of("Euro", "€") ;
	List<String> UsDollarCurrency = List.of("US Dollar", "$") ;
	
	@Test(priority = 0)
	public void SearchProduct() {
		homepageObject = new HomePage(driver);
		SearchPageObjeect =new SearchPage(driver) ;
		ReslultProductPageOb = new ReslultProductPage(driver);
		SearchPageObjeect.SearchForProduct(ProductName);
		assertTrue(ReslultProductPageOb.resultProductSelector.isDisplayed());
			
	}
	
	
	
	@Test(priority = 1, dependsOnMethods = "SearchProduct")
	public void selectEuro() {
		homepageObject = new HomePage(driver);
		homepageObject.changeCurrency(euroCurrency.get(0));
		assertTrue(SearchPageObjeect.priceTag.getText().contains(euroCurrency.get(1)));
	}
	
	@Test(priority = 2, dependsOnMethods = "selectEuro")
	public void selectUSdollar() {
		ProdChoosenPageOb = new ProdChoosenPage(driver);
		ReslultProductPageOb.openproductlink();
		homepageObject.changeCurrency(UsDollarCurrency.get(0));
		assertTrue(SearchPageObjeect.priceTag.getText().contains(UsDollarCurrency.get(1)));
		

	}
	
	

}
