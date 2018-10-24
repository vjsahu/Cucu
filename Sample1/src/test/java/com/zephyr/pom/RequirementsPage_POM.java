package com.zephyr.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.reusablemethods.BasePage;

public class RequirementsPage_POM 
{

	WebDriver driver=null;
	public RequirementsPage_POM(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(LaunchBrowser.driver, this);
	}

	public Logger log;
	BasePage bp;	
		
//	@FindBy(xpath=".//*[@id='j24_1_anchor']/div")
//	public WebElement options;
	
	@FindBy(xpath="//*[@class='contextMenuIcon fa fa-ellipsis-v']")
	public WebElement options;
		
	@FindBy(xpath="html/body/ul/li[1]/a")
	public WebElement addNode;
	
	@FindBy(css="#addNodeName")
	public WebElement nodeName;
	
	@FindBy(css="#addNodeDescription")
	public WebElement nodeDesc;
	
	@FindBy(css="#reqAddNodeModalSave")
	public WebElement saveNode;
	
	@FindBy(xpath=".//*[@id='zui-modal-trigger-requirement_1']")
	public WebElement addRequirement;
	
	@FindBy(xpath=".//*[@id='zui-modal-trigger-import-requirements']")
	public WebElement import_Requirement;
	
	@FindBy(xpath=".//*[@id='zui-modal-trigger-requirement_2']")	
	public WebElement clone_Requirement;

	@FindBy(xpath=".//*[@id='zui-modal-trigger-requirement_4']")
	public WebElement delete_Requirement;
	
	@FindBy(xpath=".//*[@id='zui-modal-trigger-requirement_9']")
	public WebElement allocate_TestCase;
	
	@FindBy(xpath=".//*[@id='zui-export-modal-trigger-requirement_3']")
	public WebElement export_Requirement;
	
	@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-requirements/test-requirements-component/div[1]/div[1]/div[2]/div[1]/a/span")
	public WebElement search_TestCase;
	
	@FindBy(xpath=".//*[@id='grid-table-tcr']/div[2]/div/div[3]/div/div")
	public WebElement clickOnTestCaseDetails;
	
	@FindBy(xpath=".//*[@id='testcase-fullscreen-resizer']/span")
	public WebElement clickOnExpander;
	
	@FindBy(xpath="//*[text()='Mapped Requirements']")
	public WebElement clickOnMapRequirements;
	
	@FindBy(xpath=".//*[@id='mapTest']")
	public WebElement clickOnMapReq;
	
	@FindBy(xpath=".//*[@id='j4_1_anchor']")
	public WebElement clickOnReleaseOption;
	
	@FindBy(xpath=".//*[@id='j4_24_anchor']")
	public WebElement clickOnPhaseOption;
	
	@FindBy(xpath=".//*[@id='grid-table-map_req']/div[2]/div[1]/div[1]/div/div/input")
	public WebElement selectTestCase;
	
	@FindBy(xpath=".//*[@id='zee-map-modal']/div/div/div[3]/zui-modal-footer/div/div/button[2]")
	public WebElement clickOnSave;
	
	@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/div/div[2]/b[3]")
	public WebElement requirementCount;
	
	//For selecting Release in Phase
	protected String releasename1="//*[@data-name='";
	protected String releasename2="']";
	
	
	//For Mapping Requirements
		@FindBy(xpath="//span[contains(.,' Detail ')]")
		public WebElement detail_Tab;
		
		
		
		
		@FindBy(xpath="(//div[@class='row map-save']/div/button[text()='Save'])[3]")
		public WebElement clickSave;

		//For selecting Release in node
			protected String expandreleasename1="//*[@data-name='";
			protected String expandreleasename2="']";
			
		//For Selecting Requirement
			//for selecting test Case
			public String requirement1="//*[@id='grid-table-map_req']/div[2]/div[";
			public String requirement2="]/div[1]/div/div/input";
		
