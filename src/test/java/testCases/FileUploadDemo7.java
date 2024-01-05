package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadDemo7 {

	public static void main(String[] args) {
		       //Read frome executable file
				//System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		        WebDriverManager.chromedriver().setup();
		
				//open chrome
				WebDriver driver = new ChromeDriver();	

				//Implicit wait 
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

				//open URL application
				driver.get("https://demo.guru99.com/test/upload/") ;


				//Maximize Browser
				driver.manage().window().maximize();
 
				WebElement uploadFile = driver.findElement(By.id("uploadfile_0"));
				uploadFile.sendKeys("C:\\Users\\AYMEN\\Desktop\\the way 2\\anime.jpeg");

	}

}
