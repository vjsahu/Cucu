Feature: Map_Master

@Map
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
	And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully


@Map
Scenario: 1 808898_Map test cases to the requirement and see the Details view of the testcases
Given User is in the page of testRepository
	And User creating a phase
Then User creating a two-three test cases
	And User navigates to test case details
	And User Maps Requirements to test case
Then User views the details view of the test cases

@Map
Scenario: 2 808598_Mapping Single Created TestCase in Requirements to a TestRepository of a Mapped Requirements
Given User is in the Page Of Requirements and Add a node and Add two to three  Requirements
When User is in the Page of TestRepository and Creates a phase and Creates a testcase
And User go to TestCase Details view and Maps a Requirement
Then Mapping of single testcase to a Requirement is done successfully

@Map
Scenario: Logout
Given User is in the Zephyr ProjectPage
When User Clicks on logout Icon
	And User clicks on Logout Option
Then User should be logged out from Zephyr Application Successfully

@Map
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
	And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully

@Map
Scenario: 3 808659_As lead, map Jira requirement to a testcase
Given User is in the page of the Requirements page
	And User clicks on Import and chooses Import type to JIRA
When User enters External DTS Login detail
	And User performs JQL query operations
	And User Imports the Jira Requirement
Then User copys the Imported Jira Requirements to Release node
	And User is in the page testRepository
Given User creates a node the under release
When User creates a test case under a node
Then User Go to testcase details
Then User Maps the Requirements to testcase
Then User expands the release node
And User selects the node and save requirements to a testcase
And User successfully Maps requirements to testcase


@Map
Scenario: 4 808661_As lead, map Jira requirement to a testcase
Given User is in the Requirements page
	And User clicks on Import and choose Import type to JIRA
When User enters External DTS Login details 
	And User performs JQL query operation
	And User Imports the Jira requirements
Then User copys the Imported Jira requirements to Release node
	And User is in the testRepository
Given User creates a node under the release
When User create a test case
Then User Goto testcase details
Then User Maps Requirements to testcase
Then User expands release node
And User selects a node and save requirements
Then User successfully maps requirements to testcase 

@Map
Scenario: 5 808662_As lead, map another Jira requirement to the same testcase
Given User is in a page of Requirements
	And User clicks on Import and selects Import type to a JIRA
When User enters the External DTS Login details
	And User performs JQL operation of Import
	And User Importing Jira requirements
Then User copys the Imported Jira requirements to a release node
	And User is in the page of a testRepository
When User creates a node under a release
Given User creates a testcase under the node
When User navigates to testcase details
Then User maps the Jira requirements to a testcase
When User expands a release node
When User maps two Jira requirements to a testcase
Then Mapping of Jira requirements to a testcase is done successfully



@Map
Scenario: 6 808664_As lead, map multiple Jira requirements to a testcase, if requirement-testcase remote link is enabled
Given User is Requirements page
	And User clicks on Import and selects Import type to JIRA
When User performs JQL operation
	And User Imports Jira requirements
	And User copy Imported folder item to release node
Then User is in page of Test Repository page
	And User creates node under release
Then User creates a testcase
Then User Maps requirements to a testcase
Then User successfully maps jira requirements to a testcase


@Map
Scenario: 7 808667_Map Jira requirement to testcase, if Jira username contains different character combination
Given User is in Requirements page
	And User clicks on Import and chooses Import type to JIRA option
When User enters External DTS login details contains special and non English different characters
	And User performs JQL query operation on Import
	And User then Imports Jira Requirements
Then User copying the Imported Jira Requirements to Release node
	And User is in the page of the testRepository
Given User creates a node under the release node
When User creates a testcase under phase node
Then User Go to testcase details view
Then User Mapping the requirements to testcase
Then User expands release node option
When User selects requirements and save it
Then User Maps the requirements to testcase 

@Map
Scenario: 8 808669_Unmap Jira requirement from testcase, if requirement-testcase remote link is enabled
Given User is in the Requirements page
	And User clicks on Import and choose Import type to JIRA
	Then User enters External DTS login details 
	And User performs some other operation
	And yet another action
Then some other action
	Given User is in the page of the TestRepository page
And User creating a node
When User adds a TestCase
Then User maps Jira requirement to a testcase
Then User clicks on the save
When User navigates again to map requirements
Then uncheck the selected requirements

@Map
Scenario: 9 808670_Unmap multi-selected Jira requirements from testcase, if requirement-testcase remote link is enabled
Given user is in the Requirements page
	And user clicks on Import and choose Import type to JIRA
When User enetrs external Login Details
	And User performs import operation
 When User Imports Jira Requirements
 When User Copying the imported jira requirement to release node
	And User is in the page of the TestRePository page
	And User Creating a node
When User Adds a TestCase
Then User maps Jira requirements to a testcase
When User click on the save
When User navigate again to map requirements
Then User Uncheck the selected requirements

@Map
Scenario:  10 808679_Delete testcase mapped to single/multiple Jira requirements, if requirement-testcase remote link is disabled
Given User is in the page of Requirements page
	And User clicks on Import option and choose Import type to JIRA
When User performs JQL operation on Import
	And User copys the Imported folder to Release node
	And User is in the testRepository page
Then User creates a node under release node
	And User adds a test case
Given User maps requirements to testcase
When User navigates to a testcase contains jira requirements
Then User deleted the testcase successfully

@Map
Scenario: Logout
Given User is in the Zephyr ProjectPage
When User Clicks on logout Icon
	And User clicks on Logout Option
