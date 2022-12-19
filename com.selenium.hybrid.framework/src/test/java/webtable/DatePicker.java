package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub

		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		
		driver.findElement(By.xpath(".//*[@id='txtReturnCalendar']")).click();
	
		Thread.sleep(2000);
		
	    List<WebElement> dates=driver.findElements(By.xpath(".//*[@id='rbcal_txtReturnCalendar']/table[2]//td"));
		
		for(int i=0;i<dates.size();i++)
		{
			
			 WebElement futuredate=dates.get(i);
			
			 String date=futuredate.getText();
			 
			 if(date.equalsIgnoreCase("30"))
			 {
				 futuredate.click();
				 break;
			 }
		}
		
		
	}

}
