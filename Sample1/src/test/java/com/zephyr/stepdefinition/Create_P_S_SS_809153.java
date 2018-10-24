package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Create_P_S_SS_809153 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;

	boolean[] actual=new boolean[64];
	SoftAssert soft=new SoftAssert();

	String fileName="Create_P_S_SS_809153";
	
@Given("^User in the TestRepositoryPage$")
public void user_in_the_TestRepositoryPage() throws Throwable
{
	try
	{
//	  
//	   lb.preCond();
//	   
//	   lp=new LoginPage(driver);
//	   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
//	   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
//	   lp.enterUname(Uname);
//	   lp.enterPass(Pass);
//	   lp.clickOnLogin();
		 lb=new LaunchBrowser();
	   bp=new BasePage();
	   pp=new ProjectPage(driver);
	   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
	   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
	   actual[0]=pp.selectProject(projectName);
	   actual[1]=pp.selectRelease(releaseName);
	   bp.waitForElement();
	   rp= new ReleasePage(driver);
	   actual[2]=rp.clickOnTestRep();  
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
}

@When("^User Navigates to Release$")
public void user_Navigates_to_Release() throws Throwable 
{
	try
	{
	   tr=new TestRepositoryPage(driver);
	   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
	   actual[3]=tr.doubleClickOnRelease(releaseName);
	   bp.waitForElement();
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}	

}

@When("^User creates three Phases$")
public void user_creates_three_Phases() throws Throwable 
{
	try
	{
		
	    String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 1, 0);
		String Desc1=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 1, 1);
		String p_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 2, 0);
		String Desc2=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 2, 1);
		String p_Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 3, 0);
		String Desc3=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 3, 1);
        
		actual[4]=tr.addNode(p_Name1, Desc1);
		bp.waitForElement();
		actual[5]=tr.doubleClickOnRelease(releaseName);
        bp.waitForElement();
		actual[6]=tr.addNode(p_Name2, Desc2);
		bp.waitForElement();
		actual[7]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		actual[8]=tr.addNode(p_Name3, Desc3);
		bp.waitForElement();
		actual[9]=tr.doubleClickOnRelease(releaseName);
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}		

}

@Then("^Three phases should be Created Successfully$")
public void three_phases_should_be_Created_Successfully() throws Throwable 
{
	try
	{
    log.info("Pass - Three phases are created successfully");
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
}

@When("^User Navigates to each Phase$")
public void user_Navigates_to_each_Phase() throws Throwable 
{
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH, "Releases", 1, 0);
	String Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 4, 0);
	String Desc1=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 4, 1);
	String Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 5, 0);
	String Desc2=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 5, 1);
	
	String[] all1=new String[1];
	all1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 1, 0);
	
	actual[10]=tr.navigateToNode(releaseName, all1);
	bp.waitForElement();
	actual[11]=tr.addNode(Name1, Desc1);
	bp.waitForElement();
	actual[12]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	actual[13]=tr.navigateToNode(releaseName, all1);
	bp.waitForElement();
	actual[14]=tr.addNode(Name2, Desc2);
	bp.waitForElement();
	actual[15]=tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}			

}

@When("^User Creates two Systems Under each Phase$")
public void user_Creates_two_Systems_Under_each_Phase() throws Throwable 
{
	try
	{
	String releaseName1=Excel_Lib.getData(INPUT_PATH, "Releases", 1, 0);
	String Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 6, 0);
	String Desc3=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 6, 1);
	String Name4=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 7, 0);
	String Desc4=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 7, 1);
	String Name5=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 8, 0);
	String Desc5=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 8, 1);
	String Name6=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 9, 0);
	String Desc6=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 9, 1);
	
	String[] all2=new String[1];
	all2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 2, 0);
	
	actual[16]=tr.navigateToNode(releaseName1, all2);
	bp.waitForElement();
	actual[17]=tr.addNode(Name3, Desc3);
	bp.waitForElement();
	actual[18]=tr.doubleClickOnRelease(releaseName1);
	bp.waitForElement();
	actual[19]=tr.navigateToNode(releaseName1, all2);
	bp.waitForElement();
	actual[20]=tr.addNode(Name4, Desc4);
	bp.waitForElement();
	actual[21]=tr.doubleClickOnRelease(releaseName1);
	bp.waitForElement();
	
	String[] all3=new String[1];
	all3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 3, 0);
	
	actual[22]=tr.navigateToNode(releaseName1, all3);
	bp.waitForElement();
	actual[23]=tr.addNode(Name5, Desc5);
	bp.waitForElement();
	actual[24]=tr.doubleClickOnRelease(releaseName1);
	bp.waitForElement();
	actual[25]=tr.navigateToNode(releaseName1, all3);
	bp.waitForElement();
	actual[26]=tr.addNode(Name6, Desc6);
	bp.waitForElement();
	actual[27]=tr.doubleClickOnRelease(releaseName1);
	bp.waitForElement();
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}			

}