	/**************************09/08/17***************************************/
		//For click on import
			public String importtype1=".//*[@id='zui-import-modal-choice']/div/div/div[2]/div/button[";
			public String importtype2="]";
			
//			@FindBy(xpath=".//*[@id='zui-import-modal-choice']/div/div/div[2]/div/button[1]")
//			public WebElement chooseImportType;
			//selecting Jira requirements
			public String selectTestCase1=".//*[@id='grid-table-IMPORT_JIRA']/div[2]/div[";
			public String  selectTestCase2="]/div[1]/div/div/input";
			
			//selecting accessType
			public String accessType1=".//li[text()='";
			public String accessType2="']";
			
			//secting JQL querry
			public String selectquerry1=".//li[text()='";
			public String selectquerry2="']";
			
			//For selecting searchDefectsJQL
			@FindBy(xpath=".//*[@id='searchDefectsJQL']")
			public WebElement enterJiraSearchDefectsJQLQuerry;
			
			@FindBy(xpath=".//*[@id='rwalgn{']/span[3]/button")
			public WebElement clickjiraSearchButton;
			
			@FindBy(xpath=".//*[@id='select2-accessType-container']")
			public WebElement chooseAccessTypes;
			
			@FindBy(xpath=".//*[@id='fldrnm']")
			public WebElement clickjiraTopLevelFolderName;
			
			@FindBy(xpath=".//*[@id='zee-import-modal-requirement-jira']/div/div/div[3]/zui-modal-footer/div/button[2]")
			public WebElement clickOnImportSelected;
			
			@FindBy(xpath=".//*[@id='select2-searchChoice-container']")
			public WebElement searchChoiceContainer;
			
			
			//Check Test Case from  Test Case grid
			public String checkTestCase1=".//*[@id='grid-table-map_req']/div[2]/div[";
			public String  checkTestCase2="]/div[1]/div/div/input";
			
			
			//for saving Jira map requirement
			@FindBy(xpath=".//*[@id='zee-map-modal']/div/div/div[3]/zui-modal-footer/div/div/button[2]")
			public WebElement clickOnSavejirareq;
			
			
			/***************************12/08/17****************************/
			//For Mapping TestCases
			@FindBy(xpath="//*[text()='Mapped TestCases']")
			public WebElement clickOnMappedTestCases;
			
			@FindBy(xpath="//*[@id='mapTest']")
			public WebElement clickOnMapTestCase;
			
			@FindBy(xpath=".//*[@id='zee-import-modal-requirement-jira']/div/div/div[1]/div[2]/zui-modal-header-buttons/div/button")
			public WebElement clickOnResetUser;
			
			@FindBy(xpath=".//*[@id='zee-import-modal-requirement-jira']/div/div/div[2]/zui-modal-body/zee-update-defect-user/div/form/div[1]/span[2]/input")
			public WebElement username;
			
			@FindBy(xpath="(//input[@name='password'])[1]")
			public WebElement password;
			
			@FindBy(xpath="(//input[@name='reEnterPassword'])[1]")
			public WebElement reEnterPassword;
			
			/*@FindBy(xpath=".//*[@id='zee-import-modal-requirement-jira']/div/div/div[3]/zui-modal-footer/div/div/button[3]")
			public WebElement update;*/
			
			@FindBy(xpath="(.//*[text()='Update'])[3]")
			public WebElement update;
			
			@FindBy(xpath="(.//button[text()='Save'])[3]")
			public WebElement updateUser;
			
			@FindBy(xpath=".//*[@id='zee-map-modal']/div/div/div[1]/div[2]/button")
			public WebElement closeInstructionWindow;
			
			public String checkRequirement1=".//*[@id='grid-table-req']/div[2]/div[";
			public String checkRequirement2="]/div[1]/div/div/input";
			
			public String mapTestCaseRequirement1=".//*[@id='grid-table-map_tc']/div[2]/div[";
			public String mapTestCaseRequirement2="]/div[1]/div/div/input";
			
			@FindBy(xpath=".//*[@id='grid-table-map_req']/div[2]/div/div[7]/div/div")
			public WebElement remoteLink;
			
}
	

