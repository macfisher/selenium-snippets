package archive;

import org.testng.annotations.Test;

@Test(groups = "TestOneAndTwo")
public class Test2 extends TestBase
{
	public void f() {
		System.out.println("Inside f method");
		driver.get("www.reddit.com");
	}
  
  
	public void g() {
		System.out.println("Inside g method");
		driver.get("www.gmail.com");
	}
}