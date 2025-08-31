package Interactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Resizable {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	Actions actions;
	
	By RESIZABLE_BOX_RESTRICTION = By.xpath("//*[@id='resizableBoxWithRestriction']");
	By RESIZABLE_HANDLE = By.xpath("//*[@id='resizableBoxWithRestriction']/span");
	By RESIZABLE_BOX = By.xpath("//*[@id='resizable']");
	By RESIZABLE_HANDLE1 = By.xpath("//*[@id='resizable']/span");
	
	@BeforeClass
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/resizable");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		actions = new Actions(driver);
		
	}
	
	@Test
	public void verifyResizable() {
		
//		actions.dragAndDropBy(driver.findElement(RESIZABLE_HANDLE), 500, 150).perform();
		actions.clickAndHold(driver.findElement(RESIZABLE_HANDLE)).moveByOffset(250, 150).release().perform();
		
		System.out.println(driver.findElement(RESIZABLE_BOX_RESTRICTION).getAttribute("style"));
		
//		actions.dragAndDropBy(driver.findElement(RESIZABLE_HANDLE1), 600, 200).perform();
		
	}
	
//	@AfterClass
	public void tearDown() {
		
		if(driver != null) {
			driver.quit();
		}
		
	}

}
