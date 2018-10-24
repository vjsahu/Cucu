package com.zephyr.stepdefinition;





import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddingTags_809275 extends LaunchBrowser 
{
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	
	boolean[] actual=new boolean[7];
	SoftAssert soft=new SoftAssert();
	
	String fileName="AddingTags_809275";
	LaunchBrowser lb=new LaunchBrowser();
	@Given("^Tester is in the Phase of Test Repository Page$")
	public void tester_is_in_the_Phase_of_Test_Repository_Page() throws Throwable
	{
		
////		   lb=new LaunchBrowser();
////		   lb.preCond();
////		   
////		   lp=new LoginPage(driver);
////		   String Uname=Excel_Lib.getData(INPUT_PATH_1,"Login",3,0);
////		   String Pass=Excel_Lib.getData(INPUT_PATH_1,"Login",3,1);
////		   lp.enterUname(Uname);
////		   lp.enterPass(Pass);
////		   lp.clickOnLogin();
//		 
		try
		{
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_1,"Releases",1,0);
		   actual[0]=pp.selectProject(projectName);
		  actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]= rp.clickOnTestRep(); 
		   
		   tr=new TestRepositoryPage(driver);
			//String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		   tr.clickOnRelease(releaseName);
		   String Name=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",1, 0);
			String Desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",1, 0);	   
		   tr.addNode(Name, Desc);
		   tr.doubleClickOnRelease(releaseName);
			String[] phases=new String[1];
			phases[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_1,"Phases",1, 0);
			actual[3]=tr.navigateToNode(releaseName,phases);
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

	@When("^Tester click on Add button$")
	public void tester_click_on_Add_button() throws Throwable 
	{
		try
		{
	   // tr.addNewTestCase();
			actual[4]=tr.addTestCase();
			actual[5]=tr.clickDetailButton();
		Actions a3=new Actions(driver);
		  for(int i=1;i<=5;i++)
		  {
				a3.sendKeys(Keys.DOWN).perform();
		  }
		
		}
		catch(Exception e)
		{	lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^Enters Multiple Tags$")
	public void enters_Multiple_Tags() throws Throwable 
	{
		try
		{
	   ctc=new CreateTestCasePage(driver);
	   String[] tags=new String[32];
       int k=0;
       int row=1;
		for(int j=0;j<=tags.length-1;j++)
		{
			tags[k]=Excel_Lib.getData(INPUT_PATH_1, "Tags",row,0);
			k++;
			row++;
		}
		actual[6]=ctc.enterMultipleTags(tags);
		}
		catch(Exception e)
		{	lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
		

	   
	}

	@Then("^New Test Case Should be Added With Multiple Tags$")
	public void new_Test_Case_Should_be_Added_With_Multiple_Tags() throws Throwable 
	{
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		    {
		    	soft.assertEquals(actual[k], true);
		    }
	    	soft.assertAll();
			
		log.info("Test Case Successfully Added with Multiple Tags");
		
		tr.clickOnList();
		}
		catch(Exception e)
		{	lb.getScreenShot(fileName);
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	   
	}
}