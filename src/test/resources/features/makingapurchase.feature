Feature: Making a purchase
  As a registered user
  I want to add items to shopping cart
  So I can buy them

  @done
  Scenario Outline: Successful purchase of a product
    Given The user is logged in
    And The user is on the page of the "<product>" they want to buy
    And The user selects correct "<size>", "<quantity>" etc.
    And The user adds items to shopping cart
    When The user proceeds to checkout
    And The user confirms shipping address, "<alias>", "<address>", "<city>", "<postCode>", "<country>"
    And The user selects shipping method
    And the user selects payment type
    And the user clicks on Place Order
    Then The order is created

    Examples:
      | product                     | size | quantity | alias    | address            | city | postCode | country        |
      | Hummingbird printed sweater | m   | 5        | Zadanie2 | ZadanieWarsztatowe | CL   | 12345    | United Kingdom |