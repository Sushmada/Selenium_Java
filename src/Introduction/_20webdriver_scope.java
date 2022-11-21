package Introduction;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _20webdriver_scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//to get total number of links in webpage
		//HINT: all links in tghe webpage will have "a" tag (anchor tag)
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//to get links count only in the footer section
		//should change the scope of webdriver and we should limit the focus to particular section
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));  //limiting webdriver focus to footer
		System.out.println(footerdriver.findElements(By.tagName("a")).size());  //count of links in footer section
		
		
		//to get the links count only in the first columnn of the footer
		//should again limit the scope of webdriver to that particular section using previously defined webelement
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int linkCount = columndriver.findElements(By.tagName("a")).size();
		System.out.println(linkCount);
		
		//to click on all the links in the column 2 i,e checking if they working fine
		for(int i=1; i<linkCount; i++)
		{
			//to open all the links in seperate tabs, use logic CONTROL+click on particular link
			//or CONTROL+ENTER on the link to open in a new tab
			
			String linksClick = Keys.chord(Keys.CONTROL,Keys.ENTER);
			//passing linksClick variable to sendkeys to perform click action on the links individually
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(linksClick);
			Thread.sleep(5000);
		}
		
		//to navigate to individual tabs and grab the title of the webpage
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> tabs = windows.iterator();
		
		while(tabs.hasNext())
		{
			driver.switchTo().window(tabs.next());
			System.out.println(driver.getTitle());
		}
		
		//my code
		/*for(int i=1;i<=windows.size();i++)
		{
			//tabs.next(); //parent window //if we use next() twice, then alternate window titles are displayed
			String a = tabs.next();
			System.out.println(driver.switchTo().window(a).getTitle());
		}
		*/
	}

}
