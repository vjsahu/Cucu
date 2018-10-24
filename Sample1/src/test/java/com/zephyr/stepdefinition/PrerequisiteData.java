package com.zephyr.stepdefinition;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PrerequisiteData extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	RequirementsPage req;
	String filename="PrerequisiteData";
	@Given("^create testcases and edit$")
	public void create_testcases_and_edit() throws Throwable 
	{
		try
		{
		 pp=new ProjectPage(driver);
		  // String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"projects1",1,1);
		   pp.selectProject(projectName);
		   bp=new BasePage();
		   bp.waitForElement();
		   pp.selectRelease(releaseName);
		   bp.waitForElement();
		   rp= new ReleasePage(driver);
		   rp.clickOnTestRep();
			bp.waitForElement();
		   tr=new TestRepositoryPage(driver);
		   tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			String node=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "AutomationPhases", 1, 2);
			String desc=Excel_Lib.getData(INPUT_PATH_4, "AutomationPhases", 1, 3);
//			String p_Name2=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 2, 0);
//			String Desc2=Excel_Lib.getData(INPUT_PATH, "Create_P_S_SS", 2, 1);
			tr.addNode(node,desc);
			bp.waitForElement();
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			String phasename1[]=new String[1];
			phasename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 2);
			tr.navigateToNode(releaseName, phasename1);
			bp.waitForElement();
			for(int i=0;i<10;i++)
			{
				tr.addTestCase();
			}
			bp.waitForElement();
			bp.waitForElement();
			for(int j=0;j<5;j++)
			{
				bp.waitForElement();
			   tr.selectallTestCase();
				bp.waitForElement();
				tr.cloneTestCase();
			}
			//tr.selectallTestCase();
			bp.waitForElement();
			String names[]=new String[5];
			names[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0));
			names[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0));
			names[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0));
			names[3]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0));
			names[4]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 5, 0));
			ep=new ExportPage(driver);
			ep.selectMultipleTestCaseFromGrid(names);
			bp.waitForElement();
			ctc=new CreateTestCasePage(driver);
			tr.editTestCase();
			bp.waitForElement();
			String detailField[]=new String[3];
			detailField[0]=Excel_Lib.getData(INPUT_PATH_4, "detailField", 1, 0);
			detailField[1]=Excel_Lib.getData(INPUT_PATH_4, "detailField", 1, 1);
			detailField[2]=Excel_Lib.getData(INPUT_PATH_4, "detailField", 1, 2);
			String automationField[]=new String[4];
			automationField[0]=Excel_Lib.getData(INPUT_PATH_4, "automationfield", 1, 3);
			automationField[1]=Excel_Lib.getData(INPUT_PATH_4, "automationfield", 1, 0);
			automationField[2]=Excel_Lib.getData(INPUT_PATH_4, "automationfield", 1, 1);
			automationField[3]=Excel_Lib.getData(INPUT_PATH_4, "automationfield", 1, 2);
			ctc.editMultipleTestCase(detailField, automationField);
			bp.waitForElement();
			ctc.saveMultipleTestCaseEdit();
			bp.waitForElement();
		
		 }catch (Exception e) 
		   {lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			   e.printStackTrace();
			    driver.close();
			    Relogin rl=new Relogin();
			    rl.reLogin();
		}
