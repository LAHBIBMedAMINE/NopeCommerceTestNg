package utility;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class Helper {
	
	public JavascriptExecutor js;

	// Method to take screen when the case fail
	
	public static void captureScreenShot(WebDriver driver, String ScreenShotName) {
		
		
		long currentTimeMillis = System.currentTimeMillis();
        // Format the date and time
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm  yyyy");
        String formattedDate = dateFormat.format(new Date(currentTimeMillis));

        // Replace invalid characters in the formatted date and time
        formattedDate = formattedDate.replaceAll("[^a-zA-Z0-9]", "_");
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        js.executeScript("document.body.style.zoom = 0.25");
        
        
	
    
	
	Path destination = Paths.get("./screenShots", ScreenShotName+" "+formattedDate+".png");
		try {
			Files.createDirectories(destination.getParent());
			FileOutputStream out = new FileOutputStream(destination.toString());
			TakesScreenshot ts = (TakesScreenshot) driver;
			out.write((ts.getScreenshotAs(OutputType.BYTES)));
			out.close();
		} catch (IOException e) {
			System.out.println("(----------------Exception while taking screenshot----------------)"+e.getMessage());
			
		}
		
	}
	
	public static void explicitScreenShot(WebDriver driver, String ScreenShotName) {
		long currentTimeMillis = System.currentTimeMillis();
        // Format the date and time
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm  yyyy");
        String formattedDate = dateFormat.format(new Date(currentTimeMillis));

        // Replace invalid characters in the formatted date and time
        formattedDate = formattedDate.replaceAll("[^a-zA-Z0-9]", "_");
	
    
	
        Path destination = Paths.get("./screenShots", ScreenShotName+" "+formattedDate+".png");
		try {
			Files.createDirectories(destination.getParent());
			FileOutputStream out = new FileOutputStream(destination.toString());
			TakesScreenshot ts = (TakesScreenshot) driver;
			out.write((ts.getScreenshotAs(OutputType.BYTES)));
			out.close();
		} catch (IOException e) {
			System.out.println("(----------------Exception while taking screenshot----------------)"+e.getMessage());
			
		}
		
	}

}
