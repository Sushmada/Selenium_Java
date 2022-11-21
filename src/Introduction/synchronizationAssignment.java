package Introduction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class synchronizationAssignment {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//div/label[2]/span/following-sibling::input/following-sibling::span")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		WebElement dropDown = driver.findElement(By.cssSelector("select.form-control"));
		Select s = new Select(dropDown);
		s.selectByValue("consult");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.cssSelector("input.btn.btn-info.btn-md")).click();
		w.until(ExpectedConditions.urlMatches("https://rahulshettyacademy.com/angularpractice/shop"));
		List<WebElement> addBtns = driver.findElements(By.cssSelector("button.btn.btn-info"));
		for (int i = 0; i < addBtns.size(); i++) {
			addBtns.get(i).click();
		}
		driver.findElement(By.xpath("//a[contains(@class, 'btn-primary')]")).click();
		driver.close();

	}

}
