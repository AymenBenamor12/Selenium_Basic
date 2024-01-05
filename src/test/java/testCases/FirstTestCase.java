package testCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestCase {

	public static void main(String[] args) throws InterruptedException  {
		// Read frome executable file
		//System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = new ChromeDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		// Maximize browser
		driver.manage().window().maximize();

		// Delete cookies
		driver.manage().deleteAllCookies();

		// open URL application
		driver.get("https://opensource-demo.orangehrmlive.com/");

		// fill Username
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

		// fill password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

		// wait s sec
		//Thread.sleep(5000);
		// Click login button
		 driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

		// click button login with explicit wait
		//WebDriverWait wait = new WebDriverWait(driver,20);
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		 
		WebElement loginBtn;
		loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
		By.xpath("//button[@type='submit']")));
		loginBtn.click();
        
		
		
		// Print a log in message to the screen
		System.out.println("Successfuly authentication");

		String userAdmin = driver.findElement(By.id("welcome")).getText();
		Assert.assertEquals("Welcome RamRamRam", userAdmin);
		Assert.assertTrue(userAdmin.contains("Welcome"));
		// Kill browser
		driver.close(); // ferme seulement le page actuel
		// driver.quit(); // pour ferme tout les navigateurs

	}

}
