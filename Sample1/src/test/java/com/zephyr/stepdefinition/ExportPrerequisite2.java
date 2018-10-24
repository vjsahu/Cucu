package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExportPrerequisite2 extends LaunchBrowser
{
	
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	LaunchBrowser lb=new LaunchBrowser();
	
	boolean[] actual=new boolean[16];
	 SoftAssert soft=new SoftAssert();
	 
	 String fileName="ExportPrerequisite2";
	@Given("^User Select the Project$")
	public void user_Select_the_Project() throws Throwable {
		try
		{
		bp=new BasePage();
		pp=new ProjectPage(driver);
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		//String releaseName=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 1);
		actual[0]=pp.selectProject(projectName);
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

	@When("^User Selects The Relaese$")
	public void user_Selects_The_Relaese() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 2, 1);
		actual[1]=pp.selectRelease(releaseName);
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

	@When("^navigate to Test Repository Page Module$")
	public void navigate_to_Test_Repository_Page_Module() throws Throwable {
		try
		{
		rp=new ReleasePage(driver);
		 actual[2]=rp.clickOnTestRep();
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

	@When("^Double Click On The release$")
	public void double_Click_On_The_release() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 2, 1);
		tr=new TestRepositoryPage(driver);
		actual[3]=tr.clickOnRelease(releaseName);
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

	@When("^Creates a Phase in the Relaese$")
	public void creates_a_Phase_in_the_Relaese() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"ExportPrerequisite",2,1);
		String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 2, 2);
		String Desc=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 2, 2);
		actual[4]=tr.addNode(Name, Desc);
		bp.waitForElement();
		
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		
		String add1[]=new String[1];
	    add1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 2, 2);
	    actual[5]= tr.navigateToNode(releaseName, add1);
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

	@When("^Add Test Cases to the Phase$")
	public void add_Test_Cases_to_the_Phase() throws Throwable {
		try
		{
		for(int i=1;i<=5;i++)
		{
			actual[6]=tr.addTestCase();
		}
		bp.waitForElement();
		actual[7]=tr.clickDetailButton();
		
	
		ctc=new CreateTestCasePage(driver);
		
		String[] f=new String[1];
		//f[0]="C:\\Users\\RAJNEESH\\Desktop\\Autoscript.exe";
		//f[0]="./AutoscriptFile/Auto_Script_1.exe";
		f[0]=Excel_Lib.getData(INPUT_PATH_2,"ExportPrerequisite",5,0);
		actual[8]=ctc.uploadAttachement(f);
		
		String stepDetails[]=new String[9];
		stepDetails[0]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 10);
		stepDetails[1]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 11);
		stepDetails[2]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 1, 12);
		
		
		stepDetails[3]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 2, 10);
		stepDetails[4]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 2, 11);
		stepDetails[5]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 2, 12);
		
		
		stepDetails[6]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 3, 10);
		stepDetails[7]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 3, 11);
		stepDetails[8]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 3, 12);
		
		actual[9]=ctc.enterTestCaseStepDetail(stepDetails);
		bp.waitForElement();
	   
	    String[] time=new String[3];
		int k=0;
		for(int i=0;i<=time.length-1;i++)
		{
			int l=Excel_Lib.getNumberData(INPUT_PATH_2,"ExportPrerequisite",6, i);
			time[k]=Integer.toString(l);
	        //time[k]=Double.toString(Excel_Lib.getNumberData(INPUT_PATH,"Estimated_Time",1, i));
	        k++;
		}
		
		 
		 actual[10]=ctc.enterEstimatedTime(time[0],time[1],time[2]);
		 bp.waitForElement();
	    //ctc.enterEstimatedTime(day, hr, mn)
		 
		 actual[11]=tr.clickOnList();
		 
		 bp.waitForElement();
		 ep=new ExportPage(driver);
		 String[] a=new String[2];
		 a[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"ExportPrerequisite", 6, 3));
		 
		 a[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"ExportPrerequisite", 7, 3));
		 actual[12]=ep.selectMultipleTestCaseFromGrid(a);
		 bp.waitForElement();
		 String[] detailField=new String[3];
		 detailField[0]="";
		 detailField[1]="";
		 detailField[2]="";
		 
		 String[] automationField=new String[4];
		 automationField[0]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 6, 4);
		 automationField[1]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 6, 5);
	      automationField[2]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 6, 6);
		automationField[3]=Excel_Lib.getData(INPUT_PATH_2, "ExportPrerequisite", 6, 7);
		tr.editTestCase();
		bp.waitForElement();
		actual[13]=ctc.editMultipleTestCase(detailField, automationField);
	
		actual[14]=ctc.saveMultipleTestCaseEdit();
	     bp.waitForElement();
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

	@Then("^Test Case Added To the Phase$")
	public void test_Case_Added_To_the_Phase() throws Throwable {
	
		try
		{
		actual[15]=tr.verifyPresentTestCase();
		bp.waitForElement();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"ExportPrerequisite",2,1);
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	soft.assertEquals(actual[k], true);
	    }
    	soft.assertAll();
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


}
