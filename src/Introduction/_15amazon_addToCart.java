package Introduction;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _15amazon_addToCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] vegs = { "Beetroot", "Carrot", "Beans" };

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		//Impllicit wait statememt which is applied globally for all the statements in the whole code
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		//declartion od explicit wait by craeting object
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		addItems(driver, vegs);
		driver.findElement(By.xpath("//div[@class='cart-preview active'] //button[@type='button']")).click();
		//wait until the given locator is visible on the webpage
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

	public static void addItems(WebDriver driver, String[] vegs) {
		int j = 0;
		List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < items.size(); i++) {
			List<String> vegs_list = Arrays.asList(vegs);
			String[] item = items.get(i).getText().split("-");
			String actual_item = item[0].trim();
			if (vegs_list.contains(actual_item)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == vegs.length) {
					break;
				}
			}
		}

		driver.findElement(By.className("cart-icon")).click();
		List<WebElement> selected_items = driver
				.findElements(By.xpath("//div[@class='cart-preview active'] //p[@class='product-name']"));
		for (WebElement a : selected_items) {
			String[] b = a.getText().split("-");
			System.out.println(b[0].trim());
		}
	}

}
