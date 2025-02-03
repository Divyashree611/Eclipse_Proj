package Ecom_Demo.Ecom_Demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Accessories{
	@Test
	public void Accesories_Test() {

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.setAcceptInsecureCerts(true);
		opt.setBrowserVersion("131.0.6778.204");
		
		driver = new ChromeDriver(opt);

		driver.navigate().to("https://teststore.automationtesting.co.uk/");
		driver.manage().window().maximize();
	
		
		WebElement accessories=driver.findElement(By.id("category-6"));
		WebElement Stationery=driver.findElement(By.id("category-7"));
		WebElement Home_accessories=driver.findElement(By.id("category-8"));
		
		Actions act = new Actions(driver);
		act.moveToElement(accessories).click(Stationery).build().perform();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String prods=driver.findElement(By.xpath("//div[@class='col-lg-5 hidden-sm-down total-products']")).getText();
		
		System.out.println(prods);
		
		//Filters
		driver.findElement(By.xpath("//span[@class=\"custom-checkbox\"]")).click(); //Instock
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
//		WebElement element = driver.findElement(By.xpath("//input[contains(@data-search-url,'Plain')]"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		Thread.sleep(500);
//
//		element.click(); //Plain
		
		List<WebElement> filters=driver.findElements(By.xpath("//section[@id=\"js-active-search-filters\"]/ul/li")); //Applied filters		
		for(WebElement i: filters) {
			System.out.println("Applied filters are:"+i.getText());
			driver.close();
		}		

	}
}