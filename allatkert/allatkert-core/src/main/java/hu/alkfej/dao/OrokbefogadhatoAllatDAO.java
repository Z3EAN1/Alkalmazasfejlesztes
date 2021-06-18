package hu.alkfej.dao;

import hu.alkfej.model.OrokbefogadhatoAllat;
import hu.alkfej.model.Orokbefogado;


import java.util.List;

public interface OrokbefogadhatoAllatDAO {

    List<OrokbefogadhatoAllat> findAll();

    OrokbefogadhatoAllat save(OrokbefogadhatoAllat orokbefogadhatoAllat);

    OrokbefogadhatoAllat findAllById(int Id);

    void delete(OrokbefogadhatoAllat orokbefogadhatoAllat);
}
