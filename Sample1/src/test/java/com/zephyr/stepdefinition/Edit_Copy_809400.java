package com.zephyr.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class Edit_Copy_809400 extends LaunchBrowser
{
	LaunchBrowser lb=new LaunchBrowser();
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExportPage ep;
	
	String fileName="Edit_Copy_809400";
	
	boolean[] actual=new boolean[16];
	 SoftAssert soft=new SoftAssert();
	@Given("^user in repository page$")
	public void user_in_repository_page() throws Throwable 
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

	@When("^user creates phase system and subsystem$")
	public void user_creates_phase_system_and_subsystem() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
	    String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
	    actual[3]=tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();
	    //Creating Phase
	    String pName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",1,0);
	    String pDesc=Excel_Lib.getData(INPUT_PATH_4,"Phase",1,1);
	    actual[4]=tr.addNode(pName, pDesc);
	    bp.waitForElement();
	    actual[5]=tr.doubleClickOnRelease(releaseName);	    
	    bp.waitForElement();
	    //tr.doubleClickOnRelease(releaseName);
	  //Navigating to Phase
	    String[] phase=new String[1];
	    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",1,0);
	    actual[6]=tr.navigateToNode(releaseName, phase); 
	    bp.waitForElement();
	    //add system
	    String sName=Excel_Lib.getData(INPUT_PATH_4,"Phase",2,0);
	    String sDesc=Excel_Lib.getData(INPUT_PATH_4,"Phase",2,1);
	    actual[7]=tr.addNode(sName, sDesc);
	    bp.waitForElement();
	    actual[8]=tr.doubleClickOnRelease(releaseName);
	    //bp=new BasePage();
	    bp.waitForElement();
	    //Navigating to System
	    String[] phase1=new String[2];
	    phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",1,0);
	    phase1[1]=Excel_Lib.getData(INPUT_PATH_4,"Phase",2,0);
	    actual[9]=tr.navigateToNode(releaseName, phase1);
	    bp.waitForElement();
	    //add subsystem
	    String ssName=Excel_Lib.getData(INPUT_PATH_4,"Phase",3,0);
	    String ssDesc=Excel_Lib.getData(INPUT_PATH_4,"Phase",3,1);
	    actual[10]=tr.addNode(ssName, ssDesc);
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

	@When("^Add ten testcases to phase$")
	public void add_ten_testcases_to_phase() throws Throwable 
	{
		try
		{
		 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
		 tr=new TestRepositoryPage(driver);
		 actual[11]=tr.doubleClickOnRelease(releaseName);  
		bp=new BasePage();
		bp.waitForElement();
		  //Navigating to Phase
		    String[] phase=new String[1];
		    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",1,0);
		    actual[12]=tr.navigateToNode(releaseName, phase); 
		   bp.waitForElement();
		    for(int i=0;i<10;i++)
		    {
		    	tr.addTestCase();
			    //bp.waitForElement();
		    }
		    bp.waitForElement();
		    actual[13]=tr.doubleClickOnRelease(releaseName); 
		    bp.waitForElement(); 
		  //Navigating to subSystem
		    String[] phase1=new String[3];
		    phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",1,0);
		    phase1[1]=Excel_Lib.getData(INPUT_PATH_4,"Phase",2,0);
		    phase1[2]=Excel_Lib.getData(INPUT_PATH_4,"Phase",3,0);
		    actual[14]=tr.navigateToNode(releaseName, phase1);
		    bp.waitForElement();
		   
		    tr.selectPhase(phase1[0]);
		   // tr.clickOnPhaseToDrag.click();
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

	@When("^copy three testcases to system$")
	public void copy_three_testcases_to_system() throws Throwable 
	{
		try
		{
		//moving testcases
		bp=new BasePage();
		 bp.waitForElement();
		tr=new TestRepositoryPage(driver);
		String[] selectTC=new String[3];
		selectTC[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",1,0));
		selectTC[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",2,0));
	    selectTC[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",3,0));	
		//selectTC[3]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",4,0));
		ep=new ExportPage(driver);
		actual[15]=ep.selectMultipleTestCaseFromGrid(selectTC);
		//System.out.println(selectTC);
		 bp.waitForElement();
		 bp.waitForElement();
		 //click on tc
		 String clickOnTc="//*[@id='grid-table-tcr']/div[2]/div[2]/div[4]";
		WebElement source=driver.findElement(By.xpath(clickOnTc));
		 bp.waitForElement();
		 //target folder
		String ClickOnSubSystem="//a[text()='move1']";
		WebElement target=driver.findElement(By.xpath(ClickOnSubSystem));
		 bp.waitForElement();
		Actions act=new Actions(driver);
		act.sendKeys(Keys.CONTROL).dragAndDrop(source, target).perform();
		
		
		//act.dragAndDrop(source, target);
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

	@When("^move three testcases to subsystem$")
	public void move_three_testcases_to_subsystem() throws Throwable 
	{
		try
		{
		 //copying test case
		bp=new BasePage();
	 	bp.waitForElement();
	 	String[] phase=new String[1];
	 	String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Releases", 1,0);
	 	phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",1,0);
	    actual[12]=tr.navigateToNode(releaseName, phase); 
		String[] phase1=new String[3];
	    phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"Phase",1,0);
	    phase1[1]=Excel_Lib.getData(INPUT_PATH_4,"Phase",2,0);
	    phase1[2]=Excel_Lib.getData(INPUT_PATH_4,"Phase",3,0);
	    actual[14]=tr.navigateToNode(releaseName, phase1);
	    bp.waitForElement();
	    tr.selectPhase(phase1[0]);
	    
		tr=new TestRepositoryPage(driver);
		String[] selectTC1=new String[3];
		selectTC1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",1,0));
		selectTC1[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",2,0));
		selectTC1[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"TestcaseNames",3,0));
		ep=new ExportPage(driver);
		ep.selectMultipleTestCaseFromGrid(selectTC1);
		System.out.println(selectTC1);
		bp.waitForElement();
		 bp.waitForElement();
		 //click on tc
		 String clickOnTc="//*[@id='grid-table-tcr']/div[2]/div[2]/div[4]";
		 WebElement source1=driver.findElement(By.xpath(clickOnTc));
		 bp.waitForElement();
		 
		 //target folder
		 String ClickOnSs="//a[text()='move2']";
			WebElement target1=driver.findElement(By.xpath(ClickOnSs));
			 bp.waitForElement();
			 Actions act=new Actions(driver);
			// act.dragAndDrop(source1, target1).perform();o
			 
			 act.dragAndDrop(source1, target1).perform();
			 bp.waitForElement();
			 bp.waitForElement();
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

	@Then("^Should be able to move/copy multiple testcases$")
	public void should_be_able_to_move_copy_multiple_testcases() throws Throwable 
	{
		try
		{
			String phase="move1";
			tr.selectPhase(phase);
//		String ClickOnSubSystem="//a[text()='move1']";
//		WebElement target=driver.findElement(By.xpath(ClickOnSubSystem));
//		target.click();
		bp=new BasePage();
		bp.waitForElement();
		bp.waitForElement();
		tr=new TestRepositoryPage(driver);
		int tc=tr.testCaseCount();
		bp.waitForElement();
		bp.waitForElement();
		System.out.println(tc);
		if(tc==3)
		{
			log.info("testcase copied sucessfully");
		}
		else
		{
			log.info("operation failed");
		}
		
		String phase2="move2";
		tr.selectPhase(phase2);
//		 String ClickOnSs="//a[text()='move2']";
//		WebElement target1=driver.findElement(By.xpath(ClickOnSs));
//		target1.click();
		bp.waitForElement();
		bp.waitForElement();
		int tc1=tr.testCaseCount();
	
		bp.waitForElement();
		bp.waitForElement();
		System.out.println(tc1);
		if(tc1==3)
		{
			log.info("testcase moved sucessfully");
		}
		else
		{
			log.info("operation failed");
		}
		
		 driver.close();
		for(int k=0;k<=actual.length-1;k++)
	     {
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
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
