create table KONYVELES
(
    id                       INTEGER not null
        constraint KONYVELES_pk
            primary key autoincrement,
    mikor                    text    not null,
    nev                      text,
    tamogat                  text,
    ertek                    double,
    gyakorisag               text,
    orokbefogado_id          int
        references OROKBEFOGADO,
    orokbefogadhato_allat_id int
        references OROKBEFOGADHATOALLAT
);

INSERT INTO KONYVELES (id, mikor, nev, tamogat, ertek, gyakorisag, orokbefogado_id, orokbefogadhato_allat_id) VALUES (10, '2020-09-16', null, 'ALLATELEDEL', 25, 'EGYSZERI', 1, 15);
INSERT INTO KONYVELES (id, mikor, nev, tamogat, ertek, gyakorisag, orokbefogado_id, orokbefogadhato_allat_id) VALUES (11, '2021-06-03', null, 'PENZOSSZEG', 15000, 'TOBBSZOROS', 32, 13);
INSERT INTO KONYVELES (id, mikor, nev, tamogat, ertek, gyakorisag, orokbefogado_id, orokbefogadhato_allat_id) VALUES (12, '2020-11-06', null, 'PENZOSSZEG', 60000, 'TOBBSZOROS', 30, 3);
INSERT INTO KONYVELES (id, mikor, nev, tamogat, ertek, gyakorisag, orokbefogado_id, orokbefogadhato_allat_id) VALUES (13, '2021-01-07', null, 'ALLATELEDEL', 30, 'EGYSZERI', 35, 17);
INSERT INTO KONYVELES (id, mikor, nev, tamogat, ertek, gyakorisag, orokbefogado_id, orokbefogadhato_allat_id) VALUES (14, '2021-04-03', null, 'ALLATELEDEL', 5, 'TOBBSZOROS', 29, 20);
INSERT INTO KONYVELES (id, mikor, nev, tamogat, ertek, gyakorisag, orokbefogado_id, orokbefogadhato_allat_id) VALUES (15, '2020-07-07', null, 'PENZOSSZEG', 10000, 'TOBBSZOROS', 33, 14);
INSERT INTO KONYVELES (id, mikor, nev, tamogat, ertek, gyakorisag, orokbefogado_id, orokbefogadhato_allat_id) VALUES (16, '2020-12-30', null, 'ALLATELEDEL', 6, 'TOBBSZOROS', 31, 18);
INSERT INTO KONYVELES (id, mikor, nev, tamogat, ertek, gyakorisag, orokbefogado_id, orokbefogadhato_allat_id) VALUES (17, '2020-02-27', null, 'PENZOSSZEG', 150000, 'TOBBSZOROS', 36, 16);
INSERT INTO KONYVELES (id, mikor, nev, tamogat, ertek, gyakorisag, orokbefogado_id, orokbefogadhato_allat_id) VALUES (18, '2021-01-08', null, 'PENZOSSZEG', 15000, 'TOBBSZOROS', 34, 19);
INSERT INTO KONYVELES (id, mikor, nev, tamogat, ertek, gyakorisag, orokbefogado_id, orokbefogadhato_allat_id) VALUES (19, '2021-03-19', null, 'ALLATELEDEL', 9.5, 'EGYSZERI', 37, 12);