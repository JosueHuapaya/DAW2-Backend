package com.prestamo.service;

import com.prestamo.entity.Cuenta;

import java.util.List;

public interface CuentaService {

    public abstract Cuenta insertaActualizaCuenta(Cuenta obj);
    public abstract Cuenta validarNumeroExiste(String numero);
    public abstract List<Cuenta> listaCuenta();
    public abstract List<Cuenta> listaCuentaPorNumeroIgual(String numero);
}
