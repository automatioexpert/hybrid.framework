package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Lib.Utility;
import Pages.LoginPage;
import Pages.PostCreation;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PublishPost 
{

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	
	
	@BeforeClass
	public void setUp()
	{
		report=new ExtentReports("C:\\Users\\Mukesh_50\\git\\HybridFramework\\Reports\\Test4.html",true);
	}
	
	
	
	
	
	@Test
	public void VerifyPostPublish()
	{

	 logger=report.startTest("VerifyPostPublish", "This will verify post publish");
		
	 
	 
	  // Start firefox Session	
	  driver=BrowserFactory.getBrowser(driver,"ie");
	  logger.log(LogStatus.INFO, "Browser started IE");	
		
	  driver.get("http://demosite.center/wordpress/wp-login.php");
	  logger.log(LogStatus.INFO, "Application loaded");
	
	  // Initialize page object elements  
	   LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	  
	   
	   login.login_Wordpress(DataProviderFactory.getExcel().getStringData(0, 0, 0),DataProviderFactory.getExcel().getStringData(0, 0, 1));
	   logger.log(LogStatus.PASS, "Able to login Successfully");


	    PostCreation post=PageFactory.initElements(driver, PostCreation.class);
	   
	    post.click_post();
	    
	    post.click_new();
	    
	    post.Filltitle();
	   
	    post.clickPublish();
	    
	    post.verifyPostPublish();
	    
	    String image=logger.addScreenCapture(Utility.captureScreenshot(driver, "wordpress"));
		
	    logger.log(LogStatus.INFO, image);
	   
	    report.endTest(logger);
	   
	}
	
	

	@AfterMethod
	public void tearDown(ITestResult result)
	{
		
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String image=logger.addScreenCapture(Utility.captureScreenshot(driver, "Test Failed"));
			
		    logger.log(LogStatus.FAIL, image);
		    
		    report.endTest(logger);
		}
		
	BrowserFactory.closeBrowser(driver);
	
	logger.log(LogStatus.INFO, "Browser Session closed");
	
	report.flush();
	}
	
}
