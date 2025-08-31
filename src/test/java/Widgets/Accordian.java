package Widgets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Accordian {
	
	public static WebDriver driver;
	
	@Test
	public void verify_accordian() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/accordian");
		
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(By.xpath("//*[@class='left-pannel']/div/div[6]"))).perform();
		
		for(int i = 1; i <= 3; i++) {
			
			WebElement contentSection = driver.findElement(By.id("section" + i + "Content"));
			
			WebElement collapsibleDiv = driver.findElement(By.xpath("//*[@id='section" + i + "Heading']/following-sibling::div"));
			
			String attributes = collapsibleDiv.getAttribute("class");
			
			if(!attributes.contains("show") && !contentSection.isDisplayed()) {
				collapsibleDiv.findElement(By.xpath("./preceding-sibling::div")).click();
				wait.until(ExpectedConditions.attributeContains(collapsibleDiv, "class", "show"));
				collapsibleDiv = driver.findElement(By.xpath("//*[@id='section" + i + "Heading']/following-sibling::div"));
				String updatedAttributes = collapsibleDiv.getAttribute("class");
				
				if(updatedAttributes.contains("show") && contentSection.isDisplayed()) {
					System.out.println("Section " + i + " expanded");
				} else {
					System.out.println("Section " + i + " is still collapsed on clicking.");
				}
			} else {
				System.out.println("Section " + i + " expanded");
			}
			
		}
		
//		driver.quit();
		
	}

}
