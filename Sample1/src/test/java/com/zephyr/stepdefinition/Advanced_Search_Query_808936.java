package com.zephyr.stepdefinition;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Advanced_Search_Query_808936 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	NavigationPage np;
	BasePage bp;
	String fileName="Advanced_Search_Querry_808936";
	
	boolean[] actual=new boolean[19];
	SoftAssert soft=new SoftAssert();
	@Given("^User is in the Page of TestRepository Page$")
	public void user_is_in_the_Page_of_TestRepository_Page() throws Throwable {
	 
		/*lb=new LaunchBrowser();
		   lb.preCond();
		   
		   lp=new LoginPage(driver);
		   String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LUname");
		  String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "LPass");
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();*/
		try
		{
		    bp=new BasePage();
			pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		   actual[0]= pp.selectProject(projectName);
		   actual[1]= pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep(); 
		   
		   tr=new TestRepositoryPage(driver);
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	
	@When("^User Creates a Phase,System and Subsystem and create testcases in all the nodes$")
	public void user_Creates_a_Phase_System_and_Subsystem_and_create_testcases_in_all_the_nodes() throws Throwable {
	    try
	    {
		String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "View", 2, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "View", 2, 3);
		
		
		actual[3]=tr.doubleClickOnRelease(releaseName);
		actual[4]=tr.addNode(p_Name1,p_Desc1);
		actual[5]=tr.addTestCase();
		actual[6]=tr.addTestCase();
		//tr.navigateToNode(releaseName, navigation);
		actual[7]=tr.doubleClickOnRelease(releaseName);
		
		String[] phase=new String[1];
		phase[0]=p_Name1;
		String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "View", 2, 1);
		String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "View", 2, 4);
		actual[8]=tr.navigateToNode(releaseName,phase );
		actual[9]=tr.addNode(s_Name1,s_Desc1);
		actual[10]=tr.addTestCase();
		actual[11]=tr.addTestCase();
		//tr.addTestCase();
		actual[12]=tr.doubleClickOnRelease(releaseName);
		
		String[] system= new String[2];
		system[0]=p_Name1;
		system[1]=s_Name1;
		
		String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "View", 2, 2);
		String ss_Desc1=Excel_Lib.getData(INPUT_PATH_3, "View", 2, 5);
		actual[13]=tr.navigateToNode(releaseName, system);
		actual[14]=tr.addNode(ss_Name1,ss_Desc1);
		bp.waitForElement();
		String[] subsystem=new String[3];
		subsystem[0]=p_Name1;
		subsystem[1]=s_Name1;
		subsystem[2]=ss_Name1;
		bp.waitForElement();
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		bp.waitForElement();
		tr.navigateToNode(releaseName, subsystem);
		bp.waitForElement();
		actual[15]=tr.addTestCase();
		actual[16]=tr.addTestCase();
	    }
	    catch(Exception e)
		{
	    	lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
	    	e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@When("^User navigates to Search View and selects a Advanced Search$")
	public void user_navigates_to_Search_View_and_selects_a_Advanced_Search() throws Throwable {
	   try
	   {
		for(int i=0;i<=3;i++)
		{
		String priority=Excel_Lib.getData(INPUT_PATH_3, "Testcases", 1, 7);
//		bp=new BasePage();
//		bp.waitForElement();
		np=new NavigationPage(driver);
		actual[17]=np.searchAndAdd(priority);
		bp.waitForElement();
		
		actual[18]=tr.previousSearchDropDown();
		bp.waitForElement();
		}
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
		   e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

	@Then("^Advanced Search is performed and present successfully in Prevoius Search drop down$")
	public void advanced_Search_is_performed_and_present_successfully_in_Prevoius_Search_drop_down() throws Throwable {
	 try
	 {
		 for(int k=0;k<=actual.length-1;k++)
	     {
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
		log.info("Advanced Search is performed and present successfully in Prevoius Search drop down");
		
		//String str=driver.findElement(By.xpath(".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[2]/div[1]/section/div/zui-zephyr-search/div/zui-zql-search/div/div[2]/div/select")).getText();
		String str=driver.findElement(By.xpath("//div/zui-zephyr-search/div/zui-zql-search/div/div[2]/div/select")).getText();
		System.out.println(str);
		bp.waitForElement();
		tr.clickOnFolder();
		bp.waitForElement();
	 }
	 catch(Exception e)
		{
		 lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
		 e.printStackTrace();
			driver.close();
	      	Relogin rl=new Relogin();
	      	rl.reLogin();
	      	throw e;
	   	 
		}
	}

}
