package com.qa.testcases;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.base.BaseTest;
import com.qa.listeners.CustomListeners;

public class ChartRepo extends BaseTest{

    @Test
    public void QA01_VerifyChartRepoTitle() {
    	log.info("1st Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA01_VerifyChartRepoTitle Test");
        goToChartRepository();
        CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
        Assert.assertEquals(getDriver().getTitle(), "Campaign Management Module");
    }
    
    @Test
    public void QA02_UploadMedicleRecords() {
    	log.info("2nd Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA02_UploadMedicleRecords Test");
        goToChartRepository();
        CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
        WebDriverWait wait = new WebDriverWait(getDriver(), 240);
        Assert.assertTrue(wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[contains(text(),'Upload Medical Record')]"))).isDisplayed());
        CustomListeners.testReport.get().log(Status.INFO, "Upload Medical Record button is enabled.");
        
    }

    @Test
    public void QA03_VerifyExpandListing() {
    	log.info("3rd Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA03_ExpandListing Test");
        goToChartRepository();
        CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
        WebDriverWait wait = new WebDriverWait(getDriver(), 240);
        Assert.assertTrue(wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[@class='btn form-toggle-btn']"))).isDisplayed());
        CustomListeners.testReport.get().log(Status.INFO, "Expand listing is working.");
    }

    @Test
    public void QA04_SearchByMedicleRecordStatus() {
    	log.info("4th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA04_VerifyMedicleRecordStatusSelection Test");
	    goToChartRepository();
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'Medical Record Status ')]//following::div[1]"))).click();
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[text()='MR Rejected']"))).click();
        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply Filters']")).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Apply filters button is enabled for Medical Record Status.");
    }

  @Test
  public void QA05_VerifyShowingStatement() throws InterruptedException {
  	log.info("5th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA05_VerifyShowingStatement Test");
      goToChartRepository();
      CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
      WebDriverWait wait = new WebDriverWait(getDriver(), 240);
      String elementText = wait.until(ExpectedConditions
              .elementToBeClickable(By.xpath("//*[contains(text(),'Showing')]"))).getText();
      Assert.assertEquals(elementText, "Showing 1 to 5 of 129 records");
  }
  
