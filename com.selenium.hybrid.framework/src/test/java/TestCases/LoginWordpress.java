package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Lib.Utility;
import Pages.LoginPage;

public class LoginWordpress 
{
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	
	
	@BeforeClass
	public void setUp()
	{
		report=new ExtentReports("C:\\Users\\Mukesh_50\\git\\HybridFramework\\Reports\\Test2.html",true);
	}
	
	
	
	
	
	@Test
	public void verifyLoginWordpress()
	{

	 logger=report.startTest("verifyLoginWordpress", "This will login and check the title");
		
	 
	 
	  // Start firefox Session	
	  driver=BrowserFactory.getBrowser(driver,"ie");
	  logger.log(LogStatus.INFO, "Browser started IE");	
		
	  driver.get("http://demosite.center/wordpress/wp-login.php");
	  logger.log(LogStatus.INFO, "Application loaded");
	
	  // Initialize page object elements  
	  // LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	 
	   LoginPage login=new LoginPage(driver);
	   
	   login.login_Wordpress(DataProviderFactory.getExcel().getStringData(0, 0, 0),DataProviderFactory.getExcel().getStringData(0, 0, 1));
	   logger.log(LogStatus.PASS, "Able to login Successfully");

	   String image=logger.addScreenCapture(Utility.captureScreenshot(driver, "wordpress"));
	   logger.log(LogStatus.INFO, image);
	   
	   
	   BrowserFactory.closeBrowser(driver);
	   logger.log(LogStatus.INFO, "Browser Session closed");
	   
	   report.endTest(logger);
	   
	}
	
	@Test
	public void test2()
	{
		logger=report.startTest("Test 2 ");
		logger.log(LogStatus.WARNING, "FIles are missing");
		report.endTest(logger);
	}
	
	@Test
	public void test3()
	{
		logger=report.startTest("Test 3 ");
		logger.log(LogStatus.SKIP, "FIles are missing");
		report.endTest(logger);
	}
	
	
	
	@AfterClass
	public void tearDown()
	{
		
	  report.flush();
	}
	
}
