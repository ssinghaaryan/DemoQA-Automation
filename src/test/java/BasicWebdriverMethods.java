import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicWebdriverMethods {
	
	public static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); // This launches the browser
		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/ref=nav_logo"); // Opens the Amazon homepage.
		By location = RelativeLocator.with(By.tagName("a")).toLeftOf(By.id("nav-search-bar-form"));
//		WebElement location = driver.findElement(By.xpath("//input[@type='text' and @id='twotabsearchtextbox']"));
//		driver.findElement(withTagName("a").toLeftOf(location)).click();
		
//		driver.findElement(By.xpath("//input[@id='UserFirstName-J8sv']")).sendKeys("sdnkajsnd");
//		driver.findElement(By.xpath("//input[@type='text' and @id='twotabsearchtextbox']")).sendKeys("Keyboards");
//		driver.findElement(By.xpath("//input[@type='text' and @id='twotabsearchtextbox']")).sendKeys(Keys.RETURN);
		
//		driver.findElement(By.id("password")).sendKeys("secret_sauce");
//		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
//		driver.close();
	}

}


//input[@id='UserFirstName-J8sv']

//button[@name='start my free trial']

//input[@id='twotabsearchtextbox']