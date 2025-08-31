package Elements;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTables {
	
	public static WebDriver driver;
	
	@Test
	public static void main(String[]args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://demoqa.com");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='category-cards']/div[1]")).click();
		
		//Web Tables component
		String headerArr[] = {"First Name", "Last Name", "Age", "Email", "Salary", "Department", "Action"};
		driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[4]")).click();
		List<WebElement> tableHeaders = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
		Thread.sleep(2000);
		for(WebElement s: tableHeaders) {
//			System.out.println(Arrays.asList(headerArr).contains(s.getText()));
		}
		
		String firstName = "Test";
		
		driver.findElement(By.id("addNewRecordButton")).click();
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys("User");
		driver.findElement(By.id("userEmail")).sendKeys("testuser@yahoo.com");
		driver.findElement(By.id("age")).sendKeys("20");
		driver.findElement(By.id("salary")).sendKeys("500000");
		driver.findElement(By.id("department")).sendKeys("QA");
		driver.findElement(By.id("submit")).click();
		
		Thread.sleep(2000);
		
		//Checking if firstName column contains the newly added user entry.
		List<WebElement> firstNames = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div[1]"));	
		for(WebElement first: firstNames) {
			if(first.getText().equalsIgnoreCase(firstName)) {
				System.out.println("First Name present!");
			}
		}
		
		//Searching and checking if user entry displayed.
		driver.findElement(By.id("searchBox")).sendKeys(firstName);
		Thread.sleep(2000);
		List<WebElement> searchedNames = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div[1]"));
		for(WebElement name: searchedNames) {
			if(name.getText().equalsIgnoreCase(firstName)) {
				System.out.println("Searched!");
			}
		}
		
		
		driver.quit();
		
		
		
	}

}
