package bluestrata.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.config.IConstants;
import com.testreport.IReporter;
import com.utilities.ReusableLibs;

import dweb.aut.pages.templates.PageTemplate;

public class LoginPage extends PageTemplate {

	public LoginPage(WebDriver webDriver, IReporter testReport) {
		super(webDriver, testReport);
		
	}
	
	public By btnTester = By.xpath("//button[@id='userDropDown']");
	public By logout = By.xpath("//button[@id='userDropDown']/..//div/button[text()='Logout']");
	//public By userNameTxtBox=By.className("form-control ng-dirty ng-valid ng-touched");
	public By userNameTxtBox=By.xpath("//input[@formcontrolname='username']");
	//input[@formcontrolname='username']
	public void login(String userName, String password)
	{
		String strValFromConfigFile = null;
		this.wd = this.wd.switchTo().defaultContent();		
		/*this.sendKeys((By.xpath(String.format(this.getLocator("placeHolderTextBox"), "Key"))), key);
		this.click(By.xpath(String.format(this.getLocator("button"), "Submit Key")),"Submit Key Button");	*/	
		
		strValFromConfigFile = String.format(ReusableLibs.getKeyValue(IConstants.AUT_CONFIG_FILE, "placeHolderTextBox"), "Username");
		this.waitInSecs(3);
		
		if(this.isElementPresent(By.id(strValFromConfigFile)))
		{
			
		this.VerifyWebElementPresent(By.id(strValFromConfigFile), "User Name");
		this.wd.findElement(By.id(strValFromConfigFile)).click();
		this.wd.findElement(By.id(strValFromConfigFile)).sendKeys(userName);
		}
		
		strValFromConfigFile = String.format(ReusableLibs.getKeyValue(IConstants.AUT_CONFIG_FILE, "passwordTextBox"), "Password");
		if(this.isElementPresent(By.id(strValFromConfigFile)))
		{
		this.VerifyWebElementPresent(By.id(strValFromConfigFile), "Password");
		this.wd.findElement(By.id(strValFromConfigFile)).click();
		this.wd.findElement(By.id(strValFromConfigFile)).sendKeys(password);
		}
		
		strValFromConfigFile = String.format(ReusableLibs.getKeyValue(IConstants.AUT_CONFIG_FILE, "button"), "Log in");
		if(this.isElementPresent(By.xpath(strValFromConfigFile)))
		{
		this.VerifyWebElementPresent(By.xpath(strValFromConfigFile),"Sign In Button");
		this.click(By.xpath(strValFromConfigFile),"Sign In Button");
		}
		
		this.waitInSecs(5);
	}
	
	public void Logout()
	{
		this.WaitForElementPresent(btnTester, 60, "Tester Button");
		this.click(btnTester, "Tester Button");
		this.click(logout, "Logout");
	}
	
	

}
