package Introduction;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class _31WebElementScreenshotAndDimensionsOfWebelement {

	public static void main(String[] args) throws IOException {
		//PREVIOUS CODE
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
		WebElement nameTextField = driver.findElement(By.cssSelector("[name='name']"));
		nameTextField.sendKeys(firstCourseTitle);     //entering the course name in the parent window Name text field
		
		driver.switchTo().window(newWindowID);
		System.out.println("new window title: "+driver.getTitle());       //prints null since we haven't entered the url
		
		//switching control to parent windpow
		driver.switchTo().window(parentWindowID);     //NOTE: If we haven;t switch the control to parent and try to access the web element in the parent window 
		                                              // then, we will get a "StaleWebElementReferenceExpection "
		
		//taking the ss of the Name textfield to check whether it has entered the correct text
		File webElementSS = nameTextField.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(webElementSS, new File("NameWebelementScreenshot.png"));     //copying the ss of web element 
		
		//getting the height and width of web element
		System.out.println("name textfield height: "+nameTextField.getRect().getDimension().getHeight());
		System.out.println("name textfield width: "+nameTextField.getRect().getDimension().getWidth());
		
		
		driver.quit();    // to close all the opened windows


	}

}
