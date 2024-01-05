package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigateCommand14 {

	public static void main(String[] args) {
		//Read frome executable file
		WebDriverManager.chromedriver().setup();
		
		//System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

		//open chrome
				WebDriver driver = new ChromeDriver();	

				//open URL application	
				driver.get("https://demoqa.com/browser-windows");

				//Maximize Browser
				driver.manage().window().maximize();
		 
				//go back
				driver.navigate().back();
				
				//go forward
				driver.navigate().forward();
				
				//refresh browser
				driver.navigate().refresh();
				
				driver.quit();

	}

}
