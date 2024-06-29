package com.prestamo.controller;

import com.prestamo.entity.Cuenta;
import com.prestamo.service.CuentaService;
import com.prestamo.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/url/consulta/cuenta")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class ConsultaCuentaController {

    @Autowired
    private CuentaService _cuentaService;

    @GetMapping("/lista")
    public List<Cuenta> lstConsultaCuenta(
            @RequestParam String numero,
            @RequestParam int entidad,
            @RequestParam int moneda,
            @RequestParam int tipoentidad,
            @RequestParam int estado)
    {
        List<Cuenta> lst = _cuentaService.listCuentaCompleja(numero + "%", entidad, moneda, tipoentidad, estado);
        return lst;
    }
}
