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
    public List<EntidadFinanciera> listEntidadFinancieraAc(String nombre, int idEntidadFinanciera) {
        return repo.findByEntidadActualiza(nombre, idEntidadFinanciera);
    }

    @Override
    public void deleteEntidadFin(int idEntidadFinanciera) {
        repo.deleteById(idEntidadFinanciera);
    }

    @Override
    public List<EntidadFinanciera> listEntidadFinancieraLike(int entidad) {
        return repo.findByEntidad(String.valueOf(entidad));
    }

    @Override
    public List<EntidadFinanciera> consultarEntidadFinancieraCompleja(String nombre, String gerente, int idTipoEntidadF, int estado) {
        if (nombre.equals("%") && gerente.equals("%") && idTipoEntidadF == -1 && estado == -1) {
            return repo.findAll();
        } else {
            return repo.consultaEntidadCompleja(nombre, gerente, idTipoEntidadF, estado);
    }
    }
    @Override
    public List<EntidadFinanciera> listar() {
        return repo.findAll();
    }

}
