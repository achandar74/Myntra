package com.testcases.myntra.usingtestng;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.testcase.myntra.usingtestng.MyntraHomepage;

public class VerifyHomePageTitleAndObjects {
	
	
	
	private WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\JANARDHAN\\Downloads\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setCapability("disable-popup-blocking", true);
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.myntra.com/");
	}

	@Test
	public void verifyhomePage() {
		MyntraHomepage homepage = new MyntraHomepage(driver);
		homepage.verifyTitleandObjectsInHomepage();

	}

	@AfterMethod
	public void closeDriver() {
		driver.close();
		driver.quit();
	}

	@Parameters({ "url" })
	@Test
	public void url(String urlname) {
		System.out.println(urlname);
	}
}
