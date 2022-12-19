package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PostCreation 
{

	@FindBy(xpath="//a[text()='Posts']") WebElement post;
	
	@FindBy(xpath="//h2//a[text()='Add New']") WebElement add_new;
	
	@FindBy(xpath=".//*[@id='title']") WebElement enter_title;
	
	@FindBy(xpath=".//*[@id='publish']") WebElement publish;
	
	WebDriver driver;

	
	public PostCreation(WebDriver ldriver)

	{
		
		this.driver=ldriver;
	}
	
	
	public void click_post()
	{
	
		post.click();
	}
	
	public void click_new()
	{
		add_new.click();
	}
	
	public void Filltitle()
	{
		enter_title.sendKeys("Selenium Webdriver");
	}
	
	public void clickPublish()
	{
		publish.click();
	}
	
	public void verifyPostPublish()
	{
		
		Assert.assertTrue(driver.getPageSource().contains("Postasdasd published."));
	}
	
}
