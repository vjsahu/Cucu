package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Sort_TestCases_809085 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	String filename="Sort_TestCases_809085";
	boolean[] actual=new boolean[14];
	 SoftAssert soft=new SoftAssert();
	 
	 @Given("^user is in the page Test Repository$")
	 public void user_is_in_the_page_Test_Repository() throws Throwable {
		 /*lb=new LaunchBrowser();
		   lb.preCond();
		   lp=new LoginPage(driver);
		   //String Uname=Excel_Lib.getData(INPUT_PATH_3,"Login",0,1);
		  String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LUname");
		   //String Pass=Excel_Lib.getData(INPUT_PATH_3,"Login",1,1);
		  String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LPass");
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();*/
		   try
		   {
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep(); 
		   }
		   catch(Exception e)
		   {lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
		   e.printStackTrace();
		   driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		   }
	 }

	 @Given("^user creates a node$")
	 public void user_creates_a_node() throws Throwable {
		 try
			{
				bp=new BasePage();
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search", 3, 0);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Search", 3, 3);
			tr=new TestRepositoryPage(driver);
			actual[3]=tr.doubleClickOnRelease(releaseName);
			actual[4]=tr.addNode(p_Name1,p_Desc1);
			String[] phase=new String[1];
			phase[0]=p_Name1;
			actual[5]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			actual[6]=tr.navigateToNode(releaseName, phase);
			}
			 catch(Exception e)
			   {lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			   e.printStackTrace();
			   driver.close();
			    Relogin rl=new Relogin();
			    rl.reLogin();
			    throw e;
			   }
	 }

	 @When("^user creates few test cases$")
	 public void user_creates_few_test_cases() throws Throwable {
		 try
		 {
		 actual[7]=tr.addTestCase();
		 }
		 catch(Exception e)
		   {lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
		   e.printStackTrace();
		   driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		   }
	 }

	 @When("^user go to detail view$")
	 public void user_go_to_detail_view() throws Throwable {
		 try{
			 actual[8]=tr.clickDetailButton();
		 	}
		 catch(Exception e)
		   {lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
		   e.printStackTrace();
		   driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		   }
	 }

	 @When("^user creates test cases in all the available fields$")
	 public void user_creates_test_cases_in_all_the_available_fields() throws Throwable {
		 try
		    {
			ctc=new CreateTestCasePage(driver);
			String tcName=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 0);
			String tcDesc=Excel_Lib.getData(INPUT_PATH_3,"TestCases" , 2, 0);
			
			actual[9]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
			
			
			String[] Details=new String[4];
			Details[0]=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 1, 1);
			Details[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "testcaseDetails", 2, 1));
			//Details[2]=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 3, 1);
			Details[2]=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 6, 1);
			Details[3]=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 4, 1);
			
			
			//bp=new BasePage();
			//bp.waitForElement();
			//ctc=new CreateTestCasePage(driver);
			actual[10]=ctc.enterTestCaseDetail(Details);
			//String[] d= new String[1];
			//d[0]="hj";
			//ctc.enterMultipleTags(d);
			//bp.waitForElement();
			String[] stepDetail=new String[6];
			stepDetail[0]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 0);
			stepDetail[1]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 1);
			stepDetail[2]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 2);
			stepDetail[3]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 0);
			stepDetail[4]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 1);
			stepDetail[5]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 2, 2);
			ctc=new CreateTestCasePage(driver);
			actual[11]=ctc.enterTestCaseStepDetail(stepDetail);
			//ctc.clickStepSave.click();
			bp.waitForElement();
			
			/*bp=new BasePage();
			bp.waitForElement();
			tr=new TestRepositoryPage(driver);
			tr.customFields.click();
			String text=Excel_Lib.getData(INPUT_PATH_3,"CustomField", 1, 0);
			String longText=Excel_Lib.getData(INPUT_PATH_3,"CustomField", 1, 1);
			String number=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3,"CustomField", 1, 2));
			String checkBox=Excel_Lib.getData(INPUT_PATH_3,"CustomField", 1, 3);
			String pickupList=Excel_Lib.getData(INPUT_PATH_3,"CustomField", 1 ,4);
			String date=Excel_Lib.getData(INPUT_PATH_3,"CustomField", 1, 6);
			
			bp.waitForElement();
		    actual[9]=tr.enterCustomFields(text, longText, number, checkBox, pickupList,date);*/
		    
		    }
		    catch(Exception e)
			   {lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			   e.printStackTrace();
			   driver.close();
			    Relogin rl=new Relogin();
			    rl.reLogin();
			    throw e;
			   }
	 }

	 @Then("^user navigates column chooser and sort test cases$")
	 public void user_navigates_column_chooser_and_sort_test_cases() throws Throwable {
		 try
			{
			 bp=new BasePage();
				bp.waitForElement();
				actual[12]=tr.clickOnList();
			String[] sorting=new String[5];
			bp.waitForElement();
			bp.waitForElement();
			sorting[0]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 2, 0);
			sorting[1]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 3, 0);
			sorting[2]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 4, 0);
			//sorting[3]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 14, 0);
			sorting[3]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 7, 0);
			sorting[4]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 8, 0);
			//sorting[7]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 8, 0);
			//sorting[8]=Excel_Lib.getData(INPUT_PATH_3, "Sorting", 9, 0);
			
			bp.waitForElement();
			actual[13]=tr.sortingTestCase(sorting);
			bp.waitForElement();
			bp.waitForElement();
			driver.navigate().refresh();
			bp.waitForElement();
			bp.waitForElement();
//			TestRepositoryPage_POM tp=new TestRepositoryPage_POM(driver);
//			tp.sortTestCase.click();
//			
			
			}
			 catch(Exception e)
			   {lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			   e.printStackTrace();
			   driver.close();
			    Relogin rl=new Relogin();
			    rl.reLogin();
			    throw e;
			   }
	 }

	 @Then("^sorting of testcase can be performed successfully$")
	 public void sorting_of_testcase_can_be_performed_successfully() throws Throwable {
		 try
		    {
		    	for(int k=0;k<=actual.length-1;k++)
		        {
		    		System.out.println(actual[k]);
		         soft.assertEquals(actual[k], true);
		        }
		        soft.assertAll();
			log.info("sorting can be performed successfully");
		    }
		    catch(Exception e)
		    {lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
		    e.printStackTrace();
		    driver.close();
		     Relogin rl=new Relogin();
		     rl.reLogin();
		     throw e;
		    }   
	 }

}
