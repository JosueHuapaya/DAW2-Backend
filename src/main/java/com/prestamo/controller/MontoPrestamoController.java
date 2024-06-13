package com.prestamo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.MontoPrestamo;
import com.prestamo.service.MontoPrestamoService;
import com.prestamo.util.AppSettings;


@RestController
@RequestMapping("/url/monto")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class MontoPrestamoController {
	
	@Autowired
	private MontoPrestamoService service;
	
	@GetMapping
	public ResponseEntity<List<MontoPrestamo>> lista(){
		List<MontoPrestamo> lstMonto= service.ListarMontoPrestamo();
		return ResponseEntity.ok(lstMonto);
	}

	@PostMapping
    public ResponseEntity<?> registra(@RequestBody MontoPrestamo obj) {
        HashMap<String, Object> salida = new HashMap<>();
        
       
        obj.setFechaRegistro(new Date());
        obj.setFechaActualizacion(new Date());
        obj.setEstado(AppSettings.ACTIVO);
        
        MontoPrestamo objSalida = service.Registramontoprestamo(obj);
        if (objSalida == null) {
            salida.put("mensaje", "Error en el registro");                
        } else {
            salida.put("mensaje", "Registro de monto prestamo con el ID >>> " + obj.getIdMontoPrestamo());
            return ResponseEntity.ok(salida);
        }
        return ResponseEntity.ok(salida);
   
 }

}
