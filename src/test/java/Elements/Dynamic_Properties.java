package Elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Dynamic_Properties {
	
	public static WebDriver driver;
	
	@Test
	public void verify_dynamicProperties() {
		
		driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/dynamic-properties");
		
//		WebElement enabledBtn = driver.findElement(By.xpath("//button[@id='enableAfter']"));
//		System.out.println(enabledBtn);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement enabledBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='enableAfter']")));
		enabledBtn.click();
		
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//button[@id='colorChange']")), "class", "text-danger"));
		
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@id='visibleAfter']"))));
		WebElement delayedBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='visibleAfter']")));
		delayedBtn.click();
		
	}

}
