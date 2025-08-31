package Widgets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Slider {

	public static WebDriver driver;
	public WebDriverWait wait;

	By SLIDER_INPUT = By.xpath("//input[contains(@class, 'range-slider')]");

	@BeforeClass
	public void setUp() {

		driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/slider");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@Test
	public void verifySlider() {

		//Provide INT value to move slider to.
		moveSlider(1);

	}

	public void moveSlider(int target) {

		try {
			wait.until(ExpectedConditions.elementToBeClickable(SLIDER_INPUT));
			WebElement slider = driver.findElement(SLIDER_INPUT);

			int currentValue = Integer.parseInt(slider.getAttribute("value"));

			int difference = target - currentValue;

			if (difference > 0) {
				// Move RIGHT
				for (int i = 0; i < difference; i++) {
					slider.sendKeys(Keys.ARROW_RIGHT);
				}
			} else {
				for (int i = 0; i < Math.abs(difference); i++) {
					slider.sendKeys(Keys.ARROW_LEFT);
				}
			}

			String finalValue = slider.getAttribute("value");
			System.out.println(finalValue);
			Assert.assertEquals(String.valueOf(target), finalValue, "Slider not working.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
