package com.assignment.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.assignment.base.testBase;

public class newCustomerScreen {
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	testBase tb = new testBase();
	String browser ="Chrome";

	@BeforeTest
	private void initializeConfigData() {
		tb.initFile();
		if(browser.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	@Test(priority = 1)
	private void verifyNewCustomerScreen() {
		driver.get(tb.CON.getProperty("url"));
		driver.findElement(By.xpath(tb.OR.getProperty("Userslink_xpath"))).click();
		driver.findElement(By.xpath(tb.OR.getProperty("Newuserbutton_xpath"))).click();
		driver.findElement(By.xpath(tb.OR.getProperty("Username_xpath"))).sendKeys("AmolNTarapure");
		driver.findElement(By.xpath(tb.OR.getProperty("Password_xpath"))).sendKeys("amol123456");
		driver.findElement(By.xpath(tb.OR.getProperty("Email_xpath"))).sendKeys("amol1234@gmail.com");
		driver.findElement(By.xpath(tb.OR.getProperty("Createuserbutton_xpath"))).click();

	}

	@Test(priority = 2)
	private void verifyCustomerFilters() {

		driver.get(tb.CON.getProperty("url"));
		driver.findElement(By.xpath(tb.OR.getProperty("Userslink_xpath"))).click();
		driver.findElement(By.xpath(tb.OR.getProperty("Usernamefilter_xpath"))).sendKeys("Contains");
		driver.findElement(By.xpath(tb.OR.getProperty("Usernameinputbox_xpath"))).sendKeys("Test");
		driver.findElement(By.xpath(tb.OR.getProperty("Emailfilter_xpath"))).sendKeys("Contains");
		driver.findElement(By.xpath(tb.OR.getProperty("Emailinputbox_xpath"))).sendKeys("yopmail.com");
		driver.findElement(By.xpath(tb.OR.getProperty("Fromdatepicker_xpath"))).click();
		driver.findElement(By.xpath(tb.OR.getProperty("Fromdatepicker_xpath"))).sendKeys("2018-11-21");
		driver.findElement(By.xpath(tb.OR.getProperty("Todatepicker_xpath"))).click();
		driver.findElement(By.xpath(tb.OR.getProperty("Todatepicker_xpath"))).sendKeys("2018-11-21");
		driver.findElement(By.xpath(tb.OR.getProperty("Filterbutton_xpath"))).click();
		Assert.assertNotNull(driver.findElement(By.xpath(tb.OR.getProperty("Rowone_xpath"))));
	}

	@AfterTest()
	private void closeBrowser() {
		driver.close();
		softAssert.assertAll();
	}

}
