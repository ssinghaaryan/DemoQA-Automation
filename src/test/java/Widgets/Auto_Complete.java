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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Auto_Complete {

	public static WebDriver driver;

	By DELETE_BUTTON = By.xpath("//*[contains(@class, 'remove')]");

	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/auto-complete");

	}

	@Test
	public void verifyAddAutoComplete() throws InterruptedException {

		int total = 0;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Actions actions = new Actions(driver);
		actions.scrollToElement(driver.findElement(By.xpath("//*[@class='left-pannel']/div/div[6]"))).perform();

		while (total < 4) {

			driver.findElement(By.xpath("//*[@id='autoCompleteMultipleInput']")).sendKeys("l");
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'auto-complete__menu-list')]")));

			List<WebElement> multipleDrodpwn = driver
					.findElements(By.xpath("//*[contains(@class, 'auto-complete__menu-list')]//div"));

			int randomNumber = (int) Math.floor(Math.random() * multipleDrodpwn.size());
			System.out.println(randomNumber);

			multipleDrodpwn.get(randomNumber).click();
			total++;
		}

		verifyDeleteAutoComplete(total);

	}

	@Test
	public void verifyDeleteAutoComplete(int total) throws InterruptedException {

		while(driver.findElements(DELETE_BUTTON).size() > 0 && total > 0) {

			driver.findElement(DELETE_BUTTON).click();
			total--;
			
		}
	}
}
