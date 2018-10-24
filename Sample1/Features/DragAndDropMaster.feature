Feature: DND_Master

@DND
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
	And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully


@DND
Scenario Outline: 1Precondition- Creating Phase ,System and Subsystem adding test case to the nodes
Given User select the projects <Count>
When User click on Release <Count>
And Navigated to test Repository Page
And Double Click On release<Count> 
And Creates a phase <Count> and Add test Cases to the Phase
Then Test cases Added to the Phase
When Creates a System <Count> and Add test Cases to the System
Then Test cases Added to the System
When Creates a subsystem <Count> and Add test cases to the subsystem
Then Test cases Added to the Subsystem
Examples:
    | Count  |
    | 1      |
    |2      | 
    |3      |
    |4      |
    |5      |
    |6      |
    |7      |
    |8      |
    
    
 @DND
Scenario Outline: Precond2_Import test cases having both valid/invalid/empty email or username in the 'Created By' field in the same excel file
 Given User is Present in the TestRepository<Releases>
When User Navigates to the REleaseName<Releases>
 And User clicks on Import
 And User Creates Map with Email in Created By Field
 And User Imports File and Runs the Import Job
Then Import Job should be Run Successfully<Releases>    
Examples:
|Releases|
|1|
|2|

@DND
Scenario: 1 808587 As Tester, drag and drop testcases from Global Phase to Current Sub-system
Given Tester is in the test repository page of release one
When User select copy from other other project option from release context menu
Then Copy from other project page should be displayed
When User select same project from Global Area and select release two
And navigate to phase containing test cases
Then test case should be displayed
When User expand the current project and select release one naviagate to subsystem
And drag and drop the two test case from Global phase to current subsystem
Then test case should be copied to current subsystem

@DND
Scenario: 2 808588 As Tester, drag and drop test cases from Global System to Current Phase
Given Tester is in the test repository page of release one
When User select copy from other other project option from release context menu
Then Copy from other project page should be displayed
When User select same project from Global Area 
And select release two, navigate to system containing test cases
Then test case should be displayed
When User expand the current project and select release one and naviagate to phase
And drag and drop the two test case from Global system to current subsystem
Then test case should be copied to current phase

@DND
Scenario: 3 808595 As Lead, drag and drop Global Phase to a Current Release
Given Tester is in the test repository page of release one
When User select copy from other other project option from release context menu
Then Copy from other project page should be displayed
When User select same project from Global Area 
And select release two and navigate to phase containing test cases
Then test case should be displayed
When User select the local release
And drag and drop the Global phase to current release
Then global phase should be copied to current release

@DND
Scenario: 4 808613 In normal project,As Lead role,DnD a phase from another normal project to a local release,if assigned current project only
Given User is in the test Repository page of normal project
When User select copy from other other project option from release context menu
Then Copy from other project page should be displayed
When User selects the phase from another normal project from global area
And select the current release
And drag and drop the phase from another normal project to local release
Then selected phase should be copied to the local release 

@DND
Scenario: 5 808615 In normal project,As tester,DnD a sub-system from a restricted project to local system,if assigned to the restricted project
Given User is in test repository page of normal project
When User select copy from other other project option from release context menu
Then Copy from other project page should be displayed
When User selects the subsystem in restricted project from global area
And select the current release and navigate to local system
And drag and drop the subsystem from restricted project to local system
Then selected subsystem should be copied to the local system 

@DND
Scenario: 6 808617 In normal project,As user,DnD a test case from an isolated project to local P/S/SS,if assigned to the isolated project
Given User is in test repository page of normal project
When User select copy from other other project option from release context menu
Then Copy from other project page should be displayed
When User selects the phase in restricted project from global area
Then test Case should be displyed
When User select the current release and navigate to local phase
And drag and drop the test case from phase of restricted project to local phase
Then selected test case should be copied to the local phase 
	
