package Widgets;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tabs {

	public static WebDriver driver;
	public WebDriverWait wait;

	By TAB_LIST = By.xpath("//*[@class='nav nav-tabs']/a");
	By ACTIVE_TAB_CONTENT = By.xpath("//*[@class='tab-content']/div[contains(@class,'active')]");

	@BeforeClass
	public void setUp() {

		driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/tabs");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@Test
	public void verifyTabs() {

		List<WebElement> tabList = driver.findElements(TAB_LIST);

		for (WebElement tab: tabList) {
			
			try {
				wait.until(ExpectedConditions.elementToBeClickable(tab));
				tab.click();
				System.out.println("Clicked Tab: " + tab.getText());
			} catch(Exception e) {
				System.out.println("Skipped: " + tab.getText());
				continue;
			}

			Assert.assertEquals(tab.getAttribute("aria-selected"), "true", tab.getText() + " is not selected.");
			Assert.assertTrue(tab.getAttribute("class").contains("active"), tab.getText() + " is not active.");

			WebElement tabContent = driver.findElement(ACTIVE_TAB_CONTENT);
			List<WebElement> paragraphs = tabContent.findElements(By.tagName("p"));

			if (!paragraphs.isEmpty()) {
				for (WebElement para : paragraphs) {
					Assert.assertTrue(para.isDisplayed(), "Content for the selected tab is not displayed.");
					System.out.println("Content for " + tab.getText() + " is: " + para.getText());
				}
			} else {
				System.out.println("No content found for: " + tab.getText());
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
