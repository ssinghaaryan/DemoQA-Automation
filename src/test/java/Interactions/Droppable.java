package Interactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Droppable {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	Actions actions;
	
	//Simple Locators
	By SIMPLE_DRAGGABLE = By.xpath("//*[@id='simpleDropContainer']/div[contains(@class, 'drag')]");
	By SIMPLE_DROPPABLE = By.xpath("//*[@id='simpleDropContainer']/div[contains(@class, 'drop')]");
	
	//Active Locators
	By NOT_ACCEPTABLE_DRAGGABLE = By.xpath("//*[@id='notAcceptable']");
	By ACCEPTABLE_DRAGGABLE = By.xpath("//*[@id='acceptable']");
	By ACCEPTABLE_DROPPABLE = By.xpath("//*[@id='acceptDropContainer']/div[contains(@class, 'drop')]");
	
	@BeforeClass
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/droppable");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		actions = new Actions(driver);
		
	}
	
	@Test
	public void verifySimpleDroppable() {
		
		WebElement draggable = driver.findElement(SIMPLE_DRAGGABLE);
		WebElement droppable = driver.findElement(SIMPLE_DROPPABLE);
		
		holdAndMove(draggable, droppable);
		validateDrop(draggable, droppable, true);
		
	}
	
	@Test
	public void verifyAcceptDroppable() {
		
		driver.findElement(By.xpath("//*[text() = 'Accept']")).click();
		
		WebElement notDraggable = driver.findElement(NOT_ACCEPTABLE_DRAGGABLE);
		WebElement draggable = driver.findElement(ACCEPTABLE_DRAGGABLE);
		WebElement droppable = driver.findElement(ACCEPTABLE_DROPPABLE);
		
		holdAndMove(notDraggable, droppable);
		validateDrop(notDraggable, droppable, false);
		
		holdAndMove(draggable, droppable);
		validateDrop(draggable, droppable, true);
		
	}
	
	@Test
	 public void verifyPreventPropogation() {
		
		driver.findElement(By.xpath("//*[text() = 'Prevent Propogation']")).click();
		
		holdAndMove(driver.findElement(By.xpath("//*[@id='dragBox']")), driver.findElement(By.xpath("//*[@id='notGreedyDropBox']")));
		
	}
	
	public void validateDrop(WebElement draggable, WebElement droppable, boolean shouldDrop) {
		
		holdAndMove(draggable, droppable);
		
		if(shouldDrop) {
			Assert.assertTrue(droppable.getAttribute("class").contains("highlight") && droppable.getText().equalsIgnoreCase("Dropped!"), "Fail");
			System.out.println("Droppable element IS active & highlighted!");
		} else {
			Assert.assertFalse(droppable.getAttribute("class").contains("active"), "Not Draggable element dropped & Droppable element active!");
			System.out.println("Droppable element NOT active & highlighted!");
		}
		
	}
	
	public void holdAndMove(WebElement element1, WebElement element2) {
		actions.clickAndHold(element1).moveToElement(element2).release().perform();
		System.out.println("Element moved to: " + element1.getAttribute("style"));
	}
	
	@AfterClass
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}

}
