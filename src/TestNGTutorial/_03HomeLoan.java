package TestNGTutorial;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _03HomeLoan {
	
	
	@Parameters({"testurl", "usernameTestLevel"})        //using multiple parameters           
	@Test(dataProvider="getData")                       //using "dataProvider" and passing the method name, we can achive dataProvider i.e, multiple sets of data can be passed to a single test
	public void homeLoanWebLogin(String turl, String usnT)    //the test runs 3 tyms with each set of data defined in the getData method
	{
		System.out.println("homeLoanWebLogin");
		System.out.println(turl);
		System.out.println(usnT);
	}
	
	@Test(timeOut=5000)                            //if the particular test will take more time to execute, then we can explicitly define the timeout only to that particular test
	public void homeLoanMobileLogin()              // so that the test will not fail below the specified time.
	{
		System.out.println("homeLoanMobileLogin");
	}
	
	@BeforeMethod
	public void bm()
	{
		System.out.println("before method");
	}
	
	@AfterMethod
	public void am()
	{
		System.out.println("after method");
	}
	
	@DataProvider                //@DataProvider annotation used to pass multiple sets of data to the single test
	public Object[][] getData()
	{
		//creating multi dimensional object and passing 3 and 2 since req is to test 3 sets of data with 2 arguments each
		Object[][] data= new Object[3][2];
		
		//1st set 
		data[0][0]= "Bujji1";
		data[0][1]="123";
		
		//2nd set
		data[1][0]="Bujjji2";
		data[1][1]="456";
		
		//3rd set
		data[2][0]="Bujji3";
		data[2][1]="789";
		
		return data;
	}

}
