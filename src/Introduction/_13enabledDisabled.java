package Introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class _13enabledDisabled {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);
		/*System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		*/
		/* isEnabled() method is not working as expected, since the selenium ppl has desinged in the way like if we click on any 
		 * disabled elements there shoudl be no avction observed. BUt in the recent ui, the dev are desinged the disabled element in the way like
		 * if the user tries to click on the disaabled elements, the disabled element will change as enabled on clicking on the element.
		 * So, the Selenium gets confused to say whether the elelmnet is enabled or disabled.
		 * and therefore, will get the result as true for both the statements even if the element is in disabled state.
		 * 
		 * In order to handle this we can use the attribute in the same element which will be different on enabling or disabling state
		 * So we need to identify the attribute of the elememt which is different for both the operation and then compare from that.
		 * Which can be achibed by the following way.
		 */
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) //passing "1" bcz style attribute contains 1 if calander is enabled 
		{
			System.out.println("is Enabled");
			Assert.assertTrue(true); 
			/*passing true bcz, on clicking the Round Trip radio button, the calendar will be in enaled state
			 * and the style val;ue will contains "1" i,e if the condition is satisfied and it comes inside the if condition,
			 * then will be true anyways
			 * 
			 */
		}
		else
		{
			Assert.assertTrue(false);
			//passing false bcz, the control comes to else block only if the calander is not anabled 
			 
		}
		
		driver.close();

	}

}
