package AutomationFramework;

import java.time.Duration;

import org.openqa.selenium.By;
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

public class ClickUp_Home_Dashboard {

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
	
	@Test (priority=2)
	public void HomeDash() throws TimeoutException,NoSuchElementException {
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@data-test,'simple-sidebar-home-item')]")));
		try {
			Thread.sleep(20000);
			driver.findElement(By.xpath("//a[contains(@data-test,'simple-sidebar-home-item')]")).click();
			Actions act = new Actions(driver);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cu-lineup__add-items-label ng-star-inserted']")));
			WebElement ln = driver.findElement(By.xpath("//div[@class='cu-lineup__add-items-label ng-star-inserted']"));
			act.moveToElement(ln).click().perform();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test (priority=3)
	public void mywork() {
		try {
		Actions act = new Actions(driver);
		WebElement task = driver.findElement(By.xpath("//button[contains(.,'Today')]"));
		act.moveToElement(task).click().perform();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
}
