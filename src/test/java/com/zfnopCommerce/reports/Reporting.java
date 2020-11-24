package com.zfnopCommerce.reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext context) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Test-Report" + timeStamp + ".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+reportName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("User","Suresh");
		
		htmlReporter.config().setDocumentTitle("ZF-nopCommerce Test project");
		htmlReporter.config().setReportName("Functional test cases");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult result) {
		logger = extent.createTest(result.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult result) {
		logger = extent.createTest(result.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		try {
			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			} 
		catch (IOException e) 
				{
				e.printStackTrace();
				}
		}
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
	
	
	
	
	
}
