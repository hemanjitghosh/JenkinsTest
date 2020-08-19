package bluestrata.pages.Clinical;

import java.util.List;

import org.apache.xerces.impl.xs.models.CMBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.enums.IncidentItem;
import com.testreport.IReporter;

import dweb.aut.pages.templates.PageTemplate;
import dweb.test.templates.TestTemplate;

import org.testng.Assert;

public class IncidentAccidentPage extends PageTemplate {

	public IncidentAccidentPage(WebDriver webDriver, IReporter testReport) {
		super(webDriver, testReport);
	}

	// This area consists of Page Objects
	protected By btnHeaderMonitoring = By.xpath("//button[text()='Monitoring']");
	protected By lblIncidentAccident = By.xpath("//h4[text()='IA']");
	protected By btnAddIncident = By.xpath("//button[contains(string(),'Add Incident')]");
	protected By lnkNotifications = By.xpath("//a[contains(text(),'Notifications')]");
	protected By lnkIncidents = By.xpath("//a[contains(text(),'Incident')]");
	protected By lnkWitnesses = By.xpath("//a[contains(text(),'Witnesses')]");
	protected By lnkInjuries = By.xpath("//a[contains(text(),'Injuries')]");
	protected By lnkVitalSigns = By.xpath("//a[contains(text(),'Vital Signs')]");
	protected By lnkCarePlans = By.xpath("//a[contains(text(),'Care Plans')]");
	protected By lnkMeal = By.xpath("//a[contains(text(),'Meals')]");
	protected By lnkBowelBladder = By.xpath("//a[contains(text(),'Bowel/Bladder')]");
	protected By lnkPhysicianOrders = By.xpath("//a[contains(text(),'Physician Orders')]");
	protected By lnkMedications = By.xpath("//a[contains(text(),'Medication')]");
	protected By lnkFallHistory = By.xpath("//a[contains(text(),'Fall')]");
	protected By lnkSignatures = By.xpath("//a[contains(text(),'Signatures')]");
	protected By cmbIncidentType = By.xpath("//select[@formcontrolname='incidentAccidentType']");
	protected By cmbPrinicipalParty = By.xpath("//select[@formcontrolname='principalParty']");
	protected By txtIncidentDesc = By.xpath("//textarea[@formcontrolname='description']");
	protected By chkLinkIncident = By.xpath("//input[@formcontrolname='saveAsProgressNote']");
	protected By cmbLocation = By.xpath("//select[@formcontrolname='location']");
	protected By cmbSafetyDevice = By.xpath("//select[@formcontrolname='safetyDevicesInUse']");
	protected By cmbAssisitiveDevice = By.xpath("//select[@formcontrolname='assistiveDevicesInUse']");
	protected By txtInterventions = By.xpath("//textarea[@formcontrolname='immediateInterventions']");
	protected By txtRootCause = By.xpath("//textarea[@formcontrolname='investigation']");
	protected By btnSave = By.xpath("//button[text()='Save']");
	protected By btnSelect=By.xpath("//button[text()='Select']");
	protected By cmbPrimaryCareGiver=By.xpath("//select[@formcontrolname='primaryCaregiverId']");
	protected By cmbAssignedNurse=By.xpath("//select[@formcontrolname='assignedNurseUserId']");
	protected By cmbPrimaryPhysician=By.xpath("//select[@formcontrolname='primaryPhysicianId']");
	protected By cmbLeftHandMotion=By.xpath("//select[@formcontrolname='rangeOfMotionLeftHand']");
	protected By cmbLeftArmMotion=By.xpath("//select[@formcontrolname='rangeOfMotionLeftArm']");
	protected By cmbLeftFootMotion=By.xpath("//select[@formcontrolname='rangeOfMotionLeftFoot']");
	protected By cmbLeftLegMotion=By.xpath("//select[@formcontrolname='rangeOfMotionLeftLeg']");
	protected By cmbRightHandMotion=By.xpath("//select[@formcontrolname='rangeOfMotionRightHand']");
	protected By cmbRightArmMotion=By.xpath("//select[@formcontrolname='rangeOfMotionRightArm']");
	protected By cmbRightFootMotion=By.xpath("//select[@formcontrolname='rangeOfMotionRightFoot']");
	protected By cmbRightLegMotion=By.xpath("//select[@formcontrolname='rangeOfMotionRightLeg']");
	protected By cmbEyeResponse=By.xpath("//select[@formcontrolname='eyeResponse']");
	protected By txtLeftPupil=By.xpath("//input[@formcontrolname='leftPupilSize']");
	protected By txtRightPupil=By.xpath("//input[@formcontrolname='rightPupilSize']");
	protected By chkSeenByPhysician=By.xpath("//input[@formcontrolname='seenByPhysician']");
	protected By chkTakenToEmergencyRoom=By.xpath("//input[@formcontrolname='takenToEmergencyRoom']");
	protected By chkFirstAid=By.xpath("//input[@formcontrolname='firstAidAdministered']");
	protected By chkHitHead=By.xpath("//input[@formcontrolname='didPartyHitTheirHead']");
	protected By chkResidentPain=By.xpath("//input[@formcontrolname='isInPain']");
	protected By chkHotChart=By.xpath("//input[@formcontrolname='sendToHotChart']");
	protected By chkFollowup=By.xpath("//input[@formcontrolname='followUpRequired']");
	protected By cmbTypeOfContact=By.xpath("//select[@formcontrolname='notificationType']");
	protected By txtNameOfContact=By.xpath("//input[@formcontrolname='name']");
	protected By txtContactNotes=By.xpath("//input[@formcontrolname='notes']");
	protected By btnAddNotification=By.xpath("//button[contains(text(),'Notification')]");
	//protected By btnApplyNotification=By.xpath("//button[text()='Apply Notification']");
	protected By btnApplyNotification=By.xpath("//button[contains(text(),'Apply')]");

	protected By btnCancelNotification=By.id("notifications_cancelNotificationButton");
	
	protected By btnEditNotification=By.xpath("//button[text()='Edit']");
	protected By txtTimeNotification=By.xpath("//input[@placeholder='mm/dd/yyyy']");
	protected By btnRemoveNotification=By.xpath("//button[text()='Remove']");
	protected By popRemove=By.xpath("//button[text()='Ok']");
	protected By lblNoData=By.xpath("//div[contains(text(),'No data to display')]");
	protected By btnAddWitness=By.xpath("//button[contains(text(),'Witness')]");
	protected By cmbWitnessType=By.xpath("//select[@formcontrolname='type']");
	protected By txtWitnessName=By.xpath("//input[@formcontrolname='name']");
	//protected By txtPhoneNumber=By.xpath("//input[@placeholder='(555) 555-5555']");
	//protected By txtPhoneNumber=By.xpath("//input[@placeholder='(ddd) ddd-dddd']");
	protected By txtPhoneNumber=By.xpath("//app-phone-input[@id='witnesses_phoneInput']");
	protected By txtWitnessStatement=By.xpath("//textarea[@formcontrolname='statement']");
	//protected By btnApplyWitness=By.xpath("//button[text()='Apply Witness']");
	//protected By btnApplyWitness=By.xpath("//div[@id='witnesses-panel']//button[contains(text(),'Apply')]");
	protected By btnApplyWitness=By.id("witnesses_applyWitnessButton");
	//protected By btnCancelWitness=By.xpath("//button[text()='Cancel Witness']");
	//protected By btnCancelWitness=By.xpath("//div[@id='witnesses-panel']//button[contains(text(),'Cancel')]");
	protected By btnCancelWitness=By.id("witnesses_cancelWitnessButton");
	protected By btnViewStatement=By.xpath("//button[text()='View']");
	protected By btnEditWitness=By.xpath("//button[text()='Edit']");
	protected By btnRemoveWitness=By.xpath("//button[text()='Remove']");
	protected By btnNoWitness=By.xpath("//button[contains(text(),'No Witnesses')]");
	protected By btnAddInjury=By.xpath("//button[contains(text(),'Add Injury')]");
	protected By btnNoInjury=By.xpath("//button[contains(text(),'No Injuries')]");
	protected By cmbTypeOfInjury=By.xpath("//select[@formcontrolname='typeOfInjury']");
	protected By cmbInjurySeverity=By.xpath("//select[@formcontrolname='severity']");
	protected By txtLocationOfInjury=By.xpath("//input[@formcontrolname='locationOfInjury']");
	protected By chkInjuryWitnessed=By.xpath("//input[@formcontrolname='wasInjuryObserved']");
	protected By chkFirstAidAdministered=By.xpath("//label[contains(text(),'First Aid Administered')]/..//input[@formcontrolname='firstAidAdministered']");
	protected By txtFirstAidAdministeredBy=By.xpath("//input[@formcontrolname='firstAidAdministeredBy']");
	protected By chkTakenToEr=By.xpath("//input[@formcontrolname='isTakenToER']");
	protected By chkTriggerAssesement=By.xpath("//input[@formcontrolname='triggerSkinIntegrityAssessment']");
	//protected By btnApplyInjury=By.xpath("//button[contains(text(),'Apply Injury')]");
	protected By btnApplyInjury=By.xpath("//div[@id='injuries-panel']//button[contains(text(),'Apply Injury')]");
	
