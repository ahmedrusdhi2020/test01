Feature: Mortgage load inquiry
  I want to use this template for my feature file

  Scenario: verify mortgage load inquiry page
    Given Landing page "https://www.myrepublicbank.com/personal/mortgages" 
    When I click on Get Started Now Btn
    Then I verify text on top 
    And I click on Next Btn
    Then I select currently working with a load officer yes or no
    And select the loan purpose
    And I put estimated purchase price "150000"
    And I select Down payment percentage
    And click Next Btn