Then User should be logged out from Zephyr Application Successfully

@Map
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
	And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully

@Map
Scenario: 11 808693_Map Requirements to TestCase Window and After Selecting Release Node,Expand and View Nodes under it
Given User is in the Requirements Page
	And User Creates a node and Two sub nodes a in Tree Structure
When User is in the TestRepository Page and Creates a Node and Adds a TestCase
	Then User Goto Details View and Map Requirements and select the Release Node
Then After Expanding the Release node all the nodes under it are remain selected successfully

@Map
Scenario: 12 809379 Deselect the node in "Map Testcase to Requirements" and view the selection of the headder check box
Given User is in a page of a Requirements
	And User creates a node an release
When User creates two to three requirements under an node
	And User is in a testRepository
	And User creates an phase under release
Then User creates an two to three testcases
	And User selects an testcase
When User maps the requirements
Then User selects an entire node and expands and view it in an grid
Then User unchecks the entire release node and view in a grid
Then User similarly selects the node should selects the headder checkbox as well

@Map
Scenario: 13 809385 Map requirements to testcase by select release node or nodes present under release "Map testcase to requirements"
Given User is in a page Requirements
	And User creates an node under release
When User creates two to three requirements under a node
	And User is in a page of testRepository
	And User creates an phase under a release
Then User creates two to three testcases
	And User go to a testcase details
When User maps requirements
Then User seelects a release node
Then User clicks on a save
Then Mapping of requirements to testcase by selectsing a release node is done successfully

@Map
Scenario: Logout
Given User is in the Zephyr ProjectPage
When User Clicks on logout Icon
	And User clicks on Logout Option
Then User should be logged out from Zephyr Application Successfully

@Map
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
	And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully

@Map
Scenario: 14 808660 As lead, map Jira requirement to a testcase
Given User is in the page of a Requirements 
	And User clicks on Import and selects Import type to the JIRA
When User enters external DTS Login details
	And User performs JQL query operation on the Import
	And User Imports a Jira requirements
Then User copys an Imported Jira requirements to a release node
	And User is in a page testRepository
When User creates a node under an release
When User creates an testcase
Then User Go to a testcase details
When User maps requirements to a testcase
Then User expands an release node
When User selects a node and saves the requirements
Then User successfully maps requirements to an testcase

@Map
Scenario: 15 808658 Map Jira Requirements to a testcase
Given User is in a Requirements page
	And User clicks on Import and selects Import type to an JIRA
When User enters external DTS login details
	And User performs JQL operation on an Import
	And User Imports the Jira requirements of issue type Bug
Then User Imports the Jira requirements of issue type New Feature
	And User Imports the Jira requirements of issue type Task
When User Imports the Jira requirements of issue type Improvement
When User Imports the Jira requirements of issue type Test
When User Imports the Jira requirements of issue type Requirement
When User copys the Imported Bug Jira requirements to an release node
When User copys the Imported New Feature requirements to an release node
When User copys the Imported Task Jira requirements to an release node
When User copys the Imported Improvement Jira requirements to an release node
When User copys the Imported Test Jira requirements to an release node
When User copys the Imported Requirement Jira requirements to an release node
Then User is in a testRepository page
When User creates a phase under an release
When User creates a testcase under an release
When User go to testcase detail
Then User maps the Jira requirements of issue type Bug to an testcase
Then User maps the Jira requirements of issue type New Feature to an testcase
Then User maps the Jira requirements of issue type Task to an testcase
Then User maps the Jira requirements of issue type Improvement to an testcase
Then User maps the Jira requirements of issue type Test to an testcase
Then User maps the Jira requirements of issue type Requirement to an testcase
Then User successfully maps Jira requirements of issue types to an testcase 

@Map
Scenario: 16 808663 As lead, map another Jira requirement with same ALT-ID as currently mapped requirement to the same testca
Given User is in the page of an Requirements page
	And User clicks on the Import option and choose Import type to JIRA
 When User enters external login detail
When User performs JQL operation on an Importing Jira Requirements
When User Imports the Jira Requirement under the Imported Folder
	And User copys the Imported folder to Global tree
	And User allocates Imported folder to Release node
Then User clones the Jira requirement
	And User maps original Jira requirement to testcase
Given User again maps the cloned Jira requirement to same testcase 
Then User maps both original and cloned Jira requirement to the same testcase successfully

@Map
Scenario: 17 808665_Map Jira requirement to testcase, if testcase name contains different character combination
Given User is in page Requirements
	And User clicks on Import and selects Import type as JIRA
When User User enters external DTS login details
When User performs JQL operation on the Import
	And User then Imports the Jira requirements
	And User copying the Imported Jira requirements to release node
Then User is in testRepository
	And User create a node under release
Given User again creates a testcase under a node
When User go to details and performs mapping
Then User maps requirement to testcase name which contains special characters
When User maps Jira requirement to testcase name which contains non-English characters
When User maps Jira requirement to testcase name which contains numbers only
When User maps Jira requirement to testcase name which contains alphanumeric characters
When User maps Jira requirement to testcase name which contains UPPERCASE
When User maps Jira requirement to testcase name which contain both alphanumeric and special chracters
Then User maps Jira requirement to different types of testcase names successfully 

@Map
Scenario: Logout
Given User is in the Zephyr ProjectPage
When User Clicks on logout Icon
	And User clicks on Logout Option
Then User should be logged out from Zephyr Application Successfully