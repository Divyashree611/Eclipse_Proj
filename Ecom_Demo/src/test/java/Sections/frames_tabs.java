package Sections;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frames_tabs {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//To handle iframe and multiple browser tabs
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		
//		driver.get("https://automationtesting.co.uk/iframes.html");
//		driver.manage().window().maximize();
//		
//		//Child window
//		driver.switchTo().frame(0);
//		driver.findElement(By.xpath("//a[@class=\"toggle\"]")).click();
//		Thread.sleep(5);
//		
//		
//		driver.switchTo().parentFrame();
//		driver.findElement(By.xpath("//a[@class=\"toggle\"]")).click();
//		
//		driver.switchTo().frame(1);
//		//driver.findElement(By.cssSelector(".ytp-play-button ytp-button")).click();
//		driver.findElement(By.cssSelector("[aria-label='Play']")).click();
//		driver.quit();
//		
		//Multiple browser windows
		

		driver=new ChromeDriver();
//		driver.get("https://automationtesting.co.uk/browserTabs.html");
//		
//		for(int i=0;i<3;i++) {
//			driver.findElement(By.xpath("//input[@value=\"Open Tab\"]")).click();
//		}
//		
//		Set<String>wh=driver.getWindowHandles();
//		
//		for(String s:wh) {
//			driver.switchTo().window(s);
//		}
		driver.get("https://automationtesting.co.uk/buttons.html");
		driver.manage().window().maximize();
		WebElement button=driver.findElement(By.id("btn_two"));
		
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scroll(0,200)");
		jse.executeScript("arguments[0].click()", button);
	
		
		driver.switchTo().alert().dismiss();
		
		

	}

}
