# K�ytt�opas

##Yleist�
Ohjelmalla ei ole graafista k�ytt�liittym��. Ohjelman k�ynnist�ess� p��tyy ohjelman p��silmukkaan, jossa valitaan joko caesar, vigenere, keyed caesar tai keyed vigenere salaus. Ohjelman voi sulkea komennolla q.

##Caesar
Jos valitaan perus Caesar-salaus (komennolla encrypt), ohjelma kysyy halutaanko salata vai purkaa salaus. Jos salausta puretaan, ohjelma kysyy ensin salattavan tekstin ja sitten salauksen offsetin. Salattavan tekstin t�ytyy olla yhdell� rivill�. Sitten ohjelma tulostaa salatun tekstin.

Jos valitaan salauksen purku (komennolla decrypt), ohjelma kysyy ensin salatun tekstin, jonka t�ytyy olla yhdell� rivill�, ja sitten offsetin. Jos antaa offsetiksi -1, ohjelma arvioi kirjainten frekvenssien perusteella parhaan offsetin ja tulostaa sill� puretun viestin. Ohjelma olettaa salaamattoman viestin olevan englantia.

