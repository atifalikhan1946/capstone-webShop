@Registration
Feature: User Registration



  Scenario: Successful registration with all required fields
    Given I am on the Demo Web Shop registration page
    When I enter "Atif" as the first name
    And I enter "Khan" as the last name
    And I select "Male" as the gender
    And I enter the following credentials:
      | Email                    | Password       | Confirm Password |
      | atifkhan1234@gmail.com    | 123456789123   | 123456789123     |
    And I click the "Register" button
