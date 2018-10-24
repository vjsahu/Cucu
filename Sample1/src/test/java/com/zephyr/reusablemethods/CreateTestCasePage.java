package com.zephyr.reusablemethods;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.zephyr.pom.CreateTestCasePage_POM;




public class CreateTestCasePage extends CreateTestCasePage_POM
{
  BasePage bp;
  WebDriver driver;
  public Logger log;

  


  public CreateTestCasePage(WebDriver driver)
  {
	 super(driver);
	 this.driver =driver;
	 log=Logger.getLogger(this.getClass());
	Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
	BasicConfigurator.configure();
	

     }	

  /* ****************************************************
   * Method Name   : enterTestCaseNameAndDesc(String testCaseName,String testCaseDesc) 
  * Purpose        : for entering test case name and description in detail view
  * Author         : OPAL1
  * Date Created   : 27/07/17
  * Date Modified  :
  * Reviewed By    : Opal4
  * ******************************************************
  */
   
   public boolean enterTestCaseNameAndDesc(String testCaseName,String testCaseDesc) throws Exception 
	{
	   try
	   {
		
		bp=new BasePage();
		bp.waitForElement();
		
		//Erasing the Field
		bp.eraseText(l1.get(0));
		
		//Entering the data to the field
		Actions a1=new Actions(driver);
		a1.sendKeys(testCaseName).perform();
		a1.sendKeys(Keys.ENTER).perform();
		bp.waitForElement();
		
		//Erasing the field
        bp.eraseText(l1.get(1));
		
        //Entering Data to the Field
        Actions a2=new Actions(driver);
		a2.sendKeys(testCaseDesc).perform();
		a2.sendKeys(Keys.ENTER).perform();
		a2.sendKeys(Keys.TAB).perform();
		bp.waitForElement();
		
		//Validation
		String tcName= l1.get(0).getText();
		String description=l1.get(1).getText();
		
		
		if((testCaseName.equals(tcName))&&(testCaseDesc.equals(description)))
		{
			log.info("Pass-Successfully Test Case Name and Description is Added");
		
		}
		else
		{
			log.info("Name or Description is not Added");
			
		}
		
		
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		   
		}
	}
   
   
   /* ****************************************************
	   * Method Name   : enterTestCaseDetail(String[] details) 
	  * Purpose    : To enter Test Case Detail( priority,altId,tags,comment)
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean enterTestCaseDetail(String[] details) throws Exception
	{
		try
		{
			bp=new BasePage();
			
		
		//Entering Data to the Priority field
			if(details[0]!="")
			{
		Actions a1=new Actions(driver);
		a1.moveToElement(enterPriority).click().pause(2000).sendKeys(details[0]).sendKeys(Keys.ENTER).perform();
		
			}
		
		//Entering Data to the AltID field
		
			if(details[1]!="")
			{
				Actions a1=new Actions(driver);
		a1.moveToElement(enterAltID).click().pause(2000).sendKeys(details[1]).sendKeys(Keys.ENTER).perform();
	
			}
		bp.waitForElement();
		
		
		//Entering Data to the Tags field
		if(details[2]!="")
		{
		Actions a1=new Actions(driver);
        a1.moveToElement(enterTags).click().pause(2000).sendKeys(details[2]).build().perform();
		a1.sendKeys(Keys.ENTER).build().perform();
		a1.sendKeys(Keys.ENTER).build().perform();
		}
		
		//bp.eraseText(l1.get(5));
		//bp.waitForElement();
//		//Entering Data to the Comment field
//		a1.moveToElement(l1.get(5)).click().pause(2000).sendKeys(details[3]).perform();
//		a1.sendKeys(Keys.ENTER).perform();
//		a1.sendKeys(Keys.TAB).perform();
//		
		//Validation
		bp.waitForElement();
		String priority=enterPriority.getText();
		String altID=enterAltID.getText();
		String tags=enterTags.getText();
		//String comment=l1.get(5).getText();
		
		if((priority.equals(details[0]))&&(altID.equals(details[1]))&&(tags.equals(details[2])))
		{
			log.info("Pass- Priority and AltID and Tags and Comment is Added Succssfully");
		}
		else
		{
			log.info("Priority or AltID or Tags or Comment is not Added");	
		}
	   
//		
		return true;
//		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
			//return false;
		}
	}
		
	/* ****************************************************
	   * Method Name   : enterTestCaseStepDetail(String[] stepDetails )
	  * Purpose        :  To enter Test Case Step Detail
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean enterTestCaseStepDetail(String[] stepDetails ) throws Exception
	{
		bp=new BasePage();
		
	  Actions a3=new Actions(driver);
	  for(int i=1;i<=7;i++)
	  {
			a3.sendKeys(Keys.DOWN).perform();
	  }
	
         try
		{	
        bp.waitForElement();
		bp.waitForElement();
		//stepDetail.click();
		
		//addTestStep.click();
		WebElement addSteps=driver.findElement(By.xpath(addTestStep));
		
		
		
		
		
			
		for(int i=0;i<=stepDetails.length-1;i=i+3)
		{
           bp.waitForElement();

		addSteps.sendKeys(stepDetails[i]);
		bp.waitForElement();

		Actions a1=new Actions(driver);
		a1.sendKeys(Keys.TAB).perform();
		a1.sendKeys(stepDetails[i+1]).perform();
		bp.waitForElement();

		a1.sendKeys(Keys.TAB).perform();
		a1.sendKeys(stepDetails[i+2]).perform();
		bp.waitForElement();

		bp.waitForElement();
		nextBtn.click();
		
		}
		
		bp.waitForElement();
		
		//driver.findElement(By.xpath(saveBtnConfirm)).click();
		log.info("Test Case step details are entered successfully");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
			//e.printStackTrace();
			//return false;
		}
         
	}

	
	/* ****************************************************
	   * Method Name   : uploadAttachement(String[] filePath)
	  * Purpose    : To upload Attachement
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean uploadAttachement(String[] filePath) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
			
			attachements.click();
			Actions a3=new Actions(driver);
			for(int i=1;i<=3;i++)
			  {
					a3.sendKeys(Keys.DOWN).perform();
			  }
		bp.waitForElement();
		for(int i=0;i<=filePath.length-1;i++)
		{
		
		driver.findElement(By.xpath(browse)).click();
		
		bp.waitForElement();
		Runtime.getRuntime().exec(filePath[i]);
		bp.waitForElement();
		}
		
		log.info("File Uploaded Successfully");
		
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.info("File is not Uploaded");
			throw e;
			//return false;
		}
		
		
	}
	/* ****************************************************
	   * Method Name   : enterEstimatedTime(String day,String hr,String mn) 
	  * Purpose    : To enter Estimated Time
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean enterEstimatedTime(String day,String hr,String mn) throws Exception
	{
		
		try
		{
		bp=new BasePage();
		bp.waitForElement();
	    estimatedTime.click();
		WebElement days=driver.findElement(By.xpath(days_1));
		days.clear();
		Actions a1=new Actions(driver);
		a1.sendKeys(day).pause(1200).perform();
		
		
		a1.sendKeys(Keys.TAB).sendKeys(hr).pause(1200).perform();
		a1.sendKeys(Keys.TAB).sendKeys(mn).pause(1200).perform();

		a1.sendKeys(Keys.ENTER).perform();
		
		String validate_time=day+":"+hr+":"+mn;
//		System.out.println("time-"+validate_time);
		bp.waitForElement();
		String time=driver.findElement(By.xpath(".//*[@id='testcase-estimated-time']/zephyr-inline-edit/div/div/span[1]/zui-estimated-time/div")).getText();
//		System.out.println("validate_time-"+time);
//		log.info("Pass- Estimated Time Successfully Added");
		
		if(validate_time.equals(time))
		{
			log.info("Pass- Estimated Time Successfully Added");
		}
		
		return true;
		}	
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
			//return false;
		
		}	
		
	}
	
	/* ****************************************************
	   * Method Name   : enterMultipleTags(String[] tags)
	  * Purpose    : To enter Multiple Tags in Test Case Detail
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	
	public boolean enterMultipleTags(String[] tags) throws Exception
	{
		try
		{
			bp=new BasePage();
		Actions a1=new Actions(driver);
		for(int j=1;j<=5;j++)
		  {
				a1.sendKeys(Keys.DOWN).perform();
		  }
		a1.moveToElement(enterTags).click();
		bp.waitForElement();
		for(int i=0;i<=tags.length-1;i++)
		{
			    a1.sendKeys(tags[i]).pause(3000).build().perform();
				a1.sendKeys(Keys.ENTER).build().perform();
				
		}
	
		a1.sendKeys(Keys.ENTER).build().perform();
	  
		return true;
				}
	
	  catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	}
	public void verifyStepDetailHistory()
	{
		
	}
	
	/* ****************************************************
	   * Method Name   : editTags(String[] tags) 
	  * Purpose    : To edit Tags in test case detail view
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	//Modified//27/7/2017////////
	//purpose-For editing tags in Test Case detail view
	public boolean editTags(String[] tags) throws Exception 
	{
		try
		{
			
		
		 bp=new BasePage();
		bp.waitForElement();
		
		Actions a2=new Actions(driver);
		a2.moveToElement(enterTags).click().perform();
		bp.waitForElement();
	    a2.moveToElement(eraseTags).click().perform();
	  
	    //Entering Data to the Tags field
		for(int k=0;k<=tags.length-1;k++)
		{	
          a2.sendKeys(tags[k]).pause(2000).perform();
		  a2.sendKeys(Keys.ENTER).build().perform();
		}
		a2.sendKeys(Keys.ENTER).build().perform();	
		return true;
	}
		
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	}
	
	/* ****************************************************
	   * Method Name   : edtitMultipleTestCase(String[] detailField,String[] automationField)
	  * Purpose    : To edit Multiple Selected Test Case fields
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	//Modified 26/7/2017//
	
	public boolean editMultipleTestCase(String[] detailField,String[] automationField) throws Exception
	{
		try
		{
		
		bp=new BasePage();
		bp.waitForElement();
		
		if(detailField[0]!="")
		{
		altId.clear();
		altId.sendKeys(detailField[0]);
		}
		if(detailField[1]!="")
		{
		comments.clear();
		comments.sendKeys(detailField[1]);
		}
//		//Newly tags Added
//		WebElement ele=driver.findElement(By.xpath(".//*[@id='zee-create-edit-modal-tcr_3']/div/div/div[2]/zui-modal-body/div/div/form/div[1]/div[1]/div[3]/div/zee-select/span/span[1]/span"));
//		Actions a2=new Actions(driver);
//		a2.moveToElement(ele).sendKeys(keysToSend)
//		
		if(detailField[2]!="")
		{
		bp.waitForElement();
		prioritySeection.click();
		bp.waitForElement();
		
		String validatePriority= driver.findElement(By.xpath(priority1+detailField[2]+priority2)).getText();
		//System.out.println(validatePriority);
		
		if(detailField[2].equalsIgnoreCase(validatePriority))
		{
			driver.findElement(By.xpath(priority1+detailField[2]+priority2)).isEnabled();
			//System.out.println(driver.findElement(By.xpath(priority1+detailField[2]+priority2)).isEnabled());
			driver.findElement(By.xpath(priority1+detailField[2]+priority2)).click();
		}
		
		}
		if(automationField[0].equalsIgnoreCase("Automated Script") && (automationField[0])!="" )
		{
			bp=new BasePage();
		  ChkAutomatedScript.click();
		  bp.waitForElement();
		
		 scriptName.clear();
		 scriptName.sendKeys(automationField[1]);
		 bp.waitForElement();
		 
		 scriptId.clear();
		 scriptId.sendKeys(automationField[2]);
		 bp.waitForElement();
		 
		 scriptPath.clear();
		 scriptPath.sendKeys(automationField[3]);
		 bp.waitForElement();
		 
		 
		}
		
		
		//driver.findElement(By.xpath(SaveBtnInMultEdit)).click();
		 return true;
		}
		 catch(Exception e)
		{
			 e.printStackTrace();
			 throw e;
		}
		 
		 
	}
	
	/* ****************************************************
	   * Method Name   : verifyEdtitMultipleTestCase(String[] detailField,String[] automationField) 
	  * Purpose    : To verify Edit Multiple Test Case fields
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean verifyEditMultipleTestCase(String[] detailField,String[] automationField) throws Exception
	{
		try
		{
		String verifyAltId=altId.getText();
		System.out.println(verifyAltId);
		String verifyComments=comments.getText();
		System.out.println(verifyComments);
		String verifyPriority=prioritySeection.getText();
		System.out.println(verifyPriority);
		
		if(detailField[0].equals(verifyAltId)||detailField[1].equals(verifyComments)||detailField[2].equals(verifyPriority))
		{
			log.info("Detail field edited Successfully");
		}
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	public boolean moveTestSteps(String srcNo,String destNo) throws Exception
	{
		try
		{
		stepDetail.click();
		String step1=".//*[@id='zephyr-editable-row-";
		String step2="']/td[2]/div/div[1]";
		
		WebElement ele=driver.findElement(By.xpath(step1+srcNo+step2));
		System.out.println(ele);
		WebElement ele1=driver.findElement(By.xpath(step1+destNo+step2));
		Actions a1=new Actions(driver);
		a1.moveToElement(ele).perform();
		a1.clickAndHold(ele).perform();
		a1.release(ele1).perform();
		
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
		//a1.dragAndDrop(ele,ele1).perform();
		//WebElement ele1=driver.findElement(By.xpath(".//*[@class='fa fa-gear']"));
		//a1.moveToElement(ele1).perform();
		//a1.click().perform();
		
		//driver.findElement(By.xpath(".//*[@id='zephyr-editable-row-1']/td[2]/div/div[1]"))
	}
	
	
	/* ****************************************************
	   * Method Name   : deleteAttachement(String[] attachement_file)
	  * Purpose    : To delete Attachements
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	
	///Newly Added
	
	public boolean deleteAttachement(String[] attachement_file) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
		 attachements.click();
		
		 
		
		
		bp.waitForElement();
		for(int i=0;i<=attachement_file.length-1;i++)
		{
		WebElement Ele=driver.findElement(By.xpath(attachFile1+attachement_file[i]+attachFile2));
		Actions a1=new Actions(driver);
		a1.moveToElement(Ele).perform();
		a1.moveToElement(deleteAttachements).click().perform();
		bp.waitForElement();
		a1.moveToElement(deleteAttachBtn).click().perform();
		log.info("Attachement successfully deleted");
		}
		
		return true;
		}
		
		catch(Exception e)
		{
			log.info("Attachement File not present");
			throw e;
			//return false;
		}
	}
	
	/* ****************************************************
	   * Method Name   : enterAutomationScriptField(String script_Name,String script_Id,String script_Path) 
	  * Purpose    : To enter Automation Script Field
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean enterAutomationScriptField(String script_Name,String script_Id,String script_Path) throws Exception
	{
		try
		{
		 bp=new BasePage();
		  ChkAutomatedScript.click();
		
		 scriptName.clear();
		 scriptName.sendKeys(script_Name);
		 
		 scriptId.clear();
		 scriptId.sendKeys(script_Id);
		 
		 scriptPath.clear();
		 scriptPath.sendKeys(script_Path);
		 
		 bp.waitForElement();
		 saveInAutoScript.click();
		 bp.waitForElement();
		 confirmSaveInAutoScript.click();

		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
	
	/* ****************************************************
	   * Method Name   : deleteTestSteps(String testStepNo)
	  * Purpose    : To delete Test Steps from test case
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean deleteTestSteps(String testStepNo) throws Exception
	{
		try
		{
		BasePage bp=new BasePage();
		stepDetail.click();
		String step1=".//*[@id='zephyr-editable-row-";
	   String step2="']/td[2]/div";
	   String deleteOptions="html/body/div/div/ul/li[1]";
		
		WebElement ele=driver.findElement(By.xpath(step1+testStepNo+step2));
		System.out.println("Test step selected");
		String option1="(//span[@class='fa fa-gear'])[";
		String option2="]";
		WebElement option=driver.findElement(By.xpath(option1+testStepNo+option2));
		
		bp.waitForElement();
		System.out.println("Moved to option");
		Actions a1=new Actions(driver);
		a1.moveToElement(ele).perform();
		bp.waitForElement();
		a1.moveToElement(option).click().perform();
		bp.waitForElement();
		
		WebElement deleteOption=driver.findElement(By.xpath(deleteOptions));
		a1.moveToElement(deleteOption).click().perform();
		bp.waitForElement();
		WebElement deleteBtn=driver.findElement(By.xpath(".//*[@id='zee-operation-modal-step-delete']/div/div/div[3]/button[2]"));
	    a1.moveToElement(deleteBtn).click().perform();
	     
	    return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
	
	/* ****************************************************
	   * Method Name   : unselectAutomationCheckBox()
	  * Purpose    : To unselect Automation CheckBox in test case
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	//25/7/2017
	//Added 
	public boolean unselectAutomationCheckBox() throws Exception
	{
		try
		{
		if(ChkAutomatedScript.isSelected()==true)
		{
		  ChkAutomatedScript.click();
		}
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/* ****************************************************
	   * Method Name   : editTagsInMultipleTesCase(String[] multipleTags) 
	  * Purpose    : To edit Tags In Multiple Tes Case
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	//added 
	//creation date-26/07/2017
	//Purpose-For editing tags in Multiple test case Edit Window
	public boolean editTagsInMultipleTesCase(String[] multipleTags) throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		//eraseTags.click();
		Actions a2=new Actions(driver);
		a2.moveToElement(tags).click().perform();
//		a2.moveToElement(eraseTags).click().perform();
//		
		for(int k=0;k<=multipleTags.length-1;k++)
		{	
          a2.sendKeys(multipleTags[k]).pause(2000).perform();
		  a2.sendKeys(Keys.ENTER).build().perform();
		}
		
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	 /* ****************************************************
	   * Method Name   : dnDForTestStepsDetails(int fromStepNum,int toStepNum) 
	  * Purpose    : To dnD the teststeps in Testcase Steps
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	 
	 public boolean dnDForTestStepsDetails(int fromStepNum,int toStepNum) throws Exception
	 {
	  try
	  {
	   bp=new BasePage();
	   stepDetail.click();
	   String Dnd1="//*[@id='zephyr-editable-row-";
	   String Dnd2="']";
	   String startPosition=Dnd1+fromStepNum+Dnd2;
	   String endPosition=Dnd1+toStepNum+Dnd2;
	   WebElement initStepNum=driver.findElement(By.xpath(startPosition));
	   Actions act=new Actions(driver);
	   act.clickAndHold(initStepNum).perform();
	   log.info("Pass - Step number '"+fromStepNum+"' is Selected and holded for DnD");
	   bp.waitForElement();
	   WebElement destStepNum=driver.findElement(By.xpath(endPosition));
	   act.release(destStepNum).perform();
	   log.info("Pass - TestStep is DnD to Step number '"+toStepNum+"' ");
	   
	   return true;
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	 }
	 
	/* ****************************************************
	  * Method Name			: dragAndDrop(WebElement source,WebElement destination) 
	 * Purpose				: To dnD the teststeps in Testcase Steps
	 * Author				: OPAL1
	 * Date Created			: 27/07/17
	 * Date Modified		:
	 * Reviewed By			: Opal4
	 * ******************************************************
	 */
	
