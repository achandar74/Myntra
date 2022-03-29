package com.testcases.myntra.usingtestng;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testcase.myntra.usingtestng.LuggagesAndTrolleysSectionPage;
import com.testcase.myntra.usingtestng.MyntraHomepage;

public class VerifyToViewSelectedProduct {
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
	public void verifyViewSelectProduct() {		
		MyntraHomepage luggageAndTrolleys = new MyntraHomepage(driver);
		luggageAndTrolleys.verifyMenSubMenu();
		luggageAndTrolleys.verifyMenSubMenu();
		luggageAndTrolleys.NavigateToLuggagesAndTrolleysSectionPage();

		LuggagesAndTrolleysSectionPage view = new LuggagesAndTrolleysSectionPage(driver);
		view.verifyTitleandObjectsInLuggagesAndTrolleysSectionPage();
		view.verifyProductFilter();
		view.verifyProductDetails();
	}

	@AfterMethod
	public void closeDriver() {
		driver.close();
		driver.quit();
	}
}
