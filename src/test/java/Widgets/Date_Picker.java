package Widgets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Date_Picker {
	
	public static WebDriver driver;
	public WebDriverWait wait;
	
	By SELECT_DATE_INPUT = By.xpath("//*[@id='datePickerMonthYearInput']");
	By DATEPICKER = By.xpath("//*[@class='react-datepicker']");
	By MONTH_SELECT = By.xpath("//*[contains(@class, 'month-select')]");
	By YEAR_SELECT = By.xpath("//*[contains(@class, 'year-select')]");
	
	By DATE_AND_TIME_INPUT = By.xpath("//*[@id='dateAndTimePickerInput']");
	By MONTH_DOWN_ARROW = By.xpath("//span[1][contains(@class, 'month-read-view')]"); // Names not correct
	By YEAR_DOWN_ARROW = By.xpath("//span[1][contains(@class, 'year-read-view')]");
	By MONTH_DROPDOWN = By.xpath("//*[@class = 'react-datepicker__month-dropdown']");
	
	//Date Locator for 'Select Date'
	public By getDateLocator(String day) {
		return By.xpath("//*[contains(@class,'week')]/div[normalize-space()='" + day + "']");
	}
	
	//Month Locator for 'Date And Time'
	public By getMonthLocator(String month) {
		return By.xpath("//*[@class = 'react-datepicker__month-dropdown']/div[text() = '" + month + "']");
	}
	
	//Year Locator for 'Date And Time'
	public By getYearLocator(String year) {
		return By.xpath("//*[@class = 'react-datepicker__year-dropdown']/div[text() = '" + year + "']");
	}
	
	public By getTimeLocator(String time) {
		return By.xpath("//*[contains(@class, 'time-list')]/li[text() = '" + time + "']");
	}
	
	@BeforeClass
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/date-picker");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@Test(dataProvider = "dataProvider")
	public void verifyDate(String month, String year, String day) {
		
		driver.findElement(SELECT_DATE_INPUT).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(DATEPICKER));
		
		Select monthSelect = new Select(driver.findElement(MONTH_SELECT));
		monthSelect.selectByVisibleText(month);
		
		Select yearSelect = new Select(driver.findElement(YEAR_SELECT));
		yearSelect.selectByVisibleText(year);
		
		driver.findElement(getDateLocator(day)).click();
		
		String selectedDate = driver.findElement(SELECT_DATE_INPUT).getAttribute("value");
		System.out.println(selectedDate);
	}
	
	@Test(dataProvider = "dataProvider1")
	public void verifyDataAndTime(String month, String year, String day, String time) {
		
		//Click on Date and Time input field
		driver.findElement(DATE_AND_TIME_INPUT).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(DATEPICKER));
		
		//Click on the Month dropdown arrow
		driver.findElement(MONTH_DOWN_ARROW).click();
		
		//Click on the specific month
		driver.findElement(getMonthLocator(month)).click();
		
		//Click on Year dropdown arrow
		driver.findElement(YEAR_DOWN_ARROW).click();
		
		//Click on the specific year
		driver.findElement(getYearLocator(year)).click();
		
		driver.findElement(getDateLocator(day)).click();
		
		driver.findElement(getTimeLocator(time)).click();
		
		String selectedDate = driver.findElement(DATE_AND_TIME_INPUT).getAttribute("value");
		System.out.println(selectedDate);
		
	}
	
	@DataProvider(name = "dataProvider")
	public Object[][] getDates() {
		return new Object[][] {
			{"May", "2002", "28"},
			{"January", "2020", "1"},
			{"December", "2000", "30"},
			{"July", "2050", "8"}
		};
	}
	
	@DataProvider(name = "dataProvider1")
	public Object[][] getDates1() {
		return new Object[][] {
			{"May", "2025", "2", "00:30"},
			{"January", "2020", "5", "17:15"},
//			{"December", "2027"},
			{"July", "2022", "10", "23:45"}
		};
	}
	
	@AfterClass
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}

}
