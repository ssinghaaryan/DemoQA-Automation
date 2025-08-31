package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Links {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		String homeURL = "https://demoqa.com/links";
		driver.navigate().to(homeURL);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@class='category-cards']/div[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[6]")).click();
	}
	
//	@Test
	public static void main(String[]args) throws InterruptedException {
		
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[@class='category-cards']/div[1]")).click();
		
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[6]")).click();

		//New Tab opening links
		Thread.sleep(2000);
		String parentTab = driver.getWindowHandle();
		//Clicking the Simple Link
		driver.findElement(By.xpath("//a[@id='simpleLink']")).click();
		
		String newTab = driver.getWindowHandle();
		System.out.println(driver.getCurrentUrl().contains("https://demoqa.com/"));
		Thread.sleep(2000);
		
		driver.switchTo().window(parentTab);
		
	}
	
	@Test(dataProvider="linkData")
	public void verify_apiCallLinks(String linkId, String expectedStatus, String expectedText) throws InterruptedException {
		
		driver.findElement(By.id(linkId)).click();
		Thread.sleep(2000);
		String responseText = driver.findElement(By.xpath("//p[@id='linkResponse']")).getText();
		Thread.sleep(2000);
//		String[] parts = responseText();
		Assert.assertTrue(responseText.contains(expectedStatus));
		Assert.assertTrue(responseText.contains(expectedText));
//		Assert.assertEquals(parts[0], expectedStatus);
//		Assert.assertEquals(parts[1], expectedText);
		
	}
	
	@DataProvider(name="linkData")
	public Object[][] provideLinkData() {
		return new Object[][] { 
			{"created", "201", "Created"},
			{"no-content", "204", "No Content"},
            {"moved", "301", "Moved Permanently"},
            {"bad-request", "400", "Bad Request"},
            {"unauthorized", "401", "Unauthorized"},
            {"forbidden", "403", "Forbidden"},
            {"invalid-url", "404", "Not Found"}
		};
	}
	
/*	
	public static String[] responseText() {
		String responseText = driver.findElement(By.xpath("//p[@id='linkResponse']")).getText();
		String responseTextArray[] = responseText.split(" ");
		return new String[]{responseTextArray[5], responseTextArray[9]};
	}
*/
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
