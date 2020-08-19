package POC.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testreport.IReporter;

import dweb.aut.pages.templates.PageTemplate;

public class POC_CarePlan_Vitals extends POC_CarePlan_BowelAndBladder {

	public POC_CarePlan_Vitals(WebDriver webDriver, IReporter testReport) {
		super(webDriver, testReport);			
		
	}
	
	public By inputSystolic = By.xpath("//*[text()='Systolic']/preceding-sibling::input");
	public By inputDialotic = By.id("diastolicInput");
	//public By inputDialotic = By.xpath("//*[text()='Diastolic']/preceding-sibling::input");
	
	public void SelectVitals(String[] VitalOptions, String Text, String Value, String OPTION , String Value2)
	{
		int Size = VitalOptions.length;
		
		SelectBloodPressureVitals(Value);
		for(int i=2;i<=Size-1;i++)
		{
			String ActivityName = VitalOptions[i-1];			
			this.click(By.xpath(String.format("//button//*[contains(text(),'%s')]", ActivityName)), ActivityName);
			this.waitInSecs(2);
			ComponentsInBMWindow();
			this.waitInSecs(4);
			//String text = WrittingTextInNotes(Text);
			VefifyEnterNotesValidation();
			SaveEnterNotesWindow();
			//ValidateEnterNoteText(text,"");
			VerifyCalculator();
			this.waitInSecs(2);			
			EnterPasscode(Value);
		}
		this.click(By.xpath("//button//*[contains(text(),'Temperature')]"), "Temperature");
		this.waitInSecs(2);
		List<WebElement> AllOption = wd.findElements(By.xpath("//button[contains(@class,'text-left shadow')]//span"));
		ArrayList<String> Option = new ArrayList<String>();
		for(int i=1;i<=AllOption.size();i++)
		{
			Option.add(wd.findElement(By.xpath(String.format("(//button[contains(@class,'text-left shadow')]//span)[%s]",i))).getText());
		}
		this.testReport.logSuccess("All Options Presented Under Weight", String.format("All Options Presented Under Weight :-<mark>%s</mark>", Option.toString()));
		By addAppliance = By.xpath(String.format("//button[contains(@class,'text-left shadow')]//span[text()='%s']", OPTION));
		this.click(addAppliance, OPTION);		
		this.waitInSecs(2);
		ComponentsInBMWindow();
		this.waitInSecs(4);
		//String text = WrittingTextInNotes(Text);
		VefifyEnterNotesValidation();
		SaveEnterNotesWindow();
		//ValidateEnterNoteText(text,"");
		VerifyCalculator();
		this.waitInSecs(2);			
		EnterPasscode(Value2);
	}
	
	public void SelectBloodPressureVitals(String Value)
	{
		this.click(By.xpath("//button//*[contains(text(),'Blood Pressure')]"), "Blood Pressure");
		this.waitInSecs(2);
		ComponentsInBMWindow();
		this.waitInSecs(2);
		VefifyEnterNotesValidation();
		SaveEnterNotesWindow();
		this.waitInSecs(2);
		
		List<WebElement> Activities = wd.findElements(By.xpath("//div[contains(@class,'justify-content-center')]//button[contains(@class,'green')]//span"));
		ArrayList<String> Activity = new ArrayList<String>();
		for(int i=1;i<=Activities.size();i++)
		{
			Activity.add(wd.findElement(By.xpath(String.format("(//div[contains(@class,'justify-content-center')]//button[contains(@class,'green')]//span)[%s]",i))).getText());
		}
		
		this.click(By.xpath("(//div[contains(@class,'justify-content-center')]//button[contains(@class,'green')]//span)[1]"), "Standing");
		
		this.SendKeysToElementClearFirst(inputSystolic, Value);
		this.waitInSecs(2);
		this.click(inputDialotic, "Dialotic");
		EnterPasscode(Value);
	}
	

}
