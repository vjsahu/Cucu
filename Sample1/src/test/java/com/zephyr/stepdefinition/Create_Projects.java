package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Create_Projects extends LaunchBrowser{
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Create_Projects";
	
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	
	boolean [] actual =new boolean[2];
	SoftAssert soft=new SoftAssert();
	
	private String project1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_2");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_1");
	private String project3=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_2");
	private String project4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_1");
	private String project5=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_2");
	private String description=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 0);
	private String lead=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1,2);
	private String mapDefectProject=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1,1);
	
	private String [] startDate=new String [3];
 	{
 	startDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Project_Data", 1, 3));
 	startDate[1]=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 4);
 	startDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Project_Data", 1, 5));
 	}
 	
 	private String [] endDate=new String [3];
 	{
 	endDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Project_Data", 1, 6));
 	endDate[1]=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 7);
 	endDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH, "Project_Data", 1, 8));
 	}
 	
 	private String shareCheckbox=Excel_Lib.getData(INPUT_PATH, "Project_Data", 100, 100);
	
 	@Given("^Login as a Test manager$")
 	public void login_as_a_Test_manager() throws Throwable {
 	 try
 	 {
 		 bp=new BasePage();
	 	 lb.preCond();
	 	 String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"URL");
	 	 lb.getUrl(url);
	 	 lp=new LoginPage(driver);
	 	 pp=new ProjectPage(driver);
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Manager_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Manager_Password_1");
	     lp.enterUname(Uname);
	     lp.enterPass(Pass);
	     lp.clickOnLogin();
	     bp.waitForElement();
 	}
	    catch(Exception e)
	     {
	      lb=new LaunchBrowser();
	      e.printStackTrace();
	      lb.getScreenShot(fileName);
	      driver.close();
	      Relogin rl=new Relogin();
	      rl.reLogin();
	      throw e;
	    }   
 	}

 	@Given("^navigate to Manage Projects page$")
 	public void navigate_to_Manage_Projects_page() throws Throwable {
 		 try
 	    {
 	 	  actual[0]=pp.launchAdministration();
 	 	  bp.waitForElement();
 	 	  actual[1]=pp.launchManageprojects();
 	 	  bp.waitForElement();
 	    }
 	    catch(Exception e)
 	     {
 	      lb=new LaunchBrowser();
 	      e.printStackTrace();
 	      lb.getScreenShot(fileName);
 	      driver.close();
 	      Relogin rl=new Relogin();
 	      rl.reLogin();
 	      throw e;
 	    }    
 	}

	
 	@When("^Create five normal project$")
 	public void create_five_normal_project() throws Throwable {
 		try
		{
		  boolean result=pp.validateProject(project1);
		  //System.out.println(result + " inside step definition");
		  if(result==false)
		   {
		  String typeName=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 9);
		  pp.createProject(project1, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
			
		   
		   
		   }
		 	
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin rl=new Relogin();
		  rl.reLogin();
		  throw e;
		}   
 	}
 	
	@When("^Create One normal project$")
	public void create_One_normal_project() throws Throwable {
		try
		{
		  boolean result=pp.validateProject(project1);
		  //System.out.println(result + " inside step definition");
		  if(result==false)
		   {
		  String typeName=Excel_Lib.getData(INPUT_PATH, "Project_Data", 1, 9);
		 pp.createProject(project1, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
			
		   
		   
		   }
		 	
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin rl=new Relogin();
		  rl.reLogin();
		  throw e;
		}   
	}

	@When("^Create two isolated projects$")
	public void create_two_isolated_projects() throws Throwable {
		try
		{
		  String typeName=Excel_Lib.getData(INPUT_PATH, "Project_Data", 2, 9);
		  boolean result=pp.validateProject(project2);
		  if(result==false)
			{
		 
		pp.createProject(project2, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
			 }
		  boolean result1=pp.validateProject(project3);
		  if(result1==false)
		   {
		 pp.createProject(project3, description, typeName,lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
		    } 
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin rl=new Relogin();
		  rl.reLogin();
		  throw e;
		}   
	}

	@When("^Create two restricted projects$")
	public void create_two_restricted_projects() throws Throwable {
		try
		{
		  String typeName=Excel_Lib.getData(INPUT_PATH, "Project_Data", 3, 9);
		  boolean result=pp.validateProject(project4);
		  if(result==false)
		   {
		pp.createProject(project4, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
		   }
		  boolean result1=pp.validateProject(project5);
		  if(result1==false)
			{
		pp.createProject(project5, description, typeName,lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
			}
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin rl=new Relogin();
		  rl.reLogin();
		  throw e;
		}   
	}

	@Then("^Projects should be created successfully$")
	public void projects_should_be_created_successfully() throws Throwable {
		try
		{
		 System.out.println("All projects created successfully");
			for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();	
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin rl=new Relogin();
		  rl.reLogin();
		  throw e;
		}   
	}


}
