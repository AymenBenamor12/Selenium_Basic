package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TooltipDemo12 {

	public static void main(String[] args) {
		//Read frome executable file
				//System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriverManager.firefoxdriver().setup();
				//open chrome
				WebDriver driver = new ChromeDriver();	

				//Implicit wait 
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

				//open URL application
				driver.get("https://demoqa.com/tool-tips/") ;

				//Maximize Browser
				driver.manage().window().maximize();
				
				WebElement tooltipText = driver.findElement(By.id("toolTipButton"));
				String textTooltip = tooltipText.getText();
				
				if ( textTooltip.equalsIgnoreCase("Hover me to see")) {
					System.out.println(" pass : tooltip matching expected value");
				} else {System.out.println("fail : tooltip not matching expected value");
			}
				WebElement placeHolder = driver.findElement(By.id("toolTipTextField"));
				String textPlaceHolder = placeHolder.getAttribute("placeholder");
				System.out.println("PlaceHolder is" + textPlaceHolder);
			}
			
	
	}



