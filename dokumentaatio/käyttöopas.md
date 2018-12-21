# Käyttöopas

##Yleistä
Ohjelmalla ei ole graafista käyttöliittymää. Ohjelman käynnistäessä päätyy ohjelman pääsilmukkaan, jossa valitaan joko caesar, vigenere, keyed caesar tai keyed vigenere salaus. Ohjelman voi sulkea komennolla q.

##Caesar
Jos valitaan perus Caesar-salaus, ohjelma kysyy halutaanko salata vai purkaa salaus. Jos valitaan salaus (komennolla encrypt), ohjelma kysyy ensin salattavan tekstin ja sitten salauksen offsetin. Salattavan tekstin täytyy olla yhdellä rivillä. Sitten ohjelma tulostaa salatun tekstin.

Jos valitaan salauksen purku (komennolla decrypt), ohjelma kysyy ensin salatun tekstin, jonka täytyy olla yhdellä rivillä, ja sitten offsetin. Jos antaa offsetiksi -1, ohjelma arvioi kirjainten frekvenssien perusteella parhaan offsetin ja tulostaa sillä puretun viestin. Ohjelma olettaa salaamattoman viestin olevan englantia.

##Vigenere
Perus vigenere-salauksen valitessa ohjelma kysyy halutaanko salata viesti vai purkaa salaus. Jos valitaan salaus (komennolla encrypt), ohjelma kysyy ensin salattavan tekstin ja sitten salauksen salasanan. Salattavan tekstin täytyy olla yhdellä rivillä. Sitten ohjelma tulostaa salatun tekstin.

Jos valitaan salauksen purku (komennolla decrypt), ohjelma kysyy ensin salatun tekstin, jonka täytyy olla yhdellä rivillä, ja sitten salasanan. Jos antaa salasanaksi tyhjän merkkijonon, ohjelma arvioi kirjainten frekvenssien perusteella parhaan salasanan ja tulostaa sillä puretun viestin. Ohjelma olettaa salaamattoman viestin olevan englantia.

## Keyed-variantit
Valittaessa keyed Caesar tai keyed Vigenere salauksen, ohjelma antaa kolme vaihtoehtoa: encrypt/decrypt/analysis. Jos valitsee encrypt tai decrypt, etenee ohjelma samaan tapaan kuin normi Caesar/Vigenere-salauksessa, mutta ohjelma kysyy myös salauksen avaimen, eikä ohjelma anna omaa arvaustaan salauksen purkamiseksi.

Jos taas valitaan analysis, siirtyy ohjelma uuteen silmukkaan. 

### Keyed Caesar -analyysi
Silmukka näyttää sen hetkiset kuvaukset salaamattomasta tekstistä salattuun, sen hetkisen käännöksen, ja salatun tekstin ja englannin kirjnainten frekvenssit. Frekvenssit annetaan ensin aakkosjärjestyksessä, sitten suuruusjärjestyksessä.

Komennolla map a b missä a ja b ovat pieniä kirjaimia saa asetettua uuden kuvauksen a->b. 
Komennolla key foo missä foo on merkkijono saadaan asetettua salauksen avain, esim. key avain asettaa a->a, b->v, c->i, d->n (toinen a poistetaan duplikaattina). 
Komennolla fill mapping ohjelma täyttää aakkosjärjestyksessä loput kuvaukset. 
Komennolla shift x missä x on kokonaisluku (ei tarvitse olla positiivinen) ohjelma siirtää kaikkia kuvauksia x askelta aakkosissa. Esimerkiksi jos ohjelma näyttää
abcdefghijklmnopqrstuvwxyz
||||||||||||||||||||||||||
vvvvvvvvvvvvvvvvvvvvvvvvvv
avinbcdefghjklmopqrstuwxyz

komennolla shift 5 siitä tulee
abcdefghijklmnopqrstuvwxyz
||||||||||||||||||||||||||
vvvvvvvvvvvvvvvvvvvvvvvvvv
cdefghjklmopqrstuwxyzavinb

Komennolla reset saa kaikki kuvaukset poistettua. Komennolla save i missä i on kokonaisluku väliltä 0-255 saa tallennettua nykyiset kuvaukset, ja ne saa takaisin komennolla load i.

### Keyed Vigenere -analyysi
Ennen silmukkaa ohjelma kysyy myös salasanan pituuden. Silmukka on hyvin samantapainen kuin Keyed Caesarissa. Map-komento tarvitsee kolmanneksi parametriksi sivuluokan jota kuvaus koskee, komennolla set coset i saa valittua sivuluokan jota ohjelma käsittelee (silmukan alussa 0). key- ja shift-komennot vaikuttavat vain valittuun sivuluokkaan.

## jar-tiedostot
.jar-tiedostot löytyvät [täältä](../jar)