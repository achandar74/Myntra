package com.testcases.myntra.usingtestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Dprovider {
	
	@Test(dataProvider = "getdata")

	public void loginpage(String username,String password) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\JANARDHAN\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://localhost:8080/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	}
	
	@DataProvider
	private Object[][] getdata() {
		Object[][] data= new Object[3][2];
		data[0][0]="chandar";
		data[0][1]="chandar";
		
		data[1][0]="cherry";
		data[1][1]="cherry";

		data[2][0]="admin";
		data[2][1]="admin";
		return data;
	}
}