	protected By btnCancelInjury=By.id("injuries_cancelInjuryButon");
	//protected By btnCancelInjury=By.xpath("//div[@id='injuries-panel']//button[contains(text(),'Cancel')]");
	protected By chkSeenByPhyisian=By.xpath("//label[contains(text(),'Seen by physician')]/..//input[@formcontrolname='seenByPhysician']");
	protected By btnEditInjury=By.xpath("//button[text()='Edit']");
	protected By btnRemove=By.xpath("//button[text()='Remove']");
	
	//Add meal
	protected By btnAddMeal=By.id("meals_addMealButton");
	protected By cmbMealType=By.xpath("//select[@formcontrolname='mealSnackId']");
	protected By cmbMealLocation=By.xpath("//app-add-meal-form//select[@formcontrolname='location']");
	protected By txtPercentConsumed=By.xpath("//input[@formcontrolname='percentConsumed']");
	protected By btnSaveMeal=By.xpath("//app-add-meal-form//button[text()='Save']");
	protected By btnEdit=By.xpath("//button[text()='Edit']");
	protected By btnEditMeal=By.xpath("//div[@id='meals-panel']//button[text()='Edit']");
	protected By btnMealCancel=By.xpath("//app-add-meal-form//button[text()='Cancel']");
	protected By btnMealRemove=By.xpath("//button[@message='Are you sure you want to remove this meal?']");
	protected By btnSaveIncident=By.xpath("//app-incident-accident//button[text()='Save']");
	protected By lblNotificationVal=By.xpath("//div[contains(string(),\"Please select contact type and/or provide contact's name\")]");
	protected By lblInjuryVal=By.xpath("//simple-notifications//div[contains(string(),\"Please select type, severity, and location of injury in the injuries tab.\")]");
	
	protected By btnAddBowel=By.xpath("//button[text()='Add Bowel']");
	protected By lblAddBowelMovement=By.xpath("//h4[text()='Add Bowel Movement']");
	protected By chkHasMovement=By.xpath("//input[@formcontrolname='hasMovement']");
	protected By cmbForm=By.xpath("//select[@formcontrolname='form']");
	protected By cmbSize=By.xpath("//select[@formcontrolname='size']");
	protected By txtBowelNotes=By.xpath("//textarea[@formcontrolname='notes']");
	protected By btnBowelSave=By.xpath("//div[@class='modal-footer']/button[text()='Save']");
	protected By btnBowelCancel=By.xpath("//div[@class='modal-footer']/button[text()='Cancel']");
	protected By btnEditBowel=By.xpath("//div[@class='datatable-body-cell-label']//button[text()='Edit' ]");
	
	protected By btnAddBladder=By.xpath("//button[text()='Add Bladder']");
	protected By lblAddBladder=By.xpath("//h4[text()='Add Bladder']");
	protected By txtAmount=By.xpath("//input[@formcontrolname='amount']");
	protected By txtBladderNotes=By.xpath("//textarea[@formcontrolname='notes']");
	protected By btnBladderSave=By.xpath("//div[@class='modal-footer']/button[text()='Save']");
	protected By btnBladderCancel=By.xpath("//div[@class='modal-footer']/button[text()='Cancel']");
	protected By btnEditBladder=By.xpath("//button[text()='Edit']");
	
	protected By cmbPosition=By.xpath("//label[text()='Position']/following::select[1]");
	protected By txtTemprature=By.xpath("//label[text()='Temperature']/following::input[1]");
	protected By cmbPulseType=By.xpath("//label[text()='Type']/following::select[1]");
	protected By txtPulse=By.xpath("//label[text()='Pulse']/following::input[1]");
	protected By txtRespiratoryValue=By.xpath("//label[text()='Value']/following::input[1]");
	protected By cmbOxygenType=By.xpath("//label[text()='Type']/following::select[2]");
	protected By txtOxygenValue=By.xpath("//label[text()='Value']/following::input[2]");
	protected By cmbBloodPressureType=By.xpath("//label[text()='Type']/following::select[3]");
	protected By cmbBloodPressurePosition=By.xpath("//label[text()='Position']/following::select[@formcontrolname='position']");
	protected By txtSystolicPressure=By.xpath("//input[@formcontrolname='systolic']");
	protected By txtDiastolicPressure=By.xpath("//input[@formcontrolname='diastolic']");
	
	protected By btnSign=By.xpath("//app-verify-form//button");
	protected By txtUserName=By.xpath("//input[@placeholder='Username']");
	protected By txtPassword=By.xpath("//input[@placeholder='Password']");
	protected By btnVerify=By.xpath("//form/button[text()='Verify']");
	protected By txtprincipalParty=By.xpath("//input[@formcontrolname='principalPartyName']");
	
	
	
	
	
	
	
	// This area consists of functions
	
	/**
	 * This method is used to click on AddIncident
	 * 
	 */
	public void clickAddIncident() {
		this.waitUntilElementIsVisible(lblIncidentAccident);
		this.click(btnAddIncident, "Add Incident button");

	}

