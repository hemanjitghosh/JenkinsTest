package POC.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testreport.IReporter;

import dweb.aut.pages.templates.PageTemplate;

public class POC_HomePage extends PageTemplate {
	
	public POC_HomePage(WebDriver webDriver, IReporter testReport) {
		super(webDriver, testReport);
		// TODO Auto-generated constructor stub
	}


	//public By BluestrataLogo= By.xpath("//img[@src='https://cdn.bluestrataemr.com/Images/WellSky-LTC.png']");
	public By BluestrataLogo= By.id("wellSkyLTCLogo");
	public By iconClock = By.xpath("//img[contains(@src,'GreenClock')]");
	//public By spanStartUpWindow = By.xpath("//span[text()='Startup Window']");
	//public By spanMainWindow = By.xpath("//span[text()='Main Window']");
	//public By spanQuickOptions = By.xpath("//span[text()='Quick Options (where applicable)']");
	public By spanStartUpWindow = By.id("startupWindowLabel");
	public By spanMainWindow = By.id("mainWindowLabel");
	public By spanQuickOptions = By.id("quickOptionsLabel");
		
	
	public By iconSetUpStation = By.xpath("//*[@title='Setup Station']//img");
	public By iconSetUpUserFingerprint = By.xpath("//*[@title=\"Setup user's fingerprint\"]//img");
	////button[contains(@title,'fingerprint')]
	public By iconLoginToNTouch = By.xpath("//*[@title='Login to NTouch']//img");
	public By iconConfigureApplication = By.xpath("//*[@title='Configure application']//img");
	public By iconViewStationInformation = By.xpath("//*[@title='View station information']//img");
	public By iconRestartTheApplication = By.xpath("//*[@title='Restart the application']//img");
	public By iconShutdownTheApplication = By.xpath("//*[@title='Shutdown the application']//img");
	
	public By iconTestStation = By.xpath("//*[text()='TestStation']/preceding-sibling::img");
	public By txtIconDefinationPage = By.xpath("//span[contains(text(),'Icon Definitions Page')]");
	public By Calculator = By.xpath("//div[contains(@class,'keypad')]");
	public By txtBox = By.xpath("//div[contains(@class,'keypad')]//div[@class='screen']");
	public By KeyPad = By.xpath("//div[contains(@class,'keys')]//div[@class='d-flex flex-wrap']");
	public By btnClear = By.xpath("//button[contains(@class,'remove')]");
	public By btnCancel = By.xpath("//button[contains(@class,'cancel')]");
	public By btnEnter = By.xpath("//button[contains(@class,'check')]");
	
	
	
	// Test Case 001
	
	public void VerifyPageLogoAndDayDayeAndTime()
	{
		this.VerifyWebElementPresent(BluestrataLogo, "WellSky LTC Logo");
		this.VerifyWebElementPresent(iconClock, "Clock");
		String DayDateTime = wd.findElement(By.xpath("//span[contains(@class,'right text-bold')]")).getText();
		this.testReport.logSuccess("Day Date And Time of the Application", String.format("Day Date And Time of the Application :- <mark>%s<mark/>", DayDateTime));

	}
	
	public By HomePageContent(String Icon)
	{
		return By.xpath(String.format("//*[@title=\"%s\"]//img",Icon));
	}
	
	public String[] GetAllIcons()
	{
		String[] Icons = null ; 
		List<WebElement> AllOptions = wd.findElements(By.xpath("(//img[contains(@src,'img/icons')]/ancestor::button)"));
		ArrayList<String> Options = new ArrayList<String>();
		for(int i=1;i<=AllOptions.size();i++)
		{
			Options.add(wd.findElement(By.xpath(String.format("(//img[contains(@src,'img/icons')]/ancestor::button)[%s]",i))).getAttribute("title"));
		}
		Icons = Options.toArray(new String[Options.size()]);
		return Icons ;
	}
	
	// Test Case 002
	
