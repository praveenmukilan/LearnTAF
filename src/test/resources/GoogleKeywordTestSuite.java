package test.resources;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.menonvarun.test.automation.framework.config.DefaultConfig;
import com.menonvarun.test.automation.framework.keywordmodel.executor.KeywordExecutor;
import com.menonvarun.test.automation.framework.keywordmodel.suite.ISimpleTest;
import com.menonvarun.test.automation.framework.keywordmodel.suite.TestSuite;




public class GoogleKeywordTestSuite {
	private static WebDriver driver;
	
	@BeforeClass
	public void setListner(){
		DefaultConfig config = DefaultConfig.getDefaultConfig();
		config.setConfigValue("listeners", "test.resources.GoogleKeyword");
	}
	
	@BeforeMethod
	public void init(){
		System.setProperty("webdriver.ie.driver",".\\IEDriverServerWin32.exe");
		driver = new InternetExplorerDriver();
	}
	
	@AfterMethod
	public void cleanup(){
		driver.quit();
	}
	
	
	@Test(dataProvider="Data")
	public void googleSearchTestSuite(ISimpleTest simpleTest){
	//	String a[] = {};
		File file = new File("src//test//resources//GoogleKeywordTest.xls");
//		System.out.println("simpleTest *********** "+ simpleTest.getTestName());
		driver.get("www.google.com");
		System.out.println("driver *********** "+ driver.getTitle() );
		NewKeywordExecutor keyExecutor = new NewKeywordExecutor(driver,file);
		keyExecutor.execute();		
	}
	
	@DataProvider(name="Data")
	public Object[][] getTestData(){
		File file = new File("src//test//resources//GoogleTestSuite.xls");
		TestSuite suiteReader = new TestSuite(file, new ArrayList<String>());
		return suiteReader.getTobeExecutedTests();
	}

}
