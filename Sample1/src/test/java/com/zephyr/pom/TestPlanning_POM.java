package com.zephyr.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zephyr.common.LaunchBrowser;

public class TestPlanning_POM 
{
	public TestPlanning_POM(WebDriver driver2) 
	{
		this.driver = driver2;
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		PageFactory.initElements(LaunchBrowser.driver,this);
	}

	WebDriver driver=null;
	
	@FindBy(xpath="//button[@title='Add new cycle']")
	public WebElement createNewCycle;
	
	//@FindBy(xpath="//input[@class='form-control ng-pristine ng-invalid ng-touched']")
	@FindBy(xpath="//input[@formcontrolname='name']")
	public WebElement cycleName;
	
	@FindBy(xpath="//input[@formcontrolname='build']")
	public WebElement build;
	
	//@FindBy(xpath="(//input[@class='form-control ng-untouched ng-pristine ng-valid'])[2]")
	@FindBy(xpath="//input[@formcontrolname='environment']")
	public WebElement environment;
	
	@FindBy(xpath="//input[@formcontrolname='status']")
	public WebElement hideChkbox;
	
	
	@FindBy(xpath="(//div[@class='input-group-addon'])[1]")
	public WebElement startDateOption;
	
	@FindBy(xpath="(//div[@class='input-group-addon'])[2]")
	public WebElement endDateOption;
			
	@FindBy(xpath="//button[text()='Save']")
	public WebElement clickOnSave;
	
	@FindBy(xpath="(//button[text()='Save'])[1]")
	public WebElement clickOnSave1;
	
	//For selecting Any cycle 
	public String cycle1="//*[@data-name='";
	public String cycle2="']";
	
	//@FindBy(xpath="//li[@class='vakata-context-separator']")
	@FindBy(xpath="//div[@class='contextMenuIcon fa fa-ellipsis-v']")
	public WebElement options;
	
	@FindBy(xpath="//a[text()='Add Phase']")
	public WebElement addphase;
	
	@FindBy(xpath="//a[text()='Delete']")
	public WebElement deleteNode;
	
	@FindBy(xpath="//a[text()='Clone']")
	public WebElement cloneCycle;
	
	@FindBy(xpath="//a[text()='Assign']")
	public WebElement assignPhase;
	
	public String btype1="(//div[@class='zui-radio'])[";
	
	public String btype2="]";
	
	@FindBy(xpath="//button[text()='OK']")
	public WebElement clickonOK;
	
	@FindBy(xpath="(//button[text()='Save'])[2]")
	public WebElement clickonSave2;
	
	@FindBy(xpath="//button[text()='Delete']")
	public WebElement confirmDelete;
	
	@FindBy(xpath="//span[text()='Select Assignee']")
	public WebElement select_Assignee;
	
	protected String assignee1="//li[text()='";
	protected String assignee2="']";
	
	@FindBy(xpath="//span[@title='Delete selected testcases']")
	public WebElement deleteselectedtestcases;
	
	@FindBy(xpath="(//span[@title='Update flag of selected testcases'])[1]")
	public WebElement setFlag;
	
	@FindBy(xpath="(//button[text()='Continue'])[2]")
	public WebElement clickOnContinue;
	
	
	@FindBy(xpath="(//span[@title='Update flag of selected testcases'])[2]")
	public WebElement unSetFlag;
	
	@FindBy(xpath="//span[@class='pull-right bulk-assignment-image zui-action-icons cursor-pointer']")
	public WebElement clickOnBulkAssign;
	
	@FindBy(xpath="//span[@class='select2-selection__rendered']")
	public WebElement selectAssignee;
	
//	@FindBy(xpath="//span[@class='pull-right bulk-assignment-image zui-action-icons cursor-pointer']")
//	public WebElement clickOnBulk;
	
	@FindBy(xpath="(//*[text()='Apply to sub folders'])[1]")
	public WebElement clickOnchkBox1;
	
	@FindBy(xpath="(//*[text()='Apply to sub folders'])[2]")
	public WebElement clickOnchkBox2;
	
	@FindBy(xpath="(//*[text()='Apply to sub folders'])[3]")
	public WebElement clickOnchkBox3;
	
	@FindBy(xpath="(//div[@class='check'])[2]")
	public WebElement clickOnRadio2;
	
	@FindBy(xpath="(//div[@class='check'])[3]")
	public WebElement clickOnRadio3;
	
