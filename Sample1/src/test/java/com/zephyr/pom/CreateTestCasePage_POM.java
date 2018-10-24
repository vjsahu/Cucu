package com.zephyr.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zephyr.common.LaunchBrowser;

public class CreateTestCasePage_POM 
{

	WebDriver driver=null;

	
	
	@FindAll({@FindBy(xpath="//div[@class='zui-inline-edit zephyr-editable-field']")})
	public List<WebElement> l1;
	
	@FindBy(xpath="//input[@class='form-control text js-zephyr-inline-edit-text ng-touched ng-pristine ng-valid']")
	public WebElement tcName;

	@FindBy(xpath="//span[@placeholder='Enter name']")
	public WebElement testcaseName;
	@FindBy(xpath="//span[@placeholder='Enter description']")
	public WebElement testcaseDesc;
	
	
	@FindBy(xpath="//h5[text()='Test Step']")
	public WebElement stepDetail;

	
	@FindBy(xpath="//button[contains(.,'+')]")
	public WebElement nextBtn;

	@FindBy(xpath="//h5[text()='Attachment']")
	public WebElement attachements;


	@FindBy(xpath="//*[@id='testcase-estimated-time']//div/div/span")
	public WebElement estimatedTime;
	
	@FindBy(xpath="//*[@id='testcase-estimated-time']/zephyr-inline-edit/div/div/span[1]/zui-estimated-time/div")
	public WebElement validateEstimateTime;
	//public String saveBtn="//button[contains(.,'+')]";
	
	 public String saveBtnInDetailView="(//*[@class='zui-btn zui-btn-primary' and text()='Save'])[2]";
			  
	 public String addTestStep="//textarea[@id='zee-add-step']";
	 public String browse="//span[contains(.,'Browse')]";
	 

	 public String days_1="(//input[@id='dayText'])[2]";
	 public String hour_1="(//input[@id='hourText'])[2]";
	 public String minute="(//input[@id='minuteText'])[2]";
	 
	 
	 //MultipleTestCaseEditField
	 
	 @FindBy(id="zui-modal-trigger-tcr_3")	
	 public WebElement edit_TestCase;
	 
	 @FindBy(xpath="//input[@id='release-externalid']")
	 protected WebElement altId;
	 
	 @FindBy(xpath="//textarea[@id='release-comments']")
	 protected WebElement comments;
	 
	 @FindBy(xpath="(//*[@class='select-control'])[1]")
	 protected WebElement tags;
	 
	 
	
	 
	 
	 @FindBy(xpath="//input[@id='release-automated']")
	 protected WebElement ChkAutomatedScript;
	 
	 @FindBy(xpath="//input[@id='release-scriptname']")
	 protected WebElement scriptName;
	 
	 @FindBy(xpath="//input[@id='release-scriptid']")
	 protected WebElement scriptId;
	 
	 @FindBy(xpath="//input[@id='release-scriptpath']")
	 protected WebElement scriptPath;
	 
	 @FindBy(xpath="//*[@id='tcr-bulk-priority-wrap-']/span/span[1]/span")
	 protected WebElement prioritySeection;
	 
	
	 
	 

	public String priority1=".//li[text()='";
	public String priority2="']";
	 
	public String SaveBtnInMultEdit="(//*[@type='submit'])[2]";
	 
	 public CreateTestCasePage_POM(WebDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(LaunchBrowser.driver,this);
			
		}
	 
	 
	 //Newly Added to delete Attachement
	protected String attachFile1="(//span[@title='";
	protected String attachFile2="'])[1]";
	 
	 @FindBy(xpath="//span[@title='Click to delete this file']")
	 protected WebElement deleteAttachements;
	 
	 @FindBy(xpath="//button[@value='DELETE']")
	 protected WebElement deleteAttachBtn;
	 
	 @FindBy(xpath="//span[contains(@class,'clear')]")
	 protected WebElement eraseTags;
	 
	 

	    //correct Added for multiedit
	    @FindBy(xpath="//*[@name='zcf_1080']")
	    protected WebElement pickuplist;
	    
//	   @FindBy(xpath="//*[@id='1077']/field-input/input")
//	   protected WebElement checkboxField;
//	   
	   //for multi edit
	   @FindBy(xpath="//*[@id='1077']/input")
	   protected WebElement chkBoxFld;
	   
//	   @FindBy(xpath="//*[@id='1079']/field-input/zephyr-inline-edit/div/div/span[1]")
//	   protected WebElement dateFields;
	   