	/**
	 * This method is used to click on list of Incident items
	 * @param item
	 */
	public void clickIncidentItems(String item) {
		if (IncidentItem.Incident.toString().equalsIgnoreCase(item)) {
			this.VerifyWebElementPresent(lnkIncidents, "Incidents Link");
			this.click(lnkIncidents, "Incidents Link");
		}
		if (IncidentItem.Notification.toString().equalsIgnoreCase(item)) {
			this.VerifyWebElementPresent(lnkNotifications, "Notifications link");
			this.click(lnkNotifications, "Notifications link");
		}
		if (IncidentItem.Witnesses.toString().equalsIgnoreCase(item)) {
			this.VerifyWebElementPresent(lnkWitnesses, "Witnesses link");
			this.click(lnkWitnesses, "Witnesses link");
		}
		if (IncidentItem.Injuries.toString().equalsIgnoreCase(item)) {
			this.VerifyWebElementPresent(lnkInjuries, "Injuries link");
			this.click(lnkInjuries, "Injuries link");
		}
		if (IncidentItem.VitalSigns.toString().equalsIgnoreCase(item)) {
			this.VerifyWebElementPresent(lnkVitalSigns, "VitalSigns link");
			this.click(lnkVitalSigns, "VitalSigns link");
		}
		if (IncidentItem.CarePlans.toString().equalsIgnoreCase(item)) {
			this.VerifyWebElementPresent(lnkCarePlans, "CarePlans link");
			this.click(lnkCarePlans, "CarePlans link");
		}
		if (IncidentItem.Meals.toString().equalsIgnoreCase(item)) {
			this.VerifyWebElementPresent(lnkMeal, "Meals link");
			this.click(lnkMeal, "Meals link");
		}
		if (IncidentItem.BowelBladder.toString().equalsIgnoreCase(item)) {
			this.VerifyWebElementPresent(lnkBowelBladder, "BowelBladder link");
			this.click(lnkBowelBladder, "BowelBladder link");
		}
		if (IncidentItem.PhysicianOrders.toString().equalsIgnoreCase(item)) {
			this.VerifyWebElementPresent(lnkPhysicianOrders, "PhysicianOrders link");
			this.click(lnkPhysicianOrders, "PhysicianOrders link");
		}
		if (IncidentItem.MedicationAdministrations.toString().equalsIgnoreCase(item)) {
			this.VerifyWebElementPresent(lnkMedications, "MedicationAdministrations link");
			this.click(lnkMedications, "MedicationAdministrations link");
		}
		if (IncidentItem.FallAssessmentHistory.toString().equalsIgnoreCase(item)) {
			this.VerifyWebElementPresent(lnkFallHistory, "FallAssessmentHistory link");
			this.click(lnkFallHistory, "FallAssessmentHistory link");
		}
		if (IncidentItem.Signatures.toString().equalsIgnoreCase(item)) {
			this.VerifyWebElementPresent(lnkSignatures, "Signatures link");
			this.click(lnkSignatures, "Signatures link");
		}

	}

	/**
	 * This method is used to Add Incident details
	 * @param incidentType
	 * @param principalParty
	 * @param description
	 * @param location
	 * @param safetyDevice
	 * @param assistiveDevice
	 * @param interventions
	 * @param rootCause
	 */
	public void addIncidentDetails(String incidentType, String principalParty, String description, String location,
			String safetyDevice, String assistiveDevice, String interventions, String rootCause) {
		this.sendKeys(cmbIncidentType, incidentType);
		this.waitInSecs(3);
		this.SelectDropDownByText(cmbPrinicipalParty, principalParty);
		//this.sendKeys(cmbPrinicipalParty, principalParty);
		this.sendKeys(txtIncidentDesc, description);
		this.sendKeys(cmbLocation, location);
		this.sendKeys(cmbSafetyDevice, safetyDevice);
		this.SelectDropDownByText(cmbAssisitiveDevice, assistiveDevice);
		this.sendKeys(txtInterventions, interventions);
		this.sendKeys(txtRootCause, rootCause);
		this.click(btnSave, "Save Incident Button");
		this.waitUntilElementIsVisible(By.xpath("//div[text()='Save Complete']"));
		long starttime = System.currentTimeMillis();
		long endtime = 3 * 60000 + starttime;
		while (this.isElementPresent(By.xpath("//div[text()='Save Complete']")) && starttime < endtime) {

			this.waitInSecs(1);

		}
	}

	/**
	 * This method is used to verify Incident details
	 * @param incidentType
	 * @param principalParty
	 * @param description
	 * @param location
	 * @param safetyDevice
	 * @param assistiveDevice
	 * @param interventions
	 * @param rootCause
	 */
	public void verifyIncidentDetails(String incidentType, String principalParty, String description, String location,
			String safetyDevice, String assistiveDevice, String interventions, String rootCause) {
	
		this.click(By.xpath("//button[@title='refresh']"), "Incident refresh records button");
		//this.waitInSecs(8);
		this.WaitForElementPresent(btnSelect, 20, "Select incident");
		this.click(btnSelect, "Select incident");
		this.assertText(incidentType,
				new Select(wd.findElement(cmbIncidentType)).getFirstSelectedOption().getText());
		//this.assertText(principalParty,
				//new Select(wd.findElement(cmbPrinicipalParty)).getFirstSelectedOption().getText());
		//input[@formcontrolname='principalPartyName']
		//this.assertText(principalParty, wd.findElement(txtprincipalParty).getAttribute("value"));
		this.assertText(description, wd.findElement(txtIncidentDesc).getAttribute("value"));
		this.assertText(location, new Select(wd.findElement(cmbLocation)).getFirstSelectedOption().getText());
		this.assertText(safetyDevice,
				new Select(wd.findElement(cmbSafetyDevice)).getFirstSelectedOption().getText());
		this.assertText(assistiveDevice,
				new Select(wd.findElement(cmbAssisitiveDevice)).getFirstSelectedOption().getText());
		this.assertText(interventions, wd.findElement(txtInterventions).getAttribute("value"));
		this.assertText(rootCause, wd.findElement(txtRootCause).getAttribute("value"));
	}

	/**
	 * This method is used to verify incident dropdown items
	 * @param incidentType
	 */
	public void verifyIncidentTypeDropdown(String incidentType) {
		Select select = new Select(wd.findElement(cmbIncidentType));
		List<WebElement> allOptions = select.getOptions();

		for (int i = 1; i < allOptions.size(); i++) {
			if (incidentType.equalsIgnoreCase(allOptions.get(i).getText().toString())) {
				break;
			}
		}
	}

	/**
	 * This method is used to verify Incident page
	 * 
	 */
	public void verifyIncidentPage() {
		this.VerifyWebElementPresent(cmbIncidentType, "Incident Type dropdown");
		this.VerifyWebElementPresent(cmbPrinicipalParty, "Principal party dropdown");
		this.VerifyWebElementPresent(txtIncidentDesc, "Incident description text");
		this.VerifyWebElementPresent(chkLinkIncident, "Progress note and link to incident checkbox");
		this.VerifyWebElementPresent(cmbPrimaryCareGiver, "Primary care giver dropdown");
		this.VerifyWebElementPresent(cmbAssignedNurse, "Addigned nurse dropdown");
		this.VerifyWebElementPresent(cmbPrimaryPhysician, "Primary physician dropdown");
		// this.WaitForElementPresent(cmbLocation, 5, "Location dropdown");
		// this.VerifyWebElementNotPresent(cmbLocation, "Location dropdown");
		this.VerifyWebElementPresent(cmbSafetyDevice, "Safety devices dropdown");
		this.VerifyWebElementPresent(cmbAssisitiveDevice, "Assisitive devices dropdown");
		this.VerifyWebElementPresent(txtInterventions, "Interventions textbox");
		this.VerifyWebElementPresent(txtRootCause, "RootCause textbox");
		this.VerifyWebElementPresent(cmbLeftArmMotion, "Left arm dropdown");
		this.VerifyWebElementPresent(cmbLeftHandMotion, "left hand dropdown");
		this.VerifyWebElementPresent(cmbLeftLegMotion, "Left leg dropdown");
		this.VerifyWebElementPresent(cmbLeftFootMotion, "Left foot dropdown");
		this.VerifyWebElementPresent(cmbRightArmMotion, "Right arm dropdown");
		this.VerifyWebElementPresent(cmbRightHandMotion, "Right hand dropdown");
		this.VerifyWebElementPresent(cmbRightLegMotion, "Right leg dropdown");
		this.VerifyWebElementPresent(cmbRightFootMotion, "Right foot dropdown");
		this.VerifyWebElementPresent(cmbEyeResponse, "Eye Response dropdown");
		this.VerifyWebElementPresent(txtLeftPupil, "Left pupil textbox");
		this.VerifyWebElementPresent(txtRightPupil, "Right pupil textbox");
		this.VerifyWebElementPresent(chkSeenByPhysician, "Resident seen by Physician checkbox");
		this.VerifyWebElementPresent(chkTakenToEmergencyRoom, "Taken to emergency room checkbox");
		this.VerifyWebElementPresent(chkFirstAid, "Resident administered firstaid checkbox");
		this.VerifyWebElementPresent(chkHitHead, "Resident hit head checkbox");
		this.VerifyWebElementPresent(chkResidentPain, "Resident pain checkbox");
		this.VerifyWebElementPresent(chkHotChart, "Send incident to hot chart textbox");
		this.VerifyWebElementPresent(chkFollowup, "Follow up checkbox");

	}

