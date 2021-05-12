Feature: Compare Credit Cards

  Scenario Outline: Compare Two Credit Card Details
    Given the user navigate to DBS Landing Page
    When the user clicks on Cards Option
    And the user clicks on CreditCards Option
    And User Select Two Credit Cards <CardOne> and <CardTwo>
    Then User Validates the Details of <CardOne> and <CardTwo>


    Examples:
      | CardOne                          | CardTwo             |
      | DBS Altitude Visa Signature Card | DBS Black Visa Card |