	   //for multi edit
	   @FindBy(xpath="//*[@id='1079']/input")
	   protected WebElement dateFieldsInM;
	 
	 
	 
	 
	 
	 
	 
	 //Single test Case Custom
	   @FindBy(xpath="//div/zee-custom-fields//span[contains(@title, 'CustomText')]/following-sibling::span")
	   protected WebElement customText;
	       
	       @FindBy(xpath="//div/zee-custom-fields//span[contains(@title, 'CustomLongText')]/following-sibling::span")
	    protected WebElement customLongText;
	       
	       @FindBy(xpath="//div/zee-custom-fields//span[contains(@title, 'CustomCheckbox')]/following-sibling::span")
	    protected WebElement customCheckbox;
	       
	       @FindBy(xpath="//div/zee-custom-fields//span[contains(@title, 'CustomNumber')]/following-sibling::span")
	    protected WebElement customNumber;
	       
	       @FindBy(xpath="//div/zee-custom-fields//span[contains(@title, 'CustomDate')]/following-sibling::span")
	    protected WebElement customDate;
	       
	       @FindBy(xpath="(//div/zee-custom-fields//span[contains(@title, 'CustomPicklist')]/following-sibling::span)")
	    protected WebElement customPicklist;
//	   //correct Added
//	   @FindBy(xpath="//*[@name='zcf_1017']")
//	   protected WebElement pickuplist;
//	   
	  @FindBy(xpath="(.//*[@class='zee-testcase-customField-wrapper']//li[2]/div/span[4]")
	  protected WebElement checkboxField;
	  

	  @FindBy(xpath="//*[@id='zee-create-edit-modal-tcr_3']/div/div/div[2]/zui-modal-body/div/div/form/div[3]/button[2]")

	public WebElement saveInAutoScript;
	   
	  @FindBy(xpath="//*[@id='bulk-confirm-modal']/div/div/div[3]/zui-modal-footer/button[2]")
	public WebElement confirmSaveInAutoScript;
	  
	  //@FindBy(xpath="//*[text()='button'])[3]")
	  //protected WebElement saveMsgInEdit;
	 //*[text()='button'])[3]
	  
	  @FindBy(xpath="(//*[@class='select2-hidden-accessible'])[3]")
	  protected WebElement pickuplistField1;
	 
	 
	 @FindBy(xpath="//*[@id='zee-testcase-step-details-module']/div[2]/zephyr-inline-rows-edit/div[2]/button[2]")
	  public WebElement clickStepSave;
	 
	//stepDetail Delete purpose in CreateTestCasePage POM
	 
		 @FindBy(xpath="(//button[text()='Delete'])[3]")
		 protected WebElement deleteBtn;
		 
		 
		 
		 //Estimated Time in ascending order
		 public String etsimatedtime1="//*[@id='grid-table-tcr']/div[2]/div[";
			public String estimatedtime2="]/div[10]/div/div";
			
		
			/************************09/08/17***********************/
		//Estimated Time icon
			@FindBy(xpath=".//*[@id='th-tcr_est_time']/div/div")
			public WebElement EstimatedTimeIcon;
			
		//Estimated sort icon
		@FindBy(xpath=".//*[@id='th-tcr_est_time']/div/i")
		public WebElement sortEstimatedIcon;
		
		
		//modified by srikanth for enterTestCaseStepDetails method in ctc page
		 public String saveBtnConfirm=" //*[@class='save-wrapper']//*[text( )='Save']";	
		 
		 
//		 @FindBy(xpath="(//button[text()='Delete'])[3]")
//		   protected WebElement deleteBtn;
		   
		   @FindBy(xpath="(//*[@id='zee-testcase-details-module-heading']/h5)[6]")
		   public WebElement clickOnStepDetailHistory;
		   
		   @FindBy(xpath="//*[@id='zee-testcase-history-details-module']/div[2]")
		   public WebElement viewStepDetailHistory;
		   
//		   @FindBy(xpath="//*[@id='1019']/field-input/zephyr-inline-edit/div/div/span[1]")
//		   public WebElement clickOnCalender;
		   
