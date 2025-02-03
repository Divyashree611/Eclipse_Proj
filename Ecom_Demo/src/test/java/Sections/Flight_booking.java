package Sections;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flight_booking {
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://www.easyjet.com/");
		driver.manage().window().maximize();
		
		WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(5));
		wt.until(ExpectedConditions.elementToBeClickable(By.id("ensRejectAll")));
		
		driver.findElement(By.id("ensRejectAll")).click();
		
		//Searching of flights
		//From
		String default_loc=driver.findElement(By.id("from")).getAttribute("value");
		System.out.println("The default From Location is:"+default_loc);
		
		//Clear deafault Location
		driver.findElement(By.cssSelector(".TextBox_clearButton__NXFRp")).click();
		
		//Enter 'Lon' to from and traverse list
		driver.findElement(By.id("from")).sendKeys("Lon");
		List<WebElement> from_Cities=
				driver.findElements(By.cssSelector(".AirportsField_airportList__0hWHo li>label>div>span"));
				//("//ul[@class=\"AirportsField_airportList__0hWHo\"]/li/label"));
		/*
		 * Can use CSS selector .AirportsField_airportList__0hWHo li>label>div>span
		 */
		for(WebElement city: from_Cities) {
			//System.out.println(city.getAttribute("for"));
			//if(city.getAttribute("for").contentEquals("LTN_from_option"))
			if(city.getText().contains("LTN")){
				city.click();
				break;
			}
		}
		

		//Enter 'Ind' to from and traverse list
		driver.findElement(By.id("to")).sendKeys("In");
		List<WebElement> dest_cities=
				driver.findElements(By.cssSelector(".AirportsField_airportList__0hWHo li>label>div>span"));
				//("//ul[@class=\"AirportsField_airportList__0hWHo\"]/li/label"));
		/*
		 * Can use CSS selector .AirportsField_airportList__0hWHo li>label>div>span
		 */
		for(WebElement city: dest_cities) {
			//System.out.println(city.getText());
			//if(city.getAttribute("for").contentEquals("LTN_from_option"))
			if(city.getText().contains("AUH")){
				city.click();
				break;
			}
		}
		
		
		
	}

}
