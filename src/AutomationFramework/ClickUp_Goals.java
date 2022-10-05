package AutomationFramework;

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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClickUp_Goals {

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
	public void Goals(){
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Show more')]")));
			driver.findElement(By.xpath("//div[contains(text(),'Show more')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(text(),'Goals')]")).click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=3)
	public void Add_Goals() throws NoSuchElementException,TimeoutException{
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.=' Set a Goal ']")));
			if(driver.findElement(By.xpath("//div[.=' Set a Goal ']")).isDisplayed()) {
				driver.findElement(By.xpath("//div[.=' Set a Goal ']")).click();
			}
			else {
				driver.findElement(By.xpath("//div[contains(@data-test,'goals__add')]")).click();
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@autocomplete='off']")));
			//goal name
			WebElement element = driver.findElement(By.xpath("//input[@autocomplete='off']"));
			element.sendKeys("Test1");
			element.sendKeys(Keys.RETURN);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='cu-goal-add__owners-text']")));
			
			//owner
			WebElement element1 = driver.findElement(By.xpath("//span[@class='cu-goal-add__owners-text']"));
			element1.click();
			Actions act = new Actions(driver);
			WebElement target = driver.findElement(By.xpath("//span[normalize-space()='Me']"));
			act.moveToElement(target).click().perform();
			WebElement at =driver.findElement(By.xpath("//div[@data-test='goal-add_scrollable-wizard__btn-container-assign']//button[@class='cu-btn'][normalize-space()='ok']"));
			act.moveToElement(at).click().perform();
			act.moveToElement(at).click().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ql-block']")));
			
			//description
			WebElement Desc= driver.findElement(By.xpath("//div[@class='ql-block']"));
			act.moveToElement(Desc).click().perform();
			Desc.sendKeys("Test Input2");
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='goal-add__scrollable-wizard__btn-container-description']//button[@class='cu-btn'][normalize-space()='ok']")));
		    WebElement close =driver.findElement(By.xpath("//div[@data-test='goal-add__scrollable-wizard__btn-container-description']//button[@class='cu-btn'][normalize-space()='ok']"));
			act.moveToElement(close).click().perform();
			act.moveToElement(close).click().perform();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=6)
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
	
	@Test(priority=5)
	public void Delete_Goals() throws NoSuchElementException {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cu-goal__breakdown-ellipsis icon']//*[name()='svg']")));
			Actions art = new Actions(driver);
			WebElement at = driver.findElement(By.xpath("//div[@class='cu-goal__breakdown-ellipsis icon']//*[name()='svg']"));
			art.moveToElement(at).click().perform();
			WebElement att = driver.findElement(By.xpath("//div[.='Delete']"));
			art.moveToElement(att).click().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Delete Goal']")));
			driver.findElement(By.xpath("//div[normalize-space()='Delete Goal']")).click();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test (priority=4)
	public void Edit_Goals()throws ElementClickInterceptedException,TimeoutException {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cu-goal__breakdown-ellipsis icon']//*[name()='svg']")));
			Actions art = new Actions(driver);
		    WebElement at = driver.findElement(By.xpath("//div[@class='cu-goal__breakdown-ellipsis icon']//*[name()='svg']"));
			art.moveToElement(at).click().perform();
			WebElement att = driver.findElement(By.xpath("//div[.='Rename']"));
			art.moveToElement(att).click().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='nav-editor__input ng-untouched ng-pristine ng-valid']")));
			WebElement re = driver.findElement(By.xpath("//input[@class='nav-editor__input ng-untouched ng-pristine ng-valid']"));
			art.moveToElement(re).click().perform();
			re.sendKeys("New_Edit_Goal");
			re.sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Change color ']")));
			art.moveToElement(at).click().perform();
			WebElement clr = driver.findElement(By.xpath("//div[text()=' Change color ']"));
			art.moveToElement(clr).click().perform();
			WebElement sclr = driver.findElement(By.xpath("//span[@style='background-color: rgb(255, 87, 34);']"));
			art.moveToElement(sclr).click().perform();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
