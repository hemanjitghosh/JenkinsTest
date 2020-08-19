package dweb.aut.pages.templates;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.config.IConstants;
import com.config.ITestParamsConstants;
import com.testreport.ExtentReporter;
import com.testreport.IReporter;
import com.utilities.ReusableLibs;

/**
 * 
 * @author Abhishek Sarkar(Test Engineer)
 *
 */
public abstract class PageTemplate {
	private static final Logger LOG = Logger.getLogger(PageTemplate.class);
	protected WebDriver wd = null;
	protected IReporter testReport = null;
	protected int implicitWaitInSecs = 0;
	protected int pageLoadTimeOutInSecs = 0;

	protected PageTemplate(WebDriver webDriver, IReporter testReport) {
		this.wd = webDriver;
		this.testReport = testReport;
		this.implicitWaitInSecs = Integer
				.parseInt(ReusableLibs.getConfigProperty(ITestParamsConstants.IMPLICIT_WAIT_IN_SECS));
		this.pageLoadTimeOutInSecs = Integer
				.parseInt(ReusableLibs.getConfigProperty(ITestParamsConstants.PAGE_LOAD_TIME_OUT_IN_SECS));

	}

	protected void sendKeys(By byLocator, String text) {
		try {
			this.waitUntilElementIsClickable(byLocator);
			try {
				this.wd.findElement(byLocator).sendKeys(text);
				LOG.info(String.format("SendKeys Successful - (By - %s, text - %s)", byLocator, text));
				this.testReport.logSuccess("SendKeys",
						String.format("Entered Text - <mark>%s</mark> To Locator - <mark>%s</mark>", text, byLocator));
			} catch (Exception ex) {
				this.sendKeysWithJavascript(byLocator, text);
			}

		} catch (Exception ex) {
			LOG.error(String.format("Exception Encountered - %s", ex.getMessage()));
			this.testReport.logFailure("SendKeys", String
					.format("Failed To Enter Text - <mark>%s</mark> To Locator - <mark>%s</mark>", text, byLocator),
					this.getScreenShotName());
			this.testReport.logException(ex);

		}

	}

