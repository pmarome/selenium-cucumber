Feature: Hotel Search Validations

  Background:
    Given I log in to the Adactin application with username "marometest" and password "ryfhyb-xowsUn-bupqa0"
    And I am on the Adactin "Search Hotel" booking page

  Scenario Outline: Search for available hotels and validate results
    When I select "<location>" as the location
    And I select "<hotel>" as the hotel
    And I select "<roomType>" as the room type
    And I select 1 as the number of rooms
    And I enter "<checkInDate>" as the check-in date
    And I enter "<checkOutDate>" as the check-out date
    And I select 1 for adults per room
    And I select 1 for children per room
    And I click on the search button to find hotels
    Then I should see a list of available hotels that match the entered search criteria "<hotel>", "<location>", "<roomType>", "<numberOfRooms>", "<checkInDate>", "<checkOutDate>", "<numberOfDays>"

    Examples:
      | hotel        | location  | roomType | numberOfRooms | checkInDate | checkOutDate | numberOfDays |
      | Hotel Hervey | Melbourne | Standard | 1 Rooms       | 02/04/2024  | 03/04/2024   | 1 Days       |

  Scenario: Validate date error message
    When I set the check-in date to "02/04/2023" and the check-out date to "01/04/2023"
    And I click on the search button to validate dates
    Then I should see the error message "Check-In Date shall be before than Check-Out Date"
