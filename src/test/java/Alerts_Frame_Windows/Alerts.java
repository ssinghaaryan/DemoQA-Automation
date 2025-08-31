package Alerts_Frame_Windows;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Alerts {
	
	public static WebDriver driver;
	
	@Test
	public void verify_alerts() throws InterruptedException {
		
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.navigate().to("https://demoqa.com/alerts");
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(By.xpath("//div[@class='accordion']/div[6]"))).perform();
		
		//Alert Button
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		driver.switchTo().alert().accept();
		
		//5 sec Timer Alert Button
		driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		handleAlert("accept");
		handleAlert("dismiss");
		
		//Prompt Alert
		driver.findElement(By.xpath("//button[@id='promtButton']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		String promptString = "Sampler Text";
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(promptString);
		alert.accept();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='promptResult']")).getText(), "You entered " + promptString);
		
		driver.quit();
	}
	
	public void handleAlert(String action) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		
		switch(action.toLowerCase()) {
			case "accept":
				driver.switchTo().alert().accept();	
				Assert.assertEquals(driver.findElement(By.xpath("//span[@id='confirmResult']")).getText(), "You selected Ok");
				break;

			case "dismiss":
				driver.switchTo().alert().dismiss();		
				Assert.assertEquals(driver.findElement(By.xpath("//span[@id='confirmResult']")).getText(), "You selected Cancel");
				break;
				
			default: System.out.println("No action performed");
		}
		
	}

}
