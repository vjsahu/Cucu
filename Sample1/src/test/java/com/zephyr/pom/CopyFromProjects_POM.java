package com.zephyr.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zephyr.common.LaunchBrowser;

public class CopyFromProjects_POM {

	
	WebDriver driver;
//	
//	@FindBy(xpath="//a[text()='Projects']")
//	public WebElement project;
//	
	
	
	@FindBy(xpath="//*[@data-name='Projects']")
	public WebElement project;
	
	//for selecting release
	public String release1="//a[@data-desc='";
	public String release2="' and text()='";
	public String release3="']";
	
	//for selecting node in localArea
	public String node1="(//a[text()='";
	public String node2="'])[1]";
	
	//for selecting test case in global
	public String globalTestCase1="//*[@id='grid-table-global']/div[2]/div[";
	public String globalTestCase2="]/div[1]/div/div/input";
	
	
	@FindBy(xpath="//h4[text()='Copy from Project Releases']")
	protected WebElement validateCopyFromProjectReleasesPage;

	//For Selecting Project From global Area
	public String globalProject1="//a[text()='";
	public String globalProject2="']";

	//for selecting node in GlobalArea from same release
		public String node3="(//a[text()='";
		
		public String node4="'])[1]";
	
		//for selecting node in GlobalArea from other release
		public String node5="//a[text()='";
		public String node6="']";
		
        public String localRelease1="(//a[@data-name='";
		
		public String localRelease2="'])[2]";
		
		//TestCaseCount
		
		public String testCaseCount="//*[@id='zee-global-tcr-tree-modal']/div/div/div[2]/zui-modal-body/div/div[2]/div/div[3]/grid/div[2]/div/div[2]/b[2]";
		
		
		@FindBy(xpath="//*[@id='zee-global-tcr-tree-modal']/div/div/div[1]/div[2]/button")
		protected WebElement closeCopyFromProjectReleasesPage;
		
		
		public CopyFromProjects_POM(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(LaunchBrowser.driver, this);
		}


     //Selecting node from;looooca area
		public String lnode1="//*[@id='zephyr-tree-localTree']/ul/li/ul//text()='";
		public String lnode2="']";
		
		
		
		public String localNode1="//*[@id='zephyr-tree-localTree']/ul//*[text()='";
		public String localNode2="']";
		
		public String globalNode1="//*[@class='tree-view global-tcr no-child js-global-wrapper expanded-on-hover tree-docked']//*[text()='";
		public String globalNode2="']";
		
		
		//14-08-17
	///////12-8-17
		 
		  
		  //public String globalIMportedNode1="//*[@class='tree-view global-tcr no-child js-global-wrapper']//*[text()='";
		 // public String globalIMportedNode2="']";
		
		public String globalIMportedNode1="((//a[text()='Imported'])[2]/following-sibling::ul//a[starts-with(@data-desc,'FileName : ";
	    public String globalIMportedNode2="')])[1]";
	
		  
		  @FindBy(xpath="//*[@class='tree-view global-tcr no-child js-global-wrapper expanded-on-hover tree-docked']//*[text()='Imported']")
		  public WebElement doubleClickOnImported;
		  
		  public String expandNode="/..";
}



