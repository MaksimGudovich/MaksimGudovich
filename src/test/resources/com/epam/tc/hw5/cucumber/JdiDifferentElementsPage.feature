Feature: Jdi Different elements page

  Scenario: Different page test
    Given I open JDI GitHub site
    And I login as user 'Roman Iovlev'
    When I click on 'Service' button in Header
    And I click on 'Different elements' button in Header Service dropdown
    And I select 'Water' checkbox on Checkbox row on Different Element page
    And I select 'Wind' checkbox on Checkbox row on Different Element page
    And I select 'Selen' radio on Checkbox row on Different Element page
    And I select 'Yellow' dropdown on Checkbox row on Different Element page
    Then 1 log row has 'Water: condition changed to true' text in Log section
    And 1 log row has 'Wind: condition changed to true' text in Log section
    And 1 log row has 'metal: value changed to Selen' text in Log section
    And 1 log row has 'Colors: value changed to Yellow' text in Log section