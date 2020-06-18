
Feature: Login and Logout functionality test

  Background: Home page pre-requisite
    Given User already in home page


  Scenario: Login functionality test

    When User click on Login link
    Then User enter valid username and password
    Then User click on Login button
    Then User land to home page



  Scenario: Logout functionality test

    When User already successfully logged in
    Then User click on Logout button
    Then User land to home page after logged out
