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

public class FilterSubsystem_808819 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	boolean[] actual=new boolean[5];
	 SoftAssert soft=new SoftAssert();
	 String filename="FilterSubsystem_808819";
	@Given("^User in repository Page$")
	public void user_in_repository_Page() throws Throwable 
	{
		try
		{
//		lb= new LaunchBrowser();
//		lb.preCond();
//		
//		 lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH_4,"Login1",1,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH_4,"Login1",1,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		   
		   pp=new ProjectPage(driver);
		   //String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,1);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		}catch (Exception e) 
		{
			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^User click on Filter with Name$")
	public void user_click_on_Filter_with_Name() throws Throwable
	{
		try
		{
			tr=new TestRepositoryPage(driver);
			bp=new BasePage();
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,1);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 1);
			tr.addNode(phaseName, phaseDesc);
			bp.waitForElement();
//			tr.addTestCase();
////			 ctc=new CreateTestCasePage(driver);
//			   String testCaseName=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 0);
//			   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 1);
//			   ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
//			   bp.waitForElement();
			   
			   //String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
				tr.doubleClickOnRelease(releaseName);
				String[] phase=new String[1];
				//navigate to phase/////////////////////////////////////////////////////////////////////
				phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 0);
				tr.navigateToNode(releaseName, phase);
				bp.waitForElement();
				String systemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 2, 0);
				String systemDesc1=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 2, 1);
				tr.addNode(systemName, systemDesc1);
//				tr.addTestCase();
//				 String testCaseName1=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 2);
//				   String testCaseDesc1=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 3);
//				   ctc.enterTestCaseNameAndDesc(testCaseName1, testCaseDesc1);
//				   
				   tr.doubleClickOnRelease(releaseName);
				   String[] navigation=new String[2];
				   //navigate to system/////////////////////////////////////////////////////////////////////
				   navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 0);
				   navigation[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 2, 0);
				   tr.navigateToNode(releaseName, navigation);
				   bp.waitForElement();
					String subsystemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 3, 0);
					String subsystemDesc=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 3, 1);
					tr.addNode(subsystemName, subsystemDesc);
//					tr.addTestCase();
//					 String testCaseName2=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 4);
//					   String testCaseDesc2=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 5);
//					   ctc.enterTestCaseNameAndDesc(testCaseName2, testCaseDesc2);
					   bp.waitForElement();
					   
					   tr.doubleClickOnRelease(releaseName);
					   String[] navigationss=new String[3];
					   //navigate to subsystem////////////////////////////////////////////////////////////
					   navigationss[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 0);
					   navigationss[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 2, 0);
					   navigationss[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 3, 0);
					   tr.navigateToNode(releaseName, navigationss);
					   bp.waitForElement();
						String fourthName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 4, 0);
						String fourthDesc=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 4, 1);
						tr.addNode(fourthName, fourthDesc);
//						tr.addTestCase();
//						 String testCaseName3=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 6);
//						   String testCaseDesc3=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 7);
//						   ctc.enterTestCaseNameAndDesc(testCaseName3, testCaseDesc3);
						   bp.waitForElement();
						   
						   tr.doubleClickOnRelease(releaseName);
						   String[] navigation4=new String[4];
						   //navigate to fourth////////////////////////////////////////////////////////////
						   navigation4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 0);
						   navigation4[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 2, 0);
						   navigation4[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 3, 0);
						   navigation4[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 4, 0);
						   tr.navigateToNode(releaseName, navigation4);
						   bp.waitForElement();
							String fifthName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 5, 0);
							String fifthDesc=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 5, 1);
							tr.addNode(fifthName, fifthDesc);
