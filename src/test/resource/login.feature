
Feature: Login screen functionality
@SmokeTest
  Scenario: verify login screen
    Given user login to the screen
    When user in expected screen
    Then Check the title of the screen
