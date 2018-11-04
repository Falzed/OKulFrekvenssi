# Määrittely
Aiheena on salakirjoituksen frekvenssianalyysi. Tarvittavia algoritmeja ovat erilaiset transponointiin perustuvat salausalgoritmit, kuten Caesar ja Vigenére -salaukset, sekä tietenkin salatun tekstin kirjainten ja kirjainsarjojen frekvenssien laskeminen. Ajan sallitessa saatan toteuttaa RSA-salauksen enimmäkseen demonstroidakseni että muuhun kuin merkkien transponointiin perustuviin salausmenetelmiin frekvenssianalyysi ei toimi.

Alustavana suunnitelmana olisi toteuttaa ainakin Caesar ja Vigenére -salaukset sekä niitten keyed variantit. Salausalgoritmit on enimmäkseen valittu mielenkiinnon perusteella.

Primitiivitauluokoiden pitäisi pitkälti riittää tietorakenteiden puolelta.

[Vigenére taulukko (Wikimedia commons)](./kuvat/Vigenère_square_shading.svg)

##Syötteet ja käyttöliittymä
Ohjelmalla tulee olemaan tekstipohjainen käyttöliittymä, jonka kautta voidaan salata annettu paljas teksti, dekryptoida salattu teksti jos tiedetään avain (ja salauksessa käytettyä ohjelman tuntemaa algoritmia), ja tietenkin analysoida salatun tekstin kirjainten ja kirjainsarjojen frekvenssejä. Ohjelma saattaa myös ehdottaa plain/cipher text kirjainpareja frekvenssien perusteella, luultavasti olettaen että viesti on englanniksi, ajan sallitessa myös suomeksi (olettaen että sopiva data löytyy).

##Aika- ja tilavaativuustavoitteet
Tilavaativuuksien pitäisi olla pieniä ja enimmäkseen lineaarisia. Salauksen aikavaativuus pitäisi olla myös ainakin Caesar ja Vigenere -salauksilla lineaarinen. Kirjainten frekvenssien lasku on myös lineaarinen, kuten myös kahden tai kolmen merkin ryppäiden frekvenssit. Vigenére-salauksen avaimen pituuden eli salauksen pituuden analysointi taitaa olla polynomniaalin (varmaan O(n^2)).