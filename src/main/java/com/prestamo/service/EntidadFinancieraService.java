package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.EntidadFinanciera;

public interface EntidadFinancieraService {

    public abstract EntidadFinanciera save(EntidadFinanciera ef);
    public abstract List<EntidadFinanciera> findEntidadFinancieraByNombreIgual(String nombre);
    public abstract List<EntidadFinanciera> findAll();

    //

    public List<EntidadFinanciera> listar();
    public List<EntidadFinanciera> listarPorTipo (Integer idTipoEntidad);

}