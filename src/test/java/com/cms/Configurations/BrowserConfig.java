package com.cms.Configurations;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BrowserConfig {

	public static  WebDriver driver;
	Properties prop = new Properties();
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String Resultfilename;
	

	private String strbrowser,strenvrironemnt;
	
	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void setup(String browser,String environment) throws Exception {
		// Check if parameter passed from TestNG is 'firefox'
		this.strbrowser = browser;
		this.strenvrironemnt = environment;
		readConfig();
		if (browser.equalsIgnoreCase("firefox")) {

			// create firefox instance

			driver = new FirefoxDriver();

		}

		// Check if parameter passed as 'chrome'

		else if (browser.equalsIgnoreCase("chrome")) {

			// set path to chromedriver.exe You may need to download it from
			// http://code.google.com/p/selenium/wiki/ChromeDriver
			File f = new File("Drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",f.getAbsolutePath() );

			// create chrome instance

			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("ie")) {
			File f = new File("Drivers/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", f.getAbsolutePath());
			driver = new InternetExplorerDriver();
			DesiredCapabilities capability;
			capability = DesiredCapabilities.internetExplorer();
			capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		}

		else {

			// If no browser passed throw exception

			throw new Exception("Browser is not correct");

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		

	}

	
		@BeforeMethod
		public void beforemethod(Method method){
			Resultfilename = method.getName();
			reportcreation();
			test = extent.startTest((this.getClass().getSimpleName()+"::"+method.getName()),method.getName());	
			if(!(driver==null)){
				test.log(LogStatus.PASS, "Browser "+getBrowser()+" Launched Sucessfully");
			}else{
				test.log(LogStatus.FAIL, "Unable to Launch Browser"+getBrowser());
			}
		}
		
		
		@AfterMethod
		 public void aftermethod()
		 {
		  driver.quit();
		  test.log(LogStatus.PASS, "Browser Closed Sucessfully");
		  extent.endTest(test);
		 }
		
		@AfterSuite
		public void aftersuite(){
			extent.flush();
			extent.close();
			
		}
		
		// Method returns the actual driver instance..
		public WebDriver getDriver() {
			return this.driver;
		}
		
		// Method returns the actual browser name..
		public String getBrowser() {
			return this.strbrowser;
		}
		
		// Method returns the actual browser name..
		public String getEnvrironment() {
			return this.strenvrironemnt;
		}
		
		@SuppressWarnings("deprecation")
		public void reportcreation(){
			File f = new File("/Results");
			String Reportpath = f.getAbsolutePath();
			
			extent = new ExtentReports(Reportpath+"\\"+Resultfilename+"."+"html",true);
			extent.config()
            .documentTitle("Automation Report")
            .reportName("Regression");
		}
		
		//Success Report
		public void SuccessReport(String Stepdetails)
		{
			test.log(LogStatus.PASS, Stepdetails);
		}
		
		public void FailureReport(String Stepdetails)
		{
			test.log(LogStatus.FAIL, Stepdetails);
		}
		
		//read config properties from config properties
		public Properties readConfig()
		{	
			

			try {		
				FileInputStream  input = new FileInputStream("D:\\SampleTestProject\\CMS\\config.properties");
			
				prop.load(input);
				
			} catch (IOException e) {

				
				//	e.printStackTrace();
			}
			catch (NullPointerException e) {

				
				//	e.printStackTrace();
			}

			return prop;
		}
		
}
