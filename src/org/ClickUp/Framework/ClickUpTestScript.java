package org.ClickUp.Framework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClickUpTestScript {
	public WebDriver driver;
	public String baseUrl = "https://www.clickup.com/";
	String path = "C:\\Users\\admin\\Desktop\\Testing Notes\\Selenium\\selenium-java-4.3.0\\chromedriver_win32\\chromedriver.exe";
	
	@BeforeTest
	public void Browser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	@Test (priority=1)
	public void Login() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Log in')]")));
		driver.findElement(By.xpath("//a[contains(.,'Log in')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-email-input']")));
		driver.findElement(By.xpath("//input[@id='login-email-input']")).sendKeys("testautomation.dir@gmail.com");
		driver.findElement(By.xpath("//input[@id='login-password-input']")).sendKeys("Vikram@123");
		driver.findElement(By.xpath("//button[@class='login-page-new__main-form-button']")).click();
	}
	
	//@Test(priority=2)
		public void space() throws InterruptedException,NoSuchElementException,TimeoutException,ElementClickInterceptedException {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(text(),'Spaces')]")));
			try {
				//driver.findElement(By.xpath("//div[starts-with(text(),'Spaces')]")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(text(),'New Space')]")));
				Actions act = new Actions(driver);
				WebElement sp = driver.findElement(By.xpath("//div[starts-with(text(),'New Space')]"));
				act.moveToElement(sp).click().perform();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Space na﻿me']")));
				WebElement nsp = driver.findElement(By.xpath("//input[@placeholder='Enter Space na﻿me']"));
				//act.moveToElement(nsp).click().perform();
				nsp.sendKeys("TestSpace01");
				nsp.sendKeys(Keys.ENTER);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Next']")));
				driver.findElement(By.xpath("//button[.='Next']")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Next']")));
				driver.findElement(By.xpath("//button[.='Next']")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Next']")));
				driver.findElement(By.xpath("//button[.='Next']")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Review Space']")));
				driver.findElement(By.xpath("//button[.='Review Space']")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Create Space']")));
				driver.findElement(By.xpath("//button[.='Create Space']")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='cu-task-row-new__input']")));
				WebElement list = driver.findElement(By.xpath("//input[@class='cu-task-row-new__input']"));
				list.sendKeys("Sample Task");
				list.sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				WebElement li = driver.findElement(By.xpath("//div[@class='cu-task-row-new__close ng-star-inserted']"));
				act.moveToElement(li).click().perform();
				Thread.sleep(1000);
				/*WebElement asign = driver.findElement(By.xpath("//*[local-name()='rect']"));
				act.moveToElement(asign).click().perform();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Due date']")));
				WebElement duedate = driver.findElement(By.xpath("//input[@placeholder='Due date']"));
				Thread.sleep(1000);
				duedate.sendKeys("11/19/22");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cu-dropdown-list-item__title cu-dropdown-list-item__title_space-between']")));
				WebElement sel_due = driver.findElement(By.xpath("//div[@class='cu-dropdown-list-item__title cu-dropdown-list-item__title_space-between']"));
				act.moveToElement(sel_due).click().perform();*/
			}
			catch(TimeoutException e) {
				e.printStackTrace();
			}
		}
	
	@Test(priority=3)
	public void Home () throws InterruptedException , NoSuchElementException,TimeoutException{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-test='simple-sidebar-home-item']")));
		try {
			Actions act = new Actions(driver);
			driver.findElement(By.xpath("//a[@data-test='simple-sidebar-home-item']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cu-lineup__add-items']")));
			WebElement lineup = driver.findElement(By.xpath("//div[@class='cu-lineup__add-items']"));
			act.moveToElement(lineup).click().perform();
			try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search for task (or subtask) name, ID, or URL']")));
			WebElement ser =driver.findElement(By.xpath("//div[contains(text(),'Dummy Task')]"));
			
			act.moveToElement(ser).click().perform();
			}
			catch(TimeoutException e) {
				e.printStackTrace();
			}
		}
		catch(TimeoutException e) {
			e.printStackTrace();
		}
	}
}
