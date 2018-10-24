package com.zephyr.reusablemethods;


import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zephyr.common.AutomationConstants;
import com.zephyr.pom.ProjectPage_POM;
import com.zephyr.pom.TestPlanning_POM;

public class ProjectPage extends ProjectPage_POM 
{
	WebDriver driver;
	public Logger log;
	BasePage bp;
	boolean res;
	TestPlanning_POM tp;
	public ProjectPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		log=Logger.getLogger(this.getClass());
	    Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
		BasicConfigurator.configure();
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	
	public boolean clickOnManageRelease() throws Exception
	{
		try
		{
			bp=new BasePage();
		manage_Release_Button.click();
		bp.waitForElement();
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}


	public String fetchRoleMsg() throws Exception
	{
	
		try
		{
	  role=rolemsg.getText();
	  log.info("Role= "+role);
	   
	   return role;
		}
	   catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
public boolean verifyProjecttitle() throws Exception
{
	try
	{
	String proTitle=driver.getTitle();
	log.info("Project Tiltle-"+proTitle);
	return true;
	
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}
//main

/* ****************************************************
   * Method Name   : selectProject(String projectName) 
  * Purpose    : To select Project 
  * Author    : OPAL1
  * Date Created   : 27/07/17
  * Date Modified  :
  * Reviewed By   : Opal4
  * ******************************************************
  */
public boolean selectProject(String projectName) throws Exception 
{
 try
 {
 BasePage bp=new BasePage();
 bp.waitForElement();
 project.isEnabled();
 project.isDisplayed();
 //bp.waitForElement();
 
 WebDriverWait wait2=new WebDriverWait(driver,AutomationConstants.EXPLICIT);
 wait2.until(ExpectedConditions.elementToBeClickable(project));
 bp.moveToElementAndClick(project);
 bp.waitForElement();
 
 
 List<WebElement> allp=projectList;
 boolean res=false;
// System.out.println(allp.size());
 for(int i=0;i<allp.size();i++)
 {
  String  pp=allp.get(i).getAttribute("title");
 
 if(pp.equals(projectName))
 {
  res=true;
  driver.findElement(By.xpath(project1+projectName+project2)).click();
  break;
 }
 }
 if(res==false)
 {
    goToProject.click();
  bp.waitForElement();
  bp.waitForElement();
  bp.waitForElement();
  Actions a1=new Actions(driver);
  a1.sendKeys(projectName).pause(1400).sendKeys(Keys.ENTER).perform();
  
 }
 
 bp.waitForElement();
 
  String validate_Project=driver.findElement(By.xpath(valProject1+projectName+valProject2)).getText();

 if(projectName.equals(validate_Project))
 {

  log.info("Pass - '"+projectName+"' Project Is Selected");
  log.info("Pass - You are in '"+projectName+"' now");
 }
 
 
   return true;
 }
 catch(Exception e)
 {
  e.printStackTrace();
  throw e;
 }
 
}

/* ****************************************************
   * Method Name   : selectRelease(String releaseName) 
  * Purpose    : To select Release
  * Author    : OPAL1
  * Date Created   : 27/07/17
  * Date Modified  :
  * Reviewed By   : Opal4
  * ******************************************************
  */
public boolean selectRelease(String releaseName) throws Exception 
{
	try
	{
	BasePage bp=new BasePage();
	bp.waitForElement();
	bp.waitForElement();
	String validateRelease=driver.findElement(By.xpath(release1+releaseName+release2)).getText();
	driver.findElement(By.xpath(release1+releaseName+release2)).click();
	bp.waitForElement();
	//String validate_Release=validateRelease.getText();
	
	if(releaseName.equalsIgnoreCase(validateRelease))
	   {
		 
			log.info("Pass - You are in the "+releaseName);
			//System.out.println("Pass - You are in the '"+releaseName+"' ");
		}
		else
		{
			log.info("Fail - You are not in the "+releaseName);
			//System.out.println("Fail - you are not in the '"+releaseName+"' ");

		}
	return true;
}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}

	
	
}

/* ****************************************************
   * Method Name   : clickOnLogout()
  * Purpose    : clickOnLogout()
  * Author    : OPAL1
  * Date Created   : 27/07/17
  * Date Modified  :
  * Reviewed By   : Opal4
  * ******************************************************
  */
public boolean clickOnLogout() throws Exception
{
	try
	{
		 bp=new BasePage();
		
	bp.waitForElement();
	user_option.click();
	bp.waitForElement();
	logout.click();
	//driver.findElement(By.xpath("//a[contains(.,'Logout')]")).click();
	bp.waitForElement();
	return true;
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	
}


/* ****************************************************
   * Method Name   : closeBrowser()
  * Purpose    : For closing the browser
  * Author    : OPAL1
  * Date Created   : 27/07/17
  * Date Modified  :
  * Reviewed By   : Opal4
  * ******************************************************
  */
public boolean closeBrowser() throws Exception
{
	try
	{
	driver.quit();
   log.info("Finalising Frmework");
   
   return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	
}



public boolean selectProjectDD(String projectName) throws Exception 
{
	try
	{
	BasePage bp=new BasePage();
	bp.waitForElement();
	project.isEnabled();
	project.isDisplayed();
	bp.waitForElement();
	bp.waitForElement();
	WebDriverWait wait2=new WebDriverWait(driver, 50);
	wait2.until(ExpectedConditions.elementToBeClickable(project));
	project.click();
	bp.waitForElement();
	
	
	
	WebElement ele=driver.findElement(By.xpath("//*[text()='Go to Project']"));
	ele.click();
	bp.waitForElement();
	bp.waitForElement();
	//WebElement el1=driver.findElement(By.xpath("//*[@class='select2-search__field']"));
	//Actions a1=new Actions(driver);
	//a1.moveToElement(el1).sendKeys(projectName).pause(1400).sendKeys(Keys.ENTER).perform();
	String validate_Project=driver.findElement(By.xpath(project1+projectName+project2)).getText();
	 
	if(projectName.equals(validate_Project))
	{

		driver.findElement(By.xpath(project1+projectName+project2)).click();
		//log.info("Pass - "+projectName+"Project Is Selected");
		log.info("Pass - '"+projectName+"' Project Is Selected");
		log.info("Pass - You are in '"+projectName+"' now");
	}
	
	else
	{
		log.info("Fail -Project-'"+projectName+"' is not Available");
		
    }
	  return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	
}



public boolean launchAdministration() throws Exception
{
 
 try
 {
	 boolean val=launchadministration.isEnabled();
	 String expected="System Setup";
	 if(val==true)
	 {
		 launchadministration.click();
		 System.out.println("Pass clicked on administration");
		 String actual=validateAdmin.getText();
		 if(actual.equals(expected))
		 {
			 System.out.println("User in Administration page");
		 }
		 else
		 {
			 System.out.println("user is not in Admin Page");
		 }
	 }
	
 }
 catch(Exception e)
 {
	 e.printStackTrace();
	 throw e;
 }
 return true;
 
}


public boolean launchManageUsers() throws Exception
{
 
 try
 {
	 bp=new BasePage();
	 bp.waitForElement();
	 boolean val=launchManageUsers.isEnabled();
	 String expected="User Setup";
	 if(val==true)
	 {
		 launchManageUsers.click();
		 System.out.println("Pass clicked on manage user");
		 String actual=validatManageuser.getText();
		 if(actual.equals(expected))
		 {
			 System.out.println("User in Manage users page");
		 }
		 else
		 {
			 System.out.println("user is not in Manage users Page");
		 }
	 }
	 bp.waitForElement();
	
 }
 catch(Exception e)
 {
	 e.printStackTrace();
	 throw e;
 }
 return true;
 
}

public boolean selectUser(String userName) throws Exception
{
 
 try
 {
   bp=new BasePage();
   String user=user1+userName+user2;
   WebElement ele=driver.findElement(By.xpath(user));
   WebDriverWait wait=new WebDriverWait(driver,60);
   wait.until(ExpectedConditions.elementToBeClickable(ele));
   ele.click();
   System.out.println(userName + " user selected successfully ");
   bp.waitForElement(); 
 }
 catch(NoSuchElementException e)
 {
   System.out.println(" User " +userName + " is not created  "); 
 }
 
 catch(Exception e)
 {
	 e.printStackTrace();
	 throw e;
 }
 return true;
 
}

public boolean assignProject(String [] projectName) throws Exception
{
  try
 {
    bp=new BasePage();
   
    //System.out.println(res);
    JavascriptExecutor js = ((JavascriptExecutor) driver);
    js.executeScript("arguments[0].scrollIntoView(true);", Save);
    bp.waitForElement();
	
    for(int i=0;i<=projectName.length-1;i++)
     {
             
    try
    { 
    String project=assignProj1+projectName[i]+assignProj2;
    WebElement ele=driver.findElement(By.xpath(project));
    Actions act=new Actions(driver);
    act.moveToElement(ele).click().perform();
    System.out.println("Project-" + projectName[i] + " selected successfully ");
  
    res=true;
    System.out.println(res);
    }
   
    catch(NoSuchElementException e)
     {
    System.out.println("Project- " + projectName[i] + " already assigned to user ");  
    
     }    
     }                     
     
     bp.waitForElement();
     if(res==true)
     {
    Forward.click();
    bp.waitForElement();

    WebDriverWait wait=new WebDriverWait(driver,20);
    wait.until(ExpectedConditions.elementToBeClickable(Save));
    Save.click();
    System.out.println("Project assigned to user successfully ");
    bp.waitForElement();
   
     }
     
       }
  catch(Exception e) 
 {
  e.printStackTrace();
  throw e;
  }
 return true; 
    }





public boolean checkAvailableUser(String user) throws Exception
{
	try
	{
		try
	
	{
	WebElement ele=driver.findElement(By.xpath(user_1+user+user_2));
	Actions a1=new Actions(driver);
	a1.moveToElement(ele).click().perform();
	System.out.println("User is present");
	
	return true;
	}
	catch(NoSuchElementException e)
	{
		System.out.println("User is not present");
		return false;
	}
	
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	
	
}


public boolean createUser(String firstName,String lasTName,String type,String role,String email,String title,String location) throws Exception
{
 try
 {
  bp=new BasePage();
  addNewUser.click();
  bp.waitForElement();
  log.info("Pass - Clicked On Add new User Successfully");
  FirstName.sendKeys(firstName);
  bp.waitForElement();
  log.info("Pass - Entered FirstName Successfully");
  LastName.sendKeys(lasTName);
  bp.waitForElement();
  log.info("Pass - Entered LastName Successfully");
  Select TYPE=new Select(Type);
  TYPE.selectByVisibleText(type);
  bp.waitForElement();
  log.info("Pass - Selected Type Successfully");
  Select ROLE=new Select(Role);
  ROLE.selectByVisibleText(role);
  bp.waitForElement();
  log.info("Pass - Selected Role Successfully");
  Email.sendKeys(email);
  bp.waitForElement();
  log.info("Pass - Entered Email Successfully");
  Title.sendKeys(title);
  bp.waitForElement();
  log.info("Pass - Entered Title Successfully");
  Location.sendKeys(location);
  bp.waitForElement();
  log.info("Pass - Entered Location Successfully");
  boolean val=expireCredential.isSelected();
  if(val==true)
  {
   expireCredential.click();
   System.out.println("Pass-Expire credential un selected");
  }
  else
  {
   System.out.println("Expire credential in selected mode");
  }
  saveNewUser.click();
  bp.waitForElement();
  log.info("Pass - New User is Created Successfully");
  
  return true; 
 }
 catch(Exception e)
 {
  e.printStackTrace();
  throw e;
 }
}









public boolean selectProjectInAdministration(String ProjectName) throws Exception
{

try
{
bp=new BasePage();
String user=pro1+ProjectName+pro2;
WebElement ele=driver.findElement(By.xpath(user));
WebDriverWait wait=new WebDriverWait(driver,60);
wait.until(ExpectedConditions.elementToBeClickable(ele));
ele.click();
System.out.println(ProjectName + "- project selected successfully ");
bp.waitForElement(); 
}
catch(NoSuchElementException e)
{
System.out.println(" Project- " +ProjectName + " is not created  "); 
}
catch(Exception e)
{
	e.printStackTrace();
	throw e;
}
return true;

}

public boolean assignResource(String resource) throws Exception
{
try
{
 	bp=new BasePage();
 	JavascriptExecutor js = ((JavascriptExecutor) driver);
    js.executeScript("arguments[0].scrollIntoView(true);", Save);
    bp.waitForElement();
    WebDriverWait wait=new WebDriverWait(driver,60);
    Actions act=new Actions(driver);
    act.moveToElement(searchUnassignProject).click().sendKeys(resource).build().perform();
    searchButton1.click();
    boolean check=unSelected.isSelected();
    if(check==false)
    {
    	unSelected.click();
	    Forward.click();
	    wait.until(ExpectedConditions.elementToBeClickable(Save));
	    Save.click();
	    bp.waitForElement();
	    System.out.println("Project -" + resource + "- assigned to Project successfully ");
   }
    else
    {
	   System.out.println("Project " + resource + " already selected ");
	   Forward.click();
	   wait.until(ExpectedConditions.elementToBeClickable(Save));
	   Save.click();
	   bp.waitForElement();
	   System.out.println("Project- " + resource + " assigned to Project successfully ");  
  }
}
catch(Exception e) 
{
System.out.println("Project -" + resource + " doesnt exist");
}
return true; 
}
public boolean unAssignResource(String resource)
{
try
{
   bp=new BasePage();
   JavascriptExecutor js = ((JavascriptExecutor) driver);
   js.executeScript("arguments[0].scrollIntoView(true);", Save);
   bp.waitForElement();
   WebDriverWait wait=new WebDriverWait(driver,60);
   Actions act=new Actions(driver);
   act.moveToElement(searchAssignProject).click().sendKeys(resource).build().perform();
   searchButton2.click();
   boolean check=Selected.isSelected();
   if(check==false)
   {
	   Selected.click();
	   Backward.click();
	   wait.until(ExpectedConditions.elementToBeClickable(Save));
	   Save.click();
	   bp.waitForElement();
	   System.out.println("Project- " + resource + " unassigned to project successfully ");
   }
   else
   {
	   System.out.println("Project- " + resource + " already selected ");
	   Backward.click();
	   wait.until(ExpectedConditions.elementToBeClickable(Save));
	   Save.click();
	   bp.waitForElement();
	   System.out.println("Project " + resource + " unassigned to projct successfully ");  
  } 
}
catch(Exception e)
{
System.out.println("Project -" + resource + "doesnt exist" );
}
return true; 
}



public boolean launchManageprojects() throws Exception
{

try
{
 boolean val=launchManageProjects.isEnabled();
 String expected="Project Setup";
 if(val==true)
 {
	 launchManageProjects.click();
	 System.out.println("Pass clicked on manage projects");
	 String actual=validatManageprojects.getText();
	 if(actual.equals(expected))
	 {
		 System.out.println("User in Manage projects page");
	 }
	 else
	 {
		 System.out.println("user is not in Manage projects Page");
	 }
 }

}
catch(Exception e)
{
 e.printStackTrace();
 throw e;
}
return true;

}

public boolean deleteProject(String projectName) throws Exception
{
try
{
bp=new BasePage();
WebElement project=driver.findElement(By.xpath(project1+projectName+project2));
System.out.println(projectName);
WebDriverWait wait=new WebDriverWait(driver,60);
String data=project.getText();
System.out.println(data);
if(data.equals(projectName))
{
bp.waitForElement();
JavascriptExecutor js=((JavascriptExecutor)driver);
js.executeScript("arguments[0].scrollIntoView(true);",project );
project.click();
WebElement delete=driver.findElement(By.xpath(delete3+projectName+delete4));
wait.until(ExpectedConditions.elementToBeClickable(delete));
delete.click();
wait.until(ExpectedConditions.visibilityOf(OK1));
OK1.click();
wait.until(ExpectedConditions.visibilityOf(Delete1)); 
Delete1.click();
bp.waitForElement();
System.out.println("Project -" + projectName +  "- deleted successfully");
}
}
catch(Exception e)
{
e.printStackTrace();
throw e;
}
return true;
}


public boolean validateProject(String project)
{
try
{
WebElement  Project=driver.findElement(By.xpath(Project1+project+Project2));
String data=Project.getText();
System.out.println("Project- " + data + " already present");
return true;
}
catch(NoSuchElementException e)
{
 System.out.println("Project- " + project + " not present");
return false;
}
}
public boolean createProject(String project,String description,String typeName,String lead,String mapDefectProject, String [] startDate , String  [] endDate ,String shareCheckbox) throws Exception
{
try
{
bp=new BasePage();
tp=new TestPlanning_POM(driver);
bp.waitForElement();
WebDriverWait wait=new  WebDriverWait(driver,60);
Actions act=new Actions(driver);
wait.until(ExpectedConditions.elementToBeClickable(addProject));
addProject.click();
bp.waitForElement();
wait.until(ExpectedConditions.elementToBeClickable(projectName));
act.moveToElement(projectName).click().sendKeys(project,Keys.ENTER).build().perform();
wait.until(ExpectedConditions.elementToBeClickable(descript));
act.moveToElement(descript).click().sendKeys(description,Keys.ENTER).build().perform();
Select sel=new Select(leadRole);
sel.selectByVisibleText(lead);
System.out.println("Project assigned to -"+ lead +" successfully");
bp.waitForElement();

if(!mapDefectProject.equals(""))
{
   Select sel2=new Select(defectProject);
   sel2.selectByVisibleText(mapDefectProject);
   bp.waitForElement();
}

tp.startDateOption.click();
bp.waitForElement();
Actions a2=new Actions(driver);
a2.moveToElement(startDateHeader).doubleClick().perform();
bp.waitForElement();
year.click();         
bp.waitForElement();
String startYear=minYear.getText();
int syear=Integer.parseInt(startYear);
int [] start=new int[1];
start[0]=Integer.parseInt(startDate[0]);

if(start[0] < syear)
{
 left.click();
 bp.waitForElement();
 
}
driver.findElement(By.xpath(tp.year1+startDate[0]+tp.year2)).click();
bp.waitForElement();
bp.waitForElement();
driver.findElement(By.xpath(tp.month1+startDate[1]+tp.month2)).click();
bp.waitForElement();
driver.findElement(By.xpath(day1+startDate[2]+day2)).click();
bp.waitForElement();
System.out.println("Start date entered successfully"); 

tp.endDateOption.click();
bp.waitForElement(); 
Actions a3=new Actions(driver);
a3.moveToElement(endDateHeader).doubleClick().perform();
bp.waitForElement();
year.click();  
bp.waitForElement();
String endMin=minYear.getText();
String endMax=maxYear.getText();
int eMin=Integer.parseInt(endMin);
int eMax=Integer.parseInt(endMax);
int [] end=new int[1];
end[0]=Integer.parseInt(endDate[0]);

if(end[0] < eMin)
{
 left.click();
 bp.waitForElement();
}
else if(end[0] > eMax) 
{
 right.click();
    bp.waitForElement();

}

driver.findElement(By.xpath(tp.year1+endDate[0]+tp.year2)).click();
bp.waitForElement();
driver.findElement(By.xpath(tp.month1+endDate[1]+tp.month2)).click();
bp.waitForElement();
driver.findElement(By.xpath(day1+endDate[2]+day2)).click();
bp.waitForElement();
System.out.println("End date entered successfully");

String name=type.getText();
//System.out.println(name);
if(!name.equals(typeName))
{
 wait.until(ExpectedConditions.elementToBeClickable(type));
 type.click();
 bp.waitForElement();
 WebElement ele=driver.findElement(By.xpath(type1+typeName+type2));
 wait.until(ExpectedConditions.visibilityOf(ele));
 ele.click();
 wait.until(ExpectedConditions.elementToBeClickable(typeOk));
 typeOk.click();
 bp.waitForElement(); 
}
 
if(!shareCheckbox.equals(""))
  {
     shareBox.click();
     bp.waitForElement();
     wait.until(ExpectedConditions.visibilityOf(Yes));
     Yes.click();
     bp.waitForElement();
     System.out.println("Check box selected successfully ");
  }
bp.waitForElement();
wait.until(ExpectedConditions.elementToBeClickable(add));
add.click();
System.out.println("Project -" + project + " created successfully ");
bp.waitForElement();
}
catch(Exception e)
  {
e.printStackTrace();
throw e;
  }
return true;
}
}
