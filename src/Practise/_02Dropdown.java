package Practise;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class _02Dropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		System.out.println(driver.getTitle());
		driver.findElement(By.id("autosuggest")).sendKeys("bu");
		Thread.sleep(3000);
		List<WebElement> suggestions = driver.findElements(By.cssSelector(".ui-menu-item"));
		for(WebElement s:suggestions)
		{
			if(s.getText().equals("Bulgaria"))
			{
				s.click();
				break;
			}
	
		}
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.id("autosuggest")).getText());
		
		System.out.println("onway: "+driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected());
		
		String retDate = driver.findElement(By.id("ctl00_mainContent_view_date2")).getAttribute("class");
		
		if(retDate.contains("valid"))
			System.out.println("Return date enabled");
		else
			System.out.println("Return date disabled");
		
//		<input name="ctl00$mainContent$view_date2" type="text" readonly="readonly" id="ctl00_mainContent_view_date2" class="custom_date_pic required home-date-pick valid">
//		<input name="ctl00$mainContent$view_date2" type="text" readonly="readonly" id="ctl00_mainContent_view_date2" class="custom_date_pic required home-date-pick">
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[value='ATQ']")).click();
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='STV']")).click();
		
		driver.findElement(By.cssSelector(".ui-datepicker-today")).click();
		
		driver.findElement(By.id("divpaxinfo")).click();
		for(int i=0; i<6; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		Select s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		s.selectByVisibleText("AED");
		
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		
		driver.close();
		
	}

}
