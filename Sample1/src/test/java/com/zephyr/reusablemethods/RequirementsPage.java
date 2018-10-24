package com.zephyr.reusablemethods;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zephyr.pom.RequirementsPage_POM;

public class RequirementsPage extends RequirementsPage_POM {

	WebDriver driver=null;
	   public Logger log;
	   BasePage bp;
	   
	   public RequirementsPage(WebDriver driver)
	   {
	   	super(driver);
	   	this.driver=driver;
	   	log=Logger.getLogger(this.getClass());
	       Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
	   }
	   
	   public boolean addRequirement() throws InterruptedException 
	   {
	   	 bp=new BasePage();
	   	bp.waitForElement();
	   	int bcnt=requirementCount();
	   	addRequirement.click();
	   	try 
	   	{
	   		Thread.sleep(2000);
	   	} 
	   	catch (InterruptedException e) 
	   	{
	   	
	   		e.printStackTrace();
	   	}
	   	int acnt=requirementCount();
	   	
	   	if((bcnt+1)==acnt)
	   	{
	   		//System.out.println("Pass-Test Case Successfully Added");
	   		log.info("Pass-Requirements Successfully Added");
	   		return true;
	   	}
	   	else
	   	{
	   		//System.out.println("Fail-Test Case is not Added");
	   		log.info("Fail-Requirements is not Added");
	   		return false;
	   	}
	   }
	   
	
	   public void importRequirement()
	   {
	   	import_Requirement.click();
	   	
	   }
	   public void deleteTestCase()
	   {
	   	delete_Requirement.click();
	   }
	   public void exportRequirement()
	   {
	   	export_Requirement.click();
	   }
	   
	  
	   	
	   
	   
	   public void moveToOption()
	   {
	   	WebElement eleop=driver.findElement(By.xpath(".//*[@id='j24_1_anchor']/div"));
	   	
	   	bp.moveToElementAndClick(eleop);
	   	
	   }
	   
	   public boolean verifyRequirementTitle() throws Exception
	   {
		   try
		   {
	   	String requirementtitle=driver.getTitle();
	   	log.info(requirementtitle);
	  
	   	return true;
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
			   throw e;
		   }
	   }
	   
//	  public int requirementCount() throws InterruptedException
//	   {
//	   	try
//	   	{
//	   	int count=0;
//	   	boolean sp=requirementCount.isEnabled();
//	   	
//	   	if(sp=true)
//	   	{
//	   	 String requirementCount=requirementCount.getText();
//	   	  count= Integer.parseInt(requirementCount);
//	   	  bp.waitForElement();
//	   	 //Thread.sleep(3000);
//	   	}
//	   	return count;
//	   	}
//	       catch(Exception e)
//	       {
//	       	log.info("Currently No Test Case Present in the Node");
//	   		return 0;
//	       }
//	   }

	   public boolean addNode(String Name,String Desc) throws Exception
	   {
	   	try
	   	{
	   		BasePage bp=new BasePage();
	   		options.click();
	   		//System.out.println("Pass - Clicked on Options");
	   		log.info("Pass - Clicked on Options");
	   		addNode.click();
	   		log.info("Pass -Clicked on Add Button");
	   		bp.waitForElement();
	   		nodeName.sendKeys(Name);
	   		nodeDesc.sendKeys(Desc);
	   		saveNode.click();
	   		log.info("Pass - Clicked on Save Button");
	   		bp.waitForElement();
	   		//log.info("Pass - phase created with name and description");
	   		log.info("Pass - created with name and description");
	   		return true;
	   		
	   		
	   	}
	   	catch(Exception e)
	   	{
	   		e.printStackTrace();
	   		throw e;
	   	}
	   }

	  public boolean navigateToNode(String releaseName,String[] navigation) throws Exception
	   {
	   	try
	   	{
	   		
	   		Thread.sleep(3000);
	   		String releasename3=releasename1+releaseName+releasename2;
	   		WebElement ele=driver.findElement(By.xpath(releasename3));
	   		Actions act=new Actions(driver);
	   		act.doubleClick(ele).build().perform();
	   		//System.out.println("Pass - Double click on'"+releaseName+"' Successfull");
	   		log.info("Pass - Double click on'"+releaseName+"' Successfull");
	   		Thread.sleep(3000);
	   		//bp.waitForElement();
	   		return true;
	   	}catch(Exception e)
	   	{
	   		e.printStackTrace();
	   		throw e;
	   	}		
	   }
	   
	   public boolean clickOnRelease(String releaseName) throws Exception
	   {
	   	try
	   	{
	   		bp=new BasePage();
	   		String releasename3=releasename1+releaseName+releasename2;
	   		driver.findElement(By.xpath(releasename3)).click();
	   		bp.waitForElement();
	   		//System.out.println("Pass - double click on'"+releaseName+"' Successfull");
	   		log.info("Pass - double click on'"+releaseName+"' Successfull");
	   		return true;
	   	}
	   	catch(Exception e)
	   	{
	   		e.printStackTrace();
	   		throw e;
	   	}
	   	
	   }
	   
