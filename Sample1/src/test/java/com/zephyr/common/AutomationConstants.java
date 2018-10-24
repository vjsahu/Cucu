package com.zephyr.common;

import com.zephyr.generic.Property_Lib;

public interface AutomationConstants
{
	public static  final String CONFIG_PATH="./ConfigFiles/";
	public static  final String CONFIG_FILE="config.properties";
	public static  final String DRIVER_PATH="./Drivers/";
	public static  final String CHROME_FILE="chromedriver.exe";
	
	public static  final String GECKO_FILE="geckodriver.exe";
	public static  final String IE_FILE="IEDriverServer.exe";

	//public static  final String EXPECTED_PATH="./expected/";
	//public static  final String JARS_PATH="./jars/";
	//public static  final String REPORT_PATH="./report/";
	//public static  final String REPORT_FILE="report.html";
	//public static  final String SNAP_PATH="./snap/";
	public static 	final String INPUT_PATH="./User_Input/inputs.xlsx";
	public static 	final String INPUT_PATH_1="./User_Input/inputs_1.xlsx";
	public static final String INPUT_PATH_2="./User_Input/inputs_2.xlsx";
	public static 	final String INPUT_PATH_3="./User_Input/Inputs_3.xlsx";
	public static 	final String INPUT_PATH_4="./User_Input/input_4.xlsx";
	public static  final String CHROME_KEY="webdriver.chrome.driver";;
	public static  final String GECKO_KEY="webdriver.gecko.driver";
	public static  final String IE_KEY="webdriver.ie.driver";
	
	public static  final String CONFIG_PATH1="./ConfigFiles/config2.properties";
	
	 public static String UNIQUE="Auto_"+Property_Lib.getPropertyValue(CONFIG_PATH1,"Count")+"_";
	
	 public static final int EXPLICIT=Integer.parseInt(Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"EXPLICIT"));
	 
	 
}











