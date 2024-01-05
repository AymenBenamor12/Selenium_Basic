package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Chanel {

	 String prixdispo = "400€" ;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	       
		//open chrome
		WebDriver driver = new ChromeDriver();	
       driver.manage().window().maximize();
		
		//Implicit wait 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//open URL application
		driver.get("https://www.chanel.com/fr/") ;
		
		WebElement accept =driver.findElement(By.id("onetrust-accept-btn-handler"));
		accept.click();
		
		WebElement message =driver.findElement(By.xpath("//*[@id=\"Fashion_item1684244088339\"]/a/div[2]/div/div/h2/span"));
		String ok = "métiers d’art 2022/23";
	   String messageToWelcome = message.getText();
		Assert.assertTrue(messageToWelcome.contains(ok));
		
		
		
		
		WebElement lunette =driver.findElement(By.xpath("//*[@id=\"eyewear\"]"));
		lunette.click();
		
		//WebElement nouveau =driver.findElement(By.xpath("//*[@id=\"main-navigation\"]/ul[2]/li[1]/div/div/div[2]/div[2]/div/ul/li[1]/a"));
		//nouveau.click();
		
		WebElement essentiel =driver.findElement(By.xpath("//*[@id=\"main-navigation\"]/ul[2]/li[1]/div/div/div[2]/div[2]/div/ul/li[3]/a"));
		essentiel.click();
		
		
		//WebElement choix =driver.findElement(By.id("product-link-A71530X08101S1729"));
		//choix.click();
	
		WebElement choix2 =driver.findElement(By.id("product-link-A71305X08101S2610"));
		choix2.click();
		
		
		//WebElement nom =driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div[3]/div/div/div[4]/div/div/div/h1/span[1]"));
		//System.out.println( "le nom du lunette est : " +nom.getText());
		
		WebElement nom2 =driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div[3]/div/div/div[4]/div/div/div/h1/span[1]"));
		System.out.println( "le nom du lunette est : " +nom2.getText());
		
		
		
		//WebElement description =driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div[3]/div/div/div[4]/div/div/div/h1/span[3]"));
		//System.out.println( "description des lunette est :" +description.getText());
		
		WebElement description2 =driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div[3]/div/div/div[4]/div/div/div/h1/span[3]"));
		System.out.println( "description des lunette est :" +description2.getText());
		
		
		//WebElement prix =driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div[3]/div/div/div[4]/div/div/div/div[1]/div"));
		//System.out.println( "le prix est egale "+prix.getText());
		
		
		WebElement prix2 =driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div[3]/div/div/div[4]/div/div/div/div[1]/div/div/p"));
		System.out.println( "le prix est egale "+prix2.getText());
	
		WebElement paiment = driver.findElement(By.id("pos-cnc-btn"));
		//String  message = paiment.getText();
        String prixmessage = "AJOUTER AU PANIER";;
		Assert.assertTrue(paiment.getText().contains(prixmessage));
		
		
		driver.quit();
		
		WebElement search = driver.findElement(
				By.xpath("//button[@class='button nav-item is-hidden-s-only js-search-button']//*[name()='svg']"));
		search.click();
		WebElement inputsearch = driver.findElement(By.xpath("//input[@id='searchInput']"));
		inputsearch.sendKeys("ROUGE ALLURE");
		inputsearch.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement element = driver.findElement(By.xpath("//button[@role='button']"));
		boolean x = element.isDisplayed();

		while (x) {

			try {
				System.out.println("x est egale "+x);

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(4000);
				element.click();
				System.out.println("11111111");
				element = driver.findElement(By.xpath("//button[@role='button']"));

				x = element.isDisplayed();

			} catch (StaleElementReferenceException e) {
				break;
			}
		}

		System.out.println("222222");

		List<WebElement> lst = driver.findElements(By.xpath("(//a[@class='product-list-inline__link'])"));

		int nbr = lst.size();
		System.out.println("size de liste est egale "+nbr);

		System.out.println("33333333");
		int a = 0;
		for (int i = 0; i < nbr; i++) {

			String text = lst.get(i).getText();
			System.out.println(text);

			boolean cnt = text.contains("rouge allure");

			Assert.assertEquals(cnt,true);
			a = a + 1;

			System.out.println(a);

		}

		System.out.println("je suis a la ligne 90");

		WebElement resultat = driver.findElement(By.xpath(
				"//body/div[@id='new-search-overlay']/div[@aria-label='Search']/div[@class='search__results__axis search__results__axis--pt']/div[@class='search__results__wrapper']/div[@class='search-overlay__product-list']/div[@class='row']/div[@class='product-list simple-makeup-product-list nw-product-grid has-filters']/div[@class='products-wrapper col-s-24 col-m-24 col-l-14']/div[3]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", resultat);
		Thread.sleep(3000);

		resultat.click();
		System.out.println("je suis a la ligne 99");

		Thread.sleep(5000);

		String searchExpected1 = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[1]/div/div/div[4]/div/div/div/h1/span[1]"))
				.getText();

		System.out.println("je suis a la ligne 106");

		System.out.println("***************" + searchExpected1);

		boolean st = searchExpected1.contains("ROUGE ALLURE");

		Assert.assertTrue(st);
		System.out.println("Test Réussi" + st);
	}
	
}

	
	
	
	

