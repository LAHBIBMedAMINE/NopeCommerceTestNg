package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.CompareProdPage;
import pages.HomePage;
import pages.NoteBookPage;

public class CompareProductTEST extends TestBase{
	
	HomePage homePgOb;
	NoteBookPage NoteBookPgOb;
	CompareProdPage CompareProdPgOb;
	
	
	@Test(priority = 1)
	public void HoverOverMenu() {
		homePgOb = new HomePage(driver);
		homePgOb.hoveroverMenu(homePgOb.computerSection, false);
		homePgOb.hoveroverMenu(homePgOb.NotebooksSection, true);
		assertTrue(driver.getCurrentUrl().contains("notebooks"));
		
	}
	
	
	@Test(priority = 2)
	public void addTocompareProd() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		NoteBookPgOb = new NoteBookPage(driver);
		CompareProdPgOb = new CompareProdPage(driver);
		
		// verify that there is no compare item
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		assertTrue(CompareProdPgOb.noItemtoCompareMsg.getText().contains("You have no items to compare."));
		
		// back to notebookPage and chose 3 item to compare
		driver.navigate().back();
		NoteBookPgOb.addToCompare(1);
		wait.until(ExpectedConditions.visibilityOf(NoteBookPgOb.ClosenotificationProdComp));
		NoteBookPgOb.ClosenotificationProdComp.click();
		wait.until(ExpectedConditions.invisibilityOf(NoteBookPgOb.ClosenotificationProdComp));


		NoteBookPgOb.addToCompare(2);
		wait.until(ExpectedConditions.visibilityOf(NoteBookPgOb.ClosenotificationProdComp));
		NoteBookPgOb.ClosenotificationProdComp.click();
		wait.until(ExpectedConditions.invisibilityOf(NoteBookPgOb.ClosenotificationProdComp));
		
		
		NoteBookPgOb.addToCompare(3);
		wait.until(ExpectedConditions.visibilityOf(NoteBookPgOb.ClosenotificationProdComp));
		NoteBookPgOb.ClosenotificationProdComp.click();
		wait.until(ExpectedConditions.invisibilityOf(NoteBookPgOb.ClosenotificationProdComp));
		
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		// verify the number of Item
		assertEquals(CompareProdPgOb.productstocompare.size(),3);
		
		
		
	}
	
	@Test(priority = 3)
	public void removeItem() {
		// remove one object
		CompareProdPgOb.removeItem(0);
		//verify the removal
		assertEquals(CompareProdPgOb.productstocompare.size(),2);
		//clear the list
		CompareProdPgOb.clearlist();
		// verify list is clear
		assertTrue(CompareProdPgOb.noItemtoCompareMsg.getText().contains("You have no items to compare."));
		
		
		
		
		
	}
	
	

}
