import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActions {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); // This launches the browser\
		driver.manage().window().maximize();
		driver.get("https://extendsclass.com//text-compare");
		
		Actions action = new Actions(driver);
		
		Thread.sleep(2000);
		WebElement firstDropZone = driver.findElement(By.xpath("//*[@id=\"dropZone\"]/div[2]/div"));
		action.keyDown(firstDropZone, Keys.COMMAND).keyDown("a").keyDown("c").build().perform();
		
		Thread.sleep(2000);
		WebElement secondDropZone = driver.findElement(By.xpath("//*[@id=\"dropZone2\"]/div[2]/div"));
		action.keyDown(secondDropZone, Keys.COMMAND).keyDown("a").keyDown("v").build().perform();

		
		Thread.sleep(2000);
		driver.quit();
		
	}
}
