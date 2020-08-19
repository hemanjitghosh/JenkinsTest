package POC.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testreport.IReporter;

public class POC_CarePlan_Restorative extends  POC_CarePlan_MoodAndBehavior {

	public POC_CarePlan_Restorative(WebDriver webDriver, IReporter testReport) {
		super(webDriver, testReport);
		// TODO Auto-generated constructor stub
	}
	
	public By txtRetorativeInformation = By.xpath("//div[@class='main-screen']//div[contains(@class,'text-white')]");
	public By btnLinkPage = By.xpath("//button//img[contains(@src,'LinkPage.png')]");
	By SelfPerformanceImg = By.xpath("//img[contains(@src,'SelfPerformance')]");
	By SelfPerformanceText = By.xpath("//img[contains(@src,'SelfPerformance')]/following-sibling::*[text()='Self Performance']");
	By SupportImg = By.xpath("//div[contains(@class,'person')]//img[contains(@src,'Support')]");
	By SupportText = By.xpath("//img[contains(@src,'Support')]/following-sibling::*[text()='Support']");
	By LocationText = By.xpath("//span[contains(text(),'Location')]");
	By SelfPerformanceSupportProvidedText = By.xpath("//span[contains(text(),'Self Performance & Support Provided')]");
	By btnMinutes = By.xpath("//button[contains(@class,'green') and contains(text(),'Minutes')]");
	By btnDistance = By.xpath("//button[contains(@class,'green') and contains(text(),'Distance')]");
	By inputMinutes = By.xpath("//button[contains(@class,'green') and contains(text(),'Minutes')]/..//..//input");
	By inputDistance = By.xpath("//button[contains(@class,'green') and contains(text(),'Distance')]/..//..//input");

	public void SelectRestorativeOptions(ArrayList<String> CarePlan)
	{
		String[] AllCarePlan = CarePlan.toArray(new String[CarePlan.size()]);
		for(int i=1;i<=AllCarePlan.length;i++)
		{
			this.click(By.xpath(String.format("//div[@class='main-screen']//button//p[text()='%s']", AllCarePlan[i-1])),  AllCarePlan[i-1]);
			this.WaitForElementPresent(txtRetorativeInformation, 10, "Retorative Information");
			this.VerifyWebElementPresent(txtRetorativeInformation, "Retorative Information");
			this.WaitForElementPresent(btnLinkPage, 10, "Link Page");
			this.click(btnLinkPage, "Link Page");
		}
			
	}
	