//		
//			String names1[]=new String[1];
//			names1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0));
//			tr.selectTestCase(names1);
//			bp.waitForElement();
//			String testCaseName=Excel_Lib.getData(INPUT_PATH_4, "testcasenameAndDesc", 1, 0);
//			String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "testcasenameAndDesc", 1, 1);
//			ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
//			bp.waitForElement();
//			String testcasedetail[]=new String[3];
//			testcasedetail[0]=Excel_Lib.getData(INPUT_PATH_4, "priority", 1, 0);
//			testcasedetail[1]=Excel_Lib.getData(INPUT_PATH_4, "testcasenameAndDesc", 1,0);
//			testcasedetail[2]=Excel_Lib.getData(INPUT_PATH_4, "testcasenameAndDesc", 1, 0);
//			ctc.enterTestCaseDetail(testcasedetail);
//			bp.waitForElement();
//			String script_Name=Excel_Lib.getData(INPUT_PATH_4, "testcasenameAndDesc", 1, 0);
//			String script_Id=Excel_Lib.getData(INPUT_PATH_4, "testcasenameAndDesc", 2,0);
//			String script_Path=Excel_Lib.getData(INPUT_PATH_4, "testcasenameAndDesc", 3,0);
//			ctc.enterAutomationScriptField(script_Name, script_Id, script_Path);
//			bp.waitForElement();
	}

	@Given("^create phases upto Eighth level$")
	public void create_phases_upto_Eighth_level() throws Throwable 
	{
//		String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,1);
//		tr.doubleClickOnRelease(releaseName);
//		bp.waitForElement();
//		String phaseName=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 0);
//		String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 1);
//		tr.addNode(phaseName, phaseDesc);
//		bp.waitForElement();
////		tr.addTestCase();
//////		 ctc=new CreateTestCasePage(driver);
////		   String testCaseName=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 0);
////		   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 1);
////		   ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
////		   bp.waitForElement();
//		   
//		   //String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
//			tr.doubleClickOnRelease(releaseName);
//			String[] phase=new String[1];
//			//navigate to phase/////////////////////////////////////////////////////////////////////
//			phase[0]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 0);
//			tr.navigateToNode(releaseName, phase);
//			bp.waitForElement();
//			String systemName=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 2, 0);
//			String systemDesc1=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 2, 1);
//			tr.addNode(systemName, systemDesc1);
////			tr.addTestCase();
////			 String testCaseName1=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 2);
////			   String testCaseDesc1=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 3);
////			   ctc.enterTestCaseNameAndDesc(testCaseName1, testCaseDesc1);
////			   
//			   tr.doubleClickOnRelease(releaseName);
//			   String[] navigation=new String[2];
//			   //navigate to system/////////////////////////////////////////////////////////////////////
//			   navigation[0]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 0);
//			   navigation[1]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 2, 0);
//			   tr.navigateToNode(releaseName, navigation);
//			   bp.waitForElement();
//				String subsystemName=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 3, 0);
//				String subsystemDesc=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 3, 1);
//				tr.addNode(subsystemName, subsystemDesc);
////				tr.addTestCase();
////				 String testCaseName2=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 4);
////				   String testCaseDesc2=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 5);
////				   ctc.enterTestCaseNameAndDesc(testCaseName2, testCaseDesc2);
//				   bp.waitForElement();
//				   
//				   tr.doubleClickOnRelease(releaseName);
//				   String[] navigationss=new String[3];
//				   //navigate to subsystem////////////////////////////////////////////////////////////
//				   navigationss[0]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 0);
//				   navigationss[1]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 2, 0);
//				   navigationss[2]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 3, 0);
//				   tr.navigateToNode(releaseName, navigationss);
//				   bp.waitForElement();
//					String fourthName=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 4, 0);
//					String fourthDesc=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 4, 1);
//					tr.addNode(fourthName, fourthDesc);
////					tr.addTestCase();
////					 String testCaseName3=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 6);
////					   String testCaseDesc3=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 7);
////					   ctc.enterTestCaseNameAndDesc(testCaseName3, testCaseDesc3);
//					   bp.waitForElement();
//					   
//					   tr.doubleClickOnRelease(releaseName);
//					   String[] navigation4=new String[4];
//					   //navigate to fourth////////////////////////////////////////////////////////////
//					   navigation4[0]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 0);
//					   navigation4[1]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 2, 0);
//					   navigation4[2]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 3, 0);
//					   navigation4[3]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 4, 0);
//					   tr.navigateToNode(releaseName, navigation4);
//					   bp.waitForElement();
//						String fifthName=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 5, 0);
//						String fifthDesc=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 5, 1);
//						tr.addNode(fifthName, fifthDesc);
////						tr.addTestCase();
////						 String testCaseName4=Excel_Lib.getData(INPUT_PATH_4, "AutomationPhases", 7, 8);
////						   String testCaseDesc4=Excel_Lib.getData(INPUT_PATH_4, "AutomationPhases", 7, 9);
////						   ctc.enterTestCaseNameAndDesc(testCaseName4, testCaseDesc4);
//						   bp.waitForElement();
//						   
//						   tr.doubleClickOnRelease(releaseName);
//						   String[] navigation5=new String[5];
//						   //navigate to fifth////////////////////////////////////////////////////////////
//						   navigation5[0]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 0);
//						   navigation5[1]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 2, 0);
//						   navigation5[2]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 3, 0);
//						   navigation5[3]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 4, 0);
//						   navigation5[4]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 5, 0);
//						   tr.navigateToNode(releaseName, navigation5);
//						   bp.waitForElement();
//							String sixthName=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 6, 0);
//							String sixthDesc=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 6, 1);
//							tr.addNode(sixthName, sixthDesc);
////							tr.addTestCase();
////							 String testCaseName6=Excel_Lib.getData(INPUT_PATH_4, "AutomationPhases", 7, 10);
////							   String testCaseDesc6=Excel_Lib.getData(INPUT_PATH_4, "AutomationPhases", 7, 11);
////							   ctc.enterTestCaseNameAndDesc(testCaseName6, testCaseDesc6);
//							   bp.waitForElement();
//							   
//							   tr.doubleClickOnRelease(releaseName);
//							   String[] navigation6=new String[6];
//							   //navigate to sixth////////////////////////////////////////////////////////////
//							   navigation6[0]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 0);
//							   navigation6[1]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 2, 0);
//							   navigation6[2]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 3, 0);
//							   navigation6[3]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 4, 0);
//							   navigation6[4]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 5, 0);
//							   navigation6[5]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 6, 0);
//							   tr.navigateToNode(releaseName, navigation6);
//							   bp.waitForElement();
//								String seventhName=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 7, 0);
//								String seventhdesc=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 7, 1);
//								tr.addNode(seventhName, seventhdesc);
////								tr.addTestCase();
////								 String testCaseName7=Excel_Lib.getData(INPUT_PATH_4, "AutomationPhases", 7, 12);
////								   String testCaseDesc7=Excel_Lib.getData(INPUT_PATH_4, "AutomationPhases", 7, 13);
////								   ctc.enterTestCaseNameAndDesc(testCaseName7, testCaseDesc7);
//								   bp.waitForElement();
//								   
//								   tr.doubleClickOnRelease(releaseName);
//								   String[] navigation7=new String[7];
//								   //navigate to seventh////////////////////////////////////////////////////////////
//								   navigation7[0]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 1, 0);
//								   navigation7[1]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 2, 0);
//								   navigation7[2]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 3, 0);
//								   navigation7[3]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 4, 0);
//								   navigation7[4]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 5, 0);
//								   navigation7[5]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 6, 0);
//								   navigation7[6]=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 7, 0);
//								   tr.navigateToNode(releaseName, navigation7);
//								   bp.waitForElement();
//									String eightName=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 8, 0);
//									String eightdesc=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 8, 1);
//									tr.addNode(eightName, eightdesc);
////									tr.addTestCase();
////									 String testCaseName8=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 14);
////									   String testCaseDesc8=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 7, 15);
////									   ctc.enterTestCaseNameAndDesc(testCaseName8, testCaseDesc8);
//									   bp.waitForElement();
	}

	@When("^covered and uncovered$")
	public void covered_and_uncovered() throws Throwable 
	{
		try
		{
		rp.clickOnRequirements();
		tr=new TestRepositoryPage(driver); 
		req=new RequirementsPage(driver);
		String releaseName=Excel_Lib.getData(INPUT_PATH_4, "Releases", 1, 0);
		//tr.doubleClickOnRelease(releaseName);
	    req.clickOnRelease(releaseName);
		bp.waitForElement();
	   	//String releaseName1=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "coveredPhase", 1, 0);
		String p_Desc1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "coveredPhase", 1, 1);
		tr=new TestRepositoryPage(driver);
		req.addNode(p_Name1,p_Desc1);
		bp.waitForElement();
		
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "coveredPhase", 1, 0);
		tr.navigateToNode(releaseName, phase);
		bp.waitForElement();
		
		req.addRequirement();
		bp.waitForElement();
		
	   rp= new ReleasePage(driver);
	   rp.clickOnTestRep();
	   bp.waitForElement();
	   
	   tr.doubleClickOnRelease(releaseName);
	   bp.waitForElement();
	   
		String pname=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "coveredPhase", 1, 0);
		String pnamedes=Excel_Lib.getData(INPUT_PATH_4, "coveredPhase", 1, 1);
		tr.addNode(pname,pnamedes);
		bp.waitForElement();
		
		tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		
		String[] phase2=new String[1];
		phase2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "coveredPhase", 1, 0);
		bp.waitForElement();
		tr.navigateToNode(releaseName,phase2);
		
		for(int i=0;i<=1;i++)
		{
			tr.addTestCase();
		}
		
		tr.clickDetailButton();
		bp.waitForElement();
		
			req.MapRequirements();
			bp.waitForElement();
			
			tr.clickOnReleaseCheckBox.click();
			bp.waitForElement();
			
			req.saveRequirement();
			bp.waitForElement();
			
			//tr.clickOnMappedRequirements.click();
			bp.waitForElement();
			
			pp.clickOnLogout();
			bp.waitForElement();
			bp.waitForElement();
			
		 }catch (Exception e) 
		   {lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			   e.printStackTrace();
			    driver.close();
			    Relogin rl=new Relogin();
			    rl.reLogin();
		}
	}



