package POC.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testreport.IReporter;

import dweb.aut.pages.templates.PageTemplate;

public class POC_CarePlan_HeightAndWeight extends PageTemplate {

	public POC_CarePlan_HeightAndWeight(WebDriver webDriver, IReporter testReport) {
		super(webDriver, testReport);
	}

	public By txtLatestHeightAndWeight = By.xpath("//div[@class='main-screen']/div[contains(@class,'border')]/div");
	By btnSubmenu = By.xpath("//button[@aria-expanded='true']/img[contains(@src,'SubMenu')]");
	By btnOutOfFacility = By.xpath("(//button/img[contains(@src,'ADLSubMenu')])[2]");
	
	public String[] VerifyHeightAndWeightWindowDetails(String Option)
	{
		String[] HeightAndWeight= null;
		try
		{
			
			this.waitUntilElementIsVisible(txtLatestHeightAndWeight);
			this.VerifyWebElementPresent(txtLatestHeightAndWeight, "Latest Height And Weight");
			this.waitInSecs(3);
			String HeightWeight = wd.findElement(By.xpath(String.format("//img[@alt='%s']/../following-sibling::div[1]/p[contains(@class,'bold')]",Option))).getText();
			String HeightWeightDate = wd.findElement(By.xpath(String.format("//img[@alt='%s']/../following-sibling::div[1]/p[2]",Option))).getText();
			this.testReport.logSuccess("Height With Date & Weight with Date", String.format("Height or Weight:-<mark>%s</mark> With Value :-<mark>%s</mark> & Date :-<mark>%s</mark>",Option,HeightWeight,HeightWeightDate ));
			ArrayList<String> heightWeight = new ArrayList<String>();
			heightWeight.add(HeightWeight);
			heightWeight.add(HeightWeightDate);			
			HeightAndWeight = heightWeight.toArray(new String[heightWeight.size()]);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return HeightAndWeight;
	}
	
	public String VerifyHeightAndWeightAfterSelection(String option , String DateValue)
	{
		this.waitInSecs(20);		
		String Value =  wd.findElement(By.xpath(String.format("//img[@alt='%s']/../following-sibling::div[1]/p[2]",option))).getText();
		if(!option.equalsIgnoreCase("Height"))
		{
			this.testReport.logSuccess("Height With Date & Weight with Date", String.format("Changed Height And Weight Reflected From :-<mark>%s</mark> to <mark>%s</mark>", DateValue,Value));
			/*if(!DateValue.equalsIgnoreCase(Value))
			{
				this.testReport.logSuccess("Height With Date & Weight with Date", String.format("Changed Height And Weight Reflected From :-<mark>%s</mark> to <mark>%s</mark>", DateValue,Value));
			}
			else
			{
				this.testReport.logFailure("Height With Date & Weight with Date", String.format("Changed Height And Weight not Reflected From :-<mark>%s</mark> to <mark>%s</mark>", DateValue,Value));
			}*/
		}
		return Value;
	}
	
	public void SelectOutOfFacility()
	{
		
		/*this.VerifyWebElementPresent(btnSubmenu, "Sub Menu");
		this.click(btnSubmenu, "Sub Menu");*/
		
		List<WebElement> SubMenu = wd.findElements(By.xpath("//button/img[contains(@src,'/SubMenu')]"));
		for(int i=1;i<=SubMenu.size();i++)
		{
			boolean isVisible = wd.findElement(By.xpath(String.format("(//button/img[contains(@src,'/SubMenu')])[%s]", i))).isDisplayed();
			if(isVisible)
			{
			this.click(By.xpath(String.format("(//button/img[contains(@src,'/SubMenu')])[%s]", i)), "Sub Menu");
			}
		}		
		List<WebElement> OutOfFacility = wd.findElements(By.xpath("(//button/img[contains(@src,'ADLSubMenu')])"));
		for(int i=1;i<=OutOfFacility.size();i++)
		{
			boolean isVisible = wd.findElement(By.xpath(String.format("(//button/img[contains(@src,'ADLSubMenu')])[%s]", i))).isDisplayed();
			if(isVisible)
			{			
			this.click(By.xpath(String.format("(//button/img[contains(@src,'ADLSubMenu')])[%s]", i)), "Out Of Facility");
			}
		}
		/*this.VerifyWebElementPresent(btnOutOfFacility, "Out Of Facility");
		this.click(btnOutOfFacility, "Out Of Facility");*/
		this.waitInSecs(2);
		
	}
	
	public void EnterOptionsForWeight(String... option)
	{
		List<WebElement> AllOption = wd.findElements(By.xpath("//button[contains(@class,'text-left shadow')]//span"));
		ArrayList<String> Option = new ArrayList<String>();
		for(int i=1;i<=AllOption.size();i++)
		{
			Option.add(wd.findElement(By.xpath(String.format("(//button[contains(@class,'text-left shadow')]//span)[%s]",i))).getText());
		}
		this.testReport.logSuccess("All Options Presented Under Weight", String.format("All Options Presented Under Weight :-<mark>%s</mark>", Option.toString()));
		
		/*By addAppliance = By.xpath(String.format("//button[contains(@class,'text-left shadow')]//span[text()='%s']", AddAppliance));
		this.click(addAppliance, AddAppliance);
		this.waitInSecs(2);
		By enterOption = By.xpath(String.format("//button[contains(@class,'text-left shadow')]//span[text()='%s']", EnterOption));
		this.click(enterOption, EnterOption);
		this.waitInSecs(2);*/
		
		int Size = option.length;
		for(int i=0; i<=(Size-1);i++)
		{
			String OPTION= option[i];
			By addAppliance = By.xpath(String.format("//button[contains(@class,'text-left shadow')]//span[text()='%s']", OPTION));
			this.click(addAppliance, OPTION);
			this.waitInSecs(2);
		}
	}
	
	
}
