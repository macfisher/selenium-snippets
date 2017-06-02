package archive;

import org.testng.annotations.Test;

@Test(groups = "ThreeAndFour")
public class Test3 extends TestBase {
  
  public void test3() {
	  System.out.println("test3");
	  driver.get("www.stackoverflow.com");
  }
}
