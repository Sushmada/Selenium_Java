package Introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _22handlingSslCertsUsingChromeOptions {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		
		//instead of doing manually like acceptancing the insecure certifications, 
		//we can use ChromeOptions method which is a method in ChromeDriver
		//ChromeOptions method will tell the browser how to behave
		//setAcceptInsecureCerts is the method to accept the insecure certs
		//value set to true which means telling the browser to accept the cert
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		/*
		 * for Firefox browser
		 * FirefoxOptions options1 = new FirefoxOptions();
		 * options1.setAcceptInsecureCerts(true);
		 */
		
		/*
		 * for Edge browser
		 * EdgeOptions options2 = new EdgeOptions();
		 * options2.setAcceptInsecureCerts(true);
		 */
		
		//after creating object of ChromeOptions method, the reference variable shd be passed as an argument to the 
		//ChromeDriver object so that the browser will get to know about how to h=behave
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		//if we donot use ChromeOptions, then wrong title will be printed in the console

	}

}
