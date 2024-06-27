package com.prestamo.controller;

import com.prestamo.entity.Cuenta;
import com.prestamo.service.CuentaService;
import com.prestamo.service.EjemploService;
import com.prestamo.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.*;

@RestController
@RequestMapping("/url/crud/cuenta")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class CuentaCrudController {

    // Test branch PC2-Aguayo
    @Autowired
    private CuentaService _cuentaService;

    @GetMapping("/list/{nro}")
    @ResponseBody
    public ResponseEntity<?> listByLike(@PathVariable String nro) {
        List<Cuenta> lst = null;
        if (nro.equals("lista")) {
            lst = _cuentaService.listCuenta();
        }
        else {
            lst = _cuentaService.listByLike(nro + "%");
        }
        return ResponseEntity.ok(lst);
    }


    @PostMapping("/insert")
    @ResponseBody
    public ResponseEntity<?> insertCuenta(@RequestBody Cuenta cuenta) {
        Map<String, Object> data = new HashMap<>();

        try {
            cuenta.setIdCuenta(0);
            cuenta.setFechaActualizacion(new Date());
            cuenta.setFechaRegistro(new Date());
            cuenta.setEstado(AppSettings.ACTIVO);

            Cuenta objCuenta = _cuentaService.insertaActualizaCuenta(cuenta);
            if (objCuenta == null) {
                data.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
            }
            else {
                data.put("mensaje", AppSettings.MENSAJE_REG_EXITOSO + "Cuenta ID >>>> " + objCuenta.getIdCuenta() + ".");
            }

        } catch (Exception e) {
            e.printStackTrace();
            data.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
        }
        return ResponseEntity.ok(data);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> updateCuenta(@RequestBody Cuenta cuenta) {
        Map<String, Object> data = new HashMap<>();
        try {
            cuenta.setFechaActualizacion(new Date());

            Cuenta objCuenta = _cuentaService.insertaActualizaCuenta(cuenta);

            if (objCuenta == null) {
                data.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
            }
            else {
                data.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO + "Cuenta ID >>>> " + objCuenta.getIdCuenta() + ".");
            }

        } catch (Exception e) {
            e.printStackTrace();
            data.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
        }
        return ResponseEntity.ok(data);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteCuenta(@PathVariable int id) {
        Map<String, Object> data = new HashMap<>();
        try {
            _cuentaService.deleteCuenta(id);
            data.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO + "Cuenta ID >>>> " + id + ".");
        } catch (Exception e) {
            e.printStackTrace();
            data.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
        }
        return ResponseEntity.ok(data);
    }

    @GetMapping("/validaNumeroActualiza/{numero}/{idCuenta}")
    public String validateNumero(@PathVariable String numero, @PathVariable int idCuenta) {
        List<Cuenta> lst = _cuentaService.listCuentaByNumeroIgualActualiza(numero, idCuenta);
        if (lst.isEmpty()) {
            return "{\"valid\":true}";
        }
        else {
            return "{\"valid\":false}";
        }

    }





}
