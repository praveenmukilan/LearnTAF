package test.resources;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.menonvarun.test.automation.framework.config.DefaultConfig;
import com.menonvarun.test.automation.framework.keywordmodel.executor.KeywordExecutor;


public class GoogleKeywordTest {
	WebDriver driver;
	@BeforeClass
	public void setListner(){
		DefaultConfig config = DefaultConfig.getDefaultConfig();
		config.setConfigValue("listeners", "test.resources.GoogleKeyword");
	}
	
	@BeforeMethod
	public void before(){
		driver = new FirefoxDriver();
	}
	
	@Test
	public void googleSearchKeywordTest(){
		
		File file = new File("src/test/resources/GoogleKeywordTest.xls");
		KeywordExecutor keyExecutor = new KeywordExecutor(driver, file,(String[]) null);
		keyExecutor.execute();
		
	}
	
	@AfterMethod
	public void after(){
		driver.quit();
	}

}
