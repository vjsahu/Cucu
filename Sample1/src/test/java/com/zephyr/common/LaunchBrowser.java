package com.zephyr.common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.ProjectPage;






public class LaunchBrowser implements AutomationConstants
{
 public static WebDriver driver;
public static long timeout;

ProjectPage pp;


public Logger log;

public LaunchBrowser()
{
  log=Logger.getLogger(this.getClass());
  Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
  BasicConfigurator.configure();
}



 public boolean preCond() throws Exception
  {
	 try
	 {
	log.info("Initialising Framework");
	String browserType=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Browser");
	//String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"URL");
	timeout=Long.parseLong((Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"IMPLICIT")));
	
	
	log.info("Browser:"+browserType);
	if(browserType.equalsIgnoreCase("chromeBrowser"))
	{
		
		System.setProperty(CHROME_KEY,DRIVER_PATH+CHROME_FILE);
		ChromeOptions option = new ChromeOptions();
		//option.setBinary("C:\\Users\\Uday\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
		option.addArguments("disable-infobars");
		driver = new ChromeDriver(option);
		
	}
	else if(browserType.equalsIgnoreCase("ieBrowser"))
	{
		
//		 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//		  
//		 capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
//		 capabilities.setCapability(InternetExplorerDriver.
//		   INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		System.setProperty(IE_KEY,DRIVER_PATH+IE_FILE);
		driver=new InternetExplorerDriver();
		
	}
	else
	{
		System.setProperty(GECKO_KEY,DRIVER_PATH+GECKO_FILE);
		driver=new FirefoxDriver();
	}

    driver.manage().window().maximize();
    log.info("TimeOut:"+timeout);
     
    driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
  

    return true;
	 }
	 catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
    

}
 
 public void getUrl(String url)
 {
	 driver.get(url);
	 
 }
 
 

 public void getScreenShot(String fileName) throws IOException
 {
     DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
     Date date = new Date();
     File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     try
     {
    	 FileUtils.copyFile(scrFile, new File("./Screenshot/"+fileName+"-"+dateFormat.format(date)+".png"));
     } 
 	catch (IOException e)
 	 {
 	  System.out.println(e.getMessage()) ;
 	 }
 }
  public void close()
{
  log.info("Finalising Frmework");
	driver.quit();
}

}