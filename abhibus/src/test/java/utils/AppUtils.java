package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class AppUtils
{
	public static ExtentReports report;
	public static ExtentTest test;
    public static WebDriver driver;
    
    @BeforeMethod
	@SuppressWarnings("deprecation")
	public static void launchBrowser()
    {
    	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		report = new ExtentReports("C:\\Users\\SPURGE\\Desktop\\Selenium\\abhibus\\reports\\report.html", true);
		test = report.startTest("extent report");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.abhibus.com/");	
    }
    
   
    
	@AfterMethod
	public static void CloseBrowser()
	{
		driver.close();
		report.endTest(test);
		report.flush();
	
	}
}


