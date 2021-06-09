
-- preduzece podaci
INSERT INTO "preduzece" ("id", "naziv", "pib", "sediste", "opis")
VALUES (nextval('preduzece_seq'), 'AMICUS SRB D.O.O.', '108585471', 'Beograd, Republika Srbija', 'farmaceutska kompanija koja se bavi trgovinom na veliko farmaceutskim proizvodima');
INSERT INTO "preduzece" ("id", "naziv", "pib", "sediste", "opis")
VALUES (nextval('preduzece_seq'), 'BERLIN-CHEMIE A. MENARINI DISTRIBUTION D.O.O.', '110102872', 'Beograd, Republika Srbija', 'farmaceutska kompanija koja se bavi trgovinom na veliko farmaceutskim proizvodima');
INSERT INTO "preduzece" ("id", "naziv", "pib", "sediste", "opis")
VALUES (nextval('preduzece_seq'), 'VEGA IT d.o.o. Novi Sad', '105723766', 'Novi Sad, Republika Srbija', 'IT kompanija koja razvija softverska resenja po narudzbini i plasira ih na trzista Velike Britanije, Nemacke, Belgije, Holandije i Svajcarske');
INSERT INTO "preduzece" ("id", "naziv", "pib", "sediste", "opis")
VALUES (nextval('preduzece_seq'), 'Comtrade Distribution d.o.o. Beograd', '100000104', 'Beograd, Republika Srbija', 'kompanija koja se bavi proizvodnjom racunara i periferne opreme');
INSERT INTO "preduzece" ("id", "naziv", "pib", "sediste", "opis")
VALUES (nextval('preduzece_seq'), 'NIS A.D. NOVI SAD', '104052135', 'Novi Sad, Republika Srbija', 'kompanija koja se bavi eksploatacijom sirove nafte');

-- obrazovanje podaci
INSERT INTO "obrazovanje" ("id", "naziv", "stepen_strucne_spreme", "opis")
VALUES (nextval('obrazovanje_seq'), 'magistar farmacije', 'VII-2', 'Magistri farmacije mogu se zaposliti u apotekama, predstavnistvima farmaceutskih kompanija, istrazivackim centrima farmaceutskih kompanija, obrazovnim i naucno-istrazivackim institucijama.');
INSERT INTO "obrazovanje" ("id", "naziv", "stepen_strucne_spreme", "opis")
VALUES (nextval('obrazovanje_seq'), 'diplomirani inzenjer menadzmenta- menadzer ljudskih resursa', 'VII-1', 'Osnovna zaduzenja menadzera ljudskih resursa su: upravljanje ljudima koji individualno i timski doprinose ostvarenju profesionalnih ciljeva i pruzanje zaposlenima mogucnosti da dostignu svoj puni potencijal.');
INSERT INTO "obrazovanje" ("id", "naziv", "stepen_strucne_spreme", "opis")
VALUES (nextval('obrazovanje_seq'), 'diplomirani inzenjer menadzmenta- menadzer prodaje', 'VII-1', 'Menadzer prodaje uspesno vlada finansijama, marketingom i vodjenjem projekata. Njegov zadatak je i da razvija poslovni odnos sa kupcima, resava njihove zahteve i prati kretanja na domacem i inostranom trzistu.');
INSERT INTO "obrazovanje" ("id", "naziv", "stepen_strucne_spreme", "opis")
VALUES (nextval('obrazovanje_seq'), 'diplomirani inzenjer informacionih tehnologija', 'VII-1', 'Inzenjer informacionih tehnologija je osposobljen za poslove u svim oblastima primene informacionih i komunikacionih tehnologija, kako u privatnom tako i u javnom sektoru.');
INSERT INTO "obrazovanje" ("id", "naziv", "stepen_strucne_spreme", "opis")
VALUES (nextval('obrazovanje_seq'), 'naftno-petrohemijski inzenjer', 'VII-1', 'Naftno-petrohemijski inzenjer je osposobljen da vodi, unapredjuje i optimizuje postojece hemijsko-tehnoloske procese u skladu sa savremenim standardima kvaliteta, zastite okoline i odrzivog razvoja. ');
INSERT INTO "obrazovanje" ("id", "naziv", "stepen_strucne_spreme", "opis")
VALUES (nextval('obrazovanje_seq'), 'diplomirani inzenjer menadzmenta- marketing menadzer', 'VII-1', 'Marketing menadzer planira, usmerava i koordinira marketing (cenu, distibuciju i promociju) proizvoda ili usluge.');
INSERT INTO "obrazovanje" ("id", "naziv", "stepen_strucne_spreme", "opis")
VALUES (nextval('obrazovanje_seq'), 'diplomirani ekonomista', 'VII-1', 'Ekonomisti proucavaju troskove i ucinke proizvodnje, raspodelu i potrosnju proizvedenih roba i usluga.');

