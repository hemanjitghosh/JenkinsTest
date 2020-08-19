package com.qa.Utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.qa.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JiraXray extends BaseTest {
	
	
	public static void getDefectDetails()
	{
		
			RestAssured.baseURI = "http://localhost:8082/rest/api/latest/search";
		 
	        //Request is specified on basis of the URI
	    
			RequestSpecification httpRequest = RestAssured.given().log().all().auth().preemptive().basic("hemanjit.ghosh", "password1")
	        		.queryParam("jql", "project=MRRHEAL&issuetype=Bug");
	 
	        //Makes calls to the server using Method type.
	        Response response = httpRequest.get();
	        
	        JsonPath js=new JsonPath(response.asString());
	        System.out.println("Response code is" +response.getStatusCode());
	        
	    	//System.out.println("js is:"+js.prettyPrint());
	    	try {
	            String str = js.prettyPrint();
	            File newTextFile = new File("C:\\Users\\hemanjitg\\Desktop\\test.txt");

	            FileWriter fw = new FileWriter(newTextFile);
	            fw.write(str);
	            fw.close();

	        } catch (IOException iox) {
	            //do stuff with exception
	            //iox.printStackTrace();
	        }
	        List values = js.getList("issues");
	        System.out.println(values.size());
	        for (int i=0;i<values.size();i++)
	        {
	        
	        	//System.out.println("Values are:-"+values.get(i));
	        
	        }
	        System.out.println(values.size());
	    	String totalDefects=js.get("issues[0].key");
	    	String totalDefects1=js.get("issues[1].key");
	    	String totalDefects2=js.get("issues[2].key");
	    	//String str=js.getJsonObject("issue");
	    	//System.out.println(str);
	    	
	    	System.out.println("Total no of defects is" +totalDefects +totalDefects1 +totalDefects2);
	        
		
	}
	
	
	public static int getTestCaseId(String testCaseName)
	{
		
		System.out.println("Cinfig val:" +getConfigProperty("TestRun"));
	
		RestAssured.baseURI = "http://localhost:8082/rest/raven/1.0/api/testexec/"+getConfigProperty("TestRun")+"/test";
		 
        //Request is specified on basis of the URI
      
		RequestSpecification httpRequest = RestAssured.given().log().all().auth().preemptive().basic("hemanjit.ghosh", "password1");
        		
		//Makes calls to the server using Method type.
        Response response = httpRequest.get();
        
        JsonPath js=new JsonPath(response.asString());
        System.out.println("Response code is" +response.getStatusCode());
        
    	
    	List list=js.getList("id");
    	
    	int id=0;
    	for(int i=0;i<list.size();i++)
    	{
    		
    		if(js.getString("key["+i+"]").equals(testCaseName))
    		{
    			id=js.getInt("id["+i+"]");
    			
    		}
    	}
    	System.out.println("ID of testcase:"+testCaseName+" is "+id );
    	
    	
    	return id;
    	
	}
	
	public static void passTestCase(String id)
	{
		RestAssured.baseURI = "http://localhost:8082/rest/raven/1.0/api/testrun/"+id+"/status";
		 
        //Request is specified on basis of the URI
      
		RequestSpecification httpRequest = RestAssured.given().log().all().auth().preemptive().basic("hemanjit.ghosh", "password1")
		.queryParam("status", "PASS");
		//Makes calls to the server using Method type.
        Response response = httpRequest.put();
        
        JsonPath js=new JsonPath(response.asString());
        System.out.println("Response code is" +response.getStatusCode());
		
	}
	
	public static void failTestCase(String id)
	{
		RestAssured.baseURI = "http://localhost:8082/rest/raven/1.0/api/testrun/"+id+"/status";
		 
        //Request is specified on basis of the URI
      
		RequestSpecification httpRequest = RestAssured.given().log().all().auth().preemptive().basic("hemanjit.ghosh", "password1")
		.queryParam("status", "FAIL");
		//Makes calls to the server using Method type.
        Response response = httpRequest.put();
        
        JsonPath js=new JsonPath(response.asString());
        System.out.println("Response code is" +response.getStatusCode());
		
	}
	
	public static void main(String[] args) {
		
	//JiraXray.getTestCaseId("MRRHEAL-9");
		//JiraXray.getDefectCount();
		System.out.println("Cinfig val:" +getConfigProperty("TestRun"));

		
	}

}
