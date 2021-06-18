package hu.alkfej.model;

import javafx.beans.property.*;

import java.time.LocalDate;

public class OrokbefogadhatoAllat {

    private IntegerProperty id = new SimpleIntegerProperty(this, "id");

    private StringProperty nev = new SimpleStringProperty(this, "nev");

    private StringProperty faj = new SimpleStringProperty(this, "faj");

    private StringProperty fenykep = new SimpleStringProperty(this, "fenykep");

    private StringProperty szoveg = new SimpleStringProperty(this, "szoveg");

    private ObjectProperty<LocalDate> szuldatum = new SimpleObjectProperty<>(this, "szuldatum");

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNev() {
        return nev.get();
    }

    public StringProperty nevProperty() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev.set(nev);
    }

    public String getFaj() {
        return faj.get();
    }

    public StringProperty fajProperty() {
        return faj;
    }

    public void setFaj(String faj) {
        this.faj.set(faj);
    }

    public String getFenykep() {
        return fenykep.get();
    }

    public StringProperty fenykepProperty() {
        return fenykep;
    }

    public void setFenykep(String fenykep) {
        this.fenykep.set(fenykep);
    }

    public String getSzoveg() {
        return szoveg.get();
    }

    public StringProperty szovegProperty() {
        return szoveg;
    }

    public void setSzoveg(String szoveg) {
        this.szoveg.set(szoveg);
    }

    public LocalDate getSzuldatum() {
        return szuldatum.get();
    }

    public ObjectProperty<LocalDate> szuldatumProperty() {
        return szuldatum;
    }

    public void setSzuldatum(LocalDate szuldatum) {
        this.szuldatum.set(szuldatum);
    }

    @Override
    public String toString() {
        return nev.getValue();
    }
}
