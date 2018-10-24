package com.zephyr.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CopyFromProjects;
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

public class Edit_Import_Global_808698 extends LaunchBrowser 
{
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	ImportPage ip;
	CopyFromProjects cp;
	
	LaunchBrowser lb=new LaunchBrowser();
    String fileName="Edit_Import_Global_808698";
	
	
	boolean[] actual=new boolean[9];
	 SoftAssert soft=new SoftAssert();
	@Given("^User in repository page$")
	public void user_in_repository_page() throws Throwable 
	{
		try
		{
			bp=new BasePage();
		    pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		   bp.waitForElement();
		}catch (Exception e) 
		{  lb.getScreenShot(fileName);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^select the copy from release option$")
	public void select_the_copy_from_release_option() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
	    String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
	    actual[3]=tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();
	    tr.options.click();
	    //bp.waitForElement();
	    tr.copyReleaseOption.click();
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

	@When("^click on release and imported$")
	public void click_on_release_and_imported() throws Throwable 
	{
		try
		{
		 bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
		    cp=new CopyFromProjects(driver);
		    String[] impnod=new String[1];
		    impnod[0]=Excel_Lib.getData(INPUT_PATH_4, "Importedfilenames", 5, 0);
		    //str1[0]="allFields.xls Aug:10:2017::09:17:11";
		    cp.selectNodeFromImportedArea(impnod);
			 String releaseName1=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
			 String[] str=new String[1];
			 str[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",13,1);
			// System.out.println(str);
			 actual[4]=cp.selectingNodeFromLocalArea(releaseName1, str);
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

	@When("^Drag and drop from global to local$")
	public void drag_and_drop_from_global_to_local() throws Throwable 
	{
		try
		{
		String src=Excel_Lib.getData(INPUT_PATH_4, "Importedfilenames", 5, 0);
		String dstn=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase", 13, 1);
		actual[5]=cp.dragAndDropImportedNodes(src, dstn);
		 bp.waitForElement();
		    bp.waitForElement();
		    //close the page
		    actual[6]=cp.closeCopyFromProjectReleasesPage();
		    bp.waitForElement();
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

	@Then("^Should be able to copy imported node$")
	public void should_be_able_to_copy_imported_node() throws Throwable 
	{
		try
		{
			bp=new BasePage();
		 // navigating to node
	    String[] navigation=new String[1];
	    navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase", 13, 1);
	   // navigation[1]=Excel_Lib.getData(INPUT_PATH_4, "Importedfilenames", 5, 0);
	    String releaseName1=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
	    actual[7]=tr.doubleClickOnRelease(releaseName1);
	    //actual[7]=bp.waitForElement();
	    bp.waitForElement();
	    String fileName=Excel_Lib.getData(INPUT_PATH_4, "Importedfilenames", 5, 0);
	    //ip=new ImportPage(driver);
	   
	     tr.navigateToNode(releaseName1, navigation);
	     actual[8]=cp.validateCopiedFile(fileName);
	    
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
		}
	}
}