@Given("^User login as Manager Credential$")
public void user_login_as_Manager_Credential() throws Throwable {
	try
	{
	lp=new LoginPage(driver);
	bp=new BasePage();
	String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Username_1");
	String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Lead_Password_1");
	lp.enterUname(Uname);
	lp.enterPass(Pass);
	lp.clickOnLogin();
	bp.waitForElement();
	bp.waitForElement();
	System.out.println(Uname);  
	
	 }catch (Exception e) 
	   {lb=new LaunchBrowser();
	   lb.getScreenShot(filename);
		   e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
	}
}

@When("^Navigate to the phase and add test cases to the phase$")
public void navigate_to_the_phase_and_add_test_cases_to_the_phase() throws Throwable {
	
	try
	{
	   pp=new ProjectPage(driver);
	  // String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,0);
	   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
	   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"projects1",1,1);
	   pp.selectProject(projectName);
	   bp=new BasePage();
	   bp.waitForElement();
	   pp.selectRelease(releaseName);
	   bp.waitForElement();
	   rp= new ReleasePage(driver);
	   rp.clickOnTestRep();
		bp.waitForElement();
	   tr=new TestRepositoryPage(driver);
	
	bp.waitForElement();
	bp.waitForElement();
	//String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",1,1);
	//tr=new TestRepositoryPage(driver);
//	   tr.doubleClickOnRelease(releaseName);
//		bp.waitForElement();
 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 11, 0);
 String desc=Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 11, 1);
 tr.doubleClickOnRelease(releaseName);
 
	tr.addNode(name, desc);
	bp.waitForElement();
	
	tr.doubleClickOnRelease(releaseName);
	bp.waitForElement();
	String phasename1[]=new String[1];
	phasename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"AutomationPhases", 11, 0);
	tr.navigateToNode(releaseName, phasename1);
	
	 }catch (Exception e) 
	   {lb=new LaunchBrowser();
	   lb.getScreenShot(filename);
		   e.printStackTrace();
		    driver.close();
		    Relogin rl=new Relogin();
		    rl.reLogin();
	}
}

