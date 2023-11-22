package tests;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utility.Helper;

public class TestBase extends AbstractTestNGCucumberTests{
    public static WebDriver driver;
    public static String downloadpath = System.getProperty("user.dir")+"\\downloads";
    
    public static ChromeOptions chromeoptions() {	
		ChromeOptions option = new ChromeOptions();
		
		HashMap<String,Object> chromePrefs = new HashMap<String,Object>();
		chromePrefs.put("profile.default.content.settings.popups",0);
		chromePrefs.put("download.default_directory", downloadpath );
		option.setExperimentalOption("prefs", chromePrefs);
		option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		option.addArguments("--download-dir=C:\\Users\\LAHBIB MOHAMED AMINE\\eclipse-workspace\\DDIS\\downloads");
		return option;
	}
    
    public static FirefoxOptions firefoxOption() {
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadpath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		option.addPreference("pdfjs.disabled", true);
		return option;
	}
    

    @BeforeClass
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName){
    	if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(chromeoptions());
    	}else if(browserName.equalsIgnoreCase("firefox")){
    		driver = new FirefoxDriver();
    	}else if(browserName.equalsIgnoreCase("edge")) {
    		driver = new EdgeDriver();
    	}
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	driver.navigate().to("https://demo.nopcommerce.com/");


    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
    
    @AfterMethod
    public void takescreenshotFailure(ITestResult result) {
    	if (ITestResult.FAILURE == result.getStatus()) {
    		System.out.println("(-----------------Failed we are Taking ScreenShot----------------)");
			Helper.captureScreenShot(driver, result.getName());
			
		}
    	
    }

}
