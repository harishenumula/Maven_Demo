package com.hrm.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class User21 {
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void verifySearchButton() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.google.com");
		System.out.println("Opening Google site");
		String search_text = "Google Search";
		WebElement search_button = driver.findElement(By.name("btnK"));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String text = search_button.getAttribute("value");

		Assert.assertEquals(text, search_text, "Text not found!");
	}
}
