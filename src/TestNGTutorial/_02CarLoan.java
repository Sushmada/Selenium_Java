package TestNGTutorial;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _02CarLoan {
	
	@Test(groups= {"Smoke"})                   //using "groups" to execute particular set of TCs
	public void carLoanWebLogin()
	{
		System.out.println("carLoanWebLogin");
		Assert.assertTrue(false);               //just to fail the test by putting assertion
	}
	
	@Test(dependsOnMethods= {"carLoanWebLogin"})           //generally TestNG executes the Tests in alphabetical order. If we want any method to execute frst irrespective of the alphabetical order
	public void carLoanMobileLogin()                       //then, we can use "dependsOnMethods" so that the current test will execute only after executing the method defined inside(multiple methods can be defined)
	{                                                      
		System.out.println("carLoanMobileLogin");           //this test will get skipped since we have failed carWebLogin test and this test is dependent on that
	}
	
	@BeforeSuite
	public void bs()
	{
		System.out.println("before suite");
	}
	
	@Parameters({"url", "username"})           //using multiple parameters
	@AfterSuite
	public void as(String uname, String usn)
	{
		System.out.println("after suite");
		System.out.println(uname);
		System.out.println(usn);
	}
	
	

}
