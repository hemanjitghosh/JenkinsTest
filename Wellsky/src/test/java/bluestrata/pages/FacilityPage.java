package bluestrata.pages;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.testreport.IReporter;



public class FacilityPage extends PhysicianPortalPage {

	public FacilityPage(WebDriver webDriver, IReporter testReport) {
		super(webDriver, testReport);
		// TODO Auto-generated constructor stub
	}

	
	public By btnMaintenance = By.xpath("//button[text()='Maintenance']");
	public By btnManageOrderSets = By.xpath("//button[text()='Manage Order Sets']");
	public By btnManageOrderLibrary = By.xpath("//button[text()='Manage Order Library']");
	public By btnCreateAnOrderSet = By.xpath("//button[text()='Create an Order Set']");
	public By txtDescription = By.xpath("(//label[text()='Description']/..//textarea[@id='description'])");
	public By txtDetailDescription = By.xpath("(//label[text()='Description']/..//input[@id='description'])");
	public By btnAddOrder = By.xpath("//button[text()='Add Order']");
	public By txtOrdersInSets = By.xpath("//div[@class='card']//*[text()='Orders in the set']");
	public By txtOrderTemplateFilterByType = By.xpath("//button[@id='typeDropDown']");
	public By txtLibraryItemSaved = By.xpath("//div[@class='Library Item Saved']") ;
	public By txtLibraryItemRemoved = By.xpath("//div[@class='Library Item Removed']") ;
	
	
	public void ManageOrdersSets() throws InterruptedException
	{
		if(this.isElementPresent(btnMaintenance))
		{
		this.VerifyWebElementPresent(btnMaintenance, "Maintenance");
		this.click(btnMaintenance, "Maintenance");
	    }
		if(this.isElementPresent(btnManageOrderSets))
		{
		this.VerifyWebElementPresent(btnManageOrderSets, "Manage Order Sets");
		this.VerifyWebElementPresent(btnManageOrderLibrary, "Manage Order Library");
		this.click(btnManageOrderSets, "Manage Order Sets");
		}
		if(this.isElementPresent(btnCreateAnOrderSet))
		{
		this.VerifyWebElementPresent(btnCreateAnOrderSet, "Create an Order Set");
		
		List<WebElement> Description = wd.findElements(By.xpath("//datatable-body-row//datatable-body-cell[1]//span"));
		int TotalDescriptionNo = Description.size();
		ArrayList<String> description = new ArrayList<String>();
		this.testReport.logSuccess("Total Number of Created Order ",String.format("Number of Created Order Present in the List - <mark>%s</mark> ", TotalDescriptionNo));
		for (int i=1;i<=TotalDescriptionNo;i++)
		{
			/*String DescriptionName = wd.findElement(By.xpath(String.format("(//div[@class='list-group']//a//div/h5)[%s]",i))).getAttribute("innerHTML");
			this.testReport.logSuccess("Created Order ",String.format("Created Order Present in the List - <mark>%s</mark> ", DescriptionName));*/
			
			description.add(wd.findElement(By.xpath(String.format("(//datatable-body-row//datatable-body-cell[1]//span)[%s]",i))).getAttribute("innerHTML"));
			
			
		}
		
		description.toString();
		this.testReport.logSuccess("Created Order ",String.format("Created Order Present in the List - <mark>%s</mark> ", description.toString()));
		
		this.click(btnCreateAnOrderSet,"Create an Order Set");
		Thread.sleep(3000);
		}
	}
	
	public void DeleteCreatedOrders()
	{
		if(this.isElementPresent(btnMaintenance))
		{
			this.VerifyWebElementPresent(btnMaintenance, "Maintenance");
			this.click(btnMaintenance, "Maintenance");
		}
		if(this.isElementPresent(btnManageOrderSets))
		{
			this.VerifyWebElementPresent(btnManageOrderSets, "Manage Order Sets");
			this.VerifyWebElementPresent(btnManageOrderLibrary, "Manage Order Library");
			this.click(btnManageOrderSets, "Manage Order Sets");
		}
		
		List<WebElement> RemoveButton = wd.findElements(By.xpath("//button[text()='Remove']"));
		int RemoveButtonCount = RemoveButton.size();
		for(int i=1;i<=RemoveButtonCount-30;i++)
		{
			By removeButton = By.xpath(String.format("(//button[text()='Remove'])[%s]",i));
			this.click(removeButton, "Remove");
			By OkButton = By.xpath("//button[text()='Ok']");
			this.click(OkButton, "Ok");
			this.waitInSecs(2);
		}

	}
	
	
	
