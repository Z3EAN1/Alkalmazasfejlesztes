-- No source text available
INSERT INTO sqlite_master (type, name, tbl_name, rootpage, sql) VALUES ('table', 'OROKBEFOGADO', 'OROKBEFOGADO', 3, 'CREATE TABLE "OROKBEFOGADO"
(
	id INTEGER not null
		constraint OROKBEFOGADO_pk
			primary key autoincrement,
	nev text not null,
	email text not null
)');
INSERT INTO sqlite_master (type, name, tbl_name, rootpage, sql) VALUES ('table', 'sqlite_sequence', 'sqlite_sequence', 4, 'CREATE TABLE sqlite_sequence(name,seq)');
INSERT INTO sqlite_master (type, name, tbl_name, rootpage, sql) VALUES ('table', 'OROKBEFOGADHATOALLAT', 'OROKBEFOGADHATOALLAT', 2, 'CREATE TABLE OROKBEFOGADHATOALLAT
(
	id INTEGER not null
		constraint OROKBEFOGADHATOALLAT_pk
			primary key autoincrement,
	nev text,
	faj text not null,
	fenykep text,
	szoveg text not null,
	szuldatum text not null
)');
INSERT INTO sqlite_master (type, name, tbl_name, rootpage, sql) VALUES ('table', 'KONYVELES', 'KONYVELES', 6, 'CREATE TABLE "KONYVELES"
(
	id INTEGER not null
		constraint KONYVELES_pk
			primary key autoincrement,
	mikor text not null,
	nev text,
	tamogat text,
	ertek double,
	gyakorisag text,
	orokbefogado_id int
		constraint KONYVELES_OROKBEFOGADO_id_fk
			references OROKBEFOGADO,
	orokbefogadhato_allat_id int
		constraint KONYVELES_OROKBEFOGADHATOALLAT_id_fk
			references OROKBEFOGADHATOALLAT
)');