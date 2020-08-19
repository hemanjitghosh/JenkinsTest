package bluestrata.tests.functionalTests;

import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.excel.Xls_Reader;

import bluestrata.pages.EmarPage;
import bluestrata.pages.HomePage;
import bluestrata.pages.LoginPage;
import dweb.test.templates.TestTemplate;

public class EmarTestCases extends dweb.test.templates.TestTemplateMethodLevelInit {

	//Xls_Reader xlsReader = new Xls_Reader("C:\\Bluestrata\\Abhishek-Project-s\\src\\test\\resources\\testdata\\BluestrataTestData.xlsx");
	Xls_Reader xlsReader = new Xls_Reader("C:\\Users\\hemanjitg\\Desktop\\BlueStrata\\LTC-AutomatedTests\\src\\test\\resources\\testdata\\BluestrataTestData.xlsx");

	final String SheetName = "emarPortal";

	@Test()
	public void QA116_LoginTo_EmarApplication(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA116";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		//login.login(userName, password);
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA117_UserNamePreferences_TopRightOf_ResidentDahsboard_Or_HomePage(ITestContext testContext)
			throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow("https://devapp.bluestrataemr.com/emar/dashboard");
		login.login(userName, password);
		emar.TesterButtonOptionsVerification();
		emar.ChangePasswordVerifications();
		emar.NavigateBackToPreviesPage();
		emar.lockFromApplication(password);
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA118_HelpMenuWith_HelpSiteAbout(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA118";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		emar.HelpButtonvalidation();
		String ParentparentWindow = emar.HelpSiteValidation(testData.get("HelpSiteURL"));
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(ParentparentWindow);

		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA119_ChangeAppWindowThrough_ApplicationMenuButton(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA119";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		homepage.VerifyAllapps();
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		homepage.VerifyAllapps();
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA120_ExploreEmar_DashboardPageUsing_eMARapp(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA120";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		homepage.VerifyAllapps();
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		emar.BlueStrataLogoValidation();
		emar.EmarPageHeaderValidation();
		emar.EmarPageButtonsVerification();
		emar.VerifyMessageButton();
		emar.VerifyHomeAndDashBoard();
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA121_LaunchPage_ViewOrderStatus_OneMARDashboard(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA121";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		homepage.VerifyAllapps();
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		emar.EmarPageButtonsVerification();
		emar.VerifyLastMedicationBox();
		emar.VerifyFolloeupsBox();
		emar.VerifyOrdersBox();
		emar.VerifyADTChangesBox();
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStationAndResidentVerification();
		emar.EmarPageHeaderValidation();
		emar.EmarPageButtonsVerification();
		emar.VerifyMessageButton();

		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA122_EmarDashboard_OrdersWidget(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA122";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		homepage.VerifyAllapps();
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		emar.VerifyOrdersBox();
		emar.VerifyTotalNoOfOrdersINOrdersBox();
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA123_EmarDashboard_ADTChanges(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA123";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		homepage.VerifyAllapps();
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		emar.VerifyOrdersBox();
		emar.VerifyADTChnages(testData.get("ADTDaysValue"));
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA124_EmarDashboard_LateMedicationsLast24Hours(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA124";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		homepage.VerifyAllapps();
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		emar.VerifyLastMedicationBox();
		//emar.LastMedicationRecordDisplayAndVerifyPaginationFeature();
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA125_EmarDashboard_Followups(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA125";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		homepage.VerifyAllapps();
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		emar.VerifyFolloeupsBox();
		emar.FollupsRecordDisplayAndVerifyPaginationFeature();
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA126_EmarDashboard_ResidentDashboard(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA126";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		homepage.VerifyAllapps();
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStationAndResidentVerification();
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		emar.SpecificResidentVerification();
		emar.BlueStrataLogoValidation();
		emar.EmarPageHeaderValidation();
		emar.EmarPageButtonsVerification();
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//////Similar to 126 //@Test()
	public void QA127_EmarDashboard_ResidentDetails_OnDashboard(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA127";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStationAndResidentVerification();
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		emar.SpecificResidentVerification();
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA128_AdministrationButtonsAvailable_OnResidentDashboard(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA128";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		emar.AdministrationButtonValidation();
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA129_VerifyCurrentAdministrationRoutine_OrdersAdministration(ITestContext testContext)
			throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA129";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		String[] Description = emar.AdministrationButtonRoutineTabValidation(testData.get("RoutineTabType"),
				testData.get("Tab"), testData.get("Task"));
		emar.PreAdministrationRequirementsValidation(testData.get("Comment"));
		emar.AdministrationsMedicationNameValidation(Description[0]);
		emar.AdministrationsValidation(testData.get("Notes"), testData.get("Amount"), testData.get("Value"));
		emar.PostAdministrationRequirmentsVerification(testData.get("Comment"));
		emar.VerifyAdministrationHistoryOverLast24Hours("Description[0]", "Description[1]", testData.get("RoutineTabType"),testData.get("Task"));
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	@Test()
	public void QA130_VerifyCurrentAdministrationPRN_OrdersAdministration(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA130";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		//login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		String[] Description = emar.AdministrationButtonRoutineTabValidation(testData.get("PRNTabType"),
				testData.get("Tab"), testData.get("Task"));
		emar.PreAdministrationRequirementsValidation(testData.get("Comment"));
		emar.AdministrationsMedicationNameValidation(Description[0]);
		emar.AdministrationsValidation(testData.get("Notes"), testData.get("Amount"), testData.get("Value"));
		emar.PostAdministrationRequirmentsVerification(testData.get("Comment"));
		emar.VerifyAdministrationHistoryOverLast24Hours(Description[0], Description[1], testData.get("PRNTabType"),testData.get("Task"));
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA131_VerifyCurrentAdministrationFollowUps_OrdersAdministration(ITestContext testContext)
			throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA131";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		String[] Description = emar.AdministrationButtonRoutineTabValidation(testData.get("FollowUPTabType"),
				testData.get("Tab"), testData.get("Task"));
		emar.FollowFieldValidation(testData.get("Notes"));
		emar.VerifyAdministrationHistoryOverLast24Hours(Description[0], Description[1],
				testData.get("FollowUPTabType"),testData.get("Task"));
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA132_AdministeringShowFutureRecord_EMAR(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA132";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		//login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		emar.AdministrationButtonRoutineTabValidation(testData.get("RoutineTabType"), testData.get("Tab"),
				testData.get("Task"));
		String RoutingCount = emar.ClickOnShowFutureButton(testData.get("RoutineTabType"));
		emar.ShowFutureOrdersConfirmTabValidation(testData.get("RoutineTabType"), RoutingCount);
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}
		
	@Test()
	public void QA133_Edit_And_Undo_on_Today_administered_Orders_on_eMAR(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA133";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		//login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		String[] Description = emar.SelectPerticulerResident(testData.get("Resident"),testData.get("RoutineTabType"),
				testData.get("Tab"), testData.get("Task"));
		emar.PreAdministrationRequirementsValidation(testData.get("Comment"));
		emar.AdministrationsValidation(testData.get("Notes"), testData.get("Amount"), testData.get("Value"));
		emar.PostAdministrationRequirmentsVerification(testData.get("Comment"));
		emar.VerifyAdministrationHistoryOverTheLast24Hours(testData.get("Notes"));
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();
	}
	
	//@Test()
	public void QA134_InteractionsButton_ResidentDashoard_EMAR(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA134";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		//login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		emar.AdministrationButtonRoutineTabValidation(testData.get("TabType"), testData.get("Tab"),
				testData.get("Task"));
		emar.InterActionsTabValidation();
		emar.InterActionsTypeButtonValidation();
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA135_LostOrDisposedMedication_ResidentDashoard_EMAR(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		String userName1 = this.getTestParameter(testContext, "newuserName");
		String password2 = this.getTestParameter(testContext, "newpassword");

		String TestCaseName = "QA135";

		String UserName = "tester";
		String PassWord = "testerPass";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		//login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		emar.AdministrationButtonRoutineTabValidation(testData.get("TabType"), testData.get("Tab"),
				testData.get("Task"));
		emar.LostOrDisposedMedTabCountVerification(testData.get("Amount"), testData.get("Notes"));
		emar.doubleSignWithCredentials(userName, password, userName1, password2);
		emar.SubmitLostOrDisposedMed();
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA136_PastAdministrationRoutine_ResidentDashoard_EMAR(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA136";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		//login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		emar.AdministrationButtonRoutineTabValidation(testData.get("RoutineTabType"),
				testData.get("Tab"),testData.get("Task"));
		emar.PreAdministrationRequirementsValidation(testData.get("Comment"));		
		emar.AdministrationsValidation(testData.get("Notes"),testData.get("Amount"),testData.get("Value"));
		emar.PostAdministrationRequirmentsVerification(testData.get("Comment"));
		emar.VerifyPastAdministrationsTab(testData.get("ResidentTabType"));
		Object[] Details =emar.VerifyTabsForAdministrations(testData.get("ResidentTabType"),testData.get("RoutineTabType"));
		emar.EditUndoButtonVerification(testData.get("RoutineTabType"),(String) Details[1], (int) Details[2]);
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA137_PastAdministrationPRN_ResidentDashoard_EMAR(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA137";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		//login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		emar.AdministrationButtonRoutineTabValidation(testData.get("PRNTabType"),
				testData.get("Tab"),testData.get("Task"));
		emar.PreAdministrationRequirementsValidation(testData.get("Comment"));		
		emar.AdministrationsValidation(testData.get("Notes"),testData.get("Amount"),testData.get("Value"));
		emar.PostAdministrationRequirmentsVerification(testData.get("Comment"));
		emar.VerifyPastAdministrationsTab(testData.get("ResidentTabType"));
		Object[] Details =emar.VerifyTabsForAdministrations(testData.get("ResidentTabType"),testData.get("PRNTabType"));
		emar.EditUndoButtonVerification(testData.get("PRNTabType"),(String) Details[1],(int) Details[2]);
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA138_PastAdministrationFollowUps_ResidentDashoard_EMAR(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA138";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		//login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		emar.AdministrationButtonRoutineTabValidation(testData.get("FollowUPTabType"),
				testData.get("Tab"),testData.get("Task"));
		emar.FollowFieldValidation(testData.get("Notes"));
		emar.VerifyPastAdministrationsTab(testData.get("ResidentTabType"));
		Object[] Details =emar.VerifyTabsForAdministrations(testData.get("ResidentTabType"),testData.get("FollowUPTabType"));
		emar.EditUndoButtonVerification(testData.get("FollowUPTabType"),(String) Details[1], (int) Details[2]);
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA139_MissedAdministrationOn_ResidentDashboard_EMAR(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA139";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		//login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		emar.AdministrationButtonRoutineTabValidation(testData.get("RoutineTabType"),
				testData.get("Tab"), testData.get("Task"));
		emar.AdministrationButtonRoutineTabValidation(testData.get("PRNTabType"),
				testData.get("Tab"), testData.get("Task"));
		emar.AdministrationButtonRoutineTabValidation(testData.get("FollowUPTabType"),
				testData.get("Tab"), testData.get("Task"));
		emar.FollowFieldValidation(testData.get("Notes"));		
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA140_MissedAdministration_RoutionOrders_ResidentDashboard_EMAR(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA140";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		//login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		String[] Description = emar.AdministrationButtonRoutineTabValidation(testData.get("RoutineTabType"),
				testData.get("Tab"), testData.get("Task"));			
		emar.PreAdministrationRequirementsValidation(testData.get("Comment"));
		emar.AdministrationsMedicationNameValidation(Description[0]);
		emar.AdministrationsValidation(testData.get("Notes"), testData.get("Amount"), testData.get("Value"));		
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	@Test()
	public void QA141_MissedAdministration_RoutionOrders_PreAdministrationAction_EMAR(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA141";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password);
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		//login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		String[] Description = emar.AdministrationButtonRoutineTabValidation(testData.get("RoutineTabType"),
				testData.get("Tab"), testData.get("Task"));			
		emar.PreAdministrationRequirementsValidation(testData.get("Comment"));
		emar.AdministrationsMedicationNameValidation(Description[0]);
		emar.AdministrationsValidation(testData.get("Notes"), testData.get("Amount"), testData.get("Value"));		
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	@Test()
	public void QA142_MissedAdministration_RoutionOrders_PostAdministrationAction_EMAR(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA141";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		//login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		String[] Description = emar.AdministrationButtonRoutineTabValidation(testData.get("RoutineTabType"),
				testData.get("Tab"), testData.get("Task"));			
		emar.PreAdministrationRequirementsValidation(testData.get("Comment"));
		emar.AdministrationsMedicationNameValidation(Description[0]);
		emar.AdministrationsValidation(testData.get("Notes"), testData.get("Amount"), testData.get("Value"));	
		emar.PostAdministrationRequirmentsVerification(testData.get("Comment"));
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA143_MissedAdministration_PRNOrders_PreAdministrationAction_EMAR(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA143";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		String[] Description = emar.AdministrationButtonRoutineTabValidation(testData.get("PRNTabType"),
				testData.get("Tab"), testData.get("Task"));			
		emar.PreAdministrationRequirementsValidation(testData.get("Comment"));
		emar.AdministrationsMedicationNameValidation(Description[0]);
		emar.AdministrationsValidation(testData.get("Notes"), testData.get("Amount"), testData.get("Value"));		
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

    //@Test()
	public void QA144_MissedAdministration_PRNOrders_PostAdministrationAction_EMAR(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA144";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		String[] Description = emar.AdministrationButtonRoutineTabValidation(testData.get("PRNTabType"),
				testData.get("Tab"), testData.get("Task"));			
		emar.PreAdministrationRequirementsValidation(testData.get("Comment"));
		emar.AdministrationsMedicationNameValidation(Description[0]);
		emar.AdministrationsValidation(testData.get("Notes"), testData.get("Amount"), testData.get("Value"));	
		emar.PostAdministrationRequirmentsVerification(testData.get("Comment"));
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}

	//@Test()
	public void QA145_MissedAdministration_AdministeringFollowupsOrders_EMAR(ITestContext testContext) throws Throwable {
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA145";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		String[] Description = emar.AdministrationButtonRoutineTabValidation(testData.get("FollowUPTabType"),
				testData.get("Tab"), testData.get("Task"));
		emar.FollowFieldValidation(testData.get("Notes"));
		String RoutineCount = emar.BooleanRoutinePRNFollowUpTab(testData.get("FollowUPTabType"));
		if(Integer.parseInt(Description[1])==(Integer.parseInt(RoutineCount)+1))
		{
			this.testReport.logSuccess("Followup's  counter", String.format("Followup's :- <mark>%s</mark> decrease by one from the last displayed counter :- <mark>%s</mark>", Description[1],RoutineCount), this.getScreenShotName());
		}
		else
		{
			this.testReport.logFailure("Followup's  counter", String.format("Followup's :- <mark>%s</mark> decrease by one from the last displayed counter :- <mark>%s</mark>", Description[1],RoutineCount), this.getScreenShotName());
		}
		
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

	}
	
	//@Test()
	public void QA147_VitalSigns_ResidentDashboard_eMAR(ITestContext testContext) throws Throwable
	{		
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA147";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password); 
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		emar.AdministrationButtonRoutineTabValidation(testData.get("TabType2"),
				testData.get("Tab"), testData.get("Task"));		
		//emar.RecordSvitalPageVerifiaction(testData.get("VitalSign"), testData.get("VitalSigntext"));
		//emar.UpdateNewVitalSign(testData.get("Amount"),testData.get("Task"));
		//emar.CreatedVitalSign(testData.get("VitalSign"), testData.get("VitalSigntext"));
			
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

		
	}
	
	//@Test()
	public void QA151_Behavior_Monitoring_on_eMAR(ITestContext testContext) throws Throwable
	{		
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");

		String TestCaseName = "QA151";

		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		login.login(userName, password);
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		 emar.SelectPerticulerResident(testData.get("Resident"),testData.get("TabType"),
				testData.get("Tab"), testData.get("Task"));	
		emar.VerifyBoxesUnderBehaviorMonitoring(testData.get("Notes"));			
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

		
	}
	
	//@Test()
	public void QA173_Creation_Of_Med_Inventory(ITestContext testContext) throws Throwable
	{		
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		EmarPage emar = new EmarPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		String userName1 = this.getTestParameter(testContext, "newuserName");
		String password2 = this.getTestParameter(testContext, "newpassword");

		String TestCaseName = "QA173";
		login.login(userName, password); 
		HashMap<String, String> testData = xlsReader.GetValue(SheetName, TestCaseName);
		String parentWindow = homepage.NavigateToEmarWindow(testData.get("EmarURL"));
		login.login(userName, password);
		emar.SelectAllAccessType(testData.get("Value"));
		emar.SelectStation(testData.get("Station"));
		emar.ClickOnManageInventoryButtonWithValidation(testData.get("Amount"), userName, password, userName1, password2);			
		emar.LogoutFromEmar();
		emar.ClosingEmarURL();
		emar.SwitchToHomePage(parentWindow);
		login.Logout();

		
	}

}
