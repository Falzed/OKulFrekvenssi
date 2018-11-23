# Toteutus
## Rakenne
Ohjelmalla on tekstipohjainen k�ytt�liittym�, jolla voi salata teksti� ja purkaa salaus muutamalla eri salausalgoritmill�. Lis�ksi vaikka avainta ei tunnettaisi ohjelma pystyy frekvenssianalyysill� purkamaan salauksen jos viesti on riitt�v�n iso.

## Puutteet ja parannusehdotukset
Ohjelma t�ll� hetkell� muuttaa kaikki viestit pieniin kirjaimiin ja poistaa niist� kaikki muut merkit kuin pienet kirjaimet. Lis�ksi frekvenssianalyysiss� oli alun perin tutkia my�s kahden ja kolmen kirjaimen sarjoja (bigrammeja ja trigrammeja), eik� vain kirjainten frekvenssej�, mutta varsinkin trigrammeja on niin paljon ett� suomen/englannin frekvenssej� ei voi j�rkev�sti sy�tt�� ohjelmaan k�sin, vaan pit�isi saada data parsettua tiedostosta (ja data saatua j�rkev��n muotoon mist� lukea).

Keyed Caesar ja Keyed Vigen�re -salauksien frekvenssianalyysi� ei ole toteutettu.
Vigen�re-salauksen frekvenssianalyysi olettaa salauksen salasanan olevan korkeintaan 50 merkki�. T�m�n voisi muuttaa triviaalisti. Se on vain est�m�st� ohjelmaa py�rim�st� liian kauaa.

## L�hteet
http://pi.math.cornell.edu/~mec/2003-2004/cryptography/subs/frequencies.html 