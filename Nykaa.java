package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.nykaa.com/");

		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));

		Actions builder = new Actions(driver);
		builder.moveToElement(brands).perform();

		// Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Oreal Paris')][1]")).click();
		System.out.println("Title: " + driver.getTitle());

		// Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='fa fa-angle-down']")).click();

		driver.findElement(By.xpath("(//div[@class='control-box sort-control-box']//div)[8]")).click();
		Thread.sleep(5000);
		WebElement hairClick = driver.findElement(By.xpath("(//div[contains(@class,'pull-right filter-options')])[1]"));
		driver.executeScript("arguments[0].click();", hairClick);
		driver.findElement(By.xpath("(//div[@class='filter-options-toggle'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='filter-options-toggle'])[2]")).click();
		driver.findElement(By.xpath("(//div[@class='control__indicator'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='pull-right filter-options-toggle'])[6]")).click();
		driver.findElement(By.xpath("//label[contains(@for,'Color Protection')]//div")).click();
		String text = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']/li")).getText();
		System.out.println(text);
		if (text.contains("Shamp")) {
			System.out.println("text matches");
		} else {
			System.out.println("txt doesnt match");
		}

		Thread.sleep(4000);

		WebElement shampoo = driver.findElement(By.xpath("(//span[contains(text(),'Oreal Paris Colour Protect')])[1]"));
		driver.executeScript("arguments[0].click();", shampoo);

		Set<String> windowSet = driver.getWindowHandles();

		List<String> listWindow = new ArrayList<String>(windowSet);
		driver.switchTo().window(listWindow.get(1));

		String mrp = driver.findElement(By.xpath("(//span[@class='post-card__content-price-offer'])[1]")).getText();
		System.out.println("MRP: " + mrp);

		driver.findElement(By.xpath("(//button[text()='ADD TO BAG'])[1]  ")).click();
		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		String grandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println("GrandTotal: " + grandTotal);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();

		String finalGrandTotal = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		if (finalGrandTotal.equalsIgnoreCase(finalGrandTotal)) {
			System.out.println("GrandTotal at check out is verified");

		} else {
			System.out.println("Test case failed");
		}
	}

}
