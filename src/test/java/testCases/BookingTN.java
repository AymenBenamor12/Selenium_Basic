package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookingTN {

	public static  void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	       
		//open chrome
		WebDriver driver = new ChromeDriver();	

		//Implicit wait 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//open URL application
		driver.get("https://tn.tunisiebooking.com/") ;


		//Maximize Browser
		driver.manage().window().maximize();
		
		WebElement destination = driver.findElement(By.id("col_destina"));
		destination.click();
		
		List<WebElement> lst = driver.findElements(By.cssSelector(".list_dest li"));
		
		int nbr = lst.size();
		System.out.println("size de liste est egale "+nbr);
		for (int i = 0; i < nbr; i++) {
			String text = lst.get(i).getText();
			System.out.println(text);	
		}
		
		WebElement jrb = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/form/div/div[4]/ul/li[7]"));
		jrb.click();
		WebElement arrive = driver.findElement(By.id("icon_arriv"));
		
		arrive.click();
		
		
		
		
		
		
		
		//kill browser
		//driver.quit();

	}

	

}
