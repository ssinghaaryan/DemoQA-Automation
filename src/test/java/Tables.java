import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tables {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); // This launches the browser\
		driver.manage().window().maximize();
		driver.get("https://www.asx.com.au");
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
//		WebElement cookiePopUp = driver.findElement(By.id("onetrust-accept-btn-handler"));
				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
//		wait.until(ExpectedConditions.visibilityOf(cookiePopUp)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler"))).click();
		
//		cookiePopUp.click();
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("netrust-accept-btn-handler")));
		
		driver.findElement(By.xpath("//div[@id='pnProductNavContents']/h5[2]")).click();
		
		List<WebElement> rowelements = driver.findElements(By.xpath("//*[@id='home_top_five']/div/div[1]/div/div[1]/table/tr"));
		int rowSize = rowelements.size();
		
		List<WebElement> colelements =  driver.findElements(By.xpath("//*[@id='home_top_five']/div/div[1]/div/div[1]/table/tr[2]/td"));
		int colSize = colelements.size();
		
		for(int i = 2; i <= rowSize; i++) {
			
			for(int j = 1; j <= colSize; j++) {
				
//				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@class = 'md-bootstrap-tooltip']"))));
				
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[id='home_top_five']>div>div>div>div>table")));
				
				// !! > Waiting till the 1st link > 1st column > 1st table is visible i.e. clickable. Meaning the rest of the elements are now available.
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr[2]/td[1]/div/div/a")));
				
//				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("section[id='home_top_five']>div>div>div>div>table")));
				
				
				
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
//				section[id='home_top_five']>div>div>div>div>table
				
				System.out.print(driver.findElement(By.xpath("//*[@id='home_top_five']/div/div[1]/div/div[1]/table/tr[" + i + "]/td[" + j + "]")).getText() + "  ");
				
			}
			System.out.println();
		}
	}
}
