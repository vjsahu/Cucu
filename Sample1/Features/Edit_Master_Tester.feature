Feature: Edit_Master

@Edit
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
	And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully


@Edit
Scenario: 1Precondition- Creating phase,system and subsysytem
Given User selects the Project and Select release 
When user naviagate to Test Repository page
And double click On Release 
And create a Phase and navigate to Phase and add test cases
And Read the test case Count
And create a System  and navigate to system and add test cases
And Read the test case Count 
And create Subsystem and navigate to subsystem and add test cases
And Read the test case Count



@Edit
Scenario: 2Precondition- Creating phase
Given User Selects the Project and selects release 
When User Naviagate to Test Repository page
And Double Click On Release
And Creates a Phase and navigate to Phase and add test cases
And Read the Test Case Count



@Edit
Scenario: 1 809032 As Tester, Update Test Case name and description
Given user is in the phase page
When User select the Test Case
And Edit the test case name and description
Then test case should be updated 

@Edit
Scenario: 2 809284 Editing tags of test case as Tester
Given Tester is in the test case Page
When Tester Edit a tag of test case
Then test case successfully edited 

@Edit
Scenario: 3 808728 Rename phase/system/subsystem and view bread crumds are reflecting
Given User is in test repository page
When User creates a phase,system and subsystem 
And navigate to subsystem and view the bread crumbs
And  rename the subsystem and view the bread crumbs
Then bread crumbs should be updated sucessfully


@Edit
Scenario Outline:4 809069 As Tester, Change the Priority of a Test Case & Save the Changes
Given User is on the test Case Page
When User change the priority to "<Priority>"
Then priority should be changed
Examples:
    |Priority|
    |P1      |
    |P2      |
    |P3      |
    |P4      |

@Edit
Scenario: 5 809086 As Tester, Sort first and Copy test case using Clone button
Given User is in the node page
When User sort the fields
And select few test cases
And copy test cases using clone button
Then test cases should be copied

@Edit
Scenario: 6 809227 As tester,change the Alt Id,Auto,Custom Fields of the multi selected test cases and save changes in Change Multiple test cases window
Given User is in the Phase Page
When User selects multiple test cases
And edit Alt Id,Auto
And edit the Custom Fields and saved it
Then multi selected test case should be edited



@Edit
Scenario: 7 809272 Delete single attachment from a test case as Tester
Given User select the test case
When User delete the attachement
Then attachement should be deleted 

@Edit
Scenario: 8 809332 Check the test case count when adding, cloning and deleting test cases as tester
Given User is the node page
When User Add a test case
Then test case count should be increased
When User clone a test case
Then test case count should be increased
When User delete a test case
Then test case count should be decreased

@Edit
Scenario: 9 809390 Copy a node from one to another and view the parent node 
Given User is in the test repsository page
When User selects and copy the node 
And select the node and paste the copied node
Then selected node should be copied to other node

@Edit
Scenario: 10 809302 Edit a test case ,set execution time from 99:23:59 to 00:00:00
Given User is in test repository page
When user select a node containing test case
And edit the test case execution time
Then test Case should be edited

@Edit
Scenario: 11 809040 As Tester, add more than one attachment to a Test case
Given user is in the phase page
When User Select the test case
And Add a attachement to the test case
Then File should be attached to the test case

@Edit
Scenario: 12 809118 As Lead, Copy Test Case using Clone button
Given User selected the test Case
When User click on clone button
Then Test Case Should be cloned Successfully

@Edit
Scenario: 13 809249 Change  testcases in bulk for subsytem in 8th hierarchy level using Edit button as Lead or Manager
Given User is in the Test Repository Page of Release1
When User creates subsystem upto eighth level
And Add test cases to the last level
And select the test case and click on Edit button
Then Edit Test Case Page should be displayed
When User edit the test case fields
Then test case should be edited Successfully
#P
@Edit
Scenario: 14 809184 As mgr/lead/tester, bulk edit Alt Id, Auto of the multi Select test cases and save changes 
Given User is in the test repository page
When User add a node and and add test cases to the node
And User Select the multiple test cases
And edit the AltId and Automation field
Then test case should be edited


