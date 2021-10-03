package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.leafground.com/pages/table.html");

		// Find the table
		WebElement webTable = driver.findElement(By.id("table_id"));

		// to find all the rows in the table so I will use findelements and it will
		// return in list
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		// find the size of the row

		System.out.println("Number of rows:" + tableRows.size());

// get the count of the columns
		// picked one single row
		WebElement webFirstRow = tableRows.get(1);
		List<WebElement> tableColumn = webFirstRow.findElements(By.tagName("td"));
		System.out.println("Number of Columns: " + tableColumn.size());
		
		
		//get all the contents
		
		for (WebElement webElement : tableRows) {
			String text = webElement.getText();
			System.out.println(text);
		}
	
	//get specific column
		// giving one as index 1 is for td
		for (int i = 1; i < tableRows.size(); i++) {
			WebElement indivRow = tableRows.get(i);
			List<WebElement> findIndivColmn = indivRow.findElements(By.tagName("td"));
			System.out.println(findIndivColmn.get(1).getText());
			
		}
	
	
	}

}
