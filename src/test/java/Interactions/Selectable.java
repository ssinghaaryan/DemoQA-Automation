package Interactions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Selectable {

	public static WebDriver driver;
	public static WebDriverWait wait;
	Actions actions;

	By VERTICAL_LIST = By.xpath("//*[@id='verticalListContainer']/li");
	By GRID_TAB = By.xpath("//*[text() = 'Grid']");

	public By getRow(int i) {
		return By.xpath("//*[@id='gridContainer']/div[@id='row" + i + "']/li");
	}

	@BeforeClass
	public void setUp() {

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.navigate().to("https://demoqa.com/selectable");
		actions = new Actions(driver);

	}

	@Test
	public void verifySelectable() throws InterruptedException {

		listSelectItems();
		Thread.sleep(5000);
		listDeselectItems();

		driver.findElement(GRID_TAB).click();
		Thread.sleep(5000);
		gridSelectItems();
		Thread.sleep(5000);
		gridDeselectItems();

	}

	public void gridSelectItems() {
		for (int i = 1; i <= 3; i++) {
			List<WebElement> list = driver.findElements(getRow(i));
			selectFromList(list);
		}
	}

	public void gridDeselectItems() {
		for (int i = 1; i <= 3; i++) {
			List<WebElement> list = driver.findElements(getRow(i));
			deselectFromList(list);
		}
	}

	public void listSelectItems() {

		List<WebElement> list = driver.findElements(VERTICAL_LIST);
		selectFromList(list);

	}

	public void listDeselectItems() {

		List<WebElement> list = driver.findElements(VERTICAL_LIST);
		deselectFromList(list);

	}
	
	public void selectFromList(List<WebElement> list) {
		
		for (WebElement item : list) {
			if (!item.getAttribute("class").contains("active")) {
				item.click();
				System.out.println("Selected: " + item.getText());
				Assert.assertTrue(item.getAttribute("class").contains("active"));
			} else {
				System.out.println("Already selected: " + item.getText());
				continue;
			}
		}
	}
	
	public void deselectFromList(List<WebElement> list) {
		
		for (WebElement item : list) {
			if (item.getAttribute("class").contains("active")) {
				item.click();
				System.out.println("Deselected: " + item.getText());
				Assert.assertTrue(!item.getAttribute("class").contains("active"));
			} else {
				System.out.println("Already Deselected: " + item.getText());
				continue;
			}
		}
		
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
