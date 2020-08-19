package POC.tests.functionalTests;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import POC.pages.POC_CarePlan_ADLs;
import POC.pages.POC_CarePlan_BowelAndBladder;
import POC.pages.POC_CarePlan_MoodAndBehavior;
import POC.pages.POC_CarePlan_Vitals;
import POC.pages.POC_HomePage;
import dweb.test.templates.TestTemplate;
import dweb.test.templates.TestTemplateMethodLevelInit;

public class CarePlan_Vitals_TestCases extends TestTemplateMethodLevelInit {

	@Test()
	public void POC_QA304_Vitals_Recording_For_Resident(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_MoodAndBehavior pocMoodBehavior = new POC_CarePlan_MoodAndBehavior(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_Vitals pocVitals = new POC_CarePlan_Vitals(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Vitals");	
		pocResident.EditingAndRemovingADLsRecords();
		String[] OPTION =pocBowelBladder.SelectBowelOption("");
		pocVitals.SelectVitals(OPTION,"ab","50","Oral","30");		
		pocResident.EditADLEntryForShifts();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}


}
