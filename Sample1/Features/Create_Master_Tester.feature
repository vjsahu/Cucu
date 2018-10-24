Feature: Create_Master

@Create1
Scenario: Precondition- 809199_As mgr, Create Testcase custom fields of all types
Given Manager Login into Zephyr Application
When Manager Navigates upto Testcase Fields in the Customizations Option
	And Manager Locks the Zephyr Acces for all other Users
	And Manager Adds Custom field with Text
	And Manager Adds Custom field with LongText
	And Manager Adds Custom field with Picklist
	And Manager Adds Custom field with Checkbox
	And Manager Adds Custom field with Number
	And Manager Adds Custom field with Date
Then Custom Fields with Text,LongText,Picklist,Checkbox,Number,Date Should be created Successfully


@Create
Scenario: Precondition- Logout
Given User is in the Zephyr ProjectPage
When User Clicks on logout Icon
	And User clicks on Logout Option
Then User should be logged out from Zephyr Application Successfully
	

@Create
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
	And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully

#P
@Create
Scenario: 1 809275 Adding multiple Tags to the Test Case as Tester
Given Tester is in the Phase of Test Repository Page
When Tester click on Add button
And Enters Multiple Tags
Then New Test Case Should be Added With Multiple Tags

@Create
Scenario: 2 809283 Adding tags to the test case as Tester
Given User is in the Test case page
When User Add tags to the test case
Then Tags successfully added to the test case
#P
@Create
Scenario: 3 809321 Create a test Case with Test Steps and Save
 Given Tester is in Test Case Page of Subsystem
  When User click on Add Tab 
  And Change the Summary Of Test Case
  And Enters the Step Details Field
  Then Test Case With Step Detail Field Should be Created
	
@Create
Scenario: 4 809365 Adding Attachement to the Test Case as Tester
Given Tester is in Test Case Detail Page
When Tester Navigates to Attachement and Drag and Drop the File
Then File should be Added To the Test Case
	
@Create
Scenario: 5 809116 Adding a Test case as Lead in Phase,System and Subsystem
Given Lead is in Test Repository Page
 When lead selects the phase 
 And clicks On Add button
 Then new Test Case Should be Added to the Phase	
When lead selects The System
And clicks On Add button
Then new Test Case Should be Added to the System
When lead selects The Subsystem 
And clicks On Add button
Then new Test Case Should be Added to the Subsystem

@Create
Scenario: 6 809347 Create test case with name having maximum characters
Given Lead or Manager is in the TestRepository Page
When User Creates a Phase
And Add a Test Case with name having max character
Then Test case should be added with Name

@Create
Scenario: 7 808876 Adding test Case to Phase System and Subsystem as Manager or Lead
Given User is in the Test Repository Page
When User Create a Phase 
And Add Test Case to the Phase
Then Test Case Should be Created in Phase
When User Creates a System
And Add Test Case to the System
Then Test Case Should be Created in System
When User Creates a Subsystem
And Add Test Case to the Subsystem in Detail view
Then Test case Should be created in Subsystem

@Create
Scenario: 8 808922 Add test case to the newly created Phase,System and Subsystem in detail view as Lead or Manager
Given User is in Test Repository Page
When User Creates a Phase and Navigate to Detail view
And Add a test Case 
When User creates a System and Navigate to Detail view
And Add a test Case
When User Creates a Subsystem and Navigate to Detail view
And Add a test Case
 
@Create
 Scenario: 9 809129 Adding Attachements to the Test Case as Lead
Given Lead is in Test Case Details Page
When Lead click On Attachement and browse The File
Then Selected File Should Be Attached To The Test Case
	
@Create
Scenario: 10 809153_Create Three Phases, Two Systems Under each Phases and Two Sub-Systems in each Sub-System
Given User in the TestRepositoryPage
When User Navigates to Release
When User creates three Phases
Then Three phases should be Created Successfully
When User Navigates to each Phase
When User Creates two Systems Under each Phase
Then Systems Should be Created Successfully
When User Navigates to each System
When User Creates two Sub-Systems Under each System
Then Sub-Systems Should be Created Successfully

@Create
Scenario: 11 809092_Add Phase, System and Sub-System with Description
Given User is in the TestRepositoryPage
When User navigates to ReleaseName
And User Creates a Phase with Name and Description
Then Phase should be added Successfully with Name and Description
When User navigates to Phases
And User Creates a System with Name and Description
Then System should be added Successfully    
When User navigates to System
And User Creates a Sub-System with Name and Description
Then Sub-system should be added Successfully