	/**
	 * This method is used to add notification items on page
	 * @param typeOfContact
	 * @param nameOfContact
	 * @param contactNotes
	 */
	public void addNotification(String typeOfContact, String nameOfContact, String contactNotes) {
		this.click(btnAddNotification, "Notification Add button");
		this.sendKeys(cmbTypeOfContact, typeOfContact);
		this.sendKeys(txtNameOfContact, nameOfContact);
		this.sendKeys(txtContactNotes, contactNotes);
		this.click(btnApplyNotification, "Apply notification button");

	}
	
	
	/**
	 * This method is used to add notification and cancel
	 * @param typeOfContact
	 * @param nameOfContact
	 * @param contactNotes
	 */
	public void addNotificationAndCancel(String typeOfContact, String nameOfContact, String contactNotes) {
		this.click(btnAddNotification, "Notification Add button");
		this.sendKeys(cmbTypeOfContact, typeOfContact);
		this.sendKeys(txtNameOfContact, nameOfContact);
		this.sendKeys(txtContactNotes, contactNotes);
		this.click(btnCancelNotification, "Cancel notification button");

	}
	/**
	 * This method is used to add notification with mandatory fields
	 * @param typeOfContact
	 * @param nameOfContact
	 */
	public void addNotificationWithMandatoryFields(String typeOfContact, String nameOfContact) {
		this.click(btnAddNotification, "Notification Add button");
		this.sendKeys(cmbTypeOfContact, typeOfContact);
		this.sendKeys(txtNameOfContact, nameOfContact);
		this.click(btnApplyNotification, "Apply notification button");

	}
	
	
	/**
	 * This method is used to add notification with mandatory fields
	 * @param contactNotes
	 */
	public void addNotificationWithoutMandatoryFields(String contactNotes) {
		this.click(btnAddNotification, "Notification Add button");
		this.sendKeys(txtContactNotes, contactNotes);
		this.click(btnApplyNotification, "Apply notification button");
		this.VerifyWebElementPresent(lblNotificationVal, "Validation for Notification");
		if(this.isElementPresent(btnApplyNotification)==true)
		{
			this.testReport.logSuccess("Apply notification button present", String.format("<mark>True<mark/>", btnApplyNotification) );
		}
		else 
		{
			testReport.logFailure("Apply notification button not present", String.format("Element not present - <mark>%s</mark>", btnApplyNotification));
		}

	}
	
	
	/**
	 * This method id used to verify Notification with mandatory fields
	 * @param typeOfContact
	 * @param nameOfContact
	 */
	public void verifyNotificationWithMandatoryFields(String typeOfContact, String nameOfContact) {
		this.VerifyWebElementPresent(
				By.xpath("//div[@class='datatable-body-cell-label' and contains(string(),'" + typeOfContact + "')]"),
				"Type of contact label");
		this.VerifyWebElementPresent(
				By.xpath("//div[@class='datatable-body-cell-label' and contains(string(),'" + nameOfContact + "')]"),
				"Name of contact label");
		
	}

	/**
	 * This method is used to add Notification 
	 */
	public void addNotification() {
		this.click(btnAddNotification, "Notification Add button");
	}

	public void verifyNotification(String typeOfContact, String nameOfContact, String contactNotes) {
		this.VerifyWebElementPresent(
				By.xpath("//div[@class='datatable-body-cell-label' and contains(string(),'" + typeOfContact + "')]"),
				"Type of contact label");
		this.VerifyWebElementPresent(
				By.xpath("//div[@class='datatable-body-cell-label' and contains(string(),'" + nameOfContact + "')]"),
				"Name of contact label");
		this.VerifyWebElementPresent(
				By.xpath("//div[@class='datatable-body-cell-label' and contains(string(),'" + contactNotes + "')]"),
				"Contact Notes label");
	}
	

	/**
	 * This method is used to Edit Notification
	 * 
	 * @param typeOfContact
	 * @param nameOfContact
	 * @param contactNotes
	 */
	public void editNotification(String typeOfContact, String nameOfContact, String contactNotes) {
		this.click(btnEditNotification, "Edit Notification Button");
		this.sendKeys(cmbTypeOfContact, typeOfContact);
		this.SendKeysToElementClearFirst(txtNameOfContact, nameOfContact);
		this.SendKeysToElementClearFirst(txtContactNotes, contactNotes);
		this.click(btnApplyNotification, "Apply notification button");
	}
	
	/**
	 * This method is used to edit notification and cancel
	 * @param typeOfContact
	 * @param nameOfContact
	 * @param contactNotes
	 */
	public void editNotificationAndCancel(String typeOfContact, String nameOfContact, String contactNotes) {
		this.click(btnEditNotification, "Edit Notification Button");
		this.sendKeys(cmbTypeOfContact, typeOfContact);
		this.SendKeysToElementClearFirst(txtNameOfContact, nameOfContact);
		this.SendKeysToElementClearFirst(txtContactNotes, contactNotes);
		this.click(btnApplyNotification, "Apply notification button");
	}
	
	
	/**
	 * this method is used to edit notification with Mandatory fields
	 * @param typeOfContact
	 * @param nameOfContact
	 */
	public void editNotificationWithMandatoryFields(String typeOfContact, String nameOfContact) {
		this.click(btnEditNotification, "Edit Notification Button");
		this.sendKeys(cmbTypeOfContact, typeOfContact);
		this.SendKeysToElementClearFirst(txtNameOfContact, nameOfContact);
		this.click(btnApplyNotification, "Apply notification button");
	}

	/**
	 * This method is used to verify Notification items
	 * 
	 */
	public void verifyNotificationItems() {
		this.VerifyWebElementPresent(txtTimeNotification, "Time notification textbox");
		this.VerifyWebElementPresent(cmbTypeOfContact, "Type of Contact Dropdown");
		this.VerifyWebElementPresent(txtNameOfContact, "Name of Contact textbox");
		this.VerifyWebElementPresent(txtContactNotes, "Contact notes textbox");
		this.VerifyWebElementPresent(btnApplyNotification, "Apply notification button");
		this.VerifyWebElementPresent(btnCancelNotification, "Cancel notification button");
	}

	/**
	 * This method is used to delete notification
	 */
	public void deleteNotification() {
		this.click(btnRemoveNotification, "Remove Notification Button");
		this.WaitForElementPresent(popRemove, 2, "Ok button popup for remove notification");
		this.click(popRemove, "Ok button popup for remove notification");
		this.VerifyWebElementPresent(lblNoData, "No Data to display");
	}

	/**
	 * This method is used to add witness
	 * @param type
	 * @param name
	 * @param number
	 * @param statement
	 */
	public void addWitness(String type, String name, String number, String statement) {
		this.click(btnAddWitness, "Add Witness button");
		this.sendKeys(cmbWitnessType, type);
		this.sendKeys(txtWitnessName, name);
		//this.click(txtPhoneNumber, number);
		//this.sendKeys(txtPhoneNumber, number);
		this.sendKeys(txtWitnessStatement, statement);
		this.click(btnApplyWitness, "Apply Witness button");
	}

