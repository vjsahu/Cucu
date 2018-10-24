package com.zephyr.reusablemethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.zephyr.pom.TestPlanning_POM;

public class TestPlanningPage extends TestPlanning_POM {
	WebDriver driver = null;
	BasePage bp;
	public Logger log;

	SoftAssert soft = new SoftAssert();

	public TestPlanningPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log = Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
		BasicConfigurator.configure();
	}

	public boolean CreateCycle(String cycle, String Build, String environ, String hide) throws Exception {
		try {
			bp = new BasePage();
			// createNewCycle.click();
			// bp.waitForElement();
			bp.waitForElement();
			cycleName.sendKeys(cycle);
			bp.waitForElement();
			build.sendKeys(Build);
			bp.waitForElement();
			environment.sendKeys(environ);
			bp.waitForElement();
			if (hide.equalsIgnoreCase("Hide")) {
				hideChkbox.click();
			}

			return true;
		} catch (Exception e) {
			log.info("Fail-Test cycle not created");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean navigateToCycle(String[] cycleName) throws Exception {
		String cycle4;
		try {
			bp = new BasePage();
			for (int i = 0; i <= cycleName.length - 1; i++) {
				// bp.waitForElement();
				cycle4 = cycle1 + cycleName[i] + cycle2;
				WebElement nodeElement = driver.findElement(By.xpath(cycle4));
				Actions act = new Actions(driver);
				act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
				String cyclename = driver.findElement(By.xpath(cycle4)).getText();
				log.info(cyclename);
				log.info("Pass - Double click on'" + cycleName[i] + "' Successfull");
				// act.moveToElement(nodeElement).click().perform();
				bp.waitForElement();
			}
			return true;
		} catch (Exception e) {
			log.info("Fail-navigation unsucessful");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean addPhaseToCycle(String Phase) throws Exception {
		try {
			bp = new BasePage();
			options.click();
			log.info("Pass - Clicked on Options");
			bp.waitForElement();
			// bp.waitForElement();
			addphase.click();
			log.info("Pass - Clicked on phase");
			bp.waitForElement();
			// WebElement
			// element=driver.findElement(By.xpath("//*[@id='defect-system-select2']"));
			// Select osel=new
			// Select(driver.findElement(By.xpath("//select[@class='form-control
			// ng-pristine ng-valid ng-touched']")));
			Select osel = new Select(addphaseToCycle);
			osel.selectByVisibleText(Phase);
			log.info("Pass - " + Phase + " selected");
			bp.waitForElement();
			clickOnSave.click();
			bp.waitForElement();
			return true;
		} catch (Exception e) {
			log.info("Fail-phase not created");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean bulkAssignment(String Bulk_type) throws Exception {
		try {
			bp = new BasePage();
			for (int i = 4; i <= 6; i++) {
				bp.waitForElement();
				WebElement btype = driver.findElement(By.xpath(btype1 + i + btype2));
				String type = btype.getText();
				bp.waitForElement();
				if (Bulk_type.equals(type)) {
					bp.waitForElement();
					btype.click();
					log.info("bulk type selected" + Bulk_type);
					bp.waitForElement();
				}
			}
			boolean status1 = clickonSave2.isDisplayed();
			if (status1 == true) {
				clickonSave2.click();
				bp.waitForElement();
			}

			// clickonOK.click();
			boolean status = clickonOK.isDisplayed();
			if (status == true) {
				clickonOK.click();
			}
			return true;
		}

		catch (Exception e) {
			log.info("Fail-bulk assignment unsucessful");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean deleteNode() throws Exception {
		try {
			bp = new BasePage();
			options.click();
			log.info("Pass - Clicked on Options");
			bp.waitForElement();
			deleteNode.click();
			log.info("Pass - Clicked on Delete");
			bp.waitForElement();
			confirmDelete.click();
			bp.waitForElement();
			return true;
		} catch (Exception e) {
			log.info("Fail-delete node unsucessful");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean assignPhase() throws Exception {
		try {
			bp = new BasePage();
			options.click();
			log.info("Pass - Clicked on Options");
			bp.waitForElement();
			assignPhase.click();
			bp.waitForElement();
			return true;
		} catch (Exception e) {
			log.info("Fail-phase not assigned");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean assignAllSelected(String assignee) throws Exception {
		try {
			bp = new BasePage();
			// select_Assignee.click();
			// bp.waitForElement();
			Actions act = new Actions(driver);
			act.moveToElement(select_Assignee).click().pause(1500).sendKeys(assignee).sendKeys(Keys.ENTER).perform();
			bp.waitForElement();
			// log.info("clicked on all selected assign option");
			// WebElement
			// asssin=driver.findElement(By.xpath(assignee1+assignee+assignee2));
			// asssin.click();
			// bp.waitForElement();
			// log.info("selected assignee"+asssin.getText());
			Boolean disp = clickonOK.isDisplayed();
			if (disp == true) {
				clickonOK.click();
			}
			bp.waitForElement();
			return true;
		} catch (Exception e) {
			log.info("Fail-fail to select assignee ");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean deleteAllSelectedTestCases() throws Exception {
		try {
			bp = new BasePage();
			deleteselectedtestcases.click();
			log.info("clicked on delete option");
			bp.waitForElement();
			Boolean bol = confirmDelete.isDisplayed();
			if (bol == true) {
				System.out.println("popup displayed  click on confirm to delete");
				confirmDelete.click();
			}
			log.info("selected testcases deleted sucessfully");
			return true;
		} catch (Exception e) {
			log.info("Fail-delete unsucessful");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean setFlags() throws Exception {
		try {
			bp = new BasePage();
			setFlag.click();
			log.info("cliked on setflag sucessfully");
			bp.waitForElement();
			clickOnContinue.click();
			log.info("cliked on continue");
			bp.waitForElement();
			return true;
		} catch (Exception e) {
			log.info("Fail-set flag unsucessfull");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean unSetFlags() throws Exception {
		try {
			bp = new BasePage();
			unSetFlag.click();
			log.info("cliked on unsetflag sucessfully");
			bp.waitForElement();
			clickOnContinue.click();
			log.info("cliked on continue");
			bp.waitForElement();
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
	}

	public boolean bulkAssignTestcasesSelectedFolder() throws Exception {
		try {
			clickOnBulkAssign.click();
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
	}

	public boolean assignAllNotexecuted(String assignee, String Check) throws Exception {
		try {
			bp = new BasePage();
			// select assignee
			Select osel = new Select(notExecuted);
			osel.selectByVisibleText(assignee);
			bp.waitForElement();
			log.info("Pass - " + assignee + " selected");
			// click on check box
			if (Check != null) {
				clickOnchkBox1.click();
			}
			bp.waitForElement();
			// save
			clickOnSave1.click();
			bp.waitForElement();
			clickonOK.click();
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
	}

	public boolean assignAllUnassigned(String assignee, String Check) throws Exception {
		try {
			bp = new BasePage();
			// click on radio
			clickOnRadio2.click();
			bp.waitForElement();
			// select assignee
			Select osel = new Select(unAssigned);
			osel.selectByVisibleText(assignee);
			bp.waitForElement();
			// click on check box
			if (Check != null) {
				clickOnchkBox2.click();
				bp.waitForElement();
			}
			// save
			clickOnSave1.click();
			bp.waitForElement();
			clickonOK.click();
			bp.waitForElement();
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
	}

	public boolean sync(String check) throws Exception {
		try {
			bp = new BasePage();
			clickOnSynch.click();
			bp.waitForElement();
			bp.waitForElement();
			// click on checkbox
			if (check != null) {
				clickOnSynchChkBox.click();
				bp.waitForElement();
			}
			// continue
			clickOnSynchContinue1.click();
			bp.waitForElement();
			// continue
			clickOnSynchContinue2.click();
			bp.waitForElement();
			// ok

			boolean status = SyncMsg.isDisplayed();
			if (status == true) {
				String msg = SyncMsg.getText();
				System.out.println(msg);
			}
			clickOnSynchOk.click();
			bp.waitForElement();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean individualAssinTo(int[] TestcaseNo, String Assignee) throws Exception {
		try {
			bp = new BasePage();
			for (int i = 0; i <= TestcaseNo.length - 1; i++) {
				bp.waitForElement();

				WebElement ele = driver.findElement(By.xpath(assignTc1 + TestcaseNo[i] + assignTc2));
				Actions act = new Actions(driver);
				act.moveToElement(ele).click().pause(1500).sendKeys(Assignee).sendKeys(Keys.ENTER).perform();
				bp.waitForElement();
				bp.waitForElement();
				String expected = driver.findElement(By.xpath(assignTc1 + TestcaseNo[i] + assignTc2)).getText();
				if (expected.equals(Assignee)) {
					System.out.println("Assigned to " + expected + " Sucessfully");
				} else {
					System.out.println("Assigned Failed");
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean selectallTestCase() throws Exception {
		try {
			select_all_TestCases.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean selectSingleMultipleTestcase(int[] tcNo) throws Exception {
		try {
			bp = new BasePage();
			for (int i = 0; i <= tcNo.length - 1; i++) {
				bp.waitForElement();
				driver.findElement(By.xpath(selectTestcase1 + tcNo[i] + selectTestcase2)).click();
				bp.waitForElement();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean enterStartDatAndEndDate(String syear, String smonth, String sday, String eyear, String emonth,
			String eday) throws Exception {
		try {
			bp = new BasePage();
			startDateOption.click();
			bp.waitForElement();
			WebElement ele = driver.findElement(By.xpath(startDateHeader));
			Actions a2 = new Actions(driver);
			a2.moveToElement(ele).doubleClick().perform();
			driver.findElement(By.xpath(startDateHeader)).click();
			bp.waitForElement();
			String[] startDate = new String[1];
			String startYear = minYear.getText();
			int Syear = Integer.parseInt(startYear);
			int[] start = new int[1];
			startDate[0] = syear;
			start[0] = Integer.parseInt(startDate[0]);

			if (start[0] < Syear) {
				left.click();
				bp.waitForElement();

			}

			driver.findElement(By.xpath(year1 + syear + year2)).click();
			bp.waitForElement();
			bp.waitForElement();
			driver.findElement(By.xpath(month1 + smonth + month2)).click();
			bp.waitForElement();
			driver.findElement(By.xpath(day1 + sday + day2)).click();
			bp.waitForElement();
			bp.waitForElement();
			endDateOption.click();
			bp.waitForElement();
			WebElement ele1 = driver.findElement(By.xpath(endDateHeader));
			Actions a3 = new Actions(driver);
			a3.moveToElement(ele1).click().perform();
			bp.waitForElement();
			bp.waitForElement();
			driver.findElement(By.xpath(endDateHeader)).click();
			bp.waitForElement();
			bp.waitForElement();

			String[] endDate = new String[1];
			String endMin = minYear.getText();
			String endMax = maxYear.getText();
			int eMin = Integer.parseInt(endMin);
			int eMax = Integer.parseInt(endMax);
			int[] end = new int[1];
			endDate[0] = eyear;
			end[0] = Integer.parseInt(endDate[0]);

			if (end[0] < eMin) {
				left.click();
				bp.waitForElement();
			} else if (end[0] > eMax) {
				right.click();
				bp.waitForElement();
			}
			driver.findElement(By.xpath(year1 + eyear + year2)).click();
			bp.waitForElement();
			// bp.waitForElement();
			driver.findElement(By.xpath(month1 + emonth + month2)).click();
			bp.waitForElement();
			// bp.waitForElement();
			driver.findElement(By.xpath(day_1 + eday + day_2)).click();
			bp.waitForElement();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean editCycle(String cycle, String Build, String environ, String hide) throws Exception {
		try {
			bp = new BasePage();
			options.click();
			System.out.println("Pass - Clicked on Options");
			bp.waitForElement();

			edit.click();
			// driver.findElement(By.xpath(edit)).click();
			bp.waitForElement();

			if (cycle != "") {
				bp.waitForElement();
				bp.eraseText(cycleName);
				cycleName.sendKeys(cycle);
			}
			bp.waitForElement();

			if (Build != "") {
				// bp.waitForElement();
				bp.eraseText(build);
				build.sendKeys(Build);
			}

			bp.waitForElement();

			if (environ != "") {
				bp.waitForElement();
				bp.eraseText(environment);
				environment.sendKeys(environ);
			}

			if (hide.equalsIgnoreCase("Hide")) {
				hideChkbox.click();
			}
			return true;
		}

		catch (Exception e) {
			System.out.println("Fail-Test cycle Not Edited");
			e.printStackTrace();
			throw e;
		}

	}

	public boolean saveTestCycle() throws Exception {
		try {
			clickOnSave.click();
			System.out.println("Clicked on save");
			return true;
		} catch (Exception e) {
			log.info("Fail-Test cycle not Saved");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean clickOnAddTestCycleSymbol() throws Exception {
		try {
			bp = new BasePage();
			createNewCycle.click();
			bp.waitForElement();

			return true;
		} catch (Exception e) {
			log.info("Fail-Test cycle Symbol not clicked");
			e.printStackTrace();
			throw e;
		}

	}

	public boolean verifyAddTestCyclePage() throws Exception {
		try {
			String text = verifyAddTestCycle.getText();

			if (text.equalsIgnoreCase(expReults)) {
				System.out.println("Pass-Successfully navigated to the Add Test Cycle Page");
			}

			return true;
		} catch (Exception e) {
			System.out.println("Fail- You are not in Add Test Cycle Page");
			e.printStackTrace();
			throw e;
		}
	}

	///////// shiva added
	public boolean getPhaseCount(String phaseName) throws Exception {
		try {
			String s1 = "//*[@data-type='Phase' and @data-name='";
			String s2 = "']";
			String phase = s1 + phaseName + s2;
			String count = driver.findElement(By.xpath(phase)).getAttribute("data-count");
			System.out.println(count);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean validateAllAssigned(int[] testcaNo, String assignee) throws Exception {
		try {
			bp = new BasePage();
			for (int i = 0; i <= testcaNo.length - 1; i++) {
				String expected = driver.findElement(By.xpath(validateTc1 + testcaNo[i] + validateTc2)).getText();
				// System.out.println(expected);
				if (expected.equals(assignee)) {
					System.out.println("Assigned to " + expected + " sucessfully");
					bp.waitForElement();
				} else {
					System.out.println("Assigned Failed");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return true;
	}

	public Boolean cancelBulkAssign() throws Exception {
		try {
			bp = new BasePage();
			cancelBulkAssign.click();
			bp.waitForElement();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return true;
	}

	/*
	 * **************************************************** Method Name :
	 * doubleClickOnCycle(String cycleName) Purpose : To Click on the cycleName
	 * in TestPlanning of the Project in Zephyr Application Author : Srikanth
	 * Date Created : 14/09/17 Date Modified : Reviewed By : Rajneesh
	 * ******************************************************
	 */
	public boolean doubleClickOnCycle(String cycleName) throws Exception {
		String cycle4;
		try {

			bp = new BasePage();
			cycle4 = cycle1 + cycleName + cycle2;
			bp.waitForElement();
			WebElement nodeElement = driver.findElement(By.xpath(cycle4));
			Actions act = new Actions(driver);
			act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
			String cyclename = driver.findElement(By.xpath(cycle4)).getText();
			log.info(cyclename);
			log.info("Pass - Double click on'" + cycleName + "' Successfull");
			// act.moveToElement(nodeElement).click().perform();
			bp.waitForElement();

			return true;
		} catch (Exception e) {
			log.info("Fail-cycle navigation unsucessful");
			e.printStackTrace();
			throw e;
		}
	}

	// added by srikanth for set/reset toggle flag in TestPlanning
	public boolean setToggleFlags() throws Exception {
		try {
			bp = new BasePage();
			toggleFlag.click();
			log.info("cliked on toggleflag sucessfully");
			bp.waitForElement();
			toggleContinueOption.click();
			log.info("cliked on continue");
			bp.waitForElement();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean resetToggleFlag() throws Exception {
		try {
			bp = new BasePage();
			resettoggleFlag.click();
			log.info("cliked on toggleflag sucessfully");
			bp.waitForElement();
			toggleContinueOption.click();
			log.info("cliked on continue");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean testCycleCount(String cycleName) throws Exception {
		try {
			bp = new BasePage();
			String cycle4 = cycle1 + cycleName + cycle2;
			bp.waitForElement();
			List<WebElement> nodeElement = driver.findElements(By.xpath(cycle4));

			int count = nodeElement.size();
			System.out.println("No of Test Cycle Test Cycle-" + count);
			return true;
		} catch (Exception e) {
			System.out.println("Fail-cycle navigation unsucessful");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean cloneCycle(String cycle, String Build, String duration, String environ, String hide,
			String testCaseAssignment) throws Exception {
		try {

			bp = new BasePage();
			options.click();
			bp.waitForElement();
			System.out.println("Pass - Clicked on Options");

			cloneCycle.click();
			bp.waitForElement();

			if (cycle != "") {
				// bp.waitForElement();
				bp.eraseText(cycleName);
				cycleName.sendKeys(cycle);
				System.out.println("Cycle name entered successfully");
			}

			if (Build != "") {
				// bp.waitForElement();
				bp.eraseText(build);
				build.sendKeys(Build);
			}

			if (duration != "") {
				keepTheDurationFixedOption.click();
			}

			if (environ != "") {
				// bp.waitForElement();
				bp.eraseText(environment);
				environment.sendKeys(environ);
			}

			if (testCaseAssignment != "") {
				copyAssignmentOver.click();
			}
			bp.waitForElement();

			if (hide.equalsIgnoreCase("Hide")) {
				hideChkbox.click();
			}
			bp.waitForElement();

			return true;

		} catch (Exception e) {
			System.out.println("Fail-cycle clone unsucessful");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean editStartDatAndEndDate(String syear, String smonth, String sday, String eyear, String emonth,
			String eday) throws Exception {
		try {
			if (syear != "") {
				bp = new BasePage();
				startDateOption.click();
				bp.waitForElement();
				WebElement ele = driver.findElement(By.xpath(startDateHeader));
				Actions a2 = new Actions(driver);
				a2.moveToElement(ele).doubleClick().perform();
				driver.findElement(By.xpath(startDateHeader)).click();
				// a2.moveToElement(ele).click().perform();

				driver.findElement(By.xpath(year1 + syear + year2)).click();
				bp.waitForElement();
				bp.waitForElement();
				driver.findElement(By.xpath(month1 + smonth + month2)).click();
				bp.waitForElement();
				driver.findElement(By.xpath(day1 + sday + day2)).click();
				bp.waitForElement();
				bp.waitForElement();

			}

			if (eyear != "") {
				endDateOption.click();
				bp.waitForElement();
				WebElement ele1 = driver.findElement(By.xpath(endDateHeader));
				Actions a3 = new Actions(driver);
				a3.moveToElement(ele1).click().perform();
				bp.waitForElement();
				// bp.waitForElement();
				driver.findElement(By.xpath(endDateHeader)).click();
				bp.waitForElement();
				// bp.waitForElement();
				driver.findElement(By.xpath(year1 + eyear + year2)).click();
				bp.waitForElement();
				// bp.waitForElement();
				driver.findElement(By.xpath(month1 + emonth + month2)).click();
				bp.waitForElement();
				// bp.waitForElement();
				driver.findElement(By.xpath(day_1 + eday + day_2)).click();
			}

			return true;
		}

		catch (Exception e) {
			System.out.println("Fail-navigation unsucessful");
			e.printStackTrace();
			throw e;
		}

	}

	public boolean validateDeletedCycle(String cycleName) throws Exception {
		String cycle4;
		try {
			bp = new BasePage();

			cycle4 = cycle1 + cycleName + cycle2;
			// WebElement nodeElement=driver.findElement(By.xpath(cycle4));

			if (driver.findElements(By.xpath(cycle4)).size() != 0) {
				System.out.println("Cycle is not deleted");
			} else {
				System.out.println("Cycle deleted successfully");
			}

			return true;
		} catch (Exception e) {
			System.out.println("Fail-Cycle deleted unsucessful");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean createFreeFormPhase(String formName) throws Exception {
		try {
			bp = new BasePage();
			options.click();
			log.info("Pass - Clicked on Options");
			bp.waitForElement();
			// bp.waitForElement();
			addphase.click();
			log.info("Pass - Clicked on phase");
			bp.waitForElement();
			createNewPhase.click();
			bp.waitForElement();
			// addNewPhase.click();
			bp.waitForElement();
			// bp.waitTillElementIsVisible(addNewPhase);
			addNewPhase.sendKeys(formName);
			bp.waitForElement();
			clickOnSave.click();
			System.out.println("Pass-FreeForm Phase created sucessfully");
			return true;
		} catch (Exception e) {
			System.out.println("Fail-FreeForm Phase not created");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean doubleClickOnClonedCycle(String cycleName, String no) throws Exception {
		String cycle4;
		try {

			cycle4 = dupCycle1 + cycleName + dupCycle2 + dupCycle3 + no + dupCycle4;
			WebElement nodeElement = driver.findElement(By.xpath(cycle4));
			Actions act = new Actions(driver);
			act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
			String cyclename = driver.findElement(By.xpath(cycle4)).getText();
			System.out.println(cyclename);
			System.out.println("Pass - Double click on'" + cycleName + "' Successfull");

			return true;
		} catch (Exception e) {
			System.out.println("Fail- Double Click cycle navigation unsucessful");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean navigateToClonedCycle(String[] cycleName, String no) throws Exception {
		String cycle4;
		try {
			bp = new BasePage();
			for (int i = 0; i <= cycleName.length - 1; i++) {

				cycle4 = dupCycle1 + cycleName[i] + dupCycle2 + dupCycle3 + no + dupCycle4;
				WebElement nodeElement = driver.findElement(By.xpath(cycle4));
				Actions act = new Actions(driver);
				act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
				String cyclename = driver.findElement(By.xpath(cycle4)).getText();
				System.out.println(cyclename);
				System.out.println("Pass - Double click on'" + cycleName[i] + "' Successfull");
				// act.moveToElement(nodeElement).click().perform();
				bp.waitForElement();
			}
			return true;
		} catch (Exception e) {
			System.out.println("Fail-navigation unsucessful");
			e.printStackTrace();
			throw e;
		}
	}

	// to click on add testcases folder
	public boolean clickOnAddTestcasesToFreeForm() throws Exception {
		try {
			// bp.waitTillElementIsClickable(clickOnAddTestcases);
			bp.waitForElement();
			clickOnAddTestcases.click();
			System.out.println("pass-clicked on addtestcases option");
			return true;
		} catch (Exception e) {
			System.out.println("Fail-FreeForm Phase not created");
			e.printStackTrace();
			throw e;
		}
	}

	// quick search
	/*
	 * public boolean quiksearch(String priority) throws Exception { try {
	 * clickOnSearchTextArea.sendKeys(priority); bp.waitForElement();
	 * System.out.println("pass-searched with " +priority); clickOnGo.click();
	 * bp.waitForElement(); System.out.println("pass-clicked on Go"); return
	 * true; } catch(Exception e) { e.printStackTrace(); throw e;
	 * 
	 * } }
	 */
	// to select check box option to save testcases in freeform page
	public boolean clickOnCheckBoxSaveAllTestcases() throws Exception {
		try {
			clickOnSaveAlltestcases.click();
			bp.waitForElement();
			System.out.println("Pass-Clicked on save All Testcases");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	// to click on Save and Ok in free form page
	public boolean clickOnSaveAndOk() throws Exception {
		try {
			saveTestcases.click();
			bp.waitForElement();
			System.out.println("Pass-Clicked on Save");

			clickOnFreeFormOk.click();
			bp.waitForElement();
			System.out.println("Pass-Clicked on OK");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	// to select single or multiple testcases
	public boolean selectMultipleTestCaseFromFreeForm(String[] testCaseNo) throws Exception {
		try {
			BasePage bp = new BasePage();
			bp.waitForElement();
			// int length=testCaseNo.length-1;
			for (int i = 0; i <= testCaseNo.length - 1; i++) {
				bp.waitForElement();
				WebElement ele = driver.findElement(By.xpath(checkTestCase1 + testCaseNo[i] + checkTestCase2));
				Actions a1 = new Actions(driver);
				a1.moveToElement(ele).click().perform();
			}
			System.out.println(testCaseNo.length + " Test Case Selected");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// to select all testcases in Free Form page
	public boolean selectAllFreeFormTestCases() throws Exception {
		try {
			selectAllFreeFormTestcases.click();
			bp.waitForElement();
			System.out.println("pass-Selected All Testcases");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	// To close Free Form Page
	public boolean closeFreeFormPage() throws Exception {
		try {
			closeFreeFormPage.click();
			bp.waitForElement();
			System.out.println("pass-Freeform page closed");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public boolean assignAllAssignedNotExecuted(String from, String to, String Check) throws Exception {
		try {
			bp = new BasePage();
			// click on radio
			bp.waitForElement();
			bp.waitForElement();
			clickOnRadio3.click();
			bp.waitForElement();
			// select assignee
			if (from != "") {
				Select osel = new Select(allunAssigned1);
				osel.selectByVisibleText(from);
				bp.waitForElement();
			}
			if (to != "") {
				Select ose2 = new Select(allunAssigned2);
				ose2.selectByVisibleText(to);
				bp.waitForElement();
			}
			// click on check box
			if (Check != "") {
				clickOnchkBox3.click();
				bp.waitForElement();
			}
			// save
			clickOnSave1.click();
			bp.waitForElement();
			clickonOK.click();
			bp.waitForElement();

			return true;
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
	}

	// To perform Quick Search
	// added by srikanth 23/09/17
	public boolean quickSearch() throws Exception {
		try {
			bp.waitForElement();
			quickSearch.click();
			System.out.println("pass-Successfully Clicked On Quick Search");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/*
	 * **************************************************** Method Name :
	 * addNode(String Name,String Desc) Purpose : To add nodet in Zephyr
	 * Application in TestPlanning Author : Srikanth Date Created : 25/09/17
	 * Date Modified : Reviewed By :
	 * ******************************************************
	 */
	public boolean addNode(String Name, String Desc) throws Exception {
		try {

			BasePage bp = new BasePage();
			// String releasename3=releasename1+releaseName+releasename2;
			// WebElement ele=driver.findElement(By.xpath(releasename3));
			bp.waitForElement();
			options.click();
			log.info("Pass - Clicked on Options");
			bp.waitForElement();
			bp.waitForElement();
			addNode.click();
			log.info("Pass - Clicked on Add Button");
			bp.waitForElement();
			nodeName.click();
			nodeName.sendKeys(Name);
			nodeDesc.click();
			nodeDesc.sendKeys(Desc);
			bp.waitForElement();
			nodeSave.click();
			log.info("Pass - Clicked on Save Button");
			bp.waitForElement();
			// log.info("Pass - phase created with name and description");
			log.info("Pass - created with name and description");
			bp.waitForElement();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// To click on Advance search
	public boolean clickOnAdvanceSearch() throws Exception {
		try {
			bp = new BasePage();
			AdvancedSearch.click();
			bp.waitForElement();
			System.out.println("pass-clicked on Avancesearchsearch");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public boolean ZQLQuery(String[] zql) throws Exception {
		try {
			for (int i = 0; i < zql.length - 1; i++) {
				Actions act = new Actions(driver);
				act.sendKeys(Keys.SPACE).perform();
				bp.waitForElement();
				WebElement ele = driver.findElement(By.xpath(ele_1 + zql[i] + ele_2));
				String value = ele.getText();
				System.out.println();
				if (zql[i].equalsIgnoreCase(value)) {
					ele.click();
					bp.waitForElement();
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean ZQLSearch(String[] zql, String value) throws Exception {
		try {
			for (int i = 0; i < zql.length - 1; i++) {
				Actions act = new Actions(driver);
				act.sendKeys(Keys.SPACE).perform();
				bp.waitForElement();
				WebElement ele = driver.findElement(By.xpath(ele_1 + zql[i] + ele_2));
				String v = ele.getText();
				System.out.println();
				if (zql[i].equalsIgnoreCase(v)) {
					ele.click();
					bp.waitForElement();
				}
			}
			String quote1 = "\"";
			String quote2 = "\"";
			enterZql.sendKeys(quote1 + value + quote2);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean sortingTestCase(String[] sort) throws Exception {
		try {

			String sorting1 = "(//label[@title='";
			String sorting2 = "'])[2]";
			bp = new BasePage();
			bp.waitForElement();
			enableOrDisable.click();

			for (int i = 0; i <= sort.length - 1; i++) {
				bp.waitForElement();
				WebElement ele = driver.findElement(By.xpath(sorting1 + sort[i] + sorting2));
				String data = ele.getText();
				boolean res = ele.isSelected();
				System.out.println(res);

				if (res == false && sort[i].equals(data)) {
					BasePage bp = new BasePage();
					bp.waitForElement();
					ele.click();
				}

			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean ZQLSearch1(String name, String operator, String value) throws Exception {
		try {
			bp = new BasePage();
			bp.explicitWait(enterZql);
			enterZql.sendKeys(name + operator + value);
			System.out.println(name + operator + value);
			boolean res = clickOnGo.isEnabled();
			System.out.println(res);
			bp.waitForElement();
			bp.explicitWait(clickOnGo);
			clickOnGo.click();
			bp.waitForElement();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean validateSearch() throws Exception {
		try {
			bp = new BasePage();
			bp.waitForElement();

			boolean sp = testcasecount.isEnabled();
			if (sp == true) {
				System.out.println("Pass-testcase count is enabled");
				String testCaseCount = testcasecount.getText();
				int count = Integer.parseInt(testCaseCount);
				bp.waitForElement();
				if (count >= 0) {
					System.out.println("testcase searched Sucesfully");
				}
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean validateAddtestcaesToFreeForm() throws Exception {
		try {
			bp = new BasePage();
			bp.waitForElement();

			boolean sp = validateAdd.isEnabled();
			if (sp == true) {
				System.out.println("Pass-testcase count is enabled");
				String testCaseCount = validateAdd.getText();
				int count = Integer.parseInt(testCaseCount);
				bp.waitForElement();
				if (count >= 0) {
					System.out.println("testcases Added Sucesfully");
				}
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean clickOnBrowse() throws Exception {
		try {
			bp = new BasePage();
			bp.waitForElement();

			clickOnBrowse.click();
			bp.waitForElement();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean clickOnChecKBox(String NodeName) throws Exception {
		try {
			driver.findElement(By.xpath(check1 + NodeName + check2)).click();
			bp.waitForElement();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean sort(String[] sortName) throws Exception {
		try {
			bp = new BasePage();
			sort.click();
			System.out.println("Pass-Sort Icon Clicked Successfully");

			for (int i = 0; i <= sortName.length - 1; i++) {
				bp.waitForElement();
				if (sortName[i].equals("Assigned To") || sortName[i].equals("Notes") || sortName[i].equals("Status")
						|| sortName[i].equals("Actual Time")) {
					WebElement ele = driver.findElement(By.xpath(sortElement1 + sortName[i] + sortElement2));
					String data = ele.getText();
					boolean res = ele.isSelected();
					System.out.println(res);
					if (res == false && sortName[i].equals(data)) {
						bp = new BasePage();
						bp.waitForElement();
						ele.click();
					}
				} else {
					WebElement ele1 = driver
							.findElement(By.xpath(sortElement1 + sortName[i] + sortElement2 + sortElement3));
					String data1 = ele1.getText();
					boolean res1 = ele1.isSelected();
					System.out.println(res1);

					if (res1 == false && sortName[i].equals(data1)) {
						bp = new BasePage();
						bp.waitForElement();
						ele1.click();
					}

				}

			}
			bp.waitForElement();
			Actions a1 = new Actions(driver);
			a1.moveToElement(ID).click().perform();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean selectNode(String cycleName) throws Exception {
		try {
			String cycle4 = cycle1 + cycleName + cycle2;
			driver.findElement(By.xpath(cycle4)).click();
			System.out.println("Node clicked Successfully");

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fail-Cycle selection unsucessful");

			throw e;
		}

	}

	public boolean selectCycleInSearch(String cyclename, String Build, String Environment) throws Exception {
		try {
			Select sel = new Select(selectCycle);
			String cyclename2 = "" + cyclename + " build : " + Build + " env : " + Environment + "";
			sel.selectByVisibleText(cyclename2);
			System.out.println("Pass - " + cyclename + " selected");
			bp.waitForElement();
			return true;
		} catch (Exception e) {
			System.out.println("Fail-Cycle Not Selected");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean selectPhaseInSearch(String PhaseName) throws Exception {
		try {
			Select sel = new Select(selectPhase);
			sel.selectByVisibleText(PhaseName);
			System.out.println("Pass - " + PhaseName + " selected");
			bp.waitForElement();
			return true;
		} catch (Exception e) {
			System.out.println("Fail-Phase Not Selected");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean filterByStatus(String Status) throws Exception {
		try {
			Select sel = new Select(filterByStatus);
			sel.selectByVisibleText(Status);
			System.out.println("Pass - " + Status + " selected");
			bp.waitForElement();
			return true;
		} catch (Exception e) {
			System.out.println("Fail-Status Not Selected");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean clickOnGo() throws Exception {
		try {
			clickOnGo1.click();
			bp.waitForElement();
			return true;
		} catch (Exception e) {
			System.out.println("Fail-Status Not Selected");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean validateRetrieveTestcases() throws Exception {
		try {
			bp = new BasePage();
			bp.waitForElement();

			boolean sp = testcasecount1.isEnabled();
			if (sp == true) {
				System.out.println("Pass-testcase count is enabled");
				String testCaseCount = testcasecount1.getText();
				int count = Integer.parseInt(testCaseCount);
				bp.waitForElement();
				if (count >= 0) {
					System.out.println("Pass-testcases Retrieved Sucesfully");
				} else {
					System.out.println("Fail-Testcases Not Retrieved ");
				}
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean launchOtherCycles() throws Exception {
		try {
			clickOnOtherCycles.click();
			bp.waitForElement();
			System.out.println("pass-Launched Other cycles");
			return true;
		} catch (Exception e) {
			System.out.println("Fail-To launch Other Cycles");
			e.printStackTrace();
			throw e;
		}
	}

	// added by srikanth
	// ZQL Sort operation
	public boolean zqlSort(String[] sortName) throws Exception {
		try {
			bp = new BasePage();
			bp.waitForElement();
			sortZql.click();
			System.out.println("Pass-Sort Icon Clicked Successfully");

			for (int i = 0; i <= sortName.length - 1; i++) {
				bp.waitForElement();
				if (sortName[i].equals("Created On") || sortName[i].equals("Coverage")) {
					WebElement ele = driver.findElement(By.xpath(sortElement1 + sortName[i] + sortElement2));
					String data = ele.getText();
					boolean res = ele.isSelected();
					System.out.println(res);
					if (res == false && sortName[i].equals(data)) {
						bp = new BasePage();
						bp.waitForElement();
						ele.click();
					}
				} else {
					WebElement ele1 = driver
							.findElement(By.xpath(sortElement1 + sortName[i] + sortElement2 + sortElement3));
					String data1 = ele1.getText();
					boolean res1 = ele1.isSelected();
					System.out.println(res1);

					if (res1 == false && sortName[i].equals(data1)) {
						bp = new BasePage();
						bp.waitForElement();
						ele1.click();
					}

				}

			}
			bp.waitForElement();
			Actions a1 = new Actions(driver);
			a1.moveToElement(zqlID).click().perform();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean selectPhasebyIndexInSearch(int index) throws Exception {
		try {
			Select sel = new Select(selectPhase);
			sel.selectByIndex(index);
			return true;
		} catch (Exception e) {
			System.out.println("Fail-Status Not Selected");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean navigateToCycle1(String[] cycleName, String no) throws Exception {
		String cycle4;
		try {
			bp = new BasePage();
			for (int i = 0; i <= cycleName.length - 1; i++) {

				cycle4 = dupCycle1 + cycleName[i] + dupCycle2 + dupCycle3 + no + dupCycle4;
				WebElement nodeElement = driver.findElement(By.xpath(cycle4));
				Actions act = new Actions(driver);
				act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
				String cyclename = driver.findElement(By.xpath(cycle4)).getText();
				System.out.println(cyclename);
				System.out.println("Pass - Double click on'" + cycleName[i] + "' Successfull");
				// act.moveToElement(nodeElement).click().perform();
				bp.waitForElement();
			}
			return true;
		} catch (Exception e) {
			System.out.println("Fail-navigation unsucessful");
			e.printStackTrace();
			throw e;
		}

	}

	/**************************** 06/10/17 ******************************/
	public boolean validateActualTime(int tcNo, String day, String hr, String mn) throws Exception {

		try {

			String validate_time = day + ":" + hr + ":" + mn;
			// System.out.println(validate_time);

			String time = driver.findElement(By.xpath(enterActualTime1 + tcNo + enterActualTime2)).getText();
			System.out.println(time);

			if (validate_time.equals(time)) {
				System.out.println("Pass- Actual Time Successfully Validated");
			}

			return true;
		} catch (Exception e) {
			System.out.println("Actual time is not matched");
			e.printStackTrace();

			throw e;
			// return false;

		}

	}

	public boolean deleteTestcaseInActionColumn(int tcno) throws Exception {
		try {
			WebElement ele = driver.findElement(By.xpath(delete1 + tcno + delete2));
			ele.click();
			System.out.println("Pass-clicked on deleted option from action column sucessfully");
			bp.waitForElement();
			confirmDelete.click();
			bp.waitForElement();
			System.out.println("Pass-deleted testcase from action column sucessfully");
			return true;
		} catch (Exception e) {
			System.out.println("Fail- Delete Unsucessful");
			e.printStackTrace();
			throw e;
		}
	}

	/****************** 12/10/17 ********************/ // added by srikanth
	public boolean clickOnMaintainassignmentsoforiginalschedules() throws Exception {
		try {
			bp = new BasePage();
			bp.waitForElement();
			clickOnMaintainassignmentsoforiginalschedules.click();
			System.out.println("Pass-successfully clicked on Maintain assignments of original schedules");

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean unassignAllSelected(String assignee) throws Exception {
		try {
			bp = new BasePage();
			// select_Assignee.click();
			// bp.waitForElement();
			Actions act = new Actions(driver);
			act.moveToElement(select_Assignee).click().pause(1500).sendKeys(assignee).sendKeys(Keys.ENTER).perform();
			bp.waitForElement();
			// log.info("clicked on all selected assign option");
			// WebElement
			// asssin=driver.findElement(By.xpath(assignee1+assignee+assignee2));
			// asssin.click();
			// bp.waitForElement();
			// log.info("selected assignee"+asssin.getText());
			// clickonOK.click();
			bp.waitForElement();
			return true;
		} catch (Exception e) {
			log.info("Fail-fail to select assignee ");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean doubleClickOnCycle2(String cycleName, WebDriver driver2) throws Exception {
		String cycle4;
		try {
			this.driver = driver2;
			bp = new BasePage();
			String cycle1 = "//*[@data-name='";
			String cycle2 = "']";
			cycle4 = cycle1 + cycleName + cycle2;
			bp.waitForElement();
			WebElement nodeElement = driver.findElement(By.xpath(cycle4));
			Actions act = new Actions(driver);
			act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
			String cyclename = driver.findElement(By.xpath(cycle4)).getText();
			System.out.println(cyclename);
			System.out.println("Pass - Double click on'" + cycleName + "' Successfull");
			// act.moveToElement(nodeElement).click().perform();
			bp.waitForElement();

			return true;
		} catch (Exception e) {
			System.out.println("Fail-cycle navigation unsucessful");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean navigateToCycle2(String[] cycleName, WebDriver driver2) throws Exception {
		this.driver = driver2;
		String cycle4;
		try {
			for (int i = 0; i <= cycleName.length - 1; i++) {
				String cycle1 = "//*[@data-name='";
				String cycle2 = "']";
				cycle4 = cycle1 + cycleName[i] + cycle2;
				WebElement nodeElement = driver.findElement(By.xpath(cycle4));
				Actions act = new Actions(driver);
				act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
				String cyclename = driver.findElement(By.xpath(cycle4)).getText();
				log.info(cyclename);
				log.info("Pass - Double click on'" + cycleName[i] + "' Successfull");
				// act.moveToElement(nodeElement).click().perform();
				bp.waitForElement();
			}
			return true;
		} catch (Exception e) {
			log.info("Fail-navigation unsucessful");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean assignPhase2(WebDriver driver2) throws Exception {
		try {
			this.driver = driver2;
			BasePage bp = new BasePage();
			bp.waitForElement();
			driver.findElement(By.xpath("//div[@class='contextMenuIcon fa fa-ellipsis-v']")).click();
			log.info("Pass - Clicked on Options");
			bp.waitForElement();
			driver.findElement(By.xpath("//a[text()='Assign']")).click();
			bp.waitForElement();
			return true;
		} catch (Exception e) {
			log.info("Fail-phase not assigned");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean assignAllSelectedWaitForOk2(String assignee, WebDriver driver2) throws Exception {
		try {
			this.driver = driver2;
			bp = new BasePage();
			// select_Assignee.click();
			// bp.waitForElement();
			WebElement ele = driver.findElement(By.xpath("//span[text()='Select Assignee']"));
			Actions act = new Actions(driver);
			act.moveToElement(ele).click().pause(1500).sendKeys(assignee).sendKeys(Keys.ENTER).perform();
			bp.waitForElement();
			// log.info("clicked on all selected assign option");
			// WebElement
			// asssin=driver.findElement(By.xpath(assignee1+assignee+assignee2));
			// asssin.click();
			// bp.waitForElement();
			// log.info("selected assignee"+asssin.getText());
			// clickonOK.click();
			bp.waitForElement();
			return true;
		} catch (Exception e) {
			log.info("Fail-fail to select assignee ");
			e.printStackTrace();
			throw e;
		}
	}

	public boolean okForAssignSelected2(WebDriver driver2) throws Exception {
		try {
			this.driver = driver2;
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			// clickonOK.click();
			return true;
		} catch (Exception e) {
			log.info("Fail-fail to select assignee ");
			e.printStackTrace();
			throw e;
		}

	}

	public boolean selectallTestCase2(WebDriver driver2) throws Exception {
		try {
			this.driver = driver2;
			driver.findElement(By.xpath(".//*[@id='phase_testcase_select_all']")).click();
			// select_all_TestCases.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean synch() throws Exception {
		try {
			bp = new BasePage();
			clickOnSynch.click();
			bp.waitForElement();
			bp.waitForElement();
			// click on checkbox
			clickOnSynchChkBox.click();
			bp.waitForElement();
			// continue
			clickOnSynchContinue1.click();
			bp.waitForElement();
			// continue
			clickOnSynchContinue2.click();
			bp.waitForElement();
			// ok
			clickOnSynchOk.click();
			bp.waitForElement();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
