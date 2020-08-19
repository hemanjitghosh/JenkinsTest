package bluestrata.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.enums.AccountPayableMenuItem;
import com.enums.PaymentType;
import com.testreport.IReporter;

import dweb.aut.pages.templates.PageTemplate;

/**
 * @author hemanjitg
 *
 */
public class AccountsPayablePage extends PageTemplate {

	public AccountsPayablePage(WebDriver webDriver, IReporter testReport) {
		super(webDriver, testReport);
	}

	// This area consists of Page Objects
	protected By mnuAccountsPayable = By.xpath("//button[text()='Accounts Payable']");
	protected By lblEnterInvoices = By.xpath("//h4[text()='Enter Invoices']");
	protected By btnCreateBatch = By.xpath("//a[text()='Create Batch']");
	protected By txtEnterBatchName = By.xpath("//input[@placeholder='Enter Batch Name']");
	protected By btnCreateInvoice = By.xpath("//button[text()='Create an Invoice']");
	protected By txtPONo = By.id("purchaseOrderNumber");
	protected By txtInvoiceNo = By.id("invoiceNumber");
	protected By txtDesc = By.id("description");
	protected By txtInvoiceAmount = By.id("invoiceAmount");
	protected By txtPayTo = By.id("payTo");
	protected By cmbVendorId = By.xpath("//input[@id='vendorId']");
	protected By postingAccount = By.id("chartOfAccountId");
	protected By txtAmount = By.id("amount");
	protected By btnCreate = By.xpath("//button[text()='Create']");
	protected By popSave = By.xpath("//div[text()='Save Complete']");
	protected By lblRecurringInvoices = By.xpath("//h4[text()='Recurring Invoices']");
	protected By btnCreateRecurringInvoice = By.xpath("//button[text()='Create an Invoice']");
	protected By mnuVendors = By.xpath("//button[text()='Vendors']");
	protected By btnCreateVendor = By.xpath("//button[text()='Create a Vendor']");
	protected By txtVendorName = By.id("name");
	protected By txtVendorAccNo = By.id("accountNumber");
	protected By popRecurringInvoiceCreated = By.xpath("//div[text()='Recurring Invoice Created']");
	protected By mnuEnterInvoices = By.xpath("//button[text()='Enter Invoices']");
	protected By mnuRecurringInvoices = By.xpath("//button[text()='Recurring Invoices']");
	protected By btnPostBatch = By.xpath("//button[text()='Post'][1]");
	protected By btnPostBatchOk = By.xpath("//button[text()='Ok']");
	protected By btnCreateVendorRecord = By.xpath("//button[text()='Create']");
	protected By txtSearchVendor = By.xpath("//input[@placeholder='Search By Name']");
	protected By btnMakeVendorInactive = By.xpath("//button[text()='Make Inactive']");
	protected By btnEditVendor = By.xpath("//button[text()='Edit']");
	protected By btnUpdateVendor = By.xpath("//button[text()='Update']");
	protected By lblVendor = By.xpath("//h4[text()='Vendors']");
	protected By lblInvoiceList = By.xpath("//h4[text()='Invoice List']");
	protected By lblMakePayments = By.xpath("//h4[text()='Make Payments']");
	protected By lblCheckRegister = By.xpath("//h4[text()='Check Register']");
	protected By lblClosePeriod = By.xpath("//h4[text()='Close Period']");
	protected By mnuInvoiceList = By.xpath("//button[text()='Invoice List']");
	protected By mnuMakePayments = By.xpath("//button[text()='Make Payments']");
	protected By mnuCheckRegister = By.xpath("//button[text()='Check Register']");
	protected By mnuClosePeriod = By.xpath("//button[text()='Close Period']");
	protected By btnCheck = By.xpath("//button[text()='Check']");
	protected By btnAch = By.xpath("//button[text()='ACH/Transfer']");
	protected By btnCreditCard = By.xpath("//button[text()='Credit Card']");
	protected By btnPostPayment = By.xpath("//button[text()='Post']");
	protected By txtTransactionNo=By.xpath("//input[@id='checkNumber']");
	protected By btnCancel=By.xpath("//button[text()='Cancel']");
	protected By lblInvoiceValidation=By.xpath("//input[@id='invoiceAmount']//following::div//preceding::span[text()='Required field.'][1]");
	protected By lblPayToValidation=By.xpath("//input[@id='payTo']//following::div//preceding::span[text()='Required field.'][1]");
	protected By lblPostingAccountValidation=By.xpath("//input[@id='chartOfAccountId']//following::div//preceding::span[text()='Required field.'][1]");
	protected By lblAmountValidation=By.xpath("//input[@id='amount']//following::div//preceding::span[text()='Required field.'][1]");
	protected By btnSetup=By.xpath("//button[text()='Setup']");
	protected By btnPaymentTerms=By.xpath("//button[text()='Payment Terms']");
	protected By btnCreateTerm=By.xpath("//button[text()='Create a Term']");
	protected By txtDiscountPercent=By.xpath("//input[@id='discountPercent']");
	protected By txtDiscountDays=By.xpath("//input[@id='discountDays']");
	protected By txtNetDue=By.xpath("//input[@id='netDue']");
	protected By btnUpdate = By.xpath("//accounts-payable-term-modify//button[text()='Update']");
	protected By popUpTermCreated = By.xpath("//div[text()='Term Created']");
	protected By btnEditRecurringInvoice = By.xpath("//button[text()='Update' and @class='btn btn-primary ng-star-inserted']");
	protected By popMissingBatch = By.xpath("//div[text()='Please enter a batch name before creating your first invoice.']");
	protected By popUpInvoiceVoided = By.xpath("//div[text()='Invoice Voided']");
	protected By lblDiscountPercent=By.xpath("//span[text()='Discount Percent']//following::div//span[text()='Required field.']");
	protected By lblDiscountDays=By.xpath("//span[text()='Discount Days']//following::div//span[text()='Required field.']");
	protected By lblNetDue=By.xpath("//span[text()='Net Due in Days']//following::div//span[text()='Required field.']");
	protected By popUpTermUpdated = By.xpath("//div[text()='Term Updated']");
	protected By cmbYear=By.xpath("//app-accounts-payable-periods//select");
	protected By lblYear=By.xpath("//span[text()='Year']");
	protected By lblMonth=By.xpath("//span[text()='Month']");
	protected By lblStartDate=By.xpath("//span[text()='Start Date']");
	protected By lblEndDate=By.xpath("//span[text()='End Date']");
	
	
		
