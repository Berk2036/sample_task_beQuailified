Feature: Checkout Overview Functionality

  Background: User is on the login page
    Given the user is on the "login" page

  Scenario Outline: Verify Product Information Consistency Between Shop Page and Checkout Overview
    When the user loges in with  "<username>" and "<password>"
    And the user sees the product information
    When the user has added all product to the cart
    And the user navigates to the cart page
    And the user initiates the checkout process
    Then the user should be redirected to the "checkout" page
    When the user enters the required information
      | name     | Max       |
      | lastname | Musterman |
      | zip_code | 11111     |
    Then the user should be redirected to the checkout overview with click continue button
    And product information on the checkout overview page should match in the shop page
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | performance_glitch_user | secret_sauce |


