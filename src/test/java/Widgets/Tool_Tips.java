package Widgets;

import java.time.Duration;
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

public class Tool_Tips {

	public static WebDriver driver;
	public WebDriverWait wait;

	By TOOLTIP_BUTTON = By.xpath("//*[@id='toolTipButton']");
	By TOOLTIP_TEXTFIELD = By.xpath("//*[@id='toolTipTextField']");
	By TOOLTIP_TEXT = By.xpath("//*[@id='texToolTopContainer']/a");
	By BUTTON_TOOLTIP = By.xpath("//*[@id='buttonToolTip']");
	By TEXTFIELD_TOOLTIP = By.xpath("//*[@id='textFieldToolTip']");
	By TEXT_TOOLTIP = By.xpath("//*[@id='contraryTexToolTip']");
	By SECTION_TOOLTIP = By.xpath("//*[@id='sectionTexToolTip']");

	public By getToolTip(String name) {

		return By.xpath("//*[@id='" + name + "']");

	}

	@BeforeClass
	public void setUp() {

		driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/tool-tips");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@Test
	public void verifyToolTip() throws InterruptedException {

		Actions actions = new Actions(driver);

		actions.scrollToElement(driver.findElement(By.xpath("//*[@class='left-pannel']/div/div[4]/div/ul/li[9]")))
				.perform();

		actions.moveToElement(driver.findElement(TOOLTIP_BUTTON)).perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(BUTTON_TOOLTIP)));
		System.out.println(driver.findElement(BUTTON_TOOLTIP).getText());

		actions.moveToElement(driver.findElement(TOOLTIP_TEXTFIELD)).perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(TEXTFIELD_TOOLTIP)));
		System.out.println(driver.findElement(TEXTFIELD_TOOLTIP).getText());

		List<WebElement> textLinks = driver.findElements(TOOLTIP_TEXT);
		for(WebElement link : textLinks) {
			actions.moveToElement(link).perform();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.attributeToBeNotEmpty(link, "aria-describedBy"));
			String toolTipType = link.getAttribute("aria-describedBy");
			System.out.println(driver.findElement(getToolTip(toolTipType)).getText());
		}
	}

	@AfterClass
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}

}
