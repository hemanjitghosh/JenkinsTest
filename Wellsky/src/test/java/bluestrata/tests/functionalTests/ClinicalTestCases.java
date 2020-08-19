package bluestrata.tests.functionalTests;

import java.awt.AWTException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Random;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.excel.Xls_Reader;

import bluestrata.pages.ClinicalPage;
import bluestrata.pages.EmarPage;
import bluestrata.pages.FacilityPage;
import bluestrata.pages.HomePage;
import bluestrata.pages.LoginPage;
import bluestrata.pages.PhysicianPortalPage;
import dweb.test.templates.TestTemplate;
import dweb.test.templates.TestTemplateMethodLevelInit;

public class ClinicalTestCases extends TestTemplateMethodLevelInit {

	//private static final boolean false = false;
	//Xls_Reader xlsReader = new Xls_Reader("C:\\Bluestrata\\Abhishek-Project-s\\src\\test\\resources\\testdata\\BluestrataTestData.xlsx");
	Xls_Reader xlsReader = new Xls_Reader("C:\\Users\\hemanjitg\\Desktop\\BlueStrata\\LTC-AutomatedTests\\src\\test\\resources\\testdata\\BluestrataTestData.xlsx");
	final String SheetName = "clinicalPortal";
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
	

	@Test(enabled=false)
	public void QA090_OrderCreationViaClinicalAPP(ITestContext testContext) throws URISyntaxException
	{
		
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		final String testCase = "QA090";

		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);

		login.login(userName, password); 
		homepage.NavigateToClinicalPortal();

		clinicalPortal.ClinicalPortalHeaderVerfication();
		clinicalPortal.VerifyPhysicianPortalDrropdown();
		physicianPortal.VerifyResidentPageHeaderHeading();
		physicianPortal.VerifytheFieldsDisplayDownToMessage();
		physicianPortal.CounttheNoOfResidentInAPage();
		physicianPortal.AssendingOrderUsingFirstName();
		physicianPortal.AssendingOrderUsingLastName();
		physicianPortal.AssendingOrderUsingMr();
		physicianPortal.AssendingOrderUsingAge();
		physicianPortal.AssendingOrderUsingLocation();
		physicianPortal.SearchResidentWithApplyFilterButton(testdata.get("EnterValue"));
		physicianPortal.VerifyPreviousOrders();
		physicianPortal.VerifyButtonInResidentOrders();
		physicianPortal.FullOrderPageVerification();

