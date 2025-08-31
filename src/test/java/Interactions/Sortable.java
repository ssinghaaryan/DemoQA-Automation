package Interactions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sortable {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	Actions actions;
	
	By VERTICAL_LIST_ITEMS = By.xpath("//*[contains(@class, 'vertical-list-container')]/div");
	By GRID_TAB = By.xpath("//*[text() = 'Grid']");
	By GRID_LIST_ITEMS = By.xpath("//*[contains(@class, 'grid-container')]/div/div");
	
	@BeforeClass
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/sortable");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		actions = new Actions(driver);
		
	}
	
	@Test
	public void verifySortable() throws InterruptedException {
		
		actions.scrollToElement(driver.findElement(By.xpath("//*[text() = 'Book Store Application']")));
		
		sortListAndGrid(VERTICAL_LIST_ITEMS);
		
		Thread.sleep(2000);
		
		driver.findElement(GRID_TAB).click();
		
		sortListAndGrid(GRID_LIST_ITEMS);
		
	}
	
	public void sortListAndGrid(By locator) {
		
		//Printing initial list
		List<String> initialList = getListText(locator);
		System.out.println("Initial Order: " + initialList);
		
		//Sorting the order randomly.
		List<WebElement> existingList = getFreshList(locator);
		
		actions.clickAndHold(existingList.get(0)).moveToElement(existingList.get(3)).release().perform();
		
		existingList = getFreshList(locator);
		actions.clickAndHold(existingList.get(existingList.size()-1)).moveToElement(existingList.get(0)).release().perform();
		
		existingList = getFreshList(locator);
		actions.clickAndHold(existingList.get(4)).moveToElement(existingList.get(existingList.size()-1)).release().perform();
		
		List<String> updatedList = getListText(locator);
		System.out.println("Updated Order: " + updatedList);
		
	}
	
	public List<WebElement> getFreshList(By locator) {
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public List<String> getListText(By locator) {
		List<String> texts = new ArrayList<>();
		for(WebElement item: getFreshList(locator)) {
			texts.add(item.getText().trim());
		}
		return texts;
	}
	
	@AfterClass
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}

}
