package POC.tests.functionalTests;

import java.util.ArrayList;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import POC.pages.POC_CarePlan_ADLs;
import POC.pages.POC_CarePlan_BowelAndBladder;
import POC.pages.POC_CarePlan_MoodAndBehavior;
import POC.pages.POC_CarePlan_Restorative;
import POC.pages.POC_CarePlan_Vitals;
import POC.pages.POC_HomePage;
import dweb.test.templates.TestTemplate;
import dweb.test.templates.TestTemplateMethodLevelInit;

public class CarePlan_Restorative_TestCases extends TestTemplateMethodLevelInit{

	//@Test()
	public void POC_QA305_Restorative_Recording_For_Resident(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.VerifyCarePlansInResidentPage("Restorative");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocRestorative.SelectRestorativeOptions(CarePlan);		
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	//@Test()
	public void POC_QA306_Self_And_Support_Under_Ambulation_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Ambulation");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Self & Support");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyActivityOptionalSelfPerformanceAndSupport("Corridor","Independent","Independent");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	//@Test()
	public void POC_QA307_Self_And_Support_Under_Ambulation_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Ambulation");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Minutes & Distance");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyMinutesAndDistance("50");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}


	//@Test()
	public void POC_QA308_Tolerance_Under_Ambulation_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Ambulation");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Tolerance");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyTolerance("Tolerated Well");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}


	@Test()
	public void POC_QA309_NoParticipation_NoParticipation_With_Notes_Under_Ambulation_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Ambulation");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("No Participation");
		Thread.sleep(2000);	
		pocRestorative.VerifyNoParticipation();
		pocBowelBladder.SelectBowelOption("No Participation With Notes");
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	//@Test()
	public void POC_QA310_Balance_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Balance");
		pocRestorative.VerifyBalanceCarePlan("","");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	//@Test()
	public void POC_QA311_Moving_From_Seat_To_Standing_Position_Under_Balance_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Balance");
		pocRestorative.VerifyBalanceCarePlan("Moving From Seat to Standing Position","Steady at all times");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	//@Test()
	public void POC_QA312_Moving_On_And_Off_Toilet_Under_Balance_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Balance");
		pocRestorative.VerifyBalanceCarePlan("Moving On and Off Toilet","Steady at all times");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	//@Test()
	public void POC_QA313_Surface_to_Surface_Transfer_Under_Balance_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Balance");
		pocRestorative.VerifyBalanceCarePlan("Surface to Surface Transfer","Steady at all times");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	//@Test()
	public void POC_QA314_Turn_Around_Under_Balance_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Balance");
		pocRestorative.VerifyBalanceCarePlan("Turn Around","Steady at all times");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	//@Test()
	public void POC_QA315_Walking_Under_Balance_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Balance");
		pocRestorative.VerifyBalanceCarePlan("Walking","Steady at all times");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA316_Restorative_Recording_For_Resident(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.VerifyCarePlansInResidentPage("Restorative");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocRestorative.SelectRestorativeOptions(CarePlan);		
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	//@Test()
	public void POC_QA317_Self_And_Support_Under_Bed_Mobility_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Bed Mobility");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Self & Support");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyActivityOptionalSelfPerformanceAndSupport("","Independent","Independent");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA318_Minutes_Under_Bed_Mobility_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Bed Mobility");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Minute");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyCalculator();
		pocRestorative.EnterPasscode("50");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	//@Test()
	public void POC_QA319_Tolerance_Under_Bed_Mobility_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Bed Mobility");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Tolerance");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyTolerance("Tolerated Well");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA320_NoParticipation_NoParticipation_With_Notes_Under_Bed_Mobility_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Sebastian Sebsmith");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Bed Mobility");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();		
		pocBowelBladder.SelectBowelOption("No Participation With Notes");
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocBowelBladder.SelectBowelOption("No Participation");
		Thread.sleep(2000);	
		pocRestorative.VerifyNoParticipation();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA321_Restorative_Recording_For_Resident(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.VerifyCarePlansInResidentPage("Restorative");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocRestorative.SelectRestorativeOptions(CarePlan);		
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA322_Self_And_Support_Under_Communication_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Communication");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Self & Support");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyActivityOptionalSelfPerformanceAndSupport("","Independent","Independent");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA323_Minutes_Under_Communication_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Communication");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Minute");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyCalculator();
		pocRestorative.EnterPasscode("50");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA324_Tolerance_Under_Communication_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Communication");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Tolerance");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyTolerance("Tolerated Well");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	@Test()
	public void POC_QA325_NoParticipation_NoParticipation_With_Notes_Under_Communication_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Sebastian Sebsmith");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Communication");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();		
		pocBowelBladder.SelectBowelOption("No Participation With Notes");
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocBowelBladder.SelectBowelOption("No Participation");
		Thread.sleep(2000);	
		pocRestorative.VerifyNoParticipation();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA326_Restorative_Recording_For_Resident(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.VerifyCarePlansInResidentPage("Restorative");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocRestorative.SelectRestorativeOptions(CarePlan);		
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA327_Self_And_Support_Under_Continence_Exercise_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Continence Exercise");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Self & Support");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyActivityOptionalSelfPerformanceAndSupport("","Independent","Independent");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA328_Minutes_Under_Continence_Exercise_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Continence Exercise");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Minute");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyCalculator();
		pocRestorative.EnterPasscode("50");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA329_Tolerance_Under_Continence_Exercise_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Continence Exercise");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Tolerance");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyTolerance("Tolerated Well");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA330_NoParticipation_NoParticipation_With_Notes_Under_Continence_Exercise_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Sebastian Sebsmith");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Continence Exercise");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();		
		pocBowelBladder.SelectBowelOption("No Participation With Notes");
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocBowelBladder.SelectBowelOption("No Participation");
		Thread.sleep(2000);	
		pocRestorative.VerifyNoParticipation();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	//@Test()
	public void POC_QA331_Restorative_Recording_For_Resident(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.VerifyCarePlansInResidentPage("Restorative");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocRestorative.SelectRestorativeOptions(CarePlan);		
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA332_Self_And_Support_Under_Dining_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Dining");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Self & Support");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyActivityOptionalSelfPerformanceAndSupport("","Independent","Independent");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA333_Minutes_Under_Dining_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Dining");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Minute");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyCalculator();
		pocRestorative.EnterPasscode("50");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA334_Tolerance_Under_Dining_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Dining");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Tolerance");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyTolerance("Tolerated Well");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA335_NoParticipation_NoParticipation_With_Notes_Under_Dining_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Sebastian Sebsmith");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Dining");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();		
		pocBowelBladder.SelectBowelOption("No Participation With Notes");
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocBowelBladder.SelectBowelOption("No Participation");
		Thread.sleep(2000);	
		pocRestorative.VerifyNoParticipation();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	
	//@Test()
	public void POC_QA336_Restorative_Recording_For_Resident(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.VerifyCarePlansInResidentPage("Restorative");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocRestorative.SelectRestorativeOptions(CarePlan);		
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA337_Self_And_Support_Under_Dressing_Grooming_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Dressing/Grooming");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Self & Support");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyActivityOptionalSelfPerformanceAndSupport("","Independent","Independent");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA338_Minutes_Under_Dressing_Grooming_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Dressing/Grooming");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Minute");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyCalculator();
		pocRestorative.EnterPasscode("50");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	@Test()
	public void POC_QA339_Tolerance_Under_Dressing_Grooming_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Dressing/Grooming");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Tolerance");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyTolerance("Tolerated Well");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA340_NoParticipation_NoParticipation_With_Notes_Under_Dressing_Grooming_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Sebastian Sebsmith");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Dressing/Grooming");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();		
		pocBowelBladder.SelectBowelOption("No Participation With Notes");
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocBowelBladder.SelectBowelOption("No Participation");
		Thread.sleep(2000);	
		pocRestorative.VerifyNoParticipation();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA341_Self_And_Support_Under_Prosthetic_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Prosthetic");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Self & Support");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyActivityOptionalSelfPerformanceAndSupport("","Independent","Independent");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA342_Minutes_Under_Prosthetic_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Prosthetic");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Minute");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyCalculator();
		pocRestorative.EnterPasscode("50");			
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA343_Tolerance_Under_Prosthetic_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Prosthetic");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Tolerance");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyTolerance("Tolerated Well");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA344_NoParticipation_NoParticipation_With_Notes_Under_Prosthetic_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Sebastian Sebsmith");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Prosthetic");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();		
		pocBowelBladder.SelectBowelOption("No Participation With Notes");
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocBowelBladder.SelectBowelOption("No Participation");
		Thread.sleep(2000);	
		pocRestorative.VerifyNoParticipation();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	@Test()
	public void POC_QA345_Restorative_Recording_For_Resident(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.VerifyCarePlansInResidentPage("Restorative");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocRestorative.SelectRestorativeOptions(CarePlan);		
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	

	//@Test()
	public void POC_QA346_Self_And_Support_Under_Range_Of_Motion_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Range Of Motion");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Self & Support");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyActivityOptionalSelfPerformanceAndSupport("","Independent","Independent");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA347_Active_Minutes_Under_Range_Of_Motion_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Range Of Motion");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Active Minute");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyCalculator();
		pocRestorative.EnterPasscode("50");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	
	//@Test()
	public void POC_QA348_Passive_Minutes_Under_Range_Of_Motion_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Range Of Motion");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Passive Minute");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyCalculator();
		pocRestorative.EnterPasscode("50");		
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA349_Tolerance_Under_Range_Of_Motion_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Range Of Motion");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Tolerance");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyTolerance("Tolerated Well");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA350_NoParticipation_NoParticipation_With_Notes_Under_Range_Of_Motion_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Sebastian Sebsmith");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Range Of Motion");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();		
		pocBowelBladder.SelectBowelOption("No Participation With Notes");
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocBowelBladder.SelectBowelOption("No Participation");
		Thread.sleep(2000);	
		pocRestorative.VerifyNoParticipation();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA351_Restorative_Recording_For_Resident(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.VerifyCarePlansInResidentPage("Restorative");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocRestorative.SelectRestorativeOptions(CarePlan);		
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	

	//@Test()
	public void POC_QA352_Self_And_Support_Under_Splint_Brace_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Splint/Brace");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Self & Support");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyActivityOptionalSelfPerformanceAndSupport("","Independent","Independent");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA353_Minutes_Under_Splint_Brace_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Splint/Brace");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Minute");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();		
		pocRestorative.EnterPasscode("50");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	
	//@Test()
	public void POC_QA354_Splint_Location_Under_Splint_Brace_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Splint/Brace");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Splint Location");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.SelectSplitLocationForTransfer("Right Upper Extremity");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA355_Tolerance_Under_Splint_Brace_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Splint/Brace");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Tolerance");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyTolerance("Tolerated Well");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA356_NoParticipation_NoParticipation_With_Notes_Under_Splint_Brace_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Sebastian Sebsmith");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Splint/Brace");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();		
		pocBowelBladder.SelectBowelOption("No Participation With Notes");
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocBowelBladder.SelectBowelOption("No Participation");
		Thread.sleep(2000);	
		pocRestorative.VerifyNoParticipation();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA357_Restorative_Recording_For_Resident(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.VerifyCarePlansInResidentPage("Restorative");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocRestorative.SelectRestorativeOptions(CarePlan);		
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA358_Self_And_Support_Under_Strength_Training_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Strength Training");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Self & Support");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyActivityOptionalSelfPerformanceAndSupport("","Independent","Independent");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA359_NU_Step_Minutes_Under_Strength_Training_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Strength Training");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("NU-Step Minute");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyCalculator();
		pocRestorative.EnterPasscode("50");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	@Test()
	public void POC_QA360_Tolerance_Under_Strength_Training_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Strength Training");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Tolerance");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyTolerance("Tolerated Well");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA361_NoParticipation_NoParticipation_With_Notes_Under_Strength_Training_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Sebastian Sebsmith");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Strength Training");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();		
		pocBowelBladder.SelectBowelOption("No Participation With Notes");
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocBowelBladder.SelectBowelOption("No Participation");
		Thread.sleep(2000);	
		pocRestorative.VerifyNoParticipation();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA362_Restorative_Recording_For_Resident(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.VerifyCarePlansInResidentPage("Restorative");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocRestorative.SelectRestorativeOptions(CarePlan);		
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA363_Self_And_Support_Under_Transfer_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Transfer");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Self & Support");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyActivityOptionalSelfPerformanceAndSupport("","Independent","Independent");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA364_Minutes_Under_Transfer_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Transfer");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Minute");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyCalculator();
		pocRestorative.EnterPasscode("50");
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA365_Tolerance_Under_Transfer_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Transfer");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();
		pocBowelBladder.SelectBowelOption("Tolerance");
		Thread.sleep(2000);	
		pocBowelBladder.ComponentsInBMWindow();
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocRestorative.VerifyTolerance("Tolerated Well");	
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA366_NoParticipation_NoParticipation_With_Notes_Under_Transfer_Restorative_Recording_For_Resident(ITestContext testContext) throws InterruptedException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Restorative pocRestorative = new POC_CarePlan_Restorative(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Sebastian Sebsmith");
		pocResident.SelectActivityOptionFromMatrix("Restorative");
		pocBowelBladder.SelectBetweenBowelAndBladder("Transfer");
		ArrayList<String> CarePlan =pocBowelBladder.verifyBowelFirstScreen();		
		pocBowelBladder.SelectBowelOption("No Participation With Notes");
		Thread.sleep(2000);	
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocBowelBladder.SelectBowelOption("No Participation");
		Thread.sleep(2000);	
		pocRestorative.VerifyNoParticipation();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
}


	


