package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _05CalendarScript {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//label[@for='departure']/span[@class='lbl_input latoBold appendBottom10']")).click();
		
		while(!driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div")).getText().contains("November"))
		{
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		
		driver.findElement(By.xpath("//div[@aria-label='Thu Nov 07 2022']/div[@class='dateInnerCell']")).click();
		System.out.println("previous dates diabled: "+driver.findElement(By.xpath("//div[@aria-label='Tue Nov 06 2022']/div[@class='dateInnerCell']")).isEnabled());
		driver.findElement(By.xpath("//div[@aria-label='Tue Nov 22 2022']/div[@class='dateInnerCell']")).click();

	}

}
