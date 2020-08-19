package bluestrata.tests.functionalTests;

import java.net.URISyntaxException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.enums.IncidentItem;
import com.excel.Xls_Reader;

import bluestrata.pages.AccountsPayablePage;
import bluestrata.pages.HomePage;
import bluestrata.pages.LoginPage;
import bluestrata.pages.Clinical.IncidentAccidentPage;
import dweb.test.templates.TestTemplate;
import dweb.test.templates.TestTemplateMethodLevelInit;

public class IncidentAccidentsTestCases extends TestTemplateMethodLevelInit {
	
	Xls_Reader xlsReader = new Xls_Reader("C:\\Users\\hemanjitg\\Desktop\\BlueStrata\\LTC-AutomatedTests\\src\\test\\resources\\testdata\\BlueStrata_Data.xlsx");
	final String SheetName = "IncidentsAccidents";
	
	
	//@Test()
	public void QA01_verifyIncident_verifyMenuItems(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA01";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.clickIncidentItems(IncidentItem.Notification.toString());
		incidentAccidentPage.clickIncidentItems(IncidentItem.Witnesses.toString());
		incidentAccidentPage.clickIncidentItems(IncidentItem.Injuries.toString());
		incidentAccidentPage.clickIncidentItems(IncidentItem.VitalSigns.toString());
		incidentAccidentPage.clickIncidentItems(IncidentItem.CarePlans.toString());
		incidentAccidentPage.clickIncidentItems(IncidentItem.Meals.toString());
		incidentAccidentPage.clickIncidentItems(IncidentItem.BowelBladder.toString());
		incidentAccidentPage.clickIncidentItems(IncidentItem.PhysicianOrders.toString());
		incidentAccidentPage.clickIncidentItems(IncidentItem.MedicationAdministrations.toString());
		incidentAccidentPage.clickIncidentItems(IncidentItem.FallAssessmentHistory.toString());
		incidentAccidentPage.clickIncidentItems(IncidentItem.Signatures.toString());
		
	}
	
	//@Test()
	public void QA02_verifyIncident_AddIncident(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA02";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
	}
	
	
	//@Test()
	public void QA03_verifyIncident_ValidateIncidentItems(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA03";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.verifyIncidentTypeDropdown(testdata.get("IncidentType1"));
		incidentAccidentPage.verifyIncidentTypeDropdown(testdata.get("IncidentType2"));
		incidentAccidentPage.verifyIncidentTypeDropdown(testdata.get("IncidentType3"));
		incidentAccidentPage.verifyIncidentTypeDropdown(testdata.get("IncidentType4"));
		incidentAccidentPage.verifyIncidentTypeDropdown(testdata.get("IncidentType5"));
		incidentAccidentPage.verifyIncidentTypeDropdown(testdata.get("IncidentType6"));
		incidentAccidentPage.verifyIncidentTypeDropdown(testdata.get("IncidentType7"));
		incidentAccidentPage.verifyIncidentTypeDropdown(testdata.get("IncidentType8"));
		incidentAccidentPage.verifyIncidentTypeDropdown(testdata.get("IncidentType9"));
		incidentAccidentPage.verifyIncidentTypeDropdown(testdata.get("IncidentType10"));
		incidentAccidentPage.verifyIncidentPage();
		
		
	}
	
	
	//@Test()
	public void QA04_verifyIncident_AddEditDeleteNotification(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA04";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Notification.toString());
		incidentAccidentPage.addNotification(testdata.get("TypeOfContact"), testdata.get("NameOfContact"), testdata.get("ContactNotes"));
		incidentAccidentPage.verifyNotification(testdata.get("TypeOfContact"), testdata.get("NameOfContact"), testdata.get("ContactNotes"));
		incidentAccidentPage.editNotification(testdata.get("EditTypeOfContact"), testdata.get("EditNameOfContact"), testdata.get("EditContactNotes"));
		incidentAccidentPage.verifyNotification(testdata.get("EditTypeOfContact"), testdata.get("EditNameOfContact"), testdata.get("EditContactNotes"));
		incidentAccidentPage.deleteNotification();
		}
	
	
	//@Test()
	public void QA05_verifyIncident_ValidateNotificationItems(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA05";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		incidentAccidentPage.clickIncidentItems(IncidentItem.Notification.toString()); 
		incidentAccidentPage.addNotification();
		incidentAccidentPage.verifyNotificationItems();
		
	}
	
	
	//@Test()
	public void QA06_verifyIncident_AddEditDeleteWitness(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA06";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		incidentAccidentPage.clickIncidentItems(IncidentItem.Witnesses.toString()); 
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.addWitness(testdata.get("WitnessType"), testdata.get("Name"), testdata.get("Phone"), testdata.get("Statement"));
		incidentAccidentPage.verifyWitness(testdata.get("WitnessType"), testdata.get("Name"), testdata.get("Phone"), testdata.get("Statement"));
		incidentAccidentPage.EditWitness(testdata.get("WitnessType"), testdata.get("EditName"), testdata.get("EditPhone"), testdata.get("EditStatement"));
		incidentAccidentPage.verifyWitness(testdata.get("WitnessType"), testdata.get("EditName"), testdata.get("EditPhone"), testdata.get("EditStatement"));
		incidentAccidentPage.deleteWitness();
	}
	
	
	//@Test()
	public void QA07_verifyIncident_ValidateWitnessItems(ITestContext testContext) throws URISyntaxException, InterruptedException
	{

		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA07";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		incidentAccidentPage.clickIncidentItems(IncidentItem.Witnesses.toString()); 
		incidentAccidentPage.verifyWitnessItems();
	}
	
	
	//@Test()
	public void QA08_verifyIncident_AddEditDeleteInjuries(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA08";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		incidentAccidentPage.clickIncidentItems(IncidentItem.Injuries.toString()); 
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.AddInjury(testdata.get("Type"), testdata.get("Severity"), testdata.get("Location"),  testdata.get("FirstAidAdministeredBy"));
		incidentAccidentPage.verifyInjury(testdata.get("Type"), testdata.get("Severity"), testdata.get("Location"),  testdata.get("FirstAidAdministeredBy"));
		incidentAccidentPage.editInjury(testdata.get("EditType"), testdata.get("EditSeverity"), testdata.get("Location"),  testdata.get("EditFirstAidAdministeredBy"));
		incidentAccidentPage.verifyInjury(testdata.get("EditType"), testdata.get("EditSeverity"), testdata.get("Location"),  testdata.get("EditFirstAidAdministeredBy"));
		incidentAccidentPage.removeInjury();
	}
	
