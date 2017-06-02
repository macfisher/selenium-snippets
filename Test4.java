package archive;

import org.testng.annotations.Test;

@Test(groups = "ThreeAndFour")
public class Test4 extends TestBase {
  
  public void test4() {
	  System.out.println("test4");
	  driver.get("www.opticatech.com");
  }
}
