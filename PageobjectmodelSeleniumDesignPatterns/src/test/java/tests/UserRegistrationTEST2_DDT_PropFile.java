package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.RegistrationPage;

public class UserRegistrationTEST2_DDT_PropFile extends TestBase{


    HomePage homeobject;
    RegistrationPage registerobject;
    LoginPage loginobject;
    LogoutPage logoutObject;
    
    String mockmail = "habixcvxvbf16699@gmail.com";
    String oldpass = "pipous";
    

    @Test(priority=0)
    public void UserRegisterInSucess(){
        homeobject = new HomePage(driver);
        homeobject.openRegistrationLink();
        registerobject = new RegistrationPage(driver);
        registerobject.userRegistration("AMINE","LAHBIB","25","June","1989",mockmail,oldpass,"thilala");
        assertTrue(registerobject.ResultMessage.getText().contains("Your registration completed"));

    }
    @Test(priority=1,dependsOnMethods ="UserRegisterInSucess" )
    public void UserLogInSucess(){
        homeobject.openLoginLink();
        loginobject = new LoginPage(driver);
        loginobject.userLogin(mockmail,oldpass);
        logoutObject = new LogoutPage(driver);
        assertTrue(logoutObject.logoutlink.isDisplayed());

    }
    
    @Test(priority=2,dependsOnMethods = "UserRegisterInSucess")
    public void UserLogout() {
    	logoutObject.Userlogout();
    	assertTrue(loginobject.Loginbtn.isDisplayed());

    }
}
