Feature: Items catalog

  As a User
  I want to be able to work with the list of items
  and add them to the cart on the mobile page

  Scenario: Add item to cart
    Given I go to mobile page
    When I click on the add to cart button
    Then I see cart page

