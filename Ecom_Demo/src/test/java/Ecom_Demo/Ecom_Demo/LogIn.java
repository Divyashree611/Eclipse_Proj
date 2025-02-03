package Ecom_Demo.Ecom_Demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogIn {

	 WebDriver driver;

	@Test
	@Parameters("driver")
	public void Login(WebDriver driver){
		// TODO Auto-generated method stub
		this.driver= driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.navigate().to("https://teststore.automationtesting.co.uk/");
		driver.findElement(By.xpath("//div[@class=\"user-info\"]//a/span")).click();
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement email=driver.findElement(By.id("field-email"));
		wait.until(ExpectedConditions.visibilityOf(email));
		
		email.sendKeys("divyashree@gmail.com");
		driver.findElement(By.id("field-password")).sendKeys("Armycarat75$");
		driver.findElement(By.id("submit-login")).click();
		
		String user=driver.findElement(By.xpath("//a[@class=\"account\"]//span")).getText();
		System.out.println("User Logged in is:"+user);
		driver.close();
		
		
	}

}
