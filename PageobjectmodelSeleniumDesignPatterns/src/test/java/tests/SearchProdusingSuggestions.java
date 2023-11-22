package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.SearchPage;

public class SearchProdusingSuggestions extends TestBase{

	SearchPage SearchPageObjeect;
	
	
	String ProductName = "mac";
	
	@Test
	public void SearchProduct() {
		SearchPageObjeect =new SearchPage(driver) ;
		
		SearchPageObjeect.searchprodusinglist(ProductName);
		assertTrue(SearchPageObjeect.itemrequested.getText()
				.contains(SearchPageObjeect.productsuggesstions.get(0).getText()));	
	}
	
	

}
