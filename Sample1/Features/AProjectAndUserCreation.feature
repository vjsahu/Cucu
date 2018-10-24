Feature: Create Project

@Ab
Scenario: As a Test Manager create new projects
Given Login as a Test manager
 And navigate to Manage Projects page
 When Create One normal project
  And Create two isolated projects
	And Create two restricted projects
 Then Projects should be created successfully

 @Ab
 Scenario: create users with details
Given Login as manager credential
When User click on the administration and manage users
When User creates a first lead user
When User creates a second lead user
When User creates a third lead user
When User creates a fourth lead user
When User creates a fifth lead user
 And User creates a first tester user
 And User creates a second tester user
 And User creates a third tester user
Then all the users are created successfully

@Ab
Scenario: User assignment
Given Login as manager
When User click on admin and manage user
And select the first lead user and assign the projects
And select the second lead user and assign the projects
And select the third lead user and assign the projects
And select the fourth lead user and assign the projects
And select the fifth lead user and assign the projects
And select the sixth lead user and assign the projects

And select the first tester user and assign the projects
And select the second tester user and assign the projects
And select the third tester user and assign the projects
And select the fourth tester user and assign the projects
Then projects successfully assigned to the users

@Ab
Scenario Outline: Create release 2.0 for all projects
Given User select the project<project>
When User create a release for all the projects
Then release is created for all projects
Examples:
|project|
|1      |
|2      |
|3      |
|4      |
|5      |


@Ab
Scenario: Logout
Given User is in the Zephyr ProjectPage
When User Clicks on logout Icon
	And User clicks on Logout Option
Then User should be logged out from Zephyr Application Successfully
