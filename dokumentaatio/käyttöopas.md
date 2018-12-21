# K�ytt�opas

##Yleist�
Ohjelmalla ei ole graafista k�ytt�liittym��. Ohjelman k�ynnist�ess� p��tyy ohjelman p��silmukkaan, jossa valitaan joko caesar, vigenere, keyed caesar tai keyed vigenere salaus. Ohjelman voi sulkea komennolla q.

##Caesar
Jos valitaan perus Caesar-salaus, ohjelma kysyy halutaanko salata vai purkaa salaus. Jos valitaan salaus (komennolla encrypt), ohjelma kysyy ensin salattavan tekstin ja sitten salauksen offsetin. Salattavan tekstin t�ytyy olla yhdell� rivill�. Sitten ohjelma tulostaa salatun tekstin.

Jos valitaan salauksen purku (komennolla decrypt), ohjelma kysyy ensin salatun tekstin, jonka t�ytyy olla yhdell� rivill�, ja sitten offsetin. Jos antaa offsetiksi -1, ohjelma arvioi kirjainten frekvenssien perusteella parhaan offsetin ja tulostaa sill� puretun viestin. Ohjelma olettaa salaamattoman viestin olevan englantia.

##Vigenere
Perus vigenere-salauksen valitessa ohjelma kysyy halutaanko salata viesti vai purkaa salaus. Jos valitaan salaus (komennolla encrypt), ohjelma kysyy ensin salattavan tekstin ja sitten salauksen salasanan. Salattavan tekstin t�ytyy olla yhdell� rivill�. Sitten ohjelma tulostaa salatun tekstin.

Jos valitaan salauksen purku (komennolla decrypt), ohjelma kysyy ensin salatun tekstin, jonka t�ytyy olla yhdell� rivill�, ja sitten salasanan. Jos antaa salasanaksi tyhj�n merkkijonon, ohjelma arvioi kirjainten frekvenssien perusteella parhaan salasanan ja tulostaa sill� puretun viestin. Ohjelma olettaa salaamattoman viestin olevan englantia.

## Keyed-variantit
Valittaessa keyed Caesar tai keyed Vigenere salauksen, ohjelma antaa kolme vaihtoehtoa: encrypt/decrypt/analysis. Jos valitsee encrypt tai decrypt, etenee ohjelma samaan tapaan kuin normi Caesar/Vigenere-salauksessa, mutta ohjelma kysyy my�s salauksen avaimen, eik� ohjelma anna omaa arvaustaan salauksen purkamiseksi.

Jos taas valitaan analysis, siirtyy ohjelma uuteen silmukkaan. 

### Keyed Caesar -analyysi