	public void HourWiseFrequencyFacilityPage(int frequencyNum , String frequency,String startingTime)
	{
		int newfrequencyNum = frequencyNum-1;
		By drpdwnFrequency = By.xpath(String.format("(//label[text()='Frequency']/..//select[@id='typeOrderFrequencyId'])[%d]", newfrequencyNum));			
		this.SelectDropDownByText(drpdwnFrequency, frequency); 
		
		By startingAt = By.xpath(String.format("((//div[@class='card'])[%d]//label[text()='Times']/..//input[@placeholder='hh:mm ampm'])",frequencyNum));
	    this.SendKeysToElementClearFirst(startingAt, startingTime);	
		this.waitInSecs(2);		
		By doseTimings = By.xpath(String.format("(//div[@class='card'])[%d]//label[text()='with the last dose at ']/../..//select[contains(@class,'form-control')]",frequencyNum));
	
		List<WebElement> NoOfTimings = wd.findElements(By.xpath(String.format("(//div[@class='card'])[%d]//label[text()='with the last dose at ']/../..//select[contains(@class,'form-control')]/option",frequencyNum)));
		int frequencyNoOfTimings = NoOfTimings.size();
		System.out.println("Total No of Timings in a Frequency : " + frequencyNoOfTimings);

		this.SelectDropDownByIndex(doseTimings, 0);
		
		
	
	}
	
	public void VerifyAndClickManageOrderLibrary()
	{
		if(this.isElementPresent(btnMaintenance))
		{
		this.VerifyWebElementPresent(btnMaintenance, "Maintenance");
		this.click(btnMaintenance, "Maintenance");
	    }
		if(this.isElementPresent(btnManageOrderSets))
		{
		this.VerifyWebElementPresent(btnManageOrderSets, "Manage Order Sets");
		this.VerifyWebElementPresent(btnManageOrderLibrary, "Manage Order Library");
		this.click(btnManageOrderLibrary,"");
		}
	}
	
