package p1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import p3.Utility;

public class Base {
	protected WebDriver driver;
	public void launchBrowser()
	{
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.policybazaar.com/");
	Reporter.log("Launching browser", true);
	}
	public void launchBrowserUsingPropertyFile() throws IOException
	{
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(Utility. readdatafromproperties("url"));
	Reporter.log("Launching browser", true);
	}
	public void closeBrowser() throws InterruptedException
	{
	Utility.wait(2000);
	Reporter.log("Closing Browser", true);
	driver.quit();
  }
}