	@FindBy(xpath="//span[@class='pull-left sync-image zui-action-icons cursor-pointer']")
	public WebElement clickOnSynch;
	
	@FindBy(xpath="//input[@id='delete-nodes-testcases']")
	public WebElement clickOnSynchChkBox;
	
	@FindBy(xpath="(//button[text()='Continue'])[1]")
	public WebElement clickOnSynchContinue1;
	
	@FindBy(xpath="(//button[text()='Continue'])[2]")
	public WebElement clickOnSynchContinue2;
	
	@FindBy(xpath="(//*[@class='modal-body'])[9]")
	public WebElement SyncMsg;
	
	@FindBy(xpath="(//button[text()='Ok'])[2]")
	public WebElement clickOnSynchOk;
	
	protected String assignTc1="//*[@id='grid-table-phase']/div[2]/div[";
	protected String assignTc2="]/div[4]/zephyr-inline-edit/div/div/span[1]";
	
	protected String uniqueassignee1="//span[text()='";
	protected String uniqueassignee2="']";
	
	@FindBy(xpath="//*[@name='eas_mode_1_select_assignee']")
	public WebElement notExecuted;
	
	@FindBy(xpath="//*[@name='eas_mode_2_select_assignee']")
	public WebElement unAssigned;
	
	@FindBy(xpath="(//*[@name='eas_mode_3_select_assignee'])[1]")
	public WebElement allunAssigned1;
	
	@FindBy(xpath="(//*[@name='eas_mode_3_select_assignee'])[2]")
	public WebElement allunAssigned2;
	
	@FindBy(xpath="//*[@id='defect-system-select2']")
	public WebElement addphaseToCycle;
	
	@FindBy(xpath=".//*[@id='phase_testcase_select_all']")
	 public WebElement select_all_TestCases;
	///modified
	protected String selectTestcase1="//*[@id='grid-table-phase']/div[2]/div[";
	protected String selectTestcase2="]/div[1]/div/div/input";
	
	//*[@id="grid-table-phase"]/div[2]/div[1]/div[1]/div/div/input
	//Added 31-08-17
	 @FindBy(xpath="//h4[text()='Add New Cycle']")
	 public WebElement verifyAddTestCycle;
	 
	 public String expReults="Add New Cycle";
	
	 //Modified
	 public String startDateHeader="(//*[@class='subform']//table/thead/tr/th[2])[1]";
	 public String endDateHeader="(//*[@class='subform']//table/thead/tr[1]/th[2])[1]";
	 public String year1="//*[text()='";
	 public String year2="']";
	 

		@FindBy(xpath="//span[@class='text-info']")
		public WebElement minYear;
		
		@FindBy(xpath="//button[@class='btn btn-default btn-sm pull-left']")
		public WebElement left;
		
		
		
		
		@FindBy(xpath="//datepicker-inner/div/yearpicker/table/tbody/tr[4]/td[5]")
		public WebElement maxYear;
		
		@FindBy(xpath="//button[@class='btn btn-default btn-sm pull-right']")
		public WebElement right;
	 public String month1="//span[text()='";
	 public String month2="']";
	 
	 public String day1="(//span[text()='";
	 public String day2="'])[2]";
	 
	 public String day_1="(//span[text()='";
	 public String day_2="'])[2]";
	 
	 public String validateTc1="//*[@id='grid-table-phase']/div[2]/div[";
	 public String validateTc2="]/div[4]/zephyr-inline-edit/div/div/span[1]";
	 
	 @FindBy(xpath="//*[@id='bulk-assignment-initial-modal']//zui-modal-footer/button[1]")
	 public WebElement cancelBulkAssign;
	 
	 /*public String startDateHeader="(//*[@class='subform']//table/thead/tr/th[2])[1]";
	 public String endDateHeader="(//*[@class='subform']//table/thead/tr[1]/th[2])[2]";
	 public String year1="//*[text()='";
	 public String year2="']";
	 
	 public String month1="//*[text()='";
	 public String month2="']";
	 
	 public String day1="(//*[text()='";
	 public String day2="'])[3]";
	 
	 public String day_1="(//*[text()='";
	 public String day_2="'])[4]";
	 
	 public String validateTc1="//*[@id='grid-table-phase']/div[2]/div[";
	 public String validateTc2="]/div[4]/zephyr-inline-edit/div/div/span[1]";
	 
	 // Modified
	 @FindBy(xpath="(//button[text()='Cancel'])[6]")
	 public WebElement cancelBulkAssign;
	 //@FindBy(xpath="(//button[text()='Cancel'])[5]")
	 //public WebElement cancelBulkAssign;*/
	 
	 
	 @FindBy(xpath="//*[text()='Edit']")
	 public WebElement edit;
	 
