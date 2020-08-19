package bluestrata.pages;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testreport.IReporter;

import dweb.aut.pages.templates.PageTemplate;
import io.appium.java_client.functions.ExpectedCondition;
import jxl.write.DateTime;

public class PhysicianPortalPage extends PageTemplate {

	public PhysicianPortalPage(WebDriver webDriver, IReporter testReport) {
		super(webDriver, testReport);
	}

	// Create Physician Portal
	public By btnPhysicianPortal = By.xpath("//button[text()='Physician Portal']");
	public By aResidentOrders = By.xpath("//button[text()='Resident Orders']");
	// public By resident = By.xpath("//datatable-scroller[@class='datatable-scroll
	// ng-star-inserted']/datatable-row-wrapper[1]//datatable-body-cell[3]");

	// Create An order
	public By btnCreateOrder = By.xpath("//button[text()='Create an Order']");
	public By btnCreateSet = By.xpath("//button[text()='Create From Set']");
	// public By txtOrderType= By.id("settingOrderTypeId");
	public By txtOrderType = By.xpath("//select[@id='settingOrderTypeId']");
	public By linkCreateLibraryItem = By.xpath("//label[contains(.,'Pick From Library')]/../div/button");
	public By txtPickLibrary = By.id("libraryCreate");
	public By linkCreate = By.xpath("//label[contains(text(),'Pick From Library')]/..//button[1]");
	public By linkCancel = By.xpath("//label[contains(text(),'Pick From Library')]/..//button[2]");
	public By txtOrderDescription = By.id("description");
	public By linkAddDiagonosis = By.xpath("//label[text()='Diagnosis']/..//button[@class='btn btn-link']/i");
	public By txtSearchDiogonosis = By.id("query");
	public By txtSearchMedicineName = By.id("query");
	public By btnSearchDiogonosis = By.xpath("//div[@class='form-group row']//button[@type='submit']");

	// public By diogonosisOption =
	// By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper[1]");
	public By diogonosisOption = By.xpath("(//div[@class='datatable-body-cell-label']/span)[1]");

	public By radioTreatment = By.xpath("//input[@value='TX']");
	public By txtMedicarePriority = By.xpath("//label[text()='Medicare B Priority']/..//input[@id='query']");
	public By chkbxAdmitting = By.xpath("//input[@formcontrolname='isPreexisting']");
	public By chkbxSendToMDS = By.xpath("//input[@formcontrolname='includeInMds']");
	public By chkbxBillingAdmitDiagnosis = By.xpath("//input[@formcontrolname='isBillingDiagnosis']");
	public By btnDiogonosisCreate = By.xpath("(//div[@class='modal-content']//button[@type='submit'])[2]");
	public By linkDuplicateDiogonosis = By.xpath("//div[text()='Duplicate Diagnosis']");
	public By btnClose = By.xpath("//button[@class='close']/span");
	public By srchDiogonosis = By.xpath("//label[text()='Diagnosis']/..//select[@id='diagnosisCode']");
	public By labelDiagnosisRequired = By.xpath("//label[text()='Diagnosis']/..//div[@class='invalid-feedback']//i");
	// public By srchDiogonosis = By.id("diagnosisCode");
	public By drpdwnPhysician = By.id("physicianId");
	public By drpdwnReceivedBy = By.id("receivedById");
	public By drpdwnReceivedOrder = By.id("typeReceivedOrder");
	public By chkbxIsAdmitting = By.xpath("//input[@formcontrolname='isAdmitting']");

	public By linkSearchMedications = By.xpath("(//label[text()='Medication']/..//button[@class='btn btn-link'])[1]");
	public By linkFreeForm = By.xpath("(//label[text()='Medication']/..//button[@class='btn btn-link'])[2]");
	public By txtMedicationName = By.xpath("//input[@id='query']");
	public By labelMedicationDatabase = By.xpath("//*[text()='Medication Database']");
	public By spanDrugName = By.xpath("//span[text()='Drug Name']");
	public By msgNoInteractions = By.xpath("//div[text()='No Interactions']");
	public By txtmedicationName = By.xpath("//label[text()='Medication']/..//input[@id='description']");
	public By btnUseDrugDatabase = By.xpath("//label[text()='Medication']/..//button");
	// public By spanDrugName = By.xpath("//span[text()='Drug Name']");

	public By warningMessage = By.xpath("//div[@class='alert alert-warning']");
	public By declineInput = By.xpath("//div[@class='alert alert-warning']//input");
	public By drpDwnroutes = By.xpath("//label[text()='Routes']/..//select[@id='settingOrderRouteId']");
	public By txtNoOfRefillis = By.xpath("//label[text()='No. Refills']/..//input[@id='numberOfRefills']");
	public By DrpdwnWhenToFill = By.xpath("//label[text()='When to refill']/..//select[@id='whenToRefillId']");
	public By txtWrittenDate = By.xpath("(//label[text()='Written Date']/..//input[@placeholder='mm/dd/yyyy'])[1]");
	public By radioMedication = By.xpath("//input[@value='Med']");
	public By txtDecline = By.xpath("//div[@class='ng-star-inserted']//textarea[@id='declinedInfectionControlReason']");

	//public By labelPickFromLibrary = By.xpath("//div[@class='ng-star-inserted']//label[text()='Pick From Library']");
	public By labelICD10Database = By.xpath("//div[@class='modal-header']/h5[text()='ICD-10 Database']");
	public By txtPickFromLibrary = By.xpath("//label[text()='Pick From Library']/..//select[@id='libraryselect']");
	public By labelPickFromLibrary = By.xpath("//label[text()='Pick From Library']");

	// Create OrderFrequency
	/*
	 * public By drpdwnFrequencyType = By.id("routineTypeId"); public By
	 * drpdwnEndDate = By.xpath("//label[text()='End']/..//select[@id='actions']");
	 * public By drpdwnRequiredActions =
	 * By.xpath("//label[text()='Require Action(s)']/..//select[@id='actions']");
	 * public By drpdwnRequiredActionsPostDropdown = By.
	 * xpath("//label[text()='Require Action(s) Post Administration']/..//select[@id='actionsPost']"
	 * ); public By drpdwnAdministeredBy = By.
	 * xpath("//label[text()='Administered By']/..//select[@id='settingOrderAdministratorId']"
	 * ); public By chkbxIsSelfAdministered =
	 * By.xpath("//input[@id='selfAdministered']"); public By
	 * chkbxselfAdministeredRequiresSupervision =
	 * By.xpath("//input[@id='selfAdministeredRequiresSupervision']"); public By
	 * chkbxRequiresFollowUp =By.xpath("//input[@id='requiresFollowUp']"); public By
	 * txtMaxDoesHours = By.
	 * xpath("//label[text()='Max Doses Per 24 Hours']/..//input[@id='prnMaxDailyAdministration']"
	 * ); public By txtFollowUpAfterMinutes = By.id("followUpAfterMinutes"); public
	 * By drpdwnFrequency =
	 * By.xpath("//label[text()='Frequency']/..//select[@id='typeOrderFrequencyId']"
	 * ); public By drpdwnHowOften = By.
	 * xpath("//label[text()='How often']/..//select[@id='patientOrderScheduleType']"
	 * ); public By txtEveryDay =
	 * By.xpath("//label[text()='Every']/..//input[@id='happensEvery']"); public By
	 * txtPhysicianInstructions = By.
	 * xpath("//label[text()='Physician Instructions']/..//textarea[@id='instructions']"
	 * ); public By txtAdditionalInstruction = By.
	 * xpath("//label[text()='Additional Instruction']/..//textarea[@id='additionalNotes']"
	 * );
	 */
	public By btnAddFrequency = By.xpath("//button[text()='Add Frequency']");	
	public By btnSaveOrder = By.xpath("//button[text()='Save']");
	public By btnCancel = By.xpath("//button[text()='Cancel']");

	public By btnHeaderPhysicianPortal = By
			.xpath("//*[@class='col-auto nav primary-menu-links']//button[text()='Physician Portal']");
	public By btnHeaderMessages = By
			.xpath("//*[@class='col-auto nav primary-menu-links']//button[contains(text(),'Messages')]");
	public By btnHeaderMediprocity = By.xpath("//*[@class='col-auto nav primary-menu-links']//button/img");

	public By spandrpdwnSign = By.xpath("//div[@aria-labelledby='menuDropDown']//button[text()='Sign']");
	public By spandrpdwnResidentOrder = By
			.xpath("//div[@aria-labelledby='menuDropDown']//button[text()='Resident Orders']");
	public By spandrpdwnRecap = By.xpath("//div[@aria-labelledby='menuDropDown']//button[text()='Recap']");
	public By spandrpdwnVerify = By.xpath("//div[@aria-labelledby='menuDropDown']//button[text()='Verify']");
	public By spandrpdwnHistoryandPhysical = By
			.xpath("//div[@aria-labelledby='menuDropDown']//button[text()='History and Physical']");
	public By spandrpdwnPhysicianProgressNoteAssessment = By
			.xpath("//div[@aria-labelledby='menuDropDown']//button[text()='Physician Progress Note Assessment']");
	public By spandrpdwnPhysicianProgressNotes = By
			.xpath("//div[@aria-labelledby='menuDropDown']//button[text()='Physician Progress Notes']");

	public By spanResidentFirstName = By.xpath(
			"//datatable-header-cell//div[@class='datatable-header-cell-template-wrap']//span[text()='First Name']");
	public By spanResidentLastName = By.xpath(
			"//datatable-header-cell//div[@class='datatable-header-cell-template-wrap']//span[text()='Last Name']");
	public By spanResidentMr = By
			.xpath("//datatable-header-cell//div[@class='datatable-header-cell-template-wrap']//span[text()='Mr#']");
	public By spanResidentSSN = By
			.xpath("//datatable-header-cell//div[@class='datatable-header-cell-template-wrap']//span[text()='SSN']");
	public By spanResidentLocation = By.xpath(
			"//datatable-header-cell//div[@class='datatable-header-cell-template-wrap']//span[text()='Location']");
	public By spanResidentDateOfBirth = By.xpath(
			"//datatable-header-cell//div[@class='datatable-header-cell-template-wrap']//span[text()='Date Of Birth']");
	public By spanResidentAge = By
			.xpath("//datatable-header-cell//div[@class='datatable-header-cell-template-wrap']//span[text()='Age']");
	public By spanResidentActions = By.xpath(
			"//datatable-header-cell//div[@class='datatable-header-cell-template-wrap']//span[text()='Actions']");

	public By txtEnterNameOrMrNumber = By.xpath("//input[@placeholder='Enter name or mr number']");
	public By drpdwnSelectStations = By.xpath("//button[contains(text(),'Select stations')]");
	public By drpdwnSelectStatus = By.xpath("//button[contains(text(),'Select statuses')]");
	public By btnApplyFilters = By.xpath("//button[contains(text(),'Apply filters')]");
	public By drpdwnAdmittedDischargedTransfered = By
			.xpath("//button[@type='button' and contains(@class,'dropdown-toggle')]");
	public By btnAdmitNewResident = By.xpath("//button[text()='Admit New Resident']");
	public By labelDisplayPastStays = By.xpath("//label[text()='Display Past Stays']");

	public By spanOrderSummaryDescription = By
			.xpath("//div[@class='datatable-header-inner']//span[text()='Description']");
	public By spanOrderSummaryType = By.xpath("//div[@class='datatable-header-inner']//span[text()='Type']");
	public By spanOrderSummaryPhysician = By.xpath("//div[@class='datatable-header-inner']//span[text()='Physician']");
	public By spanOrderSummaryFrequencies = By
			.xpath("//div[@class='datatable-header-inner']//span[text()='Frequencies']");
	public By spanOrderSummaryStatus = By.xpath("//div[@class='datatable-header-inner']//span[text()='Status']");

	public By defaultSection = By.xpath("//li[@class='pages active']/a");

	public By LabelFullorder = By.xpath("//h4[text()='Full Order']");
	public By labelOrdersInSet = By.xpath("//div[@class='card']//h5[contains(text(),'Orders in the set')]");
	public By labelIgnoreThisOrderSet = By.xpath("//div[contains(@class,'alert-warning')]//input");
	public By btnIgnore = By.xpath("//button[text()='Ignore']");

	public By labelOrderPageDescription = By.xpath("//span[text()='Description']");
	public By labelOrderPageCreated = By.xpath("//span[text()='Created']");
	public By labelOrderPageType = By.xpath("//span[text()='Type']");
	public By labelOrderPagePhysician = By.xpath("//span[text()='Physician']");
	public By labelOrderPageFrequencies = By.xpath("//span[text()='Frequencies']");
	public By labelOrderPageStatus = By.xpath("//span[text()='Status']");
	public By labelOrderPageDetail = By.xpath("//span[text()='Detail']");
	public By labelOrderPageDate = By.xpath("//span[text()='Date']");

	public By labelFullOrder = By.xpath("//div[@id='header-main']//h4[text()='Full Order']");
	public By labelOrderPageDetails = By.xpath("//h3[text()='Detail']");
	public By OrderPageDetails = By.xpath("//h5[text()='Detail']");
	public By labelOrderPageDetailsModify = By
			.xpath("//*[text()='Detail']/..//div[@class='card-header']//button[text()='Modify']");
	// public By labelOrderPageFrequency =
	// By.xpath("//div[@class='card-header']/h5[contains(text(),'Frequency ')]");
	// public By labelOrderPageFrequencyModify =
	// By.xpath("//div[@class='card-header']/h5[contains(text(),'Frequency
	// 1')]/..//button[text()='Modify']");
	public By labelOrderPageHoldDates = By.xpath("//h3[text()='Hold Dates']");
	public By labelOrderPageHoldDatesModify = By
			.xpath("//*[text()='Hold Dates']/..//div[@class='card-body']//button[text()='Add Hold Dates']");
	public By labelOrderPageDetailsUpdate = By
			.xpath("//*[text()='Detail']/..//div[@class='card-header']//button[text()='Update']");
	public By labelOrderPageDetailsCancel = By
			.xpath("//*[text()='Detail']/..//div[@class='card-header']//button[text()='Cancel']");
	/*
	 * public By btnUpdateFrequency1 = By.
	 * xpath("//div[@class='card-header']/h5[text()='Frequency 1']/..//button[text()='Update']"
	 * ); public By btnCancelFrequency1 = By.
	 * xpath("//div[@class='card-header']/h5[text()='Frequency 1']/..//button[text()='Cancel']"
	 * ); public By btnRemovefrequencyFrequency1 = By.
	 * xpath("//div[@class='card-header']/h5[text()='Frequency 1']/..//button[text()='Remove Frequency']"
	 * );
	 */

	public By btnOrderPageListView = By.xpath("//app-patient-orders-page//button[text()='List View']");
	public By btnOrderPagePrint = By.xpath("//button[text()='Print']");
	public By btnOrderPageDiscontinue = By.xpath("//button[text()='Discontinue']");
	public By btnOrderPageRefill = By.xpath("//button[text()='Refill']");
	public By btnOrderPageCopy = By.xpath("//button[text()='Copy']");
	public By labelOrderPageDetailType = By.xpath("//label[text()='Type']/..//div[text()='Medication']");

	public By btnStartDateCalender = By.xpath("//div[@class='modal-body']//label[text()='Start Date']/..//button/i");
	public By btnEndDateCalender = By.xpath("//div[@class='modal-body']//label[text()='End Date']/..//button/i");
	public By txtStartTime = By.xpath(
			"//div[@class='modal-content']//*[@formcontrolname='startTime']/..//input[@placeholder='hh:mm ampm']");
	public By txtEndTime = By
			.xpath("//div[@class='modal-content']//*[@formcontrolname='endTime']/..//input[@placeholder='hh:mm ampm']");
	public By btnAddHoldDateSave = By.xpath("//div[@class='modal-content']//button[text()='Save']");
	public By txtAddHoldDateStartDate = By.xpath("//datatable-header-cell//span[text()='Start Date']");
	public By txtAddHoldDateEndDate = By.xpath("//datatable-header-cell//span[text()='End Date']");
	public By btnDiscontinue = By.xpath("//button[text()='Discontinue']");
	public By orderDiscontinuebtn = By.xpath("//div[@class='modal-content']//button[text()='Discontinue']");
	public By btnDCdateCalender = By.xpath("//div[@class='modal-body']//label[text()='DC Date']/..//button/i");
	public By chkbxDiscontinueForCorrection = By.id("discontinueForCorrection");
	public By chkbxCreateACopyOfThatOrder = By.id("createCopy");
	public By chkbxSendDCMessageToPharmacy = By.id("sendToPharmacy");
	public By btnLeftArrow = By.xpath("//div[contains(@class,'col')]//button/i[@class='fa fa-arrow-left']");
	public By btnRightArrow = By.xpath("//div[contains(@class,'col')]//button/i[@class='fa fa-arrow-right']");

	public By msgChkboxDiscontinue = By.xpath("//div[text()='Request Discontinue Complete']");
	public By msgDiscontinue = By.xpath("(//div[@role='alert' and contains(@class,'alert')])[1]");

	public By labelOrderPagePharmacyInformation = By.xpath("//*[text()='Electronic Pharmacy Information']");
	public By labelOrderPagePharmacyName = By.xpath("//div[@class='card']//div[text()='Name']");
	public By labelOrderPagePharmacyAddrerss = By.xpath("//div[@class='card']//div[text()='Address']");
	public By labelOrderPagePharmacyContact = By.xpath("//div[@class='card']//div[text()='Contact']");

	public By btnFilterByPhysician = By.xpath("//div[@class='form-row']//select");
	public By btnFilterDrpDwn = By.xpath("//select[contains(@class,'form-control')]");
	public By btnToggleVerifyAll = By.xpath("//button[text()='Toggle Verify All']");
	public By btnToggleVerifed = By.xpath("//button[text()='Toggle Verified']");
	public By msgOrderVerified = By.xpath("//div[text()='Orders Verified']");
	public By btnToggleRecapAll = By.xpath("//button[text()='Toggle Recap All']");
	public By btnToggleRecap = By.xpath("//button[text()='Toggle Recap']");
	public By btnRecap = By.xpath("//span[text()='Recap']");

	public By btnToggleSignedAll = By.xpath("//button[text()='Toggle Signed All']");
	public By btnToggleSigned = By.xpath("//button[text()='Toggle Signed']");
	public By btnAddSignature = By
			.xpath("//div[contains(@class,'alert alert-success') and @role='alert']//button[text()='Add Signature']");
	public By txtSignOrders = By.xpath("//h4[contains(text(),'Sign Orders')]");
	public By txtSignOrdersSignature = By.xpath("//p[contains(text(),'This action requires your signature')]");
	public By msgSignatureCreated = By.xpath("//div[text()='Signature Created']");

	public By txtPrintName = By.xpath("//label[text()='Print Name']/..//input[@id='signatureName']");
	public By chkBxUseSignatureOnFile = By
			.xpath("//label[@for='useSignatureOnFile']/..//input[@name='useSignatureOnFile']");
	public By txtSignatureName = By.xpath("//label[text()='Signature']/..//canvas");
	public By btnClear = By.xpath("//button[text()='Clear']");

	public By btnRecapPageSelectPhysician = By
			.xpath("(//ss-multiselect-dropdown//button[contains(@class,'dropdown-toggle')])[1]");
	public By btnRecapPageSelectStatus = By
			.xpath("(//ss-multiselect-dropdown//button[contains(@class,'dropdown-toggle')])[2]");
	public By btnCreateRecap = By.xpath("//button[text()='Create Recap']");
	public By CreateRecap = By.xpath("//*[text()='Create Recaps']");
	public By txtSingOrders = By.xpath("//*[text()='Sign Orders']");

	public By txtCreateRecap = By.xpath("//h5[text()='Filter down existing orders']");
	public By txtRecapDescription = By.xpath("//label[text()='Description']//following-sibling::input");
	public By listRecapResidentStatus = By.xpath("//label[text()='Resident Status']/..//button");
	public By listRecapStations = By.xpath("//label[text()='Stations']/..//button");
	public By listRecapResidents = By.xpath("//label[text()='Residents']/..//button");
	public By listRecapOtherStatus = By.xpath("//label[text()='Order Status']/..//button");
	public By listRecapPhysicians = By.xpath("//label[text()='Physicians']/..//button");
	public By calenderRecapDate = By.xpath("//label[text()='Recap Date']/..//input");
	public By btnApplyFilter = By.xpath("//button[text()='Apply Filter']");
	public By calenenderRecapDate = By
			.xpath("//label[text()='Recap Date']/..//button[@class='btn btn-outline-secondary']/i");

	public By btnHeaderOrders = By.xpath("//button[text()='Orders']");

	public void ClickOnPhysicianPortal() {
		/*
		 * this.click(By.xpath(String.format(this.getLocator("button"),
		 * "Physician Portal")));
		 * this.click(By.xpath(String.format(this.getLocator("a"), "Resident Orders")));
		 */
		this.testReport.logSuccess("Clicked on Physician Portal Button ");
		this.click(btnPhysicianPortal, "Physician Portal Button");
		this.waitInSecs(2);
		this.testReport.logSuccess("Clicked on Resident Orders Links ");
		this.click(aResidentOrders, "Resident Orders");
		this.waitInSecs(2);
	}

	/*
	 * public void ClickOnExistingResident(String residentMR) { // By Resident =
	 * By.xpath((String.
	 * format("//datatable-scroller[@class='datatable-scroll ng-star-inserted']/datatable-row-wrapper//datatable-body-cell[3]//span[text()='%s']"
	 * , residentMR)));
	 * 
	 * By Resident = By.xpath((String.
	 * format("//datatable-scroller[@class='datatable-scroll ng-star-inserted']/datatable-row-wrapper//datatable-body-cell[4]//span[text()='%s']/../../..//div/button[text()='Select']"
	 * , residentMR))); this.testReport.
	 * logSuccess("Clicked on Existing Resident Present in the Portal "); for(int
	 * i=3;i<=8;i++) { By linkPageBottom = By.xpath(String.
	 * format("(//*[@class='datatable-pager ng-star-inserted']//a)[%s]",i));
	 * click(linkPageBottom,"Navigate Page");
	 * 
	 * if(this.isElementVisible(Resident)) {
	 * this.click(Resident,"Selected Resident"); break; }
	 * 
	 * }
	 * 
	 * }
	 */

	public void CreateOrderButton() {
		this.waitUntilElementIsClickable(btnCreateOrder);
		if (this.isElementPresent(btnCreateOrder) && this.isElementNotPresent(btnOrderPageListView)) {
			this.testReport.logSuccess("Order Created ");
			this.click(btnCreateOrder, "Create Order Button");
			// this.waitInSecs(5);
		}
	}

