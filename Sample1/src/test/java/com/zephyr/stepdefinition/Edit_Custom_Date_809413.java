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

public class Edit_Custom_Date_809413 extends LaunchBrowser
{
	
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Edit_Custom_Date_809413";
	
	boolean[] actual=new boolean[5];
	 SoftAssert soft=new SoftAssert();
	@Given("^user in Repository page$")
	public void user_in_Repository_page() throws Throwable 
	{
		try
		{
		pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		}catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			  Relogin rl=new Relogin();
			  rl.reLogin();
			  throw e;
		}
	}

	@When("^create a node with test case and click detail$")
	public void create_a_node_with_test_case_and_click_detail() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
	    String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
	    actual[3]=tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();

	  //Creating Phase
	     String pName=Excel_Lib.getData(INPUT_PATH_4,"Phase",4,0);
	     String pDesc=Excel_Lib.getData(INPUT_PATH_4,"Phase",4,1);
	     actual[4]=tr.addNode(pName, pDesc);
	     bp.waitForElement();
	     tr.doubleClickOnRelease(releaseName);
	     String navigation[]=new String[1];
	     navigation[0]= Excel_Lib.getData(INPUT_PATH_4,"Phase",4,0);
	     tr.navigateToNode(releaseName, navigation);
	    
	    tr=new TestRepositoryPage(driver);
	    tr.addTestCase();
	    bp.waitForElement();
	    ctc=new CreateTestCasePage(driver);
//	    ctc.selectCeckBoxOption.click();
//	    bp.waitForElement();
//	    ctc.selectDateCheckBox.click();
//	    bp.waitForElement();
	    tr.clickDetailButton();
	    bp.waitForElement();
		}catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
			 driver.close();
			  Relogin rl=new Relogin();
			  rl.reLogin();
			  throw e;
		}
	}

	@When("^edit custom field with date$")
	public void edit_custom_field_with_date() throws Throwable 
	{
		try
		{
	     tr.clickOnCustomField();
		ctc=new CreateTestCasePage(driver);
		
	    String text=Excel_Lib.getData(INPUT_PATH_4,"customfields",1,0);
	    String longText=Excel_Lib.getData(INPUT_PATH_4,"customfields",1,1);
	    String number=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "customfields", 1, 2));
	    String checkBox=Excel_Lib.getData(INPUT_PATH_4,"customfields",100,300);
	    String pickupList=Excel_Lib.getData(INPUT_PATH_4,"customfields",100,400);
	    String date=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"customfields",1,5));
	    ctc.enterCustomFields(text, longText, number, checkBox, pickupList, date);
	    bp=new BasePage();
	    bp.waitForElement();
	    
	    String text1=Excel_Lib.getData(INPUT_PATH_4,"customfields",1,0);
	    String longText1=Excel_Lib.getData(INPUT_PATH_4,"customfields",1,1);
	    String number1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "customfields", 1, 2));
	    String checkBox1=Excel_Lib.getData(INPUT_PATH_4,"customfields",100,300);
	    String pickupList1=Excel_Lib.getData(INPUT_PATH_4,"customfields",100,400);
	    String date1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"customfields",1,6));
	    ctc.enterCustomFields(text1, longText1, number1, checkBox1, pickupList1, date1);
	   // ctc.selectdate();
		}catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
			 driver.close();
			  Relogin rl=new Relogin();
			  rl.reLogin();
			  throw e;
		}
	}
	@Then("^view and verify the date$")
	public void view_and_verify_the_date() throws Throwable 
	{
		try
		{
//		ctc.clickOnList.click();
//		bp=new BasePage();
//	    bp.waitForElement();
//		ctc.clickOnListPage.click();
//	    bp.waitForElement();
//		Actions act=new Actions(driver);
//		act.sendKeys(Keys.ARROW_RIGHT).perform();
//		act.sendKeys(Keys.ARROW_RIGHT).perform();
//		act.sendKeys(Keys.ARROW_RIGHT).perform();
//		act.sendKeys(Keys.ARROW_RIGHT).perform();
//	    bp.waitForElement();
//		String expected=ctc.clickToGetTextInList.getText();
//		System.out.println(expected);
			tr.clickOnList();
		for(int k=0;k<=actual.length-1;k++)
	     {
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
	     
	     
	   
		}catch (Exception e) 
		{
			lb.getScreenShot(fileName);
		e.printStackTrace();
		 driver.close();
		  Relogin rl=new Relogin();
		  rl.reLogin();
		  throw e;
		}	}
}