	//@Test()
	public void QA09_verifyIncident_ValidateInjuriesItems(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA09";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		incidentAccidentPage.clickIncidentItems(IncidentItem.Injuries.toString()); 
		incidentAccidentPage.verifyInjuryItems();
	}
	
	//@Test()
	public void QA10_verifyIncident_AddEditDeleteMeals(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA10";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.Meals.toString()); 
		//incidentAccidentPage.removeMeal();
		//incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		//incidentAccidentPage.clickIncidentItems(IncidentItem.Meals.toString()); 
		incidentAccidentPage.addMeal(testdata.get("MealType"), testdata.get("MealLocation"), testdata.get("PercentConsumed"));
		incidentAccidentPage.verifyMeal(testdata.get("MealType"), testdata.get("MealLocation"), testdata.get("PercentConsumed"));
		incidentAccidentPage.editMeal(testdata.get("EditMealType"), testdata.get("EditMealLocation"), testdata.get("EditPercentConsumed"));
		incidentAccidentPage.verifyMeal(testdata.get("EditMealType"), testdata.get("EditMealLocation"), testdata.get("EditPercentConsumed"));
		incidentAccidentPage.removeMeal();
		
	}
	
	//@Test()
	public void QA11_verifyIncident_AddMeals_withMandatoryFields(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA11";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.Meals.toString()); 
		incidentAccidentPage.addMeal(testdata.get("MealType"), testdata.get("MealLocation"));
		incidentAccidentPage.verifyMeal(testdata.get("MealType"), testdata.get("MealLocation"));
		incidentAccidentPage.removeMeal();
		
	}
	
	
	@Test()
	public void QA12_verifyIncident_EditMeals_withMandatoryFields(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA12";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.Meals.toString()); 
		incidentAccidentPage.addMeal(testdata.get("MealType"), testdata.get("MealLocation"));
		incidentAccidentPage.editMeal(testdata.get("EditMealType"), testdata.get("EditMealLocation"));
		incidentAccidentPage.verifyMeal(testdata.get("EditMealType"), testdata.get("EditMealLocation"));
		incidentAccidentPage.removeMeal();
	}
	
	
	//@Test()
	public void QA13_verifyIncident_AddMeals_withCancelButton(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA13";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.Meals.toString()); 
		incidentAccidentPage.addMealandCancel(testdata.get("MealType"), testdata.get("MealLocation"));
		incidentAccidentPage.cancelMeal();
	}
	
	//@Test()
	public void QA14_verifyIncident_EditMeals_withCancelCheck(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA14";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.Meals.toString()); 
		incidentAccidentPage.addMeal(testdata.get("MealType"), testdata.get("MealLocation"));
		incidentAccidentPage.editMealandCancel(testdata.get("EditMealType"), testdata.get("EditMealLocation"));
		incidentAccidentPage.cancelMeal();
		incidentAccidentPage.removeMeal();
	}
	
