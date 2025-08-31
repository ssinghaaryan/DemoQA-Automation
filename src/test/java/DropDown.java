import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver(); // This launches the browser
//		driver.manage().window().maximize();
//
//		driver.get("https://demoqa.com/select-menu");
//		WebElement dd = driver.findElement(By.name("cars"));
//		Select select = new Select(dd);
//		
//		select.selectByVisibleText("Audi");
//		Thread.sleep(2000);
//		select.selectByIndex(2);
//		Thread.sleep(2000);
//		List<WebElement> allItems = select.getAllSelectedOptions();
//		System.out.println(allItems);
//		select.deselectAll();
//		
//		select.selectByVisibleText("Volvo");
//		Thread.sleep(2000);
//		select.selectByIndex(1);
//		Thread.sleep(2000);
//		select.deselectByIndex(1);
//		List<WebElement> finalItems = select.getAllSelectedOptions();
//		System.out.println(finalItems);
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/select-menu");
		WebElement dd = driver.findElement(By.id("cars"));
		Select select = new Select(dd);
		
		// --- Multi select options dropdown ---
		/*
		List<WebElement> options = select.getOptions();
		System.out.println(options.size());
		
		// Select options
		select.selectByValue("saab");
		Thread.sleep(2000);
		select.selectByVisibleText("Audi");
		Thread.sleep(2000);
		select.selectByIndex(0);
		Thread.sleep(2000);
		
		// Get all selected options
		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		System.out.println(selectedOptions);
		
		// Deselect selected options
		select.deselectAll();
		*/
		
		// --- Single select dropdown ---
//		select.selectByVisibleText("Audi");
//		Thread.sleep(2000);
//		select.selectByIndex(1);
//		Thread.sleep(2000);
//		WebElement firstOption = select.getFirstSelectedOption();
//		System.out.println(firstOption.getText());m 
		
		Thread.sleep(2000);
		driver.quit();
		
		
	}
}


//input[@id='UserFirstName-J8sv']

//button[@name='start my free trial']

//input[@id='twotabsearchtextbox']