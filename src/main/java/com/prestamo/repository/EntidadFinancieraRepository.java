package com.prestamo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prestamo.entity.EntidadFinanciera;

public interface EntidadFinancieraRepository extends JpaRepository<EntidadFinanciera, Integer> {

    @Query("Select e from EntidadFinanciera e where e.nombre = ?1")
    public List<EntidadFinanciera> findEntidadFinancieraByNombreIgual(String nombre);

    public List<EntidadFinanciera> findByTipoEntidadIdDataCatalogo(Integer idDataCatalogo);

}
