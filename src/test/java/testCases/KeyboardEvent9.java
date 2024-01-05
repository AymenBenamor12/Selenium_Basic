package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardEvent9 {

	public static void main(String[] args) {
		//Read frome executable file
		//System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		
		//open chrome
		WebDriver driver = new ChromeDriver();	

		//Implicit wait 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//open URL application
		driver.get("https://demoqa.com/text-box") ;

		//Maximize Browser
		driver.manage().window().maximize();
	
		//Fin web element
		WebElement fullName = driver.findElement(By.id("fixedban"));
		WebElement userEmail = driver.findElement(By.id("userEmail"));
		WebElement currentAddress = driver.findElement(By.id("currentAddress"));
		WebElement permantAddress = driver.findElement(By.id("permanentAddress"));
	
		//Instantiate class actions
		Actions action = new Actions(driver);
		action.sendKeys(fullName, "Aymen").perform();
		action.sendKeys(userEmail, "Aymen.amor@gmail.com").perform();
		action.sendKeys(currentAddress, "douz").perform();
	
		//copy paste current address
		action.keyDown(currentAddress, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(permantAddress, Keys.CONTROL ).perform();
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
	  
		//javascript executor
	    WebElement submit = driver.findElement(By.id("submit"));
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", submit);
	    
	    
	}

}
