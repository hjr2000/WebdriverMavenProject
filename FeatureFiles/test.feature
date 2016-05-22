Feature: Testing the internet

  @Runme
Scenario: Running a google search
  Given I am on the google homepage
  When I search for webdriver
  Then the page title is as expected

Scenario: Successfully accessing a page behind basic HTTP authentication
  Given I successfully reach a page behind basic HTTP authentication
  Then I see the page content as expected

Scenario: Cancelling the basic authentication dialog
  Given I attempt to access a page behind HTTP authentication
  When I cancel the authentication dialog
  Then I see the appropriate not authorised message

Scenario: Checking and unchecking textboxes
  Given I am on the checkbox test page
  When I click on both checkboxes
  Then I see the appropriate checkboxes are checked and unchecked
