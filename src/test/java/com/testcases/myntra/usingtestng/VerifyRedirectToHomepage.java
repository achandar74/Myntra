package com.testcases.myntra.usingtestng;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class VerifyRedirectToHomepage {
	private WebDriver driver;

@Test
	public void verifynavigateToHomePage() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\JANARDHAN\\Downloads\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();

	options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
	options.setCapability("disable-popup-blocking", true);
	options.addArguments("--disable-notifications");
	WebDriver driver = new ChromeDriver(options);

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.myntra.com/");
	}

@AfterMethod
public void closeDriver() {
	driver.close();
	driver.quit();
}

}