//							tr.addTestCase();
//							 String testCaseName4=Excel_Lib.getData(INPUT_PATH_4, "AutomationPhases", 7, 8);
//							   String testCaseDesc4=Excel_Lib.getData(INPUT_PATH_4, "AutomationPhases", 7, 9);
//							   ctc.enterTestCaseNameAndDesc(testCaseName4, testCaseDesc4);
							   bp.waitForElement();
							   
							   tr.doubleClickOnRelease(releaseName);
							   String[] navigation5=new String[5];
							   //navigate to fifth////////////////////////////////////////////////////////////
							   navigation5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 0);
							   navigation5[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 2, 0);
							   navigation5[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 3, 0);
							   navigation5[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 4, 0);
							   navigation5[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 5, 0);
							   tr.navigateToNode(releaseName, navigation5);
							   bp.waitForElement();
								String sixthName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 6, 0);
								String sixthDesc=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 6, 1);
								tr.addNode(sixthName, sixthDesc);
//								tr.addTestCase();
//								 String testCaseName6=Excel_Lib.getData(INPUT_PATH_4, "AutomationPhases", 7, 10);
//								   String testCaseDesc6=Excel_Lib.getData(INPUT_PATH_4, "AutomationPhases", 7, 11);
//								   ctc.enterTestCaseNameAndDesc(testCaseName6, testCaseDesc6);
								   bp.waitForElement();
								   
								   tr.doubleClickOnRelease(releaseName);
								   String[] navigation6=new String[6];
								   //navigate to sixth////////////////////////////////////////////////////////////
								   navigation6[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 0);
								   navigation6[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 2, 0);
								   navigation6[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 3, 0);
								   navigation6[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 4, 0);
								   navigation6[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 5, 0);
								   navigation6[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 6, 0);
								   tr.navigateToNode(releaseName, navigation6);
								   bp.waitForElement();
									String seventhName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 7, 0);
									String seventhdesc=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 7, 1);
									tr.addNode(seventhName, seventhdesc);
//									tr.addTestCase();
//									 String testCaseName7=Excel_Lib.getData(INPUT_PATH_4, "AutomationPhases", 7, 12);
//									   String testCaseDesc7=Excel_Lib.getData(INPUT_PATH_4, "AutomationPhases", 7, 13);
//									   ctc.enterTestCaseNameAndDesc(testCaseName7, testCaseDesc7);
									   bp.waitForElement();
									   
									   tr.doubleClickOnRelease(releaseName);
									   String[] navigation7=new String[7];
									   //navigate to seventh////////////////////////////////////////////////////////////
									   navigation7[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 0);
									   navigation7[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 2, 0);
									   navigation7[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 3, 0);
									   navigation7[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 4, 0);
									   navigation7[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 5, 0);
									   navigation7[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 6, 0);
									   navigation7[6]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 7, 0);
									   tr.navigateToNode(releaseName, navigation7);
									   bp.waitForElement();
										String eightName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 8, 0);
										String eightdesc=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 8, 1);
										tr.addNode(eightName, eightdesc);
//										tr.addTestCase();
//										 String testCaseName8=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 14);
//										   String testCaseDesc8=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 15);
//										   ctc.enterTestCaseNameAndDesc(testCaseName8, testCaseDesc8);
										   bp.waitForElement();
			
		String fvalue=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases",8,0);
		//System.out.println(fvalue);
		tr=new TestRepositoryPage(driver);
		actual[3]=tr.enterFilterValue(fvalue);
		}catch (Exception e) 
		{
			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^Match with Selected Subsystem$")
	public void match_with_Selected_Subsystem() throws Throwable 
	{
		try
		{
		String fvalue=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases",8,0);
		actual[4]=tr.verifyFilteredNode(fvalue);
		}catch (Exception e)
		{
			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}

	@Then("^Should able to view the multiple sub system name$")
	public void should_able_to_view_the_multiple_sub_system_name() throws Throwable
	{
		try
		{
			log.info("sucessfully viewed multiple subsystem");
	  
			//	  pp=new ProjectPage(driver);
			//		pp.clickOnLogout();
			//		lb=new LaunchBrowser();
			//		lb.close();
		}catch (Exception e) 
		{
			lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
		    throw e;
		}
	}
}
