import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoIframe {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); // This launches the browser
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
//		driver.manage().window().maximize();

//		driver.switchTo().frame("iframeResult"); //By using the id for the iFrame.
		
//		WebElement frame = driver.findElement(By.id("iframeResult"));
//		driver.switchTo().frame(frame);
//		driver.findElement(By.xpath("/html/body/button")).click();
		
//      Trying is out second time.
		
		// 1. Using Index --> Not very reliable, last option.
//		driver.switchTo().frame(1);
//		driver.findElement(By.xpath("/html/body/button"));
		
		// 2. Using iframe's id/name attribute.
//		driver.switchTo().frame("iframeResult");
//		driver.findElement(By.xpath("html/body/button")).click();
		
		// 3. Using iframe as a WebElement.
		driver.switchTo().frame(driver.findElement(By.name("iframeResult")));
		driver.findElement(By.xpath("html/body/button")).click();
		
		 
		
		Thread.sleep(2000);
		driver.quit();
	}
}