-- sektor podaci
INSERT INTO "sektor" ("id", "naziv", "oznaka", "preduzece")
VALUES (nextval('sektor_seq'), 'prodaja', 'SPR11', '1');
INSERT INTO "sektor" ("id", "naziv", "oznaka", "preduzece")
VALUES (nextval('sektor_seq'), 'marketing', 'SMAR13', '2');
INSERT INTO "sektor" ("id", "naziv", "oznaka", "preduzece")
VALUES (nextval('sektor_seq'), 'razvoj', 'SRAZ14', '3');
INSERT INTO "sektor" ("id", "naziv", "oznaka", "preduzece")
VALUES (nextval('sektor_seq'), 'finansije', 'SFIN16', '4');
INSERT INTO "sektor" ("id", "naziv", "oznaka", "preduzece")
VALUES (nextval('sektor_seq'), 'kvalitet', 'SKV18', '5');


--radnik podaci 
INSERT INTO "radnik" ("id", "ime", "prezime", "broj_lk", "obrazovanje", "sektor")
VALUES (nextval('radnik_seq'), 'Lenka', 'Subotin', '123456789', '1', '1');
INSERT INTO "radnik" ("id", "ime", "prezime", "broj_lk", "obrazovanje", "sektor")
VALUES (nextval('radnik_seq'), 'Dajana', 'Jelic', '123123456', '3', '2');
INSERT INTO "radnik" ("id", "ime", "prezime", "broj_lk", "obrazovanje", "sektor")
VALUES (nextval('radnik_seq'), 'Ivana', 'Bugadzija', '456789789', '1', '3');
INSERT INTO "radnik" ("id", "ime", "prezime", "broj_lk", "obrazovanje", "sektor")
VALUES (nextval('radnik_seq'), 'Nikola', 'Jovanovic', '345678910', '6', '4');
INSERT INTO "radnik" ("id", "ime", "prezime", "broj_lk", "obrazovanje", "sektor")
VALUES (nextval('radnik_seq'), 'Luka', 'Ivanovic', '310245678', '4', '5');
INSERT INTO "radnik" ("id", "ime", "prezime", "broj_lk", "obrazovanje", "sektor")
VALUES (nextval('radnik_seq'), 'Iva', 'Pantic', '145678932', '4', '1');
INSERT INTO "radnik" ("id", "ime", "prezime", "broj_lk", "obrazovanje", "sektor")
VALUES (nextval('radnik_seq'), 'Sara', 'Poparic', '214536987', '2', '2');
INSERT INTO "radnik" ("id", "ime", "prezime", "broj_lk", "obrazovanje", "sektor")
VALUES (nextval('radnik_seq'), 'Lea', 'Banjac', '789324510', '5', '3');
INSERT INTO "radnik" ("id", "ime", "prezime", "broj_lk", "obrazovanje", "sektor")
VALUES (nextval('radnik_seq'), 'Lazar', 'Peric', '275631098', '7', '4');
INSERT INTO "radnik" ("id", "ime", "prezime", "broj_lk", "obrazovanje", "sektor")
VALUES (nextval('radnik_seq'), 'Una', 'Ilic', '876432501', '5', '5');

-- test podaci
INSERT INTO "preduzece" ("id", "naziv", "pib", "sediste", "opis")
VALUES ('-100', 'Test preduzece', '109784532', 'Test sediste', 'Test opis');
INSERT INTO "obrazovanje" ("id", "naziv", "stepen_strucne_spreme", "opis")
VALUES ('-100', 'Test obrazovanje', 'VII-2', 'Test opis');
INSERT INTO "sektor" ("id", "naziv", "oznaka", "preduzece")
VALUES ('-100', 'Test naziv', 'TESTOZN', '1');
INSERT INTO "radnik" ("id", "ime", "prezime", "broj_lk", "obrazovanje", "sektor")
VALUES ('-100', 'Test ime', 'Test prezime', '965734120', '1', '1');
