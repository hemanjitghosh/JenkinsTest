package bluestrata.pages;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testreport.IReporter;
import dweb.aut.pages.templates.PageTemplate;

public class HomePage extends PageTemplate {

	public HomePage(WebDriver webDriver, IReporter testReport) {
		super(webDriver, testReport);
		// TODO Auto-generated constructor stub
	}
	
	public By btnMenu = By.xpath("//div[contains(@class,'col-md-auto')]//button");
	public By optionPhysicianPortal = By.xpath("//div[@class='modal-content']//img[@src='https://cdn.bluestrataemr.com/Images/Menu/sigma_medical_doctor_128.png']");
	public By optionFacilityPortal = By.xpath("//div[@class='modal-content']//img[@src='https://cdn.bluestrataemr.com/Images/Menu/sigma_educationicons_school_128.png']");
	public By optionClinicalPortal = By.xpath("//div[@class='modal-content']//img[@src='https://cdn.bluestrataemr.com/Images/Menu/sigma_medical_nurse_128.png']");
	public By optionEmarPortal = By.xpath("//div[@class='modal-content']//img[@src='https://cdn.bluestrataemr.com/Images/Menu/sigma_medical_tablet_128.png']");
	protected By optionAccountPayable=By.xpath("//button/img[@src='https://cdn.bluestrataemr.com/Images/Menu/sigma_accounting_check_128.png']");
	protected By btnHeaderMonitoring = By.xpath("//button[text()='Monitoring']");
	protected By btnIncidentsAccidents=By.xpath("//button[text()='Incidents and Accidents']");
	//public By optionEmarPortal = By.xpath("//div[@class='modal-content']//a[@href='emar/dashboard']");
	
	/*public By btnTester = By.xpath("//button[@id='userDropDown']");
	public By btnlogout = By.xpath("//button[@id='userDropDown']//following-sibling::div//button[text()='Logout']");
	public By btnChangePassword = By.xpath("//button[@id='userDropDown']//following-sibling::div//button[text()='Change Password']");
	public By btnAddSignature = By.xpath("//button[text()='Add Signature']");
	public By btnSetCurrentAppAsDefault = By.xpath("//button[text()='Set Current App as Default']");
	public By btnSetMediprocityCredentials = By.xpath("//button[text()='Set Mediprocity Credentials']");
	public By btnLock = By.xpath("//button[@id='userDropDown']//following-sibling::div//button[text()='Lock']");*/
	
	public By btnFacilyIcon = By.xpath("//button/i[contains(@class,'refresh')]");
	public By btnResidentIcon = By.xpath("//a/i[contains(@class,'refresh')]");
	
	public By btnMenuEmar = By.xpath("//app-selector//button");
	public void NavigateToPhysicianPortal()
	{
		this.WaitForElementPresent(btnMenu, 20, "Menu Button");
		this.click(btnMenu ,"Menu Button");
		this.click(optionPhysicianPortal ,"Physician Portal Option");
	}
	
	public void NavigateToClinicalPortal()
	{
		this.WaitForElementPresent(btnMenu, 20, "Menu Button");
		this.click(btnMenu ,"Menu Button");
		this.click(optionClinicalPortal ,"Clinical Option");
	}
	
	public void NavigateToFacilityPortal()
	{
		/*String Element = wd.findElement(By.xpath("//div[contains(@class,'col-md-auto')]//button")).getCssValue("background-color");
		System.out.println(Element);*/
		this.WaitForElementPresent(btnMenu, 20, "Menu Button");
		this.click(btnMenu ,"Menu Button");
		
		this.click(optionFacilityPortal ,"Facility Portal Option");
	}
	
	public void DismissAlert()
	{
		wd.switchTo().alert().dismiss();
	}
	
	public void NavigateToEmar()
	{
		this.waitUntilElementIsClickable(btnMenu);//(btnMenu, 20, "Menu Button");
		this.click(btnMenu ,"Menu Button");
		
		this.waitUntilElementIsClickable(optionEmarPortal);
		this.click(optionEmarPortal ,"Emar Portal Option");
	}
	
