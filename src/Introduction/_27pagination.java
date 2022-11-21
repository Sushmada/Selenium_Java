package Introduction;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class _27pagination {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> results = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<String> original = results.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sorted = original.stream().sorted().collect(Collectors.toList());
		Assert.assertEquals(original, sorted);
		
		List<String> price;
		do {
		List<WebElement> vegs = driver.findElements(By.xpath("//tr/td[1]"));
		price = vegs.stream().filter(s->s.getText().contains("Rice")).map(s->vegPrice(s)).collect(Collectors.toList());
		
		price.forEach(s->System.out.println("price of rice: "+s));
		
		if(price.size()<1)
		{
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
		}while(price.size()<1);

	}

	private static String vegPrice(WebElement s) {
		
		String vegPrice = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return vegPrice;
	}

}