	public String[] VerifyActivityOptionalSelfPerformanceAndSupport(String OptioNal ,String SelfPerformance , String Support)
	{
		String[] OPTION = {SelfPerformance,Support};
		try
		{
			if(this.isElementPresent(LocationText))
			{
				this.VerifyWebElementPresent(LocationText, "Location");
				this.VerifyWebElementPresent(SelfPerformanceSupportProvidedText, "Self Performance & Support Provided");
			}
			this.VerifyWebElementPresent(SelfPerformanceImg, "Self Performance");
			this.VerifyWebElementPresent(SelfPerformanceText, "Self Performance Text");
			this.VerifyWebElementPresent(SupportImg, "Support ");
			this.VerifyWebElementPresent(SupportText, "Support Text");

			List<WebElement> Options = wd.findElements(By.xpath("//button[contains(@class,'green')]//img[contains(@src,'Main')]/following-sibling::*"));
			ArrayList<String> Option = new ArrayList<String>();
			for(int i=1;i<=Options.size();i++)
			{
				Option.add(wd.findElement(By.xpath(String.format("(//button[contains(@class,'green')]//img[contains(@src,'Main')]/following-sibling::*)[%s]", i))).getText());
			}

			this.testReport.logSuccess("All Options Present Under Self Performance And Support ",
					String.format("All Options Present Under Self Performance And Support :- <mark>%s<mark/>", Option.toString()));

			if(!OptioNal.equals(""))
			{			
				By Optional = By.xpath(String.format("(//button//img[contains(@src,'Main')]/following-sibling::*[text()='%s'])[1]", OptioNal));
				this.click(Optional, OptioNal);
			}

			By Selfperformance = By.xpath(String.format("(//button//img[contains(@src,'Main')]/following-sibling::*[text()='%s'])[1]", SelfPerformance));
			this.click(Selfperformance, SelfPerformance);

			By support = By.xpath(String.format("(//*[text()='Support']/..//..//button[@is-disabled='false']//*[text()='%s'])", Support));
			this.click(support, Support);		

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return OPTION;

	}
	
	public void VerifyMinutesAndDistance(String Value)
	{
		try
		{
			this.VerifyWebElementPresent(btnMinutes, "Minutes");
			this.VerifyWebElementPresent(inputMinutes, "Minutes Input");
			this.VerifyWebElementPresent(btnDistance, "Distance");
			this.VerifyWebElementPresent(inputDistance, "Distance Input");
			VerifyCalculator();
			this.SendKeysToElementClearFirst(inputMinutes, Value);
			this.waitInSecs(2);
			this.click(inputDistance, "Distance");
			EnterPasscode(Value);
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
	}
	
	public void VerifyTolerance(String Value)
	{
		try
		{
			ArrayList<String> Option = new ArrayList<String>();

			List<WebElement> Options = wd.findElements(By.xpath("//button[@data-dismiss='modal']/p"));

			for(int i=1;i<=Options.size();i++)
			{
				Option.add(wd.findElement(By.xpath(String.format("(//button[@data-dismiss='modal']/p)[%s]", i))).getText());
			}
			this.testReport.logSuccess("All Bowel & Bladder Options", String.format("All Bowel & Bladder Options :-<mark>%s</mark>", Option.toString()));
		
		By OPTION = By.xpath(String.format("//button[@data-dismiss='modal']//p[contains(text(),'%s')]", Value));
		this.click(OPTION, Value);
		}

		catch(Exception ex)
		{
			ex.getMessage();
		}
	}
	
	public void VerifyNoParticipation()
	{
		try
		{
			By NoParticipationTextForSelfPerformanceAndSupport = By.xpath("//div[contains(@class,'main-screen')]//div//*[contains(text(),'Support')]/preceding-sibling::*//p[1]");
			By NoParticipationTextForMinutesAndDistance = By.xpath("//div[contains(@class,'main-screen')]//div//*[contains(text(),'Minutes')]/preceding-sibling::*//p[1]");
			By NoParticipationTextForResidentTolerance = By.xpath("//div[contains(@class,'main-screen')]//div//*[contains(text(),\"Resident's tolerance\")]/preceding-sibling::*//p[1]");
			
			this.VerifyWebElementPresent(NoParticipationTextForSelfPerformanceAndSupport, "No Participation Text Performance & Support Provided");
			this.VerifyWebElementPresent(NoParticipationTextForMinutesAndDistance, "No Participation Text Minutes And Distance");
			this.VerifyWebElementPresent(NoParticipationTextForResidentTolerance, "No Participation Text Resident's Tolerance");
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
	}
	
	public void VerifyBalanceCarePlan(String Value, String OPTION)
	{
		try
		{
			ArrayList<String> Options = new ArrayList<String>();
			List<WebElement> Option = wd.findElements(By.xpath("(//button[@data-backdrop='static' and @data-target='#balance-modal'])"));
			for(int i=1;i<=Option.size();i++)
			{
				Options.add(wd.findElement(By.xpath(String.format("(//button[@data-backdrop='static' and @data-target='#balance-modal'])[%s]", i))).getText());
			}
			this.testReport.logSuccess("All Options", String.format("All Options :-<mark>%s</mark> ", Options.toString()));

			if(!Value.equals(""))
			{
				this.click(By.xpath(String.format("//button[@data-backdrop='static' and @data-target='#balance-modal']//p[text()='%s']", Value)), Value);
				Thread.sleep(2000);	
				ComponentsInBMWindow();
				Thread.sleep(2000);	
				VefifyEnterNotesValidation();
				SaveEnterNotesWindow();
				SelectOptionForAShift(OPTION);
			}
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
	}
	
	
	
}
