package com.zephyr.pom;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zephyr.common.LaunchBrowser;

public class ProjectPage_POM 
{

	WebDriver driver=null;

 @FindBy(xpath="//*[@id='projectDropDown']")
 public WebElement project;
 
 @FindBy(id="//*[@id='ze-main-app']/zee-projects/zee-project/div/div[1]/div[1]/h3/b")
 public WebElement validateproject;
 
 @FindBy(xpath="//*[@id='ze-main-app']/zee-release/zee-release-wrapper/div/div[1]/div[1]/h3/b")
 public WebElement validateRelease;
 
 @FindBy(xpath="//*[@id='ze-main-app']/top-nav/header/div/ul[1]/li[1]/span")
 public WebElement rolemsg;
 
 @FindBy(xpath="//span[contains(.,'Manage Release')]")
 public WebElement manage_Release_Button;
 
 @FindBy(xpath="//i[@class='fa fa-user-circle-o']")
 public WebElement user_option;
 
 @FindBy(xpath="//a[contains(.,'Logout')]")
 public WebElement logout;
 
 
	
//@FindBy(xpath="//b[@role='presentation']")
//private WebElement selectReleasedd;
 
 public String role;

 //For Selecting Project
protected String project1="(//a[@title='";
protected String project2="'])";

//For Selecting Release
protected String release1="//*[text()='";
protected String release2="' and @class='zui-link grid_link_click release_name']";



@FindAll({ @FindBy(xpath = "(//*[@aria-labelledby='projectDropDown'])/a") })
public List<WebElement> projectList;

@FindBy(xpath = "//*[text()='Go to Project']")
public WebElement goToProject;

protected String valProject1 = "//span[@id='projectDropDown']//span[text()='";// modified
protected String valProject2 = "']";


public ProjectPage_POM(WebDriver driver) 
{
  this.driver = driver;
  PageFactory.initElements(LaunchBrowser.driver,this );

}


@FindBy(xpath="//a[@id='adminlink']")
public WebElement launchadministration;

@FindBy(xpath="//span[text()='System Setup']")
public WebElement validateAdmin;

@FindBy(xpath="//span[text()='User Setup']")
public WebElement launchManageUsers;

@FindBy(xpath="//span[text()='User Setup']")
public WebElement validatManageuser;

public String user1="//div[text()='";
public String user2="']/../../..";

@FindBy(xpath="//span[@class='forward-image']")
public WebElement Forward;

@FindBy(xpath="//button[text()='Save']")
public WebElement Save;

public String assignProj1="//div[@class='unselected-list'] //label[text()='";
public String assignProj2="']";

public String user_1="//*[@id='grid-table-resource']//*[text()='";
public String user_2="']";

@FindBy(xpath="//*[@id='ze-main-app']/resource-management/resource-management-details/div/section/div[2]/button")
public WebElement addNewUser;

@FindBy(xpath="//*[@id='resource-firstname']")
public WebElement FirstName;

@FindBy(xpath="//*[@id='resource-lastname']")
public WebElement LastName;

@FindBy(xpath="//*[@id='resource-type']")
public WebElement Type;

@FindBy(xpath="//*[@id='resource-roles']")
public WebElement Role;

@FindBy(xpath="//*[@id='resource-email']")
public WebElement Email;

@FindBy(xpath="//*[@id='resource-title']")
public WebElement Title;

@FindBy(xpath="//*[@id='resource-location']")
public WebElement Location;

@FindBy(xpath="//button[@class='zui-btn zui-btn-primary'][@type='submit'][text()='Save']")
public WebElement saveNewUser;

@FindBy(xpath="//*[@id='resource-credentialsExpired']")
public WebElement expireCredential;





public String pro1="(//*[text()='";
public String pro2="'])[2]";


@FindBy(xpath="(//input[@placeholder='Search for...'])[2]")
public WebElement searchUnassignProject;

@FindBy(xpath="(//span[@class='fa fa-search'])[2]")
public WebElement searchButton1;

@FindBy(xpath="//input[@id='unselecteedList']")
public WebElement unSelected;



@FindBy(xpath="(//input[@placeholder='Search for...'])[3]")
public WebElement searchAssignProject;

@FindBy(xpath="(//span[@class='fa fa-search'])[3]")
public WebElement searchButton2;

@FindBy(xpath="//input[@id='selectedList']")
public WebElement Selected;

@FindBy(xpath="//span[@class='backward-image']")
public WebElement Backward;



@FindBy(xpath="//span[text()='Project Setup']")
public WebElement launchManageProjects;

@FindBy(xpath="//span[text()='Project Setup']")
public WebElement validatManageprojects;

@FindBy(xpath="//button[text()='OK']")
public WebElement OK1;

@FindBy(xpath="//button[text()='Delete']")
public WebElement Delete1;


@FindBy(xpath="//span[text()='Project Setup']")
public WebElement ManageProjects;

public String delete3="(//*[text()='";
public String delete4="'])[2]/../../..//div[8]//div[2]";


@FindBy(xpath="//span[text()='Project Setup']")
public WebElement manageProject;

@FindBy(xpath="//button[text()='+']")
public WebElement addProject;

@FindBy(xpath="//input[@placeholder='Enter name']")
public WebElement projectName;

@FindBy(xpath="//input[@placeholder='Enter description']")
public WebElement descript;

@FindBy(xpath="//div/label[@for='project-lead']/following-sibling::div//select")
public WebElement leadRole;

@FindBy(xpath="//button[text()='Add']")
public WebElement add;

@FindBy(xpath="//div/label[@for='project-externalSystem']/following-sibling::div//select")
public WebElement defectProject;

@FindBy(xpath="//input[@id='sharecheckbox']")
public WebElement shareBox;

@FindBy(xpath="//button[text()=' Yes ']")
public WebElement Yes;

@FindBy(xpath="//span[@class='text-info']")
public WebElement minYear;

@FindBy(xpath="//button[@class='btn btn-default btn-sm pull-left']")
public WebElement left;


@FindBy(xpath="//button[@class='btn btn-default btn-secondary btn-sm']")
public WebElement startDateHeader;


@FindBy(xpath="//button[@class='btn btn-default btn-secondary btn-sm']")
public WebElement endDateHeader;

@FindBy(xpath="(//button[@class='btn btn-default'])[19]")
public WebElement maxYear;

@FindBy(xpath="//button[@class='btn btn-default btn-sm pull-right']")
public WebElement right;


@FindBy(xpath="//button[@class='btn btn-default btn-sm']")
public WebElement year;

public String day1="//span[text()='";
 public String day2="']";
 
 @FindBy(xpath="//a[text()='Normal ']")
 public WebElement type;
 
 public String type1="//span[text()='";
 public String type2="']";
 
 
 @FindBy(xpath="//button[@type='button'][text()='OK']")
 public WebElement typeOk;
 
 public String Project1="//div[text()='";
 public String Project2="']";

}