	public ArrayList<String> VerifyOrderTemplate(String description)
	{
		this.VerifyWebElementPresent(txtOrderTemplateFilterByType, "Order Template Filter By Type");
		this.click(txtOrderTemplateFilterByType, "Order Template Filter By Type");
		List<WebElement> types = wd.findElements(By.xpath("//button[@id='typeDropDown']//following-sibling::div/button"));
		int SizeNo = types.size();
		ArrayList<String> obj = new ArrayList<String>();
		
		for(int i=1;i<=SizeNo;i++)
		{
			//wd.findElement(By.xpath(String.format("(//button[@id='typeDropDown']//following-sibling::div/button)[%s]",i))).getText();
			obj.add(wd.findElement(By.xpath(String.format("(//button[@id='typeDropDown']//following-sibling::div/button)[%s]",i))).getText());
			
		}
		
		obj.toString();
		this.testReport.logSuccess("Order Type ",String.format(" Order Type Present in the List - <mark>%s</mark> ", obj.toString()));
		
		
		
		for(int i=1;i<=SizeNo;i++)
		{
			String type = wd.findElement(By.xpath(String.format("(//button[@id='typeDropDown']//following-sibling::div/button)[%s]",i))).getText();
			
			By Typebutton = By.xpath(String.format("(//button[@id='typeDropDown']//following-sibling::div/button)[%s]",i));
			
			this.click(Typebutton, "Type Clicked");
			this.waitInSecs(4);
			List<WebElement> Orderdecription = wd.findElements(By.xpath("//datatable-body-cell//input"));
			List<WebElement> OrderUpdate = wd.findElements(By.xpath("//button[text()='Update']"));
			List<WebElement> OrderRemove = wd.findElements(By.xpath("//button[text()='Remove']"));
			
			int decriptionNo = Orderdecription.size();
			ArrayList<String> Options =new ArrayList<String>();
			int UpdateNo = OrderUpdate.size();
			int RemoveNo = OrderRemove.size();
			
			/*for(int j=1;j<=decriptionNo;j++)
			{
				Options.add(wd.findElement(By.xpath(String.format("(//datatable-body-cell//input[contains(@class,touched)])[%s]",j))).getText());
				Options.toString();
			}
			
			this.testReport.logSuccess("Description ",String.format(" Description Present in the List - <mark>%s</mark> ", Options.toString()));
			*/
			this.testReport.logSuccess("Order Type ",String.format("No of Description : <mark>%s</mark> , No of Update Button : <mark>%s</mark> , No of Remove Button : <mark>%s</mark> in Order Type: <mark>%s</mark>  ",decriptionNo,UpdateNo,RemoveNo, type ));
			
			//every time we will Edit The First Description 
			
			By FirstDescription = By.xpath("(//datatable-body-cell//input[contains(@class,touched)])[1]");
			this.SendKeysToElementClearFirst(FirstDescription, description);
			By UpadteButton = By.xpath("(//button[text()='Update'])[1]");
			this.click(UpadteButton, "Upadte Button");
		
			/*this.VerifyWebElementPresent(txtLibraryItemSaved, "Library Item Saved");
			this.waitInSecs(2);*/
			
			this.click(txtOrderTemplateFilterByType, "Order Template Filter By Type");
			
			
		}
		
		
		
		
		return(obj) ;
		
	}

	
	public void RemoveDescriptionInOrderTemplate(String description)
	{
		this.VerifyWebElementPresent(txtOrderTemplateFilterByType, "Order Template Filter By Type");
		this.click(txtOrderTemplateFilterByType, "Order Template Filter By Type");
		List<WebElement> types = wd.findElements(By.xpath("//button[@id='typeDropDown']//following-sibling::div/button"));
		int SizeNo = types.size();
		ArrayList<String> obj = new ArrayList<String>();

		for(int i=1;i<=SizeNo;i++)
		{
			
			By Typebutton = By.xpath(String.format("(//button[@id='typeDropDown']//following-sibling::div/button)[%s]",i));

			this.click(Typebutton, "Type Clicked");
			this.waitInSecs(4);
			
			By RemoveButton = By.xpath("(//datatable-body-cell//input)[1]/..//..//following-sibling::datatable-body-cell//button[text()='Remove']");
			this.click(RemoveButton, "Order Template Remove Button");
			
			

			/*List<WebElement> Orderdecription = wd.findElements(By.xpath("//datatable-body-cell//input"));
			int decriptionNo = Orderdecription.size();

			for(int j=1;j<=decriptionNo;j++)
			{

				String Description = wd.findElement(By.xpath(String.format("(//datatable-body-cell//input[contains(@class,'control')])[%s]",j))).getAttribute("innerHTML");
				if(description.equals(Description))
				{
					By RemoveButton = By.xpath(String.format("//datatable-body-cell//input[@ng-reflect-model='%s']/..//..//following-sibling::datatable-body-cell//button[text()='Remove']",Description));
					this.click(RemoveButton, "Order Template Remove Button");
					this.VerifyWebElementPresent(txtLibraryItemRemoved, "Library Item Removed");
					this.waitInSecs(2);
				}
				if(description.equals(Description))
				{
					break;
				}

			}*/
		}

	}
	
	
	
	
	public void CreateOrderSet()
	{
		if(this.isElementPresent(btnCreateAnOrderSet))
		{
		this.click(btnCreateAnOrderSet,"Create an Order Set");
		}
	}
	
	
	public void CreateOrderSetDescription(String description, String type , String routes , String libraryText)
	{
		this.VerifyWebElementPresent(txtDescription, "Description");
		this.SendKeysToElementClearFirst(txtDescription,description);
		
		this.waitUntilElementIsVisible(txtOrderType);
		
		List<WebElement> types = wd.findElements(By.xpath("//select[@id='settingOrderTypeId']/option[contains(@value,':')]"));
		int typeCount = types.size();
		this.testReport.logSuccess("Total Number of Order Type  ",String.format("Number of Order Type Present in the List - <mark>%s</mark> ", typeCount));
		for(int i=1;i<=typeCount;i++)
		{
			String TypeName = wd.findElement(By.xpath(String.format("(//select[@id='settingOrderTypeId']/option[contains(@value,':')])[%s]",i))).getAttribute("innerHTML");
			this.testReport.logSuccess("Order Type ",String.format(" Order Type Present in the List - <mark>%s</mark> ", TypeName));
			
		}
		
		this.SelectDropDownByText(txtOrderType, type);
		
		if(type.equals("Medication") || type.equals("Treatment With Medication"))
		{
			this.VerifyWebElementPresent(linkSearchMedications,"Search Medications");
			this.VerifyWebElementPresent(linkFreeForm, "Free Form");
			this.click(linkSearchMedications,"Search Medications");
			this.waitInSecs(2);
			this.sendKeys(txtSearchMedicineName,"Amox");
			this.waitInSecs(2);
			this.click(btnSearchDiogonosis,"Search Medication");         
			By medicineName = By.xpath(String.format("//datatable-body-cell//span[text()='%s']", libraryText));
			//String MedicineName = wd.findElement(By.xpath(String.format("//datatable-scroller[@class='datatable-scroll ng-star-inserted']//span[text()='%s']", libraryText))).getText();
			this.WaitForElementPresent(medicineName, 60, "Medicine Name");
			this.click(medicineName, "Medicine");
			this.click(linkFreeForm, "Free Form");
			this.VerifyWebElementPresent(warningMessage,"Drug interactions will not be available on orders with free form drug names.");
			/*String Medicine = wd.findElement(By.xpath("//div[@class='alert alert-warning']/input[@id='description']")).getText();
			Assert.assertEquals(MedicineName, Medicine);*/
 			this.VerifyWebElementPresent(btnUseDrugDatabase,"Use Drug Database");
			/*this.VerifyWebElementNotPresent(linkSearchMedications,"Search Medications");
			this.VerifyWebElementNotPresent(linkFreeForm, "Free Form");*/
			this.click(btnUseDrugDatabase,"Use Drug Database");
			this.waitInSecs(2);
			this.VerifyWebElementPresent(linkSearchMedications,"Search Medications");
			this.VerifyWebElementPresent(linkFreeForm, "Free Form");
			/*this.VerifyWebElementNotPresent(btnUseDrugDatabase,"Use Drug Database");*/
			
			this.waitInSecs(2);
			this.SelectDropDownByText(drpDwnroutes, routes);
			
		}
		else
		{
		this.VerifyWebElementPresent(txtDetailDescription, " Detail Description");
		this.SendKeysToElementClearFirst(txtDetailDescription,description);
		}
		
	}
	
