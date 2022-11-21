package Introduction;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _24finding_BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//inorder to find the broken links(links for which page is not loading or throwing some error) we can check the status code
		// status code can be seen in the Network section in the Dev tools(inspect) on tapping the links
		//how to achieve??
		//frst we will get the href of the link(url) by using getAttribute()
		//using java method we will get the status code(openConnection)
		//if the status code is 200(link is not broken)
		//if the status code is >400 i,e 401, 404 (the links are broken)
		
		//getting the attritube of href i,e the url of the link using getAttribute
		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		//openConnection() is the method to make connections with the url which comes from the URL class
		// so by creating object of the URL class and passing the url string as an argument we are accessing the openConnection()
		// the return type is HttpURLConnection which is typecasted
		// we are setting requestmethod by HEAD
		//making connection by usinng connect()
		// using getResponse(), we are getting the status code which is integer
		//finally we are printing the status code in the console
		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int resCode = conn.getResponseCode();
		System.out.println(resCode);

	}

}
