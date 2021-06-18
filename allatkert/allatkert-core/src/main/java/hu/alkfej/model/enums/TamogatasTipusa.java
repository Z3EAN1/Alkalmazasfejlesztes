package hu.alkfej.model.enums;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public enum TamogatasTipusa {

    PENZOSSZEG("Pénzösszeg"),
    ALLATELEDEL("Állateledel");

    private final StringProperty value = new SimpleStringProperty(this, "value");

    public String getValue() {
        return value.get();
    }

    public StringProperty valueProperty() {
        return value;
    }

    TamogatasTipusa(String value) {
        this.value.set(value);
    }

    @Override
    public String toString() {
        return getValue();
    }
}
