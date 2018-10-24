package com.zephyr.stepdefinition;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class FilterTCR_StartDate_798223 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	boolean[] actual=new boolean[7];
	 SoftAssert soft=new SoftAssert();
	 String filename="FilterTCR_StartDate_798223";
@Given("^User opens the repository page$")
public void user_opens_the_repository_page() throws Throwable
{
	try
	{
//		lb=new LaunchBrowser();
//		lb.preCond();
//	   
//	   lp=new LoginPage(driver);
//	   String Uname=Excel_Lib.getData(INPUT_PATH_4,"Login1",1,0);
//	   String Pass=Excel_Lib.getData(INPUT_PATH_4,"Login1",1,1);
//	   lp.enterUname(Uname);
//	   lp.enterPass(Pass);
//	   lp.clickOnLogin();
	   
	   pp=new ProjectPage(driver);
	  // String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,0);
	   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
	   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"projects1",1,1);
	   actual[0]=pp.selectProject(projectName);
	   actual[1]=pp.selectRelease(releaseName);
	   bp=new BasePage();
	   rp= new ReleasePage(driver);
	   actual[2]=rp.clickOnTestRep();
	   bp.waitForElement();
	   tr=new TestRepositoryPage(driver);
	   actual[3]=tr.doubleClickOnRelease(releaseName);
	}catch (Exception e) 
	{lb=new LaunchBrowser();
	   lb.getScreenShot(filename);
		e.printStackTrace();
	    driver.close();
	    Relogin rl=new Relogin();
	    rl.reLogin();
	    throw e;
	}
}

@Then("^select the export test in repository page$")
public void select_the_export_test_in_repository_page() throws Throwable 
{
	try
	{
		ep=new ExportPage(driver);
		actual[4]=ep.clickOnNodeExport();
		bp.waitForElement();
	   
//		ep.unselectallSelectFields();
//		
//		String[] selectFields=new String[6];
//		selectFields[0]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 1,0);
//		selectFields[1]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 2,0);
//		selectFields[2]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 3,0);
//		selectFields[3]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 4,0);
//		selectFields[4]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 5,0);
//		selectFields[5]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 6,0);
//		ep.selectSelectFields(selectFields);
	}catch (Exception e)
	{lb=new LaunchBrowser();
	   lb.getScreenShot(filename);
		e.printStackTrace();
	    driver.close();
	    Relogin rl=new Relogin();
	    rl.reLogin();
	    throw e;
	}
//	
}

@Then("^Select the Start date$")
public void select_the_Start_date() throws Throwable 
{
	try
	{
		String date1=Excel_Lib.getData(INPUT_PATH_4, "startAndEndDate", 1, 0);
		
		ep.startDate1(date1);
		//String startDate="0"+date1;
		bp.waitForElement();
//		ep.dateFieldOption.click();
//		 bp.waitForElement();
//			bp.waitForElement();
//		driver.findElement(By.xpath("//*[@id='zui-export-text-filter-dateRange-from']")).sendKeys("06/10/2017");
//    //ep.startDate(10);
    bp.waitForElement();
	}catch (Exception e) 
	{lb=new LaunchBrowser();
	   lb.getScreenShot(filename);
		e.printStackTrace();
	    driver.close();
	    Relogin rl=new Relogin();
	    rl.reLogin();
	    throw e;
	}
    
}

@Then("^select the detailed Report$")
public void select_the_detailed_Report() throws Throwable 
{
	try
	{
	String report_Type=Excel_Lib.getData(INPUT_PATH_4, "reporttype", 2, 0);
	actual[5]=ep.reportType(report_Type);
	bp.waitForElement();
	bp.waitForElement();
   // String outputType=Excel_Lib.getData(INPUT_PATH, "outputtype", 1, 0);
    
   // ep.outputType(outputType);
    
    Actions ac=new Actions(driver);
    ac.sendKeys(Keys.DOWN).perform();
    ac.sendKeys(Keys.DOWN).perform();
    ac.sendKeys(Keys.DOWN).perform();
    bp.waitForElement();
    //ep.title(report_Type);
    bp.waitForElement();
    actual[6]=ep.saveAndDownload();
    bp.waitForElement();
	}catch (Exception e) 
	{lb=new LaunchBrowser();
	   lb.getScreenShot(filename);
		e.printStackTrace();
	    driver.close();
	    Relogin rl=new Relogin();
	    rl.reLogin();
	    throw e;
	}
}

@Then("^should generate detailed filter testcase report$")
public void should_generate_detailed_filter_testcase_report() throws Throwable 
{
	try
	{
		for(int k=0;k<=actual.length-1;k++)
	     {
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
    log.info("should generate detailed Filter by just creation start date with coverage");
//    pp=new ProjectPage(driver);
//	pp.clickOnLogout();
//	lb=new LaunchBrowser();
//	lb.close();
	}catch (Exception e) 
	{lb=new LaunchBrowser();
	   lb.getScreenShot(filename);
		e.printStackTrace();
	    driver.close();
	    Relogin rl=new Relogin();
	    rl.reLogin();
	    throw e;
	}
}

}