		   @FindBy(xpath="//*[text()='                    ']")
		   public WebElement clickOnCalender;
		   
		   @FindBy(xpath="(//span[text()='22'])[3]")
		   public WebElement clickOnDate;
		   
		   @FindBy(xpath="//span[text()='                 List             ']")
		   public WebElement clickOnList;
		   
		   @FindBy(xpath="//*[@id='grid-table-tcr']/div[2]")
		   public WebElement clickOnListPage;
		   
		//   @FindBy(xpath="//*[@id='grid-table-tcr']/div[2]")
		//   public WebElement clickToGetTextInList;
		   
		   @FindBy(xpath="(//div[@class='flex-data-item undefined ellipsis td-show'])[9]")
		   public WebElement clickToGetTextInList;
		   
		   @FindBy(xpath="(//*[@id='zee-testcase-details-module-heading']/h5)[2]")
		   public WebElement customFieldOption;
		   
		   
		   @FindBy(xpath="(//div[@class='zui-inline-dialog'])[2]")
		   public WebElement selectCeckBoxOption;
		   
		   @FindBy(xpath="/html/body/div[2]/div/ul/li[18]/div/label")
		   public WebElement selectDateCheckBox;
		   
		   	 @FindBy(xpath="//*[@id='tcr-bulk-tag-wrap-']/span")
	 public WebElement tagsInBulkEdit;
	 
	 @FindBy(xpath="//*[@id=1014]/field-input/input")
	 public WebElement chk;
		 
		  @FindBy(xpath="//*[text()='Test Detail']")
	   public WebElement clickOnCustomField;
	   
	   @FindBy(xpath="(//input[@type='checkbox'])[42]")
	   protected WebElement detailCheckboxField;
	   
	   @FindBy(xpath="//*[@id='dayText']")
	   protected WebElement estimatedTimeMultiedit;
	   
	   @FindBy(xpath="//*[@id='bulk-confirm-modal']/div/div/div[2]")
	   protected WebElement updatedTcInfo;
	   
	   @FindBy(xpath="//*[text()='Cancel' and @class='zui-btn zui-btn-tertiary']")
	   protected WebElement cancelStepDetails;
	   
	     @FindBy(xpath="//*[@id='1064']/field-input/zephyr-inline-edit/div/div/span[1]")
	   protected WebElement dateField;
	     
	     @FindBy(xpath="//h5[text()='Step Details History']")
	     public WebElement stepDetailsHistory;
	   

	     @FindBy(xpath="(//input[@name='automated'])[2]")
		 protected WebElement ChkAutomatedScriptInDetail;
	     
	     
	     
//	     @FindAll({@FindBy(xpath="//span[@class='zephyr-inline-field-name fourth']")})
//	 	public List<WebElement> automationfield;

	     //ForMultiSelect
	     @FindBy(xpath="//*[@id='zee-create-edit-modal-tcr_3']//ul/li[1]/div/span")
	     protected WebElement customText1;
	        
	          @FindBy(xpath="//*[@id='zee-create-edit-modal-tcr_3']//ul/li[2]/div/span")
	          protected WebElement customlongText1;
	             
	          @FindBy(xpath="//*[@id='zee-create-edit-modal-tcr_3']//ul/li[4]/div/span/input")
	          protected WebElement customChkbox1;
	             
	          @FindBy(xpath="//*[@id='zee-create-edit-modal-tcr_3']//ul/li[5]/div/span")
	          protected WebElement customNumber1;
	             
	          @FindBy(xpath="//*[@id='zee-create-edit-modal-tcr_3']//ul/li[6]/div/span")
	          protected WebElement customDate1;
	             
	          @FindBy(xpath="//*[@class='zee-column-wrap']/span/select")
	          protected WebElement customPicklist1;
	          
	          
	          @FindBy(xpath="//span[@placeholder='Enter alt ID']")
	          protected WebElement enterAltID;
	             
	          @FindBy(xpath="//span[@placeholder='Enter priority']")
	          protected WebElement enterPriority;
	             
	          @FindBy(xpath="//span[@placeholder='Enter comment']")
	          protected WebElement enterComment;
	          
	          @FindBy(xpath="//span[@placeholder='Enter tags']")
	          protected WebElement enterTags;
	     
}
