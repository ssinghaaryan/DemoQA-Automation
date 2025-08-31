package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Buttons {
	
	public static WebDriver driver;
	
	@Test
	public static void main(String[]args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/");
		driver.findElement(By.xpath("//div[@class='category-cards']/div[1]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[5]")).click();
		
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath("//button[@id='doubleClickBtn']"))).perform();
		Thread.sleep(2000);
		action.contextClick(driver.findElement(By.xpath("//button[@id='rightClickBtn']"))).perform();
		Thread.sleep(2000);
		action.click(driver.findElement(By.xpath("//button[@id='rightClickBtn']//following::button"))).perform();
		
		driver.quit();
		
	}

}
