Feature: Export_Master

@Export
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
	And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully

#rel1
@Export
Scenario: 1 Precondition- Create Node upto Eighth Level

Given User Selects the Project
When User Selects the Relaese
And Navigate to Test Repository Page Module
And Double Click On the Release
And Creates a Phases <Count> upto Eighth Level
And Add Test Cases to Eighth Level test Cases
Then Test Case Added To the Node

#P
#Rel 2
@Export
Scenario: 2 Precondition- Creating a Node
 Given User Select the Project
When User Selects The Relaese
And navigate to Test Repository Page Module
And Double Click On The release
And Creates a Phase in the Relaese
And Add Test Cases to the Phase
Then Test Case Added To the Phase


@Export
Scenario: 1 798102 Export Tree Node at Release level as Tester
Given User is in the Test RepositoryPage
When User Select the Release and choose Export Test Option
And select Data Report to an Excel File
Then all the Selected test case should be exported

@Export
Scenario: 2 798103 Export Tree node at Release level and generate Summary Report as Tester
Given User is in the Test RepositoryPage
When User Select the Release and choose Export Test option
And Select report type as summary
And generate the ouput in HTML/PDF/Word format
Then all the Selected test cases Should be exported

#
@Export
Scenario: 3 798104 Export Tree node at Release level and generate Detailed Report as Tester
Given User is in the Test RepositoryPage
When User Select the Release and Choose Export Tests Option
And Select Report type as Detailed
Then Test Case Should be Exported in detailed

@Export
Scenario Outline:4 798108 Export Tree node have test cases with Attachements
Given User is in the Test RepositoryPage
When User Select the Node and Choose Test Export Option
And Select Report type "<reportType>"
And Select Output type "<outputType>"	
Then Test Case should be exported with attachement"<Validation>"
Examples:
    | reportType             |outputType |Validation | 
    |Data (Excel only)       |           |           |
    |Summary                 |PDF        |PDF        |
    |Detailed                |Word       |Word       |
    |Summary                 |HTML       |HTML       |
    
#
@Export
Scenario Outline:5 798112 Export tree node (P/S/SS) have testacases with test steps, and execute Data/Summary/Detailed report to any format (HTML/PDF/Word/Excel) as Tester
Given User is in the test repository page
When User select the node and Choose test export option
And Select Report type "<report type>" as Data/Summary/Detailed/Summary
And Select Output type "<output type>" as Excel/PDF/Word/HTML
Then Test Case should be exported with test steps "<validation>"
Examples:
    | report type            |output type |validation | 
    |Data (Excel only)       |            |          |
    |Summary                 |PDF        |PDF        |
    |Detailed                |Word       |Word       |
    |Summary                 |HTML       |HTML       |
	
#	
@Export
Scenario: 6 798067 Export the search results when searched with In this release checkbox is selected as Tester
Given User is in the test repository page
When User select the node
And Add few test case in the node
And navigate to search and select the option in these release 
And export the test cases
Then should be able to export only the returned result
#
@Export
Scenario: 7 798116 Export nested Phase have testacases at lowest level in the tree have test steps, and execute Data/Detailed report to any format (HTML/PDF/Word/Excel) as Tester
Given User is in the Test repository page
When User Select the node and choose export test option
And Select report type
And Select output type
Then test cases should be exported Sucessfully

#
@Export
Scenario: 8 798136 Export multi-Select testcases(includes both Manual and Auto) in TCC Grid and execute Detailed report to any format (HTML/PDF/Word/Excel) as Tester
Given User is in the test repository page
When User select the node
And User select the multiple test cases
And click on export button and select Detailed report
And select Output type
And click on Save and Download
Then test Case should be exported Successfully 
#
@Export
Scenario: 9 798353 Export tree node at Release/P/S/SS level if nodes under it have testcases with different values for estimated time as Tester
Given User is in the test repository page
When User select the node and choose test export option
And Select report type as Summary
And select output type 
Then Test Case should be exported with different estimated time
#
#
@Export
Scenario: 10 798068 Export the search results when searched with In this release checkbox is unselected as Tester
Given User is in the test repository page
When User select the node
And Add few test cases in the node
And navigate to search and Unselect the option in these release 
Then should be able to export all the testcases irrespective of the search results
#	
@Export
Scenario: 11 798387 Export Phase having testcases with multiple test steps at different level(P/S/SS) as Tester
Given User is in the test repository page
When User Select the Phase and choose export test option
And click on Save and Download
Then test case should be exported with test steps

#sol
@Export
Scenario: 12 798363 Move system to system of other tree node to become subsystem, Export at release level
Given User is in the test repository page
When User move system to system of other tree node
And Export test cases at release level
Then test cases should be exported

#L
@Export
Scenario: 13 798063 Export selected test cases in search as Laed/Manager
Given User is in the test Repository Page
When User Add a phase and add test cases in the phase
And navigate to search and search test cases
And select few test cases and export
Then selected test cases in search results should be exported 
#
@Export
Scenario: 14 798064 Export test cases in search by clicking on Export button as Manager
Given User is in the Node Page
When User Add few test cases to the node
And navigate to search page and click on export
Then all the test cases present in search result should be exported
#
@Export
Scenario: 15 809370 Move the system/subsystem to any node
Given User is in the test Repository page
When User Add a phase,system and subsystem
And select system and choose move option
And naviagate to another phase
And paste the selected system
Then selected system should be moved to the phase
#

#sol
@Export
Scenario: 16 798155 Export test cases with Custom fields and execute Data report to an excel file
Given User is in the test Repository page
	When User creates a phase
	And add a test case to the phase
	And enter test case detail with custom field
	And click on export option 
	And click on save and download button 
Then test case should be exported successfully
#P
@Export
Scenario: 17 798374 Move some/all testcases of phase to its system/subsystem, export testcase from TCC grid 
Given User is in the test Repository page
When User creates a phase ,system and subsystem
And navigate to the phase and add test cases
	And navigate to the system and subsystem
	And select the multiple test case from phase
And move to the system/subsystem
And select multiple test case from test case grid
And export the test case
Then selected test case should be exported

@Export
Scenario: Logout
Given User is in the Zephyr ProjectPage
When User Clicks on logout Icon
	And User clicks on Logout Option
Then User should be logged out from Zephyr Application Successfully  


    
	
