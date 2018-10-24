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

public class User_Creation extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	String fileName="User_Creation";
	@Given("^Login as manager credential$")
	public void login_as_manager_credential() throws Throwable {
	    try
	    {
	    	pp=new ProjectPage(driver);
	    	//pp.clickOnLogout();
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

	@When("^User click on the administration and manage users$")
	public void user_click_on_the_administration_and_manage_users() throws Throwable {
	    try
	    {
	    	bp=new BasePage();
	    	pp.launchAdministration();
	    	bp.waitForElement();
	    	pp.launchManageUsers();
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

	@When("^User creates a first lead user$")
	public void user_creates_a_first_lead_user() throws Throwable {
		try
	    {
			String Name1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Username_2");
			 System.out.println(Name1);
			 String[] fullName=Name1.split("\\.");
			 for(int i=0;i<fullName.length;i++)
			 {
				 System.out.println(fullName[i]);
			 }
			 
			 String firstName1=fullName[0];
			 String lastName1=fullName[1];
	
			 String type=Excel_Lib.getData(INPUT_PATH, "User_Details", 1,0);
			 String role=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 1);
			 String email=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 2);
			 String title=Excel_Lib.getData(INPUT_PATH, "User_Details", 100,100);
			 String location=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 4);
			 boolean res=pp.checkAvailableUser(Name1);
			 if(res==false)
			 {
			 pp.createUser(firstName1, lastName1, type, role, email, title, location);
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

	@When("^User creates a second lead user$")
	public void user_creates_a_second_lead_user() throws Throwable {
	    try
	    {
	    	String Name2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Username_3");
			 String[] fullName2=Name2.split("\\.");
			 String firstName2=fullName2[0];
			 String lastName2=fullName2[1];
			 String type2=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 0);
			 String role2=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 1);
			 String email2=Excel_Lib.getData(INPUT_PATH, "User_Details", 2, 2);
			 String title=Excel_Lib.getData(INPUT_PATH, "User_Details", 100,100);
			 String location=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 4);
			 boolean res=pp.checkAvailableUser(Name2);
			 if(res==false)
			 {
			 pp.createUser(firstName2, lastName2, type2, role2, email2, title, location);
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

	@When("^User creates a third lead user$")
	public void user_creates_a_third_lead_user() throws Throwable {
		try
	    {
	    	String Name3=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Username_4");
			 String[] fullName3=Name3.split("\\.");
			 String firstName3=fullName3[0];
			 String lastName3=fullName3[1];
			 String type2=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 0);
			 String role2=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 1);
			 String email3=Excel_Lib.getData(INPUT_PATH, "User_Details", 3, 2);
			 String title=Excel_Lib.getData(INPUT_PATH, "User_Details", 100,100);
			 String location=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 4);
			 boolean res=pp.checkAvailableUser(Name3);
			 if(res==false)
			 {
			 pp.createUser(firstName3, lastName3, type2, role2, email3, title, location);
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

	@When("^User creates a fourth lead user$")
	public void user_creates_a_fourth_lead_user() throws Throwable {
		try
	    {
	    	String Name4=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Username_5");
			 String[] fullName4=Name4.split("\\.");
			 String firstName4=fullName4[0];
			 String lastName4=fullName4[1];
			 String type2=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 0);
			 String role2=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 1);
			 String email4=Excel_Lib.getData(INPUT_PATH, "User_Details", 4, 2);
			 String title=Excel_Lib.getData(INPUT_PATH, "User_Details", 100,100);
			 String location=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 4);
			 boolean res=pp.checkAvailableUser(Name4);
			 if(res==false)
			 {
			 pp.createUser(firstName4, lastName4, type2, role2, email4, title, location);
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

	@When("^User creates a fifth lead user$")
	public void user_creates_a_fifth_lead_user() throws Throwable {
		try
	    {
	    	String Name5=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Username_6");
			 String[] fullName5=Name5.split("\\.");
			 String firstName5=fullName5[0];
			 String lastName5=fullName5[1];
			 String type2=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 0);
			 String role2=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 1);
			 String email5=Excel_Lib.getData(INPUT_PATH, "User_Details", 5, 2);
			 String title=Excel_Lib.getData(INPUT_PATH, "User_Details", 100,100);
			 String location=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 4);
			 boolean res=pp.checkAvailableUser(Name5);
			 if(res==false)
			 {
			 pp.createUser(firstName5, lastName5, type2, role2, email5, title, location);
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

	@When("^User creates a first tester user$")
	public void user_creates_a_first_tester_user() throws Throwable {
		try
	    {
	    	String Name6=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Tester_Username_2");
			 String[] fullName6=Name6.split("\\.");
			 String firstName6=fullName6[0];
			 String lastName6=fullName6[1];
			 String type2=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 0);
			 String role2=Excel_Lib.getData(INPUT_PATH, "User_Details", 2, 1);
			 String email6=Excel_Lib.getData(INPUT_PATH, "User_Details", 6, 2);
			 String title=Excel_Lib.getData(INPUT_PATH, "User_Details", 100,100);
			 String location=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 4);
			 boolean res=pp.checkAvailableUser(Name6);
			 if(res==false)
			 {
			 pp.createUser(firstName6, lastName6, type2, role2, email6, title, location);
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

	@When("^User creates a second tester user$")
	public void user_creates_a_second_tester_user() throws Throwable {
		try
	    {
	    	String Name7=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Tester_Username_3");
			 String[] fullName7=Name7.split("\\.");
			 String firstName7=fullName7[0];
			 String lastName7=fullName7[1];
			 String type2=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 0);
			 String role2=Excel_Lib.getData(INPUT_PATH, "User_Details", 2, 1);
			 String email7=Excel_Lib.getData(INPUT_PATH, "User_Details", 7, 2);
			 String title=Excel_Lib.getData(INPUT_PATH, "User_Details", 100,100);
			 String location=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 4);
			 boolean res=pp.checkAvailableUser(Name7);
			 if(res==false)
			 {
			 pp.createUser(firstName7, lastName7, type2, role2, email7, title, location);
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

	@When("^User creates a third tester user$")
	public void user_creates_a_third_tester_user() throws Throwable {
		try
	    {
	    	String Name8=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Tester_Username_4");
			 String[] fullName8=Name8.split("\\.");
			 String firstName8=fullName8[0];
			 String lastName8=fullName8[1];
			 String type2=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 0);
			 String role2=Excel_Lib.getData(INPUT_PATH, "User_Details", 2, 1);
			 String email8=Excel_Lib.getData(INPUT_PATH, "User_Details", 8, 2);
			 String title=Excel_Lib.getData(INPUT_PATH, "User_Details", 100,100);
			 String location=Excel_Lib.getData(INPUT_PATH, "User_Details", 1, 4);
			 //String user=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Tester_Username_4");
			 boolean res=pp.checkAvailableUser(Name8);
			 if(res==false)
			 {
			 pp.createUser(firstName8, lastName8, type2, role2, email8, title, location);
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

	@Then("^all the users are created successfully$")
	public void all_the_users_are_created_successfully() throws Throwable {
	    try
	    {
	    	log.info("all the users are created successfully");
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