	private void sendKeysWithJavascript(By byLocator, String text) {
		try {
			this.waitUntilElementIsClickable(byLocator);
			((JavascriptExecutor) this.wd).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])",
					this.wd.findElement(byLocator), "value", text);
			LOG.info(String.format("sendKeysWithJavascript Successful - (By - %s, text - %s)", byLocator, text));
			this.testReport.logSuccess("sendKeysWithJavascript",
					String.format("Entered Text - <mark>%s</mark> To Locator - <mark>%s</mark>", text, byLocator));

		} catch (Exception ex) {
			LOG.error(String.format("Exception Encountered - %s", ex.getMessage()));
			this.testReport.logFailure("sendKeysWithJavascript", String
					.format("Failed To Enter Text - <mark>%s</mark> To Locator - <mark>%s</mark>", text, byLocator),
					this.getScreenShotName());
			this.testReport.logException(ex);

		}
	}	

	protected void sendKeysAsAction(By byLocator, String text) {
		try {
			this.waitUntilElementIsClickable(byLocator);
			WebElement we = this.wd.findElement(byLocator);
			Actions action = new Actions(this.wd);

			action.click(we).sendKeys(text).build().perform();
			LOG.info(String.format("sendKeysAsAction Successful - (By - %s, text - %s)", byLocator, text));
			this.testReport.logSuccess("sendKeysAsAction",
					String.format("Entered Text - <mark>%s</mark> To Locator - <mark>%s</mark>", text, byLocator));

		} catch (Exception ex) {
			LOG.error(String.format("Exception Encountered - %s", ex.getMessage()));
			this.testReport.logFailure("sendKeysAsAction", String
					.format("Failed To Enter Text - <mark>%s</mark> To Locator - <mark>%s</mark>", text, byLocator),
					this.getScreenShotName());
			this.testReport.logException(ex);

		}

	}

	protected void moveToElement(By byLocator) {
		try {
			this.waitUntilElementIsClickable(byLocator);
			Actions action = new Actions(this.wd);
			action.moveToElement(this.wd.findElement(byLocator)).build().perform();
			LOG.info(String.format("moveToElement Successful - (By - %s)", byLocator));
			this.testReport.logSuccess("moveToElement",
					String.format("moveToElement Performed On Locator - <mark>%s</mark>", byLocator));

		} catch (Exception ex) {
			LOG.error(String.format("Exception Encountered - %s", ex.getMessage()));
			this.testReport.logFailure("moveToElement",
					String.format("Failed To Perform moveToElement On Locator - <mark>%s</mark>", byLocator),
					this.getScreenShotName());
			this.testReport.logException(ex);

		}

	}
	
	
	protected void click(By byLocator , String ControlName) {
		try {
			this.waitUntilElementIsClickable(byLocator);
			try
			{
				if(!(this.wd instanceof InternetExplorerDriver)) //For Non IE Browsers
				{
					this.wd.findElement(byLocator).click();
				}
				else // For IE Browsers
				{
					this.clickWithJavascript(byLocator);
				}
			}
			catch(Exception ex)
			{
				this.clickWithJavascript(byLocator);
			}

			LOG.info(String.format("Click Successful - (By - %s)", ControlName));
			if (this.testReport != null) {
				this.testReport.logSuccess("Click",
						String.format("Click Performed On Locator - <mark>%s</mark>", ControlName ));
			}

		} catch (Exception ex) {
			LOG.error(String.format("Exception Encountered - %s", ex.getMessage()));
			if (this.testReport != null) {
				this.testReport.logFailure("Click",
						String.format("Failed To Perform Click On Locator - <mark>%s</mark>", ControlName ),
						this.getScreenShotName());
				this.testReport.logException(ex);
			}

		}

	}
	
	protected void clickWithJavascript(By byLocator) {
		try {
			this.waitUntilElementIsClickable(byLocator);
			((JavascriptExecutor) this.wd).executeScript("arguments[0].click();", this.wd.findElement(byLocator));

		} catch (Exception ex) {
			LOG.error(String.format("Exception Encountered - %s", ex.getMessage()));
			if (this.testReport != null) {
				this.testReport.logFailure("clickWithJavascript",
						String.format("Failed To Perform Click On Locator - <mark>%s</mark>", byLocator),
						this.getScreenShotName());
				this.testReport.logException(ex);
			}

		}
	}
	
	
	protected void SelectDropDownByText(By byLocator, String visibleText) {
		try {
			this.waitUntilElementIsClickable(byLocator);
			new Select(this.wd.findElement(byLocator)).selectByVisibleText(visibleText);
			LOG.info(String.format("SelectDropDownByText Successful - (By - %s, Visible Text - %s)", byLocator,
					visibleText));
			this.testReport.logSuccess("SelectDropDownByText", String.format(
					"Selected Visible Text - <mark>%s</mark> On Locator - <mark>%s</mark>", visibleText, byLocator));

		} catch (Exception ex) {
			LOG.error(String.format("Exception Encountered - %s", ex.getMessage()));
			this.testReport.logFailure("SelectDropDownByText",
					String.format(
							"Failed To Perform Select Visible Text - <mark>%s</mark> On Locator - <mark>%s</mark>",
							visibleText, byLocator),
					this.getScreenShotName());
			this.testReport.logException(ex);

		}
	}

	protected void SelectDropDownByValue(By byLocator, String value) {
		try {
			this.waitUntilElementIsClickable(byLocator);
			new Select(this.wd.findElement(byLocator)).selectByValue(value);
			LOG.info(String.format("SelectDropDownByValue Successful - (By - %s, Value - %s)", byLocator, value));
			this.testReport.logSuccess("SelectDropDownByValue",
					String.format("Selected Value - <mark>%s</mark> On Locator - <mark>%s</mark>", value, byLocator));

		} catch (Exception ex) {
			LOG.error(String.format("Exception Encountered - %s", ex.getMessage()));
			this.testReport.logFailure("SelectDropDownByText",
					String.format("Failed To Perform Select Value - <mark>%s</mark> On Locator - <mark>%s</mark>",
							value, byLocator),
					this.getScreenShotName());
			this.testReport.logException(ex);

		}
	}

	protected void SelectDropDownByIndex(By byLocator, int index) {
		try {
			this.waitUntilElementIsClickable(byLocator);
			new Select(this.wd.findElement(byLocator)).selectByIndex(index);
			LOG.info(String.format("SelectDropDownByIndex Successful - (By - %s, Index - %d)", byLocator, index));
			this.testReport.logSuccess("SelectDropDownByIndex",
					String.format("Selected Index - <mark>%s</mark> On Locator - <mark>%s</mark>", index, byLocator));

		} catch (Exception ex) {
			LOG.error(String.format("Exception Encountered - %s", ex.getMessage()));
			this.testReport.logFailure("SelectDropDownByText",
					String.format("Failed To Perform Select Index - <mark>%s</mark> On Locator - <mark>%s</mark>",
							index, byLocator),
					this.getScreenShotName());
			this.testReport.logException(ex);

		}
	}

	protected boolean checkCheckBox(By byLocator) {
		boolean isSuccess = false;
		try {
			// read check box web element and store to check box web element obj
			WebElement checkBox = this.wd.findElement(byLocator);

			// Wait until element is clickable
			this.waitUntilElementIsClickable(byLocator);

			// Click on check-box
			if (checkBox.isSelected()) {
				LOG.info("check-box already checked");
			} else {
				/*
				 * Actions act = new Actions(this.wd);
				 * act.moveToElement(checkBox).click().build().perform();
				 */
				checkBox.click();
				LOG.info("check-box checked successfully");
				this.testReport.logSuccess("checkCheckBox",
						String.format("check-box - <mark>%s</mark> checked successfully", byLocator));
			}
			isSuccess = true;
		} catch (Exception ex) {
			isSuccess = false;
			LOG.error(String.format("Exception Encountered - %s", ex.getMessage()));
			this.testReport.logFailure("checkCheckBox",
					String.format("Exception Encountered for <mark>%s</mark>", "checkCheckBox"),
					this.getScreenShotName());
			this.testReport.logException(ex);
		}
		return isSuccess;
	}

	protected String getAttribute(By byLocator, String attribute) {
		String attributeValue = null;
		try {
			this.waitUntilElementIsClickable(byLocator);
			attributeValue = this.wd.findElement(byLocator).getAttribute(attribute);
			LOG.info(String.format("Method - %s returns value - %s for attribute - %s for Locator - %s", "getAttribute",
					attributeValue, attribute, byLocator));
			this.testReport.logInfo(String.format(
					"Method - <mark>%s</mark> returns value - <mark>%s</mark> for attribute - <mark>%s</mark> for Locator - <mark>%s</mark>",
					"getAttribute", attributeValue, attribute, byLocator));

		} catch (Exception ex) {
			LOG.error(String.format("Exception Encountered - %s", ex.getMessage()));
			this.testReport.logFailure(
					String.format("getAttribute For Element - %s, For Attribute - %s", byLocator, attribute),
					String.format("Exception Encountered - %s, StackTrace - %s", ex.getMessage(), ex.getStackTrace()),
					this.getScreenShotName());

		}
		return attributeValue;

	}

	protected String getText(By byLocator) {
		String attributeValue = null;
		try {
			this.waitUntilElementIsClickable(byLocator);
			attributeValue = this.wd.findElement(byLocator).getText();
			LOG.info(String.format("Method - %s returns text - %s for Locator - %s", "getText", attributeValue,
					byLocator));
			this.testReport.logInfo(String.format(
					"Method - <mark>%s</mark> returns value - <mark>%s</mark> for Locator - <mark>%s</mark>", "text",
					attributeValue, byLocator));

		} catch (Exception ex) {
			LOG.error(String.format("Exception Encountered - %s", ex.getMessage()));
			this.testReport.logFailure(String.format("getText For Element - %s", byLocator),
					String.format("Exception Encountered - %s, StackTrace - %s", ex.getMessage(), ex.getStackTrace()),
					this.getScreenShotName());

		}
		return attributeValue;

	}

	protected boolean waitUntilElementIsClickable(By byLocator) {
		boolean isSuccess = false;
		try {
			WebDriverWait wait = new WebDriverWait(this.wd, this.implicitWaitInSecs);
			// wait.until(ExpectedConditions.elementToBeClickable(byLocator));
			LOG.info(String.format("Element clickable - (By - %s)", byLocator));
			this.testReport.logSuccess("waitUntilElementIsClickable",
					String.format("Element clickable - (By - %s)", byLocator));
			isSuccess = true;
		} catch (Exception ex) {
			isSuccess = false;
			LOG.error(String.format("Exception Encountered - %s", ex.getMessage()));
			this.testReport.logWarning("waitUntilElementIsClickable",
					String.format("Exception Encountered - %s, StackTrace - %s", ex.getMessage(), ex.getStackTrace()),
					this.getScreenShotName());
		}
		return isSuccess;
	}

	protected boolean waitUntilElementIsVisible(By byLocator) {
		boolean isSuccess = false;
		try {
			WebDriverWait wait = new WebDriverWait(this.wd, this.implicitWaitInSecs);
			// wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
			LOG.info(String.format("Element visible - (By - %s)", byLocator));
			this.testReport.logSuccess("waitUntilElementIsVisible",
					String.format("Element visible - (By - %s)", byLocator));
			isSuccess = true;
		} catch (Exception ex) {
			isSuccess = false;
			LOG.error(String.format("Exception Encountered - %s", ex.getMessage()));
			this.testReport.logWarning("waitUntilElementIsVisible",
					String.format("Exception Encountered - %s, StackTrace - %s", ex.getMessage(), ex.getStackTrace(),
							this.getScreenShotName()));
		}
		return isSuccess;
	}

	protected boolean waitUntilDataUpdatedInBackend(String dbUrl, HashMap<String, String> dbCredentials, String sql) {
		WebDriverWait wait = new WebDriverWait(this.wd, this.implicitWaitInSecs);
		return wait.until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver webDriver) {
				ResultSet resultSet = null;
				boolean isSuccess = false;
				try {
					Connection conn = DriverManager.getConnection(dbUrl, dbCredentials.get("userName"),
							dbCredentials.get("password"));
					Statement statement = conn.createStatement();
					resultSet = statement.executeQuery(sql);
					if (resultSet.next()) {
						isSuccess = true;
					}

				} catch (Exception ex) {
					isSuccess = false;
					LOG.error(String.format("Exception Encountered - %s", ex.getMessage()));

				}
				return isSuccess;

			}
		});

	}

	protected boolean isElementPresent(By byLocator) {
		boolean isSuccess = false;
		try {
			// validate element is displayed or not
			//waitInSecs(2);
			Assert.assertEquals(wd.findElements(byLocator).size() > 0, true);
			LOG.info(String.format("Element Present - (By - %s)", byLocator));
			this.testReport.logSuccess("isElementPresent", String.format("Element Present - (By - %s)", byLocator));
			isSuccess = true;
		} catch (Exception | AssertionError ex) {
			isSuccess = false;
			LOG.info(String.format("Element Not Prensent - (By - %s)", byLocator));
			this.testReport.logInfo(String.format("Element Not Prensent - (By - %s)", byLocator));
		}

		return isSuccess;
	}

	
	protected boolean isElementNotPresent(By byLocator) {
		boolean isSuccess = false;
		try {
			// validate element is displayed or not
			waitInSecs(2);
			Assert.assertEquals(wd.findElements(byLocator).size() <= 0, true);
			LOG.info(String.format("Element Not Present - (By - %s)", byLocator));
			this.testReport.logSuccess("isElementNotPresent", String.format("Element Not Present - (By - %s)", byLocator));
			isSuccess = true;
		} catch (Exception | AssertionError ex) {
			isSuccess = false;
			LOG.info(String.format("Element Prensent - (By - %s)", byLocator));
			this.testReport.logInfo(String.format("Element Prensent - (By - %s)", byLocator));
		}

		return isSuccess;
	}
	
	protected boolean isElementVisible(By byLocator ) {
		boolean isSuccess = false;
		try {
			// validate element is displayed or not
			waitInSecs(2);
			Assert.assertEquals(wd.findElement(byLocator).isDisplayed(), true);
			LOG.info(String.format("Element Present - (By - %s)", byLocator));
			this.testReport.logSuccess("isElementVisible", String.format("Element Present - (By - %s)", byLocator));
			isSuccess = true;
		} catch (Exception | AssertionError ex) {
			isSuccess = false;
			LOG.info(String.format("Element Not Prensent - (By - %s)", byLocator));
			this.testReport.logInfo(String.format("Element Not Prensent - (By - %s)", byLocator));
		}

		return isSuccess;
	}

	protected void waitInSecs(int sec) {
		try {
			TimeUnit.SECONDS.sleep(sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void dragAndDrop(By source, By target) {
		waitInSecs(3);
		// Read and store drag location
		WebElement drag = this.wd.findElement(source);

		// read and store drop location
		WebElement drop = this.wd.findElement(target);

		// drag and drop
		(new Actions(wd)).dragAndDrop(drag, drop).perform();
		LOG.info(String.format("Drag element - (By - %s)", source));
		LOG.info(String.format("drop element at - (By - %s)", target));
		waitInSecs(2);
	}

	protected synchronized String getScreenShotName() {
		String screenShotLocation = ReusableLibs.getConfigProperty(ITestParamsConstants.SCREENSHOT_LOCATION);
		String fileExtension = ReusableLibs.getConfigProperty(ITestParamsConstants.SCREENSHOT_PICTURE_FORMAT);
		return ReusableLibs.getScreenshotFile(screenShotLocation, fileExtension);
	}

	protected String getLocator(String key)
	{
		String locator = null;
		try
		{
			locator = ReusableLibs.getKeyValue(IConstants.AUT_CONFIG_FILE, key);
		}
		catch(Exception ex)
		{
			LOG.error(String.format("Exception Encountered - %s", ex.getMessage()));
		}
		return locator;
	}
	
	protected void AssettextEqual(By byLocator , By expectedByLocator )
	{
		String attributeValue = null;
		String expectedAttributeValue = null;
		try {
			this.isElementPresent(byLocator);
			attributeValue = this.wd.findElement(byLocator).getText();
			this.isElementPresent(expectedByLocator);
			expectedAttributeValue = this.wd.findElement(expectedByLocator).getText();
			if(attributeValue.equals(expectedAttributeValue))
			{
				this.testReport.logSuccess("Text Matching", String.format("Actual: <mark>{0}</mark>,Expected: <mark>{1}</mark> are matching", attributeValue, expectedAttributeValue));
			}
			
		}
		catch(Exception e)
		{
			this.testReport.logSuccess("Text Not Matching", String.format("Actual: <mark>{0}</mark>,Expected: <mark>{1}</mark> are not matching", attributeValue, expectedAttributeValue));
		}
		
	}
	
	 public void SendKeysToElementClearFirst( By locator, String text )
	        {

	            if ((this.wd instanceof InternetExplorerDriver))
	            {
	                wd.findElement(locator).clear();
	                this.waitUntilElementIsClickable(locator);
	                this.sendKeys(locator, text);
	                this.testReport.logSuccess("Click",
							String.format("Entered Text - <mark>%s</mark> To Locator - <mark>%s</mark>", text, locator));
	            }
	            else
	            {
	            	wd.findElement(locator).clear();
	            	this.waitUntilElementIsClickable(locator);
	                this.sendKeysAsAction(locator, text);
	                this.testReport.logSuccess("Click",
							String.format("Entered Text - <mark>%s</mark> To Locator - <mark>%s</mark>", text, locator));
	            }

}
	 public  void VerifyWebElementPresent( By locator, String controlName)
     {
         try
         {
        	 if(this.isElementPresent(locator))
             {
                 testReport.logSuccess("Element Present", String.format("Element is present - <mark>%s</mark>", controlName));
             }
             else
             {
                 testReport.logFailure("Element Not Present", String.format("Element not present - <mark>%s</mark>", controlName));
             }
         }
         catch (Exception e)
         {
             testReport.logFailure("Element Not Present", String.format("Element not present - <mark>%s</mark>", controlName));
         }

     }
	 
	 public void WaitForElementPresent( By locator, int sec ,String controlName)
	 {
		 try
		 {
			 for(int i=0;i<=sec ; i++)
			 {
				 if(this.isElementPresent(locator))
				 {
					 testReport.logSuccess("Element Present", String.format("Element is present - <mark>%s</mark>", controlName));
					 break;
				 }
			 }
		 }
		 catch(Exception ex)
		 {
			 testReport.logFailure("Element Not Present", String.format("Element not present - <mark>%s</mark>", controlName));
		 } 
	 }
	 
	 
	/* public void ElementIsDisable(By locator, String controlName)
	 {
		 try
         {
			 this.waitUntilElementIsClickable(locator);
			 {
			 testReport.logFailure("Element is Enable", String.format("Element is Enable - <mark>%s</mark>", controlName));
			 }
			 else
			 {
			 testReport.logSuccess("Element is Disable", String.format("Element is  Disable- <mark>%s</mark>", controlName));
			 }
	 }
	 
	 catch (Exception e)
     {
         testReport.logFailure("Element is Enable", String.format("Element is Enable - <mark>%s</mark>", controlName));
     }
 
	 
}*/
	 
	 public  void AssertTextEqual( By locator, String text)
     {
      //   String actual = "";
         
             if (this.isElementPresent(locator))
             {
            	 String actual = wd.findElement(locator).getText();
             //    Assert.assertEquals(actual, text);
              if(actual.equals(text)) 
              {
                 testReport.logSuccess("Verify Equal", String.format("Actual: <mark>%s</mark>,Expected: <mark>%s</mark> are matching", actual, text));
             }
             else
             {
                 testReport.logFailure("Verify Equal", String.format("Actual: <mark>%s</mark>,Expected: <mark>%s</mark> are not matching", actual, text));
             }
             }
         

     }
	 
	 public void VerifyWebElementNotPresent( By locator, String controlName)
	 {
		 try
		 {
			 if (this.isElementPresent(locator))
			 {
				 testReport.logFailure("Element Present", String.format("Element is present - <mark>%s</mark>", controlName));

			 }
			 else
			 {
				 testReport.logSuccess("Element Not Present", String.format("Element is not present - <mark>%s</mark>", controlName));

			 }
		 }
		 catch(Exception ex)
		 {

		 }

	 }
	 
	 public  void AssertTextNotEqual( By locator, String text)
     {
         String actual = "";
         
             if (this.isElementPresent(locator))
             {
                 actual = wd.findElement(locator).getText();
                 Assert.assertEquals(actual, text);
                 
                 testReport.logFailure("Verify Equal", String.format("Actual: <mark>%s</mark>,Expected: <mark>%s</mark> are  matching", actual, text));
             }
             else
             {
                 testReport.logSuccess("Verify Equal", String.format("Actual: <mark>%s</mark>,Expected: <mark>%s</mark> are not matching", actual, text));
             }
         
         

     }
	 
	 public void ClickENTER() throws AWTException
	 {
		 Robot robot = new Robot();
		 this.waitInSecs(3);
		 robot.keyPress(KeyEvent.VK_ENTER);
		 this.waitInSecs(3);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 this.waitInSecs(3);
	 }

	 public void assertText(String actual,String expected)
	 {
		if(actual.equals(expected))
		{
			testReport.logSuccess("Verify Equal", String.format("Actual: <mark>%s</mark>,Expected: <mark>%s</mark> are matching", actual, expected));
		}
		else
		{
			testReport.logFailure("Verify Equal", String.format("Actual: <mark>%s</mark>,Expected: <mark>%s</mark> are not  matching", actual, expected));
		}
	 }
	 public void assertText(boolean actual,boolean expected)
	 {
		if(actual==expected)
		{
			testReport.logSuccess("Verify Equal", String.format("Actual: <mark>%s</mark>,Expected: <mark>%s</mark> are matching", actual, expected));
		}
		else
		{
			testReport.logFailure("Verify Equal", String.format("Actual: <mark>%s</mark>,Expected: <mark>%s</mark> are not  matching", actual, expected));
		}
	 }
	 
	 
}

