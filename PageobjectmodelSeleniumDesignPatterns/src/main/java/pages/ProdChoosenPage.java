package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdChoosenPage extends PageBase{

	public ProdChoosenPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement emailBtn;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addtowishlistBtn;
	
	@FindBy(linkText = "Add your review")
	WebElement addreviewLink;
	
	@FindBy(id="add-to-wishlist-button-4")
	WebElement addToWishListBtn;
	
	@FindBy(id="add-to-wishlist-button-3")
	WebElement addToWishListBtn3;
	
	@FindBy(id="add-to-cart-button-4")
	WebElement addTocartBtn;
	
	public void EmailtoFirendOpnLink() {
		emailBtn.click();
	}
	
	public void addReviewOpnLink() {
		addreviewLink.click();
	}
	
	public void addToWishList() {
		addToWishListBtn.click();
	}
	public void addToWishListlenovo() {
		addToWishListBtn3.click();
	}
	public void addTocart() {
		addTocartBtn.click();
	}

}
