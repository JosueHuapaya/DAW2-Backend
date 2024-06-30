package com.prestamo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.MontoPrestamo;
import com.prestamo.service.MontoPrestamoService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/consultaMontoPrestamo")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class MontoPrestamoConsultaController {
	
	@Autowired
	private MontoPrestamoService serMonto;
	
	@GetMapping("/listaMontoPrestamosConsultaCompleja")
	public List<MontoPrestamo> listaMontoPrestamosConsultaCompleja(@RequestParam(name = "capital")int capital,
									@RequestParam(name = "dias")int dias,
									@RequestParam(name = "monto")BigDecimal monto,
									@RequestParam(name = "estado")int estado) {
		 List<MontoPrestamo> lstSalida = serMonto.listaMontoPrestamosConsultaCompleja(capital, dias, monto, estado); 
		 return lstSalida;
	}
}
