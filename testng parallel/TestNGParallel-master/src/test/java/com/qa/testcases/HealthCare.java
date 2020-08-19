package com.qa.testcases;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.base.BaseTest;
import com.qa.listeners.CustomListeners;


public class HealthCare extends BaseTest {
	
	private static final Logger LOGGER = LogManager.getLogger(HealthCare.class);
	
	public void loginToHealthCareApp()
	{
		
	}
	
	@Test
    public void QA01_VerifyPatientName() {
	
       getDriver().navigate().to(config.getProperty("testsiteurl"));
       WebDriverWait wait = new WebDriverWait(getDriver(), 240);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Mike Lewis')]")));
       CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to HealthCare App");
       getDriver().findElement(By.xpath("//div[contains(text(),'Mike Lewis')]")).getText();
       
       Assert.assertEquals("Mike Lewis".trim(), getDriver().findElement(By.xpath("//div[contains(text(),'Mike Lewis')]")).getText().trim());
       CustomListeners.testReport.get().log(Status.INFO, "Patient Name is:" +getDriver().findElement(By.xpath("//div[contains(text(),'Mike Lewis')]")).getText());
       CustomListeners.testReport.get().log(Status.INFO, "QA01_VerifyPatientName() executed successfully");

    }
	
	@Test
    public void QA02_VerifyPatientBP() {
        getDriver().navigate().to(config.getProperty("testsiteurl"));
        getDriver().findElement(By.xpath("//div[contains(text(),'BP (mmHg)')]/following-sibling::div[contains(text(),' 140/96 ')]")).getText();
       Assert.assertEquals("140/96".trim(), getDriver().findElement(By.xpath("//div[contains(text(),'BP (mmHg)')]/following-sibling::div[contains(text(),' 140/96 ')]")).getText());
       
      }
	
	@Test
    public void QA03_VerifyPatientPulse() {
        
        getDriver().navigate().to(config.getProperty("testsiteurl"));
        getDriver().findElement(By.xpath("//div[contains(text(),'Pulse')]/following-sibling::div[contains(text(),'110')]")).getText();
        Assert.assertEquals("110",getDriver().findElement(By.xpath("//div[contains(text(),'Pulse')]/following-sibling::div[contains(text(),'110')]")).getText().trim());
        
    }
	

   @Test
   public void QA04_VerifyPatientName() {
		
		CustomListeners.testReport.get().log(Status.INFO, "QA01_VerifyPatientName Test");
       getDriver().navigate().to(config.getProperty("testsiteurl"));
       getDriver().findElement(By.xpath("//div[contains(text(),'Mike Lewis')]")).getText();
       Assert.assertEquals("Mike Lewi".trim(), getDriver().findElement(By.xpath("//div[contains(text(),'Mike Lewis')]")).getText().trim());
       
   }
	
	@Test
   public void QA05_VerifyPatientBP() {
       
       getDriver().navigate().to(config.getProperty("testsiteurl"));
       getDriver().findElement(By.xpath("//div[contains(text(),'BP (mmHg)')]/following-sibling::div[contains(text(),' 140/96 ')]")).getText();
      Assert.assertEquals("140/66".trim(), getDriver().findElement(By.xpath("//div[contains(text(),'BP (mmHg)')]/following-sibling::div[contains(text(),' 140/96 ')]")).getText());
      
       
   }
	
	@Test
   public void QA06_VerifyPatientPulse() {
       System.out.println("QA03 Health Care App started! " + "Thread Id: " +  Thread.currentThread().getId());
       getDriver().navigate().to(config.getProperty("testsiteurl"));
       System.out.println("QA03 Health Care Page title is: " + getDriver().getTitle() +" " + "Thread Id: " +  Thread.currentThread().getId());
       getDriver().findElement(By.xpath("//div[contains(text(),'Pulse')]/following-sibling::div[contains(text(),'110')]")).getText();
      Assert.assertEquals("110",getDriver().findElement(By.xpath("//div[contains(text(),'Pulse')]/following-sibling::div[contains(text(),'110')]")).getText().trim());
       System.out.println("QA03 Health Care App Ended! " + "Thread Id: " +  Thread.currentThread().getId());
   }
	
