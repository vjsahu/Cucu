package com.zephyr.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CopyFromProjects;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CopyFromProjects_808587 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CopyFromProjects cfp;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="CopyFromProjects_808587";
   boolean[] actual=new boolean[16];
	
	SoftAssert soft=new SoftAssert();


@Given("^Tester is in the test repository page of release one$")
public void tester_is_in_the_test_repository_page_of_release_one() throws Throwable {

	try
	{

//		lb=new LaunchBrowser();
//	   lb.preCond();
//	   lp=new LoginPage(driver);
//	   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",3,0);
//	   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",3,1);
//	   lp.enterUname(Uname);
//	   lp.enterPass(Pass);
//	   lp.clickOnLogin();
	
	   pp=new ProjectPage(driver);
	   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
	   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
	   actual[0]=pp.selectProject(projectName);
	   actual[1]=pp.selectRelease(releaseName);
	   
	   rp= new ReleasePage(driver);
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

@When("^User select copy from other other project option from release context menu$")
public void user_select_copy_from_other_other_project_option_from_release_context_menu() throws Throwable
{
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"Common",1,1);
	tr=new TestRepositoryPage(driver);
	actual[3]=tr.doubleClickOnRelease(releaseName);
	actual[4]=tr.clickOnCopyFromProjects();
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

@Then("^Copy from other project page should be displayed$")
public void copy_from_other_project_page_should_be_displayed() throws Throwable {
	
	try
	{
	cfp=new CopyFromProjects(driver);
	actual[5]=cfp.verifyCopyFromProjectPage();
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

@When("^User select same project from Global Area and select release two$")
public void user_select_same_project_from_Global_Area_and_select_release_two() throws Throwable
{
	try
	{
   String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
	actual[6]=cfp.selectProjectFromGlobalArea(project);
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
@When("^navigate to phase containing test cases$")
public void navigate_to_phase_containing_test_cases() throws Throwable {
	
	try
{
		String release=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 1);
	//String releaseDesc=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 2);
    String[] a=new String[1];
    a[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 1, 3);
    actual[7]=cfp.selectNodeFromGlobalArea(release, a);
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


    

@Then("^test case should be displayed$")
public void test_case_should_be_displayed() throws Throwable 
{
	try
	{
	actual[8]= cfp.testCaseCountInCopyfromProjectReleases();
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

@When("^User expand the current project and select release one naviagate to subsystem$")
public void user_expand_the_current_project_and_select_release_one_naviagate_to_subsystem() throws Throwable
{
	 
	try
	{
	String release1=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop", 1, 1);
		String[] phase=new String[3];
	    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 3);
	    phase[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 4);
	    phase[2]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 5);
	    actual[9]=cfp.selectingNodeFromLocalArea(release1, phase);
	    
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

@When("^drag and drop the two test case from Global phase to current subsystem$")
public void drag_and_drop_the_two_test_case_from_Global_phase_to_current_subsystem() throws Throwable {
	
	try
	{
		bp=new BasePage();
	String[] c=new String[2];
    c[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "DragAndDrop", 1, 6));
    c[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "DragAndDrop", 2, 6));
    
    actual[10]=cfp.selectMultipleTestCaseFromGlobalNode(c);
    WebElement ele=driver.findElement(By.xpath("(//*[@title='Untitled'])[1]"));
    String phase=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2,5 );
    //c[2]="3";
    actual[11]=cfp.dragAndDropTestCase(ele,phase);
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

@Then("^test case should be copied to current subsystem$")
public void test_case_should_be_copied_to_current_subsystem() throws Throwable {
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_2,"DragAndDrop",1,1); 
	 String[] phase=new String[3];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 3);
		phase[1]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 4);
		phase[2]=Excel_Lib.getData(INPUT_PATH_2, "DragAndDrop", 2, 5);
	 actual[12]=cfp.closeCopyFromProjectReleasesPage();
	 bp=new BasePage();
	 bp.waitForElement();
	 bp.waitForElement();
	 
	 actual[13]=tr.doubleClickOnRelease(releaseName);
	 bp.waitForElement();
	
	actual[14]=tr.navigateToNode1(releaseName, phase);
	
	actual[15]=tr.verifyPresentTestCase();
	for(int k=0;k<=actual.length-1;k++)
    {
    	//System.out.println(actual[k]);
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



