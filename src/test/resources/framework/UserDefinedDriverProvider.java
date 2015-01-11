package test.resources.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.menonvarun.test.automation.framework.config.DefaultConfig;
import com.menonvarun.test.automation.framework.driver.IDriverProvider;


class UserDefinedDriverProvider implements IDriverProvider{
	
	DefaultConfig config = DefaultConfig.getDefaultConfig();

	@Override
	public WebDriver getDriver() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}

}
