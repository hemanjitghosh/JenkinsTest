package POC.tests.functionalTests;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import POC.pages.POC_CarePlan_ADLs;
import POC.pages.POC_CarePlan_BowelAndBladder;
import POC.pages.POC_CarePlan_HeightAndWeight;
import POC.pages.POC_CarePlan_IntakeAndOutput;
import POC.pages.POC_HomePage;
import dweb.test.templates.TestTemplate;
import dweb.test.templates.TestTemplateMethodLevelInit;

public class CarePlan_IntakeAndOutput_TestCases extends TestTemplateMethodLevelInit {

	@Test()
	public void POC_QA296_Intake_Recording_For_Resident(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_HeightAndWeight pocHeightWeight = new POC_CarePlan_HeightAndWeight(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_IntakeAndOutput pocIntakeOutput = new POC_CarePlan_IntakeAndOutput(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");

		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.VerifyCarePlansInResidentPage("Intake & Output");
		pocResident.SelectActivityOptionFromMatrix("Intake & Output");
		pocIntakeOutput.VerifyInTakeOutputCarePlan("Intake");
		pocBowelBladder.SelectBowelOption("Intake");
		pocBowelBladder.ComponentsInBMWindow();
		//String Text = pocBowelBladder.WrittingTextInNotes("test1");
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		//pocBowelBladder.ValidateEnterNoteText(Text,"Intake");
		pocHeightWeight.EnterOptionsForWeight("Oral");
		pocHome.SelectUserAndVerifyCalculator("");
		pocHome.EnterPasscode("500");
		pocBowelBladder.SelectBowelOption("Intake");
		pocHeightWeight.SelectOutOfFacility();
		pocBowelBladder.CancelOpenWindow();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	
	@Test()
	public void POC_QA297_Output_Recording_For_Resident(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_HeightAndWeight pocHeightWeight = new POC_CarePlan_HeightAndWeight(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_IntakeAndOutput pocIntakeOutput = new POC_CarePlan_IntakeAndOutput(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");

		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.VerifyCarePlansInResidentPage("Intake & Output");
		pocResident.SelectActivityOptionFromMatrix("Intake & Output");
		pocIntakeOutput.VerifyInTakeOutputCarePlan("Output");
		pocBowelBladder.SelectBowelOption("Output");
		pocBowelBladder.ComponentsInBMWindow();
		//String Text = pocBowelBladder.WrittingTextInNotes("test1");
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		//pocBowelBladder.ValidateEnterNoteText(Text,"Output");
		pocHeightWeight.EnterOptionsForWeight("Urine");
		pocHome.SelectUserAndVerifyCalculator("");
		pocHome.EnterPasscode("500");
		pocBowelBladder.SelectBowelOption("Output");
		pocHeightWeight.SelectOutOfFacility();
		pocBowelBladder.CancelOpenWindow();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
}