	public void VerifyIconsDisplayedInLandingPage()
	{
		String[] Icons = GetAllIcons();
		for(int i=1;i<=Icons.length;i++)
		{
			String Icon = Icons[i-1];
			this.VerifyWebElementPresent(HomePageContent(Icon), Icon);
		}
	}
	
	
	public void VerifySectionsUnderIconDefinationPage()
	{
		this.VerifyWebElementPresent(spanStartUpWindow, "StartUp Window");
		this.VerifyWebElementPresent(spanMainWindow, "Main Window");
		this.VerifyWebElementPresent(spanQuickOptions, "Quick Options (where applicable)");
	}
	
	public void UserAbleToClickOnIconDisplayedInLeftPane()
	{
		try
		{
			this.click(iconSetUpUserFingerprint, "Setup user's fingerprint");
			this.waitInSecs(2);
			this.VerifyWebElementNotPresent(spanStartUpWindow, "StartUp Window");
			this.click(iconSetUpStation, "Setup Station");
			this.VerifyWebElementPresent(spanStartUpWindow, "StartUp Window");
			this.click(iconLoginToNTouch, "Login to NTouch");
			this.waitInSecs(2);
			this.VerifyWebElementNotPresent(spanStartUpWindow, "StartUp Window");
			this.click(iconRestartTheApplication, "Restart the application");
			this.VerifyWebElementPresent(spanStartUpWindow, "StartUp Window");
			this.click(iconConfigureApplication, "Configure application");
			this.waitInSecs(2);
			this.VerifyWebElementNotPresent(spanStartUpWindow, "StartUp Window");
			this.click(iconShutdownTheApplication, "Shutdown the application");
			this.VerifyWebElementPresent(spanStartUpWindow, "StartUp Window");
			this.click(iconViewStationInformation, "View station information");
			this.waitInSecs(2);
			this.VerifyWebElementNotPresent(spanStartUpWindow, "StartUp Window");
			this.click(iconRestartTheApplication, "Restart the application");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public void ShutDownTheApplication()
	{
		this.VerifyWebElementPresent(iconShutdownTheApplication, "Shutdown the application");
		this.click(iconShutdownTheApplication, "Shutdown the application");
	}
	
	public void ClickOnIcon(String Icon)
	{
		this.waitUntilElementIsVisible(iconSetUpUserFingerprint);
		this.waitUntilElementIsClickable(iconSetUpUserFingerprint);
		this.click(iconSetUpUserFingerprint, "Stup user fingerprint");
		if(this.isElementPresent(By.xpath("//img[@alt='Creve Coeur Meadows']")))
		{
			this.click(By.xpath("//img[@alt='Creve Coeur Meadows']"), "Facility Click");
		}
		/*this.VerifyWebElementPresent(HomePageContent(Icon), Icon);
		if(this.isElementPresent(txtIconDefinationPage))
		{
			this.VerifyWebElementPresent(txtIconDefinationPage, "Icon Definitions Page");
		}
		this.click(HomePageContent(Icon), Icon);
		if(this.isElementPresent(iconTestStation))
		{
			this.VerifyWebElementPresent(iconTestStation, "Test Station");
			this.click(iconTestStation, "Test Station");

		}*/
	}
	
	public void SelectUser(String testStation )
	{
		
		By TestStation = By.xpath(String.format("//button//*[text()='%s']", testStation));
		this.click(TestStation, testStation);
		this.waitInSecs(3);
		
		/*for(int i=1;i<=10;i++)
		{
			this.click(By.xpath(String.format("//button[contains(@class,'btn-number') and text()='%s']", i)), Integer.toString(i));
			if(this.isElementPresent(By.xpath(String.format("///button//p[text()='%s']", UserName))));
			{
				By userName = By.xpath(String.format("//button//p[text()='%s']", UserName));
				this.click(userName, UserName);	
				break;
			}
		}*/
		/*int i=1;
		while(this.isElementPresent(By.xpath(String.format("//button[contains(@class,'btn-number') and text()='%s']", i))));
		{
			this.click(By.xpath(String.format("//button[contains(@class,'btn-number') and text()='%s']", i)), Integer.toString(i));
			if(this.isElementPresent(By.xpath(String.format("///button//p[text()='%s']", UserName))));
			{
				this.click(By.xpath(String.format("///button//p[text()='%s']", UserName)), UserName);				
			}
			if(this.isElementPresent(Calculator))
			{
				break;
			}
			
		}*/
	}
	
	
	public void SelectUserAndVerifyCalculator(String UserName)
	{
		By User = By.xpath(String.format("//*[text()='%s']/preceding-sibling::img", UserName));
		if(this.isElementPresent(User))
		{
			this.click(User, UserName);
		}
		/*if(!UserName.equals(""))
		{
			for(int i=1;i<=10;i++)
			{
				this.click(By.xpath(String.format("//button[contains(@class,'btn-number') and text()='%s']", i)), Integer.toString(i));
				this.waitInSecs(2);
				List<WebElement> UserNames = wd.findElements(By.xpath("//button//p"));				
				By userName = By.xpath(String.format("//button//p[text()='%s']", UserName));
				//boolean Username = wd.findElement(By.xpath(String.format("//button//p[text()='%s']", UserName))).isDisplayed();
				if(this.isElementVisible(userName));
				{					
					this.click(userName, UserName);	
					break;
				}
			}
		}*/

		if(this.isElementPresent(Calculator))
		{
			this.VerifyWebElementPresent(Calculator, "Calculator");
			this.VerifyWebElementPresent(txtBox, "Text Box");
			//this.VerifyWebElementPresent(KeyPad, "KeyPad");
			this.VerifyWebElementPresent(btnClear, "Clear Button");
			this.VerifyWebElementPresent(btnCancel, "Cancel Button");
			this.VerifyWebElementPresent(btnEnter, "Enter Button");
		}
	}
	
	public void VerifyCalculator()
	{
		if(this.isElementPresent(Calculator))
		{
			this.VerifyWebElementPresent(Calculator, "Calculator");
			this.VerifyWebElementPresent(txtBox, "Text Box");
			//this.VerifyWebElementPresent(KeyPad, "KeyPad");
			this.VerifyWebElementPresent(btnClear, "Clear Button");
			this.VerifyWebElementPresent(btnCancel, "Cancel Button");
			this.VerifyWebElementPresent(btnEnter, "Enter Button");
		}
	}
	
	public By EnterNumber(String Number)
	{
		return By.xpath(String.format("//button[text()='%s' and @is-disabled='false']",Number));
	}
	
	public void EnterPasscode(String PassCode)
	{
		int len = PassCode.length();
		char aa[]=new char[len];
		int i=0;
		for(i=0;i<len;i++)
		{
			aa[i]=PassCode.charAt(i);
			char a = aa[i];
			this.waitInSecs(1);
			String Number = Character.toString(a);
			this.click(EnterNumber(Number), Number);
			this.waitInSecs(1);
		}
		
		this.click(btnEnter, "Enter Button");
		this.waitInSecs(3);

	}	
	
	public void ClickCancelTheCalculator()
	{
		this.click(btnCancel, "Cancel Button");
	}
	
	public void VerifyOptionsUnderConfigureApplication()
	{
		List<WebElement> Options = wd.findElements(By.xpath("//div[contains(@class,'start-screen')]//button[contains(@class,'block')]"));
		
		ArrayList<String> Option = new ArrayList<String>();
		for(int i=1;i<=Options.size();i++)
		{
			Option.add(wd.findElement(By.xpath(String.format("(//div[contains(@class,'start-screen')]//button[contains(@class,'block')]/img)[%s]",i))).getAttribute("alt"));
		}
		this.testReport.logSuccess("Configure application Options", String.format("Configure application options :- <mark>%s<mark/>", Option.toString()));
	}
	
	public void ViewStationInformation()
	{
		String Header = wd.findElement(By.xpath("//*[@class='start-screen']//p[contains(@class,'h3')]")).getText();
		this.testReport.logSuccess("View Station Information Header", String.format("View Station Information Header Name :- <mark>%s<mark/>", Header));
		
		List<WebElement> Options = wd.findElements(By.xpath("//*[@class='start-screen']//p[contains(@class,'text-bold')]"));
		
		ArrayList<String> Option = new ArrayList<String>();
		for(int i=1;i<=Options.size();i++)
		{
			Option.add(wd.findElement(By.xpath(String.format("(//*[@class='start-screen']//p[contains(@class,'text-bold')])[%s]",i))).getText());
		}
		this.testReport.logSuccess("View Station Information Options with value", String.format("View Station Information Options with value :- <mark>%s<mark/>", Option.toString()));
	}
	
	
}
