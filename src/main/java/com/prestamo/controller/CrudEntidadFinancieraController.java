package com.prestamo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.prestamo.entity.Ejemplo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import com.prestamo.entity.EntidadFinanciera;
import com.prestamo.service.EntidadFinancieraService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/CrudEntidadFinanciera")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class CrudEntidadFinancieraController {

    @Autowired
    private EntidadFinancieraService serv;

    @GetMapping("/listEntidadFinancieraLike/{var}")
    @ResponseBody
    public ResponseEntity<?> listEntidadFinancieraLike(@PathVariable("var") int entidad){
      List<EntidadFinanciera> lstSalida = null;
       if(entidad == 0) {
           lstSalida = serv.listar();
       }else {
           lstSalida = serv.listEntidadFinancieraLike(entidad);
       }
       return ResponseEntity.ok(lstSalida);
   }

    @PostMapping("/registrarEntidadFinanciera")
    @ResponseBody
    public ResponseEntity<?> insertEntidadFinanciera(@RequestBody EntidadFinanciera bean){
        Map<String, Object> salida = new HashMap<>();
        try {
            bean.setFechaRegistro(new Date());
            bean.setFechaActualizacion(new Date());
            bean.setEstado(AppSettings.ACTIVO);
            EntidadFinanciera ef = serv.save(bean);
            if(ef ==null) {
                salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
            }else {
                salida.put("mensaje", AppSettings.MENSAJE_REG_EXITOSO + " Entidad Financiera de Codigo id: " + bean.getIdEntidadFinanciera() + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
        }
        return ResponseEntity.ok(salida);
    }

    @DeleteMapping("/deleteEntidadFinanciera/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteEntidadFinanciera(@PathVariable("id") int idEntidadFinanciera){
        Map<String, Object> salida = new HashMap<>();
        try {
            serv.deleteEntidadFin(idEntidadFinanciera);
            salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO + " Entidad Financiera de ID ==> " + idEntidadFinanciera + ".");
        } catch (Exception e) {
            salida.put("salida", AppSettings.MENSAJE_ELI_ERROR);
        }
        return ResponseEntity.ok(salida);
    }

    @PutMapping("/updateEntidadFinanciera")
    @ResponseBody
    public ResponseEntity<?> updateEntidadFinanciera(@RequestBody EntidadFinanciera bean){
        Map<String, Object> salida = new HashMap<>();
        try {
            bean.setFechaActualizacion(new Date());
            EntidadFinanciera ef = serv.save(bean);
            if(ef ==null) {
                salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
            }else {
                salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO + " Entidad Financiera de ID ==> " + bean.getIdEntidadFinanciera() + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
        }
        return ResponseEntity.ok(salida);
    }

    @GetMapping("/validarNombreActualizar")
    public String validaNomActualizar(@RequestParam(name="nombre") String nombre,
                                        @RequestParam(name="idEntidadFinanciera") int idEntidadFinanciera) {
        List<EntidadFinanciera> salida = serv.listEntidadFinancieraAc(nombre, idEntidadFinanciera);
        if(salida.isEmpty()) {
            return "{\"valid\":true}";
        }else {
            return "{\"valid\":false}";
        }
    }
}