	/**
	 * This method is used to verify witnesss
	 * @param type
	 * @param name
	 * @param number
	 * @param statement
	 */
	public void verifyWitness(String type, String name, String number, String statement) {
		this.click(btnEditWitness, "Edit Witness button");
		this.assertText(type, new Select(wd.findElement(cmbWitnessType)).getFirstSelectedOption().getText());
		this.assertText(name, wd.findElement(txtWitnessName).getAttribute("value"));
		/*this.assertText(number,
				(wd.findElement(txtPhoneNumber).getAttribute("value")).replaceAll("[^A-Za-z0-9]", ""));*/
		this.assertText(statement, wd.findElement(txtWitnessStatement).getAttribute("value"));
		this.click(btnCancelWitness, "Cancel witness button");

	}

	/**
	 * This method is used to Edit Witness
	 * @param type
	 * @param name
	 * @param number
	 * @param statement
	 */
	public void EditWitness(String type, String name, String number, String statement) {
		this.click(btnEditWitness, "Edit Witness button");
		this.SendKeysToElementClearFirst(txtWitnessName, name);
		//this.SendKeysToElementClearFirst(txtPhoneNumber, number);
		this.SendKeysToElementClearFirst(txtWitnessStatement, statement);
		this.click(btnApplyWitness, "Apply Witness button");
	}

	/**
	 * This method is used to delete Witness
	 */
	public void deleteWitness() {
		this.click(btnRemoveWitness, "Remove Witness button");
		this.WaitForElementPresent(popRemove, 2, "Ok button popup for remove notification");
		this.click(popRemove, "Ok button popup for remove notification");
		this.VerifyWebElementPresent(lblNoData, "No Data to display");
	}

	/**
	 * This method is used to verify Witness items
	 */
	public void verifyWitnessItems() {
		this.VerifyWebElementPresent(btnNoWitness, "No Witness button");
		this.click(btnAddWitness, "Add Witness button");
		this.VerifyWebElementPresent(cmbWitnessType, "WitnessType Combo box");
		this.VerifyWebElementPresent(txtWitnessName, "Witness name textbox");
		this.VerifyWebElementPresent(txtPhoneNumber, "Witness phone number");
		this.VerifyWebElementPresent(txtWitnessStatement, "Witness statement text");
		this.VerifyWebElementPresent(btnApplyWitness, "Apply witness button");
		this.VerifyWebElementPresent(btnCancelWitness, "Cancel witness button");
	}

	/**
	 * This method is used to Add Injury
	 * @param type
	 * @param severity
	 * @param location
	 * @param firstAidAdministeredBy`
	 */
	public void AddInjury(String type, String severity, String location, String firstAidAdministeredBy) {
		this.click(btnAddInjury, "Add Injury Button");
		this.WaitForElementPresent(cmbTypeOfInjury, 5, "Type of Injury dropdown");
		this.sendKeys(cmbTypeOfInjury, type);
		this.sendKeys(cmbInjurySeverity, severity);
		this.sendKeys(txtLocationOfInjury, location);
		this.click(chkInjuryWitnessed, "");
		this.click(chkSeenByPhyisian, "");
		this.click(chkFirstAidAdministered, "");
		this.sendKeys(txtFirstAidAdministeredBy, firstAidAdministeredBy);
		this.click(chkTakenToEr, "");
		this.click(btnApplyInjury, "Apply Injury Button");
	}
	

	/**
	 * This method is used to Add Injury with mandatory fields
	 * @param type
	 * @param severity
	 * @param location
	 */
	public void AddInjuryWithMandatoryFields(String type, String severity, String location) {
		this.click(btnAddInjury, "Add Injury Button");
		this.WaitForElementPresent(cmbTypeOfInjury, 5, "Type of Injury dropdown");
		this.sendKeys(cmbTypeOfInjury, type);
		this.sendKeys(cmbInjurySeverity, severity);
		this.sendKeys(txtLocationOfInjury, location);
		this.click(btnApplyInjury, "Apply Injury Button");
	}

	/**
	 * This method is used to verify Injury items
	 * @param type
	 * @param severity
	 * @param location
	 * @param firstAidAdministeredBy
	 */
	public void verifyInjury(String type, String severity, String location, String firstAidAdministeredBy) {
		this.click(btnEditInjury, "Edit Injury button");
		this.assertText(type, new Select(wd.findElement(cmbTypeOfInjury)).getFirstSelectedOption().getText());
		this.assertText(severity, new Select(wd.findElement(cmbInjurySeverity)).getFirstSelectedOption().getText());
		this.assertText(location, wd.findElement(txtLocationOfInjury).getAttribute("value"));
		this.assertText(true, wd.findElement(chkInjuryWitnessed).isSelected());
		this.assertText(true, wd.findElement(chkSeenByPhyisian).isSelected());
		this.assertText(true, wd.findElement(chkFirstAidAdministered).isSelected());
		this.assertText(firstAidAdministeredBy, wd.findElement(txtFirstAidAdministeredBy).getAttribute("value"));
		this.assertText(true, wd.findElement(chkTakenToEr).isSelected());
		this.click(btnCancelInjury, "Cancel injury button");
	}
	
	/**
	 * This method is used to verify Injury with mandatory fields
	 * @param type
	 * @param severity
	 * @param location
	 */
	public void verifyInjuryWithMandatoryFields(String type, String severity, String location) {
		this.click(btnEditInjury, "Edit Injury button");
		this.assertText(type, new Select(wd.findElement(cmbTypeOfInjury)).getFirstSelectedOption().getText());
		this.assertText(severity, new Select(wd.findElement(cmbInjurySeverity)).getFirstSelectedOption().getText());
		this.assertText(location, wd.findElement(txtLocationOfInjury).getAttribute("value"));
		this.click(btnCancelInjury, "Cancel injury button");
	}

	/**
	 * This method is used to Edit injury items
	 * @param type
	 * @param severity
	 * @param location
	 * @param firstAidAdministeredBy
	 */
	public void editInjury(String type, String severity, String location, String firstAidAdministeredBy) {
		this.click(btnEditInjury, "Edit Injury button");
		this.sendKeys(cmbTypeOfInjury, type);
		this.sendKeys(cmbInjurySeverity, severity);
		this.SendKeysToElementClearFirst(txtLocationOfInjury, location);
		this.SendKeysToElementClearFirst(txtFirstAidAdministeredBy, firstAidAdministeredBy);
		this.click(btnApplyInjury, "Apply injury button");

	}
	
	/**
	 * This method is used to Edit Injury with mandatory fields
	 * @param type
	 * @param severity
	 * @param location
	 */
	public void editInjuryWithMandatoryFields(String type, String severity, String location) {
		this.click(btnEditInjury, "Edit Injury button");
		this.sendKeys(cmbTypeOfInjury, type);
		this.sendKeys(cmbInjurySeverity, severity);
		this.SendKeysToElementClearFirst(txtLocationOfInjury, location);
		this.click(btnApplyInjury, "Apply injury button");

	}

	/**
	 * This method is used to remove Injury
	 */
	public void removeInjury() {
		if(this.isElementPresent(btnRemove))
		{
		this.click(btnRemove, "Remove button");
		this.WaitForElementPresent(popRemove, 2, "Ok button popup for remove");
		this.click(popRemove, "Ok button popup for remove");
		this.VerifyWebElementPresent(lblNoData, "No Data to display");
		}
		
	}

