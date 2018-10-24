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

public class FindAndAdd_DetailView_809375 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	
	boolean[] actual=new boolean[8];
	SoftAssert soft=new SoftAssert();
	String fileName="FindAndAdd_DetailView_809375";
	
	@Given("^User is in TestRepositorypage$")
	public void user_is_in_TestRepositorypage() throws Throwable 
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
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep(); 
		   Thread.sleep(3000);
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

	@When("^User Navigates to release$")
	public void user_Navigates_to_release() throws Throwable
	{
		try
		{
		tr=new TestRepositoryPage(driver);
		actual[3]=tr.clickDetailButton();
		bp.waitForElement();
		tr.moveToNodesInDetail();
		//Thread.sleep(3000);
//	    Actions act=new Actions(driver);
//	    WebElement DetailRelease=driver.findElement(By.xpath("//*[@id='tcr-h-resizer']/section/div"));
//	    act.moveToElement(DetailRelease).perform();
//	    Thread.sleep(3000);
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

	@When("^User Clicks on View and move to Sub-Folder Level$")
	public void user_Clicks_on_View_and_move_to_Sub_Folder_Level() throws Throwable 
	{
		try
		{
		tr=new TestRepositoryPage(driver);
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		actual[4]=tr.doubleClickOnRelease(releaseName);
		//tr.moveToNodesInDetail();
		String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 0);
		String Desc=Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 1);
		actual[5]=tr.addNode(Name, Desc);
		
		tr.moveToNodesInDetail();
		
		actual[6]=tr.doubleClickOnRelease(releaseName);
		//tr.moveToNodesInDetail();
		String add[]=new String[1];
		add[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH, "Create_10th_level", 1, 0);
		actual[7]=tr.navigateToNode(releaseName, add);
		bp.waitForElement();
		tr.moveToNodesInDetail();
		tr.selectPhase(Name);
		
		//tr.moveToNodesInDetail();
		//tr.selectPhase(Name);
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

	@When("^User Performs FindAndAdd Operation using ZQL$")
	public void user_Performs_FindAndAdd_Operation_using_ZQL() throws Throwable
	{
		try
		{
		String[] operator=new String[1];
		String[] symbol=new String[1];
		String[] value=new String[1];
		operator[0]=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 0);
		symbol[0]=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 1);
		value[0]=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 2);
		String colName=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 3);
		int colNum=Excel_Lib.getNumberData(INPUT_PATH, "FindAndAdd", 1, 4);
		String role=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 5);
		String selectCount=Excel_Lib.getData(INPUT_PATH, "FindAndAdd", 1, 6);
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

	@Then("^Testcases should be added successfully In Detail View$")
	public void testcases_should_be_added_successfully_In_Detail_View() throws Throwable 
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		    {
		    	soft.assertEquals(actual[k], true);
		    }
	    	soft.assertAll();
	    log.info("Pass - TestCases are added successfully in Detail View");
	    
	    tr.clickOnList();
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