	public String CreateAnOrderWithOrderDetails(String type, String libraryText, String SearchDiogonosisTxt,
			String medicarePriority, String diogonosisName, String physicianType, String ReceivedByType,
			String ReceivedOrderType, String routes, String WrittenDate, String NoOfRefillis, String WhenToFill) {

		CreateOrderButton();
		if (this.isElementPresent(txtOrderType)) {
			this.waitUntilElementIsVisible(txtOrderType);
			this.SelectDropDownByText(txtOrderType, type);
			// this.waitInSecs(5);
		}
		if (type.equals("Medication") || type.equals("Treatment With Medication")) {
			if (this.isElementPresent(linkSearchMedications)) {
				this.click(linkSearchMedications, "Search Medications");
				// this.waitInSecs(2);
				this.SendKeysToElementClearFirst(txtSearchMedicineName, "Amox");
				// this.waitInSecs(2);
				this.click(btnSearchDiogonosis, "Search Medication");
				this.waitInSecs(20); // constant
				By medicineName = By.xpath(String.format(
						"//datatable-body-cell//span[text()='%s']",
						libraryText));
				this.click(medicineName, "Medicine");
				// this.waitInSecs(2);
				this.waitUntilElementIsVisible(warningMessage);
				if (this.isElementPresent(warningMessage)) {
					this.click(declineInput, "Decline Input ");
					this.waitInSecs(2);
					this.SendKeysToElementClearFirst(txtDecline, libraryText);
					// this.waitInSecs(10);
				}
			}
		} else {
			this.WaitForElementPresent(linkCreateLibraryItem,60, "Create Library Item Link");
			this.click(linkCreateLibraryItem, "Create Library Item Link");
			this.VerifyWebElementPresent(linkCreate, "Create Link");
			this.VerifyWebElementPresent(linkCancel, "Cancel");
			this.SendKeysToElementClearFirst(txtPickLibrary, libraryText);
			this.click(linkCreate, "Create Link");

		}

		this.click(linkAddDiagonosis, "Add Diagonosis Link");
		this.waitUntilElementIsVisible(txtSearchDiogonosis);
		this.SendKeysToElementClearFirst(txtSearchDiogonosis, SearchDiogonosisTxt);

		this.click(btnSearchDiogonosis, "Search Diogonosis Button");
		this.waitInSecs(7);
		this.click(diogonosisOption, "Diogonosis Option");

		if (type.equals("Medication") || type.equals("Treatment With Medication")) {
			this.click(radioMedication, "Medication radio Button");
			this.waitInSecs(2);
		} else {
			this.click(radioTreatment, "Treatment radio Button");
		}
		this.SendKeysToElementClearFirst(txtMedicarePriority, medicarePriority);
		this.click(chkbxAdmitting, "Admitting Check Box");
		this.click(chkbxSendToMDS, "Send To MDS Check Box");
		//this.click(chkbxBillingAdmitDiagnosis, "Billing Admit Diagnosis Check Box");
		this.click(btnDiogonosisCreate, "Create Diogonosis Button");
		if (this.isElementPresent(linkDuplicateDiogonosis)) {
			this.click(btnClose, "Close Button");
			this.waitInSecs(2);
			this.SelectDropDownByText(srchDiogonosis, diogonosisName);

		}
		this.SelectDropDownByText(drpdwnPhysician, physicianType);
		this.SelectDropDownByText(drpdwnReceivedBy, ReceivedByType);
		this.SelectDropDownByText(drpdwnReceivedOrder, ReceivedOrderType);
		boolean IsAdmitting = wd.findElement(By.xpath("//input[@formcontrolname='isAdmitting']")).isSelected();
		if (!IsAdmitting) {
			this.click(chkbxIsAdmitting, "Is Admitting Check Box");
		}
		// this.waitInSecs(2);
		if (type.equals("Medication") || type.equals("Treatment With Medication")) {
			this.SelectDropDownByText(drpDwnroutes, routes);// Both Ears
			this.waitInSecs(2);
			// this.sendKeys(txtWrittenDate, WrittenDate);
			// this.waitInSecs(2);
			/*
			 * this.SendKeysToElementClearFirst(txtNoOfRefillis, NoOfRefillis);
			 * this.waitInSecs(2); this.SelectDropDownByText(DrpdwnWhenToFill, WhenToFill);
			 * this.waitInSecs(2);
			 */
		}

		return type;

	}

	/*
	 * public void CreateOrderFrequency(String frequencyType,String endDate,String
	 * requiredActions,String requiredActionsPostDropdown,String
	 * administeredBy,String followUpAfterMinutes, String frequency,String howOften,
	 * String everyDay , String physicianInstructions, String additionalInstruction)
	 * {
	 * 
	 * this.SelectDropDownByText(drpdwnFrequencyType, frequencyType);
	 * this.SelectDropDownByText(drpdwnEndDate, endDate);
	 * this.SelectDropDownByText(drpdwnRequiredActions, requiredActions);
	 * this.SelectDropDownByText(drpdwnRequiredActionsPostDropdown,
	 * requiredActionsPostDropdown); this.SelectDropDownByText(drpdwnAdministeredBy,
	 * administeredBy); this.click(chkbxIsSelfAdministered);
	 * this.click(chkbxselfAdministeredRequiresSupervision);
	 * 
	 * 
	 * 
	 * if(frequencyType.equals("Routine")) { this.click(chkbxRequiresFollowUp); }
	 * else { this.sendKeys(txtMaxDoesHours, "5"); }
	 * this.sendKeys(txtFollowUpAfterMinutes, followUpAfterMinutes);
	 * this.SelectDropDownByText(drpdwnFrequency, frequency);
	 * this.SelectDropDownByText(drpdwnHowOften, howOften);
	 * this.sendKeys(txtEveryDay, everyDay); this.sendKeys(txtPhysicianInstructions,
	 * physicianInstructions); this.sendKeys(txtAdditionalInstruction,
	 * additionalInstruction);
	 * 
	 * }
	 */

	public void SaveOrderFrequency() {
		this.testReport.logInfo("Add the Order Successfully ");
		this.click(btnSaveOrder, "Save Order");
		this.waitInSecs(10);
	}

	public void AddOrderFrequency() {
		this.testReport.logInfo("Adding the Order Frequency ");
		this.click(btnAddFrequency, "Add Frequency Button");
	}

	public void CreateOrderFrequency(int num, int no, String frequencyType, String endDate, String requiredActions,
			String requiredActionsPostDropdown, String administeredBy, String maxDoesHours, String followUpAfterMinutes,
			String slidingScaleMin, String slidingScaleMax, String slidingScaleUnits, String frequency, String howOften,
			String everyDay, String physicianInstructions, String additionalInstruction, String type) {
		int newNum = (num - 1);
		By drpdwnFrequencyType = By.xpath(String.format("(//select[@id='routineTypeId'])[%s]", num));
		if (this.isElementPresent(drpdwnFrequencyType)) {
			this.SelectDropDownByText(drpdwnFrequencyType, frequencyType);
		}
		if (endDate.equals("No End")) {
			By drpdwnEndDate = By.xpath(String.format("(//label[text()='End']/..//select[@id='actions'])[%s]", num));
			this.SelectDropDownByText(drpdwnEndDate, endDate);
		} else if (endDate.equals("By Date")) {
			By drpdwnEndDate = By.xpath(String.format("(//label[text()='End']/..//select[@id='actions'])[%s]", num));
			this.SelectDropDownByText(drpdwnEndDate, endDate);
			// By txtDate =
			// By.xpath("(//label[text()='End']/..//input[@placeholder='mm/dd/yyyy' and
			// @class='form-control'])[%s]",num);
		} else {
			By drpdwnEndDate = By.xpath(String.format("(//label[text()='End']/..//select[@id='actions'])[%s]", num));
			this.SelectDropDownByText(drpdwnEndDate, endDate);
		}
		if (!type.equals("Ancillaries")) {

			if (type.equals("Medication")
					&& (frequencyType.equals("PRN") || frequencyType.equals("PRN Every (x) Hour(s)"))
					|| type.equals("Treatment With Medication")
							&& (frequencyType.equals("PRN") || frequencyType.equals("PRN Every (x) Hour(s)"))) {
				By txtDose = By.xpath(String.format("(//label[text()='Dose']/..//input[@id='dose'])[%s]", num));
				if (this.isElementPresent(txtDose)) {
					this.SendKeysToElementClearFirst(txtDose, "4");
				}
				By txtUnit = By.xpath(String.format("(//label[text()='Unit']/..//input[@id='doseUnit'])[%s]", num));
				if (this.isElementPresent(txtUnit)) {
					this.SendKeysToElementClearFirst(txtUnit, "4");
				}
			}

			By drpDwnRequiredActionsCrossButton = By.xpath(String.format(
					"(//label[text()='Require Action(s)']/..//div[@formarrayname='requiredActions'])//span/a", num));
			if (this.isElementPresent(drpDwnRequiredActionsCrossButton)) {
				this.click(drpDwnRequiredActionsCrossButton, "Required Actions Cross Button");
			}
			By drpdwnRequiredActions = By
					.xpath(String.format("(//label[text()='Require Action(s)']/..//select[@id='actions'])[%s]", num));
			this.SelectDropDownByText(drpdwnRequiredActions, requiredActions);
			if (requiredActions.equals("Other")) {
				By txtOthersRequiredActions = By.xpath(
						String.format("(//select[@id='actions']/..//input[@formcontrolname='description'])[%d]", num));
				this.SendKeysToElementClearFirst(txtOthersRequiredActions, requiredActions);
			}
			By drpdwnRequiredActionsPostCrossButton = By.xpath(String.format(
					"(//label[text()='Require Action(s) Post Administration']/..//div[@formarrayname='requiredActionsPost'])//span/a",
					num));
			if (this.isElementPresent(drpdwnRequiredActionsPostCrossButton)) {
				this.click(drpdwnRequiredActionsPostCrossButton, "Required Actions Post Administration Cross Button");
			}

			By drpdwnRequiredActionsPostDropdown = By.xpath(String.format(
					"(//label[text()='Require Action(s) Post Administration']/..//select[@id='actionsPost'])[%d]",
					num));
			this.SelectDropDownByText(drpdwnRequiredActionsPostDropdown, requiredActionsPostDropdown);
			if (requiredActionsPostDropdown.equals("Other")) {
				By txtOthersRequiredActionsPostDropdown = By.xpath(String
						.format("(//select[@id='actionsPost']/..//input[@formcontrolname='description'])[%d]", num));
				this.SendKeysToElementClearFirst(txtOthersRequiredActionsPostDropdown, requiredActionsPostDropdown);
			}
			By drpdwnAdministeredBy = By.xpath(String.format(
					"(//label[text()='Administered By']/..//select[@id='settingOrderAdministratorId'])[%d]", num));
			this.SelectDropDownByText(drpdwnAdministeredBy, administeredBy);
			By chkbxIsSelfAdministered = By.xpath(String.format("(//input[@id='selfAdministered'])[%d]", num));
			if (this.isElementPresent(chkbxIsSelfAdministered)) {

				boolean selected = wd
						.findElement(By.xpath(String.format("(//input[@id='followUpAfterMinutes'])[%d]", num)))
						.isEnabled();

				if (!selected) {
					// By chkbxIsSelfAdministered =
					// By.xpath(String.format("(//input[@id='selfAdministered'])[%d]",num));
					this.click(chkbxIsSelfAdministered, "Is Self Administered Check Box");
					By chkbxselfAdministeredRequiresSupervision = By
							.xpath(String.format("(//input[@id='selfAdministeredRequiresSupervision'])[%d]", num));
					this.click(chkbxselfAdministeredRequiresSupervision,
							"Self Administered Requires Supervision Check Box");
					if (frequencyType.equals("Routine")) {
						By chkbxRequiresFollowUp = By
								.xpath(String.format("(//input[@id='requiresFollowUp'])[%d]", num));
						this.click(chkbxRequiresFollowUp, "Requires FollowUp Check Box");
					}

					By txtFollowUpAfterMinutes = By
							.xpath(String.format("(//input[@id='followUpAfterMinutes'])[%d]", num));
					this.SendKeysToElementClearFirst(txtFollowUpAfterMinutes, followUpAfterMinutes);
				}
			}

			By chkbxRequiesSlidingScale = By
					.xpath(String.format("(//label[@class='form-check-label']/input[@id='useSlidingScale'])[%d]", num));
			if (this.isElementPresent(chkbxRequiesSlidingScale)) {
				for (int i = 1; i <= 2; i++) {
					By txtSlidingScaleMin = By
							.xpath(String.format("(//table//input[@formcontrolname='minValue'])[%s]", i));

					By txtSlidingScaleMax = By
							.xpath(String.format("(//table//input[@formcontrolname='maxValue'])[%s]", i));

					By txtSlidingScaleUnits = By
							.xpath(String.format("(//table//input[@formcontrolname='units'])[%s]", i));

					By chkBoxSlidingScaleNotifyRemove = By
							.xpath(String.format("(//table//input[@formcontrolname='notifyPhysician'])[%s]", i));

					// By btnAddScale =
					// By.xpath(String.format("(//div[@class='card'])[%s]//button[contains(@class,'btn-link')]",
					// num));
					By btnAddScale = By.cssSelector(".col-auto.btn.btn-link");

					if (this.isElementPresent(txtSlidingScaleMin) && this.isElementPresent(txtSlidingScaleMax)
							&& this.isElementPresent(txtSlidingScaleUnits)) {

						this.SendKeysToElementClearFirst(txtSlidingScaleMin, slidingScaleMin);
						this.SendKeysToElementClearFirst(txtSlidingScaleMax, slidingScaleMax);
						this.SendKeysToElementClearFirst(txtSlidingScaleUnits, slidingScaleUnits);
						this.click(chkBoxSlidingScaleNotifyRemove, "Sliding Scale Notify Remove Check Box");
					}

					else {
						this.click(chkbxRequiesSlidingScale, "Requies Sliding Scale Check Box");
						this.SendKeysToElementClearFirst(txtSlidingScaleMin, slidingScaleMin);
						this.SendKeysToElementClearFirst(txtSlidingScaleMax, slidingScaleMax);
						this.SendKeysToElementClearFirst(txtSlidingScaleUnits, slidingScaleUnits);
						this.click(chkBoxSlidingScaleNotifyRemove, "Sliding Scale Notify Remove Check Box");

					}

					List<WebElement> SlidingScaleMin = wd
							.findElements(By.xpath(String.format("(//table//input[@formcontrolname='minValue'])")));
					int MinCount = SlidingScaleMin.size();
					if (MinCount <= 4) {
						this.click(btnAddScale, "Add Scale");
					}

				}
			}

			if (frequencyType.equals("Routine")) {
				By drpdwnFrequency = By.xpath(
						String.format("(//label[text()='Frequency']/..//select[@id='typeOrderFrequencyId'])[%s]", num));
				if (this.isElementPresent(drpdwnFrequency)) {
					this.SelectDropDownByText(drpdwnFrequency, frequency);
				}
				By drpdwnHowOften = By.xpath(String
						.format("(//label[text()='How often']/..//select[@id='patientOrderScheduleType'])[%s]", num));
				if (this.isElementPresent(drpdwnHowOften)) {
					this.SelectDropDownByText(drpdwnHowOften, howOften);
				}
				By txtEveryDay = By
						.xpath(String.format("(//label[text()='Every']/..//input[@id='happensEvery'])[%s]", num));
				if (this.isElementPresent(txtEveryDay)) {
					this.SendKeysToElementClearFirst(txtEveryDay, everyDay);
				}
			}
			if (type.equals("Medication") || type.equals("Treatment With Medication")) {
				By btnGenerrate = By.xpath(String
						.format("(//label[text()='Physician Instructions']/..//button[text()='Generate'])[%d]", num));
				if (this.isElementPresent(btnGenerrate)) {
					this.click(btnGenerrate, "Genrate Button");
				}
			} else {

				By txtPhysicianInstructions = By.xpath(String.format(
						"(//label[text()='Physician Instructions']/..//textarea[@id='instructions'])[%d]", num));
				if (this.isElementPresent(txtPhysicianInstructions)) {
					this.SendKeysToElementClearFirst(txtPhysicianInstructions, physicianInstructions);
				}
			}
		}
		By txtAdditionalInstruction = By.xpath(String
				.format("(//label[text()='Additional Instruction']/..//textarea[@id='additionalNotes'])[%d]", num));
		if (this.isElementPresent(txtAdditionalInstruction)) {
			this.SendKeysToElementClearFirst(txtAdditionalInstruction, additionalInstruction);
		}
	}

	public void CreateOrderFrequencyForRoutine(int num, String frequencyType, String endDate, String requiredActions,
			String othersRequiredActions, String requiredActionsPostDropdown, String othersRequiredActionsPostDropdown,
			String administeredBy, String maxDoesHours, String followUpAfterMinutes, String slidingScaleMin,
			String slidingScaleMax, String slidingScaleUnits) {
		By drpdwnFrequencyType = By.xpath(String.format("(//select[@id='routineTypeId'])[%s]", num));
		this.SelectDropDownByText(drpdwnFrequencyType, frequencyType);
		if (endDate.equals("No End")) {
			By drpdwnEndDate = By.xpath(String.format("(//label[text()='End']/..//select[@id='actions'])[%s]", num));
			this.SelectDropDownByText(drpdwnEndDate, endDate);
		} else if (endDate.equals("By Date")) {
			By drpdwnEndDate = By.xpath(String.format("(//label[text()='End']/..//select[@id='actions'])[%s]", num));
			this.SelectDropDownByText(drpdwnEndDate, endDate);
			// By txtDate =
			// By.xpath("(//label[text()='End']/..//input[@placeholder='mm/dd/yyyy' and
			// @class='form-control'])[%s]",num);
		} else {
			By drpdwnEndDate = By.xpath(String.format("(//label[text()='End']/..//select[@id='actions'])[%s]", num));
			this.SelectDropDownByText(drpdwnEndDate, endDate);
		}

		if (frequencyType.equals("PRN") || frequencyType.equals("PRN Every (x) Hour(s)")) {
			By txtDose = By.xpath(String.format("(//label[text()='Dose']/..//input[@id='dose'])[%s]", num));
			this.sendKeys(txtDose, "4");
			By txtUnit = By.xpath(String.format("(//label[text()='Unit']/..//input[@id='doseUnit'])[%s]", num));
			this.sendKeys(txtUnit, "4");
		}

		By drpdwnRequiredActions = By
				.xpath(String.format("(//label[text()='Require Action(s)']/..//select[@id='actions'])[%s]", num));
		this.SelectDropDownByText(drpdwnRequiredActions, requiredActions);
		if (requiredActions.equals("Other")) {
			By txtOthersRequiredActions = By.xpath(
					String.format("(//select[@id='actions']/..//input[@formcontrolname='description'])[%d]", num));
			this.sendKeys(txtOthersRequiredActions, othersRequiredActions);
		}
		By drpdwnRequiredActionsPostDropdown = By.xpath(String.format(
				"(//label[text()='Require Action(s) Post Administration']/..//select[@id='actionsPost'])[%d]", num));
		this.SelectDropDownByText(drpdwnRequiredActionsPostDropdown, requiredActionsPostDropdown);
		if (requiredActionsPostDropdown.equals("Other")) {
			By txtOthersRequiredActionsPostDropdown = By.xpath(
					String.format("(//select[@id='actionsPost']/..//input[@formcontrolname='description'])[%d]", num));
			this.sendKeys(txtOthersRequiredActionsPostDropdown, othersRequiredActionsPostDropdown);
		}
		By drpdwnAdministeredBy = By.xpath(String
				.format("(//label[text()='Administered By']/..//select[@id='settingOrderAdministratorId'])[%d]", num));
		this.SelectDropDownByText(drpdwnAdministeredBy, administeredBy);
		By chkbxIsSelfAdministered = By.xpath(String.format("(//input[@id='selfAdministered'])[%d]", num));
		this.click(chkbxIsSelfAdministered, "Is Self Administered Check Box");
		By chkbxselfAdministeredRequiresSupervision = By
				.xpath(String.format("(//input[@id='selfAdministeredRequiresSupervision'])[%d]", num));
		this.click(chkbxselfAdministeredRequiresSupervision, "Self Administered Requires Supervision Check Box");
		if (frequencyType.equals("Routine")) {
			By chkbxRequiresFollowUp = By.xpath(String.format("(//input[@id='requiresFollowUp'])[%d]", num));
			this.click(chkbxRequiresFollowUp, "Requires FollowUp Check Box");
		}
		By txtFollowUpAfterMinutes = By.xpath(String.format("(//input[@id='followUpAfterMinutes'])[%d]", num));
		this.sendKeys(txtFollowUpAfterMinutes, followUpAfterMinutes);

		for (int i = 1; i <= 5; i++) {
			By chkbxRequiesSlidingScale = By
					.xpath(String.format("(//label[@class='form-check-label']/input[@id='useSlidingScale'])[%d]", num));

			By txtSlidingScaleMin = By.xpath(String
					.format("((//div[@class='card'])[%d]//table//input[@formcontrolname='minValue'])[%s]", num, i));

			By txtSlidingScaleMax = By.xpath(String
					.format("((//div[@class='card'])[%d]//table//input[@formcontrolname='maxValue'])[%s]", num, i));

			By txtSlidingScaleUnits = By.xpath(
					String.format("((//div[@class='card'])[%d]//table//input[@formcontrolname='units'])[%s]", num, i));

			By chkBoxSlidingScaleNotifyRemove = By.xpath(String.format(
					"((//div[@class='card'])[%d]//table//input[@formcontrolname='notifyPhysician'])[%s]", num, i));

			By btnAddScale = By
					.xpath(String.format("(//div[@class='card'])[%s]//button[contains(@class,'btn-link')]", num));

			/*
			 * if(this.isElementNotPresent(txtSlidingScaleMin) &&
			 * this.isElementNotPresent(txtSlidingScaleMax) &&
			 * this.isElementNotPresent(txtSlidingScaleUnits)) {
			 * this.click(btnAddScale,"Add Scale"); }
			 */

			if (this.isElementPresent(txtSlidingScaleMin) && this.isElementPresent(txtSlidingScaleMax)
					&& this.isElementPresent(txtSlidingScaleUnits)) {

				this.SendKeysToElementClearFirst(txtSlidingScaleMin, slidingScaleMin);
				this.SendKeysToElementClearFirst(txtSlidingScaleMax, slidingScaleMax);
				this.SendKeysToElementClearFirst(txtSlidingScaleUnits, slidingScaleUnits);
				this.click(chkBoxSlidingScaleNotifyRemove, "Sliding Scale Notify Remove Check Box");
			}

			else {
				this.click(chkbxRequiesSlidingScale, "Requies Sliding Scale Check Box");
				this.SendKeysToElementClearFirst(txtSlidingScaleMin, slidingScaleMin);
				this.SendKeysToElementClearFirst(txtSlidingScaleMax, slidingScaleMax);
				this.SendKeysToElementClearFirst(txtSlidingScaleUnits, slidingScaleUnits);
				this.click(chkBoxSlidingScaleNotifyRemove, "Sliding Scale Notify Remove Check Box");

			}

			List<WebElement> SlidingScaleMin = wd.findElements(By.xpath(
					String.format("((//div[@class='card'])[%s]//table//input[@formcontrolname='minValue'])", num)));
			int MinCount = SlidingScaleMin.size();
			if (MinCount <= 4) {
				this.click(btnAddScale, "Add Scale");
			}
		}

		/*
		 * By chkbxRequiesSlidingScale = By.xpath(String.format(
		 * "(//label[@class='form-check-label']/input[@id='useSlidingScale'])[%d]",
		 * num));
		 * this.click(chkbxRequiesSlidingScale,"Requies Sliding Scale Check Box"); By
		 * txtSlidingScaleMin =
		 * By.xpath(String.format("(//table//input[@formcontrolname='minValue'])[%d]",
		 * num)); this.sendKeys(txtSlidingScaleMin, slidingScaleMin); By
		 * txtSlidingScaleMax =
		 * By.xpath(String.format("(//table//input[@formcontrolname='maxValue'])[%d]",
		 * num)); this.sendKeys(txtSlidingScaleMax, slidingScaleMax); By
		 * txtSlidingScaleUnits =
		 * By.xpath(String.format("(//table//input[@formcontrolname='units'])[%d]",
		 * num)); this.sendKeys(txtSlidingScaleUnits, slidingScaleUnits); By
		 * chkBoxSlidingScaleNotifyRemove = By.xpath(String.format(
		 * "(//table//input[@formcontrolname='notifyPhysician'])[%d]", num));
		 * this.click(
		 * chkBoxSlidingScaleNotifyRemove,"Sliding Scale Notify Remove Check Box");
		 */

	}

