package com.zephyr.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class Edit_copyTo_Phase_S_Ss_803030 extends LaunchBrowser
{
	
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	ImportPage ip;
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Edit_copyTo_Phase_S_Ss_803030";
	
	boolean[] actual=new boolean[6];
	 SoftAssert soft=new SoftAssert();
	@Given("^User in Repository page$")
	public void user_in_Repository_page() throws Throwable 
	{
		try
		{
		pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,1);
		   actual[0]=pp.selectProject(projectName);
		   bp=new BasePage();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[1]=pp.selectRelease(releaseName);
		   bp.waitForElement();
		   bp.waitForElement();
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		   bp.waitForElement();
		}
		catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^Create phase/s/ss and select imported node$")
	public void create_phase_s_ss_and_select_imported_node() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
	    String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
	    actual[3]=tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();
	    //Creating Phase
	    String pName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",7,0);
	    String pDesc=Excel_Lib.getData(INPUT_PATH_4,"Phase",7,1);
	    tr.addNode(pName, pDesc);
	    bp.waitForElement();
	    tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();
	  //Navigating to Phase
	    String[] phase=new String[1];
	    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",7,0);
	    tr.navigateToNode(releaseName, phase); 
	    bp.waitForElement();
	    //add system
	    String sName=Excel_Lib.getData(INPUT_PATH_4,"Phase",8,0);
	    String sDesc=Excel_Lib.getData(INPUT_PATH_4,"Phase",8,1);
	    tr.addNode(sName, sDesc);
	    bp.waitForElement();
	    tr.doubleClickOnRelease(releaseName);
	    //bp=new BasePage();
	    bp.waitForElement();
	    //Navigating to System
	    String[] phase1=new String[2];
	    phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",7,0);
	    phase1[1]=Excel_Lib.getData(INPUT_PATH_4,"Phase",8,0);
	    actual[4]= tr.navigateToNode(releaseName, phase1);
	    //add subsystem
	    String ssName=Excel_Lib.getData(INPUT_PATH_4,"Phase",9,0);
	    String ssDesc=Excel_Lib.getData(INPUT_PATH_4,"Phase",9,1);
	    tr.addNode(ssName, ssDesc);
	    bp.waitForElement();
	    
	    String[] phase2=new String[3];
	    phase2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",7,0);
	    phase2[1]=Excel_Lib.getData(INPUT_PATH_4,"Phase",8,0);
	    phase2[2]=Excel_Lib.getData(INPUT_PATH_4,"Phase",9,0);
	    actual[4]= tr.navigateToNode(releaseName, phase2);
	    bp.waitForElement();
		}
		catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}
	@When("^navigate to phase and copy testcases$")
	public void navigate_to_phase_and_copy_testcases() throws Throwable
	{
		try
		{
	    
		String file=Excel_Lib.getData(INPUT_PATH_4, "Importedfilenames", 3, 0);
		ip=new ImportPage(driver);
		ip.selectImportFile1(file);


		for(int i=1;i<=5;i++)
		{
		tr.addTestCase();
		}
		
		bp.waitForElement();
	    //select testcases
	    String[] selectTC=new String[2];
		selectTC[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",1,0));
		selectTC[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",2,0));
	    //selectTC[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",3,0));	
		//selectTC[3]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",4,0));
		ep=new ExportPage(driver);
		bp.waitForElement();
		ep.selectMultipleTestCaseFromGrid(selectTC);
		bp.waitForElement();
		//src 
		
		
		
		
		String source1="(//div[@class='grid-column-div'])[4]";
		WebElement src1=driver.findElement(By.xpath(source1));
		//destn phase
//		String dstn1="(//a[@class='jstree-anchor  zee-tcr-anchor'])[2]";
//		WebElement destn1=driver.findElement(By.xpath(dstn1));
		 bp.waitForElement();
		 String destNode=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",7,0);
		 tr.copyTestCase(src1, destNode);
//		 Actions act=new Actions(driver);
//		// act.dragAndDrop(source1, target1).perform();o
//		 act.sendKeys(Keys.CONTROL).dragAndDrop(src1, destn1).perform();
		 bp.waitForElement();
		 bp.waitForElement();
		 
	
		}
		catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^navigate to system and copy$")
	public void navigate_to_system_and_copy() throws Throwable 
	{
		try
		{
			   ////select testcases
			    String[] selectTC1=new String[2];
				selectTC1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",1,0));
				selectTC1[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",2,0));
			    //selectTC1[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",3,0));	
				//selectTC[3]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",4,0));
				ep=new ExportPage(driver);
				ep.selectMultipleTestCaseFromGrid(selectTC1);
				bp.waitForElement();
				//src
				String source2="(//div[@class='grid-column-div'])[4]";
				WebElement src2=driver.findElement(By.xpath(source2));
				bp.waitForElement();
				 //destn system
//				String dstnation2="(//a[@class='jstree-anchor  zee-tcr-anchor'])[3]";
//				WebElement destn2=driver.findElement(By.xpath(dstnation2));
				 bp.waitForElement();
				 
				 
				 
				 bp.waitForElement();
				 String destNode=Excel_Lib.getData(INPUT_PATH_4,"Phase",8,0);
				 tr.copyTestCase(src2, destNode);
				 
//				 Actions act1=new Actions(driver);
//				// act.dragAndDrop(source1, target1).perform();o
//				 act1.sendKeys(Keys.CONTROL).dragAndDrop(src2, destn2).perform();
				 bp.waitForElement();
				 bp.waitForElement();
		}
		catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^navigate to subsystem and copy$")
	public void navigate_to_subsystem_and_copy() throws Throwable 
	{
		try
		{
		 ///select testcases
		 String[] selectTC2=new String[2];
			selectTC2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",1,0));
			selectTC2[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",2,0));
		   // selectTC2[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",3,0));	
			//selectTC[3]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",4,0));
			ep=new ExportPage(driver);
			actual[5]=ep.selectMultipleTestCaseFromGrid(selectTC2);
			bp.waitForElement();
			//src
			String source3="(//div[@class='grid-column-div'])[4]";
			WebElement src3=driver.findElement(By.xpath(source3));
			bp.waitForElement();
//			//dstn subsystem
//			String dstnation3="(//a[@class='jstree-anchor  zee-tcr-anchor'])[4]";
//			WebElement destn3=driver.findElement(By.xpath(dstnation3));
			 bp.waitForElement();
			 
			 
			 
			 bp.waitForElement();
			 String destNode=Excel_Lib.getData(INPUT_PATH_4,"Phase",9,0);
			 tr.copyTestCase(src3, destNode);
			 
//			 Actions act2=new Actions(driver);
//			// act.dragAndDrop(source1, target1).perform();
//			 act2.sendKeys(Keys.CONTROL).dragAndDrop(src3, destn3).perform();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
//			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
//			 tr.doubleClickOnRelease(releaseName);
//			 bp.waitForElement();
			 bp.waitForElement();
			 
			 Actions act=new Actions(driver);
			    act.doubleClick(ip.Imported).perform();
			    bp.waitForElement();
			    bp.waitForElement();
		}
		catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@Then("^should be copy in all phases$")
	public void should_be_copy_in_all_phases() throws Throwable
	{
	    try
	    {
	    	for(int k=0;k<=actual.length-1;k++)
	        {
	         soft.assertEquals(actual[k], true);
	        }
	        soft.assertAll();
	        log.info("copied tescases sucessfully");
	    }
		catch (Exception e) 
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
