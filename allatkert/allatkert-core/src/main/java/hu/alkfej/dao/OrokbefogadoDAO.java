package hu.alkfej.dao;

import hu.alkfej.model.Orokbefogado;

import java.util.List;

public interface OrokbefogadoDAO {

    List<Orokbefogado> findAll();

    Orokbefogado findAllById(int Id);

    Orokbefogado save(Orokbefogado orokbefogado);

    void delete(Orokbefogado orokbefogado);



}