@Edit
Scenario: 15 809410 Add a new tag after deleting old tags and save it
Given User is in the phase page
When User add a test case and click on detail
And enter multiple tags and save it 
And edit the entered multiple test case and save it
Then test case edited successfully

@Edit
Scenario: 16 802982_Modify a map and save changes
Given User is in the Testrepository page
When User navigates to the Release
	And User clicks on ImportIcon
	And User moves to Create map field
	And User modifies the Map
Then Map should be modified successfully
#

@Edit
Scenario: 17 803005_Modify an import job and  save the changes
Given User Is Present in the TestRepositoryPage
When Use navigates to Release
	And User clicks on importicon
	And User Moves to the ImportJob Field
	And User Selects a Job and Modifies it
Then Importjob should be modified successfully

@Edit
Scenario: 18 803025_Rename an import node with time stamp under Imported folder
Given User is in Testrepository page
When User navigates to Releasename
	And User Clicks on Imported Folder
	And User Rename the Selected file
Then File should be Renamed Successfully

@Edit
Scenario: 19 809123_As Lead Modifying the Testcase with name,Priority, TagValue, EstimatedTime,TestSteps
Given Lead Navigated to TestRepositorypage
When Lead Navigates to the Phase
	And Lead Selects a Testcase and moves to DetailView
	And Lead Modify the Testcase Name, Description and save it
	And Lead Modify the Priority, TagValue and save it
	And Lead Modify the EstimatedTime and save it
	And Lead Modify the TestSteps and save it
Then As Lead Testcase should be Modified Successfully


@Edit
Scenario: 20 809148_As Tester, Edit & Modify a test case when other resource is viewing the same test case
Given Tester is in the Testrepository
When Tester moves to the Releasename
	And Tester navigates to the Phase
	And Tester Selects the Testcase
	And Tester Modify the Testcase Name and Description in View
Then Testcase should be modified successfully by Tester

@Edit
Scenario: 21 809254_Edit 100 manual Tc to Automated Script
Given User navigates to the Testrepository
When User moves to Releasename
	And User moves to the Phase
	And User Selects Multiple Manual Testcases
	And User Clicks on Edit and convert to Automated Testcase
Then Testcases should be converted into AutomatedTC with Internation cahracters in Nmae


@Edit
Scenario: 22 809266_As Tester re-order test steps using Dnd & save changes
Given Tester is Presents in the Testrepository
When Tester moves to the ReleaseName
	And Tester Navigates to the Phase
	And Tester Selects a Testcase
	And Tester clicks on DetailView
	And Tester moves to StepDetails and Perform DnD Operation
Then DnD should be Performed Successfully by Tester

@Edit
Scenario: 23 809268_As Tester re-order test steps using Dnd, modify & save
Given User moved to Testrepository
When User moves to Provided Release
	And User moves to the PhaseName
	And User Selects Specified Testcase
	And User Clicks on the Details View
	And User Modify the Teststeps
	And User DnD the Teststeps to Specified Stepnumber
Then Teststeps should be Modified and Dnd Successfully

@Edit
Scenario: 24 809273_Navigate from one test step to another then edit step step
Given User moves to the TestRepository
 When User moves to ReleaseName
	And User navigates to Phasename
	And User Selects Testcasename
	And User Clicks on Details view
	And User Moves to StepDetails and Edit the TestSteps
Then Teststeps should be Edited Successfully




@Edit
Scenario: 25 809284_Editing tags of test case as Tester
Given Tester is in the test case Page
When Tester Edit a tag of test case
Then test case successfully edited 

@Edit
Scenario: 26 809420_Clone the >200 testcases in Testrepository
Given User moves to the TestcaseRepository
When User navigates to release
	And User moves to Phase
	And User Selects >Two Hundred testcases
	And User Performs the Clone Operation
