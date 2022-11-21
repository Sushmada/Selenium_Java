package JavaScriptLogs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class JavaScriptLogsUsingSelenium {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		//write this script in OnTestFailure Listener
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("7");
		
		LogEntries entries = driver.manage().logs().get(LogType.BROWSER);     //using Selenium we are extracting the JavaScript failure logs from browser
		List<LogEntry> logs = entries.getAll();                              //LogEntry object, getAll() will returns all the logs
		 
		for(LogEntry e : logs)                     //iterating through all the logs to get the message
		{
			System.out.println(e.getMessage());     //if you are using TestNG, just push these logs into Logs4j instead of printing 
		}
	}

}
