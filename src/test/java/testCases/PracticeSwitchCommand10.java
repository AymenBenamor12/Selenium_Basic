package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeSwitchCommand10 {

	public static void main(String[] args) {
		
		//Read frome executable file
				//System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriverManager.firefoxdriver().setup();
				//open chrome
				WebDriver driver = new ChromeDriver();	

				//Implicit wait 
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

				//open URL application
				driver.get("https://demo.guru99.com/test/guru99home/") ;

				//Maximize Browser
				driver.manage().window().maximize();
			
				//switching the frame by id
				driver.switchTo().frame("a077aa5e");
				System.out.println("*** we are switching to the iframe***");
				
				driver.findElement(By.xpath("html/body/a/img")).click();
	            System.out.println("*** we are done**");
	
	}

}
