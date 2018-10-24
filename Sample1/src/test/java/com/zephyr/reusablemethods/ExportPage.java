package com.zephyr.reusablemethods;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zephyr.pom.ExportPage_POM;

public class ExportPage extends ExportPage_POM
{

	WebDriver driver;
	BasePage bp;
	public Logger log;
	public ExportPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		log=Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
		BasicConfigurator.configure();
		
	}
	/* ****************************************************
	   * Method Name   : clickOnNodeExport() 
	  * Purpose    : To click On Export option from node
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	
	public boolean clickOnNodeExport() throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(options));
	    options.click();
	    bp.waitForElement();
	    driver.findElement(By.xpath(nodeExport)).click();
	    bp.waitForElement();
	   
	   //Verification Page
	  
	   String verifyexportPage=exportPage.getText();
	  //System.out.println(verifyexportPage);
	  //System.out.println(exportPageTitle);
	 
	     Assert.assertEquals(exportPageTitle,verifyexportPage); 
	     log.info("Successfully landed on Export page");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.info("You are not navigated to Export Page");
			throw e;
		}
	}
	
//	public void verifyclickOnNodeExport()
//	{
//		String expMsg="Customize and Export Reports";
//		String exportPage=driver.findElement(By.xpath("//h4[contains(.,'Customize and Export Reports')]")).getText();
//		Assert.assertEquals(expMsg, exportPage);
//	}
	
	/* ****************************************************
	   * Method Name   : selectAllSelectFields 
	  * Purpose    : To select All Select Fields
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean selectAllSelectFields() throws Exception
	{
		try
		{
		if(allselectFieldchkBox.isSelected()==false)
		{
		allselectFieldchkBox.click();
		log.info("All select fields is selected");
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
	   * Method Name   : unselectAllSelectFields 
	  * Purpose    : To unselect All Select Fields
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean unselectAllSelectFields() throws Exception//////////////added
	{
		try
		{
			if(allunselectFieldchkBox.isSelected()==true)
			{
			allunselectFieldchkBox.click();
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
	   * Method Name   : select Select Fields(String[] selectFieldsName)
	  * Purpose    : To select Select Fields from export page
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean selectSelectFields(String[] selectFieldsName) throws Exception
	{
		try
		{
		
		List<WebElement> allSelectFields=driver.findElements(By.xpath(exportfields));
		for(int k=0;k<=selectFieldsName.length-1;k++)
		{
			int i=101;
			
			for(int j=1;j<=16;j++)
		    {
		     String ch=allSelectFields.get(j).getText();
		     WebElement allSelectField=driver.findElement(By.xpath(selectfields1+i+selectfields2));
			 boolean check=allSelectField.isSelected();
			 System.out.println(ch);
		     System.out.println(check);
		     i++;
           
	       if(selectFieldsName[k].equals(ch))
	         {
		         if(check==false)
		          {
		    	    //System.out.println("Alt id selected");
				    allSelectField.click();
				    //log.info(message);
				  }
             }
	        
	       }
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
	   * Method Name   : selectFilterBy(String coverage,String creation_date,String[] priority,String[] creator,String M_A) 
	  * Purpose    : To select FilterBy from export page
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
public boolean selectFilterBy(String coverage,String creation_date,String[] priority,String[] creator,String M_A) throws Exception
	{
		
	try
	{
	  bp=new BasePage();
	  coverageOption.click();
		for(int i=0;i<=2;i++)
		{
            WebElement ele=driver.findElement(By.xpath(coverage1+i+coverage2));
			//System.out.println(ele);
			String ele1=ele.getText();
			System.out.println(ele1);
			
			if(coverage.equalsIgnoreCase(ele1))
			{
				bp=new BasePage();
				bp.waitForElement();
				ele.click();
			}
		 }
		
		
		
		if(priority[0]!=(""))
		{
	    priorityOption.click();
		bp.waitForElement();
	    //Thread.sleep(2000);
		driver.findElement(By.xpath(priorityField)).click();
		
		
		for(int k=0;k<=priority.length-1;k++)
		{
			Actions a1=new Actions(driver);
			System.out.println(priority[k]);
			a1.sendKeys(priority[k]).sendKeys(Keys.ENTER).perform();
			
			bp.waitForElement();
		}
		Actions a2=new Actions(driver);
		a2.sendKeys(Keys.ENTER).perform();
		a2.sendKeys(Keys.ENTER).perform();
		
		}
		
		if(creator[0]!="")///////Changed
		{
			creatorOption.click();
		
		bp.waitForElement();
		//Thread.sleep(2000);
		driver.findElement(By.xpath(creatorField)).click();
		//WebElement ele=driver.findElement(By.xpath(creatorField));
		String ele_1="//li//option[text()='";
		String ele_2="']";
			
		
		
		for(int j=0;j<=creator.length-1;j++)
		{
			Actions a3=new Actions(driver);
			a3.sendKeys(creator[j]).perform();
		WebElement ele1=driver.findElement(By.xpath(ele_1+creator[j]+ele_2));
		String p=ele1.getText();
		System.out.println(p);
		if(creator[j].equalsIgnoreCase(p))
		{
			//Actions a3=new Actions(driver);
			//a3.sendKeys(creator).perform();
			Thread.sleep(2000);
			ele1.click();
			
			a3.sendKeys(Keys.SPACE).perform();
		}
		}
		
		
		Actions a4=new Actions(driver);
		a4.sendKeys(Keys.ENTER).perform();
}

		m_aOption.click();
		for(int l=0;l<=2;l++)
		{
		WebElement ele1=driver.findElement(By.xpath(m_a1+l+m_a2));
		
		String MorA=ele1.getText();
		System.out.println(MorA);
		
		if(M_A.equalsIgnoreCase(MorA))
		{ 
			bp.waitForElement();
			ele1.click();
		}
		
	}
		return true;
	}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	public void startDate() throws Exception
	{
		try
		{
		CreationDateOption.click();
		startDate.click();
		selectDate.click();
		bp.waitForElement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	public void startAndEndDate() throws Exception
	{
		try
		{
		CreationDateOption.click();
		startDate.click();
		selectDate.click();
		bp.waitForElement();
		Enddate.click();
		selectEndDate.click();
		bp.waitForElement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
	/* ****************************************************
	   * Method Name   : reportType(String report_Type) 
	  * Purpose    : To select report type in export page
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean reportType(String report_Type) throws Exception 
	{
		try
		{
			bp=new BasePage();
			
			WebElement rType=driver.findElement(By.xpath(output1+report_Type+output2));
			
			String report=rType.getText();
			
//		for(int l=35;l<=37;l++)//changed /////////////////////
//		{
//		//WebElement rType=driver.findElement(By.xpath("//*[text()='report_Type']");
//		WebElement rType=driver.findElement(By.xpath(reportType1+l+reportType2));
//		//System.out.println(rType);
//		//String report=rType.getText();
//		//System.out.println(report);
//		//System.out.println(report_Type);
		if(report_Type.equalsIgnoreCase(report))
		{
			bp.waitForElement();
			rType.click();
			//System.out.println(report_Type);
			log.info("Report Type Selected- "+report_Type);
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
	   * Method Name   :  outputType(String outputType) 
	  * Purpose    : To select output Type 
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean outputType(String outputType) throws Exception 
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		
		WebElement oType=driver.findElement(By.xpath(output1+outputType+output2));
		String output =oType.getText();
//		for(int l=38;l<=40;l++)
//		{
//			//WebElement rType=driver.findElement(By.xpath("//*[text()='outputType']");
 // WebElement oType=driver.findElement(By.xpath(outputType1+l+outputType2));
		//System.out.println(oType);
		//String output =oType.getText();
//		//System.out.println(output);
//		//System.out.println(outputType);
		if(outputType.equalsIgnoreCase(output))
		{
			bp.waitForElement();
			oType.click();
			log.info("Output Type Selected-"+output);
			//log.info("Output Type- "+outputType);
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
	   * Method Name   : title(String titleName) 
	  * Purpose    : enter title name in export page
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean title(String titleName) throws Exception
	{
		try
		{
		//WebElement title=driver.findElement(By.xpath("//input[@value='Testcase Report']"));
		testCaseReportTitle.clear();
		testCaseReportTitle.sendKeys(titleName);
		
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/* ****************************************************
	   * Method Name   : saveAndDownload()
	  * Purpose    : To save And Download exported file
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean saveAndDownload() throws Exception
	{
		try
		{
		bp=new BasePage();
		Actions a1=new Actions(driver);
		a1.sendKeys(Keys.DOWN).perform();
		a1.sendKeys(Keys.DOWN).perform();
		bp.waitForElement();
		bp.waitForElement();
		//Thread.sleep(2000);
		exportSave.click();
		log.info("Save button is clicked sucessfully");
		
		bp.waitForElement();
		bp.waitForElement();
		WebDriverWait wait1 = new WebDriverWait(driver, 50);
	    wait1.until(ExpectedConditions.elementToBeClickable(exportDownload));
		exportDownload.click();
		log.info("Export download button is clicked successfully");
		
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
	public String verifyExcelExport(String xlPath,String sheetName,int rowNum,int cellNum) throws Exception
	{
		try
		{
		FileInputStream fis=new FileInputStream(xlPath);
		Workbook w1=WorkbookFactory.create(fis);
		Sheet s1=w1.getSheet(sheetName);
		Row r1=s1.getRow(rowNum);
		Cell c1=r1.getCell(cellNum);
		String data=c1.getStringCellValue();
		//System.out.println(data);
		return data;
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
	public void verifyPDFExport() throws Exception
	{
	try 
	 {
	    PDDocument document = null;
	    document = PDDocument.load(new File("C:\\Users\\RAJNEESH\\Downloads\\TestcaseTreeExport__1499521034473.pdf"));
	    document.getClass();
	    if (!document.isEncrypted()) 
	    {
	    	
	        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
	        stripper.setSortByPosition(true);
	        PDFTextStripper Tstripper = new PDFTextStripper();
	        String st = Tstripper.getText(document);
	        
	        System.out.println("Text:" + st);
	        
	    }
	    
	    
	    
	} 
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

	
	
	
	/* ****************************************************
	   * Method Name   : dnDForTestStepsDetails(int fromStepNum,int toStepNum) 
	  * Purpose    :  To select Multiple Test Case From Test Case Grid
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	public boolean selectMultipleTestCaseFromGrid(String[] testCaseNo) throws Exception
	{
		try
		{
		BasePage bp=new BasePage();
		bp.waitForElement();
		//int length=testCaseNo.length-1;

		for(int i=0;i<=testCaseNo.length-1;i++)
		{
			bp.waitForElement();
		WebElement ele=driver.findElement(By.xpath(checkTestCase1+testCaseNo[i]+checkTestCase2));
		Actions a1=new Actions(driver);
		a1.moveToElement(ele).click().perform();
		}
		log.info(testCaseNo.length+" Test Case Selected");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/* ****************************************************
	   * Method Name   :  
	  * Purpose    : To dnD the teststeps in Testcase Steps
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
	// Search And Add Test Case
	public boolean searchTestCases(String searchOption) throws Exception
	{
		try
		{
			bp=new BasePage();
		bp.waitForElement();
		clickOnSearch.click();
		bp.waitForElement();
		clickOnSearchTextArea.clear();
		clickOnSearchTextArea.sendKeys(searchOption);
         bp.waitForElement();
		clickOnGoButton.click();
		 bp.waitForElement();
		
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
	public boolean selectMultipleTestcasesfromSearch(String[] testCaseNo) throws Exception
	{
		try
		{
		bp=new BasePage();
		int length=testCaseNo.length-1;
		for(int i=0;i<=testCaseNo.length-1;i++)
		{
		bp.waitForElement();
		WebElement ele=driver.findElement(By.xpath(checkSearchedTestCase1+testCaseNo[i]+checkSearchedTestCase2));
		Actions act=new Actions(driver);
		act.moveToElement(ele).click().perform();
		}
		
		log.info(length+" Test Case Selected");
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
	public boolean clickOnExportTab() throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		export_TestCase.click();
		bp.waitForElement();
       log.info("Succesfully Landed on Export page");
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
	public boolean UnselectInTheseRelease() throws Exception
	{
		try
		{
		boolean ele=inTheseReleaseOption.isSelected();
		if(ele==true)
		{
			inTheseReleaseOption.click();
			log.info("In these Release Opion is Uncheked");
		}
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
//	public void moveTestCasesFromOneNodeToOtherNode(String srcNode,String destNode,String[] testCases)
//	{
//		for(int i=0;i<=testCases.length-1;i++)
//		{
//		testCases[i].click();
//		Actions a1=new Actions(driver);
//		
//		a1.dragAndDrop(srcNode, destNode)
//		
//	}
	
	/* ****************************************************
	   * Method Name   : dnDForTestStepsDetails(int fromStepNum,int toStepNum) 
	  * Purpose    : To dnD the teststeps in Testcase Steps
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
		public boolean clickOnPhase(String phaseName) throws Exception
		{	try
			{
            String releasename4=phasename1+phaseName+phasename2;
			
			WebElement nodeElement=driver.findElement(By.xpath(releasename4));
			Actions a1=new Actions(driver);
			a1.moveToElement(nodeElement).click().perform();
			log.info("Pass -"+phaseName+" node is selected");
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
		////////////////////////////////////
		public boolean searchAndAdd(String searchOption) throws Exception
		 {
			try
			{
		  clickOnSearch.click();
		  //advancedSearch.click();
		  
		  //clickOnSearchTextArea.click();
		  clickOnSearchTextArea.sendKeys(searchOption);
		  Thread.sleep(3000);
		  clickOnGoButton.click();
		  Thread.sleep(3000);
		  //clickOnRelease.click();
		  
		  return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		 }
		
		public boolean selectAndExport() throws Exception
		 {
		  
		  try
		  {
		  /*Thread.sleep(2000);
		  selecTestCaseChkBox.click();*/
		  Thread.sleep(5000);
		  clickOnExportOption.click();//
		  Thread.sleep(3000);//
		  clickOnSave.click();//
		  Thread.sleep(10000);//
		  clickOnDownload.click();//
		  
		  return true;
		  }
		  catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		  //clickOnSave.click();
		  //clickOnRelease.click();
		  
		  
		//  public void Release(String )
		//  {
		//   clickOnRelease.click();
		//  }
		//  //clickOnSaveButton.click();
		  
		  
		  //Thread.sleep(3000);
		  //clickOnDownloadButton.click();
		  
		  //WebElement ele=(driver.findElement(By.xpath(".//*[@id='zui-search-textarea']")));
		  //ele.click();
		  //Thread.sleep(3000);
		  //ele.sendKeys("testcase1");
		  
		  
		  
		 }
		public boolean selectallSelectFields() throws Exception
		 {
			try
			{
		  allselectFieldchkBox.click();
		  return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		 }
		
		
		/* ****************************************************
		 * Method Name   : Start adn End date
		* Purpose    : To select report type in export page
		* Author    : OPAL1
		* Date Created   : 10/08/17
		* Date Modified  :
		* Reviewed By   : Opal4
		* ******************************************************
		*/
		////////////////////////////modified 07-09-2017
		 @SuppressWarnings("deprecation")
		public void startDate1(String date2) throws Exception
		 {
		  try
		  {
			  bp=new BasePage();
			  dateFieldOption.click();
			  bp.waitForElement();
			  
//				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
//
//				 //get current date time with Date()
//				 Date date = new Date();
//				 ///System.out.println(date);
//				 // Now format the date
//				 String date1= dateFormat.format(date);
//				  bp.waitForElement();
//			  int day;
//			  SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
//			  
//				 //get current date time with Date()
//				 Date date = new Date();
//				 day = date.getDay();
//				 day = day-5;
//				 date.setDate(day);
				 ///System.out.println(date);
				 // Now format the date
				// String date1= dateFormat.format(date);
			  
				 starDate1.click();
				  //starDate1.sendKeys(date1);
			  bp.waitForElement();
			  
			  driver.findElement(By.xpath(start_date11+date2+start_date22)).click();
//		   bp=new BasePage();
		   bp.waitForElement();
//		   dateFieldOption.click();
//		   startDateOption.click();
//
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }
		 }
		 
		 @SuppressWarnings("deprecation")
		public void endDate1() throws Exception
		 {
		  try
		  {
			  bp=new BasePage();
			  dateFieldOption.click();
			  bp.waitForElement();
			  JavascriptExecutor js =((JavascriptExecutor) driver);
			    js.executeScript("arguments[0].scrollIntoView(true);", exportSave);
				bp.waitForElement();
//			  int day;
//			  SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
//			  
//				 //get current date time with Date()
//				 Date date = new Date();
//				 day = date.getDay();
//				 day = day+10;
//				 date.setDate(day);
//				 ///System.out.println(date);
//				 // Now format the date
//				 String date1= dateFormat.format(date);
//				  bp.waitForElement();
//			  endDate1.sendKeys(date1);
				  endDate1.click();
			  bp.waitForElement(); 
			 
			  bp.waitForElement(); 
			driver.findElement(By.xpath(end_date11+"25"+end_date22)).click();
			  bp.waitForElement(); 
//		  endDateOption.click();
//		  bp=new BasePage();
//		  bp.waitForElement();
//		  bp.waitForElement();
//		  
//		     String a="(//span[text()='";
//		     String b="'])[2]";
//		     String dateNum=a+enddate+b;
//		     driver.findElement(By.xpath(dateNum)).click();
		//  startDate.click();
		//  selectDate.click();
		//  bp.waitForElement();
		//  Enddate.click();
		//  selectEndDate.click();
		//  bp.waitForElement();
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }
		 }
}

	
	



	
	

