package testCases;


import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertDemo4 {

	public static void main(String[] args) throws IOException {
		//Read frome executable file
		//System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
       
		//open chrome
		WebDriver driver = new ChromeDriver();	

		//Implicit wait 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//open URL application
		driver.get("https://demoqa.com/alerts") ;


		//Maximize Browser
		driver.manage().window().maximize();

		driver.findElement(By.id("alertButton")).click();

		//Accept Alert
		driver.switchTo().alert().accept();

		  
		
		//kill browser
		driver.quit();
	}
}


