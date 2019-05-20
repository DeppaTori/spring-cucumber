Feature: User management
  Scenario: Add User
    Given User table is empty
    When User "Tiara" register
    Then User table have "Tiara" row
