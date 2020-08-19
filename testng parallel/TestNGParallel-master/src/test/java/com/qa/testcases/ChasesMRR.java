package com.qa.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.base.BaseTest;
import com.qa.listeners.CustomListeners;

public class ChasesMRR extends BaseTest{

	  	@Test
	    public void QA01_VerifyCreateManualChase(){
	    	log.info("1st Test Start----------------");
			CustomListeners.testReport.get().log(Status.INFO, "QA01_VerifyCreateManualChase Test");
			goToChases();
	        WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//button[contains(text(),'Create Manual Chase')]"))).click();
	        System.out.println("Clicked on CreateManualChase button");
	        System.out.println();
	    }
	
	  	@Test
	    public void QA02_VerifySavePreferences(){
	    	log.info("2nd Test Start----------------");
			CustomListeners.testReport.get().log(Status.INFO, "QA02_VerifySavePreferences Test");
			goToChases();
	        WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//span[contains(text(), 'Click on settings icon to save preferences')]//following::a"))).click();
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//button[contains(text(),'Save Preferences')]"))).click();
	        System.out.println("Clicked on Save Preferences Setting icon");
	        System.out.println();
	    }
	  	
	  	@Test
	    public void QA03_VerifyResetPreferences(){
	    	log.info("3rd Test Start----------------");
			CustomListeners.testReport.get().log(Status.INFO, "QA03_VerifyResetPreferences Test");
			goToChases();
	        WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//span[contains(text(), 'Click on settings icon to save preferences')]//following::a"))).click();
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//button[contains(text(),'Save Preferences')]"))).click();
	        System.out.println("Clicked on Reset Preferences Setting icon");
	        System.out.println();
	    }
	  	
	  	@Test
	    public void QA04_ApplyResetBusinessGroup(){
	    	log.info("4th Test Start----------------");
			CustomListeners.testReport.get().log(Status.INFO, "QA04_ApplyResetBusinessGroup Test");
			goToChases();
			System.out.println("Hi");
			CustomListeners.testReport.get().log(Status.INFO, "logged into MRR application and directed to Chases.");
	        WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Business Group')]"))).click();
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Business Group')]//following::span[contains(text(),'Select')]"))).click();
	        getDriver().findElement(By.xpath("//*[text()='BG- 4924']")).click();
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Apply button is enabled for Business Group.");
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for Business Group.");
	    }

	  	@Test
	    public void QA05_ApplyResetProductCategory(){
	    	log.info("5th Test Start----------------");
			CustomListeners.testReport.get().log(Status.INFO, "QA05_ApplyResetProductCategory Test");
			goToChases();
			CustomListeners.testReport.get().log(Status.INFO, "logged into MRR application and directed to Chases.");
	        WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Product Category: Health Plan')]"))).click();
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Product Category: Health Plan')]//following::span[contains(text(),'Select')]"))).click();
	        getDriver().findElement(By.xpath("//*[text()='Medicaid: ScorePlus-Medicaid-MRB']")).click();
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Apply button is enabled for Product Category.");
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for Product Category.");
	    }
	  	
	  	@Test
	    public void QA06_ApplyResetCampaignType(){
	    	log.info("6th Test Start----------------");
			CustomListeners.testReport.get().log(Status.INFO, "QA06_ApplyResetCampaignType Test");
			goToChases();
			CustomListeners.testReport.get().log(Status.INFO, "logged into MRR application and directed to Chases.");
	        WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Campaign Type')]"))).click();
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Campaign Type')]//following::span[contains(text(),'Select')]"))).click();
	        getDriver().findElement(By.xpath("//*[text()='PROSP2020']")).click();
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Apply button is enabled for Campaign Type.");
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for Campaign Type.");
	    }
	  	
	  	@Test
	    public void QA07_ApplyResetCampaignName(){
	    	log.info("7th Test Start----------------");
			CustomListeners.testReport.get().log(Status.INFO, "QA07_ApplyResetCampaignName Test");
			goToChases();
			CustomListeners.testReport.get().log(Status.INFO, "logged into MRR application and directed to Chases.");
	        WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Campaign Name')]"))).click();
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Campaign Name')]//following::span[contains(text(),'Select')]"))).click();
	        getDriver().findElement(By.xpath("//*[text()='Medicare Campaign']")).click();
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Apply button is enabled for Campaign Name.");
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for Campaign Name.");
	    }
	  	
	  	@Test
	    public void QA08_ApplyResetMeasureGaps(){
	    	log.info("8th Test Start----------------");
			CustomListeners.testReport.get().log(Status.INFO, "QA08_ApplyResetMeasureGaps Test");
			goToChases();
			CustomListeners.testReport.get().log(Status.INFO, "logged into MRR application and directed to Chases.");
	        WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Measures/Gaps')]"))).click();
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Measures/Gaps')]//following::span[contains(text(),'Select')]"))).click();
	        getDriver().findElement(By.xpath("//*[text()='ABA: BMI Value/ Percentile']")).click();
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Apply button is enabled for Measures/Gaps.");
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for Measures/Gaps.");
	    }
	  	
