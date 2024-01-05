package testCases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Read frome executable file
				//System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
				WebDriverManager.chromedriver().setup();
		       
				//open chrome
				WebDriver driver = new ChromeDriver();	

				//Implicit wait 
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

				//open URL application
				driver.get("https://demoqa.com/alerts") ;


				//Maximize Browser
				driver.manage().window().maximize();

				
				TakesScreenshot screenshot= (TakesScreenshot) driver;
		        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);

		        //String destinationPath = "C:\\Users\\AYMEN\\Desktop\\excelProjet.screenshot.png";

		        File destinationFile = new File("D:\\Screenshot-Selenium\\screenshot.png");
		        try {
		            FileUtils.copyFile(screenshotFile, destinationFile);
		            System.out.println("Capture d'écran effectuée avec succès. Chemin du fichier : " + destinationFile.getAbsolutePath());
		        } catch (IOException e) {
		            System.out.println("Erreur lors de l'enregistrement du screenshot : " + e.getMessage());
		        }
		        
		        
		        //Screenshot for logo
		        WebElement logo = driver.findElement(By.xpath("//*[@id=\"app\"]/header/a/img"));
		        
		        // capture screenshot with getScreenshotAs() of the WebElement class
		        File f = logo.getScreenshotAs(OutputType.FILE);
		        
		        FileUtils.copyFile(f, new File("D:\\Screenshot-Selenium\\logoscreenshot.png"));
		        
		        
		     // Locate the element on the web page
		        WebElement logoElement = driver.findElement(By.xpath("//*[@id=\"app\"]/header/a/img"));
		        
		        // Get screenshot of the visible part of the web page
		        File screenshot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        
		        // Convert the screenshot into BufferedImage
		        BufferedImage fullScreen = ImageIO.read(screenshot3);
		        
		        //Find location of the webelement logo on the page
		        Point location = logoElement.getLocation();
		        
		        //Find width and height of the located element logo
		        int width = logoElement.getSize().getWidth();
		        int height = logoElement.getSize().getHeight();

			//cropping the full image to get only the logo screenshot
		        BufferedImage logoElementImage = fullScreen.getSubimage(location.getX(), location.getY(),
		                width, height);
		        ImageIO.write(logoElementImage, "png", screenshot3);
		        
		        //Save cropped Image at destination location physically.
		        FileUtils.copyFile(screenshot3, new File("D:\\Screenshot-Selenium\\particularElementScreenshot.PNG"));
		        
		        
		        
		        driver.close();
		    
	
	
	
	}

	}


