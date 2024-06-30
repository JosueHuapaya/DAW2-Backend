package com.prestamo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.SolicitudPrestamo;
import com.prestamo.service.SolicitudPrestamoService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/crudSolicitud")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class SolicitudPrestamoCrudController {

	@Autowired
	private SolicitudPrestamoService service;
	
	@GetMapping("/listaSolicitudPorCapLike/{var}")
	@ResponseBody
	public ResponseEntity<?> listaSolicitudPrestamoPorCapitalMenorQueLike(@PathVariable("var") String capital){
		List<SolicitudPrestamo> lstSalida = null;
		if (capital.equals("todos")) {
			lstSalida =service.listaSolicitudPrestamo();
		}else {
			lstSalida =service.listaSolicitudPrestamoPorCapitalMenorQueLike(capital);
		}
		return ResponseEntity.ok(lstSalida);
	}
	
	@PutMapping("/actualizaSolicitud")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaSolicitud(@RequestBody SolicitudPrestamo obj) {
		Map<String, Object> salida = new HashMap<>();
		try {			
			obj.setFechaActualizacion(new Date());
			SolicitudPrestamo objSalida = service.insertaActualizaSolicitudPrestamo(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO + " Solicitud de Prestamo de ID ==> " + obj.getIdSolicitud() + ".");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/eliminaSolicitud/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaSolicitud(@PathVariable("id") int idSolicitud) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaSolicitudPrestamo(idSolicitud);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO + " Ejemplo de ID ==> " + idSolicitud + "." );
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
