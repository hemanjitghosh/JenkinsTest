package com.qa.testcases;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.qa.Utilities.JiraXray;

public class XrayTestCases {
	
	
	
	@Test
	public void Test1(ITestContext context)
	{
		String testCaseName="MRRHEAL-4";
		 ThreadLocal<String> tcId = new ThreadLocal<String>();
		tcId.set(Integer.toString(JiraXray.getTestCaseId(testCaseName)));
		
		context.setAttribute("TestCaseId", tcId.get());
		Assert.assertTrue(true);
		
		
	}
	
	@Test
	public void Test2(ITestContext context)
	{
		String testCaseName="MRRHEAL-7";
		ThreadLocal<String> tcId = new ThreadLocal<String>();
		tcId.set(Integer.toString(JiraXray.getTestCaseId(testCaseName)));
		
		context.setAttribute("TestCaseId", tcId.get());
		Assert.assertTrue(true);
	}
	
	@Test
	public void Test3(ITestContext context)
	{
		String testCaseName="MRRHEAL-9";
		ThreadLocal<String> tcId = new ThreadLocal<String>();
		tcId.set(Integer.toString(JiraXray.getTestCaseId(testCaseName)));
		
		context.setAttribute("TestCaseId", tcId.get());
		Assert.fail();
	}
	
	@Test
	public void Test4(ITestContext context)
	{
		String testCaseName="MRRHEAL-10";
		ThreadLocal<String> tcId = new ThreadLocal<String>();
		tcId.set(Integer.toString(JiraXray.getTestCaseId(testCaseName)));
		
		context.setAttribute("TestCaseId", tcId.get());
		Assert.fail();
	}
	public static void main(String[] args) {
		
		
	}
}
