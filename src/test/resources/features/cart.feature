Feature: Cart page functionality

  Background: User is on the login page
    Given the user is on the "login" page

  Scenario Outline:  User removes items from the cart using the Remove button
    When the user loges in with  "<username>" and "<password>"
    When  the user adds a product to the cart
    And the user navigates to the cart page
    And the user clicks the remove button at cart page
    Then the products should no longer visible in the cart
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |

  Scenario Outline:  User removes items from the cart using the Remove button
    When the user loges in with  "<username>" and "<password>"
    When the user clicks all Add to Cart
    And the user navigates to the cart page
    And the user clicks the remove button at cart page
    Then the products should no longer visible in the cart
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |


