Feature: CustomField_Master 
@CustomFields
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
	And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully


@CustomFields
Scenario: 2 803130_As custom user import testcases 
Given Login as Managager into Zephyr Application
When Manager Moves to Administation Settings
	And Manager Cretes a CustomUser
	And Manager Logout from the Zephyr Application 
	And New Custom User Login into Zephyr Application
	And New User Clicks on ImportIcon
	And New User Creates a Map
	And New User Creates ImportJob
	And New User Runs ImportJob
Then File should be Successfully imported by New Custom User


@CustomFields
Scenario: Logout
Given User is in the Zephyr ProjectPage
When User Clicks on logout Icon
	And User clicks on Logout Option
Then User should be logged out from Zephyr Application Successfully