Feature: View_Master

@View
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
	And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully

@View
Scenario: 1 808920 Create Two Phases,Create Few TestCases and Switch Between Detail View to List View
Given User is in the page of TestRepository
When User Creates Two Phases and Add Few TestCases
When User Navigates from Detail view to List View
Then Navigation is done successfully

@View
Scenario: 2 808732 Create Phase,System and Subsystem in a Tree structure
Given User is in the page of a TestRepository page
	And User creates a phase under the release
When User creates system under the release
	And User creates subsystem under the system
Then User successfully verifies the bread crumbs

@View
Scenario: 3 809353 Create a Node,Add TestCases and in the Column Chooser view Custom Fields and Select any one of the custom field
Given User is in the Page of TestRepository
When User Creates a node and Adding TestCases
When User selects Custom Field from the Custom Fields column chooser
Then Custom filed should be choosed successfully


@View
Scenario: 4 808936 Create a Phase,System and Subsystem and TestCases in All the Nodes and Navigates to Search View and selects a Advanced Search
Given User is in the Page of TestRepository Page
When User Creates a Phase,System and Subsystem and create testcases in all the nodes
When User navigates to Search View and selects a Advanced Search
Then Advanced Search is performed and present successfully in Prevoius Search drop down

@View
Scenario: 5 809417 Create Phase,System and Subsystem and Create 50 TestCases and Setting Page Size to 10 and Navigate Between Pages
Given User is in the page of the Test Repository
When User Creates a Phase,System and Subsystem and creates Fifty testcases
When User Sets the per page size to ten and navigate between pages
Then Navigation between pages is done successfully

@View
Scenario: 6 809359 Creating a Phase,System and Subsystem and Viewing Subsystem TestCase Details in Expand Mode
Given User is in the Page of TestRepository
When User Creates a Phase,System and Subsystems
When User creates three testcases in subsystem and selects a testcase to view testcase details in Expanded Mode
Then User views the testcase details in Expanded Mode successfully

@View
Scenario: Logout
Given User is in the Zephyr ProjectPage
When User Clicks on logout Icon
	And User clicks on Logout Option
Then User should be logged out from Zephyr Application Successfully