	/**
	 * This method is used to verifyInjuryItems
	 */
	public void verifyInjuryItems() {
		this.click(btnAddInjury, "Add Injury button");
		this.VerifyWebElementPresent(cmbTypeOfInjury, "Type of Injury dropdown");
		this.VerifyWebElementPresent(cmbInjurySeverity, "Injury severity dropdown");
		this.VerifyWebElementPresent(txtLocationOfInjury, "Location");
		this.VerifyWebElementPresent(chkInjuryWitnessed, "Injury Witnessed");
		this.VerifyWebElementPresent(chkSeenByPhyisian, "Seen by physician");
		this.VerifyWebElementPresent(chkFirstAidAdministered, "Checkbox First aid administered");
		this.VerifyWebElementPresent(txtFirstAidAdministeredBy, "Textbox First aid administered by");
		this.VerifyWebElementPresent(chkTakenToEr, "Taken to ER");
		this.VerifyWebElementPresent(btnApplyInjury, "Apply injury");
		this.VerifyWebElementPresent(btnCancelInjury, "Cancel Injury");
	}
	
	/**
	 * This method is used to add meal
	 * @param type
	 * @param location
	 * @param percentConsumed
	 */
	public void addMeal(String type,String location,String percentConsumed) 
	{
		
		this.click(btnAddMeal, "Add Meal button");
		this.waitUntilElementIsClickable(cmbMealType);
		this.SelectDropDownByText(cmbMealType, type);
		this.waitUntilElementIsClickable(cmbMealLocation);
		this.SelectDropDownByText(cmbMealLocation, location);
		this.SendKeysToElementClearFirst(txtPercentConsumed, percentConsumed);
		this.click(btnSaveMeal, "Save meal button");
		//this.waitInSecs(2);
		
	}
	
	
	/**This method is used to add meal
	 * @param type
	 * @param location
	 */
	public void addMeal(String type,String location) 
	{
		this.click(btnAddMeal, "Add Meal button");
		this.waitUntilElementIsClickable(cmbMealType);
		this.SelectDropDownByText(cmbMealType, type);
		this.waitUntilElementIsClickable(cmbMealLocation);
		this.SelectDropDownByText(cmbMealLocation, location);
		//this.sendKeys(cmbMealLocation, location);
		this.click(btnSaveMeal, "Save meal button");
		
	}
	
	/**
	 * This method is used to verify meal
	 * @param type
	 * @param location
	 * @param percentConsumed
	 */
	public void verifyMeal(String type,String location,String percentConsumed) 
	{
		this.click(btnEditMeal, "Edit MEal button");
		this.WaitForElementPresent(cmbMealType, 5, "Meal type dropdown");
		this.VerifyWebElementPresent(cmbMealType, "meal type dropdowm");
		this.assertText(type, new Select(wd.findElement(cmbMealType)).getFirstSelectedOption().getText());
		this.assertText(location, new Select(wd.findElement(cmbMealLocation)).getFirstSelectedOption().getText());
		this.assertText(percentConsumed, wd.findElement(txtPercentConsumed).getAttribute("value"));
		this.click(btnMealCancel, "Cancel meal button");
		this.waitInSecs(5);
		
		
	}
	


	/**
	 * This method is used to verify meal
	 * @param type
	 * @param location
	 */
	public void verifyMeal(String type,String location) 
	{
		
		this.click(btnEditMeal, "Edit MEal button");
		this.WaitForElementPresent(cmbMealType, 5, "Meal type dropdown");
		this.VerifyWebElementPresent(cmbMealType, "meal type dropdowm");
		this.assertText(type, new Select(wd.findElement(cmbMealType)).getFirstSelectedOption().getText());
		this.assertText(location, new Select(wd.findElement(cmbMealLocation)).getFirstSelectedOption().getText());
		this.click(btnMealCancel, "Cancel meal button");
		
	}
	
	/**
	 * This method is used to edit meal
	 * @param type
	 * @param location
	 * @param percentConsumed
	 */
	public void editMeal(String type,String location,String percentConsumed) 
	{
		this.click(btnEditMeal, "Edit MEal button");
	
		this.WaitForElementPresent(cmbMealType, 5, "Meal type dropdown");
		if(retryingFindClick(cmbMealType)==true)
		{
		this.SelectDropDownByText(cmbMealType, type);
		}
		this.waitUntilElementIsClickable(cmbMealLocation);
		this.SelectDropDownByText(cmbMealLocation, location);
		this.SendKeysToElementClearFirst(txtPercentConsumed, percentConsumed);
		this.click(btnSaveMeal, "Save meal button");
		
	}
	
	
	/**
	 * This method is used to remove meal
	 * 
	 */
	public void removeMeal()
	{
		if(this.isElementPresent(btnMealRemove))
		{
		this.click(btnMealRemove, "Remove Meal button");
		this.WaitForElementPresent(popRemove, 2, "Ok button popup for remove");
		this.click(popRemove, "Ok button popup for remove");
		this.waitInSecs(3);
		this.VerifyWebElementPresent(lblNoData, "No Data to display");
		}
		
	}
	
	
	/**
	 * This method is used to Edit meal
	 * @param type
	 * @param location
	 */
	public void editMeal(String type,String location) 
	{
		this.click(btnEditMeal, "Edit MEal button");
		this.waitInSecs(5);
		this.WaitForElementPresent(cmbMealType, 5, "Meal type dropdown");
		this.SelectDropDownByText(cmbMealType, type);
		this.SelectDropDownByText(cmbMealLocation, location);
		this.click(btnSaveMeal, "Save meal button");
		
	}
	
	
	/**
	 * This method is used to cancel meal
	 */
	public void cancelMeal()
	{
		this.VerifyWebElementPresent(btnMealCancel, "Meal Cancel button");
		this.click(btnMealCancel, "Meal Cancel button");
	}
	
	
	/**
	 * This method is used to Add meal and cancel
	 * @param type
	 * @param location
	 */
	public void addMealandCancel(String type,String location) 
	{
		this.click(btnAddMeal, "Add Meal button");
		this.waitUntilElementIsClickable(cmbMealType);
		this.SelectDropDownByText(cmbMealType, type);
		this.waitUntilElementIsClickable(cmbMealLocation);
		this.SelectDropDownByText(cmbMealLocation, location);
		//this.sendKeys(cmbMealLocation, location);
		this.click(btnSaveMeal, "Save meal button");
		
	}
	
	
	/**
	 * This method is used to Edi meal and cancel
	 * @param type
	 * @param location
	 */
	public void editMealandCancel(String type,String location) 
	{
		this.click(btnEditMeal, "Edit MEal button");
		this.click(btnSaveMeal, "Save meal button");
		
	}
	
	/**
	 * This method is used to Add meal without mandatory fields
	 * @param percentConsumed
	 */
	public void addMealWithoutMandatoryFields(String percentConsumed)
	{
		
		this.click(btnAddMeal, "Add Meal button");
		this.WaitForElementPresent(cmbMealType, 5, "Meal type dropdown");
		this.SendKeysToElementClearFirst(txtPercentConsumed, percentConsumed);
		this.click(btnSaveMeal, "Save meal button");
		this.waitInSecs(2);
		
		if(this.isElementPresent(btnSaveMeal)==true)
		{
			this.testReport.logSuccess("Save meal button present", String.format("<mark>True<mark/>", btnSaveMeal) );
		}
		else 
		{
			testReport.logFailure("Element Not Present", String.format("Element not present - <mark>%s</mark>", btnSaveMeal));
		}
		
	}
	
