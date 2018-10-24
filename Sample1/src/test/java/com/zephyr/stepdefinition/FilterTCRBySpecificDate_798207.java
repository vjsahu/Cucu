package com.zephyr.stepdefinition;

import org.openqa.selenium.JavascriptExecutor;
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
import cucumber.api.java.en.When;

public class FilterTCRBySpecificDate_798207 extends LaunchBrowser 
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	ExportPage ep;
	boolean[] actual=new boolean[7];
	 SoftAssert soft=new SoftAssert();
	 String filename="FilterTCRBySpecificDate_798207";
	@Given("^user is in the repository page$")
	public void user_is_in_the_repository_page() throws Throwable 
	{
		try
		{
//		lb=new LaunchBrowser();
//		lb.preCond();
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
	   bp=new BasePage();
		bp.waitForElement();
	   actual[1]=pp.selectRelease(releaseName);
	   rp= new ReleasePage(driver);
	   actual[2]=rp.clickOnTestRep();
	   bp.waitForElement();
	   tr=new TestRepositoryPage(driver);
	   actual[3]=tr.doubleClickOnRelease(releaseName);
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
	@When("^user selects the export text Option$")
	public void user_selects_the_export_text_Option() throws Throwable 
	{
		try
		{
		ep=new ExportPage(driver);
		actual[4]=ep.clickOnNodeExport();
		bp=new BasePage();
		bp.waitForElement();
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
	@When("^select the specfic date range$")
	public void select_the_specfic_date_range() throws Throwable 
	{
		try
		{
			String date1=Excel_Lib.getData(INPUT_PATH_4, "startAndEndDate", 1, 0);
			//String date1 ="";
			
			bp.waitForElement();
			ep.startDate1(date1);
			bp.waitForElement();
			
			ep.endDate1();
			bp.waitForElement();
//			Actions act=new Actions(driver);
//			act.sendKeys(Keys.ARROW_DOWN).perform();
//			act.sendKeys(Keys.ARROW_DOWN).perform();
//			act.sendKeys(Keys.ARROW_DOWN).perform();
//			act.sendKeys(Keys.ARROW_DOWN).perform();
//			 ep.dateFieldOption.click();
//			 bp.waitForElement();
//				bp.waitForElement();
////			ep.startDateOption.click();
////			bp.waitForElement();
////			bp.waitForElement();
//			driver.findElement(By.xpath("//*[@id='zui-export-text-filter-dateRange-from']")).sendKeys("09/06/2017");
//			bp.waitForElement();
//			bp.waitForElement();
//			//ep.endDateOption.click();
//			driver.findElement(By.xpath("//*[@id='zui-export-text-filter-dateRange-to']")).sendKeys("10/07/2017");
////		ep=new ExportPage(driver);
////		ep.startDate(10);
//		bp=new BasePage();
//		bp.waitForElement();
//		bp.waitForElement();
//		ep.endDate(16);
//		bp.waitForElement();
//		bp.waitForElement();
//		bp=new BasePage();
//		ep=new ExportPage(driver);
//		ep.CreationDateOption.click();
//		bp.waitForElement();
//		ep.startDate.click();
//		String startDate=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"startAndEndDare",1,0));
//		System.out.println(startDate);
//		ep.startDate(startDate);
//		bp.waitForElement();
//		ep.Enddate.click();
//		String endDate=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"startAndEndDare",1,0));
//		System.out.println(endDate);
//		ep.endDate(endDate);
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

	@When("^Select the detailed report$")
	public void select_the_detailed_report() throws Throwable 
	{
		try
		{
		 String report_Type=Excel_Lib.getData(INPUT_PATH_4, "reporttype", 1, 0);
		 actual[5]=ep.reportType(report_Type); 
		   // String outputType=Excel_Lib.getData(INPUT_PATH, "outputtype", 1, 0);
		   // ep.outputType(outputType);
		 bp=new BasePage();
			bp.waitForElement();
		    Actions ac=new Actions(driver);
		    ac.sendKeys(Keys.DOWN).perform();
		    ac.sendKeys(Keys.DOWN).perform();
		    ac.sendKeys(Keys.DOWN).perform();
		    //ep.title(report_Type);
		    ep=new ExportPage(driver);
		    actual[6]=ep.saveAndDownload();
		    bp=new BasePage();
			bp.waitForElement();
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
	@Then("^should generate the specific date range report$")
	public void should_generate_the_specific_date_range_report() throws Throwable
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();	
	    log.info("should generate the detailed report on specific date range");
//	    pp=new ProjectPage(driver);
//		pp.clickOnLogout();
//		lb=new LaunchBrowser();
//		lb.close();
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
