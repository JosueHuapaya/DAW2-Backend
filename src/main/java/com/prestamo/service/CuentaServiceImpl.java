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
    public List<Cuenta> listCuenta() {
        return cuentarepository.findAll();
    }

    @Override
    public List<Cuenta> listCuentaCompleja(String numero, int entidad, int moneda, int tipoentidad,int estado) {
        return cuentarepository.listCuentaCompleja(numero, entidad, moneda, tipoentidad, estado);
    }

    @Override
    public List<Cuenta> listByLike(String numero) {
        return cuentarepository.listByNumeroLike(numero);
    }

    @Override
    public void deleteCuenta(int id) {
        cuentarepository.deleteById(id);
    }

    @Override
    public List<Cuenta> listaCuentaPorNumeroIgual(String numero) {
        return cuentarepository.listaCuentaPorNumeroIgual(numero);
    }

    @Override
    public List<Cuenta> listCuentaByNumeroIgualActualiza(String numero, int idCuenta) {
        return cuentarepository.listCuentaByNroActualiza(numero, idCuenta);
    }
}
