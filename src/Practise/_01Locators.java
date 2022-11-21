package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class _01Locators {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		System.out.println(driver.getTitle());
		String usn = "bangaru";
		driver.findElement(By.xpath("//form/h1/following-sibling::input[1]")).sendKeys(usn);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("1234567");
		driver.findElement(By.xpath("//input[@name='chkboxOne']")).click();
		driver.findElement(By.cssSelector("span:nth-child(2) input")).click();
		driver.findElement(By.cssSelector(".submit")).click();
		String error = driver.findElement(By.cssSelector("p.error")).getText();
		Assert.assertEquals(error, "* Incorrect username or password");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//form/h2/following-sibling::input[1]")).sendKeys("BUJJII");
		driver.findElement(By.xpath("//form/h2/following-sibling::input[2]")).sendKeys("bujji@bangaru.com");
		driver.findElement(By.xpath("//form/h2/following-sibling::input[3]")).sendKeys("1432");
		driver.findElement(By.cssSelector("div button:nth-child(2)")).click();
		String pw = driver.findElement(By.cssSelector("p[class='infoMsg']")).getText().split("'")[1].split("'")[0];
		driver.findElement(By.xpath("//div/button[@class='go-to-login-btn']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//form/h1/following-sibling::input[1]")).sendKeys(usn);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(pw);
		driver.findElement(By.cssSelector(".submit")).click();
		Thread.sleep(5000);
		boolean usnContains = driver.findElement(By.cssSelector(".login-container")).getText().contains(usn);
		System.out.println(usn+" contains: "+usnContains);
		driver.findElement(By.className("logout-btn")).click();
		driver.close();

	}

}
