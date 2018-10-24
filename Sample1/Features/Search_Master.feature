Feature: Search_Master

@search1
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully

@search
Scenario: Precondition- Creating Node

 Given create testcases and edit
# And create phases upto Eighth level
 When covered and uncovered
	
		Given User login as Manager Credential
	When Navigate to the phase and add test cases to the phase
	Then test cases should be added to the phase
	
@search1
Scenario: 1 798162_Filter Testcase Report by a specific Creator 
Given user logged in the repository page
When user select and click on exporttest
And select the speccific creator		
And select the summary report
Then shoud be generate filter Testcase Report

@search
Scenario: 2 798166_Filter Testcase Report by a specific Priority and a specific user
Given user in the repository page
When when user select the export tests
And select the specific priority and creator
And select the summary
Then should generate filtered specific priority and creator Report

@search
Scenario: 3 798185_Filter by only auto testcases and execute "Summary" report
Given user in the Repository page
When user select export test option
And Select the auto or manual checkbox
And In filter by select automated radio button
And select summuray report
Then should generate Automated Test case Report

@search
Scenario: 4 798201_Filter Testcase Report by multi-select Priority 
Given user in the test Repository Page
When user selects the export tests in Repositorypage
And select the multiple priorities
And Select the detailed Report
Then shoud Generateb multipriority Test case report

@search
Scenario: 5 798207_Filter Testcase Report by date range
Given user is in the repository page
When user selects the export text Option
And select the specfic date range
And Select the detailed report
Then should generate the specific date range report 

@search
Scenario: 6 798208_Filter by covered testcases and execute "Detailed" report
Given user in The repository Page
When User selects the exports Test
And select required check boxes in select fields
And Click on coverage and select covered
And Select detailed Report
Then Should generate coverage Test case report

@search
Scenario: 7 798218_Filter by "All" coverage (both covered and non-covered) testcases
Given User in the Test Repository Page
When Select the export tests option
And Select the check boxes required
And select the Priority and creator
And select the detailed report in Report Type
Then get generate all coverage test case report

@search
Scenario: 8 798222_Filter by coverage (both covered and non-covered) with multi-select Priority
Given user in the tests repository page
When select the option export tests
And Select the Required Check Box in Select fields
And Select the priority All creators and all M/A
And Select the option Detailed
Then Should generate the filter test case detailed Report 

@search
Scenario: 9 798223_Filter by just creation start date with coverage
Given User opens the repository page  
Then select the export test in repository page
And Select the Start date
And select the detailed Report
Then should generate detailed filter testcase report

@search
Scenario: 10 798267 filter testcase all coverage 
Given user in repository
	And select the export test
When select the required check box
	And select the date range
	And select the priority and creator
Then should generate the sumary report

@search
Scenario: 11 808819_Filter the 8th sub system in the phase
Given User in repository Page
When User click on Filter with Name
And Match with Selected Subsystem
Then Should able to view the multiple sub system name

@search
Scenario: 12 808867_Search test case with ZQL using priority
Given user in the repository page to search
When user click on the search
And In quick search pass ZQL
Then Should display All the testcases are matching 

@search
Scenario: 13 808868_Search write ZQL query and get test cases
Given User in repository page to search ZQl query
When User click on search button
And Select advanced search with query
Then hould display all the matching test cases

@search
Scenario: 14 808869_Select search button in test repository,click on advanced search,select previous search and click on Go
Given User is preseent in the reposirory page
When Click on  the Search and Advance search
And Click on search and pass data
And Click on previous search select previous data
Then Should match with previous results

@search
Scenario: 15 808935_View Previous Search drop down in List/Detail view
Given User is present the repositorypage
When User clicks on search and Advance search
And search with creator and click on previous search
Then Should able view in dropdown

@search
Scenario: 16 808942_Seach query having international characters
Given User is Present in the Repository Page
When Click on search and Advance search With query
And  slects on previous search
Then Should Match with drop down

@search
Scenario: 17 808952_search test case with query in ZQL
Given user present in the repository page
When User click on search with query
And select one test case
And Edit the test case
Then should able to edit and save

#@search
#Scenario: 18 809406 navigation from search view to folder view
#Given User is in a page Test Repository
	#And User creates a phase under a release
	#When User adding a testcase under 
	#And User adds a testcase
#Then User go to expand mode
	#And User navigates to a search view
#When User navigates a folder view
#Then User successfully navigating from search view to folder view

	
@search
Scenario: 19 808870_Switch between Search and Folder in different browsers(Chrome/firefox/IE-11/Edge/Safari) and view test cases
Given User is in the page testRepository page
	And User creates a phase under release
When User creates few testcases
	And User navigates to the search view
	And User navigates again to the folder view
Then User successfully switch between between search and folder

@search
Scenario: 20 809315_As a Manager/Lead/Tester, sort the estimated execution time in ascending/descending order
Given User is in the page of TestRepository page
	And User Create a node
When User creates a ten test cases with estimated time
	And User sorts the estimated time in ascending order
	Then User sorts the test cases successfully 

@search
Scenario: 21 809085_ As Tester, sort testcases by ID/ Name/ (M/A)/Alt ID/Priority/Created By/Created On/Custom Fields/estimated time
Given user is in the page Test Repository
	And user creates a node
When user creates few test cases
	And user go to detail view
	And user creates test cases in all the available fields
Then user navigates column chooser and sort test cases
	Then sorting of testcase can be performed successfully

@search
Scenario: 18 809406 navigation from search view to folder view
Given User is in a page Test Repository
	And User creates a phase under a release
	When User adding a testcase under 
	And User adds a testcase
Then User go to expand mode
	And User navigates to a search view
When User navigates a folder view
Then User successfully navigating from search view to folder view


@search
Scenario: Logout
Given User is in the Zephyr ProjectPage
When User Clicks on logout Icon
	And User clicks on Logout Option
Then User should be logged out from Zephyr Application Successfully
	

