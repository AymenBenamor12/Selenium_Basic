package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownList15 {

	public static void main(String[] args) {
		//Read frome executable file
	//System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		
	
		
		//open chrome
		WebDriver driver = new ChromeDriver();	

		//open URL application	
				driver.get("https://demoqa.com/select-menu");

				//Maximize Browser
				driver.manage().window().maximize();
				
				//to perform scoll on application selenuim 
				JavascriptExecutor js = (JavascriptExecutor)driver ;
		        js.executeScript("window.scrollBy(0, 500)", "");

				Select se = new Select(driver.findElement(By.id("oldSelectMenu")));
				se.selectByIndex(3);
				se.selectByValue("5");
				//se.deselectByVisibleText();
			
				Select carsSelect = new Select(driver.findElement(By.id("cars")));
				if (carsSelect.isMultiple()) {
					carsSelect.selectByIndex(1);
					carsSelect.selectByIndex(2);
				}
	}

}
