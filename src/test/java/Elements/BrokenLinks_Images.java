package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrokenLinks_Images {
	
	public static WebDriver driver;
	
	@Test
	public void verify_brokenImages() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/broken");
		
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(By.xpath("//div[@class='accordion']/div[3]"))).perform();
		
		//Validating the valid & broken images.
		Assert.assertTrue(isImageLoaded(driver.findElement(By.xpath("//h1[@class='text-center']//following-sibling::img[1]"))), "Valid image is not loaded");
		Assert.assertFalse(isImageLoaded(driver.findElement(By.xpath("//h1[@class='text-center']//following-sibling::img[2]"))), "Broken image is loaded");
		
		//Validating the broken & valid URLs.
		Thread.sleep(2000);
		driver.findElement(By.linkText("Click Here for Valid Link")).click();
		Assert.assertEquals("https://demoqa.com/", driver.getCurrentUrl());
		
		Thread.sleep(2000);
		driver.navigate().back();
		action.scrollToElement(driver.findElement(By.xpath("//div[@class='accordion']/div[3]"))).perform();
		driver.findElement(By.linkText("Click Here for Broken Link")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("500"), "No 500 status code found");
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static boolean isImageLoaded(WebElement imageElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (Boolean) js.executeScript("return arguments[0].complete && arguments[0].naturalWidth > 0;", imageElement);
	}

}
