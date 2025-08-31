import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiWindow {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); // This launches the browser\
//		driver.get("https://www.salesforce.com/in/");
//		driver.findElement(By.xpath("//*[@id=\"1682325589592_4ma\"]/div[1]/article/div[2]/div/pbc-button[1]/a")).click();
//		
//		Set<String> windowHandles = driver.getWindowHandles();
//		System.out.println(windowHandles);
//		
//		Iterator<String> iterator = windowHandles.iterator();
//		String parentWindow = iterator.next();
//		String childWindow = iterator.next();
//		
//		driver.switchTo().window(childWindow);
//		
//		driver.findElement(By.name("UserFirstName")).sendKeys("Aryan");
//		driver.findElement(By.name("UserLastName")).sendKeys("Singh");
//		Thread.sleep(2000);
//		driver.switchTo().window(parentWindow);
		
		driver.manage().window().maximize();
		driver.get("https://www.salesforce.com/in/");
		driver.findElement(By.xpath("//*[@id=\"1682325589592_4ma\"]/div[1]/article/div[2]/div/pbc-button[1]/a")).click();
		
		Set<String> windowHandles = driver.getWindowHandles(); // Get all the available window handles.
		
		Iterator<String> iterator = windowHandles.iterator(); // Set an iterator to iterate through these windows.
		
		String firstPage = iterator.next();
		String secondPage = iterator.next();
		
		driver.switchTo().window(secondPage); // Switching to the second page, the required one.
		
		driver.findElement(By.xpath("//input[starts-with(@id,'UserFirstName-')]")).sendKeys("Aryan");
		driver.findElement(By.xpath("//input[contains(@id,'UserLastName-')]")).sendKeys("Singh");
		
		Thread.sleep(2000);
		driver.quit();
		
	}
}
