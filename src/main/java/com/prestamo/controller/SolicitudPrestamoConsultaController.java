package com.prestamo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.SolicitudPrestamo;
import com.prestamo.service.SolicitudPrestamoService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/consultaSolicitud")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class SolicitudPrestamoConsultaController {
	
	@Autowired
	SolicitudPrestamoService service;
	
	@GetMapping("/listaSolicitudCompleja")
    public List<SolicitudPrestamo> listaSolicitudCompleja(
            @RequestParam(value = "capital", required = false) Double capital, 
            @RequestParam(value = "dias", required = false) Integer dias, 
            @RequestParam(value = "montoPagar", required = false) Double montoPagar,
            @RequestParam(value = "fechaInicio", required = false) String fechaInicio,
            @RequestParam(value = "fechaFin", required = false) String fechaFin,
            @RequestParam(value = "estadoSolicitud", required = false) Integer estadoSolicitud,
            @RequestParam(value = "prestatario", required = false) Integer prestatario) {

        List<SolicitudPrestamo> lstSalida = service.consultaCompleja(
                capital, dias, montoPagar, fechaInicio, fechaFin, estadoSolicitud, prestatario);

        return lstSalida;
    }

}