	//added by srikanth on 01/09/17
			@FindBy(xpath=".//*[@class='pull-right selected-star-image zui-action-icons cursor-pointer']")
			public WebElement toggleFlag;
			
			@FindBy(xpath=".//*[@id='ze-main-app']/testcase-eas/testcase-eas-phase/div/div/div/div/div/div[1]/div[1]/span[3]")
			public WebElement resettoggleFlag;
			
			//added on 15/09/17 by srikanth
			@FindBy(xpath=".//*[@id='confirmation-modal']/div/div/div[3]/zui-modal-footer/button[2]")
			 public WebElement toggleContinueOption;
			


			 @FindBy(xpath="(//*[@class='zui-checkbox2']//input)[3]")
				 public WebElement copyAssignmentOver;
			 
			 public String dupCycle1="(//*[@data-name='";
				public String dupCycle2="'])";
				public String dupCycle3="[";
				public String dupCycle4="]";
				
				
				 public String startDateHeader1="(//*[@class='subform']//table/thead/tr/th[2])[1]";
				 public String endDateHeader1="(//*[@class='subform']//table/thead/tr[1]/th[2])[2]";
				 
				 @FindBy(xpath="//*[@id='easCloneNodeModal']//div[2]/div/div/div[1]/div/input")
				 public WebElement keepTheDurationFixedOption;
				 
				 
				 /******************21/09/17 added by Srikanth************************/
				 @FindBy(xpath=".//*[text()='Create New']")
				 public WebElement createNewPhase;
				 
				 @FindBy(xpath=".//*[@id='easAddPhaseModal']/div/div/div[2]/zui-modal-body/div[2]/div/div/div[2]/input")
				 public WebElement addNewPhase;
				 
				 //////////22-9-2017
			     @FindBy(xpath="//button[@title='Click here to add more tests to this phase.']")
			     public WebElement clickOnAddTestcases;
			   
			     @FindBy(xpath=".//*[@id='zui-search-textarea']")
			     public WebElement clickOnSearchTextArea;
			     
			     @FindBy(xpath="//*[text()='Go']")
			     public WebElement clickOnGo;
			     
			     @FindBy(xpath="//input[@name='zui-search-save-all']")
			     public WebElement clickOnSaveAlltestcases;
			     
			     @FindBy(xpath="(//button[text()='Save'])[1]")
			     public WebElement saveTestcases;
			     
			     @FindBy(xpath="(//input[@title='Select All'])[1]")
			     public WebElement selectAllFreeFormTestcases;
			     
			    // @FindBy(xpath="(//button[text()='         Ok         '])[1]") previous
			     @FindBy(xpath="(//button[@class='btn btn-default'])[1]")
			     public WebElement clickOnFreeFormOk;
			     
			     protected String checkTestCase1="//*[@id='grid-table-tcr']/div[2]/div[";
			    protected String checkTestCase2="]/div[1]/div/div/input";
			    
			    @FindBy(xpath="(//*[@class='modal-content'])[10]")
			     public WebElement bulkPopup;
			    
			    @FindBy(xpath="(//button[text()='×'])[4]")
			     public WebElement closeFreeFormPage;
			    
			    //added by srikanth 23/09/17
			       @FindBy(xpath="//*[text()='Quick']")
			        public WebElement quickSearch;
			       
			       //added by srikanth 25/09/17 for entering testcase step details
			       @FindAll({@FindBy(xpath="//div[@class='zui-inline-edit zephyr-editable-field']")})
			   		public List<WebElement> l1;
			       
			       @FindBy(xpath=".//*[@id='node-name']")
			        public WebElement nodeName;
			       
			       @FindBy(xpath=".//*[@id='node-description']")
			        public WebElement nodeDesc;
			       
			       @FindBy(css="body > ul.vakata-context.jstree-contextmenu.jstree-default-contextmenu > li:nth-child(1) > a")
			       public WebElement addNode;
			       