	public void VerifyManageOrderFromSets(String description)
	{
		//By Description = By.xpath(String.format("//div[@class='list-group']//a//div/h5[text()='%s']", description));
		By Description = By.xpath(String.format("//datatable-body-cell//div//span[text()='%s']", description));
		this.waitInSecs(5);
		this.waitUntilElementIsVisible(Description);
		this.VerifyWebElementPresent(Description, "Created order present in Existing Set");
	}
	
	public void AddOder()
	{
		this.VerifyWebElementPresent(btnAddOrder, "AddOrder");
		this.click(btnAddOrder, "AddOrder");
	}
	
	public void VerifyTheFieldsAfterClickingOnTheCreateOrderSetsButton()
	{
		this.VerifyWebElementPresent(txtDescription, "Description");
		this.VerifyWebElementPresent(txtOrdersInSets, "Orders in the set");
		this.VerifyWebElementPresent(btnAddOrder, "Add Order");
		this.VerifyWebElementPresent(btnSaveOrder, "Save button");
		this.VerifyWebElementPresent(btnCancel, "Cancel button");
		this.VerifyWebElementPresent(txtOrderType, "Type List box");
		this.VerifyWebElementPresent(btnAddFrequency, "Add frequency Button");
	}
	
	
	public void VerifyButtonsinVerifyFields()
	{
		this.VerifyWebElementPresent(btnAddFrequency, "Add Frequency");
		
		 List<WebElement> btnRemoveFrequency = wd.findElements(By.xpath("//div[@class='card-header']/..//button[text()='Remove Frequency']"));
		 int countBtnRemoveFrequency = btnRemoveFrequency.size();
		 
		 for(int i=1;i<=countBtnRemoveFrequency;i++)
		 {
		 By btnRemvFrequency = By.xpath(String.format("(//div[@class='card-header']/..//button[text()='Remove Frequency'])[%s]",i));
			 
		this.VerifyWebElementPresent(btnRemvFrequency, "Remove Frequency");
		 }
		 
		 this.click(btnAddOrder, "Add Order");
	}
	
	
	public void ClickingTheCreatedOrderFromSets(String description)
	{
		//By Description = By.xpath(String.format("//div[@class='list-group']//a//div/h5[text()='%s']", description));
		By Description = By.xpath(String.format("//datatable-body-cell//span[text()='%s']", description));
		this.waitUntilElementIsVisible(Description);
		this.click(Description, "Created order present in Existing Set");
	}
	
}
