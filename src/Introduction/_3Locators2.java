package Introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class _3Locators2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String name = "bujji<3";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String password = getPassword(driver);
		Thread.sleep(5000);
		driver.findElement(By.className("go-to-login-btn")).click();
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
	    System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
	    Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
	    Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
	    driver.findElement(By.xpath("//button[text()='Log Out']")).click();
	    driver.close();

		
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		//driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		String[] passwordArray = driver.findElement(By.className("infoMsg")).getText().split("'");
		//0th index> Please use temporary password
		//1st index> rahulshettyacademy' to Login.
		String password = passwordArray[1].split("'")[0]; //or String passwordArray2 = passwordArray[1].split("'")
		                                                  //  String password = passwordArray2[0]
		//0th index> rahulshettyacademy
		//1st index> to Login.
		
	    return password;
	}

}
