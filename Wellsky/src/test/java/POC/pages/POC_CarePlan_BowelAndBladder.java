package POC.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testreport.IReporter;

import dweb.aut.pages.templates.PageTemplate;

public class POC_CarePlan_BowelAndBladder extends POC_CarePlan_ADLs {

	public POC_CarePlan_BowelAndBladder(WebDriver webDriver, IReporter testReport) {
		super(webDriver, testReport);
		
	}
	
	public By txtContinenceStatus = By.xpath("//span[contains(text(),'Continence Status')]");
	public By txtBowelForm = By.xpath("//span[contains(text(),'Bowel Form')]");
	public By txtSize = By.xpath("//span[contains(text(),'Size')]");
	public By btnEnterNotes = By.xpath("//button[@data-backdrop='static']/img[contains(@src,'EnterNotes')]");
	public By btnCancel = By.xpath("//button[@data-dismiss='modal' and contains(@class,'btn-link')]/img[contains(@src,'Cancel')]");
	public By btnClear = By.xpath("(//button[@title='Clear']//span[text()='Clear'])[1]");
	public By btnColostomyBag = By.xpath("//button[@data-dismiss='modal']/img[@alt='Colostomy Bag']");
	public By btnParticipate = By.xpath("//button[@data-dismiss='modal']/p[text()='Participate']");
	public By btnDidnotParticipate = By.xpath("//button[@data-dismiss='modal']/p[text()=\"Didn't Participate\"]");
	
	
	public ArrayList<String> verifyBowelFirstScreen()
	{
		ArrayList<String> BowelOption = new ArrayList<String>();
		try
		{
			List<WebElement> BowelOptions = wd.findElements(By.xpath("//div[@class='main-screen']//button//p"));
			
			for(int i=1;i<=BowelOptions.size();i++)
			{
				BowelOption.add(wd.findElement(By.xpath(String.format("(//div[@class='main-screen']//button//p)[%s]", i))).getText());
			}
			this.testReport.logSuccess("All Bowel & Bladder Options", String.format("All Bowel & Bladder Options :-<mark>%s</mark>", BowelOption.toString()));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return BowelOption;
	}
	
	public void SelectBetweenBowelAndBladder(String Name)
	{
		try
		{
			By OptionName = By.xpath(String.format("//div[@class='main-screen']//button//p[text()='%s']", Name));
			this.click(OptionName, Name);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public String[] SelectBowelOption(String Name)
	{
		String[] Option =null; 
		try
		{
			List<WebElement> BowelOptions = wd.findElements(By.xpath("//button[contains(@class,'has-hover shadow')]//p[contains(@class,'text-bold')]"));
			ArrayList<String> BowelOption = new ArrayList<String>();
			for(int i=1;i<=BowelOptions.size();i++)
			{
				BowelOption.add(wd.findElement(By.xpath(String.format("(//button[contains(@class,'has-hover shadow')]//p[contains(@class,'text-bold')])[%s]", i))).getText());
			}
			this.testReport.logSuccess("All Options", String.format("All Options :-<mark>%s</mark>", BowelOption.toString()));
			Option = BowelOption.toArray(new String[BowelOption.size()]);
			if(!(Name.equals("")))
			{
				this.waitInSecs(2);
				By OptionName = By.xpath(String.format("//button[contains(@class,'has-hover shadow')]//img[@alt='%s']", Name));
				this.click(OptionName, Name);
			}

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return Option;
	}
	
	public void CancelOpenWindow()
	{
		this.click(btnCancel, "Cancel ");
	}
	
	public void GetTextBowelMovementAfterClicking(String ResidentWithTimeBefore)
	{
		String Text = wd.findElement(By.xpath("//div[contains(@class,'main-screen')]//div//*[text()='Has bowel movement: No']/following-sibling::p[1]")).getText();
		this.testReport.logSuccess(" Bowel Movement", String.format("Bowel Movement :-<mark>%s</mark> after Clicking Text", Text));
		this.waitInSecs(3);
		String ResidentWithTimeText = wd.findElement(By.xpath("//div[contains(@class,'main-screen')]//div//*[text()='Has bowel movement: No']/following-sibling::p[2]")).getText();
		if(ResidentWithTimeText!=ResidentWithTimeBefore)
		{
			this.testReport.logSuccess(" Bowel Movement", String.format("Bowel Movement changed :-<mark>%s</mark> to  :-<mark>%s</mark>", ResidentWithTimeBefore ,ResidentWithTimeText));
		}
		else
		{
			this.testReport.logFailure(" Bowel Movement", String.format("Bowel Movement Remain same :-<mark>%s</mark> to  :-<mark>%s</mark>", ResidentWithTimeBefore ,ResidentWithTimeText));
		}
	}
	
	public String getTextBeforeBowelMovement()
	{
		String Text = wd.findElement(By.xpath("//div[contains(@class,'main-screen')]//div//*[contains(text(),'Has bowel movement')]/following-sibling::p[2]")).getText();
		this.testReport.logSuccess(" Bowel Movement", String.format("Bowel Movement :-<mark>%s</mark> Before Clicking Text", Text));
		return Text ;
	}
	
	public void VerifyButtonsInBMWindow()
	{
		try
		{
			if(this.isElementPresent(txtContinenceStatus) )
			{
				this.VerifyWebElementPresent(txtContinenceStatus, "Continence Status");	
			}
			if(this.isElementPresent(txtBowelForm) && this.isElementPresent(txtSize))
			{
				this.VerifyWebElementPresent(txtBowelForm, "Bowel Form");		
				this.VerifyWebElementPresent(txtSize, "Size");
			}
			if(this.isElementPresent(btnColostomyBag))
			{
				this.VerifyWebElementPresent(btnColostomyBag, "Colostomy Bag");
			}
			if(this.isElementPresent(btnParticipate) && this.isElementPresent(btnDidnotParticipate))
			{
				this.VerifyWebElementPresent(btnParticipate, "Participate");		
				this.VerifyWebElementPresent(btnDidnotParticipate, "Didn't Participate");				
			}
		}
		catch(Exception ex)
		{
			
		}
	}
	
	public void ComponentsInBMWindow()
	{
		try
		{
		this.WaitForElementPresent(btnEnterNotes,10, "Enter Notes ");
		this.VerifyWebElementPresent(btnEnterNotes, "Enter Notes ");
		this.VerifyWebElementPresent(btnCancel, "Cancel ");
		this.click(btnEnterNotes, "Enter Notes ");
		}
		catch(Exception ex)
		{
			
		}
	}
	
	public String WrittingTextInNotes(String text) 
	{
		this.waitInSecs(5);
		this.click(btnClear, "Clear");
		
		int size = text.length();
		char aa[]=new char[size];
		int i=0;
		for(i=0;i<size;i++)
		{
			aa[i]=text.charAt(i);
			char a = aa[i];
			String Number = Character.toString(a);
			//this.click(By.xpath(String.format("//div[contains(@class,'modal-body')]//button//span[text()='%s']",Number)), Number);
			//this.click(By.xpath(String.format("//button//span[text()='%s']",Number)), Number);
			this.click(By.xpath("(//*[@data-v-keyboard-language='en']//textarea)[1]"), "Keypad Text");
			this.waitInSecs(1);
		}
		return text;
	}
	
	public void ValidateEnterNoteText(String text,String HeightWeight)
	{
		String Text = null;
		this.waitInSecs(2);
		List<WebElement> EnterText = wd.findElements(By.xpath("//div[contains(text(),'Enter')]")) ;
		if(EnterText.size()>0)
		{
			Text = wd.findElement(By.xpath(String.format("//div[contains(text(),'%s')]/..//..//p[contains(@class,'text-dark kb-notes')]",HeightWeight))).getText();
		}
		else
		{
			Text = wd.findElement(By.xpath("//*[contains(@class,'text-dark kb-notes')]")).getText();
		}
		if(Text.equalsIgnoreCase(text))
		{
			this.testReport.logSuccess("Text Validate", "<mark>Text Validate properly</mark>");
		}
		else
		{
			this.testReport.logFailure("Text Validate", "<mark>Text not Validate properly</mark>");
		}
	}
	
	public String[] SelectOptionsFromBM(String Continence , String BowelForm , String Size)
	{
		String[] Options = {BowelForm ,Size};
		try
		{
			List<WebElement> BMOptions = wd.findElements(By.xpath("//button[contains(@class,'text-left shadow')]//img"));
			ArrayList<String> BMOption = new ArrayList<String>();
			for(int i=1;i<=BMOptions.size();i++)
			{
				BMOption.add(wd.findElement(By.xpath(String.format("(//button[contains(@class,'text-left shadow')]//img)[%s]", i))).getAttribute("alt"));
			}
			this.testReport.logSuccess("All Bowel Options", String.format("All Bowel Options :-<mark>%s</mark>", BMOption.toString()));

			By continence = By.xpath(String.format("//button[contains(@class,'text-left shadow')]//img[@alt='%s']", Continence));
			if(this.isElementPresent(continence))
			{
				this.click(continence, Continence);
			}

			By bowelForm = By.xpath(String.format("//button[contains(@class,'text-left shadow') and @is-disabled='false']//img[@alt='%s']", BowelForm));
			if(this.isElementPresent(bowelForm))
			{
				this.click(bowelForm, BowelForm);
			}

			By size = By.xpath(String.format("//button[contains(@class,'text-left shadow') and @is-disabled='false']//img[@alt='%s']", Size));
			if(this.isElementPresent(size))
			{
				this.click(size, Size);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return Options;
	}
	
	public void VerifyBowelMovementAfterSelectingBM(String BowelForm , String Size)
	{
		try
		{
			this.waitInSecs(5);
			String Text = wd.findElement(By.xpath("//div[contains(@class,'main-screen')]//div//*[contains(text(),'Has bowel movement')]/following-sibling::p[1]")).getText();
			String MovementText = BowelForm +", "+Size;
			if(MovementText.equalsIgnoreCase(Text))
			{
				this.testReport.logSuccess("Text Changed After Selecting BM", String.format("Bowel Movement Text :- <mark>%s</mark> remain same with :- <mark>%s</mark>", Text,MovementText));
			}
			else
			{
				this.testReport.logFailure("Text Changed After Selecting BM", String.format("Bowel Movement Text :- <mark>%s</mark> not remain same with :- <mark>%s</mark>", Text,MovementText));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public String SelectColostomyBagFromAppliance()
	{
		String ColostomyBag = wd.findElement(By.xpath("//button[@data-dismiss='modal']/img[contains(@src,'QuestionMark')]")).getAttribute("alt");
		this.click(btnColostomyBag, ColostomyBag);
		return ColostomyBag;		
	}
	
	public String SelectionFromTraining()
	{
		String SelectedOption = wd.findElement(By.xpath("//button[@data-dismiss='modal']/img[contains(@src,'Independant')]/following-sibling::*")).getText();
		this.click(btnParticipate, SelectedOption);
		return SelectedOption;		
	}
	
	public void VerifyApplianceAfterSelection(String BowelOption ,String ApplianceTEXT)
	{
		String ApplianceText = wd.findElement(By.xpath(String.format("//*[contains(text(),'%s')]//preceding-sibling::div/p[contains(@class,'center')]",BowelOption))).getText();
		if(ApplianceText.contains(ApplianceTEXT))
		{
			this.testReport.logSuccess("Appliance Text Verification", String.format("Appliance Text :- <mark>%s</mark>  remain same with Selection :- <mark>%s</mark>", ApplianceText,ApplianceTEXT));
		}
		else if(ApplianceTEXT.contains(ApplianceText))
		{
			this.testReport.logSuccess("Appliance Text Verification", String.format("Appliance Text :- <mark>%s</mark>  remain same with Selection :- <mark>%s</mark>", ApplianceText,ApplianceTEXT));
		}
		else
		{
			this.testReport.logFailure("Appliance Text Verification", String.format("Appliance Text :- <mark>%s</mark> not remain same with Selection :- <mark>%s</mark>", ApplianceText,ApplianceTEXT));
		}
	}
	
	public String VerifyBladderAppliance(String SelectAppliance)
	{
		try
		{
			this.waitInSecs(4);
			List<WebElement> Appliance = wd.findElements(By.xpath("//button[@data-dismiss='modal']//img[contains(@src,'QuestionMark')]"));
			ArrayList<String> ApplianceOption = new ArrayList<String>();
			for(int i=1;i<=Appliance.size();i++)
			{
				ApplianceOption.add(wd.findElement(By.xpath(String.format("(//button[@data-dismiss='modal']//img[contains(@src,'QuestionMark')])[%s]", i))).getAttribute("alt"));
			}
			this.testReport.logSuccess("All Appliance Options", String.format("All Appliance Options :-<mark>%s</mark>", ApplianceOption.toString()));

			By appliance = By.xpath(String.format("//button[@data-dismiss='modal']//img[contains(@alt,'%s')]", SelectAppliance));
			this.click(appliance, SelectAppliance);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return SelectAppliance;
	}

}
