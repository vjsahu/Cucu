Feature: Import_Master

  @Import
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it
    When User Navigates to the URL provided
    And User Enters Username, Password and clicks on login
    Then User should be Logged in into Zephyr Successfully

  @Import
  Scenario: 1 798161_Import the same exported file in "data" view to .xls
    Given User is present in the TestRepositoryPage
    When User moves to the Releasename
    And User Clicks on the Import
    And User Imports the Exported file
    Then File should be Imported Successfully

  @Import
  Scenario: 2 802965_A Create a map with minimum required fields
    Given User is present in TestRepository
    When User Navigates to the ReleaseName
    And User Cliks on Import
    And User Performs the Create Map Operations
    Then Map should be Created Successfully

 @Import
  Scenario: 3 802986_Create an 'Import Job' with a valid Dir/File path
    Given User is in Testrepositorypage
    When User Navigates to Releasename
    And User Clicks on ImportButton
    And User Moves to the ImprtJob Page
    Then Import Job should be Created Successfully
    

  @Import
  Scenario Outline: 4 802991_Run an 'Import Job' with different discriminator selected
    Given User is present in TestRepositoryPage
    When User Navigates to the Releasename
    And User Clicks on Importbutton
    And User Moves to ImprtJob Page "<discriminator>"
    And User Runs the Import Job
    Then Import Job should Run Successfully

    Examples: 
      | discriminator           |
      | Id                      |
      | empty row               |
      | By testcase Name Change |

  @Import
  Scenario: 6 803011_Import testcases if mapping file and import file values are mismatched
    Given User is Moved to the TestRepository
    When User navigates to the ReleaseName
    And User clicks on the Import
    And User Imports the TestCases with Miss-Match Values
    Then Import should be successfull with Miss-Match values

  @Import
  Scenario: 7 803020_As Manager/Lead, create a phase with name 'Imported' and run an import job.
    Given User moved to the TestRepository
    When User moes to the Release
    And User Creates a phase with name 'Imported'
    And User Imports a Testcase
    Then Testcase should be successfully added to the 'Imported' folder not in Phase

  @Import
  Scenario: 8 803056_Import test cases having both valid/invalid/empty email or username in the 'Created By' field in the same excel file
    Given User is Present in the TestRepository
    When User Navigates to the REleaseName
    And User clicks on Import
    And User Creates Map with Email in Created By Field
    And User Imports File and Runs the Import Job
    Then Import Job should be Run Successfully

  @Import
  Scenario: 9 803058_Delete an import job with status 'Import successful'
    Given User moved to the TestRepositorypage
    When User Navigate to Release
    And User Clicks On Import
    And User Performs Import Job
    And User Deletes the ImportJob
    Then User Deleted the Imported Job Successfully

  @Import
  Scenario: 10 803059_Import the Testcase file with Automated Field
    Given User moved to the TestRepositoryPage
    When User navigate to Release
    And User Click on ImportIcon
    And User Creates map with Automated Field
    And User Creates ImportJob
    And User Runs the ImportJob
    Then User is Imported the File Successfully

  @Import
  Scenario: 11 803063_Import test cases with all mapping fields
    Given User is in the testrepositorypage
    When User moves to the Release
    And User Clicks on Importicon
    And User Creates map with all fields
    And User Imports a Testcase and Runs it
    Then Testcase with all fields should be Imported Successfully

  @Import
  Scenario: 12 803066_TestCase containing International Characters
    Given User Present in TestRepository
    When User navigates to the Releasename
    And User clicks on Importicon
    And User Creates a map with all the fields
    And User Creates a Imports a file with International characters
    And User Runs the Job
    Then Testcase with International characters is Imported Successfully

  @Import
  Scenario: 13 803077_Import a single .xlsx file with 1 or multiple test case using discriminator by ID
    Given User is present in the TestRepository
    When User Navigates to releaseName
    And User Clicks on the ImportIcon
    And User Creates map
    And User Creates a Import Job with ID Change
    And User Runs the Importjob
    Then File should be Imported Successfully with ID Change


  @Import
  Scenario: 14 803083_Import a file from the client/local machine from a deeply nested directory
    Given User present in the Testrepository
    When User clicks on releasename
    And user clicks on import icon
    And user creates a map
    And user Imports a file with nested directory
    And user Runs the Import Job
    Then File should be Imported Successfully to the Imported folder

  @Import
  Scenario: 15 803087_Import a xls/xlsx file from the client/local machine  directory with special characters in the file name
    Given User is in the Testrepository Module
    When User Clicks on Releasename
    And User Clicks on ImporTIcon
    And User creates map
    And User Imports file with Special Characters and Runs it
    Then The filename with special characters should be Imported successfully

  @Import
  Scenario: 16 803100_Import TestCase with Estimated Exicution time 99:23:59
    Given User Navigated to TestRepository
    When User Clicks on ReleaseName
    And User clics on Import
    And User Creates a maP
    And User Imports the File with Estimated Execution Time
    And User Runs the Import JOB
    Then File with Estimated Execution Time is Imported Successfully

  @Import
  Scenario: 17 803103_Import Testcase with Estimated Time in Number Format
    Given User is in thE TestRepository
    When User NavigatEs to Release
    And User Clicks on ImportIconButton
    And User Creates a Map with Estimated EXE time in Number format
    And User Creates a ImportJob
    And User Runs the Imported Job
    Then Testcase with Estimated Exe time in Number format should be Imported Successfully

  @Import
  Scenario: 18 803124_Import File with Different Charrecters Combination
    Given User is present in the TestRepositoryPagE
    When User Navigates to the ReleasenamE
    And Use Clicks on Import
    And User Creates a map
    And User Creates a Imports a filename with different Characters
    And User Runs Imports Job
    Then File name with the different charectrs should be added successfully

  @Import
  Scenario: 20 797111_Import Test Cases with Custom fields
    Given User is Present in the Testrepositorypage
    When User Clicks on Import icon
    And User Creates Map With Matching Custom Fields
    And User Creates Import Job
    And User Run the Import Job
    Then Testcase with Custom fields should be Imported Successfully

  @Import
  Scenario: 21 797102_Copy import node have Test Cases with Custom values to release P/S/SS
    Given User is present in the Testrepository
    When User is Clicks on Importicon
    And User Creates map with matching Custom fields
    And User Creates the Import Job
    And User Runs Imported Job
    And User Navigates to Imported Folder
    And User Copy the Imported File
    And User Paste the Imported node in Created Phase
    Then Imported File is copied to the Phase Successfully

  @Import
  Scenario: 19 809424_import testcase excel sheet by saving map for all custom field and verify the checkbox field custom value.
    Given User is present in the Testrepositorypage
    When User Clicks on Import Icon
    And User Creates map with matching checkbox field
    And User perform Import Job by selecting Created Map
    And User Perform RunJob Operation for Imported Job
    And User Moves to the Imported Folder and Selects the Imported file
    And User checks the Value for Checkbox Field
    Then CheckBox Should be In Unchecked Mode Successfully

  @Import
  Scenario: 22 809384_As concurrent users, import testcases in test repository
    Given User is in TestRepo page
    When User Clicks on Import Testcase Icon
    And User Creates Map with Matching field
    And User Creates the ImportJob
    And User Runs the ImportedJob
    Then File should be Imported Successfully to the Imported Folder

  @Import
  Scenario: 5 803008_Import a single .xls file with 1 or multiple testcases
    Given User is in TestrepositoryPage
    When User Moves to the Release
    And User Clicks on ImportIcon
    And User Import a file with Testcase
    And User Import Same file with another Testcase
    Then Single file should be Imported by Multiple Testcases Successfully
    
 

  @Import
  Scenario: Logout
    Given User is in the Zephyr ProjectPage
    When User Clicks on logout Icon
    And User clicks on Logout Option
    Then User should be logged out from Zephyr Application Successfully
