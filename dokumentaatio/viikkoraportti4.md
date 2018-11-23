# Viikko 4
Viikon aikana toteutin Keyed Caesar ja Keyed Vigenere salaukset, sekä Vigenere-salauksen frekvenssianalyysin. Aloitin toteutus- ja testausdokumentaation kirjoittamisen, mutten edennyt pitkälle. Suorituskykytestaus on alkuteillä.

Epäselväksi on jäänyt miten keyed-varianttien frekvenssianalyysi hoituu. Suurimpana ongelmana on se ettei niistä tunnu löytävän paljoa googlesta.

Seuraavaksi aion refaktoroida käyttöliittymän ja Caesar/Keyed Caesar sekä Vigenere/Keyed Vigenere salaukset. Molemmissa on ikävän paljon copy pastettua koodia. Keyed Caesar/Vigenere-salauksien analyysin toteuttaminen olisi myös hyvä, kuten myös suorituskykytestaus ja dokumentaation kirjoittaminen.

Koodissa käytetään paljon String-luokan metodeja, mitkä saatetaan laskea valmiiksi algoritmeiksi. Enimmäkseen replaceAll, jolla tällä hetkellä poistetaan tekstistä muut merkit kuin kirjaimet, saattaa olla ongelma. Muutenkin olisi hyvä mahdollistaa varsinkin välilyöntien säilyminen.

Käytetty aika oli noin 10 tuntia.