	//@Test()
	public void QA15_verifyIncident_AddMeals_saveWithoutMandatoryFields(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA15";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString()); 
		
		incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.Meals.toString()); 
		incidentAccidentPage.addMealWithoutMandatoryFields("46");
	}
	
	//@Test()
	public void QA16_verifyIncident_AddMeals_saveIncident(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA10";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.Meals.toString()); 
		incidentAccidentPage.addMeal(testdata.get("MealType"), testdata.get("MealLocation"), testdata.get("PercentConsumed"));
		incidentAccidentPage.verifyMeal(testdata.get("MealType"), testdata.get("MealLocation"), testdata.get("PercentConsumed"));
		incidentAccidentPage.saveIncident();
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.Meals.toString());
		incidentAccidentPage.clickIncidentItems(IncidentItem.Meals.toString()); 
		incidentAccidentPage.verifyMeal(testdata.get("MealType"), testdata.get("MealLocation"), testdata.get("PercentConsumed"));
		incidentAccidentPage.removeMeal();
		incidentAccidentPage.saveIncident();
		
	}
	
	//@Test()
	public void QA17_verifyIncident_AddNotification_withMandatoryFields(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA17";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Notification.toString());
		incidentAccidentPage.addNotificationWithMandatoryFields(testdata.get("TypeOfContact"), testdata.get("NameOfContact"));
		incidentAccidentPage.verifyNotificationWithMandatoryFields(testdata.get("TypeOfContact"), testdata.get("NameOfContact"));
	
}
	//@Test()
	public void QA18_verifyIncident_EditNotification_withMandatoryFields(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA18";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Notification.toString());
		incidentAccidentPage.addNotificationWithMandatoryFields(testdata.get("TypeOfContact"), testdata.get("NameOfContact"));
		incidentAccidentPage.verifyNotificationWithMandatoryFields(testdata.get("TypeOfContact"), testdata.get("NameOfContact"));
		incidentAccidentPage.editNotificationWithMandatoryFields(testdata.get("EditTypeOfContact"), testdata.get("EditNameOfContact"));
		incidentAccidentPage.verifyNotificationWithMandatoryFields(testdata.get("EditTypeOfContact"), testdata.get("EditNameOfContact"));
		
	
}
	//@Test()
	public void QA19_verifyIncident_AddNotification_withCancelCheck(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA19";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Notification.toString());
		incidentAccidentPage.addNotificationAndCancel(testdata.get("TypeOfContact"), testdata.get("NameOfContact"), testdata.get("ContactNotes"));
	
}
	//@Test()
	public void QA20_verifyIncident_EditNotification_withCancelCheck(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA20";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Notification.toString());
		incidentAccidentPage.addNotification(testdata.get("TypeOfContact"), testdata.get("NameOfContact"), testdata.get("ContactNotes"));
		incidentAccidentPage.verifyNotification(testdata.get("TypeOfContact"), testdata.get("NameOfContact"), testdata.get("ContactNotes"));
		incidentAccidentPage.editNotificationAndCancel(testdata.get("EditTypeOfContact"), testdata.get("EditNameOfContact"), testdata.get("EditContactNotes"));
		
	
}
	//@Test()
	public void QA21_verifyIncident_AddNotification_withoutMandatoryFields(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA21";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Notification.toString());
		incidentAccidentPage.addNotificationWithoutMandatoryFields(testdata.get("ContactNotes"));
	
}	//@Test()
	public void QA22_verifyIncident_AddNotification_saveIncident(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA22";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.Notification.toString());
		incidentAccidentPage.addNotification(testdata.get("TypeOfContact"), testdata.get("NameOfContact"), testdata.get("ContactNotes"));
		incidentAccidentPage.verifyNotification(testdata.get("TypeOfContact"), testdata.get("NameOfContact"), testdata.get("ContactNotes"));
		incidentAccidentPage.saveIncident();
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.Notification.toString());
		incidentAccidentPage.verifyNotification(testdata.get("TypeOfContact"), testdata.get("NameOfContact"), testdata.get("ContactNotes"));
}
	
//@Test()
public void QA23_verifyIncident_AddInjuries_withMandatoryFields(ITestContext testContext) throws URISyntaxException, InterruptedException
{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	
	final String testCase = "QA23";
	
	String userName = this.getTestParameter(testContext, "userName");
	String password = this.getTestParameter(testContext, "password");
	login.login(userName, password);
	homepage.NavigateToIncidentsAccidents();
	incidentAccidentPage.clickAddIncident();
	incidentAccidentPage.clickIncidentItems(IncidentItem.Injuries.toString()); 
	HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	incidentAccidentPage.AddInjuryWithMandatoryFields(testdata.get("Type"), testdata.get("Severity"), testdata.get("Location"));
	incidentAccidentPage.verifyInjuryWithMandatoryFields(testdata.get("Type"), testdata.get("Severity"), testdata.get("Location"));
	incidentAccidentPage.removeInjury();
	}