		login.Logout();

	}


	@Test()
	public void QA091_ResidentOrders_CreateAnOrderUsingDetailsType(ITestContext testContext)
	{

		
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 
		TestTemplate.testReport.logSuccess("Click to Clinical Portal From Menu Bar");
		homepage.NavigateToClinicalPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Clinical Portal");
		clinicalPortal.ClickOnResidentOrdersFromOrders();	

		/*String ResidentNo = xlsReader.getCellData("physicianportal", 28, 7);

			TestTemplate.testReport.logSuccess("Click On existing Resident");
			physicianPortal.ClickOnExistingResident(ResidentNo);


			String type1 = xlsReader.getCellData("clinicalPortal", 0, 7);
			String type2 = xlsReader.getCellData("clinicalPortal", 1, 7);
			String type3 = xlsReader.getCellData("clinicalPortal", 2, 7);
			String type4 = xlsReader.getCellData("clinicalPortal", 3, 7);
			String type5 = xlsReader.getCellData("clinicalPortal", 4, 7);
			String type6 = xlsReader.getCellData("clinicalPortal", 5, 7);
			String type7 = xlsReader.getCellData("clinicalPortal", 6, 7);
			String libraryText = xlsReader.getCellData("clinicalPortal", 7, 7);
			String createdType = xlsReader.getCellData("clinicalPortal", 8, 7);
			String libraryText1 = xlsReader.getCellData("clinicalPortal", 7, 7);
			String createdType1 = xlsReader.getCellData("clinicalPortal", 8, 7);		
			String libraryText1 = xlsReader.getCellData("clinicalPortal", 9, 7);
			String createdType1 = xlsReader.getCellData("clinicalPortal", 10, 7);
			String nullDiagonisis = xlsReader.getCellData("clinicalPortal", 11, 7);
			String SearchDiogonosisTxt = xlsReader.getCellData("clinicalPortal", 12, 7);
			String medicarePriority = xlsReader.getCellData("clinicalPortal", 13, 7);
			String diogonosisName = xlsReader.getCellData("clinicalPortal", 14, 7);
			String physicianType = xlsReader.getCellData("clinicalPortal", 15, 7);
			String ReceivedByType = xlsReader.getCellData("clinicalPortal", 16, 7);
			String ReceivedOrderType1 = xlsReader.getCellData("clinicalPortal", 17, 7);
			String ReceivedOrderType2 = xlsReader.getCellData("clinicalPortal", 18, 7);
			String ReceivedOrderType3 = xlsReader.getCellData("clinicalPortal", 19, 7);
			String ReceivedOrderType4 = xlsReader.getCellData("clinicalPortal", 20, 7);
			String ReceivedOrderType5 = xlsReader.getCellData("clinicalPortal", 21, 7);
			String ReceivedOrderType6 = xlsReader.getCellData("clinicalPortal", 22, 7);
			String ReceivedOrderType7 = xlsReader.getCellData("clinicalPortal", 23, 7);
			String routes = xlsReader.getCellData("clinicalPortal", 24, 7);
			String WrittenDate = xlsReader.getCellData("clinicalPortal", 25, 7);
			String NoOfRefillis = xlsReader.getCellData("clinicalPortal", 26, 7);
			String WhenToFill = xlsReader.getCellData("clinicalPortal", 27, 7);*/


		final String testCase = "QA091";

		HashMap<String ,String> testData = xlsReader.GetValue(SheetName,testCase);

		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		physicianPortal.VerifyButtonInResidentOrders();
		



		String[] typeArray = {testData.get("type1"),testData.get("type2"),testData.get("type3"),testData.get("type4")};
		String[] ReceivedByOptions = {testData.get("ReceivedOrderType1"),testData.get("ReceivedOrderType2"),testData.get("ReceivedOrderType3"),testData.get("ReceivedOrderType4")}; 
		//testData.get("ReceivedOrderType5"),testData.get("ReceivedOrderType6"),testData.get("ReceivedOrderType7")
		int numberOfItems = typeArray.length;
		for (int i=0; i<numberOfItems; i++)

		{

			String type = typeArray[i];
			String ReceivedByorderType = ReceivedByOptions[i];


			physicianPortal.ResidentFullOrderDetailsWithoutMedication(type,testData.get("libraryText"),testData.get("createdType"));
			physicianPortal.ResidentFullOrderDetails(type,testData.get("nullDiagonisis"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),ReceivedByorderType,testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));

			physicianPortal.CancelOrder();	

		}


		login.Logout();

	}


	@Test()
	public void QA092_AddingFrequencyFromResidentOrders_CreateAnOrderWithFrequencyRoutine(ITestContext testContext)
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 
		TestTemplate.testReport.logSuccess("Click to Clinical Portal From Menu Bar");
		homepage.NavigateToClinicalPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Clinical Portal");
		clinicalPortal.ClickOnResidentOrdersFromOrders();	


		
		final String testCase = "QA092";

		HashMap<String ,String> testData = xlsReader.GetValue(SheetName,testCase);

		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		physicianPortal.VerifyButtonInResidentOrders();
	

		TestTemplate.testReport.logSuccess("Create Order With Treatment Dropdown Option");
		//passed
		physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type1"),testData.get("libraryText")+testData.get("type1"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.OrderFrequencyType(Integer.parseInt(testData.get("num")),testData.get("frequencyType"));
		physicianPortal.StartDate(Integer.parseInt(testData.get("num")),testData.get("startDate"),testData.get("startDateTime"));
		physicianPortal.OrderEndType(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,testData.get("endDateType"),testData.get("endDate") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));
		physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testData.get("num")),testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
		physicianPortal.OnceAShiftFrequency(Integer.parseInt(testData.get("num")),testData.get("frequency"));
		physicianPortal.HowOftenDailyType(Integer.parseInt(testData.get("num")),testData.get("howOften"),testData.get("everyDay"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),testData.get("type1"));
		physicianPortal.SaveOrderFrequency();
		//physicianPortal.OrderDisplayPageColourVerification();
		//physicianPortal.OrderDisplayPageColoumnsVerification();


		/*physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type2"),testData.get("libraryText")+testData.get("type2"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.OrderFrequencyType(Integer.parseInt(testData.get("num")),testData.get("frequencyType"));
		physicianPortal.StartDate(Integer.parseInt(testData.get("num")),testData.get("startDate"),testData.get("startDateTime"));
		physicianPortal.OrderEndType(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,testData.get("endDateType1"),testData.get("endDateType1") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));
		physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testData.get("num")),testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
		physicianPortal.OnceAShiftFrequency(Integer.parseInt(testData.get("num")),testData.get("frequency"));
		physicianPortal.HowOftenDailyType(Integer.parseInt(testData.get("num")),testData.get("howOften"),testData.get("everyDay"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),testData.get("type2"));
		physicianPortal.SaveOrderFrequency();*/
		//passed
		physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type7"),testData.get("libraryText")+testData.get("type7"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.OrderFrequencyType(Integer.parseInt(testData.get("num")),testData.get("frequencyType"));
		physicianPortal.StartDate(Integer.parseInt(testData.get("num")),testData.get("startDate"),testData.get("startDateTime"));
		physicianPortal.OrderEndType(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,testData.get("endDateType2"),testData.get("endDateType2") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));
		physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testData.get("num")),testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
		physicianPortal.OnceAShiftFrequency(Integer.parseInt(testData.get("num")),testData.get("frequency"));
		physicianPortal.HowOftenWeeklytype(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("num")),testData.get("howOften1"),testData.get("everyDay"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),testData.get("type7"));
		physicianPortal.SaveOrderFrequency();
		
		//passed
		
		
	
		
		
		physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type4"),testData.get("libraryText")+testData.get("type4"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.OrderFrequencyType(Integer.parseInt(testData.get("num")),testData.get("frequencyType"));
		physicianPortal.StartDate(Integer.parseInt(testData.get("num")),testData.get("startDate"),testData.get("startDateTime"));
		physicianPortal.OrderEndType(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,testData.get("endDateType"),testData.get("endDate") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));
		physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testData.get("num")),testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
		physicianPortal.OnceAShiftFrequency(Integer.parseInt(testData.get("num")),testData.get("frequency"));
		physicianPortal.HowOftenMonthlytype(testData.get("TypeOfMode"),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("num")),testData.get("howOften2"),testData.get("everyDay"),testData.get("DropdownNumber"),testData.get("DropdownDay"));		
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),testData.get("type4"));
		physicianPortal.SaveOrderFrequency();
		
		//passed
		physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type5"),testData.get("libraryText")+testData.get("type5"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.OrderFrequencyType(Integer.parseInt(testData.get("num")),testData.get("frequencyType"));
		physicianPortal.StartDate(Integer.parseInt(testData.get("num")),testData.get("startDate"),testData.get("startDateTime"));
		physicianPortal.OrderEndType(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,testData.get("endDateType1"),testData.get("endDateType1") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));
		physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testData.get("num")),testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
		physicianPortal.OnceAShiftFrequency(Integer.parseInt(testData.get("num")),testData.get("frequency"));
		physicianPortal.HowOftenMonthlytype(testData.get("TypeOfMode1"),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("num")),testData.get("howOften2"),testData.get("everyDay"),testData.get("DropdownNumber"),testData.get("DropdownDay"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),testData.get("type5"));
		physicianPortal.SaveOrderFrequency();
		//passed
		/*physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type6"),testData.get("libraryText")+testData.get("type6"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.OrderFrequencyType(Integer.parseInt(testData.get("num")),testData.get("frequencyType"));
		physicianPortal.StartDate(Integer.parseInt(testData.get("num")),testData.get("startDate"),testData.get("startDateTime"));
		physicianPortal.OrderEndType(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,testData.get("endDateType1"),testData.get("endDateType1") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));
		physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testData.get("num")),testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
		physicianPortal.OnceAShiftFrequency(Integer.parseInt(testData.get("num")),testData.get("frequency"));
		physicianPortal.HowOftenYearlyType(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("num")),testData.get("howOften3"),testData.get("scheduleOnMonth"),testData.get("everyDay"),testData.get("everyDay"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),testData.get("type6"));
		physicianPortal.SaveOrderFrequency();
		*/
		/*
		physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type3"),testData.get("libraryText")+testData.get("type3"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.OrderFrequencyType(Integer.parseInt(testData.get("num")),testData.get("frequencyType"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),testData.get("type3"));
		physicianPortal.SaveOrderFrequency();*/
		login.Logout();
	}



	@Test()
	public void QA093_FrequencyFieldSelectionWhen_FrequencyTypeRoutine(ITestContext testContext)
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 
		TestTemplate.testReport.logSuccess("Click to Clinical Portal From Menu Bar");
		homepage.NavigateToClinicalPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Clinical Portal");
		clinicalPortal.ClickOnResidentOrdersFromOrders();	

		final String TestCase = "QA093";

		HashMap<String , String > testData = xlsReader.GetValue(SheetName, TestCase);

		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));



		String[] typeArray= {testData.get("type1"),testData.get("type2")/*,testData.get("type4"),testData.get("type5"),testData.get("type6"),testData.get("type7")*/};
		int numberOfItems = typeArray.length;
		int count=0;
		for (int i=0; i<numberOfItems; i++)

		{
		
	    	String type = typeArray[i];
	    	
	    	String Description = testData.get("libraryText") + type + physicianPortal.GenarateRandomNumber();
	    	
		physicianPortal.CreateAnOrderWithOrderDetails(type,Description,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.OrderFrequencyType(Integer.parseInt(testData.get("num")),testData.get("frequencyType"));		
		physicianPortal.StartDate(Integer.parseInt(testData.get("num")),testData.get("startDate"),testData.get("startDateTime"));		
		physicianPortal.OrderEndType(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,testData.get("endDateType"),testData.get("endDate") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));
		physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testData.get("num")),testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
		physicianPortal.OnceAShiftFrequency(Integer.parseInt(testData.get("num")),testData.get("frequency"));
		physicianPortal.HowOftenDailyType(Integer.parseInt(testData.get("num")),testData.get("howOften"),testData.get("everyDay"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),type);
		
		physicianPortal.AddOrderFrequency();
		
		
		
		for(int newnum=2;newnum<=4;newnum ++)
		{
		count=newnum;
		physicianPortal.OrderFrequencyType(newnum,testData.get("frequencyType"));
		physicianPortal.StartDate(newnum,testData.get("startDate"),testData.get("startDateTime"));
		physicianPortal.OrderEndType(newnum,Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,testData.get("endDateType"),testData.get("endDate") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));
		physicianPortal.RequireActionRelatedLabel(newnum,testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
		switch (newnum)
		{
		case 2:	
			physicianPortal.TextTypeNoOfTimesAdayFrequency(testData.get("frequencyTexttype") ,newnum ,testData.get("frequency1") , Integer.parseInt(testData.get("num")) , testData.get("timeInADayTime1"));
			break;
		case 3:				
	    	physicianPortal.TextTypeNoOfTimesAdayFrequency(testData.get("frequencyTexttype1") ,newnum ,testData.get("frequency1") , Integer.parseInt(testData.get("num")) , testData.get("timeInADayShift"));
			break;
		case 4:				
		    physicianPortal.TextTypeNoOfTimesAdayFrequency(testData.get("frequencyTexttype") ,newnum ,testData.get("frequency2") , (Integer.parseInt(testData.get("num"))+1) , testData.get("timeInADayShift"));
			break;
		case 5:				
	    	physicianPortal.TextTypeNoOfTimesAdayFrequency(testData.get("frequencyTexttype1") ,newnum ,testData.get("frequency2") , (Integer.parseInt(testData.get("num"))+1) , testData.get("timeInADayShift"));
			break;
		case 6:				
		    physicianPortal.TextTypeNoOfTimesAdayFrequency(testData.get("frequencyTexttype") ,newnum ,testData.get("frequency3") , (Integer.parseInt(testData.get("num"))+2) , testData.get("timeInADayTime"));
			break;
		case 7:				
	    	physicianPortal.TextTypeNoOfTimesAdayFrequency(testData.get("frequencyTexttype1") ,newnum ,testData.get("frequency3") , (Integer.parseInt(testData.get("num"))+2) , testData.get("timeInADayShift"));
	     	break;
		case 8:		
			physicianPortal.TextTypeNoOfTimesAdayFrequency(testData.get("frequencyTexttype") ,newnum ,testData.get("frequency4") , (Integer.parseInt(testData.get("num"))+3) , testData.get("timeInADayTime"));
			break;
		case 9:				
	    	physicianPortal.TextTypeNoOfTimesAdayFrequency(testData.get("frequencyTexttype1") ,newnum ,testData.get("frequency4") , (Integer.parseInt(testData.get("num"))+3) , testData.get("timeInADayShift"));
			break;
		case 10:				
		    physicianPortal.TextTypeNoOfTimesAdayFrequency(testData.get("frequencyTexttype") ,newnum ,testData.get("frequency5") , (Integer.parseInt(testData.get("num"))+4) , testData.get("timeInADayTime"));
			break;
		case 11:				
	    	physicianPortal.TextTypeNoOfTimesAdayFrequency(testData.get("frequencyTexttype1") ,newnum ,testData.get("frequency5") , (Integer.parseInt(testData.get("num"))+4) , testData.get("timeInADayShift"));
			break;
		case 12:				
		    physicianPortal.TextTypeNoOfTimesAdayFrequency(testData.get("frequencyTexttype") ,newnum ,testData.get("frequency6") , (Integer.parseInt(testData.get("num"))+5) , testData.get("timeInADayTime"));
			break;
		case 13:				
	    	physicianPortal.TextTypeNoOfTimesAdayFrequency(testData.get("frequencyTexttype1") ,newnum ,testData.get("frequency6") , (Integer.parseInt(testData.get("num"))+5) , testData.get("timeInADayShift"));
	     	break;
		case 14:				
	    	physicianPortal.BedTimeFrequency(testData.get("frequencyTexttype") ,newnum ,testData.get("frequency8"),testData.get("timeInADayTime"));
	     	break;	  	
		case 15:				
			physicianPortal.HourWiseFrequency(newnum ,testData.get("frequency9") ,testData.get("timeInADayTime") );
	     	break;
		case 16:				
	    	physicianPortal.HourWiseFrequency(newnum ,testData.get("frequency10") ,testData.get("timeInADayTime") );
	     	break;
		case 17:				
			physicianPortal.HourWiseFrequency(newnum ,testData.get("frequency11") ,testData.get("timeInADayTime") );
	     	break;
		case 18:				
			physicianPortal.HourWiseFrequency(newnum ,testData.get("frequency12") ,testData.get("timeInADayTime") );
	     	break;
		case 19:				
			physicianPortal.HourWiseFrequency(newnum ,testData.get("frequency13") ,testData.get("timeInADayTime") );
	     	break;
		case 20:				
			physicianPortal.HourWiseFrequency(newnum ,testData.get("frequency14") ,testData.get("timeInADayTime") );
	     	break;
		case 21:				
			physicianPortal.HourWiseFrequency(newnum ,testData.get("frequency15") ,testData.get("timeInADayTime") );
	     	break;
	    case 22:				
			physicianPortal.MealWiseFrequency(newnum ,testData.get("frequency16"),testData.get("timeInADayShiftBedTime") );
	     	break;
	   	case 23:				
	   		physicianPortal.MealWiseFrequency(newnum ,testData.get("frequency17"),testData.get("timeInADayShiftBedTime") );
	     	break; 	
	    case 24:				
	    	physicianPortal.MealWiseFrequency(newnum ,testData.get("frequency18"),testData.get("timeInADayShiftBedTime") );
	     	break;
	    case 25:				
	    	physicianPortal.MealWiseFrequency(newnum ,testData.get("frequency19"),testData.get("timeInADayShiftBedTime") );
	     	break;
	   	case 26:				
	   		physicianPortal.MealWiseFrequency(newnum ,testData.get("frequency20"),testData.get("timeInADayShiftBedTime") );
	     	break; 	
		case 27:				
			physicianPortal.OnceAShiftFrequency(newnum,testData.get("frequency21"));
	     	break; 
						
			
		
		}
		String[] FrequencyNames = {testData.get("frequency1"),testData.get("frequency1"),testData.get("frequency2"),testData.get("frequency2"),testData.get("frequency3"),testData.get("frequency3"),testData.get("frequency4"),testData.get("frequency4"),testData.get("frequency5"),testData.get("frequency5"),testData.get("frequency6"),testData.get("frequency6"),testData.get("frequency8"),testData.get("frequency9"),testData.get("frequency10"),
				testData.get("frequency11"),testData.get("frequency12"),testData.get("frequency13"),testData.get("frequency14"),testData.get("frequency15"),testData.get("frequency16"),testData.get("frequency17"),testData.get("frequency18"),testData.get("frequency19"),testData.get("frequency20"),testData.get("frequency21")};
		 
		String FrequencyName = FrequencyNames[newnum-2];
		
		if(FrequencyName!=testData.get("frequency21"))
		{
		physicianPortal.HowOftenDailyType(newnum,testData.get("howOften"),testData.get("everyDay"));
		}
	
		physicianPortal.CreateOrderFrequencyForRoutine(newnum,testData.get("physicianInstructions"),testData.get("physicianInstructions"),type);		
		
		if(FrequencyName!=testData.get("frequency21"))
		{
			physicianPortal.AddOrderFrequency();
		}
		
		
		}
		physicianPortal.RemoveFrequency(count+1);
		physicianPortal.SaveOrderFrequency();		
		
		}	

		
		login.Logout();
	}



	@Test()
	public void QA094_HowOftenFieldSelectionWhen_FrequencyTypeRoutine(ITestContext testContext) throws URISyntaxException
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 
		TestTemplate.testReport.logSuccess("Click to Clinical Portal From Menu Bar");
		homepage.NavigateToClinicalPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Clinical Portal");
		clinicalPortal.ClickOnResidentOrdersFromOrders();

		/*String ResidentNo = xlsReader.getCellData("clinicalPortal", 0, 20);
			String type1 = xlsReader.getCellData("clinicalPortal", 1, 20);
			String type2 = xlsReader.getCellData("clinicalPortal", 2, 20);
			String type3 = xlsReader.getCellData("clinicalPortal", 3, 20);
			String type4 = xlsReader.getCellData("clinicalPortal", 4, 20);
			String type5 = xlsReader.getCellData("clinicalPortal", 5, 20);
			String type6 = xlsReader.getCellData("clinicalPortal", 6, 20);
			String type7 = xlsReader.getCellData("clinicalPortal", 7, 20);
			String libraryText = xlsReader.getCellData("clinicalPortal", 8, 20);			
			String SearchDiogonosisTxt = xlsReader.getCellData("clinicalPortal", 9, 20);
			String medicarePriority = xlsReader.getCellData("clinicalPortal", 10, 20);
			String diogonosisName = xlsReader.getCellData("clinicalPortal", 11, 20);
			String physicianType = xlsReader.getCellData("clinicalPortal", 12, 20);
			String ReceivedByType = xlsReader.getCellData("clinicalPortal", 13, 20);
			String ReceivedOrderType = xlsReader.getCellData("clinicalPortal", 14, 20);		
			String routes = xlsReader.getCellData("clinicalPortal", 15, 20);
			String WrittenDate = xlsReader.getCellData("clinicalPortal", 16, 20);
			String NoOfRefillis = xlsReader.getCellData("clinicalPortal", 17, 20);
			String WhenToFill = xlsReader.getCellData("clinicalPortal", 18, 20);
			String num = xlsReader.getCellData("clinicalPortal", 19, 20);
			String frequencyType = xlsReader.getCellData("clinicalPortal", 20, 20);
			String startDate = xlsReader.getCellData("clinicalPortal", 21, 20);  
			String ByDate =startDate;
			String startDateTime = xlsReader.getCellData("clinicalPortal", 22, 20);
			String byDateTime =startDateTime ;
			String byDateno = xlsReader.getCellData("clinicalPortal", 23, 20);
			String afterNoOfAdminstrationsNo = xlsReader.getCellData("clinicalPortal", 24, 20);		
			String endDate = xlsReader.getCellData("clinicalPortal", 25, 20);
			String afterNumberOfAdminstrations = xlsReader.getCellData("clinicalPortal", 26, 20);
			String requiredActions = xlsReader.getCellData("clinicalPortal", 27, 20);
			String othersRequiredActions = xlsReader.getCellData("clinicalPortal", 28, 20);
			String requiredActionsPostDropdown = xlsReader.getCellData("clinicalPortal", 29, 20);
			String othersRequiredActionsPostDropdown = xlsReader.getCellData("clinicalPortal", 30, 20);
			String administeredBy = xlsReader.getCellData("clinicalPortal", 31, 20);
			String maxDoesHours = xlsReader.getCellData("clinicalPortal", 32, 20);
			String followUpAfterMinutes = xlsReader.getCellData("clinicalPortal", 33, 20);
			String slidingScaleMin = xlsReader.getCellData("clinicalPortal", 34, 20);
			String slidingScaleMax = xlsReader.getCellData("clinicalPortal", 35, 20);
			String slidingScaleUnits = xlsReader.getCellData("clinicalPortal", 36, 20);
			String frequency = xlsReader.getCellData("clinicalPortal", 37, 20);
			String howOften = xlsReader.getCellData("clinicalPortal", 38, 20);
			String everyDay = xlsReader.getCellData("clinicalPortal", 39, 20);
			String physicianInstructions = xlsReader.getCellData("clinicalPortal", 40, 20);
			String additionalInstruction = physicianInstructions ;
			String endDateType = xlsReader.getCellData("clinicalPortal", 42, 20);
			String endDateType1 = xlsReader.getCellData("clinicalPortal", 43, 20);
			String endDateType2 = xlsReader.getCellData("clinicalPortal", 44, 20);
			String TypeOfMode = xlsReader.getCellData("clinicalPortal", 45, 20);
			String howOften1 = xlsReader.getCellData("clinicalPortal", 46, 20);
			String howOften2 = xlsReader.getCellData("clinicalPortal", 47, 20);
			String howOften3 = xlsReader.getCellData("clinicalPortal", 48, 20);
			String DropdownNumber = xlsReader.getCellData("clinicalPortal", 49, 20);
			String DropdownDay = xlsReader.getCellData("clinicalPortal", 50, 20);
			String TypeOfMode1 = xlsReader.getCellData("clinicalPortal", 51, 20);
			String scheduleOnMonth = xlsReader.getCellData("clinicalPortal", 52, 20);
			String num1= xlsReader.getCellData("clinicalPortal", 53, 20); 
			String num2= xlsReader.getCellData("clinicalPortal", 54, 20); 
			String num3= xlsReader.getCellData("clinicalPortal", 55, 20); 
			String num4= xlsReader.getCellData("clinicalPortal", 56, 20); */


		final String TestCase = "QA094";

		HashMap<String , String > testData = xlsReader.GetValue(SheetName, TestCase);

		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));

		//Long GenerateNumber = physicianPortal.GenarateRandomNumber();

		String[] typeArray = {testData.get("type1"),testData.get("type2"),testData.get("type4"),testData.get("type5"),testData.get("type6")};

		int numberOfItems = typeArray.length;
		for (int i=0; i<numberOfItems; i++)

		{

			String type = typeArray[i];



			TestTemplate.testReport.logSuccess("Create Order With Treatment Dropdown Option");

			String Description = testData.get("libraryText") + type + physicianPortal.GenarateRandomNumber();

			physicianPortal.CreateAnOrderWithOrderDetails(type,Description,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
			physicianPortal.OrderFrequencyType(Integer.parseInt(testData.get("num")),testData.get("frequencyType"));		
			physicianPortal.StartDate(Integer.parseInt(testData.get("num")),testData.get("startDate"),testData.get("startDateTime"));		
			physicianPortal.OrderEndType(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,testData.get("endDateType"),testData.get("endDate") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testData.get("num")),testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
					testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
			physicianPortal.OnceAShiftFrequency(Integer.parseInt(testData.get("num")),testData.get("frequency"));
			physicianPortal.HowOftenDailyType(Integer.parseInt(testData.get("num")),testData.get("howOften"),testData.get("everyDay"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),type);



			TestTemplate.testReport.logSuccess("Create Frequency With  Weekly HowOften Dropdown Option");
			physicianPortal.AddOrderFrequency();


			physicianPortal.OrderFrequencyType(Integer.parseInt(testData.get("num1")),testData.get("frequencyType"));		
			physicianPortal.StartDate(Integer.parseInt(testData.get("num1")),testData.get("startDate"),testData.get("startDateTime"));		
			physicianPortal.OrderEndType(Integer.parseInt(testData.get("num1")),Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,testData.get("endDateType"),testData.get("endDate") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testData.get("num1")),testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
					testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
			physicianPortal.OnceAShiftFrequency(Integer.parseInt(testData.get("num1")),testData.get("frequency"));
			physicianPortal.HowOftenWeeklytype(Integer.parseInt(testData.get("num1")),Integer.parseInt(testData.get("num")),testData.get("howOften1"),testData.get("everyDay"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num1")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),type);
			/*
			TestTemplate.testReport.logSuccess("Create Frequency With  Monthly HowOften Dropdown Option");
			physicianPortal.AddOrderFrequency();

			physicianPortal.OrderFrequencyType(Integer.parseInt(testData.get("num2")),testData.get("frequencyType"));		
			physicianPortal.StartDate(Integer.parseInt(testData.get("num2")),testData.get("startDate"),testData.get("startDateTime"));		
			physicianPortal.OrderEndType(Integer.parseInt(testData.get("num2")),Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,testData.get("endDateType"),testData.get("endDate") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testData.get("num2")),testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
					testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
			physicianPortal.OnceAShiftFrequency(Integer.parseInt(testData.get("num2")),testData.get("frequency"));
			physicianPortal.HowOftenMonthlytype(testData.get("TypeOfMode"),Integer.parseInt(testData.get("num2")),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("num2")),testData.get("howOften2"),testData.get("everyDay"),testData.get("DropdownNumber"),testData.get("DropdownDay"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num2")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),type);

			TestTemplate.testReport.logSuccess("Create Frequency With  Monthly HowOften Dropdown Option");
			physicianPortal.AddOrderFrequency();

			physicianPortal.OrderFrequencyType(Integer.parseInt(testData.get("num3")),testData.get("frequencyType"));		
			physicianPortal.StartDate(Integer.parseInt(testData.get("num3")),testData.get("startDate"),testData.get("startDateTime"));		
			physicianPortal.OrderEndType(Integer.parseInt(testData.get("num3")),Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,testData.get("endDateType"),testData.get("endDate") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testData.get("num3")),testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
					testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
			physicianPortal.OnceAShiftFrequency(Integer.parseInt(testData.get("num3")),testData.get("frequency"));
			physicianPortal.HowOftenMonthlytype(testData.get("TypeOfMode1"),Integer.parseInt(testData.get("num3")),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("num3")),testData.get("howOften2"),testData.get("everyDay"),testData.get("DropdownNumber"),testData.get("DropdownDay"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num3")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),type);



			TestTemplate.testReport.logSuccess("Create Frequency With Yearly HowOften Dropdown Option");
			physicianPortal.AddOrderFrequency();

			physicianPortal.OrderFrequencyType(Integer.parseInt(testData.get("num4")),testData.get("frequencyType"));		
			physicianPortal.StartDate(Integer.parseInt(testData.get("num4")),testData.get("startDate"),testData.get("startDateTime"));		
			physicianPortal.OrderEndType(Integer.parseInt(testData.get("num4")),Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,testData.get("endDateType"),testData.get("endDate") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));
			physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testData.get("num4")),testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
					testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
			physicianPortal.OnceAShiftFrequency(Integer.parseInt(testData.get("num4")),testData.get("frequency"));
			physicianPortal.HowOftenYearlyType(Integer.parseInt(testData.get("num4")),Integer.parseInt(testData.get("num")),testData.get("howOften3"),testData.get("scheduleOnMonth"),testData.get("everyDay"),testData.get("everyDay"));
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num4")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),type);*/
			physicianPortal.SaveOrderFrequency();


		}


		login.Logout();

	}



	@Test()
	public void QA095_AddingFrequencyFromOrders_WithFrequencyPRN(ITestContext testContext)
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 
		TestTemplate.testReport.logSuccess("Click to Clinical Portal From Menu Bar");
		homepage.NavigateToClinicalPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Clinical Portal");
		clinicalPortal.ClickOnResidentOrdersFromOrders();


		/*String ResidentNo = xlsReader.getCellData("clinicalPortal", 0, 24);
			String type1 = xlsReader.getCellData("clinicalPortal", 1, 24);
			String type2 = xlsReader.getCellData("clinicalPortal", 2, 24);
			String type3 = xlsReader.getCellData("clinicalPortal", 3, 24);
			String type4 = xlsReader.getCellData("clinicalPortal", 4, 24);
			String type5 = xlsReader.getCellData("clinicalPortal", 5, 24);
			String type6 = xlsReader.getCellData("clinicalPortal", 6, 24);
			String type7 = xlsReader.getCellData("clinicalPortal", 7, 24);
			String libraryText = xlsReader.getCellData("clinicalPortal", 8, 24);			
			String SearchDiogonosisTxt = xlsReader.getCellData("clinicalPortal", 9, 24);
			String medicarePriority = xlsReader.getCellData("clinicalPortal", 10, 24);
			String diogonosisName = xlsReader.getCellData("clinicalPortal", 11, 24);
			String physicianType = xlsReader.getCellData("clinicalPortal", 12, 24);
			String ReceivedByType = xlsReader.getCellData("clinicalPortal", 13, 24);
			String ReceivedOrderType = xlsReader.getCellData("clinicalPortal", 14, 24);		
			String routes = xlsReader.getCellData("clinicalPortal", 15, 24);
			String WrittenDate = xlsReader.getCellData("clinicalPortal", 16, 24);
			String NoOfRefillis = xlsReader.getCellData("clinicalPortal", 17, 24);
			String WhenToFill = xlsReader.getCellData("clinicalPortal", 18, 24);
			String num = xlsReader.getCellData("clinicalPortal", 19, 24);
			String frequencyType = xlsReader.getCellData("clinicalPortal", 20, 24);
			String startDate = xlsReader.getCellData("clinicalPortal", 21, 24);  
			String ByDate =startDate;
			String startDateTime = xlsReader.getCellData("clinicalPortal", 22, 24);
			String byDateTime =startDateTime ;
			String byDateno = xlsReader.getCellData("clinicalPortal", 23, 24);
			String afterNoOfAdminstrationsNo = xlsReader.getCellData("clinicalPortal", 24, 24);		
			String endDate = xlsReader.getCellData("clinicalPortal", 25, 24);
			String afterNumberOfAdminstrations = xlsReader.getCellData("clinicalPortal", 26, 24);
			String requiredActions = xlsReader.getCellData("clinicalPortal", 27, 24);
			String othersRequiredActions = xlsReader.getCellData("clinicalPortal", 28, 24);
			String requiredActionsPostDropdown = xlsReader.getCellData("clinicalPortal", 29, 24);
			String othersRequiredActionsPostDropdown = xlsReader.getCellData("clinicalPortal", 30, 24);
			String administeredBy = xlsReader.getCellData("clinicalPortal", 31, 24);
			String maxDoesHours = xlsReader.getCellData("clinicalPortal", 32, 24);
			String followUpAfterMinutes = xlsReader.getCellData("clinicalPortal", 33, 24);
			String slidingScaleMin = xlsReader.getCellData("clinicalPortal", 34, 24);
			String slidingScaleMax = xlsReader.getCellData("clinicalPortal", 35, 24);
			String slidingScaleUnits = xlsReader.getCellData("clinicalPortal", 36, 24);
			String frequency = xlsReader.getCellData("physicianportal", 37, 12);
			String howOften = xlsReader.getCellData("physicianportal", 38, 12);
			String everyDay = xlsReader.getCellData("physicianportal", 39, 12);
			String physicianInstructions = xlsReader.getCellData("clinicalPortal", 40, 24);
			String additionalInstruction = physicianInstructions ;
			String endDateType = xlsReader.getCellData("clinicalPortal", 42, 24);
			String endDateType1 = xlsReader.getCellData("clinicalPortal", 43, 24);
			String endDateType2 = xlsReader.getCellData("clinicalPortal", 44, 24);
			String TypeOfMode = xlsReader.getCellData("physicianportal", 45, 12);
			String howOften1 = xlsReader.getCellData("physicianportal", 46, 12);
			String howOften2 = xlsReader.getCellData("physicianportal", 47, 12);
			String howOften3 = xlsReader.getCellData("physicianportal", 48, 12);
			String DropdownNumber = xlsReader.getCellData("physicianportal", 49, 12);
			String DropdownDay = xlsReader.getCellData("physicianportal", 50, 12);
			String TypeOfMode1 = xlsReader.getCellData("physicianportal", 51, 12);
			String scheduleOnMonth = xlsReader.getCellData("physicianportal", 52, 12);*/

		final String TestCase = "QA095";

		HashMap<String , String > testData = xlsReader.GetValue(SheetName, TestCase);

		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));

		TestTemplate.testReport.logSuccess("Create Order With Treatment Dropdown Option");

		physicianPortal.GenarateRandomNumber();

		String[] Types = {testData.get("type1"),testData.get("type2")/*,testData.get("type3"),testData.get("type4"),testData.get("type5"),testData.get("type6"),testData.get("type7")*/};	
		int TypeSize = Types.length;
		for(int i=0;i<TypeSize;i++)

		{
			String Type = Types[i];


			TestTemplate.testReport.logSuccess("Create Order With Treatment Dropdown Option");

			String Description = testData.get("libraryText") + Type + physicianPortal.GenarateRandomNumber();

			physicianPortal.CreateAnOrderWithOrderDetails(Type,Description,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
			physicianPortal.OrderFrequencyType(Integer.parseInt(testData.get("num")),testData.get("frequencyType"));
			if(!Type.equals("Ancillaries"))
			{//(Integer.parseInt(testData.get("num"))+1)
				physicianPortal.StartDate(Integer.parseInt(testData.get("num")),testData.get("startDate"),testData.get("startDateTime"));
				physicianPortal.OrderEndType(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,testData.get("endDateType"),testData.get("endDate") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));
				physicianPortal.VerifyChkBxRequireSchedule(Integer.parseInt(testData.get("num")),Type);
				physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testData.get("num")),testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
						testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
			}
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),Type);
			physicianPortal.SaveOrderFrequency();

		}

		physicianPortal.OrderDisplayPageColourVerification();
		physicianPortal.OrderDisplayPageColoumnsVerification();

		login.Logout();
	}


	@Test()
	public void QA096_AddingFrequencyFromResidentOrder_WithFrequencyPRNEveryHour(ITestContext testContext)
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 
		TestTemplate.testReport.logSuccess("Click to Clinical Portal From Menu Bar");
		homepage.NavigateToClinicalPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Clinical Portal");
		clinicalPortal.ClickOnResidentOrdersFromOrders();


		/*String ResidentNo = xlsReader.getCellData("clinicalPortal", 0, 28);
			String type1 = xlsReader.getCellData("clinicalPortal", 1, 28);
			String type2 = xlsReader.getCellData("clinicalPortal", 2, 28);
			String type3 = xlsReader.getCellData("clinicalPortal", 3, 28);
			String type4 = xlsReader.getCellData("clinicalPortal", 4, 28);
			String type5 = xlsReader.getCellData("clinicalPortal", 5, 28);
			String type6 = xlsReader.getCellData("clinicalPortal", 6, 28);
			String type7 = xlsReader.getCellData("clinicalPortal", 7, 28);
			String libraryText = xlsReader.getCellData("clinicalPortal", 8, 28);			
			String SearchDiogonosisTxt = xlsReader.getCellData("clinicalPortal", 9, 28);
			String medicarePriority = xlsReader.getCellData("clinicalPortal", 10, 28);
			String diogonosisName = xlsReader.getCellData("clinicalPortal", 11, 28);
			String physicianType = xlsReader.getCellData("clinicalPortal", 12, 28);
			String ReceivedByType = xlsReader.getCellData("clinicalPortal", 13, 28);
			String ReceivedOrderType = xlsReader.getCellData("clinicalPortal", 14, 28);		
			String routes = xlsReader.getCellData("clinicalPortal", 15, 28);
			String WrittenDate = xlsReader.getCellData("clinicalPortal", 16, 28);
			String NoOfRefillis = xlsReader.getCellData("clinicalPortal", 17, 28);
			String WhenToFill = xlsReader.getCellData("clinicalPortal", 18, 28);
			String num = xlsReader.getCellData("clinicalPortal", 19, 28);
			String frequencyType = xlsReader.getCellData("clinicalPortal", 20, 28);
			String startDate = xlsReader.getCellData("clinicalPortal", 21, 28);  
			String ByDate =startDate;
			String startDateTime = xlsReader.getCellData("clinicalPortal", 22, 28);
			String byDateTime =startDateTime ;
			String byDateno = xlsReader.getCellData("clinicalPortal", 23, 28);
			String afterNoOfAdminstrationsNo = xlsReader.getCellData("clinicalPortal", 24, 28);		
			String endDate = xlsReader.getCellData("clinicalPortal", 25, 28);
			String afterNumberOfAdminstrations = xlsReader.getCellData("clinicalPortal", 26, 28);
			String requiredActions = xlsReader.getCellData("clinicalPortal", 27, 28);
			String othersRequiredActions = xlsReader.getCellData("clinicalPortal", 28, 28);
			String requiredActionsPostDropdown = xlsReader.getCellData("clinicalPortal", 29, 28);
			String othersRequiredActionsPostDropdown = xlsReader.getCellData("clinicalPortal", 30, 28);
			String administeredBy = xlsReader.getCellData("clinicalPortal", 31, 28);
			String maxDoesHours = xlsReader.getCellData("clinicalPortal", 32, 28);
			String followUpAfterMinutes = xlsReader.getCellData("clinicalPortal", 33, 28);
			String slidingScaleMin = xlsReader.getCellData("clinicalPortal", 34, 28);
			String slidingScaleMax = xlsReader.getCellData("clinicalPortal", 35, 28);
			String slidingScaleUnits = xlsReader.getCellData("clinicalPortal", 36, 28);
			String frequency = xlsReader.getCellData("physicianportal", 37, 12);
			String howOften = xlsReader.getCellData("physicianportal", 38, 12);
			String everyDay = xlsReader.getCellData("physicianportal", 39, 12);
			String physicianInstructions = xlsReader.getCellData("clinicalPortal", 40, 28);
			String additionalInstruction = physicianInstructions ;
			String endDateType = xlsReader.getCellData("clinicalPortal", 42, 28);
			String endDateType1 = xlsReader.getCellData("clinicalPortal", 43, 28);
			String endDateType2 = xlsReader.getCellData("clinicalPortal", 44, 28);
			String TypeOfMode = xlsReader.getCellData("physicianportal", 45, 12);
			String howOften1 = xlsReader.getCellData("physicianportal", 46, 12);
			String howOften2 = xlsReader.getCellData("physicianportal", 47, 12);
			String howOften3 = xlsReader.getCellData("physicianportal", 48, 12);
			String DropdownNumber = xlsReader.getCellData("physicianportal", 49, 12);
			String DropdownDay = xlsReader.getCellData("physicianportal", 50, 12);
			String TypeOfMode1 = xlsReader.getCellData("physicianportal", 51, 12);
			String scheduleOnMonth = xlsReader.getCellData("physicianportal", 52, 12);*/

		final String TestCase = "QA096";

		HashMap<String , String > testData = xlsReader.GetValue(SheetName, TestCase);

		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));

		TestTemplate.testReport.logSuccess("Create Order With Treatment Dropdown Option");



		String[] Types = {testData.get("type1"),testData.get("type2")/*,testData.get("type3"),testData.get("type4"),testData.get("type5"),testData.get("type6"),testData.get("type7")*/};	
		int TypeSize = Types.length;
		for(int i=0;i<TypeSize;i++)

		{
			String Type = Types[i];


			TestTemplate.testReport.logSuccess("Create Order With Treatment Dropdown Option");

			String Description = testData.get("libraryText") + Type + physicianPortal.GenarateRandomNumber();

			physicianPortal.CreateAnOrderWithOrderDetails(Type,Description,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
			physicianPortal.OrderFrequencyType(Integer.parseInt(testData.get("num")),testData.get("frequencyType"));
			if(!Type.equals("Ancillaries"))
			{
				physicianPortal.StartDate(Integer.parseInt(testData.get("num")),testData.get("startDate"),testData.get("startDateTime"));
				physicianPortal.OrderEndType(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,testData.get("endDateType"),testData.get("endDate") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));
				physicianPortal.VerifyChkBxRequireSchedule(Integer.parseInt(testData.get("num")),Type);
				physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testData.get("num")),testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
						testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
			}
			physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),Type);
			physicianPortal.SaveOrderFrequency();

		}

		physicianPortal.OrderDisplayPageColourVerification();
		physicianPortal.OrderDisplayPageColoumnsVerification();

		login.Logout();
	}

	@Test()
	public void QA097_ResidentOrders_CreateAnOrderUsingDetailsTypeTreatmentWithMedication_And_Medication(ITestContext testContext)
	{


		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 

		final String testCase = "QA097";

		HashMap<String ,String> testData = xlsReader.GetValue(SheetName,testCase);

		TestTemplate.testReport.logSuccess("Click to Clinical Portal From Menu Bar");
		homepage.NavigateToClinicalPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Clinical Portal");
		clinicalPortal.ClickOnResidentOrdersFromOrders();

		//	String ResidentNo = xlsReader.getCellData("clinicalPortal", 28, 32);

		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		physicianPortal.VerifyButtonInResidentOrders();			

		String[] frequencyTpyes = {testData.get("type1"),testData.get("type2")};
		for(int n=0;n<=1;n++)
		{
			String frequency = frequencyTpyes[n];

			//String[] receivedOrders = {testData.get("ReceivedOrderType7"),testData.get("ReceivedOrderType1"),testData.get("ReceivedOrderType2"),testData.get("ReceivedOrderType3"),testData.get("ReceivedOrderType4"),testData.get("ReceivedOrderType5"),testData.get("ReceivedOrderType6")};
			//String[] medicationtypes = {testData.get("medicationType"),testData.get("medicationType1"),testData.get("medicationType"),testData.get("medicationType1"),testData.get("medicationType"),testData.get("medicationType1"),testData.get("medicationType")};
			
			String[] receivedOrders = {testData.get("ReceivedOrderType7"),testData.get("ReceivedOrderType1"),testData.get("ReceivedOrderType2"),testData.get("ReceivedOrderType3")};
			String[] medicationtypes = {testData.get("medicationType"),testData.get("medicationType1"),testData.get("medicationType"),testData.get("medicationType1")};
			
			for(int i=0;i<2;i++)
			{
				String RecivedOrderType = receivedOrders[i];
				String medicationtype = medicationtypes[i];

				physicianPortal.ResidentFullOrderDetailsWithMedication(frequency,medicationtype,testData.get("searchMedicationName"),testData.get("libraryText1"));
				physicianPortal.ResidentFullOrderDetails(frequency ,testData.get("nullDiagonisis") ,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),RecivedOrderType,testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));

				physicianPortal.CancelOrder();	
				physicianPortal.CreateAnOrderPresent();

			}
		}
		
		

		login.Logout();


	}


	@Test()
	public void QA098_ResidentOrders_CreateAnOrderUsingDetailsTypeTreatmentWithMedication_And_Medication_FrequencyTypeRoutine(ITestContext testContext)
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 
		TestTemplate.testReport.logSuccess("Click to Clinical Portal From Menu Bar");
		homepage.NavigateToClinicalPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Clinical Portal");
		clinicalPortal.ClickOnResidentOrdersFromOrders();


		/*String ResidentNo = xlsReader.getCellData("clinicalPortal", 0, 36);
			String type1 = xlsReader.getCellData("clinicalPortal", 1, 36);
			String type2 = xlsReader.getCellData("clinicalPortal", 2, 36);
			String medicationType = xlsReader.getCellData("clinicalPortal", 3, 36);
			String medicationType1 = xlsReader.getCellData("clinicalPortal", 4, 36);
			String searchMedicationName = xlsReader.getCellData("clinicalPortal", 5, 36);
			String type6 = xlsReader.getCellData("clinicalPortal", 6, 36);
			String type7 = xlsReader.getCellData("clinicalPortal", 7, 36);
			String libraryText = xlsReader.getCellData("clinicalPortal", 8, 36);			
			String SearchDiogonosisTxt = xlsReader.getCellData("clinicalPortal", 9, 36);
			String medicarePriority = xlsReader.getCellData("clinicalPortal", 10, 36);
			String diogonosisName = xlsReader.getCellData("clinicalPortal", 11, 36);
			String physicianType = xlsReader.getCellData("clinicalPortal", 12, 36);
			String ReceivedByType = xlsReader.getCellData("clinicalPortal", 13, 36);
			String ReceivedOrderType = xlsReader.getCellData("clinicalPortal", 14, 36);		
			String routes = xlsReader.getCellData("clinicalPortal", 15, 36);
			String WrittenDate = xlsReader.getCellData("clinicalPortal", 16, 36);
			String NoOfRefillis = xlsReader.getCellData("clinicalPortal", 17, 36);
			String WhenToFill = xlsReader.getCellData("clinicalPortal", 18, 36);
			String num = xlsReader.getCellData("clinicalPortal", 19, 36);
			String frequencyType = xlsReader.getCellData("clinicalPortal", 20, 36);
			String startDate = xlsReader.getCellData("clinicalPortal", 21, 36);  
			String ByDate =startDate;
			String startDateTime = xlsReader.getCellData("clinicalPortal", 22, 36);
			String byDateTime =startDateTime ;
			String byDateno = xlsReader.getCellData("clinicalPortal", 23, 36);
			String afterNoOfAdminstrationsNo = xlsReader.getCellData("clinicalPortal", 24, 36);		
			String endDate = xlsReader.getCellData("clinicalPortal", 25, 36);
			String afterNumberOfAdminstrations = xlsReader.getCellData("clinicalPortal", 26, 36);
			String requiredActions = xlsReader.getCellData("clinicalPortal", 27, 36);
			String othersRequiredActions = xlsReader.getCellData("clinicalPortal", 28, 36);
			String requiredActionsPostDropdown = xlsReader.getCellData("clinicalPortal", 29, 36);
			String othersRequiredActionsPostDropdown = xlsReader.getCellData("clinicalPortal", 30, 36);
			String administeredBy = xlsReader.getCellData("clinicalPortal", 31, 36);
			String maxDoesHours = xlsReader.getCellData("clinicalPortal", 32, 36);
			String followUpAfterMinutes = xlsReader.getCellData("clinicalPortal", 33, 36);
			String slidingScaleMin = xlsReader.getCellData("clinicalPortal", 34, 36);
			String slidingScaleMax = xlsReader.getCellData("clinicalPortal", 35, 36);
			String slidingScaleUnits = xlsReader.getCellData("clinicalPortal", 36, 36);
			String frequency = xlsReader.getCellData("clinicalPortal", 37, 36);
			String howOften = xlsReader.getCellData("clinicalPortal", 38, 36);
			String everyDay = xlsReader.getCellData("clinicalPortal", 39, 36);
			String physicianInstructions = xlsReader.getCellData("clinicalPortal", 40, 36);
			String additionalInstruction = physicianInstructions ;
			String endDateType = xlsReader.getCellData("clinicalPortal", 42, 36);
			String endDateType1 = xlsReader.getCellData("clinicalPortal", 43, 36);
			String endDateType2 = xlsReader.getCellData("clinicalPortal", 44, 36);
			String TypeOfMode = xlsReader.getCellData("clinicalPortal", 45, 36);
			String howOften1 = xlsReader.getCellData("clinicalPortal", 46, 36);
			String howOften2 = xlsReader.getCellData("clinicalPortal", 47, 36);
			String howOften3 = xlsReader.getCellData("clinicalPortal", 48, 36);
			String DropdownNumber = xlsReader.getCellData("clinicalPortal", 49, 36);
			String DropdownDay = xlsReader.getCellData("clinicalPortal", 50, 36);
			String TypeOfMode1 = xlsReader.getCellData("clinicalPortal", 51, 36);
			String scheduleOnMonth = xlsReader.getCellData("clinicalPortal", 52, 36);*/

		final String testCase = "QA098";

		HashMap<String ,String> testData = xlsReader.GetValue(SheetName,testCase);

		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		physicianPortal.VerifyButtonInResidentOrders();

		TestTemplate.testReport.logSuccess("Create Order With Treatment Dropdown Option");
		int newnum;
		String[] frequencyTpyes = {testData.get("type1"),testData.get("type2")};
		for(int n=0;n<=1;n++)
		{
			String Frequency = frequencyTpyes[n];	

			physicianPortal.CreateAnOrderWithOrderDetails(Frequency,testData.get("libraryText"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));

			for( newnum=1;newnum<=5;newnum++)
			{
				physicianPortal.OrderFrequencyType(newnum,testData.get("frequencyType"));
				physicianPortal.StartDate(newnum,testData.get("startDate"),testData.get("startDateTime"));
				String[] OrderEndType = {testData.get("endDateType"),testData.get("endDateType1"),testData.get("endDateType2"),testData.get("endDateType"),testData.get("endDateType1")};

				String OrderEnd = OrderEndType[newnum-1];
				physicianPortal.OrderEndType(newnum,Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,OrderEnd,testData.get("endDate") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));

				physicianPortal.DoseUnitWithMedication(newnum,Frequency);
				physicianPortal.RequireActionRelatedLabel(newnum,testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
						testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));

				physicianPortal.OnceAShiftFrequency(newnum,testData.get("frequency"));
				switch(newnum)
				{
				case 1 :physicianPortal.HowOftenDailyType(newnum,testData.get("howOften"),testData.get("everyDay"));
				break;
				case 2 :physicianPortal.HowOftenWeeklytype(newnum,Integer.parseInt(testData.get("num")),testData.get("howOften1"),testData.get("everyDay"));
				break;		
				case 3 :physicianPortal.HowOftenMonthlytype(testData.get("TypeOfMode"),newnum,Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("num")),testData.get("howOften2"),testData.get("everyDay"),testData.get("DropdownNumber"),testData.get("DropdownDay"));
				break;	
				case 4 :physicianPortal.HowOftenMonthlytype(testData.get("TypeOfMode1"),newnum,(Integer.parseInt(testData.get("num"))+1),Integer.parseInt(testData.get("num")),testData.get("howOften2"),testData.get("everyDay"),testData.get("DropdownNumber"),testData.get("DropdownDay"));
				break;
				case 5 :physicianPortal.HowOftenYearlyType(newnum,Integer.parseInt(testData.get("num")),testData.get("howOften3"),testData.get("scheduleOnMonth"),testData.get("everyDay"),testData.get("everyDay"));
				break;

				}
				physicianPortal.CreateOrderFrequencyForRoutine(newnum,testData.get("physicianInstructions"),testData.get("physicianInstructions"),Frequency);
				physicianPortal.AddOrderFrequency();
			}
			physicianPortal.RemoveFrequency(newnum);		
			physicianPortal.SaveOrderFrequency();
			//physicianPortal.WhereToTabValidation();
			//physicianPortal.OrderDisplayPageColourVerification();
			//physicianPortal.OrderDisplayPageColoumnsVerification();


		}

		login.Logout();


	}

	//@Test()
	public void QA099_ResidentOrders_CreateAnOrderUsingDetailsTypeTreatmentWithMedication_And_Medication_WithFrequencyPRNEveryHour(ITestContext testContext)
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 
		TestTemplate.testReport.logSuccess("Click to Clinical Portal From Menu Bar");
		homepage.NavigateToClinicalPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Clinical Portal");
		clinicalPortal.ClickOnResidentOrdersFromOrders();


		/*String ResidentNo = xlsReader.getCellData("clinicalPortal", 0, 40);
			String type1 = xlsReader.getCellData("clinicalPortal", 1, 40);
			String type2 = xlsReader.getCellData("clinicalPortal", 2, 40);
			String medicationType = xlsReader.getCellData("clinicalPortal", 3, 40);
			String medicationType1 = xlsReader.getCellData("clinicalPortal", 4, 40);
			String searchMedicationName = xlsReader.getCellData("clinicalPortal", 5, 40);
			String type6 = xlsReader.getCellData("clinicalPortal", 6, 40);
			String type7 = xlsReader.getCellData("clinicalPortal", 7, 40);
			String libraryText = xlsReader.getCellData("clinicalPortal", 8, 40);			
			String SearchDiogonosisTxt = xlsReader.getCellData("clinicalPortal", 9, 40);
			String medicarePriority = xlsReader.getCellData("clinicalPortal", 10, 40);
			String diogonosisName = xlsReader.getCellData("clinicalPortal", 11, 40);
			String physicianType = xlsReader.getCellData("clinicalPortal", 12, 40);
			String ReceivedByType = xlsReader.getCellData("clinicalPortal", 13, 40);
			String ReceivedOrderType = xlsReader.getCellData("clinicalPortal", 14, 40);		
			String routes = xlsReader.getCellData("clinicalPortal", 15, 40);
			String WrittenDate = xlsReader.getCellData("clinicalPortal", 16, 40);
			String NoOfRefillis = xlsReader.getCellData("clinicalPortal", 17, 40);
			String WhenToFill = xlsReader.getCellData("clinicalPortal", 18, 40);
			//String num = xlsReader.getCellData("clinicalPortal", 19, 40);
			String frequencyType = xlsReader.getCellData("clinicalPortal", 20, 40);
			String startDate = xlsReader.getCellData("clinicalPortal", 21, 40);  
			String ByDate =startDate;
			String startDateTime = xlsReader.getCellData("clinicalPortal", 22, 40);
			String byDateTime =startDateTime ;
			String byDateno = xlsReader.getCellData("clinicalPortal", 23, 40);
			String afterNoOfAdminstrationsNo = xlsReader.getCellData("clinicalPortal", 24, 40);		
			String endDate = xlsReader.getCellData("clinicalPortal", 25, 40);
			String afterNumberOfAdminstrations = xlsReader.getCellData("clinicalPortal", 26, 40);
			String requiredActions = xlsReader.getCellData("clinicalPortal", 27, 40);
			String othersRequiredActions = xlsReader.getCellData("clinicalPortal", 28, 40);
			String requiredActionsPostDropdown = xlsReader.getCellData("clinicalPortal", 29, 40);
			String othersRequiredActionsPostDropdown = xlsReader.getCellData("clinicalPortal", 30, 40);
			String administeredBy = xlsReader.getCellData("clinicalPortal", 31, 40);
			String maxDoesHours = xlsReader.getCellData("clinicalPortal", 32, 40);
			String followUpAfterMinutes = xlsReader.getCellData("clinicalPortal", 33, 40);
			String slidingScaleMin = xlsReader.getCellData("clinicalPortal", 34, 40);
			String slidingScaleMax = xlsReader.getCellData("clinicalPortal", 35, 40);
			String slidingScaleUnits = xlsReader.getCellData("clinicalPortal", 36, 40);
			String frequency = xlsReader.getCellData("clinicalPortal", 37, 40);
			String howOften = xlsReader.getCellData("clinicalPortal", 38, 40);
			String everyDay = xlsReader.getCellData("clinicalPortal", 39, 40);
			String physicianInstructions = xlsReader.getCellData("clinicalPortal", 40, 40);
			String additionalInstruction = physicianInstructions ;
			String endDateType = xlsReader.getCellData("clinicalPortal", 42, 40);
			String endDateType1 = xlsReader.getCellData("clinicalPortal", 43, 40);
			String endDateType2 = xlsReader.getCellData("clinicalPortal", 44, 40);
			String TypeOfMode = xlsReader.getCellData("clinicalPortal", 45, 40);
			String howOften1 = xlsReader.getCellData("clinicalPortal", 46, 40);
			String howOften2 = xlsReader.getCellData("clinicalPortal", 47, 40);
			String howOften3 = xlsReader.getCellData("clinicalPortal", 48, 40);
			String DropdownNumber = xlsReader.getCellData("clinicalPortal", 49, 40);
			String DropdownDay = xlsReader.getCellData("clinicalPortal", 50, 40);
			String TypeOfMode1 = xlsReader.getCellData("clinicalPortal", 51, 40);
			String scheduleOnMonth = xlsReader.getCellData("clinicalPortal", 52, 40);*/

		final String testCase = "QA099";

		HashMap<String ,String> testData = xlsReader.GetValue(SheetName,testCase);

		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		physicianPortal.VerifyButtonInResidentOrders();

		TestTemplate.testReport.logSuccess("Create Order With Treatment Dropdown Option");
		int newnum;
		String[] frequencyTpyes = {testData.get("type1"),testData.get("type2")};
		for(int n=0;n<=1;n++)
		{
			String Frequency = frequencyTpyes[n];	

			physicianPortal.CreateAnOrderWithOrderDetails(Frequency,testData.get("libraryText"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));

			for( newnum=1;newnum<=3;newnum++)
			{
				physicianPortal.OrderFrequencyType(newnum,testData.get("frequencyType"));
				physicianPortal.StartDate(newnum,testData.get("startDate"),testData.get("startDateTime"));
				String[] OrderEndType = {testData.get("endDateType"),testData.get("endDateType1"),testData.get("endDateType2")};

				String OrderEnd = OrderEndType[newnum-1];
				physicianPortal.OrderEndType(newnum,Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,OrderEnd,testData.get("endDate") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));

				physicianPortal.DoseUnitWithMedication(newnum,Frequency);
				physicianPortal.RequireActionRelatedLabel(newnum,testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
						testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));

				physicianPortal.CreateOrderFrequencyForRoutine(newnum,testData.get("physicianInstructions"),testData.get("physicianInstructions"),Frequency);
				physicianPortal.AddOrderFrequency();
			}
			physicianPortal.RemoveFrequency(newnum);		
			physicianPortal.SaveOrderFrequency();
			//physicianPortal.WhereToTabValidation();
			physicianPortal.OrderDisplayPageColourVerification();
			physicianPortal.OrderDisplayPageColoumnsVerification();


		}

		login.Logout();	

	}

	//@Test()
	public void QA100_ResidentOrders_CreateAnOrderUsingDetailsTypeTreatmentWithMedication_And_Medication_WithFrequencyPRN(ITestContext testContext)
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 
		TestTemplate.testReport.logSuccess("Click to Clinical Portal From Menu Bar");
		homepage.NavigateToClinicalPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Clinical Portal");
		clinicalPortal.ClickOnResidentOrdersFromOrders();


		/*String ResidentNo = xlsReader.getCellData("clinicalPortal", 0, 44);
			String type1 = xlsReader.getCellData("clinicalPortal", 1, 44);
			String type2 = xlsReader.getCellData("clinicalPortal", 2, 44);
			String medicationType = xlsReader.getCellData("clinicalPortal", 3, 44);
			String medicationType1 = xlsReader.getCellData("clinicalPortal", 4, 44);
			String searchMedicationName = xlsReader.getCellData("clinicalPortal", 5, 44);
			String type6 = xlsReader.getCellData("clinicalPortal", 6, 44);
			String type7 = xlsReader.getCellData("clinicalPortal", 7, 44);
			String libraryText = xlsReader.getCellData("clinicalPortal", 8, 44);			
			String SearchDiogonosisTxt = xlsReader.getCellData("clinicalPortal", 9, 44);
			String medicarePriority = xlsReader.getCellData("clinicalPortal", 10, 44);
			String diogonosisName = xlsReader.getCellData("clinicalPortal", 11, 44);
			String physicianType = xlsReader.getCellData("clinicalPortal", 12, 44);
			String ReceivedByType = xlsReader.getCellData("clinicalPortal", 13, 44);
			String ReceivedOrderType = xlsReader.getCellData("clinicalPortal", 14, 44);		
			String routes = xlsReader.getCellData("clinicalPortal", 15, 44);
			String WrittenDate = xlsReader.getCellData("clinicalPortal", 16, 44);
			String NoOfRefillis = xlsReader.getCellData("clinicalPortal", 17, 44);
			String WhenToFill = xlsReader.getCellData("clinicalPortal", 18, 44);
			String num = xlsReader.getCellData("clinicalPortal", 19, 44);
			String frequencyType = xlsReader.getCellData("clinicalPortal", 20, 44);
			String startDate = xlsReader.getCellData("clinicalPortal", 21, 44);  
			String ByDate =startDate;
			String startDateTime = xlsReader.getCellData("clinicalPortal", 22, 44);
			String byDateTime =startDateTime ;
			String byDateno = xlsReader.getCellData("clinicalPortal", 23, 44);
			String afterNoOfAdminstrationsNo = xlsReader.getCellData("clinicalPortal", 24, 44);		
			String endDate = xlsReader.getCellData("clinicalPortal", 25, 44);
			String afterNumberOfAdminstrations = xlsReader.getCellData("clinicalPortal", 26, 44);
			String requiredActions = xlsReader.getCellData("clinicalPortal", 27, 44);
			String othersRequiredActions = xlsReader.getCellData("clinicalPortal", 28, 44);
			String requiredActionsPostDropdown = xlsReader.getCellData("clinicalPortal", 29, 44);
			String othersRequiredActionsPostDropdown = xlsReader.getCellData("clinicalPortal", 30, 44);
			String administeredBy = xlsReader.getCellData("clinicalPortal", 31, 44);
			String maxDoesHours = xlsReader.getCellData("clinicalPortal", 32, 44);
			String followUpAfterMinutes = xlsReader.getCellData("clinicalPortal", 33, 44);
			String slidingScaleMin = xlsReader.getCellData("clinicalPortal", 34, 44);
			String slidingScaleMax = xlsReader.getCellData("clinicalPortal", 35, 44);
			String slidingScaleUnits = xlsReader.getCellData("clinicalPortal", 36, 44);
			String frequency = xlsReader.getCellData("clinicalPortal", 37, 44);
			String howOften = xlsReader.getCellData("clinicalPortal", 38, 44);
			String everyDay = xlsReader.getCellData("clinicalPortal", 39, 44);
			String physicianInstructions = xlsReader.getCellData("clinicalPortal", 40, 44);
			String additionalInstruction = physicianInstructions ;
			String endDateType = xlsReader.getCellData("clinicalPortal", 42, 44);
			String endDateType1 = xlsReader.getCellData("clinicalPortal", 43, 44);
			String endDateType2 = xlsReader.getCellData("clinicalPortal", 44, 44);
			String TypeOfMode = xlsReader.getCellData("clinicalPortal", 45, 44);
			String howOften1 = xlsReader.getCellData("clinicalPortal", 46, 44);
			String howOften2 = xlsReader.getCellData("clinicalPortal", 47, 44);
			String howOften3 = xlsReader.getCellData("clinicalPortal", 48, 44);
			String DropdownNumber = xlsReader.getCellData("clinicalPortal", 49, 44);
			String DropdownDay = xlsReader.getCellData("clinicalPortal", 50, 44);
			String TypeOfMode1 = xlsReader.getCellData("clinicalPortal", 51, 44);
			String scheduleOnMonth = xlsReader.getCellData("clinicalPortal", 52, 44);*/

		final String testCase = "QA100";

		HashMap<String ,String> testData = xlsReader.GetValue(SheetName,testCase);

		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		physicianPortal.VerifyButtonInResidentOrders();

		TestTemplate.testReport.logSuccess("Create Order With Treatment Dropdown Option");
		int newnum;
		String[] frequencyTpyes = {testData.get("type1"),testData.get("type2")};
		for(int n=0;n<=1;n++)
		{
			String Frequency = frequencyTpyes[n];	

			physicianPortal.CreateAnOrderWithOrderDetails(Frequency,testData.get("libraryText"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));

			for( newnum=1;newnum<=3;newnum++)
			{
				physicianPortal.OrderFrequencyType(newnum,testData.get("frequencyType"));
				physicianPortal.StartDate(newnum,testData.get("startDate"),testData.get("startDateTime"));
				String[] OrderEndType = {testData.get("endDateType"),testData.get("endDateType1"),testData.get("endDateType2")};

				String OrderEnd = OrderEndType[newnum-1];
				physicianPortal.OrderEndType(newnum,Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,OrderEnd,testData.get("endDate") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));

				physicianPortal.DoseUnitWithMedication(newnum,Frequency);
				physicianPortal.RequireActionRelatedLabel(newnum,testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
						testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));

				physicianPortal.CreateOrderFrequencyForRoutine(newnum,testData.get("physicianInstructions"),testData.get("physicianInstructions"),Frequency);
				physicianPortal.AddOrderFrequency();
			}
			physicianPortal.RemoveFrequency(newnum);		
			physicianPortal.SaveOrderFrequency();
			physicianPortal.WhereToTabValidation();
			physicianPortal.OrderDisplayPageColourVerification();
			physicianPortal.OrderDisplayPageColoumnsVerification();


		}

		login.Logout();

	}


	//@Test()
	public void QA101_CreateAnOrder_ViaOrderSets (ITestContext testContext) throws InterruptedException
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		Random rand = new Random(System.currentTimeMillis());

	
		final String testCase = "QA101";
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 

		HashMap<String ,String> testData = xlsReader.GetValue(SheetName,testCase);

		int newnum;
		String[] FrequencyTypes = {testData.get("frequencyType1"),testData.get("frequencyType2"),testData.get("frequencyType3")};

		homepage.NavigateToFacilityPortal();
		facilityPage.ManageOrdersSets();
		String[] OrderType = {testData.get("type8")/*,testData.get("type1")*/};
		{
			for(int i=0;i<=1;i++)
			{
				String RequiredType = OrderType[i];

				if(RequiredType.equals(testData.get("type8")))
				{			
					facilityPage.CreateOrderSetDescription(testData.get("description"),RequiredType, testData.get("routes") , testData.get("libraryText"));
				}
				else
				{			
					facilityPage.CreateOrderSetDescription(testData.get("description"),RequiredType,testData.get("routes"),testData.get("libraryText"));
				}



				for( newnum=2; newnum<=4;newnum++)
				{
					String Frequency = FrequencyTypes[newnum-2];
					physicianPortal.OrderFrequencyType((newnum-1),Frequency);	
					physicianPortal.VerifyChkBxRequireSchedule((newnum-1),RequiredType);
					physicianPortal.RequireActionRelatedLabel(newnum,Frequency ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
							testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
					if(Frequency.equals(testData.get("frequencyType1")))
					{
						physicianPortal.OnceAShiftFrequency((newnum-1),testData.get("frequency"));
						physicianPortal.HowOftenDailyType((newnum-1),testData.get("howOften"),testData.get("everyDay"));
					}
					physicianPortal.CreateOrderFrequencyForRoutine((newnum-1),testData.get("physicianInstructions"),testData.get("physicianInstructions"),RequiredType);
					if(Frequency!=testData.get("frequencyType3"))
					{
						physicianPortal.AddOrderFrequency();
					}
				}
				if(RequiredType.equals(testData.get("type8")))
				{
					facilityPage.AddOder();
				}
			}
		}
		physicianPortal.SaveOrderFrequency();


		facilityPage.VerifyManageOrderFromSets(testData.get("description"));



		TestTemplate.testReport.logSuccess("Click to Clinical Portal From Menu Bar");
		homepage.NavigateToClinicalPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Clinical Portal");
		clinicalPortal.ClickOnResidentOrdersFromOrders();	

		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		physicianPortal.VerifyButtonInResidentOrders();
		physicianPortal.CreateFromSet();
		physicianPortal.SelectOrderFromOrderSets(testData.get("description"));
		physicianPortal.VerifyAnyOrderFromSet();


		for( newnum=2; newnum<=4;newnum++)
		{
			String Frequency = FrequencyTypes[newnum-2];
			physicianPortal.VerifyTheFieldsinFrequencyInOrdersInSets(newnum,Frequency);
		}

		physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type8"),testData.get("libraryText"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));

		physicianPortal.ClickToNewOrder();

		for( newnum=2; newnum<=4;newnum++)
		{
			String Frequency = FrequencyTypes[newnum-2];
			physicianPortal.VerifyTheFieldsinFrequencyInOrdersInSets(newnum,Frequency);
		}

		String TypeName = physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type1"),testData.get("description"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.VerifyIgnoreOrderSet();
		physicianPortal.SaveOrderFrequency();
		physicianPortal.OrdersSelection(TypeName ,testData.get("libraryText"));

		login.Logout();
	}


	//@Test()
	public void QA102_ViewAndModifyAnOrder_ViaOrderSets (ITestContext testContext) throws AWTException, InterruptedException
	{

		PhysicianPortalTestCases.testReport.logSuccess("QA102_ViewAndModifyAnOrder_ViaOrderSets" , "Verify View And Modify An Order Via Order Sets");

		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		Random rand = new Random(System.currentTimeMillis());

		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 


		final String testCase = "QA102";

		HashMap<String ,String> testData = xlsReader.GetValue(SheetName,testCase);


		int newnum;
		String[] FrequencyTypes = {testData.get("frequencyType1"),testData.get("frequencyType2"),testData.get("frequencyType3")};

		homepage.NavigateToFacilityPortal();

		String Description = testData.get("description")+physicianPortal.GenarateRandomNumber();

		String[] OrderType = {testData.get("type1"),testData.get("type8")};
		{
			for(int i=0;i<=1;i++)
			{
				String RequiredType = OrderType[i];	
				{
					facilityPage.ManageOrdersSets();
					Thread.sleep(2000);
					if(RequiredType.equals(testData.get("type1")))
					{
						facilityPage.CreateOrderSetDescription(Description,RequiredType,testData.get("routes"),testData.get("libraryText"));
					}
					else
					{
						facilityPage.CreateOrderSetDescription(testData.get("libraryText"),RequiredType,testData.get("routes"),testData.get("libraryText"));
					}

					for( newnum=2; newnum<=4;newnum++)
					{
						String Frequency = FrequencyTypes[newnum-2];
						physicianPortal.OrderFrequencyType((newnum-1),Frequency);	
						physicianPortal.VerifyChkBxRequireSchedule((newnum-1),RequiredType);
						physicianPortal.RequireActionRelatedLabel(newnum-1,Frequency ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
								testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
						if(Frequency.equals(testData.get("frequencyType1")))
						{
							physicianPortal.OnceAShiftFrequency((newnum-1),testData.get("frequency"));
							physicianPortal.HowOftenDailyType((newnum-1),testData.get("howOften"),testData.get("everyDay"));
						}
						physicianPortal.CreateOrderFrequencyForRoutine((newnum-1),testData.get("physicianInstructions"),testData.get("physicianInstructions"),testData.get("type1"));
						if(Frequency!=testData.get("frequencyType3"))
						{
							physicianPortal.AddOrderFrequency();
						}
					}
				}

				physicianPortal.SaveOrderFrequency();	
			}
			facilityPage.VerifyManageOrderFromSets(Description);
			facilityPage.VerifyManageOrderFromSets(testData.get("libraryText"));


			TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
			homepage.NavigateToClinicalPortal();

			TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
			clinicalPortal.ClickOnResidentOrdersFromOrders();

			TestTemplate.testReport.logSuccess("Click On existing Resident");
			physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
			physicianPortal.VerifyButtonInResidentOrders();
			physicianPortal.CreateFromSet();
			physicianPortal.SelectOrderFromOrderSets(testData.get("libraryText"));
			String TypeName = physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type8"),testData.get("libraryText"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
			physicianPortal.SaveOrderFrequency();	
			physicianPortal.OrdersPageTextVerification();
			physicianPortal.OrdersSelection(TypeName ,testData.get("libraryText"));			
			physicianPortal.VerifyButtonInResidentOrders();
			physicianPortal.OrdersDisplayPageForPerticularResident(testData.get("type8"));
			physicianPortal.ClickingOnCreatedOrder(testData.get("libraryText"));
			physicianPortal.VerifyButtonsInOrdersAndFrequency();
			physicianPortal.ModifyOrderPageDetail(testData.get("libraryText"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType1"),testData.get("ReceivedByType1"),testData.get("ReceivedOrderType1"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
			physicianPortal.ModifyOrderFrequency(Integer.parseInt(testData.get("modifyButtonNo")),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy1") ,testData.get("maxDoesHours") ,
					testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));
			physicianPortal.AddHoldDatesVerification(testData.get("startDate"),testData.get("endDate"),testData.get("startDateTime"),testData.get("startDateTime"),Integer.parseInt(testData.get("slidingScaleMin")) );


			physicianPortal.DiscontinueOrderValidation(testData.get("startDate"),testData.get("startDateTime"),testData.get("physicianType1"),testData.get("ReceivedOrderType1"),testData.get("discontinueForCorrection"),testData.get("copyOrder"),testData.get("dcMessage"));
			physicianPortal.DiscontinueValidation(testData.get("discontinueForCorrection"),testData.get("copyOrder"),testData.get("dcMessage"));

			physicianPortal.OrderPagePrirtValidation();
			//	physicianPortal.ArrowButtonVerification();

			physicianPortal.OrderPageCopyOrderValidation(testData.get("type8"),testData.get("libraryText"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
			physicianPortal.FillOrderPageFrequency(Integer.parseInt(testData.get("modifyButtonNo")),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy1") ,testData.get("maxDoesHours") ,
					testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"),testData.get("type8"),testData.get("libraryText"));
			physicianPortal.VerifyButtonInResidentOrders();
			physicianPortal.CreateFromSet();
			physicianPortal.SelectOrderFromOrderSets(Description);
			String TypeName2 = physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type1"),Description,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
			physicianPortal.SaveOrderFrequency();	
			physicianPortal.OrdersSelection(TypeName2 , Description);
			physicianPortal.OrdersDisplayPageForPerticularResident(testData.get("type1"));
			physicianPortal.ClickingOnCreatedOrder(Description);
			physicianPortal.VerifyButtonsInOrdersAndFrequency();
			physicianPortal.CancelOrderPageDetail(testData.get("libraryText"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType1"),testData.get("ReceivedByType1"),testData.get("ReceivedOrderType1"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
			physicianPortal.CancelOrderFrequency(Integer.parseInt(testData.get("modifyButtonNo")),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy1") ,testData.get("maxDoesHours") ,
					testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));
			physicianPortal.DiscontinueOrderValidation(testData.get("startDate"),testData.get("startDateTime"),testData.get("physicianType1"),testData.get("ReceivedOrderType1"),testData.get("discontinueForCorrection1"),testData.get("copyOrder1"),testData.get("dcMessage1"));
			physicianPortal.DiscontinueValidation(testData.get("discontinueForCorrection1"),testData.get("copyOrder1"),testData.get("dcMessage1"));
			physicianPortal.CancelOrder();

			login.Logout();

		}
	}



	//@Test()
	public void QA103_VerifyAnOrder_ViaOrderSetsOrCreateAnOrder (ITestContext testContext) throws AWTException
	{

		PhysicianPortalTestCases.testReport.logSuccess("QA20_VerifyAnOrder_ViaOrderSetsOrCreateAnOrder" , "Verify An Order Via Order Sets/Create An Order");

		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);		
		final String testCase = "QA103";

		HashMap<String , String> testData = xlsReader.GetValue(SheetName, testCase);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 

		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToClinicalPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		clinicalPortal.ClickOnResidentOrdersFromOrders();	

		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		physicianPortal.VerifyButtonInResidentOrders();

		String Description = testData.get("description") + physicianPortal.GenarateRandomNumber();

		String TypeName = physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type1"),Description,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.CreateOrderFrequency(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));


		physicianPortal.SaveOrderFrequency();		



		physicianPortal.OrdersSelection(TypeName,Description);
		physicianPortal.ClickOnListViewForNavigateToOrdersView();
		physicianPortal.VerifyTheOrderByClickingVerifyButton();
		physicianPortal.OrdersPageTextVerification();
		/*physicianPortal.VerifyCreatedOrderIntheVerifyList(Description);
			physicianPortal.PharmacyValidation();
			physicianPortal.OrdersDisplayPageForPerticularResident(testData.get("type1"));
			physicianPortal.VerifyButtonsInVerifyOrders();
			physicianPortal.ArrowButtonVerification();
			physicianPortal.VerifyClickingOnToggledVerifiedButton();*/


		login.Logout();
	}




	@Test()
	public void QA104_VerifyAndModifyAnOrder_ViaOrderSetsOrCreateAnOrder (ITestContext testContext) throws AWTException, InterruptedException
	{



		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);

		final String testCase = "QA104";

		HashMap<String , String> testData = xlsReader.GetValue(SheetName, testCase);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 
		TestTemplate.testReport.logSuccess("Click to Clinical Portal From Menu Bar");
		homepage.NavigateToClinicalPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Clinical Portal");
		clinicalPortal.ClickOnResidentOrdersFromOrders();	

		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		physicianPortal.VerifyButtonInResidentOrders();

		String Description = testData.get("description") + physicianPortal.GenarateRandomNumber();

		String TypeName = physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type1"),Description,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.CreateOrderFrequency(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));


		physicianPortal.SaveOrderFrequency();

		physicianPortal.OrdersSelection(TypeName,Description);
		//physicianPortal.ClickOnListViewForNavigateToOrdersView();
		physicianPortal.VerifyTheOrderByClickingVerifyButton();
		physicianPortal.OrdersPageTextVerification();
		



		login.Logout();


	}


	@Test()
	public void QA105_SignAnOrder_ViaOrderSetsOrCreateAnOrder (ITestContext testContext) throws AWTException
	{

		PhysicianPortalTestCases.testReport.logSuccess("QA20_SignAnOrder_ViaOrderSetsOrCreateAnOrder" , "Verify Sign An Order Via Order Sets/Create An Order");

		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 

		final String testCase = "QA105";
		HashMap<String , String> testData = xlsReader.GetValue(SheetName, testCase);		

		TestTemplate.testReport.logSuccess("Click to Clinical Portal From Menu Bar");
		homepage.NavigateToClinicalPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Clinical Portal");
		clinicalPortal.ClickOnResidentOrdersFromOrders();

		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));

		String Description = testData.get("description") + physicianPortal.GenarateRandomNumber();

		physicianPortal.VerifyButtonInResidentOrders();

		String TypeName = physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type1"),Description,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.CreateOrderFrequency(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("num")),testData.get("frequencyType1"),testData.get("endDate"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));




		physicianPortal.SaveOrderFrequency();			
		physicianPortal.OrdersSelection(TypeName,Description);


		//physicianPortal.ClickOnListViewForNavigateToOrdersView();

		/*physicianPortal.VerifyTheOrderByClickingVerifyButton();
			physicianPortal.VerifyCreatedOrderIntheVerifyList(Description);
			physicianPortal.VerifyClickingOnToggledVerifiedButton();*/

		physicianPortal.VerifyTheOrderByClickingSignButton();
		physicianPortal.OrdersPageTextVerification();
		physicianPortal.VerifyCreatedOrderIntheVerifyList(Description);
		//physicianPortal.PharmacyValidation();
		physicianPortal.OrdersDisplayPageForPerticularResident(testData.get("type1"));
		physicianPortal.VerifyButtonsInSignOrders();		
		physicianPortal.VerifyClickingOnToggledSignedButton();
		physicianPortal.ArrowButtonVerification();
		physicianPortal.VerifyAddSignatureButton();
		physicianPortal.VerifySignOrdersViaAddSignature();


		login.Logout();
	}


	//@Test()
	public void QA106_ViewAndModifyAnOrder_ViaOrderSetsOrCreateAnOrder (ITestContext testContext) throws AWTException, InterruptedException
	{

		PhysicianPortalTestCases.testReport.logSuccess("QA21_VerifyAndModifyAnOrder_ViaOrderSetsOrCreateAnOrder" , "Verify And Modify An Order Via Order Sets/Create An Order");

		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 

		final String testCase = "QA106";

		HashMap<String , String> testData = xlsReader.GetValue(SheetName, testCase);

		TestTemplate.testReport.logSuccess("Click to Clinical Portal From Menu Bar");
		homepage.NavigateToClinicalPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Clinical Portal");
		clinicalPortal.ClickOnResidentOrdersFromOrders();	

		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		physicianPortal.VerifyButtonInResidentOrders();

		String Description = testData.get("description") + physicianPortal.GenarateRandomNumber();

		String TypeName = physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type1"),Description,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.CreateOrderFrequency(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));



		physicianPortal.SaveOrderFrequency();

		physicianPortal.OrdersSelection(TypeName,Description);
		//physicianPortal.ClickOnListViewForNavigateToOrdersView();
		/*physicianPortal.VerifyTheOrderByClickingVerifyButton();
			physicianPortal.VerifyCreatedOrderIntheVerifyList(Description);
			physicianPortal.VerifyClickingOnToggledVerifiedButton();*/
		physicianPortal.VerifyTheOrderByClickingSignButton();
		physicianPortal.OrdersPageTextVerification();
		physicianPortal.VerifyCreatedOrderIntheVerifyList(Description);
		//physicianPortal.PharmacyValidation();
		physicianPortal.OrdersDisplayPageForPerticularResident(testData.get("type1"));
		physicianPortal.VerifyButtonsInSignOrders();
		physicianPortal.VerifyButtonsInOrdersAndFrequency();
		physicianPortal.ModifyOrderPageDetail(Description,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType1"),testData.get("ReceivedByType1"),testData.get("ReceivedOrderType1"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.ModifyOrderFrequency(Integer.parseInt(testData.get("modifyButtonNo")),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy1") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));
		//physicianPortal.AddHoldDatesVerification(testData.get("startDate"),testData.get("endDate"),testData.get("startDateTime"),testData.get("startDateTime"),Integer.parseInt(testData.get("slidingScaleMin")) );


		physicianPortal.DiscontinueOrderValidation(testData.get("startDate"),testData.get("startDateTime"),testData.get("physicianType1"),testData.get("ReceivedOrderType1"),testData.get("discontinueForCorrection"),testData.get("copyOrder"),testData.get("dcMessage"));
		physicianPortal.DiscontinueValidation(testData.get("discontinueForCorrection"),testData.get("copyOrder"),testData.get("dcMessage"));



		/*physicianPortal.OrderPagePrirtValidation();

		String Description2 = testData.get("description2") + physicianPortal.GenarateRandomNumber();
		physicianPortal.OrderPageCopyOrderValidation(testData.get("type1"),Description2,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.FillOrderPageFrequency(Integer.parseInt(testData.get("modifyButtonNo")),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy1") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"),testData.get("type1"),Description2);
		
		physicianPortal.VerifyTheOrderByClickingVerifyButton();
			physicianPortal.VerifyCreatedOrderIntheVerifyList(Description2);
			physicianPortal.VerifyClickingOnToggledVerifiedButton();
		physicianPortal.VerifyTheOrderByClickingSignButton();

		physicianPortal.VerifyCreatedOrderIntheVerifyList(Description2);
		physicianPortal.ArrowButtonVerification();
		physicianPortal.VerifyAddSignatureButton();
		physicianPortal.VerifySignOrdersViaAddSignature();

		clinicalPortal.ClickOnResidentOrdersFromOrders();			
		physicianPortal.VerifyButtonInResidentOrders();

		String Description1 = testData.get("description1") + physicianPortal.GenarateRandomNumber();


		String TypeName1 =physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type1"),Description1,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.CreateOrderFrequency(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));

		physicianPortal.SaveOrderFrequency();

		physicianPortal.OrdersSelection(TypeName1,Description1);
		physicianPortal.ClickOnListViewForNavigateToOrdersView();
		physicianPortal.VerifyTheOrderByClickingVerifyButton();
			physicianPortal.VerifyCreatedOrderIntheVerifyList(Description1);
			physicianPortal.VerifyClickingOnToggledVerifiedButton();
		physicianPortal.VerifyTheOrderByClickingSignButton();
		physicianPortal.VerifyCreatedOrderIntheVerifyList(Description1);

		physicianPortal.CancelOrderPageDetail(Description1,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType1"),testData.get("ReceivedByType1"),testData.get("ReceivedOrderType1"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.CancelOrderFrequency(Integer.parseInt(testData.get("modifyButtonNo")),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy1") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));


		physicianPortal.DiscontinueOrderValidation(testData.get("startDate"),testData.get("startDateTime"),testData.get("physicianType1"),testData.get("ReceivedOrderType1"),testData.get("discontinueForCorrection1"),testData.get("copyOrder1"),testData.get("dcMessage1"));
		physicianPortal.DiscontinueValidation(testData.get("discontinueForCorrection1"),testData.get("copyOrder1"),testData.get("dcMessage1"));



*/

		login.Logout();


	}


	//@Test()
	public void QA107_RecapAnOrder_ViaOrderSetsOrCreateAnOrder (ITestContext testContext) throws AWTException, InterruptedException
	{

		PhysicianPortalTestCases.testReport.logSuccess("QA024_RecapAnOrder_ViaOrderSetsOrCreateAnOrder" , "Recap An Order Via OrderSets Or CreateAnOrder");

		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 
		final String testCase = "QA107";

		HashMap<String , String> testData = xlsReader.GetValue(SheetName, testCase);

		TestTemplate.testReport.logSuccess("Click to Clinical Portal From Menu Bar");
		homepage.NavigateToClinicalPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Clinical Portal");
		clinicalPortal.ClickOnResidentOrdersFromOrders();

		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		physicianPortal.VerifyButtonInResidentOrders();

		String Description = testData.get("description") + physicianPortal.GenarateRandomNumber();

		String TypeName = physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type1"),Description,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.CreateOrderFrequency(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));





		physicianPortal.SaveOrderFrequency();

		physicianPortal.OrdersSelection(TypeName,Description);
		//physicianPortal.ClickOnListViewForNavigateToOrdersView();
		/*physicianPortal.VerifyTheOrderByClickingVerifyButton();
			physicianPortal.VerifyCreatedOrderIntheVerifyList(Description);
			physicianPortal.VerifyClickingOnToggledVerifiedButton();*/
		physicianPortal.VerifyTheOrderByClickingSignButton();
		physicianPortal.VerifyCreatedOrderIntheVerifyList(Description);

		String Resident = physicianPortal.VerifyClickingOnToggledSignedButton();
		physicianPortal.VerifyAddSignatureButton();
		physicianPortal.VerifySignOrdersViaAddSignature();

		physicianPortal.VerifyTheOrderByClickingRecapButton();
		physicianPortal.VerifyRecapDropDownList();
		physicianPortal.RecapePageTextVerification();
		physicianPortal.ClickOnCreateRecap();
		physicianPortal.VerifyRecapDescription(Description);
		physicianPortal.VerifyResidentStatus(testData.get("Option"),testData.get("ResidentStatus"));
		physicianPortal.VerifyResidentStations(testData.get("Option"),testData.get("Stations"));

		physicianPortal.VerifyRecapResidents(Resident,testData.get("Residents"));
		physicianPortal.VerifyRecapOthers(testData.get("Option"),testData.get("OrderStatus"));
		physicianPortal.VerifyRecapPhysicians(testData.get("physicianType"),testData.get("Physicians"));
		physicianPortal.VerifyRecapeDate();
		physicianPortal.RecapApplyFilter();
		physicianPortal.RecapPageButtonmVerification();
		physicianPortal.OrdersPageTextVerification();
		physicianPortal.VerifyOrderInCreateRecapsWithoutCheckingTheCheckBox(Description);

		physicianPortal.ArrowButtonVerification();
		physicianPortal.ClickOnListViewForNavigateToOrdersView();
		physicianPortal.VerifyOrderInCreateRecapsWithoutCheckingTheCheckBox(Description);
		//physicianPortal.PharmacyValidation();
		physicianPortal.OrdersDisplayPageForPerticularResident(testData.get("type1"));
		physicianPortal.RecapPageButtonmVerification();
		physicianPortal.VerifyToggleRecapAll();
		physicianPortal.VerifyToggleRecap();

		physicianPortal.OrderPagePrirtValidation();

		physicianPortal.DiscontinueOrderValidation(testData.get("startDate"),testData.get("startDateTime"),testData.get("physicianType1"),testData.get("ReceivedOrderType1"),testData.get("discontinueForCorrection"),testData.get("copyOrder"),testData.get("dcMessage"));
		//
		physicianPortal.DiscontinueValidation(testData.get("discontinueForCorrection"),testData.get("copyOrder"),testData.get("dcMessage"));




		String Description1 = testData.get("description1") + physicianPortal.GenarateRandomNumber();
		physicianPortal.ScrollUp(TestTemplate.threadLocalWebDriver.get());
		physicianPortal.WindowpopUpCopy(TestTemplate.threadLocalWebDriver.get(),"Copy");
		/*physicianPortal.CancelOrder();
			physicianPortal.CancelOrder();
			clinicalPortal.ClickOnResidentOrdersFromOrders();

			String TypeName1 = physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type1"),Description1,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
			physicianPortal.CreateOrderFrequency(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy") ,testData.get("maxDoesHours") ,
					testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));

			physicianPortal.SaveOrderFrequency();

			physicianPortal.OrdersSelection(TypeName,Description);
			physicianPortal.ClickOnListViewForNavigateToOrdersView();*/

		physicianPortal.OrderPageCopyOrderValidation(testData.get("type1"),Description1,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));

		physicianPortal.CancelOrder();
		clinicalPortal.ClickOnResidentOrdersFromOrders();

		String TypeName1 = physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type1"),Description1,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.CreateOrderFrequency(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));

		physicianPortal.SaveOrderFrequency();
		//physicianPortal.VerifyButtonInResidentOrders();

		/*physicianPortal.VerifyTheOrderByClickingVerifyButton();
			physicianPortal.VerifyCreatedOrderIntheVerifyList(Description1);
			physicianPortal.VerifyClickingOnToggledVerifiedButton();*/
		physicianPortal.VerifyTheOrderByClickingSignButton();
		physicianPortal.VerifyCreatedOrderIntheVerifyList(Description1);

		physicianPortal.VerifyClickingOnToggledSignedButton();
		physicianPortal.VerifyAddSignatureButton();
		physicianPortal.VerifySignOrdersViaAddSignature();

		physicianPortal.VerifyTheOrderByClickingRecapButton();
		physicianPortal.ClickOnCreateRecap();
		physicianPortal.VerifyRecapDescription(Description1);
		physicianPortal.VerifyResidentStatus(testData.get("Option"),testData.get("ResidentStatus"));
		physicianPortal.VerifyResidentStations(testData.get("Option"),testData.get("Stations"));

		physicianPortal.VerifyRecapResidents(Resident,testData.get("Residents"));
		physicianPortal.VerifyRecapOthers(testData.get("Option"),testData.get("OrderStatus"));
		physicianPortal.VerifyRecapPhysicians(testData.get("physicianType"),testData.get("Physicians"));
		physicianPortal.VerifyRecapeDate();
		physicianPortal.RecapApplyFilter();
		physicianPortal.VerifyOrderInCreateRecaps(Description1);
		//physicianPortal.VerifyRecapFromCheckBox();
		//physicianPortal.RecapButtonCount();
		physicianPortal.VerifyToggleRecapAll();
		//physicianPortal.VerifyToggleRecap();
		physicianPortal.VerifyOrderInCreateRecapsWithoutCheckingTheCheckBox(Description1);

		physicianPortal.DiscontinueOrderValidation(testData.get("startDate"),testData.get("startDateTime"),testData.get("physicianType1"),testData.get("ReceivedOrderType1"),testData.get("discontinueForCorrection1"),testData.get("copyOrder1"),testData.get("dcMessage1"));
		physicianPortal.RobotWork();
		physicianPortal.DiscontinueValidation(testData.get("discontinueForCorrection1"),testData.get("copyOrder1"),testData.get("dcMessage1"));
		physicianPortal.CancelOrder();

		/*physicianPortal.ScrollUp(TestTemplate.threadLocalWebDriver.get());
			physicianPortal.WindowpopUpCopy(TestTemplate.threadLocalWebDriver.get(),"Recap");*/
		physicianPortal.VerifyTheOrderByClickingRecapButton();
		physicianPortal.ClickOnCreateRecap();
		physicianPortal.RobotWork();
		physicianPortal.VerifyRecapDescription(Description1);
		physicianPortal.VerifyResidentStatus(testData.get("Option"),testData.get("ResidentStatus"));
		physicianPortal.VerifyResidentStations(testData.get("Option"),testData.get("Stations"));

		physicianPortal.VerifyRecapResidents(Resident,testData.get("Residents"));
		physicianPortal.VerifyRecapOthers(testData.get("Option"),testData.get("OrderStatus"));
		physicianPortal.VerifyRecapPhysicians(testData.get("physicianType"),testData.get("Physicians"));
		physicianPortal.VerifyRecapeDate();
		physicianPortal.RecapApplyFilter();
		physicianPortal.VerifyOrderInCreateRecapsWithoutCheckingTheCheckBox(Description1);
		//physicianPortal.VerifyToggleRecap();
		physicianPortal.VerifyAddSignatureButton();
		physicianPortal.VerifySignOrdersViaAddSignature();



		login.Logout();



	}


	//@Test()
	public void QA108_SignatureOnRecap_Wheather_OrderCreatedFromOrder_Or_FromSets (ITestContext testContext) throws AWTException
	{

		PhysicianPortalTestCases.testReport.logSuccess("QA21_VerifyAndModifyAnOrder_ViaOrderSetsOrCreateAnOrder" , "Verify And Modify An Order Via Order Sets/Create An Order");

		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 

		final String testCase = "QA108";

		HashMap<String , String> testData = xlsReader.GetValue(SheetName, testCase);

		TestTemplate.testReport.logSuccess("Click to Clinical Portal From Menu Bar");
		homepage.NavigateToClinicalPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Clinical Portal");
		clinicalPortal.ClickOnResidentOrdersFromOrders();	

		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		physicianPortal.VerifyButtonInResidentOrders();

		String Description = testData.get("description") + physicianPortal.GenarateRandomNumber();

		String TypeName =physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type1"),Description,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.CreateOrderFrequency(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));





		physicianPortal.SaveOrderFrequency();

		physicianPortal.OrdersSelection(TypeName,Description);
		physicianPortal.ClickOnListViewForNavigateToOrdersView();
		/*physicianPortal.VerifyTheOrderByClickingVerifyButton();
			physicianPortal.VerifyCreatedOrderIntheVerifyList(Description);
			physicianPortal.VerifyClickingOnToggledVerifiedButton();*/
		physicianPortal.VerifyTheOrderByClickingSignButton();
		physicianPortal.VerifyCreatedOrderIntheVerifyList(Description);

		String Resident = physicianPortal.VerifyClickingOnToggledSignedButton();
		physicianPortal.VerifyAddSignatureButton();
		physicianPortal.VerifySignOrdersViaAddSignature();
		physicianPortal.VerifyTheOrderByClickingRecapButton();

		String Description1 = testData.get("description1") + physicianPortal.GenarateRandomNumber();

		physicianPortal.ClickOnCreateRecap();
		physicianPortal.VerifyRecapDescription(Description1);
		physicianPortal.VerifyResidentStatus(testData.get("Option"),testData.get("ResidentStatus"));
		physicianPortal.VerifyResidentStations(testData.get("Option"),testData.get("Stations"));

		physicianPortal.VerifyRecapResidents(Resident,testData.get("Residents"));
		physicianPortal.VerifyRecapOthers(testData.get("Option"),testData.get("OrderStatus"));
		String PhysicianOption = physicianPortal.VerifyRecapPhysicians(testData.get("physicianType"),testData.get("Physicians"));
		physicianPortal.VerifyRecapeDate();
		physicianPortal.RecapApplyFilter();

		physicianPortal.VerifyOrderInCreateRecapsWithoutCheckingTheCheckBox(Description);
		physicianPortal.VerifyToggleRecap();
		physicianPortal.VerifyAddSignatureButton();
		physicianPortal.VerifySignOrdersViaAddSignature();

		physicianPortal.RobotWork();
		physicianPortal.SelectPhysicianForReacap(PhysicianOption);
		physicianPortal.SelectPhysicianSignatureForReacap();
		physicianPortal.ClickAndSelectPhysicianSignatureForReacap(Description1,testData.get("ClickingType"));
		physicianPortal.ClickAndSelectPhysicianSignatureForReacap(Description,testData.get("ClickingType1"));
		physicianPortal.VerifyAddSignatureButton();
		physicianPortal.VerifySignOrdersViaAddSignature();
		physicianPortal.VerifyRecapDropDownList();

		login.Logout();

	}


	//@Test()
	public void QA109_ViewAndModify_Recaps(ITestContext testContext) throws AWTException, InterruptedException
	{

		PhysicianPortalTestCases.testReport.logSuccess("QA026_ViewAndModify_Recaps" , "View And Modify Recaps");

		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		ClinicalPage clinicalPortal = new ClinicalPage(threadLocalWebDriver.get(), TestTemplate.testReport);

		final String testCase = "QA109";

		HashMap<String , String> testData = xlsReader.GetValue(SheetName, testCase);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 
		TestTemplate.testReport.logSuccess("Click to Clinical Portal From Menu Bar");
		homepage.NavigateToClinicalPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Clinical Portal");
		clinicalPortal.ClickOnResidentOrdersFromOrders();

		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		physicianPortal.VerifyButtonInResidentOrders();

		String Description = testData.get("description") + physicianPortal.GenarateRandomNumber();

		String TypeName = physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type1"),Description,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.CreateOrderFrequency(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));





		physicianPortal.SaveOrderFrequency();

		physicianPortal.OrdersSelection(TypeName,Description);
		physicianPortal.ClickOnListViewForNavigateToOrdersView();
		/*physicianPortal.VerifyTheOrderByClickingVerifyButton();
			physicianPortal.VerifyCreatedOrderIntheVerifyList(Description);
			physicianPortal.VerifyClickingOnToggledVerifiedButton();*/
		physicianPortal.VerifyTheOrderByClickingSignButton();
		physicianPortal.VerifyCreatedOrderIntheVerifyList(Description);

		String Resident = physicianPortal.VerifyClickingOnToggledSignedButton();
		physicianPortal.VerifyAddSignatureButton();
		physicianPortal.VerifySignOrdersViaAddSignature();

		physicianPortal.VerifyTheOrderByClickingRecapButton();
		physicianPortal.VerifyRecapDropDownList();
		physicianPortal.RecapePageTextVerification();
		physicianPortal.ClickOnCreateRecap();
		physicianPortal.VerifyRecapDescription(Description);
		physicianPortal.VerifyResidentStatus(testData.get("Option"),testData.get("ResidentStatus"));
		physicianPortal.VerifyResidentStations(testData.get("Option"),testData.get("Stations"));

		physicianPortal.VerifyRecapResidents(Resident,testData.get("Residents"));
		physicianPortal.VerifyRecapOthers(testData.get("Option"),testData.get("OrderStatus"));
		physicianPortal.VerifyRecapPhysicians(testData.get("physicianType"),testData.get("Physicians"));
		physicianPortal.VerifyRecapeDate();
		physicianPortal.RecapApplyFilter();
		physicianPortal.RecapPageButtonmVerification();
		physicianPortal.OrdersPageTextVerification();
		physicianPortal.VerifyOrderInCreateRecapsWithoutCheckingTheCheckBox(Description);		
		physicianPortal.ArrowButtonVerification();		
		//physicianPortal.PharmacyValidation();
		physicianPortal.OrdersDisplayPageForPerticularResident(testData.get("type1"));
		physicianPortal.RecapPageButtonmVerification();
		physicianPortal.VerifyToggleRecapAll();
		physicianPortal.VerifyToggleRecap();

		physicianPortal.OrderPagePrirtValidation();
		physicianPortal.VerifyButtonsInOrdersAndFrequency();
		physicianPortal.ModifyOrderPageDetail(Description,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType1"),testData.get("ReceivedByType1"),testData.get("ReceivedOrderType1"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.ModifyOrderFrequency(Integer.parseInt(testData.get("modifyButtonNo")),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy1") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));
		physicianPortal.AddHoldDatesVerification(testData.get("startDate"),testData.get("endDate"),testData.get("startDateTime"),testData.get("startDateTime"),Integer.parseInt(testData.get("slidingScaleMin")) );


		physicianPortal.DiscontinueOrderValidation(testData.get("startDate"),testData.get("startDateTime"),testData.get("physicianType1"),testData.get("ReceivedOrderType1"),testData.get("discontinueForCorrection"),testData.get("copyOrder"),testData.get("dcMessage"));
		physicianPortal.DiscontinueValidation(testData.get("discontinueForCorrection"),testData.get("copyOrder"),testData.get("dcMessage"));
		physicianPortal.CancelOrder();
		physicianPortal.CancelOrder();
		clinicalPortal.ClickOnResidentOrdersFromOrders();


		String Description1 = testData.get("description1") + physicianPortal.GenarateRandomNumber();

		String TypeName1 = physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type1"),Description1,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.CreateOrderFrequency(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));

		physicianPortal.SaveOrderFrequency();

		physicianPortal.OrdersSelection(TypeName1,Description1);
		physicianPortal.ClickOnListViewForNavigateToOrdersView();
		/*physicianPortal.ScrollUp(TestTemplate.threadLocalWebDriver.get());
			physicianPortal.WindowpopUpCopy(TestTemplate.threadLocalWebDriver.get(),"Copy");
			physicianPortal.OrderPageCopyOrderValidation(testData.get("type1"),Description1,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		 */

		/*physicianPortal.VerifyButtonInResidentOrders();

			physicianPortal.VerifyTheOrderByClickingVerifyButton();
			physicianPortal.VerifyCreatedOrderIntheVerifyList(Description1);
			physicianPortal.VerifyClickingOnToggledVerifiedButton();*/
		physicianPortal.VerifyTheOrderByClickingSignButton();
		physicianPortal.VerifyCreatedOrderIntheVerifyList(Description1);

		physicianPortal.VerifyClickingOnToggledSignedButton();
		physicianPortal.VerifyAddSignatureButton();
		physicianPortal.VerifySignOrdersViaAddSignature();

		physicianPortal.VerifyTheOrderByClickingRecapButton();
		physicianPortal.ClickOnCreateRecap();
		physicianPortal.VerifyRecapDescription(Description1);
		physicianPortal.VerifyResidentStatus(testData.get("Option"),testData.get("ResidentStatus"));
		physicianPortal.VerifyResidentStations(testData.get("Option"),testData.get("Stations"));

		physicianPortal.VerifyRecapResidents(Resident,testData.get("Residents"));
		physicianPortal.VerifyRecapOthers(testData.get("Option"),testData.get("OrderStatus"));
		physicianPortal.VerifyRecapPhysicians(testData.get("physicianType"),testData.get("Physicians"));
		physicianPortal.VerifyRecapeDate();
		physicianPortal.RecapApplyFilter();
		physicianPortal.VerifyOrderInCreateRecapsWithoutCheckingTheCheckBox(Description1);
		physicianPortal.VerifyToggleRecap();

		physicianPortal.CancelOrderPageDetail(Description1,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.CancelOrderFrequency(Integer.parseInt(testData.get("modifyButtonNo")),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy1") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));


		physicianPortal.DiscontinueOrderValidation(testData.get("startDate"),testData.get("startDateTime"),testData.get("physicianType1"),testData.get("ReceivedOrderType1"),testData.get("discontinueForCorrection1"),testData.get("copyOrder1"),testData.get("dcMessage1"));
		physicianPortal.DiscontinueValidation(testData.get("discontinueForCorrection1"),testData.get("copyOrder1"),testData.get("dcMessage1"));
		physicianPortal.RobotWork();
		physicianPortal.CancelOrder();





		login.Logout();

	}


	@Test(priority = 2)
	public void Gen_QA209_BS_EHR_LoginPage(ITestContext testContext)
			throws Throwable {

		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 
		final String TesctCase = "GEN_QA209";			

		login.Logout();

	}

	@Test(priority = 2)
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

	@Test(priority = 2)
	public void Gen_QA211_MyDashBoardPage(ITestContext testContext)
			throws Throwable {

		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 

		final String TesctCase = "GEN_QA211";	

		homepage.NavigateToClinicalPortal();
		emar.EmarPageHeaderValidation();

		emar.BlueStrataLogoValidation();
		homepage.VerifyFacilityIconAndName();
		homepage.VerifyResidentIconAndName();
		homepage.VerifyAllapps();
		login.Logout();

	}


	@Test(priority = 2)
	public void Gen_QA212_UserNamePreferences_TopRightOf_ResidentDahsboard_Or_HomePage(ITestContext testContext)
			throws Throwable {

		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 

		final String TesctCase = "GEN_QA212";	

		homepage.NavigateToClinicalPortal();
		emar.TesterButtonOptionsVerification();
		emar.ChangePasswordVerifications();
		emar.NavigateBackToPreviesPage();
		emar.lockFromApplication(password);		
		login.Logout();
	}

	@Test(priority = 2)
	public void Gen_QA213_HelpMenuWith_HelpSiteAbout(ITestContext testContext) throws Throwable {

		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 

		final String TesctCase = "Gen_QA213";	

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TesctCase);

		homepage.NavigateToClinicalPortal();
		emar.HelpButtonvalidation();
		String ParentparentWindow = emar.HelpSiteValidation(testData.get("HelpSiteURL"));
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(ParentparentWindow);
		login.Logout();


	}


	@Test(priority = 2)
	public void Gen_QA214_HelpMenuWith_HelpSiteAbout(ITestContext testContext) throws Throwable {

		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 

		final String TesctCase = "GEN_QA214";	

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TesctCase);

		homepage.NavigateToClinicalPortal();
		homepage.VerifyAllapps();
		login.Logout();

	}
}



