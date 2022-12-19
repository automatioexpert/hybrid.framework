package httpClient;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import Lib.Utility;

public class VerifyImages {

	public static void main(String[] args) 
	{
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.redbus.in/");
		
		List<WebElement> images=driver.findElements(By.tagName("img"));

		for(int i=0;i<images.size();i++)
		{
			
			WebElement ele= images.get(i);
			
			String url=ele.getAttribute("src");
			
			Utility.verifyLinkActive(url);
			
		}
		
	}
	
	
	 

}
