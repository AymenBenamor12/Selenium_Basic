package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PraticeTable13 {

	public static void main(String[] args) {
		//Read frome executable file
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
				
		//open chrome
				WebDriver driver = new ChromeDriver();	

				//open URL application	
				driver.get("https://demoqa.com/webtables");

				//Maximize Browser
				driver.manage().window().maximize();

				String sCellValue = driver.findElement(By.xpath("//*[contains(text(),'Vega')]")).getText();
				System.out.print(" the table contains last name:" +sCellValue);
			}

}
