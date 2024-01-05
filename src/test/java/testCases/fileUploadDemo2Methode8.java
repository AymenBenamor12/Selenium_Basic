package testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fileUploadDemo2Methode8 {

	
		
		public WebDriver driver;
		public WebDriverWait wait;
		private static String filePath ="C:\\Users\\AYMEN\\Desktop\\the way 2\\anime.jpeg";
		
		
		@BeforeMethod
		public void setup() {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		driver.navigate().to("https://blueimp.github.io/jQuery-File-Upload/");
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		//wait = new WebDriverWait(driver,10);
		driver.manage().window().maximize();
		}
		
		@Test
		public void roboTest() throws InterruptedException {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-sucess.fileinput-button")));
			driver.findElement(By.cssSelector(".btn.btn-sucess.fileinput-button")).click();
			uploadFileWithRobot(filePath);
		
			Thread.sleep(3000);
		}
		@AfterMethod
		public void tearDown() {
			
			driver.quit();
		}
		
		//file Upload by robot class
		public void uploadFileWithRobot(String imagePath) {
			StringSelection stringSelection = new StringSelection(imagePath);
		Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipBoard.setContents(stringSelection, null);
		
		Robot robot = null;
		try {
			robot = new Robot(); // Cette instance de Robot sera utilisée pour effectuer des actions automatisées, telles que le déplacement du pointeur de la souris ou la génération de frappes de clavier.
		}catch (AWTException e) {
			e.printStackTrace();
		}
	robot.delay(250);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.delay(150);
	robot.keyRelease(KeyEvent.VK_ENTER);
		}
}