	  	@Test
	    public void QA09_ApplyResetPriority(){
	    	log.info("9th Test Start----------------");
			CustomListeners.testReport.get().log(Status.INFO, "QA09_ApplyResetPriority Test");
			CustomListeners.testReport.get().log(Status.INFO, "logged into MRR application and directed to Chases.");
	        WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Priority')]"))).click();
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Priority')]//following::span[contains(text(),'Select')]"))).click();
	        getDriver().findElement(By.xpath("//*[text()='Top 3']")).click();
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Apply button is enabled for Priority.");
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for Priority.");
	    }
	  	
	  	@Test
	    public void QA10_ApplyResetOnHold(){
	    	log.info("10th Test Start----------------");
			CustomListeners.testReport.get().log(Status.INFO, "QA10_ApplyResetOnHold Test");
			goToChases();
			CustomListeners.testReport.get().log(Status.INFO, "logged into MRR application and directed to Chases.");
	        WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'On Hold')]"))).click();
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'On Hold')]//following::span[contains(text(),'Select')]"))).click();
	        getDriver().findElement(By.xpath("//*[text()='Yes']")).click();
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Apply button is enabled for On Hold.");
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for On Hold.");
	    }
	  	
	  	@Test
	    public void QA11_ApplyResetROIStatus(){
	    	log.info("11th Test Start----------------");
			CustomListeners.testReport.get().log(Status.INFO, "QA11_ROIStatus Test");
			goToChases();
			CustomListeners.testReport.get().log(Status.INFO, "logged into MRR application and directed to Chases.");
	        WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'ROI Status')]"))).click();
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'ROI Status')]//following::span[contains(text(),'Select')]"))).click();
	        getDriver().findElement(By.xpath("//*[text()='Generated']")).click();
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Apply button is enabled for ROI Status.");
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for ROI Status.");
	    }
	  	
	  	@Test
	    public void QA12_ApplyResetGapCategory(){
	    	log.info("12th Test Start----------------");
			CustomListeners.testReport.get().log(Status.INFO, "QA12_GapCategory Test");
			goToChases();
			CustomListeners.testReport.get().log(Status.INFO, "logged into MRR application and directed to Chases.");
	        WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Gap Category')]"))).click();
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Gap Category')]//following::span[contains(text(),'Select')]"))).click();
	        getDriver().findElement(By.xpath("//*[text()='Sample']")).click();
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Apply button is enabled for Gap Category.");
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for Gap Category.");
	    }
	  	
	  	@Test
	    public void QA13_ApplyResetComplianceStatus(){
	    	log.info("13th Test Start----------------");
			CustomListeners.testReport.get().log(Status.INFO, "QA13_ComplianceStatus Test");
			goToChases();
			CustomListeners.testReport.get().log(Status.INFO, "logged into MRR application and directed to Chases.");
	        WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Compliance Status')]"))).click();
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Compliance Status')]//following::span[contains(text(),'Select')]"))).click();
	        getDriver().findElement(By.xpath("//*[text()='Compliant']")).click();
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Apply button is enabled for Compliance Status.");
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for Compliance Status.");
	    }
	  	
	  	@Test
	    public void QA14_ApplyResetCreatedBy(){
	    	log.info("14th Test Start----------------");
			CustomListeners.testReport.get().log(Status.INFO, "QA14_ApplyResetCreatedBy Test");
			goToChases();
			CustomListeners.testReport.get().log(Status.INFO, "logged into MRR application and directed to Chases.");
	        WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Created By')]"))).click();
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Created By')]//following::span[contains(text(),'Select')]"))).click();
	        getDriver().findElement(By.xpath("//*[text()='System']")).click();
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Apply button is enabled for Created By.");
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for Created By.");
	    }
	  	
	  	@Test
	    public void QA15_ApplyResetAssignedTo(){
	    	log.info("15th Test Start----------------");
			CustomListeners.testReport.get().log(Status.INFO, "QA15_ApplyResetAssignedTo Test");
			goToChases();
			CustomListeners.testReport.get().log(Status.INFO, "logged into MRR application and directed to Chases.");
	        WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Assigned To')]"))).click();
	        wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//p-header[contains(text(),'Assigned To')]//following::span[contains(text(),'Select')]"))).click();
	        getDriver().findElement(By.xpath("//*[text()='Abelson, Einstein5']")).click();
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Apply button is enabled for Assigned To.");
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
	        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	        CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for Assigned To.");
	    }
	  	
}
