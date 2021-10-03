package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitlyWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.leafground.com/pages/disapper.html");
	
	WebElement webDisappear = driver.findElement(By.xpath("//button[@id='btn']/b"));
	
	// for explicitly wait u have to import WebDriverWait
	WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(2));
	wait.until(ExpectedConditions.invisibilityOf(webDisappear));
	
	String text = driver.findElement(By.tagName("strong")).getText();
	System.out.println(text);
	
	}

}
