Feature: Add and delete product
  I'm admin and I want add and
  delete product from online shop

  Background:


  @sanity
  Scenario: Successful add and delete product
    Given open online shop
    When log in as admin
    When open Products page
    When try to add new product and check this
    When I filtered this product and select checkbox
    When I click on delete button and check for successful message