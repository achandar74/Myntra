package com.testcases.myntra.usingtestng;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PropertiesExample {
	@Test
	public void loginpage() throws IOException  {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\JANARDHAN\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream("D:\\EclipseWorkspace\\MyntraShopping\\src\\main\\java\\data.properties");
		
		prop.load(fis);
		String username = prop.getProperty("username");
		String password=prop.getProperty("password");
		
		driver.get("http://localhost:8080/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	}
	
	
}
