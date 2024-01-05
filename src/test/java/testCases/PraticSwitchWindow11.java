package testCases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PraticSwitchWindow11 {

	public static void main(String[] args) {
		//Read frome executable file
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		//open chrome
		WebDriver driver = new ChromeDriver();	

		//Implicit wait 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//open URL application
		driver.get("https://demoqa.com/browser-windows") ;

		//Maximize Browser
		driver.manage().window().maximize();
	
	  //store and print the name of the first window
		String handle = driver.getWindowHandle();
		System.out.println(handle);
	
		//Click on the button new window message
		driver.findElement(By.id("messageWindowButton")).click();
		
		//store and print the name of all the windows open
		Set<String> handles = driver.getWindowHandles();
	    System.out.println(handles);
	
       // Pass a window handle to other window
	    for(String handle1 : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle1);
	    	System.out.println(handle1);
	   
	    //kill browser
	    	driver.quit();
	    }
	}

}