@Create
Scenario: 12 808723_Create sub systems till Tenth level
Given User is in the TestRepository
When User Navigates to ReleaseName
	And User Creates Folders Upto Tenth Level 
	And User Adds the Sub-System in the Tenth Level
Then Sub-System should be Added in Tenth Level

@Create
Scenario: 13 808828_Find and Add Testcases with 'creator' using '=' operator
Given User is in the TestrepositoryPage
When User Navigates to the Sub-Folder
And User Performs the Find and Add Operation with ZQL Quarry
Then TestCases should be Added Successfully

@Create
Scenario: 14 808839_Find and Add Testcases by 'name' using '~' operator
Given User is in TestRepository
When User Navigates to Sub-Folder
	And User Performs the FindAndAdd Operation using name Operator in ZQL
Then TestCase should be Added Successfully

@Create
Scenario: 15 808844_Find and Add Testcases by 'tag' using '=' operator
Given User is in the Testrepository
When User navigates to Release and Sub-Folder
And User Performs the FindAndAdd Operations Using ZQL with Tag 
Then TestCases should be added Successfully

@Create
Scenario: 16 808857_Select multiple test cases from different pages in find and add window
Given User is in the TestReposiytory
When User Navigates to Sub-Folder level
	And User Performs the FindAndAdd Operation using ZQL
	And User Adds Multiple TestCases from Different Pages
Then Multiple TestCases are Added Successfully

@Create
Scenario: 17 809375_Find and Add the test case when user is in Detail view panel
Given User is in TestRepositorypage
When User Navigates to release
	And User Clicks on View and move to Sub-Folder Level
	And User Performs FindAndAdd Operation using ZQL
Then Testcases should be added successfully In Detail View

@Create
Scenario: 18 808829_Find and Add Testcases with 'priority' using 'in' operator
Given User is in the TestRepositorypage
When User Navigates upto Sub-Folder levels
	And User Performs FindAndAdd Operation using ZQL with in Operator
Then TestCases Should be added Successfully

@Create
Scenario: 19 808825_Add a testcase to 8th level sub-node ,through Advanced ZQL using option �find and add�. 
Given User is in TestRepositoryPage
When User Navigates to the Release
And User Navigates upto Eight Node
And User Performs FindAndAdd Operation using ZQL Quarry
Then TestCases should be added to Eight Node Successfully

@Create
Scenario: 20 808826_Find and Add testcases with search query containing multiple terms like 
		name, priority, custom fields using AND operator
Given User is in Testrepository
When User Navigates to Sub-Node
And User Performs FindAndAdd Operation Using Multiple ZQL terms
Then TestCases should be Added Successfully with multiple ZQL

@Create
Scenario: 21 808849_Find and Add Testcases by  'estimatedtime' using '=' operator
Given User is in the Testrepositorypage
When User Navigates to Sub-folders Level
	And User Performs FindAndAdd Operation using ZQL with estimatedtime
Then TestCases should be Added Successfully with estimatedtime
	
@Create
Scenario: 22 808895_Add testcase with all custom fields and other fields in detail view
Given User Navigated to the TestRepositoryPage
When User Creates a Phase and Navigates to created Phase
	And User Adds Testcase
	And User Clicks on Detail View
	And User Enters Name and Description for Testcase
	And User Enters all Custom Fields ans Saves it
Then Testcase Should be created with all Custom Fields

@Create
Scenario: 23 809290_Create a Test Case With Maximum Execution Time
Given Manager is in the Phase Page of Test Repository
When Manager clicks On Add button
And Enters Estimated Time
And Logout from Zephyr Application
Given Lead is in the Phase Page of Test Repository 
When Lead clicks On Add button
And Enters Estimated Time
And Logout from Zephyr Application
Given Tester is in the Phase Page of Test Repository 
When Tester clicks On Add button
And Enters Estimated Time
And Logout from Zephyr Application
Then Test Case Created successfully with Estimated Time

@Create
Scenario: Logout
Given User is in the Zephyr ProjectPage
When User Clicks on logout Icon
	And User clicks on Logout Option
Then User should be logged out from Zephyr Application Successfully
	

