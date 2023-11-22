package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewPage extends PageBase{

	public ReviewPage(WebDriver driver) {
		super(driver);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@FindBy(css="#AddProductReview_Title")
	public WebElement titleText;
	
	@FindBy(id="AddProductReview_Title")
	WebElement reviewTitleTxBx;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement reviewTextTxBx;
	
	@FindBy(id="addproductrating_1")
	WebElement Star1;
	@FindBy(id="addproductrating_2")
	WebElement Star2;
	@FindBy(id="addproductrating_3")
	WebElement Star3;
	@FindBy(id="addproductrating_4")
	WebElement Star4;
	@FindBy(id="addproductrating_5")
	WebElement Star5;
	
	@FindBy(css="button.button-1.write-product-review-button")
	WebElement SubmitReviewBtn;
	
	@FindBy(css="div.result")
	public WebElement messageresult;
	
	
	@FindBy(css ="div.page-title > h1 > a")
	public WebElement productlink;
	
	
	public void AddaReview(String Title, String reviewText, int star) {
		
		
		wait.until(ExpectedConditions.visibilityOf(reviewTextTxBx));
		reviewTitleTxBx.sendKeys(Title);
		reviewTextTxBx.sendKeys(reviewText);
		
        switch (star) {
        case 1:
        	Star1.click();
            break;
        case 2:
        	Star2.click();
            break;
        case 3:
        	Star3.click();
            break;
        case 4:
        	Star4.click();
            break;
        case 5:
        	Star5.click();
            break;
        default:
        	break;
            
    }
        SubmitReviewBtn.click();
	}
	

}
