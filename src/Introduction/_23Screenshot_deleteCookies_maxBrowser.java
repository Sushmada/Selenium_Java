package Introduction;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.apache.commons.io.FileUtils;

public class _23Screenshot_deleteCookies_maxBrowser {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		//deleting all cookies
		driver.manage().deleteAllCookies();
		//deleting any one particular cookie
		//driver.manage().deleteCookieNamed("abc");
		
		driver.get("https://www.google.com/");
		/*
		//INTERVIEW QUESTION
		//to automate a scenario like when sessionID cookie is deleted, user shd logout of the app.
		driver.manage().deleteCookieNamed("sessionKey");//sessionKey is just an example
		driver.findElement(By.id("xyz")).click();//bcz after deleting the sessionId cookie, on clicking on any of the links user shd logout of the app and shd land on the sign in screen.
		Assert.assertEquals(driver.getTitle(), "title of the sign in screen");//just an example i,e validating if the user has landed on the sign in screen by checking the title of the screen.
		*/
		
		//to take a screenshot of the webpage
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\GoogleScreenshot.png"));

	}

}
