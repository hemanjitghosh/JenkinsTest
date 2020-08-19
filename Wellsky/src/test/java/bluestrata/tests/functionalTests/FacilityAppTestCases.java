package bluestrata.tests.functionalTests;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.excel.Xls_Reader;

import bluestrata.pages.EmarPage;
import bluestrata.pages.FacilityPage;
import bluestrata.pages.HomePage;
import bluestrata.pages.LoginPage;
import bluestrata.pages.PhysicianPortalPage;
import dweb.test.templates.TestTemplate;
import dweb.test.templates.TestTemplateMethodLevelInit;

public class FacilityAppTestCases extends TestTemplateMethodLevelInit {


	//Xls_Reader xlsReader = new Xls_Reader("C:\\Bluestrata\\Abhishek-Project-s\\src\\test\\resources\\testdata\\BluestrataTestData.xlsx");
	Xls_Reader xlsReader = new Xls_Reader("C:\\Users\\hemanjitg\\Desktop\\BlueStrata\\LTC-AutomatedTests\\src\\test\\resources\\testdata\\BluestrataTestData.xlsx");
	final String SheetName = "facilityPortal";

	@Test()
	public void QA037_CreateAnOrderSetsviaFacilityAppfor_DetailsType(ITestContext testContext) throws InterruptedException
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);


		/*String description = xlsReader.getCellData("facilityPortal", 0, 3)+physicianPortal.GenarateRandomNumber();
		String type = xlsReader.getCellData("facilityPortal", 1, 3);
		String routes = xlsReader.getCellData("facilityPortal", 2, 3);
		String libraryText = xlsReader.getCellData("facilityPortal", 3, 3);*/
		final String testCase = "QA037";

		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);

		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 

		homepage.NavigateToFacilityPortal();
		facilityPage.ManageOrdersSets();
		facilityPage.VerifyTheFieldsAfterClickingOnTheCreateOrderSetsButton();
		facilityPage.CreateOrderSetDescription(testdata.get("description")+physicianPortal.GenarateRandomNumber(),testdata.get("type"),testdata.get("routes"),testdata.get("libraryText"));
		facilityPage.VerifyButtonsinVerifyFields();
		login.Logout();
	}

	@Test()
	public void QA038_AddingFrequencyInNewlyCreatedOrderSetsViaFacilityAppFor_DetailsType_WithFrequencyType_Routine(ITestContext testContext) throws InterruptedException
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);


		final String testCase = "QA038";
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);

		String Order = testdata.get("description")+physicianPortal.GenarateRandomNumber();
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 


		homepage.NavigateToFacilityPortal();
		facilityPage.ManageOrdersSets();
		facilityPage.CreateOrderSetDescription(Order+testdata.get("type1"),testdata.get("type1"),testdata.get("routes"),testdata.get("libraryText"));
		physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType"));		
		physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
		physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num")),testdata.get("frequency"));
		physicianPortal.HowOftenDailyType(Integer.parseInt(testdata.get("num")),testdata.get("howOften"),testdata.get("everyDay"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),testdata.get("type1"));
		//facilityPage.VerifyButtonsinVerifyFields();
		physicianPortal.SaveOrderFrequency();
		facilityPage.VerifyManageOrderFromSets(Order+testdata.get("type1"));

		facilityPage.CreateOrderSet();
		facilityPage.CreateOrderSetDescription(Order+testdata.get("type2"),testdata.get("type2"),testdata.get("routes"),testdata.get("libraryText"));
		physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType"));		
		physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
		physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num")),testdata.get("frequency"));
		physicianPortal.HowOftenDailyType(Integer.parseInt(testdata.get("num")),testdata.get("howOften"),testdata.get("everyDay"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),testdata.get("type2"));
		//facilityPage.VerifyButtonsinVerifyFields();
		physicianPortal.SaveOrderFrequency();
		facilityPage.VerifyManageOrderFromSets(Order+testdata.get("type2"));
		/*
		facilityPage.CreateOrderSet();
		facilityPage.CreateOrderSetDescription(Order+testdata.get("type3"),testdata.get("type3"),testdata.get("routes"),testdata.get("libraryText"));
		physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType"));		
		physicianPortal.RequireActionRelatedLabel((Integer.parseInt(testdata.get("num"))+1),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
		physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num")),testdata.get("frequency"));
		physicianPortal.HowOftenDailyType(Integer.parseInt(testdata.get("num")),testdata.get("howOften"),testdata.get("everyDay"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),testdata.get("type3"));
		//facilityPage.VerifyButtonsinVerifyFields();
		physicianPortal.SaveOrderFrequency();
		facilityPage.VerifyManageOrderFromSets(Order+testdata.get("type3"));


		facilityPage.CreateOrderSet();
		facilityPage.CreateOrderSetDescription(Order+testdata.get("type4"),testdata.get("type4"),testdata.get("routes"),testdata.get("libraryText"));
		physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType"));		
		physicianPortal.RequireActionRelatedLabel((Integer.parseInt(testdata.get("num"))+1),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
		physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num")),testdata.get("frequency"));
		physicianPortal.HowOftenDailyType(Integer.parseInt(testdata.get("num")),testdata.get("howOften"),testdata.get("everyDay"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),testdata.get("type4"));
		//facilityPage.VerifyButtonsinVerifyFields();
		physicianPortal.SaveOrderFrequency();
		facilityPage.VerifyManageOrderFromSets(Order+testdata.get("type4"));


		facilityPage.CreateOrderSet();
		facilityPage.CreateOrderSetDescription(Order+testdata.get("type5"),testdata.get("type5"),testdata.get("routes"),testdata.get("libraryText"));
		physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType"));		
		physicianPortal.RequireActionRelatedLabel((Integer.parseInt(testdata.get("num"))+1),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
		physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num")),testdata.get("frequency"));
		physicianPortal.HowOftenDailyType(Integer.parseInt(testdata.get("num")),testdata.get("howOften"),testdata.get("everyDay"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),testdata.get("type5"));
		//facilityPage.VerifyButtonsinVerifyFields();
		physicianPortal.SaveOrderFrequency();
		facilityPage.VerifyManageOrderFromSets(Order+testdata.get("type5"));


		facilityPage.CreateOrderSet();
		facilityPage.CreateOrderSetDescription(Order+testdata.get("type6"),testdata.get("type6"),testdata.get("routes"),testdata.get("libraryText"));
		physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType"));		
		physicianPortal.RequireActionRelatedLabel((Integer.parseInt(testdata.get("num"))+1),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
		physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num")),testdata.get("frequency"));
		physicianPortal.HowOftenDailyType(Integer.parseInt(testdata.get("num")),testdata.get("howOften"),testdata.get("everyDay"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),testdata.get("type6"));
		//facilityPage.VerifyButtonsinVerifyFields();
		physicianPortal.SaveOrderFrequency();
		facilityPage.VerifyManageOrderFromSets(Order+testdata.get("type6"));


		facilityPage.CreateOrderSet();
		facilityPage.CreateOrderSetDescription(Order+testdata.get("type7"),testdata.get("type7"),testdata.get("routes"),testdata.get("libraryText"));
		physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType"));		
		physicianPortal.RequireActionRelatedLabel((Integer.parseInt(testdata.get("num"))+1),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
		physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num")),testdata.get("frequency"));
		physicianPortal.HowOftenDailyType(Integer.parseInt(testdata.get("num")),testdata.get("howOften"),testdata.get("everyDay"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),testdata.get("type7"));
		//facilityPage.VerifyButtonsinVerifyFields();
		physicianPortal.SaveOrderFrequency();
		facilityPage.VerifyManageOrderFromSets(Order+testdata.get("type7"));*/

		login.Logout();



	}


	@Test()
	public void QA039_FrequencyFieldSelection_WithFrequencyType_Routine(ITestContext testContext) throws InterruptedException
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);

		final String testCase = "QA039";
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 


		homepage.NavigateToFacilityPortal();
		facilityPage.ManageOrdersSets();
		int count=0;
		String[] typeArray= {testdata.get("type1"),testdata.get("type2"),testdata.get("type4")};
