Feature: Verification and shop process

  Background: User is on the shop page
    Given the user is on the "login" page

  Scenario Outline: User successfully completes the shopping
    When the user tries with "<username>" and "<password>"
    When the user adds a product to the cart
    And the user navigates to the cart page
    And the user initiates the checkout process
    And the user enters the required informations
      | name     | Max       |
      | lastname | Musterman |
      | zip_code | 11111     |
    And the user clicks the finish button
    Then the user should be see the success message
    When the user clicks the back button
    Then the user should be redirected to the "shop" page
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | visual_user   | secret_sauce |

  Scenario Outline: Verify "Add to Cart" button functionality
    When the user tries with "<username>" and "<password>"
    When the user clicks all Add to Cart
    Then the button should change to Remove
    And the number in the cart icon should match the number of products in cart
    When the user clicks the remove button
    Then the button should change to Add to Cart
    And the number in the cart icon should match the number of products in cart
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | performance_glitch_user | secret_sauce |


  Scenario Outline: Verify added product appears in the cart
    When the user tries with "<username>" and "<password>"
    When the user has added first product to the cart
    And the user navigates to the cart page
    Then the product information in the cart should match the shop page details
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |

  Scenario Outline: Verify added product appears in the cart
    When the user tries with "<username>" and "<password>"
    When the user has added all product to the cart
    And the user navigates to the cart page
    Then the all product information in the cart should match the shop page details
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | performance_glitch_user | secret_sauce |


