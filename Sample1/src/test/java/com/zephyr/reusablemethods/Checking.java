package com.zephyr.reusablemethods;





import org.openqa.selenium.WebDriver;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;



public class Checking extends LaunchBrowser
{
	 static int ts=3000;
	 
	static boolean[] status=new boolean[1];
	static WebDriver driver;
	static WebDriver tempDriver;
	 
public static void main(String[] args) throws Exception
{
	
	
	String date1=Excel_Lib.getData(INPUT_PATH_4, "startAndEndDate", 1, 0);
	System.out.println(date1);
	LaunchBrowser bt=new LaunchBrowser();
	bt.preCond();
	bt.getUrl("http://13.229.255.95/flex/html5");
	LoginPage lp=new LoginPage(driver);
	lp.enterUname("tester.two");
	lp.enterPass("tester.two");
	lp.clickOnLogin();
	
	Thread.sleep(ts);
	ProjectPage pp=new ProjectPage(driver);
//	//pp.clickOnLogout();
	pp.selectProject("Normal Project2");
	pp.selectRelease("Release 1.0");
	ReleasePage rp=new ReleasePage(driver);
	rp.clickOnTestRep();
	TestRepositoryPage tr=new TestRepositoryPage(driver);
	tr.doubleClickOnRelease("Release 1.0");
	tr.addNode("Abs", "Ajbhs");
	tr.addTestCase();
	CreateTestCasePage ctc=new CreateTestCasePage(driver);
	ctc.enterEstimatedTime("12","11","08");
	
	
	
//	System.setProperty(CHROME_KEY,DRIVER_PATH+CHROME_FILE);
//	  WebDriver driver = new ChromeDriver();
//	     
//	     driver.manage().window().maximize();
//	     
//	     driver.get("http://13.228.56.78/flex/html5/login");
//	     
//	     Thread.sleep(2000);
//	     
//	     DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//		  
//		 capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
//		 capabilities.setCapability(InternetExplorerDriver.
//		   INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
//	     
//	     
//	     System.setProperty("webdriver.ie.driver","F:\\IEDriverServer_Win32_3.5.1\\IEDriverServer.exe");
//	     tempDriver=new InternetExplorerDriver();
//	     //System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
//	     //tempDriver=new InternetExplorerDriver();
//	     tempDriver.manage().window().maximize();
//	     driver.get("http://13.228.56.78/flex/html5/login");
//	 
//	     
//	     
//	     
//	     ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//	     driver.switchTo().window(tabs2.get(1));
//	     driver.close();
//	     driver.switchTo().window(tabs2.get(0));
//	     driver.close();
//	
	
//	boolean[] actual=new boolean[6];
//	SoftAssert soft=new SoftAssert();
//	
//	try
//	{//String[] b=new String[2];
//	//boolean[] b1=new boolean[2];
//	
//		actual[0]=true;
//		actual[1]=true;
//	//b1[3]=true;
//	
//	
//	}
//	catch(Exception e)
//	{
//		e.printStackTrace();
//		//throw e;
//	}
	//System.out.println(b1[0]);
	//System.out.println(b1[1]);
	
//	SoftAssert sa=new SoftAssert();
//	boolean g=sa.
//	sa.assertAll();
//	
//	
////	b[0]="rh";
//	System.out.println(b[1]);
//	//String p="Data (Excel only)";
	//System.out.println(p);
	
	
//       b[0]=Excel_Lib.getData(INPUT_PATH_1, "Login", 1, 0);
//       b[1]=Excel_Lib.getData(INPUT_PATH_1, "Login", 5, 0);
//       
//       System.out.println(b[0]);
//       System.out.println(b[1]);
//       
//System.out.println(p);
//	//ExportPage exp=new ExportPage(driver);
//	String p=Excel_Lib.getData(INPUT_PATH_2, "Test_798102", 1, 0);
//	System.out.println(p);
	//exp.verifyPDFExport();
	//exp.("C:\\Users\\RAJNEESH\\Downloads\\TestcaseTreeExport_1499783832497_.xls", "export", 34, 18);
//	LaunchBrowser bt=new LaunchBrowser();
//	bt.preCond();
//	LoginPage lp=new LoginPage(driver);
//	lp.enterUname("tester.two");
//	lp.enterPass("tester.two");
//	lp.clickOnLogin();
	
//	String a=driver.findElement(By.xpath("(//*[@id='zee-login-password'])[2]")).getText();
//	System.out.println(a);
//	
//	if(a.equals(b[1]))
//	{
//		System.out.println("Yes");
//	}
////	status[0]=lp.clickOnLogin();
//	
//	boolean[] actual=new boolean[1];
//	actual[0]=false;
//	try
//	{
//	 Assert.assertArrayEquals(status, actual);
//	}
//	catch(Exception e)
//	{
//	  throw e;
//		//e.printStackTrace();
//	}
//	//lp.clickOnLogin();
//	Thread.sleep(ts);
//	ProjectPage pp=new ProjectPage(driver);
////	//pp.clickOnLogout();
//	pp.selectProject("Sample Project");
//	pp.selectRelease("Release 1.0");
//	ReleasePage rp=new ReleasePage(driver);
//	rp.clickOnTestRep();
//	TestRepositoryPage tr=new TestRepositoryPage(driver);
//	tr.doubleClickOnRelease("Release 1.0");
//	WebElement  ele=driver.findElement(By.xpath("//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[2]/notifications/div/a/span/span"));
//	System.out.println(ele.isEnabled());
//	String text=driver.findElement(By.xpath("//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[2]/notifications/div/a/span/span")).getText();
//	System.out.println(text);
	
//	String[] phases=new String[1];
//	phases[0]="Tester_Phase";
//	tr.navigateToNode("Release 1.0",phases);
//	
//	boolean[] res= new boolean[2];
//	res[0]=true;
//	res[1]=true;
//     
//	
//	Assert.assertArrayEquals(status, res);
//	
	
//	
//	
//	  TestRepositoryPage tr=new TestRepositoryPage(driver);
//	   String[] subsystem=new String[3];
//	   subsystem[0]="ss1";
//	   subsystem[1]="ss2";
//	   subsystem[2]="ss3";
//	   tr.navigateToNode("Release 1.0", subsystem);
      // tr.selectPhase("ss1");
//	   ExportPage ep=new ExportPage(driver);
//	   String[] test=new String[2];
//	   test[0]="1";
//	   test[1]="2";
//	   ep.selectMultipleTestCaseFromGrid(test);
//	   Thread.sleep(3000);
//	   String s3="//div[@title='"+"6563"+"']";
//		WebElement ele=driver.findElement(By.xpath(s3));
//		ele.click();
//	   WebElement ele=driver.findElement(By.xpath("(//div[text()='Untitled'])[1]"));
//	  WebDriverWait wait1 = new WebDriverWait(driver, 30);
//	    wait1.until(ExpectedConditions.e);
	   //tr.dragAndDropTestCase(ele,"ss3");
	  // tr.dragAndDropNode(srcNode, destNode);
//	   
//	   String[] test=new String[1];
//	   test[0]="Steps";
//	   tr.selectTestCase(test);
//	   tr.clickDetailButton();
//	   CreateTestCase ctc=new CreateTestCase(driver);
//	   ctc.moveTestSteps("1", "2");
//	   Thread.sleep(4000);
//	  tr.doubleClickOnRelease("Release 2.0");
//	  String name="James";
//	  String desc="";
//	  tr.addNode(name, desc);
//	  String[] str=new String[1];
//	  str[0]="James";
//	  tr.doubleClickOnRelease("Release 2.0");
//	  tr.navigateToNode("Release 2.0", str);
//	  System.out.println("node Added");
//	  tr.addTestCase();
//	  System.out.println("test Case added");
			  
	  // ExportPage ep=new ExportPage(driver);
	   //ep.selectMultipleTestCaseFromGrid("4");
	  // System.out.println("selected");
	  //ReleaseSetupPage rs=new ReleaseSetupPage(driver);
	  //rs.SelectDateFromDatePicker("2017","July","23");
	   //pp.selectRelease("Release 1.0");
	//pp.selectSampleProject();
    //	SampleProject sp=new SampleProject(driver);
   //	sp.clickRelease1();
   //	ReleasePage rp=new ReleasePage(driver);
    //	rp.clickOnTestRep();
   //	
    //	 
//TestRepositoryPage tr=new TestRepositoryPage(driver);	
//tr.clickOnRelease("Release 1.0");
	 
	 
  //	 driver.findElement(By.xpath("//div[@class='contextMenuIcon fa fa-ellipsis-v']")).click();
   //	 driver.findElement(By.xpath("//a[contains(.,' Export Tests')]")).click();
	 
	 //Thread.sleep(2000);
	  // driver.findElement(By.xpath("//*[@value='114']")).click();
	 //driver.findElement(By.xpath("//*[@value='110']")).click();
//	 String[] fields=new String[4];
//	 
//	 fields[0]="ID";
//   fields[1]="Name";
//    fields[2]="Alt ID";
//    fields[3]="Script ID";
//    
//    String cov="All";
//    String cov1="Covered";
//    String ma="Manual";
//   
//    String[] fields_1=new String[1];
//    fields_1[0]="P1";
//    //fields_1[1]="P4";
//   // fields_1[2]="P2";
//    //fields_1[3]="P3";
//    
//    String[] fields_2=new String[2];
//    
//    fields_2[0]="Test Lead";
//    //fields_2[1]="";
//    //fields_2[0]="Test Lead";
//    fields_2[1]="Test Manager";
    
//	 
//	 ExportPage exp=new ExportPage(driver);
//    exp.clickOnNodeExport();
//     exp.selectSelectFields(fields);
//     exp.selectFilterBy(cov, cov1, fields_1, fields_2, ma);
//    exp.reportType("Data (Excel only)");
//     exp.outputType("PDF");     exp.title("Raj3");
////     exp.saveAndDownload();
////     
//	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
//	 tr.clickexpand();
//	
//	 Thread.sleep(ts);
//	 
//	 tr.clickOnPhase("Tester_system");
	 // String[] subsystem=new String[1];
	 // subsystem[0]=Excel_Lib.getData(INPUT_PATH, "Phases", 4, 0);
//	   subsystem[0]=Excel_Lib.getData(INPUT_PATH, "Phases",4, 0);
//	   subsystem[1]=Excel_Lib.getData(INPUT_PATH, "Phases",4, 1);
//	   subsystem[2]=Excel_Lib.getData(INPUT_PATH, "Phases",4, 2);
	// subsystem[0]="phase 6";
    // tr.navigateToNode("Release 1.0",subsystem);
     //tr.clickDetailButton();
     
//     int size_1=driver.findElements(By.xpath("//*[@id='zui-modal-trigger-tcr_1'][1]")).size();
//     driver.findElements(By.xpath("//*[@id='zui-modal-trigger-tcr_1'][1]")).get(size_1-1).click();
    // List<WebElement> ele5=driver.findElements(By.xpath("//*[@id='zui-modal-trigger-tcr_1'][1]"));
     
    // FindElement fe=new FindElement(driver);
     //fe.handleMultipleEle2(ele5);
     //tr.addTestCase();
     //tr.clickOnDetails();
//	 
//		Thread.sleep(3000);
//		Actions a3=new Actions(driver);
//		for(int i=1;i<=7;i++)
//		  {
//				a3.sendKeys(Keys.DOWN).perform();
//		  }
//		Thread.sleep(2000);
//		CreateTestCase ctc=new CreateTestCase(driver);
//		
//		ctc.enterEstimatedTime("99","23","59");
//		
//		 String[] tags=new String[33];
//	       int k=0;
//	       
//			for(int j=0;j<=32;j++)
//			{
//				tags[k]=Excel_Lib.getData(INPUT_PATH,"Tags",j+1, 0);
//				k++;
//			}
//			ctc.enterMultipleTags(tags);
		//ctc.enterMultipleTags(tags);
//		String id=Excel_Lib.getData(INPUT_PATH,"TestCase", 1, 0);
//		ctc.selectTestCase(id);
//		ctc.clickOnTestCaseDetail();
		
		
		
//		
//		
//		tr.addTestCase();
//		Thread.sleep(2000);
//		
//		
//		
//		
		//CreateTestCase cc=new CreateTestCase(driver);
//	
		//cc.enterTestCaseNameAndDesc("Camp","Camp Module");
//		
//		String[] all=new String[4];
//		all[0]="P1";
//		all[1]="P1";
//		all[2]="l1";
//		all[3]="P1";
//		//cc.enterTestCaseDetail(all);
////		
//		cc.enterTestCaseStepDetail(all);
//		cc.enterTestCaseStepDetails();
//		String[] f=new String[1];
//		f[0]="C:\\Users\\RAJNEESH\\Desktop\\Autoscript.exe";
////		
//		cc.uploadAttachement(f);
//		cc.enterEstimatedTime("23", "22", "21");
		
//		String a="I am shiva and i am from banag";
//		String b=a.substring(5, 10);
//		boolean c=a.contains("sh");
//		System.out.println(c);
//		
		
			
	
	
	
}
}
