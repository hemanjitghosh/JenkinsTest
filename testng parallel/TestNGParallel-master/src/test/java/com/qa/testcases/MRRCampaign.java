package com.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.base.BaseTest;
import com.qa.listeners.CustomListeners;

public class MRRCampaign extends BaseTest{
	
	private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
	
	
	
	@Test
	public void QA01_ValidLogin() throws InterruptedException
	{
		CustomListeners.testReport.get().log(Status.INFO, "QA Login Test");
		 getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 200);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
	}
	
	@Test
	public void QA02_InValidLoginName() throws InterruptedException
	{
		 getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 200);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("Keith");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 
		Assert.assertTrue(getDriver().findElement(By.xpath("//span[contains(text(),'Invalid username or password.')]")).getText().equals("Invalid username or password."));
	}
	
	@Test
	public void QA03_InValidPassword() throws InterruptedException
	{
		 getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 200);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("invalid");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		Assert.assertTrue(getDriver().findElement(By.xpath("//span[contains(text(),'Invalid username or password.')]")).getText().equals("Invalid username or password."));

		 
	}
	
	@Test
	public void QA04_NoUsernamePAssword() throws InterruptedException
	{
		 getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 200);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 //getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		// getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("invalid");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		Assert.assertTrue(getDriver().findElement(By.xpath("//span[contains(text(),'Invalid username or password.')]")).getText().equals("Invalid username or password."));

		 
	}
	
	@Test
	public void QA05_VerifyCreateCampaign() throws InterruptedException
	{
		 getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 200);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='campaignsTab']")));
		getDriver().findElement(By.xpath("//*[@id='campaignsTab']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='btnCmpgnListCreateCampaign']")));
		Assert.assertEquals("Create Campaign", getDriver().findElement(By.xpath("//*[@id='btnCmpgnListCreateCampaign']")).getText().trim());
		 
	
	}
	
	
	
	
	@Test
	public void QA06_SelectCampaignName()
	{
		 getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 200);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='campaignsTab']")));
		getDriver().findElement(By.xpath("//*[@id='campaignsTab']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='btnCmpgnListCreateCampaign']")));
		getDriver().findElement(By.xpath("//*[@id='cmpnNameLabelToken']"));
	}
	
	@Test
	public void QA07_SelectCampaignManager()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		//getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='campaignsTab']")));
		getDriver().findElement(By.xpath("//*[@id='campaignsTab']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='btnCmpgnListCreateCampaign']")));
		getDriver().findElement(By.xpath("//*[@id='cmpnManagerLabelToken']"));
	}
	
	@Test
	public void QA04_VerifyUnableToCreateCampaign()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		//getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='campaignsTab']")));
		getDriver().findElement(By.xpath("//*[@id='campaignsTab']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCmpgnListCreateCampaign']"))).click();
		getDriver().findElement(By.id("btnCmpgnListNext")).click();
		Assert.assertTrue(getDriver().findElement(By.xpath("//div[contains(text(),'Additional campaigns cannot be created as all the Submission IDs are mapped to active campaigns.')]")).getText().equals("Additional campaigns cannot be created as all the Submission IDs are mapped to active campaigns."));
		
		
	}
	
	@Test
	public void QA08_VerifyWorkspacePage()
	{
		 getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 200);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='workspace']"))).click();
		 getDriver().findElement(By.xpath("//a[@id='workspace']")).click();
		
	}
	
	@Test
	public  void QA09_VerifyProvidersPage()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 200);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("providersTab"))).click();
		
		
	}
	
	
	@Test
	public  void QA10_VerifyChasesPage()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 200);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='workspace']"))).click();
		// getDriver().findElement(By.xpath("//a[@id='workspace']")).click();
		
	}
	
	@Test
	public  void QA11_VerifyReviewPage()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("reviewsTab"))).click();
		
		
	}
	
	@Test
	public  void QA12_VerifyReportsPage()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("reportsTab"))).click();
		 
		
	}
	
	
	@Test
	public  void QA13_VerifyChartRepository()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("chartRepositoryTab"))).click();
		 
		
	}
	
	@Test
	public  void QA14_VerifyHedisYearClosure()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		//getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='campaignsTab']")));
		getDriver().findElement(By.xpath("//*[@id='campaignsTab']")).click();
		CustomListeners.testReport.get().log(Status.INFO, "Create campaign tab clicked successfully!");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCmpgnListCreateCampaign']"))).click();
		CustomListeners.testReport.get().log(Status.INFO, "Create campaign button clicked sucessfully!");
		getDriver().findElement(By.xpath("//div[contains(text(),'HEDIS Year Round Gap Closure')]")).click();
		getDriver().findElement(By.id("btnCmpgnListNext")).click();
		
	}
	
	@Test
	public  void QA15_VerifyHedisYearPage()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		//getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='campaignsTab']")));
		getDriver().findElement(By.xpath("//*[@id='campaignsTab']")).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign tab clicked successfully!");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCmpgnListCreateCampaign']"))).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign button clicked sucessfully!");
	    getDriver().findElement(By.xpath("//div[contains(text(),'HEDIS Year Round Gap Closure')]")).click();
		getDriver().findElement(By.id("btnCmpgnListNext")).click();
		Assert.assertTrue(getDriver().findElement(By.xpath("//h5[@id='lblHeaderText']")).getText().equals("HEDIS Year Round Gap Closure ]"));
		 
		
	}
	
	@Test
	public  void QA16_VerifyHedisYearPage()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		//getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='campaignsTab']")));
		getDriver().findElement(By.xpath("//*[@id='campaignsTab']")).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign tab clicked successfully!");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCmpgnListCreateCampaign']"))).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign button clicked sucessfully!");
	    getDriver().findElement(By.xpath("//div[contains(text(),'HEDIS Year Round Gap Closure')]")).click();
		getDriver().findElement(By.id("btnCmpgnListNext")).click();
	}
	
	//input[@id='campaignType']
	
	
	@Test
	public  void QA17_VerifyCampaignType()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		//getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='campaignsTab']")));
		getDriver().findElement(By.xpath("//*[@id='campaignsTab']")).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign tab clicked successfully!");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCmpgnListCreateCampaign']"))).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign button clicked sucessfully!");
	    getDriver().findElement(By.xpath("//div[contains(text(),'HEDIS Year Round Gap Closure')]")).click();
		getDriver().findElement(By.id("btnCmpgnListNext")).click();
		Assert.assertTrue(isElementPresent(By.xpath("//input[@id='campaignType']")));

	}
	

	@Test
	public  void QA18_VerifyCampaignName()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		//getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='campaignsTab']")));
		getDriver().findElement(By.xpath("//*[@id='campaignsTab']")).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign tab clicked successfully!");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCmpgnListCreateCampaign']"))).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign button clicked sucessfully!");
	    getDriver().findElement(By.xpath("//div[contains(text(),'HEDIS Year Round Gap Closure')]")).click();
		getDriver().findElement(By.id("btnCmpgnListNext")).click();
		
		
		}
	
	@Test
	public  void QA19_VerifyCampaignManager()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		//getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='campaignsTab']")));
		getDriver().findElement(By.xpath("//*[@id='campaignsTab']")).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign tab clicked successfully!");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCmpgnListCreateCampaign']"))).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign button clicked sucessfully!");
	    getDriver().findElement(By.xpath("//div[contains(text(),'HEDIS Year Round Gap Closure')]")).click();
		getDriver().findElement(By.id("btnCmpgnListNext")).click();
		Assert.assertTrue(isElementPresent(By.xpath("//*[@id='campaignManager']")));
		
		}
	
	@Test
	public  void QA20_VerifyCampaignDescription()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		//getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='campaignsTab']")));
		getDriver().findElement(By.xpath("//*[@id='campaignsTab']")).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign tab clicked successfully!");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCmpgnListCreateCampaign']"))).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign button clicked sucessfully!");
	    getDriver().findElement(By.xpath("//div[contains(text(),'HEDIS Year Round Gap Closure')]")).click();
		getDriver().findElement(By.id("btnCmpgnListNext")).click();
		Assert.assertTrue(isElementPresent(By.xpath("//*[@id='campaignDescription']]")));
		
		}
	
	
	@Test
	public  void QA21_VerifyCampaignSubmissionID()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		//getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='campaignsTab']")));
		getDriver().findElement(By.xpath("//*[@id='campaignsTab']")).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign tab clicked successfully!");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCmpgnListCreateCampaign']"))).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign button clicked sucessfully!");
	    getDriver().findElement(By.xpath("//div[contains(text(),'HEDIS Year Round Gap Closure')]")).click();
		getDriver().findElement(By.id("btnCmpgnListNext")).click();
		Assert.assertTrue(isElementPresent(By.xpath("//*[@id='submissionId']")));
		
		}
	
	@Test
	public  void QA22_VerifyInvalidProvidersPage()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 200);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("providersTab"))).click();
		 Assert.assertTrue(false);
		
		
	}
	
	@Test
	public  void QA23_VerifyInvalidCampaignType()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		//getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='campaignsTab']")));
		getDriver().findElement(By.xpath("//*[@id='campaignsTab']")).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign tab clicked successfully!");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCmpgnListCreateCampaign']"))).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign button clicked sucessfully!");
	    getDriver().findElement(By.xpath("//div[contains(text(),'HEDIS Year Round Gap Closure')]")).click();
		getDriver().findElement(By.id("btnCmpgnListNext")).click();
		Assert.assertTrue(false);

	}
	

	@Test
	public  void QA24_VerifyInvalidCampaignName()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		//getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='campaignsTab']")));
		getDriver().findElement(By.xpath("//*[@id='campaignsTab']")).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign tab clicked successfully!");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCmpgnListCreateCampaign']"))).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign button clicked sucessfully!");
	    getDriver().findElement(By.xpath("//div[contains(text(),'HEDIS Year Round Gap Closure')]")).click();
		getDriver().findElement(By.id("btnCmpgnListNext")).click();
		Assert.assertTrue(false);
		
		
		}
	
	@Test
	public  void QA25_VerifyInvalidCampaignManager()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		//getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='campaignsTab']")));
		getDriver().findElement(By.xpath("//*[@id='campaignsTab']")).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign tab clicked successfully!");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCmpgnListCreateCampaign']"))).click();
	    CustomListeners.testReport.get().log(Status.INFO, "Create campaign button clicked sucessfully!");
	    getDriver().findElement(By.xpath("//div[contains(text(),'HEDIS Year Round Gap Closure')]")).click();
		getDriver().findElement(By.id("btnCmpgnListNext")).click();
		Assert.assertTrue(false);
		
		}
	
	@Test
	public  void QA26_VerifyInvalidReviewPage()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("reviewsTab"))).click();
		 Assert.assertTrue(false);
		
		
	}
	
	@Test
	public  void QA27_VerifyInvalidReportsPage()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("reportsTab"))).click();
		 
		
	}
	
	
	@Test
	public  void QA28_VerifyInvalidChartRepository()
	{
		getDriver().navigate().to(config.getProperty("TestSiteMrr"));
		 WebDriverWait wait = new WebDriverWait(getDriver(), 240);
		 wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='username']")));
		 getDriver().findElement(By.xpath("//*[@id='username']")).sendKeys("albertr");
		 getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
		 getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
		 getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("chartRepositoryTab"))).click();
		 Assert.assertTrue(false);
		 
		
	}
	
	
	
	

}
