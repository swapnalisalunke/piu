package p3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {
	//commonly used method
	//screenShot
	//scrolling
	//data reading
	//wait

	public static void takeScreenShot(WebDriver driver,String fileName) throws
	IOException
	{
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest= new File("C:\\Users\\hp\\git\\repository\\piu\\screenshot"+fileName+".png");
	FileHandler.copy(src, dest);
	Reporter.log("taking screenshot", true);
	Reporter.log("screenShot location is ... "+dest, true);

	}
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",

	element);

	Reporter.log("scrollingIntoView", true);
	}
	public static String readDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException
	{
	FileInputStream myFile= new FileInputStream("C:\\Users\\hp\\OneDrive\\Documents\\Book1.xlsx");

	Reporter.log("Reading data from excel row num "+row+" cell num is "+cell, true);
	String value =WorkbookFactory.create(myFile).getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();

	return value;	
	}
	public static void wait(int waitTime) throws InterruptedException
	{
	Reporter.log("waiting for "+waitTime+" milli sec", true);
	Thread.sleep(waitTime);
	}

	public static String  readdatafromproperties(String key) throws IOException
	{
	Properties prop= new Properties();
	FileInputStream myFile= new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\rushi\\myproperty.properties");

	prop.load(myFile);
	String value = prop.getProperty(key);
	Reporter.log("readind data "+key+" from propertyFile", true);
	return value;
	}
	public static String readdatafromproperties1(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	}
