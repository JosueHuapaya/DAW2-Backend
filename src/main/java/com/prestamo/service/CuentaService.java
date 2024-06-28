package com.prestamo.service;

import com.prestamo.entity.Cuenta;

import java.util.List;

public interface CuentaService {

    // Validaciones
    public abstract List<Cuenta> listaCuentaPorNumeroIgual(String numero);
    public abstract List<Cuenta> listCuentaByNumeroIgualActualiza(String numero, int id);

    // CRUD
    public abstract Cuenta insertaActualizaCuenta(Cuenta obj); // Reutilizando de la PC1
    public abstract List<Cuenta> listByLike(String numero);
    public abstract void deleteCuenta(int id);
    public abstract List<Cuenta> listCuenta();

    // Consulta
    public abstract List<Cuenta> listCuentaCompleja(String numero, int entidad, int moneda, int tipoentidad, int estado);
}
