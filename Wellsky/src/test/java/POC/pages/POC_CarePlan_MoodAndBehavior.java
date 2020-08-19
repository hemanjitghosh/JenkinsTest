package POC.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testreport.IReporter;



public class POC_CarePlan_MoodAndBehavior extends POC_CarePlan_BowelAndBladder {

	public POC_CarePlan_MoodAndBehavior(WebDriver webDriver, IReporter testReport) {
		super(webDriver, testReport);
		// TODO Auto-generated constructor stub
	}
	
	public void VerifyMoodSymptom()
	{
		try
		{
			String MoodSymptom =  wd.findElement(By.xpath("//div[@class='main-screen']/div[contains(@class,'border')]/div[1]")).getText();
			this.testReport.logSuccess("Element Present", String.format("Element Present :-<mark>%s</mark>", MoodSymptom));

			List<WebElement> moodSymptom = wd.findElements(By.xpath("(//div[contains(@class,'align-content-stretch')])"));
			for(int i=1;i<=moodSymptom.size();i++)
			{
				String Shifts = wd.findElement(By.xpath(String.format("(//div[contains(@class,'align-content-stretch')])[%s]//div[2]", i))).getText();
				String ShiftData = wd.findElement(By.xpath(String.format("(//div[contains(@class,'align-content-stretch')])[%s]//div[2]/preceding-sibling::div//img", i))).getAttribute("src");
				if(ShiftData.contains("Independant"))
				{
					this.testReport.logSuccess("Shift Data", String.format("Shift Data :-<mark>%s</mark> for :-<mark>Exhibited</mark>", Shifts));
				}
				else if(ShiftData.contains("NoADL"))
				{
					this.testReport.logSuccess("Shift Data", String.format("Shift Data :-<mark>%s</mark> for :-<mark>Not Exhibited</mark>", Shifts));
				}
				else
				{
					this.testReport.logSuccess("Shift Data", String.format("Shift Data :-<mark>%s</mark> for :-<mark>No Data</mark>", Shifts));
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void SelectingShift(String Text,String Option)
	{
		try
		{
			List<WebElement> moodSymptomOption = wd.findElements(By.xpath("(//button[@data-backdrop='static' and @data-target='#mood-behavior-modal'])"));
			for(int i=1;i<=moodSymptomOption.size();i++)
			{
				String OptionName = wd.findElement(By.xpath(String.format("(//button[@data-backdrop='static' and @data-target='#mood-behavior-modal'])[%s]//span", i))).getText();
				this.click(By.xpath(String.format("(//button[@data-backdrop='static' and @data-target='#mood-behavior-modal'])[%s]", i)), OptionName);
				this.waitInSecs(2);
				ComponentsInBMWindow();
				this.waitInSecs(4);
				//String text = WrittingTextInNotes(Text);
				VefifyEnterNotesValidation();
				SaveEnterNotesWindow();
				//ValidateEnterNoteText(text,"");
				SelectOptionForAShift(Option);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void SelectOptionForAShift(String OptionName)
	{
		try
		{
			List<WebElement> Option = wd.findElements(By.xpath("(//div[contains(@class,'container')]//button[contains(@class,'green')])"));
			ArrayList<String> OPTION = new ArrayList<String>();
			for(int i=1;i<=Option.size();i++)
			{
				OPTION.add(wd.findElement(By.xpath(String.format("(//div[contains(@class,'container')]//button[contains(@class,'green')]/img)[%s]", i))).getAttribute("alt"));
			}
			this.testReport.logSuccess("All Options", String.format("All Options :-<mark>%s</mark> ", OPTION.toString()));
			By SelectedOption = By.xpath(String.format("//div[contains(@class,'container')]//button[contains(@class,'green')]/img[@alt='%s']", OptionName));
			this.click(SelectedOption, OptionName);
			this.waitInSecs(3);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void SelectSplitLocationForTransfer(String OptionName)
	{
		try
		{
			List<WebElement> Option = wd.findElements(By.xpath("(//div[contains(@class,'modal-body')])[1]//button[contains(@class,'has-hover')]/img[contains(@alt,' ')]"));
			ArrayList<String> OPTION = new ArrayList<String>();
			for(int i=1;i<=Option.size();i++)
			{
				OPTION.add(wd.findElement(By.xpath(String.format("((//div[contains(@class,'modal-body')])[1]//button[contains(@class,'has-hover')]/img[contains(@alt,' ')])[%s]", i))).getAttribute("alt"));
			}
			this.testReport.logSuccess("All Options", String.format("All Options :-<mark>%s</mark> ", OPTION.toString()));
			By SelectedOption = By.xpath(String.format("(//div[contains(@class,'modal-body')])[1]//button[contains(@class,'has-hover')]/img[@alt='%s']", OptionName));
			this.click(SelectedOption, OptionName);
			this.waitInSecs(3);
			By SaveSelectedOption = By.xpath("//button/img[contains(@alt,'Save Selected Options')]");
			this.click(SaveSelectedOption, "Save Selected Options");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
