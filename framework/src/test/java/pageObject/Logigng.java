package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.pj.framework.framework.App;

public class Logigng {
  
	
	 public WebDriver driver;
	 public static Logger logg=LogManager.getLogger(App.class.getName());
	 public Logigng(WebDriver driver) {
		 this.driver=driver;
	 }
	 
	 @FindBy(xpath="//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a")
	 WebElement login;
	 
	 @FindBy(xpath="//div[@class='text-center']/h2")
	 WebElement title;
	 public void Login() {
		 Assert.assertEquals(title.getText(), "FEATURED COURSES");
		 
		 login.click();
		 
	 }
	 
}
