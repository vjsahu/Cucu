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

public class Create_SS_10thlevel_808723 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	boolean[] actual=new boolean[34];
	 SoftAssert soft=new SoftAssert();
	 String fileName="Create_SS_10thlevel_808723";
	 
	@Given("^User is in the TestRepository$")
	public void user_is_in_the_TestRepository() throws Throwable 
	{
		try
		{
//		
//		   lb.preCond();
//		   
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
			lb=new LaunchBrowser();
		   bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		   actual[0]=pp.selectProject(projectName);
		   bp.waitForElement();
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

	@When("^User Navigates to ReleaseName$")
	public void user_Navigates_to_ReleaseName() throws Throwable 
	{
		try
		{
			tr=new TestRepositoryPage(driver);
			String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			 actual[3]=tr.doubleClickOnRelease(releaseName);
//			WebElement DD=driver.findElement(By.xpath("//*[@id='tcr-h-resizer-handle']"));
//	        Actions act=new Actions(driver);
	       actual[4]=bp.waitForElement();
//	        act.dragAndDropBy(DD,150, 0).perform();
//	        bp.waitForElement();
//	        actual[4]=tr.doubleClickOnRelease(releaseName);
//	        bp.waitForElement();
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

	@When("^User Creates Folders Upto Tenth Level$")
	public void user_Creates_Folders_Upto_Tenth_Level() throws Throwable 
	{
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 0);
		String Desc=Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 1);
		 actual[5]=tr.addNode(Name, Desc);
		 bp.waitForElement();
		 actual[6]=tr.doubleClickOnRelease(releaseName);
		 bp.waitForElement();
        String Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 2, 0);
		String Desc1=Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 2, 1);
        String add1[]=new String[1];
        add1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 0);
        actual[7]=tr.navigateToNode(releaseName, add1);
        bp.waitForElement();
        actual[8]=tr.addNode(Name1, Desc1);
        bp.waitForElement();
        actual[9]=tr.doubleClickOnRelease(releaseName);
        bp.waitForElement();
        String Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 3, 0);
		String Desc2=Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 3, 1);
        String add2[]=new String[2];
        add2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 0);
        add2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 2, 0);
        actual[10]=tr.navigateToNode(releaseName, add2);
        bp.waitForElement();
        actual[11]=tr.addNode(Name2, Desc2);
        bp.waitForElement();
        actual[12]=tr.doubleClickOnRelease(releaseName);
        bp.waitForElement();
        String Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 4, 0);
		String Desc3=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 4, 1);
        String add3[]=new String[3];
        add3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 0);
        add3[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 2, 0);
        add3[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 3, 0);
        actual[13]=tr.navigateToNode(releaseName, add3);
        bp.waitForElement();
        actual[14]=tr.addNode(Name3, Desc3);
        bp.waitForElement();
        actual[15]=tr.doubleClickOnRelease(releaseName);
        bp.waitForElement();
        String Name4=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 5, 0);
		String Desc4=Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 5, 1);
        String add4[]=new String[4];
        add4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 0);
        add4[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 2, 0);
        add4[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 3, 0);
        add4[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 4, 0);
        actual[16]=tr.navigateToNode(releaseName, add4);
        bp.waitForElement();
        actual[17]=tr.addNode(Name4, Desc4);
        bp.waitForElement();
        actual[18]=tr.doubleClickOnRelease(releaseName);
        bp.waitForElement();
        String Name5=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 6, 0);
		String Desc5=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 6, 1);
        String add5[]=new String[5];
        add5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 0);
        add5[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 2, 0);
        add5[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 3, 0);
        add5[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 4, 0);
        add5[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 5, 0);
        actual[19]=tr.navigateToNode(releaseName, add5);
        bp.waitForElement();
        actual[20]=tr.addNode(Name5, Desc5);
        bp.waitForElement();
        actual[21]=tr.doubleClickOnRelease(releaseName);
        bp.waitForElement();
        String Name6=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 7, 0);
		String Desc6=Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 7, 1);
        String add6[]=new String[6];
        add6[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 0);
        add6[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 2, 0);
        add6[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 3, 0);
        add6[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 4, 0);
        add6[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 5, 0);
        add6[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 6, 0);
        actual[22]=tr.navigateToNode(releaseName, add6);
        bp.waitForElement();
        actual[23]=tr.addNode(Name6, Desc6);
        bp.waitForElement();
        actual[24]=tr.doubleClickOnRelease(releaseName);
        bp.waitForElement();
        String Name7=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 8, 0);
		String Desc7=Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 8, 1);
        String add7[]=new String[7];
        add7[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 0);
        add7[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 2, 0);
        add7[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 3, 0);
        add7[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 4, 0);
        add7[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 5, 0);
        add7[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 6, 0);
        add7[6]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 7, 0);
        actual[25]=tr.navigateToNode(releaseName, add7);
        bp.waitForElement();
        actual[26]=tr.addNode(Name7, Desc7);
        bp.waitForElement();
        actual[27]=tr.doubleClickOnRelease(releaseName);
        bp.waitForElement();
        
        String Name8=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 9, 0);
		String Desc8=Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 9, 1);
        String add8[]=new String[8];
        add8[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 0);
        add8[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 2, 0);
        add8[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 3, 0);
        add8[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 4, 0);
        add8[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 5, 0);
        add8[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 6, 0);
        add8[6]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 7, 0);
        add8[7]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 8, 0);
        actual[28]=tr.navigateToNode(releaseName, add8);
        bp.waitForElement();
        actual[29]=tr.addNode(Name8, Desc8);
        bp.waitForElement();
        actual[30]=tr.doubleClickOnRelease(releaseName);
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

	@When("^User Adds the Sub-System in the Tenth Level$")
	public void user_Adds_the_Sub_System_in_the_Tenth_Level() throws Throwable
	{
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		String Name9=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 10, 0);
		String Desc9=Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 10, 1);
        String add9[]=new String[9];
        add9[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 0);
        add9[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 2, 0);
        add9[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 3, 0);
        add9[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 4, 0);
        add9[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 5, 0);
        add9[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 6, 0);
        add9[6]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 7, 0);
        add9[7]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 8, 0);
        add9[8]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 9, 0);
        actual[31]=tr.navigateToNode(releaseName, add9);
        bp.waitForElement();
        actual[32]=tr.addNode(Name9, Desc9);
        bp.waitForElement();
        
        actual[33]=tr.doubleClickOnRelease(releaseName);
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

	@Then("^Sub-System should be Added in Tenth Level$")
	public void sub_System_should_be_Added_in_Tenth_Level() throws Throwable 
	{
		try
		{
		for(int k=0;k<=actual.length-1;k++)
	     {
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
	    log.info("Pass - Sub-System is added in 10th level Successfully");
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
}
