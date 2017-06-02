package archive;

import org.testng.annotations.Test;

public class Test2 extends TestBase
{
  @Test
  public void f() {
	  System.out.println("Inside f method");
	  driver.get("www.reddit.com");
  }
  
  @Test
  public void g() {
	  System.out.println("Inside g method");
	  driver.get("www.gmail.com");
  }
}