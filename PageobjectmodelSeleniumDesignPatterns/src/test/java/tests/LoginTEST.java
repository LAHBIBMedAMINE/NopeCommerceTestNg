package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;


public class LoginTEST extends TestBase{

    HomePage homeobject;
    LoginPage loginobject;
    LogoutPage logoutObject;

    @Test(priority=0)
    public void UserLogInSucess(){
        homeobject = new HomePage(driver);
        homeobject.openLoginLink();
        loginobject = new LoginPage(driver);
        loginobject.userLogin("mimo11vbvc123@gmail.com","letsdance1112");

    }

    public void UserLogout() {
    	logoutObject.Userlogout();

    }

}
