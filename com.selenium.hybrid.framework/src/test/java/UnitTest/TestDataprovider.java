package UnitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataProvider.ConfigDataProvider;
import DataProvider.ExcelDataProvider;

public class TestDataprovider 
{

	@Test
	public void testExcelReader()
	{
		
		ExcelDataProvider datareader=new ExcelDataProvider("./TestData/LoginData.xlsx");
		
		Assert.assertEquals(datareader.getStringData(0, 0, 0), "admin");
		
	}
	
	
	@Test
	public void testConfigReader()
	{
		
		ConfigDataProvider configReader=new ConfigDataProvider("./Configuration/framework.properties");
		
		Assert.assertTrue(configReader.getChromeDriverPath().contains("chromedriver.exe"));
		
	}
	
	
}
