package com.testcase.myntra.usingtestng;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LuggagesAndTrolleysSectionPage {
	private WebDriver driver;

	@FindBy(xpath = "//div[@class='sort-sortBy']")
	private WebElement sortSortByMenu;
	@FindBy(xpath = "//div[@class='atsa-more']/span")
	private WebElement moreMenu;

	@FindBy(xpath = "//li[@class='breadcrumbs-item']/span[text()='Trolley & Luggage Bags']")
	private WebElement trolleyAndLuggageBagsPage;

	@FindBy(xpath = "//div[@class='brand-more']")
	private WebElement viewAllBrand;
	@FindBy(xpath = "//div[@class='FilterDirectory-titleBar']/span")
	private WebElement closeBrand;

	@FindBy(xpath = "//input[@value='Black']/parent::label/div")
	private WebElement productColor;

	@FindBy(xpath = "//input[@value='70.0 TO 100.0']/parent::label")
	private WebElement discountRange;

	@FindBy(xpath = "(//div[@class='product-imageSliderContainer'])[1]")
	private WebElement selectfirstProduct;

	@FindBy(xpath = "//span[@class='size-buttons-size-chart']/button")
	private WebElement sizeButton;

	@FindBy(xpath = "//div[@class='size-buttons-buttonContainer']/button")
	private WebElement smallSize;

	@FindBy(xpath = "//h1[@class='pdp-title']")
	private WebElement productName;

	@FindBy(xpath = "//h1[@class='pdp-name']")
	private WebElement productDetails;

	@FindBy(xpath = "//span[@class='pdp-price']/strong")
	private WebElement productDiscountPrice;

	@FindBy(xpath = "//p[@class='size-buttons-unified-size'][text()='S']")
	private WebElement productSize;

	@FindBy(xpath = "//input[@type='tel']")
	private WebElement productDeliveryAvailability;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//li[@class='pincode-serviceabilityItem'][1]/h4")
	private WebElement getProductByDate;

	@FindBy(xpath = "//div[text()='ADD TO BAG']")
	private WebElement addToBag;

	@FindBy(xpath = "//span[text()='Bag']")
	private WebElement cartLink;

	@FindBy(xpath = "//div[@class='itemContainer-base-brand']")
	private WebElement actualProductName;
	@FindBy(xpath = "//div[@class='itemContainer-base-details']//a")
	private WebElement actualProductDetail;
	@FindBy(xpath = "//div[@class='itemComponents-base-price itemComponents-base-bold ']/div")
	private WebElement finalProductPrice;

	@FindBy(xpath = "//div[@class='colour-more']")
	private WebElement morecolor;

	@FindBy(xpath = "//span[@class='product-strike']")
	private List<WebElement> pbtOriginalPrice;
	@FindBy(xpath = "//span[@class='product-discountedPrice']")
	private List<WebElement> pbtDiscountPrice;

	String productNameText = "";
	String productDetailText = "";
	String productPriceText = "";
	String productPrice = "";
	String ProductName = "Tommy Hilfiger";
	String Discount = "50% and above";
	String Color = "Navy Blue";
	String menu[] = { "Bundles", "Country of Origin", "Dead Weight", "Features", "Lock Type", "Material",
			"Maximum Carrying Capacity", "Multipack Set", "Pattern", "Rating", "size_facet", "Sustainable",
			"Tablet Sleeve", "Type", "Volume in Litres", "warrantyMenu", "waterResistanceMenu" };
	String filterbrand[] = { "2 STRAP", "Aristocrat", "Aoking", "AMERICAN TOURISTER", "Arctic Hunter", "Bags.R.us",
			"Calvin Klein", "CARRIALL", "CAT", "DKNY", "Disney", "DELSEY", "EUME", "Eske", "ELOPPE", "Genius",
			"GIORDANO", "Genie", "GEPACK", "Heys", "Hidesign", "IT luggage", "Inesis By Decathlon", "Kenneth Cole",
			"KAMILIANT", "Kipsta By Decathlon", "MBOSS", "NOVEX", "National Geographic", "Nasher Miles", "NAKURU",
			"Polo Class", "Pronto", "Puma", "RONCATO", "SWISS BRAND", "Safari", "SWISS MILITARY", "Skybags",
			"Tommy Hilfiger", "Teakwood Leathers", "THE ASSEMBLY", "THE CLOWNFISH", "United Colors of Benetton", "VIP",
			"Wildcraft" };
	String filterPrice[] = { "1664.0 TO 7863.0", "7863.0 TO 14062.0", "14062.0 TO 20261.0", "20261.0 TO 26460.0" };
	String filterColor[] = { "Black", "Blue", "Red", "Grey", "Navy Blue", "Orange", "Purple", "Green", "Silver", "Pink",
			"White", "Maroon", "Brown", "Burgundy", "Charcoal", "Teal", "Beige", "Yellow", "Multi", "Bronze",
			"Turquoise Blue", "Tan", "Sea Green", "Rust", "Coffee Brown", "Rose", "Peach", "Metallic", "Olive",
			"Magenta", "Lime Green", "Gold", "Off White", "Mauve", "Lavender" };
	String filterDiscount[] = { "10% and above", "20% and above", "30% and above", "40% and above", "50% and above",
			"60% and above", "70% and above" };
	String size = "S";
	String pincode = "560086";
	int pbtprice;
	String pdtPrice = "";
	String pbtfinalprice = "";
	String quantity[] = { "1", "2", "3", "4", "5", "6", "7", "8" };
	int i = 4;
	String pbtFinal = "";
	String originalPrice = "";
	int productOriginalPrice;
	String discountPrice = "";
	int productSellingPrice;

	public LuggagesAndTrolleysSectionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyTitleandObjectsInLuggagesAndTrolleysSectionPage() {
		verifyluggagesAndTrolleysMainSectionPageTitle();
		verifyluggagesAndTrolleysMainSectionPageMenu();
		selectViewMoreProductBrand();
		verifyFilterbrand();
		closeBrand();
		verifyFilterPrice();
		selectMoreColor();
		verifyFilterColor();
		verifyFilterDiscount();
	}

	public void verifyProductFilter() {
		selectViewMoreProductBrand();
		selectProductBrand(ProductName);
		closeBrand();
		productColor(Color);
		selectDiscountRange(Discount);
		verifyFilterSummary();
		verifyDiscountRate();
	}

	public void VerifySelectedProduct() {
		selectFirstProduct();
		Set<String> windowID = driver.getWindowHandles();
		Iterator<String> it = windowID.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		selectProductSize(size);
		verifyProductActualPrice();
		productDeliveryDate(pincode);
	}

	public void verifyProductDetails() {
		productNameText = productName.getText();
		productDetailText = productDetails.getText();
		productPrice = productDiscountPrice.getText().split(" ")[1];
	}

	public void verifyProductAddToBag() {
		addToBag.click();
		cartLink.click();
		WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
		finalpbtPrice();
		waiter.until(ExpectedConditions.visibilityOf(actualProductName));
		Assert.assertEquals(actualProductName.getText(), productNameText, "productname is not same");
		Assert.assertEquals(actualProductDetail.getText(), productDetailText, "productDetails is not same");
		Assert.assertEquals(pbtfinalprice, productPrice, "product price is not same");
	}

	public void verifyProductIsPresentAgainByClickingCart() {
		driver.navigate().back();
		cartLink.click();
		WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
		finalpbtPrice();
		waiter.until(ExpectedConditions.visibilityOf(actualProductName));
		Assert.assertEquals(actualProductName.getText(), productNameText, "productname is not same");
		Assert.assertEquals(actualProductDetail.getText(), productDetailText, "productDetails is not same");
		Assert.assertEquals(pbtfinalprice, productPrice, "product price is not same");
	}

	public void verifyAddProductQuantityAndVerifyProductPrice() {
		addProductQuantity(i);
		WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
		finalpbtPriceafterAddingQuantity();
		System.out.println(pbtFinal);
		int qty = Integer.parseInt(productPrice);
		int totalPrice = (i + 1) * qty;
		System.out.println(totalPrice);
		waiter.until(ExpectedConditions.visibilityOf(actualProductName));
		Assert.assertEquals(pbtFinal, totalPrice, "Product Should same");
	}

	private void verifyluggagesAndTrolleysMainSectionPageTitle() {
		String luggagesAndTrolleysExpectedTitle = "Trolley Bags - Buy Trolley Bags for Men, Women & Girls Online in India | Myntra";
		String luggagesAndTrolleysActualTitle = driver.getTitle();
		Assert.assertEquals(luggagesAndTrolleysActualTitle, luggagesAndTrolleysExpectedTitle, "Title should be same");
		Assert.assertTrue(trolleyAndLuggageBagsPage.isDisplayed(), "TrolleyAndLuggageBagsPage should be there");
	}

	private void verifyluggagesAndTrolleysMainSectionPageMenu() {
		moreMenu.click();
		for (int i = 0; i < menu.length; i++) {
			List<WebElement> luggagePageMenu = driver
					.findElements(By.xpath("//input[@value='" + menu[i] + "']/following-sibling::h4"));
			if (luggagePageMenu.size() > 0 && luggagePageMenu.get(0).isDisplayed()) {
				Assert.assertTrue(luggagePageMenu.get(0).isDisplayed(), "Luggage and Trolleys Menu should display");
			}
		}
		Assert.assertTrue(sortSortByMenu.isDisplayed(), "Sort Sort By menu should display");
	}

	private void verifyFilterbrand() {
		for (int i = 0; i < filterbrand.length; i++) {
			List<WebElement> brandFilter = driver.findElements(
					By.xpath("//ul[@class='FilterDirectory-list']//input[@value='" + filterbrand[i] + "']"));
			if (brandFilter.size() > 0 && brandFilter.get(0).isDisplayed()) {
				Assert.assertTrue(brandFilter.get(0).isDisplayed(), "Filter Brand Should display");
			}
		}
	}

	private void verifyFilterPrice() {
		for (int i = 0; i < filterPrice.length; i++) {
			List<WebElement> priceFilter = driver.findElements(By.xpath("//input[@value='" + filterPrice[i] + "']"));
			if (priceFilter.size() > 0 && priceFilter.get(0).isDisplayed()) {
				Assert.assertTrue(priceFilter.get(0).isDisplayed(), "Filter Price Should display");
			}
		}
	}

	private void selectMoreColor() {
		morecolor.click();
	}

	private void verifyFilterColor() {
		for (int i = 0; i < filterColor.length; i++) {
			List<WebElement> colorFilter = driver
					.findElements(By.xpath("//input[@value='" + filterColor[i] + "']/following-sibling::div"));
			if (colorFilter.size() > 0 && colorFilter.get(0).isDisplayed()) {
				Assert.assertTrue(colorFilter.get(0).isDisplayed(), "Filter Color Should display");
			}
		}
	}

	private void verifyFilterDiscount() {
		for (int i = 0; i < filterDiscount.length; i++) {
			List<WebElement> discountFilter = driver
					.findElements(By.xpath("//ul[@class='discount-list']//label[text()='" + filterDiscount[i] + "']"));
			if (discountFilter.size() > 0 && discountFilter.get(0).isDisplayed()) {
				Assert.assertTrue(discountFilter.get(0).isDisplayed(), "Filter Discount Should display");
			}
		}
	}

	private void selectViewMoreProductBrand() {
		viewAllBrand.click();
	}

	private void selectProductBrand(String ProductName) {
		sleep();
		Actions click = new Actions(driver);
		click.moveToElement(driver
				.findElement(By.xpath("//label[@class=' common-customCheckbox']/input[@value='" + ProductName + "']")))
				.click().build().perform();
	}

	private void closeBrand() {
		closeBrand.click();
	}

	private void productColor(String Color) {
		sleep();
		Actions click = new Actions(driver);
		click.moveToElement(driver.findElement(By.xpath("//input[@value='" + Color + "']"))).click().build().perform();
	}

	private void selectDiscountRange(String Discount) {
		sleep();
		Actions click = new Actions(driver);
		click.moveToElement(driver.findElement(
				By.xpath("//label[@class='common-customRadio vertical-filters-label'][text()='" + Discount + "']")))
				.click().build().perform();
	}

	private void verifyFilterSummary() {
		StringBuffer disc = new StringBuffer(Discount);
		StringBuffer discount = disc.insert(2, " ");
		WebElement selectedProduct = driver
				.findElement(By.xpath("//div[@class='filter-summary-filter'][text()='" + ProductName + "']"));
		WebElement selectedColor = driver
				.findElement(By.xpath("//div[@class='filter-summary-filter']//span[text()='" + Color + "']"));
		WebElement selectedDiscount = driver
				.findElement(By.xpath("//div[@class='filter-summary-filter']//span[text()='" + discount + "']"));
		Assert.assertTrue(selectedProduct.isDisplayed(), "Filter Product Should display");
		Assert.assertTrue(selectedColor.isDisplayed(), "Filter Color Should display");
		Assert.assertTrue(selectedDiscount.isDisplayed(), "Filter Discount Should display");
	}

	private void verifyProductActualPrice() {
		String totalprice = (String) driver.findElement(By.xpath("//span[@class='pdp-mrp']/s")).getText().subSequence(4,
				9);
		int total = Integer.parseInt(totalprice);
		String originalPrice = (String) driver.findElement(By.xpath("//span[@class='pdp-discount']")).getText()
				.subSequence(5, 9);
		int discount = Integer.parseInt(originalPrice);
		int actualprice = total - discount;
		pbtprice = actualprice;
		System.out.println(actualprice);
	}

	private void selectFirstProduct() {
		selectfirstProduct.click();
	}

	private void selectProductSize(String size) {
		driver.findElement(By.xpath("//p[@class='size-buttons-unified-size'][text()='" + size + "']")).click();
	}

	private void productDeliveryDate(String pincode) {
		productDeliveryAvailability.sendKeys(pincode);
		submitButton.click();
		sleep();
		System.out.println(getProductByDate.getText());
	}

	private void finalpbtPrice() {
		pdtPrice = finalProductPrice.getText();
		StringBuffer pdt = new StringBuffer(pdtPrice);
		pbtfinalprice = pdt.deleteCharAt(1).toString();
		System.out.println(pbtfinalprice);
	}

	private void finalpbtPriceafterAddingQuantity() {
		pdtPrice = finalProductPrice.getText();
		StringBuffer pdt = new StringBuffer(pdtPrice);
		pbtFinal = pdt.deleteCharAt(2).toString();
		System.out.println(pbtFinal);
	}

	private void addProductQuantity(int i) {
		Actions click = new Actions(driver);
		click.moveByOffset(0, 0).click().build().perform();
		driver.findElement(By.xpath("//div[@class='itemComponents-base-quantity']")).click();
		driver.findElement(By.xpath("//div[@class='dialogs-base-list']/div[@id='" + quantity[i] + "']")).click();
		driver.findElement(By.xpath("//div[@class='dialogs-base-list']/following-sibling::div")).click();
		sleep();
	}

	private void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void verifyDiscountRate() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(pbtOriginalPrice));
		for (int i = 0; i < pbtOriginalPrice.size(); i++) {
			originalPrice = pbtOriginalPrice.get(i).getText().substring(4);
			productOriginalPrice = Integer.parseInt(originalPrice);
			discountPrice = pbtDiscountPrice.get(i).getText().substring(4);
			productSellingPrice = Integer.parseInt(discountPrice);
			if (productOriginalPrice != 0) {
				int discPrice = (productOriginalPrice * 50) / 100;
				if (discPrice >= productSellingPrice) {
					Assert.assertTrue(true, "Excepted discount is present");
				} else {
					Assert.assertTrue(false, "Excepted discount is not present");
				}
			}
		}
	}
}