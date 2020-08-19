package bluestrata.tests.functionalTests;

import java.awt.AWTException;
import java.net.URISyntaxException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.enums.AccountPayableMenuItem;
import com.enums.PaymentType;
import com.excel.Xls_Reader;

import bluestrata.pages.AccountsPayablePage;
import bluestrata.pages.HomePage;
import bluestrata.pages.LoginPage;
import dweb.test.templates.TestTemplate;
import dweb.test.templates.TestTemplateMethodLevelInit;

public class AccountsPayableTestCases extends TestTemplateMethodLevelInit {
	
	Xls_Reader xlsReader = new Xls_Reader("C:\\Users\\hemanjitg\\Desktop\\BlueStrata\\LTC-AutomatedTests\\src\\test\\resources\\testdata\\BlueStrata_Data.xlsx");
	final String SheetName = "AccountsPayable";
	
	
	//@Test
	public void QA01_verifyAccountsPayable_CreateandPostInvoices(ITestContext testContext) throws URISyntaxException, InterruptedException, AWTException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA01";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.EnterInvoices.toString());
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
 	   accountsPayable.createBatch(testdata.get("BatchName"),testdata.get("Vendor"),testdata.get("PO"),testdata.get("Invoice"),testdata.get("InvoiceAmount"),testdata.get("Amount"));
 	  if(accountsPayable.verifyInvoiceBatch(testdata.get("BatchName"))==true && testdata.get("BatchName")!=null)
 	  {
 		 
 	   accountsPayable.postInvoice(testdata.get("BatchName"));
 	  }
 	  else 
 	  {
 		 Assert.assertTrue(false, "Invoice Batch not created succesfully");
 	  }
		
	}
	
	//@Test
	public void QA02_verifyAccountsPayable_CreateandDeleteInvoices(ITestContext testContext) throws URISyntaxException, InterruptedException, AWTException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA02";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.EnterInvoices.toString());
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
 	   accountsPayable.createBatch(testdata.get("BatchName"),testdata.get("Vendor"),testdata.get("PO"),testdata.get("Invoice"),testdata.get("InvoiceAmount"),testdata.get("Amount"));
		 if(accountsPayable.verifyInvoiceBatch(testdata.get("BatchName"))==true && testdata.get("BatchName")!=null)
	 	  {
	 	   accountsPayable.deleteInvoice(testdata.get("BatchName"));
	 	  }
	 	  else 
	 	  {
	 		 Assert.assertTrue(false, "Invoice Batch not created succesfully");
	 	  }
	    
	}
	
	//@Test
	public void QA03_verifyAccountsPayable_CreateRecurringAndPostInvoices(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA03";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.RecurringInvoices.toString());
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		accountsPayable.createRecurringInvoice(testdata.get("Vendor"),testdata.get("InvoiceAmount"));
		
	}
	
	//@Test
	public void QA04_verifyAccountsPayable_CreateRecurringAndDeleteInvoices(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA04";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.RecurringInvoices.toString());
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		accountsPayable.createRecurringInvoice(testdata.get("Vendor"),testdata.get("InvoiceAmount"));
		accountsPayable.deleteRecurringInvoice(testdata.get("Vendor"));
		
	
	}
	
	//@Test
	public void QA05_Vendor_createAndEditVendor(ITestContext testContext) throws URISyntaxException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA05";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.Vendors.toString());
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		accountsPayable.createVendor(testdata.get("Vendor"),testdata.get("AccountNumber"));
		accountsPayable.searchVendor(testdata.get("Vendor"));
		accountsPayable.EditVendor(testdata.get("EditAccountNumber"));
		xlsReader.setCellData(SheetName, "Vendor", xlsReader.getCellRowNum(SheetName, "Vendor",testdata.get("Vendor")), accountsPayable.generateString(testdata.get("Vendor"),testdata.get("UpdateVendor")));
	}
	
	@Test
	public void QA06_Vendor_createAndMakeVendorInactive(ITestContext testContext) throws URISyntaxException
	{
		
		
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA06";
		
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.Vendors.toString());
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		accountsPayable.createVendor(testdata.get("Vendor"),testdata.get("AccountNumber"));
		accountsPayable.searchVendor(testdata.get("Vendor"));
		accountsPayable.makeVendorInactive();
		accountsPayable.verifyInactiveVendor(testdata.get("Vendor"));
		xlsReader.setCellData(SheetName, "Vendor", xlsReader.getCellRowNum(SheetName, "Vendor",testdata.get("Vendor")), accountsPayable.generateString(testdata.get("Vendor"),testdata.get("UpdateVendor")));
		
		
		
	}
	
	
	//@Test
	public void QA07_AccountsPayableMenuItems_verifyMenuItems(ITestContext testContext) throws URISyntaxException
	{

		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.Vendors.toString());
		accountsPayable.verifyAccountsPayableMenuItems(AccountPayableMenuItem.Vendors.toString());
		
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.EnterInvoices.toString());
		accountsPayable.verifyAccountsPayableMenuItems(AccountPayableMenuItem.EnterInvoices.toString());
		
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.RecurringInvoices.toString());
		accountsPayable.verifyAccountsPayableMenuItems(AccountPayableMenuItem.RecurringInvoices.toString());
		
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.InvoiceList.toString());
		accountsPayable.verifyAccountsPayableMenuItems(AccountPayableMenuItem.InvoiceList.toString());
		
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.MakePayments.toString());
		accountsPayable.verifyAccountsPayableMenuItems(AccountPayableMenuItem.MakePayments.toString());
		
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.CheckRegister.toString());
		accountsPayable.verifyAccountsPayableMenuItems(AccountPayableMenuItem.CheckRegister.toString());
		
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.ClosePeriod.toString());
		accountsPayable.verifyAccountsPayableMenuItems(AccountPayableMenuItem.ClosePeriod.toString());
	}
	
	//@Test
	public void QA08_MakePayment_verifyCheckPayment(ITestContext testContext) throws URISyntaxException, InterruptedException, AWTException
	{
		
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		
		final String testCase = "QA08";
		
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.EnterInvoices.toString());
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
 	   accountsPayable.createBatch(testdata.get("BatchName"),testdata.get("Vendor"),testdata.get("PO"),testdata.get("Invoice"),testdata.get("InvoiceAmount"),testdata.get("Amount"));
 	  if(accountsPayable.verifyInvoiceBatch(testdata.get("BatchName"))==true && testdata.get("BatchName")!=null)
 	  {
 		 
 	   accountsPayable.postInvoice(testdata.get("BatchName"));
 	  }
 	  else 
 	  {
 		 Assert.assertTrue(false, "Invoice Batch not created succesfully");
 	  }
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.MakePayments.toString());
		accountsPayable.selectVendor(testdata.get("Vendor"));
		accountsPayable.makePayment(PaymentType.Check.toString());
		
		String transactionNo=accountsPayable.getTransactionNoText();
		accountsPayable.postPayment();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.CheckRegister.toString());
		accountsPayable.verifyTransactionNo(transactionNo);
		
		
	}
	
	//@Test
	public void QA09_MakePayment_verifyTransferPayment(ITestContext testContext) throws URISyntaxException, InterruptedException, AWTException
	{AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
	LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
	String userName = this.getTestParameter(testContext, "userName");
	String password = this.getTestParameter(testContext, "password");
	
	final String testCase = "QA09";
	
	login.login(userName, password);
	homepage.NavigateToAccountsPayable();
	accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.EnterInvoices.toString());
	HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
	   accountsPayable.createBatch(testdata.get("BatchName"),testdata.get("Vendor"),testdata.get("PO"),testdata.get("Invoice"),testdata.get("InvoiceAmount"),testdata.get("Amount"));
	  if(accountsPayable.verifyInvoiceBatch(testdata.get("BatchName"))==true && testdata.get("BatchName")!=null)
	  {
		 
	   accountsPayable.postInvoice(testdata.get("BatchName"));
	  }
	  else 
	  {
		 Assert.assertTrue(false, "Invoice Batch not created succesfully");
	  }
	accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.MakePayments.toString());
	accountsPayable.selectVendor(testdata.get("Vendor"));
	accountsPayable.makePayment(PaymentType.ACH.toString());
	accountsPayable.enterTransactionNo("12345");
	String transactionNo=accountsPayable.getTransactionNoText();
	accountsPayable.postPayment();
	accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.CheckRegister.toString());
	accountsPayable.verifyTransactionNo(transactionNo);
	
	}
	
	//@Test
	public void QA10_MakePayment_verifyCreditCardPayment(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		
		final String testCase = "QA10";
		
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.EnterInvoices.toString());
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
 	   accountsPayable.createBatch(testdata.get("BatchName"),testdata.get("Vendor"),testdata.get("PO"),testdata.get("Invoice"),testdata.get("InvoiceAmount"),testdata.get("Amount"));
 	  if(accountsPayable.verifyInvoiceBatch(testdata.get("BatchName"))==true && testdata.get("BatchName")!=null)
 	  {
 		 
 	   accountsPayable.postInvoice(testdata.get("BatchName"));
 	  }
 	  else 
 	  {
 		 Assert.assertTrue(false, "Invoice Batch not created succesfully");
 	  }
		
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.MakePayments.toString());
		accountsPayable.selectVendor(testdata.get("Vendor"));
		accountsPayable.makePayment(PaymentType.CreditCard.toString());
		accountsPayable.enterTransactionNo("78654");
		String transactionNo=accountsPayable.getTransactionNoText();
		accountsPayable.postPayment();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.CheckRegister.toString());
		accountsPayable.verifyTransactionNo(transactionNo);
		
	}
	
	//@Test
	public void QA11_Create_Vendor_with_Mandatory_field_validation_check(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA11";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.Vendors.toString());
		accountsPayable.createVendorWithoutData();
	}
	
	//@Test
	public void QA12_Verify_user_is_able_to_cancel_a_Vendor(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA12";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.Vendors.toString());
		accountsPayable.createVendorWithCancelCheck();
		
		
	}
	
	//@Test
	public void QA13_Verify_mandatory_validation_when_creating_invoices(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA13";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.EnterInvoices.toString());
		accountsPayable.verifyMandatoryFieldsForInvoice();
	}
	
	
	//@Test
	public void QA14_Verify_user_unable_to_create_invoice_with_invalid_data(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA14";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.EnterInvoices.toString());
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
 	   accountsPayable.createBatchWithInvalidData(testdata.get("InvoiceAmount"));
 	   
	}
	

	
	//@Test
	public void QA15_Verify_user_is_able_to_cancel_a_invoice(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA15";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.EnterInvoices.toString());
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
 	   accountsPayable.cancelBatch(testdata.get("BatchName"),testdata.get("Vendor"),testdata.get("PO"),testdata.get("Invoice"),testdata.get("InvoiceAmount"),testdata.get("Amount"));
	}
	
	//@Test
	public void QA16_Verify_mandatory_validation_when_creating_RecurringInvoices(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA16";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.RecurringInvoices.toString());
		accountsPayable.verifyMandatoryFieldsForRecurringInvoice();
		
	}
	
	//@Test
	public void QA17_Verify_user_unable_to_create_RecurringInvoice_with_invalid_data(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA17";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.RecurringInvoices.toString());
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
 	   accountsPayable.createRecurringInvoiceWithInvalidData(testdata.get("InvoiceAmount"));
	}
	
	//@Test
	public void QA18_Verify_user_is_able_to_cancel_a_RecurringInvoice(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA18";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.RecurringInvoices.toString());
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		accountsPayable.cancelRecurringInvoice(testdata.get("Vendor"),testdata.get("InvoiceAmount"));
	}
	
	@Test
	public void QA19_Verify_paid_Invoice_in_CheckRegister(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA01";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.EnterInvoices.toString());
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
 	   accountsPayable.createBatch(testdata.get("BatchName"),testdata.get("Vendor"),testdata.get("PO"),testdata.get("Invoice"),testdata.get("InvoiceAmount"),testdata.get("Amount"));
 	  if(accountsPayable.verifyInvoiceBatch(testdata.get("BatchName"))==true && testdata.get("BatchName")!=null)
 	  {
 		 
 	   accountsPayable.postInvoice(testdata.get("BatchName"));
 	  accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.MakePayments.toString());
 	 accountsPayable.selectVendor(testdata.get("Vendor"));
		accountsPayable.makePayment(PaymentType.Check.toString());
		
		String transactionNo=accountsPayable.getTransactionNoText();
		accountsPayable.postPayment();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.CheckRegister.toString());
		accountsPayable.verifyTransactionNo(transactionNo);
 	   
 	  }
 	  else 
 	  {
 		 Assert.assertTrue(false, "Invoice Batch not created succesfully");
 	  }
	}
	
	//@Test
	public void QA20_Verify_user_is_Able_to_setup_Payment_Terms(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA20";
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickPaymentTerms();
		accountsPayable.createPaymentTerms(testdata.get("DiscountPercent"),testdata.get("DiscountDays"),testdata.get("NetDue"));
		accountsPayable.verifyTerm(testdata.get("DiscountPercent"));
		accountsPayable.deleteTerm(testdata.get("DiscountPercent"));
	}
	
	//////@Test <---------Blocked------------>
	public void QA21_Verify_user_is_able_to_EditInvoice(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA01";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.EnterInvoices.toString());
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
 	   accountsPayable.createBatch(testdata.get("BatchName"),testdata.get("Vendor"),testdata.get("PO"),testdata.get("Invoice"),testdata.get("InvoiceAmount"),testdata.get("Amount"));
 	  if(accountsPayable.verifyInvoiceBatch(testdata.get("BatchName"))==true && testdata.get("BatchName")!=null)
 	  {
 		 
 		 accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.EnterInvoices.toString());
 		
 		 
 	  }
	}
	
	//@Test
	public void QA22_Verify_user_is_able_to_EditRecurringInvoice(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA22";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.RecurringInvoices.toString());
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		accountsPayable.createRecurringInvoice(testdata.get("Vendor"),testdata.get("InvoiceAmount"));
		accountsPayable.editRecurringInvoice(testdata.get("Vendor"));
	}
	
	//@Test
	public void QA23_Verify_user_gets_validation_message_when_batchname_is_empty(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA23";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.EnterInvoices.toString());
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		accountsPayable.validateEmptyBatch();

 	  
	}
	
	//@Test
	public void QA24_Verify_postedInvoices_displayed_in_InvoiceList(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA24";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.EnterInvoices.toString());
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
 	   accountsPayable.createBatch(testdata.get("BatchName"),testdata.get("Vendor"),testdata.get("PO"),testdata.get("Invoice"),testdata.get("InvoiceAmount"),testdata.get("Amount"));
 	  if(accountsPayable.verifyInvoiceBatch(testdata.get("BatchName"))==true && testdata.get("BatchName")!=null)
 	  {
 		 
 	   accountsPayable.postInvoice(testdata.get("BatchName"));
 	  accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.InvoiceList.toString());
 	  accountsPayable.verifyInvoiceList(testdata.get("Vendor"));
 	  }
 	  else 
 	  {
 		 Assert.assertTrue(false, "Invoice Batch not created succesfully");
 	  }
	}
	
	//@Test
	public void QA25_Verify_mandatory_validation_for_paymentTerms(ITestContext testContext) throws URISyntaxException, InterruptedException
	{

		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA25";
		xlsReader.GetValue(SheetName,testCase);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickPaymentTerms();
		accountsPayable.validatePaymentTerms();
	}
	
	//@Test
	public void QA26_Verify_user_is_able_to_update_paymentTerms(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA26";
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickPaymentTerms();
		accountsPayable.createPaymentTerms(testdata.get("DiscountPercent"),testdata.get("DiscountDays"),testdata.get("NetDue"));
		accountsPayable.verifyTerm(testdata.get("DiscountPercent"));
		accountsPayable.updatePaymentTerms(testdata.get("DiscountPercent"), testdata.get("EditDiscountPercent"),testdata.get("EditDiscountDays"),testdata.get("EditNetDue"));
		accountsPayable.verifyTerm(testdata.get("EditDiscountPercent"));
		accountsPayable.deleteTerm(testdata.get("EditDiscountPercent"));
	}
	
	//@Test
	public void QA27_Verify_user_is_able_to_delete_paymentTerms(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA27";
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickPaymentTerms();
		accountsPayable.createPaymentTerms(testdata.get("DiscountPercent"),testdata.get("DiscountDays"),testdata.get("NetDue"));
		accountsPayable.verifyTerm(testdata.get("DiscountPercent"));
		accountsPayable.deleteTerm(testdata.get("DiscountPercent"));
	}
	
	//@Test
	public void QA28_Verify_user_is_able_to_cancel_termDetails(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA28";
		HashMap<String ,String> testdata = xlsReader.GetValue(SheetName,testCase);
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickPaymentTerms();
		accountsPayable.cancelPaymentTerms(testdata.get("DiscountPercent"),testdata.get("DiscountDays"),testdata.get("NetDue"));
	}
	
	//@Test
	public void QA29_Verify_ClosePeriod_page_items(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		AccountsPayablePage accountsPayable=new AccountsPayablePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		HomePage homepage = new HomePage(threadLocalWebDriver.get(), TestTemplate.testReport);
		LoginPage login = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		
		final String testCase = "QA29";
		
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
		login.login(userName, password);
		homepage.NavigateToAccountsPayable();
		accountsPayable.clickAccountsPayableMenuItems(AccountPayableMenuItem.ClosePeriod.toString());
		accountsPayable.verifyClosePeriodItems();
		
	}
	
	//////@Test <---------Blocked------------>
	public void QA30_Verify_User_is_able_to_void_a_paidInvoice(ITestContext testContext) throws URISyntaxException, InterruptedException
	{
		
	}
	
	
	
		
		
	
	
	
	
	
	
}