//@Test()
public void QA24_verifyIncident_EditInjuries_withMandatoryFields(ITestContext testContext) throws URISyntaxException, InterruptedException
{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	
	final String testCase = "QA24";
	
	String userName = this.getTestParameter(testContext, "userName");
	String password = this.getTestParameter(testContext, "password");
	login.login(userName, password);
	homepage.NavigateToIncidentsAccidents();
	incidentAccidentPage.clickAddIncident();
	incidentAccidentPage.clickIncidentItems(IncidentItem.Injuries.toString()); 
	HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	incidentAccidentPage.AddInjuryWithMandatoryFields(testdata.get("Type"), testdata.get("Severity"), testdata.get("Location"));
	incidentAccidentPage.verifyInjuryWithMandatoryFields(testdata.get("Type"), testdata.get("Severity"), testdata.get("Location"));
	incidentAccidentPage.editInjuryWithMandatoryFields(testdata.get("EditType"), testdata.get("EditSeverity"), testdata.get("Location"));
	incidentAccidentPage.verifyInjuryWithMandatoryFields(testdata.get("EditType"), testdata.get("EditSeverity"), testdata.get("Location"));
	incidentAccidentPage.removeInjury();
}

//@Test()
public void QA25_verifyIncident_AddInjuries_withCancelCheck(ITestContext testContext) throws URISyntaxException, InterruptedException
{

	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	
	final String testCase = "QA25";
	
	String userName = this.getTestParameter(testContext, "userName");
	String password = this.getTestParameter(testContext, "password");
	login.login(userName, password);
	homepage.NavigateToIncidentsAccidents();
	incidentAccidentPage.clickAddIncident();
	incidentAccidentPage.clickIncidentItems(IncidentItem.Injuries.toString()); 
	HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	incidentAccidentPage.addInjuryWithCancel(testdata.get("Type"), testdata.get("Severity"), testdata.get("Location"),  testdata.get("FirstAidAdministeredBy"));
	incidentAccidentPage.cancelInjury();
	
	}

//@Test()
public void QA26_verifyIncident_EditInjuries_withCancelCheck(ITestContext testContext) throws URISyntaxException, InterruptedException
{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	
	final String testCase = "QA26";
	
	String userName = this.getTestParameter(testContext, "userName");
	String password = this.getTestParameter(testContext, "password");
	login.login(userName, password);
	homepage.NavigateToIncidentsAccidents();
	incidentAccidentPage.clickAddIncident();
	incidentAccidentPage.clickIncidentItems(IncidentItem.Injuries.toString()); 
	HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	incidentAccidentPage.AddInjuryWithMandatoryFields(testdata.get("Type"), testdata.get("Severity"), testdata.get("Location"));
	incidentAccidentPage.verifyInjuryWithMandatoryFields(testdata.get("Type"), testdata.get("Severity"), testdata.get("Location"));
	incidentAccidentPage.editInjuryWithCancel();
	}


//@Test()
public void QA27_verifyIncident_AddInjuries_withoutMandatoryFields(ITestContext testContext) throws URISyntaxException, InterruptedException
{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	
	
	final String testCase = "QA27";
	
	String userName = this.getTestParameter(testContext, "userName");
	String password = this.getTestParameter(testContext, "password");
	login.login(userName, password);
	homepage.NavigateToIncidentsAccidents();
	incidentAccidentPage.clickAddIncident();
	incidentAccidentPage.clickIncidentItems(IncidentItem.Injuries.toString()); 
	HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	incidentAccidentPage.AddInjuryWithoutMandatoryFields(testdata.get("FirstAidAdministeredBy"));
	incidentAccidentPage.verifyInjuryWithoutMandatory();
}

