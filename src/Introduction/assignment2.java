package Introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.findElement(By.name("name")).sendKeys("abc");
		driver.findElement(By.name("email")).sendKeys("xyz@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("aks");
		driver.findElement(By.cssSelector("#exampleCheck1")).click();
		WebElement genderDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select gender = new Select(genderDropdown);
		gender.selectByIndex(1);
		driver.findElement(By.xpath("//input[@id='inlineRadio1']")).click();
		driver.findElement(By.name("bday")).sendKeys("22111998");
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
		driver.close();

	}

}