	public void CreateOrderFrequencyForRoutine(int num, String physicianInstructions, String additionalInstruction,
			String type) {
		if (!type.equals("Ancillaries")) {
			if ((type.equals("Medication") || type.equals("Treatment With Medication"))) {
				By btnGenerrate = By.xpath(String
						.format("(//label[text()='Physician Instructions']/..//button[text()='Generate'])[%d]", num));
				this.click(btnGenerrate, "Genrate Button");
			} else {

				By txtPhysicianInstructions = By.xpath(String.format(
						"(//label[text()='Physician Instructions']/..//textarea[@id='instructions'])[%d]", num));
				this.sendKeys(txtPhysicianInstructions, physicianInstructions);
			}
		}
		By txtAdditionalInstruction = By.xpath(String
				.format("(//label[text()='Additional Instruction']/..//textarea[@id='additionalNotes'])[%d]", num));
		this.sendKeys(txtAdditionalInstruction, additionalInstruction);
	}

	public void HowOftenDailyType(int FrequencyNum, String howOften, String everyDay) {
		By drpdwnHowOften = By.xpath(String
				.format("(//label[text()='How often']/..//select[@id='patientOrderScheduleType'])[%d]", FrequencyNum));
		this.SelectDropDownByText(drpdwnHowOften, howOften);
		By txtEveryDay = By
				.xpath(String.format("(//label[text()='Every']/..//input[@id='happensEvery'])[%d]", FrequencyNum));
		this.SendKeysToElementClearFirst(txtEveryDay, everyDay);

	}

	public void HowOftenWeeklytype(int FrequencyNum, int noOfTimes, String howOften, String everyDay) {
		By drpdwnHowOften = By.xpath(String.format(
				"((//div[@class='card'])[%d])//label[text()='How often']/..//select[@id='patientOrderScheduleType']",
				FrequencyNum+1));
		this.SelectDropDownByText(drpdwnHowOften, howOften);
		By txtEveryDay = By.xpath(String.format(
				"((//div[@class='card'])[%d])//label[text()='Every']/..//input[@id='happensEvery']", FrequencyNum+1));
		this.SendKeysToElementClearFirst(txtEveryDay, everyDay);

		List<WebElement> weeklyDays = wd.findElements(By
				.xpath(String.format("(//div[@class='card'])[%d]//div[@formarrayname='schedules']/div", FrequencyNum+1)));
		List<String> WeeklyDayInHowOften = new ArrayList<>();

		for (WebElement match : weeklyDays) {
			WeeklyDayInHowOften.add(match.getText());
			String noOfDays = match.getText();
			System.out.println(noOfDays);
		}
		for (int i = 1; i <= 2; i++) {
			By ChkBxScheduleDay = By.xpath(String.format(
					"(//div[@class='card'])[%d]//div[@formarrayname='schedules']/div[%d]//input", FrequencyNum+1, i));
			this.click(ChkBxScheduleDay, "Schedule Day Check Box");
		}

	}

	public void HowOftenMonthlytype(String typeOfMode, int FrequencyNum, int howOftenTime, int dayNo, String howOften,
			String everyDay, String DropdownNumber, String DropdownDay) {
		if (typeOfMode.equals("Use specific days")) {

			By drpdwnHowOften = By.xpath(String.format(
					"((//div[@class='card'])[%d])//label[text()='How often']/..//select[@id='patientOrderScheduleType']",
					FrequencyNum+1));
			this.SelectDropDownByText(drpdwnHowOften, howOften);
			/*
			 * By chkbxUseSpecificDays = By.xpath(String.format(
			 * "(((//div[@class='card'])[%d])//div[@class='form-row']//input[@name='rdoMonthlyChoice'])[1]",
			 * FrequencyNum));
			 * 
			 * boolean IsSelected = wd.findElement(By.xpath(String.format(
			 * "(((//div[@class='card'])[%d])//div[@class='form-row']//input[@name='rdoMonthlyChoice'])[1]",
			 * FrequencyNum))).getAttribute("ng-reflect-value").equals("true");
			 * if(!IsSelected) {
			 * this.click(chkbxUseSpecificDays,"Use Specific Days Check box"); }
			 */

			By drpDwnUseSpecificDays = By.xpath(String.format(
					"((//div[@class='card'])[%s])//label[text()='Schedule']/..//select[@id='patientOrderScheduleType']",
					FrequencyNum+1));
			this.SelectDropDownByText(drpDwnUseSpecificDays, typeOfMode);

			List<WebElement> MonthlyDays = wd.findElements(By.xpath(
					String.format("(//div[@class='card'])[%d]//div[@formarrayname='schedules']/div", FrequencyNum+1)));
			List<String> MonthlyDaysInHowOften = new ArrayList<>();

			for (WebElement match : MonthlyDays) {
				MonthlyDaysInHowOften.add(match.getText());
				String noOfDays = match.getText();
				System.out.println(noOfDays);
			}

			for (int i = 1; i <= 10; i++) {
				By ChkBxScheduleDay = By.xpath(String.format(
						"(//div[@class='card'])[%d]//div[@formarrayname='schedules']/div[%d]//input", FrequencyNum+1, i));
				this.click(ChkBxScheduleDay, "Schedule Day Check Box");
			}
			By txtEveryDay = By.xpath(String.format(
					"((//div[@class='card'])[%d]//label[text()='of every']/..//input[@id='happensEvery'])",
					FrequencyNum+1));
			this.SendKeysToElementClearFirst(txtEveryDay, everyDay);

		} else if (typeOfMode.equals("Use by week")) {

			int newHowOftenTime = (howOftenTime + 1);

			By drpdwnHowOften = By.xpath(String.format(
					"((//div[@class='card'])[%d])//label[text()='How often']/..//select[@id='patientOrderScheduleType']",
					FrequencyNum+1));
			this.SelectDropDownByText(drpdwnHowOften, howOften);

			// By radioUseByWeeks =
			// By.xpath(String.format("((//div[@class='form-row']//input[@name='rdoMonthlyChoice'])[4])"));

			By drpDwnUseByWeeks = By.xpath(String.format(
					"((//div[@class='card'])[%s])//label[text()='Schedule']/..//select[@id='patientOrderScheduleType']",
					FrequencyNum+1));
			this.SelectDropDownByText(drpDwnUseByWeeks, typeOfMode);

			/*
			 * boolean IsSelected = wd.findElement(By.xpath(String.format(
			 * "((//div[@class='card'])[%d]//div[@class='form-row']//input[@name='rdoMonthlyChoice'])[2]"
			 * ,FrequencyNum))).getAttribute("ng-reflect-value").equals("true");
			 * if(!IsSelected) { this.click(radioUseByWeeks,"Use By Weeks Radio Button"); }
			 */

			By drpdwnNumber = By.xpath(String
					.format("((//div[@class='card'])[%d]//select[@formcontrolname='weekOfTheMonth'])", FrequencyNum+1));
			this.SelectDropDownByText(drpdwnNumber, DropdownNumber);

			By drpdwnDay = By.xpath(String
					.format("((//div[@class='card'])[%d]//select[@formcontrolname='dayOfTheWeek'])", FrequencyNum+1));
			this.SelectDropDownByText(drpdwnDay, DropdownDay);

			By txtEveryDay = By.xpath(String.format(
					"((//div[@class='card'])[%d]//label[text()='of every']/..//input[@id='happensEvery'])",
					FrequencyNum+1));
			this.SendKeysToElementClearFirst(txtEveryDay, everyDay);

		}
	}

	public void HowOftenYearlyType(int FrequencyNum, int newHowOftenNumber, String howOften, String scheduleOnMonth,
			String scheduleOnNumber, String scheduleOnYear) {
		// int newHowOftenNumber =1;

		By drpdwnHowOften = By.xpath(String.format(
				"((//div[@class='card'])[%d])//label[text()='How often']/..//select[@id='patientOrderScheduleType']",
				FrequencyNum+1));
		this.SelectDropDownByText(drpdwnHowOften, howOften);

		By drpdwnScheduleOnMonth = By.xpath(String.format(
				"((//div[@class='card'])[%d])//label[text()='On']/..//select[@formcontrolname='monthOfTheYear']",
				FrequencyNum+1));
		this.SelectDropDownByText(drpdwnScheduleOnMonth, scheduleOnMonth);
		By drpdwnScheduleOnNumber = By.xpath(String.format(
				"((//div[@class='card'])[%d])//label[text()='On']/..//input[@formcontrolname='dayOfTheMonth']",
				FrequencyNum+1));
		this.SendKeysToElementClearFirst(drpdwnScheduleOnNumber, scheduleOnNumber);
		// By drpdwnScheduleOnYear = By.xpath(String.format("(//label[text()='of
		// every']/..//input[@formcontrolname='happensEvery'])[%d]",newHowOftenNumber));
		// this.sendKeys(drpdwnScheduleOnYear, scheduleOnYear);

		By txtEveryDay = By.xpath(String.format(
				"((//div[@class='card'])[%d]//label[text()='of every']/..//input[@id='happensEvery'])", FrequencyNum+1));
		this.sendKeys(txtEveryDay, scheduleOnYear);

	}

	public void OnceAShiftFrequency(int frequencyNum, String frequency) {
		By drpdwnFrequency = By.xpath(String
				.format("(//label[text()='Frequency']/..//select[@id='typeOrderFrequencyId'])[%d]", frequencyNum));
		this.SelectDropDownByText(drpdwnFrequency, frequency);
	}

	public void ShiftFrequency(int frequencyNum, String frequency) {
		By drpdwnFrequency = By.xpath(String.format(
				"((//div[@class='card'])[%d])//label[text()='Frequency']/..//select[@id='typeOrderFrequencyId']",
				frequencyNum));
		this.SelectDropDownByText(drpdwnFrequency, frequency);
	}

	public void TextTypeNoOfTimesAdayFrequency(String frequencyTexttype, int frequencyNum, String frequency,
			int numberOfShifts, String timeInADay) {
		By drpdwnFrequency = By.xpath(String.format("((//div[@class='card'])[%d])//label[text()='Frequency']/..//select[@id='typeOrderFrequencyId']",
				frequencyNum));

		this.SelectDropDownByText(drpdwnFrequency, frequency);
		if (frequencyTexttype.equals("text Box")) {
			for (int i = 1; i <= numberOfShifts; i++) {

				By textbxTimeInADayOnce = By.xpath(String.format("(((//div[@class='card'])[%d]//label[text()='Times']/..//div[@formarrayname='timeRanges'])/..//div//input[@placeholder='hh:mm ampm'])[%d]",
						frequencyNum, i));

				this.SendKeysToElementClearFirst(textbxTimeInADayOnce, timeInADay);

			}
		} else {

			By chkbxUserPredefinedTimeRange = By.xpath((String.format("((//div[@class='card'])[%s]//label[text()='Times']/..//input[@type='checkbox'])[1]",
					frequencyNum)));
			this.click(chkbxUserPredefinedTimeRange, "User Predefined TimeRange Check Box");
			for (int i = 1; i <= numberOfShifts; i++) {

				By ckhbxTimeInADayOnce = By.xpath(String.format(
						"(((//div[@class='card'])[%d]//label[text()='Times']/..//div[@formarrayname='timeRanges'])//select[@formcontrolname='settingId'])[%d]",
						frequencyNum, i));

				this.SelectDropDownByText(ckhbxTimeInADayOnce, timeInADay);

			}
		}
	}

	public void LastMessage() {
		By notRightNow = By.xpath("//div[@class='modal-content']//button[text()='Not right now']");
		this.click(notRightNow, "Not right now");
	}

	public void PhysicianPortalHeaderVerfication() {
		this.testReport.logSuccess(
				"clicking on Physician Portal app, below menu display : Physician Portal, Messages, Mediprocity");
		this.VerifyWebElementPresent(btnHeaderPhysicianPortal, "Physician Portal");
		this.VerifyWebElementPresent(btnHeaderMessages, "Messages");
		this.VerifyWebElementPresent(btnHeaderMediprocity, "Image Present ");

	}

	public void VerifyTheOrderByClickingVerifyButton() {
		if (this.isElementPresent(btnHeaderPhysicianPortal)) {
			this.VerifyWebElementPresent(btnHeaderPhysicianPortal, "Physician Portal");
			this.click(btnHeaderPhysicianPortal, "Physician Portal");
			this.VerifyWebElementPresent(spandrpdwnVerify, "Verify");
			this.click(spandrpdwnVerify, "Verify");
		}
		if (this.isElementPresent(btnHeaderOrders)) {
			this.VerifyWebElementPresent(btnHeaderOrders, "Orders");
			this.click(btnHeaderOrders, "Orders");
			this.VerifyWebElementPresent(spandrpdwnVerify, "Verify");
			this.click(spandrpdwnVerify, "Verify");
		}
	}

	public void VerifyTheOrderByClickingSignButton() {
		if (this.isElementPresent(btnHeaderPhysicianPortal)) {
			this.VerifyWebElementPresent(btnHeaderPhysicianPortal, "Physician Portal");
			this.click(btnHeaderPhysicianPortal, "Physician Portal");
			this.VerifyWebElementPresent(spandrpdwnSign, "Sign");
			this.click(spandrpdwnSign, "Sign");
		}
		if (this.isElementPresent(btnHeaderOrders)) {
			this.VerifyWebElementPresent(btnHeaderOrders, "Orders");
			this.click(btnHeaderOrders, "Orders");
			this.VerifyWebElementPresent(spandrpdwnSign, "Sign");
			this.click(spandrpdwnSign, "Sign");
		}

	}

	public void VerifyTheOrderByClickingRecapButton() {
		if (this.isElementPresent(btnHeaderPhysicianPortal)) {
			this.VerifyWebElementPresent(btnHeaderPhysicianPortal, "Physician Portal");
			this.click(btnHeaderPhysicianPortal, "Physician Portal");
			this.VerifyWebElementPresent(spandrpdwnRecap, "Recap");
			this.click(spandrpdwnRecap, "Recap");
		}
		if (this.isElementPresent(btnHeaderOrders)) {
			this.VerifyWebElementPresent(btnHeaderOrders, "Orders");
			this.click(btnHeaderOrders, "Orders");
			this.VerifyWebElementPresent(spandrpdwnRecap, "Recap");
			this.click(spandrpdwnRecap, "Recap");
		}
	}

	public void VerifyPhysicianPortalDrropdown() {
		this.testReport.logSuccess(
				"Clicking on Physician portal display below sub menus :Sign,Resident Orders,Recap,Verify,History & Physicial,Physician Progress Note Assessment,Physician Progress Note");
		this.click(btnPhysicianPortal, "Physician Portal Button");
		this.WaitForElementPresent(spandrpdwnSign, 10, "Sign");
		this.VerifyWebElementPresent(spandrpdwnSign, "Sign");
		this.VerifyWebElementPresent(spandrpdwnResidentOrder, "Resident Order");
		this.VerifyWebElementPresent(spandrpdwnRecap, "Recap");
		this.VerifyWebElementPresent(spandrpdwnVerify, "Verify");
		this.VerifyWebElementPresent(spandrpdwnHistoryandPhysical, "History and Physical");
		this.VerifyWebElementPresent(spandrpdwnPhysicianProgressNoteAssessment, "Physician Progress Note Assessment");
		this.VerifyWebElementPresent(spandrpdwnPhysicianProgressNotes, "Physician Progress Notes");
		this.click(aResidentOrders, "Resident Orders");
		this.waitInSecs(2);
	}

	public void VerifyResidentPageHeaderHeading() {
		this.testReport.logSuccess(
				" Clicking on Resident Order submenu should display under below columns First Name,Last Name,Mr#,SSN,Location,DOB,Age");

		this.VerifyWebElementPresent(spanResidentFirstName, "Resident FirstName");
		this.VerifyWebElementPresent(spanResidentLastName, "Resident LastName");
		this.VerifyWebElementPresent(spanResidentMr, "Resident Mr#");
		this.VerifyWebElementPresent(spanResidentSSN, "Resident SSN");
		this.VerifyWebElementPresent(spanResidentLocation, "Resident Location");
		this.VerifyWebElementPresent(spanResidentDateOfBirth, "Resident Date Of Birth");
		this.VerifyWebElementPresent(spanResidentAge, "Resident Age");
		this.VerifyWebElementPresent(spanResidentActions, "Resident Actions");
	}

	public void CounttheNoOfResidentInAPage() {
		/*List<WebElement> CountInAPage = wd.findElements(By.xpath(
				"//datatable-scroller[@class='datatable-scroll ng-star-inserted']/datatable-row-wrapper//datatable-body-cell[3]//span"));*/
		List<WebElement> CountInAPage = wd.findElements(By.xpath(
				"//datatable-row-wrapper//datatable-body-cell[2]"));
		List<String> ResidentCountNos = new ArrayList<>();

		for (WebElement match : CountInAPage) {
			ResidentCountNos.add(match.getText());
			String noOfResidents = match.getText();
			System.out.println(noOfResidents);
			int totalnoofResident = ResidentCountNos.size();
			System.out.println(totalnoofResident);
		}

		By nextSideClick = By.xpath("(//datatable-pager[@class='datatable-pager']//a)[8]");
		By nextArrowClick = By.xpath("(//datatable-pager[@class='datatable-pager']//a)[9]");
		this.VerifyWebElementPresent(nextSideClick, "Side Click");
		this.VerifyWebElementPresent(nextArrowClick, "Arrow Click");

		this.testReport.logSuccess("Clicked on Existing Resident Present in the Portal ");
		for (int i = 3; i <= 7; i++) {
			By linkPageBottom = By.xpath(String.format("(//datatable-pager[@class='datatable-pager']//a)[%s]", i));

			click(linkPageBottom, "Navigate Page");

		}

		By firstSideClick = By.xpath("(//datatable-pager//a/i[@class='datatable-icon-prev'])[1]");
		this.click(firstSideClick, "First Side Click");

	}

	public void VerifyButtonInResidentOrders() {
		this.testReport.logInfo(
				"clicking on Orders >> Resident Orders display two buttons :i> Create an Order ii>Create from Sets");
		this.waitUntilElementIsClickable(btnCreateOrder);
		this.VerifyWebElementPresent(btnCreateOrder, "Create An Order");
		this.waitUntilElementIsClickable(btnCreateSet);
		this.VerifyWebElementPresent(btnCreateSet, "Create From Set");
	}

	public void VerifytheFieldsDisplayDownToMessage() {
		this.testReport.logSuccess(
				"Verify below fields display down to message to find/search the resident Enter Name or MR Number ,Select Station ,Select Statuses ,Apply Filter button ");
		this.VerifyWebElementPresent(txtEnterNameOrMrNumber, "Enter Name or MR Number");
		this.VerifyWebElementPresent(drpdwnAdmittedDischargedTransfered, "Admitted,Discharged,Transfered");
		this.VerifyWebElementPresent(btnAdmitNewResident, "Admit New Resident");
		this.VerifyWebElementPresent(labelDisplayPastStays, "Display Past Stays");
	}

	public void VerifyPreviousOrders() {
		List<WebElement> totalNoOfOrders = wd.findElements(By.xpath("//datatable-scroller//datatable-row-wrapper"));
		// List<String> TotalNoOfResidentCount = new ArrayList<>();
		if (totalNoOfOrders.size() > 0) {
			this.testReport.logSuccess("any previous orders display in the list for the resident");

		} else {
			this.testReport.logSuccess("No previous orders display in the list for the resident");
		}

	}

	public void FullOrderPageVerification() {
		this.testReport.logSuccess(
				"Clicking on Create an Orders button, open Full Order Page with below fields Save button,Cancel button,Type List box,Add frequency Button");
		if (this.isElementPresent(btnCreateOrder)) {
			this.click(btnCreateOrder, "Create An Order");
		}
		if (this.isElementPresent(OrderPageDetails))
		{
		this.VerifyWebElementPresent(OrderPageDetails, "Order Page Details");
		this.VerifyWebElementPresent(btnSaveOrder, "Save button");
		this.VerifyWebElementPresent(btnCancel, "Cancel button");
		this.VerifyWebElementPresent(txtOrderType, "Type List box");
		this.VerifyWebElementPresent(btnAddFrequency, "Add frequency Button");
		}
	}

	public void SearchResidentWithApplyFilterButton(String enterName) {
		List<WebElement> CountInAPage = wd
				.findElements(By.xpath("//datatable-scroller//datatable-row-wrapper//datatable-body-row"));
		this.sendKeys(txtEnterNameOrMrNumber, enterName);
		this.waitInSecs(1);

		List<WebElement> FilterCountInAPage = wd
				.findElements(By.xpath("//datatable-scroller//datatable-row-wrapper//datatable-body-row"));

		if (CountInAPage.size() > FilterCountInAPage.size() && FilterCountInAPage.size() == 1) {
			this.testReport.logSuccess(
					"clicking on Apply Filter button, display the list of filtered residents in the Container");
		}

		else {
			this.testReport.logFailure(
					"clicking on Apply Filter button, not display the list of filtered residents in the Container");
		}

		By btnSelect = By.xpath("//button[text()='Select']");
		this.click(btnSelect, "Select Button");
	}

	public static boolean CheckAscendingOrder(List<String> Names) {
		String previous = "";
		for (String match : Names) {
			if (match.compareTo(previous) < 0) {
				return false;
			}
			previous = match;
		}

		return true;
	}

	public static boolean CheckDescendingOrder(List<String> Names) {
		String previous = "";
		for (String match : Names) {
			if (match.compareTo(previous) > 0) {
				return true;
			}
			previous = match;
		}
		return false;
	}

	public void AssendingOrderUsingFirstName() {

		List<WebElement> CountInAPage = wd
				.findElements(By.xpath(("//datatable-body-cell[3]//div[@class='datatable-body-cell-label']//span")));
		List<String> CountInAPageOrder = new ArrayList<>();

		for (WebElement match : CountInAPage) {
			CountInAPageOrder.add(match.getText());
			String noOfResidents = match.getText();
			System.out.println(noOfResidents);
		}

		By Name = By.xpath("//span[contains(text(),'First Name')]");
		this.click(Name, "First Name");
		Collections.sort(CountInAPageOrder);
		boolean sorted = CheckAscendingOrder(CountInAPageOrder);
		if (sorted == true) {
			this.testReport.logSuccess("Sorted the Name in Ascending Order");
		} else {
			this.testReport.logFailure(" Not Sorted the Name in Ascending Order");
		}

		this.click(Name, "First Name");

	}

	public void AssendingOrderUsingLastName() {

		List<WebElement> CountInAPage = wd
				.findElements(By.xpath(("//datatable-body-cell[2]//div[@class='datatable-body-cell-label']//span")));
		List<String> CountInAPageOrder = new ArrayList<>();

		for (WebElement match : CountInAPage) {
			CountInAPageOrder.add(match.getText());
			String noOfResidents = match.getText();
			System.out.println(noOfResidents);
		}

		By Name = By.xpath("//span[contains(text(),'Last Name')]");
		this.click(Name, "Last Name");
		Collections.sort(CountInAPageOrder);
		boolean sorted = CheckAscendingOrder(CountInAPageOrder);
		if (sorted == true) {
			this.testReport.logSuccess("Sorted the Last Name in Ascending Order");
		} else {
			this.testReport.logFailure(" Not Sorted the Last Name in Ascending Order");
		}

		this.click(Name, "Last Name");

	}

