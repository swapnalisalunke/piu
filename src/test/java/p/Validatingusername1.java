package p;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import p1.Base;
import p2.Loginpage;
import p2.Myaccountpage;
import p3.Utility;

public class Validatingusername1 extends Base  {
	Loginpage login;
	Myaccountpage myAcc;
	String TCID="PB_TC_1234";

	@BeforeClass
	public void launchPolicyBazaar() throws InterruptedException, IOException
	{
	Utility.wait(300);
	launchBrowserUsingPropertyFile();
	login= new Loginpage(driver);
	myAcc= new Myaccountpage(driver);
	}
	
	@BeforeMethod
	public void signInToPolicyBazaar() throws InterruptedException,EncryptedDocumentException, IOException
	{
	Utility.wait(1000);
	login.clickOnHomePageSignInButton();
	Utility.wait(1000);
	login.enterMobileNum(Utility. readdatafromproperties("mobNum"));
	Utility.wait(1000);
	login.clickOnSignInWithPassword();
	Utility.wait(1000);
	login.enterPassword(Utility. readdatafromproperties("pwd"));
	Utility.wait(1000);
	login.clickOnSignInButton();
	Utility.wait(1000);
	login.clickOnMyAccountButton();
	Utility.wait(1000);
	login.clickOnMyProfileButton();
	Utility.wait(1000);
	Set<String> allPageID = driver.getWindowHandles();
	List<String>l= new ArrayList<String>(allPageID);
	String mainPageID = l.get(0);
	String childPageID = l.get(1);
	driver.switchTo().window(childPageID);
	Reporter.log("switching to child page", true);
	Utility.wait(200);
	}

	@Test
	public void validateUserName() throws EncryptedDocumentException, IOException,InterruptedException
	{

	Utility.wait(4000);
	String actualUN = myAcc.getActualUserName();
	String expUN =  Utility.readdatafromproperties("UN");
	Assert.assertEquals(actualUN,expUN,"TC is failed actual and expected are not matching");

	Utility.takeScreenShot(driver, actualUN+" "+TCID);

	}
	@AfterMethod
	public void logoutFromPolicyBazaar() throws InterruptedException
	{
	myAcc.clickOnLogOutButton();
	}
	@AfterClass
    public void closePoilicyBazaar() throws InterruptedException
	{
	closeBrowser();
	}
}