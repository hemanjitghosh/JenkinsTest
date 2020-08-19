package POC.tests.functionalTests;

import java.awt.AWTException;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import POC.pages.POC_CarePlan_ADLs;
import POC.pages.POC_CarePlan_BowelAndBladder;
import POC.pages.POC_CarePlan_HeightAndWeight;
import POC.pages.POC_HomePage;
import dweb.test.templates.TestTemplate;
import dweb.test.templates.TestTemplateMethodLevelInit;

public class CarePlan_HeightAndWeight_TestCases extends TestTemplateMethodLevelInit{

	//@Test()
	public void POC_QA294_Height_Recording_For_Resident(ITestContext testContext) throws InterruptedException, AWTException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_HeightAndWeight pocHeightWeight = new POC_CarePlan_HeightAndWeight(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");

		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.VerifyCarePlansInResidentPage("Height & Weight");
		pocResident.SelectActivityOptionFromMatrix("Height & Weight");
		String[] HeightWeight = pocHeightWeight.VerifyHeightAndWeightWindowDetails("Height");
		pocBowelBladder.SelectBowelOption("Height");
		pocHome.SelectUserAndVerifyCalculator("");
		pocBowelBladder.ComponentsInBMWindow();
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		pocHome.EnterPasscode("50");
		String NewHeightWeightDate = pocHeightWeight.VerifyHeightAndWeightAfterSelection("Height",HeightWeight[1]);
		pocBowelBladder.SelectBowelOption("Height");
		pocHeightWeight.VerifyHeightAndWeightAfterSelection("Height",NewHeightWeightDate);
		pocHeightWeight.SelectOutOfFacility();
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}
	
	@Test()
	public void POC_QA295_Weight_Recording_For_Resident(ITestContext testContext) throws InterruptedException, AWTException
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_ADLs pocResident = new POC_CarePlan_ADLs(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_HeightAndWeight pocHeightWeight = new POC_CarePlan_HeightAndWeight(threadLocalWebDriver.get(), TestTemplate.testReport);
		POC_CarePlan_BowelAndBladder pocBowelBladder = new POC_CarePlan_BowelAndBladder(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		String PassCode = this.getTestParameter(testContext, "passCode");
		String LoginName = this.getTestParameter(testContext, "LoginName");

		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.EnterPasscode(PassCode);
		pocResident.VerifyResidentDashBoard();
		pocResident.SelectUserByName("Riley Thurman");
		pocResident.VerifyCarePlansInResidentPage("Height & Weight");
		pocResident.SelectActivityOptionFromMatrix("Height & Weight");
		String[] HeightWeight = pocHeightWeight.VerifyHeightAndWeightWindowDetails("Weight");
		pocBowelBladder.SelectBowelOption("Weight");
		pocBowelBladder.ComponentsInBMWindow();
		//String Text = pocBowelBladder.WrittingTextInNotes("test1");
		pocResident.VefifyEnterNotesValidation();
		pocResident.SaveEnterNotesWindow();
		//pocBowelBladder.ValidateEnterNoteText(Text,"Weight");
		pocHeightWeight.EnterOptionsForWeight("Add Appliance", "Scale");
		pocHome.SelectUserAndVerifyCalculator("");
		pocHome.EnterPasscode("500");
		String NewHeightWeightDate = pocHeightWeight.VerifyHeightAndWeightAfterSelection("Weight",HeightWeight[1]);
		pocBowelBladder.SelectBowelOption("Weight");
		pocHeightWeight.SelectOutOfFacility();
		pocHeightWeight.VerifyHeightAndWeightAfterSelection("Weight",NewHeightWeightDate);		
		pocResident.BigLogoutFromApplication();
		pocHome.ShutDownTheApplication();
	}

}
