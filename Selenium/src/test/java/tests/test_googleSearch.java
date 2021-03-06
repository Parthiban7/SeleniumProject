package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test_googleSearch {
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws Exception {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\parthi\\drivers\\chromedriver99.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", "C:\\parthi\\drivers\\geckodriver97.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.chrome.driver", "C:\\parthi\\drivers\\msedgedriver99.exe");
			driver = new ChromeDriver();
		}
		else {
			throw new Exception("Incorrecy Browser");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}
	
	@Test
	public void launchGoogle() {
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Allstate");
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
		System.out.println(driver.getTitle());		
	}
	
	@AfterTest
	public void quitbrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
