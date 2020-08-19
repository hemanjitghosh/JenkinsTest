package POC.tests.functionalTests;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import POC.pages.POC_HomePage;
import dweb.test.templates.TestTemplate;
import dweb.test.templates.TestTemplateMethodLevelInit;

public class HomePageTestCases extends TestTemplateMethodLevelInit {




	//@Test()
	public void POC_QA262_BlueStrata_Point_Of_Care_Header()
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);

		pocHome.VerifyPageLogoAndDayDayeAndTime();
		pocHome.ShutDownTheApplication();
	}

	//@Test()
	public void POC_QA263_POC_Application_Landing_Page_contents()
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);

		pocHome.VerifyIconsDisplayedInLandingPage();
		pocHome.VerifySectionsUnderIconDefinationPage();
		pocHome.UserAbleToClickOnIconDisplayedInLeftPane();
		pocHome.ShutDownTheApplication();
	}

	//@Test()
	public void POC_QA264_Station_Setup_1st_Icon_In_Left_Pane()
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);

		pocHome.VerifySectionsUnderIconDefinationPage();
		pocHome.ClickOnIcon("Setup Station");
		pocHome.ShutDownTheApplication();
	}

	//@Test()
	public void POC_QA265_Station_Setup_2nd_Icon_In_Left_Pane(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		String LoginName = this.getTestParameter(testContext, "LoginName");

		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.ClickCancelTheCalculator();
		pocHome.ShutDownTheApplication();
	}

	//@Test()
	public void POC_QA266_Station_Setup_3rd_Icon_In_Left_Pane(ITestContext testContext)
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		String LoginName = this.getTestParameter(testContext, "LoginName");

		pocHome.ClickOnIcon("Login to NTouch");
		pocHome.SelectUser("QAFull (KevinH) - QA - HBV - Wired");
		pocHome.SelectUserAndVerifyCalculator(LoginName);
		pocHome.ClickCancelTheCalculator();
		pocHome.ShutDownTheApplication();
	}

	@Test()
	public void POC_QA267_Station_Setup_4rd_Icon_In_Left_Pane()
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);

		pocHome.ClickOnIcon("Configure application");
		pocHome.VerifyOptionsUnderConfigureApplication();
		pocHome.ShutDownTheApplication();
	}

	////@Test()
	public void POC_QA268_Station_Setup_5th_Icon_In_Left_Pane()
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);

		pocHome.ClickOnIcon("View station information");
		pocHome.ViewStationInformation();
		pocHome.ShutDownTheApplication();
	}
	
	//@Test()
	public void POC_QA269_Station_Setup_6th_Icon_In_Left_Pane()
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);

		pocHome.ClickOnIcon("Setup user's fingerprint");
		pocHome.ClickOnIcon("Restart the application");
		pocHome.VerifyPageLogoAndDayDayeAndTime();
		pocHome.ShutDownTheApplication();
	}

	//@Test()
	public void POC_QA270_Station_Setup_7th_Icon_In_Left_Pane()
	{
		POC_HomePage pocHome = new POC_HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);

		pocHome.ClickOnIcon("Shutdown the application");
		pocHome.ShutDownTheApplication();
	}

	
	
}
