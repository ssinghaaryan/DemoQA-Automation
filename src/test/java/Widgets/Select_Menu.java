package Widgets;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Select_Menu {

	public static WebDriver driver;
	public static WebDriverWait wait;
	Actions actions;

	By OPTION_GROUP = By.xpath("//*[@id='withOptGroup']");
	By OPTIONS = By.xpath("//*[contains(@class, 'option')]");
	By SELECT_ONE = By.xpath("//*[@id='selectOne']");
	By OLD_SELECT_MENU = By.xpath("//*[@id='oldSelectMenu']");
	By MULTISELECT_DROPDOWN = By.xpath("//*[text() = 'Select...']/parent::div");
	By MULTISELECT_MENU = By.xpath("//*[@id='cars']");

	@BeforeClass
	public void setUp() {

		driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/select-menu");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		actions = new Actions(driver);

	}

	@Test
	public void verifySelectMenu() throws InterruptedException {

		actions.scrollToElement(driver.findElement(By.xpath("//*[text() = 'Interactions']")))
				.perform();

		driver.findElement(OPTION_GROUP).click();
		selectRandomOption();

		driver.findElement(SELECT_ONE).click();
		selectRandomOption();
		
		Select oldMenuSelect = new Select(driver.findElement(OLD_SELECT_MENU));
		List<WebElement> oldMenuOptions = oldMenuSelect.getOptions();
		
		int randomIndex = (int) Math.floor(Math.random() * oldMenuOptions.size());
		oldMenuSelect.selectByIndex(randomIndex);
		
		driver.findElement(MULTISELECT_DROPDOWN).click();
		List<WebElement> multiSelectOptions = driver.findElements(OPTIONS);
		for(WebElement option: multiSelectOptions) {
			option.click();
		}
		
		Select standardMenuSelect = new Select(driver.findElement(MULTISELECT_MENU));
		standardMenuSelect.isMultiple();
		List<WebElement> standardSelectOptions =  standardMenuSelect.getOptions();
		for(WebElement option: standardSelectOptions) {
			standardMenuSelect.selectByVisibleText(option.getText());
			System.out.println(option.getText());
		}

	}

	public void selectRandomOption() throws InterruptedException {

		try {

			List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(OPTIONS));

			int random = (int) Math.floor(Math.random() * options.size());
			System.out.println(random);
			Thread.sleep(2000);
			WebElement option = options.get(random);

			actions.scrollToElement(option).perform();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(option)).click();
			System.out.println(option.getText());

		} catch (Exception e) {
			System.out.println("Couldn't click one of dropdowns" + e);
		}
		
	}

//	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
