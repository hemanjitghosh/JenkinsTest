package com.qa.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;



import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.Utilities.ExtentManager;
import com.qa.base.BaseTest;
import com.qa.Utilities.*;


public class CustomListeners extends BaseTest implements ITestListener,ISuiteListener {

	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	static String messageBody;
	private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+fileName);
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

	private String tcId;
	

	public void onTestStart(ITestResult result) {

		ExtentTest test = extent.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());
        testReport.set(test);
        CustomListeners.testReport.get().log(Status.INFO, result.getTestContext().getName());
        
        CustomListeners.testReport.get().log(Status.INFO, result.getMethod().getMethodName());
        

	}

	public void onTestSuccess(ITestResult result) {

		
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(m);
		System.out.println("ID of TC !!!" +result.getTestContext().getAttribute("TestCaseId").toString());
		JiraXray.passTestCase(result.getTestContext().getAttribute("TestCaseId").toString());
		

	}

	public void onTestFailure(ITestResult result) {

		
		 CustomListeners.testReport.get().log(Status.FAIL, result.getMethod().getMethodName() +"Failed");
		
		String excepionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
				+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
		
		try {

			//BaseTest.captureScreenshot();
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(BaseTest.screenshotName)
							.build());
		} catch (IOException e) {

		}
		
		String failureLogg="TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);
		System.out.println("ID of TC !!!" +result.getTestContext().getAttribute("TestCaseId").toString());
		JiraXray.failTestCase(result.getTestContext().getAttribute("TestCaseId").toString());
		

	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

		

	}

	public void onFinish(ISuite arg0) {
		
		
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		int tests=context.getFailedTests().size()+context.getPassedTests().size()+context.getSkippedTests().size();
		
		double successRate=(Double.valueOf(context.getPassedTests().size())/tests)*100;
		
		System.out.println("Failed tests:-"+context.getFailedTests().size());
		System.out.println("Passed Tests:-"+context.getPassedTests().size());
		System.out.println("Skipped Tests:-"+context.getSkippedTests().size());
		System.out.println("Total Tests Executed:-"+tests);
		System.out.println("Success Rate of Test Execution" +successRate);

		if (extent != null) {

			extent.flush();
		}
		
	}


}