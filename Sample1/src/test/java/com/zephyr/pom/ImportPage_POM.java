package com.zephyr.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zephyr.common.LaunchBrowser;

public class ImportPage_POM 
{

WebDriver driver;
	
	public ImportPage_POM(WebDriver driver) 
	{
	  this.driver = driver;
	  PageFactory.initElements(LaunchBrowser.driver,this );
	}

	/*	****************************************************
	 * Method Name			: clickOnImport()
	 * Purpose				: POM clickOnImport() method
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	@FindBy(xpath="//*[text()='Import']")
	public WebElement ImportIcon;
	
	@FindBy(xpath="(//*[@class='zui-btn zui-btn-primary' and @type='button' and text()='Next'])")
	public WebElement NextForMap;
	
	/*	****************************************************
	 * Method Name			: createMap()
	 * Purpose				: POM of CreateMap() method
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	@FindBy(xpath="(//*[text()='Add'])[3]")
	public WebElement add;
	
	@FindBy(xpath="//*[@id='addmap']")
	public WebElement mapName;
	
	@FindBy(xpath="//*[@id='update-savedMaps']/form/div[3]/span[2]/button")
	public WebElement saveMap;
	
	@FindBy(xpath="//*[@id='zee-import-modal-testcase']/div/div/div[3]/zui-modal-footer/div/button[2]")
	public WebElement nextForImport;
	
//	@FindBy(xpath="(//div[@title='MapTestCase'])[1]")
//	public WebElement selectMap;
	
	
	/*	****************************************************
	 * Method Name			: importTestCase()
	 * Purpose				: POM of ImportTestcase() method
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	@FindBy(xpath="//*[@id='job-name']")
	public WebElement importJobName;
	
	@FindBy(id="-wrap-maps-import-component")
	public WebElement mapSelection;
	
	@FindBy(xpath="//*[@id='fromLocal']/div/attachments/div/div/p/span[2]")
	public WebElement uploadFile;
	
	@FindBy(xpath="//*[@id='update-importJobs']/form/div[3]/span[2]/button")
	public WebElement saveImport;
	
//	@FindBy(xpath="(//*[@class='flex-data-item undefined ellipsis td-show' and @data-col-index='1'])[1]")
//	public WebElement selectImportJob;
	
	/*	****************************************************
	 * Method Name			: runJob()
	 * Purpose				: POM of runJob()
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	@FindAll({@FindBy(xpath="//*[@class='grid-action-icon fa fa-play-circle-o runJobs']")})             
	//public WebElement runJob;
	public List<WebElement> runJob;
	
	@FindBy(xpath="//*[@class='grid-action-icon fa fa-refresh reRunJobs']")
	public WebElement reRunJob;
	
	@FindBy(xpath="//*[@id='job-status-modal-importJob']/div/div/div[2]")
	public WebElement importHistory;
	
	/*	****************************************************
	 * Method Name			: ValidateImport()
	 * Purpose				: POM of runJob()
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	@FindBy(xpath="//*[@id='zee-import-modal-testcase']/div/div/div[3]/zui-modal-footer/div/button")
	public WebElement backToMap;
	
	@FindBy(xpath="//*[@id='zee-import-modal-testcase']/div/div/div[3]/zui-modal-footer/div/button[1]")
	public WebElement backToInstruction;
	
	@FindBy(xpath="//*[@id='zee-import-modal-testcase']/div/div/div[1]/div[2]/button")
	public WebElement closeInstruction;
	
	@FindBy(xpath="//*[@data-name='Imported']")
	public WebElement Imported;
	
	/*	****************************************************
	 * Method Name			: ClickOKonStatusReport()
	 * Purpose				: Run the Imported Job
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	@FindBy(xpath="//*[@id='job-status-modal-importJob']/div/div/div[3]/zui-modal-footer/button[1]")
	public WebElement OkButtonofStatusReport;
	
	/*	****************************************************
	 * Method Name			: DeleteImportJob()
	 * Purpose				: Run the Imported Job
	 * Author				: OPAL
	 * Date Created			: 10/07/17
	 * Date Modified		:
	 * Reviewed By			: 
	 * ******************************************************
	 */
	
	@FindBy(xpath="//*[@class='grid-action-icon fa fa-trash deleteJobs']")
	public WebElement DeleteImportedJobIcon;
	
	@FindBy(xpath="//*[@id='zui-import-modal-job-delete']/div/div/div[3]/zui-modal-footer/button[1]")
	public WebElement DeleteButton;
	
	@FindBy(xpath="/html/body/div[2]")
	public WebElement ValidateDeleteImportJob;
	
	@FindBy(xpath="(//*[@class='flex-data-item undefined ellipsis td-show' and @data-col-index='1'])[1]")
	 public WebElement selectImportJob;
	
	@FindBy(xpath="(//*[@title='MapTestCase'])[1]")
	 public WebElement selectMap;
	
	@FindBy(xpath="/html/body/ul[2]/li[1]/a")
	 public WebElement renameButton;
	 
	 @FindBy(xpath="//*[@id='testcaseNodeName']")
	 public WebElement renameField;
	 
	 @FindBy(xpath="//*[@id='tcrRenameNodeModalSave']")
	 public WebElement confirmRename;
	 
	 @FindBy(xpath="/html/body/ul[2]/li[2]/a")
		public WebElement deleteImportedFile;
		
	@FindBy(xpath="/html/body/zui-app/section/zee-test-repository/test-repository-component/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/section/zui-tcr-tree/ng-component/zui-modal/div/div/div/div[3]/zui-modal-footer/button[2]")
	public WebElement yesToDeleteImportedFile;
		
	@FindBy(xpath="//*[@id='zee-testcase-details-module']/div[2]/zee-custom-fields/ul/li[2]/div/span/span/input")
	public WebElement checkBoxField;
			
	@FindBy(xpath="//div/zee-custom-fields//span[contains(@title, 'CustomCheckbox')]/following-sibling::span")
	public WebElement checkBoxField1;
		
			
			@FindBy(xpath="//*[@id='zee-import-modal-testcase']/div/div/div[1]/div[2]/button")
			public WebElement closeImportTestCasePage;
			
			public String mapseletion1="(//li[text()='";
			public String mapseletion2="'])";
			//li[text()='
			
			@FindBy(xpath="//*[@id='zee-import-modal-testcase']//zui-modal-footer/div/button")
			public WebElement back;
			
			
}

