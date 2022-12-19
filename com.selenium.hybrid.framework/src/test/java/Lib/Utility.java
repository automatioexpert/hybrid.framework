package Lib;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility 
{
    	
	public static void verifyLinkActive(String linkUrl)
	{
        try 
        {
           URL url = new URL(linkUrl);
           
           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
           
           httpURLConnect.setConnectTimeout(3000);
           
           httpURLConnect.connect();
           
           if(httpURLConnect.getResponseCode()==200)
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {
           
        }
    } 
	
	
	public static String captureScreenshot(WebDriver ldriver,String screenshot_name)
	{
		
		
       TakesScreenshot screenshot=(TakesScreenshot)ldriver;
		
		// it will store screenshot in memory
	    File src=screenshot.getScreenshotAs(OutputType.FILE);
		
		String path="C:\\LatestSeleniumDrivers\\"+screenshot_name+".png";
	    
	    try 
	    {
			FileUtils.copyFile(src, new File(path));
		} 
	    catch (IOException e) 
	    {
		
	    	System.out.println("Unable to capture screeshot "+e.getMessage());
		}
	    
	    return path;
		
	}
	
	
	public void highlightElements()
	{
		
	}
	
	
}