@DND
Scenario: 7 808626 In restricted project,As tester role,DnD a system from a normal project to local phase,if assigned to normal project
Given User is in test repository page of restricted project
When User select copy from other other project option from release context menu
Then Copy from other project page should be displayed
When User selects the system in normal project from global area
Then test Case should be displyed
When User select the current release and navigate to local phase of restricted project
And drag and drop the test case from system of normal project to local phase
Then selected test case should be copied to the local phase of restricted project
	
@DND
Scenario: 8 808627 In restricted project,As Lead role,DnD a sub-system from another restricted project to local system,if assigned to both restricted projects
Given User is in test repository page of restricted project
When User select copy from other other project option from release context menu
Then Copy from other project page should be displayed
When User selects the Subsystem in restricted project from global area
Then test Case should be displyed
When User select the current release and navigate to local phase of current restricted project
And drag and drop the Subsystem of restricted project to local phase
Then selected subsystem should be copied to the local phase of current restricted project
	
@DND
Scenario: 9 808629 In restricted project,As lead role,DnD a testcase from an isolated project to local P/S/SS,if assigned to the isolated project
Given User is in test repository page of restricted project
When User select copy from other other project option from release context menu
Then Copy from other project page should be displayed
When User selects the node in isolated project from global area
Then test Case should be displyed
When User select the current release and navigate to local Phase of restricted project
And drag and drop the test case from isolated project to local phase of restricted project
Then selected test case should be copied to the local Phase of restricted project
	
@DND
Scenario: 10 808638 In restricted project,As lead role,DnD a testcase from an isolated project to local P/S/SS,if assigned to the isolated project
Given User is in test repository page of isolated project
When User select copy from other other project option from release context menu
Then Copy from other project page should be displayed
When User selects the node in normal project from global area
Then test Case should be displyed
When User select the current release of restricted project
And drag and drop the phase from normal project to local release of restricted project
Then selected phase should be copied to the local release of restricted project
	
@DND
Scenario: 11 808641 In isolated project,As Lead role,DnD testcase from a normal project,if assigned to isolated and restricted projects
Given User is in test repository page of isolated project
When User select copy from other other project option from release context menu
Then Copy from other project page should be displayed
When User selects the node in normal project from global area
Then test Case should be displyed
When User select the local phase of current release isolated project
And drag and drop the test case from normal project to local phase of isolated project
Then selected test case should be copied to the local phase of isolated project


@DND
Scenario: Logout
Given User is in the Zephyr ProjectPage
When User Clicks on logout Icon
	And User clicks on Logout Option
Then User should be logged out from Zephyr Application Successfully

	#Login with Other credential who has assinged both isolated project test.lead2
	@DND
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
	And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully
	
@DND
Scenario: Precondition2- Creat two nodes and add multiple test cases 
Given User is in test repository Page of Isolated Project
When User add a first node and add multiple testcases
Then multiple test cases added successfully
When user creates a system under phase and add testcases
Then test cases successfully added in system
When user creates a subsystem under system and add testcases
Then test cases successfully added in subsystem

@DND
Scenario: 12 808643 In isolated project,As Lead,DnD a phase from another isolated project to local phase,if assigned to both isolated projects only
Given User is in THE test repository page of isolated project
When User selects copy from other other project option from release context menu
Then Copy from other project page should be displayed
When User selects the node in another Isolated project from global area
When User select the local phase of current release Isolated project
And drag and drop the node from isolated project to local phase of Isolated project
Then selected phase should be copied to the local phase of Isolated project

@DND
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
	And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully

@DND
Scenario: 13 808711 DnD (Move) testcase from Local P/S/SS to another Local P/S/SS 
Given User is in the test Repository page
	When user navigates to the first local phase, system and subsystem
	And navigates to the second phase ,system and subsystem
	And click on first phase and select multiple test cases
	And move the selected test case to the second phase
	And select the first system and select multiple test cases
	And move the selected test case to the second system
	And click on first subsystem and select multiple test cases
	And move the selected test case to the second subsystem
	Then test case should be moved to the nodes

