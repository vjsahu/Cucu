package com.zephyr.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zephyr.common.LaunchBrowser;

public class ReleasePage_POM
{
	WebDriver driver=null;
	
	
	@FindBy(xpath="//span[text()='Test Repository']")      
	public WebElement testRepository;
//	@FindBy(xpath="//*[@id='sidr']//ul/li[2]/a/span[2]")
//	public WebElement testRepository;
	
	@FindBy(xpath="//span[text()='Test Repository']") 
	public WebElement validateRepository;
	
	@FindBy(xpath="//*[@id='ze-main-app']//zee-list-detail-view/div/div[2]/a")
	public WebElement list_Tab;
	
	//@FindBy(xpath="//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[1]/h3/b")
//	@FindBy(xpath="//*[@id='sidr']//ul/li[2]/a/span[2]")
//	public WebElement validateRepository;
	
	@FindBy(xpath="//span[text()='Requirements']")//
	 public WebElement requirements;//
	 
	 @FindBy(xpath="//span[text()='Requirements']")//
	 public WebElement validateRequirements;
	//Added
//	@FindBy(xpath=".//*[@id='sidr']//ul/li[1]/a/span[2]")//
//	 public WebElement requirements;//
//	 
//	 //@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-requirements/test-requirements-component/div[1]/div[1]/div[1]/h3/b")//
//	 @FindBy(xpath=".//*[@id='sidr']//ul/li[1]/a/span[2]")
//	 public WebElement validateRequirements;//
	
	public ReleasePage_POM(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(LaunchBrowser.driver,this);
		
	}
	
	
	 @FindBy(xpath="//span[@title='Add New Release']")
	   public WebElement clickOnAddNewRelease;
	 
	 
	 @FindBy(xpath="(//div[@class='input-group-addon'])[1]")
		public WebElement startDateOption;
	  
	  public String startDateHeader="//*[@id='release-startdate']//table/thead/tr[1]/th[2]";
		 public String endDateHeader="//*[@id='release-enddate']//table/thead/tr[1]/th[2]";
		 public String year1="//*[text()='";
		 public String year2="']";
		 
		 public String month1="//*[text()='";
		 public String month2="']";
		 
		 public String day1="(//*[text()='";
		 public String day2="'])[1]";
		 
		 public String day_1="(//*[text()='";
		 public String day_2="'])[1]";
		 
		 @FindBy(xpath="(//div[@class='input-group-addon'])[2]")
			public WebElement endDateOption;
		 
		 @FindBy(xpath = "//span[@class='text-info']")
			public WebElement minYear;

			@FindBy(xpath = "//button[@class='btn btn-default btn-sm pull-left']")
			public WebElement left;

			@FindBy(xpath = "//datepicker-inner/div/yearpicker/table/tbody/tr[4]/td[5]")
			public WebElement maxYear;

			@FindBy(xpath = "//button[@class='btn btn-default btn-sm pull-right']")
			public WebElement right;
			
			
			
			   
			   @FindBy(xpath="(//button[text()='Continue'])[4]")
			   public WebElement addNewReleaseContinue;
			   
			   @FindBy(xpath="//input[@placeholder='Enter name']")
			   public WebElement enterReleaseName;
			   
			   @FindBy(xpath="//textarea[@placeholder='Enter description']")
			   public WebElement enterReleaseDescription;
			   
			   @FindBy(xpath="//input[@name='status']")
			   public WebElement releaseHide;
			   
			   @FindBy(xpath="//*[@id='ze-main-app']/release-setup//div[1]/div[2]/div[1]/div//select")
			   public WebElement mapExternalDefect;
			   
			   @FindBy(xpath="//button[text()=' Add']")
			   public WebElement addRelease;
			   
			   public String release1="//*[text()='";
			     public String release2="']";
			     
			     
			     @FindBy(xpath="//button[contains(.,'Add')]")
					public WebElement clickOnAdd;
			     
			     @FindBy(xpath="//span[text()='Manage Release']")
			     public WebElement clickOnManageRelease;
			     
			     

}
