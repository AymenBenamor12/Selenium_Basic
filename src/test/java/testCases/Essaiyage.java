package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Essaiyage {

	public static void main(String[] args) {
		  WebDriverManager.chromedriver().setup();
			//open chromes
			WebDriver driver = new ChromeDriver();	

			//Implicit wait 
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

			//open URL application
			driver.get("https://fr.shein.com/?r") ;


			//Maximize Browser
			driver.manage().window().maximize();

		

	}

}