	  /* public void selectTestCase(String name)
		{
			String s3=testcase1+name+testcase2;
			driver.findElement(By.xpath(s3)).click();
		}
	   */
	   public boolean doubleClickOnRelease(String releaseName) throws Exception 
	   {
	   	try{
	   	String releasename3=releasename1+releaseName+releasename2;
	   	Actions act=new Actions(driver);
	   	WebElement ele=driver.findElement(By.xpath(releasename3));
	   	act.moveToElement(ele).doubleClick().perform();
	   	//System.out.println("Pass - double click on'"+releaseName+"' Successfull");
	   	log.info("Pass - double click on'"+releaseName+"' Successfull");
	   	BasePage bp=new BasePage();
	   	bp.waitForElement();
	   	return true;
	   	}
	   

	   catch(Exception e)
	   {
		   e.printStackTrace();
		   throw e;
	   }
	   }
	  /* public boolean addNewTestCaseInDetilview() throws InterruptedException
	   {
	   	bp=new BasePage();
	   	bp.waitForElement();
	   	int bcnt=testCaseCount();
	   	//bp.waitForElement();
	   	add_TestCase.click();
	   	try 
	   	{
	   		Thread.sleep(2000);
	   	} 
	   	catch (InterruptedException e) 
	   	{
	   	
	   		e.printStackTrace();
	   	}
	   	int acnt=testCaseCount();
	   	
	   	if((bcnt+1)==acnt)
	   	{
	   		log.info("Pass-Test Case Successfully Added");
	   		return true;
	   	}
	   	else
	   	{
	   		log.info("Fail-Test Case is not Added");
	   		return false;
	   	}
	   		
	    }*/
//	   public void MapRequirements() throws InterruptedException
//	   {
//		   clickOnExpander.click();
//		   //clickOnTestCaseDetails.click();
//		   bp.waitForElement();
//		   clickOnMapRequirements.click();
//		   bp.waitForElement();
//		   clickOnMapReq.click();
//		   bp.waitForElement();
//		   clickOnReleaseOption.click();
//		   bp.waitForElement();
//		   clickOnPhaseOption.click();
//		   bp.waitForElement();
//		   selectTestCase.click();
//		   bp.waitForElement();
//		   clickOnSave.click();
//	   }

	   public int requirementCount() throws InterruptedException
	   {
	   	try
	   	{
	   	int count=0;
	   	boolean sp=requirementCount.isEnabled();
	   	
	   	if(sp==true)
	   	{
	   	 String requirementsCount=requirementCount.getText();
	   	  count= Integer.parseInt(requirementsCount);
	   	  bp.waitForElement();
	   	 //Thread.sleep(3000);
	   	}
	   	return count;
	   	}
	       catch(Exception e)
	       {
	       	log.info("Currently No Requirement Present in the Node");
	   		return 0;
	       }
	   }

	   /*public void doubleClickOnRelease(String releaseName) throws InterruptedException 
	   {
	   	String releasename3=releasename1+releaseName+releasename2;
	   	Actions act=new Actions(driver);
	   	WebElement ele=driver.findElement(By.xpath(releasename3));
	   	act.moveToElement(ele).doubleClick().perform();
	   	log.info("Pass - double click on'"+releaseName+"' Successfull");
	   	BasePage bp=new BasePage();
	   	bp.waitForElement();
	   }*/
	   

public boolean MapRequirements() throws Exception
	   {
		try{
		   //detail_Tab.click();
		   //clickOnTestCaseDetails.click();
			bp=new BasePage();
		   bp.waitForElement();
		   bp.waitForElement();
		   bp.waitForElement();
		   //clickOnMapRequirements.click();
		   log.info("Successfully clicked on Mapped Requirements");
		   bp.waitForElement();
		   bp.waitForElement();
		   clickOnMapReq.click();
			log.info("Successfully clicked on MapReq");
		   //bp.waitForElement();
		   return true;
		}
	   catch(Exception e)
		{
		   e.printStackTrace();
		   throw e;
		}

	   }


//For Requirement Mapping
	   