	/**
	 * This method is used to save Incident
	 * 
	 */
	public void saveIncident() 
	{
		this.VerifyWebElementPresent(btnSaveIncident, "Save Incident button");
		this.click(btnSaveIncident, "Save Incident button");
		this.waitUntilElementIsVisible(By.xpath("//div[text()='Save Complete']"));
		long starttime = System.currentTimeMillis();
		long endtime = 3 * 60000 + starttime;
		while (this.isElementPresent(By.xpath("//div[text()='Save Complete']")) && starttime < endtime) {

			this.waitInSecs(1);

		}
	}
	
	/**
	 * This method is used to Add ?Injury with cancel
	 * @param type
	 * @param severity
	 * @param location
	 * @param firstAidAdministeredBy
	 */
	public void addInjuryWithCancel(String type, String severity, String location, String firstAidAdministeredBy) {
		this.click(btnAddInjury, "Add Injury Button");
		this.WaitForElementPresent(cmbTypeOfInjury, 5, "Type of Injury dropdown");
		this.sendKeys(cmbTypeOfInjury, type);
		this.sendKeys(cmbInjurySeverity, severity);
		this.sendKeys(txtLocationOfInjury, location);
		this.click(chkInjuryWitnessed, "");
		this.click(chkSeenByPhyisian, "");
		this.click(chkFirstAidAdministered, "");
		this.sendKeys(txtFirstAidAdministeredBy, firstAidAdministeredBy);
		this.click(chkTakenToEr, "");
		
	}
	
	/**
	 *This method is used to Cancel Injury 
	 */
	public void cancelInjury()
	{
		this.click(btnCancelInjury, "Cancel Injury button");
	}
	
	/**
	 * This method is used to Edit Injury with Cancel
	 */
	public void editInjuryWithCancel() {
		this.click(btnEditInjury, "Edit Injury button");
		this.click(btnCancelInjury, "Cancel Injury button");
	}
	
	
	/**
	 * This method is used to Add Injury without Mandatory fields
	 * @param firstAidAdministeredBy
	 */
	public void AddInjuryWithoutMandatoryFields(String firstAidAdministeredBy) {
		this.click(btnAddInjury, "Add Injury Button");
		this.WaitForElementPresent(cmbTypeOfInjury, 5, "Type of Injury dropdown");
		this.click(chkInjuryWitnessed, "");
		this.click(chkSeenByPhyisian, "");
		this.click(chkFirstAidAdministered, "");
		this.sendKeys(txtFirstAidAdministeredBy, firstAidAdministeredBy);
		this.click(chkTakenToEr, "");
		this.click(btnApplyInjury, "Apply Injury Button");
	}
	
	/**
	 * This method is used to verify Injury without mandatory fields
	 */
	public void verifyInjuryWithoutMandatory()
	{
		this.VerifyWebElementPresent(lblInjuryVal, "Injury Validation label");
		this.VerifyWebElementPresent(btnApplyInjury, "Apply Injury");
	}
	
	/**
	 * This method is used to add witness
	 * @param type
	 * @param name
	 */
	public void addWitness(String type, String name) {
		this.click(btnAddWitness, "Add Witness button");
		this.sendKeys(cmbWitnessType, type);
		this.sendKeys(txtWitnessName, name);
		this.click(btnApplyWitness, "Apply Witness button");
	}
	
	/**
	 * This method is used to verify witness
	 * @param type
	 * @param name
	 */
	public void verifyWitness(String type, String name) {
		this.click(btnEditWitness, "Edit Witness button");
		this.assertText(type, new Select(wd.findElement(cmbWitnessType)).getFirstSelectedOption().getText());
		this.assertText(name, wd.findElement(txtWitnessName).getAttribute("value"));
		this.click(btnCancelWitness, "Cancel witness button");

	}
	
	/**
	 * This method is used to Edit Witness
	 * @param type
	 * @param name
	 */
	public void EditWitness(String type, String name) {
		this.click(btnEditWitness, "Edit Witness button");
		this.SendKeysToElementClearFirst(txtWitnessName, name);
		this.click(btnApplyWitness, "Apply Witness button");
	}
	
	/**
	 * This method is used to Add witness with cancel button check
	 * @param type
	 * @param name
	 */
	public void addWitnessWithCancel(String type, String name) {
		this.click(btnAddWitness, "Add Witness button");
		this.sendKeys(cmbWitnessType, type);
		this.sendKeys(txtWitnessName, name);
		this.click(btnCancelWitness, "Cancel Witness button");
		
	}
	
	
	/**
	 * This method is used to Edit witness with cancel button check
	 * @param type
	 * @param name
	 */
	public void EditWitnessWithCancel(String type, String name) {
		this.click(btnEditWitness, "Edit Witness button");
		this.SendKeysToElementClearFirst(txtWitnessName, name);
		this.click(btnCancelWitness, "Cancel Witness button");
	}
	
	/**
	 * This method is used to add Witness 
	 * @param number
	 * @param statement
	 */
	public void addWitnessWithoutMandatoryFields(String number, String statement) {
		this.click(btnAddWitness, "Add Witness button");
		this.sendKeys(txtPhoneNumber, number);
		this.sendKeys(txtWitnessStatement, statement);
		this.click(btnApplyWitness, "Apply Witness button");
		this.VerifyWebElementPresent(btnApplyWitness, "Apply Witness Button");
	}
	
	public void addBowelDetails(String form,String size,String notes)
	{
		this.click(btnAddBowel, "Add Bowel Button");
		this.VerifyWebElementPresent(lblAddBowelMovement, "Add bowel movement label");
		this.click(chkHasMovement, "Has movement checkbox");
		this.VerifyWebElementPresent(cmbForm, "Form dropdown");
		this.SelectDropDownByText(cmbForm, form);
		this.VerifyWebElementPresent(cmbSize, "Size dropdown");
		this.SelectDropDownByText(cmbSize, size);
		this.sendKeys(txtBowelNotes, notes);
		this.click(btnBowelSave, "Save Bowel button");
	}
	
	public void verifyBowelDetails(String form,String size,String notes)
	{
		this.waitInSecs(2);
		this.waitUntilElementIsClickable(btnEditBowel);
		this.click(btnEditBowel, "Edit button");
		this.VerifyWebElementPresent(lblAddBowelMovement, "label add bowel ");
		this.assertText(form, new Select(wd.findElement(cmbForm)).getFirstSelectedOption().getText());
		this.assertText(size, new Select(wd.findElement(cmbSize)).getFirstSelectedOption().getText());
		this.assertText(notes, wd.findElement(txtBowelNotes).getAttribute("value"));
		this.click(btnBowelCancel, "bowel cancel button");
	}
	
	public void removeBowel() {
		
		while(this.isElementPresent(btnRemove))
		{
		this.click(btnRemove, "Remove button");
		this.waitUntilElementIsClickable(popRemove);
		this.click(popRemove, "Ok button popup for remove");
		this.VerifyWebElementPresent(lblNoData, "No Data to display");
		}
	}
	
