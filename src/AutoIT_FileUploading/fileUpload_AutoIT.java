package AutoIT_FileUploading;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class fileUpload_AutoIT {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String downloadPath = System.getProperty("user.dir");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile_default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.id("pickfiles")).click();
		
		//java class to execute .exe files
		//Runtime.getRuntime().exec("C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\fileUpload.exe");
		
		driver.findElement(By.id("processTask")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(5000);
		
		File f = new File(downloadPath+"/Udemy Selenium Certificate_page-0001.jpg");
		if(f.exists())
		{
			Assert.assertTrue(f.exists());
			
			if(f.delete())
				System.out.println("file deleted successfully");
		}
	}

}