Then >Two Hundred Testcases should be Cloned Successfully

@Edit
Scenario: 27 809421_Moving TestCase from one node to another node
Given User Moved to the TestRepositoryPage
When User navigated to Releasename
	And User Creates two phases and Adds two testcases to each phase
	And User moves one Testcase from one phase to another phase
Then Testcase should be moved successfully from one phase to another phase
	 
@Edit
Scenario: 28 809222_change the  Alt Id, Auto, Comments, Priority Tags, Custom Fields (Text/Long Text/Picklist/Number/Date/Checkbox) of the multiselected testcases and save changes  in Change Multiple Testcases window.
Given User Present in the TestRepository
When User Clicks On Release
	And User Creates Phase and Selects it
	And User Creates a Testcase with all Fields
	And User navigate back to Release and Phase
	And User selects the Created Testcase
	And User Changes the Fields in Testcase and Saves it
Then Changes should be successfully applied for the Testcases

@Edit
Scenario: 29 809342_Bulk edit testcase and view the custom fields in details when all ready few of the testcases are bulk edited with all the custom fields
Given User is present in the TestRepositorypage
When User Creates phase and adds Five Testcases
	And User selects Three Testcases and Performs Edit Operation in Bulk
	And User adds Three more testcases in same phase
	And User Performs Bulk Edit operation without Custom fields
Then Bulk edited testcases without custom fields should retain Same values


@Edit
Scenario: 30 809214_bulk edit custom fields (type date) of multiselected testcases and save changes  in Change Multiple Testcases window.
Given User is Present in the TestRepositorypage
When User Creates Phase and Adds Three Testcases 
	And User Selects Two Testcases and Clicks on Edit
	And User Performs Bulk Edit for Custom fields with PresentDate
	And User Performs Bulk Edit for Custom fields with PastDate
	And User Performs Bulk Edit for Custom fields with FutureDate 
Then Custom fields should be Modified successfully with Present, Past, Future Dates

@Edit
Scenario: 31 808926_Reset the test data of a step and save the changes
Given User Presents in the TestPageRepository
When User Creates a phase 
	And User Adds Testcase to the Phase
	And User Clicks on detail view
	And User Adds Teststeps in StepDetails
	And User Resets only TestData and Saves it
Then TestData should be Reset Successfully


@Edit
Scenario: 32 809265_Update only some of the required fields in automated section of testcases in bulk editing without having to do all
Given User Present in the TestRepositoryPage
When User Creates phase
	And User Adds Three Testcase with AutomatedScript Field to the Phase
	And User Selects Two Testcases for Bulk Edit Operation
	And User Edits AutomatedScript with only some fields
Then AutomatedScript with only some fields should be Modified successfully
#
#P
@Edit
Scenario: 33 808927_Reset multiple teststeps and cancel the changes
Given User is Present in the TestRepositoryPage
When User Creates Phase
	And User Adds one Testcase 
	And User Adds Multiple TestSteps for the Testcases
	And User Resets the Multiple Testcases
Then Multiple TestSteps should be Reset Successfully

@Edit
Scenario: 34 809318_As Concurrent users, add test steps in test case
Given User is in the TestRepo Page
When User Clicks on Release
	And User Creates Phase in Release
	And User Adds Testcase in the Created phase
	And User Adds Steps to the Testcase
Then Teststeps should be Added Successfully in the Testcase


@Edit
Scenario: 35 809261_Edit multiple tags for Multiple testcases
Given User is in TestrepoPage
When User Clicks Release
	And User Creates phase in the Release
	And User adds three testcases to Phase
	And User Clicks on Edit Icon
	And User adds the Testcases to the Multiple selected Testcases
Then Multiple tags should be Added to Multiple testases successfully

@Edit
Scenario: 36 809317_Perform copying of testcase and creating a node at the same time
Given User is in Testrepopage
When User moves to Releasenames
	And User Creates a Phase in release
	And User adds Two Testcase in Phase
	And User clones the Testcases
Then Phase should be created and Testcases are cloned Successfully

