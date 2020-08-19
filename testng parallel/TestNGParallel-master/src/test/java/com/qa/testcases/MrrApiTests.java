package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.base.BaseTest;
import com.qa.listeners.CustomListeners;

import io.restassured.path.json.JsonPath;

public class MrrApiTests extends BaseTest {
	
	
	
	@Test
	public void QA01_verifyUserName()
	{
		CustomListeners.testReport.get().log(Status.INFO, "Verify User Name");
		String userName=MRRgetUserInfo("userName");
		Assert.assertEquals(userName, "albertr");
		CustomListeners.testReport.get().log(Status.INFO, "UserName verified successfully");
		
	}
	
	@Test
	public void QA02_verifyEmail()
	{
		CustomListeners.testReport.get().log(Status.INFO, "Verify Email Address");
		String email=MRRgetUserInfo("email");
		Assert.assertEquals(email, "albertR@hank.com");
		CustomListeners.testReport.get().log(Status.INFO, "Email verified successfully");
		
		
	}
	
	@Test
	public void QA03_verifyFirstName()
	{
		CustomListeners.testReport.get().log(Status.INFO, "Verify FirstName");
		String firstName=MRRgetUserInfo("firstName");
		Assert.assertEquals(firstName, "AlbertR");
		CustomListeners.testReport.get().log(Status.INFO, "FirstName verified successfully");
	}
	
	@Test
	public void QA04_verifyLastName()
	{
		CustomListeners.testReport.get().log(Status.INFO, "Verify Last Name");
		String lastName=MRRgetUserInfo("lastName");
		Assert.assertEquals(lastName, "Hank");
		CustomListeners.testReport.get().log(Status.INFO, "LastName verified successfully");
	}
	
	@Test
	public void QA05_verifyResponseCode()
	{
		CustomListeners.testReport.get().log(Status.INFO, "Verify Response Code");
		int statusCode=getResponseBodyUserInfo().statusCode();
		Assert.assertEquals(statusCode, 200);
		CustomListeners.testReport.get().log(Status.INFO, "Response code verified successfully");
	}
	
	@Test
	public void QA06_verifyUserStatusCode()
	{
		CustomListeners.testReport.get().log(Status.INFO, "Verify UserStatus Code");
		String userStatus=MRRgetUserInfo("status.code");
		Assert.assertEquals(userStatus, "Active");
		CustomListeners.testReport.get().log(Status.INFO, "User Status code verified successfully");
	}
	
	@Test
	public void QA07_verifyUserDescription()
	{
		CustomListeners.testReport.get().log(Status.INFO, "Verify User description");
		String desc=MRRgetUserInfo("status.description");
		Assert.assertEquals(desc, "Status Is Active");
		CustomListeners.testReport.get().log(Status.INFO, "User description verified successfully");
	}
	
	@Test
	public void QA08_verifyUserDesignation()
	{
		CustomListeners.testReport.get().log(Status.INFO, "Verify User Designation");
		String designation=MRRgetUserInfo("designation");
		Assert.assertEquals(designation, "test2");
		CustomListeners.testReport.get().log(Status.INFO, "User Designation verified successfully");
	}
	
	@Test
	public void QA09_verifyContactNo()
	{
		CustomListeners.testReport.get().log(Status.INFO, "Verify Contact no");
		String contactNo=MRRgetUserInfo("contactNo");
		Assert.assertEquals(contactNo, "1234567890");
		CustomListeners.testReport.get().log(Status.INFO, "Contact no verified successfully");
	}
	
	@Test
	public void QA10_verifyFaxNo()
	{
		CustomListeners.testReport.get().log(Status.INFO, "Verify Fax no");
		String faxNo=MRRgetUserInfo("faxNo");
		Assert.assertEquals(faxNo, "2221212121");
		CustomListeners.testReport.get().log(Status.INFO, "Fax no verified successfully");
	}
	
	@Test
	public void QA11_verifyResponseInvalidToken()
	{
		CustomListeners.testReport.get().log(Status.INFO, "Verify Invalid token");
		boolean flag=true;
		int statusCode=invalidAuthToken();
		if(statusCode!=200)
		{
			flag=false;
		}
		Assert.assertEquals(true, flag);
	
	}
	
	
	

}
