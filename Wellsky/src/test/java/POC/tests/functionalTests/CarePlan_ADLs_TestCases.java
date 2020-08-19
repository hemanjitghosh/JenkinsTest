package POC.tests.functionalTests;

import java.awt.AWTException;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import POC.pages.POC_HomePage;
import POC.pages.POC_CarePlan_ADLs;
import dweb.test.templates.TestTemplate;
import dweb.test.templates.TestTemplateMethodLevelInit;

public class CarePlan_ADLs_TestCases extends TestTemplateMethodLevelInit {

	@Test()
	public void POC_QA271_New_And_Manage_Data_For_The_Care_Areas(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.VerifyResidentDashBoard();
		pocResident.VerifyResidentDetails();
		pocResident.VerifyCarePlansInResidentPage("");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA272_Activity_Of_Daily_Livings_ADLs_First_Screen(ITestContext testContext) throws AWTException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Jerold Jersmith");
		pocResident.SelectActivityOptionFromMatrix("ADLs");
		pocResident.EditingAndRemovingADLsRecords();
		pocResident.VerifyADLsSelfPerformentAndSupport();		
		pocResident.AddADLsActivities("Independent","Independent");
		pocResident.VerifyADLResidentKioskNotes();
		pocResident.EditADLEntryForShifts();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA273_User_Able_To_Record_An_ADLs_Activity_Of_Daily_Livings_ADLs_for_BedMobility(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Jerold Jersmith");
		pocResident.SelectActivityOptionFromMatrix("ADLs");
		pocResident.EditingAndRemovingADLsRecords();
		pocResident.VerifyColourBeforeSelectingOptions("Bed Mobility");
		pocResident.VerifyActivityCapabilities("Bed Mobility");
		pocResident.VefifyEnterNotesValidation();
		pocResident.CancelEnterNotesWindow();
		pocResident.VerifyActivitySelfPerformanceAndSupport("Independent","Setup Only");
		pocResident.VerifyColourAfterSelectingOptions("Bed Mobility");
		pocResident.VerifySelectedButtonInResultsTab("Bed Mobility","Independent","Setup Only");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA274_User_Able_To_Record_An_ADLs_Activity_Of_Daily_Livings_ADLs_for_Transfer(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Jerold Jersmith");
		pocResident.SelectActivityOptionFromMatrix("ADLs");
		pocResident.EditingAndRemovingADLsRecords();
		pocResident.VerifyColourBeforeSelectingOptions("Transfer");
		pocResident.VerifyActivityCapabilities("Transfer");
		pocResident.VefifyEnterNotesValidation();
		pocResident.CancelEnterNotesWindow();
		pocResident.VerifyActivitySelfPerformanceAndSupport("Independent","Independent");
		pocResident.VerifyColourAfterSelectingOptions("Transfer");
		pocResident.VerifySelectedButtonInResultsTab("Transfer","Independent","Independent");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}


	@Test()
	public void POC_QA275_User_Able_To_Record_An_ADLs_Activity_Of_Daily_Livings_ADLs_for_WalkInRoom(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Jerold Jersmith");
		pocResident.SelectActivityOptionFromMatrix("ADLs");
		pocResident.EditingAndRemovingADLsRecords();
		pocResident.VerifyColourBeforeSelectingOptions("Walk In Room");
		pocResident.VerifyActivityCapabilities("Walk In Room");
		pocResident.VefifyEnterNotesValidation();
		pocResident.CancelEnterNotesWindow();
		pocResident.VerifyActivitySelfPerformanceAndSupport("Independent","Independent");
		pocResident.VerifyColourAfterSelectingOptions("Walk In Room");
		pocResident.VerifySelectedButtonInResultsTab("Walk In Room","Independent","Independent");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA276_User_Able_To_Record_An_ADLs_Activity_Of_Daily_Livings_ADLs_for_WalkInCorridor(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Jerold Jersmith");
		pocResident.SelectActivityOptionFromMatrix("ADLs");
		pocResident.EditingAndRemovingADLsRecords();
		pocResident.VerifyColourBeforeSelectingOptions("Walk In Corridor");
		pocResident.VerifyActivityCapabilities("Walk In Corridor");
		pocResident.VefifyEnterNotesValidation();
		pocResident.CancelEnterNotesWindow();
		pocResident.VerifyActivitySelfPerformanceAndSupport("Independent","Independent");
		pocResident.VerifyColourAfterSelectingOptions("Walk In Corridor");
		pocResident.VerifySelectedButtonInResultsTab("Walk In Corridor","Independent","Independent");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}


	@Test()
	public void POC_QA277_User_Able_To_Record_An_ADLs_Activity_Of_Daily_Livings_ADLs_for_OnUnit(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Jerold Jersmith");
		pocResident.SelectActivityOptionFromMatrix("ADLs");
		pocResident.EditingAndRemovingADLsRecords();
		pocResident.VerifyColourBeforeSelectingOptions("On Unit");
		pocResident.VerifyActivityCapabilities("On Unit");
		pocResident.VefifyEnterNotesValidation();
		pocResident.CancelEnterNotesWindow();
		pocResident.VerifyActivitySelfPerformanceAndSupport("Independent","Independent");
		pocResident.VerifyColourAfterSelectingOptions("On Unit");
		pocResident.VerifySelectedButtonInResultsTab("On Unit","Independent","Independent");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA278_User_Able_To_Record_An_ADLs_Activity_Of_Daily_Livings_ADLs_for_OffUnit(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Jerold Jersmith");
		pocResident.SelectActivityOptionFromMatrix("ADLs");
		pocResident.EditingAndRemovingADLsRecords();
		pocResident.VerifyColourBeforeSelectingOptions("Off Unit");
		pocResident.VerifyActivityCapabilities("Off Unit");
		pocResident.VefifyEnterNotesValidation();
		pocResident.CancelEnterNotesWindow();
		pocResident.VerifyActivitySelfPerformanceAndSupport("Independent","Independent");
		pocResident.VerifyColourAfterSelectingOptions("Off Unit");
		pocResident.VerifySelectedButtonInResultsTab("Off Unit","Independent","Independent");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA279_User_Able_To_Record_An_ADLs_Activity_Of_Daily_Livings_ADLs_for_Dressing(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Jerold Jersmith");
		pocResident.SelectActivityOptionFromMatrix("ADLs");
		pocResident.EditingAndRemovingADLsRecords();
		pocResident.VerifyColourBeforeSelectingOptions("Dressing");
		pocResident.VerifyActivityCapabilities("Dressing");
		pocResident.VefifyEnterNotesValidation();
		pocResident.CancelEnterNotesWindow();
		pocResident.VerifyActivitySelfPerformanceAndSupport("Independent","Independent");
		pocResident.VerifyColourAfterSelectingOptions("Dressing");
		pocResident.VerifySelectedButtonInResultsTab("Dressing","Independent","Independent");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA280_User_Able_To_Record_An_ADLs_Activity_Of_Daily_Livings_ADLs_for_Eating(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Jerold Jersmith");
		pocResident.SelectActivityOptionFromMatrix("ADLs");
		pocResident.EditingAndRemovingADLsRecords();
		pocResident.VerifyColourBeforeSelectingOptions("Eating");
		pocResident.VerifyActivityCapabilities("Eating");
		pocResident.VefifyEnterNotesValidation();
		pocResident.CancelEnterNotesWindow();
		pocResident.VerifyActivitySelfPerformanceAndSupport("Independent","Independent");
		pocResident.VerifyColourAfterSelectingOptions("Eating");
		pocResident.VerifySelectedButtonInResultsTab("Eating","Independent","Independent");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA281_User_Able_To_Record_An_ADLs_Activity_Of_Daily_Livings_ADLs_for_ToiletUse(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Jerold Jersmith");
		pocResident.SelectActivityOptionFromMatrix("ADLs");
		pocResident.EditingAndRemovingADLsRecords();
		pocResident.VerifyColourBeforeSelectingOptions("Toilet Use");
		pocResident.VerifyActivityCapabilities("Toilet Use");
		pocResident.VefifyEnterNotesValidation();
		pocResident.CancelEnterNotesWindow();
		pocResident.VerifyActivityOptionalSelfPerformanceAndSupport("Pericare","Independent","Independent");
		pocResident.VerifyColourAfterSelectingOptions("Toilet Use");
		pocResident.VerifySelectedButtonInResultsTab("Toilet Use","Independent","Independent");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA282_User_Able_To_Record_An_ADLs_Activity_Of_Daily_Livings_ADLs_for_PersonalHygiene(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Jerold Jersmith");
		pocResident.SelectActivityOptionFromMatrix("ADLs");
		pocResident.EditingAndRemovingADLsRecords();
		pocResident.VerifyColourBeforeSelectingOptions("Personal Hygiene");
		pocResident.VerifyActivityCapabilities("Personal Hygiene");
		pocResident.VefifyEnterNotesValidation();
		pocResident.CancelEnterNotesWindow();
		pocResident.VerifyActivityOptionalSelfPerformanceAndSupport("Shaving","Independent","Independent");
		pocResident.VerifyColourAfterSelectingOptions("Personal Hygiene");
		pocResident.VerifySelectedButtonInResultsTab("Personal Hygiene","Independent","Independent");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA283_User_Able_To_Record_An_ADLs_Activity_Of_Daily_Livings_ADLs_for_Bathing(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Jerold Jersmith");
		pocResident.SelectActivityOptionFromMatrix("ADLs");
		pocResident.EditingAndRemovingADLsRecords();
		pocResident.VerifyColourBeforeSelectingOptions("Bathing");
		pocResident.VerifyActivityCapabilities("Bathing");
		pocResident.VefifyEnterNotesValidation();
		pocResident.CancelEnterNotesWindow();
		pocResident.VerifyActivityOptionalSelfPerformanceAndSupport("Tub","Independent","Independent");
		pocResident.VerifyColourAfterSelectingOptions("Bathing");
		pocResident.VerifySelectedButtonInResultsTab("Bathing","Independent","Independent");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA284_Color_Change_For_ADLs_Icon(ITestContext testContext) throws AWTException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Jerold Jersmith");
		pocResident.SelectActivityOptionFromMatrix("ADLs");
		pocResident.VefifyEnterNotesValidation();
		pocResident.CancelEnterNotesWindow();
		pocResident.VerifyColourForAllCarePlansBeforeSelectingystemIcon();
		pocResident.AddADLsActivities("Independent","Independent");
		pocResident.VerifyColourForAllCarePlansAfterSelectingystemIcon();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}


}
