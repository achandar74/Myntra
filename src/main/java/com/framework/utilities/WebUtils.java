package com.framework.utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
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
	public void clickAndEnter(WebElement element, String testdata) {
		element.clear();
		element.sendKeys(testdata);
	}

	/*
	 * parameters webdriver and int driver implicitly wait until i second
	 * 
	 */
	public void implicitwait(WebDriver driver, int i) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
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
	public void verifyIsDisplayed(WebElement element) {
		Assert.assertTrue(element.isDisplayed(), "" + element + " should display");
	}

	/*
	 * parameter webelement checks whether it is enabled
	 */
	public void verifyIsEnabled(WebElement element) {
		Assert.assertTrue(element.isEnabled(), "" + element + " should enabled");
	}

	/*
	 * parameter webelement checks whether it is selected
	 */
	public void verifyIsSelected(WebElement element) {
		Assert.assertTrue(element.isSelected(), "" + element + " should selected");
	}

	/*
	 * parameter webdriver it accepts the alert
	 */
	public void acceptAlertMessage() {
		driver.switchTo().alert().accept();
	}

	/*
	 * parameter webdriver it dismiss the alert
	 */
	public void dismissAlertMessage() {
		driver.switchTo().alert().dismiss();
	}

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

	public void getCurrentURL(String str) {
		str = driver.getCurrentUrl();
	}

	public void enter(String str, String data) {
		str = data;
	}

	public boolean isElementPresent(WebElement element) {
		boolean isPresent = element.isDisplayed();
		return isPresent;
	}

	public boolean isElementAbsent(WebElement element) {
		if (element.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void switchToWindow() {
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

	public void fluentwait(WebElement element, int loadtime) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class)
				.withTimeout(Duration.ofSeconds(loadtime)).pollingEvery(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void dragAndDrop(WebElement Sourcelocator, WebElement Destinationlocator) {
		Actions action = new Actions(driver);
		action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
	}

	public void switchToWindowByTitle(String title) {
		driver.switchTo().window(title);
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

	public WebElement isEnabled(WebElement element) {
		element.isEnabled();
		return element;
	}

	public void verifyEquals(int a, int b, String str) {
		Assert.assertEquals(a, b, "" + str + "");
	}

	public void verifyEquals(double a, double b, String str) {
		Assert.assertEquals(a, b, "" + str + "");
	}

	public void verifyTrue(boolean element, String str) {
		Assert.assertTrue(element, "" + str + "");
	}

	public void verifyFalse(boolean element, String str) {
		Assert.assertFalse(element, "" + str + "");
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
		;
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

	public void selectOptionByVisibleText(WebElement element, String str) {
		Select select = new Select(element);
		select.selectByVisibleText(str);
	}

	public void selectOptionByValue(WebElement element, String str) {
		Select select = new Select(element);
		select.selectByValue(str);
	}

	public void selectOptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void switchToFrameById(String str) {
		driver.switchTo().frame(str);
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

	public void getText(WebElement element, String str) {
		str = element.getText();
	}

	public void getPageTitle(String title) {
		title = driver.getTitle();
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

	public void isSelected(WebElement element) {
		element.isSelected();
	}

	public void hitEscapeKey() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ESCAPE).click().build().perform();
		;
	}

	public void rightClick() {
		Actions act = new Actions(driver);
		act.click().build().perform();
	}

	public void doubleClick() {
		Actions act = new Actions(driver);
		act.doubleClick().build().perform();
	}

	public void getAttribute(WebElement element, String testdata) {
		element.getAttribute(testdata);
	}

	public void verifyTextIsPresent(WebElement element) {
		Assert.assertTrue(element.getText().isEmpty());
	}

	public void verifyTextIsAbsent(WebElement element) {
		Assert.assertFalse(element.getText().isEmpty());
	}

	public void verifyText(WebElement element, String testdata) {
		Assert.assertEquals(element.getText(), testdata, "" + testdata + " should be there");
	}

	public void verifyEquals(String data1, String data2, String str) {
		Assert.assertEquals(data1, data2, "" + str + "");
	}

	public void verifyNotEquals(String data1, String data2, String str) {
		Assert.assertNotEquals(data1, data2, "" + str + "");
	}

	public void verifyContains(String data1, String data2, String str) {
		Assert.assertEquals(data1.contains(data2), "" + str + "");
	}
	
	
}
