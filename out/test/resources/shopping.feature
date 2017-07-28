Feature: User shops various items and pays sales tax
    
Scenario: As a sales representative, I want to calculate total amount that the customer pays when he/she only buys material exempted from tax
    Given a user is registered with the store

    And the user buys the book of 150 rupees

    And the user buys another book of 200 rupees

    And the user buys the food item of 150 rupees

    When the user asks for a bill

    Then the total bill user needs to pay is 500 rupees