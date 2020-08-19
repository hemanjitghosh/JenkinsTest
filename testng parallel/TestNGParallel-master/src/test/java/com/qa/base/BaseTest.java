package com.qa.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseTest {

    //Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
	public static Properties config = new Properties();
   // protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	protected static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal();
    public CapabilityFactory capabilityFactory = new CapabilityFactory();
    public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(BaseTest.class);
	public static String screenshotPath;
	public static String screenshotName;
	//public static WebDriver driver;
    
    @Parameters(value={"browser"})
    @BeforeMethod
    public void setup (String browser) throws MalformedURLException {
        //Set Browser to ThreadLocalMap
        driver.set(new RemoteWebDriver(new URL("http://172.31.33.4:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
    	/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\hemanjitg\\Desktop\\TestNGParallel-master\\TestNGParallel-master\\src\\test\\resources\\driver\\chromedriver.exe");
    	driver=new ChromeDriver();*/
    }

   public void login_mrr(){
	   getDriver().navigate().to(config.getProperty("mrrtestsiteurl"));
       WebDriverWait wait = new WebDriverWait(getDriver(), 240);
       wait.until(ExpectedConditions
                  .elementToBeClickable(By.xpath("//*[@id='username']"))).sendKeys("albertr");
       getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");
       getDriver().findElement(By.xpath("//input[@id='kc-login']")).click();
       getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='fa fa-spinner fa-2x fa-spin loader-icon']")));
   }
   
   public void goToChartRepository(){
	   login_mrr();
	   WebDriverWait wait = new WebDriverWait(getDriver(), 240);
	   wait.until(ExpectedConditions.elementToBeClickable(By.id("chartRepositoryTab"))).click();
       wait.until(ExpectedConditions.alertIsPresent());
       getDriver().switchTo().alert().accept();
   }
   
   public void goToChases(){
	   login_mrr();
	   WebDriverWait wait = new WebDriverWait(getDriver(), 240);
	   wait.until(ExpectedConditions.elementToBeClickable(By.id("chasesTab"))).click();
   }
   
    public WebDriver getDriver() {
        //Get driver from ThreadLocalMap
       return driver.get();
      //return driver;
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
       driver.remove();
        
    }
    
    public void navigate(String url)
    {
    	getDriver().navigate().to(url);
    }
    
    @BeforeSuite
    public void init()
    {
    	try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			config.load(fis);
			log.debug("Config file loaded !!!");
		} catch (FileNotFoundException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
			log.debug("OR file loaded !!!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
   
    public void click(String locator) {

		if (locator.endsWith("_CSS")) {
			getDriver().findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			getDriver().findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			getDriver().findElement(By.id(OR.getProperty(locator))).click();
		}
		
	}

	public void type(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			getDriver().findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			getDriver().findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			getDriver().findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}

	

	}
	
	public static String getConfigProperty(String sKeyName)
    {
        
            Properties prop = new Properties();          

            FileInputStream file;
			try {
				file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
				prop.load(file);
			} 
			
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
            String sValue = prop.getProperty(sKeyName);
            return sValue;
        
        
    }

    

   

	

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}
	
	protected boolean isElementPresent(By byLocator) {
		boolean isSuccess = false;
		try {
			// validate element is displayed or not
			//waitInSecs(2);
			Assert.assertEquals(getDriver().findElements(byLocator).size() > 0, true);
			isSuccess = true;
		} catch (Exception e) {
			isSuccess = false;
			
		}
		catch(AssertionError e)
		{
			isSuccess = false;
		
		}
		return isSuccess;
	}
	
	public static  String  MRRAuthorizationToken() 
	{ 
	RestAssured.baseURI= "http://10.1.23.122:8780/auth/realms/uam/protocol/openid-connect/token"; 
	Response response = RestAssured.given()
			.config(RestAssured.config()
					.encoderConfig(EncoderConfig.encoderConfig()
					.encodeContentTypeAs("x-www-form-urlencoded",
					ContentType.URLENC)))
					.contentType("application/x-www-form-urlencoded; charset=UTF-8")
					.formParam("client_id", "mrrapp")
					.formParam("grant_type", "password")
					.formParam("username", "albertr").
					formParam("password", "password")
					.post();
	System.out.println("Status code for MRR token:-"+response.getStatusCode());
	
	JsonPath js=new JsonPath(response.asString());
	System.out.println("js is:"+js);
	String token=js.get("access_token");
	System.out.println("token is:"+token);
	
	return token;
	} 
	
	public String  MRRgetUserInfo(String param) 
	{ 
	RestAssured.baseURI= "http://10.1.23.122:8880/uam/getUserInfo/albertr"; 
	Response response = RestAssured.given().header("Authorization", "bearer "+BaseTest.MRRAuthorizationToken()).get();
	JsonPath js=new JsonPath(response.asString());
	
	System.out.println(response.getStatusCode());
	System.out.println("js is:"+js);
	String paramValue=js.get(param);
	System.out.println("User Name is:"+js.get("userName"));
	System.out.println("User Name is:"+js.get("email"));
	System.out.println("User Name is:"+js.get("firstName"));
	System.out.println("User Name is:"+js.get("lastName"));
	return paramValue;
	}
	
	public Response  getResponseBodyUserInfo() 
	{ 
	RestAssured.baseURI= "http://10.1.23.122:8880/uam/getUserInfo/albertr"; 
	Response response = RestAssured.given().header("Authorization", "bearer "+BaseTest.MRRAuthorizationToken()).get();
	return response;
	
	
	}
	
	public int  invalidAuthToken() 
	{ 
	RestAssured.baseURI= "http://10.1.23.122:8880/uam/getUserInfo/albertr"; 
	Response response = RestAssured.given().header("Authorization", "bearer "+"invalidtoken").get();
	return response.getStatusCode();
	}
   /* @AfterClass void terminate () {
        //Remove the ThreadLocalMap element
        driver.remove();
    }*/
}