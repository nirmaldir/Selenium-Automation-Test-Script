package AutomationFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClickUp_MenuBar {
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
	
	@Test(priority=2)
	public void menubar_fn() throws InterruptedException , NoSuchElementException,TimeoutException{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-test='simple-sidebar-home-item']")));
		try {
			
			driver.findElement(By.xpath("//a[@data-test='simple-sidebar-home-item']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://app.clickup.com/43217081/notifications']")));
			driver.findElement(By.xpath("//a[@href='https://app.clickup.com/43217081/notifications']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Show more')]")));
			driver.findElement(By.xpath("//div[contains(text(),'Show more')]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Goals')]")));
			driver.findElement(By.xpath("//div[contains(text(),'Goals')]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Favorites']")));
			driver.findElement(By.xpath("//span[.='Favorites']")).click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority=6)
	public void searchbar() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Search')]")));
		try {
		Actions act = new Actions(driver);
		WebElement srch=driver.findElement(By.xpath("//div[contains(text(),'Search')]"));
		act.moveToElement(srch).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Search or run a command..')]")));
		WebElement sr = driver.findElement(By.xpath("//input[contains(@placeholder,'Search or run a command..')]"));
		sr.sendKeys("notifications");
		sr.sendKeys(Keys.ENTER);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test(priority=5)
	public void space() throws InterruptedException,NoSuchElementException,TimeoutException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(text(),'Spaces')]")));
		try {
			driver.findElement(By.xpath("//div[starts-with(text(),'Spaces')]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(text(),'New Space')]")));
			Actions act = new Actions(driver);
			WebElement sp = driver.findElement(By.xpath("//div[starts-with(text(),'New Space')]"));
			act.moveToElement(sp).click().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Space na﻿me']")));
			WebElement nsp = driver.findElement(By.xpath("//input[@placeholder='Enter Space na﻿me']"));
			//act.moveToElement(nsp).click().perform();
			nsp.sendKeys("TestSpace01");
			nsp.sendKeys(Keys.ENTER);
			
			/*driver.findElement(By.xpath("//button[.='Next']")).click();
			Thread.sleep(2000);
			WebElement cl =driver.findElement(By.xpath("//body/app-root[@id='app-root']/cu-modal-keeper/cu-modal[@class='ng-tns-c79-110 ng-star-inserted']/div[@class='ng-tns-c79-110 cu-modal cu-modal_md cu-modal__create-new-space cu-modal_open cu-modal_stop-open-animation']/div[@class='cu-modal__inner ng-tns-c79-110 ng-trigger ng-trigger-createTaskModalState']/div[@role='dialog']/div[@class='ng-tns-c79-110 cu-modal__body cu-modal__body_no-min-height']/cu-create-project-modal[@class='cu-create-project-modal ng-tns-c658-3 ng-star-inserted']/div[@class='ng-star-inserted']/div[@class='cu-create-project-modal__view cu-create-project-modal__view_avatar ng-star-inserted']/cu-avatar-picker[@class='cu-create-project-modal__avatar-picker cu-avatar-picker']/div[@class='cu-avatar-picker__container']/cu-color-picker-panel/div[@class='cu-color-picker-panel cu-color-picker-panel_inline cu-avatar-picker__color-picker-panel']/ul[@aria-label='Color Options']/li[4]/button[1]/span[1]"));
			act.moveToElement(cl).click().perform();*/
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
		}
		catch(TimeoutException e) {
			e.printStackTrace();
		}
	}
	@Test(priority=3)
	public void Docs() throws InterruptedException,NoSuchElementException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Docs']")));
		try {
			driver.findElement(By.xpath("//div[text()='Docs']")).click();
			/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Add new']")));
			driver.findElement(By.xpath("//div[.='Add new']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Untitled ']")));
			WebElement cls= driver.findElement(By.xpath("//div[text()=' Untitled ']"));
			
			cls.sendKeys("New");*/
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(@data-test,'simple-bar__row-item-title__All')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(text(),'Assigned to me')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(@data-test,'simple-bar__row-item-title__Shared')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(text(),'Private')]")).click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test(priority=4)
	public void Dashboard() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Dashboards']")));
		try {
			driver.findElement(By.xpath("//div[text()='Dashboards']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cu-grid-sidebar__header-actions-add-btn icon']")));
	        WebElement dsbd =driver.findElement(By.xpath("//div[@class='cu-grid-sidebar__header-actions-add-btn icon']"));
	        dsbd.click();
	       /*WebElement ndsbd = driver.findElement(By.xpath("//div[@class='cu-accordion__body ng-tns-c621-21 ng-trigger ng-trigger-accordion cu-accordion__body_expanded']"));
	        dsbd.sendKeys("NewDsbd");
	        dsbd.sendKeys(Keys.RETURN);*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=7)
	public void Sign_Out(){
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cu-avatar cu-simple-bar__bottom-avatar ng-star-inserted']")));
			driver.findElement(By.xpath("//div[@class='cu-avatar cu-simple-bar__bottom-avatar ng-star-inserted']")).click();
			driver.findElement(By.xpath("//a[.=' Log out ']")).click();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void EndBrowser() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}
}