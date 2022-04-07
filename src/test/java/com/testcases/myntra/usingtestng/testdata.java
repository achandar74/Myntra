package com.testcases.myntra.usingtestng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class testdata {
ExtentReports extent;
	@BeforeTest
	public void config() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation");
		reporter.config().setDocumentTitle("Testing");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Chandar");
	}
	@Test
	public void data() {
		ExtentTest test=extent.createTest("loginpage");
		System.out.println("chandar");
		extent.flush();
	}
	

}