	// This area consists of methods

	
	  /**
	 * This method is used to click items in Account payable menu list
	 */
	
	 
	public void clickAccountsPayableMenuItems(String menuItem) {
		

		if (menuItem.equalsIgnoreCase(AccountPayableMenuItem.Vendors.toString())) {
			this.click(mnuVendors, "Vendor Menu");
		}
		else if (menuItem.equalsIgnoreCase(AccountPayableMenuItem.EnterInvoices.toString())) {
			this.click(mnuEnterInvoices, "EnterInvoices Menu");
		}
		else if (menuItem.equalsIgnoreCase(AccountPayableMenuItem.RecurringInvoices.toString())) {
			this.click(mnuRecurringInvoices, "Recurring Invoices Menu");
		}

		else if (menuItem.equalsIgnoreCase(AccountPayableMenuItem.InvoiceList.toString())) {
			this.click(mnuInvoiceList, "Invoice List menu");
		} 
		else if (menuItem.equalsIgnoreCase(AccountPayableMenuItem.MakePayments.toString())) {
			this.click(mnuMakePayments, "Make Payments menu");
		} 
		else if (menuItem.equalsIgnoreCase(AccountPayableMenuItem.CheckRegister.toString())) {
			this.click(mnuCheckRegister, "Check Register menu");
		} 
		else if (menuItem.equalsIgnoreCase(AccountPayableMenuItem.ClosePeriod.toString())) {
			this.click(mnuClosePeriod, "Close Period menu");
		}

	}
	
	
	/**
	 * This method is used to createBatch
	 * 
	 * @param batchName
	 * @param vendor
	 * @param po
	 * @param invoice
	 * @param invoiceAmount
	 * @param amount
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	public void createBatch(String batchName, String vendor, String po, String invoice, String invoiceAmount,
			String amount) {
		this.VerifyWebElementPresent(lblEnterInvoices, "Enter Invoices label");
		this.click(btnCreateBatch, "Create Batch button");
		this.sendKeys(txtEnterBatchName, batchName);
		this.click(btnCreateInvoice, "CreateInvoice button");
		this.waitUntilElementIsClickable(cmbVendorId);
		//this.WaitForElementPresent(cmbVendorId, 5, "Vendor dropdown");
		/*if(!this.isElementPresent(cmbVendorId));
		{
			this.testReport.logFailure("Vendor Id is not valid");
			this.assertText(true, false);
			Assert.fail();
		}*/
		//this.WaitForElementPresent(By.xpath("//input[@role='combobox' and @id='7d1b2da5-07c3-f9c3-c3b8-f999c91b10ec']"), 5, "Vendor dropdown");
		this.click(cmbVendorId, "VendorID");
		//this.click(By.xpath("//input[@role='combobox' and @id='7d1b2da5-07c3-f9c3-c3b8-f999c91b10ec']"), "Vendor dropdown");
		this.waitInSecs(5);
		//this.click(By.xpath("//div[@class='ng-option' and @role='option']"), "Vendor dropdown");
		//this.sendKeys(By.xpath("//div[@class='ng-option' and @role='option'] //span[text()='"+vendor+"']"), vendor);
		//div[@class='ng-option' and @role='option'] //span[text()='A1Test']
		this.sendKeys(cmbVendorId, vendor);
		this.click(By.xpath("//div/span[text()='"+vendor+"']"), "vendor");
		this.sendKeys(txtPONo, po);
		this.sendKeys(txtInvoiceNo, invoice);
		this.sendKeys(txtInvoiceAmount, invoiceAmount);
		//this.sendKeys(txtAmount, amount);
		this.click(postingAccount, "Posting account dropdowm");
		this.sendKeys(postingAccount, "101000 | Cash - General Account");
		this.waitInSecs(4);
		//this.ClickENTER();
		//this.sendKeys(byLocator, text);
		this.click(By.xpath("//div/span[text()='101000 | Cash - General Account']"),"Posting account");
		this.click(btnCreate, "Create invoice batch");
		WebDriverWait wait = new WebDriverWait(wd, 20);
		WebElement we = wait.until(ExpectedConditions.elementToBeClickable(btnCreate));
		long starttime = System.currentTimeMillis();
		long endtime = 3 * 60000 + starttime;
		while (!this.isElementPresent(popSave) && starttime < endtime) {
			this.waitInSecs(1);
		}
		this.waitInSecs(3);
		while (this.isElementPresent(popSave) && starttime < endtime) {
			this.waitInSecs(1);
		}

	}

	/**
	 * This method is used to verify Invoice batch
	 * 
	 * @param batchName
	 * @return
	 */
	public boolean verifyInvoiceBatch(String batchName) {

		clickAccountsPayableMenuItems(AccountPayableMenuItem.EnterInvoices.toString());
		By batchRecord = By.xpath("//span[@title='" + batchName + "']");
		return this.isElementPresent(batchRecord);

	}

	/**
	 * This method is used to post invoice
	 * @param batchName
	 */
	public void postInvoice(String batchName) {
		this.click(By.xpath("//span[text()='" + batchName + "']/../../../..//button[text()='Post']"),
				"Post Batch button");
		this.click(btnPostBatchOk, "Post batch ok button");
		this.waitUntilElementIsVisible(By.xpath("//div[text()='Update Completed']"));
		long starttime = System.currentTimeMillis();
		long endtime = 3 * 60000 + starttime;
		while (this.isElementPresent(By.xpath("//div[text()='Update Completed']"))
				&& starttime < endtime) {
			this.waitInSecs(1);
		}

	}

	/**
	 * This method is used to Delete Invoice
	 * @param batchName
	 */
	public void deleteInvoice(String batchName) {
		this.click(By.xpath("//span[text()='" + batchName + "']/../../../..//button[text()='Remove']"),
				"Remove Batch button");
		this.click(btnPostBatchOk, "Remove batch ok button");
		this.waitUntilElementIsVisible(By.xpath("//div[text()='Batch Updated']"));

		long starttime = System.currentTimeMillis();
		long endtime = 3 * 60000 + starttime;
		while (this.waitUntilElementIsVisible(By.xpath("//div[text()='Batch Updated']")) != true
				&& starttime < endtime) {
			this.waitInSecs(1);

		}

	}

	/**
	 * This method is used to create Recurring invoice
	 * @param vendor
	 * @param invoiceAmount
	 * @throws InterruptedException
	 */
	public void createRecurringInvoice(String vendor, String invoiceAmount) throws InterruptedException {

		this.waitInSecs(5);
		this.click(btnCreateRecurringInvoice, "Create Recurring Invoice");
		this.WaitForElementPresent(cmbVendorId, 5, "Vendor dropdown");
		/*if(!this.isElementPresent(cmbVendorId));
		{
			this.assertText(true, false);
			Assert.fail();
		}*/
		this.click(cmbVendorId, "VendorID");
		this.waitInSecs(5);
		this.sendKeys(cmbVendorId, vendor);
		this.click(By.xpath("//div[@role='option']/span[text()='"+vendor+"']"), "vendor");
		//this.SelectDropDownByText(cmbVendorId, vendor);
		this.sendKeys(txtInvoiceAmount, invoiceAmount);
		wd.findElement(txtInvoiceAmount).sendKeys(Keys.TAB);
		this.sendKeys(postingAccount, "101000 | Cash - General Account");
		this.click(By.xpath("//div/span[text()='101000 | Cash - General Account']"),"Posting account");
		this.click(btnCreate, "Create invoice batch");
		this.waitUntilElementIsVisible(popRecurringInvoiceCreated);
		long starttime = System.currentTimeMillis();
		long endtime = 3 * 60000 + starttime;
		while (this.isElementPresent(popRecurringInvoiceCreated) && starttime < endtime) {
			this.waitInSecs(1);
		}
		
	}

	/**
	 * This method is used to Create Vendor
	 * @param vendor
	 * @param accountNo
	 */
	public void createVendor(String vendor, String accountNo) {
		this.click(btnCreateVendor, "Create Vendor button");
		this.sendKeys(txtVendorName, vendor);
		WebDriver driver = this.wd;
		driver.findElement(txtVendorAccNo).clear();
		this.sendKeys(txtVendorAccNo, accountNo);
		this.click(btnCreateVendorRecord, "Create vendor entry record");
		this.waitUntilElementIsVisible(By.xpath("//div[text()='Vendor Created']"));
		long starttime = System.currentTimeMillis();
		long endtime = 3 * 60000 + starttime;
		while (this.isElementPresent(By.xpath("//div[text()='Vendor Created']")) && starttime < endtime) {

			this.waitInSecs(1);

		}
		

	}

	/**
	 * This method is used to delete Invoice
	 * @param vendor
	 */
	public void deleteRecurringInvoice(String vendor) {
		WebElement invc = wd.findElement(By.xpath("//span[text()='" + vendor + "']"));
		WebElement we = invc
				.findElement(By.xpath("//span[text()='" + vendor + "']/../../../..//button[text()='Remove']"));
		we.click();

	}

	/**
	 * String increment and append logic
	 * @param actualValue
	 * @param updateValue
	 * @return
	 */
	public String generateString(String actualValue, String updateValue) {
		
		int numberStr = Integer
				.parseInt(actualValue.substring(actualValue.indexOf(actualValue) + 7, actualValue.length()));
		StringBuilder sb1 = new StringBuilder(updateValue);
		numberStr = numberStr + 1;
		sb1.append(numberStr);
		return sb1.toString();

	}

	/**
	 * This method is used to search Vendor
	 * @param vendorName
	 */
	public void searchVendor(String vendorName) {
		this.sendKeys(txtSearchVendor, vendorName);
		this.waitUntilElementIsClickable(By.xpath("//div[@class='d-flex flex-column w-100' and contains(string(), " + vendorName + ")]"));
		this.click(By.xpath("//div[@class='d-flex flex-column w-100' and contains(string(), " + vendorName + ")]"),
				"Vendor Search Record");
		this.WaitForElementPresent(By.xpath("//h3[text()='" + vendorName + "']"), 5, "Vendor Name label");
		this.VerifyWebElementPresent(By.xpath("//h3[text()='" + vendorName + "']"), "Vendor Name label");

	}

	/**
	 * This method is used to make Vendor Inactive
	 * 
	 */
	public void makeVendorInactive() {
		
		this.click(btnMakeVendorInactive, "Make Vendor Inactive Button");
		this.click(btnPostBatchOk, "Ok button click");
		this.waitUntilElementIsVisible(By.xpath("//div[text()='Vendor Updated']"));
		long starttime = System.currentTimeMillis();
		long endtime = 3 * 60000 + starttime;
		while (this.isElementPresent(By.xpath("//div[text()='Vendor Updated']")) && starttime < endtime) {

			this.waitInSecs(1);

		}
	}
	/**
	 * This method is used to verify Inactive Vendor
	 * 
	 */
	public void verifyInactiveVendor(String vendorName) {
		this.click(By.xpath("//div[@class='dropdown multi-selector']/button"), "Active inactive dropdown");
		this.click(By.xpath("//span[text()='Inactive']"), "Click InActive button");
		this.click(By.xpath("//div[@class='d-flex flex-column w-100' and contains(string(), " + vendorName + ")]"),
				"Vendor Search Record");
		this.VerifyWebElementNotPresent(btnMakeVendorInactive, "Make Vendor Inactive Button");
	}
	

	/**
	 * This method is used to edit vendor
	 * @param accNo
	 */
	public void EditVendor(String accNo) {
		this.click(btnEditVendor, "Edit Vendor Button");
		WebDriver driver = this.wd;
		driver.findElement(txtVendorAccNo).clear();
		this.sendKeys(txtVendorAccNo, accNo);
		this.click(btnUpdateVendor, "Update Vendor Details");
		this.waitUntilElementIsVisible(By.xpath("//div[text()='Vendor Updated']"));
		long starttime = System.currentTimeMillis();
		long endtime = 3 * 60000 + starttime;
		while (this.isElementPresent(By.xpath("//div[text()='Vendor Updated']")) && starttime < endtime) {

			this.waitInSecs(1);

		}
		Assert.assertEquals(accNo,
				this.getText(By.xpath("//div[@class='form-control-plaintext' and contains(string(),'" + accNo + "')]")),
				"Account number is not Edited");
	}

	/**
	 * This method is used to verify AccountsPayable MenuItems
	 * @param menuItem
	 */
	public void verifyAccountsPayableMenuItems(String menuItem) {

		if (menuItem.equalsIgnoreCase(AccountPayableMenuItem.Vendors.toString())) {
			this.WaitForElementPresent(lblVendor, 10, "Vendors page label");
			this.VerifyWebElementPresent(lblVendor, "Vendors page label");
			this.WaitForElementPresent(btnCreateVendor, 10, "Create Vendor Button");
			this.VerifyWebElementPresent(btnCreateVendor, "Create Vendor Button");
		} else if (menuItem.equalsIgnoreCase(AccountPayableMenuItem.EnterInvoices.toString())) {
			this.WaitForElementPresent(lblEnterInvoices, 5, "EnterInvoices label");
			this.VerifyWebElementPresent(lblEnterInvoices, "EnterInvoices label");
			this.WaitForElementPresent(btnCreateBatch, 10, "Create Invoice batch button");
			this.VerifyWebElementPresent(btnCreateBatch, "Create Invoice batch button");

		} else if (menuItem.equalsIgnoreCase(AccountPayableMenuItem.RecurringInvoices.toString())) {
			this.WaitForElementPresent(lblRecurringInvoices, 5, "RecurringInvoices label");
			this.VerifyWebElementPresent(lblRecurringInvoices, "RecurringInvoices label");
			this.WaitForElementPresent(btnCreateRecurringInvoice, 10, "Create Recurring Invoice button");
			this.VerifyWebElementPresent(btnCreateRecurringInvoice, "Create Recurring Invoice button");
		} else if (menuItem.equalsIgnoreCase(AccountPayableMenuItem.InvoiceList.toString())) {
			this.WaitForElementPresent(lblInvoiceList, 5, "InvoicesList label");
			this.VerifyWebElementPresent(lblInvoiceList, "InvoicesList label");
		} else if (menuItem.equalsIgnoreCase(AccountPayableMenuItem.MakePayments.toString())) {
			this.WaitForElementPresent(lblMakePayments, 5, "Make Payments label");
			this.VerifyWebElementPresent(lblMakePayments, "Make Payments label");
		} else if (menuItem.equalsIgnoreCase(AccountPayableMenuItem.CheckRegister.toString())) {

			this.WaitForElementPresent(lblCheckRegister, 5, "Check Register label");
			this.VerifyWebElementPresent(lblCheckRegister, "Check Register label");
		} else if (menuItem.equalsIgnoreCase(AccountPayableMenuItem.ClosePeriod.toString())) {
			this.WaitForElementPresent(lblClosePeriod, 5, "Close Period label");
			this.VerifyWebElementPresent(lblClosePeriod, "Close Period label");
		}
	}
		
	/**
	 * This method is used to make Payment
	 * @param paymentType
	 */
	public void makePayment(String paymentType) {
		this.WaitForElementPresent(lblMakePayments, 5, "make Payments label");
		this.VerifyWebElementPresent(lblMakePayments, "make Payments label");
		if (paymentType.equalsIgnoreCase(PaymentType.Check.toString())) {

		}
		if (paymentType.equalsIgnoreCase(PaymentType.Check.toString())) {
			
			this.click(btnCheck, "Check payment button");
		} else if (paymentType.equalsIgnoreCase(PaymentType.ACH.toString())) {
			
			this.click(btnAch, "ACH payment button");
		} else if (paymentType.equalsIgnoreCase(PaymentType.CreditCard.toString())) {
			this.click(btnCreditCard, "CreditCar payment button");
		}

	}

	/**
	 * This methos is used to select a vendor
	 * @param vendor
	 */
	public void selectVendor(String vendor) {
		this.click(By.xpath("//span[text()='" + vendor + "']/../../..//input[@type='checkbox']"),
				"Select vendor checkbox");
	}
	

	/**
	 * This methos is used to get transaction no
	 * @return
	 */
	public String getTransactionNoText() {
		this.VerifyWebElementPresent(By.xpath("//h4[text()='Post Payments']"), "Post payments modal label");
		this.waitInSecs(3);
		return wd.findElement(By.xpath("//div/input[@id='checkNumber']")).getAttribute("value");

	}

	/**
	 * This method is used to post Payment
	 */
	public void postPayment() {

		String handle = wd.getWindowHandle();
		this.click(btnPostPayment, "Post payment button");
		wd.switchTo().window(handle);
		this.click(By.xpath("//button[@class='close']"), "payments pop up close");
		this.waitUntilElementIsVisible(By.xpath("//div[text()='Payments Posted']"));
		long starttime = System.currentTimeMillis();
		long endtime = 3 * 60000 + starttime;
		while (this.isElementPresent(By.xpath("//div[text()='Payments Posted']")) && starttime < endtime) {
			this.waitInSecs(1);

		}
	}

	/**
	 * This method is used to verify Transaction number
	 * @param transactionNo
	 */
	public void verifyTransactionNo(String transactionNo) {
		
		this.click(By.xpath("//input[@id='account']"),"Account Dropdown for CheckRegister");
		this.sendKeys(By.xpath("//input[@id='account']"), "101000 | Cash - General Account");
		this.waitInSecs(4);
		this.click(By.xpath("//div/span[text()='101000 | Cash - General Account']"), "Account Dropdown for CheckRegister");
		this.sendKeys(By.xpath("//input[@id='transactionNumber']"), transactionNo);
		this.click(By.xpath("//app-accounts-payable-manage-payments//button[text()='Apply']"),"APPLY button");
		this.waitInSecs(4);
		String text = this.getText(By.xpath("//span[text()='" + transactionNo + "']"));
		this.assertText(transactionNo,text);
		
	}
	public void enterTransactionNo(String tranNo)
	{
		this.sendKeys(txtTransactionNo, tranNo);
	}
	
	public void createVendorWithoutData() {
		this.click(btnCreateVendor, "Create Vendor button");
		this.waitInSecs(3);
		this.click(btnCreateVendorRecord, "Create vendor entry record");
		//this.VerifyWebElementPresent(By.xpath("//div[text()='Invalid form']"), "Invalid data validation for vendor");
		
		
	}
	public void createVendorWithCancelCheck() {
		this.click(btnCreateVendor, "Create Vendor button");
		this.waitInSecs(3);
		this .click(btnCancel, "Cancel button");
		
		
	}
	
	public void verifyMandatoryFieldsForInvoice()
	{
		this.VerifyWebElementPresent(lblEnterInvoices, "Enter Invoices label");
		this.click(btnCreateBatch, "Create Batch button");
		this.sendKeys(txtEnterBatchName, "Test batch");
		this.click(btnCreateInvoice, "CreateInvoice button");
		this.click(btnCreate, "Create invoice batch");
		this.VerifyWebElementPresent(By.xpath("//div[text()='Invalid form']"), "Invalid data validation for create invoice");
		this.VerifyWebElementPresent(lblInvoiceValidation, "Invoice validation message");
		this.VerifyWebElementPresent(lblPayToValidation, "Pay to validation message");
		this.VerifyWebElementPresent(lblPostingAccountValidation, "Posting account validation message");
		this.VerifyWebElementPresent(lblAmountValidation, "Amount validation message");
	}
	
	public void createBatchWithInvalidData(String invoiceAmount)
	{
		this.VerifyWebElementPresent(lblEnterInvoices, "Enter Invoices label");
		this.click(btnCreateBatch, "Create Batch button");
		this.sendKeys(txtEnterBatchName, "TestBatch");
		this.click(btnCreateInvoice, "CreateInvoice button");
		this.WaitForElementPresent(cmbVendorId, 5, "Vendor dropdown");
		this.sendKeys(txtInvoiceAmount, invoiceAmount);
		this.sendKeys(postingAccount, "error");
		this.click(btnCreate, "Create invoice batch");
		this.VerifyWebElementPresent(btnCreate, "Create invoice batch");
	}
	
	public void cancelBatch(String batchName, String vendor, String po, String invoice, String invoiceAmount,
			String amount) throws InterruptedException {
		this.VerifyWebElementPresent(lblEnterInvoices, "Enter Invoices label");
		this.click(btnCreateBatch, "Create Batch button");
		this.sendKeys(txtEnterBatchName, batchName);
		this.click(btnCreateInvoice, "CreateInvoice button");
		this.WaitForElementPresent(cmbVendorId, 5, "Vendor dropdown");
		this.click(cmbVendorId, "VendorID");
		this.waitInSecs(5);
		this.sendKeys(cmbVendorId, vendor);
		this.click(By.xpath("//div/span[text()='"+vendor+"']"), "vendor");
		this.sendKeys(txtPONo, po);
		this.sendKeys(txtInvoiceNo, invoice);
		this.sendKeys(txtInvoiceAmount, invoiceAmount);
		this.sendKeys(txtAmount, amount);
		this.sendKeys(postingAccount, "101000 | Cash - General Account");
		this.click(By.xpath("//div/span[text()='101000 | Cash - General Account']"),"Posting account");
		this.click(btnCancel, "Cancel button");
	}
	
	public void verifyMandatoryFieldsForRecurringInvoice()
	{
		this.waitInSecs(5);
		this.click(btnCreateRecurringInvoice, "Create Recurring Invoice");
		this.click(btnCreate, "Create invoice batch");
		this.VerifyWebElementPresent(By.xpath("//div[text()='Invalid form']"), "Invalid data validation for create invoice");
		this.VerifyWebElementPresent(lblInvoiceValidation, "Invoice validation message");
		this.VerifyWebElementPresent(lblPayToValidation, "Pay to validation message");
		this.VerifyWebElementPresent(lblPostingAccountValidation, "Posting account validation message");
		this.VerifyWebElementPresent(lblAmountValidation, "Amount validation message");
	}
	
	public void createRecurringInvoiceWithInvalidData(String invoiceAmount)
	{
		this.waitInSecs(5);
		this.click(btnCreateRecurringInvoice, "Create Recurring Invoice");
		this.click(btnCreate, "Create invoice batch");
		this.WaitForElementPresent(cmbVendorId, 5, "Vendor dropdown");
		this.sendKeys(txtInvoiceAmount, invoiceAmount);
		this.sendKeys(postingAccount, "error");
		this.click(btnCreate, "Create invoice batch");
		this.VerifyWebElementPresent(btnCreate, "Create invoice batch");
	}
	
	
	public void cancelRecurringInvoice(String vendor, String invoiceAmount) throws InterruptedException {

		this.waitInSecs(5);
		this.click(btnCreateRecurringInvoice, "Create Recurring Invoice");
		this.WaitForElementPresent(cmbVendorId, 5, "Vendor dropdown");
		this.click(cmbVendorId, "VendorID");
		this.waitInSecs(5);
		this.sendKeys(cmbVendorId, vendor);
		this.click(By.xpath("//div[@role='option']/span[text()='"+vendor+"']"), "vendor");
		//this.SelectDropDownByText(cmbVendorId, vendor);
		this.sendKeys(txtInvoiceAmount, invoiceAmount);
		wd.findElement(txtInvoiceAmount).sendKeys(Keys.TAB);
		this.sendKeys(postingAccount, "101000 | Cash - General Account");
		this.click(By.xpath("//div/span[text()='101000 | Cash - General Account']"),"Posting account");
		this.click(btnCancel, "Cancel button");
	}
	
	public void clickPaymentTerms()
	{
		this.click(btnSetup, "Set up menu button ");
		this.click(btnPaymentTerms, "Payment terms button");
	}
	
	public void createPaymentTerms(String percent,String discountDays,String netDue)
	{
		this.click(btnCreateTerm, "Create Term button");
		this.waitUntilElementIsClickable(txtDiscountPercent);
		this.sendKeys(txtDiscountPercent, percent);
		this.sendKeys(txtDiscountDays, discountDays);
		this.sendKeys(txtNetDue, netDue);
		this.click(btnUpdate, "Update terms button");
		this.VerifyWebElementPresent(popUpTermCreated, "Term Created succesfully");
		long starttime = System.currentTimeMillis();
		long endtime = 3 * 60000 + starttime;
		while (this.isElementPresent(popUpTermCreated) && starttime < endtime) {
			this.waitInSecs(1);

		}
		
		
	}
	
	public void verifyTerm(String percent)
	{
		this.VerifyWebElementPresent(By.xpath("//span[contains(text(),'"+percent+"')]"), "label");
		
	}
	
	public void deleteTerm(String percent) 
	{
		this.click(By.xpath("//span[contains(text(),'"+percent+"')]/following::datatable-body-cell//button[text()='Remove']"), "Remove");
		this.click(btnPostBatchOk, "Ok button");
	}
	
	public void editRecurringInvoice(String vendor)
	{
		this.click(By.xpath("//span[text()='"+vendor+"']//following::datatable-body-cell//button[text()='Detail']"), "Edit button");
		this.SendKeysToElementClearFirst(By.xpath("//input[@id='description']"), "test");
		this.waitInSecs(2);
		this.click(btnEditRecurringInvoice, "Update Invoice");
		this.waitUntilElementIsVisible(popRecurringInvoiceCreated);
		long starttime = System.currentTimeMillis();
		long endtime = 3 * 60000 + starttime;
		while (this.isElementPresent(popRecurringInvoiceCreated) && starttime < endtime) 
		{
			this.waitInSecs(1);

		}
		this.click(By.xpath("//span[text()='"+vendor+"']//following::datatable-body-cell//button[text()='Detail']"), "update button");
		this.assertText("test", wd.findElement(By.xpath("//input[@id='description']")).getAttribute("value"));
	
		
	}
	
	public void validateEmptyBatch() throws InterruptedException 
	{
		this.VerifyWebElementPresent(lblEnterInvoices, "Enter Invoices label");
		this.click(btnCreateBatch, "Create Batch button");
		this.click(btnCreateInvoice, "CreateInvoice button");
		this.VerifyWebElementPresent(popMissingBatch, "Empty batch validation message");
	}
	
	public void verifyInvoiceList(String vendor)
	{
		this.VerifyWebElementPresent(By.xpath("//span[text()='"+vendor+"']"), "Invoice item on grid");
		this.click(By.xpath("//span[text()='"+vendor+"']//following::datatable-body-cell//button[text()='Void']"), "Vod invoice button");
		this.click(btnPostBatchOk, "Ok popup");
		this.VerifyWebElementPresent(popUpInvoiceVoided, "Invoice Voided succesfully");
		
	}
	
	public void validatePaymentTerms()
	{
		this.click(btnCreateTerm, "Create Term button");
		this.waitUntilElementIsClickable(txtDiscountPercent);
		this.click(txtDiscountPercent, "DiscountPercent");
		this.click(txtDiscountDays, "DiscountDays");
		this.click(txtNetDue, "NetDue");
		this.click(btnUpdate, "Update terms button");
		this.VerifyWebElementPresent(lblDiscountPercent, "Discount percent validation");
		this.VerifyWebElementPresent(lblDiscountDays, "DiscountDays validation");
		this.VerifyWebElementPresent(lblNetDue, "NetDue in days validation");
		
	}
	
	public void updatePaymentTerms(String percent,String editPercent,String editDiscountDays,String editNetDue)
	{
		this.click(By.xpath("//span[contains(text(),'"+percent+"')]//following::div//button[text()='Update']"), "Update button");
		this.waitUntilElementIsClickable(txtDiscountPercent);
		this.SendKeysToElementClearFirst(txtDiscountPercent, editPercent);
		this.SendKeysToElementClearFirst(txtDiscountDays, editDiscountDays);
		this.SendKeysToElementClearFirst(txtNetDue, editNetDue);
		this.click(By.xpath("//button[text()='Update' and @class='btn btn-primary ng-star-inserted']"), "Update terms button");
		this.VerifyWebElementPresent(popUpTermUpdated, "Term updated succesfully");
		
	}
	
	public void cancelPaymentTerms(String percent,String discountDays,String netDue)
	{
		this.click(btnCreateTerm, "Create Term button");
		this.waitUntilElementIsClickable(txtDiscountPercent);
		this.sendKeys(txtDiscountPercent, percent);
		this.sendKeys(txtDiscountDays, discountDays);
		this.sendKeys(txtNetDue, netDue);
		this.click(By.xpath("//button[text()='Cancel' and @class='btn btn-link']"), "Cancel terms button");
	}
	
	public void verifyClosePeriodItems()
	{
		this.VerifyWebElementPresent(lblClosePeriod, "Close period label");
		this.VerifyWebElementPresent(cmbYear, "Year dropdown");
		this.VerifyWebElementPresent(lblYear, "Year label");
		this.VerifyWebElementPresent(lblMonth, " Month Label");
		this.VerifyWebElementPresent(lblStartDate, "StartDate Label");
		this.VerifyWebElementPresent(lblEndDate, "EndDate Label");
	}
}