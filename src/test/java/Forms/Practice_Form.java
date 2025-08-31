package Forms;

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
import org.testng.annotations.Test;

public class Practice_Form {
	
	public static WebDriver driver;
	
	@Test
	public void verify_PracticeForm() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/automation-practice-form");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(By.xpath("//button[@id='submit']"))).perform();
		
//		//Gender Radio option
//		driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
//		
//		Thread.sleep(2000);
//		//Month Dropdown Selector
//		driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
//		Select month = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
//		month.selectByVisibleText("May");
//		
//		Thread.sleep(2000);
//		//Year Dropdown Selector
//		Select year = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
//		year.selectByVisibleText("2000");
//		
//		//Date Selector
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day react-datepicker__day--021')]")).click();
//		
//		Thread.sleep(2000);
//		//Subject Selector
//		driver.findElement(By.xpath("//input[@id='subjectsInput']")).sendKeys("Maths");
//		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'subjects-auto-complete__option') and text()='Maths']")));
//		option.click();
//		
//		//Hobbies Radio option
//		driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();
//		driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();
//		driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']")).click();
		
		driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys(System.getProperty("user.dir") + "/test-data/paw.webp");
		
		//State Dropdown Selector
		Thread.sleep(2000);
		action.scrollToElement(driver.findElement(By.xpath("//div[@class='practice-form-wrapper']//following::div[starts-with(@id, 'Ad.Plus')][1]"))).perform();
		driver.findElement(By.xpath("//div[@id='state']")).click();
		List<WebElement>  stateList = driver.findElements(By.xpath("//div[starts-with(@id, 'react-select-3-option-')]"));
		int randomState = (int) (Math.random() * stateList.size());
		driver.findElement(By.xpath("//div[@id='react-select-3-option-" + randomState + "']")).click();
		
		//City Dropdown Selector
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='city']")).click();
		List<WebElement> cityList = driver.findElements(By.xpath("//div[starts-with(@id, 'react-select-4-option-')]"));
		int randomCity = (int) Math.random() * cityList.size();
		driver.findElement(By.xpath("//div[@id='react-select-4-option-" + randomCity + "']")).click();
		
	}

}
