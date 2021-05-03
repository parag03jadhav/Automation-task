package com.pj.framework.framework;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.LoggingAssert;

import com.pj.framework.framework.App;

import pageObject.Logigng;
import pageObject.LoginPage;

public class Home extends App
{
	public static Logger logg=LogManager.getLogger(Home.class.getName());
	@Test(dataProvider="getData")
	public void log(String us,String ps) throws IOException {
		driver=openBrowser();
		logg.info("is intilize");
		driver.get(pi.getProperty("url"));
		Logigng log=PageFactory.initElements(driver,Logigng.class);
		log.Login();
		LoginPage log1=PageFactory.initElements(driver,LoginPage.class);
		log1.Singin(us,ps);
		logg.info("Done");
	}
	@AfterTest
	public void Close() {
		
		driver.close();
	}
     @DataProvider
	
	public Object[][] getData() {
		Object [][] obj=new Object[1][2];
		obj[0][0]="Parag03jadhav@gmail.com";
		obj[0][1]="parag123";
		/*
		 * obj[1][0]="Anii@gmail.com"; obj[1][1]="Anii123"; obj[2][0]="Ashi@gmail.com";
		 * obj[2][1]="Ashi123";
		 */return obj;
		
	}
	
}
