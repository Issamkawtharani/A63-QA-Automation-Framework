Feature: Login Feature

  Scenario: Login Positive Scenario

    Given I open Koel login page
    When I enter email "issam.kawtharani@testpro.io"
    And I enter password "Issam@testpro1"
    And I submit
    Then I am logged in


  Scenario Outline:
    Given I open Koel login page
    When I enter email "<Email>"
    And I enter password "<password>"
    And I submit
    Then I am logged in
    Examples:
      | Email | password |
      |"issam.@testpro.io" | "invalid@testpro.io" |


