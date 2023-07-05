package p;

import org.testng.annotations.Test;

public class sdcvv {
  @Test
  public void f() throws InterruptedException {
	  WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/iframe");
Thread.sleep(5000);
  }
}
