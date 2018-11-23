# Toteutus
## Rakenne
Ohjelmalla on tekstipohjainen käyttöliittymä, jolla voi salata tekstiä ja purkaa salaus muutamalla eri salausalgoritmillä. Lisäksi vaikka avainta ei tunnettaisi ohjelma pystyy frekvenssianalyysillä purkamaan salauksen jos viesti on riittävän iso.

## Puutteet ja parannusehdotukset
Ohjelma tällä hetkellä muuttaa kaikki viestit pieniin kirjaimiin ja poistaa niistä kaikki muut merkit kuin pienet kirjaimet. Lisäksi frekvenssianalyysissä oli alun perin tutkia myös kahden ja kolmen kirjaimen sarjoja (bigrammeja ja trigrammeja), eikä vain kirjainten frekvenssejä, mutta varsinkin trigrammeja on niin paljon että suomen/englannin frekvenssejä ei voi järkevästi syöttää ohjelmaan käsin, vaan pitäisi saada data parsettua tiedostosta (ja data saatua järkevään muotoon mistä lukea).

Keyed Caesar ja Keyed Vigenère -salauksien frekvenssianalyysiä ei ole toteutettu.
Vigenère-salauksen frekvenssianalyysi olettaa salauksen salasanan olevan korkeintaan 50 merkkiä. Tämän voisi muuttaa triviaalisti. Se on vain estämästä ohjelmaa pyörimästä liian kauaa.

## Lähteet
http://pi.math.cornell.edu/~mec/2003-2004/cryptography/subs/frequencies.html 