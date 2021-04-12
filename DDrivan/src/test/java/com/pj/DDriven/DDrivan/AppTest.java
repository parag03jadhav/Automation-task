package com.pj.DDriven.DDrivan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppTest 
    
{
	public static WebDriver driver;
	public FileInputStream fi;
	public Properties pi;
	
	
	public WebDriver Utility() throws IOException {
		
	 fi=new FileInputStream("C:\\java\\eclipes\\selenium\\DDrivan\\src\\test\\java\\resource\\resource.properties");
		 pi=new Properties();
		pi.load(fi);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Parag\\Downloads\\chromedriver\\chromedriver.exe");
		//driver=new ChromeDriver();
		String br=pi.getProperty("browser");
	    if(br.equals("chrome")) {
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Parag\\Downloads\\chromedriver\\chromedriver.exe");
	    	driver=new ChromeDriver();
	    }
	    else if (br.equals("firefox")) {
			driver=new FirefoxDriver();
		}
	    else if (br.equals("iE")) {
			
		}
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		return driver;

		
	}
	
	 public  void takescreenshot(String Testmethod) throws IOException {
   	  Date d=new Date();
   	 SimpleDateFormat s=new SimpleDateFormat("dd-mm-yy hh-mm-ss");
   	 String date=s.format(d);
   	 
   	 TakesScreenshot ts=(TakesScreenshot)driver;
   	 File f=ts.getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(f, new File("C:\\java\\eclipes\\selenium\\DDrivan\\ScreenShot\\" + "Img"+Testmethod+ ""+date +".jpg"));
       
       
     
     
}
}
