package com.zephyr.stepdefinition;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Release_Creation extends LaunchBrowser{
	
	LaunchBrowser lb;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	LoginPage lp;
	String fileName="Release_Creation";
	@Given("^User select the project(\\d+)$")
	public void user_select_the_project(int arg1) throws Throwable {
	   try
	   {
		   bp=new BasePage();
		   if(arg1==1)
		   {   
			  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
			  pp=new ProjectPage(driver);
			  pp.clickOnLogout();
			  lp=new LoginPage(driver);
			  String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Username_1");
			  String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Password_1");
			  lp.enterUnameAndPassword(userName, passWord);
			   pp.selectProject(projectName);
		   }
		   else if(arg1==2)
		   {
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_2");
			   pp=new ProjectPage(driver);
			   pp.selectProject(projectName);
			   
		   }
		   else if(arg1==3)
		   {
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Restricted_Project_1");
			   pp=new ProjectPage(driver);
			   pp.selectProject(projectName); 
		   }
		   else if(arg1==4)
		   {
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Restricted_Project_2");
			   pp=new ProjectPage(driver);
			   pp.selectProject(projectName); 
		   }
		   else if(arg1==5)
		   {
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Isolated_Project_1");
			   pp=new ProjectPage(driver);
			   pp.selectProject(projectName); 
		   }
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

	@When("^User create a release for all the projects$")
	public void user_create_a_release_for_all_the_projects() throws Throwable {
	    try
	    {
	    	rp=new ReleasePage(driver);
	    	//tp=new TestPlanningPage(driver);
	    	bp.waitForElement();
	    	rp.clickOnManageRelease();
			bp.waitForElement();
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Release_2");
			boolean res=rp.checkAvailableRelease(releaseName);
			if(res==false)
			{
	    	//String releaseName=Excel_Lib.getData(INPUT_PATH, "Releases", 2,0);
			String Hide=Excel_Lib.getData(INPUT_PATH, "Requirements", 100,100);
	    	String Desc=Excel_Lib.getData(INPUT_PATH, "Requirements", 100,100);
			String MapexternalDefect=Excel_Lib.getData(INPUT_PATH, "Requirements", 100,100);
	    	rp.addNewRelease(releaseName, Desc, Hide, MapexternalDefect);
	    	String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Projects", 0, 2));
			String smonth=Excel_Lib.getData(INPUT_PATH, "Projects", 0, 3);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Projects", 0, 4));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Projects", 0, 5));
			String emonth=Excel_Lib.getData(INPUT_PATH, "Projects", 0, 6);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Projects", 0, 7));
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
			//rp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			rp.clickOnAdd();
			   }
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

	@Then("^release is created for all projects$")
	public void release_is_created_for_all_projects() throws Throwable {
	   try
	   {
		   log.info("release is created for all projects");
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
