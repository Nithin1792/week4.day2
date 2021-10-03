package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/resizable/");
		
	WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
	driver.switchTo().frame(frame);
	
	WebElement icon = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
	
		Actions builder = new Actions(driver);
		
		Actions moveToElement = builder.moveToElement(icon);
		moveToElement.clickAndHold();
		
		builder.moveToElement(icon,-100,-100).perform();

		
		
		
//		Thread.sleep(2000);
//		builder.moveByOffset(20, 20).perform();				
	
	}

}
