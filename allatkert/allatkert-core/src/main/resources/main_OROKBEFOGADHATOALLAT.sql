create table OROKBEFOGADHATOALLAT
(
    id        INTEGER not null
        constraint OROKBEFOGADHATOALLAT_pk
            primary key autoincrement,
    nev       text,
    faj       text    not null,
    fenykep   text,
    szoveg    text    not null,
    szuldatum text    not null
);

INSERT INTO OROKBEFOGADHATOALLAT (id, nev, faj, fenykep, szoveg, szuldatum) VALUES (3, 'Pata', 'Ló', null, ' Hello Pata vagyok!', '2003-12-12');
INSERT INTO OROKBEFOGADHATOALLAT (id, nev, faj, fenykep, szoveg, szuldatum) VALUES (12, 'Zsizsi', 'Zsiráf', 'zsiraf.png', 'Sziasztok, Zsizsi vagyok. Szeretem az embereket.', '2015-06-08');
INSERT INTO OROKBEFOGADHATOALLAT (id, nev, faj, fenykep, szoveg, szuldatum) VALUES (13, 'Marty', 'Zebra', 'zebra.jpg', 'Marty vagyok, de nem a Madagaszkárból!', '2019-05-03');
INSERT INTO OROKBEFOGADHATOALLAT (id, nev, faj, fenykep, szoveg, szuldatum) VALUES (14, 'Alex', 'Oroszlán', null, 'A vadasparkba csak miattam jönnek', '2006-09-11');
INSERT INTO OROKBEFOGADHATOALLAT (id, nev, faj, fenykep, szoveg, szuldatum) VALUES (15, 'Gloria', 'Viziló', null, 'Sziasztok, Gloria vagyok.', '2011-01-01');
INSERT INTO OROKBEFOGADHATOALLAT (id, nev, faj, fenykep, szoveg, szuldatum) VALUES (16, 'Po', 'Panda', 'panda.jpg', 'Sziasztok Po vagyok.', '2016-04-04');
INSERT INTO OROKBEFOGADHATOALLAT (id, nev, faj, fenykep, szoveg, szuldatum) VALUES (17, 'Dumbo', 'Elefánt', '', 'Sziasztok Dumbo vagyok és félek az egerektől.', '1999-04-19');
INSERT INTO OROKBEFOGADHATOALLAT (id, nev, faj, fenykep, szoveg, szuldatum) VALUES (18, 'Alvin', 'Mókus', 'mokus.jpg', 'Alvin vagyok és nem tudok énekelni, de aranyos vagyok!', '2005-09-03');
INSERT INTO OROKBEFOGADHATOALLAT (id, nev, faj, fenykep, szoveg, szuldatum) VALUES (19, 'Franklin ', 'Teknős', null, 'Franklin vagyok picit lassú', '1995-03-27');
INSERT INTO OROKBEFOGADHATOALLAT (id, nev, faj, fenykep, szoveg, szuldatum) VALUES (20, 'Oli', 'Alpaka', null, 'Szerintem én vagyok a legaranyosabb a vadasparkban.', '2009-04-07');
INSERT INTO OROKBEFOGADHATOALLAT (id, nev, faj, fenykep, szoveg, szuldatum) VALUES (21, 'Lara', 'Csimpánz', 'csimpanz.png', 'Sziasztok! Szeretek játszani.', '2001-03-07');
INSERT INTO OROKBEFOGADHATOALLAT (id, nev, faj, fenykep, szoveg, szuldatum) VALUES (22, 'Zsebi', 'Kenguru', null, 'Hasonlítok Zsebibabára a micimackóból.', '2014-07-03');
INSERT INTO OROKBEFOGADHATOALLAT (id, nev, faj, fenykep, szoveg, szuldatum) VALUES (23, 'Tifo', 'Medve', 'medve.png', 'Erdélyből jöttem, nem bántok senkit.', '1999-12-12');
INSERT INTO OROKBEFOGADHATOALLAT (id, nev, faj, fenykep, szoveg, szuldatum) VALUES (24, 'Lilo', 'Jaguár', null, 'Nem, nem autó vagyok, hanem egy állat.', '2003-09-01');