package com.zephyr.stepdefinition;

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

public class Filter_798267 extends LaunchBrowser
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
	 String filename="Filter_798267";
	@Given("^user in repository$")
	public void user_in_repository() throws Throwable 
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
		   bp.waitForElement();
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
			bp.waitForElement();
		   tr=new TestRepositoryPage(driver);
		   actual[3]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
		}catch (Exception e) 
		{
			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@Given("^select the export test$")
	public void select_the_export_test() throws Throwable 
	{
		try
		{
			
			ep=new ExportPage(driver);
			actual[4]=ep.clickOnNodeExport();
			bp=new BasePage();
			bp.waitForElement();
		}catch (Exception e) 
		{
			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^select the required check box$")
	public void select_the_required_check_box() throws Throwable 
	{
		try
		{
			ep.unselectAllSelectFields();
			bp=new BasePage();
			bp.waitForElement();
			String[] selectFields=new String[6];
			selectFields[0]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 1,0);
			selectFields[1]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 2,0);
			selectFields[2]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 3,0);
			selectFields[3]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 4,0);
			selectFields[4]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 5,0);
			selectFields[5]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 6,0);
			actual[5]=ep.selectSelectFields(selectFields);
			bp.waitForElement();
		}catch (Exception e) 
		{
			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		} 
	}

	@When("^select the date range$")
	public void select_the_date_range() throws Throwable 
	{
		try
		{
			String date1=Excel_Lib.getData(INPUT_PATH_4, "startAndEndDate", 1, 0);
			ep.startDate1(date1);
			bp.waitForElement();
			ep.endDate1();
			bp.waitForElement();
//			 bp.waitForElement();
//				bp.waitForElement();
////			ep.startDateOption.click();
////			bp.waitForElement();
////			bp.waitForElement();
//			driver.findElement(By.xpath("//*[@id='zui-export-text-filter-dateRange-from']")).sendKeys("09/06/2017");
//			bp.waitForElement();
//			bp.waitForElement();
//			//ep.endDateOption.click();
//			driver.findElement(By.xpath("//*[@id='zui-export-text-filter-dateRange-to']")).sendKeys("09/12/2017");
//			
//			ep=new ExportPage(driver);
//			ep.startDate(10);
//			bp=new BasePage();
//			bp.waitForElement();
//			ep.endDate(16);
//			bp.waitForElement();
	   
		}catch (Exception e) 
		{
			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^select the priority and creator$")
	public void select_the_priority_and_creator() throws Throwable 
	{
		try
		{
			String coverage=Excel_Lib.getData(INPUT_PATH_4, "coverage", 100,100);
			String creation_date=Excel_Lib.getData(INPUT_PATH_4, "creator", 100, 100);
			String[] priority=new String[1];
			priority[0]=Excel_Lib.getData(INPUT_PATH_4, "priority", 1,0);
			String[] creator=new String[1];
			creator[0]=Excel_Lib.getData(INPUT_PATH_4, "creator", 2,0);		
			String M_A=Excel_Lib.getData(INPUT_PATH_4, "creator", 100,1000);
		    ep.selectFilterBy(coverage, creation_date, priority, creator, M_A);  
		    bp=new BasePage();
			bp.waitForElement();
		    //String report_Type=Excel_Lib.getData(INPUT_PATH_4, "reporttype", 1, 0);
		   // actual[6]=ep.reportType(report_Type);
	   
		}catch (Exception e) 
		{
			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@Then("^should generate the sumary report$")
	public void should_generate_the_sumary_report() throws Throwable 
	{
		try
		{
	//			 String outputType=Excel_Lib.getData(INPUT_PATH_4, "outputtype", 1, 0);
	//			   ep.outputType(outputType);
	////			    Actions ac=new Actions(driver);
	////			    ac.sendKeys(Keys.DOWN).perform();
	////			    ac.sendKeys(Keys.DOWN).perform();
	////			    ac.sendKeys(Keys.DOWN).perform();
	//			    //ep.title(report_Type);
				ep=new ExportPage(driver);
			    actual[6]=ep.saveAndDownload();
				    bp.waitForElement();
				    bp.waitForElement();
				for(int k=0;k<=actual.length-1;k++)
			     {
			      soft.assertEquals(actual[k], true);
			     }
			     soft.assertAll();
			log.info("should generate summary Filter Test case Report");
	//		pp=new ProjectPage(driver);
	//		pp.clickOnLogout();
	//		lb=new LaunchBrowser();
	//		lb.close();
		}catch (Exception e) 
		{
			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	
	}
}
