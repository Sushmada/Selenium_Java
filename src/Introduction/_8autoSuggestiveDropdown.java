package Introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class _8autoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ak");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase("pakistan"))
					{
				option.click();
				//System.out.println(driver.findElement(By.xpath("//input[@id='autosuggest']")).getText());
				//Assert.assertEquals(driver.findElement(By.xpath("//input[@id='autosuggest']")).getText(), "Pakistan");

				break;
					}
		}
		Thread.sleep(2000);
		//System.out.println(driver.findElement(By.xpath("//input[@id='autosuggest']")).getText());
		driver.close();


	}

}
