package Ecom_Demo.Ecom_Demo;

import java.awt.Desktop.Action;
import java.awt.Window;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage implements WebDriverListener{

	@Test
	public void HomePage() {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		WebDriverListener ls=null;
		driver = new ChromeDriver();

		driver.navigate().to("https://teststore.automationtesting.co.uk/");
		driver.manage().window().maximize();
		//ls.afterMaximize(null);
		
		WebElement Clothes = driver.findElement(By.id("category-3"));

		// Hover to move to Women Category
		Actions act = new Actions(driver);

		WebElement Women_Clothes = driver.findElement(By.xpath("//li[@id=\"category-5\"]"));
		act.moveToElement(Clothes).clickAndHold(Women_Clothes).click().perform();
	

		System.out.println("The Category is: "
				+ driver.findElement(By.xpath("//ul[@class=\"category-top-menu\"]/li/a")).getText());

		System.out.println("The number of available products to select:"
				+ driver.findElement(By.xpath("//div[@class=\"col-lg-5 hidden-sm-down total-products\"]")).getText());

		// Clicking of only available product
		WebElement avail_product = driver.findElement(By.className("product-description"));

		act.moveToElement(avail_product).clickAndHold().perform();
		WebElement quick_view = driver.findElement(By.xpath("//a[@data-link-action=\"quickview\"]"));
		quick_view.click();

		//To add item to cart
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println(driver.findElement(By.xpath("//div[@class=\"col-md-6 col-sm-6\"]/h1")).getText());
		
		
		WebElement size = driver.findElement(By.id("group_1"));
		Select sel = new Select(size);
		sel.selectByValue("3");

		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//a[text()='Proceed to checkout']")).click();
		//driver.close();
		
		//Cookie c=new Cookie;
		System.out.println(driver.manage().getCookies());
	}

}