	   /*public boolean ExpandRelease(String releaseName) throws Exception 
	   {
		   try
		   {
	   	String releasename3=expandreleasename1+releaseName+expandreleasename2;
	   	Actions act=new Actions(driver);
	   	WebElement ele=driver.findElement(By.xpath(releasename3));
	   	act.moveToElement(ele).doubleClick().perform();
	   	log.info("Pass - double click on'"+releaseName+"' Successfull");
	   	BasePage bp=new BasePage();
	   	bp.waitForElement();
	   	return true;
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
			   throw e;
		   }
	   }*/
      
public boolean ExpandRelease(String releaseName) throws Exception 
{
	   try
	   {
		 BasePage bp=new BasePage();
		 bp.waitForElement();
		List<WebElement> allEle=driver.findElements(By.xpath(expandreleasename1+releaseName+expandreleasename2));
	int size1=driver.findElements(By.xpath(expandreleasename1+releaseName+expandreleasename2)).size();
	System.out.println(size1);
	Actions act=new Actions(driver);
	act.doubleClick(allEle.get(size1-1)).perform();
	bp.waitForElement();
	log.info("Pass - double click on'"+releaseName+"' Successfull");
	
	return true;
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
		   throw e;
	   }
}


//For Saving Requirement
	   public boolean saveRequirement() throws Exception
	   {
		   try
		   {
		   bp=new BasePage();
		   bp.waitForElement();
		   clickSave.click();
		   log.info("Successfully clicked on Save");
		   return true;
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
			   throw e;
		   }
	   }
	   
//For Selecting Requirement
	   public boolean selectRequirement(String requirementNum) throws Exception
		{
		   try
		   {
		   bp=new BasePage();
		   bp.waitForElement();
			String s3=requirement1+requirementNum+requirement2;
			System.out.println(s3);
			driver.findElement(By.xpath(s3)).click();
			return true;
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
			   throw e;
		   }
		}
	   
//For Selecting Import and Jira requirement
	   
	   public void clickOnImport()
	   {
		   import_Requirement.click();
	   }
	   public boolean chooseImportType(String importType)throws Exception
	   {
		   try
		   {
		   bp=new BasePage();
		   bp.waitForElement();
			String s3=importtype1+importType+importtype2;
			System.out.println(s3);
			driver.findElement(By.xpath(s3)).click();
		 return true;
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
			   throw e;
		   }
	   }
	   
	   //selecting access type and Folder Name
	   public boolean selectAccessTypeAndFolderName(String accessType,String folderName) throws Exception
	   {
		   try
		   {
		   bp=new BasePage();
		   bp.waitForElement();
		   chooseAccessTypes.click();
			String s3=accessType1+accessType+accessType2;
			System.out.println(s3);
			driver.findElement(By.xpath(s3)).click();
			clickjiraTopLevelFolderName.click();
			clickjiraTopLevelFolderName.sendKeys(folderName);
			
			return true;
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
			   throw e;
		   }
	   }

		public boolean selectMultipleTestCaseFromGrid(String[] testCaseNo) throws InterruptedException
		{
			BasePage bp=new BasePage();
			bp.waitForElement();
			bp.waitForElement();
//			String s3=testcase1+testCaseName+testcase2;
//			driver.findElement(By.xpath(s3)).click();
			for(int i=0;i<=testCaseNo.length-1;i++)
			{
				WebElement ele=driver.findElement(By.xpath(selectTestCase1+testCaseNo[i]+selectTestCase2));
			Actions a1=new Actions(driver);
			a1.moveToElement(ele).click().perform();
			}
			
			return true;
		}
		
