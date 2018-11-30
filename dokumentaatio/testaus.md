# Testaus
Enimm�kseen on testattu, ett� eri salaukset enkryptaavat ja dekryptaavat oikein kutsumalla metodeja sy�tteell� jonka toivottu tulos on tunnettu (esim. paperilla ratkaistu). Testauksessa on tietenkin k�ytetty JUnitia.

## Suorityskyky
Caesar-salauksessa kest�� enkryptaa "testmessage" offsetill� 5 keskim��rin . Toisin p�in kest�� noin 0.0029 ms. Testi oli 1000 suorituksen keskiarvo. Ero on outo, koska enkryptaus ja dekryptauksen ero on onko yksi laskutoimitus + vai -.
Vigenere-salauksessa sama viesti avaimella "test" kesti keskim��rin noin 0.0056 ms salata, salauksen purkaminen 0.0033 ms.
Keyed-varianteilla avaimella key Caesar-salauksessa viestill� "testmessage" ja offsetill� 5 kesti keskim��rin 0.0045 ms, dekryptaus taas 0.0046 ms. Vigenerell� (testmessage, test) aikaa kului salaukseen keskim��rin 0.0055 ms ja purkuun 0.0040 ms.