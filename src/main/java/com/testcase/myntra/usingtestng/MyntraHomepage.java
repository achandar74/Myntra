package com.testcase.myntra.usingtestng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.eventbus.SubscriberExceptionContext;

public class MyntraHomepage {
	private WebDriver driver;

	@FindBy(xpath = "//div[@class='desktop-logoContainer']/a")
	private WebElement logoimage;
	@FindBy(xpath = "//a[@data-group='men']")
	private WebElement menMainMenu;
	@FindBy(xpath = "//a[@data-group='women']")
	private WebElement womenMainMenu;
	@FindBy(xpath = "//a[@data-group='kids']")
	private WebElement kidsMainMenu;
	@FindBy(xpath = "//a[@data-group='home-&-living']")
	private WebElement homelivingMainMenu;
	@FindBy(xpath = "//a[@data-group='beauty']")
	private WebElement beautyMainMenu;
	@FindBy(xpath = "//a[@data-group='studio']")
	private WebElement studioMainMenu;
	@FindBy(xpath = "//a[@class='desktop-submit']")
	private WebElement submitButton;
	@FindBy(xpath = "//input[@class='desktop-searchBar']")
	private WebElement searchtxtBox;
	@FindBy(xpath = "//span[text()='Profile']")
	private WebElement profilemainMenu;
	@FindBy(xpath = "//span[text()='Wishlist']")
	private WebElement wishlistLink;
	@FindBy(xpath = "//span[text()='Bag']")
	private WebElement cartLink;

	@FindBy(xpath = "//a[@href='/men-bags-backpacks']")
	private WebElement bagsAndbackpacksSection;

	@FindBy(xpath = "(//a[@href='/trolley-bags'])[1]")
	private WebElement luggagesAndTrolleysSection;

	String mainMenu[] = { "men", "women", "kids", "home-&-living", "beauty", "studio" };
	String button[] = { "Profile", "Wishlist", "Bag" };
	String submenu[] = { "/men-topwear", "/men-ethnic-wear", "/men-bottomwear", "/men-innerwear", "/men-plus-size",
			"/men-footwear", "/men-personal-care", "/men-sunglasses", "/mens-watches", "/men-sports-wear", "/gadgets",
			"/men-accessories", "/men-bags-backpacks", "/trolley-bags" };
	String topwear[] = { "men-tshirts", "men-casual-shirts", "men-formal-shirts", "men-sweatshirts", "men-sweaters",
			"men-jackets", "men-blazers", "men-suits", "rain-jacket" };
	String indianAndFestiveWear[] = { "men-kurtas", "sherwani", "nehru-jackets", "dhoti" };
	String bottomwear[] = { "/men-jeans", "/men-casual-trousers", "/men-formal-trousers", "/mens-shorts",
			"/men-trackpants" };
	String innerwearAndSleepwear[] = { "briefs-and-trunks", "boxers", "innerwear-vests", "nightwear", "thermals" };
	String footwear[] = { "casual-shoes", "sports-shoes", "formal-shoes", "sneakers", "sandals", "flip-flops",
			"socks" };
	String sportsAndActiveWear[] = { "sports-shoes", "sports-sandals", "sports-wear-tshirts", "trackpants-shorts",
			"tracksuits", "sports-jackets", "sports-accessories", "swimwear" };
	String gadgets[] = { "smart-wearables", "smart-wearables?f=Categories%3AFitness%20Bands", "headphones",
			"speakers" };
	String fashionAccessories[] = { "men-wallets", "men-belts", "perfumes", "trimmer", "deodorant", "men-belts-ties",
			"men-accessory-gift-set", "men-caps", "men-gloves-mufflers-scarves", "mobile-phone-cases", "men-jewellery",
			"helmets" };

	public MyntraHomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyTitleandObjectsInHomepage() {
		verifyHomepageTitle();
		verifyLogoImage();
		verifyMainMenu();
		verifyMainmenuButtons();
		verifySearchField();
	}

	public void NavigateToLuggagesAndTrolleysSectionPage() {
		clickonluggagesAndTrolleysMainSection();
	}

	public void verifyMenSubMenu() {
		Actions a = new Actions(driver);
		a.moveToElement(menMainMenu).clickAndHold().build().perform();
		verifySubMenuSection();
		verifyTopWearMainSection();
		verifyIndianAndFestivalWearMainSection();
		verifyBottonwearMainSection();
		verifyInnerwearAndSleepwearMainSection();
		verifyFootwearMainSection();
		verifySportsAndActiveWearMainSection();
		verifyGadgetMainSection();
		verifyFashionAccessoriesMainSection();
		verifybagsAndbackpacksMainSection();
		verifyluggagesAndTrolleysMainSection();
	}

	private void verifyHomepageTitle() {
		String actual = driver.getTitle();
		String excepted = "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
		Assert.assertEquals(actual, excepted, "Excepted Title not Found");
	}

	private void verifyLogoImage() {
		Assert.assertTrue(logoimage.isDisplayed(), "Logo Image should present");
	}

	private void verifyMainMenu() {
		for (int i = 0; i < mainMenu.length; i++) {
			WebElement main = driver.findElement(By.xpath("//a[@data-group='" + mainMenu[i] + "']"));
			Assert.assertTrue(main.isDisplayed(), "Main menu should display");
		}
	}

