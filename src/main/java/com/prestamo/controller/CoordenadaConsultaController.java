package com.prestamo.controller;

import com.prestamo.entity.Coordenada;

import com.prestamo.service.CoordenadaService;
import com.prestamo.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/url/consultaCoordenada")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)

public class CoordenadaConsultaController {

    @Autowired

    private CoordenadaService coordenadaService;

    @GetMapping("/consultaComplejaCoordenada/{latitud}/{longitud}/{departamento}")

    public List<Coordenada> consultaCompleja(@PathVariable BigDecimal latitud, @PathVariable BigDecimal longitud, @PathVariable String departamento) {

        return coordenadaService.consultaComplejaCoordenada(latitud, longitud, departamento);

    }

}
