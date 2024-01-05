package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DoubleClickDemo {

	public static void main(String[] args) throws InterruptedException {
		//Read frome executable file
		//System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		
		
		
		//open chrome
		WebDriver driver = new ChromeDriver();	
        
		//Implicit wait 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//open URL application
		String url = "https://demoqa.com/buttons";
		driver.get(url);
		
		//Maximize Browser
		driver.manage().window().maximize();
		
		//instantiate action class
		Actions action = new Actions(driver); 

		//Retrieve web element to perform double click
		WebElement doubleClickbtn = driver.findElement(By.id("doubleClickBtn"));
		action.doubleClick(doubleClickbtn).perform();

		String btnDoubleClick = driver.findElement(By.id("doubleClickMessage")).getText();
		Assert.assertEquals("You have done a double click", btnDoubleClick);
		
		// Kill browser
		  driver.quit();
	
	}

}