	@Test
	public void QA07_VerifyActiveDiagnosis() {
	System.out.println("Verify if Active Diagnosis is displayed");
	getDriver().navigate().to(config.getProperty("testsiteurl"));
	WebDriverWait wait = new WebDriverWait(getDriver(), 20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='heading'])[1]")));
	Assert.assertTrue(
	getDriver().findElement(By.xpath("(//div[@class='heading'])[1]")).getText().equals("Active Diagnosis"));
	}
	
	@Test
	public void QA08_VerifyActiveMedication() {
	System.out.println("Verify if Active Medication is displayed");
	getDriver().navigate().to(config.getProperty("testsiteurl"));
	WebDriverWait wait = new WebDriverWait(getDriver(), 20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='heading'])[2]")));
	Assert.assertTrue(getDriver().findElement(By.xpath("(//div[@class='heading'])[2]")).getText()
	.equals("Active Medication"));
	}

	@Test
	public void QA09_VerifyActiveDiagnosisSubHeading() {
	System.out.println("Verify if Active Diagnosis Subheading is displayed");
	getDriver().navigate().to(config.getProperty("testsiteurl"));
	WebDriverWait wait = new WebDriverWait(getDriver(), 20);
	wait.until(ExpectedConditions
	.visibilityOfElementLocated(By.xpath("((//div[@class='heading'])[1]/following::div/label)[1]")));
	Assert.assertTrue(getDriver().findElement(By.xpath("((//div[@class='heading'])[1]/following::div/label)[1]"))
	.getText().equals("Traumatic Brain Injury - S06.2X9D"));
	}

	@Test
	public void QA10_VerifyActiveDiagnosisData() {
	System.out.println("Verify data in Active Diagnosis");
	getDriver().navigate().to(config.getProperty("testsiteurl"));
	WebDriverWait wait = new WebDriverWait(getDriver(), 20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(
	By.xpath("((//div[@class='heading'])[1]/following::div/label)[1]/following::div[1]")));
	Assert.assertTrue(getDriver()
	.findElement(By.xpath("((//div[@class='heading'])[1]/following::div/label)[1]/following::div[1]"))
	.getText()
	.contains("Diffuse traumatic brain injury with loss of consciousness of unspecified duration"));
	}

	@Test
	public void QA11_VerifyRR() {
	System.out.println("Verify RR");
	getDriver().navigate().to(config.getProperty("testsiteurl"));
	Assert.assertTrue(getDriver().findElement(By.xpath("//div[@class='RRHeader']")).isDisplayed());
	System.out.println(getDriver().findElement(By.xpath("//div[@class='RRHeader']")).getText());
	Assert.assertTrue(getDriver().findElement(By.xpath("//div[@class='RRHeader']")).getText().equals("RR (/MIN)"));
	Assert.assertTrue(getDriver().findElement(By.xpath("//div[@class='RRSubHeader']")).getText().equals("22"));
	}

	@Test
	public void QA12_VerifySP02() {
	System.out.println("Verify SP02");
	getDriver().navigate().to(config.getProperty("testsiteurl"));
	System.out.println(getDriver().findElement(By.xpath("//div[@class='sp02Header']")).getText());
	Assert.assertTrue(getDriver().findElement(By.xpath("//div[@class='sp02Header']")).isDisplayed());
	Assert.assertTrue(getDriver().findElement(By.xpath("//div[@class='sp02Header']")).getText().equals("SP02 (%)"));
	Assert.assertTrue(getDriver().findElement(By.xpath("//div[@class='sp02SubHeader']")).getText().equals("97"));
	}

	@Test
	public void QA13_VerifyTemperature() {
	System.out.println("Verify Temperature");
	getDriver().navigate().to(config.getProperty("testsiteurl"));
	System.out.println(getDriver().findElement(By.xpath("//div[@class='tempHeader']")).getText());
	Assert.assertTrue(getDriver().findElement(By.xpath("//div[@class='tempHeader']")).isDisplayed());
	Assert.assertTrue(
	getDriver().findElement(By.xpath("//div[@class='tempHeader']")).getText().equals("Temperature (°F)"));
	Assert.assertTrue(getDriver().findElement(By.xpath("//div[@class='tempSubHeader']")).getText().equals("98"));
	}

	@Test
	public void QA14_Userdetails() {
	System.out.println("Verify User details");
	getDriver().navigate().to(config.getProperty("testsiteurl"));
	System.out.println(getDriver().findElement(By.xpath("//div[@class='age']")).getText());
	Assert.assertTrue(getDriver().findElement(By.xpath("//div[@class='age']")).getText().equals("30 years, Male"));
	Assert.assertTrue(
	getDriver().findElement(By.xpath("//div[@class='encounter']")).getText().equals("Encounter - 104"));
	}


	@Test
    public void QA15_VerifyActiveMedication1() {
    CustomListeners.testReport.get().log(Status.INFO, "Verify Medication");
    getDriver().navigate().to(config.getProperty("testsiteurl"));
    WebDriverWait wait=new WebDriverWait(getDriver(), 180);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Tab Nitrostat 4 mg')]")));
    Assert.assertTrue(getDriver().findElement(By.xpath("//*[contains(text(), 'Tab Nitrostat 4 mg')]")).isDisplayed());
    CustomListeners.testReport.get().log(Status.INFO, "Medication 1 verified successfulyy!");
    }
    
    @Test
    public void QA16_VerifyActiveMedication2() {
    CustomListeners.testReport.get().log(Status.INFO, "Verify Medication");
    System.out.println("Verify User details");
    getDriver().navigate().to(config.getProperty("testsiteurl"));
    WebDriverWait wait=new WebDriverWait(getDriver(), 180);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Tab Zestril 20 mg')]")));
    Assert.assertTrue(getDriver().findElement(By.xpath("//div[contains(text(), 'Tab Zestril 20 mg')]")).isDisplayed());
    CustomListeners.testReport.get().log(Status.INFO, "Medication 2 verified successfulyy!");

 

    
    }
    
    @Test
    public void QA17_VerifyActiveMedication3() {
    CustomListeners.testReport.get().log(Status.INFO, "Verify Medication");
    getDriver().navigate().to(config.getProperty("testsiteurl"));
    WebDriverWait wait=new WebDriverWait(getDriver(), 180);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Tab Glyburied 2.5 mg')]")));
    Assert.assertTrue(getDriver().findElement(By.xpath("//*[contains(text(), 'Tab Glyburied 2.5 mg')]")).isDisplayed());
    CustomListeners.testReport.get().log(Status.INFO, "Medication 3 verified successfulyy!");

 

    }
    
    @Test
    public void QA18_VerifyAllergicDrug1() {
    CustomListeners.testReport.get().log(Status.INFO, "Verify Allergic Drug");
    getDriver().navigate().to(config.getProperty("testsiteurl"));
    WebDriverWait wait=new WebDriverWait(getDriver(), 180);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Penicillin')]")));
    Assert.assertTrue(getDriver().findElement(By.xpath("//*[contains(text(), 'Penicillin')]")).isDisplayed());
    CustomListeners.testReport.get().log(Status.INFO, "AllergicDrug2 verified successfulyy!");

 

    
    }
    
    @Test
    public void QA19_VerifyAllergicDrug2() {
        
    CustomListeners.testReport.get().log(Status.INFO, "Verify Allergic Drug");
    getDriver().navigate().to(config.getProperty("testsiteurl"));
    WebDriverWait wait=new WebDriverWait(getDriver(), 180);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Dilantin')]")));
    Assert.assertTrue(getDriver().findElement(By.xpath("//*[contains(text(), 'Dilantin')]")).isDisplayed());
    CustomListeners.testReport.get().log(Status.INFO, "AllergicDrug2 verified successfulyy!");

 

    
    }
    
    @Test
    public void QA20_VerifyAllergicDrug3() {
    CustomListeners.testReport.get().log(Status.INFO, "Verify Allergic Drug");
    getDriver().navigate().to(config.getProperty("testsiteurl"));
    WebDriverWait wait=new WebDriverWait(getDriver(), 180);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Sulpha Drugs')]")));
    Assert.assertTrue(getDriver().findElement(By.xpath("//*[contains(text(), 'Sulpha Drugs')]")).isDisplayed());
    CustomListeners.testReport.get().log(Status.INFO, "AllergicDrug3 verified successfulyy!");
      
    
    }
    
    @Test
    public void QA21_VerifyActiveMedication4() {
        
    CustomListeners.testReport.get().log(Status.INFO, "Verify Medication");
    System.out.println("Verify User details");
    getDriver().navigate().to(config.getProperty("testsiteurl"));
    Assert.assertTrue(getDriver().findElement(By.xpath("//*[contains(text(), 'Tab Glyburied 2.5 mg')]")).getText().contains("Paracetamol"));

 

    }
    
    @Test
    public void QA22_VerifyAllergicDrug4() {
        CustomListeners.testReport.get().log(Status.INFO, "Verify Allergic Drug 4");
        getDriver().navigate().to(config.getProperty("testsiteurl"));
        Assert.assertTrue(getDriver().findElement(By.xpath("//*[contains(text(), 'Sulpha Drugs')]")).getText().equals("Alpha Drugs"));

 }
    
   
}