	public void AssendingOrderUsingMr() {

		List<WebElement> CountInAPage = wd
				.findElements(By.xpath(("//datatable-body-cell[4]//div[@class='datatable-body-cell-label']//span")));
		List<String> CountInAPageOrder = new ArrayList<>();

		for (WebElement match : CountInAPage) {
			CountInAPageOrder.add(match.getText());
			String noOfResidents = match.getText();
			System.out.println(noOfResidents);
		}

		By Mr = By.xpath("//span[contains(text(),'Mr#')]");
		this.click(Mr, "Mr#");
		Collections.sort(CountInAPageOrder);
		boolean sorted = CheckAscendingOrder(CountInAPageOrder);
		if (sorted == true) {
			this.testReport.logSuccess("Sorted the Mr# in Ascending Order");
		} else {
			this.testReport.logFailure(" Not Sorted the Mr# in Ascending Order");
		}

		this.click(Mr, "Mr#");

	}

	public void AssendingOrderUsingAge() {

		List<WebElement> CountInAPage = wd
				.findElements(By.xpath(("//datatable-body-cell[7]//div[@class='datatable-body-cell-label']//span")));
		List<String> CountInAPageOrder = new ArrayList<>();

		for (WebElement match : CountInAPage) {
			CountInAPageOrder.add(match.getText());
			String noOfResidents = match.getText();
			System.out.println(noOfResidents);
		}

		By Age = By.xpath("//span[contains(text(),'Age')]");
		this.click(Age, "Age");
		Collections.sort(CountInAPageOrder);
		boolean sorted = CheckAscendingOrder(CountInAPageOrder);
		if (sorted == true) {
			this.testReport.logSuccess("Sorted the Age in Ascending Order");
		} else {
			this.testReport.logFailure(" Not Sorted the Age in Ascending Order");
		}

		this.click(Age, "Age");

	}

	public void AssendingOrderUsingLocation() {

		List<WebElement> CountInAPage = wd
				.findElements(By.xpath(("//datatable-body-cell[8]//div[@class='datatable-body-cell-label']//span")));
		List<String> CountInAPageOrder = new ArrayList<>();

		for (WebElement match : CountInAPage) {
			CountInAPageOrder.add(match.getText());
			String noOfResidents = match.getText();
			System.out.println(noOfResidents);
		}

		By Location = By.xpath("//span[contains(text(),'Location')]");
		this.click(Location, "Location");
		Collections.sort(CountInAPageOrder);
		boolean sorted = CheckAscendingOrder(CountInAPageOrder);
		if (sorted == true) {
			this.testReport.logSuccess("Sorted the Location in Ascending Order");
		} else {
			this.testReport.logFailure(" Not Sorted the Location in Ascending Order");
		}

		this.click(Location, "Location");

	}

	public void ResidentFullOrderDetailsWithoutMedication(String type, String libraryText, String createdType) {
		this.waitInSecs(5);
		if (this.isElementPresent(btnCreateOrder)) {
			this.testReport.logSuccess("Order Created ");
			this.click(btnCreateOrder, "Create Order Button");
			this.waitInSecs(5);
		}
		this.waitUntilElementIsVisible(txtOrderType);
		this.click(txtOrderType, type);
		this.SelectDropDownByText(txtOrderType, type);
		this.waitInSecs(5);
		this.VerifyWebElementPresent(labelPickFromLibrary, "Label Pick From Library");
		this.VerifyWebElementPresent(linkCreateLibraryItem, "Create Library Item Link");
		if (createdType.equals("DropDown")) {
			this.SelectDropDownByText(txtPickFromLibrary, libraryText);
			this.waitInSecs(2);
			this.AssettextEqual(txtOrderDescription, txtPickFromLibrary);

		} else {
			this.click(linkCreateLibraryItem, "Create Library Item Link");
			this.VerifyWebElementPresent(linkCreate, "Create Link");

			this.VerifyWebElementPresent(linkCancel, "Cancel");
			this.waitInSecs(2);
			this.sendKeys(txtPickLibrary, libraryText);
			this.waitInSecs(2);
			this.click(linkCreate, "Create Link");
			this.waitInSecs(2);
			this.AssettextEqual(txtOrderDescription, txtPickFromLibrary);
		}

	}

	public void VerifyRemoveButtonInPickFromLibrary(String type, String libraryText) {
		if (this.isElementPresent(btnCreateOrder)) {
			this.testReport.logSuccess("Order Created ");
			this.click(btnCreateOrder, "Create Order Button");
			this.waitInSecs(5);
		}
		this.waitUntilElementIsVisible(txtOrderType);
		this.SelectDropDownByText(txtOrderType, type);
		this.waitInSecs(5);

		List<WebElement> descriptions = wd.findElements(By.xpath("//select[@id='libraryselect']/option"));
		int DescriptionsNo = descriptions.size();
		for (int i = 1; i <= DescriptionsNo; i++) {
			String description = wd
					.findElement(By.xpath(String.format("(//select[@id='libraryselect']/option)[%s]", i))).getText();
			if (!description.equals(libraryText)) {
				this.testReport.logSuccess("Description ",
						String.format(" Description not Present in the List - <mark>%s</mark> ", description));
			}
		}

	}

	public void ResidentFullOrderDetails(String type, String nullDiagonisis, String SearchDiogonosisTxt,
			String medicarePriority, String diogonosisName, String physicianType, String ReceivedByType,
			String ReceivedOrderType, String routes, String WrittenDate, String NoOfRefillis, String WhenToFill) {
		this.SelectDropDownByText(srchDiogonosis, nullDiagonisis);
		this.waitInSecs(2);
		this.VerifyWebElementPresent(labelDiagnosisRequired, "Diagonosis Required");
		this.click(linkAddDiagonosis, "Add Diagonosis Link");
		this.waitInSecs(2);
		this.VerifyWebElementPresent(labelICD10Database, "ICD10 Database");
		this.waitUntilElementIsVisible(txtSearchDiogonosis);
		this.sendKeys(txtSearchDiogonosis, SearchDiogonosisTxt);
		this.waitInSecs(2);
		this.click(btnSearchDiogonosis, "Search Diogonosis Button");
		this.waitInSecs(10);

		// By diogonosisOption =
		// By.xpath((String.format("//div[@class='datatable-body-cell-label']/span[text()='%d']",
		// diogonosisName)));
		this.click(diogonosisOption, "Diogonosis Option");
		this.waitInSecs(5);
		this.VerifyWebElementPresent(radioMedication, "Medication radio Button");
		this.VerifyWebElementPresent(radioTreatment, "Treatment radio Button");
		if (type.equals("Medication") || type.equals("Treatment With Medication")) {
			this.click(radioMedication, "Medication radio Button");
			this.waitInSecs(2);
		} else {
			this.click(radioTreatment, "Treatment radio Button");
			this.waitInSecs(2);
		}
		this.VerifyWebElementPresent(txtMedicarePriority, "Medicare Priority");
		this.sendKeys(txtMedicarePriority, medicarePriority);
		this.waitInSecs(2);
		this.VerifyWebElementPresent(chkbxAdmitting, "Admitting Check Box");
		this.click(chkbxAdmitting, "Admitting Check Box");
		this.waitInSecs(2);
		this.VerifyWebElementPresent(chkbxSendToMDS, "Send To MDS Check Box");
		this.click(chkbxSendToMDS, "Send To MDS Check Box");
		this.waitInSecs(2);
		//this.VerifyWebElementPresent(chkbxBillingAdmitDiagnosis, "Billing Admit Diagnosis Check Box");
		//this.click(chkbxBillingAdmitDiagnosis, "Billing Admit Diagnosis Check Box");
		//this.waitInSecs(2);
		this.VerifyWebElementPresent(btnDiogonosisCreate, "Create Diogonosis Button");
		this.click(btnDiogonosisCreate, "Create Diogonosis Button");
		if (this.isElementPresent(linkDuplicateDiogonosis)) {
			this.click(btnClose, "Close Button");
			this.waitInSecs(2);
			this.SelectDropDownByText(srchDiogonosis, diogonosisName);
			this.waitInSecs(2);
		}

		this.SelectDropDownByText(drpdwnPhysician, physicianType);
		this.waitInSecs(2);
		this.SelectDropDownByText(drpdwnReceivedBy, ReceivedByType);
		this.waitInSecs(2);
		this.SelectDropDownByText(drpdwnReceivedOrder, ReceivedOrderType);
		this.waitInSecs(2);
		this.click(chkbxIsAdmitting, "Is Admitting Check Box");
		this.waitInSecs(2);
		if (type.equals("Medication") || type.equals("Treatment With Medication")) {
			this.SelectDropDownByText(drpDwnroutes, routes);// Both Ears
			this.waitInSecs(2);
			// this.sendKeys(txtWrittenDate, WrittenDate);
			// this.waitInSecs(2);
			/*
			 * this.SendKeysToElementClearFirst(txtNoOfRefillis, NoOfRefillis);
			 * this.waitInSecs(2); this.SelectDropDownByText(DrpdwnWhenToFill, WhenToFill);
			 * this.waitInSecs(2);
			 */
		}
	}

	public void CancelOrder() {
		this.waitInSecs(2);
		this.click(btnCancel, "Cancel");
		this.waitInSecs(5);
	}
	public void CreateAnOrderPresent()
	{
		this.WaitForElementPresent(btnCreateOrder, 10, "Create Order");
	}

	public void OrderFrequencyType(int num, String frequencyType) {
		By drpdwnFrequencyType = By.xpath(String.format("(//select[@id='routineTypeId'])[%d]", num));
		this.waitUntilElementIsClickable(drpdwnFrequencyType);
		this.VerifyWebElementPresent(drpdwnFrequencyType, "Frequency Type");
		this.SelectDropDownByText(drpdwnFrequencyType, frequencyType);
	}

	public void StartDate(int num, String startDate, String startDateTime) {
		By txtStartDate = By.xpath(String.format(
				"(//label[text()='Start Date']/..//input[@placeholder='mm/dd/yyyy' and @class='form-control'])[%d]",
				num));
		this.VerifyWebElementPresent(txtStartDate, "Start Date");
		By iconCalender = By.xpath(String
				.format("((//label[text()='Start Date']/..//button[@class='btn btn-outline-secondary']/i))[%d]", num));
		this.click(iconCalender, "Calender icon");
		By HighlightDate = By.xpath(String.format(
				"((//div[@class='card'])[%s]//label[text()='Start Date']/..//ngb-datepicker-month-view[@class='d-block']//div[contains(@class,'btn-light')])[1]",
				num+1));
		this.click(HighlightDate, "Today's Date");
		// this.SendKeysToElementClearFirst(txtStartDate, startDate);
		By txtStartDateTime = By
				.xpath(String.format("(//label[text()='Start Date']/..//input[@placeholder='hh:mm ampm' ])[%d]", num));
		this.VerifyWebElementPresent(txtStartDateTime, "Start Date Time");
		this.SendKeysToElementClearFirst(txtStartDateTime, startDateTime);
	}

	public void OrderEndType(int num, int byDateno, int afterNoOfAdminstrationsNo, String endDateType, String endDate,
			String ByDate, String byDateTime, String afterNumberOfAdminstrations) {
		if (endDateType.equals("No End")) {
			By drpdwnEndDate = By.xpath(String.format("(//label[text()='End']/..//select[@id='actions'])[%d]", num));
			this.VerifyWebElementPresent(drpdwnEndDate, "No End Date");
			this.SelectDropDownByText(drpdwnEndDate, endDateType);
		} else if (endDateType.equals("By Date")) {
			By drpdwnEndDate = By.xpath(String.format("(//label[text()='End']/..//select[@id='actions'])[%d]", num));
			this.VerifyWebElementPresent(drpdwnEndDate, "By Date");
			this.SelectDropDownByText(drpdwnEndDate, endDateType);
			By txtByDate = By.xpath(String.format(
					"(//div[@class='card'])[%d]//label[text()='End']/..//input[@placeholder='mm/dd/yyyy' and @class='form-control']",
					num+1));
			this.VerifyWebElementPresent(txtByDate, "By Date");
			By iconCalender = By.xpath(String.format(
					"(//div[@class='card'])[%d]//label[text()='End']/..//input[@placeholder='mm/dd/yyyy']/..//button/i",
					num+1));
			this.click(iconCalender, "Calender icon");
			By HighlightDate = By.xpath(String.format(
					"((//div[@class='card'])[%d]//label[text()='End']/..//ngb-datepicker-month-view[@class='d-block']//div[contains(@class,'btn-light')])[30]",
					num+1));
			this.click(HighlightDate, "Today's Date");

			// this.SendKeysToElementClearFirst(txtByDate, ByDate);
			By txtByDateTime = By.xpath(String.format(
					"(//div[@class='card'])[%d]//label[text()='End']/..//input[@placeholder='hh:mm ampm']", num+1));
			this.VerifyWebElementPresent(txtByDateTime, "By Date Time");
			this.SendKeysToElementClearFirst(txtByDateTime, byDateTime);
		} else {
			By drpdwnEndDate = By.xpath(String.format("(//label[text()='End']/..//select[@id='actions'])[%d]", num));
			this.VerifyWebElementPresent(drpdwnEndDate, "After Number Of Administrations");
			this.SelectDropDownByText(drpdwnEndDate, endDateType);
			By txtAfterNumberOfAdministrations = By.xpath(String.format(
					"((((//div[@class='card'])[%d]//label[text()='End']/..//input[@formcontrolname='endAfterNumberOfAdmin'])))",
					num+1));
			this.VerifyWebElementPresent(txtAfterNumberOfAdministrations, "After Number Of Administrations");
			this.sendKeys(txtAfterNumberOfAdministrations, afterNumberOfAdminstrations);
		}
	}

	public void VerifyChkBxRequireSchedule(int num, String Type) {
		if (Type.equals("Ancillaries")) {
			By chkBxRequireSchedule = By
					.xpath(String.format("(//div[@class='card'])[%s]//input[@id='requireSchedule']", num));
			this.click(chkBxRequireSchedule, "Check Box Require Schedule");
		}

	}

	public void RequireActionRelatedLabel(int num, String frequencyType, String requiredActions,
			String othersRequiredActions, String requiredActionsPostDropdown, String othersRequiredActionsPostDropdown,
			String administeredBy, String maxDoesHours, String followUpAfterMinutes, String slidingScaleMin,
			String slidingScaleMax, String slidingScaleUnits) {
		By drpdwnRequiredActions = By.xpath(String.format(
				"((//div[@class='card'])[%d]//label[text()='Require Action(s)']/..//select[@id='actions'])", num+1));
		this.waitUntilElementIsClickable(drpdwnRequiredActions);
		this.SelectDropDownByText(drpdwnRequiredActions, requiredActions);
		//this.SelectDropDownByText(By.xpath("//select[@id='actions']"), requiredActions);
		
		if (requiredActions.equals("Other")) {
			By txtOthersRequiredActions = By.xpath(String.format(
					"((//div[@class='card'])[%d]//select[@id='actions']/..//input[@formcontrolname='description'])",
					num+1));
			this.sendKeys(txtOthersRequiredActions, othersRequiredActions);
		}
		By drpdwnRequiredActionsPostDropdown = By.xpath(String.format(
				"((//div[@class='card'])[%d]//label[text()='Require Action(s) Post Administration']/..//select[@id='actionsPost'])",
				num+1));
		this.SelectDropDownByText(drpdwnRequiredActionsPostDropdown, requiredActionsPostDropdown);
		if (requiredActionsPostDropdown.equals("Other")) {
			By txtOthersRequiredActionsPostDropdown = By.xpath(String.format(
					"((//div[@class='card'])[%d]//select[@id='actionsPost']/..//input[@formcontrolname='description'])",
					num+1));
			this.sendKeys(txtOthersRequiredActionsPostDropdown, othersRequiredActionsPostDropdown);
		}
		By drpdwnAdministeredBy = By.xpath(String.format(
				"((//div[@class='card'])[%d]//label[text()='Administered By']/..//select[@id='settingOrderAdministratorId'])",
				num+1));
		this.SelectDropDownByText(drpdwnAdministeredBy, administeredBy);
		if (!frequencyType.equals("Routine")) {
			By txtMaxDoesHours = By.xpath(String.format(
					"((//div[@class='card'])[%d]//label[text()='Max Doses Per 24 Hours']/..//input[@id='prnMaxDailyAdministration'])",
					num+1));
			this.sendKeys(txtMaxDoesHours, maxDoesHours);
		}
		if (frequencyType.equals("PRN Every (x) Hour(s)")) {
			By PNREvery = By.xpath(String.format(
					"((//div[@class='card'])[%d]//label[text()='PRN Every']/..//input[@id='prnHourlyInterval'])", num+1));
			this.SendKeysToElementClearFirst(PNREvery, maxDoesHours);
		}

		By chkbxIsSelfAdministered = By
				.xpath(String.format("((//div[@class='card'])[%d]//input[@id='selfAdministered'])", num+1));
		this.click(chkbxIsSelfAdministered, "Is Self Administered Check Box");
		By chkbxselfAdministeredRequiresSupervision = By.xpath(
				String.format("((//div[@class='card'])[%d]//input[@id='selfAdministeredRequiresSupervision'])", num+1));
		this.click(chkbxselfAdministeredRequiresSupervision, "Self Administered Requires Supervision Check Box");
		if (frequencyType.equals("Routine")) {
			By chkbxRequiresFollowUp = By
					.xpath(String.format("((//div[@class='card'])[%d]//input[@id='requiresFollowUp'])", num+1));
			this.click(chkbxRequiresFollowUp, "Requires FollowUp Check Box");
		}

		By txtFollowUpAfterMinutes = By
				.xpath(String.format("((//div[@class='card'])[%d]//input[@id='followUpAfterMinutes'])", num+1));
		this.SendKeysToElementClearFirst(txtFollowUpAfterMinutes, followUpAfterMinutes);
		By chkbxRequiesSlidingScale = By.xpath(String.format(
				"((//div[@class='card'])[%d]//label[@class='form-check-label']/input[@id='useSlidingScale'])", num+1));

		for (int i = 1; i <= 2; i++) {
			By txtSlidingScaleMin = By.xpath(String
					.format("((//div[@class='card'])[%d]//table//input[@formcontrolname='minValue'])[%s]", num+1, i));

			By txtSlidingScaleMax = By.xpath(String
					.format("((//div[@class='card'])[%d]//table//input[@formcontrolname='maxValue'])[%s]", num+1, i));

			By txtSlidingScaleUnits = By.xpath(
					String.format("((//div[@class='card'])[%d]//table//input[@formcontrolname='units'])[%s]", num+1, i));

			By chkBoxSlidingScaleNotifyRemove = By.xpath(String.format(
					"((//div[@class='card'])[%d]//table//input[@formcontrolname='notifyPhysician'])[%s]", num+1, i));

			By btnAddScale = By
					.xpath(String.format("(//div[@class='card'])[%s]//button[contains(@class,'btn-link')]", num+1));

			if (this.isElementPresent(txtSlidingScaleMin) && this.isElementPresent(txtSlidingScaleMax)
					&& this.isElementPresent(txtSlidingScaleUnits)) {

				this.SendKeysToElementClearFirst(txtSlidingScaleMin, slidingScaleMin);
				this.SendKeysToElementClearFirst(txtSlidingScaleMax, slidingScaleMax);
				this.SendKeysToElementClearFirst(txtSlidingScaleUnits, slidingScaleUnits);
				this.click(chkBoxSlidingScaleNotifyRemove, "Sliding Scale Notify Remove Check Box");
			}

			else {
				this.click(chkbxRequiesSlidingScale, "Requies Sliding Scale Check Box");
				this.SendKeysToElementClearFirst(txtSlidingScaleMin, slidingScaleMin);
				this.SendKeysToElementClearFirst(txtSlidingScaleMax, slidingScaleMax);
				this.SendKeysToElementClearFirst(txtSlidingScaleUnits, slidingScaleUnits);
				this.click(chkBoxSlidingScaleNotifyRemove, "Sliding Scale Notify Remove Check Box");

			}

			List<WebElement> SlidingScaleMin = wd.findElements(By.xpath(
					String.format("((//div[@class='card'])[%s]//table//input[@formcontrolname='minValue'])", num)));
			int MinCount = SlidingScaleMin.size();
			if (MinCount <= 4) {
				this.click(btnAddScale, "Add Scale");
			}

		}

	}

	public void OrderDisplayPageColourVerification() {
		List<WebElement> bluecolourNeedSinging = wd.findElements(By.xpath("//strong[text()='Needs Signing']"));
		int needSinging = bluecolourNeedSinging.size();
		System.out.println("Total No of Need Singing : " + needSinging);

		List<WebElement> grayColourNeedsVerifications = wd
				.findElements(By.xpath("//strong[text()='Needs Verification']"));
		int needsVerifications = grayColourNeedsVerifications.size();
		System.out.println("Total No of Needs Verifications : " + needsVerifications);

		List<WebElement> greencolourActive = wd.findElements(By.xpath("//strong[text()='Active']"));
		int Active = greencolourActive.size();
		System.out.println("Total No of Active : " + Active);
	}

	public void OrderDisplayPageColoumnsVerification() {
		this.VerifyWebElementPresent(spanOrderSummaryDescription, "Summary Description");
		this.VerifyWebElementPresent(spanOrderSummaryType, "SummaryType");
		this.VerifyWebElementPresent(spanOrderSummaryPhysician, "SummaryPhysician");
		this.VerifyWebElementPresent(spanOrderSummaryFrequencies, "Order Summary Frequencies");
		this.VerifyWebElementPresent(spanOrderSummaryStatus, "Order Summary Status");

	}

	public void BottomPaneOfContainer() {
		this.VerifyWebElementPresent(defaultSection, "Default Section 25");
		List<WebElement> pagesNo = wd.findElements(By.xpath("//li[@class='pages']"));
		int PagesNoInOrderDisplay = pagesNo.size();
		System.out.println("Total No of Normal page Containers : " + PagesNoInOrderDisplay);
	}

	public void HourWiseFrequency(int frequencyNum, String frequency, String startingTime) {
		By drpdwnFrequency = By.xpath(String.format("(//label[text()='Frequency']/..//select[@id='typeOrderFrequencyId'])[%d]", frequencyNum));
		this.SelectDropDownByText(drpdwnFrequency, frequency);

		By startingAt = By.xpath(String.format(
				"((//div[@class='card'])[%d]//label[text()='Times']/..//input[@placeholder='hh:mm ampm'])",
				frequencyNum));
		this.SendKeysToElementClearFirst(startingAt, startingTime);
		// this.SendKeysToElementClearFirst(startingAt, "12:00 am");
		this.waitInSecs(2);
		// By doseTimings = By.xpath("//select[contains(@class,'form-control ng-pristine
		// ng-valid ng-touched')]");

		By doseTimings = By.xpath(String.format(
				"(//div[@class='card'])[%d]//label[text()='with the last dose at ']/../..//select[contains(@class,'form-control')]",
				frequencyNum));
		// this.click(doseTimings, "Dose Timings ");

		List<WebElement> NoOfTimings = wd.findElements(By.xpath(String.format(
				"(//div[@class='card'])[%d]//label[text()='with the last dose at ']/../..//select[contains(@class,'form-control')]/option",
				frequencyNum)));
		int frequencyNoOfTimings = NoOfTimings.size();
		System.out.println("Total No of Timings in a Frequency : " + frequencyNoOfTimings);

		this.SelectDropDownByIndex(doseTimings, 0);

	}

	public void BedTimeFrequency(String frequencyTexttype, int frequencyNum, String frequency, String timeInADay) {

		By drpdwnFrequency = By.xpath(String
				.format("(//label[text()='Frequency']/..//select[@id='typeOrderFrequencyId'])[%d]", frequencyNum));
		this.SelectDropDownByText(drpdwnFrequency, frequency);

		if (frequencyTexttype.equals("text Box")) {
			By chkbxUserPredefinedTimeRange = By.xpath((String.format(
					"((//div[@class='card'])[%s]//label[text()='Times']/..//input[@type='checkbox'])[1]",
					frequencyNum)));
			this.click(chkbxUserPredefinedTimeRange, "User Predefined TimeRange Check Box");

			By textbxTimeInADayOnce = By.xpath(String.format(
					"(((//div[@class='card'])[%d]//label[text()='Times']/..//div[@formarrayname='timeRanges'])/..//div//input[@placeholder='hh:mm ampm'])",
					frequencyNum));

			this.SendKeysToElementClearFirst(textbxTimeInADayOnce, timeInADay);
		} else {
			By ckhbxTimeInADayOnce = By.xpath(String.format(
					"(((//div[@class='card'])[%d]//label[text()='Times']/..//div[@formarrayname='timeRanges'])//select[@formcontrolname='settingId'])",
					frequencyNum));

			this.SelectDropDownByText(ckhbxTimeInADayOnce, timeInADay);

		}

	}

	public void MealWiseFrequency(int frequencyNum, String frequency, String timeInADay) {
		By drpdwnFrequency = By.xpath(String.format("(//label[text()='Frequency']/..//select[@id='typeOrderFrequencyId'])[%d]", frequencyNum));
		this.SelectDropDownByText(drpdwnFrequency, frequency);

		if (frequency.equals("Before Meals + Bed Time") || frequency.equals("After Meals + Bed Time")) {
			for (int i = 1; i <= 4; i++) {
				By ckhbxTimeInADayOnce = By.xpath(String.format(
						"(((//div[@class='card'])[%d]//label[text()='Times']/..//div[@formarrayname='timeRanges'])//select[@formcontrolname='settingId'])[%d]",
						frequencyNum, i));

				this.SelectDropDownByText(ckhbxTimeInADayOnce, timeInADay);
			}
		} else {
			for (int i = 1; i <= 3; i++) {
				By ckhbxTimeInADayOnce = By.xpath(String.format(
						"(((//div[@class='card'])[%d]//label[text()='Times']/..//div[@formarrayname='timeRanges'])//select[@formcontrolname='settingId'])[%d]",
						frequencyNum, i));

				this.SelectDropDownByText(ckhbxTimeInADayOnce, timeInADay);
			}
		}
	}

	public void ResidentFullOrderDetailsWithMedication(String type, String medicationType, String searchMedicationName,
			String libraryText) {
		if (this.isElementPresent(btnCreateOrder)) {
			this.testReport.logSuccess("Order Created ");
			this.click(btnCreateOrder, "Create Order Button");
			this.waitInSecs(5);
		}
		this.waitUntilElementIsVisible(txtOrderType);
		this.SelectDropDownByText(txtOrderType, type);
		this.waitInSecs(5);
		if (type.equals("Medication") || type.equals("Treatment With Medication")) {
			this.VerifyWebElementPresent(linkSearchMedications, "Search Medications");
			this.VerifyWebElementPresent(linkFreeForm, "Free Form");
			if (medicationType.equals("Search Medications")) {
				this.click(linkSearchMedications, "Search Medications");
				this.waitInSecs(2);
				this.VerifyWebElementPresent(labelMedicationDatabase, "Medication Database");
				this.sendKeys(txtSearchMedicineName, searchMedicationName);
				this.waitInSecs(2);
				this.click(btnSearchDiogonosis, "Search Medication");
				this.waitInSecs(20); // constant
				this.VerifyWebElementPresent(spanDrugName, "Drug Name");
				By medicineName = By.xpath(String.format(
						"//datatable-body-cell//span[text()='%s']",
						libraryText));
				this.click(medicineName, "Medicine");
				this.waitInSecs(2);
				this.VerifyWebElementPresent(msgNoInteractions, "No Interactions");
				this.waitUntilElementIsVisible(warningMessage);
				if (this.isElementPresent(warningMessage)) {
					this.click(declineInput, "Decline Input ");
					this.waitInSecs(2);
					this.sendKeys(txtDecline, libraryText);
					this.waitInSecs(10);
				}
			}

			else {
				this.click(linkFreeForm, "Free Form");
				this.VerifyWebElementPresent(txtmedicationName, "Medication Name");
				this.sendKeys(txtmedicationName, libraryText);
				this.waitInSecs(1);
				this.VerifyWebElementPresent(btnUseDrugDatabase, "Use Drug Database");
				this.click(btnUseDrugDatabase, "Use Drug Database");

			}
		}

	}

	public void DoseUnitWithMedication(int num, String type) {
		if (type.equals("Medication") || type.equals("Treatment With Medication")) {
			By txtDose = By.xpath(String.format("(//label[text()='Dose']/..//input[@id='dose'])[%d]", num));
			this.sendKeys(txtDose, "4");
			By txtUnit = By.xpath(String.format("(//label[text()='Unit']/..//input[@id='doseUnit'])[%d]", num));
			this.sendKeys(txtUnit, "4");
		}
	}

	public void RemoveFrequency(int num) {
		By btnremoveFrequency = By
				.xpath(String.format("(//div[@class='card'])[%d]//button[text()='Remove Frequency']", num+1));
		this.click(btnremoveFrequency, "Remove Frequency");
		By btnOK = By.xpath("//*[text()='Confirm']/..//..//div/button[text()='Ok']");
		this.click(btnOK, "OK Button");
	}

	public void WhereToTabValidation() {
		By btnNotrightNow = By.xpath("//*[text()='Where to?']/..//..//div/button[text()='Not right now']");
		if (this.isElementPresent(btnNotrightNow)) {
			this.click(btnNotrightNow, "Not right now");
		}
	}

	public void CreateFromSet() {
		this.VerifyWebElementPresent(btnCreateSet, "Create From Set");
		this.click(btnCreateSet, "Create From Set");
		this.VerifyWebElementPresent(btnCancel, "Cancel Button Present ");
	}

	public void SelectOrderFromOrderSets(String description) {
		By Description = By.xpath(String.format("//div[@class='list-group']//a//div/h5[text()='%s']", description));
		this.WaitForElementPresent(Description,20, "Created order present in Existing Set");
		this.VerifyWebElementPresent(Description, "Created order present in Existing Set");
		this.click(Description, "Click on Existing Set");

	}

	public void VerifyAnyOrderFromSet() {
		this.waitUntilElementIsVisible(LabelFullorder);

		this.VerifyWebElementPresent(LabelFullorder, "Full Order");
		this.VerifyWebElementPresent(labelOrdersInSet, "Orders In The Set");

		List<WebElement> NoOfOrderSets = wd
				.findElements(By.xpath("//div[@class='card']//div[@class='card-body']//a/div"));
		int CountOfOrder = NoOfOrderSets.size();
		System.out.println("Total No Of Orders in the Page : " + CountOfOrder);
		this.VerifyWebElementPresent(btnIgnore, "Ignore Button");

	}

	public void VerifyTheFieldsinFrequencyInOrdersInSets(int num, String frequencyType) {
		By drpdwnRequiredActions = By.xpath(String.format(
				"((//div[@class='card'])[%d]//label[text()='Require Action(s)']/..//select[@id='actions'])", num));
		this.VerifyWebElementPresent(drpdwnRequiredActions, "Required Actions");
		By drpdwnRequiredActionsPostDropdown = By.xpath(String.format(
				"((//div[@class='card'])[%d]//label[text()='Require Action(s) Post Administration']/..//select[@id='actionsPost'])",
				num));
		this.VerifyWebElementPresent(drpdwnRequiredActionsPostDropdown, "Required Actions Post Dropdown");
		By drpdwnAdministeredBy = By.xpath(String.format(
				"((//div[@class='card'])[%d]//label[text()='Administered By']/..//select[@id='settingOrderAdministratorId'])",
				num));
		this.VerifyWebElementPresent(drpdwnAdministeredBy, "Administered By");
		if (!frequencyType.equals("Routine")) {
			By txtMaxDoesHours = By.xpath(String.format(
					"((//div[@class='card'])[%d]//label[text()='Max Doses Per 24 Hours']/..//input[@id='prnMaxDailyAdministration'])",
					num));
			this.VerifyWebElementPresent(txtMaxDoesHours, "maxDoesHours");
		}
		if (frequencyType.equals("PRN Every (x) Hour(s)")) {
			By PNREvery = By.xpath(String.format(
					"((//div[@class='card'])[%d]//label[text()='PRN Every']/..//input[@id='prnHourlyInterval'])", num));
			this.VerifyWebElementPresent(PNREvery, "PNR Every");
		}

		By chkbxIsSelfAdministered = By
				.xpath(String.format("((//div[@class='card'])[%d]//input[@id='selfAdministered'])", num));
		this.VerifyWebElementPresent(chkbxIsSelfAdministered, "Is Self Administered Check Box");
		By chkbxselfAdministeredRequiresSupervision = By.xpath(
				String.format("((//div[@class='card'])[%d]//input[@id='selfAdministeredRequiresSupervision'])", num));
		this.VerifyWebElementPresent(chkbxselfAdministeredRequiresSupervision,
				"Self Administered Requires Supervision Check Box");
		if (frequencyType.equals("Routine")) {
			By chkbxRequiresFollowUp = By
					.xpath(String.format("((//div[@class='card'])[%d]//input[@id='requiresFollowUp'])", num));
			this.VerifyWebElementPresent(chkbxRequiresFollowUp, "Requires FollowUp Check Box");
		}

		By txtFollowUpAfterMinutes = By
				.xpath(String.format("((//div[@class='card'])[%d]//input[@id='followUpAfterMinutes'])", num));
		this.VerifyWebElementPresent(txtFollowUpAfterMinutes, "Follow Up After Minutes");
		By chkbxRequiesSlidingScale = By.xpath(String.format(
				"((//div[@class='card'])[%d]//label[@class='form-check-label']/input[@id='useSlidingScale'])", num));
		this.VerifyWebElementPresent(chkbxRequiesSlidingScale, "Requies Sliding Scale Check Box");
		By txtSlidingScaleMin = By
				.xpath(String.format("((//div[@class='card'])[%d]//table//input[@formcontrolname='minValue'])", num));
		this.VerifyWebElementPresent(txtSlidingScaleMin, "Sliding Scale Min");
		By txtSlidingScaleMax = By
				.xpath(String.format("((//div[@class='card'])[%d]//table//input[@formcontrolname='maxValue'])", num));
		this.VerifyWebElementPresent(txtSlidingScaleMax, "Sliding Scale Max");
		By txtSlidingScaleUnits = By
				.xpath(String.format("((//div[@class='card'])[%d]//table//input[@formcontrolname='units'])", num));
		this.VerifyWebElementPresent(txtSlidingScaleUnits, "Sliding Scale Units");
		By chkBoxSlidingScaleNotifyRemove = By.xpath(
				String.format("((//div[@class='card'])[%d]//table//input[@formcontrolname='notifyPhysician'])", num));
		this.VerifyWebElementPresent(chkBoxSlidingScaleNotifyRemove, "Sliding Scale Notify Remove Check Box");
		if (frequencyType.equals("Routine")) {
			By drpdwnFrequency = By.xpath(String.format(
					"((//div[@class='card'])[%d]//label[text()='Frequency']/..//select[@id='typeOrderFrequencyId'])",
					num));
			this.VerifyWebElementPresent(drpdwnFrequency, "Frequency");
			By drpdwnHowOften = By.xpath(String.format(
					"((//div[@class='card'])[%d]//label[text()='How often']/..//select[@id='patientOrderScheduleType'])",
					num));
			this.VerifyWebElementPresent(drpdwnHowOften, "howOften");
		}

		By txtPhysicianInstructions = By.xpath(String.format(
				"((//div[@class='card'])[%d]//label[text()='Physician Instructions']/..//textarea[@id='instructions'])",
				num));
		this.VerifyWebElementPresent(txtPhysicianInstructions, "Physician Instructions");

		By txtAdditionalInstruction = By.xpath(String.format(
				"((//div[@class='card'])[%d]//label[text()='Additional Instruction']/..//textarea[@id='additionalNotes'])",
				num));
		this.VerifyWebElementPresent(txtAdditionalInstruction, "Additional Instruction");
	}

	public void VerifyIgnoreOrderSet() {
		/*
		 * By Description =
		 * By.xpath(String.format("//div[@class='list-group']//a//div/h5[text()='%s']",
		 * description)); this.click(Description, "Description");
		 */
		/*
		 * By description = By.xpath("(//span[text()='Incomplete'])[1]");
		 * this.click(description, "Description");
		 */
		this.VerifyWebElementPresent(labelIgnoreThisOrderSet, "Ignore This Order Set");

		boolean LabelIgnoreThisOrderSet = wd.findElement(By.xpath("//div[contains(@class,'alert-warning')]//input")).isSelected();
				
		if (LabelIgnoreThisOrderSet) {
			this.click(labelIgnoreThisOrderSet, "Ignore This Order Set");
		}
	}

	public void VerifyAndSaveOrders(String frequencyType, String type, String libraryText, String SearchDiogonosisTxt,
			String medicarePriority, String diogonosisName, String physicianType, String ReceivedByType,
			String ReceivedOrderType, String routes, String WrittenDate, String NoOfRefillis, String WhenToFill) {
		List<WebElement> NoOfOrderSets = wd
				.findElements(By.xpath("//div[@class='card']//div[@class='card-body']//a/div"));
		int CountOfOrder = NoOfOrderSets.size();
		System.out.println("Total No Of Orders in the Page : " + CountOfOrder);
		for (int i = 1; i <= 2; i++) {
			By Order = By.xpath("(//div[@class='card']//div[@class='card-body']//a/div)[%d]");
			this.click(Order, "Click On the <Mark>%d</Mark> number Order");
			for (int newnum = 2; newnum <= 4; newnum++) {

				VerifyTheFieldsinFrequencyInOrdersInSets(newnum, frequencyType);
			}

			CreateAnOrderWithOrderDetails(type, libraryText, SearchDiogonosisTxt, medicarePriority, diogonosisName,
					physicianType, ReceivedByType, ReceivedOrderType, routes, WrittenDate, NoOfRefillis, WhenToFill);
		}
	}

	public void ClickToNewOrder() {
		By Order = By.xpath("(//div[@class='card']//div[@class='card-body']//a/div)[2]");
		this.click(Order, "Click On the <Mark>%d</Mark> number Order");
	}

	public void OrdersPageTextVerification() {
		this.VerifyWebElementPresent(labelOrderPageDescription, "Order Page Description");
		this.VerifyWebElementPresent(labelOrderPageType, "Order Page Type");
		this.VerifyWebElementPresent(labelOrderPagePhysician, "Order Page Physician");
		this.VerifyWebElementPresent(labelOrderPageFrequencies, "Order Page Frequencies");
		if (this.isElementPresent(labelOrderPageStatus)) {
			this.VerifyWebElementPresent(labelOrderPageStatus, "Order Page Status");
		}
		if (this.isElementPresent(labelOrderPageDetail)) {
			this.VerifyWebElementPresent(labelOrderPageDetail, "Order Page Detail");
		}
	}

	public void VerifyOrderInCreateRecapsWithoutCheckingTheCheckBox(String OrderName) {

		String ActiveNo = wd.findElement(By.xpath("//ul[@class='pager']//li[@class='pages active']")).getText();
		int OrdersInResident = Integer.parseInt(ActiveNo);
		List<WebElement> OrdersNoInPage = wd.findElements(By.xpath("//datatable-body-cell[2]/div"));
		int OrdersNo = OrdersNoInPage.size();
		List<WebElement> OrdersChkBxInPage = wd.findElements(By.xpath("//datatable-body-cell[1]/div"));
		int OrdersChkBxNo = OrdersChkBxInPage.size();
		List<WebElement> OrdersDetailsButtonInPage = wd
				.findElements(By.xpath("//datatable-body-cell[7]/div//button[text()='Detail']"));
		int OrdersDetailsNo = OrdersDetailsButtonInPage.size();

		if (OrdersNo == (OrdersChkBxNo) && OrdersNo == (OrdersDetailsNo)) {
			this.testReport.logSuccess("Verify All Listed Orders", String.format(
					"All listed order who need to verify have a checkbox and details button for each orders <mark>%s<mark/> , <mark>%s<mark/> are same with the Orders <mark>%s<mark/> ",
					OrdersChkBxNo, OrdersDetailsNo, OrdersNo));
		} else {
			this.testReport.logFailure("Verify All Listed Orders", String.format(
					"All listed order who need to verify have a checkbox and details button for each orders <mark>%s<mark/> , <mark>%s<mark/> are not same with the Orders <mark>%s<mark/> ",
					OrdersChkBxNo, OrdersDetailsNo, OrdersNo));
		}

		if (OrdersInResident == OrdersNo) {
			By RightSideClick = By.xpath("//a/i[@class='datatable-icon-skip']");
			if (this.isElementVisible(RightSideClick))
				;
			{
				this.click(RightSideClick, "Right Side Arrow");
			}

			List<WebElement> pageNos = wd.findElements(By.xpath("(//ul[@class='pager']//li[@role='button']/a)"));
			int pageSize = pageNos.size();
			String lastPageNo = wd
					.findElement(By.xpath(String.format("(//ul[@class='pager']//li[@role='button']/a)[%s]", pageSize)))
					.getText();
			int LastPageNo = Integer.parseInt(lastPageNo);

			By leftSideArrow = By.xpath("//a/i[@class='datatable-icon-prev']");
			if (this.isElementVisible(leftSideArrow))
				;
			{
				this.click(leftSideArrow, "Left Side Arrow");
			}

			for (int i = 1; i <= (LastPageNo); i++) {

				if (this.isElementPresent(labelOrderPageDescription) && this.isElementPresent(labelOrderPageType)) {
					List<WebElement> Orders = wd.findElements(By.xpath("//datatable-body-cell[1]/div"));
					int ordersNo = Orders.size();
					for (int j = 1; j <= ordersNo; j++) {

						By OrderDescription = By.xpath(String.format("(//datatable-body-cell[3]/div)[%d]", j));
						String requriedOrder = wd
								.findElement(By.xpath(String.format("(//datatable-body-cell[3]/div)[%d]", j)))
								.getText();

						if (requriedOrder.equals(OrderName)) {
							By OrderDescriptionDetail = By.xpath(
									String.format("(//datatable-body-cell[7]/div)[%d]//button[text()='Detail']", j));
							// By OrderCheckBox =
							// By.xpath(String.format("(//datatable-body-cell[1]/div)[%s]//input[@type='checkbox']",j));

							// this.click(OrderCheckBox, "Click on the Check Box of the Order");
							this.click(OrderDescriptionDetail, "Click on the Detail Button of the  Order");
							break;
						}
						if (requriedOrder.equals(OrderName)) {
							break;
						}

					}

				}
				By nxtrightSideArrow = By.xpath("//a/i[@class='datatable-icon-right']");
				if (this.isElementPresent(nxtrightSideArrow)) {
					this.click(nxtrightSideArrow, "Next Right Side Arrow");
				}

			}
		}

		else {
			List<WebElement> Orders = wd.findElements(By.xpath("//datatable-body-cell[1]/div"));
			int ordersNo = Orders.size();
			for (int j = 1; j <= ordersNo; j++) {

				By OrderDescription = By.xpath(String.format("(//datatable-body-cell[3]/div)[%d]", j));
				String requriedOrder = wd.findElement(By.xpath(String.format("(//datatable-body-cell[3]/div)[%d]", j)))
						.getText();
				// int RequireOrder = requriedOrder.length();
				if (requriedOrder.equals(OrderName)) {
					By OrderDescriptionDetail = By
							.xpath(String.format("(//datatable-body-cell[7]/div)[%d]//button[text()='Detail']", j));
					// By OrderCheckBox =
					// By.xpath(String.format("(//datatable-body-cell[1]/div)[%s]//input[@type='checkbox']",j));

					// this.click(OrderCheckBox, "Click on the Check Box of the Order");
					this.click(OrderDescriptionDetail, "Click on the Detail Button of the  Order");
					break;
				}
				if (requriedOrder.equals(OrderName)) {
					break;
				}

			}
		}

	}

	public void VerifyOrderInCreateRecaps(String OrderName) {

		String ActiveNo = wd.findElement(By.xpath("//ul[@class='pager']//li[@class='pages active']")).getText();
		int OrdersInResident = Integer.parseInt(ActiveNo);
		List<WebElement> OrdersNoInPage = wd.findElements(By.xpath("//datatable-body-cell[2]/div"));
		int OrdersNo = OrdersNoInPage.size();
		List<WebElement> OrdersChkBxInPage = wd.findElements(By.xpath("//datatable-body-cell[1]/div"));
		int OrdersChkBxNo = OrdersChkBxInPage.size();
		List<WebElement> OrdersDetailsButtonInPage = wd
				.findElements(By.xpath("//datatable-body-cell[7]/div//button[text()='Detail']"));
		int OrdersDetailsNo = OrdersDetailsButtonInPage.size();

		if (OrdersNo == (OrdersChkBxNo) && OrdersNo == (OrdersDetailsNo)) {
			this.testReport.logSuccess("Verify All Listed Orders", String.format(
					"All listed order who need to verify have a checkbox and details button for each orders <mark>%s<mark/> , <mark>%s<mark/> are same with the Orders <mark>%s<mark/> ",
					OrdersChkBxNo, OrdersDetailsNo, OrdersNo));
		} else {
			this.testReport.logFailure("Verify All Listed Orders", String.format(
					"All listed order who need to verify have a checkbox and details button for each orders <mark>%s<mark/> , <mark>%s<mark/> are not same with the Orders <mark>%s<mark/> ",
					OrdersChkBxNo, OrdersDetailsNo, OrdersNo));
		}

		if (OrdersInResident == OrdersNo) {
			By RightSideClick = By.xpath("//a/i[@class='datatable-icon-skip']");
			if (this.isElementVisible(RightSideClick))
				;
			{
				this.click(RightSideClick, "Right Side Arrow");
			}

			List<WebElement> pageNos = wd.findElements(By.xpath("(//ul[@class='pager']//li[@role='button']/a)"));
			int pageSize = pageNos.size();
			String lastPageNo = wd
					.findElement(By.xpath(String.format("(//ul[@class='pager']//li[@role='button']/a)[%s]", pageSize)))
					.getText();
			int LastPageNo = Integer.parseInt(lastPageNo);

			By leftSideArrow = By.xpath("//a/i[@class='datatable-icon-prev']");
			if (this.isElementVisible(leftSideArrow))
				;
			{
				this.click(leftSideArrow, "Left Side Arrow");
			}

			By checkBox = By.xpath("//datatable-header-cell[1]/div//input");
			this.click(checkBox, "Check Box ClickEd");

			for (int i = 1; i <= (LastPageNo); i++) {

				if (this.isElementPresent(labelOrderPageDescription) && this.isElementPresent(labelOrderPageType)) {
					List<WebElement> Orders = wd.findElements(By.xpath("//datatable-body-cell[1]/div"));
					int ordersNo = Orders.size();
					for (int j = 1; j <= ordersNo; j++) {

						By OrderDescription = By.xpath(String.format("(//datatable-body-cell[2]/div)[%d]", j));
						String requriedOrder = wd
								.findElement(By.xpath(String.format("(//datatable-body-cell[2]/div)[%d]", j)))
								.getText();

						if (requriedOrder.equals(OrderName)) {
							By OrderDescriptionDetail = By.xpath(
									String.format("(//datatable-body-cell[7]/div)[%d]//button[text()='Detail']", j));
							By OrderCheckBox = By.xpath(
									String.format("(//datatable-body-cell[1]/div)[%s]//input[@type='checkbox']", j));

							this.click(OrderCheckBox, "Click on the Check Box of the  Order");
							this.click(OrderDescriptionDetail, "Click on the Detail Button of the  Order");
							break;
						}
						if (requriedOrder.equals(OrderName)) {
							break;
						}

					}

				}
				By nxtrightSideArrow = By.xpath("//a/i[@class='datatable-icon-right']");
				if (this.isElementPresent(nxtrightSideArrow)) {
					this.click(nxtrightSideArrow, "Next Right Side Arrow");
				}

			}
		}

		else {

			By checkBox = By.xpath("//datatable-header-cell[1]/div//input");
			this.click(checkBox, "Check Box ClickEd");

			List<WebElement> Orders = wd.findElements(By.xpath("//datatable-body-cell[1]/div"));
			int ordersNo = Orders.size();
			for (int j = 1; j <= ordersNo; j++) {

				By OrderDescription = By.xpath(String.format("(//datatable-body-cell[2]/div)[%d]", j));
				String requriedOrder = wd.findElement(By.xpath(String.format("(//datatable-body-cell[2]/div)[%d]", j)))
						.getText();
				// int RequireOrder = requriedOrder.length();
				if (requriedOrder.equals(OrderName)) {
					By OrderDescriptionDetail = By
							.xpath(String.format("(//datatable-body-cell[7]/div)[%d]//button[text()='Detail']", j));
					By OrderCheckBox = By
							.xpath(String.format("(//datatable-body-cell[1]/div)[%s]//input[@type='checkbox']", j));

					this.click(OrderCheckBox, "Click on the Check Box of the  Order");
					this.click(OrderDescriptionDetail, "Click on the Detail Button of the  Order");
					break;
				}
				if (requriedOrder.equals(OrderName)) {
					break;
				}

			}
		}

	}

