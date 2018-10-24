package com.zephyr.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zephyr.common.LaunchBrowser;

public class ExportPage_POM 
{
	WebDriver driver=null;
	
	@FindBy(xpath="//div[@class='contextMenuIcon fa fa-ellipsis-v']")
	public WebElement options;
	
	@FindBy(xpath="//h4[contains(.,'Customize and Export Reports')]")
	protected WebElement exportPage;
	
	@FindBy(xpath="//input[@id='zui-export-checkbox-select-all']")
	protected WebElement allselectFieldchkBox;
	
	@FindBy(xpath="//a[text()='Unselect All']")/////added////////////////////////////
	protected WebElement allunselectFieldchkBox;
	
	@FindBy(xpath="//div[@id='zui-scroll-heading-tcr_5-101']")
	protected WebElement coverageOption;
	
	@FindBy(xpath="//div[text()='Creation Date']")  //added/////////////////////////////////////////////////
	protected WebElement CreationDateOption;
	
	@FindBy(xpath="/html/body/zui-app/section/zee-test-repository/test-repository-component/div[2]/div[2]/div/div/div[1]/div/div/div/div[3]/div/zui-tcr-bulk-operations/div/zee-export-dialog/zui-export/zui-modal[1]/div/div/div/div[2]/zui-modal-body/div[2]/fieldset/div[2]/div[2]/div/div[2]/div/div/a/i")
	public WebElement startDate;
	
	@FindBy(xpath="/html/body/div[3]/div/datepicker/datepicker-inner/div/daypicker/table/tbody/tr[4]/td[6]")
	public WebElement selectDate;
	
	@FindBy(xpath="/html/body/zui-app/section/zee-test-repository/test-repository-component/div[2]/div[2]/div/div/div[1]/div/div/div/div[3]/div/zui-tcr-bulk-operations/div/zee-export-dialog/zui-export/zui-modal[1]/div/div/div/div[2]/zui-modal-body/div[2]/fieldset/div[2]/div[2]/div/div[3]/div/div/a")
	public WebElement Enddate;
	
	@FindBy(xpath="/html/body/div[3]/div/datepicker/datepicker-inner/div/daypicker/table/tbody/tr[4]/td[8]/button")
	public WebElement selectEndDate;
	
	@FindBy(xpath="//div[@id='zui-scroll-heading-tcr_5-103']")
	protected WebElement priorityOption;
	
	@FindBy(xpath="//div[@id='zui-scroll-heading-tcr_5-104']")
	protected WebElement creatorOption;
	
	@FindBy(xpath="//div[@id='zui-scroll-heading-tcr_5-105']")
	protected WebElement m_aOption;
	
	@FindBy(xpath="//input[@value='Testcase Report']")
	protected WebElement testCaseReportTitle;
	
	@FindBy(xpath=".//*[@id='zui-export-modal-tcr_5']/div/div/div[3]/zui-modal-footer/button[2]")
	public WebElement exportSave;
	
	@FindBy(xpath=".//*[@id='zui-export-modal-tcr_5-download']/div/div/div[3]/zui-modal-footer/button[2]")
	protected WebElement exportDownload;
	
	
	public String nodeExport="//a[contains(.,' Export Tests')]";
	
	public String exportfields="//*[@class='zui-export-label control-label']";
	
	public String selectfields1="//*[@value='";
	public String selectfields2="']";
			
	
	public String coverage1="//span[@for='zui-export-radio-binary-101-";
	public String coverage2="']";
	
	public String m_a1="//span[@for='zui-export-radio-binary-105-";
    public String m_a2="']";
    
    public String reportType1="(//*[@class='zui-export-label control-label'])[";
    public String reportType2="]";
    
    public String outputType1="(//*[@class='zui-export-label control-label'])[";
    public String outputType2="]";
    
    
    public String priorityField="//input[@placeholder='Select Filter Priority']";
    
    public String creatorField="//input[@placeholder='Select Filter Creator']";
    
	public String output1="//*[text()='";
	public String output2="']";
	
	//public String testcase1="//div[@title='";
	//public String testcase2="']";
	
	
	
	
	//Search And Export
	@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[2]/div[1]")
	public WebElement clickOnSearch;

	@FindBy(xpath=".//*[@id='zui-search-textarea']")
	public WebElement clickOnSearchTextArea;
	
	@FindBy(xpath="//zui-zephyr-search/div[1]/div[2]/div/button")
	public WebElement clickOnGoButton;
	
	//@FindBy(xpath=".//*[@id='zui-export-modal-trigger-tcr_5']")
	//public WebElement clickOnExportOption;
	
	@FindBy(xpath=".//*[@id='in-release']")
	protected WebElement inTheseReleaseOption;
	
	@FindBy(id="zui-export-modal-trigger-tcr_5")
	public WebElement export_TestCase;

	//Check Test Case from  Test Case grid
	public String checkTestCase1=".//*[@id='grid-table-tcr']/div[2]/div[";
	public String  checkTestCase2="]/div[1]/div/div/input";
	
	//checkTestCase from Search Grid
	public String checkSearchedTestCase1="//*[@id='grid-table-tcr']/div[2]/div[";
	public String checkSearchedTestCase2="]/div[1]/div/div/input";
	
	//For moving to phase
	protected String phasename1="//*[@data-name='";
	protected String phasename2="']";
	
	
	
	@FindBy(xpath=".//*[@id='zui-export-modal-trigger-tcr_5']")
	 public WebElement clickOnExportOption;
	@FindBy(xpath=".//*[@id='zui-export-modal-tcr_5']/div/div/div[3]/zui-modal-footer/button[2]")
	 public WebElement clickOnSave;

	 //@FindBy(xpath=".//*[@id='grid-table-tcr']/div[2]/div/div[1]/div/div/input")
	  @FindBy(xpath=".//*[@id='zui-export-modal-tcr_5-download']/div/div/div[3]/zui-modal-footer/button[2]")
	  public WebElement clickOnDownload;
	  
	  
	  @FindBy(xpath=".//*[@id='in-release']")
	  public WebElement clickOnRelease;
	  
	  
	 
		
		
		
		
	public ExportPage_POM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(LaunchBrowser.driver, this);
		
	}

    //For Export Page Verification
	protected String exportPageTitle="Customize and Export Reports";
	
	
	
	
	//Date_POMs
	@FindBy(xpath="//div[text()='Creation Date']")  //added/////////////////////////////////////////////////
	public WebElement dateFieldOption;
	 
	 @FindBy(id="zui-export-text-filter-dateRange-from")  //added/////////////////////////////////////////////////
	 protected WebElement startDateOption;
	 
	 @FindBy(id="zui-export-text-filter-dateRange-to")  //added/////////////////////////////////////////////////
	 protected WebElement endDateOption;
	 
	 @FindBy(xpath="//*[@id='zui-export-text-filter-dateRange-from']")  //added/////07-09-2017////////////////////////////////////////////
	 protected WebElement starDate1;
	 
	 @FindBy(xpath="//*[@id='zui-export-text-filter-dateRange-to']")  //added/////////////////////////////////////////////////
	 protected WebElement endDate1;
	 
	 public String start_date11="(//span[text()='";
			 public String start_date22="'])[3]";
			 

			 public String end_date11="(//span[text()='";
					 public String end_date22="'])[3]";
	
}
