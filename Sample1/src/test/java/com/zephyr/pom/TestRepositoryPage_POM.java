package com.zephyr.pom;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.reusablemethods.BasePage;

public class TestRepositoryPage_POM 
{
	WebDriver driver=null;
	
	BasePage bp;
	
	@FindBy(xpath="//*[@id='tcr-h-resizer-handle']")
	public WebElement dndReleaseArea;
	
//Node Locators
@FindBy(xpath="//div[@class='contextMenuIcon fa fa-ellipsis-v']")
public WebElement options;
	
@FindBy(css="body > ul.vakata-context.jstree-contextmenu.jstree-default-contextmenu > li:nth-child(1) > a")
public WebElement addNode;
	
@FindBy(css="#addNodeName")
public WebElement nodeName;
	
@FindBy(css="#addNodeDescription")
public WebElement nodeDesc;
	
@FindBy(css="#tcrAddNodeModalSave")
public WebElement saveNode;
	

//Test	Case Functionality Locators

@FindBy(xpath="//span[contains(.,'Detail')]")
public WebElement detail_Tab;

//@FindBy(xpath="//span[contains(.,'                 Detail             ')]")
//public WebElement detail_Tab;		

@FindBy(id="zui-modal-trigger-tcr_1")	
public WebElement add_TestCase;

//@FindBy(id="//*[@id='zui-modal-trigger-tcr_1'][1]")	
//public WebElement addNewTestCase;

@FindBy(xpath="//button[contains(.,'Import')]")	
public WebElement import_TestCase;

//Modified//////
@FindBy(xpath="//*[@id='zui-modal-trigger-tcr_2']")	
public WebElement clone_TestCase;

@FindBy(id="zui-modal-trigger-tcr_4")	
public WebElement delete_TestCase;

@FindBy(xpath="(//button[text()='Delete'])[2]")
public WebElement confirmDeleteTestCaseButton;

@FindBy(id="zui-modal-trigger-tcr_3")	
public WebElement edit_TestCase;

@FindBy(id="zui-export-modal-trigger-tcr_5")
public WebElement export_TestCase;

@FindBy(id="testcase_select_all")
public WebElement select_all_TestCase;

@FindBy(xpath="//*[@id='ze-main-app']//zee-list-detail-view/div/div[2]/a")
public WebElement list_Tab;

@FindBy(xpath="//span[contains(.,'Search')]")
public WebElement search_Tab;

/*@FindBy(xpath="//div[contains(.,'Folder')]")*/ //previous
@FindBy(xpath="//span[contains(.,'Folder')]") //modified on 02/11/17
public WebElement folder_Tab;

@FindBy(xpath="//input[@id='tree-view-filter-tcr']")
public WebElement filter_Tab;


//
@FindBy(xpath=".//*[@id='j2_1']/i")
public WebElement exp;

@FindBy(xpath=".//*[@id='j8_1_anchor']/div")
public WebElement option;

@FindAll({@FindBy(xpath="//i[@role='presentation']")})
public List<WebElement> expand;


@FindBy(xpath=".//*[@id='tcr-grid']//b[3]")
public WebElement tcCount;


//For selecting Any Node in Release
public String releasename1="//*[@data-name='";
public String releasename2="']";

//for selecting test Case by passing title
public String testcase1="(//div[@title='";
public String testcase2="'])[1]";

public String addNewTestCase="//*[@id='zui-modal-trigger-tcr_1'][1]";




/*	****************************************************
 * Method Name			: findAndAdd()
 * Purpose				: To Click on the ReleaseName of the Project in Zephyr Application
 * Author				: OPAL
 * Date Created			: 27/06/17
 * Date Modified		:
 * Reviewed By			: 
 * ******************************************************
 */
@FindBy(xpath="(//*[text()='Find and Add'])[2]")
public WebElement findAndAdd;

@FindBy(xpath="//*[@id='zql-search-input-tcr-find-add']")
public WebElement advancedSearch;

@FindBy(xpath="//*[text()='Go']")
public WebElement clickOnGo;

@FindBy(xpath="//*[@id='find-and-add-modal']/div/div/div[2]/zui-modal-body/grid/div[2]/div/div[2]/b[3]")
public WebElement totalNoOfTC;

@FindBy(xpath="//*[@id='find-and-add-modal']/div/div/div[2]/zui-modal-body/grid/div[2]/div/div[2]/b[2]")
public WebElement pageTc;

@FindBy(xpath="//*[@id='find-and-add-modal']/div/div/div[2]/zui-modal-body/grid/div[2]/div/div[2]/b[1]")
public WebElement tcLowerCount;

@FindBy(xpath="//*[@id='find-and-add-modal']/div/div/div[2]/zui-modal-body/grid/div[2]/ul/li[3]/a/span")
public WebElement clickOnNext;

@FindBy(xpath="//*[@id='grid-table-find_add']/div[2]/div[1]/div[1]/div/div/input")
public WebElement clickOnTC;

@FindBy(xpath="(//*[text()='Add'])[2]")
public WebElement clickOnAdd;

@FindBy(xpath="//*[@id='find-and-add-modal']/div/div/div[3]/zui-modal-footer/button[2]")
public WebElement clickAddInDetail;

@FindBy(xpath="//*[@id='find-and-add-modal']/div/div/div[2]/zui-modal-body/grid/div[2]/ul/li[3]/a/span")
public WebElement clickNextInDetail;

//Sorting Locators
@FindBy(xpath="//*[@class='flex-header-item column-chooser-parent dont-sort custom-column-chooser']//i")
public WebElement sortTestCase;



public String moveToNodes="//*[@class='tree-tcr-collapse']";

public TestRepositoryPage_POM(WebDriver driver)
{
		this.driver = driver;
		PageFactory.initElements(LaunchBrowser.driver,this);
		
		
	}

//Srikant_POM Added

//for selecting page Number
public String pagenumber1="(.//option[text()='";
public String pagenumber2="'])";


//@FindBy(xpath=".//*[@id='tcr-grid']/div/zee-list-detail-view/div/div[1]/a/span")
@FindBy(xpath="//div[@class='zui-tcr-list-detail-view']/div[1]/a/span")
public WebElement clickOnDetailView;

@FindBy(xpath="//span[contains(.,'List')]")
public WebElement clickOnListView;

//@FindBy(xpath=".//*[@id='testcase-fullscreen-resizer']/span")
@FindBy(xpath="//div[@id='testcase-details']/div/div[4]/i")
public WebElement clickOnExpander;

//@FindBy(xpath=".//*[@id='grid-table-tcr']/div[2]/div[1]/div[3]/div/div")
@FindBy(xpath=".//*[@id='grid-table-tcr']/div[2]/div[1]/div[4]/div/div")
public WebElement clickOnTestCase;

@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[1]/bread-crumb/div/ul/li[3]/button")
public WebElement clickOnsystem1;

@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[1]/bread-crumb/div/ul/li/b")
public WebElement clickOnShowBreadCrumbs;

@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[1]/bread-crumb/div/ul/li[2]/button")
public WebElement clickOnPhase;

@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[1]/bread-crumb/div/ul/li[1]/button")
public WebElement clickOnRelease;

@FindBy(xpath=".//*[@id='pagination-page-size-tcr']")
public WebElement clickOnPageSize;

@FindBy(xpath=".//*[@id='pagination-page-size-tcr']")
public WebElement clickOnOptions;

@FindBy(xpath=".//*[@id='pagination-page-size-tcr']/option[1]")
public WebElement clickOnOption;

@FindBy(xpath=".//*[@id='tcr-grid']//div/zui-tcr-grid/grid/div[2]/ul/li[3]/a/span")
public WebElement clickOnNextButton;

@FindBy(xpath=".//*[@id='tcr-grid']//div/zui-tcr-grid/grid/div[2]/ul/li[2]/a/span")
public WebElement clickOnPrevButton;

@FindBy(xpath=".//*[@id='tcr-grid']//div/zui-tcr-grid/grid/div[2]/ul/span")
public WebElement clickOnPageNumbers;

//@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li")
public String clickOnPages1="//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[";
public String clickOnPages2="]";

@FindBy(xpath="//*[@class='breadcrumb zui-breadcrumb']")
public WebElement breadCrumbs;

//For custom fields in test case
//@FindBy(xpath="//*[text()='Custom Fields']")
@FindBy(xpath="//*[text()='Test Detail']")
public WebElement customFields;

//@FindBy(xpath="//div/zee-custom-fields//strong[contains(@title, 'CustomText')]/following-sibling::span")
@FindBy(xpath="//div/zee-custom-fields//span[contains(@title, 'CustomText')]/following-sibling::span")
protected WebElement custom1;
    

//@FindBy(xpath=".//*[@id='1002']/field-input/zephyr-inline-edit/div/div/div/form/div[2]/button[2]")
//public WebElement saveCustomField;

//For moving one to another node
@FindBy(xpath="//a[text()='Move']")
protected WebElement moveNode;

@FindBy(xpath="//a[text()='Copy']")
protected WebElement copyNode;


@FindBy(xpath="//a[text()='Paste']")
protected WebElement pasteNode;


//For Advanced search
//@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[2]/div[1]/section/div/zui-zephyr-search/div/zui-zql-search/div/div[2]/div/select")
@FindBy(xpath="//div/zui-zephyr-search/div/zui-zql-search/div/div[2]/div/select")
public WebElement prevSearchDropDown;

//@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[2]/div[1]/section/div/zui-zephyr-search/div/zui-zql-search/div/div[2]/div/select/option")
@FindBy(xpath="//div/zui-zephyr-search/div/zui-zql-search/div/div[2]/div/select/option")
public WebElement clickOnPreviousSearch;

///filter subsystem 27-7-2017
@FindBy(xpath="//input[@id='tree-view-filter-tcr']")
public WebElement clickOnFilter;


/***********24/07/17**************/
//For Navigating Pages
@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[2]/a")
public WebElement clickOnPage2;

@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[3]/a")
public WebElement clickOnPage3;

@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[4]/a")
public WebElement clickOnPage4;

@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[5]/a")
public WebElement clickOnPage5;



//For Mapping Requirements
@FindBy(xpath="//*[text()='Mapped Requirements']")
public WebElement clickOnMappedRequirements;

@FindBy(xpath=".//*[@id='mapTest']")
public WebElement clickOnMapReq;

@FindBy(xpath=".//*[@class='jstree-icon jstree-checkbox']")
public WebElement clickOnReleaseNode;

@FindBy(xpath=".//*[@class='jstree-icon jstree-ocl']")
public WebElement nodeExpander;

/*********************27/07/17**************************/
//For Delete in Detail view
@FindBy(xpath=".//*[@id='zui-modal-trigger-tcr_4']")
public WebElement deleteTestcase;

@FindBy(xpath=".//div[@id='zee-delete-modal-tcr_4']/div/div/div[3]/zui-modal-footer/button[2]")
public WebElement clicksDelete;



@FindBy(xpath=".//*[@id='zui-modal-trigger-tcr_4']/div/div/div[3]/zui-modal-footer/button[2]")
public WebElement deleteMultipleTestCases;

/*********************28/07/17**************************/
//For Deleting Node in Test Repository

@FindBy(xpath="//a[text()='Delete']")
public WebElement deleteNode;

@FindBy(css="#tcrDeleteNodeModalSave")
public WebElement deleteMsg;

@FindBy(xpath=".//*[@id='zee-delete-modal-tcr_4']/div/div/div[3]/zui-modal-footer/button[2]")
public WebElement deleteTestCaseMsg;

//@FindBy(xpath="//a[contains(.,'Rename')]")
//protected WebElement renameNode;

@FindBy(xpath="//input[@name='testcaseNodeName']")
protected WebElement renameNodeText;

@FindBy(xpath="//*[@name='nodeDescription']")
protected WebElement renameNodeDescText;

//@FindBy(xpath="//button[text()='Rename']")
//protected WebElement renameButton;

// for dnd operation


//////06-08-2017
//get testcase name
@FindBy(xpath="//*[@id='zephyr-testcase-panel']/div/div[1]/div/div/zee-panel-content1/div/div/div/zephyr-inline-edit/div/div/span[1]")
public WebElement getTestcaseName;


//Date0-08-17
//Copy from Other Project	
@FindBy(xpath="//a[text()='Copy from Project Releases']")
protected WebElement copyFromProjectReleasesOption;

//14-08-17
@FindBy(xpath=".//*[@class='jstree-icon jstree-checkbox']")
public WebElement clickOnReleaseCheckBox;


@FindBy(xpath="//a[text()='Copy from Project Releases']")
public WebElement copyReleaseOption;


//9-8-2017
@FindBy(xpath="(//i[@class='jstree-icon jstree-ocl'])[1]")
public WebElement releaseArrow;

@FindBy(xpath="(//i[@class='jstree-icon jstree-ocl'])[2]")
public WebElement importArrow;

@FindBy(xpath="//a[@data-name='allFields.xls Sep:05:2017::00:16:30']")
public WebElement selectImportfile;


@FindBy(xpath="(//i[@class='jstree-icon jstree-ocl'])[1]")
public WebElement phaseArrow;

@FindBy(xpath="(//i[@class='jstree-icon jstree-ocl'])[2]")
public WebElement systemArrow;

@FindBy(xpath="(//i[@class='jstree-icon jstree-ocl'])[3]")
public WebElement subSystemArrow;


//////06-08-2017
//get testcase name


//click on phase to drag and drop 5-8-2017
@FindBy(xpath="//*[text()='move' and @data-type='Phase']")
public WebElement clickOnPhaseToDrag;

//click on test case to drag and drop 5-8-2017
@FindBy(xpath="//*[@id='grid-table-tcr']/div[2]/div[2]/div[4]")
public WebElement clickTestcaseToDrag;

@FindBy(xpath="/html/body/ul[2]/li[4]/a")
public WebElement copyImportedFile;

@FindBy(xpath="/html/body/ul[2]/li[2]/a")
public WebElement renameNode;

@FindBy(xpath="//*[@id='testcaseNodeName']")
public WebElement renameField;

@FindBy(xpath="//*[text()='Rename']")
public WebElement renameButton;

@FindBy(xpath="(.//*[@id='1013'])[1]")
protected WebElement textField;

@FindBy(xpath="(.//*[@id='1016'])[1]")
protected WebElement longTextField;

@FindBy(xpath="(.//*[@id='1018'])[1]")
protected WebElement numberField;

// @FindBy(xpath=".//*[@id='1016']/field-textarea/zephyr-inline-edit/div/div/span[1]")
//protected WebElement date;

@FindBy(xpath="//*[@name='zcf_1017']")
protected WebElement pickuplistField;

@FindBy(xpath="//*[@name='zcf_1014']")
protected WebElement checkboxField;

@FindBy(xpath="//*[@id='zee-create-edit-modal-tcr_3']/div/div/div[2]/zui-modal-body/div/div/form/div[3]/button[2]")
 protected WebElement saveInAutoScript;
 
@FindBy(xpath="//*[@id='bulk-confirm-modal']/div/div/div[3]/zui-modal-footer/button[2]")
 protected WebElement confirmSaveInAutoScript;

@FindBy(xpath="//h5[text()='Test Detail']")
public WebElement customFieldButton;


@FindBy(xpath="//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[2]/notifications/div/a/span")
public WebElement moveToNotificationElement;

@FindBy(xpath="/html/body/div[2]/div/notification-list/div[3]/button[2]")
public WebElement applyNotification;

@FindBy(xpath="html/body/ul[2]/li[2]/a")
public WebElement deletesNode;

@FindBy(xpath="//span[contains(.,'Folder')]")
public WebElement folder_tab;

/******************25/08/17***************************/
//adding testcase added by srikanth
@FindBy(xpath=".//*[@id='zui-modal-trigger-testcase_1']")
public WebElement addTestCase;


@FindBy(xpath="(//*[text()='100'])[2]")
public WebElement initCount;

@FindBy(xpath="(//*[text()='200'])")
public WebElement finalCount;


@FindBy(xpath="/html/body/zui-app/section/zee-test-repository/test-repository-component/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/section/zui-tcr-tree/div/tree-view/div/div[2]/div[2]/ul/li[1]")
public WebElement releaseExpand;

public String releasename11="(//*[@data-name='";
public String expandNode="/..)";
}
