# Testaus
Enimm�kseen on testattu, ett� eri salaukset enkryptaavat ja dekryptaavat oikein kutsumalla metodeja sy�tteell� jonka toivottu tulos on tunnettu (esim. paperilla ratkaistu). Testauksessa on tietenkin k�ytetty JUnitia.

## Suorityskyky
Caesar-salauksessa kest�� enkryptaa "testmessage" offsetill� 5 keskim��rin 0.084 ms. Toisin p�in kest�� noin 0.048 ms.
Vigenere-salauksessa sama viesti avaimella "test" kesti noin 0.10 ms salata, salauksen purkaminen vain 0.0097 ms.