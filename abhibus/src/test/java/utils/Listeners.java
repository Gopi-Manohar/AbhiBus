package utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Pages.TakeScreenShot;

public class Listeners extends TakeScreenShot implements ITestListener
{

	public void onFinish(ITestContext arg0) 
	{
		System.out.println("The test is Finished");
		
	}

	public void onStart(ITestContext arg0) {
		System.out.println("The test is started");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("The test is failed with in success Percentage");
		
	}

	public void onTestFailure(ITestResult arg0) {
		System.out.println("The test is failed");
		try {
			screenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("The test is skipped");
		
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("The test is started");
		
	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println("The test is succeded");
		
	}
	
}
