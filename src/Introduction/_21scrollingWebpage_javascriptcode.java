package Introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class _21scrollingWebpage_javascriptcode {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//we canot scroll the webpage using selenium, so we use javascript for scrolling operation
		//we have typecasted javascriptExecutor with driver object
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//javascript to scroll the entire webpage
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3000);
		//javascript to scroll the particular element in the webpage like tables
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=500");
		Thread.sleep(5000);
		List<WebElement> numsString = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i=0; i<numsString.size(); i++)
		{
			int nums = Integer.parseInt(numsString.get(i).getText());
			sum = sum+nums;
		}
		System.out.println(sum);
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, total);
		driver.close();

	}

}
