package com.prestamo.repository;

import com.prestamo.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
    @Query("select e from Cuenta e where e.numero = ?1")
    public abstract List<Cuenta> listaCuentaPorNumeroIgual(String numero);
    public abstract Cuenta findByNumero (String numero);
}