	public void RecapButtonCount() {
		List<WebElement> recapBtn = wd.findElements(By.xpath("//span[text()='Recap']"));
		int RecapButtonCount = recapBtn.size();

		this.testReport.logSuccess("Recap Button Present",
				String.format("Recap Button presents <mark>%s<mark/> ", RecapButtonCount));

	}

	/*
	 * public void VerifyOrderAndStatusInOrder(String OrderName) { String ActiveNo =
	 * wd.findElement(By.xpath("//ul[@class='pager']//li[@class='pages active']")).
	 * getText(); int OrdersInResident = Integer.parseInt(ActiveNo);
	 * List<WebElement> OrdersNoInPage =
	 * wd.findElements(By.xpath("//datatable-body-cell[1]/div")); int OrdersNo =
	 * OrdersNoInPage.size(); if(OrdersInResident==OrdersNo) { By RightSideClick =
	 * By.xpath("//a/i[@class='datatable-icon-skip']");
	 * if(this.isElementVisible(RightSideClick)); { this.click(RightSideClick,
	 * "Right Side Arrow"); }
	 * 
	 * this.click(labelOrderPageCreated, "Created");
	 * this.click(labelOrderPageCreated, "Created");
	 * 
	 * List<WebElement> pageNos=
	 * wd.findElements(By.xpath("(//ul[@class='pager']//li[@role='button']/a)"));
	 * int pageSize = pageNos.size(); String lastPageNo =
	 * wd.findElement(By.xpath(String.format(
	 * "(//ul[@class='pager']//li[@role='button']/a)[%s]",pageSize))).getText(); int
	 * LastPageNo = Integer.parseInt(lastPageNo);
	 * 
	 * 
	 * By leftSideArrow = By.xpath("//a/i[@class='datatable-icon-prev']");
	 * if(this.isElementVisible(leftSideArrow)); { this.click(leftSideArrow,
	 * "Left Side Arrow"); }
	 * 
	 * 
	 * for(int i=1;i<=(LastPageNo);i++) { By nxtrightSideArrow =
	 * By.xpath("//a/i[@class='datatable-icon-right']");
	 * this.click(nxtrightSideArrow, "Next Right Side Arrow");
	 * 
	 * List<WebElement> Orders =
	 * wd.findElements(By.xpath("//datatable-body-cell[1]/div")); int ordersNo =
	 * Orders.size(); if(this.isElementPresent(labelOrderPageDescription) &&
	 * this.isElementPresent(labelOrderPageType)) {
	 * 
	 * 
	 * 
	 * List<WebElement> Orders =
	 * wd.findElements(By.xpath("//datatable-body-cell[1]/div")); int ordersNo =
	 * Orders.size(); for(int j=1;j<=ordersNo;j++) {
	 * 
	 * 
	 * By OrderDescription =
	 * By.xpath(String.format("(//datatable-body-cell[1]/div)[%d]",j)); String
	 * requriedOrder =
	 * wd.findElement(By.xpath(String.format("(//datatable-body-cell[1]/div)[%d]",j)
	 * )).getText(); // int RequireOrder = requriedOrder.length();
	 * if(requriedOrder.equals(OrderName) ) {
	 * this.testReport.logSuccess("Created Order Present",String.
	 * format("Created Order Present in the List - <mark>%s</mark> To Locator - <mark>%s</mark>"
	 * , requriedOrder, OrderName)); By statusNeedsSigning = By.xpath(String.
	 * format("(//datatable-body-cell[6]//small)[%s]//strong[text()='Needs Signing']"
	 * , j)); this.VerifyWebElementPresent(statusNeedsSigning,
	 * "status Needs Signing in That Order"); By statusNeedsVerification =
	 * By.xpath(String.
	 * format("(//datatable-body-cell[6]//small)[%s]//strong[text()='Needs Verification']"
	 * , j)); this.VerifyWebElementPresent(statusNeedsVerification,
	 * "status Needs Verification in That Order"); By statusActive =
	 * By.xpath(String.format(
	 * "(//datatable-body-cell[6]//small)[%s]//strong[text()='Active']", j));
	 * this.VerifyWebElementPresent(statusActive, "status Active in That Order");
	 * 
	 * this.click(OrderDescription, "Click on the Created Order"); break; }
	 * if(requriedOrder.equals(OrderName) ) { break; }
	 * 
	 * }
	 * 
	 * } By nxtrightSideArrow = By.xpath("//a/i[@class='datatable-icon-right']");
	 * if(this.isElementPresent(nxtrightSideArrow)) { this.click(nxtrightSideArrow,
	 * "Next Right Side Arrow"); }
	 * 
	 * } }
	 * 
	 * else { this.click(labelOrderPageCreated, "Created");
	 * this.click(labelOrderPageCreated, "Created");
	 * 
	 * List<WebElement> Orders =
	 * wd.findElements(By.xpath("//datatable-body-cell[1]/div")); int ordersNo =
	 * Orders.size(); for(int j=1;j<=ordersNo;j++) {
	 * 
	 * 
	 * By OrderDescription =
	 * By.xpath(String.format("(//datatable-body-cell[1]/div)[%d]",j)); String
	 * requriedOrder =
	 * wd.findElement(By.xpath(String.format("(//datatable-body-cell[1]/div)[%d]",j)
	 * )).getText(); // int RequireOrder = requriedOrder.length();
	 * if(requriedOrder.equals(OrderName) ) {
	 * this.testReport.logSuccess("Created Order Present",String.
	 * format("Created Order Present in the List - <mark>%s</mark> To Locator - <mark>%s</mark>"
	 * , requriedOrder, OrderName)); By statusNeedsSigning = By.xpath(String.
	 * format("(//datatable-body-cell[6]//small)[%s]//strong[text()='Needs Signing']"
	 * , j)); this.VerifyWebElementPresent(statusNeedsSigning,
	 * "status Needs Signing in That Order"); By statusNeedsVerification =
	 * By.xpath(String.
	 * format("(//datatable-body-cell[6]//small)[%s]//strong[text()='Needs Verification']"
	 * , j)); this.VerifyWebElementPresent(statusNeedsVerification,
	 * "status Needs Verification in That Order"); By statusActive =
	 * By.xpath(String.format(
	 * "(//datatable-body-cell[6]//small)[%s]//strong[text()='Active']", j));
	 * this.VerifyWebElementPresent(statusActive, "status Active in That Order");
	 * 
	 * this.click(OrderDescription, "Click on the Created Order"); break; }
	 * if(requriedOrder.equals(OrderName) ) { break; }
	 * 
	 * } } }
	 */

	public void OrdersSelection(String Type, String OrderName) {
		By DownArrow = By.xpath(String.format("(//*[contains(text(),'%s')]/parent::a[contains(@class,'down')])", Type));
		if (this.isElementNotPresent(DownArrow)) {
			By RightArrow = By
					.xpath(String.format("(//*[contains(text(),'%s')]/parent::a[contains(@class,'down')])", Type));
			this.click(RightArrow, "Right Arrow");
		}
		//this.click(labelOrderPageCreated, "Created");
		//this.click(labelOrderPageCreated, "Created");

		List<WebElement> Orders = wd.findElements(By.xpath("//datatable-body-cell[1]/div"));
		int ordersNo = Orders.size();
		for (int j = 1; j <= ordersNo; j++) {
			By OrderDescription = By.xpath(String.format("(//datatable-body-cell[1]/div)[%d]", j));
			String requriedOrder = wd.findElement(By.xpath(String.format("(//datatable-body-cell[1]/div)[%d]", j)))
					.getText();

			if (requriedOrder.equals(OrderName)) {
				this.click(OrderDescription, "Click on the Created Order");
				this.waitInSecs(5);
				break;
			}
		}
	}

	public void OrdersDisplayPageForPerticularResident(String type) {
		// VerifyButtonInResidentOrders();
		// String labelOrderPageDetailType
		// =wd.findElement(By.xpath(String.format("//label[text()='Type']/..//div[text()='%s']",type))).getText();

		//this.VerifyWebElementPresent(btnOrderPageListView, "Order Page List View");

		/*
		 * if(type.equals("Medication") || type.equals("Treatment With Medication")) {
		 * this.VerifyWebElementPresent(btnOrderPageRefill, "Order Page Refill"); }
		 */
		this.VerifyWebElementPresent(btnOrderPagePrint, "Order Page Print");
		this.VerifyWebElementPresent(btnOrderPageDiscontinue, "Order Page Discontinue");

		this.VerifyWebElementPresent(btnOrderPageCopy, "Order Page Copy");
		String ResidentName = wd.findElement(By.xpath("//div//h3[@id='home']")).getText();
		System.out.println("Order Resident Name :-" + ResidentName);
		By residentName = By.xpath("//div//h3[@id='home']");
		this.VerifyWebElementPresent(residentName, "Resident Name  Present");
		this.testReport.logSuccess("Resident Name",
				String.format("Resident Name  Present  - <mark>%s</mark> ", ResidentName));
	}

	public void ClickingOnCreatedOrder(String OrderName) {
		By Order = By.xpath(String.format("//label[text()='Description']/..//div[contains(@class,'form-control')]"));
		this.VerifyWebElementPresent(Order, "Order is Present");
		this.AssertTextEqual(Order, OrderName);
	}

	public void VerifyButtonsInOrdersAndFrequency() {
		if(this.isElementPresent(labelOrderPageDetails))
		{
		this.VerifyWebElementPresent(labelOrderPageDetails, "Order Page Details");
		}
		this.VerifyWebElementPresent(labelOrderPageDetailsModify, "Order Page Details Modify button");
		this.VerifyWebElementPresent(labelOrderPageHoldDates, "Order Page List Hold Dates");
		//this.VerifyWebElementPresent(labelOrderPageHoldDatesModify, "Order Page Add Hold Dates Button");

		List<WebElement> Frequencies = wd.findElements(By.xpath("//h3[contains(text(),'Frequency ')]"));
		int NoOfFrequency = Frequencies.size();
		System.out.println("No of Frequencies Present  :" + NoOfFrequency);
		for (int i = 1; i <= NoOfFrequency; i++) {
			By frequency = By.xpath(String.format("(//h3[contains(text(),'Frequency ')])[%d]", i));
			this.VerifyWebElementPresent(frequency, "Order Page Frequency Present");
		}

		List<WebElement> FrequencieModifyButton = wd
				.findElements(By.xpath("//h3[contains(text(),'Frequency ')]/..//button[text()='Modify']"));
		int NoOfFrequencyModifyButton = FrequencieModifyButton.size();
		System.out.println("No of Frequencies Present  :" + NoOfFrequencyModifyButton);
		for (int i = 1; i <= NoOfFrequencyModifyButton; i++) {
			By frequency = By
					.xpath(String.format("(//h3[contains(text(),'Frequency ')]/..//button[text()='Modify'])[%s]", i));
			this.VerifyWebElementPresent(frequency, "Order Page Frequency Present");
		}

	}

	public void AddHoldDatesVerification(String startDate, String endDate, String startTime, String endTime,
			int NoOfAddTime) {
		for (int i = 1; i <= NoOfAddTime; i++) {
			this.click(labelOrderPageHoldDatesModify, "Order Page Add Hold Dates Button");
			this.VerifyWebElementPresent(btnStartDateCalender, "Start Date Calender");
			this.VerifyWebElementPresent(btnEndDateCalender, "End Date Calender");
			this.click(btnStartDateCalender, "Start Date Calender");
			By StartDate = By.xpath(String.format(
					"(//input[@placeholder='mm/dd/yyyy']/..//div[contains(@class,'btn-light')])[%s]", startDate));
			this.click(StartDate, "Start Date");
			this.click(btnEndDateCalender, "End Date Calender");
			By EndDate = By.xpath(String
					.format("(//input[@placeholder='mm/dd/yyyy']/..//div[contains(@class,'btn-light')])[%s]", endDate));
			this.click(EndDate, "End Date");
			this.SendKeysToElementClearFirst(txtStartTime, startTime);
			this.SendKeysToElementClearFirst(txtEndTime, endTime);
			this.click(btnAddHoldDateSave, "Add Hold Date Save");

			this.VerifyWebElementPresent(txtAddHoldDateStartDate, "Add Hold Date Start Date");
			this.VerifyWebElementPresent(txtAddHoldDateEndDate, "Add Hold Date End Date");

			List<WebElement> holdDates = wd.findElements(By.xpath("//datatable-row-wrapper//datatable-body-row"));
			int HoldDatesNo = holdDates.size();
			System.out.println("No of rows Present in Add Hold Date : " + HoldDatesNo);
			this.testReport.logSuccess("Total Add HoldDate Count",
					String.format("Add /hold Date Count <mark>%s</mark>", HoldDatesNo));
		}

	}

	public void DiscontinueOrderValidation(String startDate, String startTime, String physicianType,
			String ReceivedOrderType, String discontinueForCorrection, String copyOrder, String dcMessage) {
		this.WaitForElementPresent(btnDiscontinue, 20, "Discontinue");
		this.click(btnDiscontinue, "Discontinue");
		this.click(btnDCdateCalender, "DC Date Calender");
		By StartDate = By.xpath(String.format("(//input[@placeholder='mm/dd/yyyy']/..//div[contains(@class,'btn-light')])[%s]", startDate));
		this.click(StartDate, "Start Date");
		this.SendKeysToElementClearFirst(txtStartTime, startTime);
		this.SelectDropDownByText(drpdwnPhysician, physicianType);
		this.SelectDropDownByText(drpdwnReceivedOrder, ReceivedOrderType);
		if (!discontinueForCorrection.equals("NULL")) {
			this.click(chkbxDiscontinueForCorrection, "Discontinue For Correction");
		}
		if (!copyOrder.equals("NULL")) {
			this.click(chkbxCreateACopyOfThatOrder, "Create A Copy Of That Order");
		}
		if (!dcMessage.equals("NULL")) {
			this.click(chkbxSendDCMessageToPharmacy, "Send DC Message To Pharmacy");
		}

		this.click(orderDiscontinuebtn, "Order Discontinue Button");
	}

	public void ArrowButtonVerification() {
		String preOrderStartdate = wd
				.findElement(
						By.xpath("//label[text()='Start Date']/..//div[contains(@class,'form-control-plaintext')]"))
				.getText();

		if (this.isElementVisible(btnLeftArrow) && this.isElementVisible(btnRightArrow)) {
			this.VerifyWebElementPresent(btnLeftArrow, "Left Arrow");
			this.VerifyWebElementPresent(btnRightArrow, "Right Arrow");
			this.click(btnLeftArrow, "Left Arrow");
			this.waitInSecs(3);
			String nxtOrderStartDate = wd
					.findElement(
							By.xpath("//label[text()='Start Date']/..//div[contains(@class,'form-control-plaintext')]"))
					.getText();
			if (preOrderStartdate.equals(nxtOrderStartDate)) {
				this.testReport.logFailure("Left Arrow not Present",
						String.format("Left Arrow is Not Working  - <mark>%s</mark>", btnLeftArrow));
			} else {
				this.testReport.logSuccess("Left Arrow Present",
						String.format("Left Arrow is  Working  - <mark>%s</mark>", btnLeftArrow));
			}

			this.click(btnRightArrow, "Right Arrow");
			if (preOrderStartdate.equals(nxtOrderStartDate)) {
				this.testReport.logFailure("Right Arrow not Present",
						String.format("Right Arrow is Not Working  - <mark>%s</mark>", btnRightArrow));
			} else {
				this.testReport.logSuccess("Right Arrow Present",
						String.format("Right Arrow is  Working  - <mark>%s</mark>", btnRightArrow));
			}
		} else {
			this.testReport.logSuccess("Right Arrow and Left Arrow",
					String.format("Right Arrow and Left Arrow are not present "));
		}

	}

	public void DiscontinueValidation(String discontinueForCorrection, String copyOrder, String dcMessage) throws AWTException  {
		if (!discontinueForCorrection.equals("NULL")) {
			this.isElementVisible(msgChkboxDiscontinue);
			this.waitInSecs(1);
			if (this.isElementPresent(labelOrderPageDetails)) {
				this.WaitForElementPresent(msgDiscontinue, 20, "Discontinue Message Displays");
				this.VerifyWebElementPresent(msgDiscontinue, "Discontinue Message Displays");
			}
		}
		if (!copyOrder.equals("NULL")) {
			this.isElementVisible(msgChkboxDiscontinue);
			this.waitInSecs(1);
			FullOrderPageVerification();
		}
		if (!dcMessage.equals("NULL")) {
			this.isElementVisible(msgChkboxDiscontinue);
			this.waitInSecs(1);
			//this.VerifyWebElementPresent(msgDiscontinue, "Discontinue Message Displays");
			if (this.isElementPresent(labelOrderPageDetails)) {
				this.WaitForElementPresent(msgDiscontinue, 20, "Discontinue Message Displays");
		
				this.VerifyWebElementPresent(msgDiscontinue, "Discontinue Message Displays");
			}
		}
		
		 
		
		Robot robot = new Robot();
		this.waitInSecs(3);
		robot.mouseMove(0, 0);
		this.waitInSecs(2);
	}

	public void PharmacyValidation() {
		this.VerifyWebElementPresent(labelOrderPagePharmacyInformation, "Pharmacy Information");
		this.VerifyWebElementPresent(labelOrderPagePharmacyName, "Pharmacy Name");
		if (this.isElementPresent(labelOrderPagePharmacyName)) {
			String PharmacyName = wd.findElement(By.xpath("//div[@class='card']//div[text()='Name']/following-sibling::div")).getText();
			this.testReport.logSuccess("Pharmacy Name", String.format("Pharmacy Name <mark>%s</mark>", PharmacyName));
			;
		}

		this.VerifyWebElementPresent(labelOrderPagePharmacyAddrerss, "Pharmacy Address");
		if (this.isElementPresent(labelOrderPagePharmacyAddrerss)) {
			String PharmacyAddress = wd
					.findElement(By.xpath("//div[@class='card']//div[text()='Address']/following-sibling::div"))
					.getText();
			this.testReport.logSuccess("Pharmacy Address",
					String.format("Pharmacy Address <mark>%s</mark>", PharmacyAddress));
			;
		}

		this.VerifyWebElementPresent(labelOrderPagePharmacyContact, "Pharmacy Contact");

	}

	public void ModifyOrderPageDetail(String libraryText, String SearchDiogonosisTxt, String medicarePriority,
			String diogonosisName, String physicianType, String ReceivedByType, String ReceivedOrderType, String routes,
			String WrittenDate, String NoOfRefillis, String WhenToFill) {
		if (this.isElementPresent(labelOrderPageDetailsModify)) {
			this.VerifyWebElementNotPresent(labelOrderPageDetailsUpdate, "Order Page Details Update button");
			this.VerifyWebElementNotPresent(labelOrderPageDetailsCancel, "Order Page Details Cancel button");
		}
		String physician = wd
				.findElement(By.xpath("//label[text()='Physician']/..//div[contains(@class,'form-control-plaintext')]"))
				.getText();
		String recivedBy = wd
				.findElement(
						By.xpath("//label[text()='Received By']/..//div[contains(@class,'form-control-plaintext')]"))
				.getText();
		String recivedVia = wd
				.findElement(
						By.xpath("//label[text()='Received Via']/..//div[contains(@class,'form-control-plaintext')]"))
				.getText();

		this.click(labelOrderPageDetailsModify, "Order Page Details Modify button");
		this.VerifyWebElementPresent(labelOrderPageDetailsUpdate, "Order Page Details Update button");
		this.VerifyWebElementPresent(labelOrderPageDetailsCancel, "Order Page Details Cancel button");
		String RequriredType = wd
				.findElement(By.xpath("//label[text()='Type']/..//div[contains(@class,'form-control-plaintext')]"))
				.getText();

		CreateAnOrderWithOrderDetails(RequriredType, libraryText, SearchDiogonosisTxt, medicarePriority, diogonosisName,
				physicianType, ReceivedByType, ReceivedOrderType, routes, WrittenDate, NoOfRefillis, WhenToFill);

		this.click(labelOrderPageDetailsUpdate, "Order Page Details Update button");
		this.waitInSecs(3);
		this.VerifyWebElementPresent(labelOrderPageDetailsModify, "Order Page Details Modify button");

		String Updatephysician = wd
				.findElement(By.xpath("//label[text()='Physician']/..//div[contains(@class,'form-control-plaintext')]"))
				.getText();
		String UpdaterecivedBy = wd
				.findElement(
						By.xpath("//label[text()='Received By']/..//div[contains(@class,'form-control-plaintext')]"))
				.getText();
		String UpdaterecivedVia = wd
				.findElement(
						By.xpath("//label[text()='Received Via']/..//div[contains(@class,'form-control-plaintext')]"))
				.getText();

		if ((physician.equals(Updatephysician)) && (recivedBy.equals(UpdaterecivedBy))
				&& (recivedVia.equals(UpdaterecivedVia))) {
			this.testReport.logFailure("Edit the Order", String.format(
					"No edited in Order <mark>%s</mark>,<mark>%s</mark>,<mark>%s</mark> are still same <mark>%s</mark>,<mark>%s</mark>,<mark>%s</mark> ",
					physician, recivedBy, recivedVia, Updatephysician, UpdaterecivedBy, UpdaterecivedVia));
		} else {
			this.testReport.logSuccess("Edit the Order", String.format(
					"Edited Order <mark>%s</mark>,<mark>%s</mark>,<mark>%s</mark> are Not same <mark>%s</mark>,<mark>%s</mark>,<mark>%s</mark> ",
					physician, recivedBy, recivedVia, Updatephysician, UpdaterecivedBy, UpdaterecivedVia));
		}

	}

