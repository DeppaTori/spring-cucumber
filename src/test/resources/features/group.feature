Feature: Group Management
  Scenario Outline: Add New Group
    Given Group table is empty
    When User add new "<groupName>" group
    Then Group table have <total> row

    Examples:
    | groupName | total |
    | Magician | 1 |
    | Knight | 1 |
    | Defender | 1 |
    | Archer | 1 |