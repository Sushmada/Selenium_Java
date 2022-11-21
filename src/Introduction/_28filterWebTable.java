package Introduction;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class _28filterWebTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("ato");
		List<WebElement> result = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> list = result.stream().filter(s->s.getText().contains("ato")).collect(Collectors.toList());
		result.stream().filter(s->s.getText().contains("ato")).forEach(s->System.out.println(s));
		
		Assert.assertEquals(result, list);

	}

}
