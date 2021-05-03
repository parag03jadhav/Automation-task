package com.pj.framework.framework;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class App 
{
    public WebDriver driver;
    public Properties pi;
    @Test
	public WebDriver openBrowser() throws IOException {
		FileInputStream fi=new FileInputStream("C:\\java\\eclipes\\selenium\\framework\\src\\main\\java\\resource\\data.properties");
	     pi=new Properties();
	    pi.load(fi);
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
	
	
    
}
