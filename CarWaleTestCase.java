package week4.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarWaleTestCase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notification");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.carwale.com/");
		driver.findElement(By.xpath("//span[text()='Used']")).click();

		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Chennai");
		driver.findElement(By.xpath("//mark[text()='Chennai']")).click();
		//

		driver.findElement(By.xpath("//div[text()='Choose your Budget']"));

		
//		 WebElement scroll1 = driver.findElement(By.xpath("(//button[@type='button']/div)[1]")); 
//		 Actions builder = new Actions(driver);
//		
//		Thread.sleep(5000);
//		builder.dragAndDropBy(scroll1,70,70).perform();
//		 
//		 WebElement scroll2 =driver.findElement(By.xpath("(//button[@type='button']/div)[2]"));
//		 builder.dragAndDropBy(scroll2,-60,-60).perform();
//		  
//		 WebElement scrollMin =
//		 driver.findElement(By.xpath("//input[@type='number']"));
//		  
//		 System.out.println("price beginning text field: " +
//		 scrollMin.getAttribute("value"));
//		  
//		  WebElement scrollMax =
//		 driver.findElement(By.xpath("//input[@placeholder='Max']"));
//		  System.out.println("Max price: " + scrollMax.getAttribute("value"));
		 

		WebElement scrollMin = driver.findElement(By.xpath("//input[@type='number']"));
		scrollMin.sendKeys("4");

		System.out.println("Min Value: " + scrollMin.getAttribute("value"));

		WebElement scrollMax = driver.findElement(By.xpath("//input[@placeholder='Max']"));
		scrollMax.sendKeys("12");
		System.out.println("Max price: " + scrollMax.getAttribute("value"));

	}

}