	public String GetHoMePageUrl()
	{
		String ParentWindow = wd.getWindowHandle();
		return ParentWindow;
	}
	
	public String NavigateToEmarWindow(String URL) throws Throwable 
	{
		
		String parentWindow = this.wd.getWindowHandle();
		try
		{			
			NavigateToEmar();
			java.util.Set<String> AllWindows = this.wd.getWindowHandles();
			for(String ChildWindow : AllWindows)
			{
				if(!parentWindow.equalsIgnoreCase(ChildWindow))
				{


					this.wd.switchTo().window(ChildWindow);
					wd.manage().window().maximize();
					String Name = wd.getCurrentUrl();
					if(Name.equals(URL))
					{
						this.testReport.logSuccess("user have the URL to access the Key page ", String.format("user have the <mark>%s<mark/> to access the Key page", Name) );
					}
					else
					{
						this.testReport.logSuccess("user dosn't have the URL to access the Key page ", String.format("user dosn't have the <mark>%s<mark/> to access the Key page", Name) );
					}

					
				}
			}


		}
		catch(Exception e)
		{

		}
		return parentWindow;



	}
	
	public void VerifyAllapps()
	{
		if(this.isElementPresent(btnMenuEmar))
		{
			this.click(btnMenuEmar ,"Menu Button");
		}
		else
		{
			this.click(btnMenu ,"Menu Button");
		}
		List<WebElement> apps = wd.findElements(By.xpath("//div[@class='modal-content']//img/..//small"));
		int No = apps.size();
		ArrayList<String> Apps = new ArrayList<String>();
		for(int i=1 ; i<=No ;i++)
		{
			Apps.add(wd.findElement(By.xpath(String.format("(//div[@class='modal-content']//img/..//small)[%s]",i))).getText());
		}
		this.testReport.logSuccess("Present Apps ", String.format("Present Apps On application Menu <mark>%s<mark/> ", Apps.toString()) );

		if(this.isElementPresent(btnMenuEmar))
		{
			this.click(btnMenuEmar ,"Menu Button");
		}
		/*if(this.isElementPresent(btnMenuEmar))
		{
			
			this.click(btnMenu ,"Menu Button");
		}*/
		
	}
	
	public void VerifyFacilityIconAndName()
	{
		
		this.VerifyWebElementPresent(btnFacilyIcon, "Facility Icon");
		String FacilityName = wd.findElement(By.xpath("//button/i[contains(@class,'refresh')]/../following-sibling::a")).getText();
		this.testReport.logSuccess("Facillity Name ", String.format("Facillity Name :- <mark>%s<mark/> ", FacilityName) );
		
	}
	
	public void VerifyResidentIconAndName()
	{
		this.VerifyWebElementPresent(btnResidentIcon, "Resident Icon");
		String ResidentName = wd.findElement(By.xpath("//a/i[contains(@class,'refresh')]/../following-sibling::a")).getText();
		this.testReport.logSuccess("Resident Name ", String.format("Resident Name :- <mark>%s<mark/> ", ResidentName) );
		
	}
	
	public void MyDashBoardHomePage()
	{
		this.WaitForElementPresent(btnMenu,60 ,"Menu Button");
		String URL = wd.getCurrentUrl();
		this.testReport.logSuccess("URL of Dashboard Home Page", String.format("URL of Dashboard Home Page :- <mark>%s<mark/> ", URL) );
	}
	
	/*
	 * This method is used to click and Navigate to accounts payable section
	 * */
	public void NavigateToAccountsPayable()
	{
		this.WaitForElementPresent(btnMenu, 20, "Menu Button");
		this.click(btnMenu ,"Menu Button");
		this.click(optionAccountPayable ,"Accounts Payable");
		
	}
	
	public void NavigateToIncidentsAccidents()
	{
		this.WaitForElementPresent(btnMenu, 20, "Menu Button");
		this.WaitForElementPresent(btnHeaderMonitoring, 10, "Button menu Monitoring");
		this.click(btnHeaderMonitoring, "Button menu Monitoring");
		this.click(btnIncidentsAccidents, "Button Incidents and accidents");
		
	}

	
}
