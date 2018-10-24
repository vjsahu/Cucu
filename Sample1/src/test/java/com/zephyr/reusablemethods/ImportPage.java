package com.zephyr.reusablemethods;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zephyr.pom.ImportPage_POM;
import com.zephyr.pom.TestRepositoryPage_POM;

public class ImportPage extends ImportPage_POM
{
	WebDriver driver=null;
	   public Logger log;
	   BasePage bp;
	   TestRepositoryPage tr;

	public ImportPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		log=Logger.getLogger(this.getClass());
	    Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
	}
	
	/*	****************************************************
	 * Method Name			: clickOnImport()
	 * Purpose				: clicks on the Import button
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean clickOnImport() throws Exception
	{
		try
		{
			bp=new BasePage();
			ImportIcon.click();
			bp.waitForElement();
			log.info("Pass - Clicked on Import Button Successfully");
			NextForMap.click();
			bp.waitForElement();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
	
	/*	****************************************************
	 * Method Name			: createMap()
	 * Purpose				: Creates the Map for the testcase to be import
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	public boolean createMap(String mapname,int rownum,String descrimi,String desc,String name,String testSteps,String expResults,String extrID) throws Exception
	{
		try
		{
			bp=new BasePage();
			String rownumber=Integer.toString(rownum);
			bp.waitForElement();
           	WebDriverWait wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(add));
			add.click();
			bp.waitForElement();
			wait.until(ExpectedConditions.elementToBeClickable(mapName));
			log.info("Pass - Clicked on ADD button Successfully");
			mapName.sendKeys(mapname);
			bp.waitForElement();
			Actions act=new Actions(driver);
			act.sendKeys(Keys.TAB).sendKeys(rownumber).perform();
			if(descrimi.equalsIgnoreCase("By empty Row"))
			{
				act.sendKeys(Keys.TAB).perform();
			}
			else if(descrimi.equalsIgnoreCase("By ID Change"))
			{
				act.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).perform();
			}
			else if(descrimi.equalsIgnoreCase("By Testcase Name Change"))
			{
				act.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
			}
			//act.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).perform();
			act.sendKeys(Keys.TAB).sendKeys(desc).perform();
			act.sendKeys(Keys.TAB).sendKeys(name).perform();
			act.sendKeys(Keys.TAB).sendKeys(testSteps).perform();
			act.sendKeys(Keys.TAB).sendKeys(expResults).perform();
			act.sendKeys(Keys.TAB).sendKeys(extrID).perform();
			log.info("Pass - All Entered name successfully");
			bp.waitForElement();
			wait.until(ExpectedConditions.elementToBeClickable(saveMap));
			saveMap.click();
			bp.waitForElement();
				wait.until(ExpectedConditions.elementToBeClickable(nextForImport));
			log.info("Pass - Clicked on Save successfully");
			nextForImport.click();
			bp.waitForElement();
			log.info("Pass - Clicked on next successfully");
			log.info("Pass - Map is created with valid Testcase values");
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
	/*	****************************************************
	 * Method Name			: updateMap()
	 * Purpose				: Creates the Map for the testcase to be import
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean updateMap(String mapname, int rownum,String descrimi, String[] ZephyrFields) throws Exception
	{
		try
		{
			bp=new BasePage();
			String rownumber=Integer.toString(rownum);
			bp.waitForElement();
        	WebDriverWait wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(add));
			add.click();
			bp.waitForElement();
				wait.until(ExpectedConditions.elementToBeClickable(mapName));
			
			log.info("Pass - Clicked on ADD button Successfully");
			mapName.sendKeys(mapname);
			Actions act=new Actions(driver);
			act.sendKeys(Keys.TAB).sendKeys(rownumber).perform();
			if(descrimi.equalsIgnoreCase("By empty Row"))
			{
				act.sendKeys(Keys.TAB).perform();
			}
			else if(descrimi.equalsIgnoreCase("By ID Change"))
			{
				act.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).perform();
			}
			else if(descrimi.equalsIgnoreCase("By Testcase Name Change"))
			{
				act.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
			}
			//act.sendKeys(Keys.TAB).perform();
			for(int i=0;i<=ZephyrFields.length-1;i++)
			{
				act.sendKeys(Keys.TAB).sendKeys(ZephyrFields[i]).perform();
				//bp.waitForElement();
			}
			log.info("Pass - All Entered name successfully");
			bp.waitForElement();
			wait.until(ExpectedConditions.elementToBeClickable(saveMap));
			saveMap.click();
			bp.waitForElement();
			//bp.waitForElement();
			log.info("Pass - Clicked on Save successfully");
			nextForImport.click();
			bp.waitForElement();
			log.info("Pass - Clicked on next successfully");
			log.info("Pass - Map is created with valid Testcase values");
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/*	****************************************************
	 * Method Name			: importTestCase()
	 * Purpose				: Import the testcase from the mapped testcase
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean importTestCase(String jobname,String mapName,String path) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
			add.click();
			bp.waitForElement();
			log.info("Pass - Clicked on Add successfully");
			bp.waitForElement();
			importJobName.sendKeys(jobname);
			log.info("Pass - JobName entered successfully");
			WebElement SelectMap=mapSelection;
			mapSelection.click();
			bp.waitForElement();
			List <WebElement> allMaps=driver.findElements(By.xpath(mapseletion1+mapName+mapseletion2));
			allMaps.size();
			
			
			allMaps.get(allMaps.size()-1).click();
			
//			(//li[text()='MMapTestCase'])[1]
//			Select sel=new Select(SelectMap);
//			sel.selectByVisibleText(mapName);
			log.info("Pass -  Mapped Testcase name is selected for import successfully");
			uploadFile.click();
			bp.waitForElement();
			log.info("Pass - Clicked on choose file input option successfully");
			Runtime.getRuntime().exec(path);
			bp.waitForElement();
			log.info("Pass - Excel file is selected for the import");
			bp.waitForElement();
			saveImport.click();
			bp.waitForElement();
			log.info("Pass - Clicked on save successfully");
			log.info("Pass - Testcase is imported successfully");
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/*	****************************************************
	 * Method Name			: runJob()
	 * Purpose				: Run the Imported Job
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean runJob() throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
			bp.waitForElement();
			
			runJob.get(runJob.size()-1).click();
			 //runJob.click();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 
		     String History = importHistory.getText();
		     log.info(History);
		     
		     return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/*	****************************************************
	 * Method Name			: validateImport()
	 * Purpose				: Run the Imported Job
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean validateImport(String fileName,String releaseName) throws Exception
	{
		try
		{
			
		bp=new BasePage();
		String A="//*[starts-with(@data-desc,'FileName : ";
		String B="')]";
		String ImportedFile=A+fileName+B;
		bp.waitForElement();
		backToMap.click();
		bp.waitForElement();
		log.info("Pass - Clicked on back to navigate to Map");
		backToInstruction.click();
		bp.waitForElement();
		log.info("Pass - Clicked on back to navigate to InstructionPage");
		closeInstruction.click();
		bp.waitForElement();
		log.info("Pass - Closed the Instruction message page");
		tr=new TestRepositoryPage(driver);
	    tr.doubleClickOnRelease(releaseName);
	    bp.waitForElement();
		Actions act=new Actions(driver);
		act.doubleClick(Imported).perform();
		bp.waitForElement();
		log.info("Pass - DoubleClicked on Imported folder in TestRepositoryPage");
		List <WebElement> allFiles=driver.findElements(By.xpath(ImportedFile));
		allFiles.get(allFiles.size()-1).click();
		
		//driver.findElement(By.xpath(ImportedFile)).click();
		bp.waitForElement();
		log.info("Pass - Clicked on the File we have Imported");
		String FileInfo=driver.findElement(By.xpath(ImportedFile)).getAttribute("data-desc");
		log.info(FileInfo);
		bp.waitForElement();
		log.info("Pass - Displayed the Info of Imported File");
		bp.waitForElement();
		act.doubleClick(Imported).perform();
		bp.waitForElement();
		
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/*	****************************************************
	 * Method Name			: GotoImport()
	 * Purpose				: Run the Imported Job
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean GotoImport() throws Exception
	{
		try
		{
			bp=new BasePage();
			NextForMap.click();
			bp.waitForElement();
			//nextForImport.click();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/*	****************************************************
	 * Method Name			: ClickOKonStatusReport()
	 * Purpose				: Run the Imported Job
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean ClickOKonStatusReport() throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
			OkButtonofStatusReport.click();
			bp.waitForElement();
			
			return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/*	****************************************************
	 * Method Name			: DeleteImportJob()
	 * Purpose				: Run the Imported Job
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	public boolean DeleteImportJob(String fileName) throws Exception
	{
		try
		{
			bp=new BasePage();
			OkButtonofStatusReport.click();
			bp.waitForElement();
			
			String delete1="//*[text()='";
			String delete2="']/../../../div[7]/div";
			
			
			List <WebElement> all=driver.findElements(By.xpath(delete1+fileName+delete2));
			all.get(all.size()-1).click();
			//DeleteImportedJobIcon.click();
			bp.waitForElement();
			DeleteButton.click();
			bp.waitForElement();
			String Deleted=ValidateDeleteImportJob.getText();
			log.info("Pass - "+Deleted+" Import Deleted Successfully");
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/* ****************************************************
	  * Method Name   : selectImportedFile(String fileName)
	  * Purpose    : Selects the Imported file
	  * Author    : OPAL
	  * Date Created   : 31/07/17
	  * Date Modified  :
	  * Reviewed By   : 
	  * ******************************************************
	  */
	 public boolean selectImportedFile(String fileName) throws Exception
	 {
	  try
	  {
	   bp=new BasePage();
	   String A="//*[starts-with(@data-desc,'FileName : ";
	   String B="')]";
	   String ImportedFile=A+fileName+B;
	   driver.findElement(By.xpath(ImportedFile)).click();
	   bp.waitForElement();
	   log.info("Pass - Clicked on the File we have Imported");
	   String FileInfo=driver.findElement(By.xpath(ImportedFile)).getAttribute("data-desc");
	   log.info(FileInfo);
	   bp.waitForElement();
	   log.info("Pass - Displayed the Info of Imported File"); 
	   
	   return true;
	  }
	  catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	 }
	 
	 
	 /* ****************************************************
	  * Method Name   : renameImportedFile(String fileName)
	  * Purpose    : Rename the Imported file
	  * Author    : OPAL
	  * Date Created   : 31/07/17
	  * Date Modified  :
	  * Reviewed By   : 
	  * ******************************************************
	  */
	 
	 public boolean renameImportedFile(String rename) throws Exception
	 {
	  try
	  {
		 tr=new TestRepositoryPage(driver);
	   bp=new BasePage();
	   TestRepositoryPage_POM tp=new TestRepositoryPage_POM(driver);
	   bp.waitForElement();
	   tp.options.click();
	   bp.waitForElement();
	   renameButton.click();
	   bp.waitForElement();
	   bp.eraseText(renameField);
	   bp.waitForElement();
	   renameField.sendKeys(rename);
	   bp.waitForElement();
	   confirmRename.click();
	    return true;
	  }
	  catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	 }
	 
	 /*	****************************************************
		 * Method Name			: DeleteImportfile()
		 * Purpose				: delete the impoeted file
		 * Author				: OPAL4
		 * Date Created			: 28/07/17
		 * Date Modified		:
		 * Reviewed By			: 
		 * ******************************************************
		 */
		
		public boolean deleteImportFile(String fileName) throws Exception
		{
			try
			{
				bp=new BasePage();
				tr=new TestRepositoryPage(driver);
				String A="//*[starts-with(@data-desc,'FileName : ";
				String B="')]";
				String ImportedFile=A+fileName+B;
				Actions act=new Actions(driver);
				act.doubleClick(Imported).perform();
				bp.waitForElement();
				driver.findElement(By.xpath(ImportedFile)).click();
				String FileInfo=driver.findElement(By.xpath(ImportedFile)).getAttribute("data-desc");
				log.info(FileInfo);
				bp.waitForElement();
				tr.options.click();
				//deleteImportedFile.click();
				bp.waitForElement();
				//yesToDeleteImportedFile.click();
				
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		 /*	****************************************************
		 * Method Name			: ValidateCheckBoxField()
		 * Purpose				: delete the impoeted file
		 * Author				: OPAL4
		 * Date Created			: 12/08/17
		 * Date Modified		:
		 * Reviewed By			: 
		 * ******************************************************
		 */
		
		public boolean ValidateCheckBoxField() throws Exception
		{
			try
			{
				bp=new BasePage();
				bp.waitForElement();
				bp.waitForElement();
				CreateTestCasePage ctc=new CreateTestCasePage(driver);
				ctc.clickOnCustomField.click();
				bp.waitForElement();
				log.info("Pass - Clicked on custom Field Successfully");
				String status=checkBoxField1.getAttribute("disabled");
				log.info(status);
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
	
		
		
		
		
		
		
		public boolean importTestCase1(String jobname,String mapName,String path,String fileName) throws Exception
		{
			try
			{
				bp=new BasePage();
				add.click();
				bp.waitForElement();
				log.info("Pass - Clicked on Add successfully");
				bp.waitForElement();
				importJobName.sendKeys(jobname);
				log.info("Pass - JobName entered successfully");
				WebElement SelectMap=mapSelection;
				Select sel=new Select(SelectMap);
				sel.selectByVisibleText(mapName);
				log.info("Pass -  Mapped Testcase name is selected for import successfully");
				uploadFile.click();
				bp.waitForElement();
				log.info("Pass - Clicked on choose file input option successfully");
				Runtime.getRuntime().exec(path+" "+fileName);
				bp.waitForElement();
				log.info("Pass - Excel file is selected for the import");
				saveImport.click();
				bp.waitForElement();
				log.info("Pass - Clicked on save successfully");
				log.info("Pass - Testcase is imported successfully");
				
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		

		
		
		
		
		public boolean selectImportFile1(String fileName) throws Exception
		{
			try
			{
				bp=new BasePage();
				tr=new TestRepositoryPage(driver);
				String A="//*[starts-with(@data-desc,'FileName : ";
				String B="')]";
				String ImportedFile=A+fileName+B;
				Actions act=new Actions(driver);
				act.doubleClick(Imported).perform();
				bp.waitForElement();
				
				List <WebElement> allFiles=driver.findElements(By.xpath(ImportedFile));
				allFiles.get(allFiles.size()-1).click();
				
				//driver.findElement(By.xpath(ImportedFile)).click();
				String FileInfo=driver.findElement(By.xpath(ImportedFile)).getAttribute("data-desc");
				log.info(FileInfo);
//				bp.waitForElement();
//				tr.options.click();
//				//deleteImportedFile.click();
//				bp.waitForElement();
//				//yesToDeleteImportedFile.click();
				log.info("selected imported file");
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		////////////added  18-08-2017
		public boolean draganddropImpotedtoPhase(String fileName ,String dstn) throws Exception
		{
			try
			{
				bp=new BasePage();
				tr=new TestRepositoryPage(driver);
				String A="//*[starts-with(@data-desc,'FileName : ";
				String B="')]";
				String ImportedFile=A+fileName+B;
				Actions act=new Actions(driver);
				act.doubleClick(Imported).perform();
				bp.waitForElement();
				WebElement src=driver.findElement(By.xpath(ImportedFile));
				String FileInfo=driver.findElement(By.xpath(ImportedFile)).getAttribute("data-desc");
				log.info(FileInfo);
				Actions a1=new Actions(driver);
				
				//WebElement src=driver.findElement(By.xpath(releasename1+srcNode+releasename2));
				WebElement dest=driver.findElement(By.xpath(tr.releasename1+dstn+tr.releasename2));
				a1.dragAndDrop(src, dest).perform();
				log.info("drag and dropped sucessfully");
//				bp.waitForElement();
//				tr.options.click();
//				//deleteImportedFile.click();
//				bp.waitForElement();
//				//yesToDeleteImportedFile.click();
				
				return true;
			}
			catch(Exception e)
			
			{
				e.printStackTrace();
				throw e;
			}
		}
		
		public boolean deleteImportFile1(String fileName) throws Exception
		{
			try
			{
				bp=new BasePage();
				tr=new TestRepositoryPage(driver);
				String A="//*[starts-with(@data-desc,'FileName : ";
				String B="')]";
				String ImportedFile=A+fileName+B;
				Actions act=new Actions(driver);
				act.doubleClick(Imported).perform();
				bp.waitForElement();
				driver.findElement(By.xpath(ImportedFile)).click();
				String FileInfo=driver.findElement(By.xpath(ImportedFile)).getAttribute("data-desc");
				log.info(FileInfo);
				bp.waitForElement();
				tr.options.click();
				bp.waitForElement();
				bp.waitForElement();
				//deleteImportedFile.click();
				driver.findElement(By.xpath("(//*[text()='Delete'])[4]")).click();
				bp.waitForElement();
				bp.waitForElement();
				yesToDeleteImportedFile.click();
				
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
	
}
	

