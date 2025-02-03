package Ecom_Demo.Ecom_Demo;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Clothes {

	@Test
	public void clothes_men() {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(opt);

		driver.navigate().to("https://teststore.automationtesting.co.uk/");
		driver.manage().window().maximize();
		WebElement Clothes_men = driver.findElement(By.id("category-3"));

		// Hover to move to Women Category
		Actions act = new Actions(driver);

		WebElement Men_Clothes = driver.findElement(By.xpath("//li[@id=\"category-4\"]"));
		act.moveToElement(Clothes_men).clickAndHold(Men_Clothes).click().perform();

		System.out.println("The Category is: "
				+ driver.findElement(By.xpath("//ul[@class=\"category-top-menu\"]/li/a")).getText());

		System.out.println("The number of available products to select:"
				+ driver.findElement(By.xpath("//div[@class=\"col-lg-5 hidden-sm-down total-products\"]")).getText());

		// Clicking of only available product
		WebElement avail_product = driver.findElement(By.className("product-description"));
//
		act.moveToElement(avail_product).clickAndHold().perform();
		WebElement quick_view_variant = driver.findElement(By.xpath("//div[@class=\"variant-links\"]/a[1]"));
		quick_view_variant.click();
//
//		//To add item to cart
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		System.out.println(driver.findElement(By.xpath("//div[@class=\"col-md-6 col-sm-6\"]/h1")).getText());
//		
//		
		WebElement sizes = driver.findElement(By.id("group_1"));
		WebElement default_size=driver.findElement(By.xpath("//div[@class='clearfix product-variants-item'][1]/span"));
		System.out.println(default_size.getText());
		if(default_size.getText().equalsIgnoreCase("Size: M")) {
			Select sel = new Select(sizes);
			sel.selectByValue("4");
		}

//
//		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
//		
		driver.findElement(By.xpath("//button[@class='btn btn-primary add-to-cart']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//div[@class=\"cart-content-btn\"]/a")).click();//proceed
		driver.findElement(By.xpath("//div[@class=\"text-sm-center\"]/a")).click();//checkout
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.findElement(By.linkText("Sign in")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//	    driver.findElement(By.cssSelector("#field-email")).sendKeys("divyashree@gmail.com");
//		driver.findElement(By.cssSelector("#field-password")).sendKeys("Armycarat75$");
//		driver.findElement(By.id("submit-login")).submit();
		
		driver.close();
		
	}

}
