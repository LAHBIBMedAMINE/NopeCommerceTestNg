package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.MyAccountPage;
import pages.RegistrationPage;

public class ChangeMyPasswordTest extends TestBase {

	
	HomePage homeobject;
	MyAccountPage myaccountObject;
	RegistrationPage registerobject;
    LoginPage loginobject;
    LogoutPage logoutObject;
    
    // use faker to generate fake data
    Faker fakeData = new Faker();
    String FirstName = fakeData.name().firstName();
    String LastName = fakeData.name().lastName();
    String DayofBirth ="25";
    String MonthofBirth ="June";
    String YearofBirth ="1989";
    String mail = fakeData.internet().emailAddress();
    String password = fakeData.internet().password(6, 10);
    String newpassword = fakeData.internet().password(6, 10);
    String company =fakeData.company().name();
    
    @Test(priority=0)
    public void UserRegisterInSucess(){
        homeobject = new HomePage(driver);
        homeobject.openRegistrationLink();
        registerobject = new RegistrationPage(driver);
        registerobject.userRegistration(FirstName,LastName,DayofBirth,MonthofBirth,YearofBirth,mail,password,company);
        assertTrue(registerobject.ResultMessage.getText().contains("Your registration completed"));

    }
    
    @Test(priority=1,dependsOnMethods = "UserRegisterInSucess")
    public void UserLogInSucess(){
        homeobject.openLoginLink();
        loginobject = new LoginPage(driver);
        loginobject.userLogin(mail,password);
        logoutObject =new LogoutPage(driver);
        assertTrue(logoutObject.logoutlink.isDisplayed());

    }
    
    @Test(priority=2,dependsOnMethods = "UserRegisterInSucess")
    public void changeMyPassword() {
    	homeobject.openMyAccountLink();
    	myaccountObject = new MyAccountPage(driver);
    	myaccountObject.ChangeThePasswordSuccess(password, newpassword);
    	assertTrue(myaccountObject.resultnotification.getText().contains("Password was changed"));
    	myaccountObject.closebtn.click();
    	
    	
    }
    
    @Test(priority=4,dependsOnMethods = "UserRegisterInSucess")
    public void LogoutLoginCheck() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOf(logoutObject.logoutlink));
    	wait.until(ExpectedConditions.elementToBeClickable(logoutObject.logoutlink));
    	logoutObject.Userlogout();
    	homeobject.openLoginLink();
    	loginobject.userLogin(mail, newpassword);
    	
    	
    }
	
}
