package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverCommand16 {

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

		String title = driver.getTitle();
		int titelength = title.length();
		System.out.println("title of the page is : "+title);
		System.out.println("title length :"+titelength);

		String actualURL = driver.getCurrentUrl();
		if (actualURL.equals(url)) {
			System.out.println("verification successful . the correct url is opened");
		}else { System.out.println("verification failed . an incorrect url is opened");
		}
		System.out.println("actul URL is :"+actualURL);
		System.out.println("Expected URL is :"+url);

		String pageSource = driver.getPageSource();
		int pageSourcelength = pageSource.length();
		System.out.println("Total length of the page source is :"+pageSourcelength);

	}

}
