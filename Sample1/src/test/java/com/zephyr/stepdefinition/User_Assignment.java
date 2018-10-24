package com.zephyr.stepdefinition;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class User_Assignment extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	
	@Given("^Login as manager$")
	public void login_as_manager() throws Throwable {
	    bp=new BasePage(); 
	    bp.waitForElement();
//		pp=new ProjectPage(driver);
//		pp.clickOnLogout();
//		lp=new LoginPage(driver);
//		lp.enterUname("test.manager");
//		lp.enterPass("test.manager");
//		lp.clickOnLogin();
	}

	@When("^User click on admin and manage user$")
	public void user_click_on_admin_and_manage_user() throws Throwable 
	{
	    pp=new ProjectPage(driver);
	    pp.launchAdministration();
	    pp.launchManageUsers();
	    
	}

	@When("^select the first lead user and assign the projects$")
	public void select_the_first_lead_user_and_assign_the_projects() throws Throwable {
	   
		String lead_User_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Lead_Username_1");
		pp.selectUser(lead_User_1);
		
//	    bp.checkSelectedProjectCount();
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_1");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_2");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_1");
		//projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_2");
		pp.assignProject(projects);
		
		
	}

	@When("^select the second lead user and assign the projects$")
	public void select_the_second_lead_user_and_assign_the_projects() throws Throwable {
		String lead_User_2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Lead_Username_2");
		pp.selectUser(lead_User_2);
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_1");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_2");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_1");
		//projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_2");
		pp.assignProject(projects);
	}

	@When("^select the third lead user and assign the projects$")
	public void select_the_third_lead_user_and_assign_the_projects() throws Throwable {
		String lead_User_3=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Lead_Username_3");
		pp.selectUser(lead_User_3);
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_1");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_2");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_1");
		//projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_2");
		pp.assignProject(projects);
	}

	@When("^select the fourth lead user and assign the projects$")
	public void select_the_fourth_lead_user_and_assign_the_projects() throws Throwable {
		String lead_User_4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Lead_Username_4");
		pp.selectUser(lead_User_4);
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_1");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_2");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_1");
		//projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_2");
		pp.assignProject(projects);
	}

	@When("^select the fifth lead user and assign the projects$")
	public void select_the_fifth_lead_user_and_assign_the_projects() throws Throwable {
		String lead_User_5=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Lead_Username_5");
		pp.selectUser(lead_User_5);
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_1");
		//projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_2");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_1");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_2");
		pp.assignProject(projects);
	}

	@When("^select the sixth lead user and assign the projects$")
	public void select_the_sixth_lead_user_and_assign_the_projects() throws Throwable {
		String lead_User_6=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Lead_Username_6");
		pp.selectUser(lead_User_6);
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_1");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_2");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_1");
		//projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_2");
		pp.assignProject(projects);
	}

	@When("^select the first tester user and assign the projects$")
	public void select_the_first_tester_user_and_assign_the_projects() throws Throwable {
		String tester_User_1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Tester_Username_1");
		pp.selectUser(tester_User_1);
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_1");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_2");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_1");
		//projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_2");
		pp.assignProject(projects);
	}

	@When("^select the second tester user and assign the projects$")
	public void select_the_second_tester_user_and_assign_the_projects() throws Throwable {
		String tester_User_2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Tester_Username_2");
		pp.selectUser(tester_User_2);
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_1");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_2");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_1");
		//projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_2");
		pp.assignProject(projects);
	}

	@When("^select the third tester user and assign the projects$")
	public void select_the_third_tester_user_and_assign_the_projects() throws Throwable {
		String tester_User_3=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Tester_Username_3");
		pp.selectUser(tester_User_3);
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_1");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_2");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_1");
		//projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_2");
		pp.assignProject(projects);
	}

	@When("^select the fourth tester user and assign the projects$")
	public void select_the_fourth_tester_user_and_assign_the_projects() throws Throwable {
		String tester_User_4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Tester_Username_4");
		pp.selectUser(tester_User_4);
		String[] projects=new String[5];
		projects[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		projects[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_2");
		projects[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_1");
		projects[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Restricted_Project_2");
		projects[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_1");
		//projects[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Isolated_Project_2");
		pp.assignProject(projects);
	}

	@Then("^projects successfully assigned to the users$")
	public void projects_successfully_assigned_to_the_users() throws Throwable {
	   System.out.println("Projects successfully assigned to the users");
	}
}
