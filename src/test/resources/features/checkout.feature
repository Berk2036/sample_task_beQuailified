Feature: Checkout Process Functionality

  Background: the user is on the login page
    Given the user is on the "login" page

  Scenario Outline: Verify user navigates from cart to checkout page and returns to cart upon canceling
    When the user loges in with  "<username>" and "<password>"
    Given the user adds a product to the cart
    And the user navigates to the cart page
    And the user initiates the checkout process
    Then the user should be redirected to the "checkout" page
    And the user enters the required information
      | name     | Max       |
      | lastname | Musterman |
      | zip_code | 11111     |
    And the user should be redirected to the cart page with click cancel button
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | visual_user   | secret_sauce |

