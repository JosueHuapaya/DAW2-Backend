package com.prestamo.controller;

import com.prestamo.entity.Coordenada;
import com.prestamo.entity.Ubigeo;
import com.prestamo.entity.Usuario;
import com.prestamo.repository.UbigeoRepository;
import com.prestamo.service.CoordenadaService;
import com.prestamo.service.UbigeoService;
import com.prestamo.util.AppSettings;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/url/coordenadas")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)

public class CoordenadaController {

    @Autowired
    private CoordenadaService coordenadaService;

    @Autowired

    private UbigeoRepository ubigeoRepository;

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Coordenada coordenada) {
        HashMap<String, Object> salida = new HashMap<>();
        if (coordenada.getUbigeo() != null && coordenada.getUbigeo().getIdUbigeo() > 0) {
            Ubigeo ubigeo = ubigeoRepository.findById(coordenada.getUbigeo().getIdUbigeo())
                    .orElseThrow(() -> new RuntimeException("Ubigeo no encontrado"));
            coordenada.setUbigeo(ubigeo);
        }

        coordenada.setFechaActualizacion(new Date());
        coordenada.setFechaRegistro(new Date());
        Coordenada registrada = coordenadaService.agregarCoordenadas(coordenada);

        if (registrada == null) {
            salida.put("mensaje", "Error en el registro");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(salida);
        } else {
            salida.put("mensaje", "Registro de coordenada con el ID >>> " + registrada.getIdCoordenada() +
                    " >>> ID Ubigeo >> "+ registrada.getUbigeo().getIdUbigeo());
            return ResponseEntity.ok(salida);
        }
    }

    @GetMapping("/prestatarios")
    public ResponseEntity<List<Usuario>> listaPrestamistariosTotales (Usuario usuario) {

        List<Usuario> listUsuario = coordenadaService.listaPrestamistariosTotales(usuario);

        return new ResponseEntity<>(listUsuario, HttpStatus.OK);

    }

}
