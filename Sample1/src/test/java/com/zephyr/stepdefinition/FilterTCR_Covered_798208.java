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

public class FilterTCR_Covered_798208 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	boolean[] actual=new boolean[10];
	 SoftAssert soft=new SoftAssert();
	 String filename="FilterTCR_Covered_798208";
	@Given("^user in The repository Page$")
	public void user_in_The_repository_Page() throws Throwable 
	{
		try
		{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_4,"Login1",1,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_4,"Login1",1,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		   
		   pp=new ProjectPage(driver);
		  // String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"projects1",1,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
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

	@When("^User selects the exports Test$")
	public void user_selects_the_exports_Test() throws Throwable 
	{
		try
		{
		ep=new ExportPage(driver);
		actual[4]=ep.clickOnNodeExport();
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
	@When("^select required check boxes in select fields$")
	public void select_required_check_boxes_in_select_fields() throws Throwable 
	{
		try
		{
			ep=new ExportPage(driver);
			ep.unselectAllSelectFields();
		
		String[] selectFields=new String[5];
		selectFields[0]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 1,0);
		selectFields[1]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 2,0);
		selectFields[2]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 3,0);
		selectFields[3]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 4,0);
		selectFields[4]=Excel_Lib.getData(INPUT_PATH_4, "selectcheckbox", 5,0);
		actual[5]=ep.selectSelectFields(selectFields);
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

	@When("^Click on coverage and select covered$")
	public void click_on_coverage_and_select_covered() throws Throwable 
	{
		try
		{
		String coverage=Excel_Lib.getData(INPUT_PATH_4, "coverage", 1,0);
		System.out.println(coverage);
		String creation_date=Excel_Lib.getData(INPUT_PATH_4, "creator", 100, 100);
		String[] priority=new String[1];
		priority[0]=Excel_Lib.getData(INPUT_PATH_4, "priority", 100,100);		
		String[] creator=new String[1];
		creator[0]=Excel_Lib.getData(INPUT_PATH_4, "creator", 100,100);
		String M_A=Excel_Lib.getData(INPUT_PATH_4, "creator", 100, 100);
		actual[6]=ep.selectFilterBy(coverage, creation_date, priority, creator, M_A);
		}catch (Exception e) 
		{lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			// TODO: handle exceptione.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
	}
	}

	@When("^Select detailed Report$")
	public void select_detailed_Report() throws Throwable 
	{
		try
		{
		String report_Type=Excel_Lib.getData(INPUT_PATH_4, "reporttype", 2, 0);
		actual[7]=ep.reportType(report_Type);
	   // String outputType=Excel_Lib.getData(INPUT_PATH, "outputtype", 1, 0);
	   // ep.outputType(outputType);
//	    Actions ac=new Actions(driver);
//	    ac.sendKeys(Keys.DOWN).perform();
//	    ac.sendKeys(Keys.DOWN).perform();
//	    ac.sendKeys(Keys.DOWN).perform();
		bp=new BasePage();
	    actual[8]=ep.title(report_Type);
	    bp.waitForElement();
	    actual[9]=ep.saveAndDownload();
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

	@Then("^Should generate coverage Test case report$")
	public void should_generate_coverage_Test_case_report() throws Throwable 
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("filter covered Test Cases Report Exported Successfully");
//		pp=new ProjectPage(driver);
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
