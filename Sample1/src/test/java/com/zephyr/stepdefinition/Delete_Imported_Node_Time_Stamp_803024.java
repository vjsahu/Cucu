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

public class Delete_Imported_Node_Time_Stamp_803024 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	String fileName="Delete_Imported_Node_Time_Stamp_803024";
	
	boolean[] actual=new boolean[9];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the page of the testRepository page$")
	public void user_is_in_the_page_of_the_testRepository_page() throws Throwable {
		/*lb=new LaunchBrowser();
		   lb.preCond();
		   lp=new LoginPage(driver);
		   //String Uname=Excel_Lib.getData(INPUT_PATH_3,"Login",0,1);
		  String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LUname");
		   //String Pass=Excel_Lib.getData(INPUT_PATH_3,"Login",1,1);
		  String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LPass");
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();*/
		   try
		   {
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]= rp.clickOnTestRep(); 
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

	@Given("^User navigates to the release node$")
	public void user_navigates_to_the_release_node() throws Throwable {
		 try
		    {
			tr=new TestRepositoryPage(driver);
			 String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
			 actual[3]= tr.doubleClickOnRelease(releaseName);
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

	@When("^User clicks on the Import icon$")
	public void user_clicks_on_the_Import_icon() throws Throwable {
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

	@When("^User creates an Map$")
	public void user_creates_an_Map() throws Throwable {
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
		
		String jobname=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 0);
	   String mapName=Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 1);
	   String path=Excel_Lib.getData(INPUT_PATH_3, "Import", 2, 2);
	  actual[5]= ip.importTestCase(jobname, mapName, path);
	   bp.waitForElement();
	   bp.waitForElement();
	   bp.waitForElement();
	   bp.waitForElement();
	   bp.waitForElement();
	   bp.waitForElement();
	   bp.waitForElement();
	  actual[6]=ip.runJob();
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

	@When("^User moves to the Imported node$")
	public void user_moves_to_the_Imported_node() throws Throwable {
		try
		 {
			bp.waitForElement();
			ip.ClickOKonStatusReport();
			String fileName=Excel_Lib.getData(INPUT_PATH_3,"Import",1,3);
			String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
			bp.waitForElement();
			actual[7]=ip.validateImport(fileName, releaseName);
		    log.info("Pass - Import Job Run Successfully");
		    bp.waitForElement();
			ip.selectImportFile1(fileName);
			bp.waitForElement();
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

	@Then("^User deletes the imported node with time stamp under Imported node$")
	public void user_deletes_the_imported_node_with_time_stamp_under_Imported_node() throws Throwable {
	   try
	   {
		  // bp=new BasePage();
		//bp.waitForElement();
		  // bp.waitForElement();
		   //bp.waitForElement();
		   bp.waitForElement();
		actual[8]=tr.deleteImportedNode();
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

	@Then("^User successfully deletes the imported node with time stamp$")
	public void user_successfully_deletes_the_imported_node_with_time_stamp() throws Throwable {
	    
		try
		{
			
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		     
		log.info("User successfully deletes the imported node with time stamp");
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
