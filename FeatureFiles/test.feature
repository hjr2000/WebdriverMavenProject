Feature: Testing the internet

#internet facing test
@Runme
Scenario: Running a google search
  Given I am on the google homepage
  When I search for webdriver
  Then the page title is as expected

#Basic authentication test 1
Scenario: Successfully accessing a page behind basic HTTP authentication
  Given I successfully reach a page behind basic HTTP authentication
  Then I see the page content as expected

#Basic authentication test 2
Scenario: Cancelling the basic authentication dialog
  Given I attempt to access a page behind HTTP authentication
  When I cancel the authentication dialog
  Then I see the appropriate not authorised message

#Checkbox test 1
Scenario: Checking and unchecking textboxes
  Given I am on the checkbox test page
  When I click on both checkboxes
  Then I see the appropriate checkboxes are checked and unchecked

#Dropdown list test 1
Scenario: Checking a specific drop down list option is present
  Given I am on the dropdown list page
  Then I can check a specific drop down list option is present

#Dropdown list test 2
Scenario: Checking all dropdown list options are as expected
  Given I am on the dropdown list page
  Then I see that all the expected dropdown options are present

#Dropdown list test 3
#work in process - incomplete
Scenario: Checking droplist option select works correctly
  Given I am on the dropdown list page
  When I select a specific drop down list option
  Then the required option is selected

 #Log in screen test 1
Scenario: Checking the log in process works correctly - correct credentials
  Given I am on the login page
  When I log into the application with the correct credentials
  Then the welcome screen is shown

#Log in screen test 2
#work in process - incomplete
Scenario: Checking the log in process works correctly - incorrect credentials
  Given I am on the login page
  When I try to log into the application with incorrect credentials
  Then an error screen is shown