package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditTestCase_808728 extends LaunchBrowser
{

	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	BasePage bp;
	NavigationPage np;
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="EditTEstcase_808728";
	
	boolean[] actual=new boolean[18];
	SoftAssert soft=new SoftAssert();

@Given("^User is in test repository page$")
public void user_is_in_test_repository_page() throws Throwable 
{
//	lb=new LaunchBrowser();
//	   lb.preCond();
//	   lp=new LoginPage(driver);
//	   String Uname=Excel_Lib.getData(INPUT_PATH_2,"Login",3,0);
//	   String Pass=Excel_Lib.getData(INPUT_PATH_2,"Login",3,1);
//	   lp.enterUname(Uname);
//	   lp.enterPass(Pass);
//	   lp.clickOnLogin();
//	   
	try
	{
	   pp=new ProjectPage(driver);
	   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
	   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
	   actual[0]=pp.selectProject(projectName);
	   actual[1]=pp.selectRelease(releaseName);
	   
	   rp= new ReleasePage(driver);
	   actual[2]=rp.clickOnTestRep();
	   
	}
	catch(Exception e)
	{  lb.getScreenShot(fileName);
	    e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
}



@When("^User creates a phase,system and subsystem$")
public void user_creates_a_phase_system_and_subsystem() throws Throwable {
	try
	{
		bp=new BasePage();
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);  
	
	String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 10, 0);
	String description=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 10, 3);
	
	tr=new TestRepositoryPage(driver);
	 actual[3]=tr.doubleClickOnRelease(releaseName);
	 actual[4]=tr.addNode(phaseName, description);
	  bp.waitForElement();
	  bp.waitForElement();
	 actual[5]=tr.doubleClickOnRelease(releaseName);
	 bp.waitForElement();
	 //bp.waitForElement();
	String[] navigation=new String[1];
	navigation[0]=phaseName;
	 actual[6]=tr.navigateToNode(releaseName, navigation);
	
	String phaseName2=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 10, 1);
	String description2=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 10, 4);
	 actual[7]=tr.addNode(phaseName2, description2);
	 bp.waitForElement();
	 bp.waitForElement();
	 actual[8]=tr.doubleClickOnRelease(releaseName);
	 bp.waitForElement();
	
	String[] navigation2=new String[2];
	navigation2[0]=phaseName;
	navigation2[1]=phaseName2;
	 actual[9]=tr.navigateToNode(releaseName, navigation2);
	

	String phaseName3=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 10, 2);
	String description3=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 10, 5);
	 actual[10]=tr.addNode(phaseName3, description3);
	bp.waitForElement();
	bp.waitForElement();
	 actual[11]=tr.doubleClickOnRelease(releaseName);
	 bp.waitForElement();
	}
	catch(Exception e)
	{  lb.getScreenShot(fileName);
	 e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
	
}

@When("^navigate to subsystem and view the bread crumbs$")
public void navigate_to_subsystem_and_view_the_bread_crumbs() throws Throwable {
	
	try
	{
    bp.waitForElement();
    String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
    
    String[] navigation3=new String[3];
    //navigation3[0]=releaseName;
	navigation3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 10, 0);
	navigation3[1]=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 10, 1);
	navigation3[2]=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 10, 2);
	 actual[12]=tr.navigateToNode(releaseName, navigation3);
	
	np=new NavigationPage(driver);
	String[] breadcrumbs=new String[4];
    breadcrumbs[0]=releaseName;
    breadcrumbs[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 10, 0);
    breadcrumbs[2]=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 10, 1);
    breadcrumbs[3]=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 10, 2);
	// actual[12]=tr.navigateToNode(releaseName, navigation3);
	 actual[13]=np.checkingBreadCrumbs(breadcrumbs);
	
	bp.waitForElement();
	 actual[14]=tr.doubleClickOnRelease(releaseName);
	}
	catch(Exception e)
	{   lb.getScreenShot(fileName);
	 e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
}

@When("^rename the subsystem and view the bread crumbs$")
public void rename_the_subsystem_and_view_the_bread_crumbs() throws Throwable {
	try
	{
	bp.waitForElement();
    String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
    
    String[] navigation3=new String[3];
    //navigation3[0]=releaseName;
	navigation3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 10, 0);
	navigation3[1]=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 10, 1);
	navigation3[2]=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 10, 2);
	
	
	 actual[15]=tr.navigateToNode(releaseName, navigation3);
	
	 String name3=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 11, 2);
	  String desc3=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 19, 0);
	  actual[16]=tr.renameNode(name3, desc3);
	  bp.waitForElement();
	}
	catch(Exception e)
	{  lb.getScreenShot(fileName);
	 e.printStackTrace();
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
	//tr.renameNode(name, desc);
	
}

@Then("^bread crumbs should be updated sucessfully$")
public void bread_crumbs_should_be_updated_sucessfully() throws Throwable {
   
	try
	{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
		String[] breadcrumbs=new String[4];
       breadcrumbs[0]=releaseName;
       breadcrumbs[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "Nodes", 10, 0);
       breadcrumbs[2]=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 10, 1);
        breadcrumbs[3]=Excel_Lib.getData(INPUT_PATH_2, "Nodes", 11, 2);
		
		 actual[17]=np.checkingBreadCrumbs(breadcrumbs);
		
		
		
	       
	    	   for(int k=0;k<=actual.length-1;k++)
	  	     {
	    		   System.out.println(actual[k]);
	  	      soft.assertEquals(actual[k], true);
	  	     }
	  	     soft.assertAll();
		   log.info("Nodes renamed Succesfully");
	       }
	       catch(Exception e)
			{  lb.getScreenShot(fileName);
			 e.printStackTrace();
				driver.close();
		      	Relogin rl=new Relogin();
		      	rl.reLogin();
		      	throw e;
		   	 
			}
	}
}






