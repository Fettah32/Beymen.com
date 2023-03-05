@Trello
Feature: Trello

  Scenario: Trello'da board olusturunuz ve siliniz.

    Given Trello uzerinde bir board olusturunuz.
    When Olusturdugunuz board'a iki tane kart olusturunuz.
    Then Olusturdugunuz bu iki karttan random olacak sekilde bir tanesini guncelleyiniz.
    Then Olusturdugunuz kartlari siliniz.
    And Olusturdugunuz board'u siliniz.
