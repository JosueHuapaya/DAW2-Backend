package com.prestamo.controller;

import com.prestamo.entity.Cuenta;
import com.prestamo.entity.EntidadFinanciera;
import com.prestamo.service.CuentaService;
import com.prestamo.service.EntidadFinancieraService;
import com.prestamo.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/url/cuenta")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class RegistroCuentaController {

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private EntidadFinancieraService entidadService;

    @GetMapping
    public ResponseEntity<List<Cuenta>> lista(){
        List<Cuenta> lstSalida = cuentaService.listaCuenta();
        return ResponseEntity.ok(lstSalida);
    }

    @PostMapping
    public ResponseEntity<?> registra(@RequestBody Cuenta objCuenta){
        HashMap<String, Object> salida = new HashMap<>();
        objCuenta.setFechaRegistro(new Date());
        objCuenta.setFechaActualizacion(new Date());
        objCuenta.setEstado(AppSettings.ACTIVO);

        Cuenta objSalida = cuentaService.insertaActualizaCuenta(objCuenta);
        if (objSalida == null) {
            salida.put("mensaje", "Error en el registro");
        }else {
            salida.put("mensaje", "Registro de cuenta con el ID >>> " + objCuenta.getIdCuenta() +
                    " >>> DES >> "+ objCuenta.getNumero());
        }
        return ResponseEntity.ok(salida);
    }

    @GetMapping("/validaNumeroRegistra")
    public String validaNumero(@RequestParam(name = "numero")String numero) {
        List<Cuenta> lstSalida = cuentaService.listaCuentaPorNumeroIgual(numero);
        if (lstSalida.isEmpty()) {
            return "{\"valid\":true}";
        }else {
            return "{\"valid\":false}";
        }
    }

    @GetMapping("/listarEF")
    public ResponseEntity<List<EntidadFinanciera>> listarPorTipo(@RequestParam(name="idDataCatalogo",required = false) Integer idDataCatalogo){

        List<EntidadFinanciera> lstSalida = new ArrayList<>();

        try {
            if (idDataCatalogo != null) {
                lstSalida = entidadService.listarPorTipo(idDataCatalogo);
            }else {
                lstSalida = entidadService.listar();
            }

        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.ok(lstSalida);
    }

}