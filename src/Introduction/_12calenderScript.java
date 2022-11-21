package Introduction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _12calenderScript {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(5000);
		

		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
		
		
		while(!driver.findElement(By.xpath("//span[@class='cur-month']")).getText().contains("November"))
		{
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
		}
		List<WebElement> dates = driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
		int count = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).size();
		for(int i=0; i<count; i++)
		{
			String text = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();
			if(text.equalsIgnoreCase("17"))
			{
				driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();
				break;
			}
				
		}

		

	}

}
