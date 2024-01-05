package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class aymen {
	public static void main(String[] args) {
	//Read frome executable file
			//System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	        WebDriverManager.chromedriver().setup();
			//open chrome
			WebDriver driver = new ChromeDriver();	

			//Implicit wait 
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

			//open URL application
			driver.get("https://demoqa.com/menu/") ;


			//Maximize Browser
			driver.manage().window().maximize();

			//instantiate action class
			Actions action = new Actions(driver);
			WebElement mouseHover = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/a"));
			action.moveToElement(mouseHover).perform();
		}

}
