package hu.alkfej.model;

import hu.alkfej.model.enums.TamogatasGyak;
import hu.alkfej.model.enums.TamogatasTipusa;
import javafx.beans.property.*;

import java.time.LocalDate;

public class Konyveles {

    private IntegerProperty id = new SimpleIntegerProperty(this, "id");

    private ObjectProperty<Orokbefogado> orokbefogado = new SimpleObjectProperty<>(this, "orokbefogado");

    private ObjectProperty<OrokbefogadhatoAllat> orokbefogadoallatok = new SimpleObjectProperty<>(this, "orokbefogadoallatok");

    private ObjectProperty<LocalDate> mikor = new SimpleObjectProperty<>(this, "mikor");

    private StringProperty nev = new SimpleStringProperty(this, "nev");

    private ObjectProperty<TamogatasTipusa> tamogat = new SimpleObjectProperty<>(this, "tamogat");

    private DoubleProperty ertek = new SimpleDoubleProperty(this, "ertek");

    private ObjectProperty<TamogatasGyak> gyakorisag = new SimpleObjectProperty<>(this, "gyakorisag");

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public Orokbefogado getOrokbefogado() {
        return orokbefogado.get();
    }

    public ObjectProperty<Orokbefogado> orokbefogadoProperty() {
        return orokbefogado;
    }

    public void setOrokbefogado(Orokbefogado orokbefogado) {
        this.orokbefogado.set(orokbefogado);
    }

    public OrokbefogadhatoAllat getOrokbefogadoallatok() {
        return orokbefogadoallatok.get();
    }

    public ObjectProperty<OrokbefogadhatoAllat> orokbefogadoallatokProperty() {
        return orokbefogadoallatok;
    }

    public void setOrokbefogadoallatok(OrokbefogadhatoAllat orokbefogadoallatok) {
        this.orokbefogadoallatok.set(orokbefogadoallatok);
    }

    public LocalDate getMikor() {
        return mikor.get();
    }

    public ObjectProperty<LocalDate> mikorProperty() {
        return mikor;
    }

    public void setMikor(LocalDate mikor) {
        this.mikor.set(mikor);
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

    public TamogatasTipusa getTamogat() {
        return tamogat.get();
    }

    public ObjectProperty<TamogatasTipusa> tamogatProperty() {
        return tamogat;
    }

    public void setTamogat(TamogatasTipusa tamogat) {
        this.tamogat.set(tamogat);
    }

    public double getErtek() {
        return ertek.get();
    }

    public DoubleProperty ertekProperty() {
        return ertek;
    }

    public void setErtek(double ertek) {
        this.ertek.set(ertek);
    }

    public TamogatasGyak getGyakorisag() {
        return gyakorisag.get();
    }

    public ObjectProperty<TamogatasGyak> gyakorisagProperty() {
        return gyakorisag;
    }

    public void setGyakorisag(TamogatasGyak gyakorisag) {
        this.gyakorisag.set(gyakorisag);
    }

}
