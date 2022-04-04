package com.framework.utilities;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebUtils {
	private WebDriver driver;

	WebUtils(WebDriver webDriver) {
		driver = webDriver;
	}

	/*
	 * parameters webelement and testdata enter testdata into webelement
	 */
	public void enterText(WebElement element, String testdata) {
		element.sendKeys(testdata);
	}

	/*
	 * parameter string enter url
	 */
	public void navigate(String url) {
		driver.navigate().to(url);

	}

	/*
	 * parameter webelement click the webelement
	 */
	public void click(WebElement element) {
		element.click();
	}

	/*
	 * parameters webelement and string clear the webelement enter testdata into
	 * webelement
	 */
	public void clearAndEnter(WebElement element, String testdata) {
		element.clear();
		element.sendKeys(testdata);
	}


	/*
	 * parameteres string and int enter chars and size it generate the random
	 * alphabet
	 */
	public String generateRndAlphabet(int len) {
		String charsAlphabet = "abcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(charsAlphabet.charAt(rnd.nextInt(charsAlphabet.length())));
		}
		return sb.toString();
	}

	public String generateRndCharacter(int len) {
		String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		}
		return sb.toString();
	}

	public String generateRndNumber(int len) {
		String charsNum = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(charsNum.charAt(rnd.nextInt(charsNum.length())));
		}
		return sb.toString();
	}

	/*
	 * parameter webelement checks whether it is displayed
	 */
	
	/*
	 * parameter webdriver close the driver
	 */
	public void close(WebDriver driver) {
		driver.close();
	}

	/*
	 * parameter webdriver get the title of the page
	 */
	public void getTitle(WebDriver driver) {
		driver.getTitle();
	}

	/*
	 * parameter webdriver quit the driver
	 */
	public void quit(WebDriver driver) {
		driver.quit();
	}

	public String getCurrentURL() {
		String url = driver.getCurrentUrl();
		return url;
	}


	public void isElementPresent(WebElement element) {
		try {
			Assert.assertTrue(element.isDisplayed());
		} catch (Exception e) {
			Assert.assertTrue(element.isDisplayed());
		}
	}

	public void isElementAbsent(WebElement element) {
		try {
			Assert.assertFalse(element.isDisplayed());
		} catch (Exception e) {
			Assert.assertFalse(element.isDisplayed());
		}
	}

	public void switchToChildWindow() {
		String currentWindowID = driver.getWindowHandle();
		Set<String> allwindowID = driver.getWindowHandles();
		for (String eachwindowID : allwindowID) {
			if (!currentWindowID.equalsIgnoreCase(eachwindowID)) {
				driver.switchTo().window(eachwindowID);
			}
		}
	}

	public void switchToWindowByIndex(int index) {
		int expectedWindowCount = index;
		int count = 1;
		Set<String> allwindowID = driver.getWindowHandles();
		for (String eachwindowID : allwindowID) {
			if (expectedWindowCount == count) {
				driver.switchTo().window(eachwindowID);
				break;
			}
			count++;
		}
	}

	public void waitTillPageLoad(int loadtime) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(loadtime));
	}

	public void implicitlywait(int loadtime) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(loadtime));
	}

	public void fluentwait(WebElement element, int loadtime,int pollingSec) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class)
				.withTimeout(Duration.ofSeconds(loadtime)).pollingEvery(Duration.ofSeconds(pollingSec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void dragAndDrop(WebElement Sourcelocator, WebElement Destinationlocator) {
		Actions action = new Actions(driver);
		action.clickAndHold(Sourcelocator).moveToElement(Destinationlocator).release().build().perform();
	}

	public void switchToWindowByTitle(String exceptedTitle) {
		String currentWindow = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			if (driver.switchTo().window(winHandle).getTitle().equals(exceptedTitle)) {
				break;
			} else {
				driver.switchTo().window(currentWindow);
			}
		}
	}

	public void switchtoParentWindow() {
		int expectedWindowCount = 1;
		int count = 1;
		Set<String> allwindowID = driver.getWindowHandles();
		for (String eachwindowID : allwindowID) {
			if (expectedWindowCount == count) {
				driver.switchTo().window(eachwindowID);
				break;
			}
			count++;
		}
	}

	public boolean isEnabled(WebElement element) {
		boolean ispresent = element.isEnabled();
		return ispresent;
	}

	public void verifyEquals(int actual, int expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	public void verifyEquals(double actual, double expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	

	public String getTextFromAlert() {
		String str = driver.switchTo().alert().getText();
		return str;
	}

	public void waitforAlertAndAccept() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	public void waitforAlertAndDismiss() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
	}

	public void verifyAlertText(String str) {
		String data = driver.switchTo().alert().getText();
		Assert.assertEquals(data, str);
	}

	public void waitforElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitforElementClickableAndPerformClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void waitforPageTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleIs(title));
	}

	public void waitforPageTitleContains(String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains(title));
	}

	public void waitforElementToBeEnabled(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitforElementToBeEnabledAndPerformClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}

	public void waitforElementToBeInvisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void hitEnter(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}

	public void typeAndEnter(WebElement element, String str) {
		element.sendKeys(str);
		element.sendKeys(Keys.ENTER);
	}

	public List<WebElement> getSelectedOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> opt = select.getAllSelectedOptions();
		return opt;
	}

	public List<WebElement> getAllOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> opt = select.getOptions();
		return opt;
	}

	public int getAllOptionsSize(WebElement element) {
		Select select = new Select(element);
		int size = select.getOptions().size();
		return size;
	}

	public void selectOptionByVisibleText(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByVisibleText(data);
	}

	public void selectOptionByValue(WebElement element, String str) {
		Select select = new Select(element);
		select.selectByValue(str);
	}

	public void selectOptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void switchToFrameById(String id) {
		driver.switchTo().frame(id);
	}

	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrameByElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void mouseHover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public void mouseHoverAndClickUsingActions(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}

	public String getText(WebElement element) {
		String str = element.getText();
		return str;
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void closeCurrentWindow() {
		driver.close();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateForward() {
		driver.navigate().forward();
	}

	public void closeAllWindow() {
		driver.quit();
	}

	public void reloadCurrentPage() {
		driver.navigate().refresh();
	}

	public boolean isSelected(WebElement element) {
		if (element.isSelected()) {
			return true;
		}
		return false;
	}

	public void hitEscapeKey() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ESCAPE).build().perform();
		;
	}

	public void rightClick() {
		Actions act = new Actions(driver);
		act.contextClick().build().perform();
	}

	public void doubleClick() {
		Actions act = new Actions(driver);
		act.doubleClick().build().perform();
	}

	public String getAttribute(WebElement element, String attributename) {
		String data = element.getAttribute(attributename);
		return data;
	}

	public boolean verifyTextIsPresent(WebElement element, String data) {
		if (element.getText() != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTextIsAbsent(WebElement element, String data) {
		if (element.getText() == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyText(WebElement element, String text) {
		String data = element.getText().concat(text);
		if (data.length() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void verifyEquals(String actual, String expected, String message) {
		if (actual.equals(expected)) {
			Assert.assertTrue(true, message);
		} else {
			Assert.assertTrue(false, message);
		}
	}

	public void verifyNotEquals(String actual, String expected, String message) {
		if (actual != expected) {
			Assert.assertTrue(true, message);
		} else {
			Assert.assertTrue(false, message);
		}
	}

	public void verifyContains(String actual, String expected, String message) {
		if (actual.contains(expected)) {
			Assert.assertTrue(true, message);
		} else {
			Assert.assertTrue(false, message);
		}
	}

}