	public void dragAndDrop(WebElement source,WebElement destination)
	{
		try
		{
			bp=new BasePage();
			Actions act=new Actions(driver);
			act.clickAndHold(source).perform();
			bp.waitForElement();
			act.release(destination).perform();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	   
	 
	 public boolean editTestSteps(int stepNum,String edit[]) throws Exception
	 {
	  try
	  {
	   bp=new BasePage();
	   stepDetail.click();
	   String Dnd1="//*[@id='zephyr-editable-row-";
	   String Dnd2="']//td[3]";  //Updated
	   String testStepNum=Dnd1+stepNum+Dnd2;
	   WebElement edit1=driver.findElement(By.xpath(testStepNum));
	   bp.waitForElement();
	   bp.eraseText(edit1);
			bp.waitForElement();
	   Actions act=new Actions(driver);
	   act.sendKeys(edit[0]).perform();
	   bp.waitForElement();
	   act.sendKeys(Keys.TAB).sendKeys(edit[1]).perform();
	   bp.waitForElement();
	   act.sendKeys(Keys.TAB).sendKeys(edit[2]).perform();
	   bp.waitForElement();
	   act.sendKeys(Keys.TAB).perform();
	   bp.waitForElement();
	   return true;
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	 }
	public void validate()
	{
		
			log.info("Fail - Testcase Modification Failed");
			prioritySeection.click();
			
	}
	 
	
	
	  
	 /* ****************************************************
	   * Method Name   : enterCustomFields(String text,String longText,String number,String checkBox,String pickupList,String date)
	  * Purpose    : To enter custom fields
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean enterCustomFields(String text,String longText,String number,String checkBox,String pickupList,String date) throws Exception 
	{
		try
		{
		bp=new BasePage();
		 bp.waitForElement();
		if(text!="")
		{
			 
			 bp.eraseText(customText);
			 Actions a1=new Actions(driver);
		     a1.sendKeys(text).sendKeys(Keys.TAB).perform();
		}
	  bp.waitForElement();
		if(longText!="")
		{
			bp.eraseText(customLongText);
			 Actions a1=new Actions(driver);
		      a1.sendKeys(longText).sendKeys(Keys.TAB).perform();
			//longTextField.sendKeys(longText);
		}
	  bp.waitForElement();
		if(number!="")
		{
			bp.eraseText(customNumber);
			 Actions a1=new Actions(driver);
		      a1.sendKeys(number).sendKeys(Keys.TAB).perform();
		   //numberField.sendKeys(number);
		}
	  bp.waitForElement();
		if(checkBox!="")
		{
			 Actions a1=new Actions(driver);
			 a1.moveToElement(customCheckbox).click().perform();
			
		}
	  bp.waitForElement();
		if(pickupList!="")
		{
			
			bp.waitForElement();
			  Actions a1=new Actions(driver);
		   a1.moveToElement(customPicklist).click().pause(1200).sendKeys(pickupList).sendKeys(Keys.ENTER).perform();
			
			//pickuplistField.sendKeys(pickupList);
		}
		bp.waitForElement();
	  if(date!="")
	   {
		  customDate.click();
		  String a="(//span[text()='";
		  String b="'])";
		  String dateNum=a+date+b;
		  driver.findElement(By.xpath(dateNum)).click();    
	   }

		return true;
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/* ****************************************************
	   * Method Name   : verifyAttachementFile(String fileName) 
	  * Purpose    : To verify Attachement File
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
 //02/08/2017
	//Added
	public boolean verifyAttachementFile(String fileName) throws Exception
	{
        
		try
		{
		BasePage bp=new BasePage();
		
		
		bp.waitForElement();
		WebElement Ele=driver.findElement(By.xpath(attachFile1+fileName+attachFile2));
		String validateFile=Ele.getText();
		//Assert.assertEquals(fileName, validateFile);
		Actions a1=new Actions(driver);
		a1.moveToElement(Ele).perform();
		
		Assert.assertEquals(fileName, validateFile);
		

	
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/* ****************************************************
	   * Method Name   : saveMultipleTestCaseEdit() 
	  * Purpose    : To save Multiple Test Case Edit
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	
	public boolean saveMultipleTestCaseEdit() throws Exception
	{
		try
		{
		 bp=new BasePage();
		 saveInAutoScript.click();
	   bp.waitForElement();
	   String info=updatedTcInfo.getText();
	   System.out.println(info);
		 bp.waitForElement();
		 bp.waitForElement();
		 confirmSaveInAutoScript.click();
		 return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
	////Verication methods
	
	
	public boolean verifyTestCaseName(String name) throws Exception
	{
		String tcName= l1.get(0).getText();
		//String description=l1.get(1).getText();
		try
		{
		   if((name.equals(tcName)))
		   {
			log.info("Pass-Successfully Test Case Name Added");
		   }
		  return true;
		}
          
		catch(Exception e)
          {
			
			  log.info("Fail-Test Case Name is not Added");
			  throw e;
        	  //return false;
          }
  
	}
	
//	public boolean verifyTestCaseDescription(String desc)
//	{
//		
//		
//		String description=l1.get(1).getText();
//		Assert.assertEquals(desc, description);
//		
//		return true;
//		
//		
//	}
//	
//	public boolean verifyPriority(String priority)
//	{
//		String actPriority=l1.get(2).getText();
//		Assert.assertEquals(priority, actPriority);
//		return true;
//	}

//public boolean verifyTestCaseDetail(String[] details))
//{
//	try
//	{
//	bp.waitForElement();
//	String priority=l1.get(2).getText();
//	String altID=l1.get(3).getText();
//	String tags=l1.get(4).getText();
//	String comment=l1.get(5).getText();
//	
//	if((priority.equals(details[0]))&&(altID.equals(details[1]))&&(tags.equals(details[2]))&&(comment.equals(details[3])))
//	{
//		log.info("Pass- Priority and AltID and Tags and Comment is Added Succssfully");
//	}
//	else
//	{
//		log.info("Fail-Priority or AltID or Tags or Comment is not Added");	
//	}
//   
//	
//	return true;
//	
//	}
//	catch(Exception e)
//	{
//		return false;
//	}
 
	
	//14-08-17
	public boolean editTeststep(int stepNum,String edit[]) throws Exception
	  {
	   try
	   {
	    bp=new BasePage();
	    stepDetail.click();
	    String Dnd1="//*[@id='zephyr-editable-row-";
	    String Dnd2="']/td[2]/div";
	    String testStepNum=Dnd1+stepNum+Dnd2;
	    WebElement edit1=driver.findElement(By.xpath(testStepNum));
	    bp.waitForElement();
	    //bp.eraseText(edit1);
	    Actions act=new Actions(driver);
	    act.click(edit1).doubleClick().sendKeys(Keys.DELETE).sendKeys(Keys.TAB).perform();
	    bp.waitForElement();
	    act.doubleClick().sendKeys(Keys.DELETE).sendKeys(Keys.TAB).perform();
	    bp.waitForElement();
	    act.doubleClick().sendKeys(Keys.DELETE).sendKeys(Keys.TAB).perform();
	    bp.waitForElement();
	    
	    //clickStepSave.click();
	    return true;
	   }
	   catch(Exception e)
	   {
	    e.printStackTrace();
	    throw e;
	   }
	  }
	
	/* ****************************************************
	  * Method Name			: .sendKeys(Keys.ENTER)(String[] tags)
	 * Purpose				: enters multiple tags
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	
	public boolean tagsInBulkEdit(String[] tags) throws Exception
	{
		try
		{
		Actions a1=new Actions(driver);
		a1.moveToElement(tagsInBulkEdit).click();
		for(int i=0;i<=tags.length-1;i++)
		{
			    a1.sendKeys(tags[i]).pause(3000).build().perform();
				a1.sendKeys(Keys.ENTER).build().perform();
				
		}
		a1.sendKeys(Keys.ENTER).sendKeys(Keys.ENTER).build().perform();
	  
		return true;
				
		
		}
	
	  catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	}
	
	
	/* ****************************************************
	  * Method Name			: editEstimatedTimeInMultiTc(String[] detailField,String[] automationField)
	 * Purpose				: edits the multiple tags
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	public boolean editEstimatedTimeInMultiTc(String day,String hour,String min)
	{
		try
		{
			estimatedTimeMultiedit.clear();
			Actions a1=new Actions(driver);
			a1.sendKeys(day).sendKeys(Keys.TAB).perform();
			a1.sendKeys(hour).sendKeys(Keys.TAB).perform();
			a1.sendKeys(min).perform();
			log.info("Pass- Estimated Time Successfully Added");
			return true;	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	 /* ****************************************************
	  * Method Name			: resetTeststeps()
	 * Purpose				: To dnD the teststeps in Testcase Steps
	 * Author				: OPAL1
	 * Date Created			: 27/07/17
	 * Date Modified		:
	 * Reviewed By			: Opal4
	 * ******************************************************
	 */
	
	public boolean resetTeststeps(int stepNum,String edit[]) throws Exception
	{
		try
		{
			bp=new BasePage();
			stepDetail.click();
			String Dnd1="//*[@id='zephyr-editable-row-";
			String Dnd2="']/td[2]/div";
			String testStepNum=Dnd1+stepNum+Dnd2;
			WebElement edit1=driver.findElement(By.xpath(testStepNum));
			bp.waitForElement();
			bp.eraseText(edit1);
			Actions act=new Actions(driver);
			act.sendKeys(edit[0]).perform();
			bp.waitForElement();
			act.sendKeys(Keys.TAB).sendKeys(edit[1]).perform();
			bp.waitForElement();
			act.sendKeys(Keys.TAB).sendKeys(edit[2]).perform();
			bp.waitForElement();
			act.sendKeys(Keys.TAB).perform();
			//cancelStepDetails.click();
			log.info("Pass - clicked on Cancel to Restet the Step");
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	
	 public void selectdate() throws Exception
	 {
	  bp=new BasePage();
	     try {
	      
	    bp.waitForElement();
	      clickOnCalender.click();
	      bp.waitForElement();
	      clickOnDate.click();
	      
	  } catch(Exception e)
			{
			e.printStackTrace();
			throw e;
		}
	  
	 }
	 
	 
	 public boolean enterAutomationScriptFieldInTestCasePage(String check,String name,String id,String path) throws Exception
	 {
		 try
		 {
		 bp=new BasePage();
		 
		 
		 
		 if(check!="")
		 {
		 ChkAutomatedScriptInDetail.click();
		 bp.waitForElement();
		 
		 
		 }
		 
		 
		 return true;
		 }
		 catch(Exception e)
			{
			e.printStackTrace();
			throw e;
		}
		 }
	 
	 
	 public boolean unselectAutomationField() throws Exception
	 {
		 try
		 {
		 ChkAutomatedScriptInDetail.click();
		 return true;
		 }
		 catch(Exception e)
			{
			e.printStackTrace();
			throw e;
		 
			}
		 }
		 
		
		 
		 
		 
		 
		 /* ****************************************************
		   * Method Name   : editCustomFields(String text,String longText,String number,String checkBox,String pickupList,String date) 
		  * Purpose    : To edit Custom Fields of multi selected test cases
		  * Author    : OPAL1
		  * Date Created   : 27/07/17
		  * Date Modified  :
		  * Reviewed By   : Opal4
		  * ******************************************************
		  */
		 
		 public boolean editCustomFieldsInMultipleTestCase(String text,String longText,String number,String checkBox,String pickupList,String date) throws Exception
		  {
		  try
		  {
		   //edit_TestCase.click();
		   bp=new BasePage();
		   bp.waitForElement();
		   
		   if(text!="")
		   {
		    bp.eraseText(customText1);
		    Actions a1=new Actions(driver);
		    a1.sendKeys(text).perform();
		    //textField.sendKeys();
		   }
		   if(longText!="")
		   {
		    
		    bp.eraseText(customlongText1);
		    Actions a1=new Actions(driver);
		    a1.sendKeys(longText).perform();
		   }
		   if(number!="")
		   {
		    bp.eraseText(customNumber1);
		    Actions a1=new Actions(driver);
		      a1.sendKeys(number).perform();
		   }
		   bp.waitForElement();
		   if(checkBox!="")
		   {
		    System.out.println("Inside If statement- "+checkBox);
		    Actions a2=new Actions(driver);
		    a2.moveToElement(customChkbox1).click().perform();
		    //checkboxField.click();
		    bp.waitForElement();
		   }
		   if(pickupList!="")
		   {
		    Select s1=new Select(customPicklist1);
		    s1.selectByVisibleText(pickupList);
		    //pickuplistField.sendKeys(pickupList);
		   }
		    if(date!="")
		    {
		     customDate1.click();
		     String a="(//span[text()='";
		     String b="'])[1]";
		     String dateNum=a+date+b;
		     driver.findElement(By.xpath(dateNum)).click();
		    }
		   return true;
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  // return false;
		  }
		   
		  }
		 
	 }


