import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	public static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); // This launches the browser
		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/v1/"); // Opens the Amazon homepage.
		driver.manage().window().maximize();
		
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		
		String title = driver.getTitle();
		System.out.println(title);
		
//		String pageSource = driver.getPageSource();
//		System.out.println(pageSource);
		
		//driver.navigate().to("https://www.google.com");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='inventory_list']/div"));
		System.out.println(list);
		
		
	}

}


//input[@id='UserFirstName-J8sv']

//button[@name='start my free trial']

//input[@id='twotabsearchtextbox']