package com.zephyr.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zephyr.common.LaunchBrowser;

//import com.zephyr.reusablemethods.BasePage;

public class NavigationaPage_POM {

WebDriver driver=null;
	

public NavigationaPage_POM(WebDriver driver) 
{
	this.driver = driver;
	PageFactory.initElements(LaunchBrowser.driver, this);
}

@FindBy(xpath=".//*[@id='pagination-page-size-tcr']")
public WebElement clickOnPageSize;

@FindBy(xpath=".//*[@id='pagination-page-size-tcr']")
public WebElement clickOnOptions;

@FindBy(xpath=".//*[@id='pagination-page-size-tcr']/option[1]")
public WebElement clickOnOption;

@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/li[3]/a/span")
public WebElement clickOnNextButton;

@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/li[2]/a/span")
public WebElement clickOnPrevButton;

@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span")
public WebElement clickOnPageNumbers;

@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li")
public WebElement clickOnPages;

@FindBy(xpath="//*[@class='breadcrumb zui-breadcrumb']")
public WebElement breadCrumbs;

@FindBy(xpath="//label[@class='zui-search-label']/span[contains(.,'Advanced')]")
public WebElement advancedSearch;

@FindBy(xpath="//*[text()='Go']")
public WebElement clickOnGo;

//@FindBy(xpath="//span")
@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[2]/div[1]")
public WebElement clickOnSearch;

@FindBy(xpath=".//*[@id='zui-search-textarea']")
public WebElement clickOnSearchTextArea;

@FindBy(xpath=".//*[@id='zql-search-input-tcr-search']")
public WebElement advancedSearchTextArea;

@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[2]/div[1]/section/div/zui-zephyr-search/div/zui-zql-search/div/div[2]/div/select")
public WebElement prevSearchDropDown;

@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[2]/div[1]/section/div/zui-zephyr-search/div/zui-zql-search/div/div[2]/div/select/option")
public WebElement clickOnPreviousSearch;

@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[2]/a")
public WebElement clickOnPage2;

@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[3]/a")
public WebElement clickOnPage3;

@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[4]/a")
public WebElement clickOnPage4;

@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[5]/a")
public WebElement clickOnPage5;

@FindBy(xpath="//*[@class='zql-search-previous']")///////////////////////////////////added
public WebElement previousSearch;

@FindBy(xpath="//div[text()='100']")///////////////////////////////////added
public WebElement searchTestCaseText;






}