#P
@Edit
Scenario: 37 809269_As Tester re-order test steps using Dnd, modify & Cancel
Given User is in the testrepopage
When User Moves to Releasename
	And User Creates Phase in release
	And User Adds Testcase to Phase
	And User Adds Teststeps to the Testcase
	And User Perform DragAndDrop Operation
Then Testcases should be Reorderd successfully


@Edit
Scenario: 38 803036_Copy imported test cases in another release to the current release
Given User is in Repository Page
When User moves to the Releaename
	And User Clicks on importIcon
	And User Creates Map with Matching Fields
	And User Creates Import Job for the Created Map
	And User runs the Imported Job
	And User navigates to the Imported File
	And User Copy the Imported Node
	And User Creates Phase in the Release
	And User Pastes the File in Created Phase
Then File should be copied successfully to the Phase of Current Release


@Edit
Scenario: 39 809112_As Lead, rename Sub-system
Given Lead is In Testrepository Page
When Lead Moves to the Releasename
	And Lead Creates Phase
	And Lead Creates System in the Phase
	And Lead Creates SubSystem in the System
	And Lead Rename the Subsystem
Then SubSystem should be Renamed Successfully



@Edit
Scenario: 40 809198_Bulk edit Alt Id, Auto, Comments, Priority, Tags of the multi-selected test cases and save changes
Given User is in the test repository page
When User Add a node and add test cases to the node
And Select the multiple test cases
And edit the test case fields
Then test case should be modified

@Edit
Scenario: 41 809370_Moving Subsystem to node
Given User moved to TestRepositoryPage
When User Moves to Release
	And User Creates two Phase and one System in each System
	And User Moves System of One Phase to another Phase
Then System should be moved successfully to Phase


@Edit
Scenario: 42 809413_Save a testcase with custom field of type date and view the date
Given user in Repository page
When create a node with test case and click detail
And edit custom field with date
Then view and verify the date


@Edit
Scenario: 43 808593 Edit drag and drop testcases from Global Sub-system to Current Sub-system
Given User in  Repository Page
	And select copy from release option
When navigate to global subsystem and drag
	And navigate to local subsystem and drop
Then Should copy testcases from Global Sub-system to Current Sub-system 
#
 
@Edit
Scenario: 44 808694 Copy Global Imported node to Local Release node 
Given user is present in the repository page
When User moves to the Release
	And User Clicks on Importicon 
	And User Creates map with all fields
	And User Imports a Testcase and Runs it
	Then Testcase with all fields should be Imported Successfully
	And Select the Copy from release option
  When drag the imported node from global release
	And drop the node in local relase
Then should able to copy

@Edit
Scenario: 45 808698_Copy Imported node from Global to Local Phase 
Given User in repository page
When select the copy from release option 
And click on release and imported
And Drag and drop from global to local
Then Should be able to copy imported node


@Edit
Scenario: 46 808928_Reset multiple test step in a test case
Given User in the Repository Page
When Add a Node and testcase
And Click on detail and Enter Teststeps
And Re_Enter step Details and click on cancel
Then Should reset the steps


@Edit
Scenario: Logout
Given User is in the Zephyr ProjectPage
When User Clicks on logout Icon
	And User clicks on Logout Option
Then User should be logged out from Zephyr Application Successfully

@Edit
Scenario Outline: 47 809172_As mgr/lead/tester, bulk edit Alt Id of multi-selected test cases and save changes
Given User is on the phase page "<Users>"
When User select the test cases
	And edit the AltId "<AltId>" of the multi-selected test cases
Then AltId should be changed

Examples:
    | Users         |AltId    | 
    |leadOne   |abc      | 
    |lead   |XYZ      |
    |lead   |123      |
    |lead   |rts123   |
    |lead   |@&%      |
    |lead      |def      |
    |lead      |PWD      |
    |lead      |456      |
    |lead      |hte456   |
    |lead      |%^&      |
    |tester    |ghi      |
    |tester     |GTH     |
    |tester     |789     |
    |tester     |qst890  |
    |tester     |!&#     |
    
    
    
    @Edit
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
	And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully
  
   