	/**********************************************************************************/	
		//select querry
		public boolean selectQuerry(String selectQuerry,String enterQuerry) throws Exception
		{
			try
			{
			bp=new BasePage();
			   bp.waitForElement();
			   WebDriverWait wait2=new WebDriverWait(driver, 100);
				wait2.until(ExpectedConditions.elementToBeClickable(searchChoiceContainer));
			   searchChoiceContainer.click();
				String s4=selectquerry1+selectQuerry+selectquerry2;
				System.out.println(s4);
				driver.findElement(By.xpath(s4)).click();
				//enterJiraSearchDefectsJQLQuerry.click();
				enterJiraSearchDefectsJQLQuerry.sendKeys(enterQuerry);
				
				
				
				//enterJiraSearchDefectsJQLQuerry.sendKeys(Excel_Lib.getData(INPUT_PATH_3, "", , ));
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
				
		}
		public boolean searchJqlQuerry(String requirementType) throws Exception
		{
			try
			{
				bp=new BasePage();
				bp.waitForElement();
			enterJiraSearchDefectsJQLQuerry.click();
			//enterJiraSearchDefectsJQLQuerry.sendKeys(Excel_Lib.getData(INPUT_PATH_3, "Import", 1, 6));
			clickjiraTopLevelFolderName.click();
			bp.waitForElement();
			clickjiraTopLevelFolderName.sendKeys("bug");
			clickjiraSearchButton.click();
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		
		public boolean selectMultipleTestCaseFromGrids(String[] testCaseNo) throws InterruptedException
		{
			bp=new BasePage();
			bp.waitForElement();
			bp.waitForElement();
//			String s3=testcase1+testCaseName+testcase2;
//			driver.findElement(By.xpath(s3)).click();
			for(int i=0;i<=testCaseNo.length-1;i++)
			{
			WebElement ele=driver.findElement(By.xpath(checkTestCase1+testCaseNo[i]+checkTestCase2));
			Actions a1=new Actions(driver);
			a1.moveToElement(ele).click().perform();
			bp.waitForElement();
			}
			
			return true;
		}
		
		
		/* ****************************************************
	       * Method Name   : dragAndDropNode(String srcNode,String destNode) 
	      * Purpose    : To drag And Drop Node
	      * Author    : OPAL1
	      * Date Created   : 27/07/17
	      * Date Modified  :12/08/17(Modified by srikanth)
	      * Reviewed By   : Opal4
	      * ******************************************************
	      */
	    public boolean dragAndDropNode(String srcNode,String destNode) throws Exception
	    {
	     try
	     {
	      
	     
	     Actions a1=new Actions(driver);
	     
	     WebElement src=driver.findElement(By.xpath(releasename1+srcNode+releasename2));
	     WebElement dest=driver.findElement(By.xpath(releasename1+destNode+releasename2));
	     a1.dragAndDrop(src, dest).perform();
	     
	     return true;
	     }
	     catch(Exception e)
	     {
	      e.printStackTrace();
	      throw e;
	     }
	     
	    }
	    
	    
	    public boolean DTSLoginDetails(String Password,String ReenterPassword) throws Exception
	    {
	    	try
	    	{
	    	clickOnResetUser.click();
	    	bp=new BasePage();
	    	bp.waitForElement();
	    	password.click();
	    	bp.waitForElement();
	    	password.sendKeys(Password);
	    	bp.waitForElement();
	    	//reEnterPassword.click();
	    	bp.waitForElement();
	    	reEnterPassword.sendKeys(ReenterPassword);
	    	bp.waitForElement();
	    	update.click();
	    	return true;
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		throw e;
	    	}
	    }
	    
	    public boolean DTSLoginDetail(String Username,String Password,String ReenterPassword) throws Exception
	    {
	    	try
	    	{
	    	bp=new BasePage();
		    bp.waitForElement();
	    	clickOnResetUser.click();
	    	 bp.waitForElement();
	    	bp.eraseText(username);
	    	//username.click();
	    	bp.waitForElement();
	    	username.sendKeys(Username);
	    	password.click();
	    	bp.waitForElement();
	    	password.sendKeys(Password);
	    	bp.waitForElement();
	    	//reEnterPassword.click();
	    	bp.waitForElement();
	    	reEnterPassword.sendKeys(ReenterPassword);
	    	bp.waitForElement();
	    	update.click();
	    	bp.waitForElement();
	    	bp.waitForElement();
	    	//updateUser.click();
	    	boolean res=updateUser.isDisplayed();
	    	if(res==true)
	    	{
	    		updateUser.click();
	    	}
	    	bp.waitForElement();
	    	return true;
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		throw e;
	    	}
	    }
	    public boolean cloneRequirement() throws Exception
		   {
			   try
			   {
		   	clone_Requirement.click();
		   	return true;
			   }
			   catch(Exception e)
		    	{
		    		e.printStackTrace();
		    		throw e;
		    	}

		   }
	    
	    public boolean selectRequirementsFromGrids(String[] testCaseNo) throws InterruptedException
		{
			BasePage bp=new BasePage();
			bp.waitForElement();
//			String s3=testcase1+testCaseName+testcase2;
//			driver.findElement(By.xpath(s3)).click();
			for(int i=0;i<=testCaseNo.length-1;i++)
			{
			WebElement ele=driver.findElement(By.xpath(checkRequirement1+testCaseNo[i]+checkRequirement2));
			Actions a1=new Actions(driver);
			a1.moveToElement(ele).click().perform();
			}
			
			return true;
		}
	    
	    public boolean MapTestCases() throws Exception
	    {
	    	try
	    	{
	    	bp=new BasePage();
	    	//clickOnMappedTestCases.click();
	    	bp.waitForElement();
	    	clickOnMapTestCase.click();
	    	return true;
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		throw e;
	    	}
	    }
	    public boolean mapTestCasesToRequirementsFromGrids(String[] testCaseNo) throws InterruptedException
		{
			 bp=new BasePage();
			bp.waitForElement();
//			String s3=testcase1+testCaseName+testcase2;
//			driver.findElement(By.xpath(s3)).click();
			for(int i=0;i<=testCaseNo.length-1;i++)
			{
				bp.waitForElement();
			WebElement ele=driver.findElement(By.xpath(mapTestCaseRequirement1+testCaseNo[i]+mapTestCaseRequirement2));
			Actions a1=new Actions(driver);
			a1.moveToElement(ele).click().perform();
			bp.waitForElement();
			}
			
			return true;
		}
	    
}
