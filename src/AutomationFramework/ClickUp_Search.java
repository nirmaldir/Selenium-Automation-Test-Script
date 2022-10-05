package AutomationFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClickUp_Search {

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
	public void SearchFn() throws TimeoutException, InterruptedException {
		//Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Search')]")));
		try {
		Actions act = new Actions(driver);
		WebElement srch=driver.findElement(By.xpath("//div[contains(text(),'Search')]"));
		act.moveToElement(srch).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Search or run a command..')]")));
		WebElement sr = driver.findElement(By.xpath("//input[contains(@placeholder,'Search or run a command..')]"));
		sr.sendKeys("Task");
		//sr.sendKeys(Keys.ENTER);
		WebElement stk=driver.findElement(By.xpath("//div[.=' Tasks ']"));
		act.moveToElement(stk).click().perform();
		Thread.sleep(1000);
		WebElement stds=driver.findElement(By.xpath("//div[.=' Docs ']"));
		act.moveToElement(stds).click().perform();
		Thread.sleep(1000);
		WebElement stwt=driver.findElement(By.xpath("//div[.=' Whiteboards ']"));
		act.moveToElement(stwt).click().perform();
		Thread.sleep(1000);
		WebElement sdb=driver.findElement(By.xpath("//div[.=' Dashboards ']"));
		act.moveToElement(sdb).click().perform();
		Thread.sleep(1000);
		WebElement sct=driver.findElement(By.xpath("//div[.=' Chats ']"));
		act.moveToElement(sct).click().perform();
		Thread.sleep(1000);
		WebElement srfl=driver.findElement(By.xpath("//div[.=' Files ']"));
		act.moveToElement(srfl).click().perform();
		Thread.sleep(1000);
		WebElement spf=driver.findElement(By.xpath("//div[.=' People ']"));
		act.moveToElement(spf).click().perform();
		Thread.sleep(1000);
		WebElement sral=driver.findElement(By.xpath("//div[.=' Tasks ']"));
		act.moveToElement(sral).click().perform();
		Thread.sleep(1000);
		WebElement srtk=driver.findElement(By.xpath("//div[.=' NXT Task ']"));
		act.moveToElement(srtk).build().perform();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
