package bluestrata.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testreport.IReporter;

public class ClinicalPage extends PhysicianPortalPage {

	public ClinicalPage(WebDriver webDriver, IReporter testReport) {
		super(webDriver, testReport);
		// TODO Auto-generated constructor stub
	}

	
	
	public By btnHeaderResident = By.xpath("//button[text()='Resident']");
	public By btnHeaderCensus = By.xpath("//button[text()='Census']");
	public By btnHeaderMDS = By.xpath("//button[text()='MDS']");
	public By btnHeaderCarePlans  = By.xpath("//button[text()='Care Plans ']");
	public By btnHeaderOrders = By.xpath("//button[text()='Orders']");
	public By btnHeaderChart = By.xpath("//button[text()='Chart']");
	public By btnHeaderMonitoring = By.xpath("//button[text()='Monitoring']");
	public By btnHeaderPOC = By.xpath("//button[text()='POC']");
	public By btnHeaderReports = By.xpath("//*[@class='col-auto nav primary-menu-links']//button[contains(text(),'Reports')]");
	
	public By spandrpdwnInfectionControl = By.xpath("//div[@aria-labelledby='menuDropDown']//button[text()='Infection Control']");
	
	public void ClinicalPortalHeaderVerfication()
	{
		this.VerifyWebElementPresent(btnHeaderResident,"Resident");
		this.VerifyWebElementPresent(btnHeaderCensus,"Census");
		this.VerifyWebElementPresent(btnHeaderMDS,"MDS");
		this.VerifyWebElementPresent(btnHeaderCarePlans,"Care Plans");
		this.VerifyWebElementPresent(btnHeaderOrders,"Orders");
		this.VerifyWebElementPresent(btnHeaderChart,"Chart");
		this.VerifyWebElementPresent(btnHeaderMonitoring,"Monitoring");
		this.VerifyWebElementPresent(btnHeaderPOC,"POC");
		this.VerifyWebElementPresent(btnHeaderReports,"Reports");		
		this.VerifyWebElementPresent(btnHeaderMessages,"Messages");
		this.VerifyWebElementPresent(btnHeaderMediprocity,"Mediprocity");
	}
	
	
	public void VerifyPhysicianPortalDrropdown()
	{
		
		this.click(btnHeaderOrders,"Orders");
		this.waitInSecs(2);
		this.VerifyWebElementPresent(spandrpdwnSign,"Sign");
		this.VerifyWebElementPresent(spandrpdwnResidentOrder,"Resident Order");
		this.VerifyWebElementPresent(spandrpdwnRecap,"Recap");
		this.VerifyWebElementPresent(spandrpdwnVerify,"Verify");
		this.VerifyWebElementPresent(spandrpdwnInfectionControl,"Infection Control");
		this.click(aResidentOrders,"Resident Orders"); 
		this.waitInSecs(2);
	}
	
	
	public void ClickOnResidentOrdersFromOrders()
	{
		
		this.testReport.logSuccess("Clicked on Resident Orders  Button From Orders");
		this.click(btnHeaderOrders,"Orders");
		this.waitInSecs(2);
		this.testReport.logSuccess("Clicked on Resident Orders Links ");
		this.click(aResidentOrders,"Resident Orders"); 
		this.waitInSecs(2);
	}
}
