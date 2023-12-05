package com.OrangeHRM.genericUtils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		test=report.createTest(methodname);
		Reporter.log(methodname+" execution starts");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.PASS, methodname+"execution successfully done");
		Reporter.log(methodname+" execution is successfully done");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		WebDriver driver = null;
		String failedscript=WebDriverUtility.takeScreenShot(driver,"ss");
		test.addScreenCaptureFromPath(failedscript);
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, methodname);
		Reporter.log(methodname + "-----> Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, methodname +"skipped");
		Reporter.log(methodname+"--skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExetentReport/report.html");
		htmlreport.config().setReportName("Orange HRM");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setDocumentTitle("Orange");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "Wn=indow");
		report.setSystemInfo("BaseBrowser", "chrome");
		report.setSystemInfo("BaseURL", "");
		report.setSystemInfo("Reporter Name", "Mayur");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
}
