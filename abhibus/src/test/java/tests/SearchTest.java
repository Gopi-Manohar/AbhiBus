package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import Pages.LaunchPage;
import utils.AppUtils;

public class SearchTest extends AppUtils 
{
	@Test(priority=1)
	public void Test1() throws InterruptedException 
	{
		test.log(LogStatus.INFO, "Search test has started");
		report = new ExtentReports("SearchTest");
		LaunchPage lp = new LaunchPage(driver);
		lp.searchList("Hyderabad", "Vijayawada");
		lp.selectFromDate("March", "4");
		lp.search();
		test.log(LogStatus.PASS, "Search test has passed");
		
	}
	
	@Test(priority=2)
	public void Test2() throws InterruptedException 
	{
		test.log(LogStatus.INFO, " test2 has started");
		LaunchPage lp = new LaunchPage(driver);
		lp.searchListWithInvalidData("hyderabad", "vizag");
		lp.selectFromDate("March", "4");
		lp.search();
		test.log(LogStatus.PASS, "test2 has passed");

	}
	@Test(enabled=false)
	public void Returntest() throws InterruptedException 
	{
		test.log(LogStatus.INFO, "return test has started");
		LaunchPage lp = new LaunchPage(driver);
		lp.searchList("Hyderabad", "Vijayawada");
		lp.selectFromDate("March", "4");
		Thread.sleep(2000);
		
		lp.selectToDate("March", "7");
		lp.search();
		
		test.log(LogStatus.PASS, "return test has passed");

	}

}
