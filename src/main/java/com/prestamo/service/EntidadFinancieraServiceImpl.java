package com.prestamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.EntidadFinanciera;
import com.prestamo.repository.EntidadFinancieraRepository;

@Service
public class EntidadFinancieraServiceImpl implements EntidadFinancieraService {

    @Autowired
    private EntidadFinancieraRepository repo;

    @Override
    public EntidadFinanciera save(EntidadFinanciera obj) {
        return repo.save(obj);
    }

    @Override
    public List<EntidadFinanciera> findEntidadFinancieraByNombreIgual(String nombre){
        return repo.findEntidadFinancieraByNombreIgual(nombre);
    }

    @Override
    public List<EntidadFinanciera> findAll(){
        return repo.findAll();
    }

    @Override
    public List<EntidadFinanciera> listarPorTipo(Integer idTipoEntidad) {
        return repo.findByTipoEntidadIdDataCatalogo(idTipoEntidad);
    }

    @Override
    public List<EntidadFinanciera> listar() {
        return repo.findAll();
    }

}
