package com.zephyr.reusablemethods;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.zephyr.pom.CopyFromProjects_POM;

public class CopyFromProjects extends CopyFromProjects_POM
{

	WebDriver driver;
	BasePage bp;
	 public Logger log;
	 
	public CopyFromProjects(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		log=Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
		BasicConfigurator.configure();
	}


	public boolean dragAndDropTestCase(WebElement ele,String node) throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		WebElement nodes=driver.findElement(By.xpath(localNode1+node+localNode2));
		String text=nodes.getText();
		System.out.println(text);
		Actions a1=new Actions(driver);
		a1.moveToElement(ele).clickAndHold(ele).perform();
		a1.release(nodes).perform();
		
		log.info("Test case moved to the node");
		//a1.dragAndDrop(ele, nodes).perform();
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
		
	}
	
	public boolean dragAndDropNodes(String nodeName1,String nodeName2) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
		WebElement ele1=driver.findElement(By.xpath(globalNode1+nodeName1+globalNode2));
		WebElement ele2=driver.findElement(By.xpath(localNode1+nodeName2+localNode2));
		Actions a2=new Actions(driver);
		a2.dragAndDrop(ele1, ele2).perform();
		
		log.info("Nodes moved sucessfully");
		return true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	public void copyFromProjectReleasesOption()
	{
		
	}
	
	public boolean verifyCopyFromProjectPage() throws Exception
	   {
		   try
		   {
			   bp=new BasePage();
			   bp.waitForElement();
			   
			   String validateCopyFromProjectReleasesPageTitle=validateCopyFromProjectReleasesPage.getText();
			   System.out.println(validateCopyFromProjectReleasesPageTitle);
			  if(validateCopyFromProjectReleasesPageTitle.equals("Copy from Project Releases"))
			  {
				  log.info("Pass-Successfully navigated to Copy From Project Releases Page");
			  }
			  else
			  {
				  log.info("Fail-You are not navigated to Copy From Project Releases Page");
			  }
			  
			  return true;
		   }
		   catch(Exception e)
			{
	 	    e.printStackTrace();
	 	     throw e;
			}
	   }
	
	public boolean selectProjectFromGlobalArea(String projectName) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
		//WebElement pro=driver.findElement(By.xpath("//*[@data-name='Projects']"));
		Actions a2=new Actions(driver);
		a2.doubleClick(project).build().perform();
		bp.waitForElement();
		String globalProject=globalProject1+projectName+globalProject2;
		WebElement ele=driver.findElement(By.xpath(globalProject));
		Actions act=new Actions(driver);
		act.doubleClick(ele).build().perform();
		
		log.info(projectName+" is selected");
		return true;
		}
		 catch(Exception e)
		{
 	    e.printStackTrace();
 	     throw e;
		}
		
	}
	
	public boolean selectNodeFromGlobalArea(String releaseName,String[] nodes) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
		String globalRelease=globalNode1+releaseName+globalNode2;
		WebElement ele=driver.findElement(By.xpath(globalRelease));
		Actions act=new Actions(driver);
		act.doubleClick(ele).build().perform();
		
		log.info("Pass - Double click on'"+releaseName+"' Successfull");
		bp=new BasePage();
		bp.waitForElement();
		//bp.waitForElement();
		
		for(int i=0;i<=nodes.length-1;i++)
		{
			bp.waitForElement();
			String allnodes=globalNode1+nodes[i]+globalNode2;
			
			WebElement nodeElement=driver.findElement(By.xpath(allnodes));
			act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
			
			log.info("Pass - Double click on'"+nodes[i]+"' Successfull");
			//act.moveToElement(nodeElement).click().perform();
			bp.waitForElement();
		}
		
		return true;
		}
	
	 catch(Exception e)
		{
	    e.printStackTrace();
	     throw e;
		}
	
	}
	public boolean selectMultipleTestCaseFromGlobalNode(String[] no) throws Exception
	{
		try
		{
			bp=new BasePage();
		for(int i=0;i<=no.length-1;i++)
		{
		bp.waitForElement();
		WebElement ele=driver.findElement(By.xpath(globalTestCase1+no[i]+globalTestCase2));
		ele.click();
		}
		
		return true;
		} 
		catch(Exception e)
		{
	 	    e.printStackTrace();
	 	     throw e;
			}
	}
	
	
	
	public boolean selectingNodeFromLocalArea(String releaseName,String[] nodes) throws Exception
	{
		try
		{ 
			bp=new BasePage();
			bp.waitForElement();
		String localRelease=localNode1+releaseName+localNode2;
		WebElement ele=driver.findElement(By.xpath(localRelease));
		
		WebElement releaseExpandcheck=driver.findElement(By.xpath(localNode1+releaseName+localNode2+expandNode));
		   String text=releaseExpandcheck.getAttribute("aria-expanded");
		 //  String text=releaseExpand.getAttribute("aria-expanded");
		   Actions act = new Actions(driver);
		   System.out.println(text);
		   if(text.equals("false"))
		   {
		  
		   act.moveToElement(ele).doubleClick().perform();
		   bp.waitForElement();
		   System.out.println("Pass - double click on'" + releaseName + "' Successfull");
		   bp.waitForElement();}
		   else
		   {
		    bp=new BasePage();
		    //String releasename3 = releasename1 + releaseName + releasename2;
		     ele.click();
		    System.out.println("Release already in Expanded mode");
		    bp.waitForElement();

		   
		  }
		
		
		for(int i=0;i<=nodes.length-1;i++)
		{
			bp.waitForElement();
			String allnodes=localNode1+nodes[i]+localNode2;
			
			WebElement nodeElement=driver.findElement(By.xpath(allnodes));
			act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
			
			log.info("Pass - Double click on'"+nodes[i]+"' Successfull");
			//act.moveToElement(nodeElement).click().perform();
			bp.waitForElement();
		}
		
		return true;
		}
		 catch(Exception e)
		{
 	    e.printStackTrace();
 	     throw e;
		}
	}
	
