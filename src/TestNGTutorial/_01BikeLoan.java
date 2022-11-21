package TestNGTutorial;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _01BikeLoan {
	
	@Parameters({"url"})                //using parameters annotaion in order to use the parameters defined in the xml 
	                                  //using enabled we can exclude this particular test in the execution flow eg:if it has any known defect
	@Test(groups= {"Smoke"})        //using "groups" to execute particular set of TCs
	public void bikeWebLogin(String urlname)            //collecting the parameter fetched from xml
	{
		System.out.println("bikeWebLogin");
		System.out.println(urlname);                //printing the fetched parameter
	}
	
	@Test(enabled=false)                
	public void bikeMobileLogin()      
	{
		System.out.println("bikeMobileLogin");
	}
	
	@BeforeTest
	public void bt()
	{
		System.out.println("before test");
		
	}
	
	@AfterTest
	public void at()
	{
		System.out.println("after test");
	}

}
