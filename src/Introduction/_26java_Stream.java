package Introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v101.log.model.ViolationSetting.Name;
import org.testng.Assert;

public class _26java_Stream {

	public static void main(String args[])
	{
		regular();
	
	}
	
	public static void regular()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("akshay");
		names.add("asushma");
		names.add("laptop");
		names.add("teddy");
		names.add("bluetooth");
		
		//count the num of names starting with "A"
		long count = names.stream().filter(s->s.startsWith("a")).count();
		System.out.println("count: "+count);
		
		Stream.of("akshay","asushma","laptop","teddy").filter(s->
		{
			s.startsWith("a");
			return false;
		}).count();
		System.out.println("count: "+count);
		
		//print all the names starting with "A"
		names.stream().filter(s->s.startsWith("a")).forEach(s->System.out.println("A starts: "+s));
		
		//print names whose lenth=5
		names.stream().filter(s->s.length()==5).forEach(s->System.out.println("5 length: "+s));
		
		//print only 1st name whose lenth is 5
		names.stream().filter(s->s.length()==5).limit(1).forEach(s->System.out.println("1 name length 5: "+s));
		
		//print names ending with y
		names.stream().filter(s->s.endsWith("y")).forEach(s->System.out.println("ends y: "+s));
		
		//print names starting with a to uppercase
		names.stream().filter(s->s.startsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println("A starts upper: "+s));
		
		//print names with frst letter as "a" in upper and sorted
		names.stream().filter(s->s.startsWith("a")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println("A starts upper sorted: "+s));
		
		//print square of nums
		//converting list to arraylist
		List<Integer> nums = Arrays.asList(8,8,6,7);
		nums.stream().map(s->s*s).forEach(s->System.out.println("square: "+s));
		
		//merging 2 diff lists
		Stream<String> mergedStream = Stream.concat(names.stream(), names.stream());
		mergedStream.sorted().forEach(s->System.out.println("merged sorted: "+s));
		boolean matched = names.stream().anyMatch(s->s.equalsIgnoreCase("akshay"));
		System.out.println("matching akshay: "+matched);
		Assert.assertTrue(matched);
		
		//collect function
		List<String> listNames = names.stream().filter(s->s.startsWith("a")).collect(Collectors.toList());
		System.out.println("1st element: "+listNames.get(0));
		
		//print unique vales
		List<Integer> values = Arrays.asList(8,8,6,7,7,1,2);
		values.stream().distinct().forEach(s->System.out.println(s));
		List<Integer> sortedList = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("4th element: "+sortedList.get(3));
		
		
	}
}
