# Käyttöopas

##Yleistä
Ohjelmalla ei ole graafista käyttöliittymää. Ohjelman käynnistäessä päätyy ohjelman pääsilmukkaan, jossa valitaan joko caesar, vigenere, keyed caesar tai keyed vigenere salaus. Ohjelman voi sulkea komennolla q.

##Caesar
Jos valitaan perus Caesar-salaus (komennolla encrypt), ohjelma kysyy halutaanko salata vai purkaa salaus. Jos salausta puretaan, ohjelma kysyy ensin salattavan tekstin ja sitten salauksen offsetin. Salattavan tekstin täytyy olla yhdellä rivillä. Sitten ohjelma tulostaa salatun tekstin.

Jos valitaan salauksen purku (komennolla decrypt), ohjelma kysyy ensin salatun tekstin, jonka täytyy olla yhdellä rivillä, ja sitten offsetin. Jos antaa offsetiksi -1, ohjelma arvioi kirjainten frekvenssien perusteella parhaan offsetin ja tulostaa sillä puretun viestin. Ohjelma olettaa salaamattoman viestin olevan englantia.

