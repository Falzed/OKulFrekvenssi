# Toteutus
## Rakenne
Ohjelmalla on tekstipohjainen k�ytt�liittym�, jolla voi salata teksti� ja purkaa salaus muutamalla eri salausalgoritmill�. Lis�ksi vaikka avainta ei tunnettaisi ohjelma pystyy perus caesar- ja vigenere-salausten tapauksessa frekvenssianalyysill� purkamaan salauksen jos viesti on riitt�v�n iso. Jos kyseess� on keyed-variantti, ohjelma tarjoaa k�ytt�liittym�n jolla analysoida teksti� ja sen kirjainten frekvenssej�.

## Puutteet ja parannusehdotukset
Frekvenssianalyysiss� oli alun perin tutkia my�s kahden ja kolmen kirjaimen sarjoja (bigrammeja ja trigrammeja), eik� vain kirjainten frekvenssej�, mutta varsinkin trigrammeja on niin paljon ett� suomen/englannin frekvenssej� ei voi j�rkev�sti sy�tt�� ohjelmaan k�sin, vaan pit�isi saada data parsettua tiedostosta (ja data saatua j�rkev��n muotoon mist� lukea).

Keyed-varianttien analyysi olisi saattanut onnistua etsim�ll� lyhyit�, yleisi� sanoja kuten I, and, ja the. Toisaalta sekin monimutkaistuisi jos ei oleta ett� salatussa viestiss� on v�lily�ntej� ja muita merkkej�.

Vigen�re-salauksen frekvenssianalyysi olettaa salauksen salasanan olevan korkeintaan 50 merkki�. T�m�n voisi muuttaa triviaalisti. Se on vain est�m�st� ohjelmaa py�rim�st� liian kauaa.

## Aikavaativuudet
Caesar-salauksessa k�yd��n ensin aakkosto l�pi nelj��n kertaan, luoden (omatekoiset) hashmapit. Sen j�lkeen k�yd��n salaamaton teksti kirjain kerrallaan l�pi katsoen hashmapeist� oikea k��nn�s, joka lis�t��n taulukkoon. K��nn�ksen aikavaativuuden pit�isi olla O(n+m), miss� n on salattavan tekstin pituus ja m k�ytett�vien aakkosten m��r� (k�yt�nn�ss� 26, eli aikavaativuus O(n)).

Puretessa Caesar-salaus tunnetulla offsetilla aikavaatimus on sama kuin salatessa.

Keyed Caesarilla t�ytyy luoda uusi olio jos avain vaihtuu, jolloin k�yd��n aakkoset l�pi ja poistetaan merkit jotka avaimessa. Aikavaativuudeksi sek� salauksessa ja sen purussa tulee O(n+m+k), miss� k on avaimen pituus.

Vigenere-salauksessa kopioidaan salasanaa kunnes se on yht� pitk� kuin viesti, ja joka kirjaimen kohdalla lasketaan sivuluokka. Aikavaativuus pysyy samana.

Normi Caesar-salauksen purussa frekvenssianalyysin perusteella k�yd��n l�pi kaikki mahdolliset offestit, ja lasketaan frekvenssit niill� purkaen. Offsettej� on m=aakkosten koko, ja purun aikavaativuus on O(n+m) miss� n=viestin pituus, ja frekvenssien laskemiseen menee my�s O(n) joka offsetilla, joten aikavaativuus on O(mn^2). Koska m on k�yt�nn�ss� vakio, on aikavaativuus O(n^2).

Vigenere-analyysiss� joudutaan my�s selvitt�m��n sivuluokkien m��r�, eli salasanan pituus. Joka sivuluokalle suoritetaan Caesar-analyysi, eli aikavaativuus on O(sn^2) miss� s on salasanan pituus.
## L�hteet
http://pi.math.cornell.edu/~mec/2003-2004/cryptography/subs/frequencies.html 