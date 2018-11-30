# Testaus
Enimmäkseen on testattu, että eri salaukset enkryptaavat ja dekryptaavat oikein kutsumalla metodeja syötteellä jonka toivottu tulos on tunnettu (esim. paperilla ratkaistu). Testauksessa on tietenkin käytetty JUnitia.

## Suorityskyky
Caesar-salauksessa kestää enkryptaa "testmessage" offsetillä 5 keskimäärin . Toisin päin kestää noin 0.0029 ms. Testi oli 1000 suorituksen keskiarvo. Ero on outo, koska enkryptaus ja dekryptauksen ero on onko yksi laskutoimitus + vai -.
Vigenere-salauksessa sama viesti avaimella "test" kesti keskimäärin noin 0.0056 ms salata, salauksen purkaminen 0.0033 ms.
Keyed-varianteilla avaimella key Caesar-salauksessa viestillä "testmessage" ja offsetillä 5 kesti keskimäärin 0.0045 ms, dekryptaus taas 0.0046 ms. Vigenerellä (testmessage, test) aikaa kului salaukseen keskimäärin 0.0055 ms ja purkuun 0.0040 ms.