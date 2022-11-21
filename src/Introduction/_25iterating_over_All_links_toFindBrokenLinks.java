package Introduction;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class _25iterating_over_All_links_toFindBrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		//Soft Assert
		SoftAssert soft = new SoftAssert();
		
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int resCode = conn.getResponseCode();
			System.out.println(resCode);
			/*
			if(resCode>400)
			{
				System.out.println("The broken link is with the text \"+link.getText()+\" is BROKEN with \"+resCode+\" Status Code");
				Assert.assertTrue(false);// Hard assert
			}
			*/
			//Hard Assert (instead of If block we use the below line of code
			// Disadvantage: as soon as any link is broken, the execution will stop at that point & remaining links are not checked
//			Assert.assertTrue(resCode<400, "The broken link is with the text "+link.getText()+" is BROKEN with "+resCode+" Status Code");
			
			//Soft Assert
			// INitially object is created and reference variable is useed with the assert statement
			// and finally assertAll() methoad shd be called in order to print the stored assert values in the console
			soft.assertTrue(resCode<400, "The broken link is with the text "+link.getText()+" is BROKEN with "+resCode+" Status Code");
			
			
		}
		//by using above line of code, the assert values will only be stored
		//in order to print the assert values, we need to compulsorily call assertAll() method
		soft.assertAll();

	}

}
