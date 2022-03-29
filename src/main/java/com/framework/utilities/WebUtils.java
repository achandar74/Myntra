package com.framework.utilities;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebUtils {
	private WebDriver driver;
	WebUtils(WebDriver webDriver){
		driver = webDriver;
	}
	
	
	/*
	 * parameters webelement and testdata
	 * enter testdata into webelement
	 */
	private void enterText(WebElement element,String testdata) {
		element.sendKeys(testdata);
	}
	
	/*
	 * parameter string
	 * enter url
	 */
	private void navigate(String url) {
		driver.navigate().to(url);
		
	}
	
	/*
	 * parameter webelement 
	 * click the webelement
	 */
	private void click(WebElement element) {
		element.click();
	}
	
	/*
	 * parameters webelement and string
	 * clear the webelement
	 * enter testdata into webelement
	 */
	private void clickAndEnter(WebElement element,String testdata) {
		element.clear();
		element.sendKeys(testdata);
	}
	
	/*
	 * parameters webdriver and int
	 * driver implicitly wait until i second
	 * 	
	 */
	private void implicitwait(WebDriver driver,int i) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
	}
	
	/*
	 * parameteres string and int
	 * enter chars and size
	 * it generate the random alphabet
	 */
	private static String generateRndAlphabet(String chars,int size) {
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		}
		return sb.toString();
	}
	
	/*
	 * parameter webelement
	 * checks whether it is displayed
	 */
	private static void verifyIsDisplayed(WebElement element) {
		Assert.assertTrue(element.isDisplayed(),""+element+" should display");
	}
	
	/*
	 * parameter webelement
	 * checks whether it is enabled
	 */
	private static void verifyIsEnabled(WebElement element) {
		Assert.assertTrue(element.isEnabled(),""+element+" should enabled");
	}
	
	/*
	 * parameter webelement
	 * checks whether it is selected
	 */
	private static void verifyIsSelected(WebElement element) {
		Assert.assertTrue(element.isSelected(),""+element+" should selected");
	}
	
	/*
	 * parameter webdriver
	 * it accepts the alert
	 */
	private static void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/*
	 * parameter webdriver
	 * it dismiss the alert
	 */
	private static void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/*
	 * parameter webdriver
	 * close the driver
	 */
	private void close(WebDriver driver) {
		driver.close();
	}
	
	/*
	 * parameter webdriver
	 * get the title of the page
	 */
	private void getTitle(WebDriver driver) {
		driver.getTitle();
	}
	
	
	/*
	 * parameter webdriver
	 * quit the driver
	 */
	private void quit(WebDriver driver) {
		driver.quit();
	}
}
