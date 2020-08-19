package POC.tests.functionalTests;

import java.awt.AWTException;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import POC.pages.POC_CarePlan_ADLs;
import POC.pages.POC_CarePlan_BowelAndBladder;
import POC.pages.POC_HomePage;
import dweb.test.templates.TestTemplate;
import dweb.test.templates.TestTemplateMethodLevelInit;

public class CarePlan_BowelAndBladder_TestCases extends TestTemplateMethodLevelInit{

	@Test()
	public void POC_QA285_Bowel_First_Screen(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");		
		pocResident.VerifyCarePlansInResidentPage("Bowel & Bladder");
		pocResident.SelectActivityOptionFromMatrix("Bowel & Bladder");
		pocBowelBladder.verifyBowelFirstScreen();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA286_Bowel_Recording_For_NO_BM(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Bowel & Bladder");
		pocBowelBladder.SelectBetweenBowelAndBladder("Bowel");
		String ResidentWithTimeText = pocBowelBladder.getTextBeforeBowelMovement();
		pocBowelBladder.SelectBowelOption("No BM");
		pocBowelBladder.GetTextBowelMovementAfterClicking(ResidentWithTimeText);
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA287_Bowel_Recording_For_BM(ITestContext testContext) throws InterruptedException, AWTException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Bowel & Bladder");
		pocBowelBladder.SelectBetweenBowelAndBladder("Bowel");
		pocBowelBladder.SelectBowelOption("BM");
		pocBowelBladder.VerifyButtonsInBMWindow();
		pocBowelBladder.ComponentsInBMWindow();
		//String Text = pocBowelBladder.WrittingTextInNotes("123");
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		//pocBowelBladder.ValidateEnterNoteText(Text,"");
		String[] options =pocBowelBladder.SelectOptionsFromBM("Continence", "Watery Stool", "Small");
		pocBowelBladder.VerifyBowelMovementAfterSelectingBM(options[0],options[1]);
		pocBowelBladder.SelectBowelOption("BM");
		pocBowelBladder.CancelOpenWindow();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA288_Bowel_Recording_For_Appliance(ITestContext testContext) throws InterruptedException, AWTException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Bowel & Bladder");
		pocBowelBladder.SelectBetweenBowelAndBladder("Bowel");
		pocBowelBladder.SelectBowelOption("Appliance");
		pocBowelBladder.VerifyButtonsInBMWindow();
		pocBowelBladder.ComponentsInBMWindow();
		//String Text = pocBowelBladder.WrittingTextInNotes("test1");
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		//pocBowelBladder.ValidateEnterNoteText(Text,"");
		String ColostomyBag = pocBowelBladder.SelectColostomyBagFromAppliance();
		pocBowelBladder.VerifyApplianceAfterSelection("Appliance",ColostomyBag);
		pocBowelBladder.SelectBowelOption("Appliance");
		pocBowelBladder.CancelOpenWindow();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA289_Bowel_Recording_For_Training(ITestContext testContext) throws InterruptedException, AWTException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Bowel & Bladder");
		pocBowelBladder.SelectBetweenBowelAndBladder("Bowel");
		pocBowelBladder.SelectBowelOption("Training");
		pocBowelBladder.VerifyButtonsInBMWindow();
		pocBowelBladder.ComponentsInBMWindow();
		//String Text = pocBowelBladder.WrittingTextInNotes("test1");
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		//pocBowelBladder.ValidateEnterNoteText(Text,"");
		String Option = pocBowelBladder.SelectionFromTraining();
		pocBowelBladder.VerifyApplianceAfterSelection("Training",Option);
		pocBowelBladder.SelectBowelOption("Training");
		pocBowelBladder.CancelOpenWindow();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA290_Bladder_Recording_For_NO_Output(ITestContext testContext) throws InterruptedException, AWTException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Bowel & Bladder");
		pocBowelBladder.SelectBetweenBowelAndBladder("Bladder");
		pocBowelBladder.SelectBowelOption("No Ouput");
		pocBowelBladder.VerifyButtonsInBMWindow();
		pocBowelBladder.ComponentsInBMWindow();
		//String Text = pocBowelBladder.WrittingTextInNotes("test1");
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();		
		pocBowelBladder.CancelOpenWindow();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA291_Bladder_Recording_For_Output(ITestContext testContext) throws InterruptedException, AWTException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Bowel & Bladder");
		pocBowelBladder.SelectBetweenBowelAndBladder("Bladder");
		pocBowelBladder.SelectBowelOption("Output");
		pocBowelBladder.VerifyButtonsInBMWindow();
		pocBowelBladder.ComponentsInBMWindow();
		//String Text = pocBowelBladder.WrittingTextInNotes("test1");
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();		
		//pocBowelBladder.ValidateEnterNoteText(Text,"");
		String[] options =pocBowelBladder.SelectOptionsFromBM("Continence", "", "");
		pocBowelBladder.VerifyBowelMovementAfterSelectingBM(options[0],options[1]);
		pocBowelBladder.SelectBowelOption("Output");
		pocBowelBladder.CancelOpenWindow();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}


	@Test()
	public void POC_QA292_Bladder_Recording_For_Appliance(ITestContext testContext) throws InterruptedException, AWTException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Bowel & Bladder");
		pocBowelBladder.SelectBetweenBowelAndBladder("Bladder");
		pocBowelBladder.SelectBowelOption("Appliance");
		pocBowelBladder.VerifyButtonsInBMWindow();
		pocBowelBladder.ComponentsInBMWindow();
		//String Text = pocBowelBladder.WrittingTextInNotes("test1");
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();		
		//pocBowelBladder.ValidateEnterNoteText(Text,"");
		String SelectAppliance =pocBowelBladder.VerifyBladderAppliance("Ostomy (urostomy, ileostomy)");
		pocBowelBladder.VerifyApplianceAfterSelection("Appliance",SelectAppliance);
		pocBowelBladder.SelectBowelOption("Appliance");
		pocBowelBladder.CancelOpenWindow();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA293_Bladder_Recording_For_Training(ITestContext testContext) throws InterruptedException, AWTException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);

		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");
		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.SelectActivityOptionFromMatrix("Bowel & Bladder");
		pocBowelBladder.SelectBetweenBowelAndBladder("Bladder");
		pocBowelBladder.SelectBowelOption("Training");
		pocBowelBladder.VerifyButtonsInBMWindow();
		pocBowelBladder.ComponentsInBMWindow();
		//String Text = pocBowelBladder.WrittingTextInNotes("test1");
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		//pocBowelBladder.ValidateEnterNoteText(Text,"");
		String Option = pocBowelBladder.SelectionFromTraining();
		pocBowelBladder.VerifyApplianceAfterSelection("Training",Option);
		pocBowelBladder.SelectBowelOption("Training");
		pocBowelBladder.CancelOpenWindow();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
}
