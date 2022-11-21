package Introduction;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class _30InvokingNewTabsOrWindows {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//to open new tab using selenium
		driver.switchTo().newWindow(WindowType.TAB);
		
		//to oepn a new window
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		//to get the IDs of all the windows
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();    //iterating over IDs 
		String parentWindowID = it.next();           //getting parent window ID using next()
		String childTabID = it.next();               // getting Tab Id using next()
		String newWindowID = it.next();              //getting ID of new window
		
		
		//switching control to new TAB and entering the url 
		driver.switchTo().window(childTabID);
		driver.get("https://rahulshettyacademy.com/");
		System.out.println("child window title: "+driver.getTitle());
		
		//getting the 1st cource title from the child tab
		String firstCourseTitle = driver.findElements(By.xpath("//h2/a")).get(1).getText();   //using index as 1 bcz by inspecting we got to know that iin 1st index, the required element is present
		
		//switching to parent window
		driver.switchTo().window(parentWindowID);
		System.out.println("parent window title: "+driver.getTitle());
		driver.findElement(By.cssSelector("[name='name']")).sendKeys(firstCourseTitle);     //entering the course name in the parent window Name text field
		
		driver.switchTo().window(newWindowID);
		System.out.println("new window title: "+driver.getTitle());       //prints null since we haven't entered the url
		
		driver.quit();    // to close all the opened windows

		
	}

}