@Edit
Scenario: 48 809198_Bulk edit Alt Id, Auto, Comments, Priority, Tags of the multi-selected test cases and save changes
Given User is in the test repository page
When User Add a node and add test cases to the node
And Select the multiple test cases
And edit the test case fields
Then test case should be modified


@Edit
Scenario: 49 809208_As tester,bulk edit custom fields(type picklist) of multi selected test cases and save changes in Change Multiple test cases window
Given User is in the Phase page
And User selected the multiple test cases
When User click on Edit and edit the custom field
Then custom field should be edited


@Edit
Scenario: 50 809211_As tester,bulk edit custom fields(type checkbox) to multiselected test cases using edit button
Given User is in the Phase page
	And User selected the multiple test cases
When User click on edit and edit custom field of types checkbox
Then custom field should be edited successfully


@Edit
Scenario: 51 809218_As tester,change the custom fields(type number) of multi-selected test cases and save changes in edit multiple test cases window.
Given User is in the Phase page
	And User selected the multiple test cases
When User click on edit and edit custom field of type number
Then custom field of type number should be modified

@Edit
Scenario: 52 809300_As a Manager/Lead/Tester, edit the  test case estimated execution time for a phase/system/subsystem. 
Given Uesr is in the test repository page
When User select the phase and select test case
And edit the execution time 
Then execution time should be changed
When User select the system and select test case
And edit the execution time
Then execution time should be modified
When User select the subsystem and test case
And edit the execution time
Then execution time should be edited

| Fields                 | Values              |
| First Name             | Tom                 |


@Edit
Scenario: 53 809414_Save test step formatted in different lines and  view it
Given User is in the test repository page
When User Add a node in release
And Add test case in the node and
And naviagte to detail view
And add test step,test data and expected result
Then test case should be created with stepDetails
#
@Edit
Scenario: 54  809399_Bulk edit tag alone in bulk edit window 
Given User is in the test repository page
When User add a node and add multiple test cases in the node
And select the multiple test case
And edit the tag of multi-selected test case
Then test case should be edited successfully

@Edit
Scenario: 55 809400_Move/Copy  multiple testcases from one node to another
Given user in repository page
When user creates phase system and subsystem
And Add ten testcases to phase
And copy three testcases to system
And move three testcases to subsystem
Then Should be able to move/copy multiple testcases

@Edit
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
	And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully


@Edit
Scenario: 56 809352_Change automated test case to manual from test case details 
Given User is in the test Repository Page of Normal Project
When User create a node  
And Add test case in the node
And navigate to test case detail page
And check automation script and enter Automat fields
And make it manual by unchecked automation field
Then test case should be converted into manaual
#
#
#
#BP cxheck
@Edit
Scenario: 57 803030_Copy multiple test cases from Global import node to current the phase
Given User in Repository page
When Create phase/s/ss and select imported node
And navigate to phase and copy testcases
And navigate to system and copy
And navigate to subsystem and copy
Then should be copy in all phases 

@Edit
Scenario: Logout
Given User is in the Zephyr ProjectPage
When User Clicks on logout Icon
	And User clicks on Logout Option
Then User should be logged out from Zephyr Application Successfully

@Edit
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
	And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully

@Edit
Scenario: 58 803046_Copy an imported node to a local P/S/SS and delete the import node
Given User in The Repository page
When The import is sucessful
And copy the imported node
And Paste the node in the phase
And Delete the imported file
Then should remains in phase

 
@Edit
Scenario: 59 797103_Edit teststeps and view the step history
Given user in then testrepository page
When add node and testcase
And view test step history and modify test step
Then should be able view latest history
	 
@Edit
Scenario: Logout
Given User is in the Zephyr ProjectPage
When User Clicks on logout Icon
	And User clicks on Logout Option
Then User should be logged out from Zephyr Application Successfully


