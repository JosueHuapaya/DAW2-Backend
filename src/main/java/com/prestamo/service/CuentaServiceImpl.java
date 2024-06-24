package com.prestamo.service;

import com.prestamo.entity.Cuenta;
import com.prestamo.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService{

    @Autowired
    private CuentaRepository cuentarepository;

    @Override
    public Cuenta insertaActualizaCuenta(Cuenta cuenta) {
        return cuentarepository.save(cuenta);
    }

    @Override
    public Cuenta validarNumeroExiste(String numero) {
        return cuentarepository.findByNumero(numero);
    }

    @Override
    public List<Cuenta> listaCuenta() {
        return cuentarepository.findAll();
    }

    @Override
    public List<Cuenta> listaCuentaPorNumeroIgual(String numero) {
        return cuentarepository.listaCuentaPorNumeroIgual(numero);
    }
}
