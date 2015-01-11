package test.resources.framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.menonvarun.test.automation.framework.config.DefaultConfig;
import com.menonvarun.test.automation.framework.driver.CacheDriverFactory;


public class DriverCreationTest {
	
	@Test
	public void customDriverTest(){
		DefaultConfig config = DefaultConfig.getDefaultConfig();
		config.setConfigValue("userdefined.driverclass", "test.resources.framework.UserDefinedDriverProvider");
		
		CacheDriverFactory driverFactory = new CacheDriverFactory();
		WebDriver driver = driverFactory.getDriver();
		driver.get("http://www.google.com");
	}
	
	@Test
	public void inbuildDriveCreationTest(){
		DefaultConfig config = DefaultConfig.getDefaultConfig();
		config.setConfigValue("driver.name", "firefox");
		
		CacheDriverFactory driverFactory = new CacheDriverFactory();
		WebDriver driver = driverFactory.getDriver();
		driver.get("http://www.google.com");		
	}

}
