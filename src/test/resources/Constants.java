package test.resources;

import java.io.FileInputStream;

import java.util.Properties;

public class Constants {

	
	public static String resultsFolder ="";
	
	static {
		
		FileInputStream fs;
		try {
			fs = new FileInputStream("src/test/resources/taf.properties");
			Properties prop = new Properties(System.getProperties());
			prop.load(fs);
			Constants.resultsFolder = prop.getProperty("resultsFolder");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
}
