# K‰yttˆopas

##Yleist‰
Ohjelmalla ei ole graafista k‰yttˆliittym‰‰. Ohjelman k‰ynnist‰ess‰ p‰‰tyy ohjelman p‰‰silmukkaan, jossa valitaan joko caesar, vigenere, keyed caesar tai keyed vigenere salaus. Ohjelman voi sulkea komennolla q.

##Caesar
Jos valitaan perus Caesar-salaus, ohjelma kysyy halutaanko salata vai purkaa salaus. Jos valitaan salaus (komennolla encrypt), ohjelma kysyy ensin salattavan tekstin ja sitten salauksen offsetin. Salattavan tekstin t‰ytyy olla yhdell‰ rivill‰. Sitten ohjelma tulostaa salatun tekstin.

Jos valitaan salauksen purku (komennolla decrypt), ohjelma kysyy ensin salatun tekstin, jonka t‰ytyy olla yhdell‰ rivill‰, ja sitten offsetin. Jos antaa offsetiksi -1, ohjelma arvioi kirjainten frekvenssien perusteella parhaan offsetin ja tulostaa sill‰ puretun viestin. Ohjelma olettaa salaamattoman viestin olevan englantia.

##Vigenere
Perus vigenere-salauksen valitessa ohjelma kysyy halutaanko salata viesti vai purkaa salaus. Jos valitaan salaus (komennolla encrypt), ohjelma kysyy ensin salattavan tekstin ja sitten salauksen salasanan. Salattavan tekstin t‰ytyy olla yhdell‰ rivill‰. Sitten ohjelma tulostaa salatun tekstin.

Jos valitaan salauksen purku (komennolla decrypt), ohjelma kysyy ensin salatun tekstin, jonka t‰ytyy olla yhdell‰ rivill‰, ja sitten salasanan. Jos antaa salasanaksi tyhj‰n merkkijonon, ohjelma arvioi kirjainten frekvenssien perusteella parhaan salasanan ja tulostaa sill‰ puretun viestin. Ohjelma olettaa salaamattoman viestin olevan englantia.

## Keyed-variantit
Valittaessa keyed Caesar tai keyed Vigenere salauksen, ohjelma antaa kolme vaihtoehtoa: encrypt/decrypt/analysis. Jos valitsee encrypt tai decrypt, etenee ohjelma samaan tapaan kuin normi Caesar/Vigenere-salauksessa, mutta ohjelma kysyy myˆs salauksen avaimen, eik‰ ohjelma anna omaa arvaustaan salauksen purkamiseksi.

Jos taas valitaan analysis, siirtyy ohjelma uuteen silmukkaan. 

### Keyed Caesar -analyysi
Silmukka n‰ytt‰‰ sen hetkiset kuvaukset salaamattomasta tekstist‰ salattuun, sen hetkisen k‰‰nnˆksen, ja salatun tekstin ja englannin kirjnainten frekvenssit. Frekvenssit annetaan ensin aakkosj‰rjestyksess‰, sitten suuruusj‰rjestyksess‰.

Komennolla map a b miss‰ a ja b ovat pieni‰ kirjaimia saa asetettua uuden kuvauksen a->b. 
Komennolla key foo miss‰ foo on merkkijono saadaan asetettua salauksen avain, esim. key avain asettaa a->a, b->v, c->i, d->n (toinen a poistetaan duplikaattina). 
Komennolla fill mapping ohjelma t‰ytt‰‰ aakkosj‰rjestyksess‰ loput kuvaukset. 
Komennolla shift x miss‰ x on kokonaisluku (ei tarvitse olla positiivinen) ohjelma siirt‰‰ kaikkia kuvauksia x askelta aakkosissa. Esimerkiksi jos ohjelma n‰ytt‰‰
abcdefghijklmnopqrstuvwxyz
||||||||||||||||||||||||||
vvvvvvvvvvvvvvvvvvvvvvvvvv
avinbcdefghjklmopqrstuwxyz

komennolla shift 5 siit‰ tulee
abcdefghijklmnopqrstuvwxyz
||||||||||||||||||||||||||
vvvvvvvvvvvvvvvvvvvvvvvvvv
cdefghjklmopqrstuwxyzavinb

Komennolla reset saa kaikki kuvaukset poistettua. Komennolla save i miss‰ i on kokonaisluku v‰lilt‰ 0-255 saa tallennettua nykyiset kuvaukset, ja ne saa takaisin komennolla load i.

### Keyed Vigenere -analyysi
Ennen silmukkaa ohjelma kysyy myˆs salasanan pituuden. Silmukka on hyvin samantapainen kuin Keyed Caesarissa. Map-komento tarvitsee kolmanneksi parametriksi sivuluokan jota kuvaus koskee, komennolla set coset i saa valittua sivuluokan jota ohjelma k‰sittelee (silmukan alussa 0). key- ja shift-komennot vaikuttavat vain valittuun sivuluokkaan.

Esimerkiksi jos salattu viesti olisi "Hhuk rs s lxsl exsksze, gdxaka rgwffe", ja tiedett‰isiin salasanan pituuden olevan 4, 