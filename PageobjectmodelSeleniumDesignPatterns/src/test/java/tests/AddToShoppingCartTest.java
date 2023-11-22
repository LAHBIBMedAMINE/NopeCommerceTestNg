package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.CompareProdPage;
import pages.DesktopPage;
import pages.HomePage;
import pages.NoteBookPage;
import pages.Shopping_cartPage;

public class AddToShoppingCartTest extends TestBase{
	
	HomePage homePgOb;
	NoteBookPage NoteBookPgOb;
	CompareProdPage CompareProdPgOb;
	DesktopPage DesktopPgOb;
	Shopping_cartPage Shopping_cartPgOb;
	
	// navigate to desktop page
	@Test(priority = 1)
	public void HoverOverMenu() {
		homePgOb = new HomePage(driver);
		homePgOb.hoveroverMenu(homePgOb.computerSection, false);
		homePgOb.hoveroverMenu(homePgOb.DesktopsSection, true);
		assertTrue(driver.getCurrentUrl().contains("desktops"));
	}
	
	//add elements to shopping cart
	@Test(priority =2 )
	private void AddToshopCart() {
		DesktopPgOb = new DesktopPage(driver);
		
		DesktopPgOb.addTocard(1);
		DesktopPgOb.addTocard(2);
	}
	
	//Hover to flyoutcard and check element
	@Test(priority =3 )
	public void Flyoutcartcheck() {
		// check displaying of flyout-cart 
		DesktopPgOb.hoveroverMenu(DesktopPgOb.shoppingcartLink, false);
		assertTrue(DesktopPgOb.flyoutcart.isDisplayed());
		//check displaying of flyout-cart content
		assertEquals(DesktopPgOb.productList.size(),2);
	}
	
	@Test(priority =4)
	public void checkShoppingcart() {
		Shopping_cartPgOb = new Shopping_cartPage(driver);
		// open shoppingCart
		Shopping_cartPgOb.openshoppingcart();
		//check shopping table is displayed
		assertTrue(Shopping_cartPgOb.shoppingTable.isDisplayed());
		//check number of product displayed
		assertEquals(Shopping_cartPgOb.productList.size(),2);
	}
	
	
	
	

}
