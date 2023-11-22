package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProdChoosenPage;
import pages.ReslultProductPage;
import pages.SearchPage;
import pages.WishListPage;

public class WishListTest extends TestBase{
	
	
	WishListPage wishListpgOb;
	HomePage homePgOb;
	SearchPage SearchPgOb;
	ReslultProductPage ReslultProductPgOb;
	ProdChoosenPage ProdChoosenPgOb;
	
	String ProductName = "Apple MacBook Pro 13-inch";
	String ProductName2 = "Lenovo IdeaCentre 600 All-in-One PC";
	
	@Test(priority = 0)
	public void VerifyWishListEmpty() {
		homePgOb = new HomePage(driver);
		wishListpgOb = new WishListPage(driver);
		// verifying That the WishList is empty
		homePgOb.openWishListLink();
		assertTrue(wishListpgOb.noDataMessage.getText().contains("The wishlist is empty!"));
	}
	
	@Test(priority=1)
	public void SearchProduct() {
		SearchPgOb =new SearchPage(driver) ;
		ReslultProductPgOb = new ReslultProductPage(driver);
		ProdChoosenPgOb = new ProdChoosenPage(driver);
		
		//Search for the product
		SearchPgOb.SearchForProduct(ProductName);
		assertTrue(ReslultProductPgOb.resultProductSelector.isDisplayed());
		//display the product page
		ReslultProductPgOb.openproductlink();
			
	}
	
	@Test(priority=2)
	public void addToWhishLIst() {
		ProdChoosenPgOb = new ProdChoosenPage(driver);
		
		// add product to WiShlit
		ProdChoosenPgOb.addToWishList();
		
		//verify phase
		homePgOb.openWishListLink();
		//verify the table of wishList is displayed
		assertTrue(wishListpgOb.tablewishList.isDisplayed());
		//verify the table of wishList contains only one
		assertEquals(wishListpgOb.wishListContent.size(),1);	
	}
	
	@Test(priority=3)
	public void SearchsecondProduct() {
		//Search for a second product
		SearchPgOb.SearchForProduct(ProductName2);
		assertTrue(ReslultProductPgOb.resultProductSelector.isDisplayed());
		//display the product page
		ReslultProductPgOb.openproductlink2();
			
	}
	
	@Test(priority=4)
	public void addsecondToWhishLIst() {
		// add product second to WiShlit
		ProdChoosenPgOb.addToWishListlenovo();
		
		//verify phase
		homePgOb.openWishListLink();
		//verify the table of wishList is displayed
		assertTrue(wishListpgOb.tablewishList.isDisplayed());
		//verify the table of wishList contains 2 element
		assertEquals(wishListpgOb.wishListContent.size(),2);
	}
	
	@Test(priority=5)
	public void removeItemfromWhishList() {
		wishListpgOb.removeItem();
		
		//verify phase
		//verify the table of wishList is displayed
		assertTrue(wishListpgOb.tablewishList.isDisplayed());
		//verify the table of wishList contains 2 element
		assertEquals(wishListpgOb.wishListContent.size(),1);
		
		//remove the second
		wishListpgOb.removeItem();
		//verify phase
		assertTrue(wishListpgOb.noDataMessage.getText().contains("The wishlist is empty!"));
		
	}
	

}