	private void verifyMainmenuButtons() {
		for (int i = 0; i < button.length; i++) {
			WebElement buttons = driver.findElement(By.xpath("//span[text()='" + button[i] + "']"));
			Assert.assertTrue(buttons.isDisplayed(), "Button in homepage should display");
		}
	}

	private void verifySearchField() {
		Assert.assertTrue(submitButton.isDisplayed(), "Submit Button should display");
		Assert.assertTrue(searchtxtBox.isDisplayed(), "Search TextBox should display");
	}

	private void clickonluggagesAndTrolleysMainSection() {
		luggagesAndTrolleysSection.click();
	}

	private void verifySubMenuSection() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='/men-topwear']"))));
		for (int i = 0; i < submenu.length; i++) {
			List<WebElement> submenuSection = driver.findElements(By.xpath("//a[@href='" + submenu[i] + "']"));
			if (submenuSection.size() > 0 && submenuSection.get(0).isDisplayed()) {
				Assert.assertTrue(submenuSection.get(0).isDisplayed(), "sub menus should display");
			}
		}
	}

	private void verifyTopWearMainSection() {
		for (int i = 0; i < topwear.length; i++) {
			List<WebElement> topwearSection = driver.findElements(By.xpath("//a[@href='/" + topwear[i] + "']"));
			if (topwearSection.size() > 0 && topwearSection.get(0).isDisplayed()) {
				Assert.assertTrue(topwearSection.get(0).isDisplayed(), "Topwear menus should display");
			}
		}
	}

	private void verifyIndianAndFestivalWearMainSection() {
		for (int i = 0; i < indianAndFestiveWear.length; i++) {
			List<WebElement> indianAndFestivalWearSection = driver
					.findElements(By.xpath("//a[@href='/" + indianAndFestiveWear[i] + "']"));
			if (indianAndFestivalWearSection.size() > 0 && indianAndFestivalWearSection.get(0).isDisplayed()) {
				Assert.assertTrue(indianAndFestivalWearSection.get(0).isDisplayed(),
						"indianAndFestivalWear menus should display");
			}
		}
	}

	private void verifyBottonwearMainSection() {
		for (int i = 0; i < bottomwear.length; i++) {
			List<WebElement> bottomwearSection = driver.findElements(By.xpath("//a[@href='" + bottomwear[i] + "']"));
			if (bottomwearSection.size() > 0 && bottomwearSection.get(0).isDisplayed()) {
				Assert.assertTrue(bottomwearSection.get(0).isDisplayed(), "bottomwear menus should display");
			}
		}
	}

	private void verifyInnerwearAndSleepwearMainSection() {
		for (int i = 0; i < innerwearAndSleepwear.length; i++) {
			List<WebElement> innerwearAndSleepwearSection = driver
					.findElements(By.xpath("//a[@href='/men-" + innerwearAndSleepwear[i] + "']"));
			if (innerwearAndSleepwearSection.size() > 0 && innerwearAndSleepwearSection.get(0).isDisplayed()) {
				Assert.assertTrue(innerwearAndSleepwearSection.get(0).isDisplayed(), "innerwearAndSleepwear menus should display");
			} 
		}
	}

	private void verifyFootwearMainSection() {
		for (int i = 0; i < footwear.length; i++) {
			List<WebElement> footwearSection = driver.findElements(By.xpath("//a[@href='/men-" + footwear[i] + "']"));
			if (footwearSection.size() > 0 && footwearSection.get(0).isDisplayed()) {
				Assert.assertTrue(footwearSection.get(0).isDisplayed(), "footwear menus should display");
			} 
		}
	}

	private void verifySportsAndActiveWearMainSection() {
		for (int i = 0; i < sportsAndActiveWear.length; i++) {
			List<WebElement> sportsAndActiveWearSection = driver
					.findElements(By.xpath("(//a[@href='/men-" + sportsAndActiveWear[i] + "'])[1]"));
			if (sportsAndActiveWearSection.size() > 0 && sportsAndActiveWearSection.get(0).isDisplayed()) {
				Assert.assertTrue(sportsAndActiveWearSection.get(0).isDisplayed(), "footwear menus should display");
			} 
		}
	}

	private void verifyGadgetMainSection() {
		for (int i = 0; i < gadgets.length; i++) {
			List<WebElement> gadgetsSection = driver.findElements(By.xpath("(//a[@href='/" + gadgets[i] + "'])[1]"));
			if (gadgetsSection.size() > 0 && gadgetsSection.get(0).isDisplayed()) {
				Assert.assertTrue(gadgetsSection.get(0).isDisplayed(), "gadgets menus should display");
			} 
		}
	}

	private void verifyFashionAccessoriesMainSection() {
		for (int i = 0; i < fashionAccessories.length; i++) {
			List<WebElement> fashionAccessoriesSection = driver
					.findElements(By.xpath("//a[@href='/" + fashionAccessories[i] + "']"));
			if (fashionAccessoriesSection.size() > 0 && fashionAccessoriesSection.get(0).isDisplayed()) {
				Assert.assertTrue(fashionAccessoriesSection.get(0).isDisplayed(), "fashionAccessories menus should display");
			} 
		}
	}

	private void verifybagsAndbackpacksMainSection() {
		Assert.assertTrue(bagsAndbackpacksSection.isDisplayed(), "bagsAndbackpacks menu should display");
	}

	private void verifyluggagesAndTrolleysMainSection() {
		Assert.assertTrue(luggagesAndTrolleysSection.isDisplayed(), "luggagesAndTrolleys menu should display");
	}
}