  @Test
  public void QA06_SearchByMR() throws InterruptedException {
	  log.info("6th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA06_SearchByMR Test");
	    goToChartRepository();
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    Assert.assertTrue(wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'Search by MR / Chart Name ')]//following::div[1]\""))).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "MR/Chart Name field is enabled.");
  }
  
  @Test
  public void QA07_SearchByMember() throws InterruptedException {
	  log.info("7th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA07_SearchByMember Test");
	    goToChartRepository();
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    Assert.assertTrue(wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'Member ')]//following::div[1]"))).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Member field is enabled.");
  }
  
  @Test
  public void QA08_SearchByProvider() throws InterruptedException {
	  log.info("8th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA08_SearchByProvider Test");
	    goToChartRepository();
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    Assert.assertTrue(wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'Provider ')]//following::div[1]"))).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Provider field is enabled.");
  }
  
  @Test
  public void QA09_SearchByProviderAddress() throws InterruptedException {
	  log.info("9th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA09_SearchByProviderAddress Test");
	    goToChartRepository();
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    Assert.assertTrue(wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'Provider Address ')]//following::div[1]"))).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Provider Address field is enabled.");
  }
  
  @Test
  public void QA10_SearchByDiseaseCategory() throws InterruptedException {
	  log.info("10th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA10_SearchByProviderAddress Test");
	    goToChartRepository();
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'Disease Category ')]//following::div[1]"))).click();
	    
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[text()='Adult Well-Care']"))).click();
        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply Filters']")).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Apply filters button is enabled for Disease Category.");
  }
 
  @Test
  public void QA11_SearchByFileType() throws InterruptedException {
	  log.info("11th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA11_SearchByFileType Test");
	    goToChartRepository();
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'File Type')]//following::div[1]"))).click();
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[text()='docx']"))).click();
        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply Filters']")).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Apply filters button is enabled for File Type.");
}
  
  @Test
  public void QA12_SearchByCampaignType() throws InterruptedException {
	  log.info("12th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA12_SearchByCampaignType Test");
	    goToChartRepository();
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'Campaign Type')]//following::div[1]"))).click();
	    
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[text()='PROSP2020']"))).click();
        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply Filters']")).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Apply filters button is enabled for Campaign Type.");
}
    
  @Test
  public void QA13_SearchByMeasuresforAbstraction() throws InterruptedException {
	  log.info("13th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA13_SearchByCampaignType Test");
	    goToChartRepository();
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'Measures for Abstraction ')]//following::div[1]"))).click();
	    
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[text()='APM: Cholesterol']"))).click();
        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply Filters']")).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Apply filters button is enabled for Measures for Abstraction.");
}
  
  @Test
  public void QA14_SearchByUploaded() throws InterruptedException {
	  log.info("14th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA14_SearchByUploaded Test");
	    goToChartRepository();	
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'Uploaded By ')]//following::div[1]"))).click();
	    
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[text()='Abelson, Einstein']"))).click();
        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply Filters']")).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Apply filters button is enabled for Uploaded By.");
}
  
  @Test
  public void QA15_SearchByTypeofSource() throws InterruptedException {
	  log.info("15th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA15_TypeofSource Test");
	    goToChartRepository();
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'Type of Source ')]//following::div[1]"))).click();
	    
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[text()='EHR']"))).click();
        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply Filters']")).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Apply filters button is enabled for Type of Source.");
}
  
  @Test
  public void QA16_SearchByTaggedMeasures() throws InterruptedException {
	  log.info("16th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA16_TaggedMeasures Test");
	    goToChartRepository();
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'Tagged Measures')]//following::div[1]"))).click();
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[text()='APM: Cholesterol']"))).click();
        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Apply Filters']")).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Apply filters button is enabled forTagged Measures.");
}

  @Test
  public void QA17_ResetFileType() throws InterruptedException {
	  log.info("17th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA17_ResetFileType Test");
	    goToChartRepository();
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'File Type ')]//following::div[1]"))).click();
	    
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[text()='docx']"))).click();
        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for File Type.");
}
 
  @Test
  public void QA18_ResetCampaignType() {
	  log.info("18th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA18_ResetCampaignType Test");
	    goToChartRepository();
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'Campaign Type ')]//following::div[1]"))).click();
	    
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[text()='PROSP2020']"))).click();
        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for Campaign Type.");
}
  
  @Test
  public void QA19_ResetMedicleRecordStatus() {
  	log.info("19th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA04_VerifyMedicleRecordStatusSelection Test");
	    goToChartRepository();
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    wait.until(ExpectedConditions
              .elementToBeClickable(By.xpath("//label[contains(text(),'Medical Record Status ')]//following::div[1]"))).click();
	    wait.until(ExpectedConditions
              .elementToBeClickable(By.xpath("//*[text()='MR Rejected']"))).click();
	    Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for Medical Record Status.");
  }
  
  @Test
  public void QA20_ResetMeasuresforAbstraction() {
	  log.info("20th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA20_ResetMeasuresforAbstraction Test");
	    goToChartRepository();
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'Measures for Abstraction ')]//following::div[1]"))).click();
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[text()='APM: Cholesterol']"))).click();
        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for Measures for Abstraction.");
}
  
  @Test
  public void QA21_ResetUploadedBy() {
	  log.info("21th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA21_ResetUploadedBy Test");
	    goToChartRepository();	
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'Uploaded By ')]//following::div[1]"))).click();
	    
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[text()='Abelson, Einstein']"))).click();
        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for Uploaded By.");
}
  
  @Test
  public void QA22_ResetTypeofSource() {
	  log.info("22nd Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA15_TypeofSource Test");
	    goToChartRepository();
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'Type of Source ')]//following::div[1]"))).click();
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[text()='EHR']"))).click();
        Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for Type of Source.");
}
  
  @Test
  public void QA23_ResetDiseaseCategory() {
	  log.info("23rd Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA10_SearchByProviderAddress Test");
	    goToChartRepository();
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'Disease Category ')]//following::div[1]"))).click();
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[text()='Adult Well-Care']"))).click();
	    Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for Disease Category.");
  }
  
  @Test
  public void QA24_ResetTaggedMeasures() {
	  log.info("24th Test Start----------------");
		CustomListeners.testReport.get().log(Status.INFO, "QA16_TaggedMeasures Test");
	    goToChartRepository();
	    CustomListeners.testReport.get().log(Status.INFO, "Successfully logged in to MRR App and directed to Chart Repository page");
	    WebDriverWait wait = new WebDriverWait(getDriver(), 300);
	    wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//label[contains(text(),'Tagged Measures')]//following::div[1]"))).click();
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[text()='APM: Cholesterol']"))).click();
	    Assert.assertTrue(getDriver().findElement(By.xpath("//button[text()='Reset']")).isDisplayed());
	    CustomListeners.testReport.get().log(Status.INFO, "Reset button is enabled for Tagged Measures.");
}  
  
}
