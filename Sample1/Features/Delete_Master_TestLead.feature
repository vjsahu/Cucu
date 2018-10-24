Feature: Delete_Master

@Delete
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
	And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully

@Delete
Scenario: 1 809119 Delete a test case from  test case grid
Given User is in Test Repository page
	And User navigates to a node having test cases
When User select test case and clicks on delete
	And User should get a confirmation box with options [Yes] or [No] 
Then User delete a test case successfully

@Delete
Scenario: 2 809361 Delete a testcase in detail view and navigate to list view and view the testcase grid
Given User present in test repository page
 And User creates a Node 
When User creates three test cases
 And User Navigates to Detail View and Delete a test case
 And User Navigates again to list view and view the test case grid
Then test case should be displayed in Grid in list view successfully

@Delete
Scenario: 3 808752 Delete a testcase in a sub-system , view the testcase count
Given User is in the page TestRepository
	And Select a phase which contain subsystem
When User creates few testcases in subsystem
	And User delete a testcase and view the count
Then User should display the correct count

@Delete
Scenario: 4 809121 As Lead, Delete multiple test steps from a Test Case
Given User is in the page of Test Repository
	And User navigates to a node having test case step details
When User go to details and selects a test case which is having multiple steps
	And User selects step number three to delete
	And User again selects step number two to delete
Then User Should be able to view the steps, data and expected results and deletes multiple steps successfully

@Delete
Scenario: 5 803041 Delete multi-selected test cases from a local import node
Given User is in the Test Repository page
	And User move to the Release node
When User clicks on Import icon
	And User creates a Map with a new job
Then User selects import node that he wants to import test cases
	And User selects the multiple test cases
Then User deletes selected test cases

@Delete
Scenario: 6 809050_As Tester, delete partial test step/test data/expected results from a testcase
Given User is in the page of the TestRepository window
	And User creates a node in release
When User creates a test case under phase
	And User creates a test steps
	And User deletes test steps
Then User successfully delete test steps


@Delete
Scenario: 7 803024 Delete an import node with time stamp under the Imported folder
Given User is in the page of the testRepository page
 And User navigates to the release node
When User clicks on the Import icon
 And User creates an Map
 And User moves to the Imported node
Then User deletes the imported node with time stamp under Imported node
Then User successfully deletes the imported node with time stamp

@Delete
Scenario: 8 809357 Delete a phase,system and subsystem containing test cases and view the testcase grid
Given User is in the Test Repository
 And User navigates to a subsystem containing test cases
When User deletes a subsystem which contains test cases
Then User deleted subsystem succesfully and no test case should present in the grid

@Delete
Scenario: 9 797104 Delete teststep and view the step history
Given User is in the page of the TestRepository
 And User Creates a node
When User creates a test case
 And User creates two steps 
 And User views the step history
Then User delete a test step
 And User views the step history again

@Delete
Scenario: Logout
Given User is in the Zephyr ProjectPage
When User Clicks on logout Icon
	And User clicks on Logout Option
Then User should be logged out from Zephyr Application Successfully
