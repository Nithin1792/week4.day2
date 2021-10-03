package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ajio.com/shop/");
		
		WebElement webKids = driver.findElement(By.linkText("KIDS"));
	Actions builder = new Actions(driver);
	
	//always end with perform method
	builder.moveToElement(webKids).perform();
	
	//rightclick
	
	builder.contextClick().perform();
	builder.contextClick(webKids).perform();
	
	//doubleclick
	//builder.doubleClick().perform();
	builder.doubleClick(webKids).perform();
	
	}

}
