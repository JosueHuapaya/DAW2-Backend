package com.prestamo.repository;

import java.util.List;

import com.prestamo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prestamo.entity.EntidadFinanciera;

public interface EntidadFinancieraRepository extends JpaRepository<EntidadFinanciera, Integer> {

    @Query("Select e from EntidadFinanciera e where e.nombre = ?1")
    public List<EntidadFinanciera> findEntidadFinancieraByNombreIgual(String nombre);

    public List<EntidadFinanciera> findByTipoEntidadIdDataCatalogo(Integer idDataCatalogo);

    @Query("select e from EntidadFinanciera e where str(e.tipoEntidad.idDataCatalogo) like %?1%")
    public abstract List<EntidadFinanciera> findByEntidad(String entidad);

    @Query("select e from EntidadFinanciera e where e.nombre = ?1 and e.idEntidadFinanciera != ?2")
    public abstract List<EntidadFinanciera> findByEntidadActualiza(String nombre, int idEntidadFinanciera);

    @Query("select e from EntidadFinanciera e where " + "e.nombre like %:nombre% and " + " e.gerente like %:gerente% and " + " (:idTipoEntidad = -1 OR e.tipoEntidad.idDataCatalogo = :idTipoEntidad) and " + " e.estado = :estado")
    public abstract List<EntidadFinanciera> consultaEntidadCompleja(String nombre, String gerente, int idTipoEntidad, int estado);

}
