package com.prestamo.repository;

import com.prestamo.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    @Query("select e from Cuenta e where e.numero = ?1")
    public abstract List<Cuenta> listaCuentaPorNumeroIgual(String numero);


    @Query("select e from Cuenta e where e.numero like ?1%")
    public abstract  List<Cuenta> listByNumeroLike(String numero);

    @Query("select c from Cuenta c where c.numero = ?1 and c.idCuenta != ?2")
    public abstract List<Cuenta> listCuentaByNroActualiza(String numero, int idCuenta);

}
