package com.zephyr.stepdefinition;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.pom.CreateTestCasePage_POM;
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

public class Sort_Estimated_Execution_Time_809315 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	
	boolean[] actual=new boolean[15];
	 SoftAssert soft=new SoftAssert();
	 String filename="Sort_Estimated_Execution_Time_809315";
	@Given("^User is in the page of TestRepository page$")
	public void user_is_in_the_page_of_TestRepository_page() throws Throwable {
	   
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
		  actual[0]= pp.selectProject(projectName);
		  actual[1]= pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		   }
		   catch(Exception e)
		   {lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
		   e.printStackTrace();
		   //driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		   }
	}

	@Given("^User Create a node$")
	public void user_Create_a_node() throws Throwable {
	 try{
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Search", 4, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Search", 4, 3);
		tr=new TestRepositoryPage(driver);
		bp=new BasePage();
		actual[3]=tr.doubleClickOnRelease(releaseName);
		actual[4]=tr.addNode(p_Name1,p_Desc1);
		String[] phase=new String[1];
		phase[0]=p_Name1;
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		tr.navigateToNode(releaseName, phase);
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

	@When("^User creates a ten test cases with estimated time$")
	public void user_creates_a_ten_test_cases_with_estimated_time() throws Throwable {
	 try
	 {
		 actual[5]=tr.addTestCase();
	String day1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 1,1 ));
	String hour1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 2,1 ));
	String min1=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 3,1 ));
	ctc=new CreateTestCasePage(driver);
	tr.clickDetailButton();
	bp=new BasePage();
	bp.waitForElement();
	ctc.enterEstimatedTime(day1, hour1, min1);
	bp.waitForElement();
	tr.clickOnListView.click();
	
	actual[6]=tr.addTestCase();
	String day2=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 1,2 ));
	String hour2=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 2,2 ));
	String min2=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 3,2 ));
	ctc=new CreateTestCasePage(driver);
	tr.clickDetailButton();
	bp=new BasePage();
	bp.waitForElement();
	ctc.enterEstimatedTime(day2, hour2, min2);
	bp.waitForElement();
	tr.clickOnListView.click();
	
	actual[7]=tr.addTestCase();
	String day3=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 1,4 ));
	String hour3=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 2,4 ));
	String min3=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 3,4 ));
	ctc=new CreateTestCasePage(driver);
	tr.clickDetailButton();
	bp=new BasePage();
	bp.waitForElement();
	ctc.enterEstimatedTime(day3, hour3, min3);
	bp.waitForElement();
	tr.clickOnListView.click();
	
	actual[8]=tr.addTestCase();
	String day4=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 1,3 ));
	String hour4=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 2,3 ));
	String min4=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 3,3 ));
	ctc=new CreateTestCasePage(driver);
	tr.clickDetailButton();
	bp=new BasePage();
	bp.waitForElement();
	ctc.enterEstimatedTime(day4, hour4, min4);
	bp.waitForElement();
	tr.clickOnListView.click();
	
	actual[9]=tr.addTestCase();
	String day5=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 1,6 ));
	String hour5=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 2,6 ));
	String min5=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 3,6 ));
	ctc=new CreateTestCasePage(driver);
	tr.clickDetailButton();
	bp=new BasePage();
	bp.waitForElement();
	ctc.enterEstimatedTime(day5, hour5, min5);
	bp.waitForElement();
	tr.clickOnListView.click();
	
	actual[10]=tr.addTestCase();
	String day6=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 1,5 ));
	String hour6=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 2,5 ));
	String min6=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 3,5 ));
	ctc=new CreateTestCasePage(driver);
	tr.clickDetailButton();
	bp=new BasePage();
	bp.waitForElement();
	ctc.enterEstimatedTime(day6, hour6, min6);
	bp.waitForElement();
	tr.clickOnListView.click();
	
	actual[11]=tr.addTestCase();
	String day7=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 1,7 ));
	String hour7=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 2,7 ));
	String min7=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 3,7 ));
	ctc=new CreateTestCasePage(driver);
	tr.clickDetailButton();
	bp=new BasePage();
	bp.waitForElement();
	ctc.enterEstimatedTime(day7, hour7, min7);
	bp.waitForElement();
	tr.clickOnListView.click();
	
	actual[12]=tr.addTestCase();
	String day8=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 1,8 ));
	String hour8=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 2,8 ));
	String min8=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 3,8 ));
	ctc=new CreateTestCasePage(driver);
	tr.clickDetailButton();
	bp=new BasePage();
	bp.waitForElement();
	ctc.enterEstimatedTime(day8, hour8, min8);
	bp.waitForElement();
	tr.clickOnListView.click();
	
	actual[13]=tr.addTestCase();
	String day9=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 1,10 ));
	String hour9=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 2,10 ));
	String min9=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 3,10 ));
	ctc=new CreateTestCasePage(driver);
	tr.clickDetailButton();
	bp=new BasePage();
	bp.waitForElement();
	ctc.enterEstimatedTime(day9, hour9, min9);
	bp.waitForElement();
	tr.clickOnListView.click();
																																																																																																																																																																																																																																																																																																																									
	actual[14]=tr.addTestCase();
	String day10=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 1,9 ));
	String hour10=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 2,9 ));
	String min10=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "ExecutionTime", 3,9 ));
	ctc=new CreateTestCasePage(driver);
	tr.clickDetailButton();
	bp=new BasePage();
	bp.waitForElement();
	ctc.enterEstimatedTime(day10, hour10, min10);
	bp.waitForElement();
	tr.clickOnList();
	//tr.clickOnListView.click();
	 }
	 catch(Exception e)
	 {lb=new LaunchBrowser();
	   lb.getScreenShot(filename);
	 e.printStackTrace();
	 //driver.close();
	  Relogin rl=new Relogin();
	  rl.reLogin();
	 }
	}

	@When("^User sorts the estimated time in ascending order$")
	public void user_sorts_the_estimated_time_in_ascending_order() throws Throwable {
	 try
	 {
		 ctc=new CreateTestCasePage(driver);
		 bp=new BasePage();
		 bp.waitForElement();
		 String[] sortName=new String[1];
		 sortName[0]="Estimated Time";
		 tr.sortingTestCase(sortName);
		 
		 bp.waitForElement();
		 CreateTestCasePage_POM s1=new CreateTestCasePage_POM(driver);
		// bp.waitForElement();
		 //bp.waitForElement();
		 WebElement ele=s1.EstimatedTimeIcon;
		 WebDriverWait wait1=new WebDriverWait(driver, 100);
			wait1.until(ExpectedConditions.elementToBeClickable(ele));
		 ele.click();
		// bp.waitForElement();
		 //bp.waitForElement();
		 WebElement ele1=s1.sortEstimatedIcon;
		 WebDriverWait wait2=new WebDriverWait(driver, 100);
			wait2.until(ExpectedConditions.elementToBeClickable(ele1));
		 ele1.click();
		//ctc.sortEstimatedIcon.click();
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

	@Then("^User sorts the test cases successfully$")
	public void user_sorts_the_test_cases_successfully() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
	  log.info("User sorts the test cases successfully");
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
