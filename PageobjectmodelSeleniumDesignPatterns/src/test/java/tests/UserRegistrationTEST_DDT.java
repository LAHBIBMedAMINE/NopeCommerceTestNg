package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.RegistrationPage;

public class UserRegistrationTEST_DDT extends TestBase{


    HomePage homeobject;
    RegistrationPage registerobject;
    LoginPage loginobject;
    LogoutPage logoutObject;
    
    String mockmail = "habixcvxvbf16699@gmail.com";
    String oldpass = "pipous";
    

    @DataProvider(name="testData")
    public static Object[][] userData(){
    	return new Object [][] {
    		{"Moataz", "Nabil", "Testxxx@gmail.com","12pp34pp56"},
    		{"Moataz", "Nabil", "Testxxx2@gmail.com","12pp34pp56"}
    	};
    }
    
    
    @Test(priority=0,dataProvider = "testData")
    public void UserRegisterInSucess(String name,String LastName,String email, String Password){
        
    	
    	homeobject = new HomePage(driver);
        homeobject.openRegistrationLink();
        
        registerobject = new RegistrationPage(driver);
        registerobject.userRegistration(name,LastName,"25","June","1989",email,Password,"thilala");
        assertTrue(registerobject.ResultMessage.getText().contains("Your registration completed"));
        
        homeobject.openLoginLink();
        loginobject = new LoginPage(driver);
        loginobject.userLogin(email,Password);
        
        logoutObject = new LogoutPage(driver);
        assertTrue(logoutObject.logoutlink.isDisplayed());
        logoutObject.Userlogout();
    	assertTrue(loginobject.Loginbtn.isDisplayed());

    }

}
