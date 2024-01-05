package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyColorOfElement18 {

	public static void main(String[] args) {
		//Read frome executable file
		//System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		//open chrome
		WebDriver driver = new ChromeDriver();	

		//Implicit wait 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//open URL application
		String url = "https://opensource-demo.orangehrmlive.com/";
		driver.get(url);

		//Maximize Browser
		driver.manage().window().maximize();

		String color = driver.findElement(By.xpath("//*[@id='content']/div[2]/span")).getCssValue("color");
		String[]hexValue = color.replace("rgba(", "").replace(")", "").split(",");
		int hexValue1 = Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2 = Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3 = Integer.parseInt(hexValue[2]);

		String actualColor = String.format("", hexValue1, hexValue2, hexValue3);
		System.out.println("Color is :"+actualColor);
		Assert.assertEquals("#ff0000", actualColor);

		driver.quit();

	}

}
