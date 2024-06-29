package com.prestamo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.DataCatalogo;
import com.prestamo.entity.SolicitudPrestamo;
import com.prestamo.entity.Usuario;
import com.prestamo.service.SolicitudPrestamoService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/solicitud")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class SolicitudPrestamoRegistraController {
	
	@Autowired
	private SolicitudPrestamoService service;

	@GetMapping
	public ResponseEntity<List<SolicitudPrestamo>> lista(){
		List<SolicitudPrestamo> lstSalida = service.listaSolicitudPrestamo();
		return ResponseEntity.ok(lstSalida);
	}
	
	@PostMapping
	public ResponseEntity<?> registra(@RequestBody SolicitudPrestamo obj){
		HashMap<String, Object> salida = new HashMap<>();
		
		//Datos que no completa el front
		
		DataCatalogo estadoSolicitud = new DataCatalogo();
	    estadoSolicitud.setIdDataCatalogo(12);
	    
		obj.setEstadoSolicitud(estadoSolicitud);
		obj.setEstado(AppSettings.ACTIVO);
		obj.setFechaRegistro(new Date());
		obj.setFechaActualizacion(new Date());

		SolicitudPrestamo objSalida = service.insertaActualizaSolicitudPrestamo(obj);
		if (objSalida == null) {
			salida.put("mensaje", "Error en el registro");
		}else {
			salida.put("mensaje", "Registro de solicitud de prestamo con el ID >>> " + obj.getIdSolicitud());
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/prestatarios")
    public ResponseEntity<List<Usuario>> listaPrestatariosTotales (Usuario usuario) {
        List<Usuario> listUsuario = service.listaPrestatariosTotales(usuario);
        return new ResponseEntity<>(listUsuario, HttpStatus.OK);
    }
}
