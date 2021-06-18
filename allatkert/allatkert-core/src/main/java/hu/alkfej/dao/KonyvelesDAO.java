package hu.alkfej.dao;

import hu.alkfej.model.Konyveles;

import java.util.List;

public interface KonyvelesDAO {

    List<Konyveles> findAll();

    Konyveles save(Konyveles konyveles);

    void delete(Konyveles konyveles);

    List<Konyveles> lastYear();

    List<Konyveles> penzTamogatok();

    List<Konyveles> eledelTamogatok();
}
