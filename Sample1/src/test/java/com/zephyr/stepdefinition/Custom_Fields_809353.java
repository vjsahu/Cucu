package com.zephyr.stepdefinition;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Custom_Fields_809353 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	BasePage bp;
	String fileName="Custom_Fields_809353";
	
	boolean[] actual=new boolean[8];
	 SoftAssert soft=new SoftAssert();
@Given("^User is in the Page of TestRepository$")
public void user_is_in_the_Page_of_TestRepository() throws Throwable {
    
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
	   pp=new ProjectPage(driver);
	   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Normal_Project_1");
	   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
	  actual[0]= pp.selectProject(projectName);
	  actual[1]=pp.selectRelease(releaseName);
	   
	   rp= new ReleasePage(driver);
	   actual[2]=rp.clickOnTestRep(); 
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

@When("^User Creates a node and Adding TestCases$")
public void user_Creates_a_node_and_Adding_TestCases() throws Throwable {
	try
	{
	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
	String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "View", 3, 0);
	String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Phases", 3, 3);
	
	tr=new TestRepositoryPage(driver);
	bp=new BasePage();
	 actual[3]=tr.doubleClickOnRelease(releaseName);
	 actual[4]=tr.addNode(p_Name1,p_Desc1);
	 String[] str=new String[1];
	 str[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "View", 3, 0);
	 tr.navigateToNode(releaseName, str);
	 actual[5]=tr.addTestCase();
	 actual[6]=tr.addTestCase();
	 
	 //tr.clickDetailButton();
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

@When("^User selects Custom Field from the Custom Fields column chooser$")
public void user_selects_Custom_Field_from_the_Custom_Fields_column_chooser() throws Throwable {
   try
   {
	String text=Excel_Lib.getData(INPUT_PATH_3, "TestCases", 1, 8);
	bp.waitForElement();
	 actual[7]=tr.chooseCustomFields(text);
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

@Then("^Custom filed should be choosed successfully$")
public void custom_filed_should_be_choosed_successfully() throws Throwable {
    //String custom=driver.findElement(By.xpath("//*[@id='1013']/field-input/zephyr-inline-edit/div/div/span[1]")).getText();
    //System.out.println(custom);
	try
	{
		for(int k=0;k<=actual.length-1;k++)
	     {
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
	log.info("Custom Field Should be Choosen Successfully");
	//String custom=driver.findElement(By.xpath("//div/zee-custom-fields//strong[contains(@title, 'CustomText')]/following-sibling::span")).getText();
	String custom=driver.findElement(By.xpath("//div/zee-custom-fields//span[contains(@title, 'CustomText')]/following-sibling::span")).getText();
    System.out.println(custom);
    bp.waitForElement();
    tr.clickOnList();
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
