package bluestrata.tests.functionalTests;
import java.awt.AWTException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.excel.Xls_Reader;
import com.google.common.io.Resources;

import bluestrata.pages.EmarPage;
import bluestrata.pages.FacilityPage;
import bluestrata.pages.HomePage;
import bluestrata.pages.LoginPage;
import bluestrata.pages.PhysicianPortalPage;
import dweb.test.templates.TestTemplate;
import dweb.test.templates.TestTemplateMethodLevelInit;

public class PhysicianPortalTestCases extends TestTemplateMethodLevelInit {
	
	
	//private static final boolean false = false;
	//Xls_Reader xlsReader = new Xls_Reader("C:\\Bluestrata\\Abhishek-Project-s\\src\\test\\resources\\testdata\\BluestrataTestData.xlsx");
	Xls_Reader xlsReader = new Xls_Reader("C:\\Users\\hemanjitg\\Desktop\\BlueStrata\\LTC-AutomatedTests\\src\\test\\resources\\testdata\\BluestrataTestData.xlsx");
	final String SheetName = "physicianPortal";
	
	//@Test()
	public void QA007_ResidentOrders(ITestContext testContext) throws URISyntaxException
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		Random rand = new Random(System.currentTimeMillis());		
		
		final String testCase = "QA007";
		
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName, testCase);
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToPhysicianPortal();
		
		physicianPortal.PhysicianPortalHeaderVerfication();
		physicianPortal.VerifyPhysicianPortalDrropdown();
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
	public void QA008_ResidentOrders_CreateAnOrder(ITestContext testContext)
	{
		
		
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		
		final String testCase = "QA008";
		
		HashMap<String ,String> testData = xlsReader.GetValue(SheetName,testCase);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
				
		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToPhysicianPortal();
		
		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	
		
		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		physicianPortal.VerifyButtonInResidentOrders();
		
		
		
		String[] typeArray = {testData.get("type1"),testData.get("type2"),testData.get("type3"),testData.get("type4"),testData.get("type5"),testData.get("type6"),testData.get("type7")};
		String[] ReceivedByOptions = {testData.get("ReceivedOrderType1"),testData.get("ReceivedOrderType2"),testData.get("ReceivedOrderType3"),testData.get("ReceivedOrderType4"),testData.get("ReceivedOrderType5"),testData.get("ReceivedOrderType6"),testData.get("ReceivedOrderType7")}; 
		
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
	
	//@Test()
	public void QA009_ResidentOrders_CreateAnOrderWithFrequencyRoutine(ITestContext testContext)
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToPhysicianPortal();
		
		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	
		
		
		
		final String testCase = "QA009";
		
		HashMap<String ,String> testData = xlsReader.GetValue(SheetName,testCase);
		
		
		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		physicianPortal.VerifyButtonInResidentOrders();
	
		TestTemplate.testReport.logSuccess("Create Order With Treatment Dropdown Option");
		
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
		physicianPortal.OrderDisplayPageColourVerification();
		physicianPortal.OrderDisplayPageColoumnsVerification();
	//	physicianPortal.BottomPaneOfContainer();
		
		physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type2"),testData.get("libraryText")+testData.get("type2"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.OrderFrequencyType(Integer.parseInt(testData.get("num")),testData.get("frequencyType"));
		physicianPortal.StartDate(Integer.parseInt(testData.get("num")),testData.get("startDate"),testData.get("startDateTime"));
		physicianPortal.OrderEndType(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,testData.get("endDateType1"),testData.get("endDateType1") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));
		physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testData.get("num")),testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
		physicianPortal.OnceAShiftFrequency(Integer.parseInt(testData.get("num")),testData.get("frequency"));
		physicianPortal.HowOftenDailyType(Integer.parseInt(testData.get("num")),testData.get("howOften"),testData.get("everyDay"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),testData.get("type2"));
		physicianPortal.SaveOrderFrequency();
		
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
		
		physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type6"),testData.get("libraryText")+testData.get("type6"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.OrderFrequencyType(Integer.parseInt(testData.get("num")),testData.get("frequencyType"));
		physicianPortal.StartDate(Integer.parseInt(testData.get("num")),testData.get("startDate"),testData.get("startDateTime"));
		physicianPortal.OrderEndType(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,testData.get("endDateType1"),testData.get("endDateType1") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));
		physicianPortal.RequireActionRelatedLabel(Integer.parseInt(testData.get("num")),testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
		physicianPortal.OnceAShiftFrequency(Integer.parseInt(testData.get("num")),testData.get("frequency"));
		physicianPortal.HowOftenYearlyType(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("num")),testData.get("howOften3"),testData.get("scheduleOnMonth"),testData.get("everyDay"),testData.get("everyDay"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),testData.get("type6"));
		physicianPortal.SaveOrderFrequency();
		
		physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type3"),testData.get("libraryText")+testData.get("type3"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.OrderFrequencyType(Integer.parseInt(testData.get("num")),testData.get("frequencyType"));
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),testData.get("type3"));
		physicianPortal.SaveOrderFrequency();
		login.Logout();
	}
	
	
	
	//@Test()
	public void QA010_ResidentOrders_CreateAnOrderWithFrequencyRoutine(ITestContext testContext)
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToPhysicianPortal();
		
		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	
		
		
	    final String TestCase = "QA010";
		
		HashMap<String , String > testData = xlsReader.GetValue(SheetName, TestCase);
		
		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		
		
        
     String[] typeArray= {testData.get("type1"),testData.get("type2"),testData.get("type4"),testData.get("type5"),testData.get("type6"),testData.get("type7")};
	    int numberOfItems = typeArray.length;
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
		
		
		
		for(int newnum=2;newnum<=27;newnum ++)
		{
	
		physicianPortal.OrderFrequencyType(newnum,testData.get("frequencyType"));
		physicianPortal.StartDate(newnum,testData.get("startDate"),testData.get("startDateTime"));
		physicianPortal.OrderEndType(newnum,Integer.parseInt(testData.get("byDateno")),Integer.parseInt(testData.get("afterNoOfAdminstrationsNo")) ,testData.get("endDateType"),testData.get("endDate") ,testData.get("startDate") ,testData.get("startDateTime"), testData.get("afterNumberOfAdminstrations"));
		physicianPortal.RequireActionRelatedLabel(newnum,testData.get("frequencyType") ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits"));
		switch (newnum)
		{
		case 2:	
			physicianPortal.TextTypeNoOfTimesAdayFrequency(testData.get("frequencyTexttype") ,newnum ,testData.get("frequency1") , Integer.parseInt(testData.get("num")) , testData.get("timeInADayTime"));
			break;
		case 3:				
	    	physicianPortal.TextTypeNoOfTimesAdayFrequency(testData.get("frequencyTexttype1") ,newnum ,testData.get("frequency1") , Integer.parseInt(testData.get("num")) , testData.get("timeInADayShift"));
			break;
		case 4:				
		    physicianPortal.TextTypeNoOfTimesAdayFrequency(testData.get("frequencyTexttype") ,newnum ,testData.get("frequency2") , (Integer.parseInt(testData.get("num"))+1) , testData.get("timeInADayTime"));
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
		physicianPortal.SaveOrderFrequency();		
		
		}	
	    
	    
	    login.Logout();
	}
	
	
	//@Test()
	public void QA011_HowOften_RoutineFrequencyType(ITestContext testContext) throws URISyntaxException
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);

		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToPhysicianPortal();
		
		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	
			
		
		final String TestCase = "QA011";
		
		HashMap<String , String > testData = xlsReader.GetValue(SheetName, TestCase);
		
		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));	
		
	
		//Long GenerateNumber = physicianPortal.GenarateRandomNumber();
		
		String[] typeArray = {testData.get("type1"),testData.get("type2"),testData.get("type4"),testData.get("type5"),testData.get("type6"),testData.get("type7")};
		
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
		physicianPortal.CreateOrderFrequencyForRoutine(Integer.parseInt(testData.get("num4")),testData.get("physicianInstructions"),testData.get("physicianInstructions"),type);
		physicianPortal.SaveOrderFrequency();
		
		
		}
		
		
		login.Logout();
		
	}
	
	
	
	//@Test()
	public void QA012_ResidentOrders_CreateAnOrderWithFrequencyPRN(ITestContext testContext)
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToPhysicianPortal();
		
		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	
		
		
		final String TestCase = "QA012";
		
		HashMap<String , String > testData = xlsReader.GetValue(SheetName, TestCase);
		
		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));	
	
		TestTemplate.testReport.logSuccess("Create Order With Treatment Dropdown Option");
		
		physicianPortal.GenarateRandomNumber();
		
		String[] Types = {testData.get("type1"),testData.get("type2"),testData.get("type3"),testData.get("type4"),testData.get("type5"),testData.get("type6"),testData.get("type7")};	
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
		//physicianPortal.BottomPaneOfContainer();
		login.Logout();
		
	}
	
	
	//@Test()
	public void QA013_ResidentOrders_CreateAnOrderWithFrequencyPRNEveryHour(ITestContext testContext)
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		
		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToPhysicianPortal();
		
		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	
		
		
		/*String ResidentNo = xlsReader.getCellData("physicianportal", 0, 28);
		String type1 = xlsReader.getCellData("physicianportal", 1, 28);
		String type2 = xlsReader.getCellData("physicianportal", 2, 28);
		String type3 = xlsReader.getCellData("physicianportal", 3, 28);
		String type4 = xlsReader.getCellData("physicianportal", 4, 28);
		String type5 = xlsReader.getCellData("physicianportal", 5, 28);
		String type6 = xlsReader.getCellData("physicianportal", 6, 28);
		String type7 = xlsReader.getCellData("physicianportal", 7, 28);
		String libraryText = xlsReader.getCellData("physicianportal", 8, 28);			
		String SearchDiogonosisTxt = xlsReader.getCellData("physicianportal", 9, 28);
		String medicarePriority = xlsReader.getCellData("physicianportal", 10, 28);
		String diogonosisName = xlsReader.getCellData("physicianportal", 11, 28);
		String physicianType = xlsReader.getCellData("physicianportal", 12, 28);
		String ReceivedByType = xlsReader.getCellData("physicianportal", 13, 28);
		String ReceivedOrderType = xlsReader.getCellData("physicianportal", 14, 28);		
		String routes = xlsReader.getCellData("physicianportal", 15, 28);
		String WrittenDate = xlsReader.getCellData("physicianportal", 16, 28);
		String NoOfRefillis = xlsReader.getCellData("physicianportal", 17, 28);
		String WhenToFill = xlsReader.getCellData("physicianportal", 18, 28);
		String num = xlsReader.getCellData("physicianportal", 19, 28);
		String frequencyType = xlsReader.getCellData("physicianportal", 20, 28);
		String startDate = xlsReader.getCellData("physicianportal", 21, 28);  
		String ByDate =startDate;
		String startDateTime = xlsReader.getCellData("physicianportal", 22, 28);
		String byDateTime =startDateTime ;
		String byDateno = xlsReader.getCellData("physicianportal", 23, 28);
		String afterNoOfAdminstrationsNo = xlsReader.getCellData("physicianportal", 24, 28);		
		String endDate = xlsReader.getCellData("physicianportal", 25, 28);
		String afterNumberOfAdminstrations = xlsReader.getCellData("physicianportal", 26, 28);
		String requiredActions = xlsReader.getCellData("physicianportal", 27, 28);
		String othersRequiredActions = xlsReader.getCellData("physicianportal", 28, 28);
		String requiredActionsPostDropdown = xlsReader.getCellData("physicianportal", 29, 28);
		String othersRequiredActionsPostDropdown = xlsReader.getCellData("physicianportal", 30, 28);
		String administeredBy = xlsReader.getCellData("physicianportal", 31, 28);
		String maxDoesHours = xlsReader.getCellData("physicianportal", 32, 28);
		String followUpAfterMinutes = xlsReader.getCellData("physicianportal", 33, 28);
		String slidingScaleMin = xlsReader.getCellData("physicianportal", 34, 28);
		String slidingScaleMax = xlsReader.getCellData("physicianportal", 35, 28);
		String slidingScaleUnits = xlsReader.getCellData("physicianportal", 36, 28);
		String frequency = xlsReader.getCellData("physicianportal", 37, 12);
		String howOften = xlsReader.getCellData("physicianportal", 38, 12);
		String everyDay = xlsReader.getCellData("physicianportal", 39, 12);
		String physicianInstructions = xlsReader.getCellData("physicianportal", 40, 28);
		String additionalInstruction = physicianInstructions ;
		String endDateType = xlsReader.getCellData("physicianportal", 42, 28);
		String endDateType1 = xlsReader.getCellData("physicianportal", 43, 28);
		String endDateType2 = xlsReader.getCellData("physicianportal", 44, 28);
		String TypeOfMode = xlsReader.getCellData("physicianportal", 45, 12);
		String howOften1 = xlsReader.getCellData("physicianportal", 46, 12);
		String howOften2 = xlsReader.getCellData("physicianportal", 47, 12);
		String howOften3 = xlsReader.getCellData("physicianportal", 48, 12);
		String DropdownNumber = xlsReader.getCellData("physicianportal", 49, 12);
		String DropdownDay = xlsReader.getCellData("physicianportal", 50, 12);
		String TypeOfMode1 = xlsReader.getCellData("physicianportal", 51, 12);
		String scheduleOnMonth = xlsReader.getCellData("physicianportal", 52, 12);*/
		
		final String TestCase = "QA013";
		
		HashMap<String , String > testData = xlsReader.GetValue(SheetName, TestCase);
		
		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
	
		TestTemplate.testReport.logSuccess("Create Order With Treatment Dropdown Option");
		
		
		
		String[] Types = {testData.get("type1"),testData.get("type2"),testData.get("type3"),testData.get("type4"),testData.get("type5"),testData.get("type6"),testData.get("type7")};	
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
		//physicianPortal.BottomPaneOfContainer();
		login.Logout();
	}
	
	//@Test()
	public void QA014_ResidentOrders_CreateAnOrder(ITestContext testContext)
	{
		
		
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA014";
		
		HashMap<String ,String> testData = xlsReader.GetValue(SheetName,testCase);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
				
		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToPhysicianPortal();
		
		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	
		
		//String ResidentNo = xlsReader.getCellData("physicianportal", 28, 32);
		
		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		physicianPortal.VerifyButtonInResidentOrders();
		
		
		/*String type1 = xlsReader.getCellData("physicianportal", 0, 32);
		String type2 = xlsReader.getCellData("physicianportal", 1, 32);
		String medicationType = xlsReader.getCellData("physicianportal", 2, 32);
		String medicationType1 = xlsReader.getCellData("physicianportal", 3, 32);
		String searchMedicationName = xlsReader.getCellData("physicianportal", 4, 32);
		String type6 = xlsReader.getCellData("physicianportal", 5, 32);
		String type7 = xlsReader.getCellData("physicianportal", 6, 32);
		String libraryText = xlsReader.getCellData("physicianportal", 7, 32);
		String createdType = xlsReader.getCellData("physicianportal", 8, 32);		
		String libraryText1 = xlsReader.getCellData("physicianportal", 9, 32);
		String createdType1 = xlsReader.getCellData("physicianportal", 10, 32);
		String nullDiagonisis = xlsReader.getCellData("physicianportal", 11, 32);
		String SearchDiogonosisTxt = xlsReader.getCellData("physicianportal", 12, 32);
		String medicarePriority = xlsReader.getCellData("physicianportal", 13, 32);
		String diogonosisName = xlsReader.getCellData("physicianportal", 14, 32);
		String physicianType = xlsReader.getCellData("physicianportal", 15, 32);
		String ReceivedByType = xlsReader.getCellData("physicianportal", 16, 32);
		String ReceivedOrderType1 = xlsReader.getCellData("physicianportal", 17, 32);
		String ReceivedOrderType2 = xlsReader.getCellData("physicianportal", 18, 32);
		String ReceivedOrderType3 = xlsReader.getCellData("physicianportal", 19, 32);
		String ReceivedOrderType4 = xlsReader.getCellData("physicianportal", 20, 32);
		String ReceivedOrderType5 = xlsReader.getCellData("physicianportal", 21, 32);
		String ReceivedOrderType6 = xlsReader.getCellData("physicianportal", 22, 32);
		String ReceivedOrderType7 = xlsReader.getCellData("physicianportal", 23, 32);
		String routes = xlsReader.getCellData("physicianportal", 24, 32);
		String WrittenDate = xlsReader.getCellData("physicianportal", 25, 32);
		String NoOfRefillis = xlsReader.getCellData("physicianportal", 26, 32);
		String WhenToFill = xlsReader.getCellData("physicianportal", 27, 32);*/
		
		
		String[] frequencyTpyes = {testData.get("type1"),testData.get("type2")};
		for(int n=0;n<=1;n++)
		{
			String frequency = frequencyTpyes[n];

			String[] receivedOrders = {testData.get("ReceivedOrderType7"),testData.get("ReceivedOrderType1"),testData.get("ReceivedOrderType2"),testData.get("ReceivedOrderType3"),testData.get("ReceivedOrderType4"),testData.get("ReceivedOrderType5"),testData.get("ReceivedOrderType6")};
			String[] medicationtypes = {testData.get("medicationType"),testData.get("medicationType1"),testData.get("medicationType"),testData.get("medicationType1"),testData.get("medicationType"),testData.get("medicationType1"),testData.get("medicationType")};
			for(int i=0;i<=6;i++)
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
	
	
	//@Test()
	public void QA015_ResidentOrders_CreateAnOrderWithFrequencyRoutine(ITestContext testContext)
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		
		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToPhysicianPortal();
		
		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	
		
		
		
		
		final String testCase = "QA015";
		
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
		physicianPortal.WhereToTabValidation();
		physicianPortal.OrderDisplayPageColourVerification();
		physicianPortal.OrderDisplayPageColoumnsVerification();
	//	physicianPortal.BottomPaneOfContainer();
		
		}
		
		login.Logout();
		
	}
	
	//@Test()
	public void QA016_ResidentOrders_CreateAnOrderWithFrequencyPRNEveryHour(ITestContext testContext)
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		
		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToPhysicianPortal();
		
		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	
				
		
		final String testCase = "QA016";
		
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
	//	physicianPortal.BottomPaneOfContainer();
		
		}
		
		login.Logout();	
		
	}
	
	//@Test()
	public void QA017_ResidentOrders_CreateAnOrderWithFrequencyPRN(ITestContext testContext)
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToPhysicianPortal();
		
		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	
			
		
		final String testCase = "QA017";
		
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
		//physicianPortal.BottomPaneOfContainer();
		
		}
		
		login.Logout();
		
	}
	
	
	//@Test()
	public void QA018_CreateAnOrder_ViaOrderSets (ITestContext testContext) throws InterruptedException 
	{
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		Random rand = new Random(System.currentTimeMillis());




		final String testCase = "QA018";

		HashMap<String ,String> testData = xlsReader.GetValue(SheetName,testCase);

		int newnum;
		String[] FrequencyTypes = {testData.get("frequencyType1"),testData.get("frequencyType2"),testData.get("frequencyType3")};
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		homepage.NavigateToFacilityPortal();
		facilityPage.ManageOrdersSets();
		String[] OrderType = {testData.get("type8"),testData.get("type1")};
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



		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToPhysicianPortal();

		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	

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
	public void QA019_ViewAndModifyAnOrder_ViaOrderSets (ITestContext testContext) throws AWTException, InterruptedException
	{
		 
		PhysicianPortalTestCases.testReport.logSuccess("QA19_ViewAndModifyAnOrder_ViaOrderSets" , "Verify View And Modify An Order Via Order Sets");
         
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		Random rand = new Random(System.currentTimeMillis());
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		
		final String testCase = "QA019";
		
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
		physicianPortal.RequireActionRelatedLabel(newnum,Frequency ,testData.get("requiredActions"),testData.get("othersRequiredActions") ,testData.get("requiredActionsPostDropdown"),testData.get("othersRequiredActionsPostDropdown"),testData.get("administeredBy") ,testData.get("maxDoesHours") ,
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
		homepage.NavigateToPhysicianPortal();
		
		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	
		
		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		physicianPortal.VerifyButtonInResidentOrders();
		physicianPortal.CreateFromSet();
		physicianPortal.SelectOrderFromOrderSets(testData.get("libraryText"));
		String TypeName = physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type8"),testData.get("libraryText"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.SaveOrderFrequency();	
		physicianPortal.OrdersPageTextVerification();
		physicianPortal.OrdersSelection(TypeName ,testData.get("libraryText"));
		//physicianPortal.PharmacyValidation();
		physicianPortal.VerifyButtonInResidentOrders();
		physicianPortal.OrdersDisplayPageForPerticularResident(testData.get("type8"));
		physicianPortal.ClickingOnCreatedOrder(testData.get("libraryText"));
		physicianPortal.VerifyButtonsInOrdersAndFrequency();
		physicianPortal.ModifyOrderPageDetail(testData.get("libraryText"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType1"),testData.get("ReceivedByType1"),testData.get("ReceivedOrderType1"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.ModifyOrderFrequency(Integer.parseInt(testData.get("modifyButtonNo")),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy1") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));
		physicianPortal.AddHoldDatesVerification(testData.get("endDate"),testData.get("endDate"),testData.get("startDateTime"),testData.get("startDateTime"),Integer.parseInt(testData.get("slidingScaleMin")) );
		
		
		physicianPortal.DiscontinueOrderValidation(testData.get("startDate"),testData.get("startDateTime"),testData.get("physicianType1"),testData.get("ReceivedOrderType1"),testData.get("discontinueForCorrection"),testData.get("copyOrder"),testData.get("dcMessage"));
		physicianPortal.DiscontinueValidation(testData.get("discontinueForCorrection"),testData.get("copyOrder"),testData.get("dcMessage"));
		
		physicianPortal.OrderPagePrirtValidation();
	//	physicianPortal.ArrowButtonVerification();
		
		physicianPortal.OrderPageCopyOrderValidation(testData.get("type8"),testData.get("libraryText"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		/*physicianPortal.ClickingCopyButton();
		physicianPortal.FullOrderPageVerification();
		physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type8"),testData.get("libraryText"),testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		*/
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
	public void QA020_VerifyAnOrder_ViaOrderSetsOrCreateAnOrder (ITestContext testContext) throws AWTException
	{
		 
		PhysicianPortalTestCases.testReport.logSuccess("QA20_VerifyAnOrder_ViaOrderSetsOrCreateAnOrder" , "Verify An Order Via Order Sets/Create An Order");
         
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
				
		final String testCase = "QA020";
		
		HashMap<String , String> testData = xlsReader.GetValue(SheetName, testCase);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToPhysicianPortal();
		
		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	
		
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
	
	//@Test()
	public void QA021_VerifyAndModifyAnOrder_ViaOrderSetsOrCreateAnOrder (ITestContext testContext) throws AWTException
	{
		 
		PhysicianPortalTestCases.testReport.logSuccess("QA21_VerifyAndModifyAnOrder_ViaOrderSetsOrCreateAnOrder" , "Verify And Modify An Order Via Order Sets/Create An Order");
         
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
			
		final String testCase = "QA021";
		
		HashMap<String , String> testData = xlsReader.GetValue(SheetName, testCase);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToPhysicianPortal();
		
		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	
		
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
		physicianPortal.VerifyTheOrderByClickingVerifyButton();
		physicianPortal.OrdersPageTextVerification();
		/*physicianPortal.VerifyCreatedOrderIntheVerifyList(Description);
		physicianPortal.PharmacyValidation();
		physicianPortal.OrdersDisplayPageForPerticularResident(testData.get("type1"));
		physicianPortal.VerifyButtonsInVerifyOrders();
		physicianPortal.VerifyButtonsInOrdersAndFrequency();
		physicianPortal.ModifyOrderPageDetail(Description,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType1"),testData.get("ReceivedByType1"),testData.get("ReceivedOrderType1"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.ModifyOrderFrequency(Integer.parseInt(testData.get("modifyButtonNo")),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy1") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));
		physicianPortal.AddHoldDatesVerification(testData.get("startDate"),testData.get("endDate"),testData.get("startDateTime"),testData.get("startDateTime"),Integer.parseInt(testData.get("slidingScaleMin")) );
		
		
		physicianPortal.DiscontinueOrderValidation(testData.get("startDate"),testData.get("startDateTime"),testData.get("physicianType1"),testData.get("ReceivedOrderType1"),testData.get("discontinueForCorrection"),testData.get("copyOrder"),testData.get("dcMessage"));
		physicianPortal.DiscontinueValidation(testData.get("discontinueForCorrection"),testData.get("copyOrder"),testData.get("dcMessage"));
				
		physicianPortal.OrderPagePrirtValidation();
		String Description1 = testData.get("description1") + physicianPortal.GenarateRandomNumber();
		physicianPortal.OrderPageCopyOrderValidation(testData.get("type1"),Description1,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
	
		physicianPortal.VerifyButtonInResidentOrders();
		
		String Description2 = testData.get("description2") + physicianPortal.GenarateRandomNumber();
		
		
		String TypeName1 = physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type1"),Description2,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.CreateOrderFrequency(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));
		
        physicianPortal.SaveOrderFrequency();
		
        physicianPortal.OrdersSelection(TypeName1,Description2);
		physicianPortal.ClickOnListViewForNavigateToOrdersView();
		physicianPortal.VerifyTheOrderByClickingVerifyButton();
		physicianPortal.VerifyCreatedOrderIntheVerifyList(Description2);	
		
		physicianPortal.CancelOrderPageDetail(Description2,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType1"),testData.get("ReceivedByType1"),testData.get("ReceivedOrderType1"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.CancelOrderFrequency(Integer.parseInt(testData.get("modifyButtonNo")),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy1") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));
		
		physicianPortal.ArrowButtonVerification();
		physicianPortal.DiscontinueOrderValidation(testData.get("startDate"),testData.get("startDateTime"),testData.get("physicianType1"),testData.get("ReceivedOrderType1"),testData.get("discontinueForCorrection1"),testData.get("copyOrder1"),testData.get("dcMessage1"));
		physicianPortal.DiscontinueValidation(testData.get("discontinueForCorrection1"),testData.get("copyOrder1"),testData.get("dcMessage1"));
		physicianPortal.CancelOrder();
		*/
		
		
		
		login.Logout();
		
		
	}
	
	//@Test()
	public void QA022_SignAnOrder_ViaOrderSetsOrCreateAnOrder (ITestContext testContext) throws AWTException
	{
		 
		PhysicianPortalTestCases.testReport.logSuccess("QA20_SignAnOrder_ViaOrderSetsOrCreateAnOrder" , "Verify Sign An Order Via Order Sets/Create An Order");
         
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
       
		final String testCase = "QA022";
		HashMap<String , String> testData = xlsReader.GetValue(SheetName, testCase);		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToPhysicianPortal();
		
		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	
		
		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));
		
		String Description = testData.get("description") + physicianPortal.GenarateRandomNumber();
		
		physicianPortal.VerifyButtonInResidentOrders();
	
		String TypeName = physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type1"),Description,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.CreateOrderFrequency(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("num")),testData.get("frequencyType1"),testData.get("endDate"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));
		
		
		
		
		physicianPortal.SaveOrderFrequency();		
		physicianPortal.OrdersSelection(TypeName,Description);
		
		
		
		physicianPortal.ClickOnListViewForNavigateToOrdersView();
		
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
	public void QA023_ViewAndModifyAnOrder_ViaOrderSetsOrCreateAnOrder (ITestContext testContext) throws AWTException, InterruptedException
	{
		 
		PhysicianPortalTestCases.testReport.logSuccess("QA21_VerifyAndModifyAnOrder_ViaOrderSetsOrCreateAnOrder" , "Verify And Modify An Order Via Order Sets/Create An Order");
         
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		
		final String testCase = "QA023";
		
		HashMap<String , String> testData = xlsReader.GetValue(SheetName, testCase);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToPhysicianPortal();
		
		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	
		
		TestTemplate.testReport.logSuccess("Click On existing Resident");
		physicianPortal.SearchResidentWithApplyFilterButton(testData.get("ResidentNo"));	
		//physicianPortal.ClickOnExistingResident(testData.get("ResidentNo"));
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
		physicianPortal.OrdersPageTextVerification();
		physicianPortal.VerifyCreatedOrderIntheVerifyList(Description);
		//physicianPortal.PharmacyValidation();
		physicianPortal.OrdersDisplayPageForPerticularResident(testData.get("type1"));
		physicianPortal.VerifyButtonsInSignOrders();
		physicianPortal.VerifyButtonsInOrdersAndFrequency();
		physicianPortal.ModifyOrderPageDetail(Description,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType1"),testData.get("ReceivedByType1"),testData.get("ReceivedOrderType1"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.ModifyOrderFrequency(Integer.parseInt(testData.get("modifyButtonNo")),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy1") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));
		physicianPortal.AddHoldDatesVerification(testData.get("startDate"),testData.get("endDate"),testData.get("startDateTime"),testData.get("startDateTime"),Integer.parseInt(testData.get("slidingScaleMin")) );
				
		
		physicianPortal.DiscontinueOrderValidation(testData.get("startDate"),testData.get("startDateTime"),testData.get("physicianType1"),testData.get("ReceivedOrderType1"),testData.get("discontinueForCorrection"),testData.get("copyOrder"),testData.get("dcMessage"));
		physicianPortal.DiscontinueValidation(testData.get("discontinueForCorrection"),testData.get("copyOrder"),testData.get("dcMessage"));
		

		physicianPortal.OrderPagePrirtValidation();
		
		String Description2 = testData.get("description2") + physicianPortal.GenarateRandomNumber();
		physicianPortal.OrderPageCopyOrderValidation(testData.get("type1"),Description2,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.FillOrderPageFrequency(Integer.parseInt(testData.get("modifyButtonNo")),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy1") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"),testData.get("type1"),Description2);
		
		/*physicianPortal.VerifyTheOrderByClickingVerifyButton();
		physicianPortal.VerifyCreatedOrderIntheVerifyList(Description2);
		physicianPortal.VerifyClickingOnToggledVerifiedButton();*/
		physicianPortal.VerifyTheOrderByClickingSignButton();
	
		physicianPortal.VerifyCreatedOrderIntheVerifyList(Description2);
		physicianPortal.ArrowButtonVerification();
		physicianPortal.VerifyAddSignatureButton();
		physicianPortal.VerifySignOrdersViaAddSignature();
		
		physicianPortal.ClickOnPhysicianPortal();			
		physicianPortal.VerifyButtonInResidentOrders();
		
		String Description1 = testData.get("description1") + physicianPortal.GenarateRandomNumber();
		
		
		String TypeName1 =physicianPortal.CreateAnOrderWithOrderDetails(testData.get("type1"),Description1,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType"),testData.get("ReceivedByType"),testData.get("ReceivedOrderType"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.CreateOrderFrequency(Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));
		
        physicianPortal.SaveOrderFrequency();
		
        physicianPortal.OrdersSelection(TypeName1,Description1);
		physicianPortal.ClickOnListViewForNavigateToOrdersView();
		/*physicianPortal.VerifyTheOrderByClickingVerifyButton();
		physicianPortal.VerifyCreatedOrderIntheVerifyList(Description1);
		physicianPortal.VerifyClickingOnToggledVerifiedButton();*/
		physicianPortal.VerifyTheOrderByClickingSignButton();
		physicianPortal.VerifyCreatedOrderIntheVerifyList(Description1);
		
		physicianPortal.CancelOrderPageDetail(Description1,testData.get("SearchDiogonosisTxt"),testData.get("medicarePriority"),testData.get("diogonosisName"),testData.get("physicianType1"),testData.get("ReceivedByType1"),testData.get("ReceivedOrderType1"),testData.get("routes"),testData.get("WrittenDate"),testData.get("NoOfRefillis"),testData.get("WhenToFill"));
		physicianPortal.CancelOrderFrequency(Integer.parseInt(testData.get("modifyButtonNo")),Integer.parseInt(testData.get("num")),Integer.parseInt(testData.get("No")),testData.get("frequencyType1"),testData.get("endDateType"),testData.get("requiredActions"),testData.get("requiredActionsPostDropdown") ,testData.get("administeredBy1") ,testData.get("maxDoesHours") ,
				testData.get("followUpAfterMinutes"),testData.get("slidingScaleMin"),testData.get("slidingScaleMax") ,testData.get("slidingScaleUnits") ,testData.get("frequency"),testData.get("howOften"),testData.get("everyDay"),testData.get("physicianInstructions"),testData.get("additionalInstruction"),testData.get("type1"));
		
		
		physicianPortal.DiscontinueOrderValidation(testData.get("startDate"),testData.get("startDateTime"),testData.get("physicianType1"),testData.get("ReceivedOrderType1"),testData.get("discontinueForCorrection1"),testData.get("copyOrder1"),testData.get("dcMessage1"));
		physicianPortal.DiscontinueValidation(testData.get("discontinueForCorrection1"),testData.get("copyOrder1"),testData.get("dcMessage1"));
		
		
		
		
		
		login.Logout();
		
		
	}
	
	
	//@Test()
	public void QA024_RecapAnOrder_ViaOrderSetsOrCreateAnOrder (ITestContext testContext) throws AWTException, InterruptedException
	{
		 
		PhysicianPortalTestCases.testReport.logSuccess("QA024_RecapAnOrder_ViaOrderSetsOrCreateAnOrder" , "Recap An Order Via OrderSets Or CreateAnOrder");
         
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
			
		final String testCase = "QA024";
		
		HashMap<String , String> testData = xlsReader.GetValue(SheetName, testCase);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToPhysicianPortal();
		
		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	
		
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
		physicianPortal.ClickOnPhysicianPortal();
		
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
	public void QA025_SignatureOnRecap_Wheather_OrderCreatedFromOrder_Or_FromSets (ITestContext testContext) throws AWTException
	{
		 
		PhysicianPortalTestCases.testReport.logSuccess("QA21_VerifyAndModifyAnOrder_ViaOrderSetsOrCreateAnOrder" , "Verify And Modify An Order Via Order Sets/Create An Order");
         
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		
		final String testCase = "QA025";
		
		HashMap<String , String> testData = xlsReader.GetValue(SheetName, testCase);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToPhysicianPortal();
		
		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	
		
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
	public void QA026_ViewAndModify_Recaps(ITestContext testContext) throws AWTException, InterruptedException
	{
		 
		PhysicianPortalTestCases.testReport.logSuccess("QA026_ViewAndModify_Recaps" , "View And Modify Recaps");
         
		PhysicianPortalPage physicianPortal=new PhysicianPortalPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		FacilityPage facilityPage = new FacilityPage(threadLocalWebDriver.get(), TestTemplate.testReport);
			
		final String testCase = "QA026";
		
		HashMap<String , String> testData = xlsReader.GetValue(SheetName, testCase);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		TestTemplate.testReport.logSuccess("Click to Physician Portal From Menu Bar");
		homepage.NavigateToPhysicianPortal();
		
		TestTemplate.testReport.logSuccess("Navigate to Residents Order From Physician Portal");
		physicianPortal.ClickOnPhysicianPortal();	
		
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
		physicianPortal.ClickOnPhysicianPortal();	
		
		
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
	
	@Test(priority = 1)
	public void Gen_QA209_BS_EHR_LoginPage(ITestContext testContext)
			throws Throwable {

		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);	
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		final String TesctCase = "GEN_QA209";			
		
		login.Logout();

	}
	
	@Test(priority = 1)
	public void Gen_QA210_Login_Credential_Verification(ITestContext testContext)
			throws Throwable {

		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		final String TesctCase = "GEN_QA210";	
		
		homepage.MyDashBoardHomePage();
		login.Logout();

	}
	
	
	@Test(priority = 1)
	public void Gen_QA211_MyDashBoardPage(ITestContext testContext)
			throws Throwable {

		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);	
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		

		final String TesctCase = "GEN_QA211";	

		homepage.NavigateToPhysicianPortal();
		emar.EmarPageHeaderValidation();
		
		emar.BlueStrataLogoValidation();
		homepage.VerifyFacilityIconAndName();
		homepage.VerifyResidentIconAndName();
		homepage.VerifyAllapps();
		login.Logout();

	}
	
	@Test(priority = 1)
	public void Gen_QA212_UserNamePreferences_TopRightOf_ResidentDahsboard_Or_HomePage(ITestContext testContext)
			throws Throwable {

		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		

		final String TesctCase = "GEN_QA212";	

		homepage.NavigateToPhysicianPortal();
		emar.TesterButtonOptionsVerification();
		emar.ChangePasswordVerifications();
		emar.NavigateBackToPreviesPage();
		emar.lockFromApplication(password);		
		login.Logout();

	}
	
	@Test(priority = 1)
	public void Gen_QA213_HelpMenuWith_HelpSiteAbout(ITestContext testContext) throws Throwable {
		
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		
		final String TesctCase = "Gen_QA213";	

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TesctCase);
		
		homepage.NavigateToPhysicianPortal();
		emar.HelpButtonvalidation();
		String ParentparentWindow = emar.HelpSiteValidation(testData.get("HelpSiteURL"));
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(ParentparentWindow);
		login.Logout();

	}
	
	@Test(priority = 1)
   public void Gen_QA214_HelpMenuWith_HelpSiteAbout(ITestContext testContext) throws Throwable {
		
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		

		final String TesctCase = "GEN_QA214";	

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TesctCase);
		
		homepage.NavigateToPhysicianPortal();
		homepage.VerifyAllapps();
		login.Logout();

	}
   
   
	
}