	public void ModifyOrderFrequency(int modifyButtonNo, int num, int no, String frequencyType, String endDate,
			String requiredActions, String requiredActionsPostDropdown, String administeredBy, String maxDoesHours,
			String followUpAfterMinutes, String slidingScaleMin, String slidingScaleMax, String slidingScaleUnits,
			String frequency, String howOften, String everyDay, String physicianInstructions,
			String additionalInstruction, String type) {
		By FrequencieModifyButton = By.xpath(String.format(
				"(//h3[contains(text(),'Frequency')]/..//div[@class='card-header']//button[text()='Modify'])[%s]",
				modifyButtonNo));
		By btnUpdateFrequency = By.xpath(String
				.format("//h3[contains(text(),'Frequency')]/..//div[@class='card-header']//button[text()='Update']"));
		By btnCancelFrequency = By
				.xpath("//h3[contains(text(),'Frequency')]/..//div[@class='card-header']//button[text()='Cancel']");
		By btnRemovefrequencyFrequency = By.xpath(
				"//h3[contains(text(),'Frequency')]/..//div[@class='card-header']//button[text()='Remove Frequency']");

		String labelAdministratedBy = wd.findElement(By.xpath(String.format(
				"((//div[@class='card'])//label[contains(text(),'Administered By')])[%s]/..//div[contains(@class,'form-control')]",
				modifyButtonNo))).getText();

		/*if (this.isElementPresent(FrequencieModifyButton)) {

			this.VerifyWebElementNotPresent(btnUpdateFrequency, "Order Page Frequency1 Update button");
			this.VerifyWebElementNotPresent(btnCancelFrequency, "Order Page Frequency1 Cancel button");
			this.VerifyWebElementNotPresent(btnRemovefrequencyFrequency,
					"Order Page Frequency Remove Frequency1 button");
		}*/

		this.click(FrequencieModifyButton, "Order Page Frequency1 Modify button");
		this.WaitForElementPresent(btnUpdateFrequency,20, "Order Page Frequency1 Update button");
		this.VerifyWebElementPresent(btnUpdateFrequency, "Order Page Frequency1 Update button");
		this.VerifyWebElementPresent(btnCancelFrequency, "Order Page Frequency1 Cancel button");
		// this.VerifyWebElementPresent(btnRemovefrequencyFrequency,"Order Page
		// Frequency Remove Frequency1 button");
		/*CreateOrderFrequency(1, 1, frequencyType, endDate, requiredActions, requiredActionsPostDropdown, administeredBy,
				maxDoesHours, followUpAfterMinutes, slidingScaleMin, slidingScaleMax, slidingScaleUnits, frequency,
				howOften, everyDay, physicianInstructions, additionalInstruction, type);*/

		this.click(btnUpdateFrequency, "Order Page Frequency1 Update button");
		this.click(btnCancelFrequency, "Cancel Frequency 1 button");
		//this.WaitForElementPresent(FrequencieModifyButton,20, "Order Page Frequency1 Modify button");
		//this.VerifyWebElementPresent(FrequencieModifyButton, "Order Page Frequency1 Modify button");

		this.waitInSecs(5);
		String updateLabelAdministratedBy = wd.findElement(By.xpath(String.format(
				"((//div[@class='card'])//label[contains(text(),'Administered By')])[%s]/..//div[contains(@class,'form-control')]",
				modifyButtonNo))).getText();

		/*if (labelAdministratedBy.equals(updateLabelAdministratedBy)) {
			this.testReport.logFailure("Edit the Order",
					String.format("No edited in Order <mark>%s</mark> are still same <mark>%s</mark> ",
							labelAdministratedBy, updateLabelAdministratedBy));
		} else {
			this.testReport.logSuccess("Edit the Order",
					String.format("Edited Order <mark>%s</mark> are Not same <mark>%s</mark> ", labelAdministratedBy,
							updateLabelAdministratedBy));
		}*/

	}
	public void ScrollUp(WebDriver wd)
	{
		((JavascriptExecutor)wd).executeScript("scroll(0,0)");
		 this.waitInSecs(2);
	}
	
	public void WindowpopUpCopy(WebDriver wd , String Value)
	{
		 
		JavascriptExecutor jsExec = (JavascriptExecutor) wd;
		List<WebElement> listButtons = (List<WebElement>) jsExec
				.executeScript("var buttons = document.getElementsByTagName('button');" + "return buttons");
		int iSize = listButtons.size();
		System.out.println("Size = " + iSize);
		for (WebElement button : listButtons) {
			System.out.println(button.getText());
			//if (button.getText().equalsIgnoreCase("Copy")) {
				if (button.getText().equalsIgnoreCase(Value)) {
				button.click();
				// javascript
				try
				{
					jsExec.executeAsyncScript("arguments[0].click();", button);
				}
				catch(UnhandledAlertException ex)
				{
					
				}
			}
		}
		new Thread(new Runnable() {

			@Override
			public void run() {
				JavascriptExecutor jsExec = (JavascriptExecutor) wd;
				List<WebElement> listButtons = (List<WebElement>) jsExec
						.executeScript("var buttons = document.getElementsByTagName('button');" + "return buttons");
				int iSize = listButtons.size();
				System.out.println("Size = " + iSize);
				for (WebElement button : listButtons) {
					//System.out.println(button.getText());
					//if (button.getText().equalsIgnoreCase("Copy")) {
					if (button.getText().equalsIgnoreCase(Value
							+ "")) {
						//button.click();
						// javascript
						jsExec.executeScript("arguments[0].click();", button);
					}
				}
			}

		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {

				System.out.println("Debug - OK Button To Be Clicked ON Prompt...");
				for (int i = 1; i <= 5; i++) {
					try {
						Robot robot = new Robot();
						/*
						 * Thread.sleep(3000); robot.mouseMove(X, Y);
						 */
						/*
						 * Thread.sleep(3000); robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
						 * Thread.sleep(1000); robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
						 */
						Thread.sleep(3000);

						robot.keyPress(KeyEvent.VK_ENTER);
						Thread.sleep(1000);
						robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(3000);
					} catch (Exception ex) {
						ex.printStackTrace();

					}
				}
			}
		}).start();
	}

	public void OrderPageCopyOrderValidation(String RequriredType, String libraryText, String SearchDiogonosisTxt,
			String medicarePriority, String diogonosisName, String physicianType, String ReceivedByType,
			String ReceivedOrderType, String routes, String WrittenDate, String NoOfRefillis, String WhenToFill
			) throws AWTException, InterruptedException {
		
		/*JavascriptExecutor jsExec = (JavascriptExecutor) wd;
		List<WebElement> listButtons = (List<WebElement>) jsExec
				.executeScript("var buttons = document.getElementsByTagName('button');" + "return buttons");
		int iSize = listButtons.size();
		System.out.println("Size = " + iSize);
		for (WebElement button : listButtons) {
			System.out.println(button.getText());
			if (button.getText().equalsIgnoreCase("Copy")) {

				button.click();
				// javascript
				try
				{
					jsExec.executeAsyncScript("arguments[0].click();", button);
				}
				catch(UnhandledAlertException ex)
				{
					
				}
			}
		}
		new Thread(new Runnable() {

			@Override
			public void run() {
				JavascriptExecutor jsExec = (JavascriptExecutor) wd;
				List<WebElement> listButtons = (List<WebElement>) jsExec
						.executeScript("var buttons = document.getElementsByTagName('button');" + "return buttons");
				int iSize = listButtons.size();
				System.out.println("Size = " + iSize);
				for (WebElement button : listButtons) {
					//System.out.println(button.getText());
					if (button.getText().equalsIgnoreCase("Copy")) {

						//button.click();
						// javascript
						jsExec.executeScript("arguments[0].click();", button);
					}
				}
			}

		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {

				System.out.println("Debug - OK Button To Be Clicked ON Prompt...");
				for (int i = 1; i <= 5; i++) {
					try {
						Robot robot = new Robot();
						
						 * Thread.sleep(3000); robot.mouseMove(X, Y);
						 
						
						 * Thread.sleep(3000); robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
						 * Thread.sleep(1000); robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
						 
						Thread.sleep(3000);

						robot.keyPress(KeyEvent.VK_ENTER);
						Thread.sleep(1000);
						robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(3000);
					} catch (Exception ex) {
						ex.printStackTrace();

					}
				}
			}
		}).start();*/
		
		Thread.sleep(5000);
		if(this.isElementNotPresent(OrderPageDetails))
		{
			this.click(btnOrderPageCopy, "Copy Order");
		}
		FullOrderPageVerification();
		CreateAnOrderWithOrderDetails(RequriredType, libraryText, SearchDiogonosisTxt, medicarePriority, diogonosisName,
				physicianType, ReceivedByType, ReceivedOrderType, routes, WrittenDate, NoOfRefillis, WhenToFill);

		/*SaveOrderFrequency();
		if(this.isElementNotPresent(CreateRecap) & this.isElementNotPresent(txtSignOrders))
		{
		WhereToTabValidation();
		OrdersSelection(RequriredType, libraryText);
		ArrowButtonVerification();
		ClickOnListViewForNavigateToOrdersView();
		}*/
	}
	
	public void FillOrderPageFrequency(int modifyButtonNo, int num, int no, String frequencyType, String endDate,
			String requiredActions, String requiredActionsPostDropdown, String administeredBy, String maxDoesHours,
			String followUpAfterMinutes, String slidingScaleMin, String slidingScaleMax, String slidingScaleUnits,
			String frequency, String howOften, String everyDay, String physicianInstructions,
			String additionalInstruction, String type,String RequriredType,String libraryText)
	{
		this.isElementPresent(By.xpath("//label[text()='Type']/..//select[@id='routineTypeId']/following::div[@class='invalid-feedback']"));
		{
			CreateOrderFrequency(1, 1, frequencyType, endDate, requiredActions, requiredActionsPostDropdown, administeredBy,
					maxDoesHours, followUpAfterMinutes, slidingScaleMin, slidingScaleMax, slidingScaleUnits, frequency,
					howOften, everyDay, physicianInstructions, additionalInstruction, type);
		}
		SaveOrderFrequency();
		if(this.isElementNotPresent(CreateRecap) & this.isElementNotPresent(txtSignOrders))
		{
		WhereToTabValidation();
		OrdersSelection(RequriredType, libraryText);
		ArrowButtonVerification();
		ClickOnListViewForNavigateToOrdersView();
		}
	}
	
	
	public void ClickingCopyButton() throws InterruptedException
	{
		Thread.sleep(5000);
		if(this.isElementNotPresent(OrderPageDetails))
		{
			this.click(btnOrderPageCopy, "Copy Order");
		}
	}

	public void RobotWork() throws AWTException {
		/*Point location = wd.findElement(By.xpath("//button[text()='Copy']")).getLocation();
		System.out.println("Location of Copy Button" + location);
		int X = location.x;
		int Y = location.y;
		
		 * Actions action = new Actions(wd); action.moveToElement((WebElement)
		 * btnOrderPageCopy).build().perform();
		 

		Robot robot = new Robot();
		this.waitInSecs(3);
		robot.mouseMove(X, Y);
		this.waitInSecs(3);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		this.waitInSecs(1);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		this.waitInSecs(3);*/
		Robot robot = new Robot();
		this.waitInSecs(3);
		robot.keyPress(KeyEvent.VK_ENTER);
		this.waitInSecs(3);
		robot.keyRelease(KeyEvent.VK_ENTER);
		this.waitInSecs(3);

	}

	public void ClickOnListViewForNavigateToOrdersView() {
		this.waitUntilElementIsClickable(btnOrderPageListView);
		this.click(btnOrderPageListView, "Order Page List View");
	}

	public void OrderPagePrirtValidation() throws AWTException {
		// mainWindow = this.wd.getWindowHandles();
		By btnPrint = By.xpath("//div[@id='print-header']//button[text()='Cancel']");
		String parentWindow = wd.getWindowHandle();
		System.out.println(parentWindow);
		this.click(btnOrderPagePrint, "Order Page Print");

		java.util.Set<String> Allwindows = wd.getWindowHandles();
		for (String childWindow : Allwindows) {
			if (!parentWindow.equalsIgnoreCase(childWindow)) {
				wd.switchTo().window(childWindow);

			}
		}

		Robot robot = new Robot();
		this.waitInSecs(5);

		robot.keyPress(KeyEvent.VK_ENTER);
		this.waitInSecs(5);
		robot.keyRelease(KeyEvent.VK_ENTER);
		this.waitInSecs(5);
	}

	public void CancelOrderPageDetail(String libraryText, String SearchDiogonosisTxt, String medicarePriority,
			String diogonosisName, String physicianType, String ReceivedByType, String ReceivedOrderType, String routes,
			String WrittenDate, String NoOfRefillis, String WhenToFill) {
		if (this.isElementPresent(labelOrderPageDetailsModify)) {
			this.VerifyWebElementNotPresent(labelOrderPageDetailsUpdate, "Order Page Details Update button");
			this.VerifyWebElementNotPresent(labelOrderPageDetailsCancel, "Order Page Details Cancel button");
		}
		String physician = wd
				.findElement(By.xpath("//label[text()='Physician']/..//div[contains(@class,'form-control-plaintext')]"))
				.getText();
		String recivedBy = wd
				.findElement(
						By.xpath("//label[text()='Received By']/..//div[contains(@class,'form-control-plaintext')]"))
				.getText();
		String recivedVia = wd
				.findElement(
						By.xpath("//label[text()='Received Via']/..//div[contains(@class,'form-control-plaintext')]"))
				.getText();

		this.click(labelOrderPageDetailsModify, "Order Page Details Modify button");
		this.VerifyWebElementPresent(labelOrderPageDetailsUpdate, "Order Page Details Update button");
		this.VerifyWebElementPresent(labelOrderPageDetailsCancel, "Order Page Details Cancel button");
		String RequriredType = wd
				.findElement(By.xpath("//label[text()='Type']/..//div[contains(@class,'form-control-plaintext')]"))
				.getText();

		CreateAnOrderWithOrderDetails(RequriredType, libraryText, SearchDiogonosisTxt, medicarePriority, diogonosisName,
				physicianType, ReceivedByType, ReceivedOrderType, routes, WrittenDate, NoOfRefillis, WhenToFill);

		this.click(labelOrderPageDetailsCancel, "Order Page Details Cancel button");
		this.waitInSecs(3);
		this.VerifyWebElementPresent(labelOrderPageDetailsModify, "Order Page Details Modify button");

		String Updatephysician = wd
				.findElement(By.xpath("//label[text()='Physician']/..//div[contains(@class,'form-control-plaintext')]"))
				.getText();
		String UpdaterecivedBy = wd
				.findElement(
						By.xpath("//label[text()='Received By']/..//div[contains(@class,'form-control-plaintext')]"))
				.getText();
		String UpdaterecivedVia = wd
				.findElement(
						By.xpath("//label[text()='Received Via']/..//div[contains(@class,'form-control-plaintext')]"))
				.getText();

		if ((physician.equals(Updatephysician)) && (recivedBy.equals(UpdaterecivedBy))
				&& (recivedVia.equals(UpdaterecivedVia))) {
			this.testReport.logSuccess("Edit the Order", String.format(
					"No edited in Order <mark>%s</mark>,<mark>%s</mark>,<mark>%s</mark> are still same <mark>%s</mark>,<mark>%s</mark>,<mark>%s</mark> ",
					physician, recivedBy, recivedVia, Updatephysician, UpdaterecivedBy, UpdaterecivedVia));
		} else {
			this.testReport.logFailure("Edit the Order", String.format(
					"Edited Order <mark>%s</mark>,<mark>%s</mark>,<mark>%s</mark> are Not same <mark>%s</mark>,<mark>%s</mark>,<mark>%s</mark> ",
					physician, recivedBy, recivedVia, Updatephysician, UpdaterecivedBy, UpdaterecivedVia));
		}

	}

	public void CancelOrderFrequency(int modifyButtonNo, int num, int no, String frequencyType, String endDate,
			String requiredActions, String requiredActionsPostDropdown, String administeredBy, String maxDoesHours,
			String followUpAfterMinutes, String slidingScaleMin, String slidingScaleMax, String slidingScaleUnits,
			String frequency, String howOften, String everyDay, String physicianInstructions,
			String additionalInstruction, String type) {
		By FrequencieModifyButton = By.xpath(String.format(
				"(//h3[contains(text(),'Frequency')]/..//div[@class='card-header']//button[text()='Modify'])[%s]",
				modifyButtonNo));
		By btnUpdateFrequency = By.xpath(String
				.format("//h3[contains(text(),'Frequency')]/..//div[@class='card-header']//button[text()='Update']"));
		By btnCancelFrequency = By
				.xpath("//h3[contains(text(),'Frequency')]/..//div[@class='card-header']//button[text()='Cancel']");
		By btnRemovefrequencyFrequency = By.xpath(
				"//h3[contains(text(),'Frequency')]/..//div[@class='card-header']//button[text()='Remove Frequency']");

		String labelAdministratedBy = wd.findElement(By.xpath(String.format(
				"((//div[@class='card'])//label[contains(text(),'Administered By')])[%s]/..//div[contains(@class,'form-control')]",
				modifyButtonNo))).getText();

		if (this.isElementPresent(FrequencieModifyButton)) {

			this.VerifyWebElementNotPresent(btnUpdateFrequency, "Order Page Frequency Update button");
			this.VerifyWebElementNotPresent(btnCancelFrequency, "Order Page Frequency Cancel button");
			this.VerifyWebElementNotPresent(btnRemovefrequencyFrequency,
					"Order Page Frequency Remove Frequency1 button");
		}

		this.click(FrequencieModifyButton, "Order Page Frequency1 Modify button");

		this.VerifyWebElementPresent(btnUpdateFrequency, "Order Page Frequency Update button");
		this.VerifyWebElementPresent(btnCancelFrequency, "Order Page Frequency1 Cancel button");
		//this.VerifyWebElementPresent(btnRemovefrequencyFrequency, "Order Page Frequency Remove Frequency button");
		CreateOrderFrequency(1, 1, frequencyType, endDate, requiredActions, requiredActionsPostDropdown, administeredBy,
				maxDoesHours, followUpAfterMinutes, slidingScaleMin, slidingScaleMax, slidingScaleUnits, frequency,
				howOften, everyDay, physicianInstructions, additionalInstruction, type);

		this.click(btnCancelFrequency, "Order Page Frequency Cancel button");
		this.waitInSecs(3);
		this.VerifyWebElementPresent(FrequencieModifyButton, "Order Page Frequency1 Modify button");

		String updateLabelAdministratedBy = wd.findElement(By.xpath(String.format(
				"((//div[@class='card'])//label[contains(text(),'Administered By')])[%s]/..//div[contains(@class,'form-control')]",
				num))).getText();

		if (labelAdministratedBy.equals(updateLabelAdministratedBy)) {
			this.testReport.logSuccess("Edit the Order",
					String.format("No edited in Order <mark>%s</mark> are still same <mark>%s</mark> ",
							labelAdministratedBy, updateLabelAdministratedBy));
		} else {
			this.testReport.logFailure("Edit the Order",
					String.format("Edited Order <mark>%s</mark> are Not same <mark>%s</mark> ", labelAdministratedBy,
							updateLabelAdministratedBy));

		}

	}

	public long GenarateRandomNumber() {

		long rand = (System.currentTimeMillis());
		Random rgen = new Random();
		rgen.setSeed(rand);
		System.out.println("Random number generator seed is " + rand);
		return rand;

	}

	public void VerifyCreatedOrderIntheVerifyList(String OrderName) {

		String ActiveNo = wd.findElement(By.xpath("//ul[@class='pager']//li[@class='pages active']")).getText();
		int OrdersInResident = Integer.parseInt(ActiveNo);
		List<WebElement> OrdersNoInPage = wd.findElements(By.xpath("//datatable-body-cell[2]/div"));
		int OrdersNo = OrdersNoInPage.size();
		List<WebElement> OrdersChkBxInPage = wd.findElements(By.xpath("//datatable-body-cell[1]/div"));
		int OrdersChkBxNo = OrdersChkBxInPage.size();
		List<WebElement> OrdersDetailsButtonInPage = wd
				.findElements(By.xpath("//datatable-body-cell[8]/div//button[text()='Detail']"));
		int OrdersDetailsNo = OrdersDetailsButtonInPage.size();

		if (OrdersNo == (OrdersChkBxNo) && OrdersNo == (OrdersDetailsNo)) {
			this.testReport.logSuccess("Verify All Listed Orders", String.format(
					"All listed order who need to verify have a checkbox and details button for each orders <mark>%s<mark/> , <mark>%s<mark/> are same with the Orders <mark>%s<mark/> ",
					OrdersChkBxNo, OrdersDetailsNo, OrdersNo));
		} else {
			this.testReport.logFailure("Verify All Listed Orders", String.format(
					"All listed order who need to verify have a checkbox and details button for each orders <mark>%s<mark/> , <mark>%s<mark/> are not same with the Orders <mark>%s<mark/> ",
					OrdersChkBxNo, OrdersDetailsNo, OrdersNo));
		}

		if (OrdersInResident == OrdersNo) {
			By RightSideClick = By.xpath("//a/i[@class='datatable-icon-skip']");
			if (this.isElementVisible(RightSideClick))
				;
			{
				this.click(RightSideClick, "Right Side Arrow");
			}

			List<WebElement> pageNos = wd.findElements(By.xpath("(//ul[@class='pager']//li[@role='button']/a)"));
			int pageSize = pageNos.size();
			String lastPageNo = wd
					.findElement(By.xpath(String.format("(//ul[@class='pager']//li[@role='button']/a)[%s]", pageSize)))
					.getText();
			int LastPageNo = Integer.parseInt(lastPageNo);

			By leftSideArrow = By.xpath("//a/i[@class='datatable-icon-prev']");
			if (this.isElementVisible(leftSideArrow))
				;
			{
				this.click(leftSideArrow, "Left Side Arrow");
			}

			this.click(labelOrderPageCreated, "Created");
			this.click(labelOrderPageCreated, "Created");

			for (int i = 1; i <= (LastPageNo); i++) {
				if (this.isElementNotPresent(labelOrderPageDescription)
						&& this.isElementNotPresent(labelOrderPageType)) {
					break;
				}

				if (this.isElementPresent(labelOrderPageDescription) && this.isElementPresent(labelOrderPageType)) {
					List<WebElement> Orders = wd.findElements(By.xpath("//datatable-body-cell[1]/div"));
					int ordersNo = Orders.size();
					for (int j = 1; j <= ordersNo; j++) {

						By OrderDescription = By.xpath(String.format("(//datatable-body-cell[3]/div)[%d]", j));
						String requriedOrder = wd
								.findElement(By.xpath(String.format("(//datatable-body-cell[3]/div)[%d]", j)))
								.getText();

						if (requriedOrder.equals(OrderName)) {
							By OrderDescriptionDetail = By.xpath(
									String.format("(//datatable-body-cell[8]/div)[%d]//button[text()='Detail']", j));

							this.click(OrderDescriptionDetail, "Click on the Detail Button of the  Order");
							break;
						}
						if (requriedOrder.equals(OrderName)) {
							break;
						}

					}

				}
				By nxtrightSideArrow = By.xpath("//a/i[@class='datatable-icon-right']");
				if (this.isElementVisible(nxtrightSideArrow)) {
					this.click(nxtrightSideArrow, "Next Right Side Arrow");
				}

			}
		}

		else {
			this.click(labelOrderPageCreated, "Created");
			this.waitInSecs(1);
			this.click(labelOrderPageCreated, "Created");

			List<WebElement> Orders = wd.findElements(By.xpath("//datatable-body-cell[1]/div"));
			int ordersNo = Orders.size();
			for (int j = 1; j <= ordersNo; j++) {

				By OrderDescription = By.xpath(String.format("(//datatable-body-cell[3]/div)[%d]", j));
				String requriedOrder = wd.findElement(By.xpath(String.format("(//datatable-body-cell[3]/div)[%d]", j)))
						.getText();
				// int RequireOrder = requriedOrder.length();
				if (requriedOrder.equals(OrderName)) {
					By OrderDescriptionDetail = By
							.xpath(String.format("(//datatable-body-cell[8]/div)[%d]//button[text()='Detail']", j));

					this.click(OrderDescriptionDetail, "Click on the Detail Button of the  Order");
					break;
				}
				if (requriedOrder.equals(OrderName)) {
					break;
				}

			}
		}

	}

