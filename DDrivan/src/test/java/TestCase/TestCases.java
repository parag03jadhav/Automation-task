package TestCase;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pj.DDriven.DDrivan.AppTest;
import com.pj.DDriven.DDrivan.CustomLis;

import POM.Login;



@Listeners(CustomLis.class)
public class TestCases extends AppTest{ 
	
	
	public static Workbook wb;
	public static Sheet sh;
	public static Row row;
	public static Cell cell;
	

	@Test(dataProvider="Data")
	public void Case(String name,String pass) throws IOException, InterruptedException {
		driver=Utility();
		driver.get(pi.getProperty("url"));
		Login l=PageFactory.initElements(driver, Login.class);
		l.Details(name, pass);
		
	}
	@BeforeTest
	public void Excel() throws IOException {
		FileInputStream fi=new FileInputStream("C:\\java\\eclipes\\selenium\\DDrivan\\src\\test\\java\\resource\\Data.xlsx");
		 wb=new XSSFWorkbook(fi);
	     sh=wb.getSheet("Sheet1");
	     
	}
	  
	@DataProvider
	public Object [][] Data(){
		int rcount=sh.getLastRowNum();
		row=sh.getRow(0);
		System.out.println(row);
		int cCount=row.getLastCellNum();
		Object [][] obj=new Object[rcount][cCount];
		for (int i = 0; i < rcount; i++) {
			for (int j = 0; j < cCount; j++) {
				DataFormatter d=new DataFormatter();
				obj[i][j]=d.formatCellValue(sh.getRow(i + 1).getCell(j));
				
				
			}
		}
		return obj;
	}
	
	
	/*
	 * Faild Test Case ScreenShot
	 */
	@Test
	public void Failed() {
		
		Assert.assertEquals(false, true);
		
	}
	
	/*
	 * Checking Particular element in webpage
	 */
	  @Test
      public void Checking() {
		  try {
			  driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span1"));
		  }
		  catch (Exception e) {
			  
		  }
         System.out.println("Element is not present");	
         }
	
	@AfterClass
	public void close() {
		driver.quit();
	}
	}

/*/
 * How to Handles frame in Selenium?
 * 
 * Ans
 * 
 * In webpage we cant see that is there frame is present or no just right click on that element and there is an option view pagesource frame
 * so this the frame.
 * handles frame in three ways: BY index,By name ,By webelement
 * for example 
 * driver.switchto().frame(0)= Byindex
 *  driver.switchto().frame("Name")=By Name
 *  
 *  And after that we do Actions on that
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

