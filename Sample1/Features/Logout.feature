@Logout
Feature: Logout from the Zephyr Application

Scenario: Logout

Given User is in the Zephyr ProjectPage
When User Clicks on logout Icon
	And User clicks on Logout Option
Then User should be logged out from Zephyr Application Successfully