@Then("^Systems Should be Created Successfully$")
public void systems_Should_be_Created_Successfully() throws Throwable
{
	try
	{
    log.info("Pass - Two systems should be created under each phase");
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
}

@When("^User Navigates to each System$")
public void user_Navigates_to_each_System() throws Throwable
{
	try
	{
	String releaseName1=Excel_Lib.getData(INPUT_PATH, "Releases", 1, 0);
	String Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 10, 0);
	String Desc1=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 10, 1);
	String Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 11, 0);
	String Desc2=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 11, 1);
	String Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 12, 0);
	String Desc3=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 12, 1);
	String Name4=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 13, 0);
	String Desc4=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 13, 1);
	
	String[] all3=new String[2];
	all3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 1, 0);
	all3[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 4, 0);
	
	actual[28]=tr.navigateToNode(releaseName1, all3);
	bp.waitForElement();
	actual[29]=tr.addNode(Name1, Desc1);
	bp.waitForElement();
	actual[30]=tr.doubleClickOnRelease(releaseName1);
	bp.waitForElement();
	actual[31]=tr.navigateToNode(releaseName1, all3);
	bp.waitForElement();
	actual[32]=tr.addNode(Name2, Desc2);
	bp.waitForElement();
	actual[33]=tr.doubleClickOnRelease(releaseName1);
	bp.waitForElement();
	String[] all4=new String[2];
	all4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 1, 0);
	all4[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 5, 0);
	
	actual[34]=tr.navigateToNode(releaseName1, all4);
	bp.waitForElement();
	actual[35]=tr.addNode(Name3, Desc3);
	bp.waitForElement();
	actual[36]=tr.doubleClickOnRelease(releaseName1);
	bp.waitForElement();
	
	actual[37]=tr.navigateToNode(releaseName1, all4);
	bp.waitForElement();
	actual[38]=tr.addNode(Name4, Desc4);
	bp.waitForElement();
	actual[39]=tr.doubleClickOnRelease(releaseName1);
	bp.waitForElement();
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}			

}

@When("^User Creates two Sub-Systems Under each System$")
public void user_Creates_two_Sub_Systems_Under_each_System() throws Throwable
{
	try
	{
	String releaseName1=Excel_Lib.getData(INPUT_PATH, "Releases", 1, 0);
	String Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 14, 0);
	String Desc1=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 14, 1);
	String Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 15, 0);
	String Desc2=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 15, 1);
	String Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 16, 0);
	String Desc3=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 16, 1);
	String Name4=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 17, 0);
	String Desc4=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 17, 1);
	String Name5=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 18, 0);
	String Desc5=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 18, 1);
	String Name6=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 19, 0);
	String Desc6=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 19, 1);
	String Name7=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 20, 0);
	String Desc7=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 20, 1);
	String Name8=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 21, 0);
	String Desc8=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 21, 1);
	
	String[] all3=new String[2];
	all3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 2, 0);
	all3[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 6, 0);
	
	actual[40]=tr.navigateToNode(releaseName1, all3);
	bp.waitForElement();
	actual[41]=tr.addNode(Name1, Desc1);
	bp.waitForElement();
	actual[42]=tr.doubleClickOnRelease(releaseName1);
	bp.waitForElement();
	actual[43]=tr.navigateToNode(releaseName1, all3);
	bp.waitForElement();
	actual[44]=tr.addNode(Name2, Desc2);
	bp.waitForElement();
	actual[45]=tr.doubleClickOnRelease(releaseName1);
	bp.waitForElement();
	String[] all4=new String[2];
	all4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 2, 0);
	all4[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 7, 0);
	
	actual[46]=tr.navigateToNode(releaseName1, all4);
	bp.waitForElement();
	actual[47]=tr.addNode(Name3, Desc3);
	bp.waitForElement();
	actual[48]=tr.doubleClickOnRelease(releaseName1);
	bp.waitForElement();
	
	actual[49]=tr.navigateToNode(releaseName1, all4);
	bp.waitForElement();
	actual[50]=tr.addNode(Name4, Desc4);
	bp.waitForElement();
	actual[51]=tr.doubleClickOnRelease(releaseName1);
	bp.waitForElement();
	String[] all5=new String[2];
	all5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 3, 0);
	all5[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 8, 0);
	
	actual[52]=tr.navigateToNode(releaseName1, all5);
	bp.waitForElement();
	actual[53]=tr.addNode(Name5, Desc5);
	bp.waitForElement();
	actual[54]=tr.doubleClickOnRelease(releaseName1);
	bp.waitForElement();
	
	actual[55]=tr.navigateToNode(releaseName1, all5);
	bp.waitForElement();
	actual[56]=tr.addNode(Name6, Desc6);
	bp.waitForElement();
	actual[57]=tr.doubleClickOnRelease(releaseName1);
	bp.waitForElement();
	
	String[] all6=new String[2];
	all6[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 3, 0);
	all6[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "New", 9, 0);
	
	actual[58]=tr.navigateToNode(releaseName1, all6);
	bp.waitForElement();
	actual[59]=tr.addNode(Name7, Desc7);
	bp.waitForElement();
	actual[60]=tr.doubleClickOnRelease(releaseName1);
	bp.waitForElement();
	
	actual[61]=tr.navigateToNode(releaseName1, all6);
	bp.waitForElement();
	actual[62]=tr.addNode(Name8, Desc8);
	bp.waitForElement();
	actual[63]=tr.doubleClickOnRelease(releaseName1);
	bp.waitForElement();
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}			

}

@Then("^Sub-Systems Should be Created Successfully$")
public void sub_Systems_Should_be_Created_Successfully() throws Throwable
{
	try
	{
		
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
    	soft.assertAll();
    	
    log.info("Pass - Two subsystems are created in each system");
	}
	catch(Exception e)
	{
		lb.getScreenShot(fileName);
		driver.close();
      	Relogin rl=new Relogin();
      	rl.reLogin();
      	throw e;
   	 
	}
    //lb.close();
}
	
}
