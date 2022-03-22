package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class googleTest {
	WebDriver driver;
	@BeforeSuite
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\parthi\\drivers\\chromedriver99.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void launchGoogle() {
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Google", title);
	}
	
	@Test(priority=2)
	public void searchGoogle() {
		WebElement searchBox = driver.findElement(By.name("q"));
	//	WebElement searchButton = driver.findElement(By.name("btnK"));
		searchBox.sendKeys("Allstate India");
		searchBox.sendKeys(Keys.ENTER);
	//	searchButton.click();
		
		WebElement googleLogo = driver.findElement(By.id("logo"));
		Assert.assertTrue(googleLogo.isDisplayed());
		String title = driver.getTitle();
		System.out.println(title);		
	}
	
	@AfterSuite
	public void shutdownBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