			       @FindBy(xpath=".//*[@id='easAddNodeModal']/div/div/div[3]/zui-modal-footer/button[2]")
			        public WebElement nodeSave;
			       
				    
				  
				    
				    @FindBy(xpath="//span[text()='Advanced']")
				     public WebElement AdvancedSearch;
				    
				    //25-09-2017
				    protected String ele_1="//li[text()='";
		    		protected String ele_2="']";
				  
		    		
		    		@FindBy(xpath="//input[@placeholder='Enter ZQL']")
				     public WebElement enterZql;
		    		
		    		
		    		@FindBy(xpath="(//*[@class='fa fa-ellipsis-v'])[1]")
				     public WebElement enableOrDisable;
		    		//
		    		@FindBy(xpath="//*[@id='zui-freeform-testcase-add-grid-wrapper']/zui-tcr-grid/grid/div[2]/div/div[2]/b[3]")
				     public WebElement testcasecount;
		    		
		    		
		    		
		    		@FindBy(xpath="//div[@data-target-name='browse']")
				     public WebElement clickOnBrowse;
		    		
		    		protected String check1="(//*[@data-name='";
		    		protected String check2="']/i[1])[1]";
		    		
		    		//span[@placeholder='Enter tags']
		    		
		    		@FindBy(xpath="//*[@id='ze-main-app']//testcase-eas-phase-grid/grid/div[2]/div/div[2]/b[3]")
				     public WebElement validateAdd;
		    		
		    		
		    		//27/09/17 added
		    		 @FindBy(xpath="//*[@id='header-parent-phase']//a/i")
				        public WebElement sort;
				       
				       
				       public String sortElement1="(//*[@class='zui-checkbox2']//*[text()='";
				       public String sortElement2="'])";
				       public String sortElement3="[2]";
				       
				       @FindBy(xpath="//*[@id='th-phase_testcase_id']/div/div")
				        public WebElement ID;
				       

			    		///04-10-2017
			    		
			    		@FindBy(xpath="//div[@data-target-name='cycles']")
					     public WebElement clickOnOtherCycles;
			    		
			    		@FindBy(xpath="(//*[@id='zui-eas-freform-add-testcase-modal']//div[1]//select)[1]")
					     public WebElement selectCycle;
			    		
			    		@FindBy(xpath="(//*[@id='zui-eas-freform-add-testcase-modal']//div[1]//select)[2]")
					     public WebElement selectPhase;
			    		
			    		@FindBy(xpath="(//*[@id='zui-eas-freform-add-testcase-modal']//div[1]//select)[3]")
					     public WebElement filterByStatus;
			    		
			    		@FindBy(xpath="//*[@id='zui-eas-freform-add-testcase-modal']/div/div/div[2]//button")
					     public WebElement clickOnGo1;
			    		   	
			    		@FindBy(xpath="//*[@id='zui-freeform-testcase-add-grid-wrapper']//grid/div[2]/div/div[2]/b[3]")
					     public WebElement testcasecount1;
			    		
			    		//04/10/17 added by srikanth
			    		@FindBy(xpath="(//i[@class='fa fa-ellipsis-v'])[1]")
					     public WebElement sortZql;
			    		
			    		@FindBy(xpath=".//*[@id='th-testcase_id']/div/i")
					     public WebElement sortzqlIDs;
			    		
			    		@FindBy(xpath=".//*[@id='th-testcase_id']/div")
				        public WebElement zqlID;
			    		
			    		public String phase1="(//*[@data-name='";
			    		public String phase2="'][1])[2]";
		    		
			    		
			    		/*************************06/10/17****************************/ //added by srikanth
			    		public String enterActualTime1=".//*[@id='grid-table-phase']/div[2]/div[";
			    		public String enterActualTime2="]/div[12]/div/div";
			    		
			    		public String delete1="//*[@id='grid-table-phase']/div[2]/div[";
			    		public String delete2="]/div[14]/div/div[2]/span[2]/span";
			    		
			    		/*****************************11/10/17**************************************/ //added by srikanth
			    		 @FindBy(xpath="//*[text()='Maintain assignments of original schedules']")
					        public WebElement clickOnMaintainassignmentsoforiginalschedules;
			    		
			    		//17-10-2017
				    		@FindBy(xpath="//*[@id='grid-table-tcr']/div[2]/div[1]/div[4]")
						     public WebElement dragEle;
}