//	public boolean selectingNodeFromLocalArea(String releaseName,String[] nodes) throws Exception
//	{
//		try
//		{ 
//			bp=new BasePage();
//			bp.waitForElement();
//		String localRelease=localNode1+releaseName+localNode2;
//		WebElement ele=driver.findElement(By.xpath(localRelease));
//		Actions act=new Actions(driver);
//		act.doubleClick(ele).build().perform();
//		log.info("Pass - Double click on'"+releaseName+"' Successfull");
//		for(int i=0;i<=nodes.length-1;i++)
//		{
//			bp.waitForElement();
//			String allnodes=localNode1+nodes[i]+localNode2;
//			
//			WebElement nodeElement=driver.findElement(By.xpath(allnodes));
//			act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
//			
//			log.info("Pass - Double click on'"+nodes[i]+"' Successfull");
//			//act.moveToElement(nodeElement).click().perform();
//			bp.waitForElement();
//		}
//		
//		return true;
//		}
//		 catch(Exception e)
//		{
// 	    e.printStackTrace();
// 	     throw e;
//		}
//	}
//	
	public boolean testCaseCountInCopyfromProjectReleases() throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		String testCase=driver.findElement(By.xpath(testCaseCount)).getText();
		System.out.println("Total Test Case present in Node-"+testCase);
		
		return true;
		}
		 catch(Exception e)
		{
 	    e.printStackTrace();
 	     throw e;
		}
	}
  public boolean closeCopyFromProjectReleasesPage() throws Exception
  {
	  try
	  {
		  bp=new BasePage();
		  bp.waitForElement();
		  bp.waitForElement();
	      closeCopyFromProjectReleasesPage.click();
	      bp.waitForElement();
	      
	  return true;
	  }
	  catch(Exception e)
		{
	    e.printStackTrace();
	     throw e;
		}
	  
  }

  public boolean selectingLocalRelease(String releaseName) throws Exception
  {
	  try
	  {
	    bp=new BasePage();
	    bp.waitForElement();
		String localRelease=localNode1+releaseName+localNode2;
		WebElement ele=driver.findElement(By.xpath(localRelease));
		Actions act=new Actions(driver);
		act.doubleClick(ele).build().perform();
		
		
		return true;
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  throw e;
	  }
  }
  
  //14-08-17
  public boolean selectNodeFromImportedArea(String[] nodes) throws Exception
  {
   bp=new BasePage();
   bp.waitForElement();
      Actions act=new Actions(driver);
    act.doubleClick(doubleClickOnImported).build().perform();
   try
   {
    
   //log.info("Pass - Double click on'"+releaseName+"' Successfull");
   bp.waitForElement();
   //bp.waitForElement();
   for(int i=0;i<=nodes.length-1;i++)
   {
    String allnodes=globalIMportedNode1+nodes[i]+globalIMportedNode2;
    
    WebElement nodeElement=driver.findElement(By.xpath(allnodes));
    
    act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
    
    //log.info("Pass - Double click on'"+nodes[i]+"' Successfull");
    //act.moveToElement(nodeElement).click().perform();
    
    
    //*[starts-with(@data-desc,'FileName : "
    bp.waitForElement();
   }
   
   return true;
   }
  
   catch(Exception e)
   {
      e.printStackTrace();
       throw e;
   }
  
  }
  
  public boolean dragAndDropImportedNodes(String nodeName1,String nodeName2) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
		//WebElement ele1=driver.findElement(By.xpath(globalNode1+nodeName1+globalNode2));
			WebElement ele1=driver.findElement(By.xpath(globalIMportedNode1+nodeName1+globalIMportedNode2));
			WebElement ele2=driver.findElement(By.xpath(localNode1+nodeName2+localNode2));
		Actions a2=new Actions(driver);
		a2.clickAndHold(ele1).perform();
		a2.release(ele2).perform();
		
		//a2.dragAndDrop(ele1, ele2).perform();
		bp.waitForElement();
		log.info("Nodes moved sucessfully");
		return true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
  
  
  
  public  boolean validateCopiedFile(String fileName) throws Exception
  {
	  try
	  {
		  bp=new BasePage();
			bp.waitForElement();
			String A="//*[starts-with(@data-desc,'FileName : ";
			String B="')]";
			String ImportedFile=A+fileName+B;
			driver.findElement(By.xpath(ImportedFile)).click();
			System.out.println("Imported File Copied to the local Node");
		  return true;
	  }
	  
	  catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
  }
	
}