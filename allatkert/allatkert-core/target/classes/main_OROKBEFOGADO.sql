create table OROKBEFOGADO
(
    id    INTEGER not null
        constraint OROKBEFOGADO_pk
            primary key autoincrement,
    nev   text    not null,
    email text    not null
);

INSERT INTO OROKBEFOGADO (id, nev, email) VALUES (1, 'Teszt Elek', 'teszt@elek.com');
INSERT INTO OROKBEFOGADO (id, nev, email) VALUES (29, 'Nagy Dániel', 'nagydaniel@gmail.com');
INSERT INTO OROKBEFOGADO (id, nev, email) VALUES (30, 'Lukács Tímea', 'timi25@gmail.com');
INSERT INTO OROKBEFOGADO (id, nev, email) VALUES (31, 'Herczeg András', 'bandi123@gmail.com');
INSERT INTO OROKBEFOGADO (id, nev, email) VALUES (32, 'Gulyás Tamara', 'gulyasne@gmail.com');
INSERT INTO OROKBEFOGADO (id, nev, email) VALUES (33, 'Tóth Anna', 'tanna6@citromail.hu');
INSERT INTO OROKBEFOGADO (id, nev, email) VALUES (34, 'Kis-Szalai Gábor', 'kisszalai@webout.hu');
INSERT INTO OROKBEFOGADO (id, nev, email) VALUES (35, 'Szórád Réka', 'h985570@stud.u-szeged.hu');
INSERT INTO OROKBEFOGADO (id, nev, email) VALUES (36, 'Nádai Előd', 'nadai@nadai.com');
INSERT INTO OROKBEFOGADO (id, nev, email) VALUES (37, 'Szabó Nóra', 'norci@gmail.com');