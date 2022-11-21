package Introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;


public class _29RelativeLocators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//to find the label of the element which is present above the name textfield
		WebElement nameWebelement = driver.findElement(By.cssSelector("[name='name']"));
		System.out.println("label of name: "+driver.findElement(with(By.tagName("label")).above(nameWebelement)).getText());
		
		//to find the element below the given webelement
		//the below web element is DOB but it won't identify that web element since it is "flex" web element and hence identifes the next below element i,e submit button
		WebElement submitWebelement = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(submitWebelement)).click();
		//validating if the submit button is clicked
		System.out.println("success msg: "+driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
		
		//to check the checkbox which is left of the given web element with text
		WebElement checkbox = driver.findElement(By.cssSelector("[class='form-check-label']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkbox)).click();
		
		//to get the text present to the right of the given web element which is radio button
		WebElement radioText = driver.findElement(By.id("inlineRadio2"));
		System.out.println("radio button text: "+driver.findElement(with(By.tagName("label")).toRightOf(radioText)).getText());
		
		driver.close();

	}

}