@Then("^test cases should be added to the phase$")
public void test_cases_should_be_added_to_the_phase() throws Throwable {
   try
   {
	for(int i=1;i<=3;i++)
    {
	tr.addTestCase();
    }
   
    
    bp.waitForElement();
    tr.verifyPresentTestCase();
    
    String names[]=new String[3];
	names[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0));
	names[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0));
	names[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0));
   
	
	ep=new ExportPage(driver);
	ep.selectMultipleTestCaseFromGrid(names);
	bp.waitForElement();
	tr=new TestRepositoryPage(driver);
	ctc=new CreateTestCasePage(driver);
	String detailField[]=new String[3];
	detailField[0]=Excel_Lib.getData(INPUT_PATH_4, "detailField", 1, 0);
	detailField[1]=Excel_Lib.getData(INPUT_PATH_4, "detailField", 1, 1);
	detailField[2]=Excel_Lib.getData(INPUT_PATH_4, "detailField", 1, 2);
	String automationField[]=new String[4];
	automationField[0]=Excel_Lib.getData(INPUT_PATH_4, "automationfield", 1, 3);
	automationField[1]=Excel_Lib.getData(INPUT_PATH_4, "automationfield", 1, 0);
	automationField[2]=Excel_Lib.getData(INPUT_PATH_4, "automationfield", 1, 1);
	automationField[3]=Excel_Lib.getData(INPUT_PATH_4, "automationfield", 1, 2);
	
	
	
	tr.editTestCase();
	bp.waitForElement();
	ctc.editMultipleTestCase(detailField, automationField);
	bp.waitForElement();
	ctc.saveMultipleTestCaseEdit();
	bp.waitForElement();
	
   }catch (Exception e) 
   {lb=new LaunchBrowser();
   lb.getScreenShot(filename);
	   e.printStackTrace();
	    driver.close();
	    Relogin rl=new Relogin();
	    rl.reLogin();
}
    
    
    
    
   
}

}

