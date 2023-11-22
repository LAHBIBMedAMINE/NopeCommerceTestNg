package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;

public class HoverMenuTest extends TestBase{
	
	HomePage homePgOb;
	
	
	@Test
	public void HoverOverMenu() {
		HomePage homePgOb = new HomePage(driver);
		homePgOb.hoveroverMenu(homePgOb.computerSection, false);
		homePgOb.hoveroverMenu(homePgOb.NotebooksSection, true);
		assertTrue(driver.getCurrentUrl().contains("notebooks"));
		
		
	}

}
