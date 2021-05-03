package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pj.framework.framework.App;

public class LoginPage {
	
	public WebDriver driver;
	public static Logger logg=LogManager.getLogger(App.class.getName());
	@FindBy(id="user_email")
	WebElement user;
	@FindBy(id="user_password")
	WebElement pass;
	
	@FindBy (name="commit")
	WebElement submit;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void Singin(String u,String p){
		user.sendKeys(u);
		pass.sendKeys(p);
	    submit.click();
	}

}