@DND
Scenario: 14 808703 DnD(Move) Local S/SS to Local Release node 
Given User is in the test Repository page
When User create a phase, system and subsystem to current release
When User navigate to current subsystem 
And drag and drop the current subsystem to current release 
Then subsystem should be moved to the current release
When User navigate to current system 
And drag and drop the current system to current release
Then system should be moved to the current release

@DND
Scenario: 15 808704 DnD(Move) Local System/Subsystem to Local Phase/System/Sub 
Given User is in the test Repository page
When User create a phase,system and subsystem
And user navigates to subsystem
And user naviagtes to another phase,system and subsystem
And drag and drop the subsystem to another phase,system and subsystem
Then Subsystem should be moved to the phase,system and subsystem
When user navigates to system
And user naviagtes to another phase,system and subsystem
And drag and drop the system to another phase,system and subsystem
Then system should be moved to the phase,system and subsystem

@DND
Scenario: 16 808706 Ctrl + DnD (Copy) testcase from Imported node to Local P/S/SS 
Given User is in the test Repository page of second release
When User select the imported node 
Then test case count should be displayed
When user navigate navigate to local phase 
And read the test case count
And user navigate to local system
And read the test case count
And user navigate to local subsystem
And read the test case count
And select the multiple test case from imported node
And copy the selected test case from imported node to local phase ,system and subsystem
Then test case should be copied to the local phase,system and subsystem

@DND
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
	And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully

#F
@DND
Scenario: 17 808710 Ctrl + DnD (Copy) testcase from Local Phase to another Local P/S/SS 
Given User is in the test Repository page
When user Add a phase and add test case to the phase
And Add a system  and add test case to the system
And Add subsystem and add test case to the subsystem
And Creates another phase ,system and subsystem
And naviagates to first phase 
And select multiple test case from phase 
And copy the selected test case to second phase/system/subsystem  
Then test case should be copied to the phase/system/subsystem

@DND
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
	And User Enters Username, Password and clicks on login
Then User should be Logged in into Zephyr Successfully
	
@DND
Scenario: 18 808619 DnD imported node of another normal project to current Release
Given user In the Repository page
	And select copy Release option
When navigate to normal project and select imported node
	And drag and drop to phase system and subsystem
	Then Should be able to DnD imported nodes

@DND
Scenario: 19 808622  DnD imported node from isolated project to current Release
Given user in repository Page
	And Select copy release option 
When navigate to isolated project and select imported
	And navigate to currreent Phase/S/SS
	And drag and drop to P/S/SS
Then should able to copy and close the page

@DND
Scenario: 20  808635 DnD imported node of an isolated project to current Release
Given user In repository page 
	And select copy from release Option
When navigate to isolated project and imported
	And navigate to P/S/SS in current release
	And drag and drop to the P/S/SS
Then shoud able to copy and close the page

@DND
Scenario: 21 808646 DnD imported node of a normal project to current Release
Given user in RepoSitory page
	And select copy from Release option
When navigate to normal project and imported
	And navigate to P/S/SS in current Release
	And drag and drop to current release
Then should able to Copy and close the page


@DND
Scenario: 22  808647 DnD imported node of unassigned normal project to current Release/P/S/SS
Given user in The repository page
	And select copy From release option
When navigate to normal Project and imported
	And navigate to P/S/SS in Current Release
	And drag and drop the node to P/S/SS
Then should able to copy and Close the page

@DND
Scenario: 23 808650 DnD imported node of a restricted project to current Release/P/S/SS
Given user in Repository Page
	And select Copy From release option
When navigate to restricted project and imported
	And navigate to P/S/SS In Current Release
	And drag and drop to P/S/SS in current release
Then should able to Copy and Close the page 

@DND
Scenario: 24 808707 DnD Move testcase from Imported node to Local P/S/SS 
Given user in test repository page
	And navigate to P/S/SS in test repository page
When navigate to imported and select a node
	And select testcases and drag and drop to local P/S/SS
Then should able to move testcases 

@DND
Scenario: Logout
Given User is in the Zephyr ProjectPage
When User Clicks on logout Icon
	And User clicks on Logout Option
Then User should be logged out from Zephyr Application Successfully
	
	
