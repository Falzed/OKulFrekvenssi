# Testaus
Enimmäkseen on testattu, että eri salaukset enkryptaavat ja dekryptaavat oikein kutsumalla metodeja syötteellä jonka toivottu tulos on tunnettu (esim. paperilla ratkaistu). Testauksessa on tietenkin käytetty JUnitia.

## Suorityskyky
Caesar-salauksessa kestää enkryptaa "testmessage" offsetillä 5 keskimäärin 0.084 ms. Toisin päin kestää noin 0.048 ms.
Vigenere-salauksessa sama viesti avaimella "test" kesti noin 0.10 ms salata, salauksen purkaminen vain 0.0097 ms.