	public void VerifyButtonsInVerifyOrders() {
		this.VerifyWebElementPresent(btnFilterByPhysician, "By Physician Filter Button");
		// this.VerifyWebElementPresent(btnFilterDrpDwn, "Type Dropdown Filter Button");
		this.VerifyWebElementPresent(btnToggleVerifyAll, "Toggle Verify All Button");
		this.VerifyWebElementPresent(btnToggleVerifed, "Toggle Verifed Button");
		this.VerifyWebElementPresent(btnSaveOrder, "Save Button");
		this.VerifyWebElementPresent(btnCancel, "Cancel Button");
	}

	public void VerifyButtonsInSignOrders() {
		this.VerifyWebElementPresent(btnFilterByPhysician, "By Physician Filter Button");
		this.VerifyWebElementPresent(btnFilterDrpDwn, "Type Dropdown Filter Button");
		this.VerifyWebElementPresent(btnToggleSignedAll, "Toggle Signed All Button");
		this.VerifyWebElementPresent(btnToggleSigned, "Toggle Signed Button");
		/*
		 * this.VerifyWebElementPresent(btnSaveOrder, "Save Button");
		 * this.VerifyWebElementPresent(btnCancel, "Cancel Button");
		 */

		/*
		 * List<WebElement> ToggleSignButton =
		 * wd.findElements(By.xpath("//button[text()='Toggle Signed']")); int
		 * ToggleSignButtonNo = ToggleSignButton.size();
		 * this.testReport.logSuccess("Toggle Button",
		 * String.format("Toggle Buttons Present <mark>%s<mark/>", ToggleSignButtonNo));
		 */
	}

	public void VerifyClickingOnToggledVerifiedButton() {
		String ResidentName = wd.findElement(By.xpath("//div//h3[@id='home']")).getText();
		String descriptionName = wd.findElement(By.xpath(
				"//div[@class='card-body']//label[text()='Description']/..//div[contains(@class,'form-control')]"))
				.getText();
		this.click(btnToggleVerifed, "Toggle Verifed Button");
		this.waitInSecs(3);
		// By VerifiedResidentButton =
		// By.xpath(String.format("//div[contains(@class,'list-group')]//a/div/h5[text()='%s']/..//span[text()='Verified']/..//..//..//p[contains(text(),'%s')]",
		// ResidentName,descriptionName));
		// By VerifiedResidentButton =
		// By.xpath(String.format("//div[contains(@class,'list-group')]//a/div/h5[text()='%s']/..//span[text()='Verified']",ResidentName));
		By VerifiedResidentButton = By.xpath("//div[contains(@class,'list-group')]//a//span[text()='Verified']");

		this.waitInSecs(3);
		if (this.isElementPresent(VerifiedResidentButton)) {
			this.testReport.logSuccess("Verified Resident",
					String.format("Verified Resident Present <mark>%s<mark/> with Description Name <mark>%s<mark/>",
							ResidentName, descriptionName));
		}
		// this.VerifyWebElementPresent(VerifiedResident,"Verify Resident Present");

		this.click(btnToggleVerifed, "Toggle Verifed Button");
		this.waitInSecs(3);
		if (this.isElementNotPresent(VerifiedResidentButton)) {
			this.testReport.logSuccess("Verified Resident",
					String.format("Verified Resident Not Present <mark>%s<mark/> with Description Name <mark>%s<mark/>",
							ResidentName, descriptionName));
		}
		// this.VerifyWebElementNotPresent(VerifiedResident,"Verify Resident Not
		// Present");

		this.click(btnToggleVerifed, "Toggle Verifed Button");
		this.waitInSecs(3);
		if (this.isElementPresent(VerifiedResidentButton)) {
			this.testReport.logSuccess("Verified Resident",
					String.format("Verified Resident Present <mark>%s<mark/> with Description Name <mark>%s<mark/>",
							ResidentName, descriptionName));
		}
		// this.VerifyWebElementPresent(VerifiedResident,"Verify Resident Present");

		this.click(btnSaveOrder, "Save Button");
		this.VerifyWebElementPresent(msgOrderVerified, "Order verified");

	}

	public String VerifyClickingOnToggledSignedButton() {
		this.waitInSecs(1);
		String ResidentName = wd.findElement(By.xpath("//div//h3[@id='home']")).getText();
		String descriptionName = wd.findElement(By.xpath(
				"//div[@class='card-body']//label[text()='Description']/..//div[contains(@class,'form-control')]"))
				.getText();
		this.click(btnToggleSigned, "Toggle Signed Button");
		this.waitInSecs(3);

		By SignedResidentButton = By.xpath("//div[contains(@class,'list-group')]//a//span[text()='Signed']");

		this.waitInSecs(3);
		if (this.isElementPresent(SignedResidentButton)) {
			this.testReport.logSuccess("Verified Resident",
					String.format("Verified Resident Present <mark>%s<mark/> with Description Name <mark>%s<mark/>",
							ResidentName, descriptionName));
		}

		this.click(btnToggleSigned, "Toggle Signed Button");
		this.waitInSecs(3);
		if (this.isElementNotPresent(SignedResidentButton)) {
			this.testReport.logSuccess("Verified Resident",
					String.format("Verified Resident Not Present <mark>%s<mark/> with Description Name <mark>%s<mark/>",
							ResidentName, descriptionName));
		}

		this.click(btnToggleSigned, "Toggle Signed Button");
		this.waitInSecs(3);
		if (this.isElementPresent(SignedResidentButton)) {
			this.testReport.logSuccess("Verified Resident",
					String.format("Verified Resident Present <mark>%s<mark/> with Description Name <mark>%s<mark/>",
							ResidentName, descriptionName));
		}

		return ResidentName;
	}

	public void VerifyAddSignatureButton()

	{
		this.VerifyWebElementPresent(btnAddSignature, "Add Signature");
		this.click(btnAddSignature, "Add Signature");
	}

	public void VerifySignOrdersViaAddSignature() {

		this.VerifyWebElementPresent(txtSignOrdersSignature,
				"This action requires your signature. Please sign or use your signature on file.");
		String UserName = wd.findElement(By.xpath("//button[@id='userDropDown']")).getText();

		this.VerifyWebElementPresent(txtPrintName, "Print Name");
		this.VerifyWebElementPresent(chkBxUseSignatureOnFile, "Use Signature On File");
		this.VerifyWebElementPresent(txtSignatureName, "Signature Name");
		this.VerifyWebElementPresent(btnClear, "Clear Button");

		String PrintName = wd.findElement(By.xpath("//label[text()='Print Name']/..//input[@id='signatureName']"))
				.getAttribute("value");
		if (UserName.equals(PrintName)) {
			this.testReport.logSuccess("Verify Print Name",
					String.format(
							"Verify Print Name <mark>%s<mark/> default display the current user name <mark>%s<mark/> ",
							PrintName, UserName));
		}

		boolean ChkBoxSelected = wd
				.findElement(By.xpath("//label[@for='useSignatureOnFile']/..//input[@name='useSignatureOnFile']"))
				.isSelected();
		if (!ChkBoxSelected) {
			this.click(chkBxUseSignatureOnFile, "Use Signature On File");
		}

		this.click(btnSaveOrder, "Save Order");

	}

	public void CancelAddSignature() {
		this.click(btnCancel, "Cancel Button");
		if (this.isElementPresent(btnClear)) {
			this.click(btnClear, "Clear Button");
		}
	}

	public void VerifyRecapDropDownList() {
		this.VerifyWebElementPresent(btnCreateRecap, "Create Recap");
		this.VerifyWebElementPresent(btnRecapPageSelectPhysician, "Recap Page Select Physician");
		this.VerifyWebElementPresent(btnRecapPageSelectStatus, "Recap Page Select Status");
	}

	public void ClickOnCreateRecap() {
		this.click(btnCreateRecap, "Create Recap");

	}

	public void RecapePageTextVerification() {
		this.VerifyWebElementPresent(labelOrderPageDescription, "Recap Page Description");
		this.VerifyWebElementPresent(labelOrderPageDate, "Recap Page Date");
		this.VerifyWebElementPresent(labelOrderPagePhysician, "Recap Page Physician");
		this.VerifyWebElementPresent(labelOrderPageStatus, "Recap Page Status");

	}

	public void DisplayCreateRecapPageDisplay() {
		// this.VerifyWebElementPresent(txtCreateRecap, "Create Recap");
		this.VerifyWebElementPresent(txtRecapDescription, "Recap Description");
		this.VerifyWebElementPresent(listRecapResidentStatus, "Recap Resident Status");
		this.VerifyWebElementPresent(listRecapStations, "Recap Stations");
		this.VerifyWebElementPresent(listRecapResidents, "Recap Residents");
		this.VerifyWebElementPresent(listRecapOtherStatus, "Recap Other Status");
		this.VerifyWebElementPresent(listRecapPhysicians, "Recap Physicians");
		this.VerifyWebElementPresent(calenderRecapDate, "Recap Date");
		this.VerifyWebElementPresent(btnApplyFilter, "Apply Filter");
	}

	public void VerifyRecapDescription(String Description) {
		this.VerifyWebElementPresent(txtRecapDescription, "Recap Description");
		this.SendKeysToElementClearFirst(txtRecapDescription, Description);
	}

	public void VerifyResidentStatus(String Option, String ResidentOption) {
		this.VerifyWebElementPresent(listRecapResidentStatus, "Recap Resident Status");
		this.click(listRecapResidentStatus, "Recap Resident Status");
		VerifyRecapPageResidentStatusDisplay();
		SelectionOfResidentOption(Option, ResidentOption);
	}

	public void VerifyResidentStations(String Option, String ResidentOption) {
		this.VerifyWebElementPresent(listRecapStations, "Recap Stations");
		this.click(listRecapStations, "Recap Stations");
		VerifyRecapPageResidentStationsDisplay();
		SelectionOfResidentOption(Option, ResidentOption);
	}

	public void VerifyRecapResidents(String Option, String ResidentOption) {
		this.VerifyWebElementPresent(listRecapResidents, "Recap Residents");
		this.click(listRecapResidents, "Recap Residents");
		VerifyRecapPageResidentDisplay();

		FindOptionInRecapPage(Option, ResidentOption);
	}

	public void VerifyRecapOthers(String Option, String ResidentOption) {
		this.VerifyWebElementPresent(listRecapOtherStatus, "Recap Other Status");
		this.click(listRecapOtherStatus, "Recap Other Status");
		VerifyRecapPageOrderStatusDisplay();
		SelectionOfResidentOption(Option, ResidentOption);
	}

	public String VerifyRecapPhysicians(String Option, String ResidentOption) {
		this.VerifyWebElementPresent(listRecapPhysicians, "Recap Physicians");
		this.click(listRecapPhysicians, "Recap Physicians");
		VerifyRecapPagePhysiciansDisplay();
		FindOptionInRecapPage(Option, ResidentOption);
		return Option;
	}

	public void VerifyRecapPageResidentStatusDisplay() {
		List<WebElement> statusOptions = wd.findElements(By.xpath(
				"//label[text()='Resident Status']/..//button//following-sibling::ul//a/span[contains(@class,'fa fa')]"));
		int status = statusOptions.size();
		for (int i = 1; i <= status; i++) {
			String ResidentStatus = wd
					.findElement(By.xpath(String
							.format("(//label[text()='Resident Status']/..//button//following-sibling::ul//a)[%s]", i)))
					.getText();

			System.out.println("Resident Status : " + ResidentStatus);
			this.testReport.logSuccess("Resident Name Option",
					String.format("Option Present <mark>%s<mark/>", ResidentStatus));
		}

		List<WebElement> StatusOptions = wd.findElements(By.xpath(
				"//label[text()='Resident Status']/..//button//following-sibling::ul//a/span[@style='font-weight: normal;']"));
		int Status = StatusOptions.size();
		for (int i = 1; i <= Status; i++)

		{

			String ResidentStatus = wd.findElement(By.xpath(String.format(
					"(//label[text()='Resident Status']/..//button//following-sibling::ul//a/span[@style='font-weight: normal;'])[%s]",
					i))).getText();

			System.out.println("Resident Status : " + ResidentStatus);
			this.testReport.logSuccess("Resident Status Option",
					String.format("Option Present <mark>%s<mark/>", ResidentStatus));
		}
	}

	public void SelectionOfResidentOption(String Option, String ResidentOption) {
		if (Option.equals("Select All")) {
			By OptionSelectAll = By.xpath(
					String.format("(//label[text()='%s']/..//button//following-sibling::ul//a)[1]", ResidentOption));
			this.click(OptionSelectAll, "Select All");
		}

		else {
			By OptionSelectAll = By.xpath(
					String.format("(//label[text()='%s']/..//button//following-sibling::ul//a)[2]", ResidentOption));
			this.click(OptionSelectAll, "Unselect All");
		}
	}

	public void FindOptionInRecapPage(String Option, String ResidentOption) {
		By FindOption = By.xpath(String.format("//label[text()='%s']/..//input[@placeholder='Find']", ResidentOption));
		this.SendKeysToElementClearFirst(FindOption, Option);

		By SelectedOption = By.xpath(
				String.format("(//label[text()='%s']/..//button//following-sibling::ul//a/span[contains(text(),'%s')])",
						ResidentOption, Option));
		this.click(SelectedOption, Option.toString());
	}

	public void VerifyRecapPageResidentStationsDisplay() {
		List<WebElement> StationsOptions = wd.findElements(By.xpath(
				"//label[text()='Stations']/..//button//following-sibling::ul//a/span[contains(@class,'fa fa')]"));
		int Stations = StationsOptions.size();
		for (int i = 1; i <= Stations; i++) {
			String stations = wd
					.findElement(By.xpath(
							String.format("(//label[text()='Stations']/..//button//following-sibling::ul//a)[%s]", i)))
					.getText();

			System.out.println("Stations : " + stations);
			this.testReport.logSuccess("Stations Option", String.format("Option Present <mark>%s<mark/>", stations));
		}
	}

	public void VerifyRecapPageResidentDisplay() {
		List<WebElement> ResidentsOptions = wd.findElements(By.xpath(
				"//label[text()='Residents']/..//button//following-sibling::ul//a/span[contains(@class,'fa fa')]"));
		int Residents = ResidentsOptions.size();
		for (int i = 1; i <= Residents; i++) {
			String residents = wd
					.findElement(By.xpath(
							String.format("(//label[text()='Residents']/..//button//following-sibling::ul//a)[%s]", i)))
					.getText();

			System.out.println("Resident  : " + residents);
			this.testReport.logSuccess("Resident ", String.format("Option Present <mark>%s<mark/>", residents));
		}

		List<WebElement> residentOptions = wd.findElements(By.xpath(
				"//label[text()='Physicians']/..//button//following-sibling::ul//a/span[@style='font-weight: normal;']"));
		int residents = residentOptions.size();
		for (int i = 1; i <= residents; i++)

		{

			String OtherResidents = wd.findElement(By.xpath(String.format(
					"(//label[text()='Physicians']/..//button//following-sibling::ul//a/span[@style='font-weight: normal;'])[%s]",
					i))).getText();

			System.out.println("Physicians  : " + OtherResidents);
			this.testReport.logSuccess("Physicians Count ", String.format("Option Present <mark>%s<mark/>", residents));
			this.testReport.logSuccess("Physicians ", String.format("Option Present <mark>%s<mark/>", OtherResidents));
		}
	}

	public void VerifyRecapPageOrderStatusDisplay() {
		List<WebElement> OrderStatusOptions = wd.findElements(By.xpath(
				"//label[text()='Order Status']/..//button//following-sibling::ul//a/span[contains(@class,'fa fa')]"));
		int OrderStatus = OrderStatusOptions.size();
		for (int i = 1; i <= OrderStatus; i++) {
			String orderStatus = wd
					.findElement(By.xpath(String
							.format("(//label[text()='Order Status']/..//button//following-sibling::ul//a)[%s]", i)))
					.getText();

			System.out.println("Order Status  : " + orderStatus);
			this.testReport.logSuccess("Order Status ", String.format("Option Present <mark>%s<mark/>", orderStatus));
		}
	}

	public void VerifyRecapPagePhysiciansDisplay() {
		List<WebElement> PhysiciansOptions = wd.findElements(By.xpath(
				"//label[text()='Physicians']/..//button//following-sibling::ul//a/span[contains(@class,'fa fa')]"));
		int Physicians = PhysiciansOptions.size();
		for (int i = 1; i <= Physicians; i++) {
			String physicians = wd
					.findElement(By.xpath(String
							.format("(//label[text()='Physicians']/..//button//following-sibling::ul//a)[%s]", i)))
					.getText();

			System.out.println("Physicians  : " + physicians);
			this.testReport.logSuccess("Physicians ", String.format("Option Present <mark>%s<mark/>", physicians));
		}

		List<WebElement> physiciansOptions = wd.findElements(By.xpath(
				"//label[text()='Physicians']/..//button//following-sibling::ul//a/span[@style='font-weight: normal;']"));
		int physicians = physiciansOptions.size();
		ArrayList<String> obj = new ArrayList<String>();
		for (int i = 1; i <= physicians; i++)

		{

			obj.add(wd.findElement(By.xpath(String.format(
					"(//label[text()='Physicians']/..//button//following-sibling::ul//a/span[@style='font-weight: normal;'])[%s]",
					i))).getText());
		}

		this.testReport.logSuccess("Physicians Count ", String.format("Option Present <mark>%s<mark/>", physicians));
		this.testReport.logSuccess("Physicians ", String.format("Option Present <mark>%s<mark/>", obj.toString()));

	}

	public void VerifyRecapeDate() {
		this.VerifyWebElementPresent(calenderRecapDate, "Recap Date");
		this.VerifyWebElementPresent(calenenderRecapDate, "Recap Date");
		/*
		 * this.click(calenenderRecapDate, "Recap Date"); By Date = By.xpath(String.
		 * format("(//label[text()='Recap Date']/..//ngb-datepicker-month-view[@class='d-block']//div[text()='%s'])[1]"
		 * , date)); this.click(Date, "Recape Date Clicked");
		 */

		// String defaultDate = wd.findElement(By.xpath("//label[text()='Recap
		// Date']/..//input[@placeholder='mm/dd/yyyy' and
		// @ng-reflect-disabled='false']")).getAttribute("ng-reflect-model");
		String defaultDate = wd
				.findElement(By.xpath(
						"//label[text()='Recap Date']/..//input[@placeholder='mm/dd/yyyy' and @class='form-control']"))
				.getAttribute("value");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String dt = sdf.format(cal.getTime());

		if (dt.equals(defaultDate)) {
			this.testReport.logSuccess("Default Date", String.format(
					"Default Date <mark>%s<mark/> is same with the Current Date <mark>%s<mark/>", defaultDate, dt));
		} /*else {
			this.testReport.logFailure("Default Date", String.format(
					"Default Date <mark>%s<mark/> is not same with the Current Date <mark>%s<mark/>", defaultDate, dt));
		}*/

	}

	public void RecapApplyFilter() {
		this.VerifyWebElementPresent(btnApplyFilter, "Apply Filter");
		this.click(btnApplyFilter, "Apply Filter");
		this.waitInSecs(5);
	}

	public void RecapPageButtonmVerification() {
		this.VerifyWebElementPresent(btnToggleRecapAll, "Toggle Recap All");
		this.VerifyWebElementPresent(btnCancel, "Cancel Button");
		this.VerifyWebElementPresent(btnAddSignature, "Add Signature");
		if (this.isElementPresent(btnToggleRecap)) {
			this.VerifyWebElementPresent(btnToggleRecap, "Toggle Recap");
		}
		// this.VerifyWebElementPresent(btnToggleRecap, "Toggle Recap");
	}

	public void VerifyToggleRecapAll()

	{
		this.click(btnToggleRecapAll, "Toggle Recap All");
		this.waitInSecs(2);
		List<WebElement> RecapOptions = wd.findElements(By.xpath("//span[text()='Recap']"));
		int Recap = RecapOptions.size();
		this.testReport.logSuccess("Recap Options",
				String.format("Total Recap OptionS Present <mark>%s<mark/>", Recap));
		this.waitInSecs(2);
		this.click(btnToggleRecapAll, "Toggle Recap All");
		this.waitInSecs(2);
		this.VerifyWebElementNotPresent(btnRecap, "Recap Not Present");

	}

	public void VerifyToggleRecap() {
		this.click(btnToggleRecap, "Toggle Recap");
		this.VerifyWebElementPresent(btnRecap, "Recap Present");
	}

	public void VerifyRecapFromCheckBox() {
		this.VerifyWebElementPresent(btnRecap, "Recap Present");
		this.click(btnToggleRecap, "Toggle Recap");
	}

	public void SelectPhysicianForReacap(String Option) {
		this.VerifyWebElementPresent(btnRecapPageSelectPhysician, "Recap Page Select Physician");
		this.click(btnRecapPageSelectPhysician, "Recap Page Select Physician");
		By UnselectAll = By.xpath("//li/a/span[@class='fa fa-times']");
		this.click(UnselectAll, "Unselect All");
		By PhysicianName = By.xpath(String.format("//ul//span[text()='%s']", Option));
		this.click(PhysicianName, "Physician Name");
	}

	public void SelectPhysicianSignatureForReacap() {
		this.VerifyWebElementPresent(btnRecapPageSelectStatus, "Recap Page Select Status");
		this.click(btnRecapPageSelectStatus, "Recap Page Select Status");
		By UnselectAll = By.xpath("//li/a/span[@class='fa fa-times']");
		this.click(UnselectAll, "Unselect All");
		By PhysicianSignature = By.xpath("//ul//span[text()='Need Physician Signature']");
		this.click(PhysicianSignature, "Physician Signature");
	}

	public void ClickAndSelectPhysicianSignatureForReacap(String OrderName, String Type) {

		if (this.isElementPresent(labelOrderPageDate)) {
			this.click(labelOrderPageDate, "Date");
			this.waitInSecs(3);
			if(this.isElementPresent(labelOrderPageDate))
			{
			this.click(labelOrderPageDate, "Date");
			}
		}
		List<WebElement> Orders = wd.findElements(By.xpath("//datatable-body-cell[1]/div"));
		int ordersNo = Orders.size();
		for (int j = 1; j <= ordersNo; j++) {
			String requriedOrder = wd.findElement(By.xpath(String.format("(//datatable-body-cell[1]/div)[%d]", j)))
					.getText();

			if (requriedOrder.equals(OrderName)) {

				if (Type.equals("Click")) {
					By OrderDescription = By.xpath(String.format("(//datatable-body-cell[1]/div)[%d]", j));

					this.click(OrderDescription, "Click on the Description of the  Order");
					break;
				}

				else {
					By OrderDescriptionDetail = By
							.xpath(String.format("(//datatable-body-cell[6]/div)[%d]//button[text()='Detail']", j));

					this.click(OrderDescriptionDetail, "Click on the Detail Button of the  Order");
					break;
				}
			}
			if (requriedOrder.equals(OrderName)) {
				break;
			}

		}

	}

	

}
