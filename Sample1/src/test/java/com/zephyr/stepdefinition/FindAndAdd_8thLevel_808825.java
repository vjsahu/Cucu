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

public class FindAndAdd_8thLevel_808825 extends LaunchBrowser 
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	boolean[] actual=new boolean[29];
	SoftAssert soft=new SoftAssert();
	
	String fileName="FindAndAdd_8thLevel_808825";
	
	@Given("^User is in TestRepositoryPage$")
	public void user_is_in_TestRepositoryPage() throws Throwable
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
		   actual[1]= pp.selectRelease(releaseName);
		   bp.waitForElement();
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
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

	@When("^User Navigates to the Release$")
	public void user_Navigates_to_the_Release() throws Throwable 
	{
		try
		{
		tr=new TestRepositoryPage(driver);
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		actual[3]=tr.doubleClickOnRelease(releaseName);
		//WebElement DD=tr.dndReleaseArea;
//        Actions act=new Actions(driver);
//        act.dragAndDropBy(DD,250, 0).perform();
		actual[4]=bp.waitForElement();
        //actual[4]=tr.doubleClickOnRelease(releaseName);
       // actual[4]=bp.waitForElement();
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

	@When("^User Navigates upto Eight Node$")
	public void user_Navigates_upto_Eight_Node() throws Throwable 
	{
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 1, 0);
		String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 1, 1);
		actual[5]=tr.addNode(Name, Desc);
		bp.waitForElement();
		actual[6]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
        String Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 2, 0);
		String Desc1=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 2, 1);
        String add1[]=new String[1];
        add1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 1, 0);
        actual[7]= tr.navigateToNode(releaseName, add1);
        bp.waitForElement();
        actual[8]=tr.addNode(Name1, Desc1);
        bp.waitForElement();
        actual[9]=tr.doubleClickOnRelease(releaseName);
        bp.waitForElement();
        String Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 3, 0);
		String Desc2=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 3, 1);
        String add2[]=new String[2];
        add2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 1, 0);
        add2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 2, 0);
        actual[10]=tr.navigateToNode(releaseName, add2);
        bp.waitForElement();
        actual[11]=tr.addNode(Name2, Desc2);
        bp.waitForElement();
        actual[12]=tr.doubleClickOnRelease(releaseName);
        bp.waitForElement();
        String Name3=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 4, 0);
		String Desc3=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 4, 1);
        String add3[]=new String[3];
        add3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 1, 0);
        add3[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 2, 0);
        add3[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 3, 0);;
        actual[13]=tr.navigateToNode(releaseName, add3);
        bp.waitForElement();
        actual[14]=tr.addNode(Name3, Desc3);
        bp.waitForElement();
        actual[15]=tr.doubleClickOnRelease(releaseName);
        bp.waitForElement();
        String Name4=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 5, 0);
		String Desc4=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 5, 1);
        String add4[]=new String[4];
        add4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 1, 0);
        add4[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 2, 0);
        add4[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 3, 0);
        add4[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 4, 0);
        actual[16]=tr.navigateToNode(releaseName, add4);
        bp.waitForElement();
        actual[17]=tr.addNode(Name4, Desc4);
        bp.waitForElement();
        actual[18]=tr.doubleClickOnRelease(releaseName);
        bp.waitForElement();
        String Name5=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 6, 0);
		String Desc5=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 6, 1);
        String add5[]=new String[5];
        add5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 1, 0);
        add5[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 2, 0);
        add5[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 3, 0);
        add5[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 4, 0);
        add5[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 5, 0);
        actual[19]=tr.navigateToNode(releaseName, add5);
        bp.waitForElement();
        actual[20]=tr.addNode(Name5, Desc5);
        bp.waitForElement();
        actual[21]=tr.doubleClickOnRelease(releaseName);
        bp.waitForElement();
        String Name6=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 7, 0);
		String Desc6=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 7, 1);
        String add6[]=new String[6];
        add6[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 1, 0);
        add6[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 2, 0);
        add6[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 3, 0);
        add6[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 4, 0);
        add6[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 5, 0);
        add6[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 6, 0);
        actual[22]=tr.navigateToNode(releaseName, add6);
        bp.waitForElement();
        actual[23]=tr.addNode(Name6, Desc6);
        bp.waitForElement();
        actual[24]=tr.doubleClickOnRelease(releaseName);
        bp.waitForElement();
        String Name7=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 8, 0);
		String Desc7=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 8, 1);
        String add7[]=new String[7];
        add7[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 1, 0);
        add7[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 2, 0);
        add7[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 3, 0);
        add7[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 4, 0);
        add7[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 5, 0);
        add7[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 6, 0);
        add7[6]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 7, 0);
        actual[25]=tr.navigateToNode(releaseName, add7);
        bp.waitForElement();
        actual[26]=tr.addNode(Name7, Desc7);
        bp.waitForElement();
        actual[27]=tr.doubleClickOnRelease(releaseName);
        bp.waitForElement();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}	
	}

	@When("^User Performs FindAndAdd Operation using ZQL Quarry$")
	public void user_Performs_FindAndAdd_Operation_using_ZQL_Quarry() throws Throwable 
	{
		try
		{	
		String[] operator=new String[1];
		String[] symbol=new String[1];
		String[] value=new String[1];
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		operator[0]=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 0);
		symbol[0]=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 1);
		value[0]=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 2);
		String colName=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 3);
		int colNum=Excel_Lib.getNumberData(INPUT_PATH, "FindAndAdd", 1, 4);
		String role=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 5);
		String selectCount=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 6);
		String add8[]=new String[8];
        add8[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 1, 0);
        add8[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 2, 0);
        add8[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 3, 0);
        add8[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 4, 0);
        add8[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 5, 0);
        add8[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 6, 0);
        add8[6]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 7, 0);
        add8[7]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "FNA_8th_Level", 8, 0);
        actual[28]=tr.navigateToNode(releaseName, add8);
        tr.findAndAdd(operator, symbol, value, colName, colNum, role, selectCount);
	  // tr.findAndAdd("creator","=", "\"test.lead\"", "createdBy", "11","Test Lead","Single");	
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

	@Then("^TestCases should be added to Eight Node Successfully$")
	public void testcases_should_be_added_to_Eight_Node_Successfully() throws Throwable 
	{
		try
		{
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
    	soft.assertAll();
	    log.info("Pass - TestCases are added in 8th Node Successfully");
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