//		/,testdata.get("type5"),testdata.get("type6"),testdata.get("type7")
		int numberOfItems = typeArray.length;
		for (int i=0; i<numberOfItems; i++)
		//for (int i=0; i<2; i++)
		{

			String type = typeArray[i];

			String Description = testdata.get("description")+physicianPortal.GenarateRandomNumber()+type;
			facilityPage.CreateOrderSet();
			facilityPage.CreateOrderSetDescription(Description,type,testdata.get("routes"),testdata.get("libraryText"));
			physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType"));		
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
			physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num")),testdata.get("frequency"));
			physicianPortal.HowOftenDailyType(Integer.parseInt(testdata.get("num")),testdata.get("howOften"),testdata.get("everyDay"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),type);


			physicianPortal.AddOrderFrequency();



			for(int newnum=2;newnum<=4;newnum ++)
			{
				count=newnum;
				physicianPortal.OrderFrequencyType(newnum,testdata.get("frequencyType"));
				physicianPortal.RequireActionRelatedLabel((newnum),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
				switch (newnum)
				{
				case 2:	
					physicianPortal.ShiftFrequency((newnum+1) ,testdata.get("frequency1") );
					break;
				case 3:	
					physicianPortal.ShiftFrequency((newnum+1) ,testdata.get("frequency2") );
					break;
				case 4:				
					physicianPortal.ShiftFrequency((newnum+1) ,testdata.get("frequency3") );
					break;
				case 5:					
					physicianPortal.ShiftFrequency((newnum+1) ,testdata.get("frequency4") );
					break;
				case 6:				
					physicianPortal.ShiftFrequency((newnum+1) ,testdata.get("frequency5") );
					break;
				case 7:				
					physicianPortal.ShiftFrequency((newnum+1) ,testdata.get("frequency6") );
					break;			
				case 8:		
					physicianPortal.ShiftFrequency((newnum+1) ,testdata.get("frequency8") );
					break;
				case 9:	
					facilityPage.HourWiseFrequencyFacilityPage((newnum+1) ,testdata.get("frequency9") ,testdata.get("timeInADayTime") );
					break;		    	
				case 10:
					facilityPage.HourWiseFrequencyFacilityPage((newnum+1) ,testdata.get("frequency10") ,testdata.get("timeInADayTime") );
					break;			   
				case 11:	
					facilityPage.HourWiseFrequencyFacilityPage((newnum+1) ,testdata.get("frequency11") ,testdata.get("timeInADayTime") );
					break;		    	
				case 12:	
					facilityPage.HourWiseFrequencyFacilityPage((newnum+1) ,testdata.get("frequency12") ,testdata.get("timeInADayTime") );
					break;			    
				case 13:
					facilityPage.HourWiseFrequencyFacilityPage((newnum+1) ,testdata.get("frequency13") ,testdata.get("timeInADayTime") );
					break;		    	
				case 14:
					facilityPage.HourWiseFrequencyFacilityPage((newnum+1) ,testdata.get("frequency14") ,testdata.get("timeInADayTime") );
					break;		    		  	
				case 15:	
					facilityPage.HourWiseFrequencyFacilityPage((newnum+1) ,testdata.get("frequency15") ,testdata.get("timeInADayTime") );
					break;				
				case 16:
					physicianPortal.ShiftFrequency((newnum+1) ,testdata.get("frequency16") );
					break;		    	
				case 17:	
					physicianPortal.ShiftFrequency((newnum+1) ,testdata.get("frequency17") );
					break;				
				case 18:
					physicianPortal.ShiftFrequency((newnum+1) ,testdata.get("frequency18") );
					break;				
				case 19:
					physicianPortal.ShiftFrequency((newnum+1) ,testdata.get("frequency19") );
					break;				
				case 20:	
					physicianPortal.ShiftFrequency((newnum+1) ,testdata.get("frequency20") );
					break;				
				case 21:
					physicianPortal.ShiftFrequency((newnum+1) ,testdata.get("frequency21") );
					break;



				}
				String[] FrequencyNames = {testdata.get("frequency1"),testdata.get("frequency2"),testdata.get("frequency3"),testdata.get("frequency4")};
				//,testdata.get("frequency5"),testdata.get("frequency6"),testdata.get("frequency8"),testdata.get("frequency9"),testdata.get("frequency10"),
				//testdata.get("frequency11"),testdata.get("frequency12"),testdata.get("frequency13"),testdata.get("frequency14"),testdata.get("frequency15"),testdata.get("frequency16"),testdata.get("frequency17"),testdata.get("frequency18"),testdata.get("frequency19"),testdata.get("frequency20"),testdata.get("frequency21")
				String FrequencyName = FrequencyNames[newnum-2];



				if(FrequencyName!=testdata.get("frequency4"))
				{
					physicianPortal.HowOftenDailyType(newnum,testdata.get("howOften"),testdata.get("everyDay"));
				}

				physicianPortal.CreateOrderFrequencyForRoutine(newnum,testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),type);		

				if(FrequencyName!=testdata.get("frequency4"))
				{
					physicianPortal.AddOrderFrequency();
				}


			}
			physicianPortal.RemoveFrequency(count+1);
			physicianPortal.SaveOrderFrequency();
			facilityPage.VerifyManageOrderFromSets(Description);


		}	




		login.Logout();



	}

	@Test()
	public void QA040_HowOftenFieldSelection_WithFrequencyType_Routine(ITestContext testContext) throws InterruptedException
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);

		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);

		homepage.NavigateToFacilityPortal();


		final String testCase = "QA040";
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);


		String[] typeArray = {testdata.get("type1"),testdata.get("type2")};
		//,testdata.get("type4"),testdata.get("type5"),testdata.get("type6"),testdata.get("type7")
		int numberOfItems = typeArray.length;
		for (int i=0; i<numberOfItems; i++)

		{

			String type = typeArray[i];

			facilityPage.ManageOrdersSets();
			facilityPage.VerifyButtonsinVerifyFields();

			String Description = testdata.get("description")+physicianPortal.GenarateRandomNumber()+type;

			TestTemplate.testReport.logSuccess("Create Order With Treatment Dropdown Option");

			facilityPage.CreateOrderSetDescription(Description,type,testdata.get("routes"),testdata.get("libraryText"));	
			physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
			physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num")),testdata.get("frequency"));
			physicianPortal.HowOftenDailyType(Integer.parseInt(testdata.get("num")),testdata.get("howOften"),testdata.get("everyDay"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),type);


			TestTemplate.testReport.logSuccess("Create Frequency With  Weekly HowOften Dropdown Option");
			physicianPortal.AddOrderFrequency();
			physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num1")),testdata.get("frequencyType"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num1")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
			physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num1")),testdata.get("frequency"));
			physicianPortal.HowOftenWeeklytype(Integer.parseInt(testdata.get("num1")),Integer.parseInt(testdata.get("num")),testdata.get("howOften1"),testdata.get("everyDay"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num1")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),type);

			TestTemplate.testReport.logSuccess("Create Frequency With  Monthly HowOften Dropdown Option");
			physicianPortal.AddOrderFrequency();
			physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num2")),testdata.get("frequencyType"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num2")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
			physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num2")),testdata.get("frequency"));
			physicianPortal.HowOftenMonthlytype(testdata.get("TypeOfMode"),Integer.parseInt(testdata.get("num2")),Integer.parseInt(testdata.get("num")),Integer.parseInt(testdata.get("num2")),testdata.get("howOften2"),testdata.get("everyDay"),testdata.get("DropdownNumber"),testdata.get("DropdownDay"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num2")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),type);

			TestTemplate.testReport.logSuccess("Create Frequency With  Monthly HowOften Dropdown Option");
			physicianPortal.AddOrderFrequency();
			physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num3")),testdata.get("frequencyType"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num3")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
			physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num3")),testdata.get("frequency"));
			physicianPortal.HowOftenMonthlytype(testdata.get("TypeOfMode1"),Integer.parseInt(testdata.get("num3")),Integer.parseInt(testdata.get("num")),Integer.parseInt(testdata.get("num3")),testdata.get("howOften2"),testdata.get("everyDay"),testdata.get("DropdownNumber"),testdata.get("DropdownDay"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num3")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),type);

			TestTemplate.testReport.logSuccess("Create Frequency With Yearly HowOften Dropdown Option");
			physicianPortal.AddOrderFrequency();
			physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num4")),testdata.get("frequencyType"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num4")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
			physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num4")),testdata.get("frequency"));
			physicianPortal.HowOftenYearlyType(Integer.parseInt(testdata.get("num4")),Integer.parseInt(testdata.get("num")),testdata.get("howOften3"),testdata.get("scheduleOnMonth"),testdata.get("everyDay"),testdata.get("everyDay"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num4")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),type);
			physicianPortal.SaveOrderFrequency();

			facilityPage.VerifyManageOrderFromSets(Description);


		}		

		login.Logout();

	}	


	@Test()
	public void QA041_AddingFrequencyInNewCreatedOrderSetsVia_FacilityAppForDetailsType_WithFrequencyType_PNR(ITestContext testContext) throws InterruptedException
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);


		final String testCase = "QA041";
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);


		homepage.NavigateToFacilityPortal();



		String[] typeArray = {testdata.get("type1"),testdata.get("type2"),testdata.get("type4"),testdata.get("type5"),testdata.get("type6")};	
		int TypeSize = typeArray.length;
		for(int i=0;i<TypeSize;i++)

		{
			String Type = typeArray[i];

			String Description = testdata.get("description")+physicianPortal.GenarateRandomNumber()+Type;

			facilityPage.ManageOrdersSets();
			facilityPage.VerifyButtonsinVerifyFields();

			facilityPage.CreateOrderSetDescription(Description,Type,testdata.get("routes"),testdata.get("libraryText"));	
			physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),Type);
			physicianPortal.SaveOrderFrequency();

			facilityPage.VerifyManageOrderFromSets(Description);

		}


		login.Logout();
	}



	@Test()
	public void QA042_AddingFrequencyInNewCreatedOrderSetsVia_FacilityAppForDetailsType_WithFrequencyType_PNREveryHour(ITestContext testContext) throws InterruptedException
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);

		final String testCase = "QA042";
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);


		homepage.NavigateToFacilityPortal();



		String[] typeArray = {testdata.get("type1"),testdata.get("type2"),testdata.get("type4"),testdata.get("type5"),testdata.get("type6")};	

		int TypeSize = typeArray.length;
		for(int i=0;i<TypeSize;i++)

		{
			String Type = typeArray[i];

			String Description = testdata.get("description")+physicianPortal.GenarateRandomNumber()+Type;

			facilityPage.ManageOrdersSets();
			facilityPage.VerifyButtonsinVerifyFields();

			facilityPage.CreateOrderSetDescription(Description,Type,testdata.get("routes"),testdata.get("libraryText"));	
			physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),Type);
			physicianPortal.SaveOrderFrequency();

			facilityPage.VerifyManageOrderFromSets(Description);

		}

		login.Logout();

	}

	@Test()
	public void QA043_CreateAnOrderSetsVia_FacilityApp_ForDetailsType_TreatmentWithMedication_And_Medication(ITestContext testContext) throws InterruptedException
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);

		final String testCase = "QA043";
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);


		homepage.NavigateToFacilityPortal();
		String[] typeArray = {testdata.get("type1"),testdata.get("type2")};
		int TypeSize = typeArray.length;

		facilityPage.ManageOrdersSets();
		for(int i=0;i<TypeSize;i++)
		{
			String Type = typeArray[i];

			String Description = testdata.get("description")+physicianPortal.GenarateRandomNumber()+Type;

			facilityPage.CreateOrderSet();
			facilityPage.CreateOrderSetDescription(Description,Type,testdata.get("routes"),testdata.get("libraryText"));
			facilityPage.VerifyButtonsinVerifyFields();
			physicianPortal.CancelOrder();


		}

		login.Logout();
	}


	@Test()
	public void QA044_AddingFrequencyIn_NewCreateAnOrderSetsVia_FacilityApp_ForDetailsType_TreatmentWithMedication_And_Medication_WithFrequencyType_Routine(ITestContext testContext) throws InterruptedException
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);

		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);

		homepage.NavigateToFacilityPortal();

		final String testCase = "QA044";
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);		
		String[] typeArray = {testdata.get("type1"),testdata.get("type2")};


		int numberOfItems = typeArray.length;
		for (int i=0; i<numberOfItems; i++)

		{

			String type = typeArray[i];

			facilityPage.ManageOrdersSets();
			facilityPage.VerifyButtonsinVerifyFields();

			String Description = testdata.get("description")+physicianPortal.GenarateRandomNumber()+type;

			TestTemplate.testReport.logSuccess("Create Order With Treatment Dropdown Option");

			facilityPage.CreateOrderSetDescription(Description,type,testdata.get("routes"),testdata.get("libraryText"));	
			physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
			physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num")),testdata.get("frequency"));
			physicianPortal.HowOftenDailyType(Integer.parseInt(testdata.get("num")),testdata.get("howOften"),testdata.get("everyDay"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),type);


			TestTemplate.testReport.logSuccess("Create Frequency With  Weekly HowOften Dropdown Option");
			physicianPortal.AddOrderFrequency();
			physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num1")),testdata.get("frequencyType"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num1")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
			physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num1")),testdata.get("frequency"));
			physicianPortal.HowOftenWeeklytype(Integer.parseInt(testdata.get("num1")),Integer.parseInt(testdata.get("num")),testdata.get("howOften1"),testdata.get("everyDay"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num1")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),type);

			TestTemplate.testReport.logSuccess("Create Frequency With  Monthly HowOften Dropdown Option");
			physicianPortal.AddOrderFrequency();
			physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num2")),testdata.get("frequencyType"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num2")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
			physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num2")),testdata.get("frequency"));
			physicianPortal.HowOftenMonthlytype(testdata.get("TypeOfMode"),Integer.parseInt(testdata.get("num2")),Integer.parseInt(testdata.get("num")),Integer.parseInt(testdata.get("num2")),testdata.get("howOften2"),testdata.get("everyDay"),testdata.get("DropdownNumber"),testdata.get("DropdownDay"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num2")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),type);

			TestTemplate.testReport.logSuccess("Create Frequency With  Monthly HowOften Dropdown Option");
			physicianPortal.AddOrderFrequency();
			physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num3")),testdata.get("frequencyType"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num3")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
			physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num3")),testdata.get("frequency"));
			physicianPortal.HowOftenMonthlytype(testdata.get("TypeOfMode1"),Integer.parseInt(testdata.get("num3")),Integer.parseInt(testdata.get("num")),Integer.parseInt(testdata.get("num3")),testdata.get("howOften2"),testdata.get("everyDay"),testdata.get("DropdownNumber"),testdata.get("DropdownDay"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num3")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),type);

			TestTemplate.testReport.logSuccess("Create Frequency With Yearly HowOften Dropdown Option");
			physicianPortal.AddOrderFrequency();
			physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num4")),testdata.get("frequencyType"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num4")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
			physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num4")),testdata.get("frequency"));
			physicianPortal.HowOftenYearlyType(Integer.parseInt(testdata.get("num4")),Integer.parseInt(testdata.get("num")),testdata.get("howOften3"),testdata.get("scheduleOnMonth"),testdata.get("everyDay"),testdata.get("everyDay"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num4")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),type);
			physicianPortal.SaveOrderFrequency();

			facilityPage.VerifyManageOrderFromSets(Description);


		}		

		login.Logout();

	}	

	@Test()
	public void QA045_AddingFrequencyIn_NewCreateAnOrderSetsVia_FacilityApp_ForDetailsType_TreatmentWithMedication_And_Medication_WithFrequencyType_PNR(ITestContext testContext) throws InterruptedException
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);

		homepage.NavigateToFacilityPortal();

		final String testCase = "QA045";
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);		
		String[] typeArray = {testdata.get("type1"),testdata.get("type2")};
		int TypeSize = typeArray.length;
		for(int i=0;i<TypeSize;i++)

		{
			String Type = typeArray[i];

			facilityPage.ManageOrdersSets();
			facilityPage.VerifyButtonsinVerifyFields();

			String Description = testdata.get("description")+physicianPortal.GenarateRandomNumber()+Type;

			facilityPage.CreateOrderSetDescription(Description,Type,testdata.get("routes"),testdata.get("libraryText"));	
			physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),Type);
			physicianPortal.SaveOrderFrequency();

			facilityPage.VerifyManageOrderFromSets(Description);

		}


		login.Logout();
	}


	@Test()
	public void QA046_AddingFrequencyIn_NewCreateAnOrderSetsVia_FacilityApp_ForDetailsType_TreatmentWithMedication_And_Medication_WithFrequencyType_PNREveryHour(ITestContext testContext) throws InterruptedException
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToFacilityPortal();		

		final String testCase = "QA046";
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);		
		String[] typeArray = {testdata.get("type1"),testdata.get("type2")};	
		int TypeSize = typeArray.length;
		for(int i=0;i<TypeSize;i++)

		{
			String Type = typeArray[i];

			facilityPage.ManageOrdersSets();
			facilityPage.VerifyButtonsinVerifyFields();

			String Description = testdata.get("description")+physicianPortal.GenarateRandomNumber()+Type;

			facilityPage.CreateOrderSetDescription(Description,Type,testdata.get("routes"),testdata.get("libraryText"));	
			physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),Type);
			physicianPortal.SaveOrderFrequency();

			facilityPage.VerifyManageOrderFromSets(Description);

		}


		login.Logout();
	}

	@Test()
	public void QA047_AddMultipleOrdersetsWithinOneOrdersetTemplate(ITestContext testContext) throws InterruptedException
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);

		final String testCase = "QA047";
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		String Description = testdata.get("description")+physicianPortal.GenarateRandomNumber()+testdata.get("type");
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToFacilityPortal();
		facilityPage.ManageOrdersSets();
		facilityPage.CreateOrderSetDescription(Description,testdata.get("type"),testdata.get("routes"),testdata.get("libraryText"));	
		physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType"));
		physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
		physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num")),testdata.get("frequency"));
		physicianPortal.HowOftenDailyType(Integer.parseInt(testdata.get("num")),testdata.get("howOften"),testdata.get("everyDay"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),testdata.get("type"));
		physicianPortal.SaveOrderFrequency();

		facilityPage.VerifyManageOrderFromSets(Description);
		facilityPage.ClickingTheCreatedOrderFromSets(Description);
		/*facilityPage.CreateOrderSet();
		facilityPage.VerifyManageOrderFromSets(Description);*/
		facilityPage.VerifyTheFieldsAfterClickingOnTheCreateOrderSetsButton();
		facilityPage.VerifyButtonsinVerifyFields();
		facilityPage.CreateOrderSetDescription(Description,testdata.get("type"),testdata.get("routes"),testdata.get("libraryText"));	
		physicianPortal.OrderFrequencyType(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType"));
		physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testdata.get("num")),testdata.get("frequencyType") ,testdata.get("requiredActions"),testdata.get("othersRequiredActions") ,testdata.get("requiredActionsPostDropdown"),testdata.get("othersRequiredActionsPostDropdown"), testdata.get("administeredBy"),testdata.get("maxDoesHours"),testdata.get("followUpAfterMinutes"),testdata.get("slidingScaleMin") , testdata.get("slidingScaleMax"), testdata.get("slidingScaleUnits"));
		physicianPortal.OnceAShiftFrequency(Integer.parseInt(testdata.get("num")),testdata.get("frequency"));
		physicianPortal.HowOftenDailyType(Integer.parseInt(testdata.get("num")),testdata.get("howOften"),testdata.get("everyDay"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testdata.get("num")),testdata.get("physicianInstructions"),testdata.get("physicianInstructions"),testdata.get("type"));
		physicianPortal.SaveOrderFrequency();
		facilityPage.VerifyManageOrderFromSets(Description);

		login.Logout();

	}


	@Test()
	public void QA048_UpdatingOrRemovingOrder_LibrariesViaFacilityAppForDetailsType(ITestContext testContext)
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);


		final String TesctCaseNo = "QA048";


		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TesctCaseNo);

        String PickFromLibrary =  testData.get("description") +physicianPortal.GenarateRandomNumber();
        
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToFacilityPortal();
		facilityPage.VerifyAndClickManageOrderLibrary();


		ArrayList<String> Options = facilityPage.VerifyOrderTemplate(PickFromLibrary);
		int size = Options.size();


		homepage.NavigateToPhysicianPortal();
		physicianPortal.ClickOnPhysicianPortal();	
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		for(int i=0;i<=(size-1);i++)
		{
			physicianPortal.ResidentFullOrderDetailsWithoutMedication(Options.get(i),PickFromLibrary,testData.get("createdType"));
			physicianPortal.CancelOrder();

		}

		homepage.NavigateToFacilityPortal();
		facilityPage.VerifyAndClickManageOrderLibrary();
		facilityPage.RemoveDescriptionInOrderTemplate(PickFromLibrary);

		homepage.NavigateToPhysicianPortal();
		physicianPortal.ClickOnPhysicianPortal();	
		//physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));

		for(int i=0;i<=(size-1);i++)
		{
			physicianPortal.VerifyRemoveButtonInPickFromLibrary(Options.get(i),testData.get("description"));
			physicianPortal.CancelOrder();

		}

		login.Logout();

	}
	
	
	@Test(priority = 3)
	public void Gen_QA209_BS_EHR_LoginPage(ITestContext testContext)
			throws Throwable {

		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);		
		final String TesctCase = "GEN_QA209";	
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		login.Logout();

	}
	
	@Test(priority = 3)
	public void Gen_QA210_Login_Credential_Verification(ITestContext testContext)
			throws Throwable {

		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		final String TesctCase = "GEN_QA210";	
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		homepage.MyDashBoardHomePage();
		login.Logout();

	}
	
	@Test(priority = 3)
	public void Gen_QA211_MyDashBoardPage(ITestContext testContext)
			throws Throwable {

		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);

		final String TesctCase = "GEN_QA211";	

		homepage.NavigateToFacilityPortal();
		emar.EmarPageHeaderValidation();
		
		emar.BlueStrataLogoValidation();
		homepage.VerifyFacilityIconAndName();
		homepage.VerifyResidentIconAndName();
		homepage.VerifyAllapps();
		login.Logout();


	}
	
	@Test(priority = 3)
	public void Gen_QA212_UserNamePreferences_TopRightOf_ResidentDahsboard_Or_HomePage(ITestContext testContext)
			throws Throwable {

		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);

		final String TesctCase = "GEN_QA212";	

		homepage.NavigateToFacilityPortal();
		emar.TesterButtonOptionsVerification();
		emar.ChangePasswordVerifications();
		emar.NavigateBackToPreviesPage();
		emar.lockFromApplication(password);		
		login.Logout();

	}
	
	@Test(priority = 3)
	public void Gen_QA213_HelpMenuWith_HelpSiteAbout(ITestContext testContext) throws Throwable {
		
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);

		final String TesctCase = "Gen_QA213";	

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TesctCase);
		
		homepage.NavigateToFacilityPortal();
		emar.HelpButtonvalidation();
		String ParentparentWindow = emar.HelpSiteValidation(testData.get("HelpSiteURL"));
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(ParentparentWindow);
		login.Logout();
	}
	
	@Test(priority = 3)
   public void Gen_QA214_HelpMenuWith_HelpSiteAbout(ITestContext testContext) throws Throwable {
		
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);

		final String TesctCase = "GEN_QA214";	

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TesctCase);
		
		homepage.NavigateToFacilityPortal();
		homepage.VerifyAllapps();
		login.Logout();

	}
   
   //@Test()
   public void DeteleOrders(ITestContext testContext)
   {
	   LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	   HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	   EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	   FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	   String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
	   homepage.NavigateToFacilityPortal();
	   facilityPage.DeleteCreatedOrders();
   }
}


