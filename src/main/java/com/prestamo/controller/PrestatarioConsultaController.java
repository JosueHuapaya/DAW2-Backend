package com.prestamo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.Usuario;
import com.prestamo.service.PrestatarioService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/consultaPrestatario")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class PrestatarioConsultaController {
	
	@Autowired
	private PrestatarioService prestatarioService;
	
	@GetMapping("/consultaPrestatarioCompleja")
	public List<Usuario> consulta(  @RequestParam("nombres") String nombres, @RequestParam("apellidos") String apellidos, @RequestParam("dni") String dni, @RequestParam("direccion") String direccion) {

		List<Usuario> lstSalida = prestatarioService.consultaPrestatarioCompleja(nombres, apellidos, dni, direccion);
		return lstSalida;

	}
}