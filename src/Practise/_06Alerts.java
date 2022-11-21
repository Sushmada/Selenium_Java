package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _06Alerts {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		System.out.println(driver.getTitle());
		String nameText = "Bujji";
		driver.findElement(By.id("name")).sendKeys(nameText);
		driver.findElement(By.id("alertbtn")).click();
		System.out.println("alerts contains name: "+driver.switchTo().alert().getText().contains(nameText));
		driver.switchTo().alert().accept();
		driver.findElement(By.id("name")).sendKeys(nameText);
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();
		driver.close();

	}

}
