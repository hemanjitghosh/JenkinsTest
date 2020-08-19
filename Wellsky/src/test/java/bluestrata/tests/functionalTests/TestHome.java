package bluestrata.tests.functionalTests;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import bluestrata.pages.LoginPage;
import dweb.test.templates.TestTemplate;
import dweb.test.templates.TestTemplateMethodLevelInit;

public class TestHome extends TestTemplateMethodLevelInit {
	
	@Test
	public void testLogin(ITestContext testContext)
	{
		String userName = this.getTestParameter(testContext, "userName");
		String password = this.getTestParameter(testContext, "password");
	//	String key = this.getTestParameter(testContext, "key");
		LoginPage loginPage = new LoginPage(threadLocalWebDriver.get(), TestTemplate.testReport);
		loginPage.login(userName, password);
	}

}
