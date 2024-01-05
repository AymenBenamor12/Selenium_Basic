package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementCommand17 {

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

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		WebElement txtUsername = driver.findElement(By.id("txtUsername"));
		String attValue = txtUsername.getAttribute("id");
		System.out.println(" The attribute of username :"+attValue);

		txtUsername.clear();

		//get size
		WebElement passWord = driver.findElement(By.id("txtUsername"));
		Dimension dimension = passWord.getSize();
		System.out.println("Height :"+dimension.height + "Wid"
				+ "th :" +dimension.width);

		//get location
		Point point = passWord.getLocation();
		System.out.println("x cordinate : " +point.x +"y cordinate" +point.y);

		//verifier si le bouton affiché vrai/faux
		WebElement btnlogin = driver.findElement(By.id("btnLogin"));
		boolean statut = btnlogin.isDisplayed();
		System.out.println(statut);

		//vérifier si le bouton activié vrai/faux
		boolean statut1 = btnlogin.isEnabled();
		System.out.println(statut1);

		//vérifier si le bouton existe vrai/faux
		List<WebElement> login = driver.findElements(By.id("btnLogin"));
		if(login.size()!=0) {
			System.out.println("Button exist");
		}else {System.out.println("Button not exist");
		}

	}

}