	public void editBowelDetails(String form,String size,String notes)
	{
		this.waitInSecs(2);
		this.VerifyWebElementPresent(btnEditBowel, "Edit button");
		this.click(btnEditBowel, "Edit button");
		this.VerifyWebElementPresent(lblAddBowelMovement, "label add bowel ");
		this.SelectDropDownByText(cmbForm, form);
		this.SelectDropDownByText(cmbSize, size);
		this.SendKeysToElementClearFirst(txtBowelNotes, notes);
		this.click(btnBowelSave, "Save Bowel button");
	}
	public void cancelBowelDetails(String form,String size,String notes)
	{
		this.click(btnAddBowel, "Add Bowel Button");
		this.VerifyWebElementPresent(lblAddBowelMovement, "Add bowel movement label");
		this.click(chkHasMovement, "Has movement checkbox");
		this.VerifyWebElementPresent(cmbForm, "Form dropdown");
		this.SelectDropDownByText(cmbForm, form);
		this.VerifyWebElementPresent(cmbSize, "Size dropdown");
		this.SelectDropDownByText(cmbSize, size);
		this.sendKeys(txtBowelNotes, notes);
		this.VerifyWebElementPresent(btnBowelCancel, "Cancel Bowel button");
		this.click(btnBowelCancel, "Cancel Bowel button");
	}
	public void editBowelCancelCheck()
	{
		this.waitInSecs(2);
		this.VerifyWebElementPresent(btnEditBowel, "Edit button");
		this.click(btnEditBowel, "Edit button");
		this.VerifyWebElementPresent(lblAddBowelMovement, "label add bowel ");
		this.click(btnBowelCancel,"Cancel Bowel button");
	}
	
	public void addBladderDetails(String amount,String notes)
	{
		this.click(btnAddBladder, "Add Bladder Button");
		this.VerifyWebElementPresent(lblAddBladder, "Add bladder movement label");
		this.SendKeysToElementClearFirst(txtAmount, amount);
		this.sendKeys(txtBladderNotes, notes);
		this.click(btnBladderSave, "Save Bladder button");
	}
	
	public void verifyBladderDetails(String amount,String notes)
	{
		this.waitInSecs(2);
		this.waitUntilElementIsClickable(btnEditBladder);
		this.click(btnEditBladder, "Edit button");
		this.VerifyWebElementPresent(lblAddBladder, "label add bladder ");
		this.assertText(amount, wd.findElement(txtAmount).getAttribute("value"));
		this.assertText(notes, wd.findElement(txtBladderNotes).getAttribute("value"));
		this.click(btnBowelCancel, "bowel cancel button");
	}
	
	public void removeBladder() {
		this.click(btnRemove, "Remove button");
		this.waitUntilElementIsClickable(popRemove);
		this.click(popRemove, "Ok button popup for remove");
		this.VerifyWebElementPresent(lblNoData, "No Data to display");
	}
	
	public void editBladderDetails(String amount,String notes)
	{
		this.waitInSecs(2);
		this.VerifyWebElementPresent(btnEditBladder, "Edit button");
		this.waitUntilElementIsClickable(btnEditBladder);
		this.click(btnEditBladder, "Edit button");
		this.VerifyWebElementPresent(lblAddBladder, "label add bladder ");
		this.SendKeysToElementClearFirst(txtAmount, amount);
		this.SendKeysToElementClearFirst(txtBladderNotes, notes);
		this.click(btnBladderSave, "Save Bladder button");
	}
	
	public void addBladderDetailsCancelCheck(String amount,String notes)
	{
		this.click(btnAddBladder, "Add Bladder Button");
		this.VerifyWebElementPresent(lblAddBladder, "Add bladder movement label");
		this.SendKeysToElementClearFirst(txtAmount, amount);
		this.sendKeys(txtBladderNotes, notes);
		this.click(btnBladderCancel, "Cancel Bladder button");
	}
	
	public void editBladderDetailsCancelCheck()
	{
		this.waitInSecs(2);
		this.VerifyWebElementPresent(btnEditBladder, "Edit button");
		this.click(btnEditBladder, "Edit button");
		this.click(btnBladderCancel, "Cancel Bladder button");
	}
	
	public void addVitals(String position,String temperature,String pulseType,String pulse,String respiratoryValue,String oxygenType,String oxygenValue,String bloodPressureType,String bloodPressurePosition,String systolic,String diastolic)
	{
		this.SelectDropDownByText(cmbPosition, position);
		this.sendKeys(txtTemprature, temperature);
		this.SelectDropDownByText(cmbPulseType, pulseType);
		this.sendKeys(txtPulse, pulse);
		this.sendKeys(txtRespiratoryValue, respiratoryValue);
		this.SelectDropDownByText(cmbOxygenType, oxygenType);
		this.sendKeys(txtOxygenValue, oxygenValue);
		this.SelectDropDownByText(cmbBloodPressureType, bloodPressureType);
		this.WaitForElementPresent(cmbBloodPressurePosition, 3, "bloodPressurePosition");
		this.SelectDropDownByText(cmbBloodPressurePosition, bloodPressurePosition);
		this.WaitForElementPresent(txtSystolicPressure, 3, "systolic");
		this.sendKeys(txtSystolicPressure, systolic);
		this.sendKeys(txtDiastolicPressure, diastolic);
		
	}
	
	public void verifyVitals(String position,String temperature,String pulseType,String pulse,String respiratoryValue,String oxygenType,String oxygenValue,String bloodPressureType,String bloodPressurePosition,String systolic,String diastolic)
	{
	
		this.assertText(position, new Select(wd.findElement(cmbPosition)).getFirstSelectedOption().getText());
		this.assertText(temperature,  wd.findElement(txtTemprature).getAttribute("value"));
		this.assertText(pulseType, new Select(wd.findElement(cmbPulseType)).getFirstSelectedOption().getText());
		this.assertText(pulse,  wd.findElement(txtPulse).getAttribute("value"));
		this.assertText(respiratoryValue,  wd.findElement(txtRespiratoryValue).getAttribute("value"));
		this.assertText(oxygenType, new Select(wd.findElement(cmbOxygenType)).getFirstSelectedOption().getText());
		this.assertText(oxygenValue,  wd.findElement(txtOxygenValue).getAttribute("value"));
		this.assertText(bloodPressureType, new Select(wd.findElement(cmbBloodPressureType)).getFirstSelectedOption().getText());
		this.assertText(bloodPressurePosition, new Select(wd.findElement(cmbBloodPressurePosition)).getFirstSelectedOption().getText());
		this.assertText(systolic,  wd.findElement(txtSystolicPressure).getAttribute("value"));
		this.assertText(diastolic,  wd.findElement(txtDiastolicPressure).getAttribute("value"));
		
	}
	
	public void editVitals(String temperature,String pulse,String respiratoryValue,String oxygenValue,String systolic,String diastolic)
	{
		this.SendKeysToElementClearFirst(txtTemprature, temperature);
		this.SendKeysToElementClearFirst(txtPulse, pulse);
		this.SendKeysToElementClearFirst(txtRespiratoryValue, respiratoryValue);
		this.SendKeysToElementClearFirst(txtOxygenValue, oxygenValue);
		this.SendKeysToElementClearFirst(txtSystolicPressure, systolic);
		this.SendKeysToElementClearFirst(txtDiastolicPressure, diastolic);
	}
	
	public void addSignature(String username,String password)
	{
		this.click(btnSign, "Sign Button");
		this.sendKeys(txtUserName, username);
		this.sendKeys(txtPassword, password);
		this.click(btnVerify, "Verify");
	}
	
	public void verifySignature(String username)
	{
		this.VerifyWebElementPresent(By.xpath("//span[contains(text(),"+username+")]"), "User name label");
	}
	
	public void removeSignature()
	{
		this.click(btnRemove, "Remove button");
		this.WaitForElementPresent(popRemove, 2, "Ok button popup for remove");
		this.click(popRemove, "Ok button popup for remove");
		this.VerifyWebElementPresent(lblNoData, "No Data to display");
		
	}
	
	
	/**
	 * This method is used to check for failure of Stale Elements on page
	 * 
	 */
	public boolean retryingFindClick(By by) {
	    boolean result = false;
	    int attempts = 0;
	    WebDriver driver=this.wd;
	    while(attempts < 2) {
	        try {
	        	if(driver.findElement(by).isEnabled())
	        	{
	            result = true;
	        	}
	            break;
	        } catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    return result;
	}

}
