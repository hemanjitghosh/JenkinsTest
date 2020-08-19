package POC.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testreport.IReporter;

import dweb.aut.pages.templates.PageTemplate;

public class POC_CarePlan_IntakeAndOutput extends PageTemplate {

	public POC_CarePlan_IntakeAndOutput(WebDriver webDriver, IReporter testReport) {
		super(webDriver, testReport);
		// TODO Auto-generated constructor stub
	}

	public HashMap<String, String> VerifyInTakeOutputCarePlan(String IntakeOutput)
	{
		String IntakeAndOutput =  wd.findElement(By.xpath("//div[@class='main-screen']/div[contains(@class,'border')]/div[1]")).getText();
		this.testReport.logSuccess("Element Present", String.format("Element Present :-<mark>%s</mark>", IntakeAndOutput));
		Map<String, String> obj = new HashMap<String, String>();
		if(IntakeOutput.equalsIgnoreCase("Intake"))
		{
			List<WebElement> Intake = wd.findElements(By.xpath("((//div[contains(@class,'flex-fill')]//div[contains(@class,'content-stretch')]/div[contains(@class,'flex-grow')][2]))"));
			
			ArrayList<String> IntakeOption = new ArrayList<String>();
			ArrayList<String> IntakeValue = new ArrayList<String>();
			for(int i=1;i<=Intake.size();i++)
			{
				IntakeOption.add(wd.findElement(By.xpath(String.format("((//div[contains(@class,'flex-fill')]//div[contains(@class,'content-stretch')]/div[contains(@class,'flex-grow')][2]))[%s]", i))).getText());
				IntakeValue.add(wd.findElement(By.xpath(String.format("((//div[contains(@class,'flex-fill')]//div[contains(@class,'content-stretch')]/div[contains(@class,'flex-grow')][2]))[%s]/preceding-sibling::div", i))).getText());
			}
			String[] Intakes = IntakeOption.toArray(new String[IntakeOption.size()]);
			String[] IntakeValues = IntakeValue.toArray(new String[IntakeValue.size()]);
			this.testReport.logSuccess("Intake Options Present", String.format("Intake Options Present :-<mark>%s</mark>", Intakes.toString()));
			this.testReport.logSuccess("Intake Options Value Present", String.format("Intake Options Value Present :-<mark>%s</mark>", IntakeValues.toString()));
			obj.put(Intakes.toString(), IntakeValues.toString());
			return (HashMap<String, String>) obj;
		}
		if(IntakeOutput.equalsIgnoreCase("Output"))
		{
			List<WebElement> Output = wd.findElements(By.xpath("((//div[contains(@class,'flex-fill')]//div[contains(@class,'content-stretch')]/div[contains(@class,'flex-grow')][4]))"));
			ArrayList<String> OutputOption = new ArrayList<String>();
			ArrayList<String> OutputValue = new ArrayList<String>();
			for(int i=1;i<=Output.size();i++)
			{
				OutputOption.add(wd.findElement(By.xpath(String.format("((//div[contains(@class,'flex-fill')]//div[contains(@class,'content-stretch')]/div[contains(@class,'flex-grow')][2]))[%s]", i))).getText());
				OutputValue.add(wd.findElement(By.xpath(String.format("((//div[contains(@class,'flex-fill')]//div[contains(@class,'content-stretch')]/div[contains(@class,'flex-grow')][2]))[%s]/preceding-sibling::div", i))).getText());
			}
			String[] Outputs = OutputOption.toArray(new String[OutputOption.size()]);
			String[] OutputValues = OutputValue.toArray(new String[OutputValue.size()]);
			this.testReport.logSuccess("Output Options Present", String.format("Output Options Present :-<mark>%s</mark>", Outputs.toString()));
			this.testReport.logSuccess("Output Options Value Present", String.format("Output Options Value Present :-<mark>%s</mark>", OutputValues.toString()));
			obj.put(Outputs.toString(), OutputValues.toString());
			return (HashMap<String, String>) obj;
		}
		return null;
	}
}
