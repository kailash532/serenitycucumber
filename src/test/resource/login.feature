Feature: Login screen functionality
  Background: 
    Given Launch the app
    Then get the message
    And Close the message

  Scenario: verify login screen
    Given user login to the screen
    When user in expected screen
    Then Check the title of the screen
    
