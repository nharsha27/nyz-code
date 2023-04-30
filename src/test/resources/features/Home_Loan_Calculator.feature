@tag
  Feature: Calculate How much I could borrow?

    Background:
      Given I landed on Calculate How much I could borrow page

      Scenario Outline:

        Given I have entered person's following details: <application type>,  <Number of dependants>,  <Property you would like to buy> ,<Your annual income>, <Your annual other income>, <Monthly living expenses>, <Current home loan monthly repayments>, <Other loan monthly repayments>, <Other monthly commitments>, <Total Credit limits>
        When  I click on Work Out how much I could borrow button
        Then  Borrowing estimate is displayed on the screen "<result>"
        Examples:
          | application type | Number of dependants | Property you would like to buy | Your annual income | Your annual other income | Monthly living expenses | Current home loan monthly repayments | Other loan monthly repayments | Other monthly commitments | Total Credit limits | result |
          | "Sing"           | 2                    | "Home in"                      | 80000              | 10000                    | 500                     | 0                                    | 100                           | 0                         | 10000               | true   |


