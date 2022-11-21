package Introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _1browserLaunch {

	public static void main(String[] args) {
		
		//chrome launch
		//System.setProperty("webdriver.chrome.driver", "C:C:\Users\W10-Lenovo\OneDrive\Desktop\Udemy_Selenium\1. driver executables\\chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		//ChromeDriver driver = new ChromeDriver();
		
		//firefox launch
		//System.setProperty("webdriver.gecko.driver", "C:C:\Users\W10-Lenovo\OneDrive\Desktop\Udemy_Selenium\1. driver executables\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		
		//ms edge launch
		System.setProperty("webdriver.edge.driver", "C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		
		driver.get("https://rahulshettyacademy.com/");
	    System.out.println(driver.getTitle()); 
	    System.out.println(driver.getCurrentUrl());
	    driver.close();
	    //driver.quit();

	}

}
