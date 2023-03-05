@Beymen

Feature: Beymen Project

  Scenario: Kullanici arama cubugunda arama yapabilmeli, sepetine ekleme yapabilmeli ve silebilmelidir.

    Given Beymen sitesi acilir.
    When Ana sayfanin acildigi kontrol edilir.
    When Arama kutucuguna şort kelimesi girilir.
    Then Arama kutucuguna girilen şort kelimesi silinir.
    Then Arama kutucuguna gömlek kelimesi girilir.
    Then Klavye uzerinden Enter tusuna basilir.
    Then Sonuca gore sergilenen urunlerden rastgele bir urun secilir.
    Then Secilen urunun bilgisi ve tutar bilgisi txt dosyasina yazilir.
    Then Secilen urun sepete eklenir.
    Then Urun sayfasindaki fiyat ile sepette yer alan urun fiyatinin dogrulugu karsilastirilir.
    Then Adet arttirilarak urun adedinin iki oldugu dogrulanir.
    And Urun sepetten silinerek septin bos oldugu kontrol edilir.
    And Sayfa kapatilir.
