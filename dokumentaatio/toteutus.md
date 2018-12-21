# Toteutus
## Rakenne
Ohjelmalla on tekstipohjainen käyttöliittymä, jolla voi salata tekstiä ja purkaa salaus muutamalla eri salausalgoritmillä. Lisäksi vaikka avainta ei tunnettaisi ohjelma pystyy perus caesar- ja vigenere-salausten tapauksessa frekvenssianalyysillä purkamaan salauksen jos viesti on riittävän iso. Jos kyseessä on keyed-variantti, ohjelma tarjoaa käyttöliittymän jolla analysoida tekstiä ja sen kirjainten frekvenssejä.

## Puutteet ja parannusehdotukset
Frekvenssianalyysissä oli alun perin tutkia myös kahden ja kolmen kirjaimen sarjoja (bigrammeja ja trigrammeja), eikä vain kirjainten frekvenssejä, mutta varsinkin trigrammeja on niin paljon että suomen/englannin frekvenssejä ei voi järkevästi syöttää ohjelmaan käsin, vaan pitäisi saada data parsettua tiedostosta (ja data saatua järkevään muotoon mistä lukea).

Keyed-varianttien analyysi olisi saattanut onnistua etsimällä lyhyitä, yleisiä sanoja kuten I, and, ja the. Toisaalta sekin monimutkaistuisi jos ei oleta että salatussa viestissä on välilyöntejä ja muita merkkejä.

Vigenère-salauksen frekvenssianalyysi olettaa salauksen salasanan olevan korkeintaan 50 merkkiä. Tämän voisi muuttaa triviaalisti. Se on vain estämästä ohjelmaa pyörimästä liian kauaa.

## Aikavaativuudet
Caesar-salauksessa käydään ensin aakkosto läpi neljään kertaan, luoden (omatekoiset) hashmapit. Sen jälkeen käydään salaamaton teksti kirjain kerrallaan läpi katsoen hashmapeistä oikea käännös, joka lisätään taulukkoon. Käännöksen aikavaativuuden pitäisi olla O(n+m), missä n on salattavan tekstin pituus ja m käytettävien aakkosten määrä (käytännössä 26, eli aikavaativuus O(n)).

Puretessa Caesar-salaus tunnetulla offsetilla aikavaatimus on sama kuin salatessa.

Keyed Caesarilla täytyy luoda uusi olio jos avain vaihtuu, jolloin käydään aakkoset läpi ja poistetaan merkit jotka avaimessa. Aikavaativuudeksi sekä salauksessa ja sen purussa tulee O(n+m+k), missä k on avaimen pituus.

Vigenere-salauksessa kopioidaan salasanaa kunnes se on yhtä pitkä kuin viesti, ja joka kirjaimen kohdalla lasketaan sivuluokka. Aikavaativuus pysyy samana.

Normi Caesar-salauksen purussa frekvenssianalyysin perusteella käydään läpi kaikki mahdolliset offestit, ja lasketaan frekvenssit niillä purkaen. Offsettejä on m=aakkosten koko, ja purun aikavaativuus on O(n+m) missä n=viestin pituus, ja frekvenssien laskemiseen menee myös O(n) joka offsetilla, joten aikavaativuus on O(mn^2). Koska m on käytännössä vakio, on aikavaativuus O(n^2).

Vigenere-analyysissä joudutaan myös selvittämään sivuluokkien määrä, eli salasanan pituus. Joka sivuluokalle suoritetaan Caesar-analyysi, eli aikavaativuus on O(sn^2) missä s on salasanan pituus.
## Lähteet
http://pi.math.cornell.edu/~mec/2003-2004/cryptography/subs/frequencies.html 