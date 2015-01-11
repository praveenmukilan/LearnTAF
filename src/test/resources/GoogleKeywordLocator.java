package test.resources;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleKeywordLocator{
	
	@FindBy(how=How.NAME,using="search_box")
	public WebElement searchField;
	
	@FindBy(how = How.NAME,using="submit_button")
	public WebElement submitButton;
	
	@FindBy(how = How.XPATH,using="search_result")
	public List<WebElement> searchResult;
	
	@FindBy(how = How.CSS,using="search_result_text")
	public WebElement searchResultText;

}