//@Test()
public void QA28_verifyIncident_AddInjuries_saveIncident(ITestContext testContext) throws URISyntaxException, InterruptedException
{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	
	final String testCase = "QA28";
	
	String userName = this.getTestParameter(testContext, "userName");
	String password = this.getTestParameter(testContext, "password");
	login.login(userName, password);
	homepage.NavigateToIncidentsAccidents();
	incidentAccidentPage.clickAddIncident();
	HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
	incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("IncidentLocation"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
	incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("IncidentLocation"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
	incidentAccidentPage.clickIncidentItems(IncidentItem.Injuries.toString());
	incidentAccidentPage.AddInjury(testdata.get("Type"), testdata.get("Severity"), testdata.get("Location"),  testdata.get("FirstAidAdministeredBy"));
	incidentAccidentPage.verifyInjury(testdata.get("Type"), testdata.get("Severity"), testdata.get("Location"),  testdata.get("FirstAidAdministeredBy"));
	incidentAccidentPage.saveIncident();
	incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("IncidentLocation"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
	incidentAccidentPage.clickIncidentItems(IncidentItem.Injuries.toString());
	incidentAccidentPage.verifyInjury(testdata.get("Type"), testdata.get("Severity"), testdata.get("Location"),  testdata.get("FirstAidAdministeredBy"));
	incidentAccidentPage.removeInjury();
	incidentAccidentPage.saveIncident();
	
}

//@Test()
public void QA29_verifyIncident_AddWitness_withMandatoryFields(ITestContext testContext) throws URISyntaxException, InterruptedException
{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	
	final String testCase = "QA29";
	
	String userName = this.getTestParameter(testContext, "userName");
	String password = this.getTestParameter(testContext, "password");
	login.login(userName, password);
	homepage.NavigateToIncidentsAccidents();
	incidentAccidentPage.clickAddIncident();
	incidentAccidentPage.clickIncidentItems(IncidentItem.Witnesses.toString()); 
	HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	incidentAccidentPage.addWitness(testdata.get("WitnessType"), testdata.get("Name"));
	incidentAccidentPage.verifyWitness(testdata.get("WitnessType"), testdata.get("Name"));
	

}
//@Test()
public void QA30_verifyIncident_EditWitness_withMandatoryFields(ITestContext testContext) throws URISyntaxException, InterruptedException
{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	
	final String testCase = "QA30";
	
	String userName = this.getTestParameter(testContext, "userName");
	String password = this.getTestParameter(testContext, "password");
	login.login(userName, password);
	homepage.NavigateToIncidentsAccidents();
	incidentAccidentPage.clickAddIncident();
	incidentAccidentPage.clickIncidentItems(IncidentItem.Witnesses.toString()); 
	HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	incidentAccidentPage.addWitness(testdata.get("WitnessType"), testdata.get("Name"));
	incidentAccidentPage.verifyWitness(testdata.get("WitnessType"), testdata.get("Name"));
	incidentAccidentPage.EditWitness(testdata.get("WitnessType"), testdata.get("EditName"));
	incidentAccidentPage.verifyWitness(testdata.get("WitnessType"), testdata.get("EditName"));
	incidentAccidentPage.deleteWitness();

}

//@Test()
public void QA31_verifyIncident_AddWitness_withCancelCheck(ITestContext testContext) throws URISyntaxException, InterruptedException
{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	
	final String testCase = "QA31";
	
	String userName = this.getTestParameter(testContext, "userName");
	String password = this.getTestParameter(testContext, "password");
	login.login(userName, password);
	homepage.NavigateToIncidentsAccidents();
	incidentAccidentPage.clickAddIncident();
	incidentAccidentPage.clickIncidentItems(IncidentItem.Witnesses.toString()); 
	HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	incidentAccidentPage.addWitnessWithCancel(testdata.get("WitnessType"), testdata.get("Name"));
}

//@Test()
public void QA32_verifyIncident_EditWitness_withCancelCheck(ITestContext testContext) throws URISyntaxException, InterruptedException
{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	
	final String testCase = "QA32";
	
	String userName = this.getTestParameter(testContext, "userName");
	String password = this.getTestParameter(testContext, "password");
	login.login(userName, password);
	homepage.NavigateToIncidentsAccidents();
	incidentAccidentPage.clickAddIncident();
	incidentAccidentPage.clickIncidentItems(IncidentItem.Witnesses.toString()); 
	HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	incidentAccidentPage.addWitness(testdata.get("WitnessType"), testdata.get("Name"));
	incidentAccidentPage.verifyWitness(testdata.get("WitnessType"), testdata.get("Name"));
	incidentAccidentPage.EditWitnessWithCancel(testdata.get("WitnessType"), testdata.get("EditName"));
}

//@Test()
public void QA33_verifyIncident_AddWitness_withoutMandatoryFields(ITestContext testContext) throws URISyntaxException, InterruptedException
{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	
	final String testCase = "QA33";
	
	String userName = this.getTestParameter(testContext, "userName");
	String password = this.getTestParameter(testContext, "password");
	login.login(userName, password);
	homepage.NavigateToIncidentsAccidents();
	incidentAccidentPage.clickAddIncident();
	incidentAccidentPage.clickIncidentItems(IncidentItem.Witnesses.toString()); 
	HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	incidentAccidentPage.addWitnessWithoutMandatoryFields(testdata.get("Phone"), testdata.get("Statement"));
}

//@Test()
public void QA34_verifyIncident_AddWitness_saveIncident(ITestContext testContext) throws URISyntaxException, InterruptedException
{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	
	final String testCase = "QA34";
	
	String userName = this.getTestParameter(testContext, "userName");
	String password = this.getTestParameter(testContext, "password");
	login.login(userName, password);
	homepage.NavigateToIncidentsAccidents();
	incidentAccidentPage.clickAddIncident();
	HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
	incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("IncidentLocation"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
	incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("IncidentLocation"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
	incidentAccidentPage.clickIncidentItems(IncidentItem.Witnesses.toString());
	incidentAccidentPage.addWitness(testdata.get("WitnessType"), testdata.get("Name"));
	incidentAccidentPage.verifyWitness(testdata.get("WitnessType"), testdata.get("Name"));
	incidentAccidentPage.saveIncident();
	incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("IncidentLocation"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
	incidentAccidentPage.clickIncidentItems(IncidentItem.Witnesses.toString());
	incidentAccidentPage.verifyWitness(testdata.get("WitnessType"), testdata.get("Name"));
	incidentAccidentPage.deleteWitness();
	incidentAccidentPage.saveIncident();
	
	}

//@Test()
public void QA35_verifyIncident_AddBowelDetails(ITestContext testContext) throws URISyntaxException, InterruptedException
{

	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	
	final String testCase = "QA35";
	
	String userName = this.getTestParameter(testContext, "userName");
	String password = this.getTestParameter(testContext, "password");
	login.login(userName, password);
	homepage.NavigateToIncidentsAccidents();
	incidentAccidentPage.clickAddIncident();
	HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
	incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
	incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
	incidentAccidentPage.clickIncidentItems(IncidentItem.BowelBladder.toString()); 
	incidentAccidentPage.addBowelDetails(testdata.get("Form"), testdata.get("Size"), testdata.get("BowelNotes"));
	incidentAccidentPage.verifyBowelDetails(testdata.get("Form"), testdata.get("Size"), testdata.get("BowelNotes"));
	incidentAccidentPage.removeBowel();
	
}

//@Test()
public void QA36_verifyIncident_EditBowelDetails(ITestContext testContext) throws URISyntaxException, InterruptedException
{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	
	final String testCase = "QA36";
	
	String userName = this.getTestParameter(testContext, "userName");
	String password = this.getTestParameter(testContext, "password");
	login.login(userName, password);
	homepage.NavigateToIncidentsAccidents();
	incidentAccidentPage.clickAddIncident();
	HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
	incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
	incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
	incidentAccidentPage.clickIncidentItems(IncidentItem.BowelBladder.toString()); 
	incidentAccidentPage.addBowelDetails(testdata.get("Form"), testdata.get("Size"), testdata.get("BowelNotes"));
	incidentAccidentPage.editBowelDetails(testdata.get("EditForm"), testdata.get("EditSize"), testdata.get("EditBowelNotes"));
	incidentAccidentPage.verifyBowelDetails(testdata.get("EditForm"), testdata.get("EditSize"), testdata.get("EditBowelNotes"));
	incidentAccidentPage.removeBowel();
	
}

//@Test()
public void QA37_verifyIncident_AddBowel_CancelCheck(ITestContext testContext) throws URISyntaxException, InterruptedException
{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	
	final String testCase = "QA37";
	
	String userName = this.getTestParameter(testContext, "userName");
	String password = this.getTestParameter(testContext, "password");
	login.login(userName, password);
	homepage.NavigateToIncidentsAccidents();
	incidentAccidentPage.clickAddIncident();
	HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
	incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
	incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
	incidentAccidentPage.clickIncidentItems(IncidentItem.BowelBladder.toString()); 
	incidentAccidentPage.cancelBowelDetails(testdata.get("Form"), testdata.get("Size"), testdata.get("BowelNotes"));
}

//@Test
public void QA38_verifyIncident_EditBowel_CancelCheck(ITestContext testContext) throws URISyntaxException, InterruptedException
{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	
	final String testCase = "QA38";
	
	String userName = this.getTestParameter(testContext, "userName");
	String password = this.getTestParameter(testContext, "password");
	login.login(userName, password);
	homepage.NavigateToIncidentsAccidents();
	incidentAccidentPage.clickAddIncident();
	HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
	incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
	incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
	incidentAccidentPage.clickIncidentItems(IncidentItem.BowelBladder.toString()); 
	incidentAccidentPage.addBowelDetails(testdata.get("Form"), testdata.get("Size"), testdata.get("BowelNotes"));
	incidentAccidentPage.editBowelCancelCheck();
	incidentAccidentPage.removeBowel();
}

   //@Test()
	public void QA39_verifyIncident_AddBowel_SaveIncident(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
	IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	
	final String testCase = "QA39";
	
	String userName = this.getTestParameter(testContext, "userName");
	String password = this.getTestParameter(testContext, "password");
	login.login(userName, password);
	homepage.NavigateToIncidentsAccidents();
	incidentAccidentPage.clickAddIncident();
	HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
	incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
	incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
	incidentAccidentPage.clickIncidentItems(IncidentItem.BowelBladder.toString()); 
	incidentAccidentPage.removeBowel();
	incidentAccidentPage.addBowelDetails(testdata.get("Form"), testdata.get("Size"), testdata.get("BowelNotes"));
	incidentAccidentPage.verifyBowelDetails(testdata.get("Form"), testdata.get("Size"), testdata.get("BowelNotes"));
	incidentAccidentPage.saveIncident();
	incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
	incidentAccidentPage.clickIncidentItems(IncidentItem.BowelBladder.toString()); 
	incidentAccidentPage.verifyBowelDetails(testdata.get("Form"), testdata.get("Size"), testdata.get("BowelNotes"));
	incidentAccidentPage.removeBowel();
	incidentAccidentPage.saveIncident();
	}

   //@Test()
    public void QA40_verifyIncident_AddBladder(ITestContext testContext) throws URISyntaxException, InterruptedException
    {
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA40";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.BowelBladder.toString());
		incidentAccidentPage.addBladderDetails(testdata.get("Amount"),testdata.get("BladderNotes"));
		incidentAccidentPage.verifyBladderDetails(testdata.get("Amount"),testdata.get("BladderNotes"));
		incidentAccidentPage.removeBladder();
    }
    
   //@Test()
    public void QA41_verifyIncident_EditBladder(ITestContext testContext) throws URISyntaxException, InterruptedException
    {
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA41";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.BowelBladder.toString());
		incidentAccidentPage.addBladderDetails(testdata.get("Amount"),testdata.get("BladderNotes"));
		incidentAccidentPage.editBladderDetails(testdata.get("EditAmount"),testdata.get("EditBladderNotes"));
		incidentAccidentPage.verifyBladderDetails(testdata.get("EditAmount"),testdata.get("EditBladderNotes"));
		incidentAccidentPage.removeBladder();
    }

   //@Test()
    public void QA42_verifyIncident_AddBladder_CancelCheck(ITestContext testContext) throws URISyntaxException, InterruptedException
    {
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA42";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.BowelBladder.toString());
		incidentAccidentPage.addBladderDetailsCancelCheck(testdata.get("Amount"),testdata.get("BladderNotes"));
	
    }

   //@Test()
    public void QA43_verifyIncident_EditBladder_CancelCheck(ITestContext testContext) throws URISyntaxException, InterruptedException
    {
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA43";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.BowelBladder.toString());
		incidentAccidentPage.addBladderDetails(testdata.get("Amount"),testdata.get("BladderNotes"));
		incidentAccidentPage.editBladderDetailsCancelCheck();
		
    }
    
   //@Test()
    public void QA44_verifyIncident_AddBladder_SaveIncident(ITestContext testContext) throws URISyntaxException, InterruptedException
    {
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA44";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.BowelBladder.toString());
		incidentAccidentPage.addBladderDetails(testdata.get("Amount"),testdata.get("BladderNotes"));
		incidentAccidentPage.verifyBladderDetails(testdata.get("Amount"),testdata.get("BladderNotes"));
		incidentAccidentPage.saveIncident();
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.BowelBladder.toString()); 
		incidentAccidentPage.verifyBladderDetails(testdata.get("Amount"),testdata.get("BladderNotes"));
		incidentAccidentPage.removeBladder();
		incidentAccidentPage.saveIncident();
    }

   //@Test()
    public void QA45_verifyIncident_AddVitalSigns(ITestContext testContext) throws URISyntaxException, InterruptedException
    {
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA45";
		final String testCase1 = "QA45_1";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		HashMap<String ,String> testdata1 = xlsReader.GetValue(SheetName,testCase1);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.VitalSigns.toString());
		incidentAccidentPage.addVitals(testdata.get("Position"), testdata.get("Temperature"), testdata.get("PulseType"), testdata.get("Pulse"), testdata.get("RespiratoryValue"), testdata.get("OxygenType"), testdata.get("OxygenValue"), testdata.get("BloodPressureType"), testdata1.get("BloodPressurePosition"), testdata1.get("Systolic"), testdata1.get("Diastolic"));
		incidentAccidentPage.verifyVitals(testdata.get("Position"), testdata.get("Temperature"), testdata.get("PulseType"), testdata.get("Pulse"), testdata.get("RespiratoryValue"), testdata.get("OxygenType"), testdata.get("OxygenValue"), testdata.get("BloodPressureType"), testdata1.get("BloodPressurePosition"), testdata1.get("Systolic"), testdata1.get("Diastolic"));
	}

   //@Test()
    public void QA46_verifyIncident_UserUnabletoEditVitalSigns(ITestContext testContext) throws URISyntaxException, InterruptedException
    {
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA45";
		final String testCase1 = "QA45_1";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		HashMap<String ,String> testdata1 = xlsReader.GetValue(SheetName,testCase1);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.VitalSigns.toString());
		incidentAccidentPage.addVitals(testdata.get("Position"), testdata.get("Temperature"), testdata.get("PulseType"), testdata.get("Pulse"), testdata.get("RespiratoryValue"), testdata.get("OxygenType"), testdata.get("OxygenValue"), testdata.get("BloodPressureType"), testdata1.get("BloodPressurePosition"), testdata1.get("Systolic"), testdata1.get("Diastolic"));
		incidentAccidentPage.editVitals(testdata1.get("EditTemperature"), testdata1.get("EditPulse"), testdata1.get("EditRespiratoryValue"), testdata1.get("EditOxygenValue"), testdata1.get("EditSystolic"), testdata1.get("EditDiastolic"));
		incidentAccidentPage.verifyVitals(testdata.get("Position"), testdata1.get("EditTemperature"), testdata.get("PulseType"), testdata1.get("EditPulse"), testdata1.get("EditRespiratoryValue"), testdata.get("OxygenType"), testdata1.get("EditOxygenValue"), testdata.get("BloodPressureType"), testdata1.get("BloodPressurePosition"), testdata1.get("EditSystolic"), testdata1.get("EditDiastolic"));
	}

   //@Test()
    public void QA47_verifyIncident_AddVitalSigns_SaveIncident(ITestContext testContext) throws URISyntaxException, InterruptedException
    {
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA45";
		final String testCase1 = "QA45_1";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		HashMap<String ,String> testdata1 = xlsReader.GetValue(SheetName,testCase1);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.VitalSigns.toString());
		incidentAccidentPage.addVitals(testdata.get("Position"), testdata.get("Temperature"), testdata.get("PulseType"), testdata.get("Pulse"), testdata.get("RespiratoryValue"), testdata.get("OxygenType"), testdata.get("OxygenValue"), testdata.get("BloodPressureType"), testdata1.get("BloodPressurePosition"), testdata1.get("Systolic"), testdata1.get("Diastolic"));
		incidentAccidentPage.verifyVitals(testdata.get("Position"), testdata.get("Temperature"), testdata.get("PulseType"), testdata.get("Pulse"), testdata.get("RespiratoryValue"), testdata.get("OxygenType"), testdata.get("OxygenValue"), testdata.get("BloodPressureType"), testdata1.get("BloodPressurePosition"), testdata1.get("Systolic"), testdata1.get("Diastolic"));
		incidentAccidentPage.saveIncident();
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.VitalSigns.toString()); 
		incidentAccidentPage.verifyVitals(testdata.get("Position"), testdata.get("Temperature"), testdata.get("PulseType"), testdata.get("Pulse"), testdata.get("RespiratoryValue"), testdata.get("OxygenType"), testdata.get("OxygenValue"), testdata.get("BloodPressureType"), testdata1.get("BloodPressurePosition"), testdata1.get("Systolic"), testdata1.get("Diastolic"));
    }
    
   //@Test()
    public void QA48_verifyIncident_AddSignature(ITestContext testContext) throws URISyntaxException, InterruptedException
    {
	    IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA48";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.Signatures.toString());
		incidentAccidentPage.addSignature(userName, password);
		incidentAccidentPage.verifySignature(userName);
	}

   //@Test()
    public void QA49_verifyIncident_RemoveSignature(ITestContext testContext) throws URISyntaxException, InterruptedException
    {
		IncidentAccidentPage incidentAccidentPage=new IncidentAccidentPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA49";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToIncidentsAccidents();
		incidentAccidentPage.clickAddIncident();
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		incidentAccidentPage.clickIncidentItems(IncidentItem.Incident.toString());
		incidentAccidentPage.addIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.verifyIncidentDetails(testdata.get("IncidentType"), testdata.get("PrincipalParty"), testdata.get("Description"), testdata.get("Location"), testdata.get("SafetyDevices"),testdata.get("AssistiveDevices") ,testdata.get("Interventions" ), testdata.get("RootCause"));
		incidentAccidentPage.clickIncidentItems(IncidentItem.Signatures.toString());
		incidentAccidentPage.addSignature(userName, password);
		incidentAccidentPage.verifySignature(userName);
		incidentAccidentPage.removeSignature();
	}

}
