package demo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LINKCHECK {

	
	private static int invalidLinksCount;
	
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FirefoxDriver driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-form/");
		List<WebElement> links=driver.findElements(By.tagName("img"));
		System.out.println(links.size());
		
		for(int i=0;i<links.size();i++)
		{
			//System.out.println("Link count "+i+" "+links.get(i).getText());	
			verifyLinkActive(links.get(i).getAttribute("src"));
			
		}
		
	
        System.out.println("Total invalid links are "+invalidLinksCount);
        
        
        
        
	}
	
	public static void verifyLinkActive(String linkUrl)
	{
        try {
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

}
