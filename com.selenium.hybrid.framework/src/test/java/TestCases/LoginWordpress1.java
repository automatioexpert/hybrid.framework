package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Pages.DashBoard;
import Pages.LoginPage;

public class LoginWordpress1 
{
	
	WebDriver driver;
	
	
	@Test
	public void verifyHomePage()
	{

	  // Start firefox Session	
	  driver=BrowserFactory.getBrowser(driver,"chrome");
		
		
	  driver.get("http://demosite.center/wordpress/wp-login.php");
	  
	
	  // Initialize page object elements  
	   LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	  
	   
	   login.login_Wordpress(DataProviderFactory.getExcel().getStringData(0, 0, 0),DataProviderFactory.getExcel().getStringData(0, 0, 1));
	   
	   
	   DashBoard home=PageFactory.initElements(driver, DashBoard.class);
	   
	   home.verifyHomeTitle();
	 
	   
	}
	
}
