package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.pj.DDriven.DDrivan.AppTest;

public class Login extends AppTest {
	
	@FindBy(id="user-name")
    WebElement name;
	
	@FindBy(id="password")
    WebElement pass;
	
	@FindBy(id="login-button")
    WebElement login;
	
	@FindBy(xpath="//select[@class=\"product_sort_container\"]")
	WebElement ddown;
	
	@FindBy(xpath="//div[@class='right_component']/span/select/option[1]")
	List<WebElement> d1;
	
	public void Details(String name1,String pass1) throws InterruptedException {
		name.clear();
		name.sendKeys(name1);
		pass.clear();
		pass.sendKeys(pass1);
		login.click();
		
		 Actions act=new Actions(driver);
	    act.moveToElement(ddown).click().build().perform();
	    Thread.sleep(2000);
		Select s = new Select(ddown);
		
	    for(WebElement e : d1)
		{
			String value = e.getText();
			System.out.println(value);
			
			if(value.equals("Price (low to high)"))
			{
				s.selectByVisibleText(value);
				break;
			}
		
	}
	

}
}
