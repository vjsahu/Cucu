package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Delete_Multi_Selected_TestCases_Import_Node_803041 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	String fileName="Delete_Multi_Selected_TestCases_Import_Node_803041";
	
	boolean[] actual=new boolean[6];
	SoftAssert soft=new SoftAssert();
	@Given("^User is in the Test Repository page$")
	public void user_is_in_the_Test_Repository_page() throws Throwable {
	    
		/*lb=new LaunchBrowser();
		   lb.preCond();
		   lp=new LoginPage(driver);
		   String Uname=Excel_Lib.getData(INPUT_PATH_3,"Login",0,1);
		   String Pass=Excel_Lib.getData(INPUT_PATH_3,"Login",1,1);
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();*/
		   try
		   {
		   bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep(); 
		   bp.waitForElement();
		   }
		   catch(Exception e)
			{
				
			   lb=new LaunchBrowser();
				lb.getScreenShot(fileName);	
			   e.printStackTrace();
			   driver.close();
		      	Relogin rl=new Relogin();
		      	rl.reLogin();
		      	throw e;
		   	 
			}
	}

	@Given("^User move to the Release node$")
	public void user_move_to_the_Release_node() throws Throwable {
	   try
	   {
		tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		 actual[3]= tr.doubleClickOnRelease(releaseName);
		 bp.waitForElement();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
		   e.printStackTrace();
		   driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^User clicks on Import icon$")
	public void user_clicks_on_Import_icon() throws Throwable {
	   try
	   {
		ip= new ImportPage(driver);
		 bp=new BasePage();
		 actual[4]=ip.clickOnImport();
		 bp.waitForElement();
		//ip.nextForImport.click();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
		   e.printStackTrace();
		   driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^User creates a Map with a new job$")
	public void user_creates_a_Map_with_a_new_job() throws Throwable {
	    
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		String mapname=Excel_Lib.getData(INPUT_PATH_3, "Import", 13, 0);
		int rownum=Excel_Lib.getNumberData(INPUT_PATH_3, "Import", 13, 1);
		String descrimi=Excel_Lib.getData(INPUT_PATH_3, "Import", 13, 2);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "Import", 13, 3);
		String name=Excel_Lib.getData(INPUT_PATH_3, "Import", 13, 4);
		String testSteps=Excel_Lib.getData(INPUT_PATH_3, "Import", 13, 5);
		String expResults=Excel_Lib.getData(INPUT_PATH_3, "Import", 13, 6);
		String extrID=Excel_Lib.getData(INPUT_PATH_3, "Import", 13, 7);
		ImportPage ip= new ImportPage(driver);
		ip.createMap(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
	    bp.waitForElement();
	    //ip.closeInstruction.click();
	    //bp.waitForElement();
	    //ip.nextForImport.click();
	    
		String jobname=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 0);
	   String mapName=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 1);
	   String path=Excel_Lib.getData(INPUT_PATH_3, "Import", 2, 2);
	   bp=new BasePage();
	   bp.waitForElement();
	    ip.importTestCase(jobname, mapName, path);
	   bp.waitForElement();
	   bp.waitForElement();
	   bp.waitForElement();
	   bp.waitForElement();
	   bp.waitForElement();
	   bp.waitForElement();
	   ip.runJob();
	   
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	
	@Then("^User selects import node that he wants to import test cases$")
	public void user_selects_import_node_that_he_wants_to_import_test_cases() throws Throwable {
	 try
	 {
		 //ip=new ImportPage(driver);
		bp=new BasePage();
		bp.waitForElement();
		bp.waitForElement();
		ip.ClickOKonStatusReport();
		String fileName=Excel_Lib.getData(INPUT_PATH_3,"Import",1,3);
		String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		ip.validateImport(fileName, releaseName);
		bp.waitForElement();
		ip.selectImportFile1(fileName);
		bp.waitForElement();
		tr.addTestCase();
		tr.addTestCase();
		
	    log.info("Pass - Import Job Run Successfully");
	 }
	 catch(Exception e)
		{
		 lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
		 e.printStackTrace();	
		 driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	
	@Then("^User selects the multiple test cases$")
	public void user_selects_the_multiple_test_cases() throws Throwable {
		try
		{
       bp=new BasePage();
		bp.waitForElement();
		String[] testCaseNo=new String[2];
	    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
	    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
	    //testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
	    tr.verifyPastTestCase();
	    bp.waitForElement();
		ep=new ExportPage(driver);
		actual[5]= ep.selectMultipleTestCaseFromGrid(testCaseNo);
		tr.verifyPastTestCase();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		//TestRepositoryPage_POM tp=new TestRepositoryPage_POM(driver);
	    tr.deleteTestCase();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}



	@Then("^User deletes selected test cases$")
	public void user_deletes_selected_test_cases() throws Throwable {
	   try
	   {
	  // bp.waitForElement();
	   //bp.waitForElement();
	   //bp.waitForElement();
		//tr.deleteTestCaseMsg.click();
		bp.waitForElement();
		tr.verifyPresentTestCase();
		
		for(int k=0;k<=actual.length-1;k++)
	     {
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
		log.info("User successfully deleted test cases ");
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
		   e.printStackTrace();
		   driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
		
	